package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AppBrandOpenMaterialDetailModel extends AppBrandOpenMaterialModel implements Parcelable {
    public static final Parcelable.Creator<AppBrandOpenMaterialDetailModel> CREATOR = new Parcelable.Creator<AppBrandOpenMaterialDetailModel>() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandOpenMaterialDetailModel[] newArray(int i2) {
            return new AppBrandOpenMaterialDetailModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandOpenMaterialDetailModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194349);
            AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = new AppBrandOpenMaterialDetailModel(parcel);
            AppMethodBeat.o(194349);
            return appBrandOpenMaterialDetailModel;
        }
    };
    public final List<String> lgE;
    public final String nlG;
    public final float score;

    public AppBrandOpenMaterialDetailModel(String str, int i2, String str2, String str3, String str4, List<String> list, float f2, String str5) {
        super(str, i2, str2, str3, str4);
        this.lgE = list;
        this.score = f2;
        this.nlG = str5;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public String toString() {
        AppMethodBeat.i(194350);
        String str = "AppBrandOpenMaterialDetailModel{categories='" + Arrays.toString(this.lgE.toArray()) + '\'' + ", score=" + this.score + ", functionDesc='" + this.nlG + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.nlH + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
        AppMethodBeat.o(194350);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public boolean equals(Object obj) {
        AppMethodBeat.i(194351);
        if (this == obj) {
            AppMethodBeat.o(194351);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(194351);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(194351);
            return false;
        } else {
            AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = (AppBrandOpenMaterialDetailModel) obj;
            if (Float.compare(appBrandOpenMaterialDetailModel.score, this.score) != 0 || !this.lgE.equals(appBrandOpenMaterialDetailModel.lgE) || !this.nlG.equals(appBrandOpenMaterialDetailModel.nlG)) {
                AppMethodBeat.o(194351);
                return false;
            }
            AppMethodBeat.o(194351);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public int hashCode() {
        AppMethodBeat.i(194352);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.lgE, Float.valueOf(this.score), this.nlG);
        AppMethodBeat.o(194352);
        return hash;
    }

    protected AppBrandOpenMaterialDetailModel(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(194353);
        ArrayList arrayList = new ArrayList();
        this.lgE = arrayList;
        parcel.readStringList(arrayList);
        this.score = parcel.readFloat();
        this.nlG = Util.nullAs(parcel.readString(), "");
        AppMethodBeat.o(194353);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194354);
        super.writeToParcel(parcel, i2);
        parcel.writeStringList(this.lgE);
        parcel.writeFloat(this.score);
        parcel.writeString(this.nlG);
        AppMethodBeat.o(194354);
    }

    static {
        AppMethodBeat.i(194355);
        AppMethodBeat.o(194355);
    }
}
