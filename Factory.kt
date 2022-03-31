package tasks

fun main(args: Array<String>) {
    val nyPizzaStore: NYPizzaStore = NYPizzaStore()
    val ChicagoPizzaStore: ChicagoPizzaStore = ChicagoPizzaStore()

    var pizza: Pizza? = nyPizzaStore.orderPizza("cheese")
    println("Ethan ordered a ${pizza?.name}")

    pizza = ChicagoPizzaStore.orderPizza("chees e")
    println("Ethan ordered a ${pizza?.name}")
}

abstract class Pizza {
    open var name: String = ""
        get() {
            return field
        }
    open val dough: String = ""
    open val sauce: String = ""
    open val toppings: MutableList<String> = mutableListOf()

    fun prepare() {
        println("Preparing " + name)
        println("Tossing dough...")
        println("Adding sauce...")
        println("Adding toppings: ")
        for (topping in toppings)
            println("$topping ")
    }

    open fun bake() {
        println("Bake for 25 mitutes at 350")
    }

    open fun cut() {
        println("Cutting th pizza into diagonal slices")
    }

    open fun box() {
        println("Place pizza in official PizzaStore box")
    }


}

abstract class PizzaStore() {
    fun orderPizza(type: String): Pizza? {
        val pizza = createPizza(type)

        pizza?.prepare()
        pizza?.bake()
        pizza?.cut()
        pizza?.box()
        return pizza
    }

    abstract fun createPizza(type: String): Pizza?
}

class NYStyleCheesePizza: Pizza() {
    override var name: String  = "NY style Sauce and Cheese Pizza"
    override val dough: String = "Thin Crust Dough"
    override val sauce: String = "Marinara Sauce"

    override val toppings: MutableList<String> = super.toppings

    init {
        toppings.add("Grated Reggiano Cheese")
    }
}

class ChicagoStyleCheesePizza: Pizza() {
    override var name: String  = "Chicago Style Deep Dish Cheese Pizza"
    override val dough: String = "Extra thick Crust Dough"
    override val sauce: String = "Plum Tomato Sauce"

    override val toppings: MutableList<String> = super.toppings

    init {
        toppings.add("Shredded Mozzarella Cheese")
    }

    override fun cut() {
        println("Cutting the pizza into square slices")
    }
}


class NYPizzaStore: PizzaStore() {
    override fun createPizza(item: String): Pizza? {
        return if (item.equals("cheese")) {
            NYStyleCheesePizza()
//        } else if (item.equals("veggie")) {
//            NYStyleVeggiePizza()
//        } else if (item.equals("clam")) {
//            NYStyleClamPizza()
//        } else if (item.equals("pepperoni")) {
//            NYStylePepperoniPizza()
        } else null
    }
}

class ChicagoPizzaStore: PizzaStore() {
    override fun createPizza(item: String): Pizza? {
        return if (item.equals("cheese")) {
            ChicagoStyleCheesePizza()
//        } else if (item.equals("veggie")) {
//            ChicagoStyleVeggiePizza()
//        } else if (item.equals("clam")) {
//            ChicagoStyleClamPizza()
//        } else if (item.equals("pepperoni")) {
//            ChicagoStylePepperoniPizza()
        } else null
    }
}