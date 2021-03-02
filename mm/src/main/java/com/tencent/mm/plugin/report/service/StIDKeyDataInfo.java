package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class StIDKeyDataInfo implements Parcelable {
    public static final Parcelable.Creator<StIDKeyDataInfo> CREATOR = new Parcelable.Creator<StIDKeyDataInfo>() {
        /* class com.tencent.mm.plugin.report.service.StIDKeyDataInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StIDKeyDataInfo[] newArray(int i2) {
            return new StIDKeyDataInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StIDKeyDataInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(143927);
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo(parcel);
            AppMethodBeat.o(143927);
            return stIDKeyDataInfo;
        }
    };
    public boolean CxY;
    public long key;
    public long oIi;
    public long value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(143928);
        parcel.writeLong(this.oIi);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
        parcel.writeInt(this.CxY ? 1 : 0);
        AppMethodBeat.o(143928);
    }

    public StIDKeyDataInfo() {
    }

    protected StIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(143929);
        this.oIi = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
        this.CxY = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(143929);
    }

    static {
        AppMethodBeat.i(143930);
        AppMethodBeat.o(143930);
    }
}
