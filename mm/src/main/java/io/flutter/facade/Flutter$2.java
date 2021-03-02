package io.flutter.facade;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.b;

class Flutter$2 implements LifecycleObserver {
    final /* synthetic */ FlutterView SRX;
    final /* synthetic */ Activity val$activity;

    Flutter$2(Activity activity, FlutterView flutterView) {
        this.val$activity = activity;
        this.SRX = flutterView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        AppMethodBeat.i(159071);
        b bVar = new b();
        bVar.SWi = FlutterMain.findAppBundlePath(this.val$activity.getApplicationContext());
        bVar.SWj = "main";
        this.SRX.a(bVar);
        GeneratedPluginRegistrant.registerWith(this.SRX.getPluginRegistry());
        AppMethodBeat.o(159071);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        AppMethodBeat.i(159072);
        this.SRX.SNZ.hxc();
        AppMethodBeat.o(159072);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        AppMethodBeat.i(159073);
        this.SRX.onPostResume();
        AppMethodBeat.o(159073);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        AppMethodBeat.i(159074);
        this.SRX.SNZ.hxc();
        AppMethodBeat.o(159074);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        AppMethodBeat.i(159075);
        this.SRX.SNZ.hxe();
        AppMethodBeat.o(159075);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.i(159076);
        this.SRX.destroy();
        AppMethodBeat.o(159076);
    }
}
