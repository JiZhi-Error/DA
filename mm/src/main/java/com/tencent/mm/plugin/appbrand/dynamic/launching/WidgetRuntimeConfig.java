package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetRuntimeConfig implements Parcelable {
    public static final Parcelable.Creator<WidgetRuntimeConfig> CREATOR = new Parcelable.Creator<WidgetRuntimeConfig>() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WidgetRuntimeConfig[] newArray(int i2) {
            return new WidgetRuntimeConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WidgetRuntimeConfig createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(121410);
            WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
            widgetRuntimeConfig.appId = parcel.readString();
            widgetRuntimeConfig.loG = parcel.readInt();
            widgetRuntimeConfig.loX = parcel.readInt();
            widgetRuntimeConfig.loY = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            widgetRuntimeConfig.loZ = z;
            AppMethodBeat.o(121410);
            return widgetRuntimeConfig;
        }
    };
    public String appId;
    public int loG;
    public int loX = 32;
    public boolean loY = false;
    public boolean loZ = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(121411);
        parcel.writeString(this.appId);
        parcel.writeInt(this.loG);
        parcel.writeInt(this.loX);
        if (this.loY) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.loZ) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        AppMethodBeat.o(121411);
    }

    static {
        AppMethodBeat.i(121412);
        AppMethodBeat.o(121412);
    }
}
