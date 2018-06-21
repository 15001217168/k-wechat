package weixin.cache.lock;

import java.sql.Timestamp;

/**
 * @Author:Jrss
 * @Desp:缓存同步锁基类
 * @Date:Create in 14:40 2018/6/20
 * @Modified By:
 */
public class BaseCacheLock implements ICacheLock {
    public boolean getLockSuccessful() {
        return false;
    }

    public boolean setLockSuccessful() {
        return false;
    }

    public boolean lock(String resourceName) {
        return false;
    }

    public boolean lock(String resourceName, int retryCount, Timestamp retryDelay) {
        return false;
    }

    public void unLock(String resourceName) {

    }
}
