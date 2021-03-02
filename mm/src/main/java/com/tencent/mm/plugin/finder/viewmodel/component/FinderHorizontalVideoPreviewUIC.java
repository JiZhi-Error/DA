package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bo.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0003./0B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J \u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u00060\u000bR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "horizontalFeedId", "", "horizontalLayout", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "getHorizontalLayout", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "horizontalLayout$delegate", "Lkotlin/Lazy;", "isPauseWhenEnterHorizontalPreview", "", "isResumed", "orientationEventListener", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "attachHorizontalLayout", "", "isRemove", "enterHorizontal", "orientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "exitHorizontal", "exitType", "", "handleOrientationChanged", "isEnableHorizontal", "context", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "report21875", "eventCode", "feedId", "", "leaveType", "AnimInfo", "Companion", "HorizontalVideoPreviewLayout", "plugin-finder_release"})
public final class FinderHorizontalVideoPreviewUIC extends UIComponent {
    public static final b wxu = new b((byte) 0);
    private boolean wxp;
    private boolean wxq;
    private final com.tencent.mm.bo.a wxr = new com.tencent.mm.bo.a(getActivity(), new g(this));
    private long wxs;
    private final kotlin.f wxt = kotlin.g.ah(new f(this));

    static {
        AppMethodBeat.i(255683);
        AppMethodBeat.o(255683);
    }

    private final c dIi() {
        AppMethodBeat.i(255675);
        c cVar = (c) this.wxt.getValue();
        AppMethodBeat.o(255675);
        return cVar;
    }

    public static final /* synthetic */ void c(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
        AppMethodBeat.i(255685);
        finderHorizontalVideoPreviewUIC.ph(true);
        AppMethodBeat.o(255685);
    }

    public static final /* synthetic */ c d(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
        AppMethodBeat.i(255686);
        c dIi = finderHorizontalVideoPreviewUIC.dIi();
        AppMethodBeat.o(255686);
        return dIi;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHorizontalVideoPreviewUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255681);
        AppMethodBeat.o(255681);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHorizontalVideoPreviewUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255682);
        AppMethodBeat.o(255682);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$Companion;", "", "()V", "ANIM_DURATION", "", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "lastOrientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
    static final class g implements a.b {
        final /* synthetic */ FinderHorizontalVideoPreviewUIC wxB;

        g(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
            this.wxB = finderHorizontalVideoPreviewUIC;
        }

        @Override // com.tencent.mm.bo.a.b
        public final void a(a.EnumC0280a aVar, a.EnumC0280a aVar2) {
            boolean z = true;
            boolean z2 = false;
            AppMethodBeat.i(255671);
            if (!FinderHorizontalVideoPreviewUIC.fG(this.wxB.getContext())) {
                AppMethodBeat.o(255671);
            } else if (!this.wxB.isUserVisibleFocused()) {
                AppMethodBeat.o(255671);
            } else {
                if (this.wxB.wxq && aVar != aVar2) {
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.view.e eVar = ((FinderCommentDrawerUIC) com.tencent.mm.ui.component.a.b(this.wxB.getActivity()).get(FinderCommentDrawerUIC.class)).tLT;
                    if (eVar == null || !eVar.dGs()) {
                        z = false;
                    }
                    com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                    FinderLikeDrawer finderLikeDrawer = ((FinderFeedFriendLikeDrawerUIC) com.tencent.mm.ui.component.a.b(this.wxB.getActivity()).get(FinderFeedFriendLikeDrawerUIC.class)).wvZ;
                    if (finderLikeDrawer != null) {
                        z2 = finderLikeDrawer.dGs();
                    }
                    Log.i("Finder.HorizontalVideoPreviewUIC", "[onConfigurationChanged] isDrawerOpen=" + z + " isLikeDrawerOpen=" + z2 + " newOrientation=" + aVar2);
                    if (!z && !z2) {
                        FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC = this.wxB;
                        p.g(aVar2, "newOrientation");
                        FinderHorizontalVideoPreviewUIC.a(finderHorizontalVideoPreviewUIC, aVar2);
                    }
                }
                AppMethodBeat.o(255671);
            }
        }
    }

    static /* synthetic */ void a(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
        AppMethodBeat.i(255673);
        finderHorizontalVideoPreviewUIC.Mx(1);
        AppMethodBeat.o(255673);
    }

    private final void Mx(int i2) {
        AppMethodBeat.i(255672);
        if (!dIi().sZd) {
            AppMethodBeat.o(255672);
            return;
        }
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) findViewById(R.id.fbd);
        if (finderMediaBanner != null) {
            finderMediaBanner.setFrozenRecyclerView(false);
        }
        if (dIi().getPreview() instanceof r) {
            dIi().c(i2, new d(this));
            AppMethodBeat.o(255672);
            return;
        }
        dIi().c(i2, new e(this, finderMediaBanner));
        AppMethodBeat.o(255672);
    }

    private final void ph(boolean z) {
        AppMethodBeat.i(255674);
        Log.i("Finder.HorizontalVideoPreviewUIC", "[attachHorizontalLayout] isRemove=".concat(String.valueOf(z)));
        Window window = getActivity().getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup = (ViewGroup) decorView;
        if (viewGroup == null) {
            AppMethodBeat.o(255674);
        } else if (z) {
            viewGroup.removeView(dIi());
            AppMethodBeat.o(255674);
        } else {
            viewGroup.removeView(dIi());
            viewGroup.addView(dIi(), new FrameLayout.LayoutParams(-1, -1));
            AppMethodBeat.o(255674);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255676);
        super.onCreate(bundle);
        this.wxr.enable();
        AppMethodBeat.o(255676);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255677);
        super.onResume();
        this.wxq = true;
        AppMethodBeat.o(255677);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255678);
        super.onPause();
        this.wxq = false;
        AppMethodBeat.o(255678);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255679);
        super.onDestroy();
        this.wxr.disable();
        AppMethodBeat.o(255679);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255680);
        if (dIi().sZd) {
            Mx(1);
            AppMethodBeat.o(255680);
            return true;
        }
        boolean onBackPressed = super.onBackPressed();
        AppMethodBeat.o(255680);
        return onBackPressed;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "", "scale", "", "translationX", "translationY", "rotation", "(FFFF)V", "getRotation", "()F", "getScale", "getTranslationX", "getTranslationY", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a {
        final float rotation;
        final float scale;
        final float translationX;
        final float translationY;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (java.lang.Float.compare(r3.rotation, r4.rotation) == 0) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 255655(0x3e6a7, float:3.58249E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0036
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.a
                if (r0 == 0) goto L_0x003b
                com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC$a r4 = (com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.a) r4
                float r0 = r3.scale
                float r1 = r4.scale
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x003b
                float r0 = r3.translationX
                float r1 = r4.translationX
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x003b
                float r0 = r3.translationY
                float r1 = r4.translationY
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x003b
                float r0 = r3.rotation
                float r1 = r4.rotation
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x003b
            L_0x0036:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x003a:
                return r0
            L_0x003b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(255654);
            int floatToIntBits = (((((Float.floatToIntBits(this.scale) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.rotation);
            AppMethodBeat.o(255654);
            return floatToIntBits;
        }

        public a(float f2, float f3, float f4, float f5) {
            this.scale = f2;
            this.translationX = f3;
            this.translationY = f4;
            this.rotation = f5;
        }

        public final String toString() {
            AppMethodBeat.i(255653);
            String str = "scale=" + this.scale + " translationX=" + this.translationX + " translationY=" + this.translationY + " rotation=" + this.rotation;
            AppMethodBeat.o(255653);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0012J\u001c\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\t2\f\u00108\u001a\b\u0012\u0004\u0012\u00020009R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animInfo", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "getAnimInfo", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "setAnimInfo", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;)V", "bgView", "Landroid/view/View;", "iconLayout", "indexOriginalParent", "getIndexOriginalParent", "()I", "setIndexOriginalParent", "(I)V", "isPreviewing", "", "()Z", "setPreviewing", "(Z)V", "originalParams", "Landroid/view/ViewGroup$LayoutParams;", "getOriginalParams", "()Landroid/view/ViewGroup$LayoutParams;", "setOriginalParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "originalParent", "Landroid/view/ViewGroup;", "getOriginalParent", "()Landroid/view/ViewGroup;", "setOriginalParent", "(Landroid/view/ViewGroup;)V", "preview", "getPreview", "()Landroid/view/View;", "setPreview", "(Landroid/view/View;)V", "addPreview", "", "view", "rotation", "feedId", "", "itemView", "removePreview", "exitType", "finish", "Lkotlin/Function0;", "plugin-finder_release"})
    @SuppressLint({"ResourceType"})
    public final class c extends FrameLayout {
        private final View cBH;
        boolean sZd;
        private a wxA;
        final /* synthetic */ FinderHorizontalVideoPreviewUIC wxB;
        private final FrameLayout wxv = new FrameLayout(getContext());
        private View wxw;
        private ViewGroup wxx;
        private int wxy;
        private ViewGroup.LayoutParams wxz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC, Context context) {
            super(context);
            p.h(context, "context");
            AppMethodBeat.i(255667);
            this.wxB = finderHorizontalVideoPreviewUIC;
            View view = new View(getContext());
            view.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            this.cBH = view;
            addView(this.cBH, new FrameLayout.LayoutParams(-1, -1));
            int dimension = (int) getResources().getDimension(R.dimen.ce);
            int dimension2 = (int) getResources().getDimension(R.dimen.cf);
            int dimension3 = (int) (getResources().getDimension(R.dimen.c5) / 2.0f);
            FrameLayout frameLayout = this.wxv;
            frameLayout.setPadding(dimension3, dimension3, dimension3, dimension3);
            frameLayout.setBackgroundResource(R.drawable.yl);
            this.wxv.setPivotX(((float) dimension2) / 2.0f);
            this.wxv.setPivotY(((float) dimension2) / 2.0f);
            WeImageView weImageView = new WeImageView(getContext());
            weImageView.setImageResource(R.raw.icons_outlined_back);
            weImageView.setIconColor(WebView.NIGHT_MODE_COLOR);
            this.wxv.addView(weImageView, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension2, dimension2);
            layoutParams.setMarginEnd(dimension);
            layoutParams.bottomMargin = dimension;
            layoutParams.gravity = 8388661;
            addView(this.wxv, layoutParams);
            setOnClickListener(AnonymousClass1.wxC);
            this.wxv.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.c.AnonymousClass2 */
                final /* synthetic */ c wxD;

                {
                    this.wxD = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(255658);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FinderHorizontalVideoPreviewUIC.a(this.wxD.wxB);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(255658);
                }
            });
            this.wxy = -1;
            this.wxA = new a(1.0f, 0.0f, 0.0f, 0.0f);
            AppMethodBeat.o(255667);
        }

        public final View getPreview() {
            return this.wxw;
        }

        public final void setPreview(View view) {
            this.wxw = view;
        }

        public final ViewGroup getOriginalParent() {
            return this.wxx;
        }

        public final void setOriginalParent(ViewGroup viewGroup) {
            this.wxx = viewGroup;
        }

        public final int getIndexOriginalParent() {
            return this.wxy;
        }

        public final void setIndexOriginalParent(int i2) {
            this.wxy = i2;
        }

        public final ViewGroup.LayoutParams getOriginalParams() {
            return this.wxz;
        }

        public final void setOriginalParams(ViewGroup.LayoutParams layoutParams) {
            this.wxz = layoutParams;
        }

        public final void setPreviewing(boolean z) {
            this.sZd = z;
        }

        public final a getAnimInfo() {
            return this.wxA;
        }

        public final void setAnimInfo(a aVar) {
            AppMethodBeat.i(255664);
            p.h(aVar, "<set-?>");
            this.wxA = aVar;
            AppMethodBeat.o(255664);
        }

        public final void a(View view, int i2, long j2, View view2) {
            AppMethodBeat.i(255665);
            p.h(view, "view");
            y yVar = y.vXH;
            Window window = this.wxB.getActivity().getWindow();
            p.g(window, "activity.window");
            y.b(window, true);
            FinderHorizontalVideoPreviewUIC.a(this.wxB, 2, com.tencent.mm.ac.d.zs(j2), 0);
            this.sZd = true;
            this.wxw = view;
            ViewParent parent = view.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(255665);
                throw tVar;
            }
            this.wxx = (ViewGroup) parent;
            ViewGroup viewGroup = this.wxx;
            this.wxy = viewGroup != null ? viewGroup.indexOfChild(view) : 0;
            this.wxz = new ViewGroup.LayoutParams(view.getWidth(), view.getHeight());
            this.cBH.setAlpha(0.0f);
            Point az = ao.az(getContext());
            int height = view.getHeight();
            float width = (((float) view.getWidth()) * 1.0f) / ((float) height);
            int i3 = az.x;
            int cR = kotlin.h.a.cR(width * ((float) i3));
            float f2 = (1.0f * ((float) i3)) / ((float) height);
            int[] iArr = new int[2];
            Rect rect = new Rect();
            view.getLocationInWindow(iArr);
            view.getDrawingRect(rect);
            rect.offset(iArr[0], iArr[1]);
            ViewGroup viewGroup2 = this.wxx;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cR, i3);
            layoutParams.gravity = 17;
            addView(view, 1, layoutParams);
            view.setPivotX(((float) cR) / 2.0f);
            view.setPivotY(((float) i3) / 2.0f);
            view.setScaleX(1.0f / f2);
            view.setScaleY(1.0f / f2);
            view.setTranslationX(((float) rect.centerX()) - (((float) az.x) / 2.0f));
            view.setTranslationY(((float) rect.centerY()) - (((float) az.y) / 2.0f));
            this.wxA = new a(view.getScaleX(), view.getTranslationX(), view.getTranslationY(), view.getRotation());
            view.setTag(view2);
            view.animate().rotation((float) i2).translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(400).setListener(new a(view2)).setInterpolator(new DecelerateInterpolator()).start();
            this.cBH.animate().setDuration(400).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).start();
            this.wxv.animate().setDuration(400).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).start();
            ViewGroup.LayoutParams layoutParams2 = this.wxv.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(255665);
                throw tVar2;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            int statusBarHeight = au.getStatusBarHeight(this.wxB.getActivity());
            if (i2 > 0) {
                layoutParams3.setMarginEnd((int) getResources().getDimension(R.dimen.ce));
                layoutParams3.topMargin = statusBarHeight + ((int) getResources().getDimension(R.dimen.cb));
                layoutParams3.gravity = 8388661;
                this.wxv.setRotation(90.0f);
                AppMethodBeat.o(255665);
                return;
            }
            this.wxv.setRotation(-90.0f);
            layoutParams3.setMarginStart((int) getResources().getDimension(R.dimen.ce));
            layoutParams3.bottomMargin = (int) getResources().getDimension(R.dimen.ce);
            layoutParams3.gravity = 8388691;
            AppMethodBeat.o(255665);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$addPreview$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
        public static final class a extends com.tencent.mm.plugin.finder.animation.a {
            final /* synthetic */ View rsM;

            a(View view) {
                this.rsM = view;
            }

            public final void onAnimationEnd(Animator animator) {
                View findViewById;
                AppMethodBeat.i(255659);
                p.h(animator, "animation");
                View view = this.rsM;
                if (view == null || (findViewById = view.findViewById(R.id.x1)) == null) {
                    AppMethodBeat.o(255659);
                    return;
                }
                findViewById.setVisibility(4);
                AppMethodBeat.o(255659);
            }
        }

        public final void c(int i2, kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(255666);
            p.h(aVar, "finish");
            y yVar = y.vXH;
            Window window = this.wxB.getActivity().getWindow();
            p.g(window, "activity.window");
            y.b(window, false);
            View view = this.wxw;
            if (view != null) {
                this.wxv.animate().setInterpolator(new DecelerateInterpolator()).setDuration(400).alpha(0.0f).start();
                this.cBH.animate().setInterpolator(new DecelerateInterpolator()).setDuration(400).alpha(0.0f).start();
                view.animate().cancel();
                view.animate().rotation(this.wxA.rotation).translationX(this.wxA.translationX).translationY(this.wxA.translationY).scaleX(this.wxA.scale).scaleY(this.wxA.scale).setDuration(400).setListener(new b(view, this, aVar, i2)).setInterpolator(new DecelerateInterpolator()).start();
                AppMethodBeat.o(255666);
                return;
            }
            AppMethodBeat.o(255666);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$removePreview$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder_release"})
        public static final class b extends com.tencent.mm.plugin.finder.animation.a {
            final /* synthetic */ View tzy;
            final /* synthetic */ c wxD;
            final /* synthetic */ kotlin.g.a.a wxE;
            final /* synthetic */ int wxF;

            b(View view, c cVar, kotlin.g.a.a aVar, int i2) {
                this.tzy = view;
                this.wxD = cVar;
                this.wxE = aVar;
                this.wxF = i2;
            }

            @Override // com.tencent.mm.plugin.finder.animation.a
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(255662);
                super.onAnimationStart(animator);
                this.wxD.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.c.b.AnonymousClass1 */
                    final /* synthetic */ b wxG;

                    {
                        this.wxG = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(255660);
                        if (this.wxG.tzy.getTag() instanceof View) {
                            Object tag = this.wxG.tzy.getTag();
                            if (tag == null) {
                                t tVar = new t("null cannot be cast to non-null type android.view.View");
                                AppMethodBeat.o(255660);
                                throw tVar;
                            }
                            View findViewById = ((View) tag).findViewById(R.id.x1);
                            if (findViewById != null) {
                                findViewById.setVisibility(0);
                                AppMethodBeat.o(255660);
                                return;
                            }
                        }
                        AppMethodBeat.o(255660);
                    }
                });
                AppMethodBeat.o(255662);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(255663);
                p.h(animator, "animation");
                this.tzy.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC.c.b.AnonymousClass2 */
                    final /* synthetic */ b wxG;

                    {
                        this.wxG = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(255661);
                        this.wxG.wxD.removeView(this.wxG.tzy);
                        this.wxG.tzy.setPivotX(0.0f);
                        this.wxG.tzy.setPivotY(0.0f);
                        this.wxG.tzy.setTranslationX(0.0f);
                        this.wxG.tzy.setTranslationY(0.0f);
                        this.wxG.tzy.setScaleX(1.0f);
                        this.wxG.tzy.setScaleY(1.0f);
                        this.wxG.tzy.setRotation(0.0f);
                        ViewGroup originalParent = this.wxG.wxD.getOriginalParent();
                        if (originalParent != null) {
                            originalParent.removeView(this.wxG.tzy);
                        }
                        ViewGroup originalParent2 = this.wxG.wxD.getOriginalParent();
                        if (originalParent2 != null) {
                            originalParent2.addView(this.wxG.tzy, this.wxG.wxD.getIndexOriginalParent(), this.wxG.wxD.getOriginalParams());
                        }
                        this.wxG.wxE.invoke();
                        FinderHorizontalVideoPreviewUIC.a(this.wxG.wxD.wxB, 3, com.tencent.mm.ac.d.zs(this.wxG.wxD.wxB.wxs), this.wxG.wxF);
                        this.wxG.wxD.setPreviewing(false);
                        AppMethodBeat.o(255661);
                    }
                });
                AppMethodBeat.o(255663);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderHorizontalVideoPreviewUIC wxB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
            super(0);
            this.wxB = finderHorizontalVideoPreviewUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255668);
            FinderHorizontalVideoPreviewUIC.c(this.wxB);
            View preview = FinderHorizontalVideoPreviewUIC.d(this.wxB).getPreview();
            if (preview instanceof r) {
                ((r) preview).setInterceptDetach(false);
                ((r) preview).setPreview(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255668);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderHorizontalVideoPreviewUIC wxB;
        final /* synthetic */ FinderMediaBanner wxH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC, FinderMediaBanner finderMediaBanner) {
            super(0);
            this.wxB = finderHorizontalVideoPreviewUIC;
            this.wxH = finderMediaBanner;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255669);
            FinderHorizontalVideoPreviewUIC.c(this.wxB);
            if (!this.wxB.wxp) {
                this.wxH.setAutoPlay(true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(255669);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<c> {
        final /* synthetic */ FinderHorizontalVideoPreviewUIC wxB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC) {
            super(0);
            this.wxB = finderHorizontalVideoPreviewUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(255670);
            c cVar = new c(this.wxB, this.wxB.getContext());
            AppMethodBeat.o(255670);
            return cVar;
        }
    }

    public static final /* synthetic */ void a(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC, int i2, String str, int i3) {
        bbn bbn;
        AppMethodBeat.i(255684);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(finderHorizontalVideoPreviewUIC.getActivity());
        if (fH == null || (bbn = fH.dIx()) == null) {
            bbn = new bbn();
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("feedid", str);
        jSONObject.put("leave_type", i3);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "JSONObject().apply {\n   …ype)\n        }.toString()");
        h.INSTANCE.a(21875, bbn.sessionId, bbn.sGQ, Integer.valueOf(bbn.tCE), Integer.valueOf(i2), valueOf, "video_card", n.j(jSONObject2, ",", ";", false), bbn.sGE);
        AppMethodBeat.o(255684);
    }

    public static final /* synthetic */ boolean fG(Context context) {
        int i2;
        boolean z;
        AppMethodBeat.i(255687);
        y yVar = y.vXH;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            i2 = fH.tCE;
        } else {
            i2 = Integer.MIN_VALUE;
        }
        if (y.a(yVar, 0, i2, 1)) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwp().value().intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                p.g(sharedPreferences, "context.getSharedPrefere…faultPreferencePath(), 0)");
                boolean z2 = sharedPreferences.getBoolean("settings_landscape_mode", false);
                int i3 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 1);
                if (z2 && i3 == 1) {
                    AppMethodBeat.o(255687);
                    return true;
                }
            }
        }
        AppMethodBeat.o(255687);
        return false;
    }

    public static final /* synthetic */ void a(FinderHorizontalVideoPreviewUIC finderHorizontalVideoPreviewUIC, a.EnumC0280a aVar) {
        View view;
        FinderMediaBanner finderMediaBanner;
        RecyclerHorizontalViewPager pagerView;
        Object obj;
        View findViewById;
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(255688);
        if (aVar == a.EnumC0280a.PORTRAIT || aVar == a.EnumC0280a.REVERSE_PORTRAIT) {
            finderHorizontalVideoPreviewUIC.Mx(0);
            AppMethodBeat.o(255688);
            return;
        }
        if ((aVar == a.EnumC0280a.LANDSCAPE || aVar == a.EnumC0280a.REVERSE_LANDSCAPE) && !finderHorizontalVideoPreviewUIC.dIi().sZd) {
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) finderHorizontalVideoPreviewUIC.findViewById(R.id.h7t);
            RecyclerView recyclerView = refreshLoadMoreLayout != null ? refreshLoadMoreLayout.getRecyclerView() : null;
            if (recyclerView != null) {
                Rect rect = new Rect();
                int childCount = recyclerView.getChildCount();
                int i4 = 0;
                int i5 = 0;
                View view2 = null;
                finderMediaBanner = null;
                while (i4 < childCount) {
                    View childAt = recyclerView.getChildAt(i4);
                    if (!childAt.getGlobalVisibleRect(rect) || i5 >= rect.height()) {
                        i3 = i5;
                        childAt = view2;
                    } else {
                        i3 = rect.height();
                        finderMediaBanner = (FinderMediaBanner) childAt.findViewById(R.id.fbd);
                    }
                    i4++;
                    i5 = i3;
                    view2 = childAt;
                }
                view = view2;
            } else {
                view = null;
                finderMediaBanner = null;
            }
            if (!(finderMediaBanner == null || (pagerView = finderMediaBanner.getPagerView()) == null)) {
                RecyclerView.v ch = pagerView.ch(finderMediaBanner != null ? finderMediaBanner.getFocusPosition() : 0);
                if (ch instanceof com.tencent.mm.view.recyclerview.h) {
                    obj = ((com.tencent.mm.view.recyclerview.h) ch).hgv();
                } else {
                    obj = null;
                }
                finderHorizontalVideoPreviewUIC.wxs = obj instanceof BaseFinderFeed ? ((BaseFinderFeed) obj).lT() : 0;
                if (ch != null && ch.lU() == 4) {
                    FinderVideoLayout finderVideoLayout = (FinderVideoLayout) ch.aus.findViewById(R.id.ckd);
                    if (finderVideoLayout != null) {
                        r videoView = finderVideoLayout.getVideoView();
                        if (videoView == null || videoView.isPlaying()) {
                            r videoView2 = finderVideoLayout.getVideoView();
                            if (videoView2 != null) {
                                if (videoView2.getVideoView().getHeight() < videoView2.getVideoView().getWidth()) {
                                    if (finderMediaBanner != null) {
                                        finderMediaBanner.setFrozenRecyclerView(true);
                                    }
                                    videoView2.setPreview(true);
                                    videoView2.setInterceptDetach(true);
                                    finderHorizontalVideoPreviewUIC.ph(false);
                                    finderHorizontalVideoPreviewUIC.dIi().a(videoView2.getVideoView(), aVar == a.EnumC0280a.LANDSCAPE ? 90 : -90, finderHorizontalVideoPreviewUIC.wxs, view);
                                }
                                AppMethodBeat.o(255688);
                                return;
                            }
                            AppMethodBeat.o(255688);
                            return;
                        }
                        AppMethodBeat.o(255688);
                        return;
                    }
                    AppMethodBeat.o(255688);
                    return;
                } else if (ch == null) {
                    AppMethodBeat.o(255688);
                    return;
                } else if (ch.lU() != 2 || (findViewById = ch.aus.findViewById(R.id.ckc)) == null) {
                    AppMethodBeat.o(255688);
                    return;
                } else {
                    Rect rect2 = new Rect();
                    findViewById.getGlobalVisibleRect(rect2);
                    if (rect2.left <= 5 && rect2.width() > 0 && findViewById.getHeight() < findViewById.getWidth()) {
                        if (finderMediaBanner != null) {
                            finderMediaBanner.setFrozenRecyclerView(true);
                        }
                        if (finderMediaBanner == null || finderMediaBanner.isAutoPlay) {
                            z = false;
                        } else {
                            z = true;
                        }
                        finderHorizontalVideoPreviewUIC.wxp = z;
                        if (finderMediaBanner != null) {
                            finderMediaBanner.setAutoPlay(false);
                        }
                        finderHorizontalVideoPreviewUIC.ph(false);
                        c dIi = finderHorizontalVideoPreviewUIC.dIi();
                        if (aVar == a.EnumC0280a.LANDSCAPE) {
                            i2 = 90;
                        } else {
                            i2 = -90;
                        }
                        dIi.a(findViewById, i2, finderHorizontalVideoPreviewUIC.wxs, view);
                    }
                    AppMethodBeat.o(255688);
                    return;
                }
            }
        }
        AppMethodBeat.o(255688);
    }
}
