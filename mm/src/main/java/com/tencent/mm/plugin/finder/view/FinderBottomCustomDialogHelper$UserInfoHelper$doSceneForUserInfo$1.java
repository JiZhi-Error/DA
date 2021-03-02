package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.ui.base.q;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderBottomCustomDialogHelper$UserInfoHelper$doSceneForUserInfo$1 implements Runnable {
    final /* synthetic */ FinderBottomCustomDialogHelper.UserInfoHelper this$0;

    FinderBottomCustomDialogHelper$UserInfoHelper$doSceneForUserInfo$1(FinderBottomCustomDialogHelper.UserInfoHelper userInfoHelper) {
        this.this$0 = userInfoHelper;
    }

    public final void run() {
        AppMethodBeat.i(254646);
        this.this$0.loadingDialog = q.a(this.this$0.getContext(), this.this$0.getContext().getString(R.string.ekd), true, 3, null);
        AppMethodBeat.o(254646);
    }
}
