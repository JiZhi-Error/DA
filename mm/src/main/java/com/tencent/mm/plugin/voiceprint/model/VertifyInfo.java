package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class VertifyInfo implements Parcelable {
    public static final Parcelable.Creator<VertifyInfo> CREATOR = new Parcelable.Creator<VertifyInfo>() {
        /* class com.tencent.mm.plugin.voiceprint.model.VertifyInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VertifyInfo[] newArray(int i2) {
            return new VertifyInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VertifyInfo createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(29789);
            VertifyInfo vertifyInfo = new VertifyInfo();
            vertifyInfo.GRa = parcel.readInt();
            vertifyInfo.GRb = parcel.readInt();
            vertifyInfo.GRc = parcel.readInt();
            vertifyInfo.DsN = parcel.readInt();
            vertifyInfo.mText = parcel.readString();
            vertifyInfo.GQO = parcel.readString();
            vertifyInfo.mFileName = parcel.readString();
            vertifyInfo.GRd = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            vertifyInfo.sXX = z;
            vertifyInfo.DsN = vertifyInfo.GRa;
            AppMethodBeat.o(29789);
            return vertifyInfo;
        }
    };
    public int DsN = 0;
    public String GQO = "";
    public int GRa;
    public int GRb;
    public int GRc = 0;
    public boolean GRd = false;
    public String kly = "";
    public String mFileName = "";
    public String mText = "";
    public boolean sXX = false;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(29790);
        parcel.writeInt(this.GRa);
        parcel.writeInt(this.GRb);
        parcel.writeInt(this.GRc);
        parcel.writeInt(this.DsN);
        parcel.writeString(Util.nullAs(this.mText, ""));
        parcel.writeString(Util.nullAs(this.GQO, ""));
        parcel.writeString(Util.nullAs(this.mFileName, ""));
        if (this.GRd) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.sXX) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        AppMethodBeat.o(29790);
    }

    static {
        AppMethodBeat.i(29791);
        AppMethodBeat.o(29791);
    }
}
