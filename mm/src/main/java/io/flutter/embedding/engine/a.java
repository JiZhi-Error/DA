package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.b;
import io.flutter.embedding.engine.c.c;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.g;
import io.flutter.embedding.engine.c.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.k;
import io.flutter.embedding.engine.c.l;
import io.flutter.embedding.engine.c.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.Set;

public class a {
    public final b SMo;
    public final io.flutter.embedding.engine.b.a SMr;
    private final FlutterJNI SNV;
    public final DartExecutor SNW;
    public final c SNX;
    public final io.flutter.embedding.engine.c.a SNY;
    public final c SNZ;
    private final d SOa;
    public final e SOb;
    public final f SOc;
    public final i SOd;
    public final g SOe;
    private final k SOf;
    public final j SOg;
    public final l SOh;
    public final m SOi;
    private final AbstractC2243a SOj;
    private final Set<AbstractC2243a> engineLifecycleListeners;
    public final io.flutter.plugin.c.a localizationPlugin;
    public final PlatformViewsController platformViewsController;

    /* renamed from: io.flutter.embedding.engine.a$a  reason: collision with other inner class name */
    public interface AbstractC2243a {
        void onPreEngineRestart();
    }

    public a(Context context) {
        this(context, (byte) 0);
        AppMethodBeat.i(10180);
        AppMethodBeat.o(10180);
    }

    private a(Context context, byte b2) {
        this(context, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), true);
        AppMethodBeat.i(214941);
        AppMethodBeat.o(214941);
    }

    public a(Context context, char c2) {
        this(context, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), false);
        AppMethodBeat.i(214942);
        AppMethodBeat.o(214942);
    }

    public a(Context context, String[] strArr, boolean z) {
        this(context, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), new PlatformViewsController(), strArr, false, z);
        AppMethodBeat.i(214943);
        AppMethodBeat.o(214943);
    }

    private a(Context context, io.flutter.embedding.engine.a.a aVar, FlutterJNI flutterJNI, boolean z) {
        this(context, aVar, flutterJNI, new PlatformViewsController(), null, z);
        AppMethodBeat.i(214944);
        AppMethodBeat.o(214944);
    }

    private a(Context context, io.flutter.embedding.engine.a.a aVar, FlutterJNI flutterJNI, PlatformViewsController platformViewsController2, String[] strArr, boolean z) {
        this(context, aVar, flutterJNI, platformViewsController2, null, z, false);
    }

    private a(Context context, io.flutter.embedding.engine.a.a aVar, FlutterJNI flutterJNI, PlatformViewsController platformViewsController2, String[] strArr, boolean z, boolean z2) {
        AppMethodBeat.i(214945);
        this.engineLifecycleListeners = new HashSet();
        this.SOj = new AbstractC2243a() {
            /* class io.flutter.embedding.engine.a.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.a.AbstractC2243a
            public final void onPreEngineRestart() {
                AppMethodBeat.i(10115);
                io.flutter.a.hwd();
                for (AbstractC2243a aVar : a.this.engineLifecycleListeners) {
                    aVar.onPreEngineRestart();
                }
                a.this.platformViewsController.hxs();
                a.this.SOd.SRe = null;
                AppMethodBeat.o(10115);
            }
        };
        this.SNW = new DartExecutor(flutterJNI, context.getAssets());
        this.SNW.onAttachedToJNI();
        this.SNY = new io.flutter.embedding.engine.c.a(this.SNW, flutterJNI);
        this.SMo = new b(this.SNW);
        this.SNZ = new c(this.SNW);
        this.SOa = new d(this.SNW);
        this.SOb = new e(this.SNW);
        this.SOc = new f(this.SNW);
        this.SOe = new g(this.SNW);
        this.SOd = new i(this.SNW, z2);
        this.SOf = new k(this.SNW);
        this.SOg = new j(this.SNW);
        this.SOh = new l(this.SNW);
        this.SOi = new m(this.SNW);
        this.localizationPlugin = new io.flutter.plugin.c.a(context, this.SOa);
        this.SNV = flutterJNI;
        aVar.startInitialization(context.getApplicationContext());
        aVar.ensureInitializationComplete(context, strArr);
        flutterJNI.addEngineLifecycleListener(this.SOj);
        flutterJNI.setPlatformViewsController(platformViewsController2);
        flutterJNI.setLocalizationPlugin(this.localizationPlugin);
        io.flutter.a.hwd();
        this.SNV.attachToNative(false);
        if (!this.SNV.isAttached()) {
            RuntimeException runtimeException = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
            AppMethodBeat.o(214945);
            throw runtimeException;
        }
        this.SMr = new io.flutter.embedding.engine.b.a(flutterJNI);
        this.platformViewsController = platformViewsController2;
        this.platformViewsController.onAttachedToJNI();
        this.SNX = new c(context.getApplicationContext(), this, aVar);
        if (z) {
            try {
                Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", a.class).invoke(null, this);
                AppMethodBeat.o(214945);
                return;
            } catch (Exception e2) {
                new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
                io.flutter.a.hwf();
            }
        }
        AppMethodBeat.o(214945);
    }

    public final void destroy() {
        AppMethodBeat.i(10181);
        io.flutter.a.hwd();
        this.SNX.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.SNW.onDetachedFromJNI();
        this.SNV.removeEngineLifecycleListener(this.SOj);
        this.SNV.detachFromNativeAndReleaseResources();
        AppMethodBeat.o(10181);
    }

    public final DartExecutor getDartExecutor() {
        return this.SNW;
    }

    public final io.flutter.embedding.engine.plugins.b hwF() {
        return this.SNX;
    }
}
