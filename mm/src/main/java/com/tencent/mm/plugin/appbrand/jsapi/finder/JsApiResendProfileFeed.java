package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResendProfileFeed extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "resendProfileFeed";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163987);
        s sVar2 = sVar;
        Log.i("MicroMsg.Finder.JsApiResendProfileFeed", "JsApiResendProfileFeed");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(163987);
            return;
        }
        String optString = jSONObject.optString("feedLocalId", "");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail:feedLocalId is null or nil", null));
            AppMethodBeat.o(163987);
            return;
        }
        ResendProfileFeedTask resendProfileFeedTask = new ResendProfileFeedTask(sVar2, i2, Long.valueOf(optString).longValue());
        resendProfileFeedTask.bDJ();
        AppBrandMainProcessService.a(resendProfileFeedTask);
        AppMethodBeat.o(163987);
    }

    static class ResendProfileFeedTask extends MainProcessTask implements q {
        public static final Parcelable.Creator<ResendProfileFeedTask> CREATOR = new Parcelable.Creator<ResendProfileFeedTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResendProfileFeedTask[] newArray(int i2) {
                return new ResendProfileFeedTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResendProfileFeedTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163975);
                ResendProfileFeedTask resendProfileFeedTask = new ResendProfileFeedTask(parcel);
                AppMethodBeat.o(163975);
                return resendProfileFeedTask;
            }
        };
        private String event;
        private s lVM;
        private String lVP;
        private long lVZ;
        private int lqe;

        static /* synthetic */ boolean b(ResendProfileFeedTask resendProfileFeedTask) {
            AppMethodBeat.i(163984);
            boolean bDU = resendProfileFeedTask.bDU();
            AppMethodBeat.o(163984);
            return bDU;
        }

        static /* synthetic */ boolean c(ResendProfileFeedTask resendProfileFeedTask) {
            AppMethodBeat.i(163985);
            boolean bDU = resendProfileFeedTask.bDU();
            AppMethodBeat.o(163985);
            return bDU;
        }

        public ResendProfileFeedTask(s sVar, int i2, long j2) {
            this.lVM = sVar;
            this.lqe = i2;
            this.lVZ = j2;
        }

        public ResendProfileFeedTask(Parcel parcel) {
            AppMethodBeat.i(163977);
            f(parcel);
            AppMethodBeat.o(163977);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163978);
            this.lVZ = parcel.readLong();
            this.event = parcel.readString();
            this.lVP = parcel.readString();
            AppMethodBeat.o(163978);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163979);
            parcel.writeLong(this.lVZ);
            parcel.writeString(this.event);
            parcel.writeString(this.lVP);
            AppMethodBeat.o(163979);
        }

        static {
            AppMethodBeat.i(163986);
            AppMethodBeat.o(163986);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(163980);
            Log.i("MicroMsg.Finder.JsApiResendProfileFeed", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", this.lVM.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.lVM.isRunning()));
            if (Util.isNullOrNil(this.event) || !this.event.equals("onPostEnd")) {
                this.lVM.i(this.lqe, this.lVP);
                AppMethodBeat.o(163980);
                return;
            }
            new a((byte) 0).g(this.lVM).Zg(this.lVP).bEo();
            bDK();
            AppMethodBeat.o(163980);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163981);
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed.ResendProfileFeedTask.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(163976);
                    FinderItem Fz = ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage().Fz(ResendProfileFeedTask.this.lVZ);
                    JSONObject jSONObject = new JSONObject();
                    if (Fz.field_localFlag == 0) {
                        try {
                            jSONObject.put("feedLocalId", ResendProfileFeedTask.this.lVZ);
                        } catch (Exception e2) {
                        }
                        ResendProfileFeedTask.this.lVP = a.a("", 1, jSONObject);
                        ResendProfileFeedTask.b(ResendProfileFeedTask.this);
                        AppMethodBeat.o(163976);
                        return;
                    }
                    g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
                    com.tencent.mm.plugin.finder.upload.g.vSH.t(Fz);
                    g.a aVar2 = com.tencent.mm.plugin.finder.upload.g.vSJ;
                    com.tencent.mm.plugin.finder.upload.g.vSH.a(ResendProfileFeedTask.this);
                    ResendProfileFeedTask.this.lVP = a.a("", 0, jSONObject);
                    ResendProfileFeedTask.c(ResendProfileFeedTask.this);
                    AppMethodBeat.o(163976);
                }
            }, "JsApiResendProfileFeed");
            AppMethodBeat.o(163981);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostStart(long j2) {
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostEnd(long j2, boolean z) {
            AppMethodBeat.i(163982);
            if (j2 == this.lVZ) {
                g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
                com.tencent.mm.plugin.finder.upload.g.vSH.b(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feedLocalId", String.valueOf(j2));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", e2, "PostFinderTask onPostEnd", new Object[0]);
                }
                this.event = "onPostEnd";
                if (z) {
                    this.lVP = a.a("", 0, jSONObject);
                } else {
                    this.lVP = a.a("post fail", -1, jSONObject);
                }
                bDU();
            }
            AppMethodBeat.o(163982);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostOk(long j2, long j3) {
            AppMethodBeat.i(163983);
            if (j2 == this.lVZ) {
                g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
                com.tencent.mm.plugin.finder.upload.g.vSH.b(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feedLocalId", String.valueOf(j2));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Finder.JsApiResendProfileFeed", e2, "PostFinderTask onPostEnd", new Object[0]);
                }
                this.event = "onPostEnd";
                this.lVP = a.a("", 0, jSONObject);
                bDU();
            }
            AppMethodBeat.o(163983);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostNotify(long j2, boolean z) {
        }
    }

    static final class a extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onFeedPostCallback";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
