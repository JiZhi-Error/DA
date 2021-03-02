package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.c;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorSecDeviceUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onStop", "", "setWindowStyle", "plugin-finder_release"})
public final class FinderLiveAnchorSecDeviceUIC extends FinderLiveAnchorUIC {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveAnchorSecDeviceUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255731);
        AppMethodBeat.o(255731);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC
    public final FinderBaseLivePluginLayout dIk() {
        AppMethodBeat.i(255728);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255728);
            throw tVar;
        }
        c cVar = new c((MMActivity) activity);
        AppMethodBeat.o(255728);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC
    public final void dIl() {
        AppMethodBeat.i(255729);
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255729);
                throw tVar;
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getContext().getWindow().addFlags(2097280);
        getContext().getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getContext().getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            getContext().getWindow().clearFlags(67108864);
            getContext().getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getContext().getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            Window window3 = getContext().getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        getContext().getWindow().setFormat(-3);
        getContext().getWindow().setSoftInputMode(51);
        AppMethodBeat.o(255729);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC, com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(255730);
        Log.i(this.TAG, "[LiveLifecycler]onStop ".concat(String.valueOf(this)));
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.wya;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.stop();
        }
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        if (dfZ != null) {
            if (dfZ.uDS) {
                j jVar = this.ubm;
                if (jVar != null) {
                    jVar.aGj();
                }
                f.cji();
            }
            AppMethodBeat.o(255730);
            return;
        }
        AppMethodBeat.o(255730);
    }
}
