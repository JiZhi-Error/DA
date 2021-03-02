package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.content.c;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzfg = false;
    private boolean zzfh = false;
    private SignInConfiguration zzfi;
    private boolean zzfj;
    private int zzfk;
    private Intent zzfl;

    /* access modifiers changed from: package-private */
    public class zzd implements p.a<Void> {
        private zzd() {
        }

        @Override // android.support.v4.app.p.a
        public final c<Void> onCreateLoader(int i2, Bundle bundle) {
            AppMethodBeat.i(88302);
            zzf zzf = new zzf(SignInHubActivity.this, GoogleApiClient.getAllClients());
            AppMethodBeat.o(88302);
            return zzf;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v4.content.c, java.lang.Object] */
        @Override // android.support.v4.app.p.a
        public final /* synthetic */ void onLoadFinished(c<Void> cVar, Void r6) {
            AppMethodBeat.i(88303);
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzfk, SignInHubActivity.this.zzfl);
            SignInHubActivity.this.finish();
            AppMethodBeat.o(88303);
        }

        @Override // android.support.v4.app.p.a
        public final void onLoaderReset(c<Void> cVar) {
        }
    }

    private final void zzd(int i2) {
        AppMethodBeat.i(88308);
        Status status = new Status(i2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzfg = false;
        AppMethodBeat.o(88308);
    }

    private final void zzu() {
        AppMethodBeat.i(88307);
        getSupportLoaderManager().a(new zzd());
        zzfg = false;
        AppMethodBeat.o(88307);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(88306);
        if (this.zzfh) {
            AppMethodBeat.o(88306);
            return;
        }
        setResult(0);
        switch (i2) {
            case 40962:
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                        GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                        zzq.zze(this).zzd(this.zzfi.zzt(), googleSignInAccount);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.zzfj = true;
                        this.zzfk = i3;
                        this.zzfl = intent;
                        zzu();
                        AppMethodBeat.o(88306);
                        return;
                    } else if (intent.hasExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE)) {
                        zzd(intent.getIntExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 8));
                        AppMethodBeat.o(88306);
                        return;
                    }
                }
                zzd(8);
                break;
        }
        AppMethodBeat.o(88306);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88304);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zzd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            AppMethodBeat.o(88304);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            this.zzfi = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
            if (this.zzfi == null) {
                setResult(0);
                finish();
                AppMethodBeat.o(88304);
                return;
            }
            if (!(bundle == null)) {
                this.zzfj = bundle.getBoolean("signingInGoogleApiClients");
                if (this.zzfj) {
                    this.zzfk = bundle.getInt("signInResultCode");
                    this.zzfl = (Intent) bundle.getParcelable("signInResultData");
                    zzu();
                }
                AppMethodBeat.o(88304);
            } else if (zzfg) {
                setResult(0);
                zzd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                AppMethodBeat.o(88304);
            } else {
                zzfg = true;
                Intent intent2 = new Intent(action);
                if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra("config", this.zzfi);
                try {
                    startActivityForResult(intent2, 40962);
                    AppMethodBeat.o(88304);
                } catch (ActivityNotFoundException e2) {
                    this.zzfh = true;
                    zzd(17);
                    AppMethodBeat.o(88304);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            } else {
                new String("Unknown action: ");
            }
            finish();
            AppMethodBeat.o(88304);
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(88305);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzfj);
        if (this.zzfj) {
            bundle.putInt("signInResultCode", this.zzfk);
            bundle.putParcelable("signInResultData", this.zzfl);
        }
        AppMethodBeat.o(88305);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
