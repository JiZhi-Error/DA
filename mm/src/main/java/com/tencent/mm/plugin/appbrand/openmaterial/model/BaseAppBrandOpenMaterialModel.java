package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class BaseAppBrandOpenMaterialModel implements Parcelable {
    public static final Parcelable.Creator<BaseAppBrandOpenMaterialModel> CREATOR = new Parcelable.Creator<BaseAppBrandOpenMaterialModel>() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BaseAppBrandOpenMaterialModel[] newArray(int i2) {
            return new BaseAppBrandOpenMaterialModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BaseAppBrandOpenMaterialModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194366);
            BaseAppBrandOpenMaterialModel baseAppBrandOpenMaterialModel = new BaseAppBrandOpenMaterialModel(parcel);
            AppMethodBeat.o(194366);
            return baseAppBrandOpenMaterialModel;
        }
    };
    public final String appId;
    public final int iOo;
    public final String kHw;

    public BaseAppBrandOpenMaterialModel(String str, int i2, String str2) {
        String str3;
        AppMethodBeat.i(194367);
        this.appId = str;
        this.iOo = i2;
        if (!Util.isNullOrNil(str2)) {
            String dM = l.dM(str2);
            if (!dM.endsWith(".html")) {
                str3 = str2.replace(dM, dM + ".html");
                Log.i("MicroMsg.AppBrand.BaseAppBrandOpenMaterialModel", "fixPath, path: %s, fixedPath: %s", str2, str3);
                this.kHw = str3;
                AppMethodBeat.o(194367);
            }
        }
        str3 = str2;
        Log.i("MicroMsg.AppBrand.BaseAppBrandOpenMaterialModel", "fixPath, path: %s, fixedPath: %s", str2, str3);
        this.kHw = str3;
        AppMethodBeat.o(194367);
    }

    public String toString() {
        AppMethodBeat.i(194368);
        String str = "BaseAppBrandOpenMaterialModel{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
        AppMethodBeat.o(194368);
        return str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(194369);
        if (this == obj) {
            AppMethodBeat.o(194369);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(194369);
            return false;
        } else {
            BaseAppBrandOpenMaterialModel baseAppBrandOpenMaterialModel = (BaseAppBrandOpenMaterialModel) obj;
            if (this.iOo != baseAppBrandOpenMaterialModel.iOo || !this.appId.equals(baseAppBrandOpenMaterialModel.appId) || !this.kHw.equals(baseAppBrandOpenMaterialModel.kHw)) {
                AppMethodBeat.o(194369);
                return false;
            }
            AppMethodBeat.o(194369);
            return true;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(194370);
        int hash = Objects.hash(this.appId, Integer.valueOf(this.iOo), this.kHw);
        AppMethodBeat.o(194370);
        return hash;
    }

    protected BaseAppBrandOpenMaterialModel(Parcel parcel) {
        AppMethodBeat.i(194371);
        this.appId = Util.nullAs(parcel.readString(), "");
        this.iOo = parcel.readInt();
        this.kHw = Util.nullAs(parcel.readString(), "");
        AppMethodBeat.o(194371);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194372);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
        parcel.writeString(this.kHw);
        AppMethodBeat.o(194372);
    }

    static {
        AppMethodBeat.i(194373);
        AppMethodBeat.o(194373);
    }
}
