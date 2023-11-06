package com.chunkingz.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.chunkingz.tablelayouttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val androidVersions = listOf(
            Pair("Android 9.0", "Pie"),
            Pair("Android 10.0", "Q"),
            Pair("Android 11.0", "R")
        )

        addStaticRows(binding.table1, androidVersions)

        binding.addBtn.setOnClickListener {
            val version = binding.androidVersion.text.toString()
            val codeName = binding.androidCodeName.text.toString()
            addTableRow(binding.table1, version, codeName)
        }
    }

    private fun addTableRow(tableLayout: TableLayout, version: String, codeName: String) {
        val newRow = createRowWithTwoColumns(version, codeName)
        tableLayout.addView(newRow)
    }

    private fun addStaticRows(tableLayout: TableLayout, items: List<Pair<String, String>>) {
        for (item in items) {
            val newRow = createRowWithTwoColumns(item.first, item.second)
            tableLayout.addView(newRow)
        }
    }

    private fun createRowWithTwoColumns(column1Text: String, column2Text: String): TableRow {
        val newRow = TableRow(this)
        val column1 = TextView(this)
        val column2 = TextView(this)
        column1.text = column1Text
        column2.text = column2Text
        newRow.addView(column1)
        newRow.addView(column2)
        return newRow
    }
}

