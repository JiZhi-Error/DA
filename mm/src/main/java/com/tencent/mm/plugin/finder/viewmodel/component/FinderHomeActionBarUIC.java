package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import kotlin.a.ae;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002abB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\bH\u0002J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020\bH\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020\bH\u0002J`\u00100\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\b2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0012\u0010:\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J(\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0016J \u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\u001dH\u0016J\b\u0010J\u001a\u00020\u001dH\u0016J*\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u00010\u00112\u0006\u0010O\u001a\u00020PH\u0016J \u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020\u001dH\u0002J\b\u0010W\u001a\u00020\u001dH\u0002J\b\u0010X\u001a\u00020\u001dH\u0003J\u0010\u0010Y\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\bH\u0002J\u000e\u0010[\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\bJ\u0016\u0010\\\u001a\u0004\u0018\u00010]*\u00020^2\u0006\u0010_\u001a\u00020`H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionBarColor", "", "fromTabIndex", "fromTabType", "fullScreenIconColor", "isAllHomeTabEnableFullScreenEnjoy", "", "isCurrentResume", "isPreparing", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "selected", "selectedInHot", "toTabIndex", "toTabType", "unselected", "unselectedInHot", "buildTab", "", "checkFinderTeenMode", "checkNearbyLiveFriends", "checkPersonCenterRedDotReport", NativeProtocol.WEB_DIALOG_ACTION, "checkPostEntrance", "doClickPostAction", "doPrepareUser", "status", "fixActionBarStatus", "getFinderTab", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "tabType", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "getRootView", "Landroid/view/View;", "getScrollMask", "handleTabColor", "isFromFullScreenTab", "isToFullScreenTab", "selectedInHot2UnSelected", "selected2UnselectedInHot", "selected2Unselected", "unselected2Selected", "unselected2SelectedInHot", "unselectedInHot2Selected", "unselected2UnSelectedInHot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFragmentChange", "isUserVisibleFocused", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "overlayStatusBar", "refreshActionBarColor", "registerRedDot", "resetScrollMask", "color", "setTabIndex", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC extends UIComponent implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.view.h {
    public static final a wwL = new a((byte) 0);
    private final int selected;
    private boolean uPU;
    private String wwA = "";
    private boolean wwB;
    private final int wwC;
    private final int wwD;
    private final int wwE;
    private final int wwF;
    private final int wwG;
    private int wwH;
    private int wwI;
    private int wwJ;
    private int wwK;
    private final boolean wwv = y.isAllHomeTabEnableFullScreenEnjoy();
    private String www = "";
    private String wwx = "";
    private String wwy = "";
    private String wwz = "";

    static {
        AppMethodBeat.i(255595);
        AppMethodBeat.o(255595);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class s<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        s(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            bbi bbi;
            boolean z = true;
            AppMethodBeat.i(255574);
            h.a aVar2 = aVar;
            Log.i("Finder.HomeActionBarUIC", "[MENU_ID_PROFILE] red=" + (aVar2 != null && aVar2.dEF));
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            kotlin.g.b.p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            if (((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
                StringBuilder sb = new StringBuilder("[MENU_ID_PROFILE] red=");
                if (aVar2 == null || !aVar2.dEF) {
                    z = false;
                }
                Log.i("Finder.HomeActionBarUIC", sb.append(z).append(", return for teen mode.").toString());
                AppMethodBeat.o(255574);
                return;
            }
            if (aVar2 == null || !aVar2.dEF) {
                View findViewById = this.wwV.findViewById(R.id.ga6);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                    AppMethodBeat.o(255574);
                    return;
                }
            } else {
                com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                if (kVar == null || (bbi = kVar.field_ctrInfo) == null || bbi.type != 2) {
                    View findViewById2 = this.wwV.findViewById(R.id.ga6);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                    FinderHomeActionBarUIC.a(this.wwV, 1);
                    AppMethodBeat.o(255574);
                    return;
                }
                i.a aVar3 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                if (i.a.dbp()) {
                    View findViewById3 = this.wwV.findViewById(R.id.ga6);
                    if (findViewById3 != null) {
                        findViewById3.setVisibility(0);
                    }
                    FinderHomeActionBarUIC.a(this.wwV, 1);
                    AppMethodBeat.o(255574);
                    return;
                }
            }
            AppMethodBeat.o(255574);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class t<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        t(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x0213  */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x021a  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0113  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0158  */
        @Override // android.arch.lifecycle.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.finder.extension.reddot.h.a r15) {
            /*
            // Method dump skipped, instructions count: 621
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.t.onChanged(java.lang.Object):void");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class u<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        u(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            TabLayout.f b2;
            Object tag;
            String str;
            long j2;
            bbi bbi;
            AppMethodBeat.i(255576);
            h.a aVar2 = aVar;
            TabLayout tabLayout = (TabLayout) this.wwV.findViewById(R.id.ift);
            if (tabLayout == null || (b2 = FinderHomeActionBarUIC.b(tabLayout, (Object) 1)) == null || (tag = b2.getTag()) == null) {
                AppMethodBeat.o(255576);
            } else if (tag == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
                AppMethodBeat.o(255576);
                throw tVar;
            } else {
                Log.i("Finder.HomeActionBarUIC", "[registerRedDot] TAB_TYPE_FRIEND isShow=" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
                if (aVar2 == null || !aVar2.dEF) {
                    this.wwV.wwy = "";
                    ImageView imageView = ((b) tag).uPX;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                    }
                    ImageView imageView2 = ((b) tag).wwO;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                        AppMethodBeat.o(255576);
                        return;
                    }
                } else {
                    bdo bdo = aVar2.tKS;
                    if (bdo == null || bdo.xGz != 15) {
                        ImageView imageView3 = ((b) tag).uPX;
                        if (imageView3 != null) {
                            imageView3.setVisibility(0);
                        }
                        ImageView imageView4 = ((b) tag).wwO;
                        if (imageView4 != null) {
                            imageView4.setVisibility(8);
                        }
                        ImageView imageView5 = ((b) tag).uPX;
                        if (imageView5 != null) {
                            imageView5.setImageResource(R.drawable.b1a);
                        }
                    } else {
                        ImageView imageView6 = ((b) tag).wwO;
                        if (imageView6 != null) {
                            imageView6.setImageResource(R.raw.finder_live_icon);
                        }
                        ImageView imageView7 = ((b) tag).uPX;
                        if (imageView7 != null) {
                            imageView7.setVisibility(8);
                        }
                        ImageView imageView8 = ((b) tag).wwO;
                        if (imageView8 != null) {
                            imageView8.setVisibility(0);
                        }
                    }
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                    if (kVar == null || (str = kVar.field_tipsId) == null) {
                        str = "";
                    }
                    if ((!kotlin.g.b.p.j(this.wwV.wwy, str)) && this.wwV.uPU) {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.extension.reddot.k kVar3 = aVar2.tKT;
                        if (kVar3 == null || (bbi = kVar3.field_ctrInfo) == null) {
                            j2 = 0;
                        } else {
                            j2 = bbi.feedId;
                        }
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wwV.getActivity());
                        bbn dIx = fH != null ? fH.dIx() : null;
                        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                        com.tencent.mm.plugin.finder.report.k.a("2", 8, 1, 1, 0, 0, str, (String) null, j2, dIx, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).dIf(), 0, 2176);
                        this.wwV.wwy = str;
                        com.tencent.mm.plugin.finder.extension.reddot.k kVar4 = aVar2.tKT;
                        bdo bdo2 = aVar2.tKS;
                        if (!(kVar4 == null || bdo2 == null)) {
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wwV.getActivity());
                            bbn dIx2 = fH2 != null ? fH2.dIx() : null;
                            com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
                            com.tencent.mm.plugin.finder.report.j.a("2", kVar4, bdo2, 1, dIx2, 0, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).dIf(), 32);
                            AppMethodBeat.o(255576);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(255576);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class v<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        v(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            TabLayout.f b2;
            Object tag;
            String str;
            AppMethodBeat.i(255577);
            h.a aVar2 = aVar;
            TabLayout tabLayout = (TabLayout) this.wwV.findViewById(R.id.ift);
            if (tabLayout == null || (b2 = FinderHomeActionBarUIC.b(tabLayout, (Object) 4)) == null || (tag = b2.getTag()) == null) {
                AppMethodBeat.o(255577);
            } else if (tag == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
                AppMethodBeat.o(255577);
                throw tVar;
            } else {
                Log.i("Finder.HomeActionBarUIC", "[registerRedDot] TAB_TYPE_MACHINE isShow=" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
                if (aVar2 == null || !aVar2.dEF) {
                    this.wwV.wwz = "";
                    ImageView imageView = ((b) tag).uPX;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                    }
                    ((b) tag).dIe();
                } else {
                    bdo bdo = aVar2.tKS;
                    if (bdo == null || bdo.xGz != 6) {
                        ImageView imageView2 = ((b) tag).uPX;
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                        ((b) tag).dIe();
                    } else {
                        ImageView imageView3 = ((b) tag).uPX;
                        if (imageView3 != null) {
                            imageView3.setVisibility(4);
                        }
                        b bVar = (b) tag;
                        Log.i("Finder.HomeActionBarUIC", "showNewRedDot :" + bVar.dLS);
                        if (!bVar.wwS) {
                            TextView textView = bVar.wwR;
                            if (textView != null) {
                                ao.a(textView.getPaint(), 0.8f);
                                textView.setTextSize(1, 10.0f);
                                textView.post(new b.a(textView, bVar));
                            }
                            bVar.wwS = true;
                        }
                    }
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                    if (kVar == null || (str = kVar.field_tipsId) == null) {
                        str = "";
                    }
                    if ((!kotlin.g.b.p.j(this.wwV.wwz, str)) && this.wwV.uPU) {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wwV.getActivity());
                        bbn dIx = fH != null ? fH.dIx() : null;
                        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                        com.tencent.mm.plugin.finder.report.k.a("2", 3, 1, 1, 2, 0, str, (String) null, 0, dIx, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).dIf(), 0, 2432);
                        this.wwV.wwz = str;
                        com.tencent.mm.plugin.finder.extension.reddot.k kVar3 = aVar2.tKT;
                        bdo bdo2 = aVar2.tKS;
                        if (!(kVar3 == null || bdo2 == null)) {
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wwV.getActivity());
                            bbn dIx2 = fH2 != null ? fH2.dIx() : null;
                            com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
                            com.tencent.mm.plugin.finder.report.j.a("2", kVar3, bdo2, 1, dIx2, 0, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).dIf(), 32);
                            AppMethodBeat.o(255577);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(255577);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class w<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        w(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            AppMethodBeat.i(255578);
            h.a aVar2 = aVar;
            if (aVar2 == null || !aVar2.dEF) {
                this.wwV.wwA = "";
                View findViewById = this.wwV.findViewById(R.id.e_p);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                    AppMethodBeat.o(255578);
                    return;
                }
            } else {
                View findViewById2 = this.wwV.findViewById(R.id.e_p);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(0);
                }
                com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                if (kVar == null || (str = kVar.field_tipsId) == null) {
                    str = "";
                }
                if ((!kotlin.g.b.p.j(this.wwV.wwA, str)) && this.wwV.uPU) {
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wwV.getActivity());
                    com.tencent.mm.plugin.finder.report.k.a("2", 3, 1, 1, 1, 0, str, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3456);
                    this.wwV.wwA = str;
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar3 = aVar2.tKT;
                    bdo bdo = aVar2.tKS;
                    if (!(kVar3 == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wwV.getActivity());
                        com.tencent.mm.plugin.finder.report.j.a("2", kVar3, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, 2, 32);
                        AppMethodBeat.o(255578);
                        return;
                    }
                }
            }
            AppMethodBeat.o(255578);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHomeActionBarUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255594);
        y yVar = y.vXH;
        this.wwC = appCompatActivity.getResources().getColor(R.color.vh);
        this.wwD = appCompatActivity.getResources().getColor(R.color.v6);
        this.wwE = appCompatActivity.getResources().getColor(R.color.vk);
        this.selected = appCompatActivity.getResources().getColor(R.color.fo);
        this.wwF = appCompatActivity.getResources().getColor(R.color.l4);
        this.wwG = appCompatActivity.getResources().getColor(R.color.BW_93);
        this.wwH = -1;
        this.wwI = -1;
        this.wwJ = -1;
        this.wwK = -1;
        AppMethodBeat.o(255594);
    }

    public static final /* synthetic */ void a(FinderHomeActionBarUIC finderHomeActionBarUIC, int i2) {
        AppMethodBeat.i(255597);
        finderHomeActionBarUIC.Mu(i2);
        AppMethodBeat.o(255597);
    }

    public static final /* synthetic */ TabLayout.f b(TabLayout tabLayout, Object obj) {
        AppMethodBeat.i(255599);
        TabLayout.f a2 = a(tabLayout, obj);
        AppMethodBeat.o(255599);
        return a2;
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void onPageScrollStateChanged(int i2) {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "SHEET_MENU_POST", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
        AppMethodBeat.i(255579);
        super.onCreateBefore(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).wxj.add(this);
        AppMethodBeat.o(255579);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        View findViewById;
        AppMethodBeat.i(255580);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        Window window = getActivity().getWindow();
        kotlin.g.b.p.g(window, "activity.window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
        Window window2 = getActivity().getWindow();
        kotlin.g.b.p.g(window2, "activity.window");
        window2.setStatusBarColor(0);
        com.tencent.mm.ui.b.e(getActivity(), false);
        ActionBar supportActionBar2 = getActivity().getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setBackgroundDrawable(new ColorDrawable(0));
            supportActionBar2.hide();
        }
        int statusBarHeight = au.getStatusBarHeight(getActivity());
        View findViewById2 = findViewById(R.id.cj5);
        if (findViewById2 != null) {
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height += statusBarHeight;
            findViewById2.setLayoutParams(layoutParams);
            findViewById2.setPadding(0, statusBarHeight, 0, 0);
        }
        com.tencent.mm.kernel.g.azz().a(3761, this);
        View findViewById3 = findViewById(R.id.xq);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new j(this));
        }
        View findViewById4 = findViewById(R.id.e_o);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new k(this));
        }
        View findViewById5 = findViewById(R.id.gev);
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new l(this));
        }
        View findViewById6 = findViewById(R.id.hd2);
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(new m(this));
        }
        HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) findViewById(R.id.ifu);
        if (hardTouchableLayout != null) {
            hardTouchableLayout.setOnDoubleClickListener(new n(this));
        }
        View findViewById7 = findViewById(R.id.ga5);
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(new o(this));
        }
        dId();
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daN(), getActivity(), new s(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar3 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar4 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daQ(), getActivity(), new t(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar5 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar6 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daR(), getActivity(), new u(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar7 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar8 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daT(), getActivity(), new v(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar9 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar10 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daU(), getActivity(), new w(this));
        Mu(1);
        View findViewById8 = findViewById(R.id.hd2);
        if (findViewById8 != null) {
            findViewById8.setVisibility(0);
        }
        View findViewById9 = findViewById(R.id.e_o);
        if (findViewById9 != null) {
            findViewById9.setVisibility(8);
        }
        View findViewById10 = findViewById(R.id.gev);
        if (findViewById10 != null) {
            findViewById10.setVisibility(8);
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        af finderUtilApi = ((aj) ah).getFinderUtilApi();
        kotlin.g.b.p.g(finderUtilApi, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
        if (finderUtilApi.dDf()) {
            View findViewById11 = findViewById(R.id.hd2);
            if (findViewById11 != null) {
                findViewById11.setVisibility(0);
            }
            View findViewById12 = findViewById(R.id.e_o);
            if (findViewById12 != null) {
                findViewById12.setVisibility(8);
            }
            View findViewById13 = findViewById(R.id.gev);
            if (findViewById13 != null) {
                findViewById13.setVisibility(8);
            }
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            View findViewById14 = findViewById(R.id.e_o);
            if (findViewById14 != null) {
                findViewById14.setVisibility(8);
            }
            View findViewById15 = findViewById(R.id.gev);
            if (findViewById15 != null) {
                findViewById15.setVisibility(8);
            }
            View findViewById16 = findViewById(R.id.hd2);
            if (findViewById16 != null) {
                findViewById16.setVisibility(8);
            }
            View findViewById17 = findViewById(R.id.ifu);
            if (findViewById17 != null) {
                findViewById17.post(new d(this));
            }
        }
        if (this.wwv) {
            WeImageView weImageView = (WeImageView) getActivity().findViewById(R.id.xr);
            if (weImageView != null) {
                weImageView.setIconColor(this.wwD);
            }
            WeImageView weImageView2 = (WeImageView) getActivity().findViewById(R.id.hd1);
            if (weImageView2 != null) {
                weImageView2.setIconColor(this.wwD);
            }
            WeImageView weImageView3 = (WeImageView) getActivity().findViewById(R.id.geu);
            if (weImageView3 != null) {
                weImageView3.setIconColor(this.wwD);
            }
            WeImageView weImageView4 = (WeImageView) getActivity().findViewById(R.id.ga5);
            if (weImageView4 != null) {
                weImageView4.setIconColor(this.wwD);
            }
            WeImageView weImageView5 = (WeImageView) getActivity().findViewById(R.id.e_n);
            if (weImageView5 != null) {
                weImageView5.setIconColor(this.wwD);
            }
            View findViewById18 = getActivity().findViewById(R.id.cj5);
            if (findViewById18 != null) {
                findViewById18.setBackground(null);
            }
        }
        if (!this.wwv || (findViewById = getActivity().findViewById(R.id.j7c)) == null) {
            AppMethodBeat.o(255580);
            return;
        }
        findViewById.post(new p(this));
        AppMethodBeat.o(255580);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        j(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255564);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wwV.getActivity().onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255564);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        k(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255565);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.dnS();
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wwV.getActivity(), intent, 0, 0, true, 60);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            AppCompatActivity activity = this.wwV.getActivity();
            if (activity == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255565);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.utils.a.b((MMActivity) activity, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255565);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        l(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255566);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderHomeActionBarUIC.a(this.wwV);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255566);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        m(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void onClick(View view) {
            boolean z;
            int i2;
            AppMethodBeat.i(255567);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wwV.getActivity(), intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwL().value().intValue() == 1) {
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.D(this.wwV.getActivity(), intent);
            } else {
                String aUg = z.aUg();
                kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                if (aUg.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = 2;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = 1;
                hVar.a(20971, objArr);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.C(this.wwV.getActivity(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255567);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class n implements HardTouchableLayout.b {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(255569);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            Log.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(255569);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ n wwZ;

            a(n nVar) {
                this.wwZ = nVar;
            }

            public final void run() {
                AppMethodBeat.i(255568);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwZ.wwV.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().dlm();
                AppMethodBeat.o(255568);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements View.OnClickListener {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        o(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void onClick(View view) {
            boolean z;
            bdo bdo = null;
            AppMethodBeat.i(255570);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wwV.getActivity());
            com.tencent.mm.plugin.finder.report.e c2 = fH != null ? FinderReporterUIC.c(fH) : null;
            if (c2 instanceof com.tencent.mm.plugin.finder.report.o) {
                e.a aVar2 = com.tencent.mm.plugin.finder.report.e.vdS;
                ((com.tencent.mm.plugin.finder.report.o) c2).auL(e.a.ah(ae.b(kotlin.s.U("feedActionType", 3))));
            }
            FinderHomeActionBarUIC.a(this.wwV, 2);
            Intent intent = new Intent();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("TLPersonalCenter");
            if (asX != null) {
                bdo = asX.atl("TLPersonalCenter");
            }
            if (bdo != null) {
                z = true;
            } else {
                z = false;
            }
            FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
            intent.putExtra(FinderSelfUI.dAd(), z);
            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wwV.getActivity(), intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.z(this.wwV.getActivity(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255570);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class p implements Runnable {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        p(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void run() {
            AppMethodBeat.i(255571);
            FinderHomeActionBarUIC.b(this.wwV, this.wwV.getResources().getColor(R.color.v0));
            AppMethodBeat.o(255571);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255581);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3761, this);
        AppMethodBeat.o(255581);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        d(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        public final void run() {
            AppMethodBeat.i(255555);
            View findViewById = this.wwV.findViewById(R.id.ifu);
            if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(255555);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = 0;
                findViewById.setLayoutParams(layoutParams2);
                AppMethodBeat.o(255555);
                return;
            }
            AppMethodBeat.o(255555);
        }
    }

    private final void Mu(int i2) {
        AppMethodBeat.i(255582);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
        bbn dIx = fH != null ? fH.dIx() : null;
        i.a aVar2 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
        this.www = i.a.a(i2, dIx, this.www);
        AppMethodBeat.o(255582);
    }

    public final void Jx(int i2) {
        TabLayout.f ab;
        AppMethodBeat.i(255583);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.ift);
        if (tabLayout == null || (ab = tabLayout.ab(i2)) == null) {
            AppMethodBeat.o(255583);
            return;
        }
        kotlin.g.b.p.g(ab, "this");
        if (!ab.isSelected()) {
            ab.select();
        }
        AppMethodBeat.o(255583);
    }

    private final void dId() {
        AppMethodBeat.i(255584);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.ift);
        if (tabLayout == null) {
            AppMethodBeat.o(255584);
            return;
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int i2 = 0;
        for (T t2 : ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).fragments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t3 = t2;
            TabLayout.f cW = tabLayout.cW();
            kotlin.g.b.p.g(cW, "tabLayout.newTab()");
            b bVar = new b(cW, t3.dLS);
            int i4 = t3.title;
            TextView textView = bVar.titleTv;
            if (textView != null) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                int i5 = bVar.dLS;
                View customView = bVar.vq.getCustomView();
                if (customView == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(customView, "tab.customView!!");
                Context context = customView.getContext();
                kotlin.g.b.p.g(context, "tab.customView!!.context");
                String string = context.getResources().getString(i4);
                kotlin.g.b.p.g(string, "tab.customView!!.context.resources.getString(id)");
                textView.setText(com.tencent.mm.plugin.finder.storage.c.bb(i5, string));
            }
            TextView textView2 = bVar.wwR;
            if (textView2 != null) {
                textView2.setTextSize(1, 10.0f);
            }
            bVar.index = i2;
            if (t3.dLS == 4) {
                bVar.wwR = (TextView) getActivity().findViewById(R.id.g7p);
            }
            tabLayout.a(bVar.vq, false);
            i2 = i3;
        }
        tabLayout.a(new c(this));
        AppMethodBeat.o(255584);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
    public static final class c implements TabLayout.b<TabLayout.f> {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void k(TabLayout.f fVar) {
            AppMethodBeat.i(255552);
            kotlin.g.b.p.h(fVar, "t");
            AppMethodBeat.o(255552);
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void j(TabLayout.f fVar) {
            AppMethodBeat.i(255553);
            kotlin.g.b.p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                if (this.wwV.wwv) {
                    ((b) tag).av(R.color.vk, true);
                } else {
                    ((b) tag).av(R.color.l4, true);
                }
                ((b) tag).setTextBold(false);
                switch (((b) tag).dLS) {
                    case 2:
                        WeImageView weImageView = ((b) tag).uPW;
                        if (weImageView != null) {
                            weImageView.setImageResource(R.raw.icons_outlined_location);
                            AppMethodBeat.o(255553);
                            return;
                        }
                        AppMethodBeat.o(255553);
                        return;
                    case 1:
                        WeImageView weImageView2 = ((b) tag).uPW;
                        if (weImageView2 != null) {
                            weImageView2.setImageResource(R.raw.icons_outlined_little_like);
                            AppMethodBeat.o(255553);
                            return;
                        }
                        break;
                }
            }
            AppMethodBeat.o(255553);
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void i(TabLayout.f fVar) {
            AppMethodBeat.i(255554);
            kotlin.g.b.p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                if (this.wwV.wwv) {
                    ((b) tag).av(R.color.vh, false);
                } else {
                    y yVar = y.vXH;
                    if (y.LY(((b) tag).dLS)) {
                        ((b) tag).av(R.color.vh, false);
                    } else {
                        ((b) tag).av(R.color.a2x, false);
                    }
                }
                ((b) tag).setTextBold(true);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).p(((b) tag).dLS, null);
                switch (((b) tag).dLS) {
                    case 2:
                        WeImageView weImageView = ((b) tag).uPW;
                        if (weImageView != null) {
                            weImageView.setImageResource(R.raw.icons_filled_location);
                            AppMethodBeat.o(255554);
                            return;
                        }
                        AppMethodBeat.o(255554);
                        return;
                    case 1:
                        WeImageView weImageView2 = ((b) tag).uPW;
                        if (weImageView2 != null) {
                            weImageView2.setImageResource(R.raw.icons_filled_little_like);
                            AppMethodBeat.o(255554);
                            return;
                        }
                        break;
                }
            }
            AppMethodBeat.o(255554);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        int i2;
        AppMethodBeat.i(255585);
        super.onResume();
        this.uPU = true;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dtX().value().intValue();
        if (intValue == 2) {
            String aUg = z.aUg();
            kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            boolean z = aUg.length() > 0;
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[3];
            objArr[0] = 1;
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = 1;
            hVar.a(20971, objArr);
            AppMethodBeat.o(255585);
            return;
        }
        if (intValue == 1) {
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.H(true, 1);
        }
        AppMethodBeat.o(255585);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255586);
        super.onPause();
        this.uPU = false;
        AppMethodBeat.o(255586);
    }

    private static TabLayout.f a(TabLayout tabLayout, Object obj) {
        AppMethodBeat.i(255587);
        int tabCount = tabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.f ab = tabLayout.ab(i2);
            if ((ab != null ? ab.getTag() : null) instanceof b) {
                Object tag = ab.getTag();
                if (tag == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
                    AppMethodBeat.o(255587);
                    throw tVar;
                }
                int i3 = ((b) tag).dLS;
                if ((obj instanceof Integer) && i3 == ((Integer) obj).intValue()) {
                    AppMethodBeat.o(255587);
                    return ab;
                }
            }
        }
        AppMethodBeat.o(255587);
        return null;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020\u0014H\u0002J\u000e\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0014J\u0018\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020\u00052\b\b\u0002\u0010A\u001a\u00020\u0014J\u000e\u0010B\u001a\u00020;2\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010C\u001a\u00020;R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u001c\u0010,\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001e¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "changeMargin", FirebaseAnalytics.b.INDEX, "getIndex", "()I", "setIndex", "(I)V", "isAdjust", "", "()Z", "setAdjust", "(Z)V", "newTabRedDotSafeGap", "outerNewRedTv", "Landroid/widget/TextView;", "getOuterNewRedTv", "()Landroid/widget/TextView;", "setOuterNewRedTv", "(Landroid/widget/TextView;)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "getTabRedTv", "setTabRedTv", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "dismissNewRedDot", "", "isNeedExpand", "setTextBold", "isBold", "setTextColor", "id", "isUnSelected", "setTitle", "showNewRedDot", "plugin-finder_release"})
    public static final class b {
        int dLS;
        int index;
        TextView titleTv;
        WeImageView uPW;
        ImageView uPX;
        TabLayout.f vq;
        final int wwM;
        final int wwN;
        ImageView wwO;
        ViewGroup wwP;
        TextView wwQ;
        TextView wwR;
        boolean wwS;

        @SuppressLint({"ResourceType"})
        public b(TabLayout.f fVar, int i2) {
            ImageView imageView;
            ImageView imageView2;
            ViewGroup viewGroup;
            TextView textView;
            ImageView imageView3;
            int i3;
            Context context;
            Resources resources;
            TextView textView2;
            WeImageView weImageView;
            ImageView imageView4;
            ImageView imageView5;
            kotlin.g.b.p.h(fVar, "tab");
            AppMethodBeat.i(255551);
            this.vq = fVar;
            this.dLS = i2;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            this.wwM = (int) context2.getResources().getDimension(R.dimen.ce);
            Context context3 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
            this.wwN = (int) context3.getResources().getDimension(R.dimen.cc);
            this.vq.g(this);
            y yVar = y.vXH;
            boolean isAllHomeTabEnableFullScreenEnjoy = y.isAllHomeTabEnableFullScreenEnjoy();
            Context context4 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context4, "MMApplicationContext.getContext()");
            int color = context4.getResources().getColor(isAllHomeTabEnableFullScreenEnjoy ? R.color.vk : R.color.l4);
            if (this.dLS == 1) {
                this.vq.aj(R.layout.acb);
                View customView = this.vq.getCustomView();
                if (customView != null) {
                    textView2 = (TextView) customView.findViewById(R.id.ifz);
                } else {
                    textView2 = null;
                }
                this.titleTv = textView2;
                TextView textView3 = this.titleTv;
                if (textView3 != null) {
                    textView3.setTextSize(1, 15.0f);
                }
                View customView2 = this.vq.getCustomView();
                if (customView2 != null) {
                    weImageView = (WeImageView) customView2.findViewById(R.id.ig2);
                } else {
                    weImageView = null;
                }
                this.uPW = weImageView;
                View customView3 = this.vq.getCustomView();
                if (customView3 != null) {
                    imageView4 = (ImageView) customView3.findViewById(R.id.ig3);
                } else {
                    imageView4 = null;
                }
                this.uPX = imageView4;
                View customView4 = this.vq.getCustomView();
                if (customView4 != null) {
                    imageView5 = (ImageView) customView4.findViewById(R.id.a3_);
                } else {
                    imageView5 = null;
                }
                this.wwO = imageView5;
                WeImageView weImageView2 = this.uPW;
                if (weImageView2 != null) {
                    weImageView2.setImageResource(R.raw.icons_filled_little_like);
                }
            } else if (this.dLS == 3 || this.dLS == 4) {
                this.vq.aj(R.layout.aca);
                View customView5 = this.vq.getCustomView();
                this.titleTv = customView5 != null ? (TextView) customView5.findViewById(R.id.ifz) : null;
                TextView textView4 = this.titleTv;
                if (textView4 != null) {
                    textView4.setTextSize(1, 15.0f);
                }
                View customView6 = this.vq.getCustomView();
                if (customView6 != null) {
                    imageView = (ImageView) customView6.findViewById(R.id.ifw);
                } else {
                    imageView = null;
                }
                this.uPX = imageView;
                View customView7 = this.vq.getCustomView();
                if (customView7 != null) {
                    imageView2 = (ImageView) customView7.findViewById(R.id.a39);
                } else {
                    imageView2 = null;
                }
                this.wwO = imageView2;
                View customView8 = this.vq.getCustomView();
                if (customView8 != null) {
                    viewGroup = (ViewGroup) customView8.findViewById(R.id.ig1);
                } else {
                    viewGroup = null;
                }
                this.wwP = viewGroup;
                ViewGroup viewGroup2 = this.wwP;
                if (!(viewGroup2 == null || (imageView3 = (ImageView) viewGroup2.findViewById(R.id.ig0)) == null)) {
                    ViewGroup viewGroup3 = this.wwP;
                    if (viewGroup3 == null || (context = viewGroup3.getContext()) == null || (resources = context.getResources()) == null) {
                        i3 = 0;
                    } else {
                        i3 = resources.getColor(R.color.afz);
                    }
                    com.tencent.mm.emoji.e.e.a(imageView3, R.raw.finder_icon_live_onlive, i3);
                }
                View customView9 = this.vq.getCustomView();
                if (customView9 != null) {
                    textView = (TextView) customView9.findViewById(R.id.ig4);
                } else {
                    textView = null;
                }
                this.wwQ = textView;
                TextView textView5 = this.wwQ;
                if (textView5 != null) {
                    textView5.setTextSize(1, 9.0f);
                }
            } else {
                this.vq.aj(R.layout.ac9);
            }
            WeImageView weImageView3 = this.uPW;
            if (weImageView3 != null) {
                weImageView3.setIconColor(color);
            }
            TextView textView6 = this.titleTv;
            if (textView6 != null) {
                textView6.setTextColor(color);
                AppMethodBeat.o(255551);
                return;
            }
            AppMethodBeat.o(255551);
        }

        public final void av(int i2, boolean z) {
            AppMethodBeat.i(255548);
            View customView = this.vq.getCustomView();
            if (customView == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(customView, "tab.customView!!");
            Context context = customView.getContext();
            kotlin.g.b.p.g(context, "tab.customView!!.context");
            int color = context.getResources().getColor(i2);
            TextView textView = this.titleTv;
            if (textView != null) {
                textView.setTextColor(color);
            }
            WeImageView weImageView = this.uPW;
            if (weImageView != null) {
                weImageView.setIconColor(color);
            }
            if (!z) {
                this.vq.vl.setSelectedTabIndicatorColor(color);
            }
            AppMethodBeat.o(255548);
        }

        public final void setTextBold(boolean z) {
            AppMethodBeat.i(255549);
            TextView textView = this.titleTv;
            if (textView == null) {
                AppMethodBeat.o(255549);
            } else if (z) {
                ao.a(textView.getPaint(), 0.8f);
                AppMethodBeat.o(255549);
            } else {
                TextPaint paint = textView.getPaint();
                kotlin.g.b.p.g(paint, "it.paint");
                paint.setFakeBoldText(false);
                TextPaint paint2 = textView.getPaint();
                kotlin.g.b.p.g(paint2, "it.paint");
                paint2.setStrokeWidth(0.0f);
                AppMethodBeat.o(255549);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab$showNewRedDot$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ TextView wwT;
            final /* synthetic */ b wwU;

            a(TextView textView, b bVar) {
                this.wwT = textView;
                this.wwU = bVar;
            }

            public final void run() {
                boolean z;
                int i2;
                AppMethodBeat.i(255547);
                b bVar = this.wwU;
                TextView textView = bVar.wwR;
                if (textView != null) {
                    if (textView.getParent() instanceof ViewGroup) {
                        ViewParent parent = textView.getParent();
                        if (parent == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(255547);
                            throw tVar;
                        }
                        i2 = ((ViewGroup) parent).getWidth();
                    } else {
                        i2 = 0;
                    }
                    Log.i("Finder.HomeActionBarUIC", "isNeedShrink gap: " + (i2 - textView.getRight()) + "  newTabRedDotSafeGap: " + bVar.wwM);
                    z = i2 != 0 && i2 - textView.getRight() > bVar.wwM;
                } else {
                    z = false;
                }
                if (z) {
                    ViewGroup.LayoutParams layoutParams = this.wwT.getLayoutParams();
                    if (layoutParams == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(255547);
                        throw tVar2;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink : " + layoutParams2.getMarginStart());
                    layoutParams2.setMarginStart(layoutParams2.getMarginStart() + this.wwU.wwN);
                    Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink after: " + layoutParams2.getMarginStart());
                    this.wwT.setLayoutParams(layoutParams2);
                }
                this.wwT.setVisibility(0);
                AppMethodBeat.o(255547);
            }
        }

        public final void dIe() {
            AppMethodBeat.i(255550);
            Log.i("Finder.HomeActionBarUIC", "dismissNewRedDot :" + this.dLS);
            TextView textView = this.wwR;
            if (textView != null) {
                textView.setVisibility(4);
                AppMethodBeat.o(255550);
                return;
            }
            AppMethodBeat.o(255550);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class e implements o.f {
        public static final e wwW = new e();

        static {
            AppMethodBeat.i(255557);
            AppMethodBeat.o(255557);
        }

        e() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(255556);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1, R.string.d57);
            }
            AppMethodBeat.o(255556);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class f implements o.g {
        final /* synthetic */ FinderHomeActionBarUIC wwV;

        f(FinderHomeActionBarUIC finderHomeActionBarUIC) {
            this.wwV = finderHomeActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(255558);
            y yVar = y.vXH;
            if (y.bE(this.wwV.getActivity())) {
                Intent intent = new Intent();
                intent.putExtra("key_create_scene", 1);
                intent.putExtra("scene", 1);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.w(this.wwV.getActivity(), intent);
            }
            AppMethodBeat.o(255558);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class g implements o.f {
        public static final g wwX = new g();

        static {
            AppMethodBeat.i(255560);
            AppMethodBeat.o(255560);
        }

        g() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(255559);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1001, R.string.um);
                mVar.kV(1002, R.string.uv);
            }
            AppMethodBeat.o(255559);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class h implements o.g {
        final /* synthetic */ String uPz;
        final /* synthetic */ AppCompatActivity vao;

        h(String str, AppCompatActivity appCompatActivity) {
            this.uPz = str;
            this.vao = appCompatActivity;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(255561);
            Intent intent = new Intent();
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1001) {
                intent.putExtra("key_finder_post_router", 2);
            } else if (menuItem.getItemId() == 1002) {
                intent.putExtra("key_finder_post_router", 3);
            }
            intent.putExtra("key_finder_post_from", 5);
            intent.putExtra("key_finder_post_id", this.uPz);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(this.vao, intent);
            AppMethodBeat.o(255561);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class i implements e.b {
        public static final i wwY = new i();

        static {
            AppMethodBeat.i(255563);
            AppMethodBeat.o(255563);
        }

        i() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(255562);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(6);
            AppMethodBeat.o(255562);
        }
    }

    private final void Mv(int i2) {
        boolean z = true;
        AppMethodBeat.i(255588);
        Log.i("Finder.HomeActionBarUIC", "[doPrepareUser] isPreparing=" + this.wwB + " status=" + i2);
        if (!this.wwB) {
            this.wwB = true;
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            if (((PluginFinder) ah).getRedDotManager().asW("TLPostCamera") == null) {
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                if (((PluginFinder) ah2).getRedDotManager().asW("TLCamera") == null) {
                    z = false;
                }
            }
            cd cdVar = new cd(3);
            cdVar.twh = z;
            com.tencent.mm.kernel.g.azz().b(cdVar);
        }
        AppMethodBeat.o(255588);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(255589);
        kotlin.g.b.p.h(qVar, "scene");
        if (qVar.getType() == 3761) {
            this.wwB = false;
        }
        AppMethodBeat.o(255589);
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment) {
        AppMethodBeat.i(255590);
        kotlin.g.b.p.h(finderHomeTabFragment, "fragment");
        AppMethodBeat.o(255590);
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void D(int i2, int i3, int i4, int i5) {
        boolean z = true;
        AppMethodBeat.i(255591);
        this.wwJ = i3;
        this.wwK = i2;
        this.wwH = i5;
        this.wwI = i4;
        y yVar = y.vXH;
        Window window = getActivity().getWindow();
        kotlin.g.b.p.g(window, "activity.window");
        y.b(window, !ao.isDarkMode());
        y yVar2 = y.vXH;
        if (!y.isAnyHomeTabEnableFullScreenEnjoy()) {
            AppMethodBeat.o(255591);
            return;
        }
        y yVar3 = y.vXH;
        boolean LY = y.LY(this.wwH);
        y yVar4 = y.vXH;
        boolean LY2 = y.LY(this.wwI);
        if (!LY) {
            y yVar5 = y.vXH;
            Window window2 = getActivity().getWindow();
            kotlin.g.b.p.g(window2, "activity.window");
            if (ao.isDarkMode()) {
                z = false;
            }
            y.b(window2, z);
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255591);
                throw tVar;
            }
            ((MMActivity) activity).setNavigationbarColor(getActivity().getResources().getColor(R.color.afz));
            View findViewById = getActivity().findViewById(R.id.cj5);
            if (findViewById != null) {
                findViewById.setBackgroundColor(this.wwG);
            }
        } else {
            y yVar6 = y.vXH;
            Window window3 = getActivity().getWindow();
            kotlin.g.b.p.g(window3, "activity.window");
            y.b(window3, false);
            AppCompatActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255591);
                throw tVar2;
            }
            ((MMActivity) activity2).setNavigationbarColor(getActivity().getResources().getColor(R.color.fm));
            View findViewById2 = findViewById(R.id.cj5);
            if (findViewById2 != null) {
                findViewById2.setBackground(null);
            }
        }
        if (i2 != -1 && LY && LY2) {
            b Mw = Mw(this.wwH);
            if (Mw != null) {
                TextView textView = Mw.titleTv;
                if (textView != null) {
                    textView.setTextColor(this.wwC);
                }
                WeImageView weImageView = Mw.uPW;
                if (weImageView != null) {
                    weImageView.setIconColor(this.wwC);
                }
            }
            b Mw2 = Mw(this.wwI);
            if (Mw2 != null) {
                TextView textView2 = Mw2.titleTv;
                if (textView2 != null) {
                    textView2.setTextColor(this.wwE);
                }
                WeImageView weImageView2 = Mw2.uPW;
                if (weImageView2 != null) {
                    weImageView2.setIconColor(this.wwE);
                    AppMethodBeat.o(255591);
                    return;
                }
                AppMethodBeat.o(255591);
                return;
            }
        }
        AppMethodBeat.o(255591);
    }

    @Override // com.tencent.mm.plugin.finder.view.h
    public final void onPageScrolled(int i2, float f2, int i3) {
        AppMethodBeat.i(255592);
        y yVar = y.vXH;
        if (!y.isAnyHomeTabEnableFullScreenEnjoy()) {
            AppMethodBeat.o(255592);
            return;
        }
        r rVar = new r(this, f2, i2);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.ift);
        if ((tabLayout != null ? tabLayout.getHeight() : 0) <= 0) {
            TabLayout tabLayout2 = (TabLayout) findViewById(R.id.ift);
            if (tabLayout2 != null) {
                tabLayout2.post(new q(rVar));
                AppMethodBeat.o(255592);
                return;
            }
            AppMethodBeat.o(255592);
            return;
        }
        rVar.invoke();
        AppMethodBeat.o(255592);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ kotlin.g.a.a wxa;

        q(kotlin.g.a.a aVar) {
            this.wxa = aVar;
        }

        public final void run() {
            AppMethodBeat.i(255572);
            this.wxa.invoke();
            AppMethodBeat.o(255572);
        }
    }

    private final b Mw(int i2) {
        TabLayout.f a2;
        AppMethodBeat.i(255593);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.ift);
        Object tag = (tabLayout == null || (a2 = a(tabLayout, Integer.valueOf(i2))) == null) ? null : a2.getTag();
        if (!(tag instanceof b)) {
            tag = null;
        }
        b bVar = (b) tag;
        AppMethodBeat.o(255593);
        return bVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int gUj;
        final /* synthetic */ FinderHomeActionBarUIC wwV;
        final /* synthetic */ float wxb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderHomeActionBarUIC finderHomeActionBarUIC, float f2, int i2) {
            super(0);
            this.wwV = finderHomeActionBarUIC;
            this.wxb = f2;
            this.gUj = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            float f2;
            int e2;
            int e3;
            Drawable background;
            AppMethodBeat.i(255573);
            float f3 = this.wxb;
            y yVar = y.vXH;
            boolean LY = y.LY(this.wwV.wwH);
            y yVar2 = y.vXH;
            boolean LY2 = y.LY(this.wwV.wwI);
            if (LY || LY2) {
                if (this.wxb == 0.0f && this.gUj == this.wwV.wwJ && this.wwV.wwK < this.wwV.wwJ) {
                    f3 = 1.0f;
                }
                boolean z = false;
                if (this.gUj == this.wwV.wwJ && this.wxb == 0.0f) {
                    z = true;
                } else if (this.wwV.wwJ > this.wwV.wwK && this.wwV.wwJ - 1 == this.gUj) {
                    z = true;
                } else if (this.wwV.wwJ < this.wwV.wwK && this.wwV.wwJ == this.gUj) {
                    z = true;
                }
                if (this.wwV.wwK < this.wwV.wwJ) {
                    f2 = f3;
                } else {
                    f2 = 1.0f - f3;
                }
                if (z) {
                    View c2 = FinderHomeActionBarUIC.c(this.wwV, this.wwV.wwH);
                    if (c2 != null) {
                        c2.setAlpha(1.0f - f2);
                    }
                    View c3 = FinderHomeActionBarUIC.c(this.wwV, this.wwV.wwI);
                    if (c3 != null) {
                        c3.setAlpha(f2);
                    }
                    if (!LY || !LY2) {
                        y yVar3 = y.vXH;
                        int e4 = y.e(this.wwV.selected, this.wwV.wwE, f2);
                        y yVar4 = y.vXH;
                        int e5 = y.e(this.wwV.wwE, this.wwV.selected, f2);
                        y yVar5 = y.vXH;
                        int e6 = y.e(this.wwV.selected, this.wwV.wwF, f2);
                        y yVar6 = y.vXH;
                        int e7 = y.e(this.wwV.wwF, this.wwV.selected, f2);
                        y yVar7 = y.vXH;
                        int e8 = y.e(this.wwV.wwF, this.wwV.wwC, f2);
                        y yVar8 = y.vXH;
                        int e9 = y.e(this.wwV.wwF, this.wwV.wwE, f2);
                        y yVar9 = y.vXH;
                        int e10 = y.e(this.wwV.wwC, this.wwV.wwF, f2);
                        if (LY || LY2) {
                            float f4 = LY ? f2 : 1.0f - f2;
                            if (f4 >= 0.5f) {
                                View findViewById = this.wwV.findViewById(R.id.cj5);
                                if (findViewById != null) {
                                    findViewById.setBackground(null);
                                }
                            } else {
                                View findViewById2 = this.wwV.findViewById(R.id.cj5);
                                if (findViewById2 != null) {
                                    findViewById2.setBackgroundColor(this.wwV.wwG);
                                }
                                View findViewById3 = this.wwV.findViewById(R.id.cj5);
                                if (!(findViewById3 == null || (background = findViewById3.getBackground()) == null)) {
                                    background.setAlpha(kotlin.h.a.cR(((0.5f - f4) / 0.5f) * 255.0f));
                                }
                            }
                        }
                        if (LY) {
                            y yVar10 = y.vXH;
                            int e11 = y.e(this.wwV.getActivity().getResources().getColor(R.color.afz), WebView.NIGHT_MODE_COLOR, f2);
                            AppCompatActivity activity = this.wwV.getActivity();
                            if (activity == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                                AppMethodBeat.o(255573);
                                throw tVar;
                            }
                            ((MMActivity) activity).setNavigationbarColor(e11);
                        }
                        if (LY) {
                            y yVar11 = y.vXH;
                            e2 = y.e(this.wwV.selected, this.wwV.wwC, f2);
                        } else if (LY2) {
                            y yVar12 = y.vXH;
                            e2 = y.e(this.wwV.wwC, this.wwV.selected, f2);
                        } else {
                            y yVar13 = y.vXH;
                            e2 = y.e(this.wwV.selected, this.wwV.selected, f2);
                        }
                        if (LY) {
                            y yVar14 = y.vXH;
                            e3 = y.e(this.wwV.selected, this.wwV.wwD, f2);
                        } else if (LY2) {
                            y yVar15 = y.vXH;
                            e3 = y.e(this.wwV.wwD, this.wwV.selected, f2);
                        } else {
                            y yVar16 = y.vXH;
                            e3 = y.e(this.wwV.selected, this.wwV.selected, f2);
                        }
                        TabLayout tabLayout = (TabLayout) this.wwV.findViewById(R.id.ift);
                        if (tabLayout != null) {
                            tabLayout.setSelectedTabIndicatorColor(e2);
                        }
                        WeImageView weImageView = (WeImageView) this.wwV.findViewById(R.id.xr);
                        if (weImageView != null) {
                            weImageView.setIconColor(e3);
                        }
                        WeImageView weImageView2 = (WeImageView) this.wwV.findViewById(R.id.hd1);
                        if (weImageView2 != null) {
                            weImageView2.setIconColor(e3);
                        }
                        WeImageView weImageView3 = (WeImageView) this.wwV.findViewById(R.id.geu);
                        if (weImageView3 != null) {
                            weImageView3.setIconColor(e3);
                        }
                        WeImageView weImageView4 = (WeImageView) this.wwV.findViewById(R.id.ga5);
                        if (weImageView4 != null) {
                            weImageView4.setIconColor(e3);
                        }
                        WeImageView weImageView5 = (WeImageView) this.wwV.findViewById(R.id.e_n);
                        if (weImageView5 != null) {
                            weImageView5.setIconColor(e3);
                        }
                        FinderHomeActionBarUIC.a(this.wwV, 1, LY2, LY, e10, e4, e6, e7, e8, e5, e9, this.wwV.wwF);
                        FinderHomeActionBarUIC.a(this.wwV, 3, LY2, LY, e10, e4, e6, e7, e8, e5, e9, this.wwV.wwF);
                        FinderHomeActionBarUIC.a(this.wwV, 4, LY2, LY, e10, e4, e6, e7, e8, e5, e9, this.wwV.wwF);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255573);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(FinderHomeActionBarUIC finderHomeActionBarUIC) {
        AppMethodBeat.i(255596);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj) ah).getRedDotManager().asV("TLPostCamera");
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.H(false, 1);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (!com.tencent.mm.plugin.finder.spam.a.avp("post")) {
            y yVar = y.vXH;
            switch (y.dCL()) {
                case 2:
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderHomeActionBarUIC.getActivity(), 1, true);
                    eVar.a(e.wwW);
                    eVar.a(new f(finderHomeActionBarUIC));
                    View inflate = aa.jQ(finderHomeActionBarUIC.getActivity()).inflate(R.layout.ak1, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.bj);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    View findViewById2 = inflate.findViewById(R.id.ipr);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(8);
                    }
                    View findViewById3 = inflate.findViewById(R.id.ipq);
                    if (findViewById3 != null) {
                        findViewById3.setVisibility(0);
                    }
                    TextView textView = (TextView) inflate.findViewById(R.id.ipq);
                    if (textView != null) {
                        textView.setText(finderHomeActionBarUIC.getActivity().getResources().getString(R.string.cgj));
                    }
                    eVar.V(inflate, true);
                    eVar.dGm();
                    AppMethodBeat.o(255596);
                    return;
                case 3:
                default:
                    if (!Util.isNullOrNil(z.aUg())) {
                        AppCompatActivity activity = finderHomeActionBarUIC.getActivity();
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.fr(activity);
                        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.as(3, false);
                        com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e((Context) activity, 1, true);
                        View inflate2 = aa.jQ(activity).inflate(R.layout.ak1, (ViewGroup) null);
                        TextView textView2 = (TextView) inflate2.findViewById(R.id.fzc);
                        ImageView imageView = (ImageView) inflate2.findViewById(R.id.wm);
                        View findViewById4 = inflate2.findViewById(R.id.ipq);
                        if (findViewById4 != null) {
                            findViewById4.setVisibility(8);
                        }
                        View findViewById5 = inflate2.findViewById(R.id.ipr);
                        if (findViewById5 != null) {
                            findViewById5.setVisibility(0);
                        }
                        c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
                        if (asG != null) {
                            kotlin.g.b.p.g(textView2, "nicknameTv");
                            textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, asG.getNickname()));
                            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                            com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
                            kotlin.g.b.p.g(imageView, "avatarIv");
                            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                            dka.a(aVar4, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                        }
                        StringBuilder sb = new StringBuilder();
                        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
                        String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
                        com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.auH(sb2);
                        eVar2.V(inflate2, true);
                        eVar2.a(g.wwX);
                        eVar2.a(new h(sb2, activity));
                        eVar2.b(i.wwY);
                        eVar2.dGm();
                        break;
                    } else {
                        Log.e("Finder.HomeActionBarUIC", "getMyFinderUsername is null.");
                        AppMethodBeat.o(255596);
                        return;
                    }
                case 4:
                    com.tencent.mm.ui.base.u.makeText(finderHomeActionBarUIC.getActivity(), finderHomeActionBarUIC.getActivity().getResources().getString(R.string.cq), 1).show();
                    finderHomeActionBarUIC.Mv(4);
                    AppMethodBeat.o(255596);
                    return;
                case 5:
                    com.tencent.mm.ui.base.u.makeText(finderHomeActionBarUIC.getActivity(), finderHomeActionBarUIC.getActivity().getResources().getString(R.string.cp), 1).show();
                    finderHomeActionBarUIC.Mv(5);
                    AppMethodBeat.o(255596);
                    return;
                case 6:
                    com.tencent.mm.ui.base.u.makeText(finderHomeActionBarUIC.getActivity(), finderHomeActionBarUIC.getActivity().getResources().getString(R.string.co), 1).show();
                    finderHomeActionBarUIC.Mv(6);
                    AppMethodBeat.o(255596);
                    return;
            }
        }
        AppMethodBeat.o(255596);
    }

    public static final /* synthetic */ void b(FinderHomeActionBarUIC finderHomeActionBarUIC, int i2) {
        View findViewById;
        AppMethodBeat.i(255598);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Iterator<T> it = ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(finderHomeActionBarUIC.getActivity()).get(FinderHomeUIC.class)).fragments.iterator();
        while (it.hasNext()) {
            View view = it.next().getView();
            if (!(view == null || (findViewById = view.findViewById(R.id.hcn)) == null)) {
                findViewById.setBackgroundColor(i2);
            }
        }
        AppMethodBeat.o(255598);
    }

    public static final /* synthetic */ View c(FinderHomeActionBarUIC finderHomeActionBarUIC, int i2) {
        View view;
        AppMethodBeat.i(255600);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Iterator<T> it = ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(finderHomeActionBarUIC.getActivity()).get(FinderHomeUIC.class)).fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            T next = it.next();
            if (next.dLS == i2) {
                view = next.getView();
                break;
            }
        }
        if (view != null) {
            View findViewById = view.findViewById(R.id.hcn);
            AppMethodBeat.o(255600);
            return findViewById;
        }
        AppMethodBeat.o(255600);
        return null;
    }

    public static final /* synthetic */ void a(FinderHomeActionBarUIC finderHomeActionBarUIC, int i2, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        AppMethodBeat.i(255601);
        b Mw = finderHomeActionBarUIC.Mw(i2);
        if (Mw == null) {
            AppMethodBeat.o(255601);
        } else if (finderHomeActionBarUIC.wwK != Mw.index) {
            if (finderHomeActionBarUIC.wwK != Mw.index) {
                if (finderHomeActionBarUIC.wwJ == Mw.index) {
                    if (z2) {
                        TextView textView = Mw.titleTv;
                        if (textView != null) {
                            textView.setTextColor(i7);
                        }
                        WeImageView weImageView = Mw.uPW;
                        if (weImageView != null) {
                            weImageView.setIconColor(i7);
                            AppMethodBeat.o(255601);
                            return;
                        }
                        AppMethodBeat.o(255601);
                        return;
                    } else if (z) {
                        TextView textView2 = Mw.titleTv;
                        if (textView2 != null) {
                            textView2.setTextColor(i8);
                        }
                        WeImageView weImageView2 = Mw.uPW;
                        if (weImageView2 != null) {
                            weImageView2.setIconColor(i8);
                            AppMethodBeat.o(255601);
                            return;
                        }
                        AppMethodBeat.o(255601);
                        return;
                    } else {
                        TextView textView3 = Mw.titleTv;
                        if (textView3 != null) {
                            textView3.setTextColor(i6);
                        }
                        WeImageView weImageView3 = Mw.uPW;
                        if (weImageView3 != null) {
                            weImageView3.setIconColor(i6);
                            AppMethodBeat.o(255601);
                            return;
                        }
                        AppMethodBeat.o(255601);
                        return;
                    }
                } else if (z2) {
                    TextView textView4 = Mw.titleTv;
                    if (textView4 != null) {
                        textView4.setTextColor(i9);
                    }
                    WeImageView weImageView4 = Mw.uPW;
                    if (weImageView4 != null) {
                        weImageView4.setIconColor(i9);
                        AppMethodBeat.o(255601);
                        return;
                    }
                    AppMethodBeat.o(255601);
                    return;
                } else {
                    TextView textView5 = Mw.titleTv;
                    if (textView5 != null) {
                        textView5.setTextColor(i10);
                    }
                    WeImageView weImageView5 = Mw.uPW;
                    if (weImageView5 != null) {
                        weImageView5.setIconColor(i10);
                        AppMethodBeat.o(255601);
                        return;
                    }
                }
            }
            AppMethodBeat.o(255601);
        } else if (z) {
            TextView textView6 = Mw.titleTv;
            if (textView6 != null) {
                textView6.setTextColor(i3);
            }
            WeImageView weImageView6 = Mw.uPW;
            if (weImageView6 != null) {
                weImageView6.setIconColor(i3);
                AppMethodBeat.o(255601);
                return;
            }
            AppMethodBeat.o(255601);
        } else if (z2) {
            TextView textView7 = Mw.titleTv;
            if (textView7 != null) {
                textView7.setTextColor(i4);
            }
            WeImageView weImageView7 = Mw.uPW;
            if (weImageView7 != null) {
                weImageView7.setIconColor(i4);
                AppMethodBeat.o(255601);
                return;
            }
            AppMethodBeat.o(255601);
        } else {
            TextView textView8 = Mw.titleTv;
            if (textView8 != null) {
                textView8.setTextColor(i5);
            }
            WeImageView weImageView8 = Mw.uPW;
            if (weImageView8 != null) {
                weImageView8.setIconColor(i5);
                AppMethodBeat.o(255601);
                return;
            }
            AppMethodBeat.o(255601);
        }
    }
}
