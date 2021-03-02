package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public final class zzfv {
    private final long zzabj;
    private final /* synthetic */ zzfr zzakq;
    @VisibleForTesting
    private final String zzaks;
    private final String zzakt;
    private final String zzaku;

    private zzfv(zzfr zzfr, String str, long j2) {
        this.zzakq = zzfr;
        AppMethodBeat.i(1489);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j2 > 0);
        this.zzaks = String.valueOf(str).concat(":start");
        this.zzakt = String.valueOf(str).concat(":count");
        this.zzaku = String.valueOf(str).concat(":value");
        this.zzabj = j2;
        AppMethodBeat.o(1489);
    }

    private final void zzfh() {
        AppMethodBeat.i(1490);
        this.zzakq.zzab();
        long currentTimeMillis = this.zzakq.zzbt().currentTimeMillis();
        SharedPreferences.Editor edit = zzfr.zza(this.zzakq).edit();
        edit.remove(this.zzakt);
        edit.remove(this.zzaku);
        edit.putLong(this.zzaks, currentTimeMillis);
        edit.apply();
        AppMethodBeat.o(1490);
    }

    private final long zzfj() {
        AppMethodBeat.i(1493);
        long j2 = zzfr.zza(this.zzakq).getLong(this.zzaks, 0);
        AppMethodBeat.o(1493);
        return j2;
    }

    public final void zzc(String str, long j2) {
        AppMethodBeat.i(1491);
        this.zzakq.zzab();
        if (zzfj() == 0) {
            zzfh();
        }
        if (str == null) {
            str = "";
        }
        long j3 = zzfr.zza(this.zzakq).getLong(this.zzakt, 0);
        if (j3 <= 0) {
            SharedPreferences.Editor edit = zzfr.zza(this.zzakq).edit();
            edit.putString(this.zzaku, str);
            edit.putLong(this.zzakt, 1);
            edit.apply();
            AppMethodBeat.o(1491);
            return;
        }
        boolean z = (this.zzakq.zzgb().zzlc().nextLong() & MAlarmHandler.NEXT_FIRE_INTERVAL) < MAlarmHandler.NEXT_FIRE_INTERVAL / (j3 + 1);
        SharedPreferences.Editor edit2 = zzfr.zza(this.zzakq).edit();
        if (z) {
            edit2.putString(this.zzaku, str);
        }
        edit2.putLong(this.zzakt, j3 + 1);
        edit2.apply();
        AppMethodBeat.o(1491);
    }

    public final Pair<String, Long> zzfi() {
        long abs;
        AppMethodBeat.i(1492);
        this.zzakq.zzab();
        this.zzakq.zzab();
        long zzfj = zzfj();
        if (zzfj == 0) {
            zzfh();
            abs = 0;
        } else {
            abs = Math.abs(zzfj - this.zzakq.zzbt().currentTimeMillis());
        }
        if (abs < this.zzabj) {
            AppMethodBeat.o(1492);
            return null;
        } else if (abs > (this.zzabj << 1)) {
            zzfh();
            AppMethodBeat.o(1492);
            return null;
        } else {
            String string = zzfr.zza(this.zzakq).getString(this.zzaku, null);
            long j2 = zzfr.zza(this.zzakq).getLong(this.zzakt, 0);
            zzfh();
            if (string == null || j2 <= 0) {
                Pair<String, Long> pair = zzfr.zzajs;
                AppMethodBeat.o(1492);
                return pair;
            }
            Pair<String, Long> pair2 = new Pair<>(string, Long.valueOf(j2));
            AppMethodBeat.o(1492);
            return pair2;
        }
    }
}
