package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class PassiveTimedConnectionMatcher {
    private final long zzym;
    private final int zzyn;
    private final n<String, Long> zzyo;

    public PassiveTimedConnectionMatcher() {
        AppMethodBeat.i(4983);
        this.zzym = Util.MILLSECONDS_OF_MINUTE;
        this.zzyn = 10;
        this.zzyo = new n<>(10);
        AppMethodBeat.o(4983);
    }

    public PassiveTimedConnectionMatcher(int i2, long j2) {
        AppMethodBeat.i(4984);
        this.zzym = j2;
        this.zzyn = i2;
        this.zzyo = new n<>();
        AppMethodBeat.o(4984);
    }

    public Long get(String str) {
        Long l;
        AppMethodBeat.i(4985);
        synchronized (this) {
            try {
                l = this.zzyo.get(str);
            } finally {
                AppMethodBeat.o(4985);
            }
        }
        return l;
    }

    public Long put(String str) {
        Long put;
        AppMethodBeat.i(4986);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.zzym;
        synchronized (this) {
            long j3 = j2;
            while (this.zzyo.size() >= this.zzyn) {
                try {
                    for (int size = this.zzyo.size() - 1; size >= 0; size--) {
                        if (elapsedRealtime - this.zzyo.valueAt(size).longValue() > j3) {
                            this.zzyo.removeAt(size);
                        }
                    }
                    long j4 = j3 / 2;
                    new StringBuilder(94).append("The max capacity ").append(this.zzyn).append(" is not enough. Current durationThreshold is: ").append(j4);
                    j3 = j4;
                } finally {
                    AppMethodBeat.o(4986);
                }
            }
            put = this.zzyo.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean remove(String str) {
        boolean z;
        AppMethodBeat.i(4987);
        synchronized (this) {
            try {
                z = this.zzyo.remove(str) != null;
            } finally {
                AppMethodBeat.o(4987);
            }
        }
        return z;
    }

    public boolean removeByPrefix(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(4988);
        synchronized (this) {
            int i2 = 0;
            z = false;
            while (i2 < size()) {
                try {
                    String keyAt = this.zzyo.keyAt(i2);
                    if (keyAt == null || !keyAt.startsWith(str)) {
                        z2 = z;
                    } else {
                        this.zzyo.remove(keyAt);
                        z2 = true;
                    }
                    i2++;
                    z = z2;
                } finally {
                    AppMethodBeat.o(4988);
                }
            }
        }
        return z;
    }

    public int size() {
        int size;
        AppMethodBeat.i(4989);
        synchronized (this) {
            try {
                size = this.zzyo.size();
            } finally {
                AppMethodBeat.o(4989);
            }
        }
        return size;
    }
}
