class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        LinkedHashMap<String, List<String>> categoryStore = new LinkedHashMap<>();

        categoryStore.putIfAbsent("electronics", new ArrayList<>());
        categoryStore.putIfAbsent("grocery", new ArrayList<>());
        categoryStore.putIfAbsent("pharmacy", new ArrayList<>());
        categoryStore.putIfAbsent("restaurant", new ArrayList<>());

        for (int idx = 0; idx < code.length; idx++) {
            if (isActive[idx]
                    && checkCodeValidity(code[idx])
                    && categoryStore.containsKey(businessLine[idx])) {

                categoryStore.get(businessLine[idx]).add(code[idx]);
            }
        }

        List<String> finalList = new ArrayList<>();

        for (String category : categoryStore.keySet()) {
            List<String> coupons = categoryStore.get(category);
            Collections.sort(coupons);
            finalList.addAll(coupons);
        }

        return finalList;
    }

    private boolean checkCodeValidity(String coupon) {
        if (coupon.length() == 0) return false;

        for (char ch : coupon.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || ch == '_') {
                continue;
            }
            return false;
        }
        return true;
    }
}
