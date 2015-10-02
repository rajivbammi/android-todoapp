package com.example.rbammi.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText txtEdit;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemName = getIntent().getStringExtra("itemName");
        int itemIndex = getIntent().getIntExtra("itemPosition", 0);

        txtEdit = (EditText) findViewById(R.id.txtEdit);
        txtEdit.setText(itemName);
        txtEdit.setSelection(itemName.length());

        itemPosition = itemIndex;
    }

    public void editButtonClicked(View view) {
        Intent dataIntent = new Intent();
        String itemText = txtEdit.getText().toString();

        dataIntent.putExtra("itemText", itemText);
        dataIntent.putExtra("itemPosition", itemPosition);
        setResult(RESULT_OK, dataIntent);
        finish();
    }
}
