package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.c.a.a;
import com.tencent.matrix.trace.e.b;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends f implements Application.ActivityLifecycleCallbacks {
    private final com.tencent.matrix.trace.a.b daS;
    public a dco;
    public int dcp = 0;
    private final long dcq;
    private long dcr;
    private boolean dcs;
    private long dct;
    private long dcu;
    private long dcv;
    private long dcw;
    public int dcx = 0;
    private long dcy = 0;
    private Map<String, Long> dcz = new HashMap();
    private final HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet<>();

    public interface a {
        void a(int i2, String str, long j2);
    }

    public c(com.tencent.matrix.trace.a.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.daS = bVar;
        this.dcq = com.tencent.matrix.trace.core.b.Tw().cPm;
        if (bVar.cVx == null) {
            i2 = 10000;
        } else {
            i2 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_trace_fps_time_slice.name(), 10000);
        }
        this.dcr = (long) i2;
        this.dcs = bVar.daK;
        if (bVar.cVx == null) {
            i3 = 42;
        } else {
            i3 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_fps_dropped_frozen.name(), 42);
        }
        this.dct = (long) i3;
        if (bVar.cVx == null) {
            i4 = 24;
        } else {
            i4 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_fps_dropped_high.name(), 24);
        }
        this.dcu = (long) i4;
        if (bVar.cVx == null) {
            i5 = 3;
        } else {
            i5 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_fps_dropped_normal.name(), 3);
        }
        this.dcw = (long) i5;
        if (bVar.cVx == null) {
            i6 = 9;
        } else {
            i6 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_fps_dropped_middle.name(), 9);
        }
        this.dcv = (long) i6;
        com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", Long.valueOf(this.dcq), Boolean.valueOf(this.dcs));
        if (this.dcs) {
            a(new C0237c(this, (byte) 0));
        }
    }

    public final void a(com.tencent.matrix.trace.e.b bVar) {
        synchronized (this.listeners) {
            this.listeners.add(bVar);
        }
    }

    public final void b(com.tencent.matrix.trace.e.b bVar) {
        synchronized (this.listeners) {
            this.listeners.remove(bVar);
        }
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onAlive() {
        super.onAlive();
        com.tencent.matrix.trace.core.b.Tw().a(this);
        if (this.dcs) {
            com.tencent.matrix.b.RG().application.registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onDead() {
        super.onDead();
        com.tencent.matrix.trace.core.b.Tw().b(this);
        this.dco = null;
        if (this.dcs) {
            com.tencent.matrix.b.RG().application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: com.tencent.matrix.trace.f.c$c  reason: collision with other inner class name */
    class C0237c extends com.tencent.matrix.trace.e.b {
        private Handler dcQ;
        Executor executor;
        private HashMap<String, d> map;

        private C0237c() {
            this.dcQ = new Handler(com.tencent.matrix.g.b.TP().getLooper());
            this.executor = new Executor() {
                /* class com.tencent.matrix.trace.f.c.C0237c.AnonymousClass1 */

                public final void execute(Runnable runnable) {
                    C0237c.this.dcQ.post(runnable);
                }
            };
            this.map = new HashMap<>();
        }

        /* synthetic */ C0237c(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.matrix.trace.e.b
        public final Executor getExecutor() {
            return this.executor;
        }

        @Override // com.tencent.matrix.trace.e.b
        public final int TD() {
            return 300;
        }

        @Override // com.tencent.matrix.trace.e.b
        public final void L(List<b.a> list) {
            d dVar;
            super.L(list);
            for (b.a aVar : list) {
                String str = aVar.dbP;
                int i2 = aVar.dbS;
                boolean z = aVar.dbn;
                if (!com.tencent.matrix.trace.g.b.eP(str) && z) {
                    d dVar2 = this.map.get(str);
                    if (dVar2 == null) {
                        d dVar3 = new d(str);
                        this.map.put(str, dVar3);
                        dVar = dVar3;
                    } else {
                        dVar = dVar2;
                    }
                    dVar.dcS = (long) ((((1.0f * ((float) com.tencent.matrix.trace.core.b.Tw().cPm)) / 1000000.0f) * ((float) (i2 + 1))) + ((float) dVar.dcS));
                    dVar.dcU += i2;
                    dVar.dcT++;
                    if (((long) i2) >= c.this.dct) {
                        int[] iArr = dVar.dcV;
                        int i3 = b.DROPPED_FROZEN.index;
                        iArr[i3] = iArr[i3] + 1;
                        int[] iArr2 = dVar.dcW;
                        int i4 = b.DROPPED_FROZEN.index;
                        iArr2[i4] = i2 + iArr2[i4];
                    } else if (((long) i2) >= c.this.dcu) {
                        int[] iArr3 = dVar.dcV;
                        int i5 = b.DROPPED_HIGH.index;
                        iArr3[i5] = iArr3[i5] + 1;
                        int[] iArr4 = dVar.dcW;
                        int i6 = b.DROPPED_HIGH.index;
                        iArr4[i6] = i2 + iArr4[i6];
                    } else if (((long) i2) >= c.this.dcv) {
                        int[] iArr5 = dVar.dcV;
                        int i7 = b.DROPPED_MIDDLE.index;
                        iArr5[i7] = iArr5[i7] + 1;
                        int[] iArr6 = dVar.dcW;
                        int i8 = b.DROPPED_MIDDLE.index;
                        iArr6[i8] = i2 + iArr6[i8];
                    } else if (((long) i2) >= c.this.dcw) {
                        int[] iArr7 = dVar.dcV;
                        int i9 = b.DROPPED_NORMAL.index;
                        iArr7[i9] = iArr7[i9] + 1;
                        int[] iArr8 = dVar.dcW;
                        int i10 = b.DROPPED_NORMAL.index;
                        iArr8[i10] = i2 + iArr8[i10];
                    } else {
                        int[] iArr9 = dVar.dcV;
                        int i11 = b.DROPPED_BEST.index;
                        iArr9[i11] = iArr9[i11] + 1;
                        int[] iArr10 = dVar.dcW;
                        int i12 = b.DROPPED_BEST.index;
                        iArr10[i12] = Math.max(i2, 0) + iArr10[i12];
                    }
                    if (dVar.dcS >= c.this.dcr) {
                        this.map.remove(str);
                        float min = Math.min(60.0f, (1000.0f * ((float) dVar.dcT)) / ((float) dVar.dcS));
                        com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", Float.valueOf(min), dVar.toString());
                        try {
                            com.tencent.matrix.trace.a aVar2 = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
                            if (aVar2 != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(b.DROPPED_FROZEN.name(), dVar.dcV[b.DROPPED_FROZEN.index]);
                                jSONObject.put(b.DROPPED_HIGH.name(), dVar.dcV[b.DROPPED_HIGH.index]);
                                jSONObject.put(b.DROPPED_MIDDLE.name(), dVar.dcV[b.DROPPED_MIDDLE.index]);
                                jSONObject.put(b.DROPPED_NORMAL.name(), dVar.dcV[b.DROPPED_NORMAL.index]);
                                jSONObject.put(b.DROPPED_BEST.name(), dVar.dcV[b.DROPPED_BEST.index]);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(b.DROPPED_FROZEN.name(), dVar.dcW[b.DROPPED_FROZEN.index]);
                                jSONObject2.put(b.DROPPED_HIGH.name(), dVar.dcW[b.DROPPED_HIGH.index]);
                                jSONObject2.put(b.DROPPED_MIDDLE.name(), dVar.dcW[b.DROPPED_MIDDLE.index]);
                                jSONObject2.put(b.DROPPED_NORMAL.name(), dVar.dcW[b.DROPPED_NORMAL.index]);
                                jSONObject2.put(b.DROPPED_BEST.name(), dVar.dcW[b.DROPPED_BEST.index]);
                                JSONObject a2 = com.tencent.matrix.g.a.a(new JSONObject(), aVar2.getApplication());
                                a2.put("scene", dVar.cPC);
                                a2.put("dropLevel", jSONObject);
                                a2.put("dropSum", jSONObject2);
                                a2.put("fps", (double) min);
                                com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                                cVar.tag = "Trace_FPS";
                                cVar.cWe = a2;
                                aVar2.onDetectIssue(cVar);
                                dVar.dcT = 0;
                                dVar.dcU = 0;
                                dVar.dcS = 0;
                            }
                        } catch (JSONException e2) {
                            com.tencent.matrix.g.c.e("Matrix.FrameTracer", "json error", e2);
                        } finally {
                            dVar.dcT = 0;
                            dVar.dcU = 0;
                            dVar.dcS = 0;
                        }
                    }
                }
            }
        }
    }

    class d {
        String cPC;
        long dcS;
        int dcT = 0;
        int dcU;
        int[] dcV = new int[b.values().length];
        int[] dcW = new int[b.values().length];

        d(String str) {
            this.cPC = str;
        }

        public final String toString() {
            return "visibleScene=" + this.cPC + ", sumFrame=" + this.dcT + ", sumDroppedFrames=" + this.dcU + ", sumFrameCost=" + this.dcS + ", dropLevel=" + Arrays.toString(this.dcV);
        }
    }

    public enum b {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);
        
        public int index;

        private b(int i2) {
            this.index = i2;
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        this.dcz.put(activity.getClass().getName(), Long.valueOf(System.currentTimeMillis()));
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void a(final String str, final long j2, final long j3, final boolean z, final long j4, final long j5, final long j6, final long j7) {
        if (com.tencent.matrix.a.INSTANCE.cPB) {
            long currentTimeMillis = System.currentTimeMillis();
            long j8 = j3 - j4;
            try {
                final int i2 = (int) (j8 / this.dcq);
                if (this.dco != null && i2 > this.dcp) {
                    try {
                        if (com.tencent.matrix.a.RF() != null) {
                            this.dco.a(i2, com.tencent.matrix.a.RF(), this.dcz.get(com.tencent.matrix.a.RF()).longValue());
                        }
                    } catch (Exception e2) {
                        com.tencent.matrix.g.c.e("Matrix.FrameTracer", "dropFrameListener error e:" + e2.getMessage(), new Object[0]);
                    }
                }
                this.dcx += i2;
                this.dcy += Math.max(j8, this.dcq);
                synchronized (this.listeners) {
                    Iterator<com.tencent.matrix.trace.e.b> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        final com.tencent.matrix.trace.e.b next = it.next();
                        if (this.daS.daO) {
                            next.time = SystemClock.uptimeMillis();
                        }
                        if (next.getExecutor() == null) {
                            long j9 = (j3 - j4) / TimeUtil.SECOND_TO_US;
                            next.a(str, j9, j9, i2, z);
                        } else if (next.TD() > 0) {
                            b.a TF = b.a.TF();
                            TF.dbP = str;
                            TF.dbQ = j2;
                            TF.dbR = j3;
                            TF.dbS = i2;
                            TF.dbn = z;
                            TF.dbT = j4;
                            TF.dbU = j5;
                            TF.dbV = j6;
                            TF.dbW = j7;
                            next.list.add(TF);
                            if (next.list.size() >= next.dbL && next.getExecutor() != null) {
                                LinkedList linkedList = new LinkedList(next.list);
                                next.list.clear();
                                next.getExecutor().execute(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e1: INVOKE  
                                      (wrap: java.util.concurrent.Executor : 0x00d8: INVOKE  (r4v19 java.util.concurrent.Executor) = (r2v17 'next' com.tencent.matrix.trace.e.b) type: VIRTUAL call: com.tencent.matrix.trace.e.b.getExecutor():java.util.concurrent.Executor)
                                      (wrap: com.tencent.matrix.trace.e.b$1 : 0x00de: CONSTRUCTOR  (r5v3 com.tencent.matrix.trace.e.b$1) = (r2v17 'next' com.tencent.matrix.trace.e.b), (r3v17 'linkedList' java.util.LinkedList) call: com.tencent.matrix.trace.e.b.1.<init>(com.tencent.matrix.trace.e.b, java.util.List):void type: CONSTRUCTOR)
                                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: com.tencent.matrix.trace.f.c.a(java.lang.String, long, long, boolean, long, long, long, long):void, file: classes4.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: CONSTRUCTOR  (r5v3 com.tencent.matrix.trace.e.b$1) = (r2v17 'next' com.tencent.matrix.trace.e.b), (r3v17 'linkedList' java.util.LinkedList) call: com.tencent.matrix.trace.e.b.1.<init>(com.tencent.matrix.trace.e.b, java.util.List):void type: CONSTRUCTOR in method: com.tencent.matrix.trace.f.c.a(java.lang.String, long, long, boolean, long, long, long, long):void, file: classes4.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 48 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.matrix.trace.e.b, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 54 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 473
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.f.c.a(java.lang.String, long, long, boolean, long, long, long, long):void");
                            }
                        }
