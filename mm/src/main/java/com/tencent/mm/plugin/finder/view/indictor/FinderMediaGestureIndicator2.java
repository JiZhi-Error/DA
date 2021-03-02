package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.d;
import com.tencent.mm.view.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator2;", "Lcom/tencent/mm/view/MediaBannerIndicator;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "canScrollHorizontally", "", TencentLocation.EXTRA_DIRECTION, "parent", "Landroid/view/ViewGroup;", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class FinderMediaGestureIndicator2 extends MediaBannerIndicator implements FinderViewPager.a {
    private float deo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMediaGestureIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255244);
        setIndicatorWidth((int) getResources().getDimension(R.dimen.ct));
        setIndicatorMargin(d.e(getContext(), 3.0f));
        setUnSelectDrawable(getContext().getDrawable(R.drawable.za));
        setSelectDrawable(getContext().getDrawable(R.drawable.zb));
        AppMethodBeat.o(255244);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMediaGestureIndicator2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255245);
        setIndicatorWidth((int) getResources().getDimension(R.dimen.ct));
        setIndicatorMargin(d.e(getContext(), 3.0f));
        setUnSelectDrawable(getContext().getDrawable(R.drawable.za));
        setSelectDrawable(getContext().getDrawable(R.drawable.zb));
        AppMethodBeat.o(255245);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(255242);
        p.h(motionEvent, "event");
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.deo = motionEvent.getX();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            float x = motionEvent.getX() - this.deo;
            if (Math.abs(x) >= 15.0f) {
                if (x < 0.0f) {
                    h.a onSelectedPageListener = getOnSelectedPageListener();
                    if (onSelectedPageListener != null) {
                        onSelectedPageListener.Ir(Math.min(getCurrentIndex() + 1, getCount() - 1));
                    }
                } else {
                    h.a onSelectedPageListener2 = getOnSelectedPageListener();
                    if (onSelectedPageListener2 != null) {
                        onSelectedPageListener2.Ir(Math.max(getCurrentIndex() - 1, 0));
                    }
                }
            } else if (this.deo < ((float) getWidth()) / 2.0f) {
                h.a onSelectedPageListener3 = getOnSelectedPageListener();
                if (onSelectedPageListener3 != null) {
                    onSelectedPageListener3.Ir(Math.max(getCurrentIndex() - 1, 0));
                }
            } else {
                h.a onSelectedPageListener4 = getOnSelectedPageListener();
                if (onSelectedPageListener4 != null) {
                    onSelectedPageListener4.Ir(Math.min(getCurrentIndex() + 1, getCount() - 1));
                }
            }
        }
        AppMethodBeat.o(255242);
        return true;
    }

    public final boolean canScrollHorizontally(int i2) {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderViewPager.a
    public final boolean a(int i2, ViewGroup viewGroup) {
        AppMethodBeat.i(255243);
        p.h(viewGroup, "parent");
        AppMethodBeat.o(255243);
        return true;
    }
}
