package co.mateus;

public class Account {

    private static final int MAX_LENGTH = 12;

    private String ag;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    public Account(String ag,String cc,String name ) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name){
    if(name.length() > MAX_LENGTH){
        this.name = name.substring(0, MAX_LENGTH);
    }else {
        this.name = name;
        }
    System.out.println(this.name);
    }

    public void deposit(double value){
        balance += value;
        logger.out("DEPOSITO- R$"+ value +" Seu saldo agora é R$" + balance);
    }

    public boolean withDraw(double value){
        if(balance < value){
            logger.out("SAQUE- R$"+ value +" Não foi possível sacar , saldo disponível é de R$" + balance);
            return false;
        }else {
            balance -= value;
            logger.out("SAQUE- R$"+ value +" Seu saldo agora é R$" + balance);
            return true;
        }
    }
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
    String result = "A conta:"+this.cc+", agência:"+this.ag+", do titular:"+this.name+", possui R$"+balance;
    return result;
    }
}

