package org.example.entidade;

public class TratamentoErros {
    public static boolean Caracter(String entrada) {
        char[] vericar = entrada.toCharArray();
        boolean d = true;
        for ( int i = 0; i < vericar.length; i++ )
            // verifica se o char não é um dígito
            if ( !Character.isDigit( vericar[ i ] ) ) {
                d = false;
                break;
            }
        return d;
    }
}
