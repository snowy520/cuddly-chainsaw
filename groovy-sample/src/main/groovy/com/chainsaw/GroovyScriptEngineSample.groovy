package com.chainsaw

/**
 * Created by richard on 9/3/16 11:32 PM.
 */
//class GroovyScriptEngineSample {
//}

def binding = new Binding()
def engine = new GroovyScriptEngine([tmpDir.toURI().toURL()] as URL[])

while (true) {
    def greeter = engine.run('ReloadingTest.groovy', binding)
    println greeter.sayHello()
    Thread.sleep(1000)
}