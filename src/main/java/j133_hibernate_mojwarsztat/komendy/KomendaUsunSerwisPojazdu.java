package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazdu implements Komenda {
        private DataAccessObject<SerwisPojazdu> dataAccessObject;

        public KomendaUsunSerwisPojazdu() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "usun serwis";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj id usuwanego zlecenia serwisu:");
            String idString = Komenda.scanner.nextLine();
            Long id = Long.parseLong(idString);

            if (dataAccessObject.delete(SerwisPojazdu.class, id)) {
                System.out.println("Usunięto zlecenie serwisu!");
            } else {
                System.err.println("Nie udało się usunąć zlecenia serwisu!");
            }
        }
    }

