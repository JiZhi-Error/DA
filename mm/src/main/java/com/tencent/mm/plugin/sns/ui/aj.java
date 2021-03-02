package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.comm.b;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.xweb.util.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aj implements ad {
    private int DPi = 1;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private TextView EsH;
    private TextView EsI;
    private i EsJ;
    private String EsK;
    private Bitmap EsL;
    private String appName = "";
    private String dNI = "";
    private boolean gVd = false;
    private MMActivity gte;
    private View sc;
    private String songLyric;

    public aj(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        WXMusicObject wXMusicObject;
        Map<String, String> parseXml;
        AppMethodBeat.i(203311);
        this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        String stringExtra = this.gte.getIntent().getStringExtra("Ksnsupload_music_share_object_xml");
        if (!Util.isNullOrNil(stringExtra) && (parseXml = XmlParser.parseXml(stringExtra, "musicShareItem", null)) != null) {
            this.EsJ = new i();
            this.EsJ.j("", parseXml);
        }
        if (this.EsJ == null) {
            this.EsJ = new i();
        }
        if (this.Erq.getType() == 76) {
            this.EsK = this.gte.getIntent().getStringExtra("music_mv_cover_url");
            WXMusicVideoObject wXMusicVideoObject = (WXMusicVideoObject) this.Erq.mediaObject;
            if (wXMusicVideoObject != null) {
                this.songLyric = wXMusicVideoObject.songLyric;
                this.EsJ.jlj.singerName = wXMusicVideoObject.singerName;
                this.EsJ.jlj.albumName = wXMusicVideoObject.albumName;
                this.EsJ.jlj.musicGenre = wXMusicVideoObject.musicGenre;
                this.EsJ.jlj.issueDate = wXMusicVideoObject.issueDate;
                this.EsJ.jlj.identification = wXMusicVideoObject.identification;
                this.EsJ.jlj.Alz = wXMusicVideoObject.duration;
                this.EsJ.jlj.extraInfo = this.Erq.messageExt;
            }
        } else if (this.Erq.getType() == 3 && (wXMusicObject = (WXMusicObject) this.Erq.mediaObject) != null) {
            this.songLyric = wXMusicObject.songLyric;
            this.EsK = wXMusicObject.songAlbumUrl;
            this.EsJ.jlj.extraInfo = this.Erq.messageExt;
        }
        this.EpM = k.w(this.gte.getIntent());
        this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(203311);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        AppMethodBeat.i(203312);
        this.sc = aa.jQ(this.gte).inflate(R.layout.c4y, (ViewGroup) null);
        ((RoundCornerRelativeLayout) this.sc.findViewById(R.id.h9d)).setRadius((float) a.fromDPToPix((Context) this.gte, 4));
        View findViewById = this.sc.findViewById(R.id.a_q);
        LinearLayout linearLayout = (LinearLayout) this.sc.findViewById(R.id.fpx);
        if (ao.isDarkMode()) {
            linearLayout.setBackgroundResource(R.drawable.avn);
        } else {
            linearLayout.setBackgroundResource(R.drawable.avo);
        }
        MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) this.sc.findViewById(R.id.axd);
        this.EsH = (TextView) this.sc.findViewById(R.id.axh);
        TextView textView = (TextView) this.sc.findViewById(R.id.axi);
        this.EsI = (TextView) this.sc.findViewById(R.id.axf);
        if (this.Erq.thumbData != null) {
            this.EsL = BitmapUtil.decodeByteArray(this.Erq.thumbData);
        }
        mMRoundCornerImageView.setImageBitmap(this.EsL);
        textView.setText(this.Erq.title);
        if (!Util.isNullOrNil(this.Erq.description)) {
            this.EsH.setVisibility(0);
            this.EsH.setText(this.Erq.description);
        } else {
            this.EsH.setText("");
            this.EsH.setVisibility(0);
        }
        if (this.EsJ == null || this.EsJ.jlj == null || Util.isNullOrNil(this.EsJ.jlj.Ktq)) {
            this.EsI.setText("");
            this.EsI.setVisibility(8);
        } else {
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = a.fromDPToPix(MMApplicationContext.getContext(), 6);
            ((ViewGroup.MarginLayoutParams) this.EsH.getLayoutParams()).topMargin = a.fromDPToPix(MMApplicationContext.getContext(), 2);
            this.sc.findViewById(R.id.g8b).setVisibility(0);
            this.EsI.setText(this.EsJ.jlj.Ktq + this.gte.getString(R.string.f8v));
            this.EsI.setVisibility(0);
        }
        if (this.EsL != null && !this.EsL.isRecycled()) {
            String messageDigest = d.getMessageDigest(this.Erq.thumbData);
            b bVar = b.qCp;
            b.a(this.gte, findViewById, this.EsL, messageDigest);
        }
        View view = this.sc;
        AppMethodBeat.o(203312);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, org.b.d.i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        i iVar2;
        AppMethodBeat.i(203313);
        com.tencent.mm.plugin.sns.model.aj.faK();
        WXMediaMessage wXMediaMessage = this.Erq;
        String str3 = this.dNI;
        String str4 = this.appName;
        String str5 = this.EsK;
        String str6 = this.songLyric;
        Log.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        Log.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        bf bfVar = new bf(42);
        bfVar.aPC(Util.nullAs(str3, "")).aPD(Util.nullAs(str4, ""));
        bfVar.YK(5);
        Log.d("MicroMsg.UploadManager", "TimeLineType 42");
        if (!Util.isNullOrNil(str)) {
            bfVar.aPw(str);
        }
        bfVar.aPB(Util.nullAs(wXMediaMessage.title, "")).aPz(Util.nullAs(wXMediaMessage.description, ""));
        String str7 = "";
        String str8 = "";
        String str9 = "";
        if (iMediaObject instanceof WXMusicObject) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            String nullAs = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
            str8 = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
            str9 = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
            str7 = nullAs;
        } else if (iMediaObject instanceof WXMusicVideoObject) {
            WXMusicVideoObject wXMusicVideoObject = (WXMusicVideoObject) iMediaObject;
            str7 = Util.nullAs(wXMusicVideoObject.musicUrl, "");
            str8 = Util.nullAs(!Util.isNullOrNil(wXMusicVideoObject.musicDataUrl) ? wXMusicVideoObject.musicDataUrl : wXMusicVideoObject.musicUrl, "");
            str9 = "";
        }
        bfVar.aPB("").aPz("");
        int tN = be.tN(iMediaObject.type());
        if (tN == -1) {
            Log.d("MicroMsg.UploadManager", "mediaType is invalid");
            bfVar = null;
        } else if (!bfVar.a(wXMediaMessage.thumbData, str7, str9, str8, tN, Util.nullAs(wXMediaMessage.title, ""), Util.nullAs(wXMediaMessage.description, ""), str5, str6)) {
            bfVar = null;
        }
        if (bfVar == null) {
            Log.e("MicroMsg.MusicMvWidget", "packHelper == null, %s, %s", this.dNI, this.appName);
            AppMethodBeat.o(203313);
            return false;
        }
        if (!(this.EsJ == null || (iVar2 = this.EsJ) == null)) {
            bfVar.DPd.ContentObj.jfy = iVar2.jlj;
        }
        pInt.value = bfVar.beK;
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            bfVar.YF(4);
        }
        bfVar.YK(this.EpG);
        if (this.Ero) {
            bfVar.YK(5);
        }
        LinkedList<ebm> linkedList2 = new LinkedList<>();
        if (list != null) {
            new LinkedList();
            List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
            for (String str10 : list) {
                if (!gnq.contains(str10)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str10;
                    linkedList2.add(ebm);
                }
            }
        }
        bfVar.bq(linkedList2);
        if (iVar != null) {
            bfVar.kl(iVar.token, iVar.Mte);
        }
        bfVar.a(cjy);
        if (z) {
            bfVar.YL(1);
        } else {
            bfVar.YL(0);
        }
        bfVar.gR(list2).YI(i2);
        bfVar.g(null, null, null, i5, i6);
        bfVar.ct(this.DPi, this.EpN);
        if (this.Erp && this.Erq != null) {
            bfVar.aPx(this.Erq.mediaTagName);
            bfVar.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
        }
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        com.tencent.mm.plugin.sns.model.aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(203313);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(203314);
        if (this.EsL != null && !this.EsL.isRecycled()) {
            this.EsL.recycle();
        }
        AppMethodBeat.o(203314);
        return false;
    }
}
