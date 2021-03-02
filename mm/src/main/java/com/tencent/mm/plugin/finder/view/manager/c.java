package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001BB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0010\u0014J\u0006\u00104\u001a\u00020\u0012J\u0006\u00105\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bJ\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b08J\b\u00109\u001a\u00020\u000fH\u0002J\u0018\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u0012H\u0016J\u0006\u0010=\u001a\u00020\u000fJ\u0006\u0010>\u001a\u00020\u000fJ\u001e\u0010?\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\rH\u0002J\b\u0010A\u001a\u00020\u000fH\u0002R\u000e\u0010\u0015\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR,\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000RV\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001e\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b3\u0010.¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "extendReadingView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "onDataChangedListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "link", "title", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "changeEditViewCallback", "Lkotlin/Function1;", "", WeChatBrands.Business.GROUP_OPEN, "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "REQUEST_CODE_DEL", "TAG", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "autoCheckClipBoard", "getAutoCheckClipBoard", "()Z", "setAutoCheckClipBoard", "(Z)V", "getChangeEditViewCallback", "()Lkotlin/jvm/functions/Function1;", "editView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "getExtendReadingView", "()Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getOnDataChangedListener", "()Lkotlin/jvm/functions/Function3;", "showingEditView", "getShowingEditView", "setShowingEditView", "value", "succLink", "setSuccLink", "(Ljava/lang/String;)V", "succStyle", "setSuccStyle", "(I)V", "succTitle", "setSuccTitle", "canPost", "closeEditView", "doVerify", "getSuccData", "Lkotlin/Pair;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onKeyboardHeightChanged", "keyboardHeight", "isResized", "openEditView", "refreshClipboardDetect", "setSuccData", "show", "showDelBottomSheet", "FinderExtendReadingVerifier", "plugin-finder_release"})
public final class c implements g {
    private final String TAG = "Finder.FinderExtendReadingManager";
    public boolean UVH = true;
    private int UVI;
    private final q<String, String, Integer, x> UVJ;
    final MMActivity activity;
    h gyh = new h(this.activity);
    final FinderExtendReadingView vUJ;
    final kotlin.g.a.b<Boolean, x> vUK;
    FinderExtendReadingEditView wsP;
    public boolean wsQ;
    private String wsR = "";
    private String wsS = "";
    final int wsT;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "errMsg", "", "link", "title", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "invoke"})
    public static final class f extends kotlin.g.b.q implements s<Integer, String, String, String, Integer, x> {
        final /* synthetic */ c wsV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar) {
            super(5);
            this.wsV = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Integer num, String str, String str2, String str3, Integer num2) {
            AppMethodBeat.i(261559);
            final int intValue = num.intValue();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final int intValue2 = num2.intValue();
            p.h(str5, "link");
            p.h(str6, "title");
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.view.manager.c.f.AnonymousClass1 */
                final /* synthetic */ f UVL;

                {
                    this.UVL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(261558);
                    int i2 = intValue;
                    a aVar = a.wte;
                    if (i2 != a.dHD()) {
                        if (intValue == -4054) {
                            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
                            String str = str4;
                            if (str == null) {
                                str = "";
                            }
                            com.tencent.mm.plugin.finder.spam.a.avm(str);
                        } else {
                            u.makeText(this.UVL.wsV.activity, (int) R.string.cm5, 0).show();
                        }
                        this.UVL.wsV.vUJ.dGG();
                    } else if (p.j(this.UVL.wsV.vUJ.getLink(), str5)) {
                        this.UVL.wsV.az(str5, str6, intValue2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(261558);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(261559);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.g.a.q<? super java.lang.String, ? super java.lang.String, ? super java.lang.Integer, kotlin.x> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public c(MMActivity mMActivity, FinderExtendReadingView finderExtendReadingView, q<? super String, ? super String, ? super Integer, x> qVar, kotlin.g.a.b<? super Boolean, x> bVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(finderExtendReadingView, "extendReadingView");
        p.h(qVar, "onDataChangedListener");
        p.h(bVar, "changeEditViewCallback");
        AppMethodBeat.i(261564);
        this.activity = mMActivity;
        this.vUJ = finderExtendReadingView;
        this.UVJ = qVar;
        this.vUK = bVar;
        this.gyh.setKeyboardHeightObserver(this);
        FinderExtendReadingView finderExtendReadingView2 = this.vUJ;
        AnonymousClass1 r0 = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass1 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(168502);
                c cVar = this.wsV;
                cVar.vUK.invoke(Boolean.TRUE);
                cVar.wsQ = true;
                cVar.wsP.setVisibility(0);
                cVar.dHC();
                cVar.gyh.start();
                cVar.wsP.wlH.requestFocus();
                cVar.activity.showVKB();
                x xVar = x.SXb;
                AppMethodBeat.o(168502);
                return xVar;
            }
        };
        AnonymousClass2 r1 = new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass2 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(168503);
                p.h(str, "link");
                c cVar = this.wsV;
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) cVar.activity, 1, true);
                eVar.a(new d(cVar));
                eVar.a(new e(cVar));
                eVar.dGm();
                x xVar = x.SXb;
                AppMethodBeat.o(168503);
                return xVar;
            }
        };
        AnonymousClass3 r2 = new q<String, String, Integer, x>(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass3 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(String str, String str2, Integer num) {
                AppMethodBeat.i(261556);
                String str3 = str;
                String str4 = str2;
                int intValue = num.intValue();
                p.h(str3, "title");
                p.h(str4, "link");
                this.wsV.az(str4, str3, intValue);
                x xVar = x.SXb;
                AppMethodBeat.o(261556);
                return xVar;
            }
        };
        p.h(r0, "emptyClickListener");
        p.h(r1, "filledClickListener");
        p.h(r2, "tipsClickListener");
        finderExtendReadingView2.wlL = r0;
        finderExtendReadingView2.wlM = r1;
        finderExtendReadingView2.UVt = r2;
        this.wsP = new FinderExtendReadingEditView(this.activity);
        FinderExtendReadingEditView finderExtendReadingEditView = this.wsP;
        AnonymousClass4 r02 = new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass4 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(168507);
                String str2 = str;
                p.h(str2, "link");
                this.wsV.dHA();
                this.wsV.bye(str2);
                x xVar = x.SXb;
                AppMethodBeat.o(168507);
                return xVar;
            }
        };
        AnonymousClass5 r12 = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass5 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(168508);
                this.wsV.dHA();
                x xVar = x.SXb;
                AppMethodBeat.o(168508);
                return xVar;
            }
        };
        p.h(r02, "onAddListener");
        p.h(r12, "onCloseListener");
        finderExtendReadingEditView.wlE = r02;
        finderExtendReadingEditView.wlF = r12;
        Window window = this.activity.getWindow();
        p.g(window, "activity.window");
        window.getDecorView().post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.manager.c.AnonymousClass6 */
            final /* synthetic */ c wsV;

            {
                this.wsV = r1;
            }

            public final void run() {
                AppMethodBeat.i(168509);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                Window window = this.wsV.activity.getWindow();
                p.g(window, "activity.window");
                View decorView = window.getDecorView();
                if (decorView == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                    AppMethodBeat.o(168509);
                    throw tVar;
                }
                ((FrameLayout) decorView).addView(this.wsV.wsP, layoutParams);
                this.wsV.wsP.setVisibility(8);
                AppMethodBeat.o(168509);
            }
        });
        this.wsT = 1;
        AppMethodBeat.o(261564);
    }

    /* access modifiers changed from: package-private */
    public final void awT(String str) {
        AppMethodBeat.i(168519);
        this.wsR = str;
        this.UVJ.d(str, this.wsS, Integer.valueOf(this.UVI));
        AppMethodBeat.o(168519);
    }

    /* access modifiers changed from: package-private */
    public final void awU(String str) {
        AppMethodBeat.i(168520);
        this.wsS = str;
        this.UVJ.d(this.wsR, str, Integer.valueOf(this.UVI));
        AppMethodBeat.o(168520);
    }

    private final void awW(int i2) {
        AppMethodBeat.i(261561);
        this.UVI = i2;
        this.UVJ.d(this.wsR, this.wsS, Integer.valueOf(i2));
        AppMethodBeat.o(261561);
    }

    public final void bye(String str) {
        AppMethodBeat.i(261562);
        p.h(str, "link");
        this.vUJ.setVerifyingState(str);
        a aVar = a.wte;
        a.a(str, new f(this));
        AppMethodBeat.o(261562);
    }

    public final void dHA() {
        AppMethodBeat.i(168521);
        this.vUK.invoke(Boolean.FALSE);
        this.wsQ = false;
        this.gyh.close();
        this.activity.hideVKB();
        hide();
        AppMethodBeat.o(168521);
    }

    public final void az(String str, String str2, int i2) {
        AppMethodBeat.i(261563);
        p.h(str, "link");
        p.h(str2, "title");
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
            awT(str);
            awU(str2);
            awW(i2);
            this.vUJ.ay(str2, str, i2);
        }
        AppMethodBeat.o(261563);
    }

    public final boolean dHB() {
        return !this.vUJ.wlV;
    }

    public final void dHC() {
        AppMethodBeat.i(168524);
        if (!this.UVH) {
            AppMethodBeat.o(168524);
            return;
        }
        this.wsP.post(new b(this));
        AppMethodBeat.o(168524);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ c wsV;

        b(c cVar) {
            this.wsV = cVar;
        }

        public final void run() {
            AppMethodBeat.i(255264);
            this.wsV.wsP.dGE();
            y yVar = y.vXH;
            String dCC = y.dCC();
            a aVar = a.wte;
            a.a(dCC, new s<Integer, String, String, String, Integer, x>(this) {
                /* class com.tencent.mm.plugin.finder.view.manager.c.b.AnonymousClass1 */
                final /* synthetic */ b wth;

                {
                    this.wth = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.s
                public final /* synthetic */ x a(Integer num, String str, String str2, String str3, Integer num2) {
                    AppMethodBeat.i(261560);
                    int intValue = num.intValue();
                    final String str4 = str2;
                    final String str5 = str3;
                    final int intValue2 = num2.intValue();
                    p.h(str4, "link");
                    p.h(str5, "title");
                    a aVar = a.wte;
                    if (intValue == a.dHD()) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.view.manager.c.b.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 wti;

                            {
                                this.wti = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(255262);
                                this.wti.wth.wsV.vUJ.c(str5, str4, Integer.valueOf(intValue2));
                                x xVar = x.SXb;
                                AppMethodBeat.o(255262);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(261560);
                    return xVar;
                }
            });
            AppMethodBeat.o(255264);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager$show$a$1", "Landroid/view/animation/Animation;", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.manager.c$c  reason: collision with other inner class name */
    public static final class C1345c extends Animation {
        final /* synthetic */ c wsV;
        final /* synthetic */ int wtj;

        C1345c(c cVar, int i2) {
            this.wsV = cVar;
            this.wtj = i2;
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(168516);
            p.h(transformation, "t");
            ViewGroup.LayoutParams layoutParams = this.wsV.wsP.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(168516);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = (int) (((float) this.wtj) * f2);
            this.wsV.wsP.setLayoutParams(layoutParams2);
            AppMethodBeat.o(168516);
        }
    }

    private final void hide() {
        AppMethodBeat.i(168526);
        this.wsP.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.wsP.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(168526);
            throw tVar;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = 0;
        this.wsP.setLayoutParams(layoutParams2);
        AppMethodBeat.o(168526);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d implements o.f {
        final /* synthetic */ c wsV;

        d(c cVar) {
            this.wsV = cVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(168517);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.a(this.wsV.wsT, -65536, this.wsV.activity.getResources().getString(R.string.tf));
            }
            AppMethodBeat.o(168517);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class e implements o.g {
        final /* synthetic */ c wsV;

        e(c cVar) {
            this.wsV = cVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(168518);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.wsV.wsT) {
                this.wsV.vUJ.dGG();
                this.wsV.awU("");
                this.wsV.awT("");
            }
            AppMethodBeat.o(168518);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0001\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00102w\u0010(\u001as\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020&0)R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager$FinderExtendReadingVerifier;", "", "()V", "ERROR_CODE_OK", "", "getERROR_CODE_OK", "()I", "ERROR_CODE_OUT_OF_TIME", "getERROR_CODE_OUT_OF_TIME", "ERROR_CODE_PARSE_FAILED", "getERROR_CODE_PARSE_FAILED", "ERROR_CODE_SVR_RESULT_INVALID", "getERROR_CODE_SVR_RESULT_INVALID", "ERROR_CODE_URL_INVALID", "getERROR_CODE_URL_INVALID", "TAG", "", "cacheLinks", "", "getCacheLinks", "()Ljava/util/Map;", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "pattern2", "getPattern2", "setPattern2", "match", "p", "html", "readInputStream", "", "inStream", "Ljava/io/InputStream;", "verify", "", "link", "onResult", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", ShareConstants.MEDIA_URI, "title", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "plugin-finder_release"})
    public static final class a {
        private static final String TAG = TAG;
        private static final Map<String, String> wsY = new LinkedHashMap();
        private static final int wsZ = 0;
        private static final int wta = -100;
        private static final int wtb = wtb;
        private static final int wtc = wtc;
        private static final int wtd = wtd;
        public static final a wte = new a();

        static {
            AppMethodBeat.i(168513);
            AppMethodBeat.o(168513);
        }

        private a() {
        }

        public static int dHD() {
            return wsZ;
        }

        public static int dHE() {
            return wta;
        }

        public static int dHF() {
            return wtc;
        }

        public static int dHG() {
            return wtd;
        }

        public static void a(String str, s<? super Integer, ? super String, ? super String, ? super String, ? super Integer, x> sVar) {
            AppMethodBeat.i(261557);
            p.h(str, "link");
            p.h(sVar, "onResult");
            if (!wsY.containsKey(str) || Util.isNullOrNil(wsY.get(str))) {
                com.tencent.f.h.RTc.aX(new RunnableC1344a(str, sVar));
                AppMethodBeat.o(261557);
                return;
            }
            String str2 = wsY.get(str);
            if (str2 == null) {
                p.hyc();
            }
            sVar.a(0, "", str, str2, 0);
            String str3 = TAG;
            StringBuilder append = new StringBuilder("verify in cache ").append(str).append(", ");
            String str4 = wsY.get(str);
            if (str4 == null) {
                p.hyc();
            }
            Log.i(str3, append.append(str4).toString());
            AppMethodBeat.o(261557);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.finder.view.manager.c$a$a  reason: collision with other inner class name */
        public static final class RunnableC1344a implements Runnable {
            final /* synthetic */ s UVK;
            final /* synthetic */ String nNF;

            RunnableC1344a(String str, s sVar) {
                this.nNF = str;
                this.UVK = sVar;
            }

            public final void run() {
                AppMethodBeat.i(168510);
                a aVar = a.wte;
                Log.i(a.TAG, "verify " + this.nNF);
                try {
                    String value = com.tencent.mm.n.h.aqJ().getValue("FinderExtendedReadingPrefix");
                    if (Util.isNullOrNil(value)) {
                        value = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + ";";
                    }
                    p.g(value, "prefixs");
                    if (value == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(168510);
                        throw tVar;
                    }
                    ArrayList<String> arrayList = new ArrayList();
                    for (Object obj : n.b(n.trim(value).toString(), new char[]{';'})) {
                        String str = (String) obj;
                        if (str == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                            AppMethodBeat.o(168510);
                            throw tVar2;
                        }
                        if (!Util.isNullOrNil(n.trim(str).toString())) {
                            arrayList.add(obj);
                        }
                    }
                    boolean z = false;
                    for (String str2 : arrayList) {
                        String str3 = this.nNF;
                        if (str3 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(168510);
                            throw tVar3;
                        }
                        String lowerCase = str3.toLowerCase();
                        p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (str2 == null) {
                            t tVar4 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                            AppMethodBeat.o(168510);
                            throw tVar4;
                        } else if (n.J(lowerCase, n.trim(str2).toString(), false)) {
                            z = true;
                        }
                    }
                    if (z) {
                        new ad(this.nNF).aYI().g(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                            /* class com.tencent.mm.plugin.finder.view.manager.c.a.RunnableC1344a.AnonymousClass1 */
                            final /* synthetic */ RunnableC1344a wtg;

                            {
                                this.wtg = r1;
                            }

                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Object call(Object obj) {
                                beh beh;
                                bee bee;
                                beh beh2;
                                bee bee2;
                                int i2 = 0;
                                AppMethodBeat.i(255260);
                                c.a aVar = (c.a) obj;
                                if (aVar.errType == 0 && aVar.errCode == 0) {
                                    String str = (aVar == null || (beh2 = (beh) aVar.iLC) == null || (bee2 = beh2.LOb) == null) ? null : bee2.title;
                                    if (!(aVar == null || (beh = (beh) aVar.iLC) == null || (bee = beh.LOb) == null)) {
                                        i2 = bee.style;
                                    }
                                    if (Util.isNullOrNil(str) || str == null) {
                                        s sVar = this.wtg.UVK;
                                        a aVar2 = a.wte;
                                        sVar.a(Integer.valueOf(a.dHG()), "", this.wtg.nNF, "", Integer.valueOf(i2));
                                    } else {
                                        s sVar2 = this.wtg.UVK;
                                        a aVar3 = a.wte;
                                        sVar2.a(Integer.valueOf(a.dHD()), "", this.wtg.nNF, str, Integer.valueOf(i2));
                                    }
                                } else {
                                    this.wtg.UVK.a(Integer.valueOf(aVar.errCode), aVar.errMsg, this.wtg.nNF, "", 0);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(255260);
                                return xVar;
                            }
                        });
                        AppMethodBeat.o(168510);
                        return;
                    }
                    a aVar2 = a.wte;
                    Log.i(a.TAG, "scheme or host not valid");
                    s sVar = this.UVK;
                    a aVar3 = a.wte;
                    sVar.a(Integer.valueOf(a.dHE()), "", this.nNF, "", 0);
                    AppMethodBeat.o(168510);
                } catch (MalformedURLException e2) {
                    a aVar4 = a.wte;
                    Log.printErrStackTrace(a.TAG, e2, "MalformedURLException", new Object[0]);
                    s sVar2 = this.UVK;
                    a aVar5 = a.wte;
                    sVar2.a(Integer.valueOf(a.dHE()), "", this.nNF, "", 0);
                    AppMethodBeat.o(168510);
                } catch (IOException e3) {
                    a aVar6 = a.wte;
                    Log.printErrStackTrace(a.TAG, e3, "IOException", new Object[0]);
                    s sVar3 = this.UVK;
                    a aVar7 = a.wte;
                    sVar3.a(Integer.valueOf(a.dHF()), "", this.nNF, "", 0);
                    AppMethodBeat.o(168510);
                } catch (Throwable th) {
                    a aVar8 = a.wte;
                    Log.printErrStackTrace(a.TAG, th, "Throwable", new Object[0]);
                    s sVar4 = this.UVK;
                    a aVar9 = a.wte;
                    sVar4.a(Integer.valueOf(a.dHF()), "", this.nNF, "", 0);
                    AppMethodBeat.o(168510);
                }
            }
        }
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(168525);
        ViewGroup.LayoutParams layoutParams = this.wsP.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(168525);
            throw tVar;
        }
        if (((FrameLayout.LayoutParams) layoutParams).bottomMargin != i2) {
            C1345c cVar = new C1345c(this, i2);
            if (i2 != 0) {
                cVar.setDuration(200);
            } else {
                cVar.setDuration(300);
            }
            this.wsP.startAnimation(cVar);
        }
        this.wsP.setVisibility(0);
        AppMethodBeat.o(168525);
    }
}
