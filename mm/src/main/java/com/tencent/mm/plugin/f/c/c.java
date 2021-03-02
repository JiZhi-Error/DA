package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class c implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        AppMethodBeat.i(22752);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        String aSY = d.aSY();
        this.count = 0;
        PLong pLong = new PLong();
        long a2 = a(aSY, pLong);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        String aSZ = d.aSZ();
        this.count = 0;
        PLong pLong2 = new PLong();
        long a3 = a(aSZ, pLong2);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        bg.aVF();
        String accVideoPath = com.tencent.mm.model.c.getAccVideoPath();
        this.count = 0;
        PLong pLong3 = new PLong();
        long a4 = a(accVideoPath, pLong3);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        bg.aVF();
        String aTa = com.tencent.mm.model.c.aTa();
        this.count = 0;
        PLong pLong4 = new PLong();
        long a5 = a(aTa, pLong4);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        long Eb = b.crW().crX().Eb(43) + b.crW().crX().Eb(62) + b.crW().crX().Eb(44);
        long Ec = b.crW().crX().Ec(43) + b.crW().crX().Ec(62) + b.crW().crX().Ec(44);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        long Eb2 = b.crW().crX().Eb(3);
        long Ec2 = b.crW().crX().Ec(3);
        if (this.isStop) {
            AppMethodBeat.o(22752);
            return;
        }
        long Eb3 = b.crW().crX().Eb(34);
        long Ec3 = b.crW().crX().Ec(34);
        long Eb4 = b.crW().crX().Eb(49);
        long Ec4 = b.crW().crX().Ec(49);
        h.INSTANCE.a(14556, 43, Long.valueOf(Eb), 0, 0, 0, Long.valueOf(Ec));
        h.INSTANCE.a(14556, 3, Long.valueOf(Eb2), 0, 0, 0, Long.valueOf(Ec2));
        h.INSTANCE.a(14556, 34, Long.valueOf(Eb3), 0, 0, 0, Long.valueOf(Ec3));
        h.INSTANCE.a(14556, 49, Long.valueOf(Eb4), 0, 0, 0, Long.valueOf(Ec4));
        h.INSTANCE.a(14556, Integer.valueOf("image".hashCode()), Long.valueOf(a2), 0, 0, 0, Long.valueOf(pLong.value));
        h.INSTANCE.a(14556, Integer.valueOf("image2".hashCode()), Long.valueOf(a3), 0, 0, 0, Long.valueOf(pLong2.value));
        h.INSTANCE.a(14556, Integer.valueOf("video".hashCode()), Long.valueOf(a4), 0, 0, 0, Long.valueOf(pLong3.value));
        h.INSTANCE.a(14556, Integer.valueOf("voice".hashCode()), Long.valueOf(a5), 0, 0, 0, Long.valueOf(pLong4.value));
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) 0L)).longValue();
        long longValue2 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, (Object) 0L)).longValue();
        h.INSTANCE.a(14556, Integer.valueOf("cost".hashCode()), 0, Long.valueOf(longValue), Long.valueOf(longValue2), Long.valueOf(longValue2 - longValue));
        Log.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", Long.valueOf(Eb), Long.valueOf(Eb2), Long.valueOf(Eb3), Long.valueOf(Eb4), Long.valueOf(a4), Long.valueOf(a3), Long.valueOf(a5), Long.valueOf(a2), Long.valueOf(Ec), Long.valueOf(Ec2), Long.valueOf(Ec3), Long.valueOf(Ec4), Long.valueOf(pLong3.value), Long.valueOf(pLong2.value), Long.valueOf(pLong4.value), Long.valueOf(pLong.value));
        AppMethodBeat.o(22752);
    }

    private long a(String str, PLong pLong) {
        String[] list;
        long j2 = 0;
        AppMethodBeat.i(22753);
        if (this.count >= 10) {
            if (this.isStop) {
                AppMethodBeat.o(22753);
                return -1;
            }
            this.count = 0;
        }
        o oVar = new o(str);
        if (!oVar.isDirectory() || (list = oVar.list()) == null) {
            long length = oVar.length();
            if (length > 0) {
                pLong.value++;
            }
            AppMethodBeat.o(22753);
            return length;
        }
        for (String str2 : list) {
            StringBuilder append = new StringBuilder().append(str);
            if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str2 = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str2));
            }
            long a2 = a(append.append(str2).toString(), pLong);
            if (a2 == -1) {
                AppMethodBeat.o(22753);
                return -1;
            }
            j2 += a2;
        }
        AppMethodBeat.o(22753);
        return j2;
    }
}
