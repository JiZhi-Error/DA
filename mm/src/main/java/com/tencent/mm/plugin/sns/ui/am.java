package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class am implements ad {
    private int DPi = 1;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private boolean Etx = false;
    private String appName = "";
    private String dNI = "";
    private MMActivity gte;
    private String trj = "";

    public am(MMActivity mMActivity, boolean z) {
        this.gte = mMActivity;
        this.Etx = z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(98011);
        this.EpM = k.w(this.gte.getIntent());
        this.trj = this.gte.getIntent().getStringExtra("Kdescription");
        this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.Erq = new SendMessageToWX.Req(bundleExtra).message;
        }
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(98011);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return this.Etx;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        return null;
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
        AppMethodBeat.i(98012);
        if (this.gte.isFinishing()) {
            AppMethodBeat.o(98012);
            return false;
        }
        bf bfVar = new bf(2, this.gte);
        pInt.value = bfVar.beK;
        if (i4 > a.DCT) {
            bfVar.YF(2);
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
        if (z) {
            bfVar.YL(1);
        } else {
            bfVar.YL(0);
        }
        if (iVar != null) {
            bfVar.kl(iVar.token, iVar.Mte);
        }
        bfVar.YK(this.EpG);
        if (this.Ero) {
            bfVar.YK(5);
        }
        if (this.Erp && this.Erq != null) {
            bfVar.aPx(this.Erq.mediaTagName);
            bfVar.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
        }
        bfVar.ct(this.DPi, this.EpN);
        bfVar.g(null, null, null, i5, i6);
        bfVar.aPw(str).a(cjy).bq(linkedList2).YI(i2).YJ(i3).gR(list2);
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        this.gte.setResult(-1);
        aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(98012);
        return true;
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
