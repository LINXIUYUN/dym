package cn.linxiuyun.dym.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomCache implements Cache{

    private static boolean isInit = false;

    public static Map<String,CacheModel> cacheResourcePool;

    public static void init(int initialCapacity){
        cacheResourcePool = new HashMap<>(initialCapacity);
        isInit = true;
    }

    @Override
    public void set(String key, Object value) {
        if(!isInit){
            throw new RuntimeException("cache must be initial");
        }

        CacheModel item = new CacheModel();
        item.setCount(0);
        item.setSaveTime(System.currentTimeMillis());
        item.setExpire(-1);
        item.setValue(value);

        cacheResourcePool.put(key,item);
    }

    @Override
    public void set(String key, Object value, int expire) {
        if(!isInit){
            throw new RuntimeException("cache must be initial");
        }
        CacheModel item = new CacheModel();
        item.setCount(0);
        item.setSaveTime(System.currentTimeMillis());
        item.setExpire(expire);
        item.setValue(value);

        cacheResourcePool.put(key,item);
    }

    @Override
    public void delete(String key){
        if(!isInit){
            throw new RuntimeException("cache must be initial");
        }

        if(cacheResourcePool.containsKey(key)){
            cacheResourcePool.remove(key);
        }
    }

    @Override
    public Object get(String key) {

        if(!isInit){
            throw new RuntimeException("cache must be initial");
        }

        CacheModel item = cacheResourcePool.get(key);
        if(item==null){
            return null;
        }else{
            if(item.expire>0){
                if((System.currentTimeMillis()-item.saveTime)/1000>item.expire){
                    cacheResourcePool.remove(key);
                    return null;
                }
            }else {
                if((System.currentTimeMillis()-item.saveTime)/1000>=31*24*60*60){
                    cacheResourcePool.remove(key);
                    return null;
                }
            }

            item.setCount(item.getCount()+1);
            return item.getValue();
        }
    }

    private class CacheModel{

        private Object value;
        private long saveTime;
        private int expire;
        private int count;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public long getSaveTime() {
            return saveTime;
        }

        public void setSaveTime(long saveTime) {
            this.saveTime = saveTime;
        }

        public int getExpire() {
            return expire;
        }

        public void setExpire(int expire) {
            this.expire = expire;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "CacheModel{" +
                    "value=" + value +
                    ", saveTime=" + saveTime +
                    ", expire=" + expire +
                    ", count=" + count +
                    '}';
        }
    }
}
