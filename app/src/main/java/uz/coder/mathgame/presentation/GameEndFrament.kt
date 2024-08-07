package uz.coder.mathgame.presentation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import uz.coder.mathgame.domain.entity.GameResult
import uz.coder.mathgame.R
import uz.coder.mathgame.databinding.FragmentGameEndFramentBinding
import uz.coder.mathgame.presentation.GameFragment.Companion.GAME_NAME


class GameEndFrament : Fragment() {
    private lateinit var gameResult: GameResult

    private var _binding: FragmentGameEndFramentBinding? = null
    val binding: FragmentGameEndFramentBinding
        get() = _binding ?: throw RuntimeException("binding not init")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            FragmentGameEndFramentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    retry()
                }
            })
        binding.buttonRetry.setOnClickListener {
            retry()
        }
        bindView()
    }

    private fun retry() {
        requireActivity().supportFragmentManager.popBackStack(
            GAME_NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    private fun bindView() {
        binding.apply {
            resultEmoji.setImageResource(setImgResult())
            requiredAnswerTxt.text = String.format(
                getString(R.string.required_score),
                gameResult.gameSetting.minCountOfRightAnswer
            )
            scoreTxt.text =
                String.format(getString(R.string.score_answer), gameResult.countOfRightAnswer)
            requiredPercent.text = String.format(
                getString(R.string.required_percent),
                gameResult.gameSetting.minPercentOfRightAnswer
            )
            scorePercent.text =
                String.format(getString(R.string.to_gri_javoblar_foizda_s_minumum_s), calculate())
        }
    }

    private fun calculate():Int {
        return ((gameResult.countOfRightAnswer / gameResult.countOfQuestion.toDouble()) * 100).toInt()
    }

    private fun setImgResult(): Int {
        return if (gameResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }


    private fun parseArgs() {
        gameResult = requireArguments().getSerializable(KEY_RESULT) as GameResult
    }

    companion object {
        private const val KEY_RESULT = "result"

        @JvmStatic
        fun newInstance(gameResult: GameResult) =
            GameEndFrament().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_RESULT, gameResult)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}