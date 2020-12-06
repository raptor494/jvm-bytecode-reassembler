package com.raptor.test02;

public class TestClass02 {
    
    public static class A {

        public void foo() {}

    }

    public class B<T> {

        public class D<E extends T> {}

    }

    public static class C<T> extends A {

        public void foo(T t) {
            super.foo();
        }

        public void foo() {
            Object obj = "";
            boolean b = obj instanceof String;
            b = obj instanceof String[];
        }

    }

    public static void bar(C<B> c) {}

}
