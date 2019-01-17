import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MultiLevelPort {
    ArrayList<Port<IBoat>> parkingStages;
    private  int countPlaces = 20;
    private int pictureWidth;
    private int pictureHeight;
    public MultiLevelPort(int countStages, int pictureWidth, int pictureHeight)
    {
        parkingStages = new ArrayList<Port<IBoat>>();
        for(int i =0; i< countStages; ++i)
        {
            parkingStages.add(new Port<IBoat>(countPlaces, pictureWidth, pictureHeight));
        }
    }


    public Port<IBoat> getPort(int ind){
        if((ind>-1) && (ind < parkingStages.size()))
        {
            return parkingStages.get(ind);
        }
        return null;
    }

    public boolean saveData(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            writeToFile("PortStages:" + parkingStages.size() + System.lineSeparator(), bw);
            for (Port<IBoat> level : parkingStages) {
                writeToFile("Level" + System.lineSeparator(), bw);
                for (int i = 0; i < countPlaces; i++) {
                    IBoat boat = level.getBoat(i);
                    if (boat != null) {
                        if (boat.getClass().getSimpleName().equals("Boat")) {
                            writeToFile(i + ":Boat:" + boat.getInfo(), bw);
                        }
                        if (boat.getClass().getSimpleName().equals("Catamaran")) {
                            writeToFile(i + ":Catamaran:" + boat.getInfo(), bw);
                        }
                        writeToFile(System.lineSeparator(), bw);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    private void writeToFile(String text, BufferedWriter writer) {
        try {
            char[] info = text.toCharArray();
            writer.write(info, 0, info.length);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean loadData(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }
        String bufferTextFromFile = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                bufferTextFromFile += line + "\n";
            }
            String[] strs = bufferTextFromFile.split("\n");
            if (strs[0].contains("PortStages")) {
                int count = Integer.parseInt(strs[0].split(":")[1]);
                if (parkingStages != null) {
                    parkingStages.clear();
                }
                parkingStages = new ArrayList<Port<IBoat>>(count);
            } else {
                return false;
            }
            int counter = -1;
            IBoat boat = null;
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].equals("Level")) {
                    counter++;
                    parkingStages.add(new Port<IBoat>(countPlaces, pictureWidth, pictureHeight));
                    continue;
                }
                if (strs[i].isEmpty() || strs[i] == null) {
                    continue;
                }
                if (strs[i].split(":")[1].equals("Boat")) {
                    boat = new Boat(strs[i].split(":")[2]);
                } else if (strs[i].split(":")[1].equals("Catamaran")) {
                    boat = new Catamaran(strs[i].split(":")[2]);
                }
                parkingStages.get(counter).setBoat(Integer.parseInt(strs[i].split(":")[0]), boat);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}