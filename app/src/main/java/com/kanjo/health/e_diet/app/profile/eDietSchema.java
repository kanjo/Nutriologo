package com.kanjo.health.e_diet.app.profile;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by JARP on 6/3/14.
 */
public class eDietSchema {

    /**
     * Project Related Constants
     */

    public static final String ORGANIZATIONAL_NAME = "kanjo";
    public static final String PROJECT_NAME = "ediet";
    public static final String DATABASE_NAME = "ediet.db";
    public static final int DATABASE_VERSION = 1;



    /**
     * ConentProvider Related Constants
     */
    public static final String AUTHORITY = ORGANIZATIONAL_NAME + "."
            + PROJECT_NAME + ".edietprovider";
    private static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static final UriMatcher URI_MATCHER = buildUriMatcher();

    // register identifying URIs for Restaurant entity
    // the TOKEN value is associated with each URI registered
    private static UriMatcher buildUriMatcher() {

        // add default 'no match' result to matcher
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        matcher.addURI(AUTHORITY,User.PATH, User.PATH_TOKEN);
        matcher.addURI(AUTHORITY,User.PATH_FOR_ID, User.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,GrupoPlatillos.PATH, GrupoPlatillos.PATH_TOKEN);
        matcher.addURI(AUTHORITY,GrupoPlatillos.PATH_FOR_ID, GrupoPlatillos.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,Platillo.PATH, Platillo.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Platillo.PATH_FOR_ID, Platillo.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,Horario.PATH, Horario.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Horario.PATH_FOR_ID, Horario.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,Etapa.PATH, Etapa.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Etapa.PATH_FOR_ID, Etapa.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,Profile.PATH, Profile.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Profile.PATH_FOR_ID, Profile.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,EtapaAlimento.PATH, EtapaAlimento.PATH_TOKEN);
        matcher.addURI(AUTHORITY,EtapaAlimento.PATH_FOR_ID, EtapaAlimento.PATH_FOR_ID_TOKEN);

        matcher.addURI(AUTHORITY,Porcion.PATH, Porcion.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Porcion.PATH_FOR_ID, Porcion.PATH_FOR_ID_TOKEN);

        //Alimentos
        matcher.addURI(AUTHORITY,Alimentos.PATH, Alimentos.PATH_TOKEN);
        matcher.addURI(AUTHORITY,Alimentos.PATH_FOR_ID, Alimentos.PATH_FOR_ID_TOKEN);
        //GrupoAlimentos
        matcher.addURI(AUTHORITY,GrupoAlimentos.PATH, GrupoAlimentos.PATH_TOKEN);
        matcher.addURI(AUTHORITY,GrupoAlimentos.PATH_FOR_ID, GrupoAlimentos.PATH_FOR_ID_TOKEN);

        //GrupoAlimentos_Alimentos

        matcher.addURI(AUTHORITY,GrupoAlimentos_Alimentos.PATH, GrupoAlimentos_Alimentos.PATH_TOKEN);
        matcher.addURI(AUTHORITY,GrupoAlimentos_Alimentos.PATH_FOR_ID, GrupoAlimentos_Alimentos.PATH_FOR_ID_TOKEN);
        return  matcher;
    }

    public static class User
    {
        public static String TABLE_NAME ="User";

        public static String PATH= "user";
        public static final int PATH_TOKEN = 110;

        public static final String PATH_FOR_ID = "user/*";
        public static final int PATH_FOR_ID_TOKEN = 120;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.users";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "users";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
         ALL_KEY_CLAUSE = new StringBuilder()
                 .append('"').append(Cols.USER_ID).append('"').append("=?").append(" AND ")
                 .append('"').append(Cols.NAME).append('"').append("=?").append(" AND ")
                 .append('"').append(Cols.MAIL).append('"').append("=?").append(" AND ")
                 .append('"').append(Cols.CREATION_DATE).append('"').append("=?").append(" AND ")
                 .append('"').append(Cols.ID).append('"').append("=?")
                 .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
        {
            Cols.USER_ID,Cols.ID, Cols.NAME,Cols.CREATION_DATE,Cols.MAIL
        };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.USER_ID)) {
                setValues.put(Cols.USER_ID, 0);
            }
            if (!setValues.containsKey(Cols.NAME)) {
                setValues.put(Cols.NAME, "");
            }
            if (!setValues.containsKey(Cols.CREATION_DATE)) {
                setValues.put(Cols.CREATION_DATE, getCalendarInstance());
            }

            if (!setValues.containsKey(Cols.MAIL)) {
                setValues.put(Cols.MAIL,"");
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String USER_ID = "idUser";

            public static final String NAME="name";

            public static final String MAIL = "mail";

            public static final String CREATION_DATE="CREATION_DATE";

        }






    }

    public static class GrupoPlatillos
    {
        public static String TABLE_NAME ="GrupoPlatillos";

        public static String PATH= "grupoplatillo";
        public static final int PATH_TOKEN = 210;

        public static final String PATH_FOR_ID = "grupoplatillo/*";
        public static final int PATH_FOR_ID_TOKEN = 220;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.grupoplatillos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "grupoplatillos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.GRUPO_PLATILLO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();
        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.GRUPO_PLATILLO_ID,Cols.ID, Cols.DESCRIPCION
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.GRUPO_PLATILLO_ID)) {
                setValues.put(Cols.GRUPO_PLATILLO_ID, 0);
            }
            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String GRUPO_PLATILLO_ID = "idGrupoPlatillo";

            public static final String DESCRIPCION ="Descripcion";


        }






    }

    public static class Platillo
    {
        public static String TABLE_NAME ="platillo";

        public static String PATH= "user";
        public static final int PATH_TOKEN = 310;

        public static final String PATH_FOR_ID = "platillo/*";
        public static final int PATH_FOR_ID_TOKEN = 320;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.platillos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "platillos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.PLATILLO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.INGREDIENTES).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.PREPARACION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.GRUPO_PLATILLO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.PLATILLO_ID  ,Cols.ID,
                        Cols.DESCRIPCION  ,Cols.PREPARACION,
                        Cols.INGREDIENTES , Cols.GRUPO_PLATILLO_ID
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.PLATILLO_ID)) {
                setValues.put(Cols.PLATILLO_ID, 0);
            }

            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            if (!setValues.containsKey(Cols.INGREDIENTES)) {
                setValues.put(Cols.INGREDIENTES, "");
            }

            if (!setValues.containsKey(Cols.PREPARACION)) {
                setValues.put(Cols.PREPARACION, "");
            }

            if (!setValues.containsKey(Cols.GRUPO_PLATILLO_ID)) {
                setValues.put(Cols.GRUPO_PLATILLO_ID, 0);
            }



            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String PLATILLO_ID = "idplatillo";

            public static final String DESCRIPCION ="descripcion";

            public static final String INGREDIENTES = "ingredientes";

            public static final String PREPARACION= "preparacion";

            public static final String GRUPO_PLATILLO_ID = "idGrupoPlatillo";

        }






    }

    public static class Horario
    {
        public static String TABLE_NAME ="Horario";

        public static String PATH= "horario";
        public static final int PATH_TOKEN = 410;

        public static final String PATH_FOR_ID = "horario/*";
        public static final int PATH_FOR_ID_TOKEN = 420;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.horarios";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "horarios";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.HORARIO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.TIME).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ACTIVE).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.HORARIO_ID,Cols.ID, Cols.DESCRIPCION,Cols.ACTIVE,Cols.TIME
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.HORARIO_ID)) {
                setValues.put(Cols.HORARIO_ID, 0);
            }
            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            if (!setValues.containsKey(Cols.TIME)) {
                setValues.put(Cols.TIME,"00:00:00");
            }

            if (!setValues.containsKey(Cols.ACTIVE)) {
                setValues.put(Cols.ACTIVE,0);
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String HORARIO_ID = "idHorario";

            public static final String DESCRIPCION ="descripcion";

            public static final String TIME = "time";

            public static final String ACTIVE = "active";

        }






    }

    public static class Etapa
    {
        public static String TABLE_NAME ="etapa";

        public static String PATH= "etapa";
        public static final int PATH_TOKEN = 510;

        public static final String PATH_FOR_ID = "etapa/*";
        public static final int PATH_FOR_ID_TOKEN = 520;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.etapas";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "etapas";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.ETAPA_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ETAPA_NAME).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.ETAPA_ID,Cols.ID, Cols.ETAPA_NAME
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.ETAPA_ID)) {
                setValues.put(Cols.ETAPA_ID, 0);
            }
            if (!setValues.containsKey(Cols.ETAPA_NAME)) {
                setValues.put(Cols.ETAPA_NAME, "");
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String ETAPA_ID = "idEtapa";

            public static final String ETAPA_NAME ="NombreEtapa";


        }






    }

    public static class Profile
    {
        public static String TABLE_NAME ="Profile";

        public static String PATH= "Profile";
        public static final int PATH_TOKEN = 610;

        public static final String PATH_FOR_ID = "profile/*";
        public static final int PATH_FOR_ID_TOKEN = 620;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.profiles";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "profiles";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.USER_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ETAPA_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.USER_ID,Cols.ID, Cols.ETAPA_ID
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.USER_ID)) {
                setValues.put(Cols.USER_ID, 0);
            }
            if (!setValues.containsKey(Cols.ETAPA_ID)) {
                setValues.put(Cols.ETAPA_ID, 0);
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String USER_ID = "idUser";

            public static final String ETAPA_ID ="idEtapa";


        }






    }

    public static class EtapaAlimento
    {
        public static String TABLE_NAME ="EtapaAlimentos";

        public static String PATH= "etapaAlimento";
        public static final int PATH_TOKEN = 710;

        public static final String PATH_FOR_ID = "etapaAlimento/*";
        public static final int PATH_FOR_ID_TOKEN = 720;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.etapaAlimentos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "etapaAlimentos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.ALIMENTO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ETAPA_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.HORARIO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.CANTIDAD_GRUPO).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.ALIMENTO_ID,Cols.ID, Cols.ETAPA_ID,Cols.CANTIDAD_GRUPO,Cols.HORARIO_ID
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.ALIMENTO_ID)) {
                setValues.put(Cols.ALIMENTO_ID, 0);
            }
            if (!setValues.containsKey(Cols.ETAPA_ID)) {
                setValues.put(Cols.ETAPA_ID, 0);
            }
            if (!setValues.containsKey(Cols.CANTIDAD_GRUPO)) {
                setValues.put(Cols.CANTIDAD_GRUPO, 0);
            }

            if (!setValues.containsKey(Cols.HORARIO_ID)) {
                setValues.put(Cols.HORARIO_ID,0);
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String ALIMENTO_ID = "idAlimento";

            public static final String ETAPA_ID ="idEtapa";

            public static final String HORARIO_ID = "idHorario";

            public static final String CANTIDAD_GRUPO = "cantidadgrupo";

        }






    }

    public static class Porcion
    {
        public static String TABLE_NAME ="porcion";

        public static String PATH= "porcion";
        public static final int PATH_TOKEN = 810;

        public static final String PATH_FOR_ID = "porcion/*";
        public static final int PATH_FOR_ID_TOKEN = 820;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.porciones";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "porciones";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.PORCION_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.PORCION_ID,Cols.ID, Cols.DESCRIPCION
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.PORCION_ID)) {
                setValues.put(Cols.PORCION_ID, 0);
            }
            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String PORCION_ID = "idPorcion";

            public static final String DESCRIPCION ="descripcion";


        }






    }

    public static class Alimentos
    {
        public static String TABLE_NAME ="alimentos";

        public static String PATH= "alimento";
        public static final int PATH_TOKEN = 910;

        public static final String PATH_FOR_ID = "alimento/*";
        public static final int PATH_FOR_ID_TOKEN = 920;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.alimentos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "alimentos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.ALIMENTO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.CANTIDAD_PORCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.PORCION_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.ALIMENTO_ID,Cols.ID, Cols.DESCRIPCION,Cols.PORCION_ID,Cols.CANTIDAD_PORCION
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.ALIMENTO_ID)) {
                setValues.put(Cols.ALIMENTO_ID, 0);
            }
            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            if (!setValues.containsKey(Cols.PORCION_ID)) {
                setValues.put(Cols.PORCION_ID,0);
            }

            if (!setValues.containsKey(Cols.CANTIDAD_PORCION)) {
                setValues.put(Cols.CANTIDAD_PORCION,0);
            }



            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String ALIMENTO_ID = "idHorario";

            public static final String DESCRIPCION ="descripcion";

            public static final String PORCION_ID = "active";

            public static final String CANTIDAD_PORCION = "time";



        }






    }

    public static class GrupoAlimentos
    {
        public static String TABLE_NAME ="grupoalimentos";

        public static String PATH= "grupoalimento";
        public static final int PATH_TOKEN = 1010;

        public static final String PATH_FOR_ID = "grupoalimento/*";
        public static final int PATH_FOR_ID_TOKEN = 1020;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.grupoalimentos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "grupoalimentos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.GRUPO_ALIMENTO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.DESCRIPCION).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.GRUPO_ALIMENTO_ID,Cols.ID, Cols.DESCRIPCION
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.GRUPO_ALIMENTO_ID)) {
                setValues.put(Cols.GRUPO_ALIMENTO_ID, 0);
            }
            if (!setValues.containsKey(Cols.DESCRIPCION)) {
                setValues.put(Cols.DESCRIPCION, "");
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String GRUPO_ALIMENTO_ID = "idGrupoAlimento";

            public static final String DESCRIPCION ="descripcion";

        }






    }

    public static class GrupoAlimentos_Alimentos
    {
        public static String TABLE_NAME ="GrupoAlimentos_Alimentos";

        public static String PATH= "grupoalimentos_alimento";
        public static final int PATH_TOKEN = 1110;

        public static final String PATH_FOR_ID = "grupoalimentos_alimento/*";
        public static final int PATH_FOR_ID_TOKEN = 1120;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TOPIC = "topic/com.kanjo.grupoalimentos_alimentos";

        public static final String ALL_KEY_CLAUSE;

        private final static String MIME_TYPE_END = "grupoalimentos_alimentos";

        // define the MIME type of data in the content provider
        public static final String CONTENT_TYPE_DIR = ORGANIZATIONAL_NAME
                + ".cursor.dir/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;
        public static final String CONTENT_ITEM_TYPE = ORGANIZATIONAL_NAME
                + ".cursor.item/" + ORGANIZATIONAL_NAME + "." + MIME_TYPE_END;

        static
        {
            ALL_KEY_CLAUSE = new StringBuilder()
                    .append('"').append(Cols.GRUPO_ALIMENTO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ALIMENTO_ID).append('"').append("=?").append(" AND ")
                    .append('"').append(Cols.ID).append('"').append("=?")
                    .toString();


        }

        public static final String[] ALL_KEY_COLUMNS = new String[]
                {
                        Cols.GRUPO_ALIMENTO_ID,Cols.ID, Cols.ALIMENTO_ID
                };


        public static ContentValues initializeWithDefault(final ContentValues assignedValues)
        {
            final ContentValues setValues = (assignedValues == null) ? new ContentValues()
                    : assignedValues;
            if (!setValues.containsKey(Cols.GRUPO_ALIMENTO_ID)) {
                setValues.put(Cols.GRUPO_ALIMENTO_ID, 0);
            }
            if (!setValues.containsKey(Cols.ALIMENTO_ID)) {
                setValues.put(Cols.ALIMENTO_ID, 0);
            }

            return setValues;
        }

        public static class Cols
        {
            public static final String ID = BaseColumns._ID;

            public static final String GRUPO_ALIMENTO_ID = "idGrupoAlimento";

            public static final String ALIMENTO_ID ="idAlimento";

        }






    }



    static String getCalendarInstance()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(Calendar.getInstance());
    }
}
