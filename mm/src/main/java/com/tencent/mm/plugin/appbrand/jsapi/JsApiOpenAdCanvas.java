package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.os;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOpenAdCanvas extends d<c> {
    public static final int CTRL_INDEX = 476;
    public static final String NAME = "openADCanvas";
    private String lAK = "";
    private JsApiOpenAdCanvasTask lAL = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45570);
        c cVar2 = cVar;
        if (jSONObject == null) {
            cVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(45570);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(cVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(45570);
            return;
        }
        try {
            this.lAK = jSONObject.getString("canvasId");
            if (Util.isNullOrNil(this.lAK) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.lAK)) {
                HashMap hashMap = new HashMap();
                hashMap.put("canvasId", this.lAK);
                cVar2.i(i2, n("fail", hashMap));
                i.zd(0);
                AppMethodBeat.o(45570);
                return;
            }
            int i3 = jSONObject.getInt("preLoad");
            int i4 = jSONObject.getInt("noStore");
            int optInt = jSONObject.optInt("openFirstSightVoice", 0);
            String string = jSONObject.getString("extraData");
            String string2 = jSONObject.getString("adInfoXml");
            Log.i("MicroMsg.JsApiOpenAdCanvas", "doOpenCanvas canvasid %s,preLoad %d, noStore %d", this.lAK, Integer.valueOf(i3), Integer.valueOf(i4));
            this.lAL = new JsApiOpenAdCanvasTask(this, cVar2, i2, new WeakReference(castActivityOrNull), this.lAK, i3, i4, string, string2, optInt);
            this.lAL.bDJ();
            AppBrandMainProcessService.a(this.lAL);
            i.at(cVar2.getRuntime().bsC().cyo + 1000, cVar2.getAppId());
            AppMethodBeat.o(45570);
        } catch (JSONException e2) {
            if (this.lAL != null) {
                this.lAL.bDK();
            }
            Log.printErrStackTrace("MicroMsg.JsApiOpenAdCanvas", e2, "canvasId=%s", this.lAK);
            i.zd(1);
            cVar2.i(i2, h("fail parse json error", null));
            AppMethodBeat.o(45570);
        }
    }

    static class JsApiOpenAdCanvasTask extends MainProcessTask {
        public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR = new Parcelable.Creator<JsApiOpenAdCanvasTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ JsApiOpenAdCanvasTask[] newArray(int i2) {
                return new JsApiOpenAdCanvasTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ JsApiOpenAdCanvasTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45562);
                JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask = new JsApiOpenAdCanvasTask(parcel);
                AppMethodBeat.o(45562);
                return jsApiOpenAdCanvasTask;
            }
        };
        private String dSJ;
        private int dUL;
        private int dUM;
        private s kGT;
        private WeakReference<Context> lAM;
        private String lAN;
        private int lAO;
        private String lAP;
        private String lAQ;
        private p lAw;
        private int lqe;

        static /* synthetic */ boolean e(JsApiOpenAdCanvasTask jsApiOpenAdCanvasTask) {
            AppMethodBeat.i(45568);
            boolean bDU = jsApiOpenAdCanvasTask.bDU();
            AppMethodBeat.o(45568);
            return bDU;
        }

        public JsApiOpenAdCanvasTask(p pVar, s sVar, int i2, WeakReference<Context> weakReference, String str, int i3, int i4, String str2, String str3, int i5) {
            this.lAw = pVar;
            this.kGT = sVar;
            this.lqe = i2;
            this.lAM = weakReference;
            this.lAN = str;
            this.dUL = i3;
            this.dUM = i4;
            this.dSJ = str2;
            this.lAP = str3;
            this.lAO = i5;
        }

        public JsApiOpenAdCanvasTask(Parcel parcel) {
            AppMethodBeat.i(45563);
            f(parcel);
            AppMethodBeat.o(45563);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45564);
            String str = this.lAQ;
            if (this.dUL == 0) {
                Intent intent = new Intent();
                if (str == null) {
                    str = "";
                }
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(this.lAN));
                intent.putExtra("sns_landig_pages_from_source", 13);
                intent.putExtra("sns_landing_pages_extra", this.dSJ);
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                intent.putExtra("sns_landing_pages_no_store", this.dUM);
                intent.putExtra("sns_landing_pages_ad_info", this.lAP);
                intent.putExtra("sns_landing_is_native_sight_ad", this.lAO == 1);
                com.tencent.mm.br.c.b(this.lAM.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                this.kGT.i(this.lqe, this.lAw.h("ok", null));
            } else if (this.dUL == 1) {
                this.kGT.i(this.lqe, this.lAw.h("ok", null));
            } else {
                this.kGT.i(this.lqe, this.lAw.h("fail", null));
            }
            bDK();
            AppMethodBeat.o(45564);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45565);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45561);
                    os osVar = new os();
                    osVar.dUJ.pageId = JsApiOpenAdCanvasTask.this.lAN;
                    osVar.dUJ.dFN = JsApiOpenAdCanvasTask.this.dSJ;
                    osVar.dUJ.dUL = JsApiOpenAdCanvasTask.this.dUL;
                    osVar.dUJ.dUM = JsApiOpenAdCanvasTask.this.dUM;
                    osVar.dUJ.source = 0;
                    EventCenter.instance.publish(osVar);
                    JsApiOpenAdCanvasTask.this.lAQ = osVar.dUK.xml;
                    JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvasTask.this);
                    AppMethodBeat.o(45561);
                }
            }, "JsApiOpenAdCanvas");
            AppMethodBeat.o(45565);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45566);
            this.lAN = parcel.readString();
            this.dUL = parcel.readInt();
            this.dUM = parcel.readInt();
            this.dSJ = parcel.readString();
            this.lAP = parcel.readString();
            this.lAQ = parcel.readString();
            this.lAO = parcel.readInt();
            AppMethodBeat.o(45566);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45567);
            parcel.writeString(this.lAN);
            parcel.writeInt(this.dUL);
            parcel.writeInt(this.dUM);
            parcel.writeString(this.dSJ);
            parcel.writeString(this.lAP);
            parcel.writeString(this.lAQ);
            parcel.writeInt(this.lAO);
            AppMethodBeat.o(45567);
        }

        static {
            AppMethodBeat.i(45569);
            AppMethodBeat.o(45569);
        }
    }
}
