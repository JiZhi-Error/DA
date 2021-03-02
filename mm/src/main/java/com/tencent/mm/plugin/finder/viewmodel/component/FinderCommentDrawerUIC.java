package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "isDrawerInit", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC extends UIComponent {
    public static final a wvo = new a((byte) 0);
    public e tLT;

    static {
        AppMethodBeat.i(255446);
        AppMethodBeat.o(255446);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentDrawerUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255445);
        AppMethodBeat.o(255445);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(255439);
        String stringExtra = getIntent().getStringExtra("finder_username");
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
        if (stringExtra != null) {
            z = stringExtra.equals(z.aUg());
        } else {
            z = false;
        }
        boolean z2 = z && booleanExtra;
        e.a aVar = e.wky;
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(255439);
            throw tVar;
        }
        MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) activity;
        Window window = getActivity().getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        p.g(decorView, "activity.window.decorView");
        this.tLT = e.a.a(mMFragmentActivity, decorView, z2 ? 1 : 2, false, 0, 24);
        AppMethodBeat.o(255439);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255440);
        e eVar = this.tLT;
        if (eVar == null || !eVar.dGs()) {
            AppMethodBeat.o(255440);
            return false;
        }
        e eVar2 = this.tLT;
        if (eVar2 != null) {
            eVar2.dGr();
        }
        AppMethodBeat.o(255440);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(255441);
        super.onActivityResult(i2, i3, intent);
        e eVar = this.tLT;
        if (eVar != null) {
            eVar.d(i2, intent);
            AppMethodBeat.o(255441);
            return;
        }
        AppMethodBeat.o(255441);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255442);
        super.onResume();
        e eVar = this.tLT;
        if (eVar != null) {
            eVar.onUIResume();
            AppMethodBeat.o(255442);
            return;
        }
        AppMethodBeat.o(255442);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255443);
        super.onPause();
        AppMethodBeat.o(255443);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255444);
        e eVar = this.tLT;
        if (eVar != null) {
            eVar.onDetach();
            AppMethodBeat.o(255444);
            return;
        }
        AppMethodBeat.o(255444);
    }
}
