package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Mechanik;
import j133_hibernate_mojwarsztat.model.Pojazd;
import j133_hibernate_mojwarsztat.model.SerwisPojazdu;

import java.util.Optional;

    public class KomendaDodajSerwisPojazdu implements Komenda{
        private DataAccessObject<SerwisPojazdu> dataAccessObject;
        private DataAccessObject<Pojazd> dataAccessObjectPojazd;
        private DataAccessObject<Mechanik> dataAccessObjectMechanik;

        public KomendaDodajSerwisPojazdu() {
            this.dataAccessObject = new DataAccessObject<>();
            this.dataAccessObjectPojazd = new DataAccessObject<>();
            this.dataAccessObjectMechanik = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "dodaj serwis";
        }

        @Override
        public void obsluga() {
            // ####################### Upewnij się że Pojazd istnieje
            System.out.println("Podaj id serwisowanego pojazdu:");
            String idString = Komenda.scanner.nextLine();
            Long idPojazd = Long.parseLong(idString);

            Optional<Pojazd> pojazdOptional = dataAccessObjectPojazd.find(Pojazd.class, idPojazd);
            if (pojazdOptional.isEmpty()){
                System.err.println("Pojazd nie istnieje, nie można dodać zlecenia serwisowego!");
                return;
            }

            // ####################### Upewnij się że Mechanik istnieje
            System.out.println("Podaj id mechanika:");
            String idMechanikString = Komenda.scanner.nextLine();
            Long idMechanik = Long.parseLong(idMechanikString);

            Optional<Mechanik> mechanikOptional = dataAccessObjectMechanik.find(Mechanik.class, idMechanik);
            if (mechanikOptional.isEmpty()){
                System.err.println("Mechanik nie istnieje, nie można dodać zlecenia serwisowego!");
                return;
            }

            // ####################### Konstruujemy obiekt SerwisPojazdu
            System.out.println("Podaj opis serwisu (co jest do zrobienia?):");
            String opis = Komenda.scanner.nextLine();

            SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                    .mechanik(mechanikOptional.get())
                    .pojazd(pojazdOptional.get())
                    .opis(opis)
                    .build();

            dataAccessObject.insert(serwisPojazdu);
            System.out.println("Dodano serwis!");
        }
    }

