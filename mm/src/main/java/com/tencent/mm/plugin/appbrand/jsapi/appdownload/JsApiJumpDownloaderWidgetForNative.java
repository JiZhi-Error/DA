package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import org.json.JSONObject;

public final class JsApiJumpDownloaderWidgetForNative extends d<s> {
    public static final int CTRL_INDEX = 671;
    public static final String NAME = "jumpDownloaderWidgetForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45833);
        final s sVar2 = sVar;
        String optString = jSONObject.optString("appId");
        JumpDownloadWidgetRequest jumpDownloadWidgetRequest = new JumpDownloadWidgetRequest();
        jumpDownloadWidgetRequest.appId = optString;
        com.tencent.mm.plugin.appbrand.ipc.a.a(sVar2.ay(Activity.class), jumpDownloadWidgetRequest, new AppBrandProxyUIProcessTask.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
            public final void a(AppBrandProxyUIProcessTask.ProcessResult processResult) {
                AppMethodBeat.i(45824);
                sVar2.i(i2, JsApiJumpDownloaderWidgetForNative.this.h("ok", null));
                AppMethodBeat.o(45824);
            }
        });
        AppMethodBeat.o(45833);
    }

    static class JumpDownloadWidgetRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<JumpDownloadWidgetRequest> CREATOR = new Parcelable.Creator<JumpDownloadWidgetRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative.JumpDownloadWidgetRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ JumpDownloadWidgetRequest[] newArray(int i2) {
                return new JumpDownloadWidgetRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ JumpDownloadWidgetRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45825);
                JumpDownloadWidgetRequest jumpDownloadWidgetRequest = new JumpDownloadWidgetRequest(parcel);
                AppMethodBeat.o(45825);
                return jumpDownloadWidgetRequest;
            }
        };
        public String appId;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            AppMethodBeat.i(45826);
            this.appId = parcel.readString();
            AppMethodBeat.o(45826);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45827);
            parcel.writeString(this.appId);
            AppMethodBeat.o(45827);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDN() {
            return true;
        }

        JumpDownloadWidgetRequest() {
        }

        JumpDownloadWidgetRequest(Parcel parcel) {
            AppMethodBeat.i(45828);
            k(parcel);
            AppMethodBeat.o(45828);
        }

        static {
            AppMethodBeat.i(45829);
            AppMethodBeat.o(45829);
        }
    }

    static class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(45832);
            aVar.b(null);
            AppMethodBeat.o(45832);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            AppMethodBeat.i(45831);
            String str = processRequest != null ? ((JumpDownloadWidgetRequest) processRequest).appId : null;
            Intent intent = new Intent();
            intent.putExtra("appId", str);
            intent.putExtra("view_task", true);
            ((c) g.af(c.class)).a(bDF(), intent, new a.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.downloader_app.api.a.c
                public final void bEx() {
                    AppMethodBeat.i(45830);
                    a.a(a.this);
                    AppMethodBeat.o(45830);
                }
            });
            AppMethodBeat.o(45831);
        }
    }
}
