package uz.coder.mathgame.presentation

import android.app.Application
import uz.coder.mathgame.dagger.DaggerAplicationComponent

class App : Application() {

    val component by lazy {
        DaggerAplicationComponent.factory().create(this)
    }


    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

}