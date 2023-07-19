package devandroid.alves.appgaseta.applistacurso.apoio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilGasEta {


    public static void MetodoEstatico() {
    }

    public void MetodoNaoStatico() {
    }

    public static String mensagem() {
        return "VAI CORINTHIANS!!";
    }

    public static String CalcularMelhorOpcao(double gasolina, double etanol) {
        // preco da gasolina R$ 5,12
        // preco do etanol R$ 3,99
        // pre ideal é gasolina * 0.70

        double precoIdeal = gasolina * 0.70;
        String msgRetorno = null;

            if (etanol >= precoIdeal) {
                msgRetorno = "Abasteça com Gasolina!";
            } else {
                msgRetorno = "Abasteça com Etanol!";
            }

        return msgRetorno;
    }
}
