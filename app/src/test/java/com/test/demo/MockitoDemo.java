package com.test.demo;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by quhong on 16/4/25.
 */
public class MockitoDemo {

//    @Test
    public void testIterator() throws Exception {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");


        String result = i.next()+" "+i.next();

        Assert.assertEquals("Hello World",result);
    }

    @Test
    public void testName() throws Exception {

        ArrayList mockedList = mock(ArrayList.class);

//        when(link.get(0)).thenReturn("element");
//        when(link.get(1)).thenReturn("element1");
//
//        when(link.contains(argThat(isValid())))
//
//        System.out.println(link.get(0));
//        System.out.println(link.get(1));

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
//        when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

//        verify(link).get(1);
    }
}
