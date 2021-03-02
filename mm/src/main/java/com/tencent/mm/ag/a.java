package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a extends f {
    public String appThumbUrl;
    public String ebj = "";
    public String imageUrl;
    public boolean iuQ;
    public String iuR;
    public int iuS;
    public boolean iuT;
    public String iuU;
    public String iuV;
    public String iuW;
    public String iuX;
    public String iuY;
    public String iuZ;
    public int iva;
    public int ivb;
    public int ivc = 0;
    public String ivd;
    public String ive;
    public int ivf = 0;
    public boolean ivg;
    public boolean ivh;
    public int ivi;
    public int ivj;
    public int ivk = 0;
    public String ivl = "";
    public String ivm = "";
    public String ivn = "";
    public String ivo = "";
    public String ivp = "";
    public boolean ivq = false;
    public String videoSource;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(2610);
        a aVar = new a();
        aVar.iuQ = this.iuQ;
        aVar.iuR = this.iuR;
        aVar.iuS = this.iuS;
        aVar.iuT = this.iuT;
        aVar.iuU = this.iuU;
        aVar.iuV = this.iuV;
        aVar.iuW = this.iuW;
        aVar.iuX = this.iuX;
        aVar.iuY = this.iuY;
        aVar.iva = this.iva;
        aVar.ivb = this.ivb;
        aVar.ive = this.ive;
        aVar.ivf = this.ivf;
        aVar.ivj = this.ivj;
        aVar.ivi = this.ivi;
        aVar.videoSource = this.videoSource;
        aVar.appThumbUrl = this.appThumbUrl;
        aVar.ivk = this.ivk;
        aVar.ivl = this.ivl;
        aVar.ivm = this.ivm;
        aVar.ivn = this.ivn;
        aVar.ivo = this.ivo;
        aVar.ivp = this.ivp;
        aVar.ivc = this.ivc;
        aVar.ivq = this.ivq;
        aVar.imageUrl = this.imageUrl;
        AppMethodBeat.o(2610);
        return aVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void b(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        String str2;
        AppMethodBeat.i(2611);
        super.b(sb, bVar, str, dVar, i2, i3);
        if (bVar != null && bVar.type == 48) {
            String str3 = bVar.izj;
            if (dVar == null || Util.isNullOrNil(str3) || Util.isNullOrNil(dVar.field_fileUrl) || Util.isNullOrNil(dVar.field_thumbUrl)) {
                Log.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
            } else {
                try {
                    String str4 = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s";
                    Object[] objArr = new Object[6];
                    objArr[0] = q.encode(dVar.field_fileUrl, ProtocolPackage.ServerEncoding);
                    objArr[1] = q.encode(dVar.field_thumbUrl, ProtocolPackage.ServerEncoding);
                    objArr[2] = q.encode(str3, ProtocolPackage.ServerEncoding);
                    objArr[3] = !Util.isNullOrNil(bVar.description) ? q.encode(bVar.description, ProtocolPackage.ServerEncoding) : "";
                    objArr[4] = !Util.isNullOrNil(this.ivn) ? q.encode(this.ivn, ProtocolPackage.ServerEncoding) : "";
                    if (!Util.isNullOrNil(bVar.title)) {
                        str2 = q.encode(bVar.title, ProtocolPackage.ServerEncoding);
                    } else {
                        str2 = "";
                    }
                    objArr[5] = str2;
                    String format = String.format(str4, objArr);
                    Log.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", format);
                    bVar.url = format;
                    bVar.thumburl = dVar.field_thumbUrl;
                    bVar.iwX = dVar.field_thumbUrl;
                    AppMethodBeat.o(2611);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", e2, "hy: not support utf-8!", new Object[0]);
                    AppMethodBeat.o(2611);
                    return;
                }
            }
        }
        AppMethodBeat.o(2611);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(g gVar, k.b bVar) {
        AppMethodBeat.i(2612);
        super.a(gVar, bVar);
        if (bVar.type == 48 && Util.isNullOrNil(this.ivo) && !Util.isNullOrNil(this.ivl)) {
            gVar.field_appType = 213;
            gVar.field_fullpath = this.ivl;
            gVar.field_filemd5 = this.ebj;
            gVar.field_fileType = com.tencent.mm.i.a.gpV;
            gVar.field_totalLen = (int) s.boW(this.ivl);
            gVar.field_needStorage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_force_aeskeycdn = false;
            gVar.field_trysafecdn = true;
            gVar.field_bzScene = 2;
            gVar.snsVersion = 1;
        }
        AppMethodBeat.o(2612);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(2613);
        sb.append("<weappinfo>");
        if (!Util.isNullOrNil(bVar.izh)) {
            sb.append("<pagepath>" + k.b.HE(bVar.izh) + "</pagepath>");
        }
        sb.append("<username>" + Util.escapeStringForXml(bVar.izi) + "</username>");
        sb.append("<appid>" + Util.escapeStringForXml(bVar.izj) + "</appid>");
        if (bVar.izA != 0) {
            sb.append("<version>" + bVar.izA + "</version>");
        }
        if (bVar.izk != 0) {
            sb.append("<type>" + bVar.izk + "</type>");
        }
        if (!Util.isNullOrNil(bVar.izB)) {
            sb.append("<weappiconurl>" + k.b.HE(bVar.izB) + "</weappiconurl>");
        }
        if (!Util.isNullOrNil(this.imageUrl)) {
            sb.append("<weapppagethumbrawurl>" + k.b.HE(this.imageUrl) + "</weapppagethumbrawurl>");
        }
        if (!Util.isNullOrNil(bVar.izn)) {
            sb.append("<shareId>" + k.b.HE(bVar.izn) + "</shareId>");
        }
        if (bVar.izz == 1 || bVar.izz == 2) {
            sb.append("<pkginfo>");
            sb.append("<type>");
            sb.append(bVar.izz);
            sb.append("</type>");
            sb.append("<md5>");
            sb.append(bVar.izl);
            sb.append("</md5>");
            sb.append("</pkginfo>");
        }
        if (!Util.isNullOrNil(bVar.izo)) {
            sb.append("<sharekey>" + k.b.HE(bVar.izo) + "</sharekey>");
        }
        if (!Util.isNullOrNil(this.ive)) {
            sb.append("<messageextradata>").append(k.b.HE(this.ive)).append("</messageextradata>");
        }
        if (this.iuQ) {
            sb.append("<wadynamicpageinfo>");
            sb.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            sb.append("<cacheKey>");
            sb.append(k.b.HE(this.iuR));
            sb.append("</cacheKey>");
            sb.append("</wadynamicpageinfo>");
        }
        if (this.iuT) {
            sb.append("<waupdatablemsginfov3>");
            sb.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
            sb.append("<updatablemsgperiod>");
            sb.append(this.iva);
            sb.append("</updatablemsgperiod>");
            sb.append("<updatablemsgstate>");
            sb.append(this.ivb);
            sb.append("</updatablemsgstate>");
            sb.append("<updatablemsgcontent>");
            sb.append(k.b.HE(this.iuU));
            sb.append("</updatablemsgcontent>");
            sb.append("<updatablemsgcontentcolor>");
            sb.append(k.b.HE(this.iuV));
            sb.append("</updatablemsgcontentcolor>");
            sb.append("<subscribeentrycontent>");
            sb.append(k.b.HE(this.iuW));
            sb.append("</subscribeentrycontent>");
            sb.append("<subscribeentrybuttonwording>");
            sb.append(k.b.HE(this.iuX));
            sb.append("</subscribeentrybuttonwording>");
            sb.append("<subscribeconfirmedcontent>");
            sb.append(k.b.HE(this.iuY));
            sb.append("</subscribeconfirmedcontent>");
            sb.append("<expiredsubscribewording>");
            sb.append(k.b.HE(this.iuZ));
            sb.append("</expiredsubscribewording>");
            sb.append("</waupdatablemsginfov3>");
        }
        sb.append("<appservicetype>" + this.iuS + "</appservicetype>");
        if (bVar.izr != 0) {
            sb.append("<disableforward>" + bVar.izr + "</disableforward>");
        }
        if (bVar.fn(true)) {
            sb.append("<nativeappinfo>");
            sb.append("<type>" + bVar.izp + "</type>");
            sb.append("<appnamemultilanguagekey>" + k.b.HE(bVar.izq) + "</appnamemultilanguagekey>");
            sb.append("<sourcename>" + k.b.HE(bVar.izs) + "</sourcename>");
            sb.append("<sourceiconurl>" + k.b.HE(bVar.izt) + "</sourceiconurl>");
            sb.append("</nativeappinfo>");
        }
        sb.append("<videopageinfo>");
        StringBuilder sb2 = new StringBuilder("<thumbwidth>");
        if (i2 == 0) {
            i2 = this.ivi;
        }
        sb.append(sb2.append(i2).append("</thumbwidth>").toString());
        StringBuilder sb3 = new StringBuilder("<thumbheight>");
        if (i3 == 0) {
            i3 = this.ivj;
        }
        sb.append(sb3.append(i3).append("</thumbheight>").toString());
        if (!Util.isNullOrNil(this.videoSource)) {
            sb.append("<videosource>" + k.b.HE(this.videoSource) + "</videosource>");
        }
        if (!Util.isNullOrNil(this.appThumbUrl)) {
            sb.append("<appthumburl>" + k.b.HE(this.appThumbUrl) + "</appthumburl>");
        }
        sb.append("<fromopensdk>" + this.ivk + "</fromopensdk>");
        sb.append("</videopageinfo>");
        if (!Util.isNullOrNil(this.ivm) || !Util.isNullOrNil(this.ivl)) {
            sb.append("<screenvideoinfo>");
            sb.append("<videobuttontext>").append(k.b.HE(this.ivn)).append("</videobuttontext>");
            if (dVar != null && !Util.isNullOrNil(dVar.field_fileUrl)) {
                s.deleteFile(this.ivl);
                this.ivm = dVar.field_fileUrl;
                this.ebj = dVar.field_filemd5;
                this.ivo = dVar.field_thumbUrl;
            }
            if (Util.isNullOrNil(this.ivm)) {
                sb.append("<videotemplocalpath>").append(k.b.HE(this.ivl)).append("</videotemplocalpath>");
            }
            sb.append("<videomd5>").append(k.b.HE(this.ebj)).append("</videomd5>");
            sb.append("<videoremoteurl>").append(k.b.HE(this.ivm)).append("</videoremoteurl>");
            sb.append("<videothumburl>").append(k.b.HE(this.ivo)).append("</videothumburl>");
            sb.append("<videoplaydesc>").append(k.b.HE(this.ivp)).append("</videoplaydesc>");
            sb.append("</screenvideoinfo>");
        }
        if (this.ivc != 0) {
            sb.append("<tradingguaranteeflag>").append(this.ivc).append("</tradingguaranteeflag>");
        }
        if (this.ivf != 0) {
            sb.append("<subType>").append(this.ivf).append("</subType>");
        }
        if (!TextUtils.isEmpty(this.ivd)) {
            sb.append("<todoactivityid>").append(k.b.HE(this.ivd)).append("</todoactivityid>");
        }
        sb.append("</weappinfo>");
        if (this.ivq) {
            sb.append("<roomtoolsflag>1</roomtoolsflag>");
        }
        if (this.ivg) {
            sb.append("<isprivatemessage>1</isprivatemessage>");
        }
        AppMethodBeat.o(2613);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(2614);
        this.iuQ = Util.getInt(map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1;
        this.iuR = map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.iuS = Util.getInt(map.get(".msg.appmsg.weappinfo.appservicetype"), this.iuS);
        this.ive = map.get(".msg.appmsg.weappinfo.messageextradata");
        this.ivf = Util.getInt(map.get(".msg.appmsg.weappinfo.subType"), this.ivf);
        if (Util.getInt(map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.iuT = z;
        this.iuU = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent");
        this.iuV = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor");
        this.iuW = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent");
        this.iuX = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording");
        this.iuY = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent");
        this.iuZ = map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording");
        this.ivb = Util.getInt(map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
        this.iva = (int) Util.getLong(map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10);
        this.ivi = Util.getInt(map.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
        this.ivj = Util.getInt(map.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
        this.videoSource = map.get(".msg.appmsg.weappinfo.videopageinfo.videosource");
        this.appThumbUrl = map.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl");
        this.ivk = Util.getInt(map.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
        this.ivl = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath");
        this.ebj = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5");
        this.ivm = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl");
        this.ivn = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext");
        this.ivo = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl");
        this.ivp = map.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc");
        this.ivc = Util.getInt(map.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
        this.ivd = map.get(".msg.appmsg.weappinfo.todoactivityid");
        this.ivq = Util.getBoolean(map.get(".msg.appmsg.roomtoolsflag"), false);
        if (Util.getInt(map.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
            z2 = false;
        }
        this.ivg = z2;
        this.imageUrl = map.get(".msg.appmsg.weappinfo.weapppagethumbrawurl");
        AppMethodBeat.o(2614);
    }
}
