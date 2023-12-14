package uz.coder.tezhisob.domain.usecases

import uz.coder.tezhisob.domain.entity.GameSetting
import uz.coder.tezhisob.domain.entity.Level
import uz.coder.tezhisob.domain.repository.GameRepository
import javax.inject.Inject

class GetGameSettingUseCase @Inject constructor(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSetting {
        return repository.getGameSetting(level)
    }
}