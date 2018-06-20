package cache.lock;

import java.sql.Timestamp;

/**
 * @Author:Jrss
 * @Desp:缓存锁接口
 * @Date:Create in 14:32 2018/6/20
 * @Modified By:
 */
public interface ICacheLock {
    /**
     * @Author:Jrss
     * @Desp:是否成功获得锁
     */
    public abstract boolean getLockSuccessful();

    public abstract boolean setLockSuccessful();

    /**
     * @Author:Jrss
     * @Desp:开始锁
     * @resourceName:资源名称，即锁的标识
     */
    boolean lock(String resourceName);

    /**
     * @Author:Jrss
     * @Desp:开始锁，并设置重试条件
     * @resourceName:资源名称，即锁的标识
     * @retryCount:重试次数
     * @retryDelay:每次重试延时
     */
    boolean lock(String resourceName, int retryCount, Timestamp retryDelay);

    /**
     * @Author:Jrss
     * @Desp:释放锁
     * @resourceName:资源名称，即锁的标识
     */
    void unLock(String resourceName);
}
