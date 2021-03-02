package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "Landroid/support/v4/view/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "isEnableViewPagerScroll", "", "()Z", "setEnableViewPagerScroll", "(Z)V", "viewRect", "Landroid/graphics/Rect;", "checkChildScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "", "parent", "Landroid/view/ViewGroup;", "x", "y", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "CheckScrollHorizontally", "Companion", "plugin-finder_release"})
public final class FinderViewPager extends ViewPager {
    public static final b Companion = new b((byte) 0);
    public static final String TAG = "Finder.ViewPager";
    private HashMap _$_findViewCache;
    private float historicalX;
    private boolean isEnableViewPagerScroll;
    private final Rect viewRect = new Rect();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "", "canScrollHorizontally", "", TencentLocation.EXTRA_DIRECTION, "", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "plugin-finder_release"})
    public interface a {
        boolean a(int i2, ViewGroup viewGroup);
    }

    static {
        AppMethodBeat.i(255023);
        AppMethodBeat.o(255023);
    }

    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(255025);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(255025);
    }

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(255024);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(255024);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderViewPager(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(255021);
        AppMethodBeat.o(255021);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(255022);
        AppMethodBeat.o(255022);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final boolean isEnableViewPagerScroll() {
        return this.isEnableViewPagerScroll;
    }

    public final void setEnableViewPagerScroll(boolean z) {
        this.isEnableViewPagerScroll = z;
    }

    private final boolean checkChildScrollHorizontally(int i2, ViewGroup viewGroup, float f2, float f3) {
        AppMethodBeat.i(255018);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof a) && ((a) childAt).a(i2, viewGroup)) {
                childAt.getGlobalVisibleRect(this.viewRect);
                if (this.viewRect.contains((int) f2, (int) f3)) {
                    AppMethodBeat.o(255018);
                    return true;
                }
            } else if ((childAt instanceof ViewGroup) && checkChildScrollHorizontally(i2, (ViewGroup) childAt, f2, f3)) {
                AppMethodBeat.o(255018);
                return true;
            }
        }
        AppMethodBeat.o(255018);
        return false;
    }

    @Override // android.support.v4.view.ViewPager
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(255019);
        p.h(motionEvent, "ev");
        if (!this.isEnableViewPagerScroll) {
            AppMethodBeat.o(255019);
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.historicalX = motionEvent.getX();
        } else if (checkChildScrollHorizontally((int) (this.historicalX - motionEvent.getX(0)), this, motionEvent.getX(), motionEvent.getY())) {
            AppMethodBeat.o(255019);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(255019);
        return onInterceptTouchEvent;
    }

    @Override // android.support.v4.view.ViewPager
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(255020);
        if (!this.isEnableViewPagerScroll) {
            AppMethodBeat.o(255020);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(255020);
        return onTouchEvent;
    }
}
