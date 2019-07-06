/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */
class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 1) return costs[0];
        int[] ticketCosts = new int[days.length];
        ticketCosts[0] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        for (int i = 1; i < days.length; i++) {
            int cost = costs[0] + ticketCosts[i - 1];
            int index = indexInDays(days, i, 7);
            int yaCost = index > 0 ? ticketCosts[index - 1] + costs[1] : costs[1];
            cost = Math.min(cost, yaCost);
            index = indexInDays(days, i, 30);
            yaCost = index > 0 ? ticketCosts[index - 1] + costs[2] : costs[2];
            cost = Math.min(cost, yaCost);
            ticketCosts[i] = cost;
        }
        return ticketCosts[days.length - 1];
    }

    private int indexInDays(int[] days, int index, int dayCount) {
        int day = Math.max(days[index] - dayCount + 1, 1);
        int minIndex = 0;
        int maxIndex = index;
        while (minIndex + 1 < maxIndex) {
            int currentIndex = (minIndex + maxIndex) >> 1;
            if (days[currentIndex] < day) {
                minIndex = currentIndex;
            } else if (days[currentIndex] == day) {
                return currentIndex;
            } else {
                maxIndex = currentIndex;
            }
        }
        return days[minIndex] < day ? maxIndex : minIndex;
    }
}
// class Solution {

//     public int mincostTickets(int[] days, int[] costs) {
//         if (days.length == 1) return costs[0];
//         int lastDay = days[days.length - 1];
//         int[] ticketCosts = new int[lastDay + 1];
//         boolean[] travelDay = new boolean[lastDay + 1];
//         for (int day : days) {
//             travelDay[day] = true;
//         }
//         for (int i = 1; i <= lastDay; i++) {
//             if (!travelDay[i]) {
//                 ticketCosts[i] = ticketCosts[i - 1];
//                 continue;
//             }
//             int cost = Math.min(costs[0] + ticketCosts[i - 1], ticketCosts[Math.max(0, i - 7)] + costs[1]);
//             cost = Math.min(cost, ticketCosts[Math.max(0, i - 30)] + costs[2]);
//             ticketCosts[i] = cost;
//         }
//         return ticketCosts[lastDay];
//     }
// }


