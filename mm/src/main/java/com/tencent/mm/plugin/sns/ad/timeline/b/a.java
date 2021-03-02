package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static boolean eXT() {
        AppMethodBeat.i(202195);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_ad_timeline_normal_video_online, 0);
            Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInNormalTimeline value is ".concat(String.valueOf(a2)));
            if (a2 > 0) {
                AppMethodBeat.o(202195);
                return true;
            }
            AppMethodBeat.o(202195);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(202195);
            return false;
        }
    }

    public static boolean eXU() {
        AppMethodBeat.i(202196);
        try {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_ad_timeline_basic_card_video_online, 0);
            Log.i("SnsAd.OnlinePlayerSwitchHelper", "useOnlineVideoInBaseCardTimeline value is  ".concat(String.valueOf(a2)));
            if (a2 > 0) {
                AppMethodBeat.o(202196);
                return true;
            }
            AppMethodBeat.o(202196);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(202196);
            return false;
        }
    }

    public static boolean a(TimeLineObject timeLineObject, ADXml aDXml) {
        boolean z;
        AppMethodBeat.i(202197);
        if (c(timeLineObject) && a(aDXml)) {
            if (eXT()) {
                if (aDXml == null || aDXml.isCardAd() || aDXml.isFullCardAd() || aDXml.isSphereCardAd()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.i("SnsAd.OnlinePlayerSwitchHelper", "the normal video preload is disable, because the online normal video preload is enable!");
                    AppMethodBeat.o(202197);
                    return true;
                }
            }
            if (!eXU() || !aDXml.isCardAd()) {
                Log.i("SnsAd.OnlinePlayerSwitchHelper", "the ad video preload is not disable!");
            } else {
                Log.i("SnsAd.OnlinePlayerSwitchHelper", "the base card ad video preload is disable, because the online base card prload is enable!");
                AppMethodBeat.o(202197);
                return true;
            }
        }
        AppMethodBeat.o(202197);
        return false;
    }

    public static boolean n(SnsInfo snsInfo) {
        AppMethodBeat.i(202198);
        if (snsInfo == null) {
            Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is null!!");
            AppMethodBeat.o(202198);
            return false;
        } else if (!snsInfo.isAd()) {
            Log.w("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoPreload: the snsInfo is not ad!!");
            AppMethodBeat.o(202198);
            return false;
        } else {
            TimeLineObject timeLine = snsInfo.getTimeLine();
            ADXml adXml = snsInfo.getAdXml();
            boolean a2 = a(timeLine, adXml);
            if (a2) {
                try {
                    if (timeLine.ContentObj != null && timeLine.ContentObj.LoV.size() > 0) {
                        Log.i("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload, snsId=" + timeLine.Id);
                        com.tencent.mm.plugin.sns.ad.e.b.a(adXml, timeLine.ContentObj.LoV.get(0), timeLine.Id);
                    }
                } catch (Throwable th) {
                    Log.e("SnsAd.OnlinePlayerSwitchHelper", "AdH265Helper, enableAdOnlineVideoPreload exp=" + th.toString());
                }
            }
            AppMethodBeat.o(202198);
            return a2;
        }
    }

    public static boolean c(TimeLineObject timeLineObject) {
        if (timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoU != 15) {
            return false;
        }
        return true;
    }

    public static boolean a(ADXml aDXml) {
        boolean z = false;
        AppMethodBeat.i(202199);
        if (aDXml != null) {
            if (aDXml.videoPlayInStreamingMode > 0) {
                z = true;
            }
            Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml return ".concat(String.valueOf(z)));
            AppMethodBeat.o(202199);
        } else {
            Log.d("SnsAd.OnlinePlayerSwitchHelper", "enableOnlineVideoFeatureInAdXml : the adxml is null, so return false");
            AppMethodBeat.o(202199);
        }
        return z;
    }
}
