package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a implements IDiffDevOAuth {

    /* renamed from: a  reason: collision with root package name */
    private Handler f1462a = null;

    /* renamed from: b  reason: collision with root package name */
    private List<OAuthListener> f1463b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private b f1464c;

    /* renamed from: d  reason: collision with root package name */
    private OAuthListener f1465d = new C0501a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a  reason: collision with other inner class name */
    class C0501a implements OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a  reason: collision with other inner class name */
        class RunnableC0502a implements Runnable {
            RunnableC0502a() {
                AppMethodBeat.i(190372);
                AppMethodBeat.o(190372);
            }

            public void run() {
                AppMethodBeat.i(190373);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.this.f1463b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
                AppMethodBeat.o(190373);
            }
        }

        C0501a() {
            AppMethodBeat.i(190388);
            AppMethodBeat.o(190388);
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            AppMethodBeat.i(190391);
            Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            a.this.f1464c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.f1463b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
            AppMethodBeat.o(190391);
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String str, byte[] bArr) {
            AppMethodBeat.i(190389);
            Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.f1463b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
            AppMethodBeat.o(190389);
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            AppMethodBeat.i(190390);
            Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (a.this.f1462a != null) {
                a.this.f1462a.post(new RunnableC0502a());
            }
            AppMethodBeat.o(190390);
        }
    }

    public a() {
        AppMethodBeat.i(3722);
        AppMethodBeat.o(3722);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener oAuthListener) {
        AppMethodBeat.i(3725);
        if (!this.f1463b.contains(oAuthListener)) {
            this.f1463b.add(oAuthListener);
        }
        AppMethodBeat.o(3725);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        AppMethodBeat.i(3723);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            AppMethodBeat.o(3723);
            return false;
        }
        if (this.f1462a == null) {
            this.f1462a = new Handler(Looper.getMainLooper());
        }
        if (!this.f1463b.contains(oAuthListener)) {
            this.f1463b.add(oAuthListener);
        }
        if (this.f1464c != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            AppMethodBeat.o(3723);
            return true;
        }
        b bVar = new b(str, str2, str3, str4, str5, this.f1465d);
        this.f1464c = bVar;
        if (Build.VERSION.SDK_INT >= 11) {
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            bVar.execute(new Void[0]);
        }
        AppMethodBeat.o(3723);
        return true;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        AppMethodBeat.i(3728);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f1463b.clear();
        stopAuth();
        AppMethodBeat.o(3728);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        AppMethodBeat.i(3727);
        this.f1463b.clear();
        AppMethodBeat.o(3727);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener oAuthListener) {
        AppMethodBeat.i(3726);
        this.f1463b.remove(oAuthListener);
        AppMethodBeat.o(3726);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z;
        AppMethodBeat.i(3724);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            z = this.f1464c == null ? true : this.f1464c.a();
        } catch (Exception e2) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e2.getMessage());
            z = false;
        }
        this.f1464c = null;
        AppMethodBeat.o(3724);
        return z;
    }
}
