package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OneoffTask extends Task {
    public static final Parcelable.Creator<OneoffTask> CREATOR = new zzi();
    private final long zzaj;
    private final long zzak;

    public static class Builder extends Task.Builder {
        private long zzaj = -1;
        private long zzak = -1;

        public Builder() {
            this.isPersisted = false;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public OneoffTask build() {
            AppMethodBeat.i(3655);
            checkConditions();
            OneoffTask oneoffTask = new OneoffTask(this, (zzi) null);
            AppMethodBeat.o(3655);
            return oneoffTask;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.gcm.Task.Builder
        public void checkConditions() {
            AppMethodBeat.i(3654);
            super.checkConditions();
            if (this.zzaj == -1 || this.zzak == -1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
                AppMethodBeat.o(3654);
                throw illegalArgumentException;
            } else if (this.zzaj >= this.zzak) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Window start must be shorter than window end.");
                AppMethodBeat.o(3654);
                throw illegalArgumentException2;
            } else {
                AppMethodBeat.o(3654);
            }
        }

        public Builder setExecutionWindow(long j2, long j3) {
            this.zzaj = j2;
            this.zzak = j3;
            return this;
        }

        @Override // com.google.android.gms.gcm.Task.Builder
        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
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
            AppMethodBeat.i(3653);
            this.gcmTaskService = cls.getName();
            AppMethodBeat.o(3653);
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
        AppMethodBeat.i(3669);
        AppMethodBeat.o(3669);
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(3665);
        this.zzaj = parcel.readLong();
        this.zzak = parcel.readLong();
        AppMethodBeat.o(3665);
    }

    /* synthetic */ OneoffTask(Parcel parcel, zzi zzi) {
        this(parcel);
    }

    private OneoffTask(Builder builder) {
        super(builder);
        AppMethodBeat.i(3664);
        this.zzaj = builder.zzaj;
        this.zzak = builder.zzak;
        AppMethodBeat.o(3664);
    }

    /* synthetic */ OneoffTask(Builder builder, zzi zzi) {
        this(builder);
    }

    public long getWindowEnd() {
        return this.zzak;
    }

    public long getWindowStart() {
        return this.zzaj;
    }

    @Override // com.google.android.gms.gcm.Task
    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(3666);
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzaj);
        bundle.putLong("window_end", this.zzak);
        AppMethodBeat.o(3666);
    }

    public String toString() {
        AppMethodBeat.i(3668);
        String obj = super.toString();
        long windowStart = getWindowStart();
        String sb = new StringBuilder(String.valueOf(obj).length() + 64).append(obj).append(" windowStart=").append(windowStart).append(" windowEnd=").append(getWindowEnd()).toString();
        AppMethodBeat.o(3668);
        return sb;
    }

    @Override // com.google.android.gms.gcm.Task
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(3667);
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.zzaj);
        parcel.writeLong(this.zzak);
        AppMethodBeat.o(3667);
    }
}
