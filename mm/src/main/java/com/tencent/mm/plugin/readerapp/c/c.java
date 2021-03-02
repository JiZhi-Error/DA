package com.tencent.mm.plugin.readerapp.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import java.util.List;

public final class c implements g {
    private long BBW = 0;

    @Override // com.tencent.mm.ak.g
    public final int atz() {
        return 12399999;
    }

    @Override // com.tencent.mm.ak.g
    public final int atA() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0988  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x098b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0235 A[ADDED_TO_REGION] */
    @Override // com.tencent.mm.ak.h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ak.h.b b(com.tencent.mm.ak.h.a r29) {
        /*
        // Method dump skipped, instructions count: 2449
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.readerapp.c.c.b(com.tencent.mm.ak.h$a):com.tencent.mm.ak.h$b");
    }

    public static boolean eHG() {
        AppMethodBeat.i(102663);
        if ((z.aUe() & 1024) == 0) {
            AppMethodBeat.o(102663);
            return true;
        }
        AppMethodBeat.o(102663);
        return false;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        AppMethodBeat.i(102664);
        String str = (String) cVar.iMc;
        Log.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", str);
        try {
            bw eHI = g.eHI();
            List<bv> KE = eHI.KE(str);
            if (KE == null || KE.size() == 0) {
                AppMethodBeat.o(102664);
                return;
            }
            bv bvVar = KE.get(0);
            for (bv bvVar2 : KE) {
                if (bvVar2.iFq != 1) {
                    bvVar2 = bvVar;
                }
                bvVar = bvVar2;
            }
            if (eHI.iFy.delete(bw.se(20), "reserved3=?", new String[]{str}) >= 0) {
                eHI.doNotify();
            }
            String str2 = bw.KD(bw.se(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
            Log.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", str2);
            Cursor rawQuery = eHI.iFy.rawQuery(str2, null, 2);
            if (!rawQuery.moveToFirst()) {
                rawQuery.close();
                az azVar = new az();
                azVar.setUsername(bv.sd(20));
                azVar.setContent("");
                azVar.yA(0);
                azVar.nv(0);
                azVar.nt(0);
                ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(azVar, bv.sd(20));
                AppMethodBeat.o(102664);
                return;
            }
            az bjY = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjY(bv.sd(20));
            if (bjY == null) {
                Log.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", bv.sd(20));
                AppMethodBeat.o(102664);
                return;
            }
            bv bvVar3 = new bv();
            bvVar3.convertFrom(rawQuery);
            rawQuery.close();
            az azVar2 = new az();
            azVar2.setUsername(bv.sd(20));
            azVar2.setContent(bvVar3.getTitle());
            azVar2.yA(bvVar3.time);
            azVar2.nv(0);
            if (bjY.field_unReadCount <= 0 || bvVar == null || !bjY.field_content.equals(bvVar.getTitle())) {
                azVar2.nt(0);
            } else {
                azVar2.nt(bjY.field_unReadCount - 1);
            }
            ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(azVar2, bv.sd(20));
            AppMethodBeat.o(102664);
        } catch (Exception e2) {
            Log.e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", e2);
            AppMethodBeat.o(102664);
        }
    }
}
