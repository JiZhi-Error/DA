package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class bp implements ad {
    private int DPi = 1;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private String appName = "";
    private String dNI = "";
    private MMActivity gte;
    private String trj = "";

    public bp(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(99715);
        this.EpM = k.w(this.gte.getIntent());
        this.trj = this.gte.getIntent().getStringExtra("Kdescription");
        this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(99715);
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
        AppMethodBeat.i(99716);
        if (this.Erq != null) {
            this.Erq.description = str;
            if (this.Erq.mediaObject != null && (this.Erq.mediaObject instanceof WXTextObject)) {
                ((WXTextObject) this.Erq.mediaObject).text = str;
            }
        }
        aj.faK();
        bf c2 = be.c(this.Erq, str, this.dNI, this.appName);
        if (c2 == null) {
            Log.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", this.dNI, this.appName);
            AppMethodBeat.o(99716);
            return false;
        }
        pInt.value = c2.beK;
        if (i4 > a.DCT) {
            c2.YF(4);
        }
        c2.YK(this.EpG);
        if (this.Ero) {
            c2.YK(5);
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
        c2.bq(linkedList2);
        if (iVar != null) {
            c2.kl(iVar.token, iVar.Mte);
        }
        c2.a(cjy);
        if (z) {
            c2.YL(1);
        } else {
            c2.YL(0);
        }
        c2.gR(list2).YI(i2);
        c2.g(null, null, null, i5, i6);
        c2.ct(this.DPi, this.EpN);
        if (this.Erp && this.Erq != null) {
            c2.aPx(this.Erq.mediaTagName);
            c2.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
        }
        int commit = c2.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(99716);
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
