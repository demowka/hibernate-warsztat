package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Pojazd;

import java.util.List;

    public class KomendaListaPojazd implements Komenda{
        private DataAccessObject<Pojazd> dataAccessObject;

        public KomendaListaPojazd() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "lista pojazd";
        }

        @Override
        public void obsluga() {
            List<Pojazd> pojazdy = dataAccessObject.findAll(Pojazd.class);
            pojazdy.forEach(System.out::println);
        }
    }

