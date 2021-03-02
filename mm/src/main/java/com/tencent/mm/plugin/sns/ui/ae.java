package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.b.d.i;

public final class ae implements ad {
    private int DPi = 1;
    private byte[] EpE = null;
    private String EpF;
    private int EpG;
    private CdnImageView EpH = null;
    private TextView EpI = null;
    private k EpM = null;
    private String EpN = "";
    private e EpW;
    private int ErA;
    private String ErB;
    private boolean ErC;
    private String ErD;
    private int ErE;
    private String ErF;
    private int ErG = 0;
    private String ErH = "";
    private String ErI = "";
    String ErJ = "";
    private f ErK;
    private b ErL;
    private d ErM;
    private c ErN;
    private g ErO;
    private boolean Erj = false;
    private String Erk;
    private boolean Erl = false;
    boolean Erm = false;
    boolean Ern = false;
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private String Err = "";
    private String Ers = "";
    private String Ert;
    private String Eru;
    private int Erv = 0;
    private k Erw = null;
    private String Erx = "";
    private String Ery = "";
    private int Erz;
    private String appId;
    private String appName;
    private String eag;
    private String eal;
    private String eam;
    final MMActivity gte;

    /* renamed from: h  reason: collision with root package name */
    private int f1519h = -1;
    private Bitmap iKs = null;
    public String izf = "";
    public String izg = "";
    private String izu = "";
    private String izv = "";
    private String izw = "";
    String link = "";
    String mSessionId;
    private View sc = null;
    private String statExtStr;
    private String title = "";
    private TextView titleTv = null;
    private boolean tkD = false;
    private String twt = "";
    private String videoUrl = "";
    private int vjQ = 0;
    private int w = -1;
    private fat webSearchInfo = null;

    public ae(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        Map<String, String> parseXml2;
        Map<String, String> parseXml3;
        Map<String, String> parseXml4;
        Map<String, String> parseXml5;
        Map<String, String> parseXml6;
        AppMethodBeat.i(97926);
        this.EpM = k.w(this.gte.getIntent());
        this.vjQ = this.gte.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.ErG = this.gte.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.ErH = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.ErI = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.izf = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.izg = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.gte.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.f1519h = this.gte.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.statExtStr = Util.nullAs(this.gte.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.link = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.twt = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.EpE = this.gte.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        String stringExtra = this.gte.getIntent().getStringExtra("KsnsUpload_imgPath");
        if (this.EpE == null && !Util.isNullOrNil(stringExtra)) {
            this.EpE = s.aW(stringExtra, 0, -1);
        }
        if (this.EpE == null && this.Erq != null && this.Erq.mediaObject != null && (this.Erq.mediaObject instanceof WXImageObject)) {
            this.EpE = ((WXImageObject) this.Erq.mediaObject).imageData;
        }
        this.tkD = this.gte.getIntent().getBooleanExtra("ksnsis_video", false);
        this.Erl = this.gte.getIntent().getBooleanExtra("ksnsis_music", false);
        this.Erm = this.gte.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.Ern = this.gte.getIntent().getBooleanExtra("ksnsis_liteapp", false);
        this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
        this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.Ert = Util.nullAs(this.gte.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.Eru = Util.nullAs(this.gte.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.eal = Util.nullAs(this.gte.getIntent().getStringExtra("JsAppId"), "");
        this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.Erv = this.gte.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.ErJ = this.gte.getIntent().getStringExtra("fav_note_xml");
        this.Erx = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.Ery = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.Erz = this.gte.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
        this.ErA = this.gte.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
        this.ErB = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
        this.ErC = this.gte.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
        this.ErD = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
        this.ErE = this.gte.getIntent().getIntExtra("KsnsUpload_SubType", 0);
        this.ErF = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_PreloadResouces"), "");
        if (this.Ern) {
            this.izu = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppId"), "");
            this.izv = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppPath"), "");
            this.izw = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppQuery"), "");
        }
        this.Erk = Util.nullAs(this.gte.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.Erk.startsWith("http://mmsns.qpic.cn") || this.Erk.startsWith("https://mmsns.qpic.cn")) {
            this.twt = this.Erk;
            this.EpE = null;
            Log.i("MicroMsg.LinkWidget", "get thumb url %s", this.Erk);
        }
        Bundle bundleExtra = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.Erq = new SendMessageToWX.Req(bundleExtra).message;
            if (Util.isNullOrNil(this.title)) {
                this.title = this.Erq.title;
            }
            if (Util.isNullOrNil(this.Ers)) {
                this.Ers = this.Erq.description;
            }
            if (Util.isNullOrNil(this.EpE)) {
                this.EpE = this.Erq.thumbData;
            }
        }
        byte[] byteArrayExtra = this.gte.getIntent().getByteArrayExtra("KWebSearchInfo");
        if (byteArrayExtra != null) {
            this.webSearchInfo = new fat();
            try {
                this.webSearchInfo.parseFrom(byteArrayExtra);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.LinkWidget", e2, "parse web search info failed", new Object[0]);
                this.webSearchInfo = null;
            }
        }
        String stringExtra2 = this.gte.getIntent().getStringExtra("KSnsStrId");
        SnsInfo aQm = aj.faO().aQm(Util.nullAs(this.gte.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!Util.isNullOrNil(stringExtra2)) {
            this.Erw = k.tO(706);
            this.Erw.tS(this.Erw.jll).PI(new StringBuilder().append(System.currentTimeMillis()).toString()).tS(this.Erw.jlm).tS(1).PI(stringExtra2);
            if (aQm != null) {
                this.Erw.tR(aQm.field_type);
                this.Erw.fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(this.link);
            }
            h.DVR.b(this.Erw);
        }
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        String stringExtra3 = this.gte.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!Util.isNullOrNil(stringExtra3) && (parseXml6 = XmlParser.parseXml(stringExtra3, "finderFeed", null)) != null) {
            this.EpW = new e();
            this.EpW.j("", parseXml6);
        }
        String stringExtra4 = this.gte.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!Util.isNullOrNil(stringExtra4) && (parseXml5 = XmlParser.parseXml(stringExtra4, "finderTopic", null)) != null) {
            this.ErK = new f();
            this.ErK.j("", parseXml5);
        }
        String stringExtra5 = this.gte.getIntent().getStringExtra("ksnsupload_finder_activity_xml");
        if (!Util.isNullOrNil(stringExtra5) && (parseXml4 = XmlParser.parseXml(stringExtra5, "finderTopic", null)) != null) {
            this.ErL = new b();
            this.ErL.jld = l.z("", parseXml4);
        }
        String stringExtra6 = this.gte.getIntent().getStringExtra("ksnsupload_finder_album_xml");
        if (!Util.isNullOrNil(stringExtra6) && (parseXml3 = XmlParser.parseXml(stringExtra6, "finderColumn", null)) != null) {
            this.ErN = new c();
            this.ErN.j("", parseXml3);
        }
        String stringExtra7 = this.gte.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil(stringExtra7) && (parseXml2 = XmlParser.parseXml(stringExtra7, "finderLive", null)) != null) {
            this.ErM = new d();
            this.ErM.j("", parseXml2);
        }
        if (!Util.isNullOrNil(this.gte.getIntent().getStringExtra("ksnsupload_mega_video_object_xml")) && (parseXml = XmlParser.parseXml(stringExtra3, "finderMegaVideo", null)) != null) {
            this.ErO = new g();
            this.ErO.j("", parseXml);
        }
        AppMethodBeat.o(97926);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0105  */
    @Override // com.tencent.mm.plugin.sns.ui.ad
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View ffB() {
        /*
        // Method dump skipped, instructions count: 1409
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.ae.ffB():android.view.View");
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        bf bfVar;
        c cVar;
        b bVar;
        int i7;
        boolean z2;
        AppMethodBeat.i(97928);
        if (this.Erl) {
            bfVar = new bf(4, this.gte);
        } else if (this.tkD) {
            bfVar = new bf(5, this.gte);
        } else if (this.Erm) {
            bf bfVar2 = new bf(30, this.gte);
            bfVar2.DPd.weappInfo.username = this.Erx;
            bfVar2.DPd.weappInfo.path = this.Ery;
            bfVar2.DPd.weappInfo.version = this.Erz;
            bfVar2.DPd.weappInfo.nbf = this.ErA;
            bfVar2.DPd.weappInfo.dCC = this.ErB;
            boolean z3 = this.ErC;
            eyd eyd = bfVar2.DPd.weappInfo;
            if (z3) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            eyd.isGame = i7;
            bfVar2.DPd.weappInfo.eda = this.ErD;
            bfVar2.DPd.weappInfo.subType = this.ErE;
            bfVar2.DPd.weappInfo.Nvm = this.ErF;
            bfVar = bfVar2;
        } else if (this.Ern) {
            bfVar = new bf(41, this.gte);
            cio cio = new cio();
            cio.appId = this.izu;
            cio.path = this.izv;
            cio.query = this.izw;
            bfVar.DPd.liteappInfo = cio;
        } else if (this.vjQ == 11) {
            bfVar = new bf(18, this.gte);
            eep eep = new eep();
            eep.izc = this.ErH;
            eep.izb = this.title;
            eep.iyZ = this.link;
            eep.izd = this.ErI;
            eep.iza = this.ErG;
            eep.ize = this.twt;
            eep.izf = this.izf;
            eep.izg = this.izg;
            bfVar.DPh = eep;
            bfVar.DPd.streamvideo = eep;
        } else if (this.vjQ == 15) {
            bfVar = new bf(26, this.gte);
            bfVar.DPd.ContentObj.LoX = this.ErJ;
        } else if (this.vjQ == 16 && this.webSearchInfo != null) {
            bfVar = new bf(3, this.gte);
            fat fat = this.webSearchInfo;
            if (fat != null) {
                bfVar.webSearchInfo = fat;
            }
        } else if (this.vjQ == 17) {
            bfVar = new bf(28, this.gte);
            if (this.EpW != null) {
                bfVar.a(this.EpW);
            }
        } else if (this.vjQ == 23) {
            bfVar = new bf(36, this.gte);
            if (this.ErO != null) {
                bfVar.a(this.ErO);
            }
        } else if (this.vjQ == 18) {
            bfVar = new bf(29, this.gte);
            if (this.ErK != null) {
                bfVar.a(this.ErK);
            }
        } else if (this.vjQ == 22) {
            bfVar = new bf(37, this.gte);
            if (this.ErK != null) {
                bfVar.a(this.ErK);
            }
        } else if (this.vjQ == 24) {
            bfVar = new bf(39, this.gte);
            if (!(this.ErL == null || (bVar = this.ErL) == null)) {
                bfVar.DPd.ContentObj.Lpe = bVar.jld;
            }
        } else if (this.vjQ == 20) {
            bfVar = new bf(38, this.gte);
            if (!(this.ErN == null || (cVar = this.ErN) == null)) {
                bfVar.DPd.ContentObj.Lpb = cVar.jle;
            }
        } else if (this.vjQ == 21) {
            bfVar = new bf(34, this.gte);
            if (this.ErM != null) {
                bfVar.a(this.ErM);
            }
        } else if (this.vjQ == 27) {
            bfVar = new bf(43, this.gte);
            if (this.ErM != null) {
                bfVar.a(this.ErM);
            }
        } else {
            bfVar = new bf(3, this.gte);
        }
        pInt.value = bfVar.beK;
        if (i4 > a.DCT) {
            bfVar.YF(4);
        }
        if (this.EpE == null) {
            q.bcQ();
            Bitmap EP = com.tencent.mm.av.d.EP(this.twt);
            if (EP != null && !EP.isRecycled()) {
                Bitmap extractThumbNail = BitmapUtil.extractThumbNail(EP, 150, 150, false, false);
                Log.i("MicroMsg.LinkWidget", "create bitmap %d %d", Integer.valueOf(extractThumbNail.getHeight()), Integer.valueOf(extractThumbNail.getWidth()));
                this.EpE = BitmapUtil.Bitmap2Bytes(extractThumbNail);
            }
        }
        bfVar.aPB(this.title).aPz(this.link).aPA(this.link).aPw(str);
        bfVar.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
        if (this.vjQ == 15) {
            bfVar.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("fav_note_link_description"), ""));
        }
        if (this.Erl) {
            if (!bfVar.a(this.EpE, this.link, this.link, this.link, 3, "", "", "", "")) {
            }
        } else if (this.tkD) {
            WXVideoObject wXVideoObject = this.Erq != null ? (WXVideoObject) this.Erq.mediaObject : null;
            bfVar.a(this.EpE, this.link, wXVideoObject == null ? this.link : Util.nullAs(wXVideoObject.videoLowBandUrl, this.link), wXVideoObject == null ? this.link : Util.nullAs(wXVideoObject.videoUrl, this.link), 4, Util.nullAs(this.title, ""), Util.nullAs(this.Ers, ""), "", "");
        } else if (!Util.isNullOrNil(this.Erk)) {
            bfVar.i(this.Erk, "", "", this.w, this.f1519h);
        } else if (this.EpE != null) {
            if (this.Erm) {
                byte[] bArr = this.EpE;
                if (bArr == null) {
                    z2 = false;
                } else if (bArr.length < 4) {
                    z2 = false;
                } else {
                    z2 = true;
                    byte[] bArr2 = {-119, 80, 78, 71};
                    for (int i8 = 0; i8 < 4; i8++) {
                        if (bArr[i8] != bArr2[i8]) {
                            z2 = false;
                        }
                    }
                }
                if (z2) {
                    Log.i("MicroMsg.LinkWidget", "isPngThumbData");
                    byte[] cd = e.cd(this.EpE);
                    if (cd != null && cd.length > 0) {
                        Log.i("MicroMsg.LinkWidget", "use covert data");
                        this.EpE = e.cd(cd);
                    }
                }
            }
            bfVar.b(this.EpE, "", "");
        }
        bfVar.ct(this.DPi, this.EpN);
        bfVar.YK(this.EpG);
        bfVar.aPE(this.eag);
        bfVar.aPF(this.EpF);
        String str3 = this.statExtStr;
        bfVar.DPd.statExtStr = Util.nullAsNil(str3);
        Log.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", str3);
        bfVar.YI(i2);
        if (z) {
            bfVar.YL(1);
        } else {
            bfVar.YL(0);
        }
        bfVar.gR(list2);
        LinkedList<ebm> linkedList2 = new LinkedList<>();
        if (list != null) {
            new LinkedList();
            List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
            for (String str4 : list) {
                if (!gnq.contains(str4)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str4;
                    linkedList2.add(ebm);
                }
            }
        }
        if (iVar != null) {
            bfVar.kl(iVar.token, iVar.Mte);
        }
        bfVar.bq(linkedList2);
        if (!Util.isNullOrNil(this.appId)) {
            bfVar.aPC(this.appId);
        }
        if (!Util.isNullOrNil(this.appName)) {
            bfVar.aPD(Util.nullAs(this.appName, ""));
        }
        if (this.Ero) {
            bfVar.YK(5);
        }
        bfVar.a(cjy);
        if (this.Erp && this.Erq != null) {
            bfVar.aPx(this.Erq.mediaTagName);
            bfVar.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
        }
        bfVar.aPy(str2);
        bfVar.g(this.Ert, this.Eru, this.eal, i5, i6);
        bfVar.aPH(this.eam);
        bfVar.setSessionId(this.mSessionId);
        bfVar.YG(this.Erv);
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            com.tencent.mm.plugin.sns.k.g.DVR.c(this.EpM);
        }
        if (this.Erw != null) {
            this.Erw.tQ(commit);
            h.DVR.c(this.Erw);
            this.Erw.bfK();
        }
        aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(97928);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(97929);
        if (this.iKs != null && !this.iKs.isRecycled() && this.Erj) {
            this.iKs.recycle();
        }
        AppMethodBeat.o(97929);
        return false;
    }
}
