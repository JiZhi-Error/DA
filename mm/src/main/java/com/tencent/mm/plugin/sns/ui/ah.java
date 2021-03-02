package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.b.d.i;

public final class ah implements ad {
    private static e Aer;
    private ImageView EpU = null;
    private ImageIndicatorView EpV = null;
    private g ErO = null;
    private String appId;
    private String appName;
    private String eam;
    private MMActivity gte = null;
    private ImageView mEx = null;
    private String mSessionId;
    private View sc = null;
    private boolean thE;
    private String title = "";

    static {
        AppMethodBeat.i(203309);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        Aer = aVar.aJT();
        AppMethodBeat.o(203309);
    }

    public ah(MMActivity mMActivity) {
        this.gte = mMActivity;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(203305);
        this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.thE = this.gte.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
        com.tencent.mm.plugin.sns.k.e.DUQ.Aqq = this.gte.getIntent().getLongExtra("finder_feed_id", 0);
        String stringExtra = this.gte.getIntent().getStringExtra("ksnsupload_mega_video_object_xml");
        if (!Util.isNullOrNil(stringExtra) && (parseXml = XmlParser.parseXml(stringExtra, "finderMegaVideo", null)) != null) {
            this.ErO = new g();
            this.ErO.j("", parseXml);
        }
        AppMethodBeat.o(203305);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return this.ErO != null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        AppMethodBeat.i(203306);
        this.sc = aa.jQ(this.gte).inflate(R.layout.bvu, (ViewGroup) null);
        this.mEx = (ImageView) this.sc.findViewById(R.id.hy3);
        this.EpU = (ImageView) this.sc.findViewById(R.id.hy2);
        this.EpV = (ImageIndicatorView) this.sc.findViewById(R.id.hy0);
        if (!(this.ErO == null || this.ErO.jlh == null)) {
            col col = this.ErO.jlh;
            if (!Util.isNullOrNil(col.mediaList)) {
                cok cok = col.mediaList.get(0);
                Pair<Integer, Integer> a2 = n.a((int) cok.width, (int) cok.height, this.gte, false);
                this.sc.setLayoutParams(new ViewGroup.LayoutParams(((Integer) a2.first).intValue(), ((Integer) a2.second).intValue()));
                this.sc.requestLayout();
                if (!TextUtils.isEmpty(cok.coverUrl)) {
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(cok.coverUrl, this.mEx);
                } else {
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(cok.thumbUrl, this.mEx);
                }
            }
            this.EpU.setVisibility(0);
            this.EpV.setVisibility(8);
            this.sc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.ah.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203304);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/ui/MegaVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ah.a(ah.this);
                    a.a(this, "com/tencent/mm/plugin/sns/ui/MegaVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203304);
                }
            });
        }
        View view = this.sc;
        AppMethodBeat.o(203306);
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
        AppMethodBeat.i(203307);
        bf bfVar = new bf(36, this.gte);
        if (this.ErO != null) {
            bfVar.a(this.ErO);
        }
        pInt.value = bfVar.beK;
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            bfVar.YF(4);
        }
        bfVar.aPB(this.title).aPw(str);
        bfVar.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
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
        bfVar.a(cjy);
        bfVar.aPy(str2);
        bfVar.aPH(this.eam);
        bfVar.setSessionId(this.mSessionId);
        int commit = bfVar.commit();
        if (this.thE) {
            com.tencent.mm.plugin.sns.k.e.DUQ.DVC = commit;
        }
        com.tencent.mm.plugin.sns.model.aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(203307);
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

    static /* synthetic */ void a(ah ahVar) {
        AppMethodBeat.i(203308);
        if (!(ahVar.ErO == null || ahVar.ErO.jlh == null)) {
            long aOw = r.aOw(ahVar.ErO.jlh.objectId);
            if (aOw != 0) {
                Intent intent = new Intent();
                intent.putExtra("report_scene", 3);
                intent.putExtra("from_user", ahVar.ErO.jlh.username);
                intent.putExtra("feed_object_id", aOw);
                intent.putExtra("business_type", 1);
                intent.putExtra("finder_user_name", ahVar.ErO.jlh.username);
                intent.putExtra("feed_object_nonceId", ahVar.ErO.jlh.objectNonceId);
                intent.putExtra("key_from_user_name", ahVar.ErO.jlh.username);
                intent.putExtra("tab_type", 5);
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(4, 2, 25, intent);
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(ahVar.gte, intent);
            }
        }
        AppMethodBeat.o(203308);
    }
}
