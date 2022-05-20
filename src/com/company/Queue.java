package com.company;

public class Queue {
    private char[] q;
    private int putloc, getloc;

    Queue(int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    Queue(Queue ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        for (int i = getloc; i < putloc; i++)
            q[i] = ob.q[i];
    }

    Queue(char[] a) {
        putloc = 0;
        getloc = 0;
        q = new char[a.length + 1];

        for (int i = 0; i < a.length; i++) put(a[i]);
    }

     void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - crowded queue");
            return;
        }
        q[putloc++] = ch;
    }

     char get() {
        if (getloc == putloc) {
            System.out.println(" - empty queue");
            return (char) 0;
        }
        return q[getloc++];
    }

    int Qlength(Queue ob){

        return ob.q.length;
    }

}
class TestQ {

    public static void main(String[] args) {
        Queue testQ = new Queue(10);
        char[] d = new char[]{'3', '5', 'A', 'a'};
        Queue test3Q = new Queue(d);
        char ch;

        System.out.println("Array testQ ");
        for (int i = 0; i < 10; i++) {
            testQ.put((char) ('a' + i));
        }

        Queue test2Q = new Queue(testQ);

        for (int i = 0; i < testQ.Qlength(testQ); i++) {
            ch = testQ.get();
            System.out.println(ch + '\n');
        }

        for (int i = 0; i < test2Q.Qlength(test2Q); i++) {
            ch = test2Q.get();
            System.out.println(ch + '\n');
        }

        for (int i = 0; i < test3Q.Qlength(test3Q); i++) {
            ch = test3Q.get();
            System.out.println(ch + '\n');
        }
    }
}
