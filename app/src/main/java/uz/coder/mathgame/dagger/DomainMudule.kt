package uz.coder.mathgame.dagger

import uz.coder.mathgame.data.GameRepositoryImpl
import uz.coder.mathgame.domain.repository.GameRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainMudule {

@Binds
@AplicationScope
fun bindsGameRepository(impl: GameRepositoryImpl): GameRepository

}