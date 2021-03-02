package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J2\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskViewPager;", "Lcom/tencent/mm/ui/base/CustomViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mConsumeTouchEvent", "", "mGalleryPagerWidth", "", "mOnlySlideBySide", "mSideGalleryExposeWidth", "canScroll", "v", "Landroid/view/View;", "checkV", "dx", "x", "y", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "setCanOnlySlideBySide", "enable", "setDisplayMetrics", "pagerWidth", "sideItemDisplayWidth", "plugin-multitask_release"})
public class MultiTaskViewPager extends CustomViewPager {
    private boolean Adp;

    public MultiTaskViewPager(Context context) {
        super(context);
    }

    public MultiTaskViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setCanOnlySlideBySide(boolean z) {
        this.Adp = z;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(200760);
        if (this.Adp) {
            AppMethodBeat.o(200760);
            return true;
        }
        if ((view instanceof ViewGroup) && ((ViewGroup) view).getVisibility() == 0) {
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = ((ViewGroup) view).getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = ((ViewGroup) view).getChildAt(childCount);
                int i5 = i3 + scrollX;
                p.g(childAt, "child");
                if (i5 >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && canScroll(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop()) && childAt.isEnabled()) {
                    AppMethodBeat.o(200760);
                    return true;
                }
            }
        }
        if (!z || !u.n(view, -i2) || view == null || view.getVisibility() != 0) {
            AppMethodBeat.o(200760);
            return false;
        }
        AppMethodBeat.o(200760);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(200761);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(200761);
    }
}
