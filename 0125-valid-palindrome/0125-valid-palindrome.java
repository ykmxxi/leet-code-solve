class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}