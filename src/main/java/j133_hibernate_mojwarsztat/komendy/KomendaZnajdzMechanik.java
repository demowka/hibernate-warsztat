package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Mechanik;
import org.hibernate.Session;
import java.util.Optional;


    public class KomendaZnajdzMechanik implements Komenda {
        private DataAccessObject<Mechanik> dataAccessObject;

        public KomendaZnajdzMechanik() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "znajdz mechanik";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj id szukanego mechanika:");
            String idString = Komenda.scanner.nextLine();
            Long id = Long.parseLong(idString);

            Optional<Mechanik> mechanikOptional = dataAccessObject.find(Mechanik.class, id);
            if (mechanikOptional.isPresent()) {
                System.out.println(mechanikOptional.get());
            } else {
                System.err.println("Nie znaleziono mechanika!");
            }
        }
    }

