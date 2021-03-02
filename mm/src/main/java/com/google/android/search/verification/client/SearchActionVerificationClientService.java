package com.google.android.search.verification.client;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.internal.GmsIntents;
import com.google.android.search.verification.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public abstract class SearchActionVerificationClientService extends IntentService {
    private final boolean bKd = isDebugMode();
    private final long bKe = 1000;
    private final Intent bKf = new Intent("com.google.android.googlequicksearchbox.SEARCH_ACTION_VERIFICATION_SERVICE").setPackage(GmsIntents.GOOGLE_NOW_PACKAGE_NAME);
    private a bKg;
    private com.google.android.search.verification.a.a bKh = null;

    public abstract boolean a(Intent intent, boolean z);

    private static boolean isDebugMode() {
        return !"user".equals(Build.TYPE);
    }

    public SearchActionVerificationClientService() {
        super("SearchActionVerificationClientService");
    }

    class a implements ServiceConnection {
        a() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(73442);
            boolean unused = SearchActionVerificationClientService.this.bKd;
            SearchActionVerificationClientService.this.bKh = a.AbstractBinderC0118a.g(iBinder);
            AppMethodBeat.o(73442);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(73443);
            SearchActionVerificationClientService.this.bKh = null;
            boolean unused = SearchActionVerificationClientService.this.bKd;
            AppMethodBeat.o(73443);
        }
    }

    private boolean isConnected() {
        return this.bKh != null;
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        boolean z = true;
        if (intent != null) {
            boolean z2 = isDebugMode() || xQ();
            long nanoTime = System.nanoTime();
            while (!isConnected() && System.nanoTime() - nanoTime < this.bKe * TimeUtil.SECOND_TO_US) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e2) {
                    if (this.bKd) {
                        String valueOf = String.valueOf(e2);
                        new StringBuilder(String.valueOf(valueOf).length() + 33).append("Unexpected InterruptedException: ").append(valueOf);
                    }
                }
            }
            if (!isConnected()) {
                String valueOf2 = String.valueOf(intent);
                new StringBuilder(String.valueOf(valueOf2).length() + 62).append("VerificationService is not connected, unable to check intent: ").append(valueOf2);
            } else if (intent.hasExtra("SearchActionVerificationClientExtraIntent")) {
                Intent intent2 = (Intent) intent.getParcelableExtra("SearchActionVerificationClientExtraIntent");
                if (this.bKd) {
                    d(intent2);
                }
                try {
                    new StringBuilder(24).append("API version: ").append(this.bKh.getVersion());
                    Bundle bundle = new Bundle();
                    if (!z2 || !this.bKh.a(intent2, bundle)) {
                        z = false;
                    }
                    a(intent2, z);
                } catch (RemoteException e3) {
                    String valueOf3 = String.valueOf(e3.getMessage());
                    if (valueOf3.length() != 0) {
                        "Remote exception: ".concat(valueOf3);
                    } else {
                        new String("Remote exception: ");
                    }
                }
            } else if (this.bKd) {
                String valueOf4 = String.valueOf(intent);
                new StringBuilder(String.valueOf(valueOf4).length() + 28).append("No extra, nothing to check: ").append(valueOf4);
            }
        }
    }

    public final void onCreate() {
        super.onCreate();
        this.bKg = new a();
        bindService(this.bKf, this.bKg, 1);
    }

    public final void onDestroy() {
        super.onDestroy();
        unbindService(this.bKg);
    }

    private boolean xQ() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(GmsIntents.GOOGLE_NOW_PACKAGE_NAME, 64);
            if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                return false;
            }
            return Base64.encodeToString(packageInfo.signatures[0].toByteArray(), 2).equals("MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK");
        } catch (PackageManager.NameNotFoundException e2) {
            if (!this.bKd) {
                return false;
            }
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 34).append("Unexpected NameNotFoundException: ").append(valueOf);
            return false;
        }
    }

    private static void d(Intent intent) {
        String valueOf = String.valueOf(intent);
        new StringBuilder(String.valueOf(valueOf).length() + 1).append("\t").append(valueOf);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                String.format("\t%s: %s", str, extras.get(str));
            }
        }
    }
}
