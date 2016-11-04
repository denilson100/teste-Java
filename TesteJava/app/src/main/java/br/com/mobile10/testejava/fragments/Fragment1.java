package br.com.mobile10.testejava.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import br.com.mobile10.testejava.R;


/**
 * Created by denilsonmonteiro on 01/11/16.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private TextView textoPalindromo;       // Texto apresentado para o usuário
    private EditText editText;              // Pega texto digitado pelo usuário
    private LinearLayout linearLayout;      // Layout apresentado apenas quando o usuário faz a ação
    private Switch chaveCaseSencitive;      // Botão que aciona se é case sencitive ou não
    private boolean caseSensitive = false;  // Chave que representa o case sencitive

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

        // Referencia os ids correspondentes
        textoPalindromo = (TextView) getActivity().findViewById(R.id.texto);
        textoPalindromo.setText("");
        editText = (EditText) getActivity().findViewById(R.id.textoDigitado);
        linearLayout = (LinearLayout) getActivity().findViewById(R.id.fundo);
        chaveCaseSencitive = (Switch) getActivity().findViewById(R.id.switch1);

        chaveCaseSencitive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(caseSensitive == false) {
                    chaveCaseSencitive.setChecked(true);
                    caseSensitive = true;
                } else {
                    chaveCaseSencitive.setChecked(false);
                    caseSensitive = false;
                }

            }
        });

        getActivity().findViewById(R.id.btVerificaPalindromo).setOnClickListener(this);
        getActivity().findViewById(R.id.btExOvo).setOnClickListener(this);
        getActivity().findViewById(R.id.btEx1221).setOnClickListener(this);
        getActivity().findViewById(R.id.btExJose).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String palavraDigitada = editText.getText().toString();

        switch (v.getId()) {

            // Nesse id vericica se a chave case sencitive esta acionada. Se sim, executa a comparação com case sensitive
            case R.id.btVerificaPalindromo:
                if(caseSensitive == true) {
                    if (inverterPalavra(palavraDigitada).equals(palavraDigitada)) {
                        ePalindromo();
                    } else {
                        naoEPalindromo();
                    }
                } else {
                    if (inverterPalavra(palavraDigitada).equalsIgnoreCase(palavraDigitada)) {
                        ePalindromo();
                    } else {
                        naoEPalindromo();
                    }
                }
                break;

            // Alguns exemplos prontos. Apenas reproduz o texto.
            case R.id.btExOvo:
                if(inverterPalavra("OVO").equals("OVO")) {
                    ePalindromo();
                } else {
                    naoEPalindromo();
                }
                break;
            case R.id.btEx1221:
                if(inverterPalavra("1221").equals("1221")) {
                    ePalindromo();
                } else {
                    naoEPalindromo();
                }
                break;
            case R.id.btExJose:
                if(inverterPalavra("José").equals("José")) {
                    ePalindromo();
                } else {
                    naoEPalindromo();
                }
                break;
        }
    }

    /**
     * Metodo apenas seta o texto e cor de fundo se o palavra for Palindromo.
     */
    public void ePalindromo(){
        textoPalindromo.setText("É Palindromo");
        linearLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.verde));
    }

    /**
     * Metodo apenas seta o texto e cor de fundo se o palavra for não Palindromo.
     */
    public void naoEPalindromo(){
        textoPalindromo.setText("Não é Palindromo");
        linearLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.vermelho));
    }

    /**
     * Metodo para inverter as letras da palavra.
     * @param textoDigitado
     * @return palavraInvertida. string com as letras invertidas (da ultima para a primeira)
     */
    public String inverterPalavra(String textoDigitado){
        String palavraInvertida = "";
        char arrayDeChar[] = textoDigitado.toCharArray();
        //for para pegar cada item do texto na ordem decrescente
        for (int i = arrayDeChar.length - 1; i >= 0; i--) {
            System.out.println("Data at ["+ i +"]=" + arrayDeChar[i]);
            //Variavel recebe cada letra do array de char
            palavraInvertida = palavraInvertida + arrayDeChar[i];
        }

        //Compara o texto original com a palavra montada de forma invertida.
        if(textoDigitado.equals(palavraInvertida)) {
            Log.d("Log", "É igual!!");
        } else {
            Log.d("Log", "Não é igual!!");
        }
        return palavraInvertida;

    }
}
