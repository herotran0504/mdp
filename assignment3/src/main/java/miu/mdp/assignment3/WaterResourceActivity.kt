package miu.mdp.assignment3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment3.databinding.ActivityWaterBinding
import miu.mdp.assignment3.databinding.ItemWaterResBinding
import miu.mdp.core.BindingActivity
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast

class WaterResourceActivity : BindingActivity<ActivityWaterBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityWaterBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.addBtn.setOnClickListener {
            handleAddWaterResource()
        }

        addTableHeader()
    }

    private fun addTableHeader() {
        addRow(
            resName = getString(R.string.res_name),
            resLocation = getString(R.string.res_location),
            resType = getString(R.string.res_type),
        )
    }

    private fun handleAddWaterResource() {
        val waterResource = WaterResource(
            resName = binding.resName.text.toString(),
            resLocation = binding.resLocation.text.toString(),
            resType = binding.resType.text.toString()
        )
        if (validateWaterResource(waterResource)) {
            hideKeyboard()
            clearInput()
            addWaterResource(waterResource)
        }
    }

    private fun clearInput() {
        binding.resName.setText("")
        binding.resLocation.setText("")
        binding.resType.setText("")
    }

    private fun addWaterResource(waterResource: WaterResource) {
        addRow(
            resName = waterResource.resName,
            resLocation = waterResource.resLocation,
            resType = waterResource.resType,
        )
    }

    private fun addRow(resName: String, resLocation: String, resType: String) {
        val rowBinding = ItemWaterResBinding.inflate(layoutInflater, binding.root, false)
        binding.resTable.addView(rowBinding.root)
        rowBinding.resName.text = resName
        rowBinding.resLocation.text = resLocation
        rowBinding.resType.text = resType
    }

    private fun validateWaterResource(waterResource: WaterResource): Boolean {
        if (waterResource.resName.isEmpty()) {
            displayResRequired(getString(R.string.res_name_error))
            return false
        } else if (waterResource.resLocation.isEmpty()) {
            displayResRequired(getString(R.string.res_location_error))
            return false
        } else if (waterResource.resType.isEmpty()) {
            displayResRequired(getString(R.string.res_type_error))
            return false
        }
        return true
    }

    private fun displayResRequired(message: String) {
        showToast(message)
        hideKeyboard()
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, WaterResourceActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}