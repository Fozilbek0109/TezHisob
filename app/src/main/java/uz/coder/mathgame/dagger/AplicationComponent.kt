package uz.coder.mathgame.dagger

import android.app.Application
import uz.coder.mathgame.presentation.App
import dagger.BindsInstance
import dagger.Component
import uz.coder.mathgame.presentation.GameFragment
@AplicationScope
@Component(modules = [DomainMudule::class, VievModelModule::class])
interface AplicationComponent {

    fun inject(gameFragment: GameFragment)
    fun inject(app: App)


    @Component.Factory
    interface Factory {

        fun create(
          @BindsInstance  application: Application
        ): AplicationComponent
    }

}