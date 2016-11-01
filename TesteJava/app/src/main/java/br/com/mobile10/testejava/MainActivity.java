package br.com.mobile10.testejava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etapa2();


    }

    public void etapa1(){

        String palavraInvertida = "";
        String meuTexto = "1221";
        char arrayDeChar[] = meuTexto.toCharArray();

        //for para pegar cada item do texto na ordem crescente
//        for(int i = 0; i < arrayDeChar.length; i++) {
//
//            System.out.println("Data at ["+ i +"]=" + arrayDeChar[i]);
//        }

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

    public void etapa2(){

        //Etapa 2
        int[] array = new int[] {2, 5, -1, 6, 10, -2};
        int num = 4;
        int count = 0;

        for(int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++ ) {
                if (array[ i ] + array[ j ] == num ) {
                    if ( i != j ) count += 2;
                    else count++;
                }
            }
        }
        System.out.println("Número de pares são: " + count);

    }

}
