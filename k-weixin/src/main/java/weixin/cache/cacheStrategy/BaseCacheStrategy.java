package weixin.cache.cacheStrategy;

import weixin.cache.lock.ICacheLock;

import java.sql.Timestamp;

/**
 * @Author:Jrss
 * @Desp:
 * @Date:Create in 14:46 2018/6/20
 * @Modified By:
 */
public abstract class BaseCacheStrategy implements IBaseCacheStrategyGenerics {
    /**
     * @Author:Jrss
     * @Desp:获取拼装后的FinalKey
     */
    public String getFinalKey(String key) {
        return "K-Weixin:" + key;
    }

    /**
     * @Author:Jrss
     * @Desp:创建一个（分布）锁
     */
    public abstract ICacheLock beginCacheLock(String resourceName, String key, int retryCount, Timestamp retryDelay);

    /**
     * @Author:Jrss
     * @Desp:创建一个（分布）锁
     */
    public abstract ICacheLock beginCacheLock(String resourceName, String key);
}
