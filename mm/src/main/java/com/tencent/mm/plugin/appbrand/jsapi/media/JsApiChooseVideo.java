package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo extends d {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean mdp = false;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        boolean z;
        AppMethodBeat.i(46571);
        if (mdp) {
            fVar.i(i2, h("cancel", null));
            AppMethodBeat.o(46571);
            return;
        }
        Context context = fVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46571);
            return;
        }
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        String optString = jSONObject.optString("maxDuration");
        Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", optJSONArray, optString);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.mch = true;
            chooseRequest.mci = true;
        } else {
            chooseRequest.mch = optJSONArray.toString().contains("camera");
            chooseRequest.mci = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        chooseRequest.mdr = jSONObject.optBoolean("compressed", true);
        if (chooseRequest.mch) {
            r.a(fVar.getAppId(), new a.AbstractC0015a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.AnonymousClass3 */

                @Override // android.support.v4.app.a.AbstractC0015a
                public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(46546);
                    if (i2 != 115) {
                        AppMethodBeat.o(46546);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        fVar.i(i2, JsApiChooseVideo.this.h("fail:system permission denied", null));
                        AppMethodBeat.o(46546);
                    } else {
                        JsApiChooseVideo.this.a(fVar, jSONObject, i2);
                        AppMethodBeat.o(46546);
                    }
                }
            });
            Context context2 = fVar.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                fVar.i(i2, h("fail", null));
                z = false;
            } else {
                z = b.a((Activity) context2, "android.permission.CAMERA", 115, "", "");
                if (z) {
                    r.aeq(fVar.getAppId());
                }
            }
            if (!z) {
                AppMethodBeat.o(46571);
                return;
            }
        }
        mdp = true;
        h.a(fVar.getAppId(), new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(46544);
                boolean unused = JsApiChooseVideo.mdp = false;
                h.b(fVar.getAppId(), this);
                AppMethodBeat.o(46544);
            }
        });
        chooseRequest.maxDuration = Util.getInt(optString, 60);
        chooseRequest.appId = fVar.getAppId();
        com.tencent.mm.plugin.appbrand.ipc.a.b(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
            public final /* synthetic */ void a(ChooseResult chooseResult) {
                AppMethodBeat.i(46545);
                ChooseResult chooseResult2 = chooseResult;
                if (chooseResult2 != null) {
                    switch (chooseResult2.resultCode) {
                        case 0:
                            fVar.i(i2, JsApiChooseVideo.this.h("cancel", null));
                            AppMethodBeat.o(46545);
                            return;
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult2.mds;
                            if (appBrandLocalVideoObject == null) {
                                Log.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            } else {
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempFilePath", appBrandLocalVideoObject.dJX);
                                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                                hashMap.put("size", Long.valueOf(appBrandLocalVideoObject.size));
                                hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                                hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                                fVar.i(i2, JsApiChooseVideo.this.n("ok", hashMap));
                                AppMethodBeat.o(46545);
                                return;
                            }
                    }
                }
                fVar.i(i2, JsApiChooseVideo.this.h("fail", null));
                AppMethodBeat.o(46545);
            }
        });
        AppMethodBeat.o(46571);
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private q gxX;
        private String mcN;
        private DialogInterface.OnCancelListener mcu;
        private ChooseResult mdt = new ChooseResult();
        private ChooseRequest mdu;

        private a() {
            AppMethodBeat.i(46560);
            AppMethodBeat.o(46560);
        }

        static /* synthetic */ AppBrandLocalVideoObject a(a aVar, String str, boolean z) {
            AppMethodBeat.i(46567);
            AppBrandLocalVideoObject as = aVar.as(str, z);
            AppMethodBeat.o(46567);
            return as;
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46566);
            aVar.b(processResult);
            AppMethodBeat.o(46566);
        }

        static /* synthetic */ void b(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46568);
            aVar.b(processResult);
            AppMethodBeat.o(46568);
        }

        static /* synthetic */ void c(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46569);
            aVar.b(processResult);
            AppMethodBeat.o(46569);
        }

        static /* synthetic */ void d(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46570);
            aVar.b(processResult);
            AppMethodBeat.o(46570);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            boolean z;
            AppMethodBeat.i(46561);
            this.mdu = (ChooseRequest) processRequest;
            this.mdu.maxDuration = Math.min(Math.max(this.mdu.maxDuration, 60), 0);
            if (Util.getAvailableMemoryMB(bDF()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                u.makeText(bDF(), MMApplicationContext.getResources().getString(R.string.jj), 1).show();
            }
            bDF().mmSetOnActivityResultCallback(this);
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            intent.putExtra("GalleryUI_SkipVideoSizeLimit", true);
            intent.putExtra("gallery_report_tag", 16);
            if (this.mdu.mch && this.mdu.mci) {
                this.mcN = s.k(com.tencent.mm.loader.j.b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.mdu.maxDuration);
                intent.putExtra("video_full_path", this.mcN);
                com.tencent.mm.pluginsdk.ui.tools.s.e(bDF(), 1, 7, intent);
                AppMethodBeat.o(46561);
            } else if (this.mdu.mch) {
                this.mcN = s.k(com.tencent.mm.loader.j.b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
                com.tencent.mm.pluginsdk.ui.tools.s.a((Activity) bDF(), this.mcN, 5, this.mdu.maxDuration, 1, false);
                AppMethodBeat.o(46561);
            } else if (this.mdu.mci) {
                intent.putExtra("show_header_view", false);
                com.tencent.mm.pluginsdk.ui.tools.s.e(bDF(), 1, 16, intent);
                AppMethodBeat.o(46561);
            } else {
                this.mdt.resultCode = -2;
                b(this.mdt);
                AppMethodBeat.o(46561);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void bDM() {
            AppMethodBeat.i(46562);
            super.bDM();
            if (this.gxX != null) {
                this.gxX.dismiss();
                this.gxX = null;
            }
            AppMethodBeat.o(46562);
        }

        private void bHv() {
            AppMethodBeat.i(46563);
            this.mcu = new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46557);
                    a.this.mdt.resultCode = 0;
                    a.a(a.this, a.this.mdt);
                    AppMethodBeat.o(46557);
                }
            };
            MMActivity bDF = bDF();
            MMApplicationContext.getResources().getString(R.string.zb);
            this.gxX = com.tencent.mm.ui.base.h.a((Context) bDF, MMApplicationContext.getResources().getString(R.string.jj), true, this.mcu);
            AppMethodBeat.o(46563);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask, com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(46564);
            if (i3 == 0) {
                this.mdt.resultCode = 0;
                b(this.mdt);
                AppMethodBeat.o(46564);
            } else if (-1 != i3) {
                this.mdt.resultCode = -2;
                b(this.mdt);
                AppMethodBeat.o(46564);
            } else {
                switch (i2) {
                    case 4:
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!Util.isNullOrNil(stringArrayListExtra)) {
                            final String k = s.k(stringArrayListExtra.get(0), false);
                            bHv();
                            com.tencent.mm.plugin.appbrand.utils.f.bZn().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(46559);
                                    a.this.mdt.resultCode = -1;
                                    a.this.mdt.mds = a.a(a.this, k, a.this.mdu.mdr);
                                    a.d(a.this, a.this.mdt);
                                    AppMethodBeat.o(46559);
                                }
                            });
                            AppMethodBeat.o(46564);
                            return;
                        }
                        break;
                    case 5:
                        if (!Util.isNullOrNil(this.mcN)) {
                            bHv();
                            com.tencent.mm.plugin.appbrand.utils.f.bZn().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(46558);
                                    if (new o(a.this.mcN).exists()) {
                                        a.this.mdt.resultCode = -1;
                                        a.this.mdt.mds = a.a(a.this, a.this.mcN, a.this.mdu.mdr);
                                        a.b(a.this, a.this.mdt);
                                        AppMethodBeat.o(46558);
                                        return;
                                    }
                                    a.this.mdt.resultCode = -2;
                                    a.c(a.this, a.this.mdt);
                                    AppMethodBeat.o(46558);
                                }
                            });
                            AppMethodBeat.o(46564);
                            return;
                        }
                        break;
                }
                this.mdt.resultCode = -2;
                b(this.mdt);
                AppMethodBeat.o(46564);
            }
        }

        private AppBrandLocalVideoObject as(String str, boolean z) {
            com.tencent.mm.compatible.i.d dVar;
            int i2;
            int i3;
            AppMethodBeat.i(46565);
            if (z) {
                try {
                    str = t.aaf(str);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", Util.stackTraceToString(e2));
                }
            }
            try {
                com.tencent.mm.compatible.i.d dVar2 = new com.tencent.mm.compatible.i.d();
                dVar2.setDataSource(str);
                dVar = dVar2;
            } catch (Exception e3) {
                Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e3);
                dVar = null;
            }
            if (dVar == null) {
                Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                AppMethodBeat.o(46565);
                return null;
            }
            int i4 = Util.getInt(dVar.extractMetadata(24), 0);
            if (i4 == 90 || i4 == 270) {
                i2 = Util.getInt(dVar.extractMetadata(19), 0);
                i3 = Util.getInt(dVar.extractMetadata(18), 0);
            } else {
                i2 = Util.getInt(dVar.extractMetadata(18), 0);
                i3 = Util.getInt(dVar.extractMetadata(19), 0);
            }
            int i5 = Util.getInt(dVar.extractMetadata(9), 0);
            dVar.release();
            AppBrandLocalVideoObject O = AppBrandLocalMediaObjectManager.O(this.mdu.appId, str);
            if (O == null) {
                AppMethodBeat.o(46565);
                return null;
            }
            O.duration = (i5 + 500) / 1000;
            O.width = i2;
            O.height = i3;
            O.size = s.boW(str);
            Log.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", O);
            AppMethodBeat.o(46565);
            return O;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<ChooseRequest> CREATOR = new Parcelable.Creator<ChooseRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseRequest[] newArray(int i2) {
                return new ChooseRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46547);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(46547);
                return chooseRequest;
            }
        };
        String appId;
        int maxDuration;
        boolean mch;
        boolean mci;
        boolean mdr;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final String bDO() {
            return "GalleryChooseVideo";
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(46548);
            this.appId = parcel.readString();
            this.maxDuration = parcel.readInt();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mch = z;
            if (parcel.readByte() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mci = z2;
            if (parcel.readByte() == 0) {
                z3 = false;
            }
            this.mdr = z3;
            AppMethodBeat.o(46548);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3;
            byte b4 = 1;
            AppMethodBeat.i(46549);
            parcel.writeString(this.appId);
            parcel.writeInt(this.maxDuration);
            if (this.mch) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (this.mci) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            parcel.writeByte(b3);
            if (!this.mdr) {
                b4 = 0;
            }
            parcel.writeByte(b4);
            AppMethodBeat.o(46549);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDN() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(46550);
            k(parcel);
            AppMethodBeat.o(46550);
        }

        static {
            AppMethodBeat.i(46551);
            AppMethodBeat.o(46551);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<ChooseResult> CREATOR = new Parcelable.Creator<ChooseResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseResult[] newArray(int i2) {
                return new ChooseResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46552);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(46552);
                return chooseResult;
            }
        };
        AppBrandLocalVideoObject mds;
        int resultCode;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(46553);
            this.resultCode = parcel.readInt();
            this.mds = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
            AppMethodBeat.o(46553);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46554);
            parcel.writeInt(this.resultCode);
            parcel.writeParcelable(this.mds, i2);
            AppMethodBeat.o(46554);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.i(46555);
            k(parcel);
            AppMethodBeat.o(46555);
        }

        static {
            AppMethodBeat.i(46556);
            AppMethodBeat.o(46556);
        }
    }
}
