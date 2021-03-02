package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordMediaReportInfo implements Parcelable {
    public static final Parcelable.Creator<RecordMediaReportInfo> CREATOR = new Parcelable.Creator<RecordMediaReportInfo>() {
        /* class com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RecordMediaReportInfo[] newArray(int i2) {
            return new RecordMediaReportInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RecordMediaReportInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101507);
            RecordMediaReportInfo recordMediaReportInfo = new RecordMediaReportInfo(parcel);
            AppMethodBeat.o(101507);
            return recordMediaReportInfo;
        }
    };
    private HashMap ral = new HashMap();

    public RecordMediaReportInfo() {
        AppMethodBeat.i(101508);
        AppMethodBeat.o(101508);
    }

    public final void x(String str, Object obj) {
        AppMethodBeat.i(101509);
        this.ral.put(str, obj);
        AppMethodBeat.o(101509);
    }

    public final <T> T y(String str, T t) {
        AppMethodBeat.i(101510);
        if (this.ral.get(str) != null) {
            T t2 = (T) this.ral.get(str);
            AppMethodBeat.o(101510);
            return t2;
        }
        AppMethodBeat.o(101510);
        return t;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101511);
        parcel.writeSerializable(this.ral);
        AppMethodBeat.o(101511);
    }

    protected RecordMediaReportInfo(Parcel parcel) {
        AppMethodBeat.i(101512);
        this.ral = (HashMap) parcel.readSerializable();
        AppMethodBeat.o(101512);
    }

    static {
        AppMethodBeat.i(101515);
        AppMethodBeat.o(101515);
    }

    public final String eJN() {
        AppMethodBeat.i(101513);
        String jSONObject = new JSONObject(this.ral).toString();
        AppMethodBeat.o(101513);
        return jSONObject;
    }

    public final void aLq(String str) {
        AppMethodBeat.i(101514);
        if (str == null) {
            AppMethodBeat.o(101514);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.ral.put(next, jSONObject.get(next));
            }
            AppMethodBeat.o(101514);
        } catch (JSONException e2) {
            AppMethodBeat.o(101514);
        }
    }
}
