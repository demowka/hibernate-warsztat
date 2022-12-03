package j133_hibernate_mojwarsztat.komendy;

import j133_hibernate_mojwarsztat.DataAccessObject;
import j133_hibernate_mojwarsztat.model.Pojazd;

public class KomendaUsunPojazd implements Komenda {
        private DataAccessObject<Pojazd> dataAccessObject;

        public KomendaUsunPojazd() {
            this.dataAccessObject = new DataAccessObject<>();
        }

        @Override
        public String getKomenda() {
            return "usun pojazd";
        }

        @Override
        public void obsluga() {
            System.out.println("Podaj id usuwanego pojazdu:");
            String idString = Komenda.scanner.nextLine();
            Long id = Long.parseLong(idString);

            if(dataAccessObject.delete(Pojazd.class, id)){
                System.out.println("Usunięto pojazd!");
            }else{
                System.err.println("Nie udało się usunąć pojazdu!");
            }
        }
    }

