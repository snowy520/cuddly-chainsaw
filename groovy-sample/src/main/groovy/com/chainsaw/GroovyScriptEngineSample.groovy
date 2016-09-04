package com.chainsaw

/**
 * Created by richard on 9/3/16 11:32 PM.
 */
//class GroovyScriptEngineSample {
//}

def binding = new Binding()
binding.setProperty("name","me")
String[] roots  =  {"src/groovy/com/chainsaw"} ;
def engine = new GroovyScriptEngine(roots)

while (true) {
    def greeter = engine.run('ReloadingTest.groovy', binding)
    println greeter.sayHello()
    Thread.sleep(1000)
}