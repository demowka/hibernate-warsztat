package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.SerwisPojazdu;

import java.util.Optional;

    public class KomendaZnajdzSerwisPojazdu implements Komenda {
        private DataAccessObject<SerwisPojazdu> dataAccessObject;

        public KomendaZnajdzSerwisPojazdu() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "znajdz serwis";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj id szukanego zlecenia serwisu:");
            String idString = Komenda.scanner.nextLine();
            Long id = Long.parseLong(idString);

            Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
            if (serwisPojazduOptional.isPresent()) {
                System.out.println(serwisPojazduOptional.get());
            } else {
                System.err.println("Nie znaleziono zlecenia serwisu!");
            }
        }
    }

