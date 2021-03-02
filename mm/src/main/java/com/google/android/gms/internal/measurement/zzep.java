package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class zzep {
    final String name;
    private final String origin;
    final long timestamp;
    final long zzafp;
    final zzer zzafq;
    final String zzti;

    zzep(zzgl zzgl, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        zzer zzer;
        AppMethodBeat.i(1245);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zzti = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j2;
        this.zzafp = j3;
        if (this.zzafp != 0 && this.zzafp > this.timestamp) {
            zzgl.zzge().zzip().zzg("Event created with reverse previous/current timestamps. appId", zzfg.zzbm(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzer = new zzer(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgl.zzge().zzim().log("Param name can't be null");
                    it.remove();
                } else {
                    Object zzh = zzgl.zzgb().zzh(next, bundle2.get(next));
                    if (zzh == null) {
                        zzgl.zzge().zzip().zzg("Param value can't be null", zzgl.zzga().zzbk(next));
                        it.remove();
                    } else {
                        zzgl.zzgb().zza(bundle2, next, zzh);
                    }
                }
            }
            zzer = new zzer(bundle2);
        }
        this.zzafq = zzer;
        AppMethodBeat.o(1245);
    }

    private zzep(zzgl zzgl, String str, String str2, String str3, long j2, long j3, zzer zzer) {
        AppMethodBeat.i(1244);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzer);
        this.zzti = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j2;
        this.zzafp = j3;
        if (this.zzafp != 0 && this.zzafp > this.timestamp) {
            zzgl.zzge().zzip().zze("Event created with reverse previous/current timestamps. appId, name", zzfg.zzbm(str2), zzfg.zzbm(str3));
        }
        this.zzafq = zzer;
        AppMethodBeat.o(1244);
    }

    public final String toString() {
        AppMethodBeat.i(1247);
        String str = this.zzti;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        String sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(valueOf).append('}').toString();
        AppMethodBeat.o(1247);
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(zzgl zzgl, long j2) {
        AppMethodBeat.i(1246);
        zzep zzep = new zzep(zzgl, this.origin, this.zzti, this.name, this.timestamp, j2, this.zzafq);
        AppMethodBeat.o(1246);
        return zzep;
    }
}
