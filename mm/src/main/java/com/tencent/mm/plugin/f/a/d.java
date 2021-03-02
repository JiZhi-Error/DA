package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final List<a> ap(ca caVar) {
        g tl;
        AppMethodBeat.i(22730);
        if (caVar == null) {
            AppMethodBeat.o(22730);
            return null;
        }
        g U = q.bcR().U(caVar);
        if (U == null || U.localId == 0) {
            Log.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", info());
            AppMethodBeat.o(22730);
            return null;
        }
        String o = q.bcR().o(U.iXm, "", "");
        long boW = s.boW(o);
        String o2 = q.bcR().o(U.iXo, "", "");
        long boW2 = s.boW(o2);
        String str = q.bcR().o(U.iXo, "", "") + "hd";
        long boW3 = s.boW(str);
        String o3 = q.bcR().o(U.iXn, "", "");
        long boW4 = s.boW(o3);
        String alX = ((c) com.tencent.mm.kernel.g.af(c.class)).alX(o);
        long boW5 = s.boW(alX);
        String alX2 = ((c) com.tencent.mm.kernel.g.af(c.class)).alX(o3);
        long boW6 = s.boW(alX2);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        if (U.bcv() && (tl = q.bcR().tl(U.iXx)) != null) {
            str2 = q.bcR().o(tl.iXm, "", "");
            if (!Util.isEqual(str2, o)) {
                j2 = s.boW(str2);
            }
            str3 = q.bcR().o(tl.iXo, "", "");
            if (!Util.isEqual(str3, o2)) {
                j3 = s.boW(str3);
            }
            str4 = q.bcR().o(tl.iXo, "", "") + "hd";
            if (!Util.isEqual(str4, str)) {
                j4 = s.boW(str4);
            }
        }
        a aq = aq(caVar);
        aq.field_msgSubType = 20;
        aq.field_path = bxr(o);
        aq.field_size = boW;
        a aq2 = aq(caVar);
        aq2.field_msgSubType = 21;
        aq2.field_path = bxr(o2);
        aq2.field_size = boW2;
        a aq3 = aq(caVar);
        aq3.field_msgSubType = 22;
        aq3.field_path = bxr(str);
        aq3.field_size = boW3;
        a aq4 = aq(caVar);
        aq4.field_msgSubType = 26;
        aq4.field_path = bxr(o3);
        aq4.field_size = boW4;
        a aq5 = aq(caVar);
        aq5.field_msgSubType = 27;
        aq5.field_path = bxr(alX);
        aq5.field_size = boW5;
        a aq6 = aq(caVar);
        aq6.field_msgSubType = 28;
        aq6.field_path = bxr(alX2);
        aq6.field_size = boW6;
        a aq7 = aq(caVar);
        aq7.field_msgSubType = 23;
        aq7.field_path = bxr(str2);
        aq7.field_size = j2;
        a aq8 = aq(caVar);
        aq8.field_msgSubType = 24;
        aq8.field_path = bxr(str3);
        aq8.field_size = j3;
        a aq9 = aq(caVar);
        aq9.field_msgSubType = 25;
        aq9.field_path = bxr(str4);
        aq9.field_size = j4;
        Log.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s] mid[%s] hevc[%s %s]", info(), aq, aq2, aq3, aq7, aq8, aq9, aq4, aq5, aq6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aq);
        arrayList.add(aq2);
        arrayList.add(aq3);
        arrayList.add(aq4);
        arrayList.add(aq5);
        arrayList.add(aq6);
        arrayList.add(aq7);
        arrayList.add(aq8);
        arrayList.add(aq9);
        if (boW4 > 0 || boW5 > 0 || boW6 > 0) {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
            if (boW4 > 0) {
                mmkv.encode("CleanCalcMidImg", mmkv.getLong("CleanCalcMidImg", 0) + boW4);
            }
            if (boW5 > 0 || boW6 > 0) {
                mmkv.encode("CleanCalcHevcImg", mmkv.getLong("CleanCalcHevcImg", 0) + boW5 + boW6);
            }
        }
        AppMethodBeat.o(22730);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final String info() {
        AppMethodBeat.i(22731);
        String str = "image_" + hashCode();
        AppMethodBeat.o(22731);
        return str;
    }
}
