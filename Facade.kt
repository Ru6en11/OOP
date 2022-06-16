
fun main()
{
    val tuner =  Tuner()
    val DVD = CdPlayer()
    val projector = Projector()
    val theaterLights = TheaterLights()
    val popcornPopper = PopcornPopper()
    val amplifier = Amplifier()
    val homePlayerFacade = HomePlayerFacade(tuner, DVD, projector,theaterLights, popcornPopper, amplifier)
    homePlayerFacade.watchMovie("Darkwing Duck")
    println()
    homePlayerFacade.endMovie()
}

class Amplifier{
    fun on(){
        println("Amplifier if ON")
    }
    fun off(){
        println("Amplifier if OFF")
    }
}
class Tuner(){
    var Am = 0;
    var Fm = 0;
    var frequency: Int = 0
    fun on(){
        println("Tuner is ON")
    }
    fun off(){
        println("Tuner if OFF")
    }
    @JvmName("setAm1")
    fun setAm(Am: Int){
        this.Am = Am
        println("Tuner AM: $Am")
    }

    @JvmName("setFm1")
    fun setFm(Fm: Int){
        this.Fm = Fm
        println("Tuner FM: $Fm")
    }

}
class CdPlayer(){
    fun on(){
        println("CdPlayer is ON")
    }
    fun off(){
        println("CdPlayer is OFF")
    }
    fun play(name: String){
        println("CdPlayer is $name")
    }
    fun pause() {
        println("CdPlayer is STOPPING")
    }
}

class PopcornPopper{
    fun on(){
        println("PopcornPopper is ON")
    }
    fun off(){
        println("PopcornPopper is OFF")
    }
    fun pop(){
        println("PopcornPopper is POPPING")
    }
}

class TheaterLights(){
    fun on(){
        println("TheaterLights is ON")
    }
    fun off(){
        println("TheaterLights is OFF")
    }
}

class Projector(){
    fun on(){
        println("Projector is ON")
    }
    fun off(){
        println("Projector is OFF")
    }
}

class HomePlayerFacade(var tuner: Tuner,
                       var DVD: CdPlayer,
                       var projector: Projector,
                       var theaterLights: TheaterLights,
                       var popcornPopper: PopcornPopper,
                       var amplifier: Amplifier
){
    fun watchMovie(name: String){
        println("Movie will start")
        popcornPopper.on()
        popcornPopper.pop()
        projector.on()
        theaterLights.on()
        amplifier.on()
        DVD.on()
        DVD.play(name)
    }
    fun endMovie(){
        println("Movie is ENDING")
        popcornPopper.off()
        projector.off()
        theaterLights.off()
        amplifier.off()
        DVD.off()
    }
}
