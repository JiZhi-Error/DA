package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult implements Parcelable {
    public static final Parcelable.Creator<MiniProgramNavigationBackResult> CREATOR = new Parcelable.Creator<MiniProgramNavigationBackResult>() {
        /* class com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MiniProgramNavigationBackResult[] newArray(int i2) {
            return new MiniProgramNavigationBackResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MiniProgramNavigationBackResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134625);
            MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult(parcel, (byte) 0);
            AppMethodBeat.o(134625);
            return miniProgramNavigationBackResult;
        }
    };
    public JSONObject kFg;
    public JSONObject kFh;

    /* synthetic */ MiniProgramNavigationBackResult(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static MiniProgramNavigationBackResult a(JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(134626);
        if (jSONObject == null && jSONObject2 == null) {
            AppMethodBeat.o(134626);
            return null;
        }
        MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            jSONObject3 = jSONObject;
        }
        miniProgramNavigationBackResult.kFg = jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        if (jSONObject2 != null) {
            jSONObject4 = jSONObject2;
        }
        miniProgramNavigationBackResult.kFh = jSONObject4;
        AppMethodBeat.o(134626);
        return miniProgramNavigationBackResult;
    }

    public String toString() {
        AppMethodBeat.i(229875);
        String str = "MiniProgramNavigationBackResult{extraData=" + this.kFg + ", privateData=" + this.kFh + '}';
        AppMethodBeat.o(229875);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str = null;
        AppMethodBeat.i(134627);
        parcel.writeString(this.kFg == null ? null : this.kFg.toString());
        if (this.kFh != null) {
            str = this.kFh.toString();
        }
        parcel.writeString(str);
        AppMethodBeat.o(134627);
    }

    public MiniProgramNavigationBackResult() {
    }

    private MiniProgramNavigationBackResult(Parcel parcel) {
        AppMethodBeat.i(134628);
        try {
            this.kFg = new JSONObject(Util.nullAs(parcel.readString(), "{}"));
            this.kFh = new JSONObject(Util.nullAs(parcel.readString(), "{}"));
            AppMethodBeat.o(134628);
        } catch (JSONException e2) {
            Log.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", e2);
            AppMethodBeat.o(134628);
        }
    }

    static {
        AppMethodBeat.i(134629);
        AppMethodBeat.o(134629);
    }
}
