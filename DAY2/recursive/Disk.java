public class Disk {
    int id;
    int size;

    Disk(int _id, int _size) {
        this.id = id;
        this.size = _size;
    }

    @Override
    public String toString() {
        return "size: " + size;
    }
}
