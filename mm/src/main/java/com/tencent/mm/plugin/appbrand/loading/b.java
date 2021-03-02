package com.tencent.mm.plugin.appbrand.loading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "Landroid/content/ServiceConnection;", "pendingIntentKey", "", "TAG", "", "onProgressLoadSuccess", "Lkotlin/Function0;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getTAG", "()Ljava/lang/String;", "getOnProgressLoadSuccess", "()Lkotlin/jvm/functions/Function0;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "plugin-appbrand-integration_release"})
public final class b implements ServiceConnection {
    private final String TAG;
    private final int mZL;
    private final a<x> mZT;

    public b(int i2, String str, a<x> aVar) {
        p.h(str, "TAG");
        p.h(aVar, "onProgressLoadSuccess");
        AppMethodBeat.i(50822);
        this.mZL = i2;
        this.TAG = str;
        this.mZT = aVar;
        if (BuildInfo.IS_FLAVOR_RED) {
            Assert.assertTrue(this.mZL > 0);
        }
        AppMethodBeat.o(50822);
    }

    public /* synthetic */ b(final int i2, String str) {
        this(i2, str, new a<x>() {
            /* class com.tencent.mm.plugin.appbrand.loading.b.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50819);
                c.mZY.yr(i2);
                x xVar = x.SXb;
                AppMethodBeat.o(50819);
                return xVar;
            }
        });
        AppMethodBeat.i(50823);
        AppMethodBeat.o(50823);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(50820);
        Log.i(this.TAG, "disconnected");
        AppMethodBeat.o(50820);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(50821);
        Log.i(this.TAG, "onServiceConnected: name = ".concat(String.valueOf(componentName)));
        try {
            if (a.AbstractBinderC0815a.s(iBinder).yo(0) == 1) {
                this.mZT.invoke();
                Log.i(this.TAG, "onServiceConnected: IPC_TRIGGER_PROGRESS_SUCCESS");
                AppMethodBeat.o(50821);
                return;
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "onServiceConnected: ", e2);
            c.mZY.yr(this.mZL);
        }
        AppMethodBeat.o(50821);
    }
}
