package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Pojazd;

import java.util.Optional;

    public class KomendaZnajdzPojazd implements Komenda {
        private DataAccessObject<Pojazd> dataAccessObject;

        public KomendaZnajdzPojazd() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "znajdz pojazd";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj id szukanego pojazdu:");
            String idString = Komenda.scanner.nextLine();
            Long id = Long.parseLong(idString);

            Optional<Pojazd> pojazdOptional = dataAccessObject.find(Pojazd.class, id);
            if (pojazdOptional.isPresent()) {
                System.out.println(pojazdOptional.get());
            } else {
                System.err.println("Nie znaleziono pojazdu!");
            }
        }
    }

