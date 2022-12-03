package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Mechanik;

import java.util.List;

    public class KomendaListaMechanik implements Komenda{
        private DataAccessObject<Mechanik> dataAccessObject;

        public KomendaListaMechanik() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "lista mechanik";
        }

        @Override
        public void obsluga() {
            List<Mechanik> mechanicy = dataAccessObject.findAll(Mechanik.class);
            mechanicy.forEach(System.out::println);
        }
    }

