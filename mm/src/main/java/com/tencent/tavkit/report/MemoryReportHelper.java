package com.tencent.tavkit.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryReportHelper {
    public static final int MIN_TICK_INTERVAL_MS = 1000;
    private static final String TAG = "MemoryReportHelper";
    private static long lastTickTime;
    private Map<String, Consumer> consumerHashMap;
    private Context context;

    public static MemoryReportHelper getInstance() {
        AppMethodBeat.i(197649);
        MemoryReportHelper memoryReportHelper = Instance.INSTANCE;
        AppMethodBeat.o(197649);
        return memoryReportHelper;
    }

    public static boolean isInIntervalTime() {
        AppMethodBeat.i(197650);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTickTime < 1000) {
            AppMethodBeat.o(197650);
            return true;
        }
        lastTickTime = currentTimeMillis;
        AppMethodBeat.o(197650);
        return false;
    }

    public static String appendReportKey(Collection<?> collection) {
        AppMethodBeat.i(197651);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj instanceof IReportable) {
                arrayList.add(((IReportable) obj).getReportKey());
            }
        }
        String appendKeys = appendKeys(arrayList);
        AppMethodBeat.o(197651);
        return appendKeys;
    }

    public static String appendKeys(Collection<String> collection) {
        AppMethodBeat.i(197652);
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(197652);
        return sb2;
    }

    private MemoryReportHelper() {
        AppMethodBeat.i(197653);
        this.consumerHashMap = new HashMap();
        AppMethodBeat.o(197653);
    }

    public void init(Context context2) {
        this.context = context2;
    }

    public void tick(String str) {
        AppMethodBeat.i(197654);
        if (this.context == null) {
            AppMethodBeat.o(197654);
            return;
        }
        tick(str, (long) (getPidMemorySize(Process.myPid(), this.context) / 1024));
        AppMethodBeat.o(197654);
    }

    public void tick(String str, long j2) {
        AppMethodBeat.i(197655);
        Consumer consumer = this.consumerHashMap.get(str);
        if (consumer == null) {
            consumer = new Consumer(str);
            this.consumerHashMap.put(consumer.key, consumer);
        }
        Consumer.access$200(consumer, j2);
        new StringBuilder("tick() called with: key = [").append(str).append("], MB = [").append(j2).append("]");
        AppMethodBeat.o(197655);
    }

    public int getPidMemorySize(int i2, Context context2) {
        AppMethodBeat.i(197656);
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context2.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessMemoryInfo(new int[]{i2});
        processMemoryInfo[0].getTotalSharedDirty();
        int totalPss = processMemoryInfo[0].getTotalPss();
        AppMethodBeat.o(197656);
        return totalPss;
    }

    public void clear() {
        AppMethodBeat.i(197657);
        this.consumerHashMap.clear();
        AppMethodBeat.o(197657);
    }

    public Map<String, Long> getAvgMBValues() {
        AppMethodBeat.i(197658);
        HashMap hashMap = new HashMap();
        for (Consumer consumer : this.consumerHashMap.values()) {
            if (consumer != null) {
                hashMap.put(consumer.key, Long.valueOf(Consumer.access$300(consumer)));
            }
        }
        AppMethodBeat.o(197658);
        return hashMap;
    }

    public Map<String, Long> getMaxMBValues() {
        AppMethodBeat.i(197659);
        HashMap hashMap = new HashMap();
        for (Consumer consumer : this.consumerHashMap.values()) {
            if (consumer != null) {
                hashMap.put(consumer.key, Long.valueOf(consumer.getMaxM()));
            }
        }
        AppMethodBeat.o(197659);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public static class Consumer {
        private long count = 0;
        private final String key;
        private long maxM = 0;
        private long totalM = 0;

        static /* synthetic */ void access$200(Consumer consumer, long j2) {
            AppMethodBeat.i(197646);
            consumer.tick(j2);
            AppMethodBeat.o(197646);
        }

        static /* synthetic */ long access$300(Consumer consumer) {
            AppMethodBeat.i(197647);
            long avgMB = consumer.getAvgMB();
            AppMethodBeat.o(197647);
            return avgMB;
        }

        public Consumer(String str) {
            this.key = str;
        }

        private void tick(long j2) {
            this.totalM += j2;
            this.count++;
            if (j2 > this.maxM) {
                this.maxM = j2;
            }
        }

        private long getAvgMB() {
            if (this.count == 0) {
                return 0;
            }
            return this.totalM / this.count;
        }

        public long getMaxM() {
            return this.maxM;
        }
    }

    static class Instance {
        private static final MemoryReportHelper INSTANCE = new MemoryReportHelper();

        private Instance() {
        }

        static {
            AppMethodBeat.i(197648);
            AppMethodBeat.o(197648);
        }
    }
}
