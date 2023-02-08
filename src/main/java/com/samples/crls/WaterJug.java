package com.samples.crls;

class Jug {
    private int quantity;
    private char color;

    Jug(int quantity, char color)  {
        this.quantity = quantity;
        this.color = color;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getColor(){
        return this.color;
    }
}

public class WaterJug {

    static void groupJugs(Jug[] jugs) {
        partitionByColors(jugs);
        int redJugsEnd = jugs.length / 2 -1;
        int blueJugsStart = redJugsEnd + 1;
        sortBySize(jugs, 0, redJugsEnd);
        sortBySize(jugs, blueJugsStart, jugs.length -1);
        groupByQuantity(jugs);
    }

    static void groupByQuantity(Jug[] jugs) {
        int reds = 0;
        int blues = jugs.length / 2;
        while(reds != jugs.length / 2 - 1) {
            //Swap
            reds++;
            Jug temp = jugs[reds];
            jugs[reds] = jugs[blues];
            jugs[blues] = temp;
            blues++;
        }
    }

    static void sortBySize(Jug[] jugs, int low, int high) {
        if(low < high) {
            int partition = findPartionBySize(jugs, low, high);
            sortBySize(jugs, low, partition -1);
            sortBySize(jugs, partition + 1, high);
        }
    }

    static int findPartionBySize(Jug[] jugs, int low, int high) {
        Jug pivot = jugs[high];
        int partitionIndx = low -1;
        for(int index = low; index <= high -1; index++) {
            if(jugs[index].getQuantity() <= pivot.getQuantity()) {
                partitionIndx = partitionIndx + 1;
                //Swap
                Jug temp = jugs[partitionIndx];
                jugs[partitionIndx] = jugs[index];
                jugs[index] = temp;
            }
        }
        //Move pivot to it's position
        partitionIndx = partitionIndx + 1;
        Jug temp = jugs[partitionIndx];
        jugs[partitionIndx] = pivot;
        jugs[high] = temp;
        return partitionIndx;
    }

    static void partitionByColors(Jug[] jugs) {
        int red = -1;
        int blue = jugs.length ;
        while(red <= blue) {
            do {
                red++;
            } while(jugs[red].getColor() == 'R');
            do {
                blue--;
            } while(jugs[blue].getColor() == 'B');
            //Swap
            if(red < blue) {
                Jug temp = jugs[red];
                jugs[red] = jugs[blue];
                jugs[blue] = temp;
            }
        }
    }

}
