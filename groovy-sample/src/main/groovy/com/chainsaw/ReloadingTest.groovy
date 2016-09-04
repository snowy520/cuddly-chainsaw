package com.chainsaw

/**
 * Created by richard on 9/3/16 11:35 PM.
 */
class Greeter {
    private String name;

    public Greeter(String name) {
        this.name = name;
    }

    String sayHello() {
        def greet = "Hello, "+this.name+"!"
        greet
    }

}

new Greeter(name)
