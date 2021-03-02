package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCVoid implements Parcelable {
    public static final Parcelable.Creator<IPCVoid> CREATOR = new Parcelable.Creator<IPCVoid>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCVoid.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCVoid[] newArray(int i2) {
            return new IPCVoid[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCVoid createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158875);
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(158875);
            return iPCVoid;
        }
    };
    public static final IPCVoid hnE = new IPCVoid();

    static {
        AppMethodBeat.i(158876);
        AppMethodBeat.o(158876);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }
}
