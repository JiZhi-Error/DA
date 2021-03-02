package com.tencent.mm.plugin.ball.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class BallReportInfo implements Parcelable {
    public static final Parcelable.Creator<BallReportInfo> CREATOR = new Parcelable.Creator<BallReportInfo>() {
        /* class com.tencent.mm.plugin.ball.model.BallReportInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BallReportInfo[] newArray(int i2) {
            return new BallReportInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BallReportInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(127549);
            BallReportInfo ballReportInfo = new BallReportInfo(parcel);
            AppMethodBeat.o(127549);
            return ballReportInfo;
        }
    };
    public String dPJ;
    public int hCZ;
    public int hDa;
    public String iNV;
    public String oWA;
    public String oWB;
    public int oWC;
    public int oWx;
    public String oWy;
    public int oWz;
    public int opType;

    BallReportInfo() {
    }

    protected BallReportInfo(Parcel parcel) {
        AppMethodBeat.i(127550);
        this.hCZ = parcel.readInt();
        this.oWx = parcel.readInt();
        this.hDa = parcel.readInt();
        this.dPJ = parcel.readString();
        this.oWy = parcel.readString();
        this.iNV = parcel.readString();
        this.opType = parcel.readInt();
        this.oWA = parcel.readString();
        this.oWB = parcel.readString();
        this.oWC = parcel.readInt();
        this.oWz = parcel.readInt();
        AppMethodBeat.o(127550);
    }

    static {
        AppMethodBeat.i(127554);
        AppMethodBeat.o(127554);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(127551);
        parcel.writeInt(this.hCZ);
        parcel.writeInt(this.oWx);
        parcel.writeInt(this.hDa);
        parcel.writeString(this.dPJ);
        parcel.writeString(this.oWy);
        parcel.writeString(this.iNV);
        parcel.writeInt(this.opType);
        parcel.writeString(this.oWA);
        parcel.writeString(this.oWB);
        parcel.writeInt(this.oWC);
        parcel.writeInt(this.oWz);
        AppMethodBeat.o(127551);
    }

    public final JSONObject cii() {
        AppMethodBeat.i(127552);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("r_internal_sessionId", this.oWA);
            jSONObject.put("r_internal_aggregationSessionId", this.oWB);
            jSONObject.put("r_internal_taskOrder", this.oWC);
            AppMethodBeat.o(127552);
        } catch (JSONException e2) {
            AppMethodBeat.o(127552);
        }
        return jSONObject;
    }

    BallReportInfo(JSONObject jSONObject) {
        AppMethodBeat.i(127553);
        this.oWA = jSONObject.optString("r_internal_sessionId", null);
        this.oWB = jSONObject.optString("r_internal_aggregationSessionId", null);
        this.oWC = jSONObject.optInt("r_internal_taskOrder", 1);
        AppMethodBeat.o(127553);
    }

    public String toString() {
        AppMethodBeat.i(188577);
        String str = "BallReportInfo{generateType=" + this.hCZ + ", generateScene=" + this.oWx + ", bizScene=" + this.hDa + ", bizId='" + this.dPJ + '\'' + ", bizSubId='" + this.oWy + '\'' + ", bizName='" + this.iNV + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.oWA + '\'' + ", internal_aggregationSessionId='" + this.oWB + '\'' + ", internal_taskOrder=" + this.oWC + '}';
        AppMethodBeat.o(188577);
        return str;
    }
}
