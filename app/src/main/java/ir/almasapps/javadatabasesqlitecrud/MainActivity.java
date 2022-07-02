package ir.almasapps.javadatabasesqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ir.almasapps.javadatabasesqlitecrud.Adapters.ListAdapter;
import ir.almasapps.javadatabasesqlitecrud.Database.View.CreateView;

public class MainActivity extends AppCompatActivity {

    CreateView createView;
    ListView listView;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.fab);
        listView = findViewById(R.id.list);
        createView = new CreateView(this);

        ListAdapter listAdapter = new ListAdapter(this,createView.getAllContacts());
        listView.setAdapter(listAdapter);


        btnAdd.setOnClickListener(v ->
                startActivity(new Intent(getBaseContext(),InsertContactActivity.class))
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListAdapter listAdapter = new ListAdapter(this,createView.getAllContacts());
        listView.setAdapter(listAdapter);
    }
}
