package com.tencent.mm.plugin.finder.live;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.live.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.view.i;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0013\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020\u0006H\u0016J\n\u00106\u001a\u0004\u0018\u00010\nH\u0016J\b\u00107\u001a\u000204H\u0002J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\fH\u0002J\u0018\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u000fH\u0016J\"\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\fH\u0016J\u0010\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010H\u001a\u000204H\u0016J\"\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0012\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010N\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\"\u0010O\u001a\u0002042\u0006\u0010J\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0010\u0010P\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010Q\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010R\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010S\u001a\u000204H\u0016J\b\u0010T\u001a\u000204H\u0002J\b\u0010U\u001a\u000204H\u0002J\u0010\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020\u000fH\u0002J\b\u0010X\u001a\u000204H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "lifeCycle", "Landroid/arch/lifecycle/Lifecycle;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "isFromFloat", "", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;Lcom/tencent/mm/ui/MMActivity;Landroid/arch/lifecycle/Lifecycle;Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;Z)V", "AUTO_GUIDE_CANCEL", "", "LIVE_HISTORY_GUIDE_HEIGHT", "NEED_SHOW_HISTORY_GUIDE", "feedChangeListener", "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1;", "hasShowNewGuide", "liveLayoutManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "getLiveLayoutManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "setLiveLayoutManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMainHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainHandler$delegate", "Lkotlin/Lazy;", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "onCreateEvent", "recyclerView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;)V", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getRfLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "cancelNewGuide", "", "getActivity", "getPresenter", "initMultiTaskData", "initView", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "isFinish", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onLoadMoreResult", "pullType", "incrementSize", "onNewIntent", "intent", "onPause", "onPreloadResult", "onResume", "onStart", "onStop", "onUninit", "refreshLayoutAction", "refreshLoadMoreAbility", "setNewGuide", "itemCount", "startLiveVideo", "Companion", "plugin-finder_release"})
public final class FinderLiveViewCallback implements UILifecycleObserver, c.b {
    static final String TAG = TAG;
    private static boolean ufL;
    public static final a ufM = new a((byte) 0);
    FinderLiveLayoutManager UJI;
    private final h UJJ;
    private final MMActivity activity;
    private final bbn reportObj;
    FinderLiveRecyclerView ufA;
    private final int ufB;
    private boolean ufC;
    final int ufD;
    private boolean ufE;
    private i ufF;
    private final kotlin.f ufG;
    private boolean ufH;
    final RefreshLoadMoreLayout ufI;
    private Lifecycle ufJ;
    final c.a ufK;
    private final f ufn;
    private final boolean ufp;
    private final com.tencent.mm.plugin.finder.ui.e ufz = new com.tencent.mm.plugin.finder.ui.e();

    /* access modifiers changed from: package-private */
    public final MMHandler getMainHandler() {
        AppMethodBeat.i(245834);
        MMHandler mMHandler = (MMHandler) this.ufG.getValue();
        AppMethodBeat.o(245834);
        return mMHandler;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pos", "", "child", "Landroid/view/View;", "invoke"})
    static final class b extends q implements m<Integer, View, x> {
        final /* synthetic */ FinderLiveViewCallback ufN;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.d ufO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLiveViewCallback finderLiveViewCallback, com.tencent.mm.plugin.finder.live.viewmodel.d dVar) {
            super(2);
            this.ufN = finderLiveViewCallback;
            this.ufO = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, View view) {
            boolean z;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            String str;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar;
            awe awe;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2;
            ViewParent viewParent;
            String str2;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3;
            FinderObject finderObject;
            LiveConfig liveConfig;
            ViewParent viewParent2;
            AppMethodBeat.i(245822);
            int intValue = num.intValue();
            View view2 = view;
            p.h(view2, "child");
            if (this.ufN.ufn.pos == -1) {
                z = this.ufN.ufp;
            } else {
                z = false;
            }
            a aVar = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "onItemSelected:" + intValue + " fromFloat:" + z);
            FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = (FinderLiveVisitorPluginLayout) view2.findViewById(R.id.cz5);
            af afVar = af.waa;
            StringBuilder sb = new StringBuilder();
            af afVar2 = af.waa;
            String sb2 = sb.append(af.dEm()).append(finderLiveVisitorPluginLayout.getData().uCr.getLiveId()).toString();
            ad.a aVar2 = ad.vZu;
            af.a(afVar, sb2, ad.vYL.name, null, false, false, 28);
            RecyclerView.a adapter = this.ufN.ufA.getAdapter();
            if (!(adapter instanceof b)) {
                adapter = null;
            }
            b bVar = (b) adapter;
            if (bVar != null) {
                com.tencent.mm.plugin.finder.live.viewmodel.c IW = bVar.IW(intValue);
                f fVar = this.ufN.ufn;
                p.g(finderLiveVisitorPluginLayout, "pluginLayout");
                p.h(finderLiveVisitorPluginLayout, "newPlugin");
                a aVar3 = FinderLiveViewCallback.ufM;
                String str3 = FinderLiveViewCallback.TAG;
                StringBuilder append = new StringBuilder("before update plugins,pos:").append(fVar.pos).append(",cur view pos:");
                FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout2 = fVar.ufS;
                if (finderLiveVisitorPluginLayout2 == null || finderLiveVisitorPluginLayout2.getParent() == null) {
                    num2 = null;
                } else {
                    FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout3 = fVar.ufS;
                    if (finderLiveVisitorPluginLayout3 != null) {
                        viewParent2 = finderLiveVisitorPluginLayout3.getParent();
                    } else {
                        viewParent2 = null;
                    }
                    if (viewParent2 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(245822);
                        throw tVar;
                    }
                    num2 = Integer.valueOf(WxRecyclerView.bw((ViewGroup) viewParent2));
                }
                Log.i(str3, append.append(num2).toString());
                int i2 = fVar.pos;
                if (!z) {
                    k kVar = k.vkd;
                    if (!k.dpl().vlx) {
                        k kVar2 = k.vkd;
                        s dpl = k.dpl();
                        if (IW == null || (liveConfig = IW.uCr) == null || (str2 = liveConfig.getSessionBuffer()) == null) {
                            str2 = (IW == null || (gVar3 = IW.uCs) == null || (finderObject = gVar3.uDz) == null) ? null : finderObject.sessionBuffer;
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        p.h(str2, "<set-?>");
                        dpl.vlV = str2;
                        com.tencent.mm.plugin.expt.hellhound.a.aox(s.j.COMMENT_SCENE_LIVE_ROOM_SLIDE.scene);
                        k kVar3 = k.vkd;
                        k.dpl().auQ(s.j.COMMENT_SCENE_LIVE_ROOM_SLIDE.scene);
                        k kVar4 = k.vkd;
                        k.dpl().vlw = (long) intValue;
                    }
                }
                FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout4 = fVar.ufS;
                a aVar4 = FinderLiveViewCallback.ufM;
                String str4 = FinderLiveViewCallback.TAG;
                StringBuilder sb3 = new StringBuilder("deactivate plugin pos:");
                if (finderLiveVisitorPluginLayout4 == null || finderLiveVisitorPluginLayout4.getParent() == null) {
                    num3 = null;
                } else {
                    ViewParent parent = finderLiveVisitorPluginLayout4.getParent();
                    if (parent == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(245822);
                        throw tVar2;
                    }
                    num3 = Integer.valueOf(WxRecyclerView.bw((ViewGroup) parent));
                }
                Log.i(str4, sb3.append(num3).toString());
                if (finderLiveVisitorPluginLayout4 != null) {
                    finderLiveVisitorPluginLayout4.reset(false);
                    finderLiveVisitorPluginLayout4.unMount();
                }
                fVar.ufS = finderLiveVisitorPluginLayout;
                fVar.pos = intValue;
                FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout5 = fVar.ufS;
                a aVar5 = FinderLiveViewCallback.ufM;
                String str5 = FinderLiveViewCallback.TAG;
                StringBuilder sb4 = new StringBuilder("activate plugin pos:");
                if (finderLiveVisitorPluginLayout5 != null) {
                    ViewParent parent2 = finderLiveVisitorPluginLayout5.getParent();
                    if (parent2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(245822);
                        throw tVar3;
                    }
                    num4 = Integer.valueOf(WxRecyclerView.bw((ViewGroup) parent2));
                } else {
                    num4 = null;
                }
                Log.i(str5, sb4.append(num4).append(" data:").append(IW).toString());
                if (!(IW == null || finderLiveVisitorPluginLayout5 == null)) {
                    o oVar = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g a2 = o.a(IW);
                    if (a2 != null) {
                        Boolean remove = fVar.UJL.remove(Integer.valueOf(fVar.pos));
                        if (remove == null) {
                            remove = Boolean.FALSE;
                        }
                        p.g(remove, "restartItem.remove(pos) ?: false");
                        boolean booleanValue = remove.booleanValue();
                        o.ujN.a(a2, finderLiveVisitorPluginLayout5, fVar.pos);
                        finderLiveVisitorPluginLayout5.activate(IW, false, z, booleanValue, fVar.pos);
                        finderLiveVisitorPluginLayout5.mount();
                    }
                }
                a aVar6 = FinderLiveViewCallback.ufM;
                String str6 = FinderLiveViewCallback.TAG;
                StringBuilder append2 = new StringBuilder("after update plugins,pos:").append(fVar.pos).append(",cur view pos:");
                FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout6 = fVar.ufS;
                if (finderLiveVisitorPluginLayout6 == null || finderLiveVisitorPluginLayout6.getParent() == null) {
                    num5 = null;
                } else {
                    FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout7 = fVar.ufS;
                    if (finderLiveVisitorPluginLayout7 != null) {
                        viewParent = finderLiveVisitorPluginLayout7.getParent();
                    } else {
                        viewParent = null;
                    }
                    if (viewParent == null) {
                        t tVar4 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(245822);
                        throw tVar4;
                    }
                    num5 = Integer.valueOf(WxRecyclerView.bw((ViewGroup) viewParent));
                }
                Log.i(str6, append2.append(num5).toString());
                if (!(i2 == -1 || i2 == intValue)) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                    if (IW == null || (gVar2 = IW.uCs) == null || (str = gVar2.hwd) == null) {
                        str = "";
                    }
                    iVar.h(ch.COL_USERNAME, str);
                    iVar.h("liveId", com.tencent.mm.plugin.expt.hellhound.core.b.zs((IW == null || (gVar = IW.uCs) == null || (awe = gVar.liveInfo) == null) ? 0 : awe.liveId));
                    com.tencent.mm.plugin.finder.report.live.m.a(s.ar.SlideEnter, iVar.toString());
                    mVar.a(s.at.CloseTypeSlide);
                }
                this.ufO.Jq(intValue);
                c.a aVar7 = this.ufN.ufK;
                if (aVar7 != null && !aVar7.IX(intValue)) {
                    FinderLiveViewCallback.a(this.ufN, this.ufO.uCu.size());
                }
                o oVar2 = o.ujN;
                o.a(FinderLiveViewCallback.c(this.ufN));
                o oVar3 = o.ujN;
                i dfU = o.dfU();
                if (dfU != null) {
                    o oVar4 = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                    if (dfZ != null) {
                        aws aws = dfU.uzL.get(Long.valueOf(dfZ.liveInfo.liveId));
                        if (aws == null) {
                            aws = new aws();
                        }
                        p.g(aws, "multiTaskDataMap[it.live…FinderLiveMultiTaskData()");
                        String str7 = aws.key;
                        if (str7 == null || str7.length() == 0) {
                            dfU.getMainHandler().removeMessages(3);
                            MMHandler mainHandler = dfU.getMainHandler();
                            kotlin.f diC = i.diC();
                            i.a aVar8 = i.uzN;
                            mainHandler.sendEmptyMessageDelayed(3, ((Number) diC.getValue()).longValue());
                        } else {
                            Log.i("FinderLiveMultiTaskManager", "checkAddToHistory: has added, liveId = " + dfZ.liveInfo.liveId + ", objectId = " + dfZ.hFK);
                        }
                    }
                }
            }
            af afVar3 = af.waa;
            StringBuilder sb5 = new StringBuilder();
            af afVar4 = af.waa;
            String sb6 = sb5.append(af.dEm()).append(finderLiveVisitorPluginLayout.getData().uCr.getLiveId()).toString();
            ad.a aVar9 = ad.vZu;
            af.a(afVar3, sb6, ad.vYN.name, null, false, false, 28);
            x xVar = x.SXb;
            AppMethodBeat.o(245822);
            return xVar;
        }
    }

    public FinderLiveViewCallback(RefreshLoadMoreLayout refreshLoadMoreLayout, MMActivity mMActivity, Lifecycle lifecycle, c.a aVar, boolean z) {
        p.h(refreshLoadMoreLayout, "rfLayout");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(245854);
        this.ufI = refreshLoadMoreLayout;
        this.activity = mMActivity;
        this.ufJ = lifecycle;
        this.ufK = aVar;
        this.ufp = z;
        RecyclerView recyclerView = this.ufI.getRecyclerView();
        if (recyclerView == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView");
            AppMethodBeat.o(245854);
            throw tVar;
        }
        this.ufA = (FinderLiveRecyclerView) recyclerView;
        this.ufn = new f(this.ufA);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        this.reportObj = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx();
        this.ufB = au.aD(this.activity) + this.activity.getResources().getDimensionPixelSize(R.dimen.bx);
        this.ufD = 2;
        this.ufG = kotlin.g.ah(new d(this));
        this.UJJ = new h(this);
        AppMethodBeat.o(245854);
    }

    public static final /* synthetic */ void a(FinderLiveViewCallback finderLiveViewCallback, int i2) {
        AppMethodBeat.i(245856);
        finderLiveViewCallback.IY(i2);
        AppMethodBeat.o(245856);
    }

    public static final /* synthetic */ i c(FinderLiveViewCallback finderLiveViewCallback) {
        AppMethodBeat.i(245857);
        i iVar = finderLiveViewCallback.ufF;
        if (iVar == null) {
            p.btv("multiTaskManager");
        }
        AppMethodBeat.o(245857);
        return iVar;
    }

    public static final /* synthetic */ MMHandler e(FinderLiveViewCallback finderLiveViewCallback) {
        AppMethodBeat.i(245858);
        MMHandler mainHandler = finderLiveViewCallback.getMainHandler();
        AppMethodBeat.o(245858);
        return mainHandler;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "inNewGuideStatus", "", "getInNewGuideStatus", "()Z", "setInNewGuideStatus", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245855);
        AppMethodBeat.o(245855);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ FinderLiveViewCallback ufN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveViewCallback finderLiveViewCallback) {
            super(0);
            this.ufN = finderLiveViewCallback;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        static final class a implements MMHandler.Callback {
            final /* synthetic */ d ufP;

            a(d dVar) {
                this.ufP = dVar;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(245824);
                if (message.what == this.ufP.ufN.ufD) {
                    a aVar = FinderLiveViewCallback.ufM;
                    FinderLiveViewCallback.ufL = false;
                    this.ufP.ufN.ufz.f(this.ufP.ufN.ufA);
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_SHOW_LIVE_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
                }
                AppMethodBeat.o(245824);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(245825);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper(), new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(245825);
            return mMHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class h extends IListener<hn> {
        final /* synthetic */ FinderLiveViewCallback ufN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderLiveViewCallback finderLiveViewCallback) {
            this.ufN = finderLiveViewCallback;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(260388);
            hn hnVar2 = hnVar;
            p.h(hnVar2, "event");
            switch (hnVar2.dLW.type) {
                case 14:
                    this.ufN.ufA.post(new a(this));
                    break;
            }
            AppMethodBeat.o(260388);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h UJK;

            a(h hVar) {
                this.UJK = hVar;
            }

            public final void run() {
                ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList;
                AppMethodBeat.i(260387);
                int i2 = this.UJK.ufN.ufn.pos;
                o oVar = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
                int size = (dfY == null || (arrayList = dfY.uCu) == null) ? 0 : arrayList.size();
                a aVar = FinderLiveViewCallback.ufM;
                Log.i(FinderLiveViewCallback.TAG, "TYPE_LIVE_RESTART curPos:" + i2 + ",size:" + size + '!');
                if (i2 < 0) {
                    AppMethodBeat.o(260387);
                    return;
                }
                if (size > i2) {
                    this.UJK.ufN.ufn.UJL.put(Integer.valueOf(i2), Boolean.TRUE);
                    RecyclerView.a adapter = this.UJK.ufN.ufA.getAdapter();
                    if (adapter != null) {
                        adapter.aq(i2, 1);
                    }
                    FinderLiveLayoutManager finderLiveLayoutManager = this.UJK.ufN.UJI;
                    if (finderLiveLayoutManager != null) {
                        finderLiveLayoutManager.uyI = true;
                        AppMethodBeat.o(260387);
                        return;
                    }
                }
                AppMethodBeat.o(260387);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderLiveViewCallback ufN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderLiveViewCallback finderLiveViewCallback) {
            this.ufN = finderLiveViewCallback;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View view;
            View view2 = null;
            AppMethodBeat.i(245826);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            c.a aVar = this.ufN.ufK;
            Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.deM()) : null;
            a aVar2 = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "onLoadMoreBegin flingUpType:".concat(String.valueOf(valueOf)));
            View footer$7529eef0 = this.ufN.ufI.getFooter$7529eef0();
            if (footer$7529eef0 != null) {
                view = footer$7529eef0.findViewById(R.id.epq);
            } else {
                view = null;
            }
            if (!(view instanceof MMProcessBar)) {
                view = null;
            }
            MMProcessBar mMProcessBar = (MMProcessBar) view;
            View footer$7529eef02 = this.ufN.ufI.getFooter$7529eef0();
            if (footer$7529eef02 != null) {
                view2 = footer$7529eef02.findViewById(R.id.eoy);
            }
            if (p.j(valueOf, Boolean.TRUE)) {
                if (mMProcessBar != null) {
                    mMProcessBar.setVisibility(8);
                }
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                this.ufN.ufI.apT(0);
            } else {
                if (mMProcessBar != null) {
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    mMProcessBar.setBackground$255f295(context.getResources().getColor(R.color.am));
                }
                if (mMProcessBar != null) {
                    mMProcessBar.setVisibility(0);
                }
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                c.a aVar3 = this.ufN.ufK;
                if (aVar3 != null) {
                    aVar3.boE();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(245826);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(245827);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            a aVar = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "onLoadMoreEnd");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(245827);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(245828);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            a aVar = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "onRefreshBegin");
            this.ufN.ufI.apS(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(245828);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(245829);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            a aVar = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "onRefreshEnd");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$refreshLayoutAction$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(245829);
        }
    }

    private final void deO() {
        AppMethodBeat.i(245836);
        this.ufI.setActionCallback(new e(this));
        AppMethodBeat.o(245836);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(245838);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(245838);
            return;
        }
        AppMethodBeat.o(245838);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(245839);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.onNewIntent(intent);
            AppMethodBeat.o(245839);
            return;
        }
        AppMethodBeat.o(245839);
    }

    public final boolean onBackPressed() {
        AppMethodBeat.i(245840);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            boolean onBackPress = finderLiveVisitorPluginLayout.onBackPress();
            AppMethodBeat.o(245840);
            return onBackPress;
        }
        AppMethodBeat.o(245840);
        return false;
    }

    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(245841);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.keyboardChange(z, i2);
            AppMethodBeat.o(245841);
            return;
        }
        AppMethodBeat.o(245841);
    }

    /* access modifiers changed from: package-private */
    public final void IY(int i2) {
        boolean z = true;
        AppMethodBeat.i(245842);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwW().value().intValue() == 0) {
            Log.i(TAG, "FINDER_LIVE_GUIDE_ENABLE false");
            AppMethodBeat.o(245842);
        } else if (this.ufE) {
            AppMethodBeat.o(245842);
        } else {
            this.ufE = true;
            boolean z2 = i2 > 1;
            y yVar = y.vXH;
            if (y.dCU() || !z2) {
                z = false;
            }
            this.ufC = z;
            if (this.ufC) {
                this.ufA.a(new f(this));
                this.ufA.getViewTreeObserver().addOnGlobalLayoutListener(new g(this));
                AppMethodBeat.o(245842);
                return;
            }
            this.ufz.f(this.ufA);
            AppMethodBeat.o(245842);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ FinderLiveViewCallback ufN;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245831);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245831);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderLiveViewCallback finderLiveViewCallback) {
            this.ufN = finderLiveViewCallback;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245830);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                recyclerView.b(this);
                FinderLiveViewCallback finderLiveViewCallback = this.ufN;
                finderLiveViewCallback.getMainHandler().removeMessages(finderLiveViewCallback.ufD);
                finderLiveViewCallback.getMainHandler().sendEmptyMessage(finderLiveViewCallback.ufD);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245830);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/FinderLiveViewCallback$setNewGuide$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ FinderLiveViewCallback ufN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(FinderLiveViewCallback finderLiveViewCallback) {
            this.ufN = finderLiveViewCallback;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(245833);
            this.ufN.ufA.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            com.tencent.mm.ac.d.a(800, new a(this));
            AppMethodBeat.o(245833);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ g ufQ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.ufQ = gVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(245832);
                a aVar = FinderLiveViewCallback.ufM;
                FinderLiveViewCallback.ufL = true;
                this.ufQ.ufN.ufA.a(0, this.ufQ.ufN.ufB, new DecelerateInterpolator());
                FinderLiveViewCallback.e(this.ufQ.ufN).sendEmptyMessageDelayed(this.ufQ.ufN.ufD, 5000);
                x xVar = x.SXb;
                AppMethodBeat.o(245832);
                return xVar;
            }
        }
    }

    public final void a(int i2, com.tencent.mm.plugin.finder.live.viewmodel.d dVar, int i3) {
        ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList;
        View findViewById;
        View findViewById2;
        AppMethodBeat.i(245843);
        Log.i(TAG, "onLoadMoreResult pullType:" + i2 + " increment size:" + i3 + ",init position:" + (dVar != null ? Integer.valueOf(dVar.getInitPos()) : null));
        if (i3 <= 0) {
            View footer$7529eef0 = this.ufI.getFooter$7529eef0();
            if (!(footer$7529eef0 == null || (findViewById2 = footer$7529eef0.findViewById(R.id.epq)) == null)) {
                findViewById2.setVisibility(8);
            }
            View footer$7529eef02 = this.ufI.getFooter$7529eef0();
            if (!(footer$7529eef02 == null || (findViewById = footer$7529eef02.findViewById(R.id.eoy)) == null)) {
                findViewById.setVisibility(0);
            }
        } else {
            View footer$7529eef03 = this.ufI.getFooter$7529eef0();
            if (footer$7529eef03 != null) {
                footer$7529eef03.setVisibility(8);
            }
        }
        this.ufI.apT(i3);
        if (dVar == null || (arrayList = dVar.uCu) == null) {
            AppMethodBeat.o(245843);
            return;
        }
        int size = arrayList.size();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (size > com.tencent.mm.plugin.finder.storage.c.duZ()) {
            int size2 = arrayList.size();
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            int duZ = size2 - com.tencent.mm.plugin.finder.storage.c.duZ();
            int i4 = duZ;
            while (i4 > 0 && dVar.getInitPos() > 0) {
                arrayList.remove(0);
                i4--;
                dVar.Jq(dVar.getInitPos() - 1);
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder("max live size:");
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            Log.i(str, sb.append(com.tencent.mm.plugin.finder.storage.c.duZ()).append(",delete ").append(duZ - i4).append(" old live data!").toString());
        }
        int initPos = dVar.getInitPos() + 1;
        boolean deQ = deQ();
        if (!deQ) {
            int size3 = dVar.uCu.size();
            if (initPos >= 0 && size3 > initPos) {
                RecyclerView.a adapter = this.ufA.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                FinderLiveRecyclerView finderLiveRecyclerView = this.ufA;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(initPos, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(finderLiveRecyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult", "(ILcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                finderLiveRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(finderLiveRecyclerView, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "onLoadMoreResult", "(ILcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(245843);
                return;
            }
        }
        Log.i(TAG, "onLoadMoreResult isFinish:" + deQ + ", nextPosition:" + initPos + ", size:" + dVar.uCu.size());
        AppMethodBeat.o(245843);
    }

    /* access modifiers changed from: package-private */
    public final boolean deQ() {
        AppMethodBeat.i(245844);
        boolean isFinishing = this.activity.isFinishing() | this.activity.isDestroyed();
        AppMethodBeat.o(245844);
        return isFinishing;
    }

    public final void deR() {
        AppMethodBeat.i(245845);
        Log.i(TAG, "[LiveLifecycle]onUninit ".concat(String.valueOf(this)));
        this.ufn.release();
        AppMethodBeat.o(245845);
    }

    public final void MC() {
        AppMethodBeat.i(245846);
        Log.i(TAG, "[LiveLifecycle]onInit ".concat(String.valueOf(this)));
        AppMethodBeat.o(245846);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(245847);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + lifecycleOwner);
        this.UJJ.alive();
        this.ufH = true;
        AppMethodBeat.o(245847);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(245848);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + lifecycleOwner);
        k kVar = k.vkd;
        k.dpl().vlx = true;
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            dfZ.uDS = true;
        }
        o oVar2 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
        if (dfZ2 != null) {
            dfZ2.uEv = false;
        }
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
        Log.i(TAG, "startLiveVideo,float mode:" + aEf.hAz.isFloatMode() + ", normal mode:" + aEf.hAz.isNormalMode());
        if (aEf.hAz.isFloatMode()) {
            aEf.aBU();
        }
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.start();
            AppMethodBeat.o(245848);
            return;
        }
        AppMethodBeat.o(245848);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        Context context;
        Resources resources;
        Configuration configuration;
        s.al alVar;
        AppMethodBeat.i(245849);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + lifecycleOwner);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.resume();
        }
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            dfZ.uDS = true;
        }
        o oVar2 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
        if (dfZ2 != null) {
            dfZ2.uEv = false;
        }
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout2 = this.ufn.ufS;
        Integer videoOrientationPluginVisiableVisable = finderLiveVisitorPluginLayout2 != null ? finderLiveVisitorPluginLayout2.getVideoOrientationPluginVisiableVisable() : null;
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout3 = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout3 == null || (context = finderLiveVisitorPluginLayout3.getContext()) == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            AppMethodBeat.o(245849);
            return;
        }
        int i2 = configuration.orientation;
        if (this.ufH) {
            alVar = s.al.FROM_ONCREATE;
        } else {
            alVar = s.al.FROM_ONRESUME;
        }
        com.tencent.mm.plugin.finder.report.live.m.vli.a(videoOrientationPluginVisiableVisable, i2, alVar);
        AppMethodBeat.o(245849);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(245850);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + lifecycleOwner);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.pause();
        }
        this.ufH = false;
        AppMethodBeat.o(245850);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(245851);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + lifecycleOwner);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.ufn.ufS;
        if (finderLiveVisitorPluginLayout != null) {
            finderLiveVisitorPluginLayout.stop();
            AppMethodBeat.o(245851);
            return;
        }
        AppMethodBeat.o(245851);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(245852);
        p.h(lifecycleOwner, "var1");
        Log.i(TAG, "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + lifecycleOwner);
        this.UJJ.dead();
        ufL = false;
        AppMethodBeat.o(245852);
    }

    private final void deS() {
        i iVar;
        FinderLiveViewCallback finderLiveViewCallback;
        AppMethodBeat.i(245853);
        byte[] byteArrayExtra = this.activity.getIntent().getByteArrayExtra("KEY_MULTI_TASK_INFO");
        o oVar = o.ujN;
        i dfU = o.dfU();
        if (dfU != null) {
            iVar = new i(this.activity, dfU);
            finderLiveViewCallback = this;
        } else {
            iVar = new i(this.activity, byteArrayExtra);
            finderLiveViewCallback = this;
        }
        finderLiveViewCallback.ufF = iVar;
        o oVar2 = o.ujN;
        i iVar2 = this.ufF;
        if (iVar2 == null) {
            p.btv("multiTaskManager");
        }
        o.a(iVar2);
        AppMethodBeat.o(245853);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderLiveViewCallback ufN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLiveViewCallback finderLiveViewCallback) {
            super(0);
            this.ufN = finderLiveViewCallback;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(245823);
            RecyclerView.a adapter = this.ufN.ufA.getAdapter();
            if (adapter != null) {
                i2 = adapter.getItemCount();
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(245823);
            return valueOf;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a0, code lost:
        if (com.tencent.mm.plugin.finder.utils.y.dCU() != false) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.finder.live.viewmodel.d r12) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.FinderLiveViewCallback.a(com.tencent.mm.plugin.finder.live.viewmodel.d):void");
    }

    /* access modifiers changed from: package-private */
    public final void deP() {
        AppMethodBeat.i(245837);
        c.a aVar = this.ufK;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.deK()) : null;
        Log.i(TAG, "refreshLoadMoreAbility:".concat(String.valueOf(valueOf)));
        this.ufI.setEnableNestedScroll(!p.j(valueOf, Boolean.FALSE));
        AppMethodBeat.o(245837);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.activity;
    }
}
