package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

public final class ErrLog {

    /* access modifiers changed from: package-private */
    public static class PreventError implements Parcelable {
        public static final Parcelable.Creator<PreventError> CREATOR = new Parcelable.Creator<PreventError>() {
            /* class com.tencent.mm.sandbox.monitor.ErrLog.PreventError.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PreventError[] newArray(int i2) {
                return new PreventError[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PreventError createFromParcel(Parcel parcel) {
                AppMethodBeat.i(32589);
                PreventError preventError = new PreventError(parcel);
                AppMethodBeat.o(32589);
                return preventError;
            }
        };
        public Error NEe;
        public String processName;
        public String tag;
        public String username;

        public PreventError(String str, String str2, Error error, String str3) {
            this.username = str;
            this.tag = str2;
            this.NEe = error;
            this.processName = str3;
        }

        public String toString() {
            AppMethodBeat.i(32590);
            String str = "PreventError{username='" + this.username + '\'' + ", tag='" + this.tag + '\'' + ", err=" + this.NEe + ", processName='" + this.processName + '\'' + '}';
            AppMethodBeat.o(32590);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(32591);
            parcel.writeString(this.username);
            parcel.writeString(this.tag);
            parcel.writeParcelable(this.NEe, i2);
            parcel.writeString(this.processName);
            AppMethodBeat.o(32591);
        }

        protected PreventError(Parcel parcel) {
            AppMethodBeat.i(32592);
            this.username = parcel.readString();
            this.tag = parcel.readString();
            this.NEe = (Error) parcel.readParcelable(Error.class.getClassLoader());
            this.processName = parcel.readString();
            AppMethodBeat.o(32592);
        }

        static {
            AppMethodBeat.i(32593);
            AppMethodBeat.o(32593);
        }
    }

    /* access modifiers changed from: package-private */
    public static class Error implements Parcelable {
        public static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator<Error>() {
            /* class com.tencent.mm.sandbox.monitor.ErrLog.Error.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Error[] newArray(int i2) {
                return new Error[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Error createFromParcel(Parcel parcel) {
                AppMethodBeat.i(32583);
                Error error = new Error(parcel);
                AppMethodBeat.o(32583);
                return error;
            }
        };
        public boolean NEd;
        public String msg;
        public final String platform = (d.ics + "_" + d.KyO + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public String username;

        public Error(String str, String str2, long j2, String str3, boolean z) {
            AppMethodBeat.i(32584);
            this.username = str;
            this.tag = str2;
            this.timestamp = j2;
            this.msg = str3;
            this.NEd = false;
            this.NEd = z;
            AppMethodBeat.o(32584);
        }

        public String toString() {
            AppMethodBeat.i(32585);
            String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.msg;
            AppMethodBeat.o(32585);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(32586);
            parcel.writeString(this.username);
            parcel.writeString(this.tag);
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.msg);
            parcel.writeByte(this.NEd ? (byte) 1 : 0);
            AppMethodBeat.o(32586);
        }

        protected Error(Parcel parcel) {
            AppMethodBeat.i(32587);
            this.username = parcel.readString();
            this.tag = parcel.readString();
            this.timestamp = parcel.readLong();
            this.msg = parcel.readString();
            this.NEd = parcel.readByte() != 0;
            AppMethodBeat.o(32587);
        }

        static {
            AppMethodBeat.i(32588);
            AppMethodBeat.o(32588);
        }
    }
}
