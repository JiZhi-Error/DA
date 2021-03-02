package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EventLocationBackgroundStateChanged implements Parcelable {
    public static final Parcelable.Creator<EventLocationBackgroundStateChanged> CREATOR = new Parcelable.Creator<EventLocationBackgroundStateChanged>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EventLocationBackgroundStateChanged[] newArray(int i2) {
            return new EventLocationBackgroundStateChanged[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EventLocationBackgroundStateChanged createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134870);
            EventLocationBackgroundStateChanged eventLocationBackgroundStateChanged = new EventLocationBackgroundStateChanged(parcel);
            AppMethodBeat.o(134870);
            return eventLocationBackgroundStateChanged;
        }
    };
    public boolean kYn;

    public EventLocationBackgroundStateChanged(boolean z) {
        this.kYn = z;
    }

    protected EventLocationBackgroundStateChanged(Parcel parcel) {
        AppMethodBeat.i(134871);
        this.kYn = parcel.readByte() != 0;
        AppMethodBeat.o(134871);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134872);
        parcel.writeByte((byte) (this.kYn ? 1 : 0));
        AppMethodBeat.o(134872);
    }

    static {
        AppMethodBeat.i(134873);
        AppMethodBeat.o(134873);
    }
}
