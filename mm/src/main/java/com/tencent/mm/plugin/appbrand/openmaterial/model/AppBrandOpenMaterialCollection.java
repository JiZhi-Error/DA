package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppBrandOpenMaterialCollection implements Parcelable {
    public static final Parcelable.Creator<AppBrandOpenMaterialCollection> CREATOR = new Parcelable.Creator<AppBrandOpenMaterialCollection>() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandOpenMaterialCollection[] newArray(int i2) {
            return new AppBrandOpenMaterialCollection[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandOpenMaterialCollection createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194342);
            AppBrandOpenMaterialCollection appBrandOpenMaterialCollection = new AppBrandOpenMaterialCollection(parcel);
            AppMethodBeat.o(194342);
            return appBrandOpenMaterialCollection;
        }
    };
    public final MaterialModel nlD;
    public final List<AppBrandOpenMaterialModel> nlE;
    public final List<AppBrandOpenMaterialDetailModel> nlF;

    public static AppBrandOpenMaterialCollection j(MaterialModel materialModel) {
        AppMethodBeat.i(194343);
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection = new AppBrandOpenMaterialCollection(materialModel, Collections.emptyList(), Collections.emptyList());
        AppMethodBeat.o(194343);
        return appBrandOpenMaterialCollection;
    }

    public AppBrandOpenMaterialCollection(MaterialModel materialModel, List<AppBrandOpenMaterialModel> list, List<AppBrandOpenMaterialDetailModel> list2) {
        AppMethodBeat.i(194344);
        this.nlD = materialModel;
        this.nlE = new ArrayList(list);
        this.nlF = new ArrayList(list2);
        AppMethodBeat.o(194344);
    }

    public String toString() {
        AppMethodBeat.i(194345);
        String str = "AppBrandOpenMaterialCollection{materialModel=" + this.nlD + ", appBrandOpenMaterialModels=" + Arrays.toString(this.nlE.toArray()) + ", appBrandOpenMaterialDetailModels=" + Arrays.toString(this.nlF.toArray()) + '}';
        AppMethodBeat.o(194345);
        return str;
    }

    protected AppBrandOpenMaterialCollection(Parcel parcel) {
        AppMethodBeat.i(194346);
        MaterialModel materialModel = (MaterialModel) parcel.readParcelable(MaterialModel.class.getClassLoader());
        this.nlD = materialModel == null ? MaterialModel.bQg() : materialModel;
        List<AppBrandOpenMaterialModel> createTypedArrayList = parcel.createTypedArrayList(AppBrandOpenMaterialModel.CREATOR);
        this.nlE = createTypedArrayList == null ? Collections.emptyList() : createTypedArrayList;
        List<AppBrandOpenMaterialDetailModel> createTypedArrayList2 = parcel.createTypedArrayList(AppBrandOpenMaterialDetailModel.CREATOR);
        this.nlF = createTypedArrayList2 == null ? Collections.emptyList() : createTypedArrayList2;
        AppMethodBeat.o(194346);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194347);
        parcel.writeParcelable(this.nlD, i2);
        parcel.writeTypedList(this.nlE);
        parcel.writeTypedList(this.nlF);
        AppMethodBeat.o(194347);
    }

    static {
        AppMethodBeat.i(194348);
        AppMethodBeat.o(194348);
    }
}
