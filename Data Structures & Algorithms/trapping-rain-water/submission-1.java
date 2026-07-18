class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int lmax = 0, rmax = 0;

        int trappedWater = 0;

        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if (lmax < rmax) {
                trappedWater = trappedWater + lmax - height[left];
                left++;
            } else {
                trappedWater += rmax - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}
