package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "deleteFinderDataItem";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163926);
        s sVar2 = sVar;
        Log.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "JsApiDeleteFinderDataItem");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(163926);
            return;
        }
        String optString = jSONObject.optString("dataItemId", "");
        String optString2 = jSONObject.optString("dataItemNonceId", "");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail:dataItemId is null or nil", null));
            AppMethodBeat.o(163926);
            return;
        }
        DeleteFinderTask deleteFinderTask = new DeleteFinderTask(sVar2, i2, optString, optString2);
        deleteFinderTask.bDJ();
        AppBrandMainProcessService.a(deleteFinderTask);
        AppMethodBeat.o(163926);
    }

    static class DeleteFinderTask extends MainProcessTask implements i {
        public static final Parcelable.Creator<DeleteFinderTask> CREATOR = new Parcelable.Creator<DeleteFinderTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem.DeleteFinderTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DeleteFinderTask[] newArray(int i2) {
                return new DeleteFinderTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DeleteFinderTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163918);
                DeleteFinderTask deleteFinderTask = new DeleteFinderTask(parcel);
                AppMethodBeat.o(163918);
                return deleteFinderTask;
            }
        };
        private s lVM;
        private String lVN;
        private String lVO;
        private String lVP;
        private int lqe;

        public DeleteFinderTask(s sVar, int i2, String str, String str2) {
            this.lVM = sVar;
            this.lqe = i2;
            this.lVN = str;
            this.lVO = str2;
        }

        public DeleteFinderTask(Parcel parcel) {
            AppMethodBeat.i(163919);
            f(parcel);
            AppMethodBeat.o(163919);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163920);
            this.lVN = parcel.readString();
            this.lVO = parcel.readString();
            this.lVP = parcel.readString();
            AppMethodBeat.o(163920);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163921);
            parcel.writeString(this.lVN);
            parcel.writeString(this.lVO);
            parcel.writeString(this.lVP);
            AppMethodBeat.o(163921);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(163922);
            Log.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", this.lVM.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.lVM.isRunning()));
            this.lVM.i(this.lqe, this.lVP);
            bDK();
            AppMethodBeat.o(163922);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163923);
            av avVar = new av(z.aUg(), Long.valueOf(this.lVN).longValue(), this.lVO, false);
            g.azz().a(3627, this);
            g.azz().a(avVar, 0);
            AppMethodBeat.o(163923);
        }

        static {
            AppMethodBeat.i(163925);
            AppMethodBeat.o(163925);
        }

        @Override // com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(163924);
            g.azz().b(3627, this);
            JSONObject jSONObject = new JSONObject();
            if (i2 == 0 && i3 == 0) {
                this.lVP = a.a("", 0, jSONObject);
            } else {
                this.lVP = a.a(str, i3, jSONObject);
            }
            bDU();
            AppMethodBeat.o(163924);
        }
    }
}
