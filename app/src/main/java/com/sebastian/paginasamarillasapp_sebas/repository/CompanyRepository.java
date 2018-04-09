package com.sebastian.paginasamarillasapp_sebas.repository;

import com.sebastian.paginasamarillasapp_sebas.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static List<Company> companies = new ArrayList<>();

    static {
        companies.add( new Company("100", "Restaurant","McDonald's",
                "http://www.mcdonalds.com.pe/", "936988972", "mcdonalds@gmail.com", "img_mcdonald",
                "McDonald's es una cadena de restaurantes de comida rápida. Sus principales productos son las hamburguesas, las papas fritas, los menús para el desayuno, los refrescos, los batidos, los helados, los postres y, recientemente, las ensaladas de fruta y otros productos exclusivos para diversos países. Atiende aproximadamente a 68 millones de clientes por día, en más de 36 000 establecimientos, en 119 territorios y países alrededor del mundo. La cadena empleó a 1,7 millones de personas. En la mayoría de los restaurantes se han incluido distintas áreas con juegos para niños."));

        companies.add( new Company("200", "Restaurant","Burger King",
                "http://www.burgerking.com.pe/", "5050000", "BURGERKING@gmail.com", "img_bk",
                "Fue fundada el 4 de diciembre de 1954 en Miami, cuando dos jóvenes emprendedores llamados James McLamore y David Egerton inauguraron este restaurante basado en un concepto diferente al que existía y que se ha mantenido hasta hoy: «The Home of The Whopper». En 1955 'el producto rey' fue incorporado como la imagen de la marca y ha perdurado como referencia: la Whopper, el producto principal de Burger King. En 1958 se lanzó el primer anuncio de televisión en Miami, lo que dio pie a una campaña televisiva de más de 50 años. En 1959 la marca comenzó su expansión por medio de franquicias, extendiendo sus operaciones por todo Estados Unidos y después a nivel mundial."));

        companies.add( new Company("300", "Restaurant","Pizza Hut",
                "https://www.pizzahut.com.pe/Online/Home/Home", "5051111", "PizzaHut@gmail.com", "img_pizzahut",
                "La historia de Pizza Hut comenzó en 1958, cuando dos estudiantes de Wichita (Kansas), los hermanos Dan y Frank Carney, montaron su propio restaurante. Se decidieron por una pizzería gracias al consejo de un amigo. Para ponerlo en marcha pidieron prestado a su madre 600 dólares, con los que comprarían el material, y se aliaron con un socio capitalista, John Bender.El local se abrió el 15 de junio de ese mismo año con el nombre actual, inspirado en su primer establecimiento, que en español significa «La choza de las pizzas»."));

        companies.add( new Company("400", "Restaurant","Kentucky Fried Chicken",
                "https://www.kfc.com.pe/", "5050505", "kfc@gmail.com", "img_kfc",
                "Kentucky Fried Chicken (traducible al español como Pollo frito de Kentucky), más conocido por sus siglas KFC, es una franquicia de restaurantes de comida rápida especializada en pollo frito, que pertenece al grupo Yum! Brands. Cuenta con más de 18 000 restaurantes en 120 países y se encuentra en la segunda posición a nivel de negocios, por detrás de McDonalds (según datos de Forbes, de abril de 2013)."));

        companies.add( new Company("500", "Restaurant","Bembos",
                "http://www.bembos.com.pe/", "4191919", "Bembos@gmail.com", "img_bembos",
                "Bembos es una empresa peruana de comida rápida, dedicada principalmente al mercado del consumo de hamburguesas. Sus colores tradicionales son el rojo, azul y amarillo. Abre sus puertas el 11 de junio de 1988, con un pequeño restaurante en pleno corazón de Miraflores. Fue tanta la acogida que tuvieron que en 1990 abrir una sucursal en la vecina San Isidro. A pesar de la llegada de transnacionales importantes como McDonald's (1996) y Burger King (1993), el público peruano aún siente predilección por ir a comer a Bembos."));

        /*companies.add( new Company("600", "Restaurant F","SuperF",
                "Direccion 6", "6666666", "email6@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("700", "Restaurant G","SuperG",
                "Direccion 7", "7777777", "email7@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("800", "Restaurant H","SuperH",
                "Direccion 8", "8888888", "email8@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("900", "Restaurant I","SuperI",
                "Direccion 9", "9999999", "email9@gmail.com", "img_logo1", "Buen lugar"));

        companies.add( new Company("1000", "Restaurant J","SuperJ",
                "Direccion 10", "10101010", "email10@gmail.com", "img_logo1", "Buen lugar"));*/

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    public  static List<Company> getCompanies(){
        return companies;
    }

}
