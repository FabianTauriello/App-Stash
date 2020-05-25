package io.github.fabiantauriello.appstash.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import io.github.fabiantauriello.appstash.R
import io.github.fabiantauriello.appstash.model.SpinnerOptions
import io.github.fabiantauriello.appstash.presenter.AppContract
import io.github.fabiantauriello.appstash.presenter.AppPresenter
import kotlinx.android.synthetic.main.activity_app.*

// used for creating a new app idea
class AppActivity : AppCompatActivity(), AppContract.View {

    // establishes a 1 - 1 relationship between the presenter and the view
    private val presenter = AppPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        // tells the presenter that his activity is it's view
        presenter.setView(this)

        configureSpinnerAdapters()
        configureSpinnerListeners()
        configureEditTextListeners()
        configureClickListener()
    }

    private fun configureSpinnerAdapters() {
        spin_platform.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, SpinnerOptions.PLATFORMS)
        spin_category.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, SpinnerOptions.CATEGORIES)
    }

    private fun configureSpinnerListeners() {
        spin_platform.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.platformSelected(SpinnerOptions.PLATFORMS[position])
            }
        }
        spin_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.categorySelected(SpinnerOptions.CATEGORIES[position])
            }
        }
    }

    private fun configureEditTextListeners() {
        et_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.updateName(et_name.text.toString())
            }
        })
        et_description.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.updateDescription(et_description.text.toString())
            }
        })
    }

    private fun configureClickListener() {
        btn_save_app.setOnClickListener {
            presenter.saveApp()
        }
    }

    override fun showAppSaved() {
        Toast.makeText(this, getString(R.string.app_saved), Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun showAppSaveError() {
        Toast.makeText(this, getString(R.string.error_saving_app), Toast.LENGTH_SHORT).show()
    }

}


