package strategy

fun main() {
    val c1 = King(AxeBehaviour())
    c1.w = AK47Behaviour()
    c1.fight()
}

interface WeaponBehaviour {
    fun useWeapon()
}

abstract class Character(var weaponBehaviour: WeaponBehaviour) {
    abstract fun fight()
}

class Knight(var weapon: WeaponBehaviour): Character(weapon) {
    override fun fight() {
        //
    }
}

class Queen(var weapon: WeaponBehaviour): Character(weapon) {
    override fun fight() {
        //
    }
}

class King(var weapon: WeaponBehaviour): Character(weapon) {
    var w = weapon
        set(value) {
            field = value
        }
    override fun fight() {
        println("King started a fight")
        w.useWeapon()
    }
}

class AxeBehaviour: WeaponBehaviour {
    override fun useWeapon() {
        println("Axe slash")
    }
}

class AK47Behaviour: WeaponBehaviour {
    override fun useWeapon() {
        println("Ra-ta-ta")
    }
}