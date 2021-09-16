/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendz.tool.autopadlet.util;

/**
 *
 * @author Administrator
 */
public class CounterComment {

    private static int count = 0;

    public static void reset() {
        count = 0;
    }

    public static synchronized void inc() {
        count++;
    }

    public static int get() {
        return count;
    }
}
