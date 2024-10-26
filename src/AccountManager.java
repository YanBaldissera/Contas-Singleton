import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instance;
    private Map<String, Double> contas;

    private AccountManager() {
        contas = new HashMap<>();
    }

    public static synchronized AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public void adicionarConta(String contaId, double valor) {
        contas.put(contaId, valor);
    }

    public void depositar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            contas.put(contaId, contas.get(contaId) + valor);
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public void sacar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            if (saldoAtual >= valor) {
                contas.put(contaId, saldoAtual - valor);
            } else {
                System.out.println("Saldo insuficiente na conta " + contaId);
            }
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public double verSaldo(String contaId) {
        return contas.getOrDefault(contaId, -1.0);
    }

    public void listarContas() {
        for (Map.Entry<String, Double> conta : contas.entrySet()) {
            System.out.println("Conta ID: " + conta.getKey() + ", Saldo:  " + conta.getValue());
        }
    }
}
