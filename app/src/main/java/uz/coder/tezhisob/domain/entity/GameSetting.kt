package uz.coder.tezhisob.domain.entity



data class GameSetting(
    val maxSumValue:Int,
    val minCountOfRightAnswer:Int,
    val minPercentOfRightAnswer:Int,
    val gameTimerSeconds:Int
)