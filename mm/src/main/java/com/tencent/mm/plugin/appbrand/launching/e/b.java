package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

final class b extends com.tencent.mm.plugin.appbrand.launching.a {
    b() {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.a
    public final boolean b(Context context, LaunchParcel launchParcel) {
        boolean z;
        AppMethodBeat.i(47437);
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        } else {
            h.c(intent, (Activity) context);
        }
        intent.putExtra("extra_from_mm", false);
        intent.putExtra("extra_launch_parcel", launchParcel);
        intent.putExtra("extra_launch_source_context", context.getClass().getName());
        intent.putExtra("extra_launch_source_process_name", MMApplicationContext.getProcessName());
        if (!(context instanceof AppBrandUI)) {
            z = false;
        } else if (context instanceof AppBrandPluginUI) {
            z = false;
        } else if (launchParcel.mYK.scene != 1090) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            new a(context);
        }
        if (launchParcel.mQC != null) {
            int flags = intent.getFlags();
            try {
                intent.setFlags(-268435457 & flags);
                ActivityStarterIpcDelegate activityStarterIpcDelegate = launchParcel.mQC;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, bl.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activityStarterIpcDelegate.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
                intent.setFlags(flags);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        } else {
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(47437);
        return true;
    }

    class a extends IListener<d> implements Application.ActivityLifecycleCallbacks {
        private final Application app = ((Application) this.val$context.getApplicationContext());
        private final WeakReference<Activity> mZg = new WeakReference<>((Activity) this.val$context);
        final /* synthetic */ Context val$context;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(Context context) {
            this.val$context = context;
            AppMethodBeat.i(47431);
            alive();
            this.app.registerActivityLifecycleCallbacks(this);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(47431);
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(47432);
            if (activity == this.mZg.get()) {
                unregisterAll();
            }
            AppMethodBeat.o(47432);
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.i(47433);
            if (activity == this.mZg.get()) {
                unregisterAll();
            }
            AppMethodBeat.o(47433);
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.i(47434);
            if (activity == this.mZg.get()) {
                unregisterAll();
            }
            AppMethodBeat.o(47434);
        }

        private void unregisterAll() {
            AppMethodBeat.i(47435);
            dead();
            this.app.unregisterActivityLifecycleCallbacks(this);
            AppMethodBeat.o(47435);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            AppMethodBeat.i(47436);
            Activity activity = this.mZg.get();
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
            unregisterAll();
            AppMethodBeat.o(47436);
            return false;
        }
    }
}
