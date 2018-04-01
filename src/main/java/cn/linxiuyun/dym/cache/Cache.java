package cn.linxiuyun.dym.cache;

public interface Cache {

    public void set(String key,Object value);

    public void set(String key,Object value,int expire);

    public Object get(String key);

    public void delete(String key);

}
