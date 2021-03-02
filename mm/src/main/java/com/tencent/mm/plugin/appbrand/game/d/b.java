package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private String appId;
    private int appVersion;
    private int dCv;
    private int lsj;
    private int lsk;
    n lsl;

    public b(QualitySessionRuntime qualitySessionRuntime, n nVar) {
        this.appId = qualitySessionRuntime.appId;
        this.dCv = qualitySessionRuntime.nJE;
        this.appVersion = qualitySessionRuntime.nLk;
        this.lsl = nVar;
    }

    public final void hd(boolean z) {
        int i2;
        AppMethodBeat.i(45132);
        Log.v("MicroMsg.Kv_14959", "hy: 14959 report is full: %b", Boolean.valueOf(z));
        if (this.lsl == null) {
            AppMethodBeat.o(45132);
            return;
        }
        n nVar = this.lsl;
        if (nVar.nLJ == m.a._2D) {
            i2 = 1;
        } else if (nVar.nLJ == m.a.WEBGL) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        this.lsj = i2;
        this.lsk = this.lsl.lsk;
        if (z) {
            if (this.lsl != null) {
                int i3 = this.lsl.nLU;
                int i4 = this.lsl.nLV;
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.CPU.eventId), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.lsk));
                Log.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj));
            }
            if (this.lsl != null) {
                int i5 = this.lsl.nLU;
                int i6 = this.lsl.cvD;
                int i7 = this.lsl.cvE;
                int i8 = this.lsl.cvF;
                int i9 = this.lsl.nLT;
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.MEM.eventId), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(this.lsk));
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.NATIVE_MEM.eventId), Integer.valueOf(i7), Integer.valueOf(i5), Integer.valueOf(this.lsk));
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.DALVIK_MEM.eventId), Integer.valueOf(i8), Integer.valueOf(i5), Integer.valueOf(this.lsk));
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.MEM_DELTA.eventId), Integer.valueOf(i9), Integer.valueOf(i5), Integer.valueOf(this.lsk));
                Log.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i5), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj));
            }
        }
        if (this.lsl != null) {
            int i10 = this.lsl.nLU;
            int i11 = this.lsl.fps;
            h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.FPS.eventId), Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(this.lsk));
            Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj));
            int i12 = (int) this.lsl.nLP;
            if (i12 != -1) {
                h.INSTANCE.a(14959, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.lsj), Integer.valueOf(a.VARIANCE_FPS.eventId), Integer.valueOf(i12), Integer.valueOf(i10), Integer.valueOf(this.lsk));
                Log.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i12), Integer.valueOf(a.VARIANCE_FPS.eventId), Integer.valueOf(i10), Integer.valueOf(this.lsk), Integer.valueOf(this.lsj));
                AppMethodBeat.o(45132);
                return;
            }
            Log.e("MicroMsg.Kv_14959", "variance == -1!");
        }
        AppMethodBeat.o(45132);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        FPS(1),
        CPU(2),
        MEM(3),
        DRAW_CALL(4),
        TRIANGLE(5),
        VERTEX(6),
        NATIVE_MEM(101),
        DALVIK_MEM(102),
        OTHER_MEM(103),
        MEM_DELTA(104),
        VARIANCE_FPS(105);
        
        int eventId;

        public static a valueOf(String str) {
            AppMethodBeat.i(45130);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(45130);
            return aVar;
        }

        static {
            AppMethodBeat.i(45131);
            AppMethodBeat.o(45131);
        }

        private a(int i2) {
            this.eventId = i2;
        }
    }
}
