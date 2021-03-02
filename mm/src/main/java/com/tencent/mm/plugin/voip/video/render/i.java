package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"})
public final class i {
    private static final a[] HnQ;
    public static final i HnR = new i();

    static {
        AppMethodBeat.i(236253);
        a[] aVarArr = new a[5];
        for (int i2 = 0; i2 < 5; i2++) {
            aVarArr[i2] = new a();
        }
        HnQ = aVarArr;
        AppMethodBeat.o(236253);
    }

    private i() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"})
    public static final class a {
        long HnS = 0;
        long HnT = 0;

        public final long fLU() {
            return this.HnT / (this.HnS == 0 ? 1 : this.HnS);
        }
    }

    public static void aO(int i2, long j2) {
        a aVar = HnQ[i2];
        aVar.HnS++;
        aVar.HnT += j2;
    }

    public static void reset() {
        a[] aVarArr = HnQ;
        for (a aVar : aVarArr) {
            aVar.HnS = 0;
            aVar.HnT = 0;
        }
    }

    public static void report() {
        AppMethodBeat.i(236252);
        if (!g.fKe()) {
            reset();
            AppMethodBeat.o(236252);
            return;
        }
        if (HnQ[0].HnS >= 5) {
            j jVar = j.Hhp;
            j.LM(HnQ[0].fLU());
        }
        if (HnQ[1].HnS >= 5) {
            j jVar2 = j.Hhp;
            j.LN(HnQ[1].fLU());
        }
        if (HnQ[2].HnS >= 5) {
            j jVar3 = j.Hhp;
            j.LO(HnQ[2].fLU());
        }
        if (HnQ[3].HnS >= 5) {
            j jVar4 = j.Hhp;
            j.LP(HnQ[3].fLU());
        }
        if (HnQ[4].HnS >= 5) {
            j jVar5 = j.Hhp;
            j.LQ(HnQ[4].fLU());
        }
        reset();
        AppMethodBeat.o(236252);
    }
}
