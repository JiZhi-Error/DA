package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel implements Parcelable {
    public static final Parcelable.Creator<SwitchAccountModel> CREATOR = new Parcelable.Creator<SwitchAccountModel>() {
        /* class com.tencent.mm.plugin.setting.model.SwitchAccountModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SwitchAccountModel[] newArray(int i2) {
            return new SwitchAccountModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SwitchAccountModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73784);
            SwitchAccountModel switchAccountModel = new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
            AppMethodBeat.o(73784);
            return switchAccountModel;
        }
    };
    public final String CXS;
    public final String CXT;
    public final int CXU;
    public final String tjJ;
    public final String username;

    static {
        AppMethodBeat.i(73786);
        AppMethodBeat.o(73786);
    }

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i2) {
        this.CXS = str;
        this.username = str2;
        this.tjJ = str3;
        this.CXT = str4;
        this.CXU = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(73785);
        parcel.writeString(this.CXS);
        parcel.writeString(this.username);
        parcel.writeString(this.tjJ);
        parcel.writeString(this.CXT);
        parcel.writeInt(this.CXU);
        AppMethodBeat.o(73785);
    }
}
