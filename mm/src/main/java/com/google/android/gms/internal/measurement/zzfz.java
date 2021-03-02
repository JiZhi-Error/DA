package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfz implements ServiceConnection {
    final /* synthetic */ zzfx zzaky;

    private zzfz(zzfx zzfx) {
        this.zzaky = zzfx;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(1501);
        if (iBinder == null) {
            zzfx.zza(this.zzaky).zzge().zzip().log("Install Referrer connection returned with null binder");
            AppMethodBeat.o(1501);
            return;
        }
        try {
            this.zzaky.zzakw = zzs.zza(iBinder);
            if (this.zzaky.zzakw == null) {
                zzfx.zza(this.zzaky).zzge().zzip().log("Install Referrer Service implementation was not found");
                AppMethodBeat.o(1501);
                return;
            }
            zzfx.zza(this.zzaky).zzge().zzir().log("Install Referrer Service connected");
            zzfx.zza(this.zzaky).zzgd().zzc(new zzga(this));
            AppMethodBeat.o(1501);
        } catch (Exception e2) {
            zzfx.zza(this.zzaky).zzge().zzip().zzg("Exception occurred while calling Install Referrer API", e2);
            AppMethodBeat.o(1501);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(1502);
        this.zzaky.zzakw = null;
        zzfx.zza(this.zzaky).zzge().zzir().log("Install Referrer Service disconnected");
        AppMethodBeat.o(1502);
    }
}
