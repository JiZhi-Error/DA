package com.tencent.mm.plugin.appbrand.loading;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.v.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;", "Landroid/app/Service;", "()V", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;)V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "onBind", "Landroid/os/IBinder;", "onCreate", "", "onDestroy", "onRebind", "onStartCommand", "", "flags", "startId", "onUnbind", "", "AppBrandTriggerBinder", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandProcessTriggerService0 extends Service {
    public static final b Companion = new b((byte) 0);
    public static final int IPC_TRIGGER_PRELOAD = 2;
    private static final String TAG = "MicroMsg.AppBrand.AppBrandProcessTriggerService";
    private com.tencent.mm.plugin.appbrand.v.b callback;
    private Intent intent;

    static {
        AppMethodBeat.i(50833);
        AppMethodBeat.o(50833);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$Companion;", "", "()V", "IPC_TRIGGER_PRELOAD", "", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.plugin.appbrand.v.b getCallback() {
        return this.callback;
    }

    public final void setCallback(com.tencent.mm.plugin.appbrand.v.b bVar) {
        this.callback = bVar;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final void setIntent(Intent intent2) {
        this.intent = intent2;
    }

    public IBinder onBind(Intent intent2) {
        AppMethodBeat.i(50827);
        p.h(intent2, "intent");
        Log.i(TAG, "onBind: " + intent2.getPackage());
        this.intent = intent2;
        a aVar = new a();
        AppMethodBeat.o(50827);
        return aVar;
    }

    public void onRebind(Intent intent2) {
        AppMethodBeat.i(50828);
        super.onRebind(intent2);
        Log.i(TAG, "onRebind: ");
        AppMethodBeat.o(50828);
    }

    public void onCreate() {
        AppMethodBeat.i(50829);
        super.onCreate();
        Log.i(TAG, "onCreate: ");
        AppMethodBeat.o(50829);
    }

    public int onStartCommand(Intent intent2, int i2, int i3) {
        return 3;
    }

    public boolean onUnbind(Intent intent2) {
        AppMethodBeat.i(50830);
        Log.i(TAG, "onUnbind: ");
        AppMethodBeat.o(50830);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0$AppBrandTriggerBinder;", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCall$Stub;", "(Lcom/tencent/mm/plugin/appbrand/loading/AppBrandProcessTriggerService0;)V", "registerInvokeCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/preloading/IAppBrandProgressTriggerCallback;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "requestCode", "plugin-appbrand-integration_release"})
    public final class a extends a.AbstractBinderC0815a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
        /* renamed from: com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0$a$a  reason: collision with other inner class name */
        static final class C0744a<T> implements d<IPCVoid> {
            public static final C0744a mZW = new C0744a();

            static {
                AppMethodBeat.i(228823);
                AppMethodBeat.o(228823);
            }

            C0744a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.v.a
        public final void a(com.tencent.mm.plugin.appbrand.v.b bVar) {
            AppMethodBeat.i(228824);
            AppBrandProcessTriggerService0.this.setCallback(bVar);
            if (bVar != null) {
                bVar.t(this);
                AppMethodBeat.o(228824);
                return;
            }
            AppMethodBeat.o(228824);
        }

        @Override // com.tencent.mm.plugin.appbrand.v.a
        public final int yo(int i2) {
            AppMethodBeat.i(228825);
            Log.i(AppBrandProcessTriggerService0.TAG, "request: reqCode = ".concat(String.valueOf(i2)));
            switch (i2) {
                case 0:
                    AppMethodBeat.o(228825);
                    return 1;
                case 1:
                default:
                    AppMethodBeat.o(228825);
                    return -1;
                case 2:
                    new com.tencent.mm.plugin.appbrand.task.preload.d();
                    com.tencent.mm.plugin.appbrand.task.preload.d.a(AppBrandProcessTriggerService0.this.getIntent(), C0744a.mZW);
                    AppMethodBeat.o(228825);
                    return 1;
            }
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(50832);
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        AppMethodBeat.o(50832);
    }
}
