package io.flutter.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c;
import java.nio.ByteBuffer;

public class FlutterNativeView implements c {
    private final b SMD;
    public FlutterView SMe;
    final DartExecutor SNW;
    public final io.flutter.app.c SWe;
    final FlutterJNI SWf;
    public boolean SWg;
    private final Context mContext;

    public FlutterNativeView(Context context) {
        this(context, (byte) 0);
    }

    private FlutterNativeView(Context context, byte b2) {
        AppMethodBeat.i(9670);
        this.SMD = new b() {
            /* class io.flutter.view.FlutterNativeView.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(214925);
                if (FlutterNativeView.this.SMe == null) {
                    AppMethodBeat.o(214925);
                    return;
                }
                FlutterNativeView.this.SMe.onFirstFrame();
                AppMethodBeat.o(214925);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
            }
        };
        this.mContext = context;
        this.SWe = new io.flutter.app.c(this, context);
        this.SWf = new FlutterJNI();
        this.SWf.addIsDisplayingFlutterUiListener(this.SMD);
        this.SNW = new DartExecutor(this.SWf, context.getAssets());
        this.SWf.addEngineLifecycleListener(new a(this, (byte) 0));
        this.SWf.attachToNative(false);
        this.SNW.onAttachedToJNI();
        assertAttached();
        AppMethodBeat.o(9670);
    }

    public final void destroy() {
        AppMethodBeat.i(9671);
        this.SWe.SMf.onDetachedFromJNI();
        this.SNW.onDetachedFromJNI();
        this.SMe = null;
        this.SWf.removeIsDisplayingFlutterUiListener(this.SMD);
        this.SWf.detachFromNativeAndReleaseResources();
        this.SWg = false;
        AppMethodBeat.o(9671);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(9673);
        if (bVar.SWj == null) {
            AssertionError assertionError = new AssertionError("An entrypoint must be specified");
            AppMethodBeat.o(9673);
            throw assertionError;
        }
        assertAttached();
        if (this.SWg) {
            AssertionError assertionError2 = new AssertionError("This Flutter engine instance is already running an application");
            AppMethodBeat.o(9673);
            throw assertionError2;
        }
        this.SWf.runBundleAndSnapshotFromLibrary(bVar.SWi, bVar.SWj, bVar.SWk, this.mContext.getResources().getAssets());
        this.SWg = true;
        AppMethodBeat.o(9673);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer) {
        AppMethodBeat.i(9674);
        this.SNW.SOH.a(str, byteBuffer);
        AppMethodBeat.o(9674);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, c.a aVar) {
        AppMethodBeat.i(9676);
        this.SNW.SOH.a(str, aVar);
        AppMethodBeat.o(9676);
    }

    /* access modifiers changed from: package-private */
    public FlutterJNI getFlutterJNI() {
        return this.SWf;
    }

    final class a implements a.AbstractC2243a {
        private a() {
        }

        /* synthetic */ a(FlutterNativeView flutterNativeView, byte b2) {
            this();
        }

        @Override // io.flutter.embedding.engine.a.AbstractC2243a
        public final void onPreEngineRestart() {
            AppMethodBeat.i(9775);
            if (FlutterNativeView.this.SMe != null) {
                FlutterNativeView.this.SMe.hxB();
            }
            if (FlutterNativeView.this.SWe == null) {
                AppMethodBeat.o(9775);
                return;
            }
            FlutterNativeView.this.SWe.SMf.hxs();
            AppMethodBeat.o(9775);
        }
    }

    private void assertAttached() {
        AppMethodBeat.i(9672);
        if (!this.SWf.isAttached()) {
            AssertionError assertionError = new AssertionError("Platform view is not attached");
            AppMethodBeat.o(9672);
            throw assertionError;
        }
        AppMethodBeat.o(9672);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer, c.b bVar) {
        AppMethodBeat.i(9675);
        if (!this.SWf.isAttached()) {
            AppMethodBeat.o(9675);
            return;
        }
        this.SNW.SOH.a(str, byteBuffer, bVar);
        AppMethodBeat.o(9675);
    }
}
