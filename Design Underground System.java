class UndergroundSystem {
    private class temp{
        private String name;
        private int time;
        temp(String name, int time){
            this.name=name;
            this.time=time;
        }
    }
    HashMap<Integer, temp> in= new HashMap<>();
    HashMap<String, Integer> out=new HashMap<>();
    HashMap<String, Integer> count=new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        temp station=new temp(stationName, t);
        in.put(id,station);
    }
    
    public void checkOut(int id, String stationName, int t) {
        temp station=in.get(id);
        int time=t-station.time;
        String s=station.name + "-" + stationName;
        out.put(s,out.getOrDefault(s,0)+time);
        count.put(s,count.getOrDefault(s,0)+1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String s=startStation + "-" + endStation;
        return (double) out.get(s)/count.get(s);
    }
}
