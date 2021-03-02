package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class p extends MAutoStorage<o> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(o.info, "SnsReportKv")};
    public h iFy;

    static {
        AppMethodBeat.i(97594);
        AppMethodBeat.o(97594);
    }

    public p(h hVar) {
        super(hVar, o.info, "SnsReportKv", o.INDEX_CREATE);
        this.iFy = hVar;
    }

    public final int a(dzz dzz) {
        AppMethodBeat.i(97591);
        dzz dzz2 = new dzz();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dzz.KGB.size(); i4++) {
            cfy cfy = dzz.KGB.get(i4);
            if (cfy.MlG.zy.length + i3 > 51200) {
                a(dzz2, i3);
                i2++;
                dzz2.KGB.clear();
                i3 = 0;
            } else {
                i3 += cfy.MlG.zy.length;
                dzz2.KGB.add(cfy);
            }
        }
        if (dzz2.KGB.size() > 0) {
            i2++;
            a(dzz2, i3);
        }
        AppMethodBeat.o(97591);
        return i2;
    }

    private int a(dzz dzz, int i2) {
        AppMethodBeat.i(97592);
        try {
            byte[] byteArray = dzz.toByteArray();
            o oVar = new o();
            oVar.field_value = byteArray;
            oVar.field_logtime = System.currentTimeMillis();
            oVar.field_logsize = i2;
            oVar.field_offset = 0;
            int insert = (int) this.iFy.insert("SnsReportKv", "", oVar.convertTo());
            Log.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(insert)));
            AppMethodBeat.o(97592);
            return insert;
        } catch (Exception e2) {
            AppMethodBeat.o(97592);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x013c A[LOOP:2: B:26:0x0136->B:28:0x013c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0115 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.dzz iH(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.p.iH(int, int):com.tencent.mm.protocal.protobuf.dzz");
    }
}
