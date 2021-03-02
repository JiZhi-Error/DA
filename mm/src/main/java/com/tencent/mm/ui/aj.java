package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.x;

public final class aj implements b<SubscribeMsgRequestResult, x> {
    private final WeakReference<Activity> OKT;
    private final String mRa;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(232715);
        final SubscribeMsgRequestResult subscribeMsgRequestResult2 = subscribeMsgRequestResult;
        if (subscribeMsgRequestResult2 == null) {
            if (this.OKT.get() != null) {
                Activity activity = this.OKT.get();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    AppMethodBeat.o(232715);
                } else {
                    u.makeText(activity, activity.getString(R.string.a3c), 1).show();
                }
            }
            AppMethodBeat.o(232715);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.aj.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(232713);
                    yw ywVar = new yw();
                    ywVar.efe.dCl = aj.this.mRa;
                    ywVar.efe.action = !subscribeMsgRequestResult2.jyo ? 1 : 2;
                    ywVar.efe.option = 1;
                    EventCenter.instance.publish(ywVar);
                    AppMethodBeat.o(232713);
                }
            });
            AppMethodBeat.o(232715);
        }
        return null;
    }

    public aj(Activity activity, String str) {
        AppMethodBeat.i(232714);
        this.OKT = new WeakReference<>(activity);
        this.mRa = str;
        AppMethodBeat.o(232714);
    }
}
