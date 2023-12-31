package uz.coder.tezhisob.dagger

import android.app.Application
import uz.coder.tezhisob.presentation.App
import dagger.BindsInstance
import dagger.Component
import uz.coder.tezhisob.presentation.GameFragment
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