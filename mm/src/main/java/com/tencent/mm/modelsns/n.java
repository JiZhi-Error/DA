package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.Map;

public final class n {
    private static float PK(String str) {
        AppMethodBeat.i(94861);
        if (str == null) {
            AppMethodBeat.o(94861);
            return 0.0f;
        }
        float f2 = Util.getFloat(str, 0.0f);
        AppMethodBeat.o(94861);
        return f2;
    }

    private static String PL(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static TimeLineObject bfM() {
        AppMethodBeat.i(94862);
        TimeLineObject timeLineObject = new TimeLineObject();
        adp adp = new adp();
        timeLineObject.AppInfo = new fa();
        timeLineObject.ContentObj = adp;
        timeLineObject.Privated = 0;
        timeLineObject.CreateTime = 0;
        timeLineObject.Id = "";
        cjy cjy = new cjy();
        cjy.LbD = 0.0f;
        cjy.LbC = 0.0f;
        timeLineObject.Location = cjy;
        timeLineObject.canvasInfo = "";
        timeLineObject.weappInfo = new eyd();
        AppMethodBeat.o(94862);
        return timeLineObject;
    }

    public static cnb bfN() {
        AppMethodBeat.i(94863);
        cnb cnb = new cnb();
        cnb.Desc = "";
        cnb.Privated = 0;
        AppMethodBeat.o(94863);
        return cnb;
    }

    public static cnb a(String str, int i2, String str2, String str3, int i3, int i4, String str4) {
        AppMethodBeat.i(94864);
        cnb cnb = new cnb();
        cnb.Id = str;
        cnb.oUv = i2;
        cnb.Url = str2;
        cnb.Msz = str3;
        cnb.Mcw = i3;
        cnb.MsA = i4;
        cnb.Desc = str4;
        cnd cnd = new cnd();
        cnd.Mtp = 0.0f;
        cnd.Mto = 0.0f;
        cnd.Mtq = 0.0f;
        cnb.MsB = cnd;
        cnb.MsM = g.getMessageDigest(str2 == null ? "".getBytes() : str2.getBytes());
        AppMethodBeat.o(94864);
        return cnb;
    }

    public static cnb a(String str, int i2, String str2, String str3, int i3, int i4, int i5, String str4, cnd cnd) {
        AppMethodBeat.i(94865);
        cnb cnb = new cnb();
        cnb.Id = PL(str);
        cnb.oUv = i2;
        cnb.Desc = PL(str4);
        cnb.Url = PL(str2);
        cnb.Mcw = i3;
        cnb.Msz = PL(str3);
        cnb.MsA = i4;
        cnb.Privated = i5;
        cnb.MsB = cnd;
        cnb.MsM = g.getMessageDigest(str2 == null ? "".getBytes() : str2.getBytes());
        AppMethodBeat.o(94865);
        return cnb;
    }

    public static TimeLineObject PM(String str) {
        TimeLineObject timeLineObject;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        bcj bcj;
        css css;
        col col;
        bcl bcl;
        bcf bcf;
        jo joVar;
        axf axf;
        bcl bcl2;
        cio cio;
        byte[] bytes;
        AppMethodBeat.i(94866);
        Map<String, String> parseXml = XmlParser.parseXml(str, "TimelineObject", null);
        TimeLineObject bfM = bfM();
        if (parseXml != null) {
            bfM.Id = PL(parseXml.get(".TimelineObject.id"));
            bfM.UserName = PL(parseXml.get(".TimelineObject.username"));
            bfM.Privated = Util.getInt(parseXml.get(".TimelineObject.private"), 0);
            bfM.CreateTime = Util.getInt(parseXml.get(".TimelineObject.createTime"), 0);
            bfM.ContentDesc = PL(parseXml.get(".TimelineObject.contentDesc"));
            bfM.contentDescShowType = Util.getInt(parseXml.get(".TimelineObject.contentDescShowType"), 0);
            bfM.contentDescScene = Util.getInt(parseXml.get(".TimelineObject.contentDescScene"), 0);
            bfM.statExtStr = PL(parseXml.get(".TimelineObject.statExtStr"));
            bfM.sightFolded = Util.getInt(parseXml.get(".TimelineObject.sightFolded"), 0);
            bfM.showFlag = Util.getInt(parseXml.get(".TimelineObject.showFlag"), 0);
            cjy cjy = new cjy();
            cjy.LbC = PK(parseXml.get(".TimelineObject.location.$longitude"));
            cjy.LbD = PK(parseXml.get(".TimelineObject.location.$latitude"));
            cjy.kea = PL(parseXml.get(".TimelineObject.location.$city"));
            cjy.Mpu = Util.getInt(parseXml.get(".TimelineObject.location.$poiScale"), 0);
            cjy.LIb = PL(parseXml.get(".TimelineObject.location.$poiClassifyId"));
            cjy.Esb = Util.getInt(parseXml.get(".TimelineObject.location.$poiClassifyType"), 0);
            cjy.ErZ = PL(parseXml.get(".TimelineObject.location.$poiAddress"));
            cjy.kHV = PL(parseXml.get(".TimelineObject.location.$poiName"));
            cjy.Mpv = Util.getInt(parseXml.get(".TimelineObject.location.$poiClickableStatus"), 0);
            cjy.Mpx = PL(parseXml.get(".TimelineObject.location.$poiAddressName"));
            cjy.country = PL(parseXml.get(".TimelineObject.location.$country"));
            bfM.Location = cjy;
            if (bfM.ContentObj == null) {
                bfM.ContentObj = new adp();
            }
            bfM.ContentObj.Desc = PL(parseXml.get(".TimelineObject.ContentObject.description"));
            bfM.ContentObj.LoU = Util.getInt(parseXml.get(".TimelineObject.ContentObject.contentStyle"), 0);
            bfM.ContentObj.LoW = Util.getInt(parseXml.get(".TimelineObject.ContentObject.contentSubStyle"), 0);
            bfM.ContentObj.Title = PL(parseXml.get(".TimelineObject.ContentObject.title"));
            bfM.ContentObj.Url = PL(parseXml.get(".TimelineObject.ContentObject.contentUrl"));
            if (parseXml.containsKey(".TimelineObject.ContentObject.mmreadershare.itemshowtype")) {
                int i2 = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.itemshowtype"), 0);
                if (i2 != -1) {
                    bfM.ContentObj.LoY = new cli();
                    bfM.ContentObj.LoY.iAb = i2;
                    bfM.ContentObj.LoY.iwf = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.ispaysubscribe"), 0);
                }
                if (i2 == 5) {
                    bfM.ContentObj.LoY.iwd = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.pubtime"), 0);
                    bfM.ContentObj.LoY.vid = PL(parseXml.get(".TimelineObject.ContentObject.mmreadershare.vid"));
                    bfM.ContentObj.LoY.coverUrl = PL(parseXml.get(".TimelineObject.ContentObject.mmreadershare.cover"));
                    bfM.ContentObj.LoY.iwg = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.funcflag"), 0);
                    bfM.ContentObj.LoY.duration = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.duration"), 0);
                    bfM.ContentObj.LoY.desc = PL(parseXml.get(".TimelineObject.ContentObject.mmreadershare.digest"));
                    bfM.ContentObj.LoY.iwe = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.nativepage"), 0);
                    bfM.ContentObj.LoY.videoWidth = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.width"), 0);
                    bfM.ContentObj.LoY.videoHeight = Util.getInt(parseXml.get(".TimelineObject.ContentObject.mmreadershare.height"), 0);
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 != 0) {
                    str2 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".id";
                    str3 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".type";
                    str4 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".title";
                    str5 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".description";
                    str6 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url";
                    str7 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$videomd5";
                    str8 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".thumb";
                    str9 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$type";
                    str10 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".thumb.$type";
                    str11 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".private";
                    str12 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".subType";
                    str13 = ".TimelineObject.ContentObject.mediaList.media".concat(String.valueOf(i3));
                    str14 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".lowBandUrl";
                    str15 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".lowBandUrl.$type";
                    str16 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".songalbumurl";
                    str17 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".songlyric";
                    str18 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".thumb.$key";
                    str19 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".thumb.$enc_idx";
                    str20 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".thumb.$token";
                    str21 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$key";
                    str22 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$enc_idx";
                    str23 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$token";
                    str24 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".enc.$key";
                    str25 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".enc";
                    str26 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".attachShareTitle";
                    str27 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".attachThumbUrl";
                    str28 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".videosize.$attachTotalTime";
                    str29 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".url.$md5";
                    str30 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".attachUrl.$md5";
                    str31 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".attachUrl";
                    str32 = ".TimelineObject.ContentObject.mediaList.media" + i3 + ".userData";
                } else {
                    str2 = ".TimelineObject.ContentObject.mediaList.media.id";
                    str3 = ".TimelineObject.ContentObject.mediaList.media.type";
                    str4 = ".TimelineObject.ContentObject.mediaList.media.title";
                    str5 = ".TimelineObject.ContentObject.mediaList.media.description";
                    str6 = ".TimelineObject.ContentObject.mediaList.media.url";
                    str7 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                    str8 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                    str9 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                    str10 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                    str11 = ".TimelineObject.ContentObject.mediaList.media.private";
                    str12 = ".TimelineObject.ContentObject.mediaList.media.subType";
                    str13 = ".TimelineObject.ContentObject.mediaList.media";
                    str14 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                    str15 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                    str16 = ".TimelineObject.ContentObject.mediaList.media.songalbumurl";
                    str17 = ".TimelineObject.ContentObject.mediaList.media.songlyric";
                    str18 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                    str19 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                    str20 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                    str21 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                    str22 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                    str23 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                    str24 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                    str25 = ".TimelineObject.ContentObject.mediaList.media.enc";
                    str26 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                    str27 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                    str28 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                    str29 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                    str30 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                    str31 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                    str32 = ".TimelineObject.ContentObject.mediaList.media.userData";
                }
                String str33 = parseXml.get(str13 + ".size.$width");
                String str34 = parseXml.get(str13 + ".size.$height");
                String str35 = parseXml.get(str13 + ".size.$totalSize");
                cnd cnd = new cnd();
                cnd.Mtp = 0.0f;
                cnd.Mto = 0.0f;
                cnd.Mtq = 0.0f;
                if (str33 != null) {
                    cnd.Mto = PK(str33);
                }
                if (str34 != null) {
                    cnd.Mtp = PK(str34);
                }
                if (str35 != null) {
                    cnd.Mtq = PK(str35);
                }
                String str36 = parseXml.get(str2);
                String str37 = parseXml.get(str3);
                String str38 = parseXml.get(str4);
                String str39 = parseXml.get(str5);
                String str40 = parseXml.get(str6);
                String str41 = parseXml.get(".TimelineObject.ContentObject.mediaList.media.videoDuration");
                String str42 = parseXml.get(str11);
                String str43 = parseXml.get(str8);
                String str44 = parseXml.get(str7);
                String str45 = parseXml.get(str9);
                String str46 = parseXml.get(str10);
                String str47 = parseXml.get(str14);
                String str48 = parseXml.get(str15);
                String str49 = parseXml.get(str16);
                String str50 = parseXml.get(str17);
                String str51 = parseXml.get(str12);
                String str52 = parseXml.get(str32);
                String str53 = parseXml.get(str31);
                String str54 = parseXml.get(str30);
                String str55 = parseXml.get(str29);
                String str56 = parseXml.get(str28);
                String str57 = parseXml.get(str27);
                String str58 = parseXml.get(str26);
                String str59 = parseXml.get(str25);
                String str60 = parseXml.get(str24);
                String str61 = parseXml.get(str23);
                String str62 = parseXml.get(str22);
                String str63 = parseXml.get(str21);
                String str64 = parseXml.get(str20);
                String str65 = parseXml.get(str19);
                String str66 = parseXml.get(str18);
                if (str37 == null || Util.isNullOrNil(str36)) {
                    int indexOf = str.indexOf("<noteinfo>");
                    int indexOf2 = str.indexOf("</noteinfo>");
                } else {
                    cnb cnb = new cnb();
                    cnb.Id = PL(str36);
                    cnb.oUv = Util.getInt(str37, 0);
                    cnb.Title = PL(str38);
                    cnb.Desc = PL(str39);
                    cnb.Url = PL(str40);
                    cnb.Mcw = Util.getInt(str45, 0);
                    cnb.Msz = PL(str43);
                    cnb.MsA = Util.getInt(str46, 0);
                    cnb.Privated = Util.getInt(str42, 0);
                    cnb.MsB = cnd;
                    cnb.MsC = PL(str47);
                    cnb.MsD = Util.getInt(str48, 0);
                    cnb.songAlbumUrl = str49;
                    cnb.songLyric = str50;
                    cnb.EpK = PL(str52);
                    cnb.subType = Util.getInt(str51, 0);
                    cnb.MsF = PL(str53);
                    cnb.MsH = PL(str54);
                    cnb.MsG = PL(str55);
                    cnb.MsS = PL(str44);
                    cnb.ERX = Util.getInt(str56, 0);
                    cnb.MsI = PL(str57);
                    cnb.MsJ = PL(str58);
                    cnb.MsK = Util.getInt(str59, 0);
                    cnb.MsL = Util.getLong(str60, 0);
                    if (cnb.Url == null) {
                        bytes = "".getBytes();
                    } else {
                        bytes = cnb.Url.getBytes();
                    }
                    cnb.MsM = g.getMessageDigest(bytes);
                    cnb.viB = str61;
                    cnb.MsN = Util.getInt(str62, 0);
                    cnb.MsO = str63;
                    cnb.MsP = str64;
                    cnb.MsQ = Util.getInt(str65, 0);
                    cnb.MsR = str66;
                    cnb.MsT = PK(str41);
                    bfM.ContentObj.LoV.add(cnb);
                    i3++;
                }
            }
            int indexOf3 = str.indexOf("<noteinfo>");
            int indexOf22 = str.indexOf("</noteinfo>");
            if (indexOf3 < 0 || indexOf22 < 0) {
                timeLineObject = bfM;
            } else {
                bfM.ContentObj.LoX = str.substring(indexOf3, indexOf22 + 11);
                timeLineObject = bfM;
            }
            adp adp = timeLineObject.ContentObj;
            e eVar = new e();
            int indexOf4 = str.indexOf("<finderFeed>");
            int indexOf5 = str.indexOf("</finderFeed>");
            if (indexOf4 < 0 || indexOf5 < 0) {
                bcj = null;
            } else {
                Map<String, String> parseXml2 = XmlParser.parseXml(str.substring(indexOf4, indexOf5 + 13), "finderFeed", null);
                if (parseXml2 != null) {
                    eVar.j("", parseXml2);
                }
                bcj = eVar.jlg;
            }
            adp.dME = bcj;
            adp adp2 = timeLineObject.ContentObj;
            i iVar = new i();
            int indexOf6 = str.indexOf("<musicShareItem>");
            int indexOf7 = str.indexOf("</musicShareItem>");
            if (indexOf6 < 0 || indexOf7 < 0) {
                css = null;
            } else {
                Map<String, String> parseXml3 = XmlParser.parseXml(str.substring(indexOf6, indexOf7 + 17), "musicShareItem", null);
                if (parseXml3 != null) {
                    iVar.j("", parseXml3);
                }
                css = iVar.jlj;
            }
            adp2.jfy = css;
            adp adp3 = timeLineObject.ContentObj;
            g gVar = new g();
            int indexOf8 = str.indexOf("<finderMegaVideo>");
            int indexOf9 = str.indexOf("</finderMegaVideo>");
            if (indexOf8 < 0 || indexOf9 < 0) {
                col = null;
            } else {
                Map<String, String> parseXml4 = XmlParser.parseXml(str.substring(indexOf8, indexOf9 + 18), "finderMegaVideo", null);
                if (parseXml4 != null) {
                    gVar.j("", parseXml4);
                }
                col = gVar.jlh;
            }
            adp3.Lpd = col;
            adp adp4 = timeLineObject.ContentObj;
            f fVar = new f();
            int indexOf10 = str.indexOf("<finderTopic>");
            int indexOf11 = str.indexOf("</finderTopic>");
            if (indexOf10 < 0 || indexOf11 < 0) {
                bcl = null;
            } else {
                Map<String, String> parseXml5 = XmlParser.parseXml(str.substring(indexOf10, indexOf11 + 14), "finderTopic", null);
                if (parseXml5 != null) {
                    fVar.j("", parseXml5);
                }
                bcl = fVar.jld;
            }
            adp4.LoZ = bcl;
            adp adp5 = timeLineObject.ContentObj;
            c cVar = new c();
            int indexOf12 = str.indexOf("<finderColumn>");
            int indexOf13 = str.indexOf("</finderColumn>");
            if (indexOf12 < 0 || indexOf13 < 0) {
                bcf = null;
            } else {
                Map<String, String> parseXml6 = XmlParser.parseXml(str.substring(indexOf12, indexOf13 + 15), "finderColumn", null);
                if (parseXml6 != null) {
                    cVar.j("", parseXml6);
                }
                bcf = cVar.jle;
            }
            adp5.Lpb = bcf;
            adp adp6 = timeLineObject.ContentObj;
            h hVar = new h();
            int indexOf14 = str.indexOf("<mmbrandmpvideo>");
            int indexOf15 = str.indexOf("</mmbrandmpvideo>");
            if (indexOf14 < 0 || indexOf15 < 0) {
                joVar = null;
            } else {
                Map<String, String> parseXml7 = XmlParser.parseXml(str.substring(indexOf14, indexOf15 + 17), "mmbrandmpvideo", null);
                if (parseXml7 != null) {
                    hVar.jli = h.k("", parseXml7);
                }
                joVar = hVar.jli;
            }
            adp6.Lpa = joVar;
            adp adp7 = timeLineObject.ContentObj;
            d dVar = new d();
            int indexOf16 = str.indexOf("<finderLive>");
            int indexOf17 = str.indexOf("</finderLive>");
            if (indexOf16 < 0 || indexOf17 < 0) {
                axf = null;
            } else {
                Map<String, String> parseXml8 = XmlParser.parseXml(str.substring(indexOf16, indexOf17 + 13), "finderLive", null);
                if (parseXml8 != null) {
                    dVar.j("", parseXml8);
                }
                axf = dVar.jlf;
            }
            adp7.Lpc = axf;
            adp adp8 = timeLineObject.ContentObj;
            int indexOf18 = str.indexOf("<finder>");
            int indexOf19 = str.indexOf("</finder>");
            int i4 = 0;
            if (indexOf18 < 0 || indexOf19 < 0) {
                i4 = 0;
            } else {
                Map<String, String> parseXml9 = XmlParser.parseXml(str.substring(indexOf18, indexOf19 + 9), "finder", null);
                if (parseXml9 != null) {
                    i4 = Util.safeParseInt(parseXml9.get(".finder.type"));
                }
            }
            adp8.izD = i4;
            adp adp9 = timeLineObject.ContentObj;
            f fVar2 = new f();
            int indexOf20 = str.indexOf("<finder>");
            int indexOf21 = str.indexOf("</finder>");
            if (indexOf20 < 0 || indexOf21 < 0) {
                bcl2 = null;
            } else {
                String substring = str.substring(indexOf20, indexOf21 + 9);
                int indexOf23 = substring.indexOf("<finderTopic>");
                int indexOf24 = substring.indexOf("</finderTopic>");
                if (indexOf23 < 0 || indexOf24 < 0) {
                    bcl2 = null;
                } else {
                    Map<String, String> parseXml10 = XmlParser.parseXml(substring.substring(indexOf23, indexOf24 + 14), "finderTopic", null);
                    if (parseXml10 != null) {
                        fVar2.j("", parseXml10);
                    }
                    bcl2 = fVar2.jld;
                }
            }
            adp9.Lpe = bcl2;
            fa faVar = new fa();
            String PL = PL(parseXml.get(".TimelineObject.appInfo.id"));
            String PL2 = PL(parseXml.get(".TimelineObject.appInfo.version"));
            String PL3 = PL(parseXml.get(".TimelineObject.appInfo.appName"));
            String PL4 = PL(parseXml.get(".TimelineObject.appInfo.installUrl "));
            String PL5 = PL(parseXml.get(".TimelineObject.appInfo.fromUrl "));
            faVar.Id = PL;
            faVar.xMq = PL3;
            faVar.KIq = PL4;
            faVar.KIr = PL5;
            faVar.Version = PL2;
            faVar.KIs = Util.getInt(parseXml.get(".TimelineObject.appInfo.clickable"), 0);
            timeLineObject.AppInfo = faVar;
            eyd eyd = new eyd();
            String PL6 = PL(parseXml.get(".TimelineObject.weappInfo.appUserName"));
            String PL7 = PL(parseXml.get(".TimelineObject.weappInfo.pagePath"));
            String PL8 = PL(parseXml.get(".TimelineObject.weappInfo.version"));
            String PL9 = PL(parseXml.get(".TimelineObject.weappInfo.debugMode"));
            String PL10 = PL(parseXml.get(".TimelineObject.weappInfo.shareActionId"));
            String PL11 = PL(parseXml.get(".TimelineObject.weappInfo.isGame"));
            String PL12 = PL(parseXml.get(".TimelineObject.weappInfo.messageExtraData"));
            String PL13 = PL(parseXml.get(".TimelineObject.weappInfo.subType"));
            String PL14 = PL(parseXml.get(".TimelineObject.weappInfo.preloadResources"));
            eyd.username = PL6;
            eyd.path = PL7;
            eyd.version = Util.getInt(PL8, 0);
            eyd.nbf = Util.getInt(PL9, 0);
            eyd.dCC = PL10;
            eyd.isGame = Util.getInt(PL11, 0);
            eyd.eda = PL12;
            eyd.subType = Util.getInt(PL13, 0);
            eyd.Nvm = PL14;
            timeLineObject.weappInfo = eyd;
            String PL15 = PL(parseXml.get(".TimelineObject.liteApp.appId"));
            if (PL15.isEmpty()) {
                cio = null;
            } else {
                cio cio2 = new cio();
                cio2.appId = PL15;
                cio2.path = PL(parseXml.get(".TimelineObject.liteApp.path"));
                cio2.query = PL(parseXml.get(".TimelineObject.liteApp.query"));
                cio = cio2;
            }
            timeLineObject.liteappInfo = cio;
            eep eep = new eep();
            String PL16 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideotitle"));
            String PL17 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideototaltime"));
            String PL18 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideourl"));
            String PL19 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideoweburl"));
            String PL20 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideowording"));
            String PL21 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideothumburl"));
            String PL22 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
            String PL23 = PL(parseXml.get(".TimelineObject.streamvideo.streamvideopublishid"));
            eep.izb = PL16;
            eep.iza = Util.safeParseInt(PL17);
            eep.iyZ = PL18;
            eep.izd = PL19;
            eep.izc = PL20;
            eep.ize = PL21;
            eep.izf = PL22;
            eep.izg = PL23;
            timeLineObject.streamvideo = eep;
            dzy dzy = new dzy();
            String PL24 = PL(parseXml.get(".TimelineObject.redEnvelopesInfo.sendId"));
            String PL25 = PL(parseXml.get(".TimelineObject.redEnvelopesInfo.ticket"));
            dzy.yQE = PL24;
            dzy.dHx = PL25;
            be beVar = new be();
            int i5 = Util.getInt(parseXml.get(".TimelineObject.actionInfo.scene"), 0);
            String PL26 = PL(parseXml.get(".TimelineObject.actionInfo.appid"));
            int i6 = Util.getInt(parseXml.get(".TimelineObject.actionInfo.type"), 0);
            String PL27 = PL(parseXml.get(".TimelineObject.actionInfo.url"));
            String PL28 = PL(parseXml.get(".TimelineObject.actionInfo.mediaTagName"));
            String PL29 = PL(parseXml.get(".TimelineObject.actionInfo.wordingKey"));
            beVar.KEt = PL26;
            beVar.Scene = i5;
            beVar.oUv = i6;
            beVar.Url = PL27;
            beVar.KEu = PL28;
            beVar.KEv = PL29;
            bc bcVar = new bc();
            String PL30 = PL(parseXml.get(".TimelineObject.actionInfo.appMsg.appid"));
            String PL31 = PL(parseXml.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
            String PL32 = PL(parseXml.get(".TimelineObject.actionInfo.appMsg.messageExt"));
            String PL33 = PL(parseXml.get(".TimelineObject.actionInfo.appMsg.messageAction"));
            bcVar.jfi = PL30;
            bcVar.KEq = PL31;
            bcVar.KEr = PL32;
            bcVar.KEs = PL33;
            beVar.KEw = bcVar;
            int i7 = Util.getInt(parseXml.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
            int i8 = Util.getInt(parseXml.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
            String PL34 = PL(parseXml.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
            String PL35 = PL(parseXml.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
            beVar.KEx = PL(parseXml.get(".TimelineObject.actionInfo.newWordingKey"));
            ek ekVar = new ek();
            ekVar.KIc = i7;
            ekVar.KIe = i8;
            fc fcVar = new fc();
            fcVar.KIw = PL34;
            fcVar.KIx = PL35;
            beVar.KEy = ekVar;
            beVar.KEz = fcVar;
            beVar.KEA = PN(parseXml.get(".TimelineObject.actionInfo.installedWording"));
            beVar.KEB = PN(parseXml.get(".TimelineObject.actionInfo.uninstalledWording"));
            timeLineObject.actionInfo = beVar;
            timeLineObject.sourceUserName = PL(parseXml.get(".TimelineObject.sourceUserName"));
            timeLineObject.sourceNickName = PL(parseXml.get(".TimelineObject.sourceNickName"));
            timeLineObject.publicUserName = PL(parseXml.get(".TimelineObject.publicUserName"));
            timeLineObject.statisticsData = PL(parseXml.get(".TimelineObject.statisticsData"));
            timeLineObject.canvasInfo = PL(parseXml.get(".TimelineObject.canvasInfoXml"));
            timeLineObject.contentattr = Util.getInt(parseXml.get(".TimelineObject.contentattr"), 0);
            fat fat = new fat();
            fat.IEy = PL(parseXml.get(".TimelineObject.websearch.relevant_vid"));
            fat.IEz = PL(parseXml.get(".TimelineObject.websearch.relevant_expand"));
            fat.IEA = PL(parseXml.get(".TimelineObject.websearch.relevant_pre_searchid"));
            fat.IEB = PL(parseXml.get(".TimelineObject.websearch.relevant_shared_openid"));
            fat.IEC = Util.getLong(parseXml.get(".TimelineObject.websearch.rec_category"), 0);
            fat.rCq = PL(parseXml.get(".TimelineObject.websearch.shareUrl"));
            fat.msN = PL(parseXml.get(".TimelineObject.websearch.shareTitle"));
            fat.xDQ = PL(parseXml.get(".TimelineObject.websearch.shareDesc"));
            fat.IED = PL(parseXml.get(".TimelineObject.websearch.shareImgUrl"));
            fat.IEE = PL(parseXml.get(".TimelineObject.websearch.shareString"));
            fat.IEF = PL(parseXml.get(".TimelineObject.websearch.shareStringUrl"));
            fat.source = PL(parseXml.get(".TimelineObject.websearch.source"));
            fat.eby = PL(parseXml.get(".TimelineObject.websearch.sourceUrl"));
            fat.IEG = PL(parseXml.get(".TimelineObject.websearch.strPlayCount"));
            fat.IEH = PL(parseXml.get(".TimelineObject.websearch.titleUrl"));
            fat.IEI = PL(parseXml.get(".TimelineObject.websearch.extReqParams"));
            fat.IEJ = PL(parseXml.get(".TimelineObject.websearch.tagList"));
            fat.IEK = Util.getLong(parseXml.get(".TimelineObject.websearch.channelId"), 0);
            fat.IEL = PL(parseXml.get(".TimelineObject.websearch.shareTag"));
            timeLineObject.webSearchInfo = fat;
        } else {
            timeLineObject = bfM;
        }
        AppMethodBeat.o(94866);
        return timeLineObject;
    }

    private static fb PN(String str) {
        AppMethodBeat.i(94867);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(94867);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml("<root>" + PO(str) + "</root>", "root", null);
        if (parseXml == null) {
            AppMethodBeat.o(94867);
            return null;
        }
        fb fbVar = new fb();
        fbVar.KIt = PL(parseXml.get(".root.en"));
        fbVar.KIu = PL(parseXml.get(".root.zh-CN"));
        fbVar.KIv = PL(parseXml.get(".root.zh-TW"));
        AppMethodBeat.o(94867);
        return fbVar;
    }

    private static String PO(String str) {
        AppMethodBeat.i(94868);
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 0;
        int length = str.length();
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != '&') {
                sb.append(charAt);
                i2++;
            } else if (str.startsWith("&amp;", i2)) {
                sb.append('&');
                i2 += 5;
            } else if (str.startsWith("&apos;", i2)) {
                sb.append('\'');
                i2 += 6;
            } else if (str.startsWith("&quot;", i2)) {
                sb.append('\"');
                i2 += 6;
            } else if (str.startsWith("&lt;", i2)) {
                sb.append('<');
                i2 += 4;
            } else if (str.startsWith("&gt;", i2)) {
                sb.append('>');
                i2 += 4;
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(94868);
        return sb2;
    }

    public static Pair<Integer, Integer> a(TimeLineObject timeLineObject, Context context, boolean z) {
        int i2;
        int i3;
        cnb cnb;
        AppMethodBeat.i(94869);
        if (timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.size() <= 0 || (cnb = timeLineObject.ContentObj.LoV.get(0)) == null || cnb.MsB == null || cnb.MsB.Mto <= 0.0f || cnb.MsB.Mtp <= 0.0f) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = (int) cnb.MsB.Mtp;
            i3 = (int) cnb.MsB.Mto;
        }
        Pair<Integer, Integer> a2 = a(i3, i2, context, z);
        AppMethodBeat.o(94869);
        return a2;
    }

    public static Pair<Integer, Integer> a(int i2, int i3, Context context) {
        double d2;
        double d3;
        AppMethodBeat.i(201846);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 160.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 200.0f);
        int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 44.0f);
        double d4 = (double) i2;
        double d5 = (double) i3;
        if (d4 <= 0.0d || d5 <= 0.0d) {
            double d6 = (double) fromDPToPix;
            d2 = d6;
            d3 = d6;
        } else {
            double min = Math.min(((double) fromDPToPix2) / d4, ((double) fromDPToPix2) / d5);
            d3 = d4 * min;
            d2 = min * d5;
            if (d3 < ((double) fromDPToPix3)) {
                double d7 = (((double) fromDPToPix3) * 1.0d) / d3;
                d3 *= d7;
                d2 *= d7;
            }
            if (d2 < ((double) fromDPToPix3)) {
                double d8 = (((double) fromDPToPix3) * 1.0d) / d2;
                d3 *= d8;
                d2 *= d8;
            }
            if (d3 > ((double) fromDPToPix2)) {
                d3 = (double) fromDPToPix2;
            }
            if (d2 > ((double) fromDPToPix2)) {
                d2 = (double) fromDPToPix2;
            }
        }
        if (d3 < 1.0d) {
            d3 = 1.0d;
        }
        if (d2 < 1.0d) {
            d2 = 1.0d;
        }
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf((int) d3), Integer.valueOf((int) d2));
        AppMethodBeat.o(201846);
        return create;
    }

    public static Pair<Integer, Integer> a(int i2, int i3, Context context, boolean z) {
        int i4;
        int i5;
        AppMethodBeat.i(94870);
        if (i2 <= 0) {
            i4 = 320;
        } else {
            i4 = i2;
        }
        if (i3 <= 0) {
            i3 = 240;
        }
        if (context == null) {
            Log.e("MicroMsg.TimeLineHelper", "the context is null");
            Pair<Integer, Integer> create = Pair.create(Integer.valueOf(i4), Integer.valueOf(i3));
            AppMethodBeat.o(94870);
            return create;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            i5 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
        } else {
            i5 = i4;
        }
        int i6 = (i5 >> 5) << 5;
        if (i4 < i3 && context != null) {
            i6 = Math.min(BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 160.0f), i6);
        }
        int i7 = (int) (((((double) i6) * 1.0d) * ((double) i3)) / ((double) i4));
        if (!z) {
            int fromDPToPix = a.fromDPToPix(context, (int) TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR);
            int fromDPToPix2 = a.fromDPToPix(context, 169);
            if (i7 > i6) {
                i7 = fromDPToPix;
                i6 = fromDPToPix2;
            } else {
                i7 = fromDPToPix2;
                i6 = fromDPToPix;
            }
        }
        Log.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z));
        Pair<Integer, Integer> create2 = Pair.create(Integer.valueOf(i6), Integer.valueOf(i7));
        AppMethodBeat.o(94870);
        return create2;
    }

    public static Pair<Integer, Integer> df(Context context) {
        AppMethodBeat.i(201847);
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf(a.fromDPToPix(context, (int) TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH)), Integer.valueOf(a.fromDPToPix(context, (int) TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR)));
        AppMethodBeat.o(201847);
        return create;
    }
}
