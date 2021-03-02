package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static SparseArray<b> hoJ = new SparseArray<>();
    private static MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private static final byte[] mLock = new byte[0];

    static {
        AppMethodBeat.i(153439);
        AppMethodBeat.o(153439);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.jni.a.a$a  reason: collision with other inner class name */
    public static class RunnableC0360a implements Runnable {
        private WakerLock hoK = null;

        public RunnableC0360a(WakerLock wakerLock) {
            this.hoK = wakerLock;
        }

        public final void run() {
            AppMethodBeat.i(153418);
            synchronized (a.mLock) {
                try {
                    b bVar = (b) a.hoJ.get(this.hoK.hashCode());
                    if (bVar != null) {
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(this.hoK.hashCode());
                        objArr[1] = Integer.valueOf(this.hoK.innerWakeLockHashCode());
                        objArr[2] = this.hoK.getCreatePosStackLine();
                        Collection<b.C0361a> values = bVar.hoN.values();
                        StringBuilder sb = new StringBuilder();
                        boolean z = true;
                        for (b.C0361a aVar : values) {
                            if (z) {
                                z = false;
                            } else {
                                sb.append(',');
                            }
                            if (aVar.hoP != 0) {
                                sb.append('{').append(aVar.hoO).append(',').append(SystemClock.elapsedRealtime() - aVar.hoP).append('}');
                            }
                        }
                        if (sb.length() == 0) {
                            sb.append("<empty>");
                        }
                        objArr[3] = sb.toString();
                        Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", objArr);
                    } else {
                        Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.hoK.hashCode()), Integer.valueOf(this.hoK.innerWakeLockHashCode()), this.hoK.getCreatePosStackLine(), "#lost-trace-state#");
                    }
                    this.hoK.unLock();
                } finally {
                    AppMethodBeat.o(153418);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        volatile boolean hoL = false;
        RunnableC0360a hoM = null;
        Map<String, C0361a> hoN = new HashMap();

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.jni.a.a$b$a  reason: collision with other inner class name */
        public static class C0361a {
            public String hoO = null;
            public long hoP = 0;

            public C0361a(String str, long j2) {
                this.hoO = str;
                this.hoP = j2;
            }
        }

        public b(WakerLock wakerLock) {
            AppMethodBeat.i(153419);
            this.hoM = new RunnableC0360a(wakerLock);
            AppMethodBeat.o(153419);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        private static int hoQ = 0;
        private static long hoR = 0;
        private static long hoS = 0;
        private static final HashMap<String, C0362a> hoT = new HashMap<>();
        private static final byte[] hoU = new byte[0];
        private static BroadcastReceiver hoV = null;

        static /* synthetic */ void e(String str, String str2, long j2) {
            AppMethodBeat.i(153433);
            c(str, str2, j2);
            AppMethodBeat.o(153433);
        }

        static /* synthetic */ void f(String str, String str2, long j2) {
            AppMethodBeat.i(153434);
            d(str, str2, j2);
            AppMethodBeat.o(153434);
        }

        static {
            AppMethodBeat.i(183797);
            AppMethodBeat.o(183797);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.jni.a.a$c$a  reason: collision with other inner class name */
        public static class C0362a implements Externalizable {
            public String hoO;
            public String hoW;
            public boolean hoX;
            public int hoY;
            public int hoZ;
            public long hpa;
            public long hpb;
            public AtomicInteger hpc;
            public String mProcessName;

            private C0362a() {
                AppMethodBeat.i(153421);
                this.mProcessName = "";
                this.hoO = "";
                this.hoW = "";
                this.hoX = false;
                this.hoY = 0;
                this.hoZ = 0;
                this.hpa = 0;
                this.hpb = 0;
                this.hpc = new AtomicInteger(0);
                AppMethodBeat.o(153421);
            }

            /* synthetic */ C0362a(byte b2) {
                this();
            }

            @Override // java.io.Externalizable
            public final void readExternal(ObjectInput objectInput) {
                AppMethodBeat.i(153422);
                synchronized (c.hoU) {
                    try {
                        this.mProcessName = objectInput.readUTF();
                        this.hoO = objectInput.readUTF();
                        this.hoY = objectInput.readInt();
                        this.hoZ = objectInput.readInt();
                        this.hpa = objectInput.readLong();
                        this.hoW = "";
                        this.hoX = false;
                        this.hpb = 0;
                        this.hpc = new AtomicInteger(0);
                    } finally {
                        AppMethodBeat.o(153422);
                    }
                }
            }

            @Override // java.io.Externalizable
            public final void writeExternal(ObjectOutput objectOutput) {
                AppMethodBeat.i(153423);
                synchronized (c.hoU) {
                    try {
                        objectOutput.writeUTF(this.mProcessName);
                        objectOutput.writeUTF(this.hoO);
                        objectOutput.writeInt(this.hoY);
                        objectOutput.writeInt(this.hoZ);
                        objectOutput.writeLong(this.hpa);
                    } finally {
                        AppMethodBeat.o(153423);
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0099 A[SYNTHETIC, Splitter:B:22:0x0099] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[SYNTHETIC, Splitter:B:28:0x00a4] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void lH() {
            /*
            // Method dump skipped, instructions count: 213
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.jni.a.a.c.lH():void");
        }

        public static void detach() {
            AppMethodBeat.i(153425);
            if (hoQ > 0) {
                MMApplicationContext.getContext().unregisterReceiver(hoV);
                ayF();
                hoQ = 0;
                Log.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", MMApplicationContext.getProcessName());
            }
            AppMethodBeat.o(153425);
        }

        public static void Fv(String str) {
            AppMethodBeat.i(153426);
            u(str, true);
            AppMethodBeat.o(153426);
        }

        public static void Fw(String str) {
            AppMethodBeat.i(153427);
            u(str, false);
            AppMethodBeat.o(153427);
        }

        private static void u(String str, boolean z) {
            AppMethodBeat.i(153428);
            int myPid = Process.myPid();
            String processName = MMApplicationContext.getProcessName();
            if (myPid == hoQ) {
                if (z) {
                    c(processName, str, SystemClock.elapsedRealtime());
                    AppMethodBeat.o(153428);
                    return;
                }
                d(processName, str, SystemClock.elapsedRealtime());
                AppMethodBeat.o(153428);
            } else if (z) {
                Intent intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                MMApplicationContext.getContext().sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
                AppMethodBeat.o(153428);
            } else {
                Intent intent2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                intent2.putExtra("pid", myPid);
                intent2.putExtra("processName", processName);
                intent2.putExtra("traceMsg", str);
                intent2.putExtra("tick", SystemClock.elapsedRealtime());
                MMApplicationContext.getContext().sendBroadcast(intent2, WeChatPermissions.PERMISSION_MM_MESSAGE());
                AppMethodBeat.o(153428);
            }
        }

        private static void c(String str, String str2, long j2) {
            AppMethodBeat.i(153429);
            String str3 = str + "_" + str2;
            synchronized (hoU) {
                try {
                    C0362a aVar = hoT.get(str3);
                    if (aVar == null) {
                        aVar = new C0362a((byte) 0);
                        aVar.mProcessName = str;
                        aVar.hoO = str2;
                        aVar.hpa = 0;
                        aVar.hoY = 0;
                        aVar.hoZ = 0;
                        hoT.put(str3, aVar);
                    }
                    if (aVar.hpc.getAndIncrement() == 0) {
                        aVar.hpb = j2;
                        aVar.hoW = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                        aVar.hoX = CrashReportFactory.foreground;
                    }
                } finally {
                    AppMethodBeat.o(153429);
                }
            }
        }

        private static void d(String str, String str2, long j2) {
            AppMethodBeat.i(153430);
            String str3 = str + "_" + str2;
            long j3 = 0;
            synchronized (hoU) {
                try {
                    C0362a aVar = hoT.get(str3);
                    if (aVar != null && aVar.hpc.get() > 0) {
                        aVar.hoY++;
                        if (aVar.hpc.decrementAndGet() == 0) {
                            j3 = j2 - aVar.hpb;
                            aVar.hpa += j3;
                            aVar.hoZ++;
                        }
                    }
                } finally {
                    AppMethodBeat.o(153430);
                }
            }
            ayE();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (j3 >= 14000 || elapsedRealtime - hoS >= Util.MILLSECONDS_OF_HOUR) {
                Log.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                ayF();
                hoS = elapsedRealtime;
            }
        }

        private static void ayE() {
            AppMethodBeat.i(153431);
            synchronized (hoU) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime - hoR >= 21600000) {
                        if (!hoT.isEmpty()) {
                            StringBuilder sb = new StringBuilder();
                            for (Map.Entry<String, C0362a> entry : hoT.entrySet()) {
                                C0362a value = entry.getValue();
                                if (value.hoZ > 0) {
                                    sb.setLength(0);
                                    sb.append(value.mProcessName).append(',').append(value.hoO.replace(",", "##")).append(',').append(value.hoZ).append(',').append(value.hoY).append(',').append(value.hpa).append(',').append(value.hoX ? 1 : 0).append(',').append(value.hoW);
                                    String sb2 = sb.toString();
                                    sc scVar = new sc();
                                    scVar.dYF.dYG = sb2;
                                    EventCenter.instance.publish(scVar);
                                    Log.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", sb.toString());
                                }
                            }
                            hoT.clear();
                        }
                        hoR = elapsedRealtime;
                    }
                } finally {
                    AppMethodBeat.o(153431);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0062 A[SYNTHETIC, Splitter:B:13:0x0062] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[SYNTHETIC, Splitter:B:27:0x008e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void ayF() {
            /*
            // Method dump skipped, instructions count: 168
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.jni.a.a.c.ayF():void");
        }
    }

    public static void ayA() {
        AppMethodBeat.i(153435);
        c.lH();
        AppMethodBeat.o(153435);
    }

    public static void ayB() {
        AppMethodBeat.i(153436);
        c.detach();
        AppMethodBeat.o(153436);
    }

    public static void a(WakerLock wakerLock, String str) {
        AppMethodBeat.i(153437);
        synchronized (mLock) {
            try {
                b bVar = hoJ.get(wakerLock.hashCode());
                if (bVar == null) {
                    bVar = new b(wakerLock);
                    hoJ.put(wakerLock.hashCode(), bVar);
                }
                if (!bVar.hoN.containsKey(str)) {
                    bVar.hoN.put(str, new b.C0361a(str, SystemClock.elapsedRealtime()));
                }
                c.Fv(str);
                MMHandler mMHandler = mHandler;
                if (!bVar.hoL) {
                    bVar.hoL = true;
                    mMHandler.postDelayed(bVar.hoM, Util.MILLSECONDS_OF_MINUTE);
                }
            } finally {
                AppMethodBeat.o(153437);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        AppMethodBeat.i(153438);
        synchronized (mLock) {
            try {
                b bVar = hoJ.get(wakerLock.hashCode());
                if (bVar != null) {
                    MMHandler mMHandler = mHandler;
                    if (bVar.hoL) {
                        bVar.hoL = false;
                        mMHandler.removeCallbacks(bVar.hoM);
                    }
                    for (b.C0361a aVar : bVar.hoN.values()) {
                        c.Fw(aVar.hoO);
                    }
                    bVar.hoN.clear();
                }
            } finally {
                AppMethodBeat.o(153438);
            }
        }
    }
}
