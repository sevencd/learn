package thread;

import java.util.concurrent.locks.StampedLock;

public class StampedLockPoint {
    private double x, y;
    private final StampedLock s1 = new StampedLock();

    public void move(double deltaX, double deltaY) {
        // 获取写锁
        long stamp = s1.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            s1.unlockWrite(stamp);
        }
    }

    public double distanceFormOrigin() {
        // 乐观读操作
        long stamp = s1.tryOptimisticRead();
        // 拷贝变量
        double currentX = x, currentY = y;
        // 判断读期间是否有写操作
        if (!s1.validate(stamp)) {
            // 升级为悲观读
            stamp = s1.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                s1.unlockRead(stamp);
            }
        }
        return currentX * currentX + currentY * currentY;
    }
}
