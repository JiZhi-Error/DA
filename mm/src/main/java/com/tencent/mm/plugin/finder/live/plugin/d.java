package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.protocal.protobuf.bbn;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f*\u0001(\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0015J\b\u0010<\u001a\u00020:H\u0016J\b\u0010=\u001a\u000208H\u0016J\b\u0010>\u001a\u00020:H\u0016J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0012\u0010C\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010F\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0012\u0010H\u001a\u00020:2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001c\u0010K\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J$\u0010N\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u001a\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020@2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010MJ\u001a\u0010R\u001a\u00020:2\u0006\u0010P\u001a\u00020@2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010MJ$\u0010S\u001a\u00020:2\u0006\u0010P\u001a\u00020@2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010G\u001a\u00020\u0015J\b\u0010T\u001a\u00020:H\u0016J\b\u0010U\u001a\u00020:H\u0016J\u0010\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020\u0015H\u0016J\b\u0010X\u001a\u00020:H\u0016R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006Y"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePlugin;", "vg", "Landroid/view/ViewGroup;", "liveStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "CLEAR_RECOVERY_SCREEN_DURATION", "", "getCLEAR_RECOVERY_SCREEN_DURATION", "()J", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getBasePluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "basePluginLayout$delegate", "Lkotlin/Lazy;", "cacheVisibility", "", "getCacheVisibility", "()I", "setCacheVisibility", "(I)V", "clearStatus", "getClearStatus", "setClearStatus", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveStatus", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "onNetworkChange", "com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "screenClearAnim", "Landroid/animation/ObjectAnimator;", "getScreenClearAnim", "()Landroid/animation/ObjectAnimator;", "setScreenClearAnim", "(Landroid/animation/ObjectAnimator;)V", "screenRecoveryAnim", "getScreenRecoveryAnim", "setScreenRecoveryAnim", "getVg", "()Landroid/view/ViewGroup;", "canClearScreen", "", "changeVisitorRole", "", "liveIdentity", "clearScreen", "isFinished", "mount", "name", "", "networkChange", "status", "onLandscapeAction", "extraMsg", "Landroid/os/Bundle;", "onLandscapeDelayAction", "delayMs", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitAction", "extraData", "", "onPortraitDelayAction", "postLandscapeAction", NativeProtocol.WEB_DIALOG_ACTION, "data", "postPortraitAction", "postPortraitActionDelay", "recoveryScreen", "reset", "setVisible", "visible", "unMount", "plugin-finder_release"})
public class d extends com.tencent.mm.live.c.a {
    private final f ULg;
    public final bbn reportObj;
    public int ulV;
    public int ulW;
    private ObjectAnimator ulX;
    protected ObjectAnimator ulY;
    private final long ulZ;
    private final b uma;
    public final ViewGroup umb;
    public final com.tencent.mm.live.c.b umc;

    public final FinderBaseLivePluginLayout hTt() {
        AppMethodBeat.i(260541);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) this.ULg.getValue();
        AppMethodBeat.o(260541);
        return finderBaseLivePluginLayout;
    }

    public /* synthetic */ d(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        this(viewGroup, bVar, null);
        AppMethodBeat.i(246397);
        AppMethodBeat.o(246397);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, bbn bbn) {
        super(viewGroup, bVar);
        p.h(viewGroup, "vg");
        p.h(bVar, "liveStatus");
        AppMethodBeat.i(260547);
        this.umb = viewGroup;
        this.umc = bVar;
        this.reportObj = bbn;
        this.ULg = g.ah(new C1191d(this));
        this.ulV = this.hwr.getVisibility();
        this.ulW = 65535;
        this.ulZ = 300;
        this.uma = new b(this);
        AppMethodBeat.o(260547);
    }

    public final com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData() {
        AppMethodBeat.i(246389);
        com.tencent.mm.live.c.b bVar = this.umc;
        if (bVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
            AppMethodBeat.o(246389);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = ((FinderBaseLivePluginLayout) bVar).getLiveData();
        AppMethodBeat.o(246389);
        return liveData;
    }

    @Override // com.tencent.mm.live.c.a
    public void mount() {
        AppMethodBeat.i(246390);
        super.mount();
        com.tencent.mm.kernel.g.aAg().a(this.uma);
        AppMethodBeat.o(246390);
    }

    @Override // com.tencent.mm.live.c.a
    public void unMount() {
        AppMethodBeat.i(246391);
        super.unMount();
        com.tencent.mm.kernel.g.aAg().b(this.uma);
        AppMethodBeat.o(246391);
    }

    public void onNewIntent(Intent intent) {
    }

    @Override // com.tencent.mm.live.view.a, com.tencent.mm.live.c.a
    public String name() {
        AppMethodBeat.i(246392);
        String str = getClass().getSimpleName() + '@' + hashCode();
        AppMethodBeat.o(246392);
        return str;
    }

    public void reset() {
    }

    public boolean dgK() {
        return false;
    }

    public void epk() {
        AppMethodBeat.i(260542);
        if (this.ulX == null) {
            this.ulX = ObjectAnimator.ofFloat(this.hwr, "alpha", 1.0f, 0.0f);
            ObjectAnimator objectAnimator = this.ulX;
            if (objectAnimator != null) {
                objectAnimator.setDuration(this.ulZ);
            }
            ObjectAnimator objectAnimator2 = this.ulX;
            if (objectAnimator2 != null) {
                objectAnimator2.addListener(new a(this));
            }
            ObjectAnimator objectAnimator3 = this.ulX;
            if (objectAnimator3 != null) {
                objectAnimator3.setInterpolator(new DecelerateInterpolator());
            }
        }
        ObjectAnimator objectAnimator4 = this.ulX;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.ulX;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
            AppMethodBeat.o(260542);
            return;
        }
        AppMethodBeat.o(260542);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$clearScreen$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ d umd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(d dVar) {
            this.umd = dVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(246386);
            this.umd.rg(this.umd.ulV);
            AppMethodBeat.o(246386);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public void dCW() {
        AppMethodBeat.i(260543);
        if (this.ulY == null) {
            this.ulY = ObjectAnimator.ofFloat(this.hwr, "alpha", 0.0f, 1.0f);
            ObjectAnimator objectAnimator = this.ulY;
            if (objectAnimator != null) {
                objectAnimator.setDuration(this.ulZ);
            }
            ObjectAnimator objectAnimator2 = this.ulY;
            if (objectAnimator2 != null) {
                objectAnimator2.addListener(new c(this));
            }
            ObjectAnimator objectAnimator3 = this.ulX;
            if (objectAnimator3 != null) {
                objectAnimator3.setInterpolator(new AccelerateInterpolator());
            }
        }
        ObjectAnimator objectAnimator4 = this.ulY;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.ulY;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
            AppMethodBeat.o(260543);
            return;
        }
        AppMethodBeat.o(260543);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$recoveryScreen$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ d umd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(d dVar) {
            this.umd = dVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(246388);
            this.umd.rg(this.umd.ulV);
            AppMethodBeat.o(246388);
        }
    }

    public static /* synthetic */ void a(d dVar, String str) {
        AppMethodBeat.i(260544);
        p.h(str, NativeProtocol.WEB_DIALOG_ACTION);
        dVar.c(str, null, 0);
        AppMethodBeat.o(260544);
    }

    public static /* synthetic */ void a(d dVar, String str, Object obj, int i2, int i3) {
        AppMethodBeat.i(260546);
        if ((i3 & 2) != 0) {
            obj = null;
        }
        if ((i3 & 4) != 0) {
            i2 = ViewConfiguration.getJumpTapTimeout();
        }
        dVar.c(str, obj, i2);
        AppMethodBeat.o(260546);
    }

    private void c(String str, Object obj, int i2) {
        AppMethodBeat.i(260545);
        p.h(str, NativeProtocol.WEB_DIALOG_ACTION);
        Bundle bundle = new Bundle();
        bundle.putString("ACTION_POST_PORTRAIT", str);
        if (i2 > 0) {
            bundle.putInt("ACTION_POST_PORTRAIT_DELAY", i2);
        }
        getLiveData().a(new k("EVENT_POST_PORTRAIT_ACTION", bundle, obj));
        hTt().onPortraitAction(getLiveData().uEg, getLiveData().uEf, bundle, obj);
        AppMethodBeat.o(260545);
    }

    public void ai(Bundle bundle) {
    }

    public void a(Bundle bundle, Object obj, long j2) {
    }

    public final boolean isFinished() {
        AppMethodBeat.i(246395);
        Context context = this.umb.getContext();
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(246395);
            return false;
        }
        boolean isFinishing = ((Activity) context).isFinishing() | ((Activity) context).isDestroyed();
        AppMethodBeat.o(246395);
        return isFinishing;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", UserDataStore.STATE, "", "plugin-finder_release"})
    public static final class b extends p.a {
        final /* synthetic */ d umd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.umd = dVar;
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(246387);
            this.umd.uC(i2);
            AppMethodBeat.o(246387);
        }
    }

    public void uC(int i2) {
    }

    @Override // com.tencent.mm.live.c.a
    public void rg(int i2) {
        AppMethodBeat.i(246396);
        this.ulV = i2;
        if (dgK() && this.ulW == 8) {
            i2 = 8;
        }
        super.rg(i2);
        if (i2 == 0) {
            this.hwr.setAlpha(1.0f);
        }
        AppMethodBeat.o(246396);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.plugin.d$d  reason: collision with other inner class name */
    static final class C1191d extends q implements kotlin.g.a.a<FinderBaseLivePluginLayout> {
        final /* synthetic */ d umd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1191d(d dVar) {
            super(0);
            this.umd = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderBaseLivePluginLayout invoke() {
            AppMethodBeat.i(260540);
            com.tencent.mm.live.c.b bVar = this.umd.umc;
            if (bVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
                AppMethodBeat.o(260540);
                throw tVar;
            }
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) bVar;
            AppMethodBeat.o(260540);
            return finderBaseLivePluginLayout;
        }
    }
}
