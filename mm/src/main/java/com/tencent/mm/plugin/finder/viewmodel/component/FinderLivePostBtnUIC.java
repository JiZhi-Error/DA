package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.g;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\"H\u0002J\u0006\u00106\u001a\u00020\"J\b\u00107\u001a\u00020\"H\u0016J,\u00108\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\"H\u0016J\b\u0010;\u001a\u00020\"H\u0002J\u001c\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016Rz\u0010\u0019\u001ab\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "TAG", "", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "getLivePostHelper", "()Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "livePostHelper$delegate", "Lkotlin/Lazy;", "onNoticeOpSceneEndCallBack", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "scene", "", "getOnNoticeOpSceneEndCallBack", "()Lkotlin/jvm/functions/Function4;", "setOnNoticeOpSceneEndCallBack", "(Lkotlin/jvm/functions/Function4;)V", "reportReport", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportReport", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportReport$delegate", "doCreateFinderNotice", "startTime", "doDelFinderNotice", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "handleLiveMenuItemSelected", "menuId", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "onCreateLiveNote", "onLivePostBtnClick", "onResume", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "showLiveBottomSheet", "showOrDimissLoading", "show", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-finder_release"})
public final class FinderLivePostBtnUIC extends UIComponent implements i {
    private final String TAG = "FinderLivePostUIC";
    private q nUq;
    private final int wyj = 10001;
    private final int wyk = 10002;
    private com.tencent.mm.ui.widget.a.e wyl;
    private final kotlin.f wym = kotlin.g.ah(new d(this));
    public r<? super Integer, ? super Integer, ? super String, ? super au, x> wyn;
    private final kotlin.f wyo = kotlin.g.ah(new a(this));

    public final com.tencent.mm.plugin.finder.ui.g dIm() {
        AppMethodBeat.i(255770);
        com.tencent.mm.plugin.finder.ui.g gVar = (com.tencent.mm.plugin.finder.ui.g) this.wyo.getValue();
        AppMethodBeat.o(255770);
        return gVar;
    }

    public static final /* synthetic */ void a(FinderLivePostBtnUIC finderLivePostBtnUIC, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(255780);
        finderLivePostBtnUIC.a(true, onCancelListener);
        AppMethodBeat.o(255780);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLivePostBtnUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255778);
        AppMethodBeat.o(255778);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255771);
        super.onResume();
        com.tencent.mm.kernel.g.azz().a(6653, this);
        a(false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(255771);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(255772);
        super.onStop();
        com.tencent.mm.kernel.g.azz().b(6653, this);
        AppMethodBeat.o(255772);
    }

    public final void dIn() {
        AppMethodBeat.i(255773);
        y yVar = y.vXH;
        if (y.bE(getActivity())) {
            y yVar2 = y.vXH;
            if (y.dCL() == 2) {
                Log.i(this.TAG, "[onLivePostBtnClick] USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
                Intent intent = new Intent();
                intent.putExtra("key_create_scene", 3);
                intent.putExtra("scene", 2);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.w(getActivity(), intent);
                AppMethodBeat.o(255773);
                return;
            }
            Log.i(this.TAG, "FinderLive.entrance,live btn click!");
            if (NetStatusUtil.isConnected(getActivity())) {
                com.tencent.mm.plugin.finder.ui.g dIm = dIm();
                if (dIm != null) {
                    dIm.dzD();
                }
                dIo();
                AppMethodBeat.o(255773);
                return;
            }
            new f.a(getActivity()).hbu().bow(getActivity().getResources().getString(R.string.ct_)).boA(getActivity().getResources().getString(R.string.w0)).b(c.wyu).show();
            AppMethodBeat.o(255773);
            return;
        }
        Log.i(this.TAG, "[onLivePostBtnClick] checkHasRealname false");
        AppMethodBeat.o(255773);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class c implements f.c {
        public static final c wyu = new c();

        static {
            AppMethodBeat.i(255764);
            AppMethodBeat.o(255764);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    private final void dIo() {
        AppMethodBeat.i(255774);
        this.wyl = new com.tencent.mm.ui.widget.a.e((Context) getActivity(), 1, false);
        com.tencent.mm.ui.widget.a.e eVar = this.wyl;
        if (eVar != null) {
            eVar.a(new e(this));
        }
        com.tencent.mm.ui.widget.a.e eVar2 = this.wyl;
        if (eVar2 != null) {
            eVar2.a(new f(this));
        }
        com.tencent.mm.ui.widget.a.e eVar3 = this.wyl;
        if (eVar3 != null) {
            eVar3.b(new g(this));
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.wyl;
        if (eVar4 != null) {
            eVar4.dGm();
            AppMethodBeat.o(255774);
            return;
        }
        AppMethodBeat.o(255774);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class e implements o.f {
        final /* synthetic */ FinderLivePostBtnUIC wyp;

        e(FinderLivePostBtnUIC finderLivePostBtnUIC) {
            this.wyp = finderLivePostBtnUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(255766);
            StringBuilder sb = new StringBuilder("live bottom sheet:");
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(this.wyp.wyj, R.string.cko);
                sb.append(this.wyp.getString(R.string.cko) + ',');
                mVar.kV(this.wyp.wyk, R.string.ckp);
                sb.append(String.valueOf(this.wyp.getString(R.string.ckp)));
            }
            Log.i(this.wyp.TAG, String.valueOf(sb.toString()));
            AppMethodBeat.o(255766);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class f implements o.g {
        final /* synthetic */ FinderLivePostBtnUIC wyp;

        f(FinderLivePostBtnUIC finderLivePostBtnUIC) {
            this.wyp = finderLivePostBtnUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            aqb aqb;
            AppMethodBeat.i(255768);
            com.tencent.mm.plugin.finder.ui.g dIm = this.wyp.dIm();
            if (dIm != null) {
                aqb = dIm.vKV;
            } else {
                aqb = null;
            }
            com.tencent.mm.plugin.finder.ui.g dIm2 = this.wyp.dIm();
            if (dIm2 != null) {
                p.g(menuItem, "menuItem");
                dIm2.ks = menuItem.getItemId();
            }
            if (aqb != null) {
                FinderLivePostBtnUIC finderLivePostBtnUIC = this.wyp;
                p.g(menuItem, "menuItem");
                FinderLivePostBtnUIC.a(finderLivePostBtnUIC, menuItem.getItemId(), aqb);
                AppMethodBeat.o(255768);
                return;
            }
            FinderLivePostBtnUIC.a(this.wyp, new DialogInterface.OnCancelListener(this) {
                /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC.f.AnonymousClass1 */
                final /* synthetic */ f wyv;

                {
                    this.wyv = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(255767);
                    com.tencent.mm.plugin.finder.ui.g dIm = this.wyv.wyp.dIm();
                    if (dIm != null) {
                        dIm.dzE();
                        AppMethodBeat.o(255767);
                        return;
                    }
                    AppMethodBeat.o(255767);
                }
            });
            AppMethodBeat.o(255768);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class g implements e.b {
        final /* synthetic */ FinderLivePostBtnUIC wyp;

        g(FinderLivePostBtnUIC finderLivePostBtnUIC) {
            this.wyp = finderLivePostBtnUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(255769);
            com.tencent.mm.plugin.finder.ui.g dIm = this.wyp.dIm();
            if (dIm != null) {
                dIm.dzE();
                AppMethodBeat.o(255769);
                return;
            }
            AppMethodBeat.o(255769);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        au auVar = null;
        AppMethodBeat.i(255775);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        a(false, (DialogInterface.OnCancelListener) null);
        r<? super Integer, ? super Integer, ? super String, ? super au, x> rVar = this.wyn;
        if (rVar != null) {
            Integer valueOf = Integer.valueOf(i2);
            Integer valueOf2 = Integer.valueOf(i3);
            if (qVar instanceof au) {
                auVar = qVar;
            }
            rVar.invoke(valueOf, valueOf2, str, auVar);
            AppMethodBeat.o(255775);
            return;
        }
        AppMethodBeat.o(255775);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "hasSetResult", "", "result", "", "kotlin.jvm.PlatformType", "secondResult", "thirdResult", "onResult"})
    public static final class b<T> implements c.a<Object> {
        final /* synthetic */ FinderLivePostBtnUIC wyp;
        final /* synthetic */ com.tencent.mm.ui.widget.picker.c wys;
        final /* synthetic */ z.f wyt;

        b(FinderLivePostBtnUIC finderLivePostBtnUIC, com.tencent.mm.ui.widget.picker.c cVar, z.f fVar) {
            this.wyp = finderLivePostBtnUIC;
            this.wys = cVar;
            this.wyt = fVar;
        }

        @Override // com.tencent.mm.ui.widget.picker.c.a
        public final void a(boolean z, Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(255763);
            this.wys.hide();
            if (z) {
                try {
                    A a2 = this.wyt.SYG.first;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(255763);
                        throw tVar;
                    }
                    int a3 = j.a((List) a2, (Object) ((CharSequence) obj));
                    Object obj4 = this.wyt.SYG.second.get(a3);
                    p.g(obj4, "triple.second[firstChosenIndex]");
                    List list = (List) obj4;
                    if (obj2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(255763);
                        throw tVar2;
                    }
                    int a4 = j.a(list, (Object) ((CharSequence) obj2));
                    Object obj5 = this.wyt.SYG.SWY.get(a4);
                    p.g(obj5, "triple.third[secChosenIndex]");
                    List list2 = (List) obj5;
                    if (obj3 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(255763);
                        throw tVar3;
                    }
                    int a5 = j.a(list2, (Object) ((CharSequence) obj3));
                    y yVar = y.vXH;
                    Date date = new Date(y.dCO());
                    Calendar instance = Calendar.getInstance();
                    p.g(instance, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                    instance.setTime(date);
                    instance.set(5, instance.get(5) + a3);
                    instance.set(11, (24 - ((List) this.wyt.SYG.second.get(a3)).size()) + a4);
                    instance.set(12, ((12 - ((List) this.wyt.SYG.SWY.get(a4)).size()) + a5) * 5);
                    instance.set(13, 0);
                    Log.i(this.wyp.TAG, "chosen time:" + instance.getTime() + ",timeInMills:" + instance.getTimeInMillis());
                    FinderLivePostBtnUIC.a(this.wyp, true);
                    FinderLivePostBtnUIC.a(this.wyp, (int) (instance.getTimeInMillis() / 1000));
                    AppMethodBeat.o(255763);
                    return;
                } catch (Throwable th) {
                    Log.i(this.wyp.TAG, th.getMessage());
                }
            }
            AppMethodBeat.o(255763);
        }
    }

    static /* synthetic */ void a(FinderLivePostBtnUIC finderLivePostBtnUIC, boolean z) {
        AppMethodBeat.i(255777);
        finderLivePostBtnUIC.a(z, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(255777);
    }

    private final void a(boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(255776);
        if (!z) {
            q qVar = this.nUq;
            if (qVar != null) {
                qVar.dismiss();
                AppMethodBeat.o(255776);
                return;
            }
            AppMethodBeat.o(255776);
        } else if (this.nUq == null) {
            this.nUq = q.a(getActivity(), getActivity().getString(R.string.dbf), true, 2, onCancelListener);
            AppMethodBeat.o(255776);
        } else {
            q qVar2 = this.nUq;
            if (qVar2 != null) {
                if (!qVar2.isShowing()) {
                    q qVar3 = this.nUq;
                    if (qVar3 != null) {
                        qVar3.setOnCancelListener(onCancelListener);
                    }
                    q qVar4 = this.nUq;
                    if (qVar4 != null) {
                        qVar4.show();
                        AppMethodBeat.o(255776);
                        return;
                    }
                }
                AppMethodBeat.o(255776);
                return;
            }
            AppMethodBeat.o(255776);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ FinderLivePostBtnUIC wyp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLivePostBtnUIC finderLivePostBtnUIC) {
            super(0);
            this.wyp = finderLivePostBtnUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(255765);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.ko(this.wyp.getContext()).get(FinderReporterUIC.class)).dIx();
            AppMethodBeat.o(255765);
            return dIx;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.ui.g> {
        final /* synthetic */ FinderLivePostBtnUIC wyp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderLivePostBtnUIC finderLivePostBtnUIC) {
            super(0);
            this.wyp = finderLivePostBtnUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.ui.g invoke() {
            AppMethodBeat.i(255762);
            final z.f fVar = new z.f();
            fVar.SYG = (T) new com.tencent.mm.plugin.finder.ui.g(this.wyp.getActivity());
            T t = fVar.SYG;
            if (t != null) {
                t.vKW = new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC.a.AnonymousClass1 */
                    final /* synthetic */ a wyq;

                    {
                        this.wyq = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        aqb aqb = null;
                        AppMethodBeat.i(255761);
                        FinderLivePostBtnUIC.a(this.wyq.wyp, false);
                        T t = fVar.SYG;
                        int intValue = (t != null ? Integer.valueOf(t.ks) : null).intValue();
                        Log.i(this.wyq.wyp.TAG, "onLivePrepareEnd selectedItemId:".concat(String.valueOf(intValue)));
                        T t2 = fVar.SYG;
                        if (t2 != null) {
                            aqb = t2.vKV;
                        }
                        if (intValue != -1) {
                            FinderLivePostBtnUIC.a(this.wyq.wyp, intValue, aqb);
                            T t3 = fVar.SYG;
                            if (t3 != null) {
                                t3.dzE();
                            }
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(255761);
                        return xVar;
                    }
                };
            }
            T t2 = fVar.SYG;
            AppMethodBeat.o(255762);
            return t2;
        }
    }

    public static final /* synthetic */ void a(FinderLivePostBtnUIC finderLivePostBtnUIC, int i2, aqb aqb) {
        s.g gVar;
        String str;
        boolean z;
        FinderObject finderObject;
        awe awe;
        String str2;
        String str3;
        bel bel;
        bel bel2;
        awe awe2;
        awe awe3;
        AppMethodBeat.i(255779);
        if (i2 == finderLivePostBtnUIC.wyj) {
            k kVar = k.vkd;
            k.q(s.a.LIVE_CLICK_BTN_MENU.hlf, "");
            if (aqb != null) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                if (com.tencent.mm.plugin.finder.live.model.o.dfZ() == null && aqb.LBU != null) {
                    FinderObject finderObject2 = aqb.LBU;
                    if ((finderObject2 != null ? finderObject2.liveInfo : null) != null && ((finderObject = aqb.LBU) == null || (awe3 = finderObject.liveInfo) == null || awe3.liveId != 0)) {
                        String str4 = finderLivePostBtnUIC.TAG;
                        StringBuilder sb = new StringBuilder("continue live:");
                        FinderObject finderObject3 = aqb.LBU;
                        Log.i(str4, sb.append((finderObject3 == null || (awe2 = finderObject3.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).toString());
                        com.tencent.mm.plugin.finder.ui.g dIm = finderLivePostBtnUIC.dIm();
                        if (dIm != null) {
                            FinderObject finderObject4 = aqb.LBU;
                            if (finderObject4 == null || (awe = finderObject4.liveInfo) == null) {
                                AppMethodBeat.o(255779);
                                return;
                            }
                            if (awe.liveId != 0) {
                                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                                bed bed = dIm.udb;
                                int i3 = bed != null ? bed.LNW : 0;
                                bed bed2 = dIm.udb;
                                if (bed2 == null || (bel2 = bed2.wxaShopInfo) == null) {
                                    str2 = null;
                                } else {
                                    str2 = bel2.appId;
                                }
                                bed bed3 = dIm.udb;
                                if (bed3 == null || (bel = bed3.wxaShopInfo) == null) {
                                    str3 = null;
                                } else {
                                    str3 = bel.LOg;
                                }
                                boolean z2 = com.tencent.mm.plugin.finder.utils.m.z(i3, str2, str3);
                                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                                Activity activity = dIm.dKq;
                                long j2 = finderObject4.id;
                                String str5 = finderObject4.objectNonceId;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                p.g(awe, LocaleUtil.ITALIAN);
                                com.tencent.mm.plugin.finder.utils.a.a(activity, j2, str5, awe, z2, dIm.ufj, null, null, null, null, finderObject4.sessionBuffer, null, null, 14224);
                            }
                            AppMethodBeat.o(255779);
                            return;
                        }
                        AppMethodBeat.o(255779);
                        return;
                    }
                }
                com.tencent.mm.plugin.finder.ui.g dIm2 = finderLivePostBtnUIC.dIm();
                if (dIm2 != null) {
                    p.h(aqb, "resp");
                    int i4 = aqb.LBS;
                    boolean z3 = !com.tencent.mm.ac.d.cW(i4, 1);
                    Log.i(dIm2.TAG, "live global enable:" + z3 + ",flag:" + i4);
                    if (!z3) {
                        com.tencent.mm.plugin.finder.ui.g.a(dIm2);
                        AppMethodBeat.o(255779);
                        return;
                    }
                    int i5 = aqb.KTQ;
                    boolean z4 = !com.tencent.mm.ac.d.cW(i5, 1);
                    Log.i(dIm2.TAG, "live private enable:" + z4 + ",flag:" + i5);
                    if (!z4) {
                        com.tencent.mm.plugin.finder.ui.g.a(dIm2);
                        AppMethodBeat.o(255779);
                        return;
                    }
                    dIm2.b(aqb);
                    AppMethodBeat.o(255779);
                    return;
                }
                AppMethodBeat.o(255779);
                return;
            }
            Log.w(finderLivePostBtnUIC.TAG, "handleLiveMenuItemSelected resp is null, ignore");
            AppMethodBeat.o(255779);
            return;
        }
        if (i2 == finderLivePostBtnUIC.wyk) {
            k kVar2 = k.vkd;
            s dpl = k.dpl();
            if ((finderLivePostBtnUIC.getActivity() instanceof FinderSelfUI) || !(finderLivePostBtnUIC.getActivity() instanceof FinderProfileUI)) {
                gVar = s.g.PROFILE;
            } else {
                gVar = s.g.PROFILE_RIGHT_CORNER;
            }
            p.h(gVar, "<set-?>");
            dpl.vmt = gVar;
            k kVar3 = k.vkd;
            k.a(s.ab.LIVE_SELF_PAGE_CLICK_BOOK_ITEM, "");
            if (aqb != null) {
                if (aqb.live_notice_info != null) {
                    awt awt = aqb.live_notice_info;
                    if (awt != null) {
                        str = awt.dDJ;
                    } else {
                        str = null;
                    }
                    String str6 = str;
                    if (str6 == null || str6.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (finderLivePostBtnUIC.getActivity() instanceof FinderProfileUI) {
                            u.makeText(finderLivePostBtnUIC.getActivity(), finderLivePostBtnUIC.getActivity().getString(R.string.d77), 0).show();
                            AppMethodBeat.o(255779);
                            return;
                        }
                        Log.i(finderLivePostBtnUIC.TAG, "goto live notice");
                        Intent intent = new Intent();
                        intent.putExtra("finder_username", com.tencent.mm.model.z.aUg());
                        intent.putExtra("KEY_FINDER_SELF_FLAG", true);
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC.a.a(finderLivePostBtnUIC.getActivity(), intent, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(finderLivePostBtnUIC.getActivity(), intent);
                        k kVar4 = k.vkd;
                        k.a(s.ab.LIVE_JUMP_PROFILE_PAGE, "");
                        AppMethodBeat.o(255779);
                        return;
                    }
                }
                Log.i(finderLivePostBtnUIC.TAG, "onCreateLiveNote");
                z.f fVar = new z.f();
                y yVar = y.vXH;
                fVar.SYG = (T) y.dCP();
                com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(finderLivePostBtnUIC.getActivity(), fVar.SYG.first, fVar.SYG.second, fVar.SYG.SWY);
                cVar.hcj();
                cVar.aF(finderLivePostBtnUIC.getActivity().getResources().getString(R.string.cxx));
                cVar.a(new b(finderLivePostBtnUIC, cVar, fVar));
                View inflate = LayoutInflater.from(finderLivePostBtnUIC.getActivity()).inflate(R.layout.a8q, (ViewGroup) null);
                p.g(inflate, "LayoutInflater.from(acti…live_picker_footer, null)");
                View inflate2 = LayoutInflater.from(finderLivePostBtnUIC.getActivity()).inflate(R.layout.af4, (ViewGroup) null);
                p.g(inflate2, "LayoutInflater.from(acti…live_picker_header, null)");
                cVar.apd(finderLivePostBtnUIC.getActivity().getResources().getColor(R.color.q5));
                cVar.hch();
                cVar.axw(R.drawable.a02);
                cVar.setHeaderView(inflate2);
                cVar.setFooterView(inflate);
                cVar.show();
                k kVar5 = k.vkd;
                k.a(s.ab.LIVE_ENTER_CRAETE_BOOK_PAGE, "");
                AppMethodBeat.o(255779);
                return;
            }
            Log.w(finderLivePostBtnUIC.TAG, "handleLiveMenuItemSelected resp is null, ignore");
        }
        AppMethodBeat.o(255779);
    }

    public static final /* synthetic */ void a(FinderLivePostBtnUIC finderLivePostBtnUIC, int i2) {
        AppMethodBeat.i(255781);
        awt awt = new awt();
        awt.dvv = i2;
        g.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.g.sFI;
        g.a.Hg(i2);
        String aUg = com.tencent.mm.model.z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(finderLivePostBtnUIC.getActivity());
        com.tencent.mm.kernel.g.azz().b(new au(aUg, awt, 0, fH != null ? fH.dIx() : null));
        AppMethodBeat.o(255781);
    }
}
