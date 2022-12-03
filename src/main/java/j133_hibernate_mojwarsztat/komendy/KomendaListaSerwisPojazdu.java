package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.SerwisPojazdu;

import java.util.List;

    public class KomendaListaSerwisPojazdu implements Komenda{
        private DataAccessObject<SerwisPojazdu> dataAccessObject;

        public KomendaListaSerwisPojazdu() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "lista serwis";
        }

        @Override
        public void obsluga() {
            List<SerwisPojazdu> serwisy = dataAccessObject.findAll(SerwisPojazdu.class);
            serwisy.forEach(System.out::println);
        }
    }

