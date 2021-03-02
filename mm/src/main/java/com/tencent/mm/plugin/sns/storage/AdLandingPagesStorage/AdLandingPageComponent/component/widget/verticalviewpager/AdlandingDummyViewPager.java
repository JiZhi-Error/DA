package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager extends DummyViewPager {
    private a EhZ = new a(this, (byte) 0);
    public Set<ViewPager.OnPageChangeListener> Eia = new HashSet();

    public AdlandingDummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97055);
        setOnPageChangeListener(this.EhZ);
        AppMethodBeat.o(97055);
    }

    class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        /* synthetic */ a(AdlandingDummyViewPager adlandingDummyViewPager, byte b2) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            AppMethodBeat.i(97052);
            for (ViewPager.OnPageChangeListener onPageChangeListener : AdlandingDummyViewPager.this.Eia) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
            AppMethodBeat.o(97052);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(97053);
            for (ViewPager.OnPageChangeListener onPageChangeListener : AdlandingDummyViewPager.this.Eia) {
                onPageChangeListener.onPageSelected(i2);
            }
            AppMethodBeat.o(97053);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            AppMethodBeat.i(97054);
            if (i2 == 0) {
                AdlandingDummyViewPager.this.Eic = AdlandingDummyViewPager.this.getScrollX();
            }
            for (ViewPager.OnPageChangeListener onPageChangeListener : AdlandingDummyViewPager.this.Eia) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            AppMethodBeat.o(97054);
        }
    }
}
