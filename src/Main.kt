// Lab 3 Kotltin
// David Dominguez 23712


// Cree una clase base llamada Food con propiedades name y price
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}


// interfaz llamada Dessert con una función eat()
interface Dessert {
    fun eat(): String
}


// subclases para alimentos específicos - override de cook
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Asando la hamburguesa $name"
    }
}
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Horneando la pizza $name"
    }
}

// implemente la interfaz Dessert para la clase IceCream. La clase IceCream es una subclase de Food
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado $name"
    }

    override fun eat(): String {
        return "Comiendo el helado $name"
    }
}

// ree una clase abstracta llamada Drink que extienda la clase Food. Agregue una función abstracta pour()
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// subclase de Drink llamada Juice. Implemente la función pour() y Haga override de la función cook()
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour(): String {
        return "Vertiendo el jugo $name"
    }

    override fun cook(): String {
        return "Exprimiendo el jugo $name"
    }
}

// extension function llamada discountedPrice() para la clase Food
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price * (1 - discountPercentage / 100)
}

fun main() {

    // cree instancias de diferentes alimentos, Llame a la función cook() para cada uno
    val burger = Burger("Clasica", 10.0)
    val pizza = Pizza("Extra queso", 12.0)
    val iceCream = IceCream("Vainilla", 5.0)
    val juice = Juice("Naranja", 3.0)

    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())
    println("----------------------------------------")


    //cree una instancia de la clase IceCream y llame a la función eat()
    val iceCream2 = IceCream("Chocolate", 6.0)
    println(iceCream2.eat())
    println("----------------------------------------")

    // Cree una instancia de la clase Burger y use la función de extensión discountedPrice() para calcular e imprimir el precio con descuento
    val burger2 = Burger("Hamburguesa", 30.0)
    val discountedBurgerPrice = burger2.discountedPrice(10.0)
    println("Precio con descuento de la hamburguesa ${burger2.name}: $${String.format("%.2f", discountedBurgerPrice)}")
    println("----------------------------------------")
}


