package com.tencent.mm.plugin.finder.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", FirebaseAnalytics.b.INDEX, "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
public interface h {
    void D(int i2, int i3, int i4, int i5);

    void a(boolean z, int i2, FinderHomeTabFragment finderHomeTabFragment);

    void onPageScrollStateChanged(int i2);

    void onPageScrolled(int i2, float f2, int i3);
}
