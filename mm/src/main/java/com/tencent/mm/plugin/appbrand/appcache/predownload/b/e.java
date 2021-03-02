package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class e extends a<Boolean, fer> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fer fer) {
        AppMethodBeat.i(44392);
        Boolean a2 = a(str, str2, fer);
        AppMethodBeat.o(44392);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fer fer) {
        return fer.NzO;
    }

    private static Boolean a(String str, String str2, fer fer) {
        boolean z;
        int i2;
        WxaAttributes.WxaVersionInfo wxaVersionInfo;
        AppMethodBeat.i(44391);
        String str3 = fer.NAe;
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", str, str2);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(44391);
            return bool;
        }
        try {
            byte[] decode = Base64.decode(str3, 0);
            fcv fcv = new fcv();
            fcv.parseFrom(decode);
            WxaAttributes d2 = n.buC().d(str, "versionInfo");
            WxaAttributes.WxaVersionInfo bAp = d2 == null ? null : d2.bAp();
            WxaAttributes.WxaVersionInfo wxaVersionInfo2 = null;
            Iterator<fcu> it = fcv.KSX.iterator();
            while (it.hasNext()) {
                fcu next = it.next();
                if ("WxaAppVersionInfo".equals(next.xMX)) {
                    wxaVersionInfo = WxaAttributes.WxaVersionInfo.XJ(next.Cyk);
                } else {
                    wxaVersionInfo = wxaVersionInfo2;
                }
                wxaVersionInfo2 = wxaVersionInfo;
            }
            if (wxaVersionInfo2 == null) {
                a aVar = a.INSTANCE;
                a.F((long) fer.NzO.NzL, 87);
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(44391);
                return bool2;
            }
            a aVar2 = a.INSTANCE;
            a.F((long) fer.NzO.NzL, 88);
            boolean z2 = bAp == null || wxaVersionInfo2 == null || bAp.appVersion < wxaVersionInfo2.appVersion;
            if (z2) {
                n.buC().a(str, fcv.KSW, fcv.KSX);
                z = n.buC().d(str, new String[0]) != null;
                if (z) {
                    ((b) n.W(b.class)).b(new b.a.C0564b(str));
                }
                a aVar3 = a.INSTANCE;
                int i3 = fer.NzO.NzL;
                if (z) {
                    i2 = 85;
                } else {
                    i2 = 86;
                }
                a.F((long) i3, (long) i2);
            } else {
                a aVar4 = a.INSTANCE;
                a.F((long) fer.NzO.NzL, 84);
                z = false;
            }
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(bAp == null ? -1 : bAp.appVersion);
            objArr[3] = Integer.valueOf(wxaVersionInfo2 == null ? -1 : wxaVersionInfo2.appVersion);
            objArr[4] = Boolean.valueOf(z2);
            objArr[5] = Boolean.valueOf(z);
            Log.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", objArr);
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(44391);
            return valueOf;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", e2, "call[%s | %s], decode base64", str, str2);
            Boolean bool3 = Boolean.FALSE;
            AppMethodBeat.o(44391);
            return bool3;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdIssueContact";
    }
}
