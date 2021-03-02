package com.tencent.mm.plugin.finder.nearby.base;

import android.support.v4.view.ViewPager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "position", "onPageScrolled", "p0", "p1", "", "p2", "onPageSelected", "Companion", "plugin-finder_release"})
public abstract class b implements ViewPager.OnPageChangeListener, a {
    public static final a uQl = new a((byte) 0);
    private final MMActivity activity;
    private final List<AbsNearByFragment> fragments;
    private int lastIndex = -1;
    private int lastType = -1;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(MMActivity mMActivity, List<? extends AbsNearByFragment> list) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(list, "fragments");
        this.activity = mMActivity;
        this.fragments = list;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.lastIndex != i2) {
            int i3 = 0;
            T t = null;
            for (T t2 : this.fragments) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t3 = t2;
                if (i2 == i3) {
                    i3 = i4;
                    t = t3;
                } else {
                    if (this.lastIndex == i3) {
                        t3.onUserVisibleUnFocused();
                        a(t3);
                    }
                    i3 = i4;
                }
            }
            D(this.lastIndex, i2, this.lastType, this.fragments.get(i2).dLS);
            if (t != null) {
                t.onUserVisibleFocused();
                a(t);
            }
        }
        this.lastIndex = i2;
        this.lastType = this.fragments.get(i2).dLS;
    }
}
