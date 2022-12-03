package org.example2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class app
{
    public static void main( String[] args )
    {
//
//        long  sdas=3;
//        int  inst=3;
//        System.out.println(sdas==inst);
//        System.out.println( "Hello World!" );
        String a0="asqwea";
        String a="asqweasd";
        String a1="bsrqwd";
        String a2="afqd";
        String a3="tuiooesd";
        String a4="hqiooesd";
        String a5="potntuiooesd";
        String a6="zmmawntuiooesd";
        String a7="qjhtuiooesd";
        Queue<String> aq =new PriorityQueue<>();
        aq.add(a);
        aq.add(a0);
        aq.add(a1);
        aq.add(a2);
        aq.add(a3);
        aq.add(a4);
        aq.add(a5);
        aq.add(a6);
        aq.add(a7);
        for (int i = 0; i < 8; i++) {
            System.out.println(aq.poll());
        }
        System.out.println();
    }
}
