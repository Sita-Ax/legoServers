package me.code.legoservers.lego;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

@Repository
public class LegoRepository {

    public HashMap<Integer, Lego> legoList;

    public LegoRepository() throws FileNotFoundException {
        this.legoList = new HashMap<>();
        legoInfo();
    }

    public Collection<Lego> getAll() {
        return legoList.values();
    }

    public void legoInfo() throws FileNotFoundException {
        File file = new File("themes.csv");
        Scanner scan = new Scanner(file);
        String line = scan.nextLine();
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            String[] row = line.split(",");
            Lego lego = new Lego();
            lego.set_id(Integer.parseInt(row[0]));
            lego.setName(row[1]);
            lego.setParentId((row.length == 3) ? Integer.parseInt(row[2]) : 0);
            legoList.put(lego.get_id(), lego);
        }
        scan.close();
    }
}
