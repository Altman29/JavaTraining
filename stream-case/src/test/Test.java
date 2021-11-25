package test;

import entity.Trader;
import entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author csy
 * @createTime 2021-10-16
 * @Description TODO
 */
public class Test {

    /*
    (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
    (2) 交易员都在哪些不同的城市工作过？
    (3) 查找所有来自于剑桥的交易员，并按姓名排序。
    (4) 返回所有交易员的姓名字符串，按字母顺序排序。
    (5) 有没有交易员是在米兰工作的？
    (6) 打印生活在剑桥的交易员的所有交易额。
    (7) 所有交易中，最高的交易额是多少？
    (8) 找到交易额最小的交易。
     */
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays
                        .asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
                                new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
                                new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        //    (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        System.out.println("(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。");
        transactions.stream().filter(trans -> trans.getYear() == 2011)
                        .sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        System.out.println();

        //    (2) 交易员都在哪些不同的城市工作过？
        System.out.println("(2) 交易员都在哪些不同的城市工作过？");
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                        .distinct()//可以使用collect(toSet()).这里方便打印使用forEach终端操作。
                        .forEach(System.out::println);
        System.out.println();

        //    (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        System.out.println("(3) 查找所有来自于剑桥的交易员，并按姓名排序.");
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct().sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
        System.out.println();

        //    (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println("(4) 返回所有交易员的姓名字符串，按字母顺序排序。");

        String reduce = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().distinct()
                        .reduce("", (n1, n2) -> n1 + n2 + " ");
        System.out.println(reduce);
        System.out.println();

        //    (5) 有没有交易员是在米兰工作的？  有没有->anyMatch
        System.out.println("(5) 有没有交易员是在米兰工作的？  有没有->anyMatch");
        boolean milan = transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        if (milan) {
            System.out.println("yes");
        }
        System.out.println();

        //    (6) 打印生活在剑桥的交易员的所有交易额。
        System.out.println("(6) 打印生活在剑桥的交易员的所有交易额。");
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .map(Transaction::getValue).forEach(System.out::println);
        System.out.println();

        //    (7) 所有交易中，最高的交易额是多少？
        System.out.println("(7) 所有交易中，最高的交易额是多少？");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).get());
        System.out.println();

        //    (8) 找到交易额最小的交易。
        System.out.println("(8) 找到交易额最小的交易。");
        // System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::min).get());//just get value 300
        Optional<Transaction> smallestTransition = transactions.stream()
                        .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        smallestTransition.ifPresent(System.out::println);
    }
}
