public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();

        table.add("Chicago");
        table.add("New York");
        table.add("CHICAGO");
        table.add("Los Angeles");

        System.out.println(table);
    }
}