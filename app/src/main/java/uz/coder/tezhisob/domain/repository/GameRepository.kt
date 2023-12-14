package uz.coder.tezhisob.domain.repository

import uz.coder.tezhisob.domain.entity.GameSetting
import uz.coder.tezhisob.domain.entity.Level
import uz.coder.tezhisob.domain.entity.Question

interface GameRepository {
    fun generateQuestion(maxSumValue:Int,countOfOptions:Int): Question
    fun getGameSetting(level: Level): GameSetting
}