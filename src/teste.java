public class teste {
    public static void main(String[] args) {
        AccountManager manager = AccountManager.getInstance();


        manager.adicionarConta("001", 0.0);
        manager.adicionarConta("002", 0.0);
        manager.adicionarConta("003", 0.0);
        manager.adicionarConta("004", 0.0);


        Cliente cliente1 = new Cliente("001", "Alice");
        Cliente cliente2 = new Cliente("002", "Bob");
        Cliente cliente3 = new Cliente("003", "Carol");
        Cliente cliente4 = new Cliente("004", "David");


        cliente1.depositar(500);
        cliente2.depositar(500);
        cliente3.depositar(500);
        cliente4.depositar(500);


        cliente1.sacar(600);
        cliente2.sacar(100);
        cliente3.sacar(700);
        cliente4.sacar(400);

        // Exibir saldos
        System.out.println("Saldo de " + cliente1.getNome() + ": " + cliente1.verSaldo());
        System.out.println("Saldo de " + cliente2.getNome() + ": " + cliente2.verSaldo());
        System.out.println("Saldo de " + cliente3.getNome() + ": " + cliente3.verSaldo());
        System.out.println("Saldo de " + cliente4.getNome() + ": " + cliente4.verSaldo());


        AccountManager manager2 = AccountManager.getInstance();
        System.out.println("Verificando se é a mesma instância: " + (manager == manager2));

        // Listar contas ativas
        manager.listarContas();
    }
}
