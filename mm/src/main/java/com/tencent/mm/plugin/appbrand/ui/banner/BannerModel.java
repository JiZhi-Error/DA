package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

/* access modifiers changed from: package-private */
public final class BannerModel implements Parcelable {
    public static final Parcelable.Creator<BannerModel> CREATOR = new Parcelable.Creator<BannerModel>() {
        /* class com.tencent.mm.plugin.appbrand.ui.banner.BannerModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BannerModel[] newArray(int i2) {
            return new BannerModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BannerModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(49035);
            BannerModel bannerModel = new BannerModel(parcel, (byte) 0);
            AppMethodBeat.o(49035);
            return bannerModel;
        }
    };
    private static volatile BannerModel oay;
    String appId;
    String appName;
    int iOo;
    String kVZ;
    String oax;

    /* synthetic */ BannerModel(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(49036);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
        parcel.writeString(this.appName);
        parcel.writeString(this.kVZ);
        parcel.writeString(this.oax);
        AppMethodBeat.o(49036);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        AppMethodBeat.i(49037);
        this.appId = parcel.readString();
        this.iOo = parcel.readInt();
        this.appName = parcel.readString();
        this.kVZ = parcel.readString();
        this.oax = parcel.readString();
        AppMethodBeat.o(49037);
    }

    static {
        AppMethodBeat.i(49039);
        AppMethodBeat.o(49039);
    }

    static BannerModel bYe() {
        BannerModel bXW;
        AppMethodBeat.i(49038);
        synchronized (BannerModel.class) {
            try {
                bXW = ((e) g.af(e.class)).bXW();
                oay = bXW;
            } finally {
                AppMethodBeat.o(49038);
            }
        }
        return bXW;
    }

    static BannerModel bYf() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = oay;
        }
        return bannerModel;
    }
}
