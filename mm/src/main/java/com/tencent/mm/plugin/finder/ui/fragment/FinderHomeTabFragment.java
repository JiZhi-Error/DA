package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0005¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "tabType", "", "(I)V", "title", "(II)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "setTitle", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onUserVisibleUnFocused", "plugin-finder_release"})
public abstract class FinderHomeTabFragment extends UIComponentFragment {
    public Bundle Ew;
    private HashMap _$_findViewCache;
    public int dLS;
    public int title;

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public FinderHomeTabFragment() {
        this.title = -1;
        this.dLS = -1;
    }

    public FinderHomeTabFragment(byte b2) {
        this.title = -1;
        this.dLS = 106;
    }

    public FinderHomeTabFragment(int i2, int i3) {
        this.title = i2;
        this.dLS = i3;
    }

    public void dlm() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final void onUserVisibleUnFocused() {
        super.onUserVisibleUnFocused();
        this.Ew = null;
    }

    public boolean onBackPressed() {
        return false;
    }
}
