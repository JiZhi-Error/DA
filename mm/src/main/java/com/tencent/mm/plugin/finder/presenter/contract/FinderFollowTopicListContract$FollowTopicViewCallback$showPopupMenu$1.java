package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$1 implements View.OnCreateContextMenuListener {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicViewCallback uWY;

    FinderFollowTopicListContract$FollowTopicViewCallback$showPopupMenu$1(FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback) {
        this.uWY = followTopicViewCallback;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(249772);
        contextMenu.add(0, FinderFollowTopicListContract.FollowTopicViewCallback.f(this.uWY), 0, FinderFollowTopicListContract.FollowTopicViewCallback.d(this.uWY).getString(R.string.dao));
        AppMethodBeat.o(249772);
    }
}