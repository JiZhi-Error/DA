package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.m;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c implements m, m.a, m.b, m.d, m.e, m.f {
    private FlutterNativeView SMd;
    public FlutterView SMe;
    public final PlatformViewsController SMf;
    private final Map<String, Object> SMg = new LinkedHashMap(0);
    private final List<m.d> SMh = new ArrayList(0);
    private final List<m.a> SMi = new ArrayList(0);
    private final List<m.b> SMj = new ArrayList(0);
    private final List<m.e> SMk = new ArrayList(0);
    private final List<m.f> SMl = new ArrayList(0);
    public Activity mActivity;
    private Context mAppContext;

    public c(FlutterNativeView flutterNativeView, Context context) {
        AppMethodBeat.i(9595);
        this.SMd = flutterNativeView;
        this.mAppContext = context;
        this.SMf = new PlatformViewsController();
        AppMethodBeat.o(9595);
    }

    public c(Context context) {
        AppMethodBeat.i(9596);
        this.mAppContext = context;
        this.SMf = new PlatformViewsController();
        AppMethodBeat.o(9596);
    }

    @Override // io.flutter.plugin.a.m
    public final boolean bsW(String str) {
        AppMethodBeat.i(9597);
        boolean containsKey = this.SMg.containsKey(str);
        AppMethodBeat.o(9597);
        return containsKey;
    }

    @Override // io.flutter.plugin.a.m
    public final m.c bsX(String str) {
        AppMethodBeat.i(9598);
        if (this.SMg.containsKey(str)) {
            IllegalStateException illegalStateException = new IllegalStateException("Plugin key " + str + " is already in use");
            AppMethodBeat.o(9598);
            throw illegalStateException;
        }
        this.SMg.put(str, null);
        a aVar = new a(str);
        AppMethodBeat.o(9598);
        return aVar;
    }

    class a implements m.c {
        private final String SMm;

        a(String str) {
            this.SMm = str;
        }
    }

    @Override // io.flutter.plugin.a.m.d
    public final boolean a(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(9599);
        for (m.d dVar : this.SMh) {
            if (dVar.a(i2, strArr, iArr)) {
                AppMethodBeat.o(9599);
                return true;
            }
        }
        AppMethodBeat.o(9599);
        return false;
    }

    @Override // io.flutter.plugin.a.m.a
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(9600);
        for (m.a aVar : this.SMi) {
            if (aVar.onActivityResult(i2, i3, intent)) {
                AppMethodBeat.o(9600);
                return true;
            }
        }
        AppMethodBeat.o(9600);
        return false;
    }

    @Override // io.flutter.plugin.a.m.b
    public final boolean onNewIntent(Intent intent) {
        AppMethodBeat.i(9601);
        for (m.b bVar : this.SMj) {
            if (bVar.onNewIntent(intent)) {
                AppMethodBeat.o(9601);
                return true;
            }
        }
        AppMethodBeat.o(9601);
        return false;
    }

    @Override // io.flutter.plugin.a.m.e
    public final void onUserLeaveHint() {
        AppMethodBeat.i(9602);
        for (m.e eVar : this.SMk) {
            eVar.onUserLeaveHint();
        }
        AppMethodBeat.o(9602);
    }

    @Override // io.flutter.plugin.a.m.f
    public final boolean a(FlutterNativeView flutterNativeView) {
        AppMethodBeat.i(9603);
        boolean z = false;
        for (m.f fVar : this.SMl) {
            if (fVar.a(flutterNativeView)) {
                z = true;
            } else {
                z = z;
            }
        }
        AppMethodBeat.o(9603);
        return z;
    }
}
