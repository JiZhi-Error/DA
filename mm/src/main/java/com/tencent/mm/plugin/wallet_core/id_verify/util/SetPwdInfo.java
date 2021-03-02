package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo implements Parcelable {
    public static final Parcelable.Creator<SetPwdInfo> CREATOR = new Parcelable.Creator<SetPwdInfo>() {
        /* class com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetPwdInfo[] newArray(int i2) {
            return new SetPwdInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetPwdInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70201);
            SetPwdInfo setPwdInfo = new SetPwdInfo(parcel);
            AppMethodBeat.o(70201);
            return setPwdInfo;
        }
    };
    public int HUM;
    public String lHA = "";
    public String lHB = "";
    public String yXJ;

    public SetPwdInfo() {
    }

    protected SetPwdInfo(Parcel parcel) {
        AppMethodBeat.i(70202);
        this.HUM = parcel.readInt();
        this.yXJ = parcel.readString();
        this.lHA = parcel.readString();
        this.lHB = parcel.readString();
        AppMethodBeat.o(70202);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70203);
        parcel.writeInt(this.HUM);
        parcel.writeString(this.yXJ);
        parcel.writeString(this.lHA);
        parcel.writeString(this.lHB);
        AppMethodBeat.o(70203);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(70204);
        AppMethodBeat.o(70204);
    }
}
