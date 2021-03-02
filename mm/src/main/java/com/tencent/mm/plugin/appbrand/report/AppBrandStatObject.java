package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject implements Parcelable {
    public static final Parcelable.Creator<AppBrandStatObject> CREATOR = new Parcelable.Creator<AppBrandStatObject>() {
        /* class com.tencent.mm.plugin.appbrand.report.AppBrandStatObject.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandStatObject[] newArray(int i2) {
            return new AppBrandStatObject[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandStatObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(123532);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject(parcel);
            AppMethodBeat.o(123532);
            return appBrandStatObject;
        }
    };
    public String dCw;
    public int ecS;
    public int ecU;
    public String ecV;
    public String meP;
    public int nHt;
    public String nHu;
    public AppBrandRecommendStatObj nHv;
    public Bundle nHw;
    public int scene;

    public AppBrandStatObject() {
    }

    public final String toString() {
        AppMethodBeat.i(123533);
        String str = "AppBrandStatObject{preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", usedState=" + this.nHt + '}';
        AppMethodBeat.o(123533);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(123534);
        parcel.writeInt(this.ecU);
        parcel.writeString(this.ecV);
        parcel.writeInt(this.scene);
        parcel.writeString(this.dCw);
        parcel.writeInt(this.nHt);
        parcel.writeInt(this.ecS);
        parcel.writeString(this.meP);
        parcel.writeParcelable(this.nHv, i2);
        parcel.writeString(this.nHu);
        parcel.writeBundle(this.nHw);
        AppMethodBeat.o(123534);
    }

    protected AppBrandStatObject(Parcel parcel) {
        AppMethodBeat.i(123535);
        this.ecU = parcel.readInt();
        this.ecV = parcel.readString();
        this.scene = parcel.readInt();
        this.dCw = parcel.readString();
        this.nHt = parcel.readInt();
        this.ecS = parcel.readInt();
        this.meP = parcel.readString();
        this.nHv = (AppBrandRecommendStatObj) parcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader());
        this.nHu = parcel.readString();
        this.nHw = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(123535);
    }

    static {
        AppMethodBeat.i(123536);
        AppMethodBeat.o(123536);
    }
}
