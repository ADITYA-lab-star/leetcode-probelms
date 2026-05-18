public class L2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int s = spells.length;
        int p = potions.length;

        int res[] = new int[s];

        for (int i = 0; i < s; i++) {
            int temp = 0;
            for (int j = 0; j < p; j++) {
                if (spells[i] * potions[j] >= success) {
                    temp++;
                }
            }
            res[i] = temp;
        }

        return res;
    }
}
