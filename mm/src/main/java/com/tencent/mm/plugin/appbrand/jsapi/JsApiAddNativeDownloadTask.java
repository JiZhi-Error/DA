package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiAddNativeDownloadTask extends d<s> {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45449);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            sVar2.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(45449);
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j2 = Util.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = sVar2.getContext();
        Log.i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", optString2, Long.valueOf(j2), optString3, optString5, optString4);
        if (!NetStatusUtil.isNetworkConnected(context)) {
            sVar2.i(i2, h("fail:fail network not connected", null));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45435);
                    Toast.makeText(context, context.getString(R.string.dom), 0).show();
                    AppMethodBeat.o(45435);
                }
            });
            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
            AppMethodBeat.o(45449);
        } else if (!e.apn()) {
            sVar2.i(i2, h("fail:fail sdcard not ready", null));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(45436);
                    Toast.makeText(context, context.getString(R.string.doq), 0).show();
                    AppMethodBeat.o(45436);
                }
            });
            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
            AppMethodBeat.o(45449);
        } else if (j2 > 0 && !e.yV(j2)) {
            sVar2.i(i2, h("fail:fail sdcard has not enough space", null));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(45437);
                    Toast.makeText(context, context.getString(R.string.don), 0).show();
                    AppMethodBeat.o(45437);
                }
            });
            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = ".concat(String.valueOf(j2)));
            AppMethodBeat.o(45449);
        } else if (Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            sVar2.i(i2, h("fail:taskUrl is null or nil", null));
            AppMethodBeat.o(45449);
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j2);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", sVar2.getAppId());
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            ac currentPageView = sVar2.getCurrentPageView();
            if (currentPageView != null) {
                intent.putExtra("page_url", currentPageView.lBI);
            } else {
                Log.e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            c.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            final AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            addNativeDownloadTaskTask.lyv = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AnonymousClass4 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public final void run() {
                    AppMethodBeat.i(45438);
                    addNativeDownloadTaskTask.bDK();
                    HashMap hashMap = new HashMap();
                    switch (addNativeDownloadTaskTask.cSx) {
                        case 0:
                            sVar2.i(i2, JsApiAddNativeDownloadTask.this.h("fail:cancel", null));
                            AppMethodBeat.o(45438);
                            return;
                        case 1:
                            sVar2.i(i2, JsApiAddNativeDownloadTask.this.h("fail:download fail", null));
                            AppMethodBeat.o(45438);
                            return;
                        case 2:
                            hashMap.put("download_id", Long.valueOf(addNativeDownloadTaskTask.dCa));
                            sVar2.i(i2, JsApiAddNativeDownloadTask.this.n("ok", hashMap));
                            break;
                    }
                    AppMethodBeat.o(45438);
                }
            };
            addNativeDownloadTaskTask.bDJ();
            AppBrandMainProcessService.a(addNativeDownloadTaskTask);
            AppMethodBeat.o(45449);
        }
    }

    static class AddNativeDownloadTaskTask extends MainProcessTask {
        public static final Parcelable.Creator<AddNativeDownloadTaskTask> CREATOR = new Parcelable.Creator<AddNativeDownloadTaskTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddNativeDownloadTaskTask[] newArray(int i2) {
                return new AddNativeDownloadTaskTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddNativeDownloadTaskTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45440);
                AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
                addNativeDownloadTaskTask.f(parcel);
                AppMethodBeat.o(45440);
                return addNativeDownloadTaskTask;
            }
        };
        public int cSx = 0;
        public long dCa = 0;
        private IListener lyu;
        Runnable lyv;

        static /* synthetic */ boolean a(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(45445);
            boolean bDU = addNativeDownloadTaskTask.bDU();
            AppMethodBeat.o(45445);
            return bDU;
        }

        static /* synthetic */ boolean b(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(45446);
            boolean bDU = addNativeDownloadTaskTask.bDU();
            AppMethodBeat.o(45446);
            return bDU;
        }

        static /* synthetic */ boolean c(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(45447);
            boolean bDU = addNativeDownloadTaskTask.bDU();
            AppMethodBeat.o(45447);
            return bDU;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45441);
            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", Integer.valueOf(this.cSx));
            this.lyu = new IListener<i>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.AnonymousClass1 */

                {
                    AppMethodBeat.i(160592);
                    this.__eventId = i.class.getName().hashCode();
                    AppMethodBeat.o(160592);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(i iVar) {
                    AppMethodBeat.i(45439);
                    i iVar2 = iVar;
                    if (!(iVar2 instanceof i)) {
                        Log.w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
                        AppMethodBeat.o(45439);
                        return false;
                    } else if (iVar2.dBY.scene != 1) {
                        Log.i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
                        AppMethodBeat.o(45439);
                        return false;
                    } else {
                        if (iVar2.dBY.dBZ) {
                            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                            AddNativeDownloadTaskTask.this.cSx = 0;
                            AddNativeDownloadTaskTask.a(AddNativeDownloadTaskTask.this);
                        } else if (iVar2.dBY.dCa > 0) {
                            new HashMap().put("download_id", Long.valueOf(iVar2.dBY.dCa));
                            AddNativeDownloadTaskTask.this.dCa = iVar2.dBY.dCa;
                            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", Long.valueOf(AddNativeDownloadTaskTask.this.dCa));
                            AddNativeDownloadTaskTask.this.cSx = 2;
                            AddNativeDownloadTaskTask.b(AddNativeDownloadTaskTask.this);
                        } else {
                            Log.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                            AddNativeDownloadTaskTask.this.cSx = 1;
                            AddNativeDownloadTaskTask.c(AddNativeDownloadTaskTask.this);
                        }
                        EventCenter.instance.removeListener(AddNativeDownloadTaskTask.this.lyu);
                        AppMethodBeat.o(45439);
                        return true;
                    }
                }
            };
            EventCenter.instance.add(this.lyu);
            AppMethodBeat.o(45441);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45442);
            if (this.lyv != null) {
                this.lyv.run();
            }
            AppMethodBeat.o(45442);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45443);
            this.cSx = parcel.readInt();
            this.dCa = parcel.readLong();
            AppMethodBeat.o(45443);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45444);
            parcel.writeInt(this.cSx);
            parcel.writeLong(this.dCa);
            AppMethodBeat.o(45444);
        }

        static {
            AppMethodBeat.i(45448);
            AppMethodBeat.o(45448);
        }
    }
}
