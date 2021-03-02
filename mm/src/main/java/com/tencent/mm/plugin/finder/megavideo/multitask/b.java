package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "mContentView", "Landroid/view/View;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;Landroid/view/View;)V", "contentView", "getContentView", "()Landroid/view/View;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "plugin-finder_release"})
public final class b extends com.tencent.mm.plugin.multitask.a.b {
    private final View mContentView;
    public f uKk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Activity activity, CustomViewPager customViewPager, View view) {
        super(activity, customViewPager);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(view, "mContentView");
        AppMethodBeat.i(248461);
        this.mContentView = view;
        AppMethodBeat.o(248461);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getContentView() {
        AppMethodBeat.i(248459);
        if (getActivity() instanceof MMActivity) {
            View contentView = super.getContentView();
            AppMethodBeat.o(248459);
            return contentView;
        }
        View view = this.mContentView;
        AppMethodBeat.o(248459);
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r0 == null) goto L_0x004f;
     */
    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getMaskView() {
        /*
            r4 = this;
            r1 = 0
            r3 = 248460(0x3ca8c, float:3.48167E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            android.app.Activity r0 = r4.getActivity()
            boolean r0 = r0 instanceof com.tencent.mm.ui.MMActivity
            if (r0 == 0) goto L_0x0059
            com.tencent.mm.plugin.finder.megavideo.ui.f r0 = r4.uKk
            if (r0 == 0) goto L_0x004f
            com.tencent.mm.plugin.finder.megavideo.ui.h$b r0 = r0.uLW
            if (r0 != 0) goto L_0x001d
            java.lang.String r2 = "viewCallback"
            kotlin.g.b.p.btv(r2)
        L_0x001d:
            android.support.v7.widget.RecyclerView r2 = r0.getRecyclerView()
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r2.getLayoutManager()
            if (r0 != 0) goto L_0x0033
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0033:
            android.support.v7.widget.LinearLayoutManager r0 = (android.support.v7.widget.LinearLayoutManager) r0
            int r0 = r0.ks()
            android.support.v7.widget.RecyclerView$v r0 = r2.ch(r0)
            boolean r2 = r0 instanceof com.tencent.mm.view.recyclerview.h
            if (r2 != 0) goto L_0x0042
            r0 = r1
        L_0x0042:
            com.tencent.mm.view.recyclerview.h r0 = (com.tencent.mm.view.recyclerview.h) r0
            if (r0 == 0) goto L_0x0057
            r1 = 2131304549(0x7f092065, float:1.8227244E38)
            android.view.View r0 = r0.Mn(r1)
        L_0x004d:
            if (r0 != 0) goto L_0x005d
        L_0x004f:
            android.view.View r0 = super.getMaskView()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0056:
            return r0
        L_0x0057:
            r0 = r1
            goto L_0x004d
        L_0x0059:
            android.view.View r0 = r4.getContentView()
        L_0x005d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.multitask.b.getMaskView():android.view.View");
    }
}
