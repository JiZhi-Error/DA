package com.tencent.mm.plugin.mv.ui.uic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/KeyboardProviderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "observerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "", "isResized", "", "onPause", "onResume", "removeObserver", "plugin-mv_release"})
public final class KeyboardProviderUIC extends UIComponent implements g {
    public final ArrayList<g> AsQ = new ArrayList<>();
    public h gyh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyboardProviderUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257085);
        AppMethodBeat.o(257085);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257081);
        super.onCreate(bundle);
        this.gyh = new h(getActivity());
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.setKeyboardHeightObserver(this);
            AppMethodBeat.o(257081);
            return;
        }
        AppMethodBeat.o(257081);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(257082);
        super.onResume();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.start();
            AppMethodBeat.o(257082);
            return;
        }
        AppMethodBeat.o(257082);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(257083);
        super.onPause();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
            AppMethodBeat.o(257083);
            return;
        }
        AppMethodBeat.o(257083);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(257084);
        for (g gVar : new ArrayList(this.AsQ)) {
            gVar.y(i2, z);
        }
        AppMethodBeat.o(257084);
    }
}
