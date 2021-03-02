package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;

public class ByRuntimeQrcodeResult implements Parcelable {
    public static final Parcelable.Creator<ByRuntimeQrcodeResult> CREATOR = new Parcelable.Creator<ByRuntimeQrcodeResult>() {
        /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ByRuntimeQrcodeResult[] newArray(int i2) {
            return new ByRuntimeQrcodeResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ByRuntimeQrcodeResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47496);
            ByRuntimeQrcodeResult byRuntimeQrcodeResult = new ByRuntimeQrcodeResult(parcel);
            AppMethodBeat.o(47496);
            return byRuntimeQrcodeResult;
        }
    };
    public String data;
    public String les;

    public ByRuntimeQrcodeResult(String str, String str2) {
        this.data = str;
        this.les = str2;
    }

    public final String bua() {
        AppMethodBeat.i(47497);
        try {
            String iVar = new i().h("transitiveData", this.les).h("data", this.data).toString();
            AppMethodBeat.o(47497);
            return iVar;
        } catch (g e2) {
            Log.e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", e2);
            AppMethodBeat.o(47497);
            return "{}";
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(47498);
        parcel.writeString(this.data);
        parcel.writeString(this.les);
        AppMethodBeat.o(47498);
    }

    protected ByRuntimeQrcodeResult(Parcel parcel) {
        AppMethodBeat.i(47499);
        this.data = parcel.readString();
        this.les = parcel.readString();
        AppMethodBeat.o(47499);
    }

    static {
        AppMethodBeat.i(47500);
        AppMethodBeat.o(47500);
    }
}
