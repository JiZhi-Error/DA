package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends d<c> {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45551);
        c cVar2 = cVar;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String nullAsNil = Util.nullAsNil(jSONObject.optString("scene"));
        String nullAsNil2 = Util.nullAsNil(jSONObject.optString("type"));
        if (Util.isNullOrNil(optString3)) {
            optString3 = cVar2.getRuntime().bsC().username;
        }
        if (Util.isNullOrNil(cVar2.getAppId()) || Util.isNullOrNil(optString3)) {
            Log.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45551);
            return;
        }
        Log.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3);
        StartVoIPCall startVoIPCall = new StartVoIPCall(this, cVar2, i2);
        startVoIPCall.bDJ();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", cVar2.getAppId());
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", nullAsNil);
        intent.putExtra("voipCSType", nullAsNil2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(cVar2.getContext(), MMApplicationContext.getSourcePackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.l(cVar2.getContext(), intent);
        AppMethodBeat.o(45551);
    }

    static class StartVoIPCall extends MainProcessTask {
        public static final Parcelable.Creator<StartVoIPCall> CREATOR = new Parcelable.Creator<StartVoIPCall>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartVoIPCall[] newArray(int i2) {
                return new StartVoIPCall[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartVoIPCall createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45542);
                StartVoIPCall startVoIPCall = new StartVoIPCall(parcel);
                AppMethodBeat.o(45542);
                return startVoIPCall;
            }
        };
        private p lAw;
        private f lAx;
        private IListener lAy = new IListener<wv>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall.AnonymousClass1 */

            {
                AppMethodBeat.i(160593);
                this.__eventId = wv.class.getName().hashCode();
                AppMethodBeat.o(160593);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(wv wvVar) {
                AppMethodBeat.i(45541);
                wv wvVar2 = wvVar;
                if (wvVar2 != null && (wvVar2 instanceof wv)) {
                    StartVoIPCall.this.status = wvVar2.edj.status;
                    EventCenter.instance.removeListener(StartVoIPCall.this.lAy);
                    StartVoIPCall.b(StartVoIPCall.this);
                }
                AppMethodBeat.o(45541);
                return false;
            }
        };
        private int lqe;
        public int status;

        static /* synthetic */ boolean b(StartVoIPCall startVoIPCall) {
            AppMethodBeat.i(45549);
            boolean bDU = startVoIPCall.bDU();
            AppMethodBeat.o(45549);
            return bDU;
        }

        public StartVoIPCall(p pVar, f fVar, int i2) {
            AppMethodBeat.i(45543);
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
            AppMethodBeat.o(45543);
        }

        public StartVoIPCall(Parcel parcel) {
            AppMethodBeat.i(45544);
            f(parcel);
            AppMethodBeat.o(45544);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45545);
            EventCenter.instance.addListener(this.lAy);
            AppMethodBeat.o(45545);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45546);
            bDK();
            Log.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", Integer.valueOf(this.status));
            if (this.status == 1) {
                this.lAx.i(this.lqe, this.lAw.h("cancel", null));
                AppMethodBeat.o(45546);
            } else if (this.status == 2) {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(45546);
            } else if (this.status == 3) {
                this.lAx.i(this.lqe, this.lAw.h("fail:network error", null));
                AppMethodBeat.o(45546);
            } else if (this.status == 4) {
                this.lAx.i(this.lqe, this.lAw.h("fail:param not match", null));
                AppMethodBeat.o(45546);
            } else {
                this.lAx.i(this.lqe, this.lAw.h("fail:unknow", null));
                AppMethodBeat.o(45546);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45547);
            this.status = parcel.readInt();
            AppMethodBeat.o(45547);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45548);
            parcel.writeInt(this.status);
            AppMethodBeat.o(45548);
        }

        static {
            AppMethodBeat.i(45550);
            AppMethodBeat.o(45550);
        }
    }
}
