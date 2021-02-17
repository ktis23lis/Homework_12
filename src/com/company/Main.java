package com.company;

public class Main {
    static final int size = 10_000_000;
    static final float half = size/2;

    public static void main(String[] args) {

	    float [] arr = new float[size];
	    float [] a1 = new float [(int) half];
        float [] a2 = new float [(int) half];


        hardExample(arr, a1, a2);


        elementaryArr(arr);


            }

    private static void hardExample(float[] arr, float[] a1, float[] a2) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long q = System.currentTimeMillis();
        System.arraycopy(arr,0, a1,0, (int) half);
        System.arraycopy(arr,(int) half, a2,0, (int) half);
        System.out.println("Время разбивики массива на два "+ (System.currentTimeMillis() - q));
        Thread t1 = new Thread() {
            @Override
            public void run() {
                long w = System.currentTimeMillis();
                 for (int i = 0; i < a1.length; i++) {
                     a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }System.out.println("Время расчета первого массива "+(System.currentTimeMillis()-w));
                }
                    };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                long e = System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время расчета второго массива "+(System.currentTimeMillis()-e));
            }
        } ;

        t1.run();
        t2.run();

        long r = System.currentTimeMillis();
        System.arraycopy(a1,0, arr,0,(int)half);
        System.arraycopy(a2,0, arr,(int)half,(int)half);
        System.out.println("Время склейки "+(System.currentTimeMillis()-r));
    }

    private static void elementaryArr(float[] arr) {
                long b = System.currentTimeMillis();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = 1;
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math
                            .cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Обычный способ "+((System.currentTimeMillis()) - b));
            }



        }