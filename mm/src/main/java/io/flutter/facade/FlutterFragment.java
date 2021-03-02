package io.flutter.facade;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import io.flutter.facade.a;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public class FlutterFragment extends Fragment {
    private String SRY = FilePathGenerator.ANDROID_DIR_SEP;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(159077);
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.SRY = getArguments().getString(TencentExtraKeys.LOCATION_KEY_ROUTE);
        }
        AppMethodBeat.o(159077);
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.i(159078);
        super.onInflate(context, attributeSet, bundle);
        AppMethodBeat.o(159078);
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(159079);
        FragmentActivity activity = getActivity();
        Lifecycle lifecycle = getLifecycle();
        String str = this.SRY;
        FlutterMain.startInitialization(activity.getApplicationContext());
        FlutterMain.ensureInitializationComplete(activity.getApplicationContext(), null);
        a.AnonymousClass1 r4 = new FlutterView(activity, new FlutterNativeView(activity)) {
            /* class io.flutter.facade.a.AnonymousClass1 */
            private final b<String> SRW = new b<>(this, "flutter/lifecycle", p.SSt);

            {
                AppMethodBeat.i(159068);
                AppMethodBeat.o(159068);
            }

            @Override // io.flutter.view.FlutterView
            public final void onFirstFrame() {
                AppMethodBeat.i(159069);
                super.onFirstFrame();
                setAlpha(1.0f);
                AppMethodBeat.o(159069);
            }

            @Override // io.flutter.view.FlutterView
            public final void onPostResume() {
                AppMethodBeat.i(159070);
                this.SRW.eN("AppLifecycleState.resumed");
                AppMethodBeat.o(159070);
            }
        };
        if (str != null) {
            r4.setInitialRoute(str);
        }
        lifecycle.addObserver(new Flutter$2(activity, r4));
        r4.setAlpha(0.0f);
        AppMethodBeat.o(159079);
        return r4;
    }
}
