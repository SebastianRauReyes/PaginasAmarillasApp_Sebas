package com.sebastian.paginasamarillasapp_sebas.repository;

import com.sebastian.paginasamarillasapp_sebas.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static List<Company> companies = new ArrayList<>();

    static {
        companies.add( new Company("100", "Restaurant A","SuperA",
                "https://www.google.com.pe/", "950286279", "email1@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("200", "Restaurant B","SuperB",
                "Direccion 2", "2222222", "email2@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("300", "Restaurant C","SuperC",
                "Direccion 3", "33333333", "email3@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("400", "Restaurant D","SuperD",
                "Direccion 4", "44444444", "email4@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("500", "Restaurant E","SuperE",
                "Direccion 5", "55555555", "email5@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("600", "Restaurant F","SuperF",
                "Direccion 6", "6666666", "email6@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("700", "Restaurant G","SuperG",
                "Direccion 7", "7777777", "email7@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("800", "Restaurant H","SuperH",
                "Direccion 8", "8888888", "email8@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("900", "Restaurant I","SuperI",
                "Direccion 9", "9999999", "email9@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("1000", "Restaurant J","SuperJ",
                "Direccion 10", "10101010", "email10@gmail.com", "img_logo1", "Buen lugar"));

    }

    public  static List<Company> getCompanies(){

        return companies;
    }


}
