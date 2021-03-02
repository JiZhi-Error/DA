package com.tencent.mm.ag;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.z;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class k extends z {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static class c {
        private static final List<com.tencent.mm.co.c<? extends f>> izP = Collections.synchronizedList(new ArrayList());
        private static final HashMap<Integer, com.tencent.mm.co.c<? extends f>> izQ = new HashMap<>();

        static {
            AppMethodBeat.i(150128);
            AppMethodBeat.o(150128);
        }

        public static void a(com.tencent.mm.co.c<? extends f> cVar) {
            AppMethodBeat.i(150126);
            izP.add(cVar);
            AppMethodBeat.o(150126);
        }

        static /* synthetic */ f rI(int i2) {
            AppMethodBeat.i(150127);
            com.tencent.mm.co.c<? extends f> cVar = izQ.get(Integer.valueOf(i2));
            if (cVar != null) {
                f fVar = (f) cVar.get();
                fVar.type = i2;
                if (fVar != null) {
                    AppMethodBeat.o(150127);
                    return fVar;
                }
                Log.w("MicroMsg.AppMessage", "get(%s) return null piece for type(%s)", cVar, Integer.valueOf(i2));
            } else {
                Log.w("MicroMsg.AppMessage", "get for type(%s) is null", Integer.valueOf(i2));
            }
            AppMethodBeat.o(150127);
            return null;
        }
    }

    private static final boolean aSt() {
        Field[] declaredFields;
        AppMethodBeat.i(150129);
        int i2 = 0;
        for (Field field : b.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                i2++;
            }
        }
        if (i2 > 204) {
            Log.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", Integer.valueOf(i2), 204);
            AppMethodBeat.o(150129);
            return false;
        }
        Log.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", Integer.valueOf(i2));
        AppMethodBeat.o(150129);
        return true;
    }

    public static class b extends f {
        private static final f<Integer, b> gAU = new com.tencent.mm.memory.a.c(100);
        public String action;
        public String aesKey;
        public String appId;
        public String appName;
        public int appVersion;
        public String canvasPageXml = "";
        public String content;
        public int contentattr;
        public String dCK;
        public int dDG;
        public String dFv;
        public String dPu;
        public String dRL;
        public int dYg;
        public String desc;
        public String description;
        public String designerName;
        public String designerRediretctUrl;
        public String eag;
        public String eah;
        public String eaj;
        public String eak;
        public String eal;
        public String eam;
        public String ean;
        public String extInfo;
        public String fQR;
        public String filemd5;
        public String iconUrl;
        public a iwF;
        public Map<String, String> iwG;
        public String iwH;
        public int iwI;
        public String iwJ;
        public String iwK;
        public int iwL;
        public int iwM;
        public String iwN;
        public String iwO;
        public int iwP;
        public int iwQ;
        public int iwR;
        public String iwS;
        public String iwT;
        public String iwU;
        public String iwV;
        public String iwW;
        public String iwX;
        public int iwY;
        public int iwZ;
        public int iwc;
        public String ixA;
        public String ixB;
        public String ixC;
        public String ixD;
        public String ixE;
        public int ixF;
        public int ixG;
        public int ixH;
        public String ixI;
        public String ixJ;
        public String ixK;
        public String ixL;
        public String ixM;
        public int ixN;
        public String ixO;
        public String ixP;
        public String ixQ;
        public int ixR;
        public int ixS;
        public String ixT;
        public String ixU;
        public int ixV;
        public int ixW;
        public int ixX;
        public String ixY;
        public String ixZ;
        public int ixa;
        public String ixb;
        public int ixc;
        public String ixd;
        public String ixe;
        public int ixf;
        public int ixg;
        public String ixh;
        public String ixi;
        public int ixj;
        public String ixk;
        public String ixl;
        public int ixm;
        public String ixn;
        public String ixo;
        public int ixp;
        public String ixq;
        public String ixr;
        public String ixs;
        public String ixt;
        public String ixu;
        public String ixv;
        public String ixw;
        public String ixx;
        public String ixy;
        public String ixz;
        public int iyA;
        public String iyB;
        public String iyC;
        public String iyD;
        public List<String> iyE;
        public String iyF;
        public List<String> iyG;
        public String iyH;
        public int iyI;
        public String iyJ;
        public String iyK;
        public String iyL;
        public String iyM;
        public String iyN;
        public String iyO;
        public String iyP;
        public String iyQ;
        public String iyR;
        public String iyS;
        public String iyT;
        public String iyU;
        public int iyV;
        public String iyW;
        public String iyX;
        public Map<String, String> iyY;
        public String iyZ;
        public String iya;
        public String iyb;
        public String iyc;
        public String iyd;
        public String iye;
        public int iyf;
        public String iyg;
        public String iyh;
        public String iyi;
        public String iyj;
        public String iyk;
        public String iyl;
        public String iym;
        public String iyn;
        public String iyo;
        public String iyp;
        public String iyq;
        public String iyr;
        public int iys;
        public String iyt;
        public String iyu;
        public String iyv;
        public int iyw;
        public boolean iyx = false;
        public int iyy = 0;
        public String iyz;
        public int izA;
        public String izB;
        public int izC = 0;
        public int izD = 0;
        private final HashMap<Class<? extends f>, f> izE = new HashMap<>();
        public Map<String, String> izF;
        public String izG;
        private String izH;
        private String izI;
        public int iza = 0;
        public String izb = "";
        public String izc = "";
        public String izd = "";
        public String ize = "";
        public String izf = "";
        public String izg = "";
        public String izh;
        public String izi;
        public String izj;
        public int izk;
        public String izl;
        public int izm;
        public String izn;
        public String izo;
        public int izp = a.BUSINESS_MAX.ordinal();
        public String izq;
        public int izr;
        public String izs;
        public String izt;
        public String izu;
        public String izv;
        public String izw;
        public Pair<String, String> izx = new Pair<>("", "");
        public MsgQuoteItem izy;
        public int izz;
        public String mediaTagName;
        public String messageAction;
        public String messageExt;
        public int pageType;
        public int sdkVer;
        public String secondUrl;
        public int thumbHeight;
        public int thumbWidth;
        public String thumburl;
        public int tid;
        public String title;
        public int type;
        public String url;
        public String username;

        public static class a {
            public String desc;
            public String fRa;
            public int izJ;
            public int izK;
            public int izL;
            public int izM;
            public int izN = 0;
            public int izO = 0;
            public String title;
        }

        public b() {
            AppMethodBeat.i(150108);
            AppMethodBeat.o(150108);
        }

        @Override // com.tencent.mm.ag.f
        public final /* synthetic */ f aHj() {
            AppMethodBeat.i(150124);
            b aSw = aSw();
            AppMethodBeat.o(150124);
            return aSw;
        }

        static {
            AppMethodBeat.i(150125);
            AppMethodBeat.o(150125);
        }

        public final <T extends f> T as(Class<T> cls) {
            AppMethodBeat.i(150109);
            T t = (T) this.izE.get(cls);
            AppMethodBeat.o(150109);
            return t;
        }

        public final Map<String, String> aSu() {
            return this.izF;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap<java.lang.Class<? extends com.tencent.mm.ag.f>, com.tencent.mm.ag.f> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void a(f fVar) {
            AppMethodBeat.i(150110);
            if (fVar == null) {
                Log.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
                AppMethodBeat.o(150110);
                return;
            }
            fVar.iwk = this;
            this.izE.put(fVar.getClass(), fVar);
            AppMethodBeat.o(150110);
        }

        public static final b HC(String str) {
            AppMethodBeat.i(150111);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(150111);
                return null;
            }
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = "parseImg_".concat(String.valueOf(str)).hashCode();
            b bVar = gAU.get(Integer.valueOf(hashCode));
            if (bVar != null) {
                AppMethodBeat.o(150111);
                return bVar;
            }
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.AppMessage", "parseImg failed");
                AppMethodBeat.o(150111);
                return null;
            }
            b bVar2 = new b();
            bVar2.type = 2;
            bVar2.appId = parseXml.get(".msg.appinfo.appid");
            bVar2.appVersion = Util.getInt(parseXml.get(".msg.appinfo.version"), 0);
            bVar2.appName = parseXml.get(".msg.appinfo.appname");
            bVar2.mediaTagName = parseXml.get(".msg.appinfo.mediatagname");
            bVar2.messageExt = parseXml.get(".msg.appinfo.messageext");
            bVar2.messageAction = parseXml.get(".msg.appinfo.messageaction");
            gAU.x(Integer.valueOf(hashCode), bVar2);
            AppMethodBeat.o(150111);
            return bVar2;
        }

        public final String w(Context context, boolean z) {
            AppMethodBeat.i(150112);
            String str = "";
            if (fn(true)) {
                if (!Util.isNullOrNil(this.izs)) {
                    String str2 = this.izs;
                    AppMethodBeat.o(150112);
                    return str2;
                } else if (!Util.isNullOrNil(this.izq)) {
                    int identifier = context.getResources().getIdentifier(this.izq, "string", context.getPackageName());
                    Log.d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                    if (identifier > 0) {
                        str = context.getResources().getString(identifier);
                    } else if (a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.izp) {
                        str = "";
                    } else {
                        str = this.eah;
                    }
                } else if (a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.izp) {
                    str = "";
                } else {
                    str = this.eah;
                }
            }
            if (z && !str.isEmpty()) {
                str = "[" + str + "]";
            }
            Log.d("MicroMsg.AppMessage", "txt: %s.", str);
            AppMethodBeat.o(150112);
            return str;
        }

        public final boolean fn(boolean z) {
            AppMethodBeat.i(150113);
            if (z) {
                if (44 == this.type && this.izp >= a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.izp < a.BUSINESS_MAX.ordinal()) {
                    AppMethodBeat.o(150113);
                    return true;
                }
            } else if (this.izp >= a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.izp < a.BUSINESS_MAX.ordinal()) {
                AppMethodBeat.o(150113);
                return true;
            }
            AppMethodBeat.o(150113);
            return false;
        }

        public static final b HD(String str) {
            AppMethodBeat.i(150114);
            b aD = aD(str, null);
            AppMethodBeat.o(150114);
            return aD;
        }

        public static final b aD(String str, String str2) {
            String str3;
            Map<String, String> map;
            AppMethodBeat.i(150115);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(150115);
                return null;
            }
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                str3 = str.substring(indexOf);
            } else {
                str3 = str;
            }
            int hashCode = str3.hashCode();
            b bVar = gAU.get(Integer.valueOf(hashCode));
            if (bVar != null) {
                AppMethodBeat.o(150115);
                return bVar;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, String> decode = !Util.isNullOrNil(str2) ? SemiXml.decode(str2) : null;
            if (decode == null) {
                map = XmlParser.parseXml(str3, "msg", null);
            } else {
                map = decode;
            }
            if (map == null) {
                Log.e("MicroMsg.AppMessage", "parse msg failed");
                AppMethodBeat.o(150115);
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            b bVar2 = new b();
            bVar2.izF = map;
            bVar2.izG = str;
            bVar2.izH = str3;
            bVar2.izI = str2;
            try {
                bVar2.a(map, bVar2);
                for (com.tencent.mm.co.c cVar : c.izP) {
                    f fVar = (f) cVar.get();
                    if (fVar != null) {
                        fVar.a(map, bVar2);
                        bVar2.a(fVar);
                    }
                }
                f rI = c.rI(bVar2.type);
                if (rI != null) {
                    rI.a(map, bVar2);
                    bVar2.a(rI);
                }
                gAU.x(Integer.valueOf(hashCode), bVar2);
                Log.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(Util.nullAsNil(str2).hashCode()));
                AppMethodBeat.o(150115);
                return bVar2;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppMessage", "parse amessage xml failed");
                Log.e("MicroMsg.AppMessage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(150115);
                return null;
            }
        }

        public static String a(b bVar, String str, d dVar) {
            AppMethodBeat.i(150116);
            Log.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", Util.secPrint(bVar.aesKey), bVar.filemd5);
            StringBuilder sb = new StringBuilder();
            sb.append("<msg>");
            if (bVar.thumbWidth == 0 || bVar.thumbHeight == 0) {
                Log.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
                sb.append(a(bVar, str, dVar, 0, 0));
            } else {
                Log.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", Integer.valueOf(bVar.thumbWidth), Integer.valueOf(bVar.thumbHeight));
                sb.append(a(bVar, str, dVar, bVar.thumbWidth, bVar.thumbHeight));
            }
            sb.append("</msg>");
            gAU.x(Integer.valueOf(sb.toString().hashCode()), bVar);
            String sb2 = sb.toString();
            AppMethodBeat.o(150116);
            return sb2;
        }

        public static String a(b bVar, String str, d dVar, int i2, int i3) {
            AppMethodBeat.i(150117);
            StringBuilder sb = new StringBuilder();
            sb.append("<appmsg appid=\"" + Util.escapeStringForXml(bVar.appId) + "\" sdkver=\"" + bVar.sdkVer + "\">");
            bVar.a(sb, bVar, str, dVar, i2, i3);
            f rI = c.rI(bVar.type);
            if (rI != null) {
                rI.a(sb, bVar, str, dVar, i2, i3);
            }
            sb.append("</appmsg>");
            if (2 == bVar.dDG) {
                sb.append("<ShakePageResult>").append(bVar.iwV).append("</ShakePageResult>");
            }
            Log.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", sb.toString());
            String sb2 = sb.toString();
            AppMethodBeat.o(150117);
            return sb2;
        }

        public final g aSv() {
            AppMethodBeat.i(150118);
            g gVar = new g();
            gVar.taskName = "task_AppMessage";
            gVar.field_fullpath = "";
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = false;
            gVar.field_isStreamMedia = false;
            gVar.field_force_aeskeycdn = true;
            gVar.field_trysafecdn = false;
            for (Map.Entry<Class<? extends f>, f> entry : this.izE.entrySet()) {
                f value = entry.getValue();
                if (value != null) {
                    value.a(gVar, this);
                }
            }
            AppMethodBeat.o(150118);
            return gVar;
        }

        public static b a(b bVar) {
            AppMethodBeat.i(150119);
            if (bVar == null) {
                b bVar2 = new b();
                AppMethodBeat.o(150119);
                return bVar2;
            }
            b aSw = bVar.aSw();
            AppMethodBeat.o(150119);
            return aSw;
        }

        @Override // com.tencent.mm.ag.f
        public final void a(Map<String, String> map, b bVar) {
            String[] split;
            String[] split2;
            AppMethodBeat.i(150120);
            try {
                this.iwG = map;
                this.appId = map.get(".msg.appmsg.$appid");
                this.sdkVer = Util.getInt(map.get(".msg.appmsg.$sdkver"), 0);
                this.title = Util.escapeDirTraversal(map.get(".msg.appmsg.title"));
                this.description = map.get(".msg.appmsg.des");
                this.username = map.get(".msg.appmsg.username");
                this.action = map.get(".msg.appmsg.action");
                this.type = Util.getInt(map.get(".msg.appmsg.type"), 0);
                this.content = map.get(".msg.appmsg.content");
                this.url = map.get(".msg.appmsg.url");
                this.iwH = map.get(".msg.appmsg.lowurl");
                this.iwN = map.get(".msg.appmsg.appattach.tpurl");
                this.iwO = map.get(".msg.appmsg.appattach.tpthumburl");
                this.iwP = Util.getInt(map.get(".msg.appmsg.appattach.tpthumblength"), 0);
                this.iwQ = Util.getInt(map.get(".msg.appmsg.appattach.tpthumbheight"), 0);
                this.iwR = Util.getInt(map.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
                this.iwS = map.get(".msg.appmsg.appattach.tpthumbmd5");
                this.iwT = map.get(".msg.appmsg.appattach.tpauthkey");
                this.iwU = map.get(".msg.appmsg.appattach.tpthumbaeskey");
                this.ixd = map.get(".msg.appmsg.dataurl");
                this.ixe = map.get(".msg.appmsg.lowdataurl");
                this.iwI = Util.getInt(map.get(".msg.appmsg.appattach.totallen"), 0);
                this.dCK = map.get(".msg.appmsg.appattach.attachid");
                if (!Util.isNullOrNil(this.iwN)) {
                    this.dCK = this.iwN;
                }
                this.iwJ = Util.escapeDirTraversal(map.get(".msg.appmsg.appattach.fileext"));
                this.iwK = map.get(".msg.appmsg.appattach.emoticonmd5");
                this.extInfo = map.get(".msg.appmsg.extinfo");
                this.izx = new Pair<>("", map.get(".msg.appmsg.extinfo.solitaire_info"));
                this.iwL = Util.getInt(map.get(".msg.appmsg.androidsource"), 0);
                this.eag = map.get(".msg.appmsg.sourceusername");
                this.eah = map.get(".msg.appmsg.sourcedisplayname");
                this.fQR = map.get(".msg.commenturl");
                this.thumburl = map.get(".msg.appmsg.thumburl");
                this.mediaTagName = map.get(".msg.appmsg.mediatagname");
                this.messageAction = map.get(".msg.appmsg.messageaction");
                this.messageExt = map.get(".msg.appmsg.messageext");
                this.appVersion = Util.getInt(map.get(".msg.appinfo.version"), 0);
                this.appName = map.get(".msg.appinfo.appname");
                this.dRL = map.get(".msg.fromusername");
                this.iwW = map.get(".msg.appmsg.appattach.cdnattachurl");
                this.iwX = map.get(".msg.appmsg.appattach.cdnthumburl");
                this.iwY = Util.getInt(map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
                this.iwZ = Util.getInt(map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
                this.ixa = Util.getInt(map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
                this.thumbHeight = Util.getInt(map.get(".msg.appmsg.appattach.thumbheight"), 0);
                this.thumbWidth = Util.getInt(map.get(".msg.appmsg.appattach.thumbwidth"), 0);
                this.aesKey = map.get(".msg.appmsg.appattach.aeskey");
                this.ixc = Util.getInt(map.get(".msg.appmsg.appattach.encryver"), 1);
                this.ixb = map.get(".msg.appmsg.appattach.cdnthumbaeskey");
                this.iwM = Util.getInt(map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
                if (this.iwM == 0 && this.iwI > 26214400) {
                    this.iwM = 1;
                    Log.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", Integer.valueOf(this.iwI));
                }
                this.ixg = Util.getInt(map.get(".msg.appmsg.productitem.$type"), 0);
                this.ixh = map.get(".msg.appmsg.productitem.productinfo");
                this.ixj = Util.getInt(map.get(".msg.appmsg.emoticongift.packageflag"), 0);
                this.ixi = map.get(".msg.appmsg.emoticongift.packageid");
                this.ixo = map.get(".msg.appmsg.emoticonshared.packageid");
                this.ixp = Util.getInt(map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
                this.ixk = map.get(".msg.appmsg.tvinfo");
                this.ixl = map.get(".msg.appmsg.recorditem");
                this.eaj = map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
                this.eak = map.get(".msg.appmsg.webviewshared.shareUrlOpen");
                this.eal = map.get(".msg.appmsg.webviewshared.jsAppId");
                this.eam = map.get(".msg.appmsg.webviewshared.publisherId");
                this.iyV = p.fd(map.get(".msg.appmsg.designershared.designeruin"));
                this.designerName = map.get(".msg.appmsg.designershared.designername");
                this.designerRediretctUrl = map.get(".msg.appmsg.designershared.designerrediretcturl");
                this.tid = Util.safeParseInt(map.get(".msg.appmsg.emotionpageshared.tid"));
                this.iyW = map.get(".msg.appmsg.emotionpageshared.title");
                this.desc = map.get(".msg.appmsg.emotionpageshared.desc");
                this.iconUrl = map.get(".msg.appmsg.emotionpageshared.iconUrl");
                this.secondUrl = Util.nullAs(map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
                this.pageType = Util.safeParseInt(map.get(".msg.appmsg.emotionpageshared.pageType"));
                this.iyZ = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
                this.iza = Util.safeParseInt(map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
                this.izb = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
                this.izc = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
                this.izd = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
                this.ize = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
                this.izf = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
                this.izg = Util.nullAs(map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
                this.canvasPageXml = Util.nullAs(map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
                if (map.containsKey(".msg.appmsg.gamelife")) {
                    this.iyY = new HashMap(4);
                    this.iyY.put(Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording.$lang")), Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording")));
                    this.iyY.put(Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording1.$lang")), Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording1")));
                    this.iyY.put(Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording2.$lang")), Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording2")));
                    this.iyY.put(Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording3.$lang")), Util.nullAsNil(map.get(".msg.appmsg.gamelife.digest.wording3")));
                }
                this.izi = map.get(".msg.appmsg.weappinfo.username");
                this.izh = map.get(".msg.appmsg.weappinfo.pagepath");
                this.izj = map.get(".msg.appmsg.weappinfo.appid");
                this.izA = Util.getInt(map.get(".msg.appmsg.weappinfo.version"), 0);
                this.izk = Util.getInt(map.get(".msg.appmsg.weappinfo.type"), 0);
                this.izz = Util.getInt(map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
                this.izl = map.get(".msg.appmsg.weappinfo.pkginfo.md5");
                this.izB = map.get(".msg.appmsg.weappinfo.weappiconurl");
                this.izn = map.get(".msg.appmsg.weappinfo.shareId");
                this.izo = map.get(".msg.appmsg.weappinfo.sharekey");
                this.izp = Util.getInt(map.get(".msg.appmsg.weappinfo.nativeappinfo.type"), a.BUSINESS_MAX.ordinal());
                this.izq = Util.nullAs(map.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
                this.izs = Util.nullAs(map.get(".msg.appmsg.weappinfo.nativeappinfo.sourcename"), "");
                this.izt = Util.nullAs(map.get(".msg.appmsg.weappinfo.nativeappinfo.sourceiconurl"), "");
                this.izr = Util.getInt(map.get(".msg.appmsg.weappinfo.disableforward"), 0);
                this.izC = Util.getInt(map.get(".msg.appmsg.soundtype"), 0);
                switch (this.type) {
                    case 1:
                        if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                            this.iyx = true;
                            break;
                        }
                    case 13:
                        this.ixm = Util.getInt(map.get(".msg.appmsg.mallproductitem.$type"), 0);
                        this.ixn = map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                        break;
                    case 16:
                        this.dPu = bVar.izG;
                        this.ixT = "";
                        this.ixV = Util.getInt(map.get(".msg.appmsg.carditem.from_scene"), 2);
                        this.ixU = map.get(".msg.appmsg.carditem.brand_name");
                        this.ixW = Util.getInt(map.get(".msg.appmsg.carditem.card_type"), -1);
                        break;
                    case 34:
                        this.ixY = Util.nullAs(map.get(".msg.appmsg.giftcard_info.order_id"), "");
                        this.ixX = p.fd(map.get(".msg.appmsg.giftcard_info.biz_uin"));
                        this.ixZ = Util.nullAs(map.get(".msg.appmsg.giftcard_info.app_name"), "");
                        this.iya = Util.nullAs(map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                        this.iyb = Util.nullAs(map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                        this.iyc = Util.nullAs(map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                        this.iyd = Util.nullAs(map.get(".msg.appmsg.giftcard_info.title_color"), "");
                        this.iye = Util.nullAs(map.get(".msg.appmsg.giftcard_info.des_color"), "");
                        break;
                    case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                        this.izy = new MsgQuoteItem();
                        this.izy.type = Util.getInt(map.get(".msg.appmsg.refermsg.type"), 0);
                        this.izy.zFI = Util.getLong(map.get(".msg.appmsg.refermsg.svrid"), 0);
                        this.izy.zFJ = Util.nullAs(map.get(".msg.appmsg.refermsg.fromusr"), "");
                        this.izy.zFK = Util.nullAs(map.get(".msg.appmsg.refermsg.chatusr"), "");
                        this.izy.zFK = Util.nullAs(map.get(".msg.appmsg.refermsg.chatusr"), "");
                        this.izy.zFL = Util.nullAs(map.get(".msg.appmsg.refermsg.displayname"), "");
                        this.izy.content = Util.nullAs(map.get(".msg.appmsg.refermsg.content"), "");
                        this.izy.zFM = Util.nullAs(map.get(".msg.appmsg.refermsg.msgsource"), "");
                        break;
                    case 68:
                        this.izu = map.get(".msg.appmsg.liteapp.id");
                        this.izv = map.get(".msg.appmsg.liteapp.path");
                        this.izw = map.get(".msg.appmsg.liteapp.query");
                        break;
                    case 2000:
                        this.ixN = Util.getInt(map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                        this.ixO = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.feedesc"));
                        this.ixP = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.transcationid"));
                        this.ixQ = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.transferid"));
                        this.ixR = Util.getInt(map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        this.ixS = Util.getInt(map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                        this.dYg = Util.getInt(map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                        this.dFv = Util.nullAs(map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                        this.iyX = Util.nullAs(map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                        break;
                    case 2001:
                        this.iyj = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.iconurl"));
                        this.iyo = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.scenetext"));
                        this.iyi = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.url"));
                        this.iyk = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                        this.iyl = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                        this.iyn = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                        this.iym = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.senderdes"));
                        this.iyp = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.templateid"));
                        this.iyq = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.sceneid"));
                        this.iyr = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                        this.iys = Util.getInt(map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                        this.iyt = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                        this.iyu = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.imageid"));
                        this.iyv = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                        this.iyw = Util.getInt(map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                        this.iyy = Util.getInt(map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                        this.ixR = Util.getInt(map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        this.iyz = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                        this.iyA = Util.getInt(map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                        this.iyB = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                        this.iyC = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                        this.iyD = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                        String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                        if (!Util.isNullOrNil(nullAsNil) && (split2 = nullAsNil.split("\\|")) != null && split2.length > 0) {
                            this.iyE = new ArrayList();
                            this.iyE.addAll(Arrays.asList(split2));
                        }
                        this.iyF = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                        String nullAsNil2 = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                        if (!Util.isNullOrNil(nullAsNil2) && (split = nullAsNil2.split("\\|")) != null && split.length > 0) {
                            this.iyG = new ArrayList();
                            this.iyG.addAll(Arrays.asList(split));
                        }
                        this.iyH = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                        this.iyI = Util.getInt(map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                        this.iyJ = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                        break;
                    case 2002:
                        this.iyK = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.url"));
                        this.iyL = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                        this.iyM = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                        this.iyN = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                        this.iyO = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                        this.iyP = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                        this.iyQ = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                        this.iyR = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                        this.iyS = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                        this.iyT = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                        this.iyU = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                        break;
                }
                if (this.type != 21) {
                    if (this.type != 2001) {
                        this.dDG = Util.getInt(map.get(".msg.appmsg.showtype"), 0);
                        switch (this.dDG) {
                            case 1:
                                if (Util.getInt(map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                    this.content = SemiXml.encode(map);
                                    break;
                                }
                                break;
                            case 2:
                                String lowerCase = bVar.izG.toLowerCase();
                                this.iwV = bVar.izG.substring(lowerCase.indexOf("<ShakePageResult>".toLowerCase()) + 17, lowerCase.indexOf("</ShakePageResult>".toLowerCase()));
                                break;
                        }
                    } else {
                        this.dDG = Util.getInt(map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
                    }
                } else {
                    this.dDG = Util.getInt(map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                }
                this.ean = map.get(".msg.appmsg.statextstr");
                this.iwc = Util.getInt(map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
                if (this.iwc == 5 && Util.getInt(map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                    this.iwc = 0;
                }
                this.ixf = Util.getInt(map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
                this.ixq = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
                this.ixr = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
                if (Util.isNullOrNil(this.ixr)) {
                    this.ixr = map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
                }
                this.ixs = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
                this.ixt = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
                this.ixu = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
                this.ixv = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
                this.ixw = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
                this.ixx = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
                this.ixy = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
                this.ixA = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
                this.ixz = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
                this.ixC = map.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
                this.ixB = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
                this.ixF = Util.getInt(map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                this.ixH = Util.getInt(map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
                this.ixG = Util.getInt(map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
                this.ixD = map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
                this.ixE = map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
                String str = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
                this.ixL = str;
                this.ixJ = str;
                String str2 = map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
                this.ixK = str2;
                this.ixI = str2;
                this.ixM = Util.nullAsNil(map.get(".msg.appmsg.template_id"));
                this.filemd5 = map.get(".msg.appmsg.md5");
                this.iyf = Util.getInt(map.get(".msg.appmsg.jumpcontrol.enable"), 0);
                this.iyg = map.get(".msg.appmsg.jumpcontrol.jumpurl");
                this.iyh = map.get(".msg.appmsg.jumpcontrol.pushcontent");
                Map<String, String> parseXml = XmlParser.parseXml(bVar.izH, "msgoperation", null);
                if (!(this == null || parseXml == null)) {
                    this.iwF = new a();
                    this.iwF.fRa = parseXml.get(".msgoperation.expinfo.expidstr");
                    this.iwF.izJ = Util.getInt(parseXml.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                    this.iwF.izK = Util.getInt(parseXml.get(".msgoperation.appmsg.isupdatetitle"), 0);
                    this.iwF.title = parseXml.get(".msgoperation.appmsg.title");
                    this.iwF.izL = Util.getInt(parseXml.get(".msgoperation.appmsg.isupdatedesc"), 0);
                    this.iwF.desc = parseXml.get(".msgoperation.appmsg.desc");
                    this.iwF.izM = Util.getInt(parseXml.get(".msgoperation.appmsg.ishiddentail"), 0);
                }
                AppMethodBeat.o(150120);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppMessage", "parse amessage xml failed");
                Log.e("MicroMsg.AppMessage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(150120);
                throw e2;
            }
        }

        private b aSw() {
            AppMethodBeat.i(150121);
            b bVar = new b();
            if (this == null) {
                AppMethodBeat.o(150121);
                return bVar;
            }
            Log.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", Util.secPrint(this.aesKey), this.filemd5, bVar.appId);
            bVar.action = this.action;
            bVar.appId = this.appId;
            bVar.appName = this.appName;
            bVar.appVersion = this.appVersion;
            bVar.dCK = this.dCK;
            bVar.iwI = this.iwI;
            bVar.content = this.content;
            bVar.description = this.description;
            bVar.username = this.username;
            bVar.extInfo = this.extInfo;
            bVar.mediaTagName = this.mediaTagName;
            bVar.messageAction = this.messageAction;
            bVar.messageExt = this.messageExt;
            bVar.iwL = this.iwL;
            bVar.iwJ = this.iwJ;
            bVar.dRL = this.dRL;
            bVar.iwH = this.iwH;
            bVar.sdkVer = this.sdkVer;
            bVar.title = this.title;
            bVar.type = this.type;
            bVar.dDG = this.dDG;
            bVar.iwc = this.iwc;
            bVar.ixf = this.ixf;
            bVar.url = this.url;
            bVar.iwK = this.iwK;
            bVar.eag = this.eag;
            bVar.eah = this.eah;
            bVar.fQR = this.fQR;
            bVar.thumburl = this.thumburl;
            bVar.iwV = this.iwV;
            bVar.ixd = this.ixd;
            bVar.ixe = this.ixe;
            bVar.ixg = this.ixg;
            bVar.ixh = this.ixh;
            bVar.ixj = this.ixj;
            bVar.ixi = this.ixi;
            bVar.ixm = this.ixm;
            bVar.ixn = this.ixn;
            bVar.ixp = this.ixp;
            bVar.ixo = this.ixo;
            bVar.ixk = this.ixk;
            bVar.ixl = this.ixl;
            bVar.ixM = this.ixM;
            bVar.dPu = this.dPu;
            bVar.ixT = this.ixT;
            bVar.ixU = this.ixU;
            bVar.ixV = this.ixV;
            bVar.ixW = this.ixV;
            bVar.ixO = this.ixO;
            bVar.ixR = this.ixR;
            bVar.ixN = this.ixN;
            bVar.ixP = this.ixP;
            bVar.ixQ = this.ixQ;
            bVar.iyf = this.iyf;
            bVar.iyg = this.iyg;
            bVar.iyh = this.iyh;
            bVar.contentattr = this.contentattr;
            bVar.eaj = this.eaj;
            bVar.eak = this.eak;
            bVar.eal = this.eal;
            bVar.eam = this.eam;
            bVar.iyX = this.iyX;
            bVar.iyV = this.iyV;
            bVar.designerName = this.designerName;
            bVar.designerRediretctUrl = this.designerName;
            bVar.tid = this.tid;
            bVar.iyW = this.iyW;
            bVar.desc = this.desc;
            bVar.iconUrl = this.iconUrl;
            bVar.secondUrl = this.secondUrl;
            bVar.pageType = this.pageType;
            bVar.iyZ = this.iyZ;
            bVar.iza = this.iza;
            bVar.izb = this.izb;
            bVar.izc = this.izc;
            bVar.izd = this.izd;
            bVar.ize = this.ize;
            bVar.izf = this.izf;
            bVar.izg = this.izg;
            bVar.canvasPageXml = this.canvasPageXml;
            bVar.ean = this.ean;
            bVar.iyY = this.iyY;
            bVar.iwW = this.iwW;
            bVar.aesKey = this.aesKey;
            bVar.filemd5 = this.filemd5;
            bVar.iwM = this.iwM;
            bVar.iwF = this.iwF;
            bVar.izh = this.izh;
            bVar.izi = this.izi;
            bVar.izk = this.izk;
            bVar.izl = this.izl;
            bVar.izz = this.izz;
            bVar.izj = this.izj;
            bVar.izA = this.izA;
            bVar.izB = this.izB;
            bVar.izn = this.izn;
            bVar.izo = this.izo;
            bVar.izp = this.izp;
            bVar.izq = this.izq;
            bVar.izs = this.izs;
            bVar.izt = this.izt;
            bVar.izr = this.izr;
            bVar.izH = this.izH;
            bVar.izI = this.izI;
            bVar.izG = this.izG;
            bVar.izF = this.izF;
            bVar.iwN = this.iwN;
            bVar.iwO = this.iwO;
            bVar.iwP = this.iwP;
            bVar.iwQ = this.iwQ;
            bVar.iwR = this.iwR;
            bVar.iwS = this.iwS;
            bVar.iwT = this.iwT;
            bVar.iwU = this.iwU;
            bVar.izy = this.izy;
            bVar.izx = this.izx;
            bVar.izu = this.izu;
            bVar.izv = this.izv;
            bVar.izw = this.izw;
            bVar.izD = this.izD;
            for (Map.Entry<Class<? extends f>, f> entry : this.izE.entrySet()) {
                f aHj = entry.getValue().aHj();
                if (aHj != null) {
                    bVar.a(aHj);
                }
            }
            AppMethodBeat.o(150121);
            return bVar;
        }

        @Override // com.tencent.mm.ag.f
        public final void a(StringBuilder sb, b bVar, String str, d dVar, int i2, int i3) {
            String escapeStringForXml;
            AppMethodBeat.i(150122);
            for (com.tencent.mm.co.c cVar : c.izP) {
                f fVar = (f) cVar.get();
                if (fVar != null) {
                    f as = bVar.as(fVar.getClass());
                    if (as != null) {
                        fVar = as;
                    }
                    fVar.b(sb, bVar, str, dVar, i2, i3);
                }
            }
            sb.append("<title>" + Util.escapeStringForXml(bVar.title) + "</title>");
            sb.append("<des>" + Util.escapeStringForXml(bVar.description) + "</des>");
            sb.append("<username>" + Util.escapeStringForXml(bVar.username) + "</username>");
            StringBuilder sb2 = new StringBuilder("<action>");
            if (Util.isNullOrNil(bVar.action)) {
                escapeStringForXml = "view";
            } else {
                escapeStringForXml = Util.escapeStringForXml(bVar.action);
            }
            sb.append(sb2.append(escapeStringForXml).append("</action>").toString());
            sb.append("<type>" + bVar.type + "</type>");
            sb.append("<showtype>").append(bVar.dDG).append("</showtype>");
            sb.append("<content>" + Util.escapeStringForXml(bVar.content) + "</content>");
            sb.append("<url>" + Util.escapeStringForXml(bVar.url) + "</url>");
            sb.append("<lowurl>" + Util.escapeStringForXml(bVar.iwH) + "</lowurl>");
            sb.append("<dataurl>" + Util.escapeStringForXml(bVar.ixd) + "</dataurl>");
            sb.append("<lowdataurl>" + Util.escapeStringForXml(bVar.ixe) + "</lowdataurl>");
            sb.append("<contentattr>").append(bVar.contentattr).append("</contentattr>");
            sb.append("<streamvideo>");
            sb.append("<streamvideourl>").append(Util.escapeStringForXml(bVar.iyZ)).append("</streamvideourl>");
            sb.append("<streamvideototaltime>").append(bVar.iza).append("</streamvideototaltime>");
            sb.append("<streamvideotitle>").append(Util.escapeStringForXml(bVar.izb)).append("</streamvideotitle>");
            sb.append("<streamvideowording>").append(Util.escapeStringForXml(bVar.izc)).append("</streamvideowording>");
            sb.append("<streamvideoweburl>").append(Util.escapeStringForXml(bVar.izd)).append("</streamvideoweburl>");
            sb.append("<streamvideothumburl>").append(Util.escapeStringForXml(bVar.ize)).append("</streamvideothumburl>");
            sb.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(bVar.izf)).append("</streamvideoaduxinfo>");
            sb.append("<streamvideopublishid>").append(Util.escapeStringForXml(bVar.izg)).append("</streamvideopublishid>");
            sb.append("</streamvideo>");
            sb.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", bVar.canvasPageXml));
            switch (bVar.type) {
                case 10:
                    sb.append("<productitem type=\"" + bVar.ixg + "\">");
                    sb.append("<productinfo>" + Util.escapeStringForXml(bVar.ixh) + "</productinfo>");
                    sb.append("</productitem>");
                    break;
                case 13:
                    sb.append("<mallproductitem type=\"" + bVar.ixm + "\">");
                    sb.append("<mallproductinfo>" + Util.escapeStringForXml(bVar.ixn) + "</mallproductinfo>");
                    sb.append("</mallproductitem>");
                    break;
                case 16:
                    sb.append("<carditem>" + bVar.ixT + "</carditem>");
                    break;
                case 19:
                case 24:
                    sb.append("<recorditem>" + Util.escapeStringForXml(bVar.ixl) + "</recorditem>");
                    break;
                case 20:
                    sb.append("<tvinfo>" + Util.escapeStringForXml(bVar.ixk) + "</tvinfo>");
                    break;
                case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                    sb.append("<refermsg>");
                    if (bVar.izy != null) {
                        sb.append("<type>").append(bVar.izy.type).append("</type>");
                        sb.append("<svrid>").append(bVar.izy.zFI).append("</svrid>");
                        sb.append("<fromusr>").append(bVar.izy.zFJ).append("</fromusr>");
                        sb.append("<chatusr>").append(bVar.izy.zFK).append("</chatusr>");
                        sb.append("<displayname>").append(Util.escapeStringForXml(bVar.izy.zFL)).append("</displayname>");
                        sb.append("<msgsource>").append(Util.escapeStringForXml(bVar.izy.zFM)).append("</msgsource>");
                        sb.append("<content>").append(Util.escapeStringForXml(bVar.izy.content)).append("</content>");
                    }
                    sb.append("</refermsg>");
                    break;
                case 68:
                    sb.append("<liteapp>");
                    sb.append("<id>").append(bVar.izu).append("</id>");
                    sb.append("<path>").append(Util.escapeStringForXml(bVar.izv)).append("</path>");
                    sb.append("<query>").append(Util.escapeStringForXml(bVar.izw)).append("</query>");
                    sb.append("</liteapp>");
                    break;
                case 2000:
                    sb.append("<wcpayinfo>");
                    sb.append("<paysubtype>" + bVar.ixN + "</paysubtype>");
                    sb.append("<feedesc>" + bVar.ixO + "</feedesc>");
                    sb.append("<transcationid>" + bVar.ixP + "</transcationid>");
                    sb.append("<transferid>" + bVar.ixQ + "</transferid>");
                    sb.append("<invalidtime>" + bVar.ixR + "</invalidtime>");
                    sb.append("<pay_memo>" + bVar.iyX + "</pay_memo>");
                    sb.append("</wcpayinfo>");
                    break;
                case 2001:
                    sb.append("<wcpayinfo>");
                    sb.append("<iconurl>" + Util.escapeStringForXml(bVar.iyj) + "</iconurl>");
                    sb.append("<scenetext>" + Util.escapeStringForXml(bVar.iyo) + "</scenetext>");
                    sb.append("<url>" + Util.escapeStringForXml(bVar.iyi) + "</url>");
                    sb.append("<receivertitle>" + Util.escapeStringForXml(bVar.iyk) + "</receivertitle>");
                    sb.append("<sendertitle>" + Util.escapeStringForXml(bVar.iyl) + "</sendertitle>");
                    sb.append("<receiverdes>" + Util.escapeStringForXml(bVar.iyn) + "</receiverdes>");
                    sb.append("<senderdes>" + Util.escapeStringForXml(bVar.iym) + "</senderdes>");
                    sb.append("<templateid>" + Util.escapeStringForXml(bVar.iyp) + "</templateid>");
                    sb.append("<sceneid>" + Util.escapeStringForXml(bVar.iyq) + "</sceneid>");
                    sb.append("<nativeurl>" + Util.escapeStringForXml(bVar.iyr) + "</nativeurl>");
                    sb.append("<innertype>" + Util.escapeStringForXml(new StringBuilder().append(bVar.dDG).toString()) + "</innertype>");
                    sb.append("<localtype>" + Util.escapeStringForXml(new StringBuilder().append(bVar.iys).toString()) + "</localtype>");
                    sb.append("<paymsgid>" + Util.escapeStringForXml(bVar.iyt) + "</paymsgid>");
                    sb.append("<imageid>" + Util.escapeStringForXml(bVar.iyu) + "</imageid>");
                    sb.append("<imageaeskey>" + Util.escapeStringForXml(bVar.iyv) + "</imageaeskey>");
                    sb.append("<imagelength>" + Util.escapeStringForXml(new StringBuilder().append(bVar.iyw).toString()) + "</imagelength>");
                    sb.append("<droptips>" + Util.escapeStringForXml(new StringBuilder().append(bVar.iyy).toString()) + "</droptips>");
                    sb.append("</wcpayinfo>");
                    break;
            }
            sb.append("<appattach>");
            if (dVar == null || (Util.isNullOrNil(str) && i2 == 0 && i3 == 0)) {
                sb.append("<totallen>" + bVar.iwI + "</totallen>");
                sb.append("<attachid>" + Util.escapeStringForXml(bVar.dCK) + "</attachid>");
                sb.append("<cdnattachurl>" + Util.escapeStringForXml(bVar.iwW) + "</cdnattachurl>");
                sb.append("<emoticonmd5>" + Util.escapeStringForXml(bVar.iwK) + "</emoticonmd5>");
                sb.append("<aeskey>" + Util.escapeStringForXml(bVar.aesKey) + "</aeskey>");
                if (!(i2 == 0 || i3 == 0)) {
                    sb.append("<thumbheight>" + i3 + "</thumbheight>");
                    sb.append("<thumbwidth>" + i2 + "</thumbwidth>");
                }
            } else {
                sb.append("<attachid>" + Util.escapeStringForXml(str) + "</attachid>");
                if (dVar.field_fileLength > 0 && !Util.isNullOrNil(dVar.field_fileId)) {
                    sb.append("<cdnattachurl>" + Util.escapeStringForXml(dVar.field_fileId) + "</cdnattachurl>");
                    if (bVar.type == 19 || bVar.type == 24 || bVar.type == 4 || bVar.type == 3 || bVar.type == 7 || bVar.type == 27 || bVar.type == 26) {
                        Log.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", Integer.valueOf(bVar.type), Long.valueOf(dVar.field_fileLength));
                    } else {
                        sb.append("<totallen>" + dVar.field_fileLength + "</totallen>");
                    }
                }
                if (dVar.field_thumbimgLength > 0) {
                    sb.append("<cdnthumburl>" + Util.escapeStringForXml(dVar.field_fileId) + "</cdnthumburl>");
                    if (!Util.isNullOrNil(dVar.field_thumbfilemd5)) {
                        sb.append("<cdnthumbmd5>" + dVar.field_thumbfilemd5 + "</cdnthumbmd5>");
                    }
                    sb.append("<cdnthumblength>" + dVar.field_thumbimgLength + "</cdnthumblength>");
                    sb.append("<cdnthumbheight>" + i3 + "</cdnthumbheight>");
                    sb.append("<cdnthumbwidth>" + i2 + "</cdnthumbwidth>");
                    sb.append("<cdnthumbaeskey>" + dVar.field_aesKey + "</cdnthumbaeskey>");
                }
                sb.append("<aeskey>" + Util.escapeStringForXml(dVar.field_aesKey) + "</aeskey>");
                sb.append("<encryver>1</encryver>");
            }
            sb.append("<fileext>" + Util.escapeStringForXml(bVar.iwJ) + "</fileext>");
            sb.append("<islargefilemsg>" + bVar.iwM + "</islargefilemsg>");
            sb.append("</appattach>");
            if (bVar.type == 53) {
                sb.append("<extinfo>").append((String) bVar.izx.second).append("</extinfo>");
            } else {
                sb.append("<extinfo>" + Util.escapeStringForXml(bVar.extInfo) + "</extinfo>");
            }
            sb.append("<androidsource>" + bVar.iwL + "</androidsource>");
            if (!Util.isNullOrNil(bVar.eag)) {
                sb.append("<sourceusername>" + Util.escapeStringForXml(bVar.eag) + "</sourceusername>");
                sb.append("<sourcedisplayname>" + Util.escapeStringForXml(bVar.eah) + "</sourcedisplayname>");
                sb.append("<commenturl>" + Util.escapeStringForXml(bVar.fQR) + "</commenturl>");
            }
            sb.append("<thumburl>" + Util.escapeStringForXml(bVar.thumburl) + "</thumburl>");
            sb.append("<mediatagname>" + Util.escapeStringForXml(bVar.mediaTagName) + "</mediatagname>");
            sb.append("<messageaction>" + HE(Util.escapeStringForXml(bVar.messageAction)) + "</messageaction>");
            sb.append("<messageext>" + HE(Util.escapeStringForXml(bVar.messageExt)) + "</messageext>");
            sb.append("<emoticongift>");
            sb.append("<packageflag>" + bVar.ixj + "</packageflag>");
            sb.append("<packageid>" + Util.escapeStringForXml(bVar.ixi) + "</packageid>");
            sb.append("</emoticongift>");
            sb.append("<emoticonshared>");
            sb.append("<packageflag>" + bVar.ixp + "</packageflag>");
            sb.append("<packageid>" + Util.escapeStringForXml(bVar.ixo) + "</packageid>");
            sb.append("</emoticonshared>");
            sb.append("<designershared>");
            sb.append("<designeruin>" + bVar.iyV + "</designeruin>");
            sb.append("<designername>" + bVar.designerName + "</designername>");
            sb.append("<designerrediretcturl>" + bVar.designerRediretctUrl + "</designerrediretcturl>");
            sb.append("</designershared>");
            sb.append("<emotionpageshared>");
            sb.append("<tid>" + bVar.tid + "</tid>");
            sb.append("<title>" + bVar.iyW + "</title>");
            sb.append("<desc>" + bVar.desc + "</desc>");
            sb.append("<iconUrl>" + bVar.iconUrl + "</iconUrl>");
            sb.append("<secondUrl>" + bVar.secondUrl + "</secondUrl>");
            sb.append("<pageType>" + bVar.pageType + "</pageType>");
            sb.append("</emotionpageshared>");
            sb.append("<webviewshared>");
            sb.append("<shareUrlOriginal>" + Util.escapeStringForXml(bVar.eaj) + "</shareUrlOriginal>");
            sb.append("<shareUrlOpen>" + Util.escapeStringForXml(bVar.eak) + "</shareUrlOpen>");
            sb.append("<jsAppId>" + Util.escapeStringForXml(bVar.eal) + "</jsAppId>");
            sb.append("<publisherId>" + Util.escapeStringForXml(bVar.eam) + "</publisherId>");
            sb.append("</webviewshared>");
            sb.append("<template_id>" + Util.escapeStringForXml(bVar.ixM) + "</template_id>");
            Log.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", bVar.filemd5);
            sb.append("<md5>" + Util.escapeStringForXml(bVar.filemd5) + "</md5>");
            for (com.tencent.mm.co.c cVar2 : c.izP) {
                f fVar2 = (f) cVar2.get();
                if (fVar2 != null) {
                    f as2 = bVar.as(fVar2.getClass());
                    if (as2 != null) {
                        fVar2 = as2;
                    }
                    fVar2.a(sb, bVar, str, dVar, i2, i3);
                }
            }
            AppMethodBeat.o(150122);
        }

        public final void a(k kVar) {
            kVar.field_appId = this.appId;
            kVar.field_title = this.title;
            kVar.field_description = this.description;
            kVar.field_type = this.type;
            kVar.field_source = this.appName;
        }

        public static String HE(String str) {
            AppMethodBeat.i(150123);
            String str2 = "<![CDATA[" + str + "]]>";
            AppMethodBeat.o(150123);
            return str2;
        }

        public final String getTitle() {
            if (this.iwF == null || this.iwF.izK == 0) {
                return this.title;
            }
            return this.iwF.title;
        }

        public final String getDescription() {
            if (this.iwF == null || this.iwF.izL == 0) {
                return this.description;
            }
            return this.iwF.desc;
        }

        public final boolean aSx() {
            if (this.iwF == null || this.iwF.izM == 0) {
                return false;
            }
            return true;
        }

        public final boolean aSy() {
            if (this.iwF == null || this.iwF.izJ != 1) {
                return false;
            }
            return true;
        }
    }

    static {
        AppMethodBeat.i(150130);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[7];
        mAutoDBInfo.columns = new String[8];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "msgId";
        mAutoDBInfo.colsMap.put("msgId", "LONG default '0'  PRIMARY KEY ");
        sb.append(" msgId LONG default '0'  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msgId";
        mAutoDBInfo.columns[1] = "xml";
        mAutoDBInfo.colsMap.put("xml", "TEXT");
        sb.append(" xml TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "description";
        mAutoDBInfo.colsMap.put("description", "TEXT");
        sb.append(" description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "source";
        mAutoDBInfo.colsMap.put("source", "TEXT");
        sb.append(" source TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        mAutoDBInfo.columns[7] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        if (CrashReportFactory.hasDebuger()) {
            Assert.assertTrue(aSt());
        }
        AppMethodBeat.o(150130);
    }

    public enum a {
        BUSINESS_MY_LIFE_AROUND,
        BUSINESS_OTHER,
        BUSINESS_MAX;

        public static a valueOf(String str) {
            AppMethodBeat.i(150104);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(150104);
            return aVar;
        }

        static {
            AppMethodBeat.i(150107);
            AppMethodBeat.o(150107);
        }

        public static boolean isValid(int i2) {
            AppMethodBeat.i(150105);
            if (i2 < BUSINESS_MY_LIFE_AROUND.ordinal() || i2 >= BUSINESS_MAX.ordinal()) {
                AppMethodBeat.o(150105);
                return false;
            }
            AppMethodBeat.o(150105);
            return true;
        }

        public static String b(int i2, String str, Context context) {
            AppMethodBeat.i(150106);
            String str2 = "";
            if (isValid(i2) && !Util.isNullOrNil(str)) {
                int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                Log.d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                if (identifier > 0) {
                    str2 = context.getResources().getString(identifier);
                }
            }
            Log.d("MicroMsg.AppMessage", "txt: %s.", str2);
            AppMethodBeat.o(150106);
            return str2;
        }
    }
}
