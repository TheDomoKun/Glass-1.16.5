package x.glass.client.utils;

public final class TimerUtil {
    public long lastMS;

    public long getCurrentMS() {
        return System.nanoTime() / 1000000;
    }

    public boolean hasReached(final long milliseconds) {
        return getCurrentMS() - lastMS >= milliseconds;
    }

    public void reset() {
        lastMS = getCurrentMS();
    }
}
