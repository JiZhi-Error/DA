package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new WakeLockEventCreator();
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long mTimeout;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzxv;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private int zzxw;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long zzyd;
    private long zzyf;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String zzyq;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zzyr;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String zzys;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int zzyt;
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final List<String> zzyu;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String zzyv;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private int zzyw;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String zzyx;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzyy;

    static {
        AppMethodBeat.i(5002);
        AppMethodBeat.o(5002);
    }

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 11) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 14) int i5, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f2, @SafeParcelable.Param(id = 16) long j4, @SafeParcelable.Param(id = 17) String str5) {
        this.zzal = i2;
        this.zzxv = j2;
        this.zzxw = i3;
        this.zzyq = str;
        this.zzyr = str3;
        this.zzys = str5;
        this.zzyt = i4;
        this.zzyf = -1;
        this.zzyu = list;
        this.zzyv = str2;
        this.zzyd = j3;
        this.zzyw = i5;
        this.zzyx = str4;
        this.zzyy = f2;
        this.mTimeout = j4;
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5);
    }

    public WakeLockEvent(WakeLockEvent wakeLockEvent) {
        this(wakeLockEvent.zzal, wakeLockEvent.getTimeMillis(), wakeLockEvent.getEventType(), wakeLockEvent.getWakeLockName(), wakeLockEvent.getWakeLockType(), wakeLockEvent.getCallingPackages(), wakeLockEvent.getEventKey(), wakeLockEvent.getElapsedRealtime(), wakeLockEvent.getDeviceState(), wakeLockEvent.getSecondaryWakeLockName(), wakeLockEvent.getHostPackage(), wakeLockEvent.getBeginPowerPercentage(), wakeLockEvent.getTimeout(), wakeLockEvent.getCodePackage());
        AppMethodBeat.i(4996);
        AppMethodBeat.o(4996);
    }

    public static boolean checkEventType(StatsEvent statsEvent) {
        AppMethodBeat.i(5000);
        if (7 == statsEvent.getEventType() || 8 == statsEvent.getEventType() || 9 == statsEvent.getEventType() || 10 == statsEvent.getEventType() || 11 == statsEvent.getEventType() || 12 == statsEvent.getEventType()) {
            AppMethodBeat.o(5000);
            return true;
        }
        AppMethodBeat.o(5000);
        return false;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final StatsEvent ReconstructCloseEvent(StatsEvent statsEvent) {
        AppMethodBeat.i(4997);
        if (statsEvent instanceof WakeLockEvent) {
            WakeLockEvent wakeLockEvent = (WakeLockEvent) statsEvent;
            StatsEvent durationMillis = new WakeLockEvent(wakeLockEvent).setEventType(getEventType()).setDurationMillis(getElapsedRealtime() - wakeLockEvent.getElapsedRealtime());
            AppMethodBeat.o(4997);
            return durationMillis;
        }
        AppMethodBeat.o(4997);
        return statsEvent;
    }

    public final float getBeginPowerPercentage() {
        return this.zzyy;
    }

    @Nullable
    public final List<String> getCallingPackages() {
        return this.zzyu;
    }

    public final String getCodePackage() {
        return this.zzys;
    }

    public final int getDeviceState() {
        return this.zzyw;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getDurationMillis() {
        return this.zzyf;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getElapsedRealtime() {
        return this.zzyd;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String getEventKey() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.zzxw;
    }

    public final String getHostPackage() {
        return this.zzyx;
    }

    public final String getSecondaryWakeLockName() {
        return this.zzyr;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String getSpecificString() {
        AppMethodBeat.i(4999);
        String wakeLockName = getWakeLockName();
        int wakeLockType = getWakeLockType();
        String join = getCallingPackages() == null ? "" : TextUtils.join(",", getCallingPackages());
        int deviceState = getDeviceState();
        String secondaryWakeLockName = getSecondaryWakeLockName() == null ? "" : getSecondaryWakeLockName();
        String hostPackage = getHostPackage() == null ? "" : getHostPackage();
        float beginPowerPercentage = getBeginPowerPercentage();
        String codePackage = getCodePackage() == null ? "" : getCodePackage();
        String sb = new StringBuilder(String.valueOf(wakeLockName).length() + 45 + String.valueOf(join).length() + String.valueOf(secondaryWakeLockName).length() + String.valueOf(hostPackage).length() + String.valueOf(codePackage).length()).append("\t").append(wakeLockName).append("\t").append(wakeLockType).append("\t").append(join).append("\t").append(deviceState).append("\t").append(secondaryWakeLockName).append("\t").append(hostPackage).append("\t").append(beginPowerPercentage).append("\t").append(codePackage).toString();
        AppMethodBeat.o(4999);
        return sb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.zzxv;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeout() {
        return this.mTimeout;
    }

    public final String getWakeLockName() {
        return this.zzyq;
    }

    public final int getWakeLockType() {
        return this.zzyt;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final WakeLockEvent markTimeOut() {
        if (this.mTimeout != 0) {
            this.zzyf = this.mTimeout;
        }
        if (7 == this.zzxw) {
            this.zzxw = 9;
        } else if (10 == this.zzxw) {
            this.zzxw = 12;
        }
        return this;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final StatsEvent setDurationMillis(long j2) {
        this.zzyf = j2;
        return this;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final StatsEvent setEventType(int i2) {
        this.zzxw = i2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4998);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, getWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 5, getWakeLockType());
        SafeParcelWriter.writeStringList(parcel, 6, getCallingPackages(), false);
        SafeParcelWriter.writeLong(parcel, 8, getElapsedRealtime());
        SafeParcelWriter.writeString(parcel, 10, getSecondaryWakeLockName(), false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, getEventKey(), false);
        SafeParcelWriter.writeString(parcel, 13, getHostPackage(), false);
        SafeParcelWriter.writeInt(parcel, 14, getDeviceState());
        SafeParcelWriter.writeFloat(parcel, 15, getBeginPowerPercentage());
        SafeParcelWriter.writeLong(parcel, 16, getTimeout());
        SafeParcelWriter.writeString(parcel, 17, getCodePackage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4998);
    }
}
