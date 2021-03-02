package com.tencent.mm.plugin.finder.view.tabcomp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "getTabLayout", "Landroid/support/design/widget/TabLayout;", "getTabLayoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getViewPager", "Landroid/support/v4/view/ViewPager;", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public interface g {
    void c(Window window);

    TabLayout dHJ();

    HardTouchableLayout dHK();

    ViewPager dHL();

    View getBackBtn();

    int getLayoutId();
}
