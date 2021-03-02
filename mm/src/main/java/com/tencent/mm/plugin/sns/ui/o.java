package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class o implements ad {
    private int DPi = 1;
    private byte[] EpE = null;
    private String EpF;
    private int EpG;
    private CdnImageView EpH = null;
    private TextView EpI = null;
    private int EpJ;
    private String EpK = "";
    private String EpL = "";
    private k EpM = null;
    private String EpN = "";
    private String appId = "";
    private String appName = "";
    private String dRr = "";
    private String eag;
    private MMActivity gte;

    /* renamed from: h  reason: collision with root package name */
    private int f1521h = -1;
    private Bitmap iKs = null;
    private String link = "";
    private View sc = null;
    private String title = "";
    private TextView titleTv = null;
    private boolean tkD = false;
    private String twt = "";
    private int w = -1;

    public o(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(97855);
        this.EpM = k.w(this.gte.getIntent());
        this.w = this.gte.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.f1521h = this.gte.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.link = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.twt = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.dRr = this.gte.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.tkD = this.gte.getIntent().getBooleanExtra("ksnsis_video", false);
        this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
        this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
        this.EpL = Util.nullAs(this.gte.getIntent().getStringExtra("KContentObjDesc"), "");
        this.EpK = Util.nullAs(this.gte.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.EpJ = this.gte.getIntent().getIntExtra("KUploadProduct_subType", 0);
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(97855);
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
        AppMethodBeat.i(97856);
        this.sc = aa.jQ(this.gte).inflate(R.layout.c4w, (ViewGroup) null);
        this.EpH = (CdnImageView) this.sc.findViewById(R.id.dw4);
        this.titleTv = (TextView) this.sc.findViewById(R.id.ir7);
        this.EpI = (TextView) this.sc.findViewById(R.id.h7r);
        if (this.tkD) {
            this.sc.findViewById(R.id.i4t).setVisibility(0);
        } else {
            this.sc.findViewById(R.id.i4t).setVisibility(8);
        }
        this.titleTv.setText(this.title);
        if (!Util.isNullOrNil(this.twt)) {
            this.EpH.setVisibility(0);
            this.EpH.setUrl(this.twt);
        } else if (!Util.isNullOrNil(this.EpE)) {
            this.EpH.setVisibility(0);
            this.iKs = BitmapUtil.decodeByteArray(this.EpE);
            this.EpH.setImageBitmap(this.iKs);
        } else {
            this.EpH.setVisibility(8);
        }
        r.b(this.EpH, this.gte);
        View view = this.sc;
        AppMethodBeat.o(97856);
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
        AppMethodBeat.i(97857);
        bf bfVar = new bf(17, this.gte);
        pInt.value = bfVar.beK;
        if (i4 > a.DCT) {
            bfVar.YF(2);
        }
        if (iVar != null) {
            bfVar.kl(iVar.token, iVar.Mte);
        }
        bfVar.aPB(this.title).aPz(this.EpL).aPA(this.link).aPw(str);
        boolean z2 = false;
        if (!Util.isNullOrNil(this.dRr)) {
            z2 = bfVar.a(s.aW(this.dRr, 0, -1), this.EpL, this.title, this.EpJ, this.EpK);
        } else if (!Util.isNullOrNil(this.twt) && q.bcQ() != null) {
            q.bcQ();
            Bitmap EP = d.EP(this.twt);
            if (EP != null) {
                z2 = bfVar.a(BitmapUtil.Bitmap2PngBytes(EP), this.EpL, this.title, this.EpJ, this.EpK);
            }
        }
        if (!z2) {
            Log.i("MicroMsg.EmojiDesignerShareWidget", "set userData user imgurl ");
            z2 = bfVar.c(this.twt, this.twt, this.EpL, this.EpJ, this.EpK);
        }
        if (!z2) {
            Log.e("MicroMsg.EmojiDesignerShareWidget", "set userData faild");
        }
        bfVar.ct(this.DPi, this.EpN);
        bfVar.YK(this.EpG);
        bfVar.aPE(this.eag);
        bfVar.aPF(this.EpF);
        bfVar.g(null, null, null, i5, i6);
        bfVar.YI(i2);
        if (z) {
            bfVar.YL(1);
        } else {
            bfVar.YL(0);
        }
        bfVar.gR(list2);
        if (!Util.isNullOrNil(this.appId)) {
            bfVar.aPC(this.appId);
            bfVar.aPD(this.appName);
        }
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
        bfVar.bq(linkedList2);
        bfVar.a(cjy);
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        aj.faK().eZn();
        this.gte.finish();
        ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amu(this.EpK);
        ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amv(this.EpK);
        AppMethodBeat.o(97857);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(97858);
        if (this.iKs != null && !this.iKs.isRecycled()) {
            this.iKs.recycle();
        }
        AppMethodBeat.o(97858);
        return false;
    }
}
