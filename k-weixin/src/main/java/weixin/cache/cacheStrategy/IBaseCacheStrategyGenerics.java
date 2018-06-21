package weixin.cache.cacheStrategy;

import java.util.HashMap;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 14:56 2018/6/20
 * @Modified By:
 */
public  interface IBaseCacheStrategyGenerics<K,V> extends IBaseCacheStrategy
{
    /**
     *@Author:Jrss
     *@Desp:获取缓存中最终的键，
     */
    String getFinalKey(String key);
    /**
     *@Author:Jrss
     *@Desp:添加指定ID的对象
     */
    void insertToCache(K key, V value);

    /**
     *@Author:Jrss
     *@Desp:移除指定缓存键的对象
     */
    void removeFromCache(K key);

    /**
     *@Author:Jrss
     *@Desp:返回指定缓存键的对象
     */
    V get(K key);

    /**
     *@Author:Jrss
     *@Desp:获取所有缓存信息集合
     */
    HashMap<K, V> getAll();

    /**
     *@Author:Jrss
     *@Desp:检查是否存在Key及对象
     */
    boolean checkExisted(K key);

    /**
     *@Author:Jrss
     *@Desp:获取缓存集合总数
     */
    long getCount();

    /**
     *@Author:Jrss
     *@Desp:更新缓存
     */
    void Update(K key, V value);
}
