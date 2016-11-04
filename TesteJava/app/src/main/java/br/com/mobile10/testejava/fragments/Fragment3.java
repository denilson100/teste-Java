package br.com.mobile10.testejava.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.mobile10.testejava.R;


/**
 * Created by denilsonmonteiro on 01/11/16.
 */
public class Fragment3 extends Fragment implements View.OnClickListener {

    private TextView textoCode;

    public Fragment3(){

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragments3, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Referencia os ids correspondentes
        textoCode = (TextView) getActivity().findViewById(R.id.code);
        textoCode.setText("<code>");

        /**
         * Li e perguntei bastante sobre essa implementação, pois nunca utilizei.
         * Não cheguei a uma conclusão correta de como implementar.
         * Se eu fosse fazer com base no que li, tentaria ler o arquivo proposto com 10GB e gravar
         * direto no DB, separando as frases em cada indice. Depois tentar ordenar e apresentar as
         * 50 mil mais frequente.
         * Mas teria que testar se é possível executar, performace, etc... Não tenho certeza se funcionaria.
         * Até da entrega (hoje) não consegui realizar o desafio, mas vou continuar tentando a solução e conseguindo,
         * atualizo no github.
         */

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}
