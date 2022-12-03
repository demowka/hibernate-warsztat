package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Pojazd;
import org.hibernate.Session;
import org.hibernate.Transaction;

    public class KomendaDodajPojazd implements Komenda{
        private DataAccessObject<Pojazd> dataAccessObject;

        public KomendaDodajPojazd() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "dodaj pojazd";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj marke pojazdu:");
            String marke = Komenda.scanner.nextLine();

            System.out.println("Podaj model pojazdu:");
            String model = Komenda.scanner.nextLine();

            System.out.println("Podaj vin pojazdu:");
            String vin = Komenda.scanner.nextLine();

            System.out.println("Podaj nr rejestracyjny pojazdu:");
            String nrRej = Komenda.scanner.nextLine();

            Pojazd pojazd = Pojazd.builder()
                    .marka(marke)
                    .model(model)
                    .nrRej(nrRej)
                    .vin(vin)
                    .build();

            dataAccessObject.insert(pojazd);
        }
    }

