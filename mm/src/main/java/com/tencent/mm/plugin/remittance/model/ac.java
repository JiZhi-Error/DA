package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.remittance.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class ac {
    private static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public HashMap<String, String> Cqp = new HashMap<>();
    public Object lock = new Object();

    public ac() {
        AppMethodBeat.i(67903);
        AppMethodBeat.o(67903);
    }

    public final void jL(String str, String str2) {
        AppMethodBeat.i(67904);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e(TAG, "saveMsgContent param error");
            AppMethodBeat.o(67904);
            return;
        }
        this.Cqp.put(str, str2);
        AppMethodBeat.o(67904);
    }

    public final boolean aMd(String str) {
        boolean aMf;
        AppMethodBeat.i(67905);
        synchronized (this.lock) {
            try {
                aMf = aMf(str);
            } finally {
                AppMethodBeat.o(67905);
            }
        }
        return aMf;
    }

    private synchronized boolean aMe(String str) {
        List<String> list;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(67906);
            if (!aMf(str)) {
                List<String> eNz = eNz();
                eNz.add(str);
                if (eNz.size() > 50) {
                    list = eNz.subList(eNz.size() - 50, eNz.size());
                } else {
                    list = eNz;
                }
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (String str2 : list) {
                    sb.append(str2);
                    if (i2 != list.size() - 1) {
                        sb.append(",");
                    }
                    i2++;
                }
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_REMITTANCE_PAYMSGID_STRING_SYNC, sb.toString());
                z = true;
                AppMethodBeat.o(67906);
            } else {
                Log.i(TAG, "it is a duplicate msg");
                AppMethodBeat.o(67906);
            }
        }
        return z;
    }

    public final boolean jM(String str, String str2) {
        AppMethodBeat.i(67907);
        String str3 = this.Cqp.get(str);
        if (Util.isNullOrNil(str3)) {
            Log.w(TAG, "empty transid: %s", str);
            AppMethodBeat.o(67907);
            return false;
        }
        boolean aF = aF(str, str3, str2);
        AppMethodBeat.o(67907);
        return aF;
    }

    public final boolean aF(String str, String str2, String str3) {
        boolean insert;
        AppMethodBeat.i(67908);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            Log.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            AppMethodBeat.o(67908);
            return false;
        } else if (!aMe(str)) {
            AppMethodBeat.o(67908);
            return false;
        } else {
            ca caVar = new ca();
            caVar.setContent(str2);
            caVar.setStatus(2);
            caVar.Cy(str3);
            caVar.setCreateTime(bp.Kw(str3));
            caVar.nv(1);
            caVar.setType(419430449);
            long aC = ((l) g.af(l.class)).eiy().aC(caVar);
            if (aC < 0) {
                Log.e(TAG, f.apq() + "insert msg failed :" + aC);
                aMg(str);
                AppMethodBeat.o(67908);
                return false;
            }
            caVar.setMsgId(aC);
            if (caVar.dOQ()) {
                b.jmd.b(caVar, com.tencent.mm.ag.l.t(caVar));
            } else {
                b.jmd.s(caVar);
            }
            k kVar = new k();
            kVar.field_xml = caVar.field_content;
            String processXml = Util.processXml(str2);
            k.b bVar = null;
            if (!(processXml == null || (bVar = k.b.aD(processXml, caVar.field_reserved)) == null)) {
                kVar.field_title = bVar.title;
                kVar.field_description = bVar.description;
            }
            kVar.field_type = 2000;
            kVar.field_msgId = aC;
            k GL = a.eAT().GL(aC);
            if (GL == null || GL.field_msgId != aC) {
                insert = a.eAT().insert(kVar);
                if (!insert) {
                    Log.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(aC)));
                }
            } else {
                insert = a.eAT().update(kVar, new String[0]);
            }
            if (bVar != null) {
                c cVar = new c();
                cVar.field_locaMsgId = caVar.field_msgId;
                cVar.field_transferId = bVar.ixQ;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.c.eMU();
                com.tencent.mm.plugin.remittance.a.c.eMW().a(cVar);
            }
            AppMethodBeat.o(67908);
            return insert;
        }
    }

    private static List<String> eNz() {
        AppMethodBeat.i(67909);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REMITTANCE_PAYMSGID_STRING_SYNC, "");
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(",");
            if (split.length > 0) {
                arrayList.addAll(Arrays.asList(split));
            }
        }
        AppMethodBeat.o(67909);
        return arrayList;
    }

    private static boolean aMf(String str) {
        AppMethodBeat.i(67910);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(67910);
            return false;
        }
        boolean contains = eNz().contains(str);
        AppMethodBeat.o(67910);
        return contains;
    }

    private static void aMg(String str) {
        AppMethodBeat.i(67911);
        List<String> eNz = eNz();
        eNz.remove(str);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str2 : eNz) {
            sb.append(str2);
            if (i2 != eNz.size() - 1) {
                sb.append(",");
            }
            i2++;
        }
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_REMITTANCE_PAYMSGID_STRING_SYNC, sb.toString());
        AppMethodBeat.o(67911);
    }
}
