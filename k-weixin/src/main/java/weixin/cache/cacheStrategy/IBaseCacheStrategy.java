package weixin.cache.cacheStrategy;

import weixin.cache.lock.ICacheLock;

import java.sql.Timestamp;

/**
 * @Author:Jrss
 * @Desp:缓存策略接口
 * @Date:Create in 14:32 2018/6/20
 * @Modified By:
 */
public interface IBaseCacheStrategy {
    /**
    *@Author:Jrss
    *@Desp:创建一个（分布）锁
    */
    ICacheLock beginCacheLock(String resourceName, String key, int retryCount, Timestamp retryDelay);
    /**
     *@Author:Jrss
     *@Desp:创建一个（分布）锁
     */
    ICacheLock beginCacheLock(String resourceName, String key);
}
