import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas =1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
            else
                System.out.println("contato realizado com sucesso");

        }while(continuarTentando && tentativasRealizadas<3);
        if(atendeu)
            System.out.println("conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else 
            System.out.println("não conseguimos contato com " + candidato + ", número máximo tentativas " + tentativasRealizadas + "  tentativas");    
    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionado() {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        System.out.println("imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("o candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }
        System.out.println("forma abreviada de interação for each");

        for (String candidato: candidatos) {
            System.out.println("o candidato selecionado foi " + candidato);
        }
     }


    static void selecaoCandidatos() {

        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "jorge"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase=2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("o candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("o candidato " + candidato + " foi selecionado para vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("ligar para candidato");
        }else if(salarioBase==salarioPretendido)
        System.out.println("ligar para o candidato com contra proposta");
        else {
            System.out.println("aguardando o resultado dos demais candidato");
        }
    }
}
