package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Mechanik;
import org.hibernate.Session;
import org.hibernate.Transaction;


    public class KomendaDodajMechanik implements Komenda{
        private DataAccessObject<Mechanik> dataAccessObject;

        public KomendaDodajMechanik() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "dodaj mechanik";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj imie mechanika:");
            String imie = Komenda.scanner.nextLine();

            System.out.println("Podaj kwalifikacje mechanika:");
            String kwalifikacje = Komenda.scanner.nextLine();

            System.out.println("Podaj specjalizacje mechanika:");
            String specjalizacja = Komenda.scanner.nextLine();

            Mechanik mechanik = Mechanik.builder()
                    .specjalizacja(specjalizacja)
                    .kwalifikacje(kwalifikacje)
                    .imie(imie)
                    .build();

            dataAccessObject.insert(mechanik);
        }
    }

