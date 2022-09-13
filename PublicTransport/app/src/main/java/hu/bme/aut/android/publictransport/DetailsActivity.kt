package hu.bme.aut.android.publictransport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.android.publictransport.databinding.ActivityDetailsBinding
import hu.bme.aut.android.publictransport.databinding.ActivityListBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transportType = this.intent.getIntExtra(KEY_TRANSPORT_TYPE, -1)

        binding.tvTicketType.text = getTypeString(transportType)
    }

    private fun getTypeString(transportType: Int): String {
        return when (transportType) {
            ListActivity.TYPE_BUS -> "Bus pass"
            ListActivity.TYPE_TRAIN -> "Train pass"
            ListActivity.TYPE_BIKE -> "Bike pass"
            else -> "Unknown pass type"
        }
    }

    companion object {
        const val KEY_TRANSPORT_TYPE = "KEY_TRANSPORT_TYPE"
    }
}