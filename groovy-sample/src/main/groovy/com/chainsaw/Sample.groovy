package com.chainsaw

/**
 * Created by richard on 9/3/16 11:30 PM.
 */

def gcl = new GroovyClassLoader()
def clazz = gcl.parseClass('class Foo { void doIt() { println "ok" } }')
assert clazz.name == 'Foo'
def o = clazz.newInstance()
o.doIt()

