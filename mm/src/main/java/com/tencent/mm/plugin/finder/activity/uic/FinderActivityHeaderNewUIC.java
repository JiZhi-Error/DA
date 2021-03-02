package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.activity.view.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0006\u0010\u0017\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "headerManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "headerView", "Landroid/view/View;", "isFirstResume", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setCampaignFinished", "plugin-finder_release"})
public final class FinderActivityHeaderNewUIC extends UIComponent {
    private View kgo;
    a trc;
    private boolean vbR = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityHeaderNewUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242067);
        AppMethodBeat.o(242067);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242064);
        super.onCreate(bundle);
        this.kgo = getActivity().findViewById(R.id.f4);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242064);
            throw tVar;
        }
        a aVar = new a((MMActivity) activity);
        aVar.dR(this.kgo);
        this.trc = aVar;
        AppMethodBeat.o(242064);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242065);
        super.onDestroy();
        a aVar = this.trc;
        if (aVar != null) {
            aVar.destroy();
            AppMethodBeat.o(242065);
            return;
        }
        AppMethodBeat.o(242065);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(260091);
        super.onResume();
        if (this.vbR) {
            this.vbR = false;
            AppMethodBeat.o(260091);
            return;
        }
        a aVar = this.trc;
        if (aVar != null) {
            aVar.hSA();
            AppMethodBeat.o(260091);
            return;
        }
        AppMethodBeat.o(260091);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        a aVar;
        AppMethodBeat.i(242066);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 20000 && (aVar = this.trc) != null) {
            aVar.hSB();
            AppMethodBeat.o(242066);
            return;
        }
        AppMethodBeat.o(242066);
    }
}
