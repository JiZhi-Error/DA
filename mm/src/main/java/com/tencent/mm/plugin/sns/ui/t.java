package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.b.d.i;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0001\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000e2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u000eH\u0016J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u000eH\u0016J\u0012\u00104\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u00020\u000bH\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\"\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0018\u0010=\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "Lcom/tencent/mm/plugin/sns/ui/IWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "appId", "", "appName", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "layout", "Landroid/view/View;", "mSessionId", "needReport", "", "publisherId", "snsType", "", "getSnsType", "()I", "thumb", "Landroid/widget/ImageView;", "title", "beforeCommit", "checkLocation", "commit", "isPrivated", "syncFlag", "token", "Lorg/scribe/model/Token;", "desc", "withList", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/Location;", "groupList", "Ljava/util/LinkedList;", "", "parseterLen", "isBlackGroup", "groupUser", "pContentType", "Lcom/tencent/mm/pointers/PInt;", "canvasInfo", "ContactTagCount", "TempUserCount", "enableNext", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleronDestroy", "hanlerOnSave", "outState", "initView", "needAutoDraft", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "plugin-sns_release"})
public class t implements ad {
    private d EpQ;
    private final int FdB = 34;
    private String appId;
    private String appName;
    private String eam;
    private MMActivity gte;
    private ImageView mEx;
    private String mSessionId;
    private View sc;
    private boolean thE;
    private String title = "";

    /* access modifiers changed from: protected */
    public int hWM() {
        return this.FdB;
    }

    public t(MMActivity mMActivity) {
        p.h(mMActivity, "context");
        AppMethodBeat.i(201815);
        this.gte = mMActivity;
        AppMethodBeat.o(201815);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return this.EpQ != null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        boolean z;
        AppMethodBeat.i(201812);
        MMActivity mMActivity = this.gte;
        if (mMActivity == null) {
            p.btv("context");
        }
        View inflate = aa.jQ(mMActivity).inflate(R.layout.bvs, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…s_finder_live_item, null)");
        this.sc = inflate;
        View view = this.sc;
        if (view == null) {
            p.btv("layout");
        }
        this.mEx = (ImageView) view.findViewById(R.id.hy3);
        if (this.EpQ != null) {
            d dVar = this.EpQ;
            if (dVar == null) {
                p.hyc();
            }
            if (dVar.jlf != null) {
                d dVar2 = this.EpQ;
                if (dVar2 == null) {
                    p.hyc();
                }
                axf axf = dVar2.jlf;
                MMActivity mMActivity2 = this.gte;
                if (mMActivity2 == null) {
                    p.btv("context");
                }
                int[] ha = ap.ha(mMActivity2);
                int i2 = ha[0];
                int i3 = ha[1];
                MMActivity mMActivity3 = this.gte;
                if (mMActivity3 == null) {
                    p.btv("context");
                }
                Pair<Integer, Integer> a2 = n.a(i2, i3, mMActivity3, false);
                Integer num = (Integer) a2.first;
                p.g(num, "smallSide");
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(num.intValue(), (int) ((((Number) a2.first).floatValue() * 3.5f) / 3.0f));
                View view2 = this.sc;
                if (view2 == null) {
                    p.btv("layout");
                }
                view2.setLayoutParams(layoutParams);
                View view3 = this.sc;
                if (view3 == null) {
                    p.btv("layout");
                }
                view3.requestLayout();
                String str = "";
                String str2 = axf.coverUrl;
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = axf.coverUrl;
                    p.g(str3, "shareObject.coverUrl");
                    str = str3;
                } else {
                    String str4 = axf.headUrl;
                    if (str4 == null || str4.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        String str5 = axf.headUrl;
                        p.g(str5, "shareObject.headUrl");
                        str = str5;
                    }
                }
                ((aj) g.ah(aj.class)).loadImage(str, this.mEx);
            }
        }
        View view4 = this.sc;
        if (view4 == null) {
            p.btv("layout");
        }
        AppMethodBeat.o(201812);
        return view4;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(201813);
        MMActivity mMActivity = this.gte;
        if (mMActivity == null) {
            p.btv("context");
        }
        if (mMActivity == null) {
            p.hyc();
        }
        String nullAs = Util.nullAs(mMActivity.getIntent().getStringExtra("Ksnsupload_title"), "");
        p.g(nullAs, "Util.nullAs(context!!.in…dUI.KSnsUploadTitle), \"\")");
        this.title = nullAs;
        MMActivity mMActivity2 = this.gte;
        if (mMActivity2 == null) {
            p.btv("context");
        }
        this.eam = Util.nullAs(mMActivity2.getIntent().getStringExtra("KPublisherId"), "");
        MMActivity mMActivity3 = this.gte;
        if (mMActivity3 == null) {
            p.btv("context");
        }
        this.mSessionId = Util.nullAs(mMActivity3.getIntent().getStringExtra("reportSessionId"), "");
        MMActivity mMActivity4 = this.gte;
        if (mMActivity4 == null) {
            p.btv("context");
        }
        this.appId = Util.nullAs(mMActivity4.getIntent().getStringExtra("Ksnsupload_appid"), "");
        MMActivity mMActivity5 = this.gte;
        if (mMActivity5 == null) {
            p.btv("context");
        }
        this.appName = Util.nullAs(mMActivity5.getIntent().getStringExtra("Ksnsupload_appname"), "");
        MMActivity mMActivity6 = this.gte;
        if (mMActivity6 == null) {
            p.btv("context");
        }
        this.thE = mMActivity6.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
        e eVar = e.DUQ;
        MMActivity mMActivity7 = this.gte;
        if (mMActivity7 == null) {
            p.btv("context");
        }
        eVar.Aqq = mMActivity7.getIntent().getLongExtra("finder_feed_id", 0);
        MMActivity mMActivity8 = this.gte;
        if (mMActivity8 == null) {
            p.btv("context");
        }
        String stringExtra = mMActivity8.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil(stringExtra) && (parseXml = XmlParser.parseXml(stringExtra, "finderLive", null)) != null) {
            this.EpQ = new d();
            d dVar = this.EpQ;
            if (dVar == null) {
                p.hyc();
            }
            dVar.j("", parseXml);
        }
        AppMethodBeat.o(201813);
    }

    /* access modifiers changed from: protected */
    public void a(MMActivity mMActivity, bf bfVar) {
        AppMethodBeat.i(259405);
        p.h(mMActivity, "context");
        p.h(bfVar, "packHelper");
        AppMethodBeat.o(259405);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        AppMethodBeat.i(201814);
        int hWM = hWM();
        MMActivity mMActivity = this.gte;
        if (mMActivity == null) {
            p.btv("context");
        }
        bf bfVar = new bf(hWM, mMActivity);
        if (this.EpQ != null) {
            bfVar.a(this.EpQ);
        }
        if (pInt == null) {
            p.hyc();
        }
        pInt.value = bfVar.getContentType();
        if (i4 > a.DCT) {
            bfVar.YF(4);
        }
        bfVar.aPB(this.title).aPw(str);
        MMActivity mMActivity2 = this.gte;
        if (mMActivity2 == null) {
            p.btv("context");
        }
        if (mMActivity2 == null) {
            p.hyc();
        }
        bfVar.aPz(Util.nullAs(mMActivity2.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
        bfVar.fbU().YI(i2);
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
        MMActivity mMActivity3 = this.gte;
        if (mMActivity3 == null) {
            p.btv("context");
        }
        a(mMActivity3, bfVar);
        int commit = bfVar.commit();
        if (this.thE) {
            e.DUQ.DVC = commit;
        }
        com.tencent.mm.plugin.sns.model.aj.faK().eZn();
        MMActivity mMActivity4 = this.gte;
        if (mMActivity4 == null) {
            p.btv("context");
        }
        mMActivity4.finish();
        AppMethodBeat.o(201814);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
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
    public final boolean ffE() {
        return false;
    }
}
