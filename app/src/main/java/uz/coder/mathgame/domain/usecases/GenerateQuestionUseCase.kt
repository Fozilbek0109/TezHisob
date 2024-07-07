package uz.coder.mathgame.domain.usecases

import uz.coder.mathgame.domain.entity.Question
import uz.coder.mathgame.domain.repository.GameRepository
import javax.inject.Inject

class GenerateQuestionUseCase @Inject constructor(private val repository: GameRepository) {

    operator fun invoke(maxSumValue:Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTION)
    }
    companion object{
        const val COUNT_OF_OPTION = 6
    }
}