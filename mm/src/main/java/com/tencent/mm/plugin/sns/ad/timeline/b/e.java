package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.e.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class e {
    private static Set<String> DyR = Collections.synchronizedSet(new HashSet());

    public static boolean a(TimeLineObject timeLineObject, ADXml aDXml, int i2) {
        AppMethodBeat.i(202214);
        try {
            if (!eXV()) {
                Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
                AppMethodBeat.o(202214);
                return false;
            }
            b(timeLineObject, aDXml, i2);
            AppMethodBeat.o(202214);
            return false;
        } catch (Throwable th) {
            Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp=" + th.toString());
        }
    }

    public static boolean a(ds dsVar) {
        AppMethodBeat.i(202215);
        try {
            if (!eXV()) {
                Log.w("TimeLineAdPreloadHelper", "checkPreloadAdResource, network is not wifi or 4G,5G");
                AppMethodBeat.o(202215);
                return false;
            }
            b(n.PM(z.b(dsVar.KHG.MYH.ObjectDesc)), new ADXml(z.a(dsVar.KHG.MYI)), 1);
            AppMethodBeat.o(202215);
            return false;
        } catch (Throwable th) {
            Log.e("TimeLineAdPreloadHelper", "checkPreloadAdResource, exp2=" + th.toString());
        }
    }

    private static void b(TimeLineObject timeLineObject, ADXml aDXml, int i2) {
        AppMethodBeat.i(202216);
        Log.i("TimeLineAdPreloadHelper", "doPreload, scene=".concat(String.valueOf(i2)));
        b(timeLineObject, aDXml);
        a(aDXml, timeLineObject.Id);
        if (aDXml != null) {
            a(aDXml.adScanJumpInfo, timeLineObject.Id);
        }
        AppMethodBeat.o(202216);
    }

    private static boolean eXV() {
        AppMethodBeat.i(202217);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext()) || NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(202217);
            return true;
        }
        AppMethodBeat.o(202217);
        return false;
    }

    private static boolean b(TimeLineObject timeLineObject, ADXml aDXml) {
        AppMethodBeat.i(202218);
        try {
            if (timeLineObject.ContentObj.LoU != 15) {
                Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, ContentStyle is not video, snsId=" + timeLineObject.Id);
                AppMethodBeat.o(202218);
                return false;
            } else if (timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.isEmpty()) {
                Log.w("TimeLineAdPreloadHelper", "preloadAdVideo, MediaObjList is empty, snsId=" + timeLineObject.Id);
                AppMethodBeat.o(202218);
                return false;
            } else if (b(aDXml, timeLineObject.Id)) {
                Log.i("TimeLineAdPreloadHelper", "the sns info is topic card info, snsId=" + timeLineObject.Id);
                AppMethodBeat.o(202218);
                return true;
            } else {
                cnb cnb = timeLineObject.ContentObj.LoV.get(0);
                boolean a2 = a.a(timeLineObject, aDXml);
                Log.i("TimeLineAdPreloadHelper", "AdH265Helper, preloadAdVideo, isOnlineVideo=".concat(String.valueOf(a2)));
                b.a(aDXml, cnb, timeLineObject.Id);
                if (!a2) {
                    a(cnb, timeLineObject.Id);
                }
                b(cnb, timeLineObject.Id);
                AppMethodBeat.o(202218);
                return true;
            }
        } catch (Throwable th) {
            Log.e("TimeLineAdPreloadHelper", "preloadAdVideo, doCheckVideo  Ad exp=" + th.toString());
            AppMethodBeat.o(202218);
            return false;
        }
    }

    private static boolean a(final cnb cnb, final String str) {
        AppMethodBeat.i(202219);
        String str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
        if (s.YS(str2)) {
            Log.w("TimeLineAdPreloadHelper", "startPreloadVideo, file Exists, snsId=" + str + ", mediaId=" + cnb.Id + ", filePath=" + str2);
            AppMethodBeat.o(202219);
            return false;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.b.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(202210);
                try {
                    Log.i("TimeLineAdPreloadHelper", "startPreloadVideo, snsId=" + str + ", mediaId=" + cnb.Id);
                    aj.faJ().a(cnb, 4, (com.tencent.mm.plugin.sns.data.n) null, bp.Oqt);
                    AppMethodBeat.o(202210);
                } catch (Throwable th) {
                    Log.e("TimeLineAdPreloadHelper", "startPreloadVideo exp=" + th.toString());
                    AppMethodBeat.o(202210);
                }
            }
        });
        AppMethodBeat.o(202219);
        return true;
    }

    private static boolean b(final cnb cnb, final String str) {
        AppMethodBeat.i(202220);
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        if (s.YS(ki + r.e(cnb))) {
            Log.w("TimeLineAdPreloadHelper", "startPreloadThumb, file Exists, snsId=" + str + ", mediaId=" + cnb.Id);
            AppMethodBeat.o(202220);
            return false;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.b.e.AnonymousClass2 */

            public final void run() {
                int i2 = 1;
                AppMethodBeat.i(202211);
                try {
                    Log.i("TimeLineAdPreloadHelper", "startPreloadThumb, snsId=" + str + ", mediaId=" + cnb.Id);
                    com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(cnb);
                    nVar.DEs = 1;
                    nVar.dPI = cnb.Id;
                    c faJ = aj.faJ();
                    cnb cnb = cnb;
                    if (cnb.oUv == 6) {
                        i2 = 5;
                    }
                    faJ.a(cnb, i2, nVar, bp.Oqt);
                    AppMethodBeat.o(202211);
                } catch (Throwable th) {
                    Log.e("TimeLineAdPreloadHelper", "startPreloadThumb exp=" + th.toString());
                    AppMethodBeat.o(202211);
                }
            }
        });
        AppMethodBeat.o(202220);
        return true;
    }

    private static void a(ADXml aDXml, String str) {
        AppMethodBeat.i(202221);
        if (aDXml == null || !aDXml.isFullCardAd() || aDXml.adFullCardInfo == null) {
            AppMethodBeat.o(202221);
            return;
        }
        if (aDXml.adFullCardInfo.DWE != null) {
            aG(aDXml.adFullCardInfo.DWE.EwR, str, "preloadFullCardImage fullcardEndView.titleImage");
            aG(aDXml.adFullCardInfo.DWE.coverImgUrl, str, "preloadFullCardImage fullcardEndView.coverImg");
        }
        aG(aDXml.adFullCardInfo.DWA, str, "preloadFullCardImage fullcard.frontCover");
        aG(aDXml.adFullCardInfo.DWC, str, "preloadFullCardImage fullcard.endCover");
        AppMethodBeat.o(202221);
    }

    public static void a(ADXml.b bVar, String str) {
        AppMethodBeat.i(202222);
        if (bVar != null) {
            aG(bVar.DWj, str, "preloadScanRes bgImage");
            aG(bVar.pSE, str, "preloadScanRes descIcon");
            aG(bVar.DWk, str, "preloadScanRes succIcon");
        }
        AppMethodBeat.o(202222);
    }

    private static boolean b(ADXml aDXml, String str) {
        AppMethodBeat.i(202223);
        if (aDXml == null || aDXml.adFinderTopicInfo == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202223);
            return false;
        }
        try {
            List<com.tencent.mm.plugin.sns.ad.a.e> list = aDXml.adFinderTopicInfo.DrS;
            if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(list)) {
                AppMethodBeat.o(202223);
                return false;
            }
            for (com.tencent.mm.plugin.sns.ad.a.e eVar : list) {
                if (eVar != null && eVar.eWB()) {
                    a(eVar.ebR, str);
                    b(eVar.ebR, str);
                }
            }
            Log.d("TimeLineAdPreloadHelper", "the topic card resource preloaded!");
            AppMethodBeat.o(202223);
            return true;
        } catch (Throwable th) {
            Log.e("TimeLineAdPreloadHelper", "preloadTopicCardRes exp=" + th.toString());
            AppMethodBeat.o(202223);
            return false;
        }
    }

    static {
        AppMethodBeat.i(202226);
        AppMethodBeat.o(202226);
    }

    private static void aG(final String str, final String str2, final String str3) {
        AppMethodBeat.i(202224);
        if (TextUtils.isEmpty(str)) {
            Log.w("TimeLineAdPreloadHelper", str3 + " url is empty, snsid=" + str2);
            AppMethodBeat.o(202224);
            return;
        }
        String kz = h.kz("adId", str);
        if (!TextUtils.isEmpty(kz) && s.YS(kz)) {
            Log.i("TimeLineAdPreloadHelper", str3 + " file exists, snsid=" + str2);
            AppMethodBeat.o(202224);
        } else if (DyR.contains(str)) {
            Log.w("TimeLineAdPreloadHelper", str3 + " is in downloading, snsid=" + str2);
            AppMethodBeat.o(202224);
        } else {
            DyR.add(str);
            h.a(str, true, (f.a) new f.a() {
                /* class com.tencent.mm.plugin.sns.ad.timeline.b.e.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(202212);
                    Log.e("TimeLineAdPreloadHelper", str3 + " failed, snsid=" + str2 + ", url=" + str);
                    e.DyR.remove(str);
                    AppMethodBeat.o(202212);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(202213);
                    Log.i("TimeLineAdPreloadHelper", str3 + " succ, snsid=" + str2 + ", url=" + str);
                    e.DyR.remove(str);
                    AppMethodBeat.o(202213);
                }
            });
            AppMethodBeat.o(202224);
        }
    }

    public static String aNR(String str) {
        AppMethodBeat.i(259434);
        String kz = h.kz("adId", str);
        AppMethodBeat.o(259434);
        return kz;
    }
}
