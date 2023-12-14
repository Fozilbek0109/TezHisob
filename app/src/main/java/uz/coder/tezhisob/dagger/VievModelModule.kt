package uz.coder.tezhisob.dagger

import androidx.lifecycle.ViewModel
import uz.coder.tezhisob.presentation.GameViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface VievModelModule {

@Binds
@IntoMap
@ViewModelKey(GameViewModel::class)
fun bindsGameViewModel(gameViewModel: GameViewModel):ViewModel
}