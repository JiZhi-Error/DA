package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.b;
import com.tencent.mm.hardcoder.c;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final int[] hkT = {0, 1, 2, 3};
    private static final int[] hkU = {0, 1, 2, 3};
    private b hkV = new b();
    private Thread hkW;
    private HardCoderJNI.HCPerfManagerThread hkX;
    LinkedBlockingQueue<Object> hkY = new LinkedBlockingQueue<>();

    public static class c {
        public int aHK = 0;
        public long hla = 0;
    }

    static /* synthetic */ void fW(String str) {
        AppMethodBeat.i(62448);
        Fj(str);
        AppMethodBeat.o(62448);
    }

    public static class b {
        public int delay = 0;
        public long hla = 0;
        public int hlb = 0;
        public int hlc = 0;
        public int hld = 0;
        public int[] hle = null;
        public long hlf = 0;
        public long hlg = 0;
        public long hlh = 0;
        public int hli = 0;
        public int hlj = 0;
        public int hlk = 0;
        public int[] hll = new int[a.hkT.length];
        public int[] hlm = new int[a.hkU.length];
        public int[] hln = null;
        public long hlo = 0;
        public long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;
        public int timeout = 0;

        public b() {
            AppMethodBeat.i(62442);
            AppMethodBeat.o(62442);
        }

        public final boolean axM() {
            return this.hle != null && this.hle.length > 0 && (this.hle.length != 1 || this.hle[0] > 0);
        }

        public final String axN() {
            AppMethodBeat.i(62443);
            if (axM()) {
                StringBuilder sb = new StringBuilder("[");
                int[] iArr = this.hle;
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    sb.append(iArr[i2] + " ");
                }
                sb.append("]");
                String sb2 = sb.toString();
                AppMethodBeat.o(62443);
                return sb2;
            }
            AppMethodBeat.o(62443);
            return "[ ]";
        }

        public final String toString(long j2) {
            AppMethodBeat.i(62444);
            String format = String.format("hashCode:%x time:[init:%d, start:%d, stop:%d][delay:%d, timeout:%d][scene:%d, action:%d, callerTid:%d][cpu:%d, io:%d, gpu:%d] bindTids:%s [TAG:%s]", Integer.valueOf(hashCode()), Long.valueOf(this.hlg - j2), Long.valueOf(this.startTime - j2), Long.valueOf(this.hlh - j2), Integer.valueOf(this.delay), Integer.valueOf(this.timeout), Integer.valueOf(this.scene), Long.valueOf(this.hlf), Integer.valueOf(this.hli), Integer.valueOf(this.hlb), Integer.valueOf(this.hld), Integer.valueOf(this.hlc), axN(), this.tag);
            AppMethodBeat.o(62444);
            return format;
        }
    }

    public a(HardCoderJNI.HCPerfManagerThread hCPerfManagerThread) {
        AppMethodBeat.i(62445);
        this.hkV.start();
        this.hkX = hCPerfManagerThread;
        this.hkW = this.hkX.newThread(new RunnableC0349a(this, (byte) 0), "HCPerfManager", 10);
        this.hkW.start();
        d.i("Hardcoder.HCPerfManager", String.format("HCPerfManager new thread[%s]", this.hkW));
        AppMethodBeat.o(62445);
    }

    /* renamed from: com.tencent.mm.hardcoder.a$a  reason: collision with other inner class name */
    class RunnableC0349a implements Runnable {
        private boolean running;

        private RunnableC0349a() {
            this.running = false;
        }

        /* synthetic */ RunnableC0349a(a aVar, byte b2) {
            this();
        }

        public final void run() {
            long id;
            String bVar;
            String bVar2;
            String bVar3;
            String bVar4;
            int i2;
            int i3;
            int i4;
            String bVar5;
            int i5;
            int i6;
            int i7;
            int i8;
            String bVar6;
            int i9;
            int i10;
            int i11;
            String bVar7;
            String bVar8;
            String bVar9;
            String bVar10;
            String bVar11;
            String bVar12;
            boolean z;
            Object obj;
            AppMethodBeat.i(62441);
            Object[] objArr = new Object[2];
            if (Thread.currentThread() == null) {
                id = -1;
            } else {
                id = Thread.currentThread().getId();
            }
            objArr[0] = Long.valueOf(id);
            objArr[1] = Thread.currentThread().getName();
            d.i("Hardcoder.HCPerfManager", String.format("HCPerfManager thread run start, id:%d, name:%s", objArr));
            this.running = true;
            HashSet hashSet = new HashSet();
            long j2 = 30000;
            ArrayList arrayList = new ArrayList();
            long[] axO = f.axO();
            if (axO == null || axO.length < 2) {
                axO = new long[]{0, 0};
                d.d("Hardcoder.HardCoderReporter", "process jiffies info is invalid");
            }
            d.d("Hardcoder.HardCoderReporter", "process:[" + axO[0] + "," + axO[1] + "]");
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = hashSet;
            b bVar13 = null;
            b bVar14 = null;
            b bVar15 = null;
            while (this.running) {
                long currentTimeMillis = System.currentTimeMillis();
                int size = a.this.hkY.size();
                d.d("Hardcoder.HCPerfManager", "startLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j2);
                int i12 = 0;
                while (true) {
                    if (i12 >= (size == 0 ? 1 : size)) {
                        break;
                    }
                    try {
                        obj = a.this.hkY.poll(j2, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                        d.e("Hardcoder.HCPerfManager", "taskQueue poll: " + e2.getMessage());
                        obj = null;
                    }
                    if (obj == null) {
                        break;
                    }
                    if (obj instanceof b) {
                        arrayList.add((b) obj);
                        hashSet2.add(Integer.valueOf(((b) obj).hashCode()));
                    } else if (!(obj instanceof c)) {
                        if (!HardCoderJNI.isCheckEnv()) {
                            this.running = false;
                            break;
                        }
                        a.fW("taskQueue poll invalid object");
                    } else {
                        int i13 = ((c) obj).aHK;
                        if (hashSet2.contains(Integer.valueOf(i13))) {
                            hashMap.put(Integer.valueOf(i13), (c) obj);
                        }
                    }
                    i12++;
                }
                long j3 = 30000;
                b bVar16 = null;
                b bVar17 = null;
                b bVar18 = null;
                HashSet hashSet4 = new HashSet();
                long currentTimeMillis2 = System.currentTimeMillis();
                d.d("Hardcoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
                int i14 = 0;
                while (true) {
                    int i15 = i14;
                    if (i15 >= arrayList.size()) {
                        break;
                    }
                    b bVar19 = (b) arrayList.get(i15);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (bVar19 != null) {
                        if (hashMap.containsKey(Integer.valueOf(bVar19.hashCode()))) {
                            bVar19.hlh = currentTimeMillis3;
                            bVar19.hla = ((c) hashMap.get(Integer.valueOf(bVar19.hashCode()))).hla;
                            hashMap.remove(Integer.valueOf(bVar19.hashCode()));
                            a.a(a.this, currentTimeMillis3, arrayList, -2, -2, -2, null);
                            a.a(a.this, bVar19);
                        }
                        long j4 = bVar19.hlh - currentTimeMillis3;
                        if (j4 <= 0) {
                            d.d("Hardcoder.HCPerfManager", "InLoop STOP:" + i15 + FilePathGenerator.ANDROID_DIR_SEP + arrayList.size() + " task:" + bVar19.toString(currentTimeMillis3));
                            arrayList.remove(bVar19);
                            hashSet2.remove(Integer.valueOf(bVar19.hashCode()));
                            i15--;
                        } else {
                            j3 = Math.min(j3, j4);
                            long j5 = bVar19.startTime - currentTimeMillis3;
                            if (j5 > 0) {
                                d.d("Hardcoder.HCPerfManager", "InLoop WAIT:" + i15 + FilePathGenerator.ANDROID_DIR_SEP + arrayList.size() + " task:" + bVar19.toString(currentTimeMillis3));
                                j3 = Math.min(j3, j5);
                            } else {
                                d.d("Hardcoder.HCPerfManager", "InLoop RUN:" + i15 + FilePathGenerator.ANDROID_DIR_SEP + arrayList.size() + " task:" + bVar19.toString(currentTimeMillis3));
                                if (bVar19.hlb > 0 && (bVar16 == null || bVar16.hlb > bVar19.hlb || (bVar16.hlb == bVar19.hlb && bVar16.hlh < bVar19.hlh))) {
                                    bVar16 = bVar19;
                                }
                                if (bVar19.hlc > 0 && (bVar17 == null || bVar17.hlc > bVar19.hlc || (bVar17.hlc == bVar19.hlc && bVar17.hlh < bVar19.hlh))) {
                                    bVar17 = bVar19;
                                }
                                if (bVar19.hld > 0 && (bVar18 == null || bVar18.hld > bVar19.hld || (bVar18.hld == bVar19.hld && bVar18.hlh < bVar19.hlh))) {
                                    bVar18 = bVar19;
                                }
                                int[] iArr = bVar19.hle;
                                int length = iArr.length;
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= length) {
                                        break;
                                    } else if (iArr[i16] > 0) {
                                        hashSet4.add(bVar19);
                                        break;
                                    } else {
                                        i16++;
                                    }
                                }
                            }
                        }
                    }
                    i14 = i15 + 1;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                d.d("Hardcoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", Long.valueOf(currentTimeMillis4 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())));
                StringBuilder append = new StringBuilder("EndLoop CurrCpu:").append(bVar15 == null ? BuildConfig.COMMAND : bVar15.toString(currentTimeMillis2)).append(" -> MaxCpu:");
                if (bVar16 == null) {
                    bVar = BuildConfig.COMMAND;
                } else {
                    bVar = bVar16.toString(currentTimeMillis2);
                }
                d.d("Hardcoder.HCPerfManager", append.append(bVar).toString());
                StringBuilder append2 = new StringBuilder("EndLoop CurrGpu:").append(bVar14 == null ? BuildConfig.COMMAND : bVar14.toString(currentTimeMillis2)).append(" -> MaxGpu:");
                if (bVar14 == null) {
                    bVar2 = BuildConfig.COMMAND;
                } else {
                    bVar2 = bVar14.toString(currentTimeMillis2);
                }
                d.d("Hardcoder.HCPerfManager", append2.append(bVar2).toString());
                StringBuilder append3 = new StringBuilder("EndLoop CurrIO:").append(bVar13 == null ? BuildConfig.COMMAND : bVar13.toString(currentTimeMillis2)).append(" -> MaxIO:");
                if (bVar18 == null) {
                    bVar3 = BuildConfig.COMMAND;
                } else {
                    bVar3 = bVar18.toString(currentTimeMillis2);
                }
                d.d("Hardcoder.HCPerfManager", append3.append(bVar3).toString());
                d.d("Hardcoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet4.size())));
                HashSet hashSet5 = new HashSet();
                hashSet5.addAll(hashSet3);
                hashSet5.removeAll(hashSet4);
                if (bVar16 == bVar15 && bVar17 == bVar14 && bVar18 == bVar13 && hashSet3.size() == hashSet4.size() && hashSet5.isEmpty()) {
                    d.d("Hardcoder.HCPerfManager", "EndLoop Nothing Changed, Continue.");
                    j2 = j3;
                } else {
                    Iterator it = hashSet5.iterator();
                    int i17 = 0;
                    while (it.hasNext()) {
                        b bVar20 = (b) it.next();
                        if (bVar20.hle != null) {
                            i17 = bVar20.hle.length + i17;
                        }
                    }
                    if (i17 > 0) {
                        int[] iArr2 = new int[i17];
                        Iterator it2 = hashSet5.iterator();
                        int i18 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            b bVar21 = (b) it2.next();
                            long currentTimeMillis5 = System.currentTimeMillis();
                            d.i("Hardcoder.HCPerfManager", "!cancelBindCore task:" + bVar21.toString(currentTimeMillis5));
                            if (bVar21.hlh > currentTimeMillis5) {
                                d.e("Hardcoder.HCPerfManager", "stopTime:" + (bVar21.hlh - currentTimeMillis5) + ". Error !");
                            } else {
                                if (!bVar21.axM()) {
                                    if (!HardCoderJNI.isCheckEnv()) {
                                        this.running = false;
                                        break;
                                    }
                                    a.fW("bindTids:" + bVar21.axN());
                                }
                                int[] iArr3 = bVar21.hle;
                                int i19 = i18;
                                for (int i20 : iArr3) {
                                    iArr2[i19] = i20;
                                    i19++;
                                }
                                i18 = i19;
                            }
                        }
                        if (HardCoderJNI.isCheckEnv()) {
                            HardCoderJNI.cancelCpuCoreForThread(iArr2, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                        }
                        a.a(a.this, currentTimeMillis2, arrayList, -2, -2, -2, null);
                    }
                    Iterator it3 = hashSet4.iterator();
                    int i21 = 0;
                    while (it3.hasNext()) {
                        b bVar22 = (b) it3.next();
                        if (bVar22.hle != null) {
                            i21 = bVar22.hle.length + i21;
                        }
                    }
                    int[] iArr4 = new int[i21];
                    Iterator it4 = hashSet4.iterator();
                    long j6 = 0;
                    int i22 = 0;
                    int i23 = 0;
                    int i24 = Integer.MAX_VALUE;
                    int i25 = 0;
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        b bVar23 = (b) it4.next();
                        d.i("Hardcoder.HCPerfManager", "requestBindCore task:" + bVar23.toString(currentTimeMillis2));
                        long currentTimeMillis6 = System.currentTimeMillis();
                        if (bVar23.hlh <= currentTimeMillis6) {
                            d.e("Hardcoder.HCPerfManager", "stopTime:" + (bVar23.hlh - currentTimeMillis6) + ". Error !");
                        } else {
                            if (!bVar23.axM()) {
                                if (!HardCoderJNI.isCheckEnv()) {
                                    this.running = false;
                                    break;
                                }
                                a.fW("bindTids:" + bVar23.axN());
                            }
                            for (int i26 : bVar23.hle) {
                                iArr4[i23] = i26;
                                i23++;
                            }
                            i22 = bVar23.scene;
                            j6 = bVar23.hlf;
                            int i27 = bVar23.hli;
                            i24 = Math.min((int) (bVar23.hlh - currentTimeMillis2), i24);
                            i25 = i27;
                        }
                    }
                    if (bVar18 == null) {
                        if (bVar13 != null) {
                            d.i("Hardcoder.HCPerfManager", "!cancelHighIOFreq task:" + bVar13.toString(currentTimeMillis2));
                            if (HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelHighIOFreq(bVar13.hli, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -2, -2, -1, null);
                        }
                    } else if (bVar13 != bVar18) {
                        StringBuilder sb = new StringBuilder("IOReq:");
                        if (bVar13 == null) {
                            bVar4 = BuildConfig.COMMAND;
                        } else {
                            bVar4 = bVar13.toString(currentTimeMillis2);
                        }
                        d.d("Hardcoder.HCPerfManager", sb.append(bVar4).append(" -> ").append(bVar18.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis4 - bVar18.startTime).toString());
                    }
                    if (bVar18 != null) {
                        i2 = bVar18.hld;
                        i22 = bVar18.scene;
                        j6 = bVar18.hlf;
                        i4 = bVar18.hli;
                        i3 = Math.min((int) (bVar18.hlh - currentTimeMillis2), i24);
                    } else {
                        i2 = 0;
                        i3 = i24;
                        i4 = i25;
                    }
                    if (bVar17 == null) {
                        if (bVar14 != null) {
                            d.i("Hardcoder.HCPerfManager", "!cancelGpuHighFreq task:" + bVar14.toString(currentTimeMillis2));
                            if (HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelGpuHighFreq(bVar14.hli, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -2, -1, -2, null);
                        }
                    } else if (bVar14 != bVar17) {
                        StringBuilder sb2 = new StringBuilder("GPUReq:");
                        if (bVar14 == null) {
                            bVar5 = BuildConfig.COMMAND;
                        } else {
                            bVar5 = bVar14.toString(currentTimeMillis2);
                        }
                        d.d("Hardcoder.HCPerfManager", sb2.append(bVar5).append(" -> ").append(bVar17.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis4 - bVar17.startTime).toString());
                    }
                    if (bVar17 != null) {
                        i6 = bVar17.hlc;
                        int i28 = bVar17.scene;
                        long j7 = bVar17.hlf;
                        int i29 = bVar17.hli;
                        i7 = Math.min((int) (bVar17.hlh - currentTimeMillis2), i3);
                        j6 = j7;
                        i5 = i28;
                        i8 = i29;
                    } else {
                        i5 = i22;
                        i6 = 0;
                        i7 = i3;
                        i8 = i4;
                    }
                    if (bVar16 == null) {
                        if (bVar15 != null) {
                            d.i("Hardcoder.HCPerfManager", "!cancelCpuHighFreq task:" + bVar15.toString(currentTimeMillis2));
                            if (HardCoderJNI.isCheckEnv()) {
                                HardCoderJNI.cancelCpuHighFreq(bVar15.hli, SystemClock.elapsedRealtimeNanos());
                            }
                            a.a(a.this, currentTimeMillis2, arrayList, -1, -2, -2, null);
                        }
                    } else if (bVar15 != bVar16) {
                        StringBuilder sb3 = new StringBuilder("CPUReq:");
                        if (bVar15 == null) {
                            bVar6 = BuildConfig.COMMAND;
                        } else {
                            bVar6 = bVar15.toString(currentTimeMillis2);
                        }
                        d.d("Hardcoder.HCPerfManager", sb3.append(bVar6).append(" -> ").append(bVar16.toString(currentTimeMillis2)).append(" delay:").append(currentTimeMillis4 - bVar16.startTime).toString());
                    }
                    if (bVar16 != null) {
                        i10 = bVar16.hlb;
                        i9 = bVar16.scene;
                        j6 = bVar16.hlf;
                        i11 = bVar16.hli;
                        i7 = Math.min((int) (bVar16.hlh - currentTimeMillis2), i7);
                    } else {
                        i9 = i5;
                        i10 = 0;
                        i11 = i8;
                    }
                    if (i7 < Integer.MAX_VALUE) {
                        Object[] objArr2 = new Object[14];
                        objArr2[0] = Integer.valueOf(i9);
                        objArr2[1] = Long.valueOf(j6);
                        objArr2[2] = Integer.valueOf(i11);
                        objArr2[3] = Integer.valueOf(i10);
                        objArr2[4] = Integer.valueOf(i6);
                        objArr2[5] = Integer.valueOf(i2);
                        objArr2[6] = Integer.valueOf(iArr4.length);
                        objArr2[7] = Integer.valueOf(i7);
                        if (bVar16 == null) {
                            bVar7 = BuildConfig.COMMAND;
                        } else {
                            bVar7 = bVar16.toString(currentTimeMillis2);
                        }
                        objArr2[8] = bVar7;
                        if (bVar17 == null) {
                            bVar8 = BuildConfig.COMMAND;
                        } else {
                            bVar8 = bVar17.toString(currentTimeMillis2);
                        }
                        objArr2[9] = bVar8;
                        if (bVar18 == null) {
                            bVar9 = BuildConfig.COMMAND;
                        } else {
                            bVar9 = bVar18.toString(currentTimeMillis2);
                        }
                        objArr2[10] = bVar9;
                        if (bVar16 == null) {
                            bVar10 = BuildConfig.COMMAND;
                        } else {
                            bVar10 = bVar16.toString(currentTimeMillis2);
                        }
                        objArr2[11] = bVar10;
                        if (bVar17 == null) {
                            bVar11 = BuildConfig.COMMAND;
                        } else {
                            bVar11 = bVar17.toString(currentTimeMillis2);
                        }
                        objArr2[12] = bVar11;
                        if (bVar18 == null) {
                            bVar12 = BuildConfig.COMMAND;
                        } else {
                            bVar12 = bVar18.toString(currentTimeMillis2);
                        }
                        objArr2[13] = bVar12;
                        d.i("Hardcoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d,%d] TO:%d max CPU:%s GPU:%s IO:%s cur CPU:%s GPU:%s IO:%s", objArr2));
                        a.el(i7 > 0);
                        a.el(i9 > 0 || j6 > 0);
                        a.el(i11 > 0);
                        if (i10 > 0 || i6 > 0 || i2 > 0 || iArr4.length > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        a.el(z);
                        if (HardCoderJNI.isCheckEnv()) {
                            long requestUnifyCpuIOThreadCoreGpu = HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(i9, j6, i10, i6, i2, iArr4, i7, i11, SystemClock.elapsedRealtimeNanos());
                            HardCoderJNI.putRequestStatusHashMap(requestUnifyCpuIOThreadCoreGpu, new c.C0350c(i9, j6, i10, i6, i2, iArr4));
                            d.i("Hardcoder.HCPerfManager", "hardcoder requestUnifyCpuIOThreadCoreGpu requestId:" + requestUnifyCpuIOThreadCoreGpu + "reqScene[" + i9 + ", " + j6 + "] running[enable:" + HardCoderJNI.isHcEnable() + ", env:" + (HardCoderJNI.isCheckEnv() && HardCoderJNI.isRunning() > 0) + "]");
                            if (HardCoderJNI.sceneReportCallback != null) {
                                HardCoderJNI.sceneReportCallback.sceneReport(i9, j6);
                            }
                        }
                        a.a(a.this, currentTimeMillis2, arrayList, i10, i6, i2, iArr4);
                    }
                    j2 = j3;
                    hashSet3 = hashSet4;
                    bVar13 = bVar18;
                    bVar14 = bVar17;
                    bVar15 = bVar16;
                }
            }
            d.i("Hardcoder.HCPerfManager", "HCPerfManager thread run end.");
            AppMethodBeat.o(62441);
        }
    }

    private static void Fj(String str) {
        AppMethodBeat.i(62447);
        if (str == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62447);
            throw assertionError;
        }
        AssertionError assertionError2 = new AssertionError(str);
        AppMethodBeat.o(62447);
        throw assertionError2;
    }

    public final int a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, long j2, int i8, String str) {
        boolean z;
        AppMethodBeat.i(62446);
        if (i2 < 0 || i3 < 0 || i5 < 0 || i4 < 0 || iArr == null || iArr.length <= 0 || i6 <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z || (i3 == 0 && i4 == 0 && i5 == 0 && iArr.length == 1 && iArr[0] == 0)) {
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(iArr == null ? 0 : iArr.length);
            objArr[5] = Integer.valueOf(i6);
            d.e("Hardcoder.HCPerfManager", String.format("start error params, ignore this task! delay:%d, [cpu:%d, io:%d, gpu:%d], bindTids:%d, timeout:%d", objArr));
            AppMethodBeat.o(62446);
            return 0;
        }
        b bVar = new b();
        bVar.delay = i2;
        bVar.hlb = i3;
        bVar.hld = i4;
        bVar.hle = (int[]) iArr.clone();
        bVar.hlc = i5;
        bVar.timeout = i6;
        bVar.scene = i7;
        bVar.hlf = j2;
        bVar.hli = i8;
        bVar.hlg = System.currentTimeMillis();
        bVar.startTime = bVar.hlg + ((long) i2);
        bVar.hlh = bVar.hlg + ((long) i2) + ((long) i6);
        bVar.tag = str;
        bVar.lastUpdateTime = bVar.startTime;
        boolean offer = this.hkY.offer(bVar);
        d.d("Hardcoder.HCPerfManager", String.format("start ret:%b ,task:%s", Boolean.valueOf(offer), bVar.toString(bVar.hlg)));
        if (offer) {
            int hashCode = bVar.hashCode();
            AppMethodBeat.o(62446);
            return hashCode;
        }
        AppMethodBeat.o(62446);
        return 0;
    }

    static /* synthetic */ void a(a aVar, long j2, List list, int i2, int i3, int i4, int[] iArr) {
        AppMethodBeat.i(62449);
        aVar.hkV.bc(new b.a(j2, new ArrayList(list), i2, i3, i4, iArr));
        AppMethodBeat.o(62449);
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        AppMethodBeat.i(62450);
        d.d("Hardcoder.HCPerfManager", "reportPerformanceTask:" + bVar.hashCode());
        aVar.hkV.bc(bVar);
        AppMethodBeat.o(62450);
    }

    static /* synthetic */ void el(boolean z) {
        AppMethodBeat.i(62451);
        if (!z) {
            Fj(null);
        }
        AppMethodBeat.o(62451);
    }
}
