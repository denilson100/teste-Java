package br.com.mobile10.testejava.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.mobile10.testejava.R;


/**
 * Created by denilsonmonteiro on 01/11/16.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    String palavraInvertida = "";
    String meuTexto = "1221";
    char arrayDeChar[] = meuTexto.toCharArray();

    public Fragment1(){

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragments1, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().findViewById(R.id.calcular).setOnClickListener(this);

        //for para pegar cada item do texto na ordem decrescente
        for (int i = arrayDeChar.length - 1; i >= 0; i--) {
            System.out.println("Data at ["+ i +"]=" + arrayDeChar[i]);
            //Variavel recebe cada letra do array de char
            palavraInvertida = palavraInvertida + arrayDeChar[i];
        }

        //Compara o texto original com a palavra montada de forma invertida.
        if(meuTexto.equals(palavraInvertida)) {
            System.out.println("É igual!!");
        } else {
            System.out.println("Não é igual!!");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calcular:

                break;
        }
    }
}
