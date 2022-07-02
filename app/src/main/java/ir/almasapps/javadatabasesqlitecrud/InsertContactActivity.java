package ir.almasapps.javadatabasesqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ir.almasapps.javadatabasesqlitecrud.Database.View.CreateView;

public class InsertContactActivity extends AppCompatActivity {

    EditText txtName,txtPhone,txtEmail;
    Button btnInsert;
    CreateView createView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_contact);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        btnInsert = findViewById(R.id.btnInsert);
        createView = new CreateView(this);

        btnInsert.setOnClickListener(
                v -> {
            createView.insertContact(txtName.getText().toString(),txtPhone.getText().toString(),txtEmail.getText().toString(),R.drawable.ic_baseline_account_circle_24);
            finish();
        });

    }
}