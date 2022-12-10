package java8.studyStream.collector;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

public class Test {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//        Map<Currency, List<Transaction>> transactionsByCurrencies =
//                transactions.stream().collect(groupingBy(Transaction::getCurrency));
        IntSummaryStatistics collect = transactions.stream().collect(summarizingInt(tran -> tran.getYear()));
        System.out.println("collect = " + collect);
        System.out.println("collect = " + collect.getSum());

    }
}
