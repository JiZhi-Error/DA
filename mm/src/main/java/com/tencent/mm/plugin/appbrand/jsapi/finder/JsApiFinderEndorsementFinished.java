package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiFinderEndorsementFinished extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "endorsementFinished";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163945);
        s sVar2 = sVar;
        h.hkS();
        if (jSONObject == null) {
            sVar2.i(i2, "fail:data is null");
            AppMethodBeat.o(163945);
            return;
        }
        String optString = jSONObject.optString("finderUserName", "");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, "fail:finderUserName is null");
            AppMethodBeat.o(163945);
            return;
        }
        AppBrandMainProcessService.a(new FinderUserPageTask(optString));
        AppMethodBeat.o(163945);
    }

    static class FinderUserPageTask extends MainProcessTask {
        public static final Parcelable.Creator<FinderUserPageTask> CREATOR = new Parcelable.Creator<FinderUserPageTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFinderEndorsementFinished.FinderUserPageTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ FinderUserPageTask[] newArray(int i2) {
                return new FinderUserPageTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FinderUserPageTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163939);
                FinderUserPageTask finderUserPageTask = new FinderUserPageTask(parcel, (byte) 0);
                AppMethodBeat.o(163939);
                return finderUserPageTask;
            }
        };
        private String username;

        /* synthetic */ FinderUserPageTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        private FinderUserPageTask(Parcel parcel) {
            AppMethodBeat.i(163940);
            f(parcel);
            AppMethodBeat.o(163940);
        }

        public FinderUserPageTask(String str) {
            this.username = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163941);
            this.username = parcel.readString();
            AppMethodBeat.o(163941);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163942);
            parcel.writeString(this.username);
            AppMethodBeat.o(163942);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163943);
            AppMethodBeat.o(163943);
        }

        static {
            AppMethodBeat.i(163944);
            AppMethodBeat.o(163944);
        }
    }
}
