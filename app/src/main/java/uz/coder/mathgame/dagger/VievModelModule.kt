package uz.coder.mathgame.dagger

import androidx.lifecycle.ViewModel
import uz.coder.mathgame.presentation.GameViewModel
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