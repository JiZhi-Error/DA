package com.tencent.qqmusic.mediaplayer.util;

public class CpuInfoUtil {
    private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String TAG = "CpuInfoUtil";
    private static OutputCpuThread mCurrThread = null;

    public static synchronized void startProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
        }
    }

    public static synchronized void stopProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
            mCurrThread = null;
        }
    }

    public static void outputThreadInfoToLog() {
    }

    public static void outputCpuHZToLog() {
    }

    /* access modifiers changed from: package-private */
    public static class OutputCpuThread extends Thread {
        public boolean isStop = false;

        public OutputCpuThread(String str) {
            super(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[SYNTHETIC, Splitter:B:32:0x0087] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A[SYNTHETIC, Splitter:B:41:0x00a0] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 197
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil.OutputCpuThread.run():void");
        }
    }
}
