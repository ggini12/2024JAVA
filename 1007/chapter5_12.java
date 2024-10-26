package report4;

abstract class PairMap {
    protected String keyArray[];   // Array to store keys
    protected String valueArray[]; // Array to store values

    abstract public String get(String key);         // Retrieve value by key
    abstract public void put(String key, String value); // Store key-value pair
    abstract public String delete(String key);       // Delete key-value pair by key
    abstract public int length();                    // Return the number of stored items
}

class Dictionary extends PairMap {
    private int count; // Track the number of stored items

    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
        count = 0;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i]; // Return the value associated with the key
            }
        }
        return null; // Key not found
    }

    @Override
    public void put(String key, String value) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value; // Update existing value
                return;
            }
        }
        // If key not found, add new key-value pair
        if (count < keyArray.length) {
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                String deletedValue = valueArray[i];
                // Shift elements to fill the gap
                for (int j = i; j < count - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }
                keyArray[count - 1] = null; // Clear the last element
                valueArray[count - 1] = null; // Clear the last element
                count--;
                return deletedValue; // Return the deleted value
            }
        }
        return null; // Key not found
    }

    @Override
    public int length() {
        return count; // Return the current number of items
    }
}

public class chapter5_12 {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(20);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++");  // Update 이재문's value to C++
        
        System.out.println("이재문의 값은 " + dic.get("이재문")); // Should print C++
        System.out.println("황기태의 값은 " + dic.get("황기태")); // Should print 자바
        
        dic.delete("황기태"); // Remove 황기태 from the dictionary
        System.out.println("황기태의 값은 " + dic.get("황기태")); // Should print null
    }
}
