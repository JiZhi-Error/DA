package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PeriodicTask extends Task {
    public static final Parcelable.Creator<PeriodicTask> CREATOR = new zzk();
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    public static class Builder extends Task.Builder {
        private long zzam = -1;
        private long zzan = -1;

        public Builder() {
            this.isPersisted = true;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public PeriodicTask build() {
            AppMethodBeat.i(3674);
            checkConditions();
            PeriodicTask periodicTask = new PeriodicTask(this, (zzk) null);
            AppMethodBeat.o(3674);
            return periodicTask;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.gcm.Task.Builder
        public void checkConditions() {
            AppMethodBeat.i(3675);
            super.checkConditions();
            if (this.zzam == -1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
                AppMethodBeat.o(3675);
                throw illegalArgumentException;
            } else if (this.zzam <= 0) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(66).append("Period set cannot be less than or equal to 0: ").append(this.zzam).toString());
                AppMethodBeat.o(3675);
                throw illegalArgumentException2;
            } else if (this.zzan == -1) {
                this.zzan = (long) (((float) this.zzam) * 0.1f);
                AppMethodBeat.o(3675);
            } else {
                if (this.zzan > this.zzam) {
                    this.zzan = this.zzam;
                }
                AppMethodBeat.o(3675);
            }
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFlex(long j2) {
            this.zzan = j2;
            return this;
        }

        public Builder setPeriod(long j2) {
            this.zzam = j2;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setRequiredNetwork(int i2) {
            this.requiredNetworkState = i2;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setService(Class<? extends GcmTaskService> cls) {
            AppMethodBeat.i(3673);
            this.gcmTaskService = cls.getName();
            AppMethodBeat.o(3673);
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    static {
        AppMethodBeat.i(3689);
        AppMethodBeat.o(3689);
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(3685);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = parcel.readLong();
        this.mFlexInSeconds = Math.min(parcel.readLong(), this.mIntervalInSeconds);
        AppMethodBeat.o(3685);
    }

    /* synthetic */ PeriodicTask(Parcel parcel, zzk zzk) {
        this(parcel);
    }

    private PeriodicTask(Builder builder) {
        super(builder);
        AppMethodBeat.i(3684);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzam;
        this.mFlexInSeconds = Math.min(builder.zzan, this.mIntervalInSeconds);
        AppMethodBeat.o(3684);
    }

    /* synthetic */ PeriodicTask(Builder builder, zzk zzk) {
        this(builder);
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    @Override // com.google.android.gms.gcm.Task
    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(3686);
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
        AppMethodBeat.o(3686);
    }

    public String toString() {
        AppMethodBeat.i(3688);
        String obj = super.toString();
        long period = getPeriod();
        String sb = new StringBuilder(String.valueOf(obj).length() + 54).append(obj).append(" period=").append(period).append(" flex=").append(getFlex()).toString();
        AppMethodBeat.o(3688);
        return sb;
    }

    @Override // com.google.android.gms.gcm.Task
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(3687);
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
        AppMethodBeat.o(3687);
    }
}
