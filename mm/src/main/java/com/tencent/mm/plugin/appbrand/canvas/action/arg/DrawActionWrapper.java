package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper implements Parcelable {
    public static final Parcelable.Creator<DrawActionWrapper> CREATOR = new Parcelable.Creator<DrawActionWrapper>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawActionWrapper[] newArray(int i2) {
            return new DrawActionWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawActionWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145001);
            DrawActionWrapper drawActionWrapper = new DrawActionWrapper(parcel);
            AppMethodBeat.o(145001);
            return drawActionWrapper;
        }
    };
    public BaseDrawActionArg kZv;
    public JSONObject kZw;
    public int type;

    public DrawActionWrapper() {
    }

    public DrawActionWrapper(Parcel parcel) {
        AppMethodBeat.i(145002);
        this.type = parcel.readInt();
        switch (this.type) {
            case 1:
                try {
                    this.kZw = new JSONObject(parcel.readString());
                    AppMethodBeat.o(145002);
                    return;
                } catch (JSONException e2) {
                    Log.printErrStackTrace("DrawActionWrapper", e2, "", new Object[0]);
                    AppMethodBeat.o(145002);
                    return;
                }
            case 2:
                this.kZv = (BaseDrawActionArg) parcel.readParcelable(DrawActionWrapper.class.getClassLoader());
                break;
        }
        AppMethodBeat.o(145002);
    }

    public final void reset() {
        AppMethodBeat.i(145003);
        if (this.kZv != null) {
            this.kZv.reset();
            c.bzn().a(this.kZv);
        }
        d.bzo().lab.release(this);
        AppMethodBeat.o(145003);
    }

    public final String getMethod() {
        AppMethodBeat.i(145004);
        switch (this.type) {
            case 1:
                String optString = this.kZw.optString(FirebaseAnalytics.b.METHOD);
                AppMethodBeat.o(145004);
                return optString;
            case 2:
                String str = this.kZv.method;
                AppMethodBeat.o(145004);
                return str;
            default:
                AppMethodBeat.o(145004);
                return "";
        }
    }

    public String toString() {
        AppMethodBeat.i(145005);
        String format = String.format("type %d ,method %s", Integer.valueOf(this.type), getMethod());
        AppMethodBeat.o(145005);
        return format;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145006);
        parcel.writeInt(this.type);
        switch (this.type) {
            case 1:
                parcel.writeString(this.kZw.toString());
                AppMethodBeat.o(145006);
                return;
            case 2:
                parcel.writeParcelable(this.kZv, i2);
                break;
        }
        AppMethodBeat.o(145006);
    }

    static {
        AppMethodBeat.i(145007);
        AppMethodBeat.o(145007);
    }
}
