package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj implements Parcelable {
    public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR = new Parcelable.Creator<AppBrandRecommendStatObj>() {
        /* class com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandRecommendStatObj[] newArray(int i2) {
            return new AppBrandRecommendStatObj[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandRecommendStatObj createFromParcel(Parcel parcel) {
            AppMethodBeat.i(123527);
            AppBrandRecommendStatObj appBrandRecommendStatObj = new AppBrandRecommendStatObj(parcel);
            AppMethodBeat.o(123527);
            return appBrandRecommendStatObj;
        }
    };
    public String dNI;
    public float dTj;
    public float latitude;
    public String nHd;
    public String nHe;
    public String nHf;
    public String nHg;
    public int nHh;
    public String nHi;
    public int position;
    public long sessionId;
    public String username;

    public AppBrandRecommendStatObj() {
    }

    public AppBrandRecommendStatObj(Parcel parcel) {
        AppMethodBeat.i(123528);
        this.username = parcel.readString();
        this.nHd = parcel.readString();
        this.nHe = parcel.readString();
        this.dNI = parcel.readString();
        this.nHf = parcel.readString();
        this.nHg = parcel.readString();
        this.nHh = parcel.readInt();
        this.nHi = parcel.readString();
        this.position = parcel.readInt();
        this.dTj = parcel.readFloat();
        this.latitude = parcel.readFloat();
        this.sessionId = parcel.readLong();
        AppMethodBeat.o(123528);
    }

    public String toString() {
        AppMethodBeat.i(123529);
        String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.nHd + '\'' + ", strategy_info=" + this.nHe + ", appid='" + this.dNI + '\'' + ", page_path=" + this.nHf + ", page_param=" + this.nHg + ", card_type=" + this.nHh + ", pass_str=" + this.nHi + ", position=" + this.position + ", longitude=" + this.dTj + ", latitude=" + this.latitude + ", sessionId=" + this.sessionId + '}';
        AppMethodBeat.o(123529);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(123530);
        parcel.writeString(this.username);
        parcel.writeString(this.nHd);
        parcel.writeString(this.nHe);
        parcel.writeString(this.dNI);
        parcel.writeString(this.nHf);
        parcel.writeString(this.nHg);
        parcel.writeInt(this.nHh);
        parcel.writeString(this.nHi);
        parcel.writeInt(this.position);
        parcel.writeFloat(this.dTj);
        parcel.writeFloat(this.latitude);
        parcel.writeLong(this.sessionId);
        AppMethodBeat.o(123530);
    }

    static {
        AppMethodBeat.i(123531);
        AppMethodBeat.o(123531);
    }
}
