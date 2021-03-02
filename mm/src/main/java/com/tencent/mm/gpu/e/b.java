package com.tencent.mm.gpu.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.c;
import com.tencent.mm.gpu.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.rtmp.TXLiveConstants;

public final class b implements Runnable {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void run() {
        AppMethodBeat.i(186195);
        Log.d("GpuResReportTask", "GpuResReportTask run.");
        if (PluginGpuRes.isSkipModel()) {
            Log.e("GpuResReportTask", "skip current phone model");
            AppMethodBeat.o(186195);
            return;
        }
        Log.d("GpuResReportTask", "do not skip current phone model");
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String processName = MMApplicationContext.getProcessName();
        e eVar = new e();
        eVar.pid = Process.myPid();
        eVar.processName = processName;
        eVar.hjv = PluginGpuRes.getCurrSpend();
        eVar.hju = currentTimeMillis2;
        eVar.hjt = aVar.axv();
        eVar.hjr = aVar.axu();
        eVar.hjs = aVar.axw();
        Log.i("GpuResReportTask", "processName = ".concat(String.valueOf(processName)));
        Log.i("GpuResReportTask", eVar.toString());
        String str = eVar.processName;
        int i2 = eVar.hjv;
        int Fi = c.Fi(str);
        int i3 = eVar.hjt;
        int i4 = eVar.hjs;
        int i5 = eVar.hjr;
        if (!(i3 == 0 && i4 == 0 && i5 == 0)) {
            if (i2 >= 360) {
                c.e((long) Fi, 76, (long) i3);
                c.e((long) Fi, 78, (long) i5);
                c.e((long) Fi, 77, (long) i4);
                c.e((long) Fi, 96, (long) c.axn().pz(1));
                c.e((long) Fi, 108, (long) c.axn().pz(2));
                c.e((long) Fi, 119, (long) c.axn().pz(3));
                c.e((long) Fi, 131, (long) c.axn().pz(4));
                c.e((long) Fi, 75, 1);
            }
            switch (i2) {
                case 30:
                    c.e((long) Fi, 4, (long) i3);
                    c.e((long) Fi, 6, (long) i5);
                    c.e((long) Fi, 5, (long) i4);
                    c.e((long) Fi, 88, (long) c.axn().pz(1));
                    c.e((long) Fi, 100, (long) c.axn().pz(2));
                    c.e((long) Fi, 111, (long) c.axn().pz(3));
                    c.e((long) Fi, 123, (long) c.axn().pz(4));
                    c.e((long) Fi, 3, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 60:
                    c.e((long) Fi, 13, (long) i3);
                    c.e((long) Fi, 15, (long) i5);
                    c.e((long) Fi, 14, (long) i4);
                    c.e((long) Fi, 89, (long) c.axn().pz(1));
                    c.e((long) Fi, 101, (long) c.axn().pz(2));
                    c.e((long) Fi, 112, (long) c.axn().pz(3));
                    c.e((long) Fi, 124, (long) c.axn().pz(4));
                    c.e((long) Fi, 12, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 90:
                    c.e((long) Fi, 22, (long) i3);
                    c.e((long) Fi, 24, (long) i5);
                    c.e((long) Fi, 23, (long) i4);
                    c.e((long) Fi, 90, (long) c.axn().pz(1));
                    c.e((long) Fi, 102, (long) c.axn().pz(2));
                    c.e((long) Fi, 113, (long) c.axn().pz(3));
                    c.e((long) Fi, 125, (long) c.axn().pz(4));
                    c.e((long) Fi, 21, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 120:
                    c.e((long) Fi, 31, (long) i3);
                    c.e((long) Fi, 33, (long) i5);
                    c.e((long) Fi, 32, (long) i4);
                    c.e((long) Fi, 91, (long) c.axn().pz(1));
                    c.e((long) Fi, 103, (long) c.axn().pz(2));
                    c.e((long) Fi, 114, (long) c.axn().pz(3));
                    c.e((long) Fi, 126, (long) c.axn().pz(4));
                    c.e((long) Fi, 30, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 150:
                    c.e((long) Fi, 40, (long) i3);
                    c.e((long) Fi, 42, (long) i5);
                    c.e((long) Fi, 41, (long) i4);
                    c.e((long) Fi, 92, (long) c.axn().pz(1));
                    c.e((long) Fi, 104, (long) c.axn().pz(2));
                    c.e((long) Fi, 115, (long) c.axn().pz(3));
                    c.e((long) Fi, 127, (long) c.axn().pz(4));
                    c.e((long) Fi, 39, 1);
                    AppMethodBeat.o(186195);
                    return;
                case TXLiveConstants.RENDER_ROTATION_180 /*{ENCODED_INT: 180}*/:
                    c.e((long) Fi, 49, (long) i3);
                    c.e((long) Fi, 51, (long) i5);
                    c.e((long) Fi, 50, (long) i4);
                    c.e((long) Fi, 93, (long) c.axn().pz(1));
                    c.e((long) Fi, 105, (long) c.axn().pz(2));
                    c.e((long) Fi, 116, (long) c.axn().pz(3));
                    c.e((long) Fi, 128, (long) c.axn().pz(4));
                    c.e((long) Fi, 48, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 240:
                    c.e((long) Fi, 58, (long) i3);
                    c.e((long) Fi, 60, (long) i5);
                    c.e((long) Fi, 59, (long) i4);
                    c.e((long) Fi, 94, (long) c.axn().pz(1));
                    c.e((long) Fi, 106, (long) c.axn().pz(2));
                    c.e((long) Fi, 117, (long) c.axn().pz(3));
                    c.e((long) Fi, 129, (long) c.axn().pz(4));
                    c.e((long) Fi, 57, 1);
                    AppMethodBeat.o(186195);
                    return;
                case 300:
                    c.e((long) Fi, 67, (long) i3);
                    c.e((long) Fi, 69, (long) i5);
                    c.e((long) Fi, 68, (long) i4);
                    c.e((long) Fi, 95, (long) c.axn().pz(1));
                    c.e((long) Fi, 107, (long) c.axn().pz(2));
                    c.e((long) Fi, 118, (long) c.axn().pz(3));
                    c.e((long) Fi, 130, (long) c.axn().pz(4));
                    c.e((long) Fi, 66, 1);
                    break;
            }
        }
        AppMethodBeat.o(186195);
    }
}
