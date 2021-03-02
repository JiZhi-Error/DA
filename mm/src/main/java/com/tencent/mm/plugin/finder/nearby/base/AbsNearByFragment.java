package com.tencent.mm.plugin.finder.nearby.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0005¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "tabType", "", "(I)V", "titleId", "(II)V", "title", "", "(Ljava/lang/String;I)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitleId", "setTitleId", "getClickTabContextId", "getCommentScene", "getPageName", "getReportType", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onMenuClick", "onResume", "onUserVisibleUnFocused", "onViewCreated", "view", "plugin-finder_release"})
public abstract class AbsNearByFragment extends UIComponentFragment {
    public Bundle Ew;
    private HashMap _$_findViewCache;
    public int dLS;
    public String title;
    public int uQk;

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

    public final void setTitle(String str) {
        p.h(str, "<set-?>");
        this.title = str;
    }

    public AbsNearByFragment() {
        this.title = "";
        this.title = "";
        this.dLS = -1;
    }

    public AbsNearByFragment(int i2, int i3) {
        this.title = "";
        this.uQk = i2;
        this.dLS = i3;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        p.h(view, "view");
        super.onViewCreated(view, bundle);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onCreateBefore(bundle);
        }
    }

    public void dlk() {
    }

    public void dll() {
    }

    public void dlm() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public void onUserVisibleUnFocused() {
        super.onUserVisibleUnFocused();
        this.Ew = null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onResume() {
        d dVar = d.uTq;
        d.b(this);
        super.onResume();
    }

    public int getCommentScene() {
        return 76;
    }

    public int ddN() {
        return 3;
    }

    public String ack() {
        return "1001";
    }

    public String afB() {
        return "1001";
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        p.h(layoutInflater, "inflater");
        if (this.lJI == null) {
            View inflate = aa.jQ(getContext()).inflate(getLayoutId(), viewGroup, false);
            Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                p.g(inflate, "view");
                it.next().setRootView(inflate);
            }
            this.lJI = inflate;
            this.PRX = true;
        }
        return this.lJI;
    }
}
