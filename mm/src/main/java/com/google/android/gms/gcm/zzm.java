package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm implements zzn {
    private final PendingIntent zzat;
    private final Context zzk;

    zzm(Context context) {
        AppMethodBeat.i(3713);
        this.zzk = context;
        this.zzat = PendingIntent.getBroadcast(context, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
        AppMethodBeat.o(3713);
    }

    private final Intent zzh(String str) {
        AppMethodBeat.i(3717);
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("app", this.zzat);
        intent.putExtra("source", 4);
        intent.putExtra("source_version", 12451000);
        intent.putExtra("scheduler_action", str);
        AppMethodBeat.o(3717);
        return intent;
    }

    @Override // com.google.android.gms.gcm.zzn
    public final boolean zzd(ComponentName componentName) {
        AppMethodBeat.i(3716);
        Intent zzh = zzh("CANCEL_ALL");
        zzh.putExtra("component", componentName);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.o(3716);
        return true;
    }

    @Override // com.google.android.gms.gcm.zzn
    public final boolean zzd(ComponentName componentName, String str) {
        AppMethodBeat.i(3715);
        Intent zzh = zzh("CANCEL_TASK");
        zzh.putExtra("component", componentName);
        zzh.putExtra("tag", str);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.o(3715);
        return true;
    }

    @Override // com.google.android.gms.gcm.zzn
    public final boolean zzd(Task task) {
        AppMethodBeat.i(3714);
        Intent zzh = zzh("SCHEDULE_TASK");
        Bundle bundle = new Bundle();
        task.toBundle(bundle);
        zzh.putExtras(bundle);
        this.zzk.sendBroadcast(zzh);
        AppMethodBeat.o(3714);
        return true;
    }
}
