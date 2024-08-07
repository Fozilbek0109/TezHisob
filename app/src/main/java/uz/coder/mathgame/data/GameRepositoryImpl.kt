package uz.coder.mathgame.data

import uz.coder.mathgame.domain.entity.GameSetting
import uz.coder.mathgame.domain.entity.Level
import uz.coder.mathgame.domain.entity.Question
import uz.coder.mathgame.domain.repository.GameRepository
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class GameRepositoryImpl @Inject constructor() : GameRepository {
    companion object {
        private const val MIN_SUM_VALUE = 2
        private const val MIN_SUM_VALUE_ANSWER = 1
    }
    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val yigindi = Random.nextInt(MIN_SUM_VALUE, maxSumValue+1) //27
        val visibleNumber = Random.nextInt(MIN_SUM_VALUE_ANSWER, yigindi) //15
        val variantlar = HashSet<Int>()
        val rightAnswer = yigindi - visibleNumber
        variantlar.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_SUM_VALUE)//1
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (variantlar.size < countOfOptions) {
            variantlar.add(Random.nextInt(from, to))
        }
        return Question(yigindi, visibleNumber, variantlar.toList())
    }

    override fun getGameSetting(level: Level): GameSetting = when (level) {
        Level.TEST -> GameSetting(10, 3, 50, 8)
        Level.EASY -> GameSetting(10, 10, 70, 60)
        Level.NORMAL -> GameSetting(20, 20, 80, 40)
        Level.HARD -> GameSetting(20, 20, 90, 45)
    }
}