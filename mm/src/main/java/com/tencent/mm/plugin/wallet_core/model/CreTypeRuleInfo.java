package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreTypeRuleInfo implements Parcelable {
    public static final Parcelable.Creator<CreTypeRuleInfo> CREATOR = new Parcelable.Creator<CreTypeRuleInfo>() {
        /* class com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CreTypeRuleInfo[] newArray(int i2) {
            return new CreTypeRuleInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CreTypeRuleInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70251);
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo(parcel);
            AppMethodBeat.o(70251);
            return creTypeRuleInfo;
        }
    };
    public int HWK;
    public CreExtInfo HWL;

    public CreTypeRuleInfo() {
    }

    protected CreTypeRuleInfo(Parcel parcel) {
        AppMethodBeat.i(70252);
        this.HWK = parcel.readInt();
        this.HWL = (CreExtInfo) parcel.readParcelable(CreExtInfo.class.getClassLoader());
        AppMethodBeat.o(70252);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70253);
        parcel.writeInt(this.HWK);
        parcel.writeParcelable(this.HWL, i2);
        AppMethodBeat.o(70253);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(70255);
        AppMethodBeat.o(70255);
    }

    public static CreTypeRuleInfo bE(JSONObject jSONObject) {
        AppMethodBeat.i(70254);
        if (jSONObject != null) {
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo();
            creTypeRuleInfo.HWK = jSONObject.optInt("support_cre_type", 0);
            creTypeRuleInfo.HWL = CreExtInfo.bD(jSONObject.optJSONObject("cre_need_info"));
            AppMethodBeat.o(70254);
            return creTypeRuleInfo;
        }
        AppMethodBeat.o(70254);
        return null;
    }
}
