package strategy

fun main(args: Array<String>) {
    var b1: Beverage = Espresso()
    b1 = Mocha(b1)
    b1 = Whip(b1)
    b1 = Whip(b1)
    println(b1.description + " $${b1.cost()}")

    var b2: Beverage = HouseBlend()
    b2 = Mocha(b2)
    b2 = Whip(b2)
    println(b2.description + " $${b2.cost()}")
}

abstract class Beverage {
    open var description: String = "Unknown Beverage"
        get() {
            return field
        }

    abstract fun cost(): Double
}

abstract class CondimentDecorator: Beverage() {
    override var description: String =  ""
        get() = field
}

class Espresso(override var description: String = "Espresso"): Beverage() {
    override fun cost(): Double {
        return 1.99
    }
}

class DarkRoast(override var description: String = "Dark Roast"): Beverage() {
    override fun cost(): Double {
        return 1.65
    }
}

class HouseBlend(override var description: String = "House Blend Cofffe"): Beverage() {
    override fun cost(): Double {
        return 0.89
    }
}

class Mocha(val beverage: Beverage): CondimentDecorator() {

    override var description: String = beverage.description + ", Mocha"


    override fun cost(): Double {
        return 0.30 + beverage.cost()
    }
}

class Whip(val beverage: Beverage): CondimentDecorator() {

    override var description: String = beverage.description + ", Whip"
        get() {
            return field
        }

    override fun cost(): Double {
        return 0.18 + beverage.cost()
    }
}