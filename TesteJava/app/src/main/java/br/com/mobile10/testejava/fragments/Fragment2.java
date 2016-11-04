package br.com.mobile10.testejava.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.mobile10.testejava.R;


/**
 * Created by denilsonmonteiro on 01/11/16.
 */
public class Fragment2 extends Fragment implements View.OnClickListener {

    private TextView textoResultado;        // Resultado do cálculo. Visivel apenas quando clica no botão verificar.
    private EditText editGetNumero;         // EditText que só recebe números.
    private LinearLayout layoutResultado;   // Layout para deixar visivel o resultado.
    private Button btCalcular;              // Botão simples para disparar o calculo e resultado.
    private static final String REQUIRED = "Digite um número";  // Mensagem caso o úsuario deixe campo em branco.

    public Fragment2(){

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragments2, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textoResultado = (TextView) getActivity().findViewById(R.id.numeroDePares);
        editGetNumero = (EditText) getActivity().findViewById(R.id.pegaTexto);
        layoutResultado = (LinearLayout) getActivity().findViewById(R.id.resultado);
        btCalcular = (Button) getActivity().findViewById(R.id.calcular);

        getActivity().findViewById(R.id.calcular).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calcular:
                String textoDigitado = editGetNumero.getText().toString();
                //Verifica se o campo de texto está vazio. Se estiver retorna um alerta.
                if (TextUtils.isEmpty(textoDigitado)) {
                    editGetNumero.setError(REQUIRED);
                    return;
                }
                textoResultado.setText(calculaPares(textoDigitado));
                layoutResultado.setVisibility(View.VISIBLE);
                Log.d("TAG", "Texto digitado: " + editGetNumero.getText().toString());
                break;
        }
    }

    /**
     * Metodo encontra os pares de um inteiro dentro do array.
     * Recebe um string, ela é transformada em inteiro para o processamento e ao final volta para string.
     * @param s
     * @return string (número de pares possíveis)
     */
    public String calculaPares(String s){

        int numeroDigitado = Integer.parseInt(s);               // Num capturado vem como string.
        int[] array = new int[] {2, 5, 0, 7, 9, -2, 3, -1, 8};  // Um array aleatório. Pode ser mudado.
        int num = numeroDigitado;
        int count = 0;

        // Laço para verificação de pares.
        for(int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++ ) {
                if (array[ i ] + array[ j ] == num ) {
                    if ( i != j ) count += 2;
                    else count++;
                }
            }
        }
        System.out.println("Número de pares são: " + count);
        return String.valueOf(count);
    }
}
