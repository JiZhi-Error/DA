package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "plugin-appbrand-integration_release"})
public final class i extends h {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup, true);
        p.h(fragmentActivity, "context");
        p.h(viewGroup, "viewGroup");
        AppMethodBeat.i(180713);
        AppMethodBeat.o(180713);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.h
    public final List<a> a(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(180710);
        p.h(fragmentActivity, "context");
        p.h(viewGroup, "childrenContainer");
        ArrayList arrayList = new ArrayList(2);
        a(arrayList, super.b(fragmentActivity, viewGroup));
        a(arrayList, super.c(fragmentActivity, viewGroup));
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(180710);
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.h
    public final a b(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(261692);
        a b2 = super.b(fragmentActivity, viewGroup);
        AppMethodBeat.o(261692);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.h
    public final a c(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        AppMethodBeat.i(261693);
        a c2 = super.c(fragmentActivity, viewGroup);
        AppMethodBeat.o(261693);
        return c2;
    }
}
