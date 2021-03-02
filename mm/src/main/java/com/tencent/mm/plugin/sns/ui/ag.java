package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.b.d.i;

public final class ag implements ad {
    private int DPi = 1;
    private byte[] EpE = null;
    private String EpF;
    private int EpG;
    CdnImageView EpH = null;
    private TextView EpI = null;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private int Erv = 0;
    private k Erw = null;
    private String EsA;
    jo EsB = null;
    private String appId;
    private String appName;
    private String eag;
    private String eam;
    private final MMActivity gte;
    public String izf = "";
    public String izg = "";
    private String mSessionId;
    private View sc = null;
    private String title = "";
    private TextView titleTv = null;
    private int vjQ = 0;

    public ag(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(203301);
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
        this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
        this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.EsA = Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
        if (!Util.isNullOrNil(this.EsA) && (parseXml = XmlParser.parseXml(this.EsA, "mmbrandmpvideo", null)) != null) {
            this.EsB = h.k("", parseXml);
        }
        AppMethodBeat.o(203301);
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
        AppMethodBeat.i(203302);
        this.sc = aa.jQ(this.gte).inflate(R.layout.c4w, (ViewGroup) null);
        this.sc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ag.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(203300);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ag.this.EsB != null) {
                    Rect rect = new Rect();
                    int[] iArr = new int[2];
                    ag.this.EpH.getLocationOnScreen(iArr);
                    rect.set(iArr[0], iArr[1], iArr[0] + ag.this.EpH.getMeasuredWidth(), iArr[1] + ag.this.EpH.getMeasuredHeight());
                    h.a(view.getContext(), ag.this.EsB, rect);
                }
                a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203300);
            }
        });
        this.EpH = (CdnImageView) this.sc.findViewById(R.id.dw4);
        this.titleTv = (TextView) this.sc.findViewById(R.id.ir7);
        this.EpI = (TextView) this.sc.findViewById(R.id.h7r);
        ImageView imageView = (ImageView) this.sc.findViewById(R.id.i4t);
        imageView.setImageDrawable(ar.m(this.gte, R.raw.icons_outlined_video_call, -1));
        imageView.setVisibility(0);
        this.EpH.setVisibility(0);
        if (this.EsB != null) {
            this.EpH.setUrl(this.EsB.iAo);
            this.titleTv.setText(this.EsB.title);
        }
        r.b(this.EpH, this.gte);
        View view = this.sc;
        AppMethodBeat.o(203302);
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
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        jo joVar;
        AppMethodBeat.i(203303);
        bf bfVar = new bf(33, this.gte);
        pInt.value = bfVar.beK;
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            bfVar.YF(4);
        }
        bfVar.aPB(this.title).aPw(str);
        bfVar.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
        if (this.vjQ == 15) {
            bfVar.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("fav_note_link_description"), ""));
        }
        if (!(this.EsB == null || (joVar = this.EsB) == null)) {
            bfVar.DPd.ContentObj.Lpa = joVar;
        }
        bfVar.ct(this.DPi, this.EpN);
        bfVar.YK(this.EpG);
        bfVar.aPE(this.eag);
        bfVar.aPF(this.EpF);
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
            for (String str3 : list) {
                if (!gnq.contains(str3)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str3;
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
        bfVar.aPH(this.eam);
        bfVar.setSessionId(this.mSessionId);
        bfVar.YG(this.Erv);
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        if (this.Erw != null) {
            this.Erw.tQ(commit);
            com.tencent.mm.plugin.sns.k.h.DVR.c(this.Erw);
            this.Erw.bfK();
        }
        aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(203303);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        return false;
    }
}
