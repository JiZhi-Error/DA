package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentPoster;", "", "()V", "TAG", "", FirebaseAnalytics.b.INDEX, "", "pendingIntents", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "add", "task", "execPendingIntent", "", "intentKey", "getPendingIntentAndRemoveAtomic", "peek", "updateCtx", "", "ctx", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c {
    private static int index;
    private static final SparseArray<e> mZX = new SparseArray<>();
    public static final c mZY = new c();

    static {
        AppMethodBeat.i(50838);
        AppMethodBeat.o(50838);
    }

    private c() {
    }

    public final int a(e eVar) {
        int i2;
        AppMethodBeat.i(50834);
        p.h(eVar, "task");
        synchronized (this) {
            try {
                SparseArray<e> sparseArray = mZX;
                int i3 = index + 1;
                index = i3;
                sparseArray.append(i3, eVar);
                MMHandlerThread.postToMainThreadDelayed(new d(index, "MicroMsg.AppBrand.PendingIntentPoster"), 12000);
                i2 = index;
            } finally {
                AppMethodBeat.o(50834);
            }
        }
        return i2;
    }

    public final e yp(int i2) {
        e eVar;
        AppMethodBeat.i(228826);
        synchronized (this) {
            try {
                eVar = mZX.get(i2);
            } finally {
                AppMethodBeat.o(228826);
            }
        }
        return eVar;
    }

    public final e yq(int i2) {
        e eVar;
        AppMethodBeat.i(50835);
        synchronized (this) {
            try {
                eVar = mZX.get(i2);
                if (eVar == null) {
                    Log.i("MicroMsg.AppBrand.PendingIntentPoster", "getPendingIntentAndRemoveAtomic: get a null task by intentKey = ".concat(String.valueOf(i2)));
                } else {
                    Log.i("MicroMsg.AppBrand.PendingIntentPoster", "getPendingIntentAndRemoveAtomic: brandName = " + eVar.kEG.brandName);
                }
                mZX.remove(i2);
            } finally {
                AppMethodBeat.o(50835);
            }
        }
        return eVar;
    }

    public final void a(int i2, Context context) {
        AppMethodBeat.i(50836);
        p.h(context, "ctx");
        synchronized (this) {
            try {
                e eVar = mZX.get(i2);
                if (eVar == null) {
                    Log.i("MicroMsg.AppBrand.PendingIntentPoster", "updateCtx: get a null task by intentKey = ".concat(String.valueOf(i2)));
                    return;
                }
                p.h(context, "<set-?>");
                eVar.ctx = context;
                x xVar = x.SXb;
                AppMethodBeat.o(50836);
            } finally {
                AppMethodBeat.o(50836);
            }
        }
    }

    public final boolean yr(int i2) {
        AppMethodBeat.i(50837);
        e yq = yq(i2);
        if (yq == null) {
            AppMethodBeat.o(50837);
            return false;
        }
        Context context = yq.ctx;
        Intent intent = yq.intent;
        Log.i("MicroMsg.AppBrand.PendingIntentPoster", "execPendingIntent: ctx = " + yq.ctx);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(50837);
        return true;
    }
}
