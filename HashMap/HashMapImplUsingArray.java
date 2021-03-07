All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
  
  class MyHashMap
{
    int[] map;

    public MyHashMap()
	{
        map = new int[1000001];
       
    }
	
    public int get(int key)
	{
        return map[key] - 1;
    }
    
	public void put(int key, int value)
	{
        map[key] = value+1; //to avoid non-zero values, so get will not return -1(not found) for a value that is zero
    }
    
	public void remove(int key)
	{
        map[key] = 0;
    }
}
