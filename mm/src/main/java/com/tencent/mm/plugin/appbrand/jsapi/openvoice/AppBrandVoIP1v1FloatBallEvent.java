package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent implements Parcelable {
    public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR = new Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandVoIP1v1FloatBallEvent[] newArray(int i2) {
            return new AppBrandVoIP1v1FloatBallEvent[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandVoIP1v1FloatBallEvent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(226917);
            AppBrandVoIP1v1FloatBallEvent appBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent(parcel);
            AppMethodBeat.o(226917);
            return appBrandVoIP1v1FloatBallEvent;
        }
    };
    public int dRq = 0;

    public AppBrandVoIP1v1FloatBallEvent() {
    }

    public AppBrandVoIP1v1FloatBallEvent(Parcel parcel) {
        AppMethodBeat.i(226918);
        this.dRq = parcel.readInt();
        AppMethodBeat.o(226918);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(226919);
        parcel.writeInt(this.dRq);
        AppMethodBeat.o(226919);
    }

    static {
        AppMethodBeat.i(226920);
        AppMethodBeat.o(226920);
    }
}
