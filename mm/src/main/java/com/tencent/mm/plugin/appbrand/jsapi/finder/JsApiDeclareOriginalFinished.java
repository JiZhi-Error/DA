package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.cn;
import org.json.JSONObject;

public final class JsApiDeclareOriginalFinished extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "declareOriginalFinished";

    static class RefreshFinderUserpageTask extends MainProcessTask {
        public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR = new Parcelable.Creator<RefreshFinderUserpageTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished.RefreshFinderUserpageTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RefreshFinderUserpageTask[] newArray(int i2) {
                return new RefreshFinderUserpageTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RefreshFinderUserpageTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226834);
                RefreshFinderUserpageTask refreshFinderUserpageTask = new RefreshFinderUserpageTask(parcel);
                AppMethodBeat.o(226834);
                return refreshFinderUserpageTask;
            }
        };

        public RefreshFinderUserpageTask() {
        }

        public RefreshFinderUserpageTask(Parcel parcel) {
            AppMethodBeat.i(226835);
            f(parcel);
            AppMethodBeat.o(226835);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(226836);
            cn cnVar = new cn(z.aUg(), 0, null, 0, null, 0, 0);
            cnVar.twC = true;
            g.azz().a(cnVar, 0);
            bDU();
            AppMethodBeat.o(226836);
        }

        static {
            AppMethodBeat.i(226837);
            AppMethodBeat.o(226837);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226838);
        AppBrandMainProcessService.a(new RefreshFinderUserpageTask());
        AppMethodBeat.o(226838);
    }
}
