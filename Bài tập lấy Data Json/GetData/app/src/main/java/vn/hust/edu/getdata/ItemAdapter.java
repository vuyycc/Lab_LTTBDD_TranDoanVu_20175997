package vn.hust.edu.getdata;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    JSONArray jsonArrayData;
    Context contextData;


    public ItemAdapter(Context context, JSONArray jsonArrayData) {
        this.jsonArrayData = jsonArrayData;
        this.contextData = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArrayData.getJSONObject(position);
            String username = jsonObject.getString("username");
            holder.username.setText(username);
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            holder.email.setText(email);
            JSONObject avatar = jsonObject.getJSONObject("avatar");
            String thumbnail = "https://lebavui.github.io" + avatar.getString("thumbnail");
            String photo = "https://lebavui.github.io" + avatar.getString("photo");
            JSONObject address = jsonObject.getJSONObject("address");
            String street = address.getString("street");
            String suite = address.getString("suite");
            String city = address.getString("city");
            String zipcode = address.getString("zipcode");
            JSONObject geo = address.getJSONObject("geo");
            String lat = geo.getString("lat");
            String lng = geo.getString("lng");
            String phone = jsonObject.getString("phone");
            String website = jsonObject.getString("website");
            JSONObject company = jsonObject.getJSONObject("company");
            String companyName = company.getString("name");
            String catchPhrase = company.getString("catchPhrase");
            String bs = company.getString("bs");

            Log.v("TAG", "thumbnail is " + thumbnail);
            Picasso.with(contextData).load(thumbnail).into(holder.icon);

            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(contextData, BoxItem.class);
                    intent.putExtra("username", username);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("photo", photo);
                    intent.putExtra("street", street);
                    intent.putExtra("suite", suite);
                    intent.putExtra("city", city);
                    intent.putExtra("zipcode", zipcode);
                    intent.putExtra("lat", lat);
                    intent.putExtra("lng", lng);
                    intent.putExtra("phone", phone);
                    intent.putExtra("website", website);
                    intent.putExtra("companyName", companyName);
                    intent.putExtra("catchPhrase", catchPhrase);
                    intent.putExtra("bs", bs);

                    contextData.startActivity(intent);
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArrayData.length();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView email;
        ImageView icon;
        ConstraintLayout layout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            icon = itemView.findViewById(R.id.icon);
            layout = itemView.findViewById(R.id.parent);
        }
    }
}
