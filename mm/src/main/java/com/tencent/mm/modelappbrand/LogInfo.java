package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogInfo implements Parcelable {
    public static final Parcelable.Creator<LogInfo> CREATOR = new Parcelable.Creator<LogInfo>() {
        /* class com.tencent.mm.modelappbrand.LogInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LogInfo[] newArray(int i2) {
            return new LogInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LogInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(76375);
            LogInfo logInfo = new LogInfo();
            logInfo.ts = parcel.readLong();
            logInfo.level = parcel.readInt();
            logInfo.message = parcel.readString();
            AppMethodBeat.o(76375);
            return logInfo;
        }
    };
    public int level;
    public String message;
    public long ts;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(76376);
        parcel.writeLong(this.ts);
        parcel.writeInt(this.level);
        parcel.writeString(this.message);
        AppMethodBeat.o(76376);
    }

    static {
        AppMethodBeat.i(76377);
        AppMethodBeat.o(76377);
    }
}
