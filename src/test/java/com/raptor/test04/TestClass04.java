package com.raptor.test04;

public interface TestClass04<F> {

    <E> void f0();
    
    <E extends C1> void f1();

    <E extends I1> void f2();

    <E1 extends C1, E2 extends I2> void f3();

    <E extends C2 & I2> void f4();

    <E extends I1 & I2> void f5();

    <E extends C2 & I1 & I2> void f6();

    <E extends I3<C1>> void f7();

    <E extends Throwable> void f8(F f) throws E;

    static void f9() {
        var x = new int[3][2][];
    }

    void f10(java.util.List<? extends Number> list);

    default void f11() {}

}

class C1 {}
class C2 {}
class C3<T> {}

interface I1 {}
interface I2 {}
interface I3<T> {}
interface I4 extends I1, I2, I3<String> {}