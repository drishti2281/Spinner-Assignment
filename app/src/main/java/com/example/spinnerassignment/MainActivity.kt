package com.example.spinnerassignment

import android.app.Dialog
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinnerassignment.databinding.ActivityMainBinding
import com.example.spinnerassignment.databinding.DialogBoxBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var array = arrayListOf<String>("Teting", "Testing2", "Testing3", "Testing4")
    lateinit var arrayAdapter: ArrayAdapter<String>
    var spinnerAdapter = SpinnerAdapter(array)
    var companyArray = arrayListOf<SpinnerModel>(
        SpinnerModel(1, "o7 Services", "jal"),
        SpinnerModel(1, "o7 Solution", "jal"),
        SpinnerModel(1, "o7 Technology", "jal"),
        SpinnerModel(1, "o7 Solutions", "jal"),
    )
    lateinit var companyAdapter: ArrayAdapter<SpinnerModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }.also { binding.SpinnerAssignment.onItemSelectedListener = it }
        arrayAdapter = ArrayAdapter(this, R.layout.spinner_items, array)
        binding.adapterSpinner.adapter = arrayAdapter

        binding.userClassSpinner.adapter = spinnerAdapter

        companyAdapter = ArrayAdapter(this, R.layout.spinner_items, companyArray)
        binding.companySpinner.adapter = companyAdapter

        binding.fab.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog() {
        var dialogBinding = DialogBoxBinding.inflate(layoutInflater)
        var dialog = Dialog(this).apply {
            setContentView(dialogBinding.root)
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            show()
        }
        dialogBinding.btnSave.setOnClickListener {
            array.add(dialogBinding.etName.text.toString())
            dialog.cancel()

        }
    }
}