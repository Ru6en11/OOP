package strategy

fun main(args: Array<String>) {
    val weatherData: WeatherData = WeatherData()

    val conditionsDisplay: CurrentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val staticDisplay: StaticDisplay = StaticDisplay(weatherData)
    val forecastDisplay: ForecastDisplay = ForecastDisplay(weatherData)

    weatherData.setMeasurements(15f, 70f, 28.9f)
    weatherData.setMeasurements(13f, 68f, 29.4f)
    weatherData.setMeasurements(17f, 75f, 230.1f)
    weatherData.removeObserver(conditionsDisplay)
    weatherData.removeObserver(staticDisplay)
    weatherData.setMeasurements(21f, 86f, 543.43f)
}

interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

class WeatherData: Subject {
    val observers: MutableList<Observer> = mutableListOf()
    var temperature: Float = 0f
    var humidity: Float = 0f
    var pressure: Float = 0f

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        var i: Int = observers.indexOf(o)
        if (i >= 0) {
            observers.removeAt(i)
        }
    }

    override fun notifyObservers() {
        for (i in 0 until observers.size) {
            var observer: Observer = observers.get(i)
            observer.update(temperature, humidity, pressure)
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

interface DisplayElement {
    fun display()
}

class CurrentConditionsDisplay(var weatherData: Subject): Observer, DisplayElement {
    var temperature: Float = 0f
    var humidity: Float = 0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("Current conditions: temperature: $temperature humidity: $humidity")
    }
}

class StaticDisplay(var weatherData: Subject): Observer, DisplayElement {
    var temperature: Float? = null
    var humidity: Float = 0f
    var pressure: Float = 0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("Static display: temperature: $temperature humidity: $humidity")
    }
}
class ForecastDisplay(var weatherData: Subject): Observer, DisplayElement {
    var temperature: Float = 0f
    var humidity: Float = 0f
    var pressure: Float = 0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("Forecast Display: temperature: $temperature humidity: $humidity")
    }
}