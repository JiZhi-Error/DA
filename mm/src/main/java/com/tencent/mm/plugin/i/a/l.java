package com.tencent.mm.plugin.i.a;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.Map;

public final class l {
    public static String c(axf axf) {
        AppMethodBeat.i(196071);
        StringBuilder sb = new StringBuilder();
        if (axf != null) {
            try {
                if (!Util.isNullOrNil(axf.hJs)) {
                    sb.append("<finderLive><finderLiveID>").append(axf.hJs).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(axf.username)).append("</finderUsername><finderObjectID>").append(axf.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(axf.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(axf.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(axf.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(axf.headUrl)).append("</headUrl><extFlag>").append(XmlParser.getCDataWrapper(String.valueOf(axf.extFlag))).append("</extFlag><media><coverUrl>").append(XmlParser.getCDataWrapper(axf.coverUrl)).append("</coverUrl><height>").append(axf.height).append("</height><width>").append(axf.width).append("</width></media><liveStatus>").append(axf.liveStatus).append("</liveStatus>");
                    sb.append("</finderLive>");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196071);
        return sb2;
    }

    public static String d(axf axf) {
        AppMethodBeat.i(196072);
        StringBuilder sb = new StringBuilder();
        if (axf != null) {
            try {
                if (!Util.isNullOrNil(axf.hJs)) {
                    sb.append("<finderLiveInvite><finderLiveID>").append(axf.hJs).append("</finderLiveID><finderUsername>").append(Util.escapeStringForXml(axf.username)).append("</finderUsername><finderObjectID>").append(axf.feedId).append("</finderObjectID><nickname>").append(XmlParser.getCDataWrapper(axf.nickName)).append("</nickname><desc>").append(XmlParser.getCDataWrapper(axf.desc)).append("</desc><finderNonceID>").append(Util.escapeStringForXml(axf.objectNonceId)).append("</finderNonceID><headUrl>").append(XmlParser.getCDataWrapper(axf.headUrl)).append("</headUrl><coverUrl>").append(XmlParser.getCDataWrapper(axf.headUrl)).append("</coverUrl><liveMicId>").append(Util.escapeStringForXml(axf.hFO)).append("</liveMicId><liveMicSdkUserId>").append(Util.escapeStringForXml(axf.LHH)).append("</liveMicSdkUserId>");
                    sb.append("</finderLiveInvite>");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196072);
        return sb2;
    }

    public static axf v(String str, Map<String, String> map) {
        AppMethodBeat.i(196073);
        axf axf = new axf();
        try {
            String str2 = str + ".finderLive";
            if (!map.isEmpty() && map.containsKey(str2 + ".finderLiveID")) {
                axf.hJs = Util.nullAsNil(map.get(str2 + ".finderLiveID"));
                axf.username = Util.nullAsNil(map.get(str2 + ".finderUsername"));
                axf.feedId = Util.nullAsNil(map.get(str2 + ".finderObjectID"));
                axf.nickName = Util.nullAsNil(map.get(str2 + ".nickname"));
                axf.desc = Util.nullAsNil(map.get(str2 + ".desc"));
                axf.coverUrl = Util.nullAsNil(map.get(str2 + ".media.coverUrl")).replace("&amp;", "&");
                axf.height = Util.safeParseFloat(map.get(str2 + ".media.height"));
                axf.width = Util.safeParseFloat(map.get(str2 + ".media.width"));
                axf.headUrl = Util.nullAsNil(map.get(str2 + ".headUrl"));
                axf.objectNonceId = Util.nullAsNil(map.get(str2 + ".finderNonceID"));
                axf.liveStatus = Util.safeParseInt(map.get(str2 + ".liveStatus"));
                axf.extFlag = Util.safeParseInt(map.get(str2 + ".extFlag"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FinderShareParser", "parse error! %s", e2.getMessage());
        }
        AppMethodBeat.o(196073);
        return axf;
    }

    public static axf w(String str, Map<String, String> map) {
        AppMethodBeat.i(196074);
        axf axf = new axf();
        try {
            String str2 = str + ".finderLiveInvite";
            if (!map.isEmpty() && map.containsKey(str2 + ".finderLiveID")) {
                axf.hJs = Util.nullAsNil(map.get(str2 + ".finderLiveID"));
                axf.username = Util.nullAsNil(map.get(str2 + ".finderUsername"));
                axf.feedId = Util.nullAsNil(map.get(str2 + ".finderObjectID"));
                axf.nickName = Util.nullAsNil(map.get(str2 + ".nickname"));
                axf.desc = Util.nullAsNil(map.get(str2 + ".desc"));
                axf.coverUrl = Util.nullAsNil(map.get(str2 + ".coverUrl")).replace("&amp;", "&");
                axf.headUrl = Util.nullAsNil(map.get(str2 + ".headUrl"));
                axf.objectNonceId = Util.nullAsNil(map.get(str2 + ".finderNonceID"));
                axf.hFO = Util.nullAsNil(map.get(str2 + ".liveMicId"));
                axf.LHH = Util.nullAsNil(map.get(str2 + ".liveMicSdkUserId"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FinderShareParser", "parse error! %s", e2.getMessage());
        }
        AppMethodBeat.o(196074);
        return axf;
    }

    public static String b(bcj bcj) {
        AppMethodBeat.i(164040);
        StringBuilder sb = new StringBuilder();
        if (bcj != null) {
            try {
                if (!Util.isNullOrNil(bcj.objectId)) {
                    sb.append("<finderFeed><objectId>").append(bcj.objectId).append("</objectId><objectNonceId>").append(bcj.objectNonceId).append("</objectNonceId><feedType>").append(bcj.vXJ).append("</feedType><nickname>").append(Util.escapeStringForXml(bcj.nickname)).append("</nickname><username>").append(Util.escapeStringForXml(bcj.username)).append("</username><avatar>").append(XmlParser.getCDataWrapper(bcj.uNR)).append("</avatar><desc>").append(Util.escapeStringForXml(bcj.desc)).append("</desc><mediaCount>").append(bcj.dJl).append("</mediaCount><localId>").append(bcj.localId).append("</localId>");
                    sb.append("<mediaList>");
                    Iterator<bch> it = bcj.mediaList.iterator();
                    while (it.hasNext()) {
                        bch next = it.next();
                        sb.append("<media><mediaType>").append(next.mediaType).append("</mediaType><url>").append(XmlParser.getCDataWrapper(next.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(next.thumbUrl)).append("</thumbUrl><width>").append(next.width).append("</width><height>").append(next.height).append("</height><videoPlayDuration>").append(next.LLv).append("</videoPlayDuration></media>");
                    }
                    sb.append("</mediaList>");
                    sb.append("<megaVideo>");
                    sb.append("<objectId>").append(bcj.LLw).append("</objectId>");
                    sb.append("<objectNonceId>").append(bcj.LLx).append("</objectNonceId>");
                    sb.append("</megaVideo>");
                    sb.append("</finderFeed>");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(164040);
        return sb2;
    }

    public static String a(col col) {
        String cDataWrapper;
        AppMethodBeat.i(196075);
        StringBuilder sb = new StringBuilder();
        if (col != null) {
            try {
                if (!Util.isNullOrNil(col.objectId)) {
                    sb.append("<finderMegaVideo><objectId>").append(col.objectId).append("</objectId><objectNonceId>").append(col.objectNonceId).append("</objectNonceId><nickname>").append(Util.escapeStringForXml(col.nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(col.uNR)).append("</avatar><desc>").append(Util.escapeStringForXml(col.desc)).append("</desc><username>").append(Util.escapeStringForXml(col.username)).append("</username><mediaCount>").append(col.dJl).append("</mediaCount>");
                    sb.append("<mediaList>");
                    Iterator<cok> it = col.mediaList.iterator();
                    while (it.hasNext()) {
                        cok next = it.next();
                        if (!TextUtils.isEmpty(next.coverUrl)) {
                            cDataWrapper = XmlParser.getCDataWrapper(next.coverUrl);
                        } else {
                            cDataWrapper = XmlParser.getCDataWrapper(next.thumbUrl);
                        }
                        sb.append("<media><url>").append(XmlParser.getCDataWrapper(next.url)).append("</url><thumbUrl>").append(XmlParser.getCDataWrapper(next.thumbUrl)).append("</thumbUrl><width>").append(next.width).append("</width><height>").append(next.height).append("</height><coverUrl>").append(cDataWrapper).append("</coverUrl><videoPlayDuration>").append(next.LLv).append("</videoPlayDuration></media>");
                    }
                    sb.append("</mediaList>");
                    sb.append("<finderFeed>");
                    sb.append("<objectId>").append(col.MuF).append("</objectId>");
                    sb.append("<objectNonceId>").append(col.finderObjectNonceId).append("</objectNonceId>");
                    sb.append("</finderFeed>");
                    sb.append("</finderMegaVideo>");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196075);
        return sb2;
    }

    public static bcj x(String str, Map<String, String> map) {
        AppMethodBeat.i(164041);
        bcj bcj = new bcj();
        try {
            String str2 = str + ".finderFeed";
            if (!map.isEmpty() && map.containsKey(str2 + ".objectId")) {
                bcj.objectId = Util.nullAsNil(map.get(str2 + ".objectId"));
                bcj.objectNonceId = Util.nullAsNil(map.get(str2 + ".objectNonceId"));
                bcj.vXJ = Util.safeParseInt(map.get(str2 + ".feedType"));
                bcj.nickname = Util.nullAsNil(map.get(str2 + ".nickname"));
                bcj.username = Util.nullAsNil(map.get(str2 + ".username"));
                bcj.uNR = Util.nullAsNil(map.get(str2 + ".avatar"));
                bcj.desc = Util.nullAsNil(map.get(str2 + ".desc"));
                bcj.dJl = Util.safeParseInt(map.get(str2 + ".mediaCount"));
                bcj.localId = Util.safeParseLong(map.get(str2 + ".localId"));
                for (int i2 = 0; i2 < bcj.dJl; i2++) {
                    bch bch = new bch();
                    String str3 = str2 + ".mediaList.media";
                    if (i2 > 0) {
                        str3 = str3 + i2;
                    }
                    bch.mediaType = Util.safeParseInt(map.get(str3 + ".mediaType"));
                    bch.url = Util.nullAsNil(map.get(str3 + ".url"));
                    bch.thumbUrl = Util.nullAsNil(map.get(str3 + ".thumbUrl"));
                    bch.width = Util.safeParseFloat(map.get(str3 + ".width"));
                    bch.height = Util.safeParseFloat(map.get(str3 + ".height"));
                    bch.LLv = Util.safeParseInt(map.get(str3 + ".videoPlayDuration"));
                    bcj.mediaList.add(bch);
                }
                String str4 = str2 + ".megaVideo";
                bcj.LLw = Util.nullAsNil(map.get(str4 + ".objectId"));
                bcj.LLx = Util.nullAsNil(map.get(str4 + ".objectNonceId"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FinderShareParser", "parse error! %s", e2.getMessage());
        }
        AppMethodBeat.o(164041);
        return bcj;
    }

    public static col y(String str, Map<String, String> map) {
        AppMethodBeat.i(196076);
        col col = new col();
        try {
            String str2 = str + ".finderMegaVideo";
            if (!map.isEmpty() && map.containsKey(str2 + ".objectId")) {
                col.objectId = Util.nullAsNil(map.get(str2 + ".objectId"));
                col.objectNonceId = Util.nullAsNil(map.get(str2 + ".objectNonceId"));
                col.nickname = Util.nullAsNil(map.get(str2 + ".nickname"));
                col.username = Util.nullAsNil(map.get(str2 + ".username"));
                col.uNR = Util.nullAsNil(map.get(str2 + ".avatar"));
                col.desc = Util.nullAsNil(map.get(str2 + ".desc"));
                col.dJl = Util.safeParseInt(map.get(str2 + ".mediaCount"));
                for (int i2 = 0; i2 < col.dJl; i2++) {
                    cok cok = new cok();
                    String str3 = str2 + ".mediaList.media";
                    if (i2 > 0) {
                        str3 = str3 + i2;
                    }
                    cok.url = Util.nullAsNil(map.get(str3 + ".url"));
                    cok.thumbUrl = Util.nullAsNil(map.get(str3 + ".thumbUrl"));
                    cok.width = Util.safeParseFloat(map.get(str3 + ".width"));
                    cok.height = Util.safeParseFloat(map.get(str3 + ".height"));
                    cok.coverUrl = Util.nullAsNil(map.get(str3 + ".coverUrl"));
                    cok.LLv = Util.safeParseInt(map.get(str3 + ".videoPlayDuration"));
                    col.mediaList.add(cok);
                }
                String str4 = str2 + ".finderFeed";
                col.MuF = Util.nullAsNil(map.get(str4 + ".objectId"));
                col.finderObjectNonceId = Util.nullAsNil(map.get(str4 + ".objectNonceId"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FinderShareParser", "parse error! %s", e2.getMessage());
        }
        AppMethodBeat.o(196076);
        return col;
    }

    public static String b(bcl bcl) {
        AppMethodBeat.i(164042);
        StringBuilder sb = new StringBuilder();
        if (bcl != null && !Util.isNullOrNil(bcl.dST)) {
            sb.append("<finderTopic><topic>").append(Util.escapeStringForXml(bcl.dST)).append("</topic><topicType>").append(bcl.tvC).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(bcl.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(bcl.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(bcl.LLC)).append("</patMusicId>");
            if (bcl.LLB != null) {
                sb.append("<location><poiClassifyId>").append(Util.escapeStringForXml(bcl.LLB.LIb)).append("</poiClassifyId><longitude>").append(bcl.LLB.dTj).append("</longitude><latitude>").append(bcl.LLB.latitude).append("</latitude></location>");
            }
            if (bcl.LLD != null) {
                sb.append("<event><topicId>").append(bcl.LLD.LAp).append("</topicId><name>").append(Util.escapeStringForXml(bcl.LLD.LAq)).append("</name><creatorNickName>").append(Util.escapeStringForXml(bcl.LLD.LAr)).append("</creatorNickName></event>");
            }
            sb.append("</finderTopic>");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(164042);
        return sb2;
    }

    public static bcl z(String str, Map<String, String> map) {
        AppMethodBeat.i(164043);
        bcl bcl = new bcl();
        String str2 = str + ".finderTopic";
        if (!map.isEmpty()) {
            bcl.dST = Util.nullAsNil(map.get(str2 + ".topic"));
            bcl.tvC = Util.getInt(map.get(str2 + ".topicType"), -1);
            bcl.iconUrl = Util.nullAsNil(map.get(str2 + ".iconUrl"));
            bcl.desc = Util.nullAsNil(map.get(str2 + ".desc"));
            bcl.LLC = Util.nullAsNil(map.get(str2 + ".patMusicId"));
            bcg bcg = new bcg();
            bcg.LIb = map.get(str2 + ".location.poiClassifyId");
            bcg.dTj = Util.getFloat(map.get(str2 + ".location.longitude"), 0.0f);
            bcg.latitude = Util.getFloat(map.get(str2 + ".location.latitude"), 0.0f);
            bcl.LLB = bcg;
            if (map.get(str2 + ".event.topicId") != null) {
                aoi aoi = new aoi();
                aoi.LAp = Util.nullAsNil(map.get(str2 + ".event.topicId"));
                aoi.LAq = Util.nullAsNil(map.get(str2 + ".event.name"));
                aoi.LAr = Util.nullAsNil(map.get(str2 + ".event.creatorNickName"));
                bcl.LLD = aoi;
            }
        } else {
            bcl.dST = "";
            bcl.tvC = -1;
            bcl.iconUrl = "";
            bcl.desc = "";
            bcl.LLB = new bcg();
        }
        AppMethodBeat.o(164043);
        return bcl;
    }

    public static String a(bcf bcf) {
        AppMethodBeat.i(196077);
        StringBuilder sb = new StringBuilder();
        if (bcf != null) {
            try {
                if (!Util.isNullOrNil(bcf.cardId)) {
                    sb.append("<finderColumn><cardId>").append(Util.escapeStringForXml(bcf.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(bcf.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(bcf.oqZ)).append("</secondTitle>");
                    for (int i2 = 0; i2 < bcf.LLt.size(); i2++) {
                        String str = bcf.LLt.get(i2) + bcf.LLu.get(i2);
                        if (i2 == 0) {
                            sb.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
                        } else if (i2 == 1) {
                            sb.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
                        } else if (i2 == 2) {
                            sb.append("<iconUrl_2>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_2>");
                        } else if (i2 == 3) {
                            sb.append("<iconUrl_3>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_3>");
                        }
                    }
                    if (bcf.tVe != null) {
                        sb.append("<cardbuffer>").append(XmlParser.getCDataWrapper(new String(Base64.encode(bcf.tVe.toByteArray(), 0)))).append("</cardbuffer>");
                    }
                    sb.append("</finderColumn>");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196077);
        return sb2;
    }

    public static bcf A(String str, Map<String, String> map) {
        AppMethodBeat.i(196078);
        bcf bcf = new bcf();
        String str2 = str + ".finderColumn";
        if (!map.isEmpty()) {
            bcf.tVe = new b(Base64.decode(Util.nullAsNil(map.get(str2 + ".cardbuffer")), 0));
            String nullAsNil = Util.nullAsNil(map.get(str2 + ".iconUrl"));
            String nullAsNil2 = Util.nullAsNil(map.get(str2 + ".iconUrl_1"));
            String nullAsNil3 = Util.nullAsNil(map.get(str2 + ".iconUrl_2"));
            String nullAsNil4 = Util.nullAsNil(map.get(str2 + ".iconUrl_3"));
            String[] split = nullAsNil.split("&token");
            bcf.LLt.add(split[0]);
            bcf.LLu.add(split.length > 1 ? "&token" + split[1] : "");
            String[] split2 = nullAsNil2.split("&token");
            bcf.LLt.add(split2[0]);
            bcf.LLu.add(split2.length > 1 ? "&token" + split2[1] : "");
            String[] split3 = nullAsNil3.split("&token");
            bcf.LLt.add(split3[0]);
            bcf.LLu.add(split3.length > 1 ? "&token" + split3[1] : "");
            String[] split4 = nullAsNil4.split("&token");
            bcf.LLt.add(split4[0]);
            bcf.LLu.add(split4.length > 1 ? "&token" + split4[1] : "");
            bcf.cardId = Util.nullAsNil(map.get(str2 + ".cardId"));
            bcf.title = Util.nullAsNil(map.get(str2 + ".title"));
            bcf.oqZ = Util.nullAsNil(map.get(str2 + ".secondTitle"));
        } else {
            bcf.cardId = "";
            bcf.title = "";
            bcf.oqZ = "";
            bcf.tVe = null;
        }
        AppMethodBeat.o(196078);
        return bcf;
    }

    public static String b(bcf bcf) {
        AppMethodBeat.i(196079);
        StringBuilder sb = new StringBuilder();
        if (bcf != null) {
            try {
                sb.append("<finderContentColumnSharedItem><cardId>").append(Util.escapeStringForXml(bcf.cardId)).append("</cardId><title>").append(Util.escapeStringForXml(bcf.title)).append("</title><secondTitle>").append(Util.escapeStringForXml(bcf.oqZ)).append("</secondTitle>");
                for (int i2 = 0; i2 < bcf.LLt.size(); i2++) {
                    String str = bcf.LLt.get(i2) + bcf.LLu.get(i2);
                    if (i2 == 0) {
                        sb.append("<iconUrl>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl>");
                    } else if (i2 == 1) {
                        sb.append("<iconUrl_1>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_1>");
                    } else if (i2 == 2) {
                        sb.append("<iconUrl_2>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_2>");
                    } else if (i2 == 3) {
                        sb.append("<iconUrl_3>").append(XmlParser.getCDataWrapper(str)).append("</iconUrl_3>");
                    }
                }
                if (bcf.tVe != null) {
                    sb.append("<cardbuffer>").append(XmlParser.getCDataWrapper(new String(Base64.encode(bcf.tVe.toByteArray(), 0)))).append("</cardbuffer>");
                }
                sb.append("</finderContentColumnSharedItem>");
            } catch (Exception e2) {
                Log.e("MicroMsg.FinderShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196079);
        return sb2;
    }

    public static String a(bck bck) {
        AppMethodBeat.i(196080);
        StringBuilder sb = new StringBuilder();
        if (bck != null) {
            sb.append("<finderpoirelatedstream><longitudeString>").append(Util.escapeStringForXml(bck.LLz)).append("</longitudeString><latitudeString>").append(Util.escapeStringForXml(bck.LLy)).append("</latitudeString><poiName>").append(Util.escapeStringForXml(bck.kHV)).append("</poiName><poiScaleString>").append(Util.escapeStringForXml(bck.LLA)).append("</poiScaleString><address>").append(Util.escapeStringForXml(bck.iUO)).append("</address><infoUrl>").append(XmlParser.getCDataWrapper(bck.JTr)).append("</infoUrl><poiClassifyId>").append(Util.escapeStringForXml(bck.LIb)).append("</poiClassifyId><poiCategories>").append(Util.escapeStringForXml(bck.tPa)).append("</poiCategories>");
            sb.append("</finderpoirelatedstream>");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196080);
        return sb2;
    }

    public static bck B(String str, Map<String, String> map) {
        AppMethodBeat.i(196081);
        bck bck = new bck();
        String str2 = str + ".finderpoirelatedstream";
        if (!map.isEmpty()) {
            bck.LLz = Util.nullAsNil(map.get(str2 + ".longitudeString"));
            bck.LLy = Util.nullAsNil(map.get(str2 + ".latitudeString"));
            bck.kHV = Util.nullAsNil(map.get(str2 + ".poiName"));
            bck.LLA = Util.nullAsNil(map.get(str2 + ".poiScaleString"));
            bck.iUO = Util.nullAsNil(map.get(str2 + ".address"));
            bck.JTr = Util.nullAsNil(map.get(str2 + ".infoUrl"));
            bck.LIb = Util.nullAsNil(map.get(str2 + ".poiClassifyId"));
            bck.tPa = Util.nullAsNil(map.get(str2 + ".poiCategories"));
        } else {
            bck.LLz = "";
            bck.LLy = "";
            bck.kHV = "";
            bck.LLA = "";
            bck.iUO = "";
            bck.JTr = "";
            bck.LIb = "";
            bck.tPa = "";
        }
        AppMethodBeat.o(196081);
        return bck;
    }

    public static String bf(int i2, String str) {
        AppMethodBeat.i(196082);
        StringBuilder sb = new StringBuilder();
        sb.append("<finder><type>").append(i2).append("</type><detail>").append(str).append("</detail>");
        sb.append("</finder>");
        String sb2 = sb.toString();
        AppMethodBeat.o(196082);
        return sb2;
    }

    public static String dJA() {
        return ".msg.appmsg.finder.detail";
    }

    public static int d(Map<String, String> map, int i2) {
        AppMethodBeat.i(196083);
        if (map != null) {
            i2 = Util.getInt(map.get(".msg.appmsg.finder.type"), -1);
        }
        AppMethodBeat.o(196083);
        return i2;
    }
}
