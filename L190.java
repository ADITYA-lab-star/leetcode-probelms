public class L190 { 
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0; // Using 'int' in Java to represent uint32_t, as Java doesn't have unsigned integers directly for 32-bit.
                     // The bitwise operations will still work as expected on the bit patterns.
        for (int i = 0; i < 32; i++) {
            ans = ans << 1; // Left shift 'ans' by 1 to make space for the next bit.
            
            // Check if the least significant bit of 'n' is 1.
            // In C++, 'n&1' would be enough. In Java, due to signed integer representation
            // for 'int', the highest bit might cause issues with direct comparison
            // if we were dealing with extremely large positive numbers in the signed range
            // that are interpreted as negative. However, for bit manipulation like this,
            // 'n & 1' correctly extracts the LSB.
            if ((n & 1) == 1) { 
                ans = ans | 1; // If the LSB of 'n' is 1, set the LSB of 'ans' to 1.
            }
            
            // Right shift 'n' by 1 to process the next bit.
            // For unsigned right shift, Java has '>>>'. For signed '>>'.
            // Here, since we are conceptually treating 'n' as unsigned for bit manipulation
            // and simply discarding the LSB, 'n = n >>> 1;' is the most appropriate
            // as it will correctly handle the most significant bit (sign bit) for negative
            // numbers by filling with a 0, rather than extending the sign bit.
            n = n >>> 1; 
        }
        return ans;
    }

}