class Solution {
    public int[] countMentions(int nou, List<List<String>> events) {
        int[] mentions = new int[nou];
        boolean[] online = new boolean[nou];
        int[]backononline = new int[nou];

        Arrays.fill(online,true);
        Arrays.fill(backononline,-1);

        Collections.sort(events,(a,b)-> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if(t1 != t2) return t1-t2;

            if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if(b.get(0).equals("OFFLINE") && a.get(0).equals("MESSAGE")) return 1;

            return 0;
        });

        for(List<String> e:events){
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));

            for(int i=0; i<nou ;i++){
                if(!online[i]&&backononline[i] <= time){
                    online[i] = true;
                }
            }

            if(type.equals("OFFLINE")){
                int user = Integer.parseInt(e.get(2));
                online[user] =false;
                backononline[user] = time+60;
            }else{
                String msg = e.get(2);
                if(msg.equals("ALL")){
                    for(int i =0;i<nou;i++){
                        mentions[i]++;
                    }
                }else if(msg.equals("HERE")){
                    for(int i=0;i<nou;i++){
                        if(online[i]){
                            mentions[i]++;
                        }
                    }
                }else{
                    String[] parts = msg.split(" ");
                    for(String p:parts){
                        if(p.startsWith("id")){
                            int id =Integer.parseInt(p.substring(2));
                            mentions[id]++;
                        }
                    }
                }
                
            }
        }
        return mentions;
    }
}