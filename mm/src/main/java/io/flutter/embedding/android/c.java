package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.Arrays;

final class c {
    a SMB;
    private FlutterSplashView SMC;
    private final b SMD = new b() {
        /* class io.flutter.embedding.android.c.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.b.b
        public final void dLt() {
            AppMethodBeat.i(215043);
            c.this.SMB.dLt();
            AppMethodBeat.o(215043);
        }

        @Override // io.flutter.embedding.engine.b.b
        public final void dLu() {
            AppMethodBeat.i(215044);
            c.this.SMB.dLu();
            AppMethodBeat.o(215044);
        }
    };
    boolean Syd;
    io.flutter.embedding.engine.a wJi;
    FlutterView wKM;
    io.flutter.plugin.platform.b wKN;

    /* access modifiers changed from: package-private */
    public interface a extends e, f, k {
        @Override // io.flutter.embedding.android.k
        j KF();

        String KJ();

        String KK();

        String KL();

        String KM();

        @Override // io.flutter.embedding.android.f
        io.flutter.embedding.engine.a KP();

        io.flutter.plugin.platform.b a(Activity activity, io.flutter.embedding.engine.a aVar);

        @Override // io.flutter.embedding.android.e
        void b(io.flutter.embedding.engine.a aVar);

        @Override // io.flutter.embedding.android.e
        void c(io.flutter.embedding.engine.a aVar);

        void dLt();

        void dLu();

        Activity getActivity();

        Context getContext();

        Lifecycle getLifecycle();

        d hwl();

        boolean hwm();

        i hwn();

        l hwo();

        boolean hwp();

        boolean hwq();
    }

    c(a aVar) {
        AppMethodBeat.i(10071);
        this.SMB = aVar;
        AppMethodBeat.o(10071);
    }

    /* access modifiers changed from: package-private */
    public final void hrO() {
        AppMethodBeat.i(215067);
        hrS();
        if (this.wJi == null) {
            hrP();
        }
        this.wKN = this.SMB.a(this.SMB.getActivity(), this.wJi);
        if (this.SMB.hwp()) {
            io.flutter.a.hwd();
            this.wJi.SNX.a(this.SMB.getActivity(), this.SMB.getLifecycle());
        }
        this.SMB.b(this.wJi);
        AppMethodBeat.o(215067);
    }

    private void hrP() {
        AppMethodBeat.i(10074);
        io.flutter.a.hwd();
        String KJ = this.SMB.KJ();
        if (KJ != null) {
            this.wJi = io.flutter.embedding.engine.b.hwG().bta(KJ);
            this.Syd = true;
            if (this.wJi == null) {
                IllegalStateException illegalStateException = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + KJ + "'");
                AppMethodBeat.o(10074);
                throw illegalStateException;
            }
            AppMethodBeat.o(10074);
            return;
        }
        a aVar = this.SMB;
        this.SMB.getContext();
        this.wJi = aVar.KP();
        if (this.wJi != null) {
            this.Syd = true;
            AppMethodBeat.o(10074);
            return;
        }
        io.flutter.a.hwd();
        this.wJi = new io.flutter.embedding.engine.a(this.SMB.getContext(), this.SMB.hwl().toArray(), this.SMB.hwq());
        this.Syd = false;
        AppMethodBeat.o(10074);
    }

    /* access modifiers changed from: package-private */
    public final View hrQ() {
        AppMethodBeat.i(10075);
        io.flutter.a.hwd();
        hrS();
        if (this.SMB.hwn() == i.surface) {
            this.wKM = new FlutterView(this.SMB.getActivity(), new FlutterSurfaceView(this.SMB.getActivity(), this.SMB.hwo() == l.transparent));
        } else {
            this.wKM = new FlutterView(this.SMB.getActivity(), new FlutterTextureView(this.SMB.getActivity()));
        }
        this.wKM.a(this.SMD);
        this.SMC = new FlutterSplashView(this.SMB.getContext());
        if (Build.VERSION.SDK_INT >= 17) {
            this.SMC.setId(View.generateViewId());
        } else {
            this.SMC.setId(486947586);
        }
        this.SMC.a(this.wKM, this.SMB.KF());
        io.flutter.a.hwd();
        this.wKM.d(this.wJi);
        FlutterSplashView flutterSplashView = this.SMC;
        AppMethodBeat.o(10075);
        return flutterSplashView;
    }

    /* access modifiers changed from: package-private */
    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(215068);
        io.flutter.a.hwd();
        hrS();
        byte[] bArr = null;
        if (bundle != null) {
            bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
        }
        if (this.SMB.hwq()) {
            this.wJi.SOd.de(bArr);
        }
        if (this.SMB.hwp()) {
            this.wJi.SNX.hwM();
        }
        AppMethodBeat.o(215068);
    }

    /* access modifiers changed from: package-private */
    public final void onStart() {
        AppMethodBeat.i(10076);
        io.flutter.a.hwd();
        hrS();
        hrR();
        AppMethodBeat.o(10076);
    }

    private void hrR() {
        AppMethodBeat.i(215069);
        if (this.SMB.KJ() != null) {
            AppMethodBeat.o(215069);
        } else if (this.wJi.SNW.SOI) {
            AppMethodBeat.o(215069);
        } else {
            new StringBuilder("Executing Dart entrypoint: ").append(this.SMB.KK()).append(", and sending initial route: ").append(this.SMB.KM());
            io.flutter.a.hwd();
            if (this.SMB.KM() != null) {
                this.wJi.SOc.setInitialRoute(this.SMB.KM());
            }
            this.wJi.SNW.a(new DartExecutor.a(this.SMB.KL(), this.SMB.KK()));
            AppMethodBeat.o(215069);
        }
    }

    /* access modifiers changed from: package-private */
    public final void onResume() {
        AppMethodBeat.i(10077);
        io.flutter.a.hwd();
        hrS();
        this.wJi.SNZ.hxd();
        AppMethodBeat.o(10077);
    }

    /* access modifiers changed from: package-private */
    public final void onPostResume() {
        AppMethodBeat.i(215070);
        io.flutter.a.hwd();
        hrS();
        if (this.wJi == null) {
            io.flutter.a.hwf();
        } else if (this.wKN != null) {
            this.wKN.hxp();
            AppMethodBeat.o(215070);
            return;
        }
        AppMethodBeat.o(215070);
    }

    /* access modifiers changed from: package-private */
    public final void onPause() {
        AppMethodBeat.i(10078);
        io.flutter.a.hwd();
        hrS();
        this.wJi.SNZ.hxc();
        AppMethodBeat.o(10078);
    }

    /* access modifiers changed from: package-private */
    public final void onStop() {
        AppMethodBeat.i(10079);
        io.flutter.a.hwd();
        hrS();
        this.wJi.SNZ.hxe();
        AppMethodBeat.o(10079);
    }

    /* access modifiers changed from: package-private */
    public final void onDestroyView() {
        AppMethodBeat.i(10080);
        io.flutter.a.hwd();
        hrS();
        this.wKM.hwy();
        this.wKM.b(this.SMD);
        AppMethodBeat.o(10080);
    }

    /* access modifiers changed from: package-private */
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(215071);
        io.flutter.a.hwd();
        hrS();
        if (this.SMB.hwq()) {
            bundle.putByteArray("framework", this.wJi.SOd.SRe);
        }
        if (this.SMB.hwp()) {
            Bundle bundle2 = new Bundle();
            this.wJi.SNX.hwL();
            bundle.putBundle("plugins", bundle2);
        }
        AppMethodBeat.o(215071);
    }

    /* access modifiers changed from: package-private */
    public final void onDetach() {
        AppMethodBeat.i(10081);
        io.flutter.a.hwd();
        hrS();
        this.SMB.c(this.wJi);
        if (this.SMB.hwp()) {
            io.flutter.a.hwd();
            if (this.SMB.getActivity().isChangingConfigurations()) {
                this.wJi.SNX.hwJ();
            } else {
                this.wJi.SNX.hwK();
            }
        }
        if (this.wKN != null) {
            this.wKN.destroy();
            this.wKN = null;
        }
        this.wJi.SNZ.hxf();
        if (this.SMB.hwm()) {
            this.wJi.destroy();
            if (this.SMB.KJ() != null) {
                io.flutter.embedding.engine.b.hwG().btb(this.SMB.KJ());
            }
            this.wJi = null;
        }
        AppMethodBeat.o(10081);
    }

    /* access modifiers changed from: package-private */
    public final void onBackPressed() {
        AppMethodBeat.i(215072);
        hrS();
        if (this.wJi != null) {
            io.flutter.a.hwd();
            this.wJi.SOc.dLr();
            AppMethodBeat.o(215072);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(215072);
    }

    /* access modifiers changed from: package-private */
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(10082);
        hrS();
        if (this.wJi != null) {
            new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(i2).append("\npermissions: ").append(Arrays.toString(strArr)).append("\ngrantResults: ").append(Arrays.toString(iArr));
            io.flutter.a.hwd();
            this.wJi.SNX.a(i2, strArr, iArr);
            AppMethodBeat.o(10082);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(10082);
    }

    /* access modifiers changed from: package-private */
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(215073);
        hrS();
        if (this.wJi != null) {
            io.flutter.a.hwd();
            this.wJi.SNX.onNewIntent(intent);
            AppMethodBeat.o(215073);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(215073);
    }

    /* access modifiers changed from: package-private */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(10083);
        hrS();
        if (this.wJi != null) {
            new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(i2).append("\nresultCode: ").append(i3).append("\ndata: ").append(intent);
            io.flutter.a.hwd();
            this.wJi.SNX.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(10083);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(10083);
    }

    /* access modifiers changed from: package-private */
    public final void onUserLeaveHint() {
        AppMethodBeat.i(215074);
        hrS();
        if (this.wJi != null) {
            io.flutter.a.hwd();
            this.wJi.SNX.onUserLeaveHint();
            AppMethodBeat.o(215074);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(215074);
    }

    /* access modifiers changed from: package-private */
    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(215075);
        hrS();
        if (this.wJi != null) {
            this.wJi.SNW.notifyLowMemoryWarning();
            if (i2 == 10) {
                io.flutter.a.hwd();
                this.wJi.SOh.hxj();
                AppMethodBeat.o(215075);
                return;
            }
        } else {
            io.flutter.a.hwf();
        }
        AppMethodBeat.o(215075);
    }

    /* access modifiers changed from: package-private */
    public final void hrS() {
        AppMethodBeat.i(10084);
        if (this.SMB == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
            AppMethodBeat.o(10084);
            throw illegalStateException;
        }
        AppMethodBeat.o(10084);
    }
}
