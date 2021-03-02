package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static Map<Long, Long> taj = new HashMap();
    private static Map<Long, Long> tak = new HashMap();

    public static final void HT(int i2) {
        AppMethodBeat.i(103389);
        e.INSTANCE.idkeyStat(802, (long) i2, 1, false);
        AppMethodBeat.o(103389);
    }

    public static final void HU(int i2) {
        AppMethodBeat.i(103390);
        e.INSTANCE.idkeyStat(802, 4, (long) i2, false);
        AppMethodBeat.o(103390);
    }

    static {
        AppMethodBeat.i(103397);
        AppMethodBeat.o(103397);
    }

    public static void DQ(long j2) {
        AppMethodBeat.i(103391);
        if (taj.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(103391);
            return;
        }
        taj.put(Long.valueOf(j2), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(103391);
    }

    public static long DR(long j2) {
        AppMethodBeat.i(103392);
        Long l = taj.get(Long.valueOf(j2));
        if (l == null) {
            AppMethodBeat.o(103392);
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        AppMethodBeat.o(103392);
        return currentTimeMillis;
    }

    public static void DS(long j2) {
        AppMethodBeat.i(103393);
        if (tak.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(103393);
            return;
        }
        tak.put(Long.valueOf(j2), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(103393);
    }

    public static int fS(int i2, int i3) {
        if (i3 == -401) {
            return -4;
        }
        if (i2 == 4) {
            return -2;
        }
        return -1;
    }

    public static String a(a aVar) {
        int i2;
        int i3;
        int i4 = 1;
        AppMethodBeat.i(103394);
        String aVar2 = aVar.toString();
        Log.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", aVar2);
        e.INSTANCE.kvStat(15098, aVar2);
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(aVar.scene);
        objArr[1] = Integer.valueOf(aVar.index);
        objArr[2] = Long.valueOf(aVar.tal);
        objArr[3] = Integer.valueOf(aVar.type);
        objArr[4] = aVar.tam;
        objArr[5] = Integer.valueOf(aVar.source);
        objArr[6] = Long.valueOf(aVar.timestamp);
        objArr[7] = Long.valueOf(aVar.tan);
        objArr[8] = Long.valueOf(aVar.tao);
        if (aVar.tap) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[9] = Integer.valueOf(i2);
        objArr[10] = Integer.valueOf(aVar.taq);
        objArr[11] = Integer.valueOf(aVar.tar);
        objArr[12] = Integer.valueOf(aVar.tas);
        objArr[13] = Integer.valueOf(aVar.tat);
        objArr[14] = Integer.valueOf(aVar.tau);
        if (aVar.tav) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[15] = Integer.valueOf(i3);
        if (!aVar.taw) {
            i4 = 0;
        }
        objArr[16] = Integer.valueOf(i4);
        objArr[17] = Integer.valueOf(aVar.pHw);
        String format = String.format("scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]", objArr);
        AppMethodBeat.o(103394);
        return format;
    }

    public static class a {
        public int index;
        public int pHw;
        public String query;
        public String sGF;
        public int scene;
        public int source;
        public long tal;
        public String tam;
        public long tan;
        public long tao;
        public boolean tap;
        public int taq;
        public int tar;
        public int tas;
        public int tat;
        public int tau;
        public boolean tav;
        public boolean taw;
        public int tax;
        public String tay;
        public long timestamp;
        public int type;

        public final String toString() {
            int i2;
            int i3;
            int i4 = 1;
            AppMethodBeat.i(103388);
            Object[] objArr = new Object[22];
            objArr[0] = Integer.valueOf(this.scene);
            objArr[1] = Integer.valueOf(this.index);
            objArr[2] = Long.valueOf(this.tal);
            objArr[3] = Integer.valueOf(this.type);
            objArr[4] = this.tam;
            objArr[5] = Integer.valueOf(this.source);
            objArr[6] = Long.valueOf(this.timestamp);
            objArr[7] = Long.valueOf(this.tan);
            objArr[8] = Long.valueOf(this.tao);
            if (this.tap) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[9] = Integer.valueOf(i2);
            objArr[10] = Integer.valueOf(this.taq);
            objArr[11] = Integer.valueOf(this.tar);
            objArr[12] = Integer.valueOf(this.tas);
            objArr[13] = Integer.valueOf(this.tat);
            objArr[14] = Integer.valueOf(this.tau);
            if (this.tav) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[15] = Integer.valueOf(i3);
            if (!this.taw) {
                i4 = 0;
            }
            objArr[16] = Integer.valueOf(i4);
            objArr[17] = Integer.valueOf(this.pHw);
            objArr[18] = this.sGF;
            objArr[19] = Integer.valueOf(this.tax);
            objArr[20] = this.query;
            objArr[21] = this.tay;
            String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
            AppMethodBeat.o(103388);
            return format;
        }
    }

    public static void w(long j2, int i2) {
        AppMethodBeat.i(199702);
        b(j2, i2, 0, -1);
        AppMethodBeat.o(199702);
    }

    public static void b(long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(199703);
        g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        if (DY != null) {
            int i5 = DY.field_favProto.Lya.sourceType;
            String str = DY.field_favProto.Lya.dRL;
            int i6 = 0;
            if (i2 == 1) {
                i6 = ab.Eq(DY.field_favProto.Lya.dRL) ? 2 : 1;
            }
            hb hbVar = new hb();
            hbVar.dLm.type = 40;
            hbVar.dLm.dGb = DY.field_favProto;
            EventCenter.instance.publish(hbVar);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10651, Integer.valueOf(DY.field_type), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(DY.field_id), b.r(DY), Long.valueOf(DY.field_updateTime / 1000), Integer.valueOf(i5), str, Integer.valueOf(i6), "", hbVar.dLn.dLF, Integer.valueOf(i4));
        }
        AppMethodBeat.o(199703);
    }

    public static void i(long j2, int i2, int i3) {
        AppMethodBeat.i(103396);
        g DZ = ((af) g.ah(af.class)).getFavItemInfoStorage().DZ(j2);
        if (DZ != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11122, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(((af) g.ah(af.class)).getFavTagSetMgr().cUF()), Integer.valueOf(i3), Integer.valueOf(DZ.field_type), b.r(DZ), Long.valueOf(DZ.field_updateTime), Integer.valueOf(DZ.field_favProto.Lya.sourceType), DZ.field_favProto.Lya.dRL);
        }
        AppMethodBeat.o(103396);
    }
}
