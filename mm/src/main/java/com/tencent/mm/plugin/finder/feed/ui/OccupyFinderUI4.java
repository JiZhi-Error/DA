package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020)H\u0002J*\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u00102\u001a\u00020.H\u0014J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020)H\u0002J\u0012\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010#\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fromOpenSdk", "", "getFromOpenSdk", "()Z", "setFromOpenSdk", "(Z)V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "tipsMask", "Landroid/view/View;", "getTipsMask", "()Landroid/view/View;", "setTipsMask", "(Landroid/view/View;)V", "wording", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "back", "", "checkPermission", "dealShare", "fallback", "errcode", "", "errMsg", "businessType", "appid", "getLayoutId", "hasExtStatusFlag", "flag", "", "initMaskView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTipsDialog", "showTipsToast", "plugin-finder_release"})
public final class OccupyFinderUI4 extends MMFinderUI {
    private final String TAG = "Finder.FinderSharePostUI";
    private boolean UJy;
    private HashMap _$_findViewCache;
    private String dQx;
    private DialogInterface.OnCancelListener kke;
    q loadingDialog;
    View ueH;
    public dxx ueI;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245740);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245740);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245739);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245739);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OccupyFinderUI4() {
        AppMethodBeat.i(245736);
        String string = MMApplicationContext.getContext().getString(R.string.a06);
        p.g(string, "MMApplicationContext.get…ing(R.string.app_waiting)");
        this.dQx = string;
        AppMethodBeat.o(245736);
    }

    public static final /* synthetic */ void a(OccupyFinderUI4 occupyFinderUI4) {
        AppMethodBeat.i(245737);
        occupyFinderUI4.back();
        AppMethodBeat.o(245737);
    }

    public final void setTipsMask(View view) {
        this.ueH = view;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        int i2;
        boolean z3 = false;
        AppMethodBeat.i(245733);
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        this.ueH = findViewById(R.id.fa4);
        TextView textView = (TextView) findViewById(R.id.clb);
        p.g(textView, "titleTv");
        com.tencent.mm.plugin.finder.utils.e.n(textView);
        TextView textView2 = (TextView) findViewById(R.id.cla);
        p.g(textView2, "okBtn");
        com.tencent.mm.plugin.finder.utils.e.n(textView2);
        textView2.setOnClickListener(new c(this));
        this.kke = new d(this);
        this.loadingDialog = q.a(getContext(), this.dQx, true, 0, this.kke);
        dxx dxx = new dxx();
        try {
            dxx.parseFrom(getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            dxx = null;
        }
        dxx dxx2 = dxx;
        if (dxx2 != null) {
            this.ueI = dxx2;
            dxx dxx3 = this.ueI;
            if (dxx3 == null) {
                p.btv("shareData");
            }
            dqh dqh = dxx3.MXA;
            if (dqh != null) {
                z = dqh.UJy;
            } else {
                z = false;
            }
            this.UJy = z;
            boolean showFinderEntry = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
            if ((z.aUd() & 34359738368L) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = !z2;
            y yVar = y.vXH;
            int dCL = y.dCL();
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            switch (com.tencent.mm.plugin.finder.storage.c.dsH().value().intValue()) {
                case 1:
                    i2 = dCL;
                    showFinderEntry = false;
                    break;
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = dCL;
                    z4 = false;
                    break;
                default:
                    i2 = dCL;
                    break;
            }
            if (!showFinderEntry) {
                IU(R.string.d9l);
            } else if (!z4) {
                com.tencent.mm.ac.d.h(new f(this));
            } else if (i2 == 1) {
                IU(R.string.d9o);
            } else {
                z3 = true;
            }
            if (z3) {
                com.tencent.mm.ac.d.i(new e(this));
                AppMethodBeat.o(245733);
                return;
            }
        } else {
            back();
        }
        AppMethodBeat.o(245733);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ OccupyFinderUI4 ueJ;

        d(OccupyFinderUI4 occupyFinderUI4) {
            this.ueJ = occupyFinderUI4;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(245729);
            OccupyFinderUI4.a(this.ueJ);
            AppMethodBeat.o(245729);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ OccupyFinderUI4 ueJ;

        c(OccupyFinderUI4 occupyFinderUI4) {
            this.ueJ = occupyFinderUI4;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245728);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            OccupyFinderUI4.a(this.ueJ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245728);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ak0;
    }

    private final void back() {
        AppMethodBeat.i(245734);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(245734);
    }

    private final void IU(int i2) {
        AppMethodBeat.i(245735);
        com.tencent.mm.ac.d.h(new g(this, i2));
        AppMethodBeat.o(245735);
    }

    private void e(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(260381);
        p.h(str, "errMsg");
        Log.i(this.TAG, "fallback errcode:" + i2 + ", " + str + ", " + str3);
        if (!this.UJy) {
            r rVar = r.vWn;
            r.e(i2, str, str2, str3);
        }
        AppMethodBeat.o(260381);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI4 ueJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(OccupyFinderUI4 occupyFinderUI4) {
            super(0);
            this.ueJ = occupyFinderUI4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245730);
            OccupyFinderUI4.b(this.ueJ);
            x xVar = x.SXb;
            AppMethodBeat.o(245730);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI4 ueJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(OccupyFinderUI4 occupyFinderUI4) {
            super(0);
            this.ueJ = occupyFinderUI4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245726);
            q qVar = this.ueJ.loadingDialog;
            if (qVar != null) {
                qVar.dismiss();
            }
            this.ueJ.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(245726);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI4 ueJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(OccupyFinderUI4 occupyFinderUI4) {
            super(0);
            this.ueJ = occupyFinderUI4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245731);
            q qVar = this.ueJ.loadingDialog;
            if (qVar != null) {
                qVar.dismiss();
            }
            View view = this.ueJ.ueH;
            if (view != null) {
                view.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245731);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI4 ueJ;
        final /* synthetic */ int ueQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(OccupyFinderUI4 occupyFinderUI4, int i2) {
            super(0);
            this.ueJ = occupyFinderUI4;
            this.ueQ = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245732);
            u.makeText(this.ueJ, this.ueQ, 0).show();
            OccupyFinderUI4.a(this.ueJ);
            x xVar = x.SXb;
            AppMethodBeat.o(245732);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int UJA;
        final /* synthetic */ String UJB;
        final /* synthetic */ String UJC;
        final /* synthetic */ z.a UJD;
        final /* synthetic */ z.f UJE;
        final /* synthetic */ String UJF;
        final /* synthetic */ String UJG;
        final /* synthetic */ String UJz;
        final /* synthetic */ String gZs;
        final /* synthetic */ OccupyFinderUI4 ueJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OccupyFinderUI4 occupyFinderUI4, String str, int i2, String str2, String str3, String str4, z.a aVar, z.f fVar, String str5, String str6) {
            super(0);
            this.ueJ = occupyFinderUI4;
            this.UJz = str;
            this.UJA = i2;
            this.UJB = str2;
            this.gZs = str3;
            this.UJC = str4;
            this.UJD = aVar;
            this.UJE = fVar;
            this.UJF = str5;
            this.UJG = str6;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260380);
            Intent intent = new Intent();
            intent.putExtra("postType", 4);
            intent.putExtra("KEY_POST_REMOTE_URL", this.UJz);
            intent.putExtra("KEY_POST_FROM_APPTYPE", this.UJA);
            intent.putExtra("KEY_POST_FROM_APP_PARAMJSON", this.UJB);
            intent.putExtra("key_finder_post_from", 8);
            dxx dxx = this.ueJ.ueI;
            if (dxx == null) {
                p.btv("shareData");
            }
            intent.putExtra("KEY_POST_FROM_SHARE", dxx.toByteArray());
            intent.putExtra("saveDesc", this.gZs);
            intent.putExtra("KEY_POST_EXTEND_URL", this.UJC);
            if (this.UJD.SYB) {
                intent.putExtra("isLongVideoPost", true);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.UJE.SYG);
            intent.putStringArrayListExtra("postMediaList", arrayList);
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(11, 8, 74, intent);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, "");
            Log.i(this.ueJ.TAG, "from:" + this.UJF);
            String str = this.UJF;
            r rVar = r.vWn;
            if (p.j(str, r.dCh())) {
                i iVar = i.vfo;
                if (i.dnX() != null) {
                    p.g(intent.putExtra("KEY_SHARE_VIDEO_SOURCE", 5), "intent.putExtra(Constant…EY_SHARE_VIDEO_SOURCE, 5)");
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(context, intent);
                    r rVar2 = r.vWn;
                    r.showToast("success, rawPath:" + this.UJG + ", path:" + s.k(this.UJE.SYG, false) + " url:" + this.UJz + ", fromApp:" + this.UJA);
                    this.ueJ.overridePendingTransition(0, 0);
                    OccupyFinderUI4.a(this.ueJ);
                    x xVar = x.SXb;
                    AppMethodBeat.o(260380);
                    return xVar;
                }
            }
            i iVar2 = i.vfo;
            i.as(8, false);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(context2, intent);
            r rVar22 = r.vWn;
            r.showToast("success, rawPath:" + this.UJG + ", path:" + s.k(this.UJE.SYG, false) + " url:" + this.UJz + ", fromApp:" + this.UJA);
            this.ueJ.overridePendingTransition(0, 0);
            OccupyFinderUI4.a(this.ueJ);
            x xVar2 = x.SXb;
            AppMethodBeat.o(260380);
            return xVar2;
        }
    }

    public static final /* synthetic */ void b(OccupyFinderUI4 occupyFinderUI4) {
        String str;
        String str2;
        String str3;
        i.a bxZ;
        boolean z;
        boolean z2;
        String str4;
        String str5;
        AppMethodBeat.i(245738);
        dxx dxx = occupyFinderUI4.ueI;
        if (dxx == null) {
            p.btv("shareData");
        }
        dqh dqh = dxx.MXA;
        if (dqh == null || (str5 = dqh.businessType) == null) {
            str = "";
        } else {
            str = str5;
        }
        p.g(str, "shareData.sdkPost?.businessType ?: \"\"");
        dxx dxx2 = occupyFinderUI4.ueI;
        if (dxx2 == null) {
            p.btv("shareData");
        }
        dqh dqh2 = dxx2.MXA;
        if (dqh2 == null || (str4 = dqh2.dNI) == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        p.g(str2, "shareData.sdkPost?.appid ?: \"\"");
        dxx dxx3 = occupyFinderUI4.ueI;
        if (dxx3 == null) {
            p.btv("shareData");
        }
        dqh dqh3 = dxx3.MXA;
        if (dqh3 == null || (str3 = dqh3.extInfo) == null) {
            str3 = "";
        }
        p.g(str3, "shareData.sdkPost?.extInfo ?: \"\"");
        try {
            JSONObject jSONObject = new JSONObject(str3);
            r rVar = r.vWn;
            String string = jSONObject.getString(r.dCc());
            r rVar2 = r.vWn;
            String string2 = jSONObject.getString(r.dCd());
            r rVar3 = r.vWn;
            int i2 = jSONObject.getInt(r.dCe());
            r rVar4 = r.vWn;
            String optString = jSONObject.optString(r.dCf());
            if (optString == null) {
                optString = "";
            }
            r rVar5 = r.vWn;
            String optString2 = jSONObject.optString(r.dCg(), "");
            r rVar6 = r.vWn;
            String optString3 = jSONObject.optString(r.hVu(), "");
            r rVar7 = r.vWn;
            String optString4 = jSONObject.optString(r.hVv(), "");
            boolean YS = s.YS(string);
            z.f fVar = new z.f();
            fVar.SYG = "";
            z.a aVar = new z.a();
            aVar.SYB = false;
            if (!YS) {
                occupyFinderUI4.e(-3, "file not exist", str, str2);
                occupyFinderUI4.back();
                AppMethodBeat.o(245738);
                return;
            }
            com.tencent.mm.plugin.finder.upload.i iVar = com.tencent.mm.plugin.finder.upload.i.vSX;
            p.g(string, "rawPath");
            p.h(string, "path");
            if (com.tencent.mm.plugin.finder.upload.i.ayX(string)) {
                bxZ = com.tencent.mm.plugin.finder.upload.i.bxY(string);
            } else {
                if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_album_get_video_info, 0) == 1) {
                    bxZ = com.tencent.mm.plugin.finder.upload.i.bxY(string);
                } else {
                    bxZ = com.tencent.mm.plugin.finder.upload.i.bxZ(string);
                }
            }
            if (occupyFinderUI4.UJy) {
                if (bxZ != null) {
                    com.tencent.mm.plugin.finder.upload.i iVar2 = com.tencent.mm.plugin.finder.upload.i.vSX;
                    OccupyFinderUI4 occupyFinderUI42 = occupyFinderUI4;
                    p.h(occupyFinderUI42, "context");
                    p.h(bxZ, "item");
                    if (!com.tencent.mm.plugin.finder.upload.i.gl(bxZ.videoWidth, bxZ.videoHeight)) {
                        h.cA(occupyFinderUI42, occupyFinderUI42.getString(R.string.dmz));
                        z2 = false;
                    } else {
                        boolean a2 = com.tencent.mm.plugin.finder.upload.i.a(bxZ);
                        if (!a2) {
                            r.f fVar2 = r.f.vhE;
                            r.f.ai(bxZ.jkQ, bxZ.jkR, bxZ.xiW);
                            h.cC(occupyFinderUI42, occupyFinderUI42.getString(R.string.dme));
                        }
                        z2 = a2;
                    }
                    if (z2) {
                        z = true;
                        if (occupyFinderUI4.UJy && !z) {
                            occupyFinderUI4.e(-5, "format invalid", str, str2);
                            occupyFinderUI4.back();
                            AppMethodBeat.o(245738);
                            return;
                        }
                    }
                }
                z = false;
                occupyFinderUI4.e(-5, "format invalid", str, str2);
                occupyFinderUI4.back();
                AppMethodBeat.o(245738);
                return;
            }
            MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(string);
            if (aTV != null) {
                aVar.SYB = aTV.duration > Util.MILLSECONDS_OF_MINUTE;
                Log.i(occupyFinderUI4.TAG, "isLongVideo, " + aTV.duration);
            }
            al alVar = al.waC;
            fVar.SYG = (T) al.am("share", MD5Util.getMD5String(string) + System.currentTimeMillis(), "");
            s.nw(string, fVar.SYG);
            if (!Util.isNullOrNil((String) fVar.SYG) || !s.YS(fVar.SYG)) {
                com.tencent.mm.ac.d.h(new b(occupyFinderUI4, string2, i2, optString, optString3, optString4, aVar, fVar, optString2, string));
                AppMethodBeat.o(245738);
                return;
            }
            occupyFinderUI4.e(-4, "file copy failed", str, str2);
            occupyFinderUI4.back();
            AppMethodBeat.o(245738);
        } catch (JSONException e2) {
            occupyFinderUI4.e(-2, "extInfo json invalid", str, str2);
            occupyFinderUI4.back();
            AppMethodBeat.o(245738);
        } catch (Throwable th) {
            occupyFinderUI4.e(-100, "other exception", str, str2);
            occupyFinderUI4.back();
            Log.printErrStackTrace(occupyFinderUI4.TAG, th, "", new Object[0]);
            AppMethodBeat.o(245738);
        }
    }
}
