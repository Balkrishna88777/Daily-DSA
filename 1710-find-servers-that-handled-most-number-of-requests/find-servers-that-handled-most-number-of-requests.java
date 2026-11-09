class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> troo = new TreeSet<>();

        for(int i=0; i<k; i++){
            troo.add(i);
        }

        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));

        int[] arr = new int[k];

        for(int i=0; i<arrival.length; i++){
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                long[] comp = busy.poll();
                troo.add((int) comp[1]);
            }

            if(troo.isEmpty()){
                continue;
            }


            int preferred = i % k;

            Integer server = troo.ceiling(preferred);

            if (server == null) {
                server = troo.first();
            }

            troo.remove(server);

            arr[server]++;

            busy.offer(new long[]{
                (long) arrival[i] + load[i],
                server
            });
        }

        int max = 0;

        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}