class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> zeroLoss = new HashSet<>();
        Set<Integer> oneLoss = new HashSet<>();
        Set<Integer> moreLoss = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (!oneLoss.contains(winner) && !moreLoss.contains(winner)) {
                zeroLoss.add(winner);
            }
            if (zeroLoss.contains(loser)) {
                zeroLoss.remove(loser);
                oneLoss.add(loser);
            } else if (oneLoss.contains(loser)) {
                oneLoss.remove(loser);
                moreLoss.add(loser);
            } else if (moreLoss.contains(loser)) {
                continue;
            } else {
                oneLoss.add(loser);
            }
        }

        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(new ArrayList<>(zeroLoss));
        answerList.add(new ArrayList<>(oneLoss));
        Collections.sort(answerList.get(0));
        Collections.sort(answerList.get(1));
        return answerList;
    }
}