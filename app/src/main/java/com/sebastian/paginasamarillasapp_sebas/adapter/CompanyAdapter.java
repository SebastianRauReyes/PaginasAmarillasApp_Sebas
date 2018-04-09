package com.sebastian.paginasamarillasapp_sebas.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.paginasamarillasapp_sebas.R;
import com.sebastian.paginasamarillasapp_sebas.activity.DetailActivity;
import com.sebastian.paginasamarillasapp_sebas.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<Company> companies;


    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView logo_text;
        TextView id_text;
        TextView name_text;
        TextView category_text;
        TextView address_text;
        TextView phone_text;
        TextView email_text;
        TextView info_text;



        public ViewHolder(View itemView) {
            super(itemView);

            logo_text = itemView.findViewById(R.id.picture_image);

            name_text = itemView.findViewById(R.id.name_text);
            category_text = itemView.findViewById(R.id.category_text);
            address_text= itemView.findViewById(R.id.address_text);
            phone_text= itemView.findViewById(R.id.phone_text);
            email_text= itemView.findViewById(R.id.email_text);



        }    }




    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Company company = companies.get(position);

        int resId = holder.itemView.getContext().getResources().getIdentifier(company.getLogo(), "drawable", holder.itemView.getContext().getPackageName());

        holder.logo_text.setImageResource(resId);

        //holder.id_text.setText(company.getId());
        holder.name_text.setText(company.getName());
        holder.category_text.setText(company.getCategory());
        holder.address_text.setText(company.getAddress());
        holder.phone_text.setText(company.getPhone());
        holder.email_text.setText(company.getEmail());
       // holder.info_text.setText(company.getInfo());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Seleccionado: " + company.getName(), Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);

                intent.putExtra("address",company.getAddress());
                intent.putExtra("name",company.getName());
                intent.putExtra("phone",company.getPhone());
                intent.putExtra("email",company.getEmail());

                holder.itemView.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {

        return companies.size();
    }

    public void filterList(ArrayList<Company> filteredList) {
        companies = filteredList;
        notifyDataSetChanged();
    }

}
