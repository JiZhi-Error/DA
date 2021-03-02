package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public class f extends a<Boolean, fes> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fes fes) {
        boolean z;
        int i2;
        boolean z2 = false;
        AppMethodBeat.i(44400);
        fes fes2 = fes;
        int i3 = fes2.KSa;
        String str3 = fes2.NAf;
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call appId(%s) version(%d) key nil", str2, Integer.valueOf(i3));
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) fes2.NzO.NzL, 124);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(44400);
            return bool;
        } else if (WxaPkgIntegrityChecker.D(str2, 0, i3).first == WxaPkgIntegrityChecker.a.APP_READY) {
            Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, normal pkg ok appId(%s), version(%d)", str2, Integer.valueOf(i3));
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) fes2.NzO.NzL, 125);
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(44400);
            return bool2;
        } else {
            am A = ((an) n.W(an.class)).A(str2, 1, i3);
            if (A == null) {
                Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, null encrypt pkg info with %s, %d", str2, Integer.valueOf(i3));
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) fes2.NzO.NzL, 126);
                z = true;
            } else {
                z = !a(A, fes2.NAf, fes2.Md5, fes2.NzO.NzL, a.ISSUE_DECRYPT);
            }
            if (z) {
                ap apVar = (ap) n.W(ap.class);
                String str4 = fes2.Md5;
                int i4 = fes2.NzO.NzL;
                if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                    Log.e("MicroMsg.AppBrand.Predownload.PushWxaPkgDecryptKeyStorage", "setDecryptKey, invalid appId[%s], decryptKey[%s]", str2, str3);
                } else {
                    ao aoVar = new ao();
                    aoVar.field_appId = str2;
                    aoVar.field_appVersion = i3;
                    boolean z3 = apVar.get(aoVar, new String[0]);
                    aoVar.field_decryptKey = str3;
                    aoVar.field_reportId = i4;
                    aoVar.field_pkgMd5 = str4;
                    z2 = z3 ? apVar.update(aoVar, new String[0]) : apVar.insert(aoVar);
                }
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar4 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                int i5 = fes2.NzO.NzL;
                if (z2) {
                    i2 = c.CTRL_INDEX;
                } else {
                    i2 = r.CTRL_INDEX;
                }
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i5, (long) i2);
            }
            Boolean bool3 = Boolean.TRUE;
            AppMethodBeat.o(44400);
            return bool3;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fes fes) {
        return fes.NzO;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdIssueDecryptKey";
    }

    private static boolean a(am amVar, String str, String str2, int i2, a aVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z = false;
        AppMethodBeat.i(44397);
        switch (aVar) {
            case WXA_LAUNCH:
                i3 = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
                break;
            default:
                i3 = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
                break;
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i3);
        String aT = ba.aT(amVar.field_appId, amVar.field_version);
        int aesDecryptFile = MMProtocalJni.aesDecryptFile(amVar.field_pkgPath, aT, str.getBytes());
        Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", amVar.field_appId, Integer.valueOf(amVar.field_version), Integer.valueOf(aesDecryptFile));
        if (aesDecryptFile != 0) {
            switch (aVar) {
                case WXA_LAUNCH:
                    i7 = 133;
                    break;
                default:
                    i7 = 129;
                    break;
            }
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i7);
            AppMethodBeat.o(44397);
            return false;
        }
        String bhK = s.bhK(aT);
        if (!bhK.equals(str2)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", bhK, str2);
            switch (aVar) {
                case WXA_LAUNCH:
                    i6 = g.CTRL_INDEX;
                    break;
                default:
                    i6 = 130;
                    break;
            }
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar4 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i6);
            AppMethodBeat.o(44397);
            return false;
        }
        n.buL().r(amVar.field_appId, amVar.field_version, str2);
        boolean e2 = n.buL().e(amVar.field_appId, 0, amVar.field_version, aT);
        switch (aVar) {
            case WXA_LAUNCH:
                if (!e2) {
                    i4 = 148;
                    break;
                } else {
                    i4 = TbsListener.ErrorCode.NEEDDOWNLOAD_8;
                    break;
                }
            default:
                if (!e2) {
                    i4 = 144;
                    break;
                } else {
                    i4 = TbsListener.ErrorCode.NEEDDOWNLOAD_4;
                    break;
                }
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar5 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i4);
        s.deleteFile(amVar.field_pkgPath);
        int i8 = ((an) n.W(an.class)).delete(amVar, new String[0]) ? b.CTRL_INDEX : 140;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar6 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i8);
        if (aVar != a.ISSUE_DECRYPT) {
            ap apVar = (ap) n.W(ap.class);
            String str3 = amVar.field_appId;
            int i9 = amVar.field_version;
            if (!Util.isNullOrNil(str3)) {
                ao aoVar = new ao();
                aoVar.field_appId = str3;
                aoVar.field_appVersion = i9;
                z = apVar.delete(aoVar, new String[0]);
            }
            int i10 = z ? 141 : TbsListener.ErrorCode.NEEDDOWNLOAD_3;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar7 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i10);
        }
        switch (aVar) {
            case WXA_LAUNCH:
                i5 = 132;
                break;
            default:
                i5 = 128;
                break;
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar8 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i2, (long) i5);
        AppMethodBeat.o(44397);
        return true;
    }

    public enum a {
        WXA_LAUNCH,
        ISSUE_DECRYPT,
        GET_CODE;

        public static a valueOf(String str) {
            AppMethodBeat.i(44395);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44395);
            return aVar;
        }

        static {
            AppMethodBeat.i(44396);
            AppMethodBeat.o(44396);
        }
    }

    public static boolean a(am amVar, a aVar) {
        ao aoVar;
        AppMethodBeat.i(44398);
        String str = amVar.field_appId;
        int i2 = amVar.field_version;
        ao aoVar2 = new ao();
        aoVar2.field_appId = str;
        aoVar2.field_appVersion = i2;
        if (((ap) n.W(ap.class)).get(aoVar2, new String[0])) {
            aoVar = aoVar2;
        } else {
            aoVar = null;
        }
        if (aoVar == null) {
            Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", amVar.toShortString());
            AppMethodBeat.o(44398);
            return false;
        }
        boolean a2 = a(amVar, aoVar.field_decryptKey, aoVar.field_pkgMd5, aoVar.field_reportId, aVar);
        AppMethodBeat.o(44398);
        return a2;
    }
}
