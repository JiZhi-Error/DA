package com.tencent.mm.ui.h.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.d;

public final class c {
    protected static String QjB = "https://m.facebook.com/dialog/";
    protected static String QjC = "https://graph.facebook.com/";
    protected static String QjD = "https://api.facebook.com/restserver.php";
    private long QjE = 0;
    public long QjF = 0;
    private Activity QjG;
    private String[] QjH;
    private int QjI;
    private a QjJ;
    private final long QjK = Util.MILLSECONDS_OF_DAY;
    public String jZX = null;
    private String mAppId;

    public interface a {
        void E(Bundle bundle);

        void a(b bVar);

        void a(e eVar);

        void onCancel();
    }

    public c(String str) {
        AppMethodBeat.i(152810);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.o(152810);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.o(152810);
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        AppMethodBeat.i(152811);
        b(activity, strArr, aVar);
        h.INSTANCE.idkeyStat(582, 0, 1, false);
        AppMethodBeat.o(152811);
    }

    private void b(Activity activity, String[] strArr, a aVar) {
        AppMethodBeat.i(152812);
        this.QjJ = aVar;
        a(activity, strArr);
        AppMethodBeat.o(152812);
    }

    private void a(Activity activity, String[] strArr) {
        AppMethodBeat.i(152813);
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        d.lA(activity);
        a(activity, "oauth", bundle, new a() {
            /* class com.tencent.mm.ui.h.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void E(Bundle bundle) {
                AppMethodBeat.i(152806);
                d.hsr();
                d.sync();
                c.this.bnE(bundle.getString("access_token"));
                c.this.bnF(bundle.getString(AccessToken.EXPIRES_IN_KEY));
                if (c.this.gWo()) {
                    Log.d("Facebook-authorize", "Login Success! access_token=" + c.this.jZX + " expires=" + c.this.QjF);
                    c.this.QjJ.E(bundle);
                    AppMethodBeat.o(152806);
                    return;
                }
                c.this.QjJ.a(new e("Failed to receive access token."));
                AppMethodBeat.o(152806);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void a(b bVar) {
                AppMethodBeat.i(152807);
                Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(bVar)));
                c.this.QjJ.a(bVar);
                AppMethodBeat.o(152807);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void a(e eVar) {
                AppMethodBeat.i(152808);
                Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(eVar)));
                c.this.QjJ.a(eVar);
                AppMethodBeat.o(152808);
            }

            @Override // com.tencent.mm.ui.h.a.c.a
            public final void onCancel() {
                AppMethodBeat.i(152809);
                Log.d("Facebook-authorize", "Login canceled");
                c.this.QjJ.onCancel();
                AppMethodBeat.o(152809);
            }
        });
        AppMethodBeat.o(152813);
    }

    public final void j(int i2, int i3, Intent intent) {
        AppMethodBeat.i(152814);
        if (i2 == this.QjI) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (stringExtra == null) {
                    bnE(intent.getStringExtra("access_token"));
                    bnF(intent.getStringExtra(AccessToken.EXPIRES_IN_KEY));
                    if (gWo()) {
                        Log.d("Facebook-authorize", "Login Success! access_token=" + this.jZX + " expires=" + this.QjF);
                        this.QjJ.E(intent.getExtras());
                        AppMethodBeat.o(152814);
                        return;
                    }
                    this.QjJ.a(new e("Failed to receive access token."));
                    AppMethodBeat.o(152814);
                    return;
                } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                    Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                    a(this.QjG, this.QjH);
                    AppMethodBeat.o(152814);
                    return;
                } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                    Log.d("Facebook-authorize", "Login canceled by user.");
                    this.QjJ.onCancel();
                    AppMethodBeat.o(152814);
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                    if (stringExtra2 != null) {
                        stringExtra = stringExtra + ":" + stringExtra2;
                    }
                    Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(stringExtra)));
                    this.QjJ.a(new e(stringExtra));
                    AppMethodBeat.o(152814);
                    return;
                }
            } else if (i3 == 0) {
                if (intent != null) {
                    Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.QjJ.a(new b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                    AppMethodBeat.o(152814);
                    return;
                }
                Log.d("Facebook-authorize", "Login canceled by user.");
                this.QjJ.onCancel();
            }
        }
        AppMethodBeat.o(152814);
    }

    public final String kx(Context context) {
        AppMethodBeat.i(152815);
        f.ky(context);
        bnE(null);
        this.QjF = 0;
        AppMethodBeat.o(152815);
        return null;
    }

    public final String r(String str, Bundle bundle) {
        AppMethodBeat.i(152816);
        String a2 = a(str, bundle, "GET");
        AppMethodBeat.o(152816);
        return a2;
    }

    public final String a(String str, Bundle bundle, String str2) {
        AppMethodBeat.i(152817);
        bundle.putString("format", "json");
        if (gWo()) {
            bundle.putString("access_token", this.jZX);
        }
        String e2 = f.e(str != null ? QjC + str : QjD, str2, bundle);
        AppMethodBeat.o(152817);
        return e2;
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        AppMethodBeat.i(152818);
        String str2 = QjB + str;
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ServerProtocol.DIALOG_REDIRECT_URI);
        if (str.equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.mAppId);
        } else {
            bundle.putString("app_id", this.mAppId);
        }
        if (gWo()) {
            bundle.putString("access_token", this.jZX);
        }
        String str3 = str2 + "?" + f.bw(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            f.Y(context, "Error", "Application requires permission to access the Internet");
            AppMethodBeat.o(152818);
            return;
        }
        new g(context, str3, aVar).show();
        AppMethodBeat.o(152818);
    }

    public final void bnE(String str) {
        AppMethodBeat.i(152820);
        this.jZX = str;
        this.QjE = System.currentTimeMillis();
        AppMethodBeat.o(152820);
    }

    public final void bnF(String str) {
        long currentTimeMillis;
        AppMethodBeat.i(152821);
        if (str != null) {
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                currentTimeMillis = 0;
            } else {
                currentTimeMillis = System.currentTimeMillis() + (Util.safeParseLong(str) * 1000);
            }
            this.QjF = currentTimeMillis;
        }
        AppMethodBeat.o(152821);
    }

    public final boolean gWo() {
        AppMethodBeat.i(152819);
        if (this.jZX == null || (this.QjF != 0 && System.currentTimeMillis() >= this.QjF)) {
            AppMethodBeat.o(152819);
            return false;
        }
        AppMethodBeat.o(152819);
        return true;
    }
}
