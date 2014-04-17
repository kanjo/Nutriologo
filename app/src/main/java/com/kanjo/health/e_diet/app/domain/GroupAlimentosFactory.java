package com.kanjo.health.e_diet.app.domain;

/**
 * Created by JARP on 4/10/14.
 */

import android.support.v4.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by JARP on 4/9/14.
 */

//TODO: Revisar como se quitan los typos
@SuppressWarnings("All")
public  class GroupAlimentosFactory {

    public GroupAlimentosFactory()
    {
        build();
    }

    public static GroupAlimentosFactory GRUPO_ALIMENTOS = new GroupAlimentosFactory();

    public  class GroupAlimento
    {
        public int quantity;
        public String description;
        //TODO:AGREGAR TYPE
    }

    public class GroupPlatillo extends GroupAlimento
    {

        public List<Platillo> listPlatillo;
    }

    public  class GroupAlimentoPorcion extends GroupAlimento
    {
        public List<AlimentoPorcion> listAlimentoPorcion;
    }

    public  class VERDURAS extends GroupAlimentoPorcion
    {

        public VERDURAS()
        {
            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildVerduras();

            description= "Verduras";
        }

    }

    public class FRUTAS extends GroupAlimentoPorcion
    {
        public FRUTAS() {

            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildFrutas();

            description = "Frutas";
        }



    }

    public class CerealesConGrasa extends GroupAlimentoPorcion
    {
        public CerealesConGrasa() {

            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildCerealesConGrasa();

            description = "Cereales con grasa";
        }

    }

    public  class CerealesSinGrasa extends GroupAlimentoPorcion {

        public CerealesSinGrasa() {

            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildCerealesSinGrasa();

            description = "Cereales sin grasa";
        }



    }

    public static class  Entradas {

        public int quantity;

        public final static List<AlimentoPorcion> LIST_ENTRADAS_DE_CARNES_FRIAS;
        public final static List<AlimentoPorcion> LIST_ENTRADAS_DE_CREMAS;
        public final static List<AlimentoPorcion> LIST_ENTRADAS_DE_LEGUMINOSAS;

        static
        {
            LIST_ENTRADAS_DE_CARNES_FRIAS = GRUPO_ALIMENTOS.buildEntradasDeCarnesFrias();
            LIST_ENTRADAS_DE_CREMAS = GRUPO_ALIMENTOS.buildEntradasDeCremas();
            LIST_ENTRADAS_DE_LEGUMINOSAS = GRUPO_ALIMENTOS.buildEntradasLeguminosas();

        }

    }

    public static class Omeletes
    {

        public int quantity;

        public final static List<Platillo> LIST_OMELETES;

        static {
            LIST_OMELETES = GRUPO_ALIMENTOS.buildOmeletes();
        }

    }

    public static class Ensaladas
    {

        public final static List<Platillo> LIST_ENSALADAS;

        public int quantity;

        static {
            LIST_ENSALADAS = GRUPO_ALIMENTOS.buildEnsaldas();
        }
    }

    public class POAMuyBajoAporteDeGrasa extends GroupAlimentoPorcion
    {

        public POAMuyBajoAporteDeGrasa() {

            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildPOABajoAporteGrasa();

            description = "POA muy bajo aporte de grasa";
        }

    }

    public class POABajoAporteGrasa extends GroupAlimentoPorcion
    {

            public POABajoAporteGrasa()
            {
                listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

                listAlimentoPorcion = GRUPO_ALIMENTOS.buildPOABajoAporteGrasa();

                description = "POA bajo aporte de grasa";
            }

    }


    public class Leche extends GroupAlimentoPorcion
    {
        public Leche()
        {
            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildLecheSemiDescremada();

            description = "Leche semidescremada";
        }

    }

    public class AceitesSinProteina extends GroupAlimentoPorcion
    {
        public AceitesSinProteina()
        {
            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildAceitesSinProteina();

            description = "Aceites sin proteína";
        }
    }

    public class AceitesConProteina extends GroupAlimentoPorcion
    {
        public AceitesConProteina()
        {
            listAlimentoPorcion = new ArrayList<AlimentoPorcion>();

            listAlimentoPorcion = GRUPO_ALIMENTOS.buildAceitesConProteina();

            description = "Aceites con proteína";
        }
    }

    public Map<String, List<AlimentoPorcion>> listGrupoAlimentos;

    public Map <String , List<AlimentoPorcion>> listEntradas;

    public Map <String , List<AlimentoPorcion>> listCereales ;

    public Map<String, List<Platillo>> mapOmeleteEnsalda;

    public Map<String, List<AlimentoPorcion>> mapPOA;

    public Map<String, List<AlimentoPorcion>> mapAceites;

    void build()
    {
        listGrupoAlimentos= new ArrayMap<String, List<AlimentoPorcion>>();
        listGrupoAlimentos.put("Verduras",buildVerduras());
        listGrupoAlimentos.put("Frutas",buildFrutas());
        listGrupoAlimentos.put("Leche",buildLecheSemiDescremada());
        listGrupoAlimentos.put("Nutrición Ortemolecular ", buildNutricionOrtemolecularOmega3());

        listCereales= new ArrayMap<String, List<AlimentoPorcion>>();
        listCereales.put("Cereales",buildCerealesSinGrasa());
        listCereales.put("Cereales con Grasa",buildCerealesConGrasa());

        listEntradas  = new ArrayMap<String, List<AlimentoPorcion>>();
        listEntradas.put("Entrada de Leguminosas",buildEntradasLeguminosas());
        listEntradas.put("Entrada de Cremas",buildEntradasDeCremas());
        listEntradas.put("Entrada de carnes frías",buildEntradasDeCarnesFrias());

        mapOmeleteEnsalda = new ArrayMap<String, List<Platillo>>();
        mapOmeleteEnsalda.put("Omeletes",buildOmeletes());
        mapOmeleteEnsalda.put("Ensaladas",buildEnsaldas());

        mapPOA = new ArrayMap<String, List<AlimentoPorcion>>();
        mapPOA.put("Muy Bajo Aporte de Grasa",buildPOAMuyBajoAporteGrasa());
        mapPOA.put("Bajo Aporte de Grasa",buildPOABajoAporteGrasa());

        mapAceites = new ArrayMap<String, List<AlimentoPorcion>>();
        mapAceites.put("Aceites con Proteínas",buildAceitesConProteina());
        mapAceites.put("Aceites sin Proteínas",buildAceitesSinProteina());





    }

    public List<AlimentoPorcion> buildVerduras()
    {
        List<AlimentoPorcion> verduras = new ArrayList<AlimentoPorcion>();
        verduras.add(new AlimentoPorcion("Acelga", TipoMedida.TAZA, 1000));
        verduras.add(new AlimentoPorcion("Brocoli",TipoMedida.TAZA,1000));
        verduras.add(new AlimentoPorcion("Calabaza",TipoMedida.TAZA,500));
        verduras.add(new AlimentoPorcion("Calabazita Cruda",TipoMedida.TAZA,1000));
        return  verduras;

    }

    private List<AlimentoPorcion> buildFrutas()
    {
        List<AlimentoPorcion> frutas = new ArrayList<AlimentoPorcion>();
        frutas.add(new AlimentoPorcion("Arándanos", TipoMedida.PIEZAS, 10000));
        frutas.add(new AlimentoPorcion("Carambolo", TipoMedida.PIEZA, 1000));
        frutas.add(new AlimentoPorcion("Chabacano", TipoMedida.PIEZAS, 4000));
        frutas.add(new AlimentoPorcion("Ciruela", TipoMedida.PIEZAS, 3000));
        return  frutas;

    }

    private List<AlimentoPorcion> buildCerealesSinGrasa()
    {
        List<AlimentoPorcion> cereales = new ArrayList<AlimentoPorcion>();
        cereales.add(new AlimentoPorcion("All Bran", TipoMedida.TAZA, 10000));
        cereales.add(new AlimentoPorcion("Amaranto", TipoMedida.TAZA, 250));
        cereales.add(new AlimentoPorcion("Arroz guisado", TipoMedida.TAZA, 1000));
        cereales.add(new AlimentoPorcion("Avena Integral", TipoMedida.TAZA, 500));
        return  cereales;

    }

    private List<AlimentoPorcion> buildCerealesConGrasa()
    {
        List<AlimentoPorcion> cereales = new ArrayList<AlimentoPorcion>();
        cereales.add(new AlimentoPorcion("Bisquet Integral", TipoMedida.PIEZA, 500));
        cereales.add(new AlimentoPorcion("Cocol chico integral", TipoMedida.PIEZA, 1000));
        cereales.add(new AlimentoPorcion("Concha chica", TipoMedida.PIEZA, 1000));
        cereales.add(new AlimentoPorcion("Concha integral", TipoMedida.PIEZA, 500));
        return  cereales;

    }

    private List<AlimentoPorcion> buildEntradasLeguminosas()
    {


        List<AlimentoPorcion> entradaLeguminosas = new ArrayList<AlimentoPorcion>();
        entradaLeguminosas.add(new AlimentoPorcion("Frijoles Charros", TipoMedida.TAZA, 500));
        entradaLeguminosas.add(new AlimentoPorcion("Frijoles de la olla o refritos", TipoMedida.TAZA, 500));
        entradaLeguminosas.add(new AlimentoPorcion("Sopa de frijoles", TipoMedida.TAZA, 1000));
        entradaLeguminosas.add(new AlimentoPorcion("Sopa o caldo de garbanzos", TipoMedida.TAZA, 1000));
        return  entradaLeguminosas;

    }

    private List<AlimentoPorcion> buildEntradasDeCremas()
    {
        List<AlimentoPorcion> entradaDeCremas = new ArrayList<AlimentoPorcion>();
        entradaDeCremas.add(new AlimentoPorcion("Crema de calabaza", TipoMedida.TAZA, 1000));
        entradaDeCremas.add(new AlimentoPorcion("Crema de chile poblano", TipoMedida.TAZA, 1000));
        entradaDeCremas.add(new AlimentoPorcion("Crema de cilantro", TipoMedida.TAZA, 1000));
        entradaDeCremas.add(new AlimentoPorcion("Crema de elote", TipoMedida.TAZA, 1000));
        return  entradaDeCremas;

    }

    private List<AlimentoPorcion> buildEntradasDeCarnesFrias()
    {

        List<AlimentoPorcion> entradaDeCarnesFrias = new ArrayList<AlimentoPorcion>();
        entradaDeCarnesFrias.add(new AlimentoPorcion("Rollos de jamón de pavo rellenos de queso panela", TipoMedida.PIEZAS, 2000));
        entradaDeCarnesFrias.add(new AlimentoPorcion("Rollos de jamón rellenos de atún en agua", TipoMedida.PIEZA, 2000));
        entradaDeCarnesFrias.add(new AlimentoPorcion("Salchicha con queso panela", TipoMedida.TAZA, 500));
        entradaDeCarnesFrias.add(new AlimentoPorcion("Crema de elote", TipoMedida.TAZA, 1000));
        return  entradaDeCarnesFrias;


    }

    private List<Platillo> buildOmeletes()
    {

        List<Platillo> mOmeletes = new ArrayList<Platillo>();

        StringBuilder recetaBuilder = new StringBuilder();

        recetaBuilder.append("Dos claras de huevo rellenas de jamón de pavo ");
        recetaBuilder.append("y queso panela acompañados de jitomate y aguacate ");

        mOmeletes.add(new Platillo("Omelette de Pavo", recetaBuilder.toString()));

        recetaBuilder.setLength(0);

        recetaBuilder.append("Dos claras de huevo ");
        recetaBuilder.append("acompañados de jitomate y aguacate ");
        mOmeletes.add(new Platillo("Claras de huevo ", recetaBuilder.toString()));


        return mOmeletes;


    }

    private List<Platillo> buildEnsaldas()
    {


        List<Platillo> mEnsaldas= new ArrayList<Platillo>();

        StringBuilder recetaBuilder = new StringBuilder();

        recetaBuilder.append("Queso de cabra, aceituna negra, pimiento  ");
        recetaBuilder.append("ejote, champiñones,  ");
        recetaBuilder.append("con mezcla de lechugas y ");
        recetaBuilder.append("vinagre balsámico ");

        mEnsaldas.add(new Platillo("Genovesa", recetaBuilder.toString()));

        recetaBuilder.setLength(0);

        recetaBuilder.append("Variedad de Lechugas, 1/2 pza de aguacate ");
        recetaBuilder.append("tiras de tortilla, chile ancho frito, y pechuga de pollo ");
        recetaBuilder.append("adobada aderezar con vinagreta ");
        mEnsaldas.add(new Platillo("Mexicana", recetaBuilder.toString()));


        return mEnsaldas;
    }


    private List<AlimentoPorcion> buildPOAMuyBajoAporteGrasa()
    {

        List<AlimentoPorcion> poaConMuyBajoAporteGrasa = new ArrayList<AlimentoPorcion>();
        poaConMuyBajoAporteGrasa.add(new AlimentoPorcion("Albóndiga mediana de Pollo o res en caldillo", TipoMedida.PIEZA, 1000));
        poaConMuyBajoAporteGrasa.add(new AlimentoPorcion("Atún empecado en agua o aceite", TipoMedida.LATA, 1000));
        poaConMuyBajoAporteGrasa.add(new AlimentoPorcion("Bistec de pollo o de res empanizados", TipoMedida.PIEZA, 500));
        poaConMuyBajoAporteGrasa.add(new AlimentoPorcion("Calamar", TipoMedida.PIEZA, 1000));
        return  poaConMuyBajoAporteGrasa;
    }


    private List<AlimentoPorcion> buildPOABajoAporteGrasa()
    {
        List<AlimentoPorcion> poaBajoAporteGrasa = new ArrayList<AlimentoPorcion>();
        poaBajoAporteGrasa.add(new AlimentoPorcion("Albóndiga mediana de Pollo o res en caldillo", TipoMedida.PIEZA, 1000));
        poaBajoAporteGrasa.add(new AlimentoPorcion("Atún empecado en agua o aceite", TipoMedida.LATA, 1000));
        poaBajoAporteGrasa.add(new AlimentoPorcion("Bistec de pollo o de res empanizados", TipoMedida.PIEZA, 500));
        poaBajoAporteGrasa.add(new AlimentoPorcion("Calamar", TipoMedida.PIEZA, 1000));
        return  poaBajoAporteGrasa;

    }

    private List<AlimentoPorcion> buildLecheSemiDescremada()
    {
        List<AlimentoPorcion> lecheSemiDescremada = new ArrayList<AlimentoPorcion>();
        lecheSemiDescremada.add(new AlimentoPorcion("Leche Alpura light deslactosada", TipoMedida.TAZA, 1000));
        lecheSemiDescremada.add(new AlimentoPorcion("Leche de soya ADES natural", TipoMedida.TAZA, 1000));
        lecheSemiDescremada.add(new AlimentoPorcion("Leche Lala light deslactosada", TipoMedida.TAZA, 1000));
        lecheSemiDescremada.add(new AlimentoPorcion("Leche Semidescremada", TipoMedida.TAZA, 1000));
        return  lecheSemiDescremada;
    }

    private List<AlimentoPorcion> buildAceitesSinProteina()
    {

        List<AlimentoPorcion> aceitesSinProteina = new ArrayList<AlimentoPorcion>();
        aceitesSinProteina.add(new AlimentoPorcion("Aceite de canela capullo", TipoMedida.SUFLETA, 1000));
        aceitesSinProteina.add(new AlimentoPorcion("Aceite de oliva aderezar", TipoMedida.SUFLETA, 1000));
        aceitesSinProteina.add(new AlimentoPorcion("Aceite oléico cocina", TipoMedida.SUFLETA, 1000));
        aceitesSinProteina.add(new AlimentoPorcion("Aguate chico", TipoMedida.PIEZA, 500));
        return  aceitesSinProteina;
    }

    private List<AlimentoPorcion> buildAceitesConProteina()
    {
        List<AlimentoPorcion> aceiteConProteina = new ArrayList<AlimentoPorcion>();
        aceiteConProteina.add(new AlimentoPorcion("Almedras", TipoMedida.PIEZAS, 5000));
        aceiteConProteina.add(new AlimentoPorcion("Arándanos secos", TipoMedida.SUFLETA, 2000));
        aceiteConProteina.add(new AlimentoPorcion("Cacahuate", TipoMedida.SUFLETA, 2000));
        aceiteConProteina.add(new AlimentoPorcion("Crema de cacahuate", TipoMedida.CUCHARADAS, 2000));
        return  aceiteConProteina;

    }

    private List<AlimentoPorcion> buildNutricionOrtemolecularOmega3()
    {
        //TODO:CAMBIAR YA QUE SÓLO LLEVA UN ELEMENTO POR LO PRONTO SE QUEDA ASI
        List<AlimentoPorcion> aceiteConProteina = new ArrayList<AlimentoPorcion>();
        aceiteConProteina.add(new AlimentoPorcion("Almedras", TipoMedida.PIEZAS, 5000));
        aceiteConProteina.add(new AlimentoPorcion("Arándanos secos", TipoMedida.SUFLETA, 2000));
        aceiteConProteina.add(new AlimentoPorcion("Cacahuate", TipoMedida.SUFLETA, 2000));
        aceiteConProteina.add(new AlimentoPorcion("Crema de cacahuate", TipoMedida.CUCHARADAS, 2000));
        return  aceiteConProteina;
    }



    public class Platillo
    {

        public Platillo(String descripcion, String receta)
        {
            this.descripcion=descripcion;
            this.receta=receta;
        }


        public String descripcion;
        public String receta;
    }

    public class AlimentoPorcion
    {

        public AlimentoPorcion(String descripcion,String medida, int porcion)
        {
            this.descripcion=descripcion;
            this.tipoMedida=medida;
            this.porcion = porcion;

        }
        String descripcion;

        //La porcion se va a manejar como
        //una unidad de 1000 ejemplos :
        // una 1 taza = 1000 , 2 piezas = 2000,
        // 3/4 taza = 750 etc...

        int porcion;
        String tipoMedida;


    }

    @SuppressWarnings("ALL")
    public static class TipoMedida
    {
        public static final String PIEZA ="pza.";
        public static final String PIEZAS ="pzas.";
        public static final String REBANADA = "reb.";
        public static final String REBANADAS = "rebs.";
        public static final String TAZA = "taza.";
        public static final String TAZAS = "tazas.";
        public static final String LATA = "tazas.";
        public static final String LATAS = "lazas.";
        public static final String SUFLETA = "sufleta.";
        public static final String CUCHARADA = "cucharada.";
        public static final String CUCHARADAS = "cucharadas.";

    }
}
