package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
public final class FinderBottomCustomDialogHelper$Companion$showConfirmDialog$4 implements o.f {
    final /* synthetic */ e $dialog;
    final /* synthetic */ RoundedCornerFrameLayout $rootViewContainer;

    FinderBottomCustomDialogHelper$Companion$showConfirmDialog$4(e eVar, RoundedCornerFrameLayout roundedCornerFrameLayout) {
        this.$dialog = eVar;
        this.$rootViewContainer = roundedCornerFrameLayout;
    }

    @Override // com.tencent.mm.ui.base.o.f
    public final void onCreateMMMenu(m mVar) {
        AppMethodBeat.i(254625);
        mVar.clear();
        this.$dialog.setFooterView(null);
        this.$dialog.setFooterView(this.$rootViewContainer);
        AppMethodBeat.o(254625);
    }
}
