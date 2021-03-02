package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int API_VERSION_UPDATE_REQUIRED = 21;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new ConnectionResultCreator();
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNFINISHED = 99;
    public static final int UNKNOWN = -1;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getErrorCode", id = 2)
    private final int zzam;
    @SafeParcelable.Field(getter = "getResolution", id = 3)
    private final PendingIntent zzan;
    @SafeParcelable.Field(getter = "getErrorMessage", id = 4)
    private final String zzao;

    static {
        AppMethodBeat.i(4370);
        AppMethodBeat.o(4370);
    }

    public ConnectionResult(int i2) {
        this(i2, null, null);
    }

    @SafeParcelable.Constructor
    ConnectionResult(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) String str) {
        this.zzal = i2;
        this.zzam = i3;
        this.zzan = pendingIntent;
        this.zzao = str;
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }

    static String zza(int i2) {
        AppMethodBeat.i(4365);
        switch (i2) {
            case -1:
                AppMethodBeat.o(4365);
                return "UNKNOWN";
            case 0:
                AppMethodBeat.o(4365);
                return "SUCCESS";
            case 1:
                AppMethodBeat.o(4365);
                return "SERVICE_MISSING";
            case 2:
                AppMethodBeat.o(4365);
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                AppMethodBeat.o(4365);
                return "SERVICE_DISABLED";
            case 4:
                AppMethodBeat.o(4365);
                return "SIGN_IN_REQUIRED";
            case 5:
                AppMethodBeat.o(4365);
                return "INVALID_ACCOUNT";
            case 6:
                AppMethodBeat.o(4365);
                return "RESOLUTION_REQUIRED";
            case 7:
                AppMethodBeat.o(4365);
                return "NETWORK_ERROR";
            case 8:
                AppMethodBeat.o(4365);
                return "INTERNAL_ERROR";
            case 9:
                AppMethodBeat.o(4365);
                return "SERVICE_INVALID";
            case 10:
                AppMethodBeat.o(4365);
                return "DEVELOPER_ERROR";
            case 11:
                AppMethodBeat.o(4365);
                return "LICENSE_CHECK_FAILED";
            case 13:
                AppMethodBeat.o(4365);
                return "CANCELED";
            case 14:
                AppMethodBeat.o(4365);
                return InstanceID.ERROR_TIMEOUT;
            case 15:
                AppMethodBeat.o(4365);
                return "INTERRUPTED";
            case 16:
                AppMethodBeat.o(4365);
                return "API_UNAVAILABLE";
            case 17:
                AppMethodBeat.o(4365);
                return "SIGN_IN_FAILED";
            case 18:
                AppMethodBeat.o(4365);
                return "SERVICE_UPDATING";
            case 19:
                AppMethodBeat.o(4365);
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                AppMethodBeat.o(4365);
                return "RESTRICTED_PROFILE";
            case 21:
                AppMethodBeat.o(4365);
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                AppMethodBeat.o(4365);
                return "UNFINISHED";
            case 1500:
                AppMethodBeat.o(4365);
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                String sb = new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(i2).append(")").toString();
                AppMethodBeat.o(4365);
                return sb;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4366);
        if (obj == this) {
            AppMethodBeat.o(4366);
            return true;
        } else if (!(obj instanceof ConnectionResult)) {
            AppMethodBeat.o(4366);
            return false;
        } else {
            ConnectionResult connectionResult = (ConnectionResult) obj;
            if (this.zzam != connectionResult.zzam || !Objects.equal(this.zzan, connectionResult.zzan) || !Objects.equal(this.zzao, connectionResult.zzao)) {
                AppMethodBeat.o(4366);
                return false;
            }
            AppMethodBeat.o(4366);
            return true;
        }
    }

    public final int getErrorCode() {
        return this.zzam;
    }

    public final String getErrorMessage() {
        return this.zzao;
    }

    public final PendingIntent getResolution() {
        return this.zzan;
    }

    public final boolean hasResolution() {
        return (this.zzam == 0 || this.zzan == null) ? false : true;
    }

    public final int hashCode() {
        AppMethodBeat.i(4367);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzam), this.zzan, this.zzao);
        AppMethodBeat.o(4367);
        return hashCode;
    }

    public final boolean isSuccess() {
        return this.zzam == 0;
    }

    public final void startResolutionForResult(Activity activity, int i2) {
        AppMethodBeat.i(4364);
        if (!hasResolution()) {
            AppMethodBeat.o(4364);
            return;
        }
        activity.startIntentSenderForResult(this.zzan.getIntentSender(), i2, null, 0, 0, 0);
        AppMethodBeat.o(4364);
    }

    public final String toString() {
        AppMethodBeat.i(4368);
        String toStringHelper = Objects.toStringHelper(this).add("statusCode", zza(this.zzam)).add("resolution", this.zzan).add("message", this.zzao).toString();
        AppMethodBeat.o(4368);
        return toStringHelper;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4369);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i2, false);
        SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4369);
    }
}
