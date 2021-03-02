package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WidgetSysConfig implements Parcelable {
    public static final Parcelable.Creator<WidgetSysConfig> CREATOR = new Parcelable.Creator<WidgetSysConfig>() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WidgetSysConfig[] newArray(int i2) {
            return new WidgetSysConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WidgetSysConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121413);
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.lcY = parcel.readInt();
            widgetSysConfig.lcZ = parcel.readInt();
            widgetSysConfig.lda = parcel.readInt();
            AppMethodBeat.o(121413);
            return widgetSysConfig;
        }
    };
    public int lcY;
    public int lcZ;
    public int lda;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(121414);
        parcel.writeInt(this.lcY);
        parcel.writeInt(this.lcZ);
        parcel.writeInt(this.lda);
        AppMethodBeat.o(121414);
    }

    static {
        AppMethodBeat.i(121415);
        AppMethodBeat.o(121415);
    }
}
