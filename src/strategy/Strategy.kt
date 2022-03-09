package strategy

fun main() {
    val mallard: Duck = MallardDuck()
    mallard.perfomQuack()
    mallard.perfomFly()

    val model: Duck = ModelDuck()
    model.perfomFly()
    model.flyBehavior = FlyRocketPowered()
    model.perfomFly()
}

interface FlyBehavior {
    fun fly()
}

class FlyWithWings: FlyBehavior {
    override fun fly() {
        println("I'm flying!")
    }
}

class FlyNoWay: FlyBehavior {
    override fun fly() {
        println("I'm can't fly :(")
    }
}

class FlyRocketPowered: FlyBehavior {
    override fun fly() {
        println("I'm flying with a rocket!")
    }
}

interface QuackBehavior {
    fun quack()
}

class Quack: QuackBehavior {
    override fun quack() {
        println("Quack-quack!")
    }
}

class MuteQuack: QuackBehavior {
    override fun quack() {
        println("<< Silence >>")
    }
}

class Squeak: QuackBehavior {
    override fun quack() {
        println("Squeeeak")
    }
}


abstract class Duck() {

    abstract var flyBehavior: FlyBehavior

    abstract val quackBehavior: QuackBehavior


    fun perfomFly() {
        flyBehavior.fly()
    }

    fun perfomQuack() {
        quackBehavior.quack()
    }

    fun swim() {
        println("All ducks float, even decoys!")
    }

    abstract fun display()
}

class MallardDuck(): Duck() {
    override var flyBehavior: FlyBehavior = FlyWithWings()
    override var quackBehavior = Quack()

    override fun display() {
        println("Hi! I'm MallardDuck!")
    }

}

class ModelDuck: Duck() {
    override var flyBehavior: FlyBehavior = FlyNoWay()
        set(value) {
            field = value
        }
    override var quackBehavior: QuackBehavior = Quack()
        set(value) {
            field = value
        }

    override fun display() {
        println("I'm really modelDuck!")
    }
}