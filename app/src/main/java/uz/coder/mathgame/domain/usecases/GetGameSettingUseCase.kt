package uz.coder.mathgame.domain.usecases

import uz.coder.mathgame.domain.entity.GameSetting
import uz.coder.mathgame.domain.entity.Level
import uz.coder.mathgame.domain.repository.GameRepository
import javax.inject.Inject

class GetGameSettingUseCase @Inject constructor(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSetting {
        return repository.getGameSetting(level)
    }
}