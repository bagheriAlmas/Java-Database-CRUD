package ir.almasapps.javadatabasesqlitecrud.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.almasapps.javadatabasesqlitecrud.Database.Model.Contact;
import ir.almasapps.javadatabasesqlitecrud.Database.View.CreateView;
import ir.almasapps.javadatabasesqlitecrud.R;
import ir.almasapps.javadatabasesqlitecrud.UpdateContactActivity;


/**
 * Created by Mahdi on 9/29/17.
 */

public class ListAdapter extends BaseAdapter{

    Context context;
    CreateView createView;
    List<Contact> list;




    public ListAdapter(Context context, List<Contact> list) {
        this.context = context;
        createView = new CreateView(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return createView.getAllContacts().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //list_item = inflater.inflate(R.layout.list_item, null);
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        TextView txtName= view.findViewById(R.id.list_item_txtName);
        TextView txtPhone= view.findViewById(R.id.list_item_txtPhone);
        TextView txtEmail= view.findViewById(R.id.list_item_txtEmail);
        ImageView img= view.findViewById(R.id.list_item_img);

        txtName.setText(list.get(position).getName());
        txtPhone.setText(list.get(position).getPhone());
        txtEmail.setText(list.get(position).getEmail());
        img.setImageResource(list.get(position).getImage());

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateContactActivity.class);
            intent.putExtra("contactID",list.get(position).getId());
            context.startActivity(intent);
        });




        return view;
    }

}