package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

final class zza implements WakeLock.Configuration {
    zza() {
    }

    @Override // com.google.android.gms.stats.WakeLock.Configuration
    public final long getMaximumTimeout(String str, String str2) {
        return MAlarmHandler.NEXT_FIRE_INTERVAL;
    }

    @Override // com.google.android.gms.stats.WakeLock.Configuration
    public final boolean isWorkChainsEnabled() {
        return false;
    }
}
