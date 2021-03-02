package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class AppBrandOpenMaterialModel extends BaseAppBrandOpenMaterialModel implements Parcelable {
    public static final Parcelable.Creator<AppBrandOpenMaterialModel> CREATOR = new Parcelable.Creator<AppBrandOpenMaterialModel>() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandOpenMaterialModel[] newArray(int i2) {
            return new AppBrandOpenMaterialModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandOpenMaterialModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194356);
            AppBrandOpenMaterialModel appBrandOpenMaterialModel = new AppBrandOpenMaterialModel(parcel);
            AppMethodBeat.o(194356);
            return appBrandOpenMaterialModel;
        }
    };
    public String appName;
    public final String iconUrl;
    public final String nlH;

    public AppBrandOpenMaterialModel(String str, int i2, String str2, String str3, String str4) {
        super(str, i2, str2);
        this.iconUrl = str3;
        this.nlH = str4;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public String toString() {
        AppMethodBeat.i(194357);
        String str = "AppBrandOpenMaterialModel{iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.nlH + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
        AppMethodBeat.o(194357);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public boolean equals(Object obj) {
        AppMethodBeat.i(194358);
        if (this == obj) {
            AppMethodBeat.o(194358);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(194358);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(194358);
            return false;
        } else {
            AppBrandOpenMaterialModel appBrandOpenMaterialModel = (AppBrandOpenMaterialModel) obj;
            if (!Objects.equals(this.iconUrl, appBrandOpenMaterialModel.iconUrl) || !this.nlH.equals(appBrandOpenMaterialModel.nlH) || !Objects.equals(this.appName, appBrandOpenMaterialModel.appName)) {
                AppMethodBeat.o(194358);
                return false;
            }
            AppMethodBeat.o(194358);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public int hashCode() {
        AppMethodBeat.i(194359);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.iconUrl, this.nlH, this.appName);
        AppMethodBeat.o(194359);
        return hash;
    }

    protected AppBrandOpenMaterialModel(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(194360);
        this.iconUrl = parcel.readString();
        this.nlH = Util.nullAs(parcel.readString(), "");
        this.appName = parcel.readString();
        AppMethodBeat.o(194360);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194361);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.nlH);
        parcel.writeString(this.appName);
        AppMethodBeat.o(194361);
    }

    static {
        AppMethodBeat.i(194362);
        AppMethodBeat.o(194362);
    }
}
