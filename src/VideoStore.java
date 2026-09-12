public class VideoStore {

    private Video[] store = new Video[10];
    private int count = 0;

    public void addVideo(String name) {
        store[count++] = new Video(name);
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    public void doCheckout(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video \"" + name + "\" not found in the inventory.");
    }

    public void doReturn(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video \"" + name + "\" not found in the inventory.");
    }

    public void receiveRating(String name, int rating) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equals(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating received for video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video \"" + name + "\" not found in the inventory.");
    }

    public void listInventory() {
        System.out.println("---------------------------------------\n" + //
                        "Video Name | Checkout Status | Rating\n" + //
                        "-----------------------------------------------"); 
        for (int i = 0; i < count; i++) {
            System.out.println(store[i].getName() + " | " + store[i].getCheckout() + " | " + store[i].getRating());
        }
    }
}