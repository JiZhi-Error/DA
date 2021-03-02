package com.tencent.mm.gpu.g;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.c;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.gpu.f.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class a implements Application.ActivityLifecycleCallbacks, Runnable {
    private static a hjD = new a();
    private volatile String activity = BuildConfig.KINDA_DEFAULT;
    public boolean hjE = false;
    private long hjF = 0;
    public List<AbstractC0347a> mListeners = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.gpu.g.a$a  reason: collision with other inner class name */
    public interface AbstractC0347a {
        void a(e eVar);
    }

    static {
        AppMethodBeat.i(186222);
        AppMethodBeat.o(186222);
    }

    public static a axy() {
        return hjD;
    }

    private a() {
        AppMethodBeat.i(186215);
        ((Application) MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this);
        AppMethodBeat.o(186215);
    }

    public final void a(AbstractC0347a aVar) {
        AppMethodBeat.i(186216);
        if (aVar == null) {
            AppMethodBeat.o(186216);
            return;
        }
        synchronized (this.mListeners) {
            try {
                if (this.mListeners.contains(aVar)) {
                    this.mListeners.remove(aVar);
                    AppMethodBeat.o(186216);
                }
            } finally {
                AppMethodBeat.o(186216);
            }
        }
    }

    public final void onActivityCreated(Activity activity2, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity2) {
        AppMethodBeat.i(186217);
        this.activity = activity2.getClass().getSimpleName();
        if (axz()) {
            axA();
        }
        AppMethodBeat.o(186217);
    }

    public final void onActivityResumed(Activity activity2) {
    }

    public final void onActivityPaused(Activity activity2) {
    }

    public final void onActivityStopped(Activity activity2) {
        AppMethodBeat.i(186218);
        if (axz()) {
            axA();
        }
        AppMethodBeat.o(186218);
    }

    public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity2) {
    }

    public final void run() {
        AppMethodBeat.i(186219);
        if (PluginGpuRes.isSkipModel()) {
            Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
            AppMethodBeat.o(186219);
            return;
        }
        Log.d("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        if (!axz()) {
            Log.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
            AppMethodBeat.o(186219);
            return;
        }
        Log.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
        this.hjF = System.currentTimeMillis();
        long j2 = this.hjF;
        com.tencent.mm.gpu.f.a aVar = new com.tencent.mm.gpu.f.a();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        String processName = MMApplicationContext.getProcessName();
        e eVar = new e();
        eVar.pid = Process.myPid();
        eVar.processName = processName;
        eVar.hjv = PluginGpuRes.getCurrSpend();
        eVar.hju = currentTimeMillis;
        eVar.hjt = aVar.axv();
        eVar.hjr = aVar.axu();
        eVar.hjs = aVar.axw();
        eVar.activityName = this.activity;
        Log.e("MicroMsg.GpuMemoryWatchDog", eVar.toString());
        Log.e("MicroMsg.GpuMemoryWatchDog.oomScore", new StringBuilder().append(b.axx()).toString());
        c axn = c.axn();
        axn.hjg.post(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ac: INVOKE  
              (wrap: android.os.Handler : 0x00a5: IGET  (r1v6 android.os.Handler) = (r0v13 'axn' com.tencent.mm.gpu.d.c) com.tencent.mm.gpu.d.c.hjg android.os.Handler)
              (wrap: com.tencent.mm.gpu.d.c$4 : 0x00a9: CONSTRUCTOR  (r2v2 com.tencent.mm.gpu.d.c$4) = (r0v13 'axn' com.tencent.mm.gpu.d.c) call: com.tencent.mm.gpu.d.c.4.<init>(com.tencent.mm.gpu.d.c):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.tencent.mm.gpu.g.a.run():void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a9: CONSTRUCTOR  (r2v2 com.tencent.mm.gpu.d.c$4) = (r0v13 'axn' com.tencent.mm.gpu.d.c) call: com.tencent.mm.gpu.d.c.4.<init>(com.tencent.mm.gpu.d.c):void type: CONSTRUCTOR in method: com.tencent.mm.gpu.g.a.run():void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 22 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.gpu.d.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 28 more
            */
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.gpu.g.a.run():void");
    }

    private boolean axz() {
        AppMethodBeat.i(186220);
        if (System.currentTimeMillis() - this.hjF > 10000) {
            AppMethodBeat.o(186220);
            return true;
        }
        AppMethodBeat.o(186220);
        return false;
    }

    private void axA() {
        AppMethodBeat.i(186221);
        if (!axz()) {
            Log.i("MicroMsg.GpuMemoryWatchDog", "checkCanDump in run false.");
            AppMethodBeat.o(186221);
            return;
        }
        Log.d("MicroMsg.GpuMemoryWatchDog", "GpuResReportTask run.");
        h.RTc.aX(this);
        AppMethodBeat.o(186221);
    }
}
