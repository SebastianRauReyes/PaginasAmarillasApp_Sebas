package com.sebastian.paginasamarillasapp_sebas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.sebastian.paginasamarillasapp_sebas.R;
import com.sebastian.paginasamarillasapp_sebas.adapter.CompanyAdapter;
import com.sebastian.paginasamarillasapp_sebas.model.Company;
import com.sebastian.paginasamarillasapp_sebas.repository.CompanyRepository;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private List<Company> companies = CompanyRepository.getCompanies();
    private RecyclerView recyclerView;
    private EditText editText;
    CompanyAdapter companyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Toast.makeText(this, "Query:"+this.getIntent().getExtras().get("query"), Toast.LENGTH_SHORT).show();

        editText = findViewById(R.id.BusquedaEditText);
        editText.setText(this.getIntent().getExtras().getString("query"));

        recyclerView = findViewById(R.id.recyclerView);

        companyAdapter = new CompanyAdapter();
        companyAdapter.setCompanies(CompanyRepository.getCompanies());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(companyAdapter);


        editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
        });
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    private void filter(String s) {
        ArrayList<Company> companie = new ArrayList<>();

        for (Company company : companies) {
            if (company.getName().toLowerCase().contains(s.toLowerCase())) {companie.add(company);}
        }

        companyAdapter.filterList(companie);
    }

}
