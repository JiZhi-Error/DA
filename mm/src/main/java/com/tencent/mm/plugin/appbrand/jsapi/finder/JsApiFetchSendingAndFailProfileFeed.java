package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiFetchSendingAndFailProfileFeed extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "fetchSendingAndFailProfileFeed";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163938);
        Log.i("MicroMsg.Finder.JsApiFetchSendingAndFailProfileFeed", "JsApiFetchSendingAndFailProfileFeed");
        FetchSendingAndFailProfileFeedTask fetchSendingAndFailProfileFeedTask = new FetchSendingAndFailProfileFeedTask(i2, sVar);
        fetchSendingAndFailProfileFeedTask.bDJ();
        AppBrandMainProcessService.a(fetchSendingAndFailProfileFeedTask);
        AppMethodBeat.o(163938);
    }

    static class FetchSendingAndFailProfileFeedTask extends MainProcessTask {
        public static final Parcelable.Creator<FetchSendingAndFailProfileFeedTask> CREATOR = new Parcelable.Creator<FetchSendingAndFailProfileFeedTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ FetchSendingAndFailProfileFeedTask[] newArray(int i2) {
                return new FetchSendingAndFailProfileFeedTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FetchSendingAndFailProfileFeedTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163929);
                FetchSendingAndFailProfileFeedTask fetchSendingAndFailProfileFeedTask = new FetchSendingAndFailProfileFeedTask(parcel);
                AppMethodBeat.o(163929);
                return fetchSendingAndFailProfileFeedTask;
            }
        };
        private s kGT;
        private String lVP;
        private int lqe;

        static /* synthetic */ boolean a(FetchSendingAndFailProfileFeedTask fetchSendingAndFailProfileFeedTask) {
            AppMethodBeat.i(163936);
            boolean bDU = fetchSendingAndFailProfileFeedTask.bDU();
            AppMethodBeat.o(163936);
            return bDU;
        }

        public FetchSendingAndFailProfileFeedTask(int i2, s sVar) {
            this.lqe = i2;
            this.kGT = sVar;
        }

        public FetchSendingAndFailProfileFeedTask(Parcel parcel) {
            AppMethodBeat.i(163931);
            f(parcel);
            AppMethodBeat.o(163931);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163932);
            this.lVP = parcel.readString();
            AppMethodBeat.o(163932);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163933);
            parcel.writeString(this.lVP);
            AppMethodBeat.o(163933);
        }

        static {
            AppMethodBeat.i(163937);
            AppMethodBeat.o(163937);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163934);
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFetchSendingAndFailProfileFeed.FetchSendingAndFailProfileFeedTask.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(163930);
                    List<FinderItem> dxD = ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage().dxD();
                    JSONArray jSONArray = new JSONArray();
                    for (FinderItem finderItem : dxD) {
                        FinderObject finderObject = finderItem.getFinderObject();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            a.a(finderObject, jSONObject);
                            jSONObject.put("status", finderItem.field_localFlag);
                            jSONObject.put("feedLocalId", String.valueOf(finderItem.systemRowid));
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                        }
                    }
                    FetchSendingAndFailProfileFeedTask.this.lVP = a.a("", 0, jSONArray);
                    FetchSendingAndFailProfileFeedTask.a(FetchSendingAndFailProfileFeedTask.this);
                    AppMethodBeat.o(163930);
                }
            }, "JsApiFetchSendingAndFailProfileFeed");
            AppMethodBeat.o(163934);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            AppMethodBeat.i(163935);
            try {
                JSONObject jSONObject = new JSONObject(this.lVP);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("data");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("objectDesc")) == null || (optJSONArray = optJSONObject.optJSONArray("media")) == null)) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                                if (optJSONObject3 != null) {
                                    String optString = optJSONObject3.optString("url");
                                    String optString2 = optJSONObject3.optString("thumbUrl");
                                    if (!Util.isNullOrNil(optString) && !optString.startsWith("http")) {
                                        i<String> iVar = new i<>();
                                        if (this.kGT.getFileSystem().a(new o(optString), (String) null, false, iVar) == m.OK) {
                                            optJSONObject3.put("url", iVar.value);
                                        }
                                    }
                                    if (!Util.isNullOrNil(optString2) && !optString2.startsWith("http")) {
                                        i<String> iVar2 = new i<>();
                                        if (this.kGT.getFileSystem().a(new o(optString2), (String) null, false, iVar2) == m.OK) {
                                            optJSONObject3.put("thumbUrl", iVar2.value);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.lVP = jSONObject.toString();
            } catch (Exception e2) {
                this.lVP = a.a(e2.getMessage(), -1, new JSONArray());
            }
            Log.i("MicroMsg.Finder.JsApiFetchSendingAndFailProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", this.kGT.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.kGT.isRunning()));
            this.kGT.i(this.lqe, this.lVP);
            bDK();
            AppMethodBeat.o(163935);
        }
    }
}
