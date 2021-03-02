package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\tR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "INDICATOR_H", "getINDICATOR_H", "()I", "INDICATOR_MARGIN", "getINDICATOR_MARGIN", "INDICATOR_W", "getINDICATOR_W", "TAG", "", "indicatorList", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "getIndicatorList", "()Ljava/util/ArrayList;", "attachViewPager", "", "viewpager", "Landroid/support/v4/view/ViewPager;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "setCurrentChoosedIndicator", "choosedIndicator", "setIndicatorSize", "indicatorSize", "plugin-finder_release"})
public final class FinderLiveGiftPanelIndicator extends LinearLayout {
    private final String TAG = "FinderLiveGiftPanelIndicator";
    private final int uyr;
    private final int uys;
    private final int uyt;
    private final ArrayList<ImageView> uyu;

    public final int getINDICATOR_W() {
        return this.uyr;
    }

    public final int getINDICATOR_H() {
        return this.uys;
    }

    public final int getINDICATOR_MARGIN() {
        return this.uyt;
    }

    public final ArrayList<ImageView> getIndicatorList() {
        return this.uyu;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftPanelIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247448);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        this.uyr = context2.getResources().getDimensionPixelOffset(R.dimen.ct);
        this.uys = this.uyr;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        this.uyt = context3.getResources().getDimensionPixelOffset(R.dimen.bt);
        this.uyu = new ArrayList<>();
        setOrientation(0);
        AppMethodBeat.o(247448);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftPanelIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247449);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        this.uyr = context2.getResources().getDimensionPixelOffset(R.dimen.ct);
        this.uys = this.uyr;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        this.uyt = context3.getResources().getDimensionPixelOffset(R.dimen.bt);
        this.uyu = new ArrayList<>();
        setOrientation(0);
        AppMethodBeat.o(247449);
    }

    public final void setIndicatorSize(int i2) {
        AppMethodBeat.i(247446);
        removeAllViews();
        this.uyu.clear();
        Log.i(this.TAG, "setIndicatorSize indicatorSize:".concat(String.valueOf(i2)));
        if (i2 < 2) {
            AppMethodBeat.o(247446);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.uyr, this.uys);
            layoutParams.setMargins(this.uyt, 0, this.uyt, 0);
            layoutParams.gravity = 16;
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.a1h);
            imageView.setLayoutParams(layoutParams);
            addView(imageView);
            this.uyu.add(imageView);
        }
        AppMethodBeat.o(247446);
    }

    public final void setCurrentChoosedIndicator(int i2) {
        AppMethodBeat.i(247447);
        int size = this.uyu.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == i2) {
                this.uyu.get(i3).setImageResource(R.drawable.a0v);
            } else {
                this.uyu.get(i3).setImageResource(R.drawable.a1h);
            }
        }
        AppMethodBeat.o(247447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator$attachViewPager$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "selectedIndex", "plugin-finder_release"})
    public static final class a implements ViewPager.OnPageChangeListener {
        final /* synthetic */ FinderLiveGiftPanelIndicator uyv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(FinderLiveGiftPanelIndicator finderLiveGiftPanelIndicator) {
            this.uyv = finderLiveGiftPanelIndicator;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(247445);
            this.uyv.setCurrentChoosedIndicator(i2);
            m mVar = m.vVH;
            if (!m.dBP()) {
                com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.aw.GIFT_BOARD_TURN_PAGE, "", 0);
            }
            AppMethodBeat.o(247445);
        }
    }
}
