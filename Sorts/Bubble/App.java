public class App {
    public static void main(String[] args) {
        int[] a = { 5, 4, 6, 8, 2, 1 };

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i]<a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

        for (int i : a) {
            System.out.println(i);
        }
    }
}