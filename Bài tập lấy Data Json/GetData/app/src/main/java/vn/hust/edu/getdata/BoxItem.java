package vn.hust.edu.getdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BoxItem extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        String username = getIntent().getStringExtra("username");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String photo = getIntent().getStringExtra("photo");
        String street = getIntent().getStringExtra("street");
        String suite = getIntent().getStringExtra("suite");
        String city = getIntent().getStringExtra("city");
        String zipcode = getIntent().getStringExtra("zipcode");
        String lat = getIntent().getStringExtra("lat");
        String lng = getIntent().getStringExtra("lng");
        String phone = getIntent().getStringExtra("phone");
        String website = getIntent().getStringExtra("website");
        String companyName = getIntent().getStringExtra("companyName");
        String catchPhrase = getIntent().getStringExtra("catchPhrase");
        String bs = getIntent().getStringExtra("bs");

        TextView view_username = findViewById(R.id.usernameItem);
        view_username.setText(username);
        TextView view_name = findViewById(R.id.name);
        view_name.setText(name);
        TextView view_email = findViewById(R.id.emailItem);
        view_email.setText(email);

        TextView view_address = findViewById(R.id.address);
        String address = street +
                "-" + suite +
                "-" + city +
                "-" + zipcode +
                "\ngeo:  lat = " + lat + " ,  lng = " + lng;
        view_address.setText(address);
        TextView view_company = findViewById(R.id.company);
        String company = "Tên công ty: " + companyName + "\ncụm công ty: " + catchPhrase + "\nbs: " + bs;
        view_company.setText(company);
        TextView view_phone = findViewById(R.id.phone);
        view_phone.setText(phone);
        TextView view_website = findViewById(R.id.website);
        view_website.setText(website);

        ImageView img_photo = findViewById(R.id.photo);
        Picasso.with(this).load(photo).into(img_photo);

    }
}
