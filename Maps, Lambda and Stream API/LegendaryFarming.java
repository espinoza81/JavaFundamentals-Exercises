import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap <String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        LinkedHashMap <String, String> legendaryItem = new LinkedHashMap<>();
        legendaryItem.put("shards", "Shadowmourne");
        legendaryItem.put("fragments", "Valanyr");
        legendaryItem.put("motes", "Dragonwrath");
        boolean haveWinner = false;
        while (!haveWinner){
            String[] input = console.nextLine().split(" ");
            for(int i=0; i<input.length; i+=2){
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1].toLowerCase(Locale.ROOT);
                if (materials.containsKey(material)) {
                    if(legendaryItem.containsKey(material) && materials.get(material)+quantity >=250){
                        materials.put(material, materials.get(material)+quantity-250);
                        haveWinner = true;
                        System.out.println(legendaryItem.get(material) + " obtained!");
                        break;
                    }
                    materials.put(material, materials.get(material)+quantity);
                }
                else  materials.put(material, quantity);
            }
        }
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
