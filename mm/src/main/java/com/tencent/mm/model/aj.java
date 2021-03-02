package com.tencent.mm.model;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.protocal.protobuf.C2396if;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj {
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x055f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.protobuf.ell r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 1429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.aj.a(com.tencent.mm.protocal.protobuf.ell, boolean):void");
    }

    public static void a(ig igVar) {
        AppMethodBeat.i(134111);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(igVar == null ? -1 : igVar.oTz);
        Log.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", objArr);
        g.aAi();
        com.tencent.mm.network.g gVar = g.aAg().hqi.iMw;
        if (gVar == null || gVar.aZh() == null) {
            AppMethodBeat.o(134111);
            return;
        }
        gVar.aZh().aZg();
        if (igVar == null || igVar.oTz == 0) {
            Log.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
            AppMethodBeat.o(134111);
            return;
        }
        LinkedList<C2396if> linkedList = igVar.oTA;
        if (linkedList == null || linkedList.size() != igVar.oTz) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr2[1] = Integer.valueOf(igVar.oTz);
            Log.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", objArr2);
        }
        Log.d("MicroMsg.HandleAuthResponse", "axauth list size " + linkedList.size());
        if (linkedList.size() == 0) {
            AppMethodBeat.o(134111);
            return;
        }
        Iterator<C2396if> it = linkedList.iterator();
        while (it.hasNext()) {
            C2396if next = it.next();
            int i2 = next.xMB;
            ccb ccb = next.KMp;
            try {
                Log.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i2)));
                gVar.aZh().h(i2, ccb.toByteArray());
            } catch (Exception e2) {
                Log.e("MicroMsg.HandleAuthResponse", "exception:%s", Util.stackTraceToString(e2));
            }
            String[] strArr = new String[ccb.oTA.size()];
            String[] strArr2 = new String[ccb.oTA.size()];
            int[] iArr = new int[ccb.oTA.size()];
            Log.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", Integer.valueOf(ccb.oTz));
            Iterator<cca> it2 = ccb.oTA.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                cca next2 = it2.next();
                Log.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", next2.MhX, next2.MhY);
                strArr[i3] = next2.MhX;
                strArr2[i3] = next2.MhY;
                iArr[i3] = next2.MhZ;
                i3++;
                if (Util.isNullOrNil(next2.MhX) || !Util.isNullOrNil(next2.MhY)) {
                }
            }
            if (strArr.length > 0 && gVar != null) {
                gVar.addHostInfo(strArr, strArr2, iArr);
            }
        }
        Iterator<C2396if> it3 = linkedList.iterator();
        while (it3.hasNext()) {
            final C2396if next3 = it3.next();
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.model.aj.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(134109);
                    Log.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
                    g.azz().a(new ag(next3), 0);
                    AppMethodBeat.o(134109);
                }
            });
        }
        AppMethodBeat.o(134111);
    }
}
