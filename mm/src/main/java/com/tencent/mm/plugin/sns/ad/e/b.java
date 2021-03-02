package com.tencent.mm.plugin.sns.ad.e;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URI;

public final class b {
    private static boolean gNA = false;

    public static boolean KB() {
        return gNA;
    }

    public static void a(SnsInfo snsInfo, cnb cnb) {
        AppMethodBeat.i(201889);
        if (snsInfo != null && snsInfo.isAd()) {
            a(snsInfo.getAdXml(), cnb, r.Jb(snsInfo.field_snsId));
        }
        AppMethodBeat.o(201889);
    }

    public static void a(ADXml aDXml, cnb cnb, String str) {
        String str2;
        AppMethodBeat.i(201890);
        long currentTimeMillis = System.currentTimeMillis();
        if (aDXml == null || cnb == null || !cnb.isAd) {
            AppMethodBeat.o(201890);
            return;
        }
        if (aDXml.isFullCardAd()) {
            if (!eWK()) {
                Log.i("AdH265Helper", "fullcardAd not enable h265");
                a(cnb, false);
                AppMethodBeat.o(201890);
                return;
            }
            str2 = "fullcardAd enable h265";
        } else if (aDXml.isCardAd()) {
            if (!eWL()) {
                Log.i("AdH265Helper", "cardAd not enable h265");
                a(cnb, false);
                AppMethodBeat.o(201890);
                return;
            }
            str2 = "cardAd enable h265";
        } else if (!eWM()) {
            Log.i("AdH265Helper", "normalAd not enable h265");
            a(cnb, false);
            AppMethodBeat.o(201890);
            return;
        } else {
            str2 = "normalAd enable h265";
        }
        a(cnb, true);
        Log.i("AdH265Helper", "checkAdSupportH265, " + str2 + ", snsId=" + str + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(201890);
    }

    public static void a(cnb cnb, boolean z) {
        String aNE;
        AppMethodBeat.i(201891);
        long currentTimeMillis = System.currentTimeMillis();
        if (cnb == null) {
            Log.e("AdH265Helper", "setMediaInfoForH265, media==null");
            AppMethodBeat.o(201891);
        } else if (!cnb.isAd) {
            Log.e("AdH265Helper", "setMediaInfoForH265, !media.isAd");
            AppMethodBeat.o(201891);
        } else {
            try {
                if (!TextUtils.isEmpty(cnb.Url)) {
                    String str = cnb.Url;
                    if (!z) {
                        aNE = aNE(str);
                    } else if (!str.contains("svpuseh265flag")) {
                        aNE = ap.n(str, "svpuseh265flag=1");
                    } else {
                        aNE = str.replace("svpuseh265flag=0", "svpuseh265flag=1");
                    }
                    cnb.Url = aNE;
                } else {
                    Log.e("AdH265Helper", "setMediaInfoForH265, media.Url==null");
                }
            } catch (Throwable th) {
                Log.e("AdH265Helper", "setMediaInfoForH265, exp=" + th.toString());
            }
            String str2 = cnb.Id;
            try {
                if (TextUtils.isEmpty(cnb.Id)) {
                    Log.e("AdH265Helper", "setMediaInfoForH265, media.Id==null");
                } else if (z) {
                    if (!cnb.Id.contains("_hvec")) {
                        cnb.Id += "_hvec";
                    }
                } else if (cnb.Id.contains("_hvec")) {
                    cnb.Id = cnb.Id.replace("_hvec", "");
                }
            } catch (Throwable th2) {
                Log.e("AdH265Helper", "setMediaInfoForH265, exp=" + th2.toString());
            }
            Log.i("AdH265Helper", "setMediaInfoForH265, media.hash=" + cnb.hashCode() + ", enableH265=" + z + ", meida.enc=" + cnb.MsK + ", cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", rawMediaId=" + str2 + ", media.Id=" + cnb.Id);
            AppMethodBeat.o(201891);
        }
    }

    public static void a(e eVar, cnb cnb) {
        AppMethodBeat.i(201892);
        if (cnb != null && cnb.isAd && !TextUtils.isEmpty(cnb.Url)) {
            try {
                if (cnb.Url.contains("svpuseh265flag=1")) {
                    boolean sX = com.tencent.mm.modelcontrol.e.sX(6);
                    if (sX) {
                        eVar.field_requestVideoFormat = 2;
                    } else {
                        eVar.field_requestVideoFormat = 1;
                        try {
                            j.b(j.DEe, Build.MODEL.toLowerCase(), 0, 0, "");
                        } catch (Throwable th) {
                            Log.e("AdH265Helper", "checkAdDeviceSupportH265 report exp=" + th.toString());
                        }
                    }
                    Log.i("AdH265Helper", "checkAppendAdH265Flag, isDeviceSupportHevc=" + sX + ", requestVideoFormat=" + eVar.field_requestVideoFormat + ", url=" + cnb.Url);
                    an(true, sX);
                    AppMethodBeat.o(201892);
                    return;
                }
                eVar.field_requestVideoFormat = 1;
                Log.i("AdH265Helper", "checkAppendAdH265Flag, url has no h265 flag, url=" + cnb.Url);
                an(false, false);
                AppMethodBeat.o(201892);
                return;
            } catch (Throwable th2) {
                eVar.field_requestVideoFormat = 1;
                Log.e("AdH265Helper", "checkAppendAdH265Flag, exp=" + th2.toString());
            }
        }
        AppMethodBeat.o(201892);
    }

    private static boolean eWK() {
        AppMethodBeat.i(201893);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_fullcard_enable_h265, 0) > 0) {
                AppMethodBeat.o(201893);
                return true;
            }
            AppMethodBeat.o(201893);
            return false;
        } catch (Throwable th) {
            Log.e("AdH265Helper", "isExptFullCardAdEnableH265, exp=" + th.toString());
            AppMethodBeat.o(201893);
            return false;
        }
    }

    private static boolean eWL() {
        AppMethodBeat.i(201894);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_card_enable_h265, 0) > 0) {
                AppMethodBeat.o(201894);
                return true;
            }
            AppMethodBeat.o(201894);
            return false;
        } catch (Throwable th) {
            Log.e("AdH265Helper", "isExptCardAdEnableH265, exp=" + th.toString());
            AppMethodBeat.o(201894);
            return false;
        }
    }

    private static boolean eWM() {
        AppMethodBeat.i(201895);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_normal_enable_h265, 0) > 0) {
                AppMethodBeat.o(201895);
                return true;
            }
            AppMethodBeat.o(201895);
            return false;
        } catch (Throwable th) {
            Log.e("AdH265Helper", "isExptNormAdEnableH265, exp=" + th.toString());
            AppMethodBeat.o(201895);
            return false;
        }
    }

    private static String aNE(String str) {
        AppMethodBeat.i(201896);
        try {
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(201896);
                return str;
            } else if (!str.contains("svpuseh265flag")) {
                AppMethodBeat.o(201896);
                return str;
            } else {
                URI uri = new URI(str);
                String query = uri.getQuery();
                if (!TextUtils.isEmpty(query)) {
                    if (query.contains("svpuseh265flag=0")) {
                        query = query.replace("&svpuseh265flag=0", "").replace("svpuseh265flag=0", "");
                    }
                    if (query.contains("svpuseh265flag=1")) {
                        query = query.replace("&svpuseh265flag=1", "").replace("svpuseh265flag=1", "");
                    }
                    if (query.startsWith("&")) {
                        query = query.replaceFirst("&", "");
                    }
                }
                if (TextUtils.isEmpty(query)) {
                    query = null;
                }
                String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), query, uri.getFragment()).toString();
                AppMethodBeat.o(201896);
                return uri2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("AdH265Helper", e2, "", new Object[0]);
            AppMethodBeat.o(201896);
            return str;
        }
    }

    public static cnb a(cnb cnb) {
        AppMethodBeat.i(201897);
        try {
            cnb cnb2 = new cnb();
            cnb2.parseFrom(cnb.toByteArray());
            Log.d("AdH265Helper", "copyMediaObj id=" + cnb2.Id);
            AppMethodBeat.o(201897);
            return cnb2;
        } catch (Exception e2) {
            Log.e("AdH265Helper", "copyMediaObj exp=" + e2.toString());
            AppMethodBeat.o(201897);
            return cnb;
        }
    }

    private static void an(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(201898);
        if (z && z2) {
            i2 = 4;
        } else if (!z) {
            i2 = 5;
        } else {
            i2 = 6;
        }
        h.INSTANCE.dN(1579, i2);
        Log.i("AdH265Helper", "report, isOnline=false, urlHasFlag=" + z + ", cdnHasFlag=" + z2 + ", key=" + i2);
        AppMethodBeat.o(201898);
    }
}
