package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.List;

/* access modifiers changed from: package-private */
public final class bc {
    private bb Opf = new bb();
    protected final long SECONDS_OF_DAY = 86400;

    public bc() {
        AppMethodBeat.i(117134);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        byte[] aW = s.aW(sb.append(g.aAh().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!Util.isNullOrNil(aW)) {
            try {
                this.Opf.parseFrom(aW);
                if (gCE()) {
                    gCD();
                }
                AppMethodBeat.o(117134);
                return;
            } catch (Exception e2) {
                Log.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                Log.e("MicroMsg.DelSvrIdMgr", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(117134);
    }

    private void gCD() {
        AppMethodBeat.i(117135);
        Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.Opf.Opc.size()), Integer.valueOf(this.Opf.Opd.size()), Integer.valueOf(this.Opf.Ope.size()), Util.getStack());
        try {
            this.Opf.Opb.clear();
            this.Opf.Opa.clear();
            this.Opf.OoZ.clear();
            bb bbVar = new bb();
            bbVar.Opc.addAll(this.Opf.Opc);
            bbVar.Opd.addAll(this.Opf.Opd);
            bbVar.Ope.addAll(this.Opf.Ope);
            byte[] byteArray = bbVar.toByteArray();
            StringBuilder sb = new StringBuilder();
            g.aAi();
            s.f(sb.append(g.aAh().cachePath).append("checkmsgid.ini").toString(), byteArray, byteArray.length);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bbVar.Opc.size());
            objArr[1] = Integer.valueOf(bbVar.Opd.size());
            objArr[2] = Integer.valueOf(bbVar.Ope.size());
            objArr[3] = Integer.valueOf(byteArray == null ? -1 : byteArray.length);
            Log.i("MicroMsg.DelSvrIdMgr", "summerdel toFile done [%d, %d, %d] data len[%d]", objArr);
            AppMethodBeat.o(117135);
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(111, 168, 1, false);
            Log.printErrStackTrace("MicroMsg.DelSvrIdMgr", e2, "summerdel ", new Object[0]);
            AppMethodBeat.o(117135);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean Ni(long j2) {
        AppMethodBeat.i(117136);
        if (gCE()) {
            gCD();
        }
        if (this.Opf.Opc.contains(Long.valueOf(j2)) || this.Opf.Opd.contains(Long.valueOf(j2)) || this.Opf.Ope.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(117136);
            return true;
        }
        AppMethodBeat.o(117136);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void r(int i2, long j2, long j3) {
        AppMethodBeat.i(117137);
        b(i2, j2, j3, true);
        AppMethodBeat.o(117137);
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, long j2, long j3, boolean z) {
        AppMethodBeat.i(117138);
        if (j2 == 0) {
            AppMethodBeat.o(117138);
            return;
        }
        if (z) {
            gCE();
        }
        int i3 = i2 - ((int) (j3 / 86400));
        switch (i3) {
            case 0:
                this.Opf.Opc.add(Long.valueOf(j2));
                break;
            case 1:
                this.Opf.Opd.add(Long.valueOf(j2));
                break;
            case 2:
                this.Opf.Ope.add(Long.valueOf(j2));
                break;
            default:
                Log.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i3));
                break;
        }
        if (z) {
            gCD();
        }
        AppMethodBeat.o(117138);
    }

    /* access modifiers changed from: protected */
    public final void B(List<Integer> list, List<Long> list2) {
        AppMethodBeat.i(117139);
        Log.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        gCE();
        int nowSecond = (int) (Util.nowSecond() / 86400);
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(nowSecond, (long) list.get(i2).intValue(), list2.get(i2).longValue(), false);
        }
        gCD();
        AppMethodBeat.o(117139);
    }

    private boolean gCE() {
        AppMethodBeat.i(117140);
        Log.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.Opf.OoY), Integer.valueOf(this.Opf.Opc.size()), Integer.valueOf(this.Opf.Opd.size()), Integer.valueOf(this.Opf.Ope.size()));
        int nowSecond = (int) (Util.nowSecond() / 86400);
        int i2 = nowSecond - this.Opf.OoY;
        this.Opf.OoY = nowSecond;
        switch (i2) {
            case 0:
                AppMethodBeat.o(117140);
                return false;
            case 1:
                this.Opf.Ope = this.Opf.Opd;
                this.Opf.Opd = this.Opf.Opc;
                this.Opf.Opc.clear();
                AppMethodBeat.o(117140);
                return true;
            case 2:
                this.Opf.Ope = this.Opf.Opc;
                this.Opf.Opd.clear();
                this.Opf.Opc.clear();
                AppMethodBeat.o(117140);
                return true;
            default:
                this.Opf.Ope.clear();
                this.Opf.Opd.clear();
                this.Opf.Opc.clear();
                AppMethodBeat.o(117140);
                return true;
        }
    }
}
