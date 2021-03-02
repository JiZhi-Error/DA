package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i2) {
        return new zzb(intent, activity, i2);
    }

    public static DialogRedirect getInstance(Fragment fragment, Intent intent, int i2) {
        return new zzc(intent, fragment, i2);
    }

    public static DialogRedirect getInstance(LifecycleFragment lifecycleFragment, Intent intent, int i2) {
        return new zzd(intent, lifecycleFragment, i2);
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            redirect();
        } catch (ActivityNotFoundException e2) {
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void redirect();
}
