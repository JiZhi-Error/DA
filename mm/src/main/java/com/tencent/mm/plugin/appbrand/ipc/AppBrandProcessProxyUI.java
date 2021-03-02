package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements f.e, c {
    public static String lwe = "appbrand_report_key_target_url";
    public static String lwf = "appbrand_report_key_target_activity";
    private int lvW = 0;
    private AppBrandProxyUIProcessTask lvX;
    private AppBrandProxyUIProcessTask.ProcessRequest lvY;
    private boolean lvZ = false;
    private volatile boolean lwa = false;
    private volatile boolean lwb = false;
    private d lwc;
    private a lwd;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static boolean B(Intent intent) {
        AppMethodBeat.i(45393);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI") && intent.getIntExtra("key_running_mode", -1) == 10000) {
                    AppMethodBeat.o(45393);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(45393);
                return false;
            }
        }
        AppMethodBeat.o(45393);
        return false;
    }

    public static void l(Context context, Intent intent) {
        AppMethodBeat.i(45394);
        if (!(context instanceof AppBrandUI) || (context instanceof AppBrandPluginUI)) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(45394);
            return;
        }
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(context, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", intent).putExtra("key_proxy_launch_appbrand_ui_class", context.getClass()).addFlags(268435456));
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl2.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(45394);
    }

    static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context context, final Class<? extends AppBrandProcessProxyUI> cls, final _Req _req, final AppBrandProxyUIProcessTask.b<_Result> bVar, Intent intent) {
        final Context context2;
        AnonymousClass1 r0;
        boolean z;
        AppMethodBeat.i(45395);
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        Intent putExtra = new Intent(context2, cls == null ? AppBrandProcessProxyUI.class : cls).putExtra("key_model_class_name", _req.bCJ().getName());
        if (bVar == null) {
            r0 = null;
        } else {
            r0 = new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper())) {
                /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final void onReceiveResult(int i2, Bundle bundle) {
                    AppMethodBeat.i(45385);
                    if (bundle == null) {
                        bVar.a(null);
                        AppMethodBeat.o(45385);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    bVar.a((AppBrandProxyUIProcessTask.ProcessResult) bundle.getParcelable("key_result_parcel"));
                    AppMethodBeat.o(45385);
                }
            };
        }
        final Intent putExtra2 = putExtra.putExtra("key_result_receiver", r0).putExtra(lwf, _req.bDO()).putExtra("key_running_mode", 1);
        putExtra2.putExtra("key_request_parcel", _req);
        if (!(context2 instanceof Activity)) {
            putExtra2.addFlags(268435456);
        } else {
            Window window = ((Activity) context2).getWindow();
            if (window == null || window.getDecorView() == null) {
                z = false;
            } else {
                z = Build.VERSION.SDK_INT >= 23 && (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
            }
            putExtra2.putExtra("key_need_light_status", z);
        }
        if (intent != null) {
            putExtra2.addFlags(intent.getFlags());
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(45386);
                if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
                    Context context = context2;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(45386);
                    return;
                }
                ((Activity) context2).startActivityForResult(putExtra2, _req.bDP());
                AppMethodBeat.o(45386);
            }
        });
        AppMethodBeat.o(45395);
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2, final DialogInterface.OnClickListener onClickListener3) {
        Context context2;
        AppMethodBeat.i(45396);
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        Intent putExtra = new Intent(context2, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper())) {
            /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(45387);
                if (-1 == i2 && onClickListener != null) {
                    onClickListener.onClick(null, i2);
                }
                if (-2 == i2 && onClickListener2 != null) {
                    onClickListener2.onClick(null, i2);
                }
                if (-3 == i2 && onClickListener3 != null) {
                    onClickListener3.onClick(null, i2);
                }
                AppMethodBeat.o(45387);
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context2 instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(45396);
        } catch (BadParcelableException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandProcessProxyUI", e2, "showAlert get BadParcelableException", new Object[0]);
            AppMethodBeat.o(45396);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(45397);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(45397);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(45398);
        setTheme(R.style.q6);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        y.e(getWindow());
        y.d(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(45398);
            return;
        }
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                String stringExtra = getIntent().getStringExtra("key_model_class_name");
                Log.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    this.lvX = AppBrandProxyUIProcessTask.a.YX(stringExtra);
                    if (this.lvX == null) {
                        Log.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", stringExtra);
                    } else if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                        this.lvY = (AppBrandProxyUIProcessTask.ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                        if (this.lvY == null) {
                            Log.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", stringExtra);
                        } else {
                            AppBrandProxyUIProcessTask appBrandProxyUIProcessTask = this.lvX;
                            appBrandProxyUIProcessTask.lwz = this;
                            if (appBrandProxyUIProcessTask instanceof LifecycleObserver) {
                                appBrandProxyUIProcessTask.bDF().getLifecycle().addObserver((LifecycleObserver) appBrandProxyUIProcessTask);
                            }
                            this.lvX.a(this.lvY);
                            z = true;
                        }
                    } else {
                        this.lvY = null;
                    }
                }
                if (!z) {
                    finish();
                    AppMethodBeat.o(45398);
                    return;
                }
                break;
            case 2:
                String dl = dl(getIntent().getStringExtra("key_alert_title"), "");
                String dl2 = dl(getIntent().getStringExtra("key_alert_message"), getString(R.string.zb));
                String dl3 = dl(getIntent().getStringExtra("key_alert_confirm"), "");
                final String dl4 = dl(getIntent().getStringExtra("key_alert_deny"), "");
                this.lwd = new a(this, (byte) 0);
                this.lwc = h.a((Context) this, dl2, dl, dl3, dl4, false, (DialogInterface.OnClickListener) this.lwd, (DialogInterface.OnClickListener) this.lwd);
                this.lwc.setOnDismissListener(this.lwd);
                this.lwc.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.AnonymousClass4 */

                    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(45388);
                        if (i2 == 4 && keyEvent.getAction() == 1) {
                            if (!Util.isNullOrNil(dl4)) {
                                AppBrandProcessProxyUI.this.lwd.onClick(AppBrandProcessProxyUI.this.lwc, -3);
                                dialogInterface.dismiss();
                            }
                            AppBrandProcessProxyUI.this.b((AppBrandProxyUIProcessTask.ProcessResult) null);
                        }
                        AppMethodBeat.o(45388);
                        return false;
                    }
                });
                AppMethodBeat.o(45398);
                return;
            case 10000:
                Intent intent = (Intent) getIntent().getParcelableExtra("key_proxy_launch_target_intent");
                if (intent != null) {
                    if (intent.getComponent() != null) {
                        try {
                            Class.forName(intent.getComponent().getClassName());
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", intent.getComponent().getClassName(), e2);
                        }
                    }
                    try {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(45398);
                        return;
                    } catch (Exception e3) {
                        try {
                            Log.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", intent, e3);
                            AppMethodBeat.o(45398);
                            return;
                        } catch (Exception e4) {
                            AppMethodBeat.o(45398);
                            return;
                        }
                    }
                } else {
                    finish();
                    AppMethodBeat.o(45398);
                    return;
                }
            default:
                finish();
                break;
        }
        AppMethodBeat.o(45398);
    }

    private static String dl(String str, String str2) {
        AppMethodBeat.i(45399);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(45399);
            return str2;
        }
        AppMethodBeat.o(45399);
        return str;
    }

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private boolean lwr;

        private a() {
            this.lwr = false;
        }

        /* synthetic */ a(AppBrandProcessProxyUI appBrandProcessProxyUI, byte b2) {
            this();
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(45390);
            wB(i2);
            AppMethodBeat.o(45390);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(45391);
            wB(-2);
            AppBrandProcessProxyUI.this.b((AppBrandProxyUIProcessTask.ProcessResult) null);
            AppMethodBeat.o(45391);
        }

        private void wB(int i2) {
            AppMethodBeat.i(45392);
            if (this.lwr) {
                AppMethodBeat.o(45392);
                return;
            }
            this.lwr = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                resultReceiver.send(i2, null);
            }
            AppMethodBeat.o(45392);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(45400);
        super.onResume();
        int intExtra = getIntent().getIntExtra("key_running_mode", 0);
        if (intExtra == 10000) {
            int i2 = this.lvW + 1;
            this.lvW = i2;
            if (i2 > 1) {
                try {
                    Class cls = (Class) getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
                    if (cls == null) {
                        finish();
                        AppMethodBeat.o(45400);
                        return;
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, cls).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    AppMethodBeat.o(45400);
                    return;
                } catch (Exception e2) {
                    finish();
                }
            }
            AppMethodBeat.o(45400);
        } else if (intExtra == 2) {
            Log.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
            AppMethodBeat.o(45400);
        } else {
            boolean bDG = bDG();
            Log.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", Boolean.valueOf(this.lvZ), Boolean.valueOf(bDG), this.lvY.getClass().getName());
            if (this.lvZ && this.lvY.bDN() && !bDG) {
                b((AppBrandProxyUIProcessTask.ProcessResult) null);
            }
            this.lvZ = true;
            AppMethodBeat.o(45400);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(45401);
        super.onDestroy();
        if (!this.lwb) {
            Log.i("MicroMsg.AppBrandProcessProxyUI", "has result not be called when destory");
            ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
        }
        f.aL(this);
        if (this.lwc != null && this.lwc.isShowing()) {
            this.lwc.dismiss();
            this.lwc = null;
            this.lwd = null;
        }
        AppMethodBeat.o(45401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(45402);
        super.onActivityResult(i2, i3, intent);
        f.aK(this).onActivityResult(i2, i3, intent);
        if (this.lvY == null) {
            Log.e("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, NULL mRequest");
            finish();
            AppMethodBeat.o(45402);
            return;
        }
        Log.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", Integer.valueOf(i2), Integer.valueOf(i3), this.lvY.getClass().getName());
        this.lvZ = false;
        AppMethodBeat.o(45402);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(45403);
        super.finish();
        overridePendingTransition(0, 0);
        if (this.lvX != null) {
            this.lvX.bDM();
        }
        AppMethodBeat.o(45403);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.c
    public final MMActivity bDF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.c
    public final void b(final AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(45404);
        this.lwa = true;
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(45389);
                AppBrandProcessProxyUI.this.finish();
                AppBrandProcessProxyUI.this.c(processResult);
                AppMethodBeat.o(45389);
            }
        });
        AppMethodBeat.o(45404);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void initActivityCloseAnimation() {
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.c
    public final boolean bDG() {
        AppMethodBeat.i(45405);
        if (activityHasDestroyed() || isFinishing() || this.lwa) {
            AppMethodBeat.o(45405);
            return true;
        }
        AppMethodBeat.o(45405);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.c
    public final void c(AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(45406);
        this.lwb = true;
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (!(resultReceiver == null || processResult == null)) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
        AppMethodBeat.o(45406);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(180200);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (this.lvX != null) {
            this.lvX.u(iArr);
        }
        AppMethodBeat.o(180200);
    }
}
