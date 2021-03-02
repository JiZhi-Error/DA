package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathActionArgWrapper extends BaseDrawActionArg {
    public static final Parcelable.Creator<PathActionArgWrapper> CREATOR = new Parcelable.Creator<PathActionArgWrapper>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathActionArgWrapper[] newArray(int i2) {
            return new PathActionArgWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathActionArgWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145271);
            PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper(parcel);
            AppMethodBeat.o(145271);
            return pathActionArgWrapper;
        }
    };
    public List<BasePathActionArg> kZW;

    public PathActionArgWrapper(Parcel parcel) {
        this(parcel, (byte) 0);
    }

    private PathActionArgWrapper(Parcel parcel, byte b2) {
        super(parcel);
        AppMethodBeat.i(145272);
        this.kZW = new ArrayList();
        this.kZW = parcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
        AppMethodBeat.o(145272);
    }

    public PathActionArgWrapper() {
        AppMethodBeat.i(145273);
        this.kZW = new ArrayList();
        AppMethodBeat.o(145273);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void reset() {
        AppMethodBeat.i(145274);
        super.reset();
        for (BasePathActionArg basePathActionArg : this.kZW) {
            f.bzq().a(basePathActionArg);
        }
        this.kZW.clear();
        AppMethodBeat.o(145274);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145275);
        super.i(parcel);
        AppMethodBeat.o(145275);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145276);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            AppMethodBeat.o(145276);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            BasePathActionArg basePathActionArg = (BasePathActionArg) f.bzq().WC(optJSONObject.optString(FirebaseAnalytics.b.METHOD));
            basePathActionArg.parse(optJSONObject);
            this.kZW.add(basePathActionArg);
        }
        AppMethodBeat.o(145276);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145277);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145277);
            return false;
        } else if (obj instanceof PathActionArgWrapper) {
            boolean equals = this.kZW.equals(((PathActionArgWrapper) obj).kZW);
            AppMethodBeat.o(145277);
            return equals;
        } else {
            AppMethodBeat.o(145277);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145278);
        super.writeToParcel(parcel, i2);
        parcel.writeList(this.kZW);
        AppMethodBeat.o(145278);
    }

    static {
        AppMethodBeat.i(145279);
        AppMethodBeat.o(145279);
    }
}
