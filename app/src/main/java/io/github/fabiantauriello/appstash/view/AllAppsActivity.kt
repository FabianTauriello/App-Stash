package io.github.fabiantauriello.appstash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fabiantauriello.appstash.R
import io.github.fabiantauriello.appstash.presenter.AllAppsContract
import io.github.fabiantauriello.appstash.presenter.AllAppsPresenter
import kotlinx.android.synthetic.main.activity_all_apps.*

class AllAppsActivity : AppCompatActivity(), AllAppsContract.View {

    private val presenter = AllAppsPresenter()
    private val adapter = AppRecyclerViewAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_apps)

        presenter.setView(this)
        presenter.getAllApps().observe(this, Observer {apps ->
            apps.let {
                adapter.updateApps(apps)
            }
        })

        configureRecyclerView()
        configureClickListener()
    }

    private fun configureRecyclerView() {
        rv_all_apps.layoutManager = LinearLayoutManager(this)
        rv_all_apps.adapter = adapter
    }

    private fun configureClickListener() {
        btn_add_app.setOnClickListener {
            startActivity(Intent(this, AppActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu - this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_all -> {
                presenter.clearAllApps()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showAllAppsCleared() {
        Toast.makeText(this, getString(R.string.apps_cleared), Toast.LENGTH_SHORT).show()
    }
}
