package ir.almasapps.javadatabasesqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ir.almasapps.javadatabasesqlitecrud.Database.Model.Contact;
import ir.almasapps.javadatabasesqlitecrud.Database.View.CreateView;

public class UpdateContactActivity extends AppCompatActivity {

    EditText txtName,txtPhone,txtEmail;
    Button btnUpdate,btnDelete;
    CreateView createView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        createView = new CreateView(this);
        int contactID = getIntent().getIntExtra("contactID",0);
        Contact contact = createView.getContactByID(contactID);

        txtName = findViewById(R.id.update_txtName);
        txtPhone = findViewById(R.id.update_txtPhone);
        txtEmail = findViewById(R.id.update_txtEmail);
        btnUpdate = findViewById(R.id.update_btnUpdate);
        btnDelete = findViewById(R.id.update_btnDelete);

        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        txtEmail.setText(contact.getEmail());


        btnUpdate.setOnClickListener(v -> {
            createView.updateContact(contactID,txtName.getText().toString(),txtPhone.getText().toString(),txtEmail.getText().toString(),R.drawable.ic_baseline_account_circle_24);
            finish();
        });

        btnDelete.setOnClickListener(v -> {
            createView.deleteContactByID(contactID);
            finish();
        });
    }
}