package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreExtInfo implements Parcelable {
    public static final Parcelable.Creator<CreExtInfo> CREATOR = new Parcelable.Creator<CreExtInfo>() {
        /* class com.tencent.mm.plugin.wallet_core.model.CreExtInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CreExtInfo[] newArray(int i2) {
            return new CreExtInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CreExtInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70246);
            CreExtInfo creExtInfo = new CreExtInfo(parcel);
            AppMethodBeat.o(70246);
            return creExtInfo;
        }
    };
    public int HWG;
    public int HWH;
    public int HWI;
    public int HWJ;

    public CreExtInfo() {
    }

    protected CreExtInfo(Parcel parcel) {
        AppMethodBeat.i(70247);
        this.HWG = parcel.readInt();
        this.HWH = parcel.readInt();
        this.HWI = parcel.readInt();
        this.HWJ = parcel.readInt();
        AppMethodBeat.o(70247);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70248);
        parcel.writeInt(this.HWG);
        parcel.writeInt(this.HWH);
        parcel.writeInt(this.HWI);
        parcel.writeInt(this.HWJ);
        AppMethodBeat.o(70248);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(70250);
        AppMethodBeat.o(70250);
    }

    public static CreExtInfo bD(JSONObject jSONObject) {
        AppMethodBeat.i(70249);
        if (jSONObject != null) {
            CreExtInfo creExtInfo = new CreExtInfo();
            creExtInfo.HWG = jSONObject.optInt("need_creid_renewal", 0);
            creExtInfo.HWH = jSONObject.optInt("need_birth_date", 0);
            creExtInfo.HWI = jSONObject.optInt("need_cre_expire_date", 0);
            creExtInfo.HWJ = jSONObject.optInt("need_show_cre_type", 0);
            AppMethodBeat.o(70249);
            return creExtInfo;
        }
        AppMethodBeat.o(70249);
        return null;
    }
}
