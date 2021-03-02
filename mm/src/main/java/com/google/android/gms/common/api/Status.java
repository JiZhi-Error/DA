package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zze();
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @VisibleForTesting
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    private static final Status zzdq = new Status(17);
    @SafeParcelable.VersionField(id = 1000)
    private final int zzal;
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int zzam;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent zzan;
    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    private final String zzao;

    static {
        AppMethodBeat.i(4480);
        AppMethodBeat.o(4480);
    }

    @KeepForSdk
    public Status(int i2) {
        this(i2, null);
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    Status(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) int i3, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.zzal = i2;
        this.zzam = i3;
        this.zzao = str;
        this.zzan = pendingIntent;
    }

    @KeepForSdk
    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    @KeepForSdk
    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4476);
        if (!(obj instanceof Status)) {
            AppMethodBeat.o(4476);
            return false;
        }
        Status status = (Status) obj;
        if (this.zzal != status.zzal || this.zzam != status.zzam || !Objects.equal(this.zzao, status.zzao) || !Objects.equal(this.zzan, status.zzan)) {
            AppMethodBeat.o(4476);
            return false;
        }
        AppMethodBeat.o(4476);
        return true;
    }

    public final PendingIntent getResolution() {
        return this.zzan;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    public final String getStatusMessage() {
        return this.zzao;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.zzan != null;
    }

    public final int hashCode() {
        AppMethodBeat.i(4475);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzal), Integer.valueOf(this.zzam), this.zzao, this.zzan);
        AppMethodBeat.o(4475);
        return hashCode;
    }

    public final boolean isCanceled() {
        return this.zzam == 16;
    }

    public final boolean isInterrupted() {
        return this.zzam == 14;
    }

    public final boolean isSuccess() {
        return this.zzam <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i2) {
        AppMethodBeat.i(4474);
        if (!hasResolution()) {
            AppMethodBeat.o(4474);
            return;
        }
        activity.startIntentSenderForResult(this.zzan.getIntentSender(), i2, null, 0, 0, 0);
        AppMethodBeat.o(4474);
    }

    public final String toString() {
        AppMethodBeat.i(4478);
        String toStringHelper = Objects.toStringHelper(this).add("statusCode", zzp()).add("resolution", this.zzan).toString();
        AppMethodBeat.o(4478);
        return toStringHelper;
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4479);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzan, i2, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4479);
    }

    public final String zzp() {
        AppMethodBeat.i(4477);
        if (this.zzao != null) {
            String str = this.zzao;
            AppMethodBeat.o(4477);
            return str;
        }
        String statusCodeString = CommonStatusCodes.getStatusCodeString(this.zzam);
        AppMethodBeat.o(4477);
        return statusCodeString;
    }
}
