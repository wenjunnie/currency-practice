package deadlock;

import java.util.Random;
import deadlock.TransferMoney.Account;

/**
 * 多人随机转账，依然很危险。
 * @Author: wenjun
 * @Date: 2019/10/29 16:40
 */
public class MultiTransferMoney {

    private static final int NUM_ACCOUNTS = 500;
    private static final int NUM_MONEY = 1000;
    private static final int NUM_THREADS = 20;
    private static int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        Random random = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            accounts[i] = new Account(NUM_MONEY);
        }
        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = random.nextInt(NUM_ACCOUNTS);
                    int toAcct = random.nextInt(NUM_ACCOUNTS);
                    int amount = random.nextInt(NUM_MONEY);
                    TransferMoney.transferMoney(accounts[fromAcct],accounts[toAcct],amount);
                }
            }
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }
    }
}
