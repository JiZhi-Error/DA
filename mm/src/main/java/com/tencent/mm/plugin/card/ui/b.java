package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b implements Application.ActivityLifecycleCallbacks {
    private int pYP = 0;

    public static Application bWY() {
        AppMethodBeat.i(113172);
        Application application = (Application) MMApplicationContext.getContext().getApplicationContext();
        AppMethodBeat.o(113172);
        return application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        g gVar;
        AppMethodBeat.i(113173);
        if (this.pYP < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.card.ui.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(113171);
                        Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
                        com.tencent.mm.plugin.card.b.g cug = am.cug();
                        if (cug != null) {
                            cug.a(r.EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND);
                        }
                        AppMethodBeat.o(113171);
                    }
                });
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (!(cardDetailUI.pZb == null || (gVar = cardDetailUI.pZb.pZz) == null || !(gVar instanceof m))) {
                    Log.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                    cardDetailUI.pZb.pZz.d(c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                }
            }
        }
        this.pYP++;
        AppMethodBeat.o(113173);
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.pYP--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
