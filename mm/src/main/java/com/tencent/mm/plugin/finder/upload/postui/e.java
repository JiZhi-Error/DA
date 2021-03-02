package com.tencent.mm.plugin.finder.upload.postui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderChooseNewsView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "newsView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getNewsView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "canPost", "", "isChecked", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder_release"})
public final class e {
    public final MMActivity activity;
    public final FinderChooseNewsView vUT;

    public e(MMActivity mMActivity, FinderChooseNewsView finderChooseNewsView) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(finderChooseNewsView, "newsView");
        AppMethodBeat.i(253252);
        this.activity = mMActivity;
        this.vUT = finderChooseNewsView;
        AppMethodBeat.o(253252);
    }

    public final boolean isChecked() {
        AppMethodBeat.i(253251);
        y yVar = y.vXH;
        if (!y.dCH() || !this.vUT.isChecked()) {
            AppMethodBeat.o(253251);
            return false;
        }
        AppMethodBeat.o(253251);
        return true;
    }
}
