package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONObject;

public final class JsApiShowUpdatableMessageSubscribeButton extends d<s> {
    public static final int CTRL_INDEX = 465;
    public static final String NAME = "showUpdatableMessageSubscribeButton";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46795);
        s sVar2 = sVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "data is null, err");
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46795);
            return;
        }
        String optString = jSONObject.optString("shareKey");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiShowUpdatableMessageSubscribeButton", "shareKey is null, err");
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46795);
            return;
        }
        ShowUpdatableMessageSubscribeButtonTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask();
        showUpdatableMessageSubscribeButtonTask.cyr = optString;
        AppBrandMainProcessService.a(showUpdatableMessageSubscribeButtonTask);
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(46795);
    }

    static class ShowUpdatableMessageSubscribeButtonTask extends MainProcessTask {
        public static final Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR = new Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton.ShowUpdatableMessageSubscribeButtonTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ShowUpdatableMessageSubscribeButtonTask[] newArray(int i2) {
                return new ShowUpdatableMessageSubscribeButtonTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ShowUpdatableMessageSubscribeButtonTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46789);
                ShowUpdatableMessageSubscribeButtonTask showUpdatableMessageSubscribeButtonTask = new ShowUpdatableMessageSubscribeButtonTask(parcel);
                AppMethodBeat.o(46789);
                return showUpdatableMessageSubscribeButtonTask;
            }
        };
        public String cyr;

        public ShowUpdatableMessageSubscribeButtonTask() {
        }

        public ShowUpdatableMessageSubscribeButtonTask(Parcel parcel) {
            AppMethodBeat.i(46790);
            f(parcel);
            AppMethodBeat.o(46790);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46791);
            if (g.af(m.class) == null) {
                Log.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
                if (BuildInfo.IS_FLAVOR_RED) {
                    Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
                }
                AppMethodBeat.o(46791);
                return;
            }
            c Lq = ((m) g.af(m.class)).Lq(this.cyr);
            if (Lq == null || (Lq.field_btnState != 2 && Lq.field_msgState == 0)) {
                ((m) g.af(m.class)).ao(this.cyr, 1);
                AppMethodBeat.o(46791);
                return;
            }
            Log.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", this.cyr, Integer.valueOf(Lq.field_btnState), Integer.valueOf(Lq.field_msgState));
            AppMethodBeat.o(46791);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(46792);
            this.cyr = parcel.readString();
            AppMethodBeat.o(46792);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46793);
            parcel.writeString(this.cyr);
            AppMethodBeat.o(46793);
        }

        static {
            AppMethodBeat.i(46794);
            AppMethodBeat.o(46794);
        }
    }
}
