package uz.coder.mathgame.domain.entity



data class GameSetting(
    val maxSumValue:Int,
    val minCountOfRightAnswer:Int,
    val minPercentOfRightAnswer:Int,
    val gameTimerSeconds:Int
)