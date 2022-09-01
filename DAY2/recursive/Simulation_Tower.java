public class Simulation_Tower {

    private void move(Tower base, Tower target, Tower temp, int towerCount) {
        if(towerCount != 1) {
            move(base,temp,target,towerCount-1);
        }

        Disk disk = base.pop();
        target.push(disk);

        System.out.println(disk.toString() + "를 옮겼습니다.");

        if(towerCount != 1) {
            move(temp,target,base,towerCount-1);
        }

//         target.push(base.pop());
//         temp.push(base.pop());
//
//         temp.push(target.pop());
//         target.push(base.pop());
//
//         base.push(temp.pop());
//         target.push(temp.pop());
//
//         target.push(base.pop());

    }

    private void run(Tower base, Tower target, Tower temp, int towerCount) {
        move(base,target,temp,towerCount);
    }

    public static void main(String[] args) {
        Tower tower = new Tower();

        Simulation_Tower simul = new Simulation_Tower();

//        tower.push(new Disk(5,5));
//        tower.push(new Disk(4,4));
        tower.push(new Disk(3,3));
        tower.push(new Disk(2,2));
        tower.push(new Disk(1,1));

        simul.run(tower,new Tower(), new Tower(), tower.getCount());

    }
}
