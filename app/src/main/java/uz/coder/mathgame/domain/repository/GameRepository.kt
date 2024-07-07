package uz.coder.mathgame.domain.repository

import uz.coder.mathgame.domain.entity.GameSetting
import uz.coder.mathgame.domain.entity.Level
import uz.coder.mathgame.domain.entity.Question

interface GameRepository {
    fun generateQuestion(maxSumValue:Int,countOfOptions:Int): Question
    fun getGameSetting(level: Level): GameSetting
}