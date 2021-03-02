package com.tencent.mm.plugin.sns.j;

import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class o {
    public static String INVALID_TAG = "]]>";
    public static String oJw = "<TimelineObject>";
    public static String oJx = "</TimelineObject>";

    private static String filterNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String filterId(String str) {
        boolean z;
        AppMethodBeat.i(96171);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(96171);
            return "";
        }
        if (str.matches("\\d*")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(96171);
            return str;
        }
        AppMethodBeat.o(96171);
        return "";
    }

    /* access modifiers changed from: package-private */
    public static class a {
        StringBuffer sb = new StringBuffer();

        a() {
            AppMethodBeat.i(96165);
            AppMethodBeat.o(96165);
        }

        public final void startTag(String str) {
            AppMethodBeat.i(96166);
            this.sb.append("<" + str + ">");
            AppMethodBeat.o(96166);
        }

        public final void endTag(String str) {
            AppMethodBeat.i(96167);
            this.sb.append("</" + str + ">");
            AppMethodBeat.o(96167);
        }

        public final void setText(String str) {
            AppMethodBeat.i(96168);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(96168);
            } else if (str.contains(o.INVALID_TAG)) {
                this.sb.append("<![CDATA[" + Util.escapeStringForXml(str) + "]]>");
                AppMethodBeat.o(96168);
            } else {
                this.sb.append("<![CDATA[" + str + "]]>");
                AppMethodBeat.o(96168);
            }
        }

        public final void append(String str) {
            AppMethodBeat.i(163073);
            if (!Util.isNullOrNil(str)) {
                this.sb.append(str);
            }
            AppMethodBeat.o(163073);
        }

        public final void setText(int i2) {
            AppMethodBeat.i(96169);
            this.sb.append(i2);
            AppMethodBeat.o(96169);
        }

        public final void startTag(String str, Map<String, String> map) {
            AppMethodBeat.i(96170);
            this.sb.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.sb.append(" " + str2 + "=\"" + map.get(str2) + "\" ");
            }
            this.sb.append(">");
            map.clear();
            AppMethodBeat.o(96170);
        }
    }

    public static String e(TimeLineObject timeLineObject) {
        AppMethodBeat.i(96172);
        a aVar = new a();
        HashMap hashMap = new HashMap();
        aVar.startTag("TimelineObject");
        aVar.startTag("id");
        if (timeLineObject.Id == null || timeLineObject.Id.equals("")) {
            aVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            aVar.setText(timeLineObject.Id);
        }
        aVar.endTag("id");
        if (timeLineObject.UserName != null) {
            aVar.startTag(ch.COL_USERNAME);
            aVar.setText(timeLineObject.UserName);
            aVar.endTag(ch.COL_USERNAME);
        }
        aVar.startTag("createTime");
        aVar.setText(new StringBuilder().append(timeLineObject.CreateTime).toString());
        aVar.endTag("createTime");
        aVar.startTag("contentDescShowType");
        aVar.setText(timeLineObject.contentDescShowType);
        aVar.endTag("contentDescShowType");
        aVar.startTag("contentDescScene");
        aVar.setText(timeLineObject.contentDescScene);
        aVar.endTag("contentDescScene");
        aVar.startTag("private");
        aVar.setText(new StringBuilder().append(timeLineObject.Privated).toString());
        aVar.endTag("private");
        if (timeLineObject.AppInfo != null && !Util.isNullOrNil(timeLineObject.AppInfo.Id)) {
            aVar.startTag("appInfo");
            aVar.startTag("id");
            aVar.setText(filterNull(timeLineObject.AppInfo.Id));
            aVar.endTag("id");
            aVar.startTag("version");
            aVar.setText(filterNull(timeLineObject.AppInfo.Version));
            aVar.endTag("version");
            aVar.startTag("appName");
            aVar.setText(filterNull(timeLineObject.AppInfo.xMq));
            aVar.endTag("appName");
            aVar.startTag("installUrl");
            aVar.setText(filterNull(timeLineObject.AppInfo.KIq));
            aVar.endTag("installUrl");
            aVar.startTag("fromUrl");
            aVar.setText(filterNull(timeLineObject.AppInfo.KIr));
            aVar.endTag("fromUrl");
            aVar.endTag("appInfo");
        }
        if (timeLineObject.streamvideo != null && !Util.isNullOrNil(timeLineObject.streamvideo.iyZ)) {
            aVar.startTag("streamvideo");
            aVar.startTag("streamvideourl");
            aVar.setText(filterNull(timeLineObject.streamvideo.iyZ));
            aVar.endTag("streamvideourl");
            aVar.startTag("streamvideototaltime");
            aVar.setText(timeLineObject.streamvideo.iza);
            aVar.endTag("streamvideototaltime");
            aVar.startTag("streamvideotitle");
            aVar.setText(filterNull(timeLineObject.streamvideo.izb));
            aVar.endTag("streamvideotitle");
            aVar.startTag("streamvideowording");
            aVar.setText(filterNull(timeLineObject.streamvideo.izc));
            aVar.endTag("streamvideowording");
            aVar.startTag("streamvideoweburl");
            aVar.setText(filterNull(timeLineObject.streamvideo.izd));
            aVar.endTag("streamvideoweburl");
            aVar.startTag("streamvideothumburl");
            aVar.setText(filterNull(timeLineObject.streamvideo.ize));
            aVar.endTag("streamvideothumburl");
            aVar.startTag("streamvideoaduxinfo");
            aVar.setText(filterNull(timeLineObject.streamvideo.izf));
            aVar.endTag("streamvideoaduxinfo");
            aVar.startTag("streamvideopublishid");
            aVar.setText(filterNull(timeLineObject.streamvideo.izg));
            aVar.endTag("streamvideopublishid");
            aVar.endTag("streamvideo");
        }
        if (timeLineObject.webSearchInfo != null && !Util.isNullOrNil(timeLineObject.webSearchInfo.IEy)) {
            aVar.startTag("websearch");
            aVar.startTag("relevant_vid");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEy));
            aVar.endTag("relevant_vid");
            aVar.startTag("relevant_expand");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEz));
            aVar.endTag("relevant_expand");
            aVar.startTag("relevant_pre_searchid");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEA));
            aVar.endTag("relevant_pre_searchid");
            aVar.startTag("relevant_shared_openid");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEB));
            aVar.endTag("relevant_shared_openid");
            aVar.startTag("rec_category");
            aVar.setText(filterNull(new StringBuilder().append(timeLineObject.webSearchInfo.IEC).toString()));
            aVar.endTag("rec_category");
            aVar.startTag("shareUrl");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.rCq));
            aVar.endTag("shareUrl");
            aVar.startTag("shareTitle");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.msN));
            aVar.endTag("shareTitle");
            aVar.startTag("shareDesc");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.xDQ));
            aVar.endTag("shareDesc");
            aVar.startTag("shareImgUrl");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IED));
            aVar.endTag("shareImgUrl");
            aVar.startTag("shareString");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEE));
            aVar.endTag("shareString");
            aVar.startTag("shareStringUrl");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEF));
            aVar.endTag("shareStringUrl");
            aVar.startTag("source");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.source));
            aVar.endTag("source");
            aVar.startTag("strPlayCount");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEG));
            aVar.endTag("strPlayCount");
            aVar.startTag("titleUrl");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEH));
            aVar.endTag("titleUrl");
            aVar.startTag("extReqParams");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEI));
            aVar.endTag("extReqParams");
            aVar.startTag("tagList");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEJ));
            aVar.endTag("tagList");
            aVar.startTag("channelId");
            aVar.setText(filterNull(new StringBuilder().append(timeLineObject.webSearchInfo.IEK).toString()));
            aVar.endTag("channelId");
            aVar.startTag("thumbUrl");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.thumbUrl));
            aVar.endTag("thumbUrl");
            aVar.startTag("shareTag");
            aVar.setText(filterNull(timeLineObject.webSearchInfo.IEL));
            aVar.endTag("shareTag");
            aVar.endTag("websearch");
        }
        aVar.startTag("contentDesc");
        aVar.setText(filterNull(timeLineObject.ContentDesc));
        aVar.endTag("contentDesc");
        aVar.startTag("contentattr");
        aVar.setText(new StringBuilder().append(timeLineObject.contentattr).toString());
        aVar.endTag("contentattr");
        aVar.startTag("sourceUserName");
        aVar.setText(filterNull(timeLineObject.sourceUserName));
        aVar.endTag("sourceUserName");
        aVar.startTag("sourceNickName");
        aVar.setText(filterNull(timeLineObject.sourceNickName));
        aVar.endTag("sourceNickName");
        aVar.startTag("statisticsData");
        aVar.setText(filterNull(timeLineObject.statisticsData));
        aVar.endTag("statisticsData");
        aVar.startTag("weappInfo");
        aVar.startTag("appUserName");
        aVar.setText(filterNull(timeLineObject.weappInfo.username));
        aVar.endTag("appUserName");
        aVar.startTag("pagePath");
        aVar.setText(filterNull(timeLineObject.weappInfo.path));
        aVar.endTag("pagePath");
        aVar.startTag("version");
        aVar.setText(filterNull(new StringBuilder().append(timeLineObject.weappInfo.version).toString()));
        aVar.endTag("version");
        aVar.startTag("debugMode");
        aVar.setText(filterNull(new StringBuilder().append(timeLineObject.weappInfo.nbf).toString()));
        aVar.endTag("debugMode");
        aVar.startTag("shareActionId");
        aVar.setText(filterNull(timeLineObject.weappInfo.dCC));
        aVar.endTag("shareActionId");
        aVar.startTag("isGame");
        aVar.setText(filterNull(new StringBuilder().append(timeLineObject.weappInfo.isGame).toString()));
        aVar.endTag("isGame");
        aVar.startTag("messageExtraData");
        aVar.setText(filterNull(timeLineObject.weappInfo.eda));
        aVar.endTag("messageExtraData");
        aVar.startTag("subType");
        aVar.setText(filterNull(new StringBuilder().append(timeLineObject.weappInfo.subType).toString()));
        aVar.endTag("subType");
        aVar.startTag("preloadResources");
        aVar.setText(filterNull(timeLineObject.weappInfo.Nvm));
        aVar.endTag("preloadResources");
        aVar.endTag("weappInfo");
        aVar.startTag("canvasInfoXml");
        aVar.setText(filterNull(timeLineObject.canvasInfo));
        aVar.endTag("canvasInfoXml");
        if (timeLineObject.Location != null) {
            float f2 = timeLineObject.Location.LbC;
            float f3 = timeLineObject.Location.LbD;
            if (!(f2 == -1000.0f || f3 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", new StringBuilder().append(timeLineObject.Location.LbC).toString());
                hashMap.put("latitude", new StringBuilder().append(timeLineObject.Location.LbD).toString());
                hashMap.put("city", Util.escapeStringForXml(filterNull(timeLineObject.Location.kea)));
                hashMap.put("poiName", Util.escapeStringForXml(filterNull(timeLineObject.Location.kHV)));
                hashMap.put("poiAddress", Util.escapeStringForXml(filterNull(timeLineObject.Location.ErZ)));
                hashMap.put("poiScale", new StringBuilder().append(timeLineObject.Location.Mpu).toString());
                hashMap.put("poiClassifyId", filterNull(timeLineObject.Location.LIb));
                hashMap.put("poiClassifyType", new StringBuilder().append(timeLineObject.Location.Esb).toString());
                hashMap.put("poiClickableStatus", new StringBuilder().append(timeLineObject.Location.Mpv).toString());
                aVar.startTag(FirebaseAnalytics.b.LOCATION, hashMap);
                aVar.endTag(FirebaseAnalytics.b.LOCATION);
            }
        }
        aVar.startTag("ContentObject");
        aVar.startTag("contentStyle");
        aVar.setText(new StringBuilder().append(timeLineObject.ContentObj.LoU).toString());
        aVar.endTag("contentStyle");
        aVar.startTag("contentSubStyle");
        aVar.setText(new StringBuilder().append(timeLineObject.ContentObj.LoW).toString());
        aVar.endTag("contentSubStyle");
        aVar.startTag("title");
        aVar.setText(filterNull(timeLineObject.ContentObj.Title));
        aVar.endTag("title");
        aVar.startTag("description");
        aVar.setText(filterNull(timeLineObject.ContentObj.Desc));
        aVar.endTag("description");
        aVar.startTag("contentUrl");
        aVar.setText(filterNull(timeLineObject.ContentObj.Url));
        aVar.endTag("contentUrl");
        if (timeLineObject.ContentObj.LoV.size() > 0) {
            aVar.startTag("mediaList");
            Iterator<cnb> it = timeLineObject.ContentObj.LoV.iterator();
            while (it.hasNext()) {
                cnb next = it.next();
                aVar.startTag("media");
                aVar.startTag("id");
                if (filterId(next.Id).equals("")) {
                    aVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    aVar.setText(filterId(next.Id));
                }
                aVar.endTag("id");
                aVar.startTag("type");
                aVar.setText(new StringBuilder().append(next.oUv).toString());
                aVar.endTag("type");
                aVar.startTag("title");
                aVar.setText(filterNull(next.Title));
                aVar.endTag("title");
                aVar.startTag("description");
                aVar.setText(filterNull(next.Desc));
                aVar.endTag("description");
                aVar.startTag("private");
                aVar.setText(new StringBuilder().append(next.Privated).toString());
                aVar.endTag("private");
                if (!Util.isNullOrNil(next.songAlbumUrl)) {
                    aVar.startTag("songalbumurl");
                    aVar.setText(next.songAlbumUrl);
                    aVar.endTag("songalbumurl");
                }
                if (!Util.isNullOrNil(next.songLyric)) {
                    aVar.startTag("songlyric");
                    aVar.setText(next.songLyric);
                    aVar.endTag("songlyric");
                }
                hashMap.clear();
                hashMap.put("type", new StringBuilder().append(next.Mcw).toString());
                if (!Util.isNullOrNil(next.md5)) {
                    hashMap.put("md5", next.md5);
                }
                if (!Util.isNullOrNil(next.MsS)) {
                    hashMap.put("videomd5", next.MsS);
                }
                aVar.startTag("url", hashMap);
                aVar.setText(filterNull(next.Url));
                aVar.endTag("url");
                if (next.Msz != null && !next.Msz.equals("")) {
                    hashMap.clear();
                    hashMap.put("type", new StringBuilder().append(next.MsA).toString());
                    aVar.startTag("thumb", hashMap);
                    aVar.setText(filterNull(next.Msz));
                    aVar.endTag("thumb");
                }
                aVar.startTag("videoDuration");
                aVar.setText(new StringBuilder().append(next.MsT).toString());
                aVar.endTag("videoDuration");
                if (next.subType > 0) {
                    aVar.startTag("subType");
                    aVar.setText(new StringBuilder().append(next.subType).toString());
                    aVar.endTag("subType");
                }
                if (!Util.isNullOrNil(next.EpK)) {
                    aVar.startTag("userData");
                    aVar.setText(next.EpK);
                    aVar.endTag("userData");
                }
                if (next.MsC != null && !next.MsC.equals("")) {
                    hashMap.clear();
                    hashMap.put("type", new StringBuilder().append(next.MsD).toString());
                    aVar.startTag("lowBandUrl", hashMap);
                    aVar.setText(filterNull(next.MsC));
                    aVar.endTag("lowBandUrl");
                }
                if (next.MsB != null) {
                    hashMap.clear();
                    if (next.MsB.Mto > 0.0f) {
                        hashMap.put("width", new StringBuilder().append(next.MsB.Mto).toString());
                    }
                    if (next.MsB.Mtp > 0.0f) {
                        hashMap.put("height", new StringBuilder().append(next.MsB.Mtp).toString());
                    }
                    if (next.MsB.Mtq > 0.0f) {
                        hashMap.put("totalSize", new StringBuilder().append(next.MsB.Mtq).toString());
                    }
                    aVar.startTag("size", hashMap);
                    aVar.endTag("size");
                }
                aVar.endTag("media");
            }
            aVar.endTag("mediaList");
        }
        aVar.sb.append(filterNull(timeLineObject.ContentObj.LoX));
        if (!(timeLineObject.ContentObj.LoY == null || timeLineObject.ContentObj.LoY.iAb == -1)) {
            aVar.startTag("mmreadershare");
            aVar.startTag("itemshowtype");
            aVar.setText(timeLineObject.ContentObj.LoY.iAb);
            aVar.endTag("itemshowtype");
            aVar.startTag("ispaysubscribe");
            aVar.setText(timeLineObject.ContentObj.LoY.iwf);
            aVar.endTag("ispaysubscribe");
            if (timeLineObject.ContentObj.LoY.iAb == 5) {
                aVar.startTag("pubtime");
                aVar.setText(timeLineObject.ContentObj.LoY.iwd);
                aVar.endTag("pubtime");
                aVar.startTag("vid");
                aVar.setText(timeLineObject.ContentObj.LoY.vid);
                aVar.endTag("vid");
                aVar.startTag("funcflag");
                aVar.setText(timeLineObject.ContentObj.LoY.iwg);
                aVar.endTag("funcflag");
                aVar.startTag(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                aVar.setText(timeLineObject.ContentObj.LoY.duration);
                aVar.endTag(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                aVar.startTag("digest");
                aVar.setText(timeLineObject.ContentObj.LoY.desc);
                aVar.endTag("digest");
                aVar.startTag("cover");
                aVar.setText(timeLineObject.ContentObj.LoY.coverUrl);
                aVar.endTag("cover");
                if (!Util.isNullOrNil(timeLineObject.ContentObj.LoY.vid)) {
                    aVar.startTag("nativepage");
                    aVar.setText(1);
                    aVar.endTag("nativepage");
                }
                aVar.startTag("width");
                aVar.setText(timeLineObject.ContentObj.LoY.videoWidth);
                aVar.endTag("width");
                aVar.startTag("height");
                aVar.setText(timeLineObject.ContentObj.LoY.videoHeight);
                aVar.endTag("height");
            }
            aVar.endTag("mmreadershare");
        }
        if (timeLineObject.ContentObj.dME != null) {
            e eVar = new e();
            eVar.jlg = timeLineObject.ContentObj.dME;
            aVar.append(l.b(eVar.jlg));
        }
        if (timeLineObject.ContentObj.jfy != null) {
            i iVar = new i();
            iVar.jlj = timeLineObject.ContentObj.jfy;
            aVar.append(ak.a(iVar.jlj));
        }
        if (timeLineObject.ContentObj.Lpd != null) {
            g gVar = new g();
            gVar.jlh = timeLineObject.ContentObj.Lpd;
            aVar.append(l.a(gVar.jlh));
        }
        if (timeLineObject.ContentObj.LoZ != null) {
            f fVar = new f();
            fVar.jld = timeLineObject.ContentObj.LoZ;
            aVar.append(l.b(fVar.jld));
        }
        if (timeLineObject.ContentObj.Lpe != null) {
            b bVar = new b();
            bVar.jld = timeLineObject.ContentObj.Lpe;
            aVar.append(bVar.bfF());
        }
        if (timeLineObject.ContentObj.Lpa != null) {
            h hVar = new h();
            hVar.jli = timeLineObject.ContentObj.Lpa;
            aVar.append(h.b(hVar.jli));
        }
        if (timeLineObject.ContentObj.Lpc != null) {
            d dVar = new d();
            dVar.a(timeLineObject.ContentObj.Lpc);
            aVar.append(dVar.bfF());
        }
        if (timeLineObject.ContentObj.Lpb != null) {
            c cVar = new c();
            cVar.jle = timeLineObject.ContentObj.Lpb;
            aVar.append(l.a(cVar.jle));
        }
        aVar.endTag("ContentObject");
        if (timeLineObject.actionInfo != null) {
            aVar.startTag("actionInfo");
            if (timeLineObject.actionInfo.KEw != null) {
                aVar.startTag("appMsg");
                aVar.startTag("mediaTagName");
                aVar.setText(timeLineObject.actionInfo.KEw.KEq);
                aVar.endTag("mediaTagName");
                aVar.startTag("messageExt");
                aVar.setText(timeLineObject.actionInfo.KEw.KEr);
                aVar.endTag("messageExt");
                aVar.startTag("messageAction");
                aVar.setText(timeLineObject.actionInfo.KEw.KEs);
                aVar.endTag("messageAction");
                aVar.endTag("appMsg");
            }
            aVar.endTag("actionInfo");
        }
        if (timeLineObject.AppInfo != null && !Util.isNullOrNil(timeLineObject.AppInfo.Id)) {
            String str = timeLineObject.statExtStr;
            eco eco = new eco();
            if (str != null) {
                try {
                    eco.parseFrom(Base64.decode(str, 0));
                } catch (Exception e2) {
                }
            }
            eco.NcJ = new ecm();
            eco.NcJ.xEN = timeLineObject.AppInfo.Id;
            try {
                str = Base64.encodeToString(eco.toByteArray(), 0).replace("\n", "");
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.TimelineConvert", e3, "", new Object[0]);
            }
            timeLineObject.statExtStr = str;
        }
        if (timeLineObject.statExtStr != null) {
            aVar.startTag("statExtStr");
            aVar.setText(timeLineObject.statExtStr);
            aVar.endTag("statExtStr");
        }
        if (timeLineObject.liteappInfo != null && !Util.isNullOrNil(timeLineObject.liteappInfo.appId)) {
            aVar.startTag("liteApp");
            aVar.startTag("appId");
            aVar.setText(filterNull(timeLineObject.liteappInfo.appId));
            aVar.endTag("appId");
            aVar.startTag("path");
            aVar.setText(filterNull(timeLineObject.liteappInfo.path));
            aVar.endTag("path");
            aVar.startTag(SearchIntents.EXTRA_QUERY);
            aVar.setText(filterNull(timeLineObject.liteappInfo.query));
            aVar.endTag(SearchIntents.EXTRA_QUERY);
            aVar.endTag("liteApp");
        }
        aVar.endTag("TimelineObject");
        String stringBuffer = aVar.sb.toString();
        Log.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(stringBuffer)));
        if (XmlParser.parseXml(stringBuffer, "TimelineObject", null) == null) {
            Log.e("MicroMsg.TimelineConvert", "xml is error");
            AppMethodBeat.o(96172);
            return "";
        }
        AppMethodBeat.o(96172);
        return stringBuffer;
    }
}
