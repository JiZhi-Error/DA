package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J*\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J$\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "isLandscape", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onStartNestedScroll", "child", "nestedScrollAxes", "show", "plugin-finder_release"})
public final class FinderLiveShoppingPanel extends LiveBottomSheetPanel {
    private final String TAG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveShoppingPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(248134);
        this.TAG = "FinderLiveShoppingPanel";
        AppMethodBeat.o(248134);
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveShoppingPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(248135);
        AppMethodBeat.o(248135);
    }

    @Override // com.tencent.mm.live.view.LiveBottomSheetPanel
    public final void show() {
        Window window = null;
        AppMethodBeat.i(248129);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i2 = resources.getConfiguration().orientation;
        Log.i(this.TAG, "show orientation:".concat(String.valueOf(i2)));
        if (i2 == 2) {
            b<Boolean, x> onVisibilityListener = getOnVisibilityListener();
            if (onVisibilityListener != null) {
                onVisibilityListener.invoke(Boolean.TRUE);
            }
            animate().setListener(null).translationX(0.0f).start();
            Context context2 = getContext();
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                window = activity.getWindow();
            }
            b(window);
            AppMethodBeat.o(248129);
            return;
        }
        super.show();
        AppMethodBeat.o(248129);
    }

    @Override // com.tencent.mm.live.view.LiveBottomSheetPanel
    public final void hide() {
        AppMethodBeat.i(248130);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i2 = resources.getConfiguration().orientation;
        Log.i(this.TAG, "hide orientation:".concat(String.valueOf(i2)));
        if (i2 == 2) {
            animate().translationX((float) au.az(getContext()).y).setListener(new a(this)).start();
            AppMethodBeat.o(248130);
            return;
        }
        super.hide();
        AppMethodBeat.o(248130);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ FinderLiveShoppingPanel uHd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderLiveShoppingPanel finderLiveShoppingPanel) {
            this.uHd = finderLiveShoppingPanel;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(248128);
            b<Boolean, x> onVisibilityListener = this.uHd.getOnVisibilityListener();
            if (onVisibilityListener != null) {
                onVisibilityListener.invoke(Boolean.FALSE);
                AppMethodBeat.o(248128);
                return;
            }
            AppMethodBeat.o(248128);
        }
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(248131);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(248131);
            return true;
        }
        AppMethodBeat.o(248131);
        return false;
    }

    @Override // com.tencent.mm.live.view.LiveBottomSheetPanel
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        AppMethodBeat.i(248132);
        if (!isLandscape()) {
            boolean onStartNestedScroll = super.onStartNestedScroll(view, view2, i2);
            AppMethodBeat.o(248132);
            return onStartNestedScroll;
        }
        AppMethodBeat.o(248132);
        return false;
    }

    @Override // com.tencent.mm.live.view.LiveBottomSheetPanel
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        AppMethodBeat.i(248133);
        if (!isLandscape()) {
            boolean onNestedFling = super.onNestedFling(view, f2, f3, z);
            AppMethodBeat.o(248133);
            return onNestedFling;
        }
        AppMethodBeat.o(248133);
        return false;
    }
}
