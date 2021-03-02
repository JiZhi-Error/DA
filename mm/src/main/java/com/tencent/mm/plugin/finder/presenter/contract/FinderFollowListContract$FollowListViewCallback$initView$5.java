package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
public final class FinderFollowListContract$FollowListViewCallback$initView$5 implements MenuItem.OnMenuItemClickListener {
    final /* synthetic */ FinderFollowListContract.FollowListViewCallback uWN;

    public FinderFollowListContract$FollowListViewCallback$initView$5(FinderFollowListContract.FollowListViewCallback followListViewCallback) {
        this.uWN = followListViewCallback;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(249735);
        this.uWN.activity.finish();
        AppMethodBeat.o(249735);
        return true;
    }
}
