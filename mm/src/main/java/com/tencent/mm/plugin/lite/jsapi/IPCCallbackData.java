package com.tencent.mm.plugin.lite.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class IPCCallbackData implements Parcelable {
    public static final Parcelable.Creator<IPCCallbackData> CREATOR = new Parcelable.Creator<IPCCallbackData>() {
        /* class com.tencent.mm.plugin.lite.jsapi.IPCCallbackData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCCallbackData[] newArray(int i2) {
            return new IPCCallbackData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCCallbackData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(198817);
            IPCCallbackData iPCCallbackData = new IPCCallbackData(parcel);
            AppMethodBeat.o(198817);
            return iPCCallbackData;
        }
    };
    public boolean cqT = false;
    public String cqU = null;
    public String cqV = null;
    public boolean yEe = false;

    public IPCCallbackData() {
    }

    public IPCCallbackData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(198818);
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.cqT = z;
        this.yEe = parcel.readInt() != 1 ? false : z2;
        this.cqU = parcel.readString();
        this.cqV = parcel.readString();
        AppMethodBeat.o(198818);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(198819);
        if (this.cqT) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.yEe) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        parcel.writeString(this.cqU);
        parcel.writeString(this.cqV);
        AppMethodBeat.o(198819);
    }

    public final JSONObject ecy() {
        AppMethodBeat.i(198820);
        if (this.cqV == null) {
            AppMethodBeat.o(198820);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.cqV);
            AppMethodBeat.o(198820);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(198820);
            return null;
        }
    }

    static {
        AppMethodBeat.i(198821);
        AppMethodBeat.o(198821);
    }
}
