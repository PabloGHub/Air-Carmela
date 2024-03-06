import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ApoyoPuntoVenta {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> ListaMeses = new ArrayList<>();
    static HashMap<String, String> Meses = new HashMap<>();
    HashMap<String, String> CiudadCodigo = new HashMap<>();
    void insert()
    {
        CiudadCodigo.put("Barajas", "MAD");
        CiudadCodigo.put("El Prat", "BCN");
        CiudadCodigo.put("Alvedro", "LCG");
        CiudadCodigo.put("Ranón", "OVD");
        CiudadCodigo.put("Santiago del Monte", "OVD");
        CiudadCodigo.put("Los LLanos", "ABC");
        CiudadCodigo.put("El Altet", "ALC");
        CiudadCodigo.put("El Alquián", "LEI");
        CiudadCodigo.put("Costacabana", "LEI");
        CiudadCodigo.put("Badajoz", "BJZ");
        CiudadCodigo.put("Loiu", "BIO");
        CiudadCodigo.put("Villafría", "RGS");
        CiudadCodigo.put("Córdoba", "ODB");
        CiudadCodigo.put("Chauchina", "GRX");
        CiudadCodigo.put("Santa Fe", "GRX");
        CiudadCodigo.put("Gerona", "GRO");
        CiudadCodigo.put("Gando", "LPA");
        CiudadCodigo.put("Puerto del Rosario", "FUE");
        CiudadCodigo.put("El Matorral", "FUE");
        CiudadCodigo.put("Monflorite", "HSK");
        CiudadCodigo.put("Es Codolar", "IBZ");
        CiudadCodigo.put("La Parra", "XRY");
        CiudadCodigo.put("Virgen del Camino", "LEN");
        CiudadCodigo.put("Agoncillo", "RJL");
        CiudadCodigo.put("Cuatro Vientos", "MCV");
        CiudadCodigo.put("Pablo Picasso", "AGP");
        CiudadCodigo.put("Melilla", "MLN");
        CiudadCodigo.put("Mahón", "MAH");
        CiudadCodigo.put("Corvera", "RMU");
        CiudadCodigo.put("Son San Juan", "PMI");
        CiudadCodigo.put("Noáin", "PNA");
        CiudadCodigo.put("Reus", "REU");
        CiudadCodigo.put("Sabadell", "QSA");
        CiudadCodigo.put("Matacán", "SLM");
        CiudadCodigo.put("Fuenterrabía", "EAS");
        CiudadCodigo.put("Lavacolla", "SCQ");
        CiudadCodigo.put("San Pablo", "SVQ");
        CiudadCodigo.put("Parayas", "SDR");
        CiudadCodigo.put("Son Bonet", "SBO");
        CiudadCodigo.put("Los Rodeos", "TFN");
        CiudadCodigo.put("Reina Sofía", "TFS");
        CiudadCodigo.put("Mazo", "SPC");
        CiudadCodigo.put("La Gomera", "GMZ");
        CiudadCodigo.put("Los Cangrejos", "VDE");
        CiudadCodigo.put("Manises", "VLC");
        CiudadCodigo.put("Villanubla", "VLL");
        CiudadCodigo.put("Peinador", "VGO");
        CiudadCodigo.put("Foronda", "VIT");
        CiudadCodigo.put("Zaragoza", "ZAZ");
        CiudadCodigo.put("Montferrer Castellbó", "LEU");
        CiudadCodigo.put("Benlloch", "CDT");
        CiudadCodigo.put("Cañada de Calatrava", "CQM");
        CiudadCodigo.put("Alguaire", "ILD");
        CiudadCodigo.put("Teruel", "TEV");
    }
    public void Opcion1(String[] args){
        if (args.length < 3) {
            System.out.println("Debe proporcionar día, mes y año como argumentos de ejecución.");
            return;
        }

        int dia = Integer.parseInt(args[0]);
        int mes = Integer.parseInt(args[1]);
        int año = Integer.parseInt(args[2]);

        System.out.println("\nSe ha recibido como parámetro de ejecución");
        System.out.println("Día: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Año: " + año);

        System.out.println("El resultado solicitado de la misma es: " + transformarFecha(dia, mes, año) + "\n");
    }
        //Creamos Lista de Meses
        public static String transformarFecha(int dia, int mes, int año) {
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

            String mesString = meses[mes - 1];

            String fechaFormateada = dia + "-" + mesString + "-" + año;

            return fechaFormateada;
        }

    public void Opcion2(){

        System.out.println("Ingrese la hora de despegue en formato HH:mm ");
        String horaDespegueStr = scanner.nextLine();


        LocalTime horaDespegue = LocalTime.parse(horaDespegueStr, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.println("Ingrese la duración en minutos del trayecto:");
        int duracionMinutos = scanner.nextInt();

        LocalTime horaLlegada = horaDespegue.plusMinutes(duracionMinutos);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaLlegadaFormateada = horaLlegada.format(formatter);


        System.out.println("Hora de despegue: " + horaDespegueStr);
        System.out.println("Hora de llegada: " + horaLlegadaFormateada + "\n");}
    public void Opcion3(){
            ListaMeses.add("");
            ListaMeses.add("Enero");
            ListaMeses.add("Febrero");
            ListaMeses.add("Marzo");
            ListaMeses.add("Abril");
            ListaMeses.add("Mayo");
            ListaMeses.add("Junio");
            ListaMeses.add("Julio");
            ListaMeses.add("Agosto");
            ListaMeses.add("Septiembre");
            ListaMeses.add("Octubre");
            ListaMeses.add("Noviembre");
            ListaMeses.add("Diciembre");
            ListaMeses.add("Enero");
            ListaMeses.add("Febrero");
            ListaMeses.add("Marzo");
            ListaMeses.add("Abril");
            ListaMeses.add("Mayo");
            ListaMeses.add("Junio");
            ListaMeses.add("Julio");
            ListaMeses.add("Agosto");
            ListaMeses.add("Septiembre");
            ListaMeses.add("Octubre");
            ListaMeses.add("Noviembre");
            ListaMeses.add("Diciembre");

            System.out.println("Ingresa: ");
            Integer ob = scanner.nextInt();
            for (Integer i=0 ; i < 12; i ++  )
                System.out.println(ListaMeses.get(ob+i));
    }
    public String Opcion4(String Mes, Year Anyo){
        Meses.put("Enero", "31");
        Meses.put("Febrero", "28");
        Meses.put("Marzo", "31");
        Meses.put("Abril", "30");
        Meses.put("Mayo", "31");
        Meses.put("Junio", "30");
        Meses.put("Julio", "31");
        Meses.put("Agosto", "31");
        Meses.put("Septiembre", "30");
        Meses.put("Octubre", "31");
        Meses.put("Noviembre", "30");
        Meses.put("Diciembre", "31");
        System.out.print("Introduce el nombre del mes: ");
        Year AnyoActual = Anyo;
        String ComprobarCorrecto = Meses.get(Mes);
        if (ComprobarCorrecto != null) {
            if (AnyoActual.isLeap()) {
                // BISIESTO
                Meses.put("Febrero", "29");
                String DiasMes = Meses.get(Mes);
                System.out.println("El mes buscado es: " + Mes + " y este tiene " + DiasMes + " Días \n");
            } else {
                // AÑO NORMAL
                String DiasMes = Meses.get(Mes);
                System.out.println("El mes buscado es: " + Mes + " y este tiene " + DiasMes + " Días \n");
            }
        }else{
            System.out.print("El valor introducido no existe, intoduzca un mes real.");
            System.out.print("Asegúrese de que está escribiendo el nombre del mes correctamente");
        }
        return Meses.get(Mes);
    }
    public ArrayList<ArrayList<String>> Opcion5(String Origen, String Destino){
        insert();

        // -----------------------------------------------

        HashMap<String, ArrayList<String>[]> DiccionarioArrayLists = new HashMap<>();
        ArrayList<String> Benlloch = new ArrayList<>();
        Benlloch.add("CDT");
        Benlloch.add("07:00");
        Benlloch.add("08:20");
        Benlloch.add("80");

        ArrayList<String> Teruel = new ArrayList<>();
        Teruel.add("TEV");
        Teruel.add("08:00");
        Teruel.add("09:30");
        Teruel.add("90");

        ArrayList<String> Alguaire = new ArrayList<>();
        Alguaire.add("ILD");
        Alguaire.add("11:00");
        Alguaire.add("12:40");
        Alguaire.add("100");

        ArrayList<String> Barajas = new ArrayList<>();
        Barajas.add("MAD");
        Barajas.add("11:00");
        Barajas.add("12:40");
        Barajas.add("100");

        ArrayList<String> ElPrat = new ArrayList<>();
        ElPrat.add("BCN");
        ElPrat.add("11:00");
        ElPrat.add("12:40");
        ElPrat.add("100");

        ArrayList<String> Alvedro = new ArrayList<>();
        Alvedro.add("LCG");
        Alvedro.add("11:00");
        Alvedro.add("12:40");
        Alvedro.add("100");

        ArrayList<String> Ranon = new ArrayList<>();
        Ranon.add("OVD");
        Ranon.add("11:00");
        Ranon.add("12:40");
        Ranon.add("100");

        ArrayList<String> SantiagoDelMonte = new ArrayList<>();
        SantiagoDelMonte.add("OVD");
        SantiagoDelMonte.add("11:00");
        SantiagoDelMonte.add("12:40");
        SantiagoDelMonte.add("100");

        ArrayList<String> LosLlanos = new ArrayList<>();
        LosLlanos.add("ABC");
        LosLlanos.add("11:00");
        LosLlanos.add("12:40");
        LosLlanos.add("100");

        ArrayList<String> ElAltet = new ArrayList<>();
        ElAltet.add("ALC");
        ElAltet.add("11:00");
        ElAltet.add("12:40");
        ElAltet.add("100");

        ArrayList<String> ElAlquian = new ArrayList<>();
        ElAlquian.add("LEI");
        ElAlquian.add("11:00");
        ElAlquian.add("12:40");
        ElAlquian.add("100");

        ArrayList<String> Costacabana = new ArrayList<>();
        Costacabana.add("LEI");
        Costacabana.add("11:00");
        Costacabana.add("12:40");
        Costacabana.add("100");

        ArrayList<String> Badajoz = new ArrayList<>();
        Badajoz.add("BJZ");
        Badajoz.add("11:00");
        Badajoz.add("12:40");
        Badajoz.add("100");

        ArrayList<String> Loiu = new ArrayList<>();
        Loiu.add("BIO");
        Loiu.add("11:00");
        Loiu.add("12:40");
        Loiu.add("100");

        ArrayList<String> Villafria = new ArrayList<>();
        Villafria.add("RGS");
        Villafria.add("11:00");
        Villafria.add("12:40");
        Villafria.add("100");

        ArrayList<String> Cordoba = new ArrayList<>();
        Cordoba.add("ODB");
        Cordoba.add("11:00");
        Cordoba.add("12:40");
        Cordoba.add("100");

        ArrayList<String> Chauchina = new ArrayList<>();
        Chauchina.add("GRX");
        Chauchina.add("11:00");
        Chauchina.add("12:40");
        Chauchina.add("100");

        ArrayList<String> SantaFe = new ArrayList<>();
        SantaFe.add("GRX");
        SantaFe.add("11:00");
        SantaFe.add("12:40");
        SantaFe.add("100");

        ArrayList<String> Gerona = new ArrayList<>();
        Gerona.add("GRO");
        Gerona.add("11:00");
        Gerona.add("12:40");
        Gerona.add("100");

        ArrayList<String> Gando = new ArrayList<>();
        Gando.add("LPA");
        Gando.add("11:00");
        Gando.add("12:40");
        Gando.add("100");

        ArrayList<String> PuertoDelRosario = new ArrayList<>();
        PuertoDelRosario.add("FUE");
        PuertoDelRosario.add("11:00");
        PuertoDelRosario.add("12:40");
        PuertoDelRosario.add("100");

        ArrayList<String> ElMatorral = new ArrayList<>();
        ElMatorral.add("FUE");
        ElMatorral.add("11:00");
        ElMatorral.add("12:40");
        ElMatorral.add("100");

        ArrayList<String> MonFlorite = new ArrayList<>();
        MonFlorite.add("HSK");
        MonFlorite.add("11:00");
        MonFlorite.add("12:40");
        MonFlorite.add("100");

        ArrayList<String> EsCodolar = new ArrayList<>();
        EsCodolar.add("IBZ");
        EsCodolar.add("11:00");
        EsCodolar.add("12:40");
        EsCodolar.add("100");

        ArrayList<String> LaParra = new ArrayList<>();
        LaParra.add("XRY");
        LaParra.add("11:00");
        LaParra.add("12:40");
        LaParra.add("100");

        ArrayList<String> VirgenDelCamino = new ArrayList<>();
        VirgenDelCamino.add("LEN");
        VirgenDelCamino.add("11:00");
        VirgenDelCamino.add("12:40");
        VirgenDelCamino.add("100");

        ArrayList<String> Agoncillo = new ArrayList<>();
        Agoncillo.add("RJL");
        Agoncillo.add("11:00");
        Agoncillo.add("12:40");
        Agoncillo.add("100");

        ArrayList<String> CuatroVientos = new ArrayList<>();
        CuatroVientos.add("MCV");
        CuatroVientos.add("11:00");
        CuatroVientos.add("12:40");
        CuatroVientos.add("100");

        ArrayList<String> PabloPicasso = new ArrayList<>();
        PabloPicasso.add("AGP");
        PabloPicasso.add("11:00");
        PabloPicasso.add("12:40");
        PabloPicasso.add("100");

        ArrayList<String> Melilla = new ArrayList<>();
        Melilla.add("MLN");
        Melilla.add("11:00");
        Melilla.add("12:40");
        Melilla.add("100");

        ArrayList<String> Mahon = new ArrayList<>();
        Mahon.add("MAH");
        Mahon.add("11:00");
        Mahon.add("12:40");
        Mahon.add("100");

        ArrayList<String> Corevera = new ArrayList<>();
        Corevera.add("RMU");
        Corevera.add("11:00");
        Corevera.add("12:40");
        Corevera.add("100");

        ArrayList<String> SonSanJuan = new ArrayList<>();
        SonSanJuan.add("PMI");
        SonSanJuan.add("11:00");
        SonSanJuan.add("12:40");
        SonSanJuan.add("100");

        ArrayList<String> Noain = new ArrayList<>();
        Noain.add("PNA");
        Noain.add("11:00");
        Noain.add("12:40");
        Noain.add("100");

        ArrayList<String> Reus = new ArrayList<>();
        Reus.add("REU");
        Reus.add("11:00");
        Reus.add("12:40");
        Reus.add("100");

        ArrayList<String> Sabadell = new ArrayList<>();
        Sabadell.add("QSA");
        Sabadell.add("11:00");
        Sabadell.add("12:40");
        Sabadell.add("100");

        ArrayList<String> Matacan = new ArrayList<>();
        Matacan.add("SLM");
        Matacan.add("11:00");
        Matacan.add("12:40");
        Matacan.add("100");

        ArrayList<String> Fuenterrabia = new ArrayList<>();
        Fuenterrabia.add("EAS");
        Fuenterrabia.add("11:00");
        Fuenterrabia.add("12:40");
        Fuenterrabia.add("100");

        ArrayList<String> Lavacolla = new ArrayList<>();
        Lavacolla.add("SCQ");
        Lavacolla.add("11:00");
        Lavacolla.add("12:40");
        Lavacolla.add("100");

        ArrayList<String> SanPablo = new ArrayList<>();
        EsCodolar.add("SVQ");
        EsCodolar.add("11:00");
        EsCodolar.add("12:40");
        EsCodolar.add("100");

        ArrayList<String> Parayas = new ArrayList<>();
        Parayas.add("SDR");
        Parayas.add("11:00");
        Parayas.add("12:40");
        Parayas.add("100");

        ArrayList<String> SonBonet = new ArrayList<>();
        SonBonet.add("SBO");
        SonBonet.add("11:00");
        SonBonet.add("12:40");
        SonBonet.add("100");

        ArrayList<String> LosRodeos = new ArrayList<>();
        LosRodeos.add("TFN");
        LosRodeos.add("11:00");
        LosRodeos.add("12:40");
        LosRodeos.add("100");

        ArrayList<String> ReinaSofia = new ArrayList<>();
        ReinaSofia.add("TFS");
        ReinaSofia.add("11:00");
        ReinaSofia.add("12:40");
        ReinaSofia.add("100");

        ArrayList<String> Mazo = new ArrayList<>();
        Mazo.add("SPC");
        Mazo.add("11:00");
        Mazo.add("12:40");
        Mazo.add("100");

        ArrayList<String> LaGomera = new ArrayList<>();
        LaGomera.add("GMZ");
        LaGomera.add("11:00");
        LaGomera.add("12:40");
        LaGomera.add("100");

        ArrayList<String> LosCangrejos = new ArrayList<>();
        LosCangrejos.add("VDE");
        LosCangrejos.add("11:00");
        LosCangrejos.add("12:40");
        LosCangrejos.add("100");

        ArrayList<String> Manises = new ArrayList<>();
        Manises.add("VLC");
        Manises.add("11:00");
        Manises.add("12:40");
        Manises.add("100");

        ArrayList<String> Villanubla = new ArrayList<>();
        Villanubla.add("VLL");
        Villanubla.add("11:00");
        Villanubla.add("12:40");
        Villanubla.add("100");

        ArrayList<String> Peinador = new ArrayList<>();
        Peinador.add("VGO");
        Peinador.add("11:00");
        Peinador.add("12:40");
        Peinador.add("100");

        ArrayList<String> Foronda = new ArrayList<>();
        Foronda.add("VIT");
        Foronda.add("11:00");
        Foronda.add("12:40");
        Foronda.add("100");

        ArrayList<String> Zaragoza = new ArrayList<>();
        Zaragoza.add("ZAZ");
        Zaragoza.add("11:00");
        Zaragoza.add("12:40");
        Zaragoza.add("100");

        ArrayList<String> MontferrerCastellbo = new ArrayList<>();
        MontferrerCastellbo.add("LEU");
        MontferrerCastellbo.add("11:00");
        MontferrerCastellbo.add("12:40");
        MontferrerCastellbo.add("100");

        ArrayList<String> CanyadaDeCalatrava = new ArrayList<>();
        CanyadaDeCalatrava.add("CQM");
        CanyadaDeCalatrava.add("11:00");
        CanyadaDeCalatrava.add("12:40");
        CanyadaDeCalatrava.add("100");

        // ------------------------------------------------

        ArrayList<String>[] AeropuertoSanPablo = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoBarajas = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};


        ArrayList<String>[] AeropuertoAlguaire = new ArrayList[]{SanPablo,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoTeruel = new ArrayList[]{Alguaire,SanPablo, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoBenlloch = new ArrayList[]{Alguaire,Teruel, SanPablo, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoBadajoz = new ArrayList[]{Alguaire,Teruel, Benlloch, SanPablo, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoElPrat = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, SanPablo, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoAlvedro = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, SanPablo
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoRanon = new ArrayList[]{Alguaire,Teruel, Benlloch, ElPrat, Alvedro
                , SanPablo, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSantiagoDelMonte = new ArrayList[]{Alguaire,Teruel, Benlloch, ElPrat, Alvedro
                , Ranon, SanPablo, LosLlanos, ElAltet, ElAlquian, Costacabana, Badajoz, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoLosLlanos = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, SanPablo, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoElAltet = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, SanPablo, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoElAlquian = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, SanPablo, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoCostacabana = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, SanPablo, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSLoiu = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, SanPablo, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoVillafria = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, SanPablo
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoCordoba = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , SanPablo, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoChauchina = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, SanPablo,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSantaFe = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SanPablo, Gerona, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoGerona = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, SanPablo, Gando, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};
        ArrayList<String>[] AeropuertoGando = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, SanPablo, PuertoDelRosario, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoPuertoDelRosario = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, SanPablo, ElMatorral, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoElMatorral = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoEsCodolar = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};


        ArrayList<String>[] AeropuertoLaParra = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoVirgenDelCamino = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoAgoncillo = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoCuatroVientos = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoPabloPicasso = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoMelilla = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoMahon = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoCorvera = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSonSanJuan = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoNoain = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoReus = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSabadell = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoMatacan = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoFuenterrabia = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoLavacolla = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoParayas = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoSonBonet = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoLosRodeos = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoReinaSofia = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoMazo= new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoLaGomera = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoLosCangrejos = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoManises = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoVillanubla = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Peinador, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoPeinador = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Foronda, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoForonda = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Zaragoza, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoZaragoza = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, MontferrerCastellbo
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoMontferrerCastellbo = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza
                , CanyadaDeCalatrava};

        ArrayList<String>[] AeropuertoCanyadaDeCalatrava = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo};

        ArrayList<String>[] AeropuertoMonFlorite = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo};

        ArrayList<String>[] AeropuertoLoiu = new ArrayList[]{Alguaire,Teruel, Benlloch, Badajoz, ElPrat, Alvedro
                , Ranon, SantiagoDelMonte, LosLlanos, ElAltet, ElAlquian, Costacabana, Loiu, Villafria
                , Cordoba, Chauchina,SantaFe, Gerona, Gando, PuertoDelRosario, ElMatorral, SanPablo, EsCodolar, LaParra
                , VirgenDelCamino, Agoncillo, CuatroVientos, PabloPicasso, Melilla, Mahon, Corevera, SonSanJuan, Noain
                , Reus, Sabadell, Matacan, Fuenterrabia, Lavacolla, Parayas, SonBonet, LosRodeos, ReinaSofia
                , Mazo, LaGomera, LosCangrejos, Manises, Villanubla, Peinador, Foronda, Zaragoza, MontferrerCastellbo};

        DiccionarioArrayLists.put("SVQ", AeropuertoSanPablo);
        DiccionarioArrayLists.put("MAD", AeropuertoBarajas);
        DiccionarioArrayLists.put("BCN", AeropuertoElPrat);
        DiccionarioArrayLists.put("LCG", AeropuertoAlvedro);
        DiccionarioArrayLists.put("OVD", AeropuertoRanon);
        DiccionarioArrayLists.put("OVD", AeropuertoSantiagoDelMonte);
        DiccionarioArrayLists.put("ABC", AeropuertoLosLlanos);
        DiccionarioArrayLists.put("ALC", AeropuertoElAltet);
        DiccionarioArrayLists.put("LEI", AeropuertoElAlquian);
        DiccionarioArrayLists.put("LEI", AeropuertoCostacabana);
        DiccionarioArrayLists.put("BJZ", AeropuertoBadajoz);
        DiccionarioArrayLists.put("BIO", AeropuertoLoiu);
        DiccionarioArrayLists.put("RGS", AeropuertoVillafria);
        DiccionarioArrayLists.put("ODB", AeropuertoCordoba);
        DiccionarioArrayLists.put("GRX", AeropuertoChauchina);
        DiccionarioArrayLists.put("GRX", AeropuertoSantaFe);
        DiccionarioArrayLists.put("GRO",AeropuertoGerona);
        DiccionarioArrayLists.put("LPA", AeropuertoGando);
        DiccionarioArrayLists.put("FUE", AeropuertoPuertoDelRosario);
        DiccionarioArrayLists.put("FUE",AeropuertoElMatorral);
        DiccionarioArrayLists.put("HSK", AeropuertoMonFlorite);
        DiccionarioArrayLists.put("IBZ", AeropuertoEsCodolar);
        DiccionarioArrayLists.put("XRY", AeropuertoLaParra);
        DiccionarioArrayLists.put( "LEN", AeropuertoVirgenDelCamino);
        DiccionarioArrayLists.put("RJL", AeropuertoAgoncillo);
        DiccionarioArrayLists.put("MCV", AeropuertoCuatroVientos);
        DiccionarioArrayLists.put("AGP", AeropuertoPabloPicasso);
        DiccionarioArrayLists.put("MLN", AeropuertoMelilla);
        DiccionarioArrayLists.put("MAH", AeropuertoMahon);
        DiccionarioArrayLists.put("RMU", AeropuertoCorvera);
        DiccionarioArrayLists.put("PMI", AeropuertoSonSanJuan);
        DiccionarioArrayLists.put("PNA", AeropuertoNoain);
        DiccionarioArrayLists.put("REU", AeropuertoReus);
        DiccionarioArrayLists.put("QSA", AeropuertoSabadell);
        DiccionarioArrayLists.put("SLM", AeropuertoMatacan);
        DiccionarioArrayLists.put("EAS", AeropuertoFuenterrabia);
        DiccionarioArrayLists.put("SCQ", AeropuertoLavacolla);
        DiccionarioArrayLists.put("SDR", AeropuertoParayas);
        DiccionarioArrayLists.put("SBO", AeropuertoSonBonet);
        DiccionarioArrayLists.put("TFN", AeropuertoLosRodeos);
        DiccionarioArrayLists.put("TFS", AeropuertoReinaSofia);
        DiccionarioArrayLists.put("SPC", AeropuertoMazo);
        DiccionarioArrayLists.put("GMZ", AeropuertoLaGomera);
        DiccionarioArrayLists.put("VDE", AeropuertoLosCangrejos);
        DiccionarioArrayLists.put("VLC", AeropuertoManises);
        DiccionarioArrayLists.put("VLL", AeropuertoVillanubla);
        DiccionarioArrayLists.put("VGO", AeropuertoPeinador);
        DiccionarioArrayLists.put("VIT",AeropuertoForonda);
        DiccionarioArrayLists.put("ZAZ", AeropuertoZaragoza);
        DiccionarioArrayLists.put("LEU", AeropuertoMontferrerCastellbo);
        DiccionarioArrayLists.put("CDT", AeropuertoBenlloch);
        DiccionarioArrayLists.put("CQM", AeropuertoCanyadaDeCalatrava);
        DiccionarioArrayLists.put("ILD", AeropuertoAlguaire);
        DiccionarioArrayLists.put("TEV", AeropuertoTeruel);
        //System.out.print("Origen: ");
        /*String Origen =
        System.out.println(" ");
        System.out.print("Destino: ");
        String Destino = */
        String CodigoIATAOrigen = CiudadCodigo.get(Origen);
        String CodigoIATADestino = CiudadCodigo.get(Destino);
        LocalTime HoraSalida1 = null;
        Integer MinutosSalidaLlegada1 = 0;
        LocalTime HoraLlegada1 = null;
        if (DiccionarioArrayLists.containsKey(CodigoIATAOrigen)){
            for (ArrayList<String> i : DiccionarioArrayLists.get(CodigoIATAOrigen)){
                Integer PosicionArrayList = i.indexOf(CodigoIATADestino);
                for (String e : i){
                    for (Integer x = 0; PosicionArrayList.equals(x);x++) {
                        HoraSalida1 = LocalTime.parse(i.get(1));
                        MinutosSalidaLlegada1 = Integer.parseInt(i.get(3));
                        HoraLlegada1 = HoraSalida1.plusMinutes(MinutosSalidaLlegada1);
                    }
                }
            }
        }
        String CodigoIATAOrigen1 = CiudadCodigo.get(Origen);
        String CodigoIATADestino1 = CiudadCodigo.get(Destino);
        LocalTime HoraSalida = null;
        Integer MinutosSalidaLlegada = 0;
        LocalTime HoraLlegada = null;
        if (DiccionarioArrayLists.containsKey(CodigoIATAOrigen1)){
            for (ArrayList<String> i : DiccionarioArrayLists.get(CodigoIATAOrigen1)){
                Integer PosicionArrayList = i.indexOf(CodigoIATADestino1);
                for (String e : i){
                    for (Integer x = 0; PosicionArrayList.equals(x);x++) {
                        HoraSalida = LocalTime.parse(i.get(2));
                        MinutosSalidaLlegada = Integer.parseInt(i.get(3));
                        HoraLlegada = HoraSalida.plusMinutes(MinutosSalidaLlegada);
                    }
                }
            }
        }
        // ----------------------------------------------------------------------------
        Random random = new Random();
        ArrayList<String> PrecioResultado = new ArrayList<>();

        double PrecioMinimo = 35.00;
        double PrecioMaximo = 60.00;
        double RangoMinMax = PrecioMaximo - PrecioMinimo;
        double PrecioAleatorio = PrecioMinimo + (random.nextDouble() * RangoMinMax);
        DecimalFormat FormatoDecimales = new DecimalFormat("#.##");

        double PrecioMinimo1 = 35.00;
        double PrecioMaximo1 = 60.00;
        double RangoMinMax1 = PrecioMaximo1 - PrecioMinimo1;
        double PrecioAleatorio1 = PrecioMinimo1 + (random.nextDouble() * RangoMinMax1);

        PrecioResultado.add(FormatoDecimales.format(PrecioAleatorio));
        PrecioResultado.add(FormatoDecimales.format(PrecioAleatorio1));

        //RESULTADO
        ArrayList<String> ValoresResultados = new ArrayList<>();

        System.out.println(" ");
        System.out.println("  El resultado solicitado es: ");
        System.out.println(Origen + "("+CodigoIATAOrigen+")" + "-->" + Destino + "("+CodigoIATADestino+")" + " "
                + HoraSalida + " " + HoraLlegada + " " + FormatoDecimales.format(PrecioAleatorio) +"€");
        System.out.println(Origen + "("+CodigoIATAOrigen+")" + "-->" + Destino + "("+CodigoIATADestino+")" + " "
                + HoraSalida1 + " " + HoraLlegada1 + " " + FormatoDecimales.format(PrecioAleatorio1) +"€");
        String Salida1 = Origen + "("+CodigoIATAOrigen+")" + "-->" + Destino + "("+CodigoIATADestino+")" + " "
                + HoraSalida + " " + HoraLlegada + " " + FormatoDecimales.format(PrecioAleatorio) +"€";
        String Salida2 = Origen + "("+CodigoIATAOrigen+")" + "-->" + Destino + "("+CodigoIATADestino+")" + " "
                + HoraSalida1 + " " + HoraLlegada1 + " " + FormatoDecimales.format(PrecioAleatorio1) +"€";
        ValoresResultados.add(Salida1);
        ValoresResultados.add(Salida2);

        ArrayList<ArrayList<String>> ValoresSalida = new ArrayList<>();
        ValoresSalida.add(ValoresResultados);
        ValoresSalida.add(PrecioResultado);

        return ValoresSalida;
    }
}
