package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a;
import java.io.Serializable;

public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int Eic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        AppMethodBeat.i(97057);
        a aVar = new a();
        if (Build.VERSION.SDK_INT >= 11) {
            z = true != (this.mPageTransformer != null) ? true : z;
            this.mPageTransformer = aVar;
            setChildrenDrawingOrderEnabledCompat(true);
            this.mDrawingOrder = 1;
            if (z) {
                populate();
            }
        }
        setOnPageChangeListener(new ViewPager.f() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.f, android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
                AppMethodBeat.i(97056);
                super.onPageScrollStateChanged(i2);
                if (i2 == 0) {
                    DummyViewPager.this.Eic = DummyViewPager.this.getScrollX();
                }
                AppMethodBeat.o(97056);
            }
        });
        AppMethodBeat.o(97057);
    }

    public int getBaseScrollX() {
        return this.Eic;
    }

    public void setBaseScrollX(int i2) {
        this.Eic = i2;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
