import entity.BaseRule;
import org.junit.Test;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOp {
    private int ruleid;
    private String string;
    /*  private String msg = "nothing is want to talk with you";

    private Instruction instruction;

    public Hello(String msg) {
        this.msg = msg;
        this.instruction = new Instruction(this);
    }*/

    @Test
    public void testList() {
        List<BaseRule> list = new LinkedList<BaseRule>();
        BaseRule r1 = new BaseRule();
        r1.setRuleid(1);
        r1.setRulename("规则1");
        r1.setRemark("备注1");
        list.add(r1);
        BaseRule r2 = new BaseRule();
        r2.setRuleid(2);
        r2.setRulename("规则2");
        r2.setRemark("备注2");
        list.add(r2);
        BaseRule r3 = new BaseRule();
        r3.setRuleid(3);
        r3.setRulename("规则3");
        r3.setRemark("备注3");
        list.add(r3);

        Iterator<BaseRule> iterator = list.iterator();
        while (iterator.hasNext()) {
            BaseRule baseRule = iterator.next();
            if (baseRule.getRemark().equals("备注3")) {
                System.out.println(baseRule.getRulename());
            }
        }
        list.stream().filter(x -> x.getRemark().equals("备注3")).forEach(x -> System.out.println(x.getRulename()));

    }


    //Intermediate  中间
    @Test
    public void skip() {
        //过滤前5个元素
        Stream.of(1, 2, 3, 4, 5, 6).skip(5).forEach(System.out::println);
    }

    @Test
    public void peek() {
        //生成一个包含着远stream元素的新stram，同时会提供一个消费函数，新的stream每个元素被消费的时候都会执行给定的消费函数，且消费函数优先执行
        //只是提供消费函数，不会改变元素的值
        Stream.of(1, 2, 3, 4, 5, 6).peek(x -> {
            int y = x + 10;
            x = y;
            System.out.println(x);
        }).forEach((k) -> {
            System.out.println(k);
        });
    }

    @Test
    public void sorted() {
        //进行特定规则的排序
        Stream.of(5, 4, 2, 1, 3).sorted((x, y) ->
                y.compareTo(x)
        ).forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        Stream.of(1, 2, 3, 88, 4, 5).flatMap(x -> Stream.of(x * 1000)).forEach(System.out::println);
    }

    @Test
    public void map() {
        //将stream包含的元素通过函数进行转换，并产生新的stream函数
        Stream.of(1, 2, 3, 88, 4, 5).map(x -> x * 1000).forEach(System.out::println);
    }

    @Test
    public void filter() {
        //对stream原有的元素通过函数帅选出满足条件的元素，并产生新的stream
        Stream.of(1, 2, 3, 88, 4, 5).filter(x -> x > 3).forEach(System.out::println);
        System.out.println("--------------");
        //true：不顾虑此元素， false：过滤此元素
        Stream.of(1, 2, 3, 88, 4, 5).filter(x -> {
            if (x == 1) {
                return true;
            }
            return true;
        }).forEach(System.out::println);
    }

    @Test
    public void concat() {
        //将两个stream拼接成一个新的stream
        Stream.concat(Stream.of(1, 2, 3), Stream.of(3, 4, 5)).forEach(System.out::println);
    }

    @Test
    public void distinct() {
        Stream.of(1, 2, 3, 4, 6, 5, 1, 2, 3).distinct().forEach(System.out::println);
    }

    //及早求值方法，一个stream操作中，可以有多次惰性求值，但是只有一个及早求值
    @Test
    public void cout() {
        long count = Stream.of(1, 1, 2, 4, 5, 6).filter(x -> {
            if (x.equals(1)) {
                return true;
            }
            return false;
        }).count();
        System.out.println(count);
        Stream.of(1, 1, 2, 4, 5, 6).filter(x -> {
            if (x.equals(1)) {
                return true;
            }
            return false;
        }).forEach(System.out::println);
    }

    //静态工厂方法
    @Test
    public void streamof() {
        BaseRule rule = new BaseRule();
        rule.setRuleid(1);
        rule.setRulename("规则1");
        rule.setRemark("备注1");
        //创建的stream长度为其内元素的个数
        Stream<BaseRule> stream = Stream.of(rule);
        stream.forEach((k) -> {
            System.out.println(k.getRulename());
        });
    }

    @Test
    public void generator() {
        //建立无限长度的stream。支持lambda表达式
        Stream<Double> stream = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return java.lang.Math.random();
            }
        });
        Stream<String> stringStream = Stream.generate(() -> "你好");
        //stringStream.forEach(System.out::println);
        Stream<Double> doubleStream = Stream.generate(java.lang.Math::random);
        doubleStream.forEach((k) -> {
            System.out.println(k);
        });
    }

    @Test
    public void iterate() {
        //创建一个无限长度的stream,用以递增
        Stream.iterate(9, (k) -> k + 1).limit(5).forEach(System.out::println);
        Stream.iterate("hello", k -> k + "001").limit(10).forEach(System.out::println);
    }

    @Test
    public void arraysToStream() {
        int ids[] = new int[]{1, 2, 3, 4, 5, 6};
        Arrays.stream(ids).forEach(System.out::println);
    }

    //Terminal  终端  及早求值
    @Test
    public void count() {
        Long count = Stream.generate(() -> "jsj").limit(100).count();
        System.out.println(count);
    }

    @Test
    public void foreach() {
        //stream是无序的
        Stream.of(1, 8, 5, 4, 3, 2).forEachOrdered(x -> System.out.println(x));
        System.out.println("--------------");
        Stream.of(1, 8, 5, 4, 3, 2).forEachOrdered(x -> System.out.println(x));
    }

    @Test
    public void max() {
        Optional<Integer> optionalI = Stream.of(1, 5, 9).max((x, y) -> {
            return x - y;
                }
        );
        System.out.println(optionalI.get());
    }

    //reduce java中万能的reduce
    @Test
    public void allMatch() {
        //stream中的元素全部满足条件则返回true，否则为false
        Boolean aBoolean = Stream.of(1, 2, 3).allMatch(x -> x > 2);
        System.out.println(aBoolean);
    }

    @Test
    public void anyMatch() {
        Boolean aBoolean = Stream.of(1, 2, 3).anyMatch((x) -> x > 1);
        System.out.println(aBoolean);
    }

    @Test
    public  void findAny()
    {
        //选择任意一个
       Optional<Integer> optionalInteger = Stream.of(1,2,3).findAny();
       System.out.println(optionalInteger.get());
    }

    @Test
    public  void findFirst()
    {
        //选择第一个
       Optional<Integer> optional =  Stream.of(1,2,3).findFirst();
       System.out.println(optional.get());
    }
    @Test
    public  void noneMatch() {
        //都不满足是返回true
        Boolean aBoolean = Stream.of(1, 2, 3).noneMatch(x -> x > 1);
        System.out.println(aBoolean);
    }

}
