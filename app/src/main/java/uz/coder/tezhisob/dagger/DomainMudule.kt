package uz.coder.tezhisob.dagger

import uz.coder.tezhisob.data.GameRepositoryImpl
import uz.coder.tezhisob.domain.repository.GameRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainMudule {

@Binds
@AplicationScope
fun bindsGameRepository(impl: GameRepositoryImpl): GameRepository

}