package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileViewPager;", "Landroid/support/v4/view/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "app_release"})
public final class BizProfileViewPager extends ViewPager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizProfileViewPager(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(230891);
        AppMethodBeat.o(230891);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizProfileViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(230892);
        AppMethodBeat.o(230892);
    }

    @Override // android.support.v4.view.ViewPager
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.support.v4.view.ViewPager
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
