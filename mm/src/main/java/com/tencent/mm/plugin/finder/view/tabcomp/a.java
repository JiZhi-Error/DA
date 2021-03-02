package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H'J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "", "()V", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "getLayoutId", "getTabMargin", "", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "plugin-finder_release"})
public abstract class a {
    public int index;

    public abstract void by(String str, boolean z);

    public abstract int getLayoutId();

    public abstract void pd(boolean z);

    public abstract void u(ViewGroup viewGroup);

    public int[] cXC() {
        return new int[]{0, 0};
    }

    public void a(boolean z, ViewGroup viewGroup) {
        p.h(viewGroup, "tabView");
    }
}
