package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.d;
import org.json.JSONException;
import org.json.JSONObject;

@a(7)
@d.b
public class WebViewStubProxyUI extends MMActivity {
    private int IRl;
    private f ISw = null;
    public boolean Jdc = false;
    private boolean Jdd = false;
    private final f Jde = new f() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass5 */

        public final IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean afl(int i2) {
            AppMethodBeat.i(79263);
            WebViewStubProxyUI.this.ISw.afl(i2);
            AppMethodBeat.o(79263);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean f(int i2, Bundle bundle) {
            AppMethodBeat.i(79264);
            WebViewStubProxyUI.this.ISw.f(i2, bundle);
            AppMethodBeat.o(79264);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean a(d dVar) {
            AppMethodBeat.i(79265);
            WebViewStubProxyUI.this.ISw.a(dVar);
            AppMethodBeat.o(79265);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean a(final String str, final String str2, final Bundle bundle, final boolean z) {
            AppMethodBeat.i(79266);
            Log.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.this.iMQ = true;
            WebViewStubProxyUI.this.Jdc = WebViewStubProxyUI.aZO(str2);
            WebViewStubProxyUI.this.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(79262);
                    g.ahd(WebViewStubProxyUI.this.IRl).a((Context) null, (f) null, (f) null);
                    WebViewStubProxyUI.this.finish();
                    try {
                        WebViewStubProxyUI.this.ISw.a(str, str2, bundle, z);
                        AppMethodBeat.o(79262);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e2.getMessage());
                        AppMethodBeat.o(79262);
                    }
                }
            });
            AppMethodBeat.o(79266);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String fWW() {
            AppMethodBeat.i(79267);
            String fWW = WebViewStubProxyUI.this.ISw.fWW();
            AppMethodBeat.o(79267);
            return fWW;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String getCurrentUrl() {
            AppMethodBeat.i(79268);
            String currentUrl = WebViewStubProxyUI.this.ISw.getCurrentUrl();
            AppMethodBeat.o(79268);
            return currentUrl;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String ePp() {
            AppMethodBeat.i(211035);
            String ePp = WebViewStubProxyUI.this.ISw.ePp();
            AppMethodBeat.o(211035);
            return ePp;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String fWX() {
            AppMethodBeat.i(79269);
            String fWX = WebViewStubProxyUI.this.ISw.fWX();
            AppMethodBeat.o(79269);
            return fWX;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final int fWY() {
            AppMethodBeat.i(79270);
            int fWY = WebViewStubProxyUI.this.ISw.fWY();
            AppMethodBeat.o(79270);
            return fWY;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yL(boolean z) {
            AppMethodBeat.i(79271);
            WebViewStubProxyUI.this.ISw.yL(z);
            AppMethodBeat.o(79271);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yM(boolean z) {
            AppMethodBeat.i(79272);
            WebViewStubProxyUI.this.ISw.yM(z);
            AppMethodBeat.o(79272);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void t(int i2, Bundle bundle) {
            AppMethodBeat.i(79273);
            WebViewStubProxyUI.this.ISw.t(i2, bundle);
            AppMethodBeat.o(79273);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void fWV() {
            AppMethodBeat.i(79274);
            WebViewStubProxyUI.this.ISw.fWV();
            AppMethodBeat.o(79274);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aM(Bundle bundle) {
            AppMethodBeat.i(79275);
            WebViewStubProxyUI.this.ISw.aM(bundle);
            AppMethodBeat.o(79275);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aWP(String str) {
            AppMethodBeat.i(79276);
            WebViewStubProxyUI.this.ISw.aWP(str);
            AppMethodBeat.o(79276);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void fWZ() {
            AppMethodBeat.i(79277);
            if (WebViewStubProxyUI.this.ISw == null) {
                AppMethodBeat.o(79277);
                return;
            }
            WebViewStubProxyUI.this.ISw.fWZ();
            AppMethodBeat.o(79277);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void e(String str, String str2, int i2, int i3) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void lz(String str, String str2) {
            AppMethodBeat.i(79278);
            WebViewStubProxyUI.this.ISw.lz(str, str2);
            AppMethodBeat.o(79278);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(79279);
            if (WebViewStubProxyUI.this.ISw == null) {
                Log.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
                Bundle bundle2 = new Bundle();
                AppMethodBeat.o(79279);
                return bundle2;
            }
            Bundle j2 = WebViewStubProxyUI.this.ISw.j(i2, bundle);
            AppMethodBeat.o(79279);
            return j2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aL(Bundle bundle) {
            AppMethodBeat.i(79280);
            WebViewStubProxyUI.this.ISw.aL(bundle);
            AppMethodBeat.o(79280);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yN(boolean z) {
            AppMethodBeat.i(79281);
            WebViewStubProxyUI.this.ISw.yN(z);
            AppMethodBeat.o(79281);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void lA(String str, String str2) {
            AppMethodBeat.i(79282);
            WebViewStubProxyUI.this.ISw.lA(str, str2);
            AppMethodBeat.o(79282);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final Bundle fl(String str, String str2) {
            AppMethodBeat.i(79283);
            Bundle fl = WebViewStubProxyUI.this.ISw.fl(str, str2);
            AppMethodBeat.o(79283);
            return fl;
        }
    };
    private MTimerHandler Jdf = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(79286);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.o(79286);
            return false;
        }
    }, true);
    private DialogInterface.OnDismissListener ebe = new DialogInterface.OnDismissListener() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass6 */

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(79284);
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            AppMethodBeat.o(79284);
        }
    };
    private boolean iMQ = false;
    private String nlH = "";
    private MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(79285);
            if (WebViewStubProxyUI.this.getWindow() != null && WebViewStubProxyUI.this.getWindow().getDecorView() != null && WebViewStubProxyUI.this.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.f(WebViewStubProxyUI.this);
                WebViewStubProxyUI.this.Jdd = true;
                AppMethodBeat.o(79285);
                return false;
            } else if (WebViewStubProxyUI.this.tnt < 10) {
                WebViewStubProxyUI.e(WebViewStubProxyUI.this);
                AppMethodBeat.o(79285);
                return true;
            } else {
                Log.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79285);
                return false;
            }
        }
    }, true);
    private int tnt = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewStubProxyUI() {
        AppMethodBeat.i(79287);
        AppMethodBeat.o(79287);
    }

    static /* synthetic */ int e(WebViewStubProxyUI webViewStubProxyUI) {
        int i2 = webViewStubProxyUI.tnt + 1;
        webViewStubProxyUI.tnt = i2;
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        com.tencent.mm.ui.widget.a.d n;
        AppMethodBeat.i(79288);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.ISw = webViewStubCallbackWrapper.JhP;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.IRl = intent.getIntExtra("webview_binder_id", 0);
        this.nlH = intent.getStringExtra("proxyui_function_key");
        Log.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", Integer.valueOf(intExtra), Integer.valueOf(this.IRl), this.nlH);
        if ("startMonitoringBeacons".equals(this.nlH)) {
            this.Jdc = true;
        }
        switch (intExtra) {
            case 1:
                if (!this.Jdd) {
                    this.timer.startTimer(100);
                }
                if (this.Jdc) {
                    this.Jdf.startTimer(5000);
                    AppMethodBeat.o(79288);
                    return;
                }
                break;
            case 2:
                final yv yvVar = new yv();
                yvVar.callback = new Runnable() {
                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(79257);
                        if (!yvVar.efc.efd) {
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.o(79257);
                            return;
                        }
                        if (WebViewStubProxyUI.this.ISw != null) {
                            try {
                                WebViewStubProxyUI.this.ISw.f(1001, null);
                            } catch (RemoteException e2) {
                                Log.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e2.getMessage());
                            }
                        }
                        WebViewStubProxyUI.this.finish();
                        c.a aVar = c.JYn;
                        if (aVar != null) {
                            aVar.bV(WebViewStubProxyUI.this);
                        }
                        AppMethodBeat.o(79257);
                    }
                };
                yvVar.efb.context = this;
                yvVar.efb.type = intent.getIntExtra("update_type_key", 0);
                if (yvVar.efb.type <= 0) {
                    Log.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + yvVar.efb.type);
                    finish();
                    AppMethodBeat.o(79288);
                    return;
                }
                EventCenter.instance.asyncPublish(yvVar, Looper.myLooper());
                AppMethodBeat.o(79288);
                return;
            case 3:
                ci aEY = ((l) com.tencent.mm.kernel.g.af(l.class)).aSW().aEY("@t.qq.com");
                if (!z.aUM()) {
                    n = h.a(this, (int) R.string.bcp, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(79258);
                            com.tencent.mm.plugin.webview.a.a.jRt.g(new Intent(), WebViewStubProxyUI.this);
                            AppMethodBeat.o(79258);
                        }
                    }, (DialogInterface.OnClickListener) null);
                } else if (aEY == null || Util.isNullOrNil(aEY.name)) {
                    n = h.n(this, R.string.gvq, R.string.zb);
                } else {
                    com.tencent.mm.kernel.g.azz().a(new y(getIntent().getIntExtra("type", 0), Util.nullAsNil(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.ISw.afl(0);
                        n = null;
                    } catch (Exception e2) {
                        Log.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e2.getMessage());
                        n = null;
                    }
                }
                if (n == null) {
                    finish();
                    AppMethodBeat.o(79288);
                    return;
                }
                n.setOnDismissListener(this.ebe);
                AppMethodBeat.o(79288);
                return;
            case 4:
                this.timer.startTimer(100);
                AppMethodBeat.o(79288);
                return;
            case 5:
                ((p) com.tencent.mm.kernel.g.af(p.class)).a(this, intent.getStringExtra("proxyui_handle_event_url"), this.ebe);
                AppMethodBeat.o(79288);
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    Log.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    AppMethodBeat.o(79288);
                    return;
                }
            case 8:
                String stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (Util.isNullOrNil(stringExtra)) {
                    Log.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    AppMethodBeat.o(79288);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                uu uuVar = new uu();
                uuVar.ebc.context = this;
                uuVar.ebc.ebd = stringExtra;
                uuVar.ebc.ebe = this.ebe;
                uuVar.ebc.ebf = bundle2;
                EventCenter.instance.publish(uuVar);
                AppMethodBeat.o(79288);
                return;
            case 9:
                Intent intent2 = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent2.setFlags(603979776);
                Intent intent3 = new Intent();
                intent3.setClass(this, SimpleLoginUI.class);
                MMWizardActivity.b(this, intent3, intent2);
                finish();
                AppMethodBeat.o(79288);
                return;
            case 10:
                String stringExtra2 = getIntent().getStringExtra("KAppId");
                String stringExtra3 = getIntent().getStringExtra("shortcut_user_name");
                if (!Util.isNullOrNil(stringExtra2) && !Util.isNullOrNil(stringExtra3)) {
                    getString(R.string.zb);
                    final q a2 = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(79259);
                            Log.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.o(79259);
                        }
                    });
                    a2.show();
                    e.a(MMApplicationContext.getContext(), stringExtra3, stringExtra2, new e.a() {
                        /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.webview.model.e.a
                        public final void pI(boolean z) {
                            AppMethodBeat.i(79261);
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            if (z) {
                                if (WebViewStubProxyUI.this.ISw != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("add_shortcut_status", true);
                                    try {
                                        WebViewStubProxyUI.this.ISw.j(54, bundle);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
                                    }
                                }
                                h.a((Context) WebViewStubProxyUI.this, (int) R.string.j42, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.AnonymousClass4.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(79260);
                                        WebViewStubProxyUI.this.finish();
                                        AppMethodBeat.o(79260);
                                    }
                                });
                                AppMethodBeat.o(79261);
                                return;
                            }
                            Toast.makeText(WebViewStubProxyUI.this.getContext(), WebViewStubProxyUI.this.getContext().getString(R.string.j41), 0).show();
                            if (WebViewStubProxyUI.this.ISw != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putBoolean("add_shortcut_status", false);
                                try {
                                    WebViewStubProxyUI.this.ISw.j(54, bundle2);
                                } catch (Exception e3) {
                                    Log.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e3.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            AppMethodBeat.o(79261);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(79288);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(79289);
        int intExtra = getIntent().getIntExtra("screen_orientation", -1);
        AppMethodBeat.o(79289);
        return intExtra;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79290);
        super.onDestroy();
        if (!this.Jdc) {
            this.ISw = null;
        }
        g.ahd(this.IRl).cLD();
        if (!this.iMQ && Util.isEqual(g.ahd(this.IRl).JsO, this.nlH)) {
            g.ahd(this.IRl).K(false, this.nlH);
            Log.w("MicroMsg.WebViewStubProxyUI", "onDestroy setIsBusy false");
        }
        Log.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
        AppMethodBeat.o(79290);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(79291);
        switch (i2) {
            case 72:
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                if (iArr[0] != 0) {
                    g.ahd(this.IRl).d(i2, 0, (Intent) null);
                    break;
                } else {
                    g.ahd(this.IRl).d(i2, -1, (Intent) null);
                    AppMethodBeat.o(79291);
                    return;
                }
        }
        AppMethodBeat.o(79291);
    }

    static /* synthetic */ boolean aZO(String str) {
        AppMethodBeat.i(182701);
        if (str != null) {
            String[] split = str.split(":");
            if (split.length > 0 && split[0].equals("startMonitoringBeacons")) {
                AppMethodBeat.o(182701);
                return true;
            }
        }
        AppMethodBeat.o(182701);
        return false;
    }

    static /* synthetic */ void f(WebViewStubProxyUI webViewStubProxyUI) {
        AppMethodBeat.i(182702);
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        Log.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = ".concat(String.valueOf(intExtra)));
        switch (intExtra) {
            case 1:
                n nVar = new n();
                nVar.type = intent.getStringExtra("proxyui_type_key");
                nVar.mhO = intent.getStringExtra("proxyui_function_key");
                nVar.ISe = intent.getStringExtra("proxyui_callback_key");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    Log.e("MicroMsg.WebViewStubProxyUI", "getExtras from intent, returned NULL");
                    extras = Bundle.EMPTY;
                }
                nVar.params = n.aN(extras.getBundle("compatParams"));
                nVar.IRs = extras.getBundle("jsEngine");
                try {
                    String string = extras.getString("rawParams");
                    if (!TextUtils.isEmpty(string)) {
                        nVar.ISf = new JSONObject(string);
                    }
                } catch (JSONException e2) {
                    Log.e("MicroMsg.WebViewStubProxyUI", "get rawParams, e = %s", e2);
                }
                JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                f ahd = g.ahd(webViewStubProxyUI.IRl);
                ahd.zo(false);
                ahd.a(webViewStubProxyUI, webViewStubProxyUI.Jde, webViewStubProxyUI.ISw);
                if (!ahd.a(nVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.Jde.a(null, null, null, true);
                        AppMethodBeat.o(182702);
                        return;
                    } catch (Exception e3) {
                        Log.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e3.getMessage());
                        AppMethodBeat.o(182702);
                        return;
                    }
                }
                break;
            case 2:
            case 3:
            default:
                Log.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = ".concat(String.valueOf(intExtra)));
                webViewStubProxyUI.finish();
                break;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    new JsapiPermissionWrapper(2);
                }
                g.ahd(webViewStubProxyUI.IRl).a(webViewStubProxyUI, webViewStubProxyUI.Jde);
                if (!g.ahd(webViewStubProxyUI.IRl).baT(intent.getStringExtra("proxyui_username_key"))) {
                    Log.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    AppMethodBeat.o(182702);
                    return;
                }
                break;
        }
        AppMethodBeat.o(182702);
    }
}
