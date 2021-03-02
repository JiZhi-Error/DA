package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class GoogleApiActivity extends HellActivity implements DialogInterface.OnCancelListener {
    @VisibleForTesting
    private int zzct = 0;

    public static PendingIntent zza(Context context, PendingIntent pendingIntent, int i2) {
        AppMethodBeat.i(11020);
        PendingIntent activity = PendingIntent.getActivity(context, 0, zza(context, pendingIntent, i2, true), 134217728);
        AppMethodBeat.o(11020);
        return activity;
    }

    public static Intent zza(Context context, PendingIntent pendingIntent, int i2, boolean z) {
        AppMethodBeat.i(11021);
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        AppMethodBeat.o(11021);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(11023);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zzct = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                GoogleApiManager zzb = GoogleApiManager.zzb(this);
                switch (i3) {
                    case -1:
                        zzb.zzr();
                        break;
                    case 0:
                        zzb.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                }
            }
        } else if (i2 == 2) {
            this.zzct = 0;
            setResult(i3, intent);
        }
        finish();
        AppMethodBeat.o(11023);
    }

    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.i(11025);
        this.zzct = 0;
        setResult(0);
        finish();
        AppMethodBeat.o(11025);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(11022);
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzct = bundle.getInt("resolution");
        }
        if (this.zzct != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                AppMethodBeat.o(11022);
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
                AppMethodBeat.o(11022);
                return;
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.zzct = 1;
                    AppMethodBeat.o(11022);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    finish();
                    AppMethodBeat.o(11022);
                    return;
                }
            } else {
                GoogleApiAvailability.getInstance().showErrorDialogFragment(this, num.intValue(), 2, this);
                this.zzct = 1;
            }
        }
        AppMethodBeat.o(11022);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(11024);
        bundle.putInt("resolution", this.zzct);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(11024);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
