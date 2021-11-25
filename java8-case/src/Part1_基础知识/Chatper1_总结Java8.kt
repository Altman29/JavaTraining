package Part1_基础知识

/**
 * @author csy
 * @createTime 2021-10-08
 */

/*
为什么关心Java8? 因为Java 8所做的改变，在许多方面比Java历史上任何一次改变都深远。而且这些变化，会让编程更简单。


Collections.sort(inventory, new Comparator<Apple>() {
 public int compare(Apple a1, Apple a2){
 return a1.getWeight().compareTo(a2.getWeight());
S'inventory.sort(comparing(Apple::getWeight));

它念起来就是“给库存排序，比较苹果的重量”.

小结
以下是你应从本章中学到的关键概念。
 请记住语言生态系统的思想，以及语言面临的“要么改变，要么衰亡”的压力。虽然Java
可能现在非常有活力，但你可以回忆一下其他曾经也有活力但未能及时改进的能，方便我们编写既有效又简洁的
程序。语言的命
运，如COBOL。  Java 8中新增的核心内容提供了令人激动的新概念和功
 现有的Java编程实践并不能很好地利用多核处理器。
 函数是一等值；记得方法如何作为函数式值来传递，还有Lambda是怎样写的。
 Java 8中Streams的概念使得Collections的许多方面得以推广，让代码更为易读，并允
许并行处理流元素。
 你可以在接口中使用默认方法，在实现类没有实现方法时提供方法内容。
 其他来自函数式编程的有趣思想，包括处理null和使用模式匹配。
 */
