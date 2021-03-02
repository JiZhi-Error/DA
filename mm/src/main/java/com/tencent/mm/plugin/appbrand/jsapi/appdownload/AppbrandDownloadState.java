package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState implements Parcelable {
    public static final Parcelable.Creator<AppbrandDownloadState> CREATOR = new Parcelable.Creator<AppbrandDownloadState>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppbrandDownloadState[] newArray(int i2) {
            return new AppbrandDownloadState[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppbrandDownloadState createFromParcel(Parcel parcel) {
            AppMethodBeat.i(45721);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState(parcel, (byte) 0);
            AppMethodBeat.o(45721);
            return appbrandDownloadState;
        }
    };
    public String appId;
    public long dCa;
    public long lCS;
    public float lCT;
    public long progress;
    public String state;

    /* synthetic */ AppbrandDownloadState(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(45722);
        parcel.writeString(this.state);
        parcel.writeLong(this.dCa);
        parcel.writeString(this.appId);
        parcel.writeLong(this.progress);
        parcel.writeLong(this.lCS);
        parcel.writeFloat(this.lCT);
        AppMethodBeat.o(45722);
    }

    private AppbrandDownloadState(Parcel parcel) {
        AppMethodBeat.i(45723);
        this.state = parcel.readString();
        this.dCa = parcel.readLong();
        this.appId = parcel.readString();
        this.progress = parcel.readLong();
        this.lCS = parcel.readLong();
        this.lCT = parcel.readFloat();
        AppMethodBeat.o(45723);
    }

    public AppbrandDownloadState() {
    }

    static {
        AppMethodBeat.i(45725);
        AppMethodBeat.o(45725);
    }

    public final JSONObject bEw() {
        AppMethodBeat.i(45724);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", this.state);
            jSONObject.put("downloadId", this.dCa);
            jSONObject.put("appId", this.appId);
            jSONObject.put("progress", this.progress);
            jSONObject.put("taskSize", this.lCS);
            jSONObject.put("progressFloat", (double) this.lCT);
        } catch (JSONException e2) {
            Log.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + e2.getMessage());
        }
        AppMethodBeat.o(45724);
        return jSONObject;
    }
}
