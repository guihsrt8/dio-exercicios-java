public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}

public class Contador {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Por favor, forneça dois números inteiros como parâmetros.");
            return;
        }

        try {
            int primeiroParametro = Integer.parseInt(args[0]);
            int segundoParametro = Integer.parseInt(args[1]);

            if (primeiroParametro > segundoParametro) {
                throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
            }

            for (int i = primeiroParametro; i <= segundoParametro; i++) {
                System.out.println("Imprimindo o número " + i);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, forneça números inteiros válidos como parâmetros.");
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }
}

