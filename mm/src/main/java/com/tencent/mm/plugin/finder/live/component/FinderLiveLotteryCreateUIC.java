package com.tencent.mm.plugin.finder.live.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.component.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "getLayoutId", "", "keyboardChange", "", "show", "height", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLiveLotteryCreateUIC extends UIComponent {
    final String TAG = "FinderLiveLotteryCreateUIC";
    private h gyh;
    private boolean hwq;
    private d.b ugD;
    private d.a ugO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLotteryCreateUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(245939);
        AppMethodBeat.o(245939);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.adj;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245935);
        super.onCreate(bundle);
        this.ugO = new e(getActivity());
        View rootView = getRootView();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(245935);
            throw tVar;
        }
        this.ugD = new f(rootView, (MMActivity) activity, this.ugO);
        d.a aVar = this.ugO;
        if (aVar != null) {
            d.b bVar = this.ugD;
            if (bVar == null) {
                p.hyc();
            }
            aVar.onAttach(bVar);
            AppMethodBeat.o(245935);
            return;
        }
        AppMethodBeat.o(245935);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        View decorView;
        AppMethodBeat.i(245936);
        super.onResume();
        Window window = getActivity().getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            AppMethodBeat.o(245936);
            return;
        }
        decorView.post(new a(this));
        AppMethodBeat.o(245936);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ FinderLiveLotteryCreateUIC ugP;

        a(FinderLiveLotteryCreateUIC finderLiveLotteryCreateUIC) {
            this.ugP = finderLiveLotteryCreateUIC;
        }

        public final void run() {
            AppMethodBeat.i(245934);
            if (this.ugP.gyh == null) {
                this.ugP.gyh = new h(this.ugP.getActivity());
                h hVar = this.ugP.gyh;
                if (hVar != null) {
                    hVar.setKeyboardHeightObserver(new g(this) {
                        /* class com.tencent.mm.plugin.finder.live.component.FinderLiveLotteryCreateUIC.a.AnonymousClass1 */
                        final /* synthetic */ a ugQ;

                        {
                            this.ugQ = r1;
                        }

                        @Override // com.tencent.mm.ui.tools.g
                        public final void y(int i2, boolean z) {
                            AppMethodBeat.i(245933);
                            Log.i(this.ugQ.ugP.TAG, "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
                            FinderLiveLotteryCreateUIC.a(this.ugQ.ugP, i2 > 0, i2);
                            AppMethodBeat.o(245933);
                        }
                    });
                }
            }
            h hVar2 = this.ugP.gyh;
            if (hVar2 != null) {
                hVar2.start();
                AppMethodBeat.o(245934);
                return;
            }
            AppMethodBeat.o(245934);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(245937);
        super.onPause();
        h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
            AppMethodBeat.o(245937);
            return;
        }
        AppMethodBeat.o(245937);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(245938);
        super.onDestroy();
        d.a aVar = this.ugO;
        if (aVar != null) {
            aVar.onDetach();
            AppMethodBeat.o(245938);
            return;
        }
        AppMethodBeat.o(245938);
    }

    public static final /* synthetic */ void a(FinderLiveLotteryCreateUIC finderLiveLotteryCreateUIC, boolean z, int i2) {
        AppMethodBeat.i(245940);
        if (finderLiveLotteryCreateUIC.hwq != z) {
            finderLiveLotteryCreateUIC.hwq = z;
            d.b bVar = finderLiveLotteryCreateUIC.ugD;
            if (bVar != null) {
                bVar.keyboardChange(z, i2);
                AppMethodBeat.o(245940);
                return;
            }
        }
        AppMethodBeat.o(245940);
    }
}
