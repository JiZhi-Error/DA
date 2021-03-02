package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.b.d.i;

public final class u implements ad {
    private static e Aer;
    private static int EpR = -1;
    private static int EpS = 0;
    private static int EpT = 1;
    private IListener DLK = new IListener<ia>() {
        /* class com.tencent.mm.plugin.sns.ui.u.AnonymousClass1 */

        {
            AppMethodBeat.i(203234);
            this.__eventId = ia.class.getName().hashCode();
            AppMethodBeat.o(203234);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ia iaVar) {
            AppMethodBeat.i(203235);
            ia iaVar2 = iaVar;
            if (!(iaVar2 == null || iaVar2.dMC == null || iaVar2.dMC.localId <= 0 || u.this.EpW == null || u.this.EpW.jlg == null || u.this.EpW.jlg.localId != iaVar2.dMC.localId)) {
                if (!iaVar2.dMC.dMD || iaVar2.dMC.dME == null) {
                    u.this.EpX = u.EpT;
                } else {
                    u.this.EpW.jlg = iaVar2.dMC.dME;
                    com.tencent.mm.plugin.sns.k.e.DUQ.DVE.ql(u.this.EpW.jlg.objectId);
                    u.this.EpX = u.EpS;
                }
            }
            AppMethodBeat.o(203235);
            return false;
        }
    };
    private ImageView EpU = null;
    private ImageIndicatorView EpV = null;
    private com.tencent.mm.modelsns.e EpW = null;
    private int EpX = EpR;
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
        AppMethodBeat.i(203245);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        Aer = aVar.aJT();
        AppMethodBeat.o(203245);
    }

    public u(MMActivity mMActivity) {
        AppMethodBeat.i(203237);
        this.gte = mMActivity;
        AppMethodBeat.o(203237);
    }

    /* access modifiers changed from: package-private */
    public final boolean ffF() {
        AppMethodBeat.i(203238);
        boolean z = false;
        if (this.EpW != null && this.EpW.jlg != null && this.EpW.jlg.localId > 0 && r.aOw(this.EpW.jlg.objectId) <= 0 && Util.isNullOrNil(this.EpW.jlg.objectNonceId)) {
            z = true;
        }
        AppMethodBeat.o(203238);
        return z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(203239);
        this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.thE = this.gte.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
        int intExtra = this.gte.getIntent().getIntExtra("finder_post_from_sns_type", 3);
        com.tencent.mm.plugin.sns.k.e.DUQ.Aqq = this.gte.getIntent().getLongExtra("finder_feed_id", 0);
        String stringExtra = this.gte.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!Util.isNullOrNil(stringExtra) && (parseXml = XmlParser.parseXml(stringExtra, "finderFeed", null)) != null) {
            this.EpW = new com.tencent.mm.modelsns.e();
            this.EpW.j("", parseXml);
        }
        String eZx = r.eZx();
        com.tencent.mm.plugin.sns.k.e.DUQ.DVE.evg = (long) intExtra;
        dz dzVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVE;
        dzVar.eBX = dzVar.x("MonmentSessionId", eZx, true);
        if (!(this.EpW == null || this.EpW.jlg == null)) {
            com.tencent.mm.plugin.sns.k.e.DUQ.DVE.ql(this.EpW.jlg.objectId);
        }
        EventCenter.instance.addListener(this.DLK);
        AppMethodBeat.o(203239);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return this.EpW != null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        AppMethodBeat.i(203240);
        this.sc = aa.jQ(this.gte).inflate(R.layout.bvu, (ViewGroup) null);
        this.mEx = (ImageView) this.sc.findViewById(R.id.hy3);
        this.EpU = (ImageView) this.sc.findViewById(R.id.hy2);
        this.EpV = (ImageIndicatorView) this.sc.findViewById(R.id.hy0);
        if (!(this.EpW == null || this.EpW.jlg == null)) {
            bcj bcj = this.EpW.jlg;
            if (!Util.isNullOrNil(bcj.mediaList)) {
                bch bch = bcj.mediaList.get(0);
                if (bcj.vXJ == 4) {
                    Pair<Integer, Integer> a2 = n.a((int) bch.width, (int) bch.height, this.gte, false);
                    this.sc.setLayoutParams(new ViewGroup.LayoutParams(((Integer) a2.first).intValue(), ((Integer) a2.second).intValue()));
                    this.sc.requestLayout();
                } else {
                    Pair<Integer, Integer> a3 = n.a((int) bch.width, (int) bch.height, this.gte);
                    this.sc.setLayoutParams(new ViewGroup.LayoutParams(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue()));
                    this.sc.requestLayout();
                }
                ((aj) g.ah(aj.class)).loadImage(bch.thumbUrl, this.mEx);
            }
            if (bcj.vXJ == 4) {
                this.EpU.setVisibility(0);
                this.EpV.setVisibility(8);
            } else {
                this.EpU.setVisibility(8);
                this.EpV.setVisibility(8);
                this.EpV.FdA = bcj.dJl;
            }
            this.sc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.u.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203236);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    u.b(u.this);
                    a.a(this, "com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203236);
                }
            });
        }
        View view = this.sc;
        AppMethodBeat.o(203240);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        AppMethodBeat.i(203241);
        bf bfVar = new bf(28, this.gte);
        if (this.EpW != null) {
            bfVar.a(this.EpW);
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
        if (ffF()) {
            if (this.EpX == EpR) {
                if (bfVar.DPf != null) {
                    bfVar.DPf.setPostHolding();
                }
            } else if (this.EpX == EpT && bfVar.DPf != null) {
                bfVar.DPf.setItemDie();
            }
        }
        int commit = bfVar.commit();
        if (this.EpX == EpT) {
            com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1;
            com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
            com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
        } else {
            com.tencent.mm.plugin.sns.k.e.DUQ.DVD = commit;
        }
        if (this.thE) {
            com.tencent.mm.plugin.sns.k.e.DUQ.DVC = commit;
        }
        com.tencent.mm.plugin.sns.model.aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(203241);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(203242);
        EventCenter.instance.removeListener(this.DLK);
        AppMethodBeat.o(203242);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        AppMethodBeat.i(203243);
        boolean ffF = ffF();
        AppMethodBeat.o(203243);
        return ffF;
    }

    static /* synthetic */ void b(u uVar) {
        AppMethodBeat.i(203244);
        if (!(uVar.EpW == null || uVar.EpW.jlg == null)) {
            long aOw = r.aOw(uVar.EpW.jlg.objectId);
            long j2 = uVar.EpW.jlg.localId;
            if (!(aOw == 0 && j2 == 0)) {
                Intent intent = new Intent();
                intent.putExtra("report_scene", 3);
                intent.putExtra("from_user", uVar.EpW.jlg.username);
                intent.putExtra("feed_object_id", aOw);
                intent.putExtra("business_type", 0);
                intent.putExtra("finder_user_name", uVar.EpW.jlg.username);
                intent.putExtra("feed_object_nonceId", uVar.EpW.jlg.objectNonceId);
                intent.putExtra("key_from_user_name", uVar.EpW.jlg.username);
                intent.putExtra("tab_type", 5);
                intent.putExtra("feed_local_id", j2);
                if (aOw == 0 && j2 != 0) {
                    intent.putExtra("key_posting_scene", true);
                }
                ((aj) g.ah(aj.class)).fillContextIdToIntent(4, 2, 25, intent);
                ((aj) g.ah(aj.class)).enterFinderShareFeedUI(uVar.gte, intent);
            }
        }
        AppMethodBeat.o(203244);
    }
}
