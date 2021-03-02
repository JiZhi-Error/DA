package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Parcelable.Creator<MallFunction> CREATOR = new Parcelable.Creator<MallFunction>() {
        /* class com.tencent.mm.plugin.wallet_core.model.mall.MallFunction.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MallFunction[] newArray(int i2) {
            return new MallFunction[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MallFunction createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70535);
            MallFunction mallFunction = new MallFunction(parcel);
            AppMethodBeat.o(70535);
            return mallFunction;
        }
    };
    public String Icd;
    public ArrayList<String> Ice;
    public MallNews Icf;
    public String Icg;
    public int Ich = 0;
    public String edq;
    public String egX;
    public String h5Url;
    public String kHR;
    public int type;
    public String zkt;
    public String zku;

    public MallFunction() {
    }

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        AppMethodBeat.i(70536);
        this.kHR = parcel.readString();
        this.edq = parcel.readString();
        this.Icd = parcel.readString();
        this.zkt = parcel.readString();
        this.zku = parcel.readString();
        this.egX = parcel.readString();
        this.h5Url = parcel.readString();
        this.Ice = new ArrayList<>();
        parcel.readStringList(this.Ice);
        this.Icf = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.Icg = parcel.readString();
        this.Ich = parcel.readInt();
        AppMethodBeat.o(70536);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70537);
        parcel.writeString(this.kHR);
        parcel.writeString(this.edq);
        parcel.writeString(this.Icd);
        parcel.writeString(this.zkt);
        parcel.writeString(this.zku);
        parcel.writeString(this.egX);
        parcel.writeString(this.h5Url);
        parcel.writeStringList(this.Ice);
        parcel.writeParcelable(this.Icf, i2);
        parcel.writeInt(this.type);
        parcel.writeString(this.Icg);
        parcel.writeInt(this.Ich);
        AppMethodBeat.o(70537);
    }

    static {
        AppMethodBeat.i(70538);
        AppMethodBeat.o(70538);
    }
}
