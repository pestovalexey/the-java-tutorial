package io.pestov.tutorial.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author Aleksey Pestov
 */
public class ProxyTest {
    public static void main(String[] args) {
        TraceHandler traceHandler = new TraceHandler();
        Foo fooProxyInstance = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, traceHandler);
        String result = fooProxyInstance.bar("me");
        System.out.println(result);
    }
}

class TraceHandler implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("bar(" + args[0] + ")");

        return "welcome";
    }
}
