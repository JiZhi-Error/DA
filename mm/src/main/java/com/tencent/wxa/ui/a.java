package com.tencent.wxa.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.b.c;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.e;
import io.flutter.embedding.android.f;
import io.flutter.embedding.android.j;
import io.flutter.embedding.android.k;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import java.util.Arrays;

public final class a {
    AbstractC2229a Syb;
    private WxaFlutterSplashView Syc;
    private boolean Syd;
    public c Sye;
    private final b Syf = new b() {
        /* class com.tencent.wxa.ui.a.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.b.b
        public final void dLt() {
        }

        @Override // io.flutter.embedding.engine.b.b
        public final void dLu() {
        }
    };
    private io.flutter.embedding.engine.a wJi;
    public FlutterView wKM;
    private io.flutter.plugin.platform.b wKN;

    /* renamed from: com.tencent.wxa.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC2229a extends e, f, k {
        @Override // io.flutter.embedding.android.k
        j KF();

        com.tencent.wxa.b.b KI();

        String KJ();

        String KK();

        String KL();

        String KM();

        FlutterView.b KN();

        FlutterView.c KO();

        @Override // io.flutter.embedding.android.f
        io.flutter.embedding.engine.a KP();

        @Override // io.flutter.embedding.android.e
        void b(io.flutter.embedding.engine.a aVar);

        Activity getActivity();

        Context getContext();

        Lifecycle getLifecycle();
    }

    public a(AbstractC2229a aVar) {
        AppMethodBeat.i(206366);
        this.Syb = aVar;
        this.Sye = new com.tencent.wxa.b.a(this.Syb.KI());
        AppMethodBeat.o(206366);
    }

    public final void hrO() {
        AppMethodBeat.i(206367);
        hrS();
        com.tencent.wxa.c.hrH().init();
        com.tencent.wxa.c.hrH().SxG = this.Syb.KI();
        if (this.wJi == null) {
            hrP();
        }
        this.Syb.getActivity();
        this.wKN = null;
        this.Syb.b(this.wJi);
        AppMethodBeat.o(206367);
    }

    private void hrP() {
        AppMethodBeat.i(206368);
        com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
        hrS();
        AbstractC2229a aVar = this.Syb;
        this.Syb.getContext();
        this.wJi = aVar.KP();
        if (this.wJi != null) {
            this.Syd = true;
            AppMethodBeat.o(206368);
            return;
        }
        com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
        this.Syd = false;
        AppMethodBeat.o(206368);
    }

    public final View hrQ() {
        AppMethodBeat.i(206369);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
        hrS();
        this.wJi.SNX.a(this.Syb.getActivity(), this.Syb.getLifecycle());
        this.Sye.onCreateView();
        this.wKM = new FlutterView(this.Syb.getActivity(), this.Syb.KN(), this.Syb.KO());
        this.wKM.a(this.Syf);
        this.Syc = new WxaFlutterSplashView(this.Syb.getContext());
        if (Build.VERSION.SDK_INT >= 17) {
            this.Syc.setId(View.generateViewId());
        } else {
            this.Syc.setId(0);
        }
        this.Syc.a(this.wKM, this.Syb.KF());
        WxaFlutterSplashView wxaFlutterSplashView = this.Syc;
        AppMethodBeat.o(206369);
        return wxaFlutterSplashView;
    }

    public final void onStart() {
        AppMethodBeat.i(206370);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
        hrS();
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
        com.tencent.wxa.c.hrH().SxG = this.Syb.KI();
        com.tencent.wxa.c.hrH().a(this.wKM, this.wJi);
        hrR();
        com.tencent.wxa.c.hrH().b(this.wKM);
        AppMethodBeat.o(206370);
    }

    private void hrR() {
        AppMethodBeat.i(206371);
        if (this.Syb.KJ() == null && !this.wJi.SNW.SOI) {
            com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.Syb.KK() + ", and sending initial route: " + this.Syb.KM(), new Object[0]);
            if (this.Syb.KM() != null) {
                this.wJi.SOc.setInitialRoute(this.Syb.KM());
            }
            this.wJi.SNW.a(new DartExecutor.a(this.Syb.KL(), this.Syb.KK()));
        }
        AppMethodBeat.o(206371);
    }

    public final void onResume() {
        AppMethodBeat.i(206372);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
        this.Sye.onResume();
        hrS();
        AppMethodBeat.o(206372);
    }

    public final void onPostResume() {
        AppMethodBeat.i(206373);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
        hrS();
        if (this.wJi == null) {
            com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        } else if (this.wKN != null) {
            this.wKN.hxp();
            AppMethodBeat.o(206373);
            return;
        }
        AppMethodBeat.o(206373);
    }

    public final void onPause() {
        AppMethodBeat.i(206374);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
        this.Sye.onPause();
        hrS();
        AppMethodBeat.o(206374);
    }

    public final void onStop() {
        AppMethodBeat.i(206375);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
        hrS();
        com.tencent.wxa.c.hrH().c(this.wKM);
        AppMethodBeat.o(206375);
    }

    public final void onDestroyView() {
        AppMethodBeat.i(206376);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
        this.Sye.onDestroyView();
        hrS();
        com.tencent.wxa.c.hrH().a(this.wKM);
        AppMethodBeat.o(206376);
    }

    public final void onDetach() {
        AppMethodBeat.i(206377);
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
        hrS();
        if (this.wKN != null) {
            this.wKN.destroy();
            this.wKN = null;
        }
        com.tencent.wxa.c.hrH().SxG = null;
        AppMethodBeat.o(206377);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(206378);
        com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
        hrS();
        if (this.wJi != null) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
            this.Sye.a(new k.d() {
                /* class com.tencent.wxa.ui.a.AnonymousClass2 */

                @Override // io.flutter.plugin.a.k.d
                public final void ba(Object obj) {
                    AppMethodBeat.i(206363);
                    if (obj == null || !(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
                        if (a.this.Syb.getActivity() != null) {
                            a.this.Syb.getActivity().finish();
                        }
                        AppMethodBeat.o(206363);
                        return;
                    }
                    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() back press comsumed .", new Object[0]);
                    AppMethodBeat.o(206363);
                }

                @Override // io.flutter.plugin.a.k.d
                public final void b(String str, String str2, Object obj) {
                    AppMethodBeat.i(206364);
                    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() error. s:%s s1:%s", str, str2);
                    if (a.this.Syb.getActivity() != null) {
                        a.this.Syb.getActivity().finish();
                    }
                    AppMethodBeat.o(206364);
                }

                @Override // io.flutter.plugin.a.k.d
                public final void dLv() {
                    AppMethodBeat.i(206365);
                    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() notImplemented.", new Object[0]);
                    if (a.this.Syb.getActivity() != null) {
                        a.this.Syb.getActivity().finish();
                    }
                    AppMethodBeat.o(206365);
                }
            });
            AppMethodBeat.o(206378);
            return;
        }
        com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
        if (this.Syb.getActivity() != null) {
            this.Syb.getActivity().finish();
        }
        AppMethodBeat.o(206378);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(206379);
        hrS();
        if (this.wJi != null) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i2 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr), new Object[0]);
            this.wJi.SNX.a(i2, strArr, iArr);
            AppMethodBeat.o(206379);
            return;
        }
        com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        AppMethodBeat.o(206379);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(206380);
        hrS();
        if (this.wJi != null) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
            this.wJi.SNX.onNewIntent(intent);
            AppMethodBeat.o(206380);
            return;
        }
        com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        AppMethodBeat.o(206380);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(206381);
        hrS();
        if (this.wJi != null) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i2 + "\nresultCode: " + i3 + "\ndata: " + intent, new Object[0]);
            this.wJi.SNX.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(206381);
            return;
        }
        com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        AppMethodBeat.o(206381);
    }

    public final void onUserLeaveHint() {
        AppMethodBeat.i(206382);
        hrS();
        if (this.wJi != null) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
            this.wJi.SNX.onUserLeaveHint();
            AppMethodBeat.o(206382);
            return;
        }
        com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        AppMethodBeat.o(206382);
    }

    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(206383);
        hrS();
        if (this.wJi == null) {
            com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
        } else if (i2 == 10) {
            com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(i2)), new Object[0]);
            this.wJi.SOh.hxj();
            AppMethodBeat.o(206383);
            return;
        }
        AppMethodBeat.o(206383);
    }

    private void hrS() {
        AppMethodBeat.i(206384);
        if (this.Syb == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
            AppMethodBeat.o(206384);
            throw illegalStateException;
        }
        AppMethodBeat.o(206384);
    }
}
