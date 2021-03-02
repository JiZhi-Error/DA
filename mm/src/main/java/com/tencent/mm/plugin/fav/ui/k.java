package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.LinkedList;
import java.util.List;

public final class k {
    public static boolean a(String str, LinkedList<aml> linkedList, long j2) {
        g DY;
        AppMethodBeat.i(106783);
        if (str.length() == 0) {
            Log.e("MicroMsg.FavPostLogic", "postNote null");
            AppMethodBeat.o(106783);
            return false;
        }
        if (-1 == j2) {
            DY = a(linkedList, j2);
        } else {
            DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        }
        b.C(DY);
        AppMethodBeat.o(106783);
        return true;
    }

    public static g a(LinkedList<aml> linkedList, long j2) {
        AppMethodBeat.i(106784);
        g gVar = null;
        if (j2 != -1) {
            gVar = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
            if (gVar == null) {
                gVar = Ed(j2);
            }
            gVar.field_favProto.ppH.clear();
        }
        if (gVar == null) {
            gVar = new g();
            gVar.field_type = 18;
            gVar.field_sourceType = 6;
            G(gVar);
            gVar.field_favProto.ajl(1);
            gVar.field_favProto.ajk(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        }
        gVar.field_edittime = Util.nowSecond();
        gVar.field_updateTime = Util.nowMilliSecond();
        gVar.field_favProto.Mz(gVar.field_edittime);
        gVar.field_favProto.Lya.MA(Util.nowMilliSecond());
        gVar.field_favProto.bH(linkedList);
        AppMethodBeat.o(106784);
        return gVar;
    }

    private static g Ed(long j2) {
        AppMethodBeat.i(106785);
        g gVar = new g();
        gVar.field_type = 18;
        gVar.field_sourceType = 6;
        String aTY = z.aTY();
        anh anh = new anh();
        anh.bhf(aTY);
        anh.bhg(aTY);
        anh.ajm(gVar.field_sourceType);
        anh.MA(Util.nowMilliSecond());
        gVar.field_favProto.a(anh);
        gVar.field_fromUser = anh.dRL;
        gVar.field_toUser = anh.toUser;
        gVar.field_favProto.ajl(1);
        gVar.field_favProto.ajk(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        gVar.field_edittime = Util.nowSecond();
        gVar.field_updateTime = Util.nowMilliSecond();
        gVar.field_favProto.Mz(gVar.field_edittime);
        gVar.field_favProto.Lya.MA(Util.nowMilliSecond());
        gVar.field_itemStatus = 9;
        gVar.field_localId = j2;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(gVar);
        AppMethodBeat.o(106785);
        return gVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        com.tencent.mm.sdk.platformtools.Util.qualityClose(null);
        com.tencent.matrix.trace.core.AppMethodBeat.o(106786);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[ExcHandler: all (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> dH(java.util.List<java.lang.String> r6) {
        /*
            r5 = 106786(0x1a122, float:1.49639E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            if (r6 == 0) goto L_0x000e
            int r0 = r6.size()
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0011:
            return r6
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r3 = r6.iterator()
        L_0x001b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            r2 = 0
            java.io.InputStream r2 = com.tencent.mm.vfs.s.openRead(r0)     // Catch:{ Exception -> 0x003f, all -> 0x0045 }
            if (r2 != 0) goto L_0x0032
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r2)
            goto L_0x001b
        L_0x0032:
            boolean r4 = com.tencent.mm.sdk.platformtools.ImgUtil.isImgFile(r0)     // Catch:{ Exception -> 0x0052, all -> 0x0045 }
            if (r4 == 0) goto L_0x003b
            r1.add(r0)     // Catch:{ Exception -> 0x0052, all -> 0x0045 }
        L_0x003b:
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r2)
            goto L_0x001b
        L_0x003f:
            r0 = move-exception
            r0 = r2
        L_0x0041:
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r0)
            goto L_0x001b
        L_0x0045:
            r0 = move-exception
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x004d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r6 = r1
            goto L_0x0011
        L_0x0052:
            r0 = move-exception
            r0 = r2
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.k.dH(java.util.List):java.util.List");
    }

    static void G(g gVar) {
        AppMethodBeat.i(106788);
        String aTY = z.aTY();
        anh anh = new anh();
        anh.bhf(aTY);
        anh.bhg(aTY);
        anh.ajm(gVar.field_sourceType);
        anh.MA(Util.nowMilliSecond());
        gVar.field_favProto.a(anh);
        gVar.field_fromUser = anh.dRL;
        gVar.field_toUser = anh.toUser;
        AppMethodBeat.o(106788);
    }

    public static boolean dI(List<String> list) {
        AppMethodBeat.i(106787);
        List<String> dH = dH(list);
        if (dH == null || dH.size() == 0) {
            Log.e("MicroMsg.FavPostLogic", "postImgs path null");
            AppMethodBeat.o(106787);
            return false;
        }
        g gVar = new g();
        gVar.field_type = 2;
        gVar.field_sourceType = 6;
        G(gVar);
        for (String str : dH) {
            aml aml = new aml();
            aml.bgt(str);
            aml.bgs(b.ds(aml.toString(), 2));
            BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a(aml), true);
            aml.bgu(b.a(aml));
            aml.ajd(2);
            gVar.field_favProto.ppH.add(aml);
        }
        b.C(gVar);
        h.INSTANCE.a(10648, 2, Integer.valueOf(dH.size()));
        AppMethodBeat.o(106787);
        return true;
    }
}
