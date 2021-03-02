package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct> implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>> {
    /* access modifiers changed from: package-private */
    public abstract String bwQ();

    /* access modifiers changed from: package-private */
    public abstract _Ret c(String str, String str2, _CmdStruct _cmdstruct);

    /* access modifiers changed from: package-private */
    public abstract fem cs(_CmdStruct _cmdstruct);

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.tencent.mm.plugin.appbrand.appcache.predownload.b.a<_Ret, _CmdStruct> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.vending.c.a
    public /* synthetic */ Object call(Object obj) {
        boolean z;
        d dVar = (d) obj;
        String str = (String) dVar.get(1);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) invalid appId", bwQ());
            z = false;
        } else {
            fem cs = cs(dVar.get(2));
            if (cs == null) {
                Log.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) null CmdBase", bwQ());
                z = false;
            } else {
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) cs.NzL, (long) com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQu.get(getClass()));
                long nowSecond = Util.nowSecond();
                long j2 = ((long) cs.NzJ) & Util.MAX_32BIT_VALUE;
                Log.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) DealEndTime %d , now %d", bwQ(), Long.valueOf(j2), Long.valueOf(nowSecond));
                if (j2 < nowSecond) {
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) cs.NzL, (long) com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQv.get(getClass()));
                    z = false;
                } else {
                    long j3 = Util.getLong(n.NL().get(cw(str, cs.NzN), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
                    long j4 = ((long) cs.NzK) & Util.MAX_32BIT_VALUE;
                    Log.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s), lastSeq %d, cmdSeq %d", bwQ(), Long.valueOf(j3), Long.valueOf(j4));
                    if (j3 > j4) {
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) cs.NzL, (long) com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQw.get(getClass()));
                        z = false;
                    } else if (j3 == j4) {
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar4 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) cs.NzL, (long) com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQx.get(getClass()));
                        z = false;
                    } else {
                        String str2 = cs.NzN;
                        n.NL().cN(cw(str, str2), Long.toString(j4));
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return c((String) dVar.get(0), (String) dVar.get(1), dVar.get(2));
        }
        g.hdx().ej(null);
        return null;
    }

    private String cw(String str, String str2) {
        String str3 = "PredownloadCmdSequence$" + bwQ() + '$' + str;
        if (!TextUtils.isEmpty(str2)) {
            return str3 + '$' + str2;
        }
        return str3;
    }
}
