package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.an.c;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class j extends e {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01f6  */
    @Override // com.tencent.mm.model.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.ca a(com.tencent.mm.ak.h.a r25, final java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
        // Method dump skipped, instructions count: 1355
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.j.a(com.tencent.mm.ak.h$a, java.lang.String, java.lang.String, java.lang.String):com.tencent.mm.storage.ca");
    }

    public static int a(int i2, d dVar, ca caVar, String str, long j2, String str2, String str3, int i3, long j3, String str4) {
        long j4;
        String str5;
        AppMethodBeat.i(150640);
        if (i2 != 0) {
            Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i2), Long.valueOf(j2), str, str3, str2);
            caVar.setStatus(5);
            ((l) g.af(l.class)).eiy().b(caVar.field_msgSvrId, caVar);
            String t = a.t(Integer.valueOf(i2), 2, Long.valueOf(j3), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(i3), "");
            new y(t).bfK();
            new w(t).bfK();
            q.bcR().doNotify();
            AppMethodBeat.o(150640);
            return 0;
        } else if (dVar == null) {
            AppMethodBeat.o(150640);
            return 0;
        } else {
            if (dVar.field_retCode != 0) {
                Log.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j2), str, str3, str2);
                caVar.setStatus(5);
                if (!Util.isNullOrNil(caVar.field_talker)) {
                    ((l) g.af(l.class)).eiy().b(caVar.field_msgSvrId, caVar);
                }
            } else {
                if (ImgUtil.isWXGF(str4)) {
                    String str6 = str2 + "_hevc";
                    s.nx(str4, str6);
                    if (!s.YS(str2)) {
                        s.bpa(str2);
                    }
                    ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str6, str2);
                } else {
                    s.nx(str4, str2);
                }
                caVar.setStatus(6);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                BitmapUtil.getRent(str2, pInt, pInt2);
                caVar.nG(pInt.value);
                caVar.nH(pInt2.value);
                Log.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j2), str, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str3, str2);
                if (!Util.isNullOrNil(caVar.field_talker)) {
                    ((l) g.af(l.class)).eiy().b(caVar.field_msgSvrId, caVar);
                }
                h.INSTANCE.idkeyStat(198, 1, (long) i3, false);
                h.INSTANCE.idkeyStat(198, 2, 1, false);
                h hVar = h.INSTANCE;
                if (ab.Eq(str)) {
                    j4 = 4;
                } else {
                    j4 = 3;
                }
                hVar.idkeyStat(198, j4, 1, false);
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(dVar == null ? i2 : dVar.field_retCode);
            objArr[1] = 2;
            objArr[2] = Long.valueOf(j3);
            objArr[3] = Long.valueOf(Util.nowMilliSecond());
            objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
            objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i3);
            objArr[7] = dVar == null ? "" : dVar.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (dVar == null) {
                str5 = "";
            } else {
                str5 = dVar.gqk;
            }
            objArr[15] = str5;
            new y(a.t(objArr)).bfK();
            if (!(dVar == null || dVar.field_retCode == 0)) {
                Object[] objArr2 = new Object[16];
                if (dVar != null) {
                    i2 = dVar.field_retCode;
                }
                objArr2[0] = Integer.valueOf(i2);
                objArr2[1] = 2;
                objArr2[2] = Long.valueOf(j3);
                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                objArr2[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                objArr2[6] = Integer.valueOf(i3);
                objArr2[7] = dVar == null ? "" : dVar.field_transInfo;
                objArr2[8] = "";
                objArr2[9] = "";
                objArr2[10] = "";
                objArr2[11] = "";
                objArr2[12] = "";
                objArr2[13] = "";
                objArr2[14] = "";
                objArr2[15] = dVar == null ? "" : dVar.gqk;
                new w(a.t(objArr2)).bfK();
            }
            q.bcR().doNotify();
            AppMethodBeat.o(150640);
            return 0;
        }
    }

    @Override // com.tencent.mm.model.e, com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        AppMethodBeat.i(150641);
        q.bcR().V(cVar.dTX);
        AppMethodBeat.o(150641);
    }
}
