package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.c;
import com.tencent.mm.i.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN extends d {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46598);
        final Context context = fVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46598);
        } else if (jSONObject == null) {
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(46598);
        } else {
            String appId = fVar.getAppId();
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", appId, jSONObject.toString());
            if (Util.isNullOrNil(optString)) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                fVar.i(i2, h("fail:tempFilePath is null", null));
                AppMethodBeat.o(46598);
                return;
            }
            final AppBrandLocalMediaObject av = AppBrandLocalMediaObjectManager.av(appId, optString);
            if (av == null) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                fVar.i(i2, h("fail:file doesn't exist", null));
                AppMethodBeat.o(46598);
            } else if (TextUtils.isEmpty(av.iGf)) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                fVar.i(i2, h("fail:fileFullPath is null", null));
                AppMethodBeat.o(46598);
            } else {
                final JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = appId;
                jsApiUploadEncryptedMediaFileTask.dJX = optString;
                jsApiUploadEncryptedMediaFileTask.meg = optBoolean;
                jsApiUploadEncryptedMediaFileTask.mek = (Activity) context;
                jsApiUploadEncryptedMediaFileTask.lAx = fVar;
                jsApiUploadEncryptedMediaFileTask.mimeType = av.mimeType;
                jsApiUploadEncryptedMediaFileTask.lyv = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(46580);
                        HashMap hashMap = new HashMap();
                        hashMap.put("fileId", jsApiUploadEncryptedMediaFileTask.fileId);
                        hashMap.put("aesKey", jsApiUploadEncryptedMediaFileTask.aesKey);
                        hashMap.put("fileUrl", jsApiUploadEncryptedMediaFileTask.fileUrl);
                        hashMap.put("fileLength", new StringBuilder().append(jsApiUploadEncryptedMediaFileTask.kKK).toString());
                        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", jsApiUploadEncryptedMediaFileTask.fileId);
                        if (Util.isNullOrNil(jsApiUploadEncryptedMediaFileTask.fileId)) {
                            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
                            fVar.i(i2, JsApiUploadEncryptedFileToCDN.this.h("fail", null));
                        } else {
                            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
                            fVar.i(i2, JsApiUploadEncryptedFileToCDN.this.n("ok", hashMap));
                        }
                        jsApiUploadEncryptedMediaFileTask.bDK();
                        AppMethodBeat.o(46580);
                    }
                };
                if (!ag.dm(context)) {
                    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                    final String sizeMB = Util.getSizeMB((long) ((int) s.boW(av.iGf)));
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.AnonymousClass2 */

                        public final void run() {
                            String string;
                            AppMethodBeat.i(226906);
                            if (TextUtils.isEmpty(av.mimeType) || !av.mimeType.contains("video")) {
                                string = context.getString(R.string.a1n);
                            } else {
                                string = context.getString(R.string.a1t);
                            }
                            h.a(context, context.getString(R.string.a1p, string, sizeMB), context.getString(R.string.zb), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.AnonymousClass2.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(226904);
                                    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                                    jsApiUploadEncryptedMediaFileTask.bDJ();
                                    AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                                    AppMethodBeat.o(226904);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.AnonymousClass2.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(226905);
                                    Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                                    fVar.i(i2, JsApiUploadEncryptedFileToCDN.this.h("cancel", null));
                                    jsApiUploadEncryptedMediaFileTask.bDK();
                                    AppMethodBeat.o(226905);
                                }
                            });
                            AppMethodBeat.o(226906);
                        }
                    });
                    AppMethodBeat.o(46598);
                    return;
                }
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                jsApiUploadEncryptedMediaFileTask.bDJ();
                AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                AppMethodBeat.o(46598);
            }
        }
    }

    static final class a extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = 196;
        private static final String NAME = "onUploadEncryptedFileToCDNProgress";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static class JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
        public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR = new Parcelable.Creator<JsApiUploadEncryptedMediaFileTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ JsApiUploadEncryptedMediaFileTask[] newArray(int i2) {
                return new JsApiUploadEncryptedMediaFileTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ JsApiUploadEncryptedMediaFileTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46589);
                JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask(parcel);
                AppMethodBeat.o(46589);
                return jsApiUploadEncryptedMediaFileTask;
            }
        };
        public String aesKey;
        public String appId;
        public String dJX;
        public String fileId;
        public String fileUrl;
        private ProgressDialog gtM = null;
        public int kKK;
        f lAx;
        public Runnable lyv;
        public boolean meg;
        public int meh = 0;
        public int mei = 0;
        public int mej = 0;
        Activity mek;
        d.a mel;
        d.b mem;
        public String mimeType;

        static /* synthetic */ boolean a(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.i(46595);
            boolean bDU = jsApiUploadEncryptedMediaFileTask.bDU();
            AppMethodBeat.o(46595);
            return bDU;
        }

        static /* synthetic */ boolean b(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.i(46596);
            boolean bDU = jsApiUploadEncryptedMediaFileTask.bDU();
            AppMethodBeat.o(46596);
            return bDU;
        }

        public JsApiUploadEncryptedMediaFileTask() {
        }

        public JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
            AppMethodBeat.i(46590);
            f(parcel);
            AppMethodBeat.o(46590);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean f2;
            AppMethodBeat.i(46591);
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", Integer.valueOf(this.mei), Integer.valueOf(this.mej));
            if (this.mei == 1) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
                n.buO().a(this.mel);
                n.buO().a(this.mem);
                n.buO();
                b.WG(this.dJX);
                this.mei = 0;
                this.mej = 1;
                bDU();
                AppMethodBeat.o(46591);
                return;
            }
            final AppBrandLocalMediaObject av = AppBrandLocalMediaObjectManager.av(this.appId, this.dJX);
            if (av == null) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
                this.mej = 1;
                bDU();
                AppMethodBeat.o(46591);
                return;
            }
            com.tencent.mm.plugin.appbrand.b.a aVar = new com.tencent.mm.plugin.appbrand.b.a();
            aVar.dJX = av.dJX;
            aVar.laR = av.iGf;
            aVar.jPY = av.jPY;
            String str = this.dJX;
            aVar.mediaId = c.a("appbrandmediafile", Util.nowMilliSecond(), str, str);
            n.buN().a(aVar);
            this.mel = new d.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.b.d.a
                public final void ac(int i2, String str) {
                    AppMethodBeat.i(46583);
                    Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", Integer.valueOf(i2), str);
                    JsApiUploadEncryptedMediaFileTask.this.meh = i2;
                    JsApiUploadEncryptedMediaFileTask.this.mej = 3;
                    JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedMediaFileTask.this);
                    AppMethodBeat.o(46583);
                }
            };
            this.mem = new d.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.b.d.b
                public final void b(boolean z, String str, String str2, String str3) {
                    com.tencent.mm.plugin.appbrand.b.a next;
                    AppMethodBeat.i(46584);
                    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                    if (!Util.isNullOrNil(str) && str.equals(av.dJX)) {
                        n.buO().a(JsApiUploadEncryptedMediaFileTask.this.mel);
                        n.buO().a(JsApiUploadEncryptedMediaFileTask.this.mem);
                        n.buO();
                        b.WG(av.dJX);
                        if (!z) {
                            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
                        } else {
                            JsApiUploadEncryptedMediaFileTask.this.fileId = str2;
                            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
                        }
                        com.tencent.mm.plugin.appbrand.b.c buN = n.buN();
                        String str4 = JsApiUploadEncryptedMediaFileTask.this.fileId;
                        if (Util.isNullOrNil(str4)) {
                            Log.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
                        } else {
                            Iterator<com.tencent.mm.plugin.appbrand.b.a> it = buN.lbc.values().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                next = it.next();
                                if (Util.nullAsNil(next.laS).equals(str4)) {
                                    break;
                                }
                            }
                            if (next != null || next.laT == null) {
                                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
                            } else {
                                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                                JsApiUploadEncryptedMediaFileTask.this.aesKey = next.laT.field_aesKey;
                                JsApiUploadEncryptedMediaFileTask.this.fileId = next.laT.field_fileId;
                                JsApiUploadEncryptedMediaFileTask.this.fileUrl = next.laT.field_fileUrl;
                                JsApiUploadEncryptedMediaFileTask.this.kKK = next.laT.field_fileLength;
                                Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", JsApiUploadEncryptedMediaFileTask.this.aesKey, Integer.valueOf(JsApiUploadEncryptedMediaFileTask.this.kKK));
                            }
                            JsApiUploadEncryptedMediaFileTask.this.mej = 1;
                            JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedMediaFileTask.this);
                        }
                        next = null;
                        if (next != null) {
                        }
                        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
                        JsApiUploadEncryptedMediaFileTask.this.mej = 1;
                        JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedMediaFileTask.this);
                    }
                    AppMethodBeat.o(46584);
                }
            };
            b buO = n.buO();
            d.a aVar2 = this.mel;
            if (!(buO.laY == null || aVar2 == null || buO.laY.contains(aVar2))) {
                buO.laY.add(aVar2);
            }
            b buO2 = n.buO();
            String str2 = this.appId;
            String str3 = av.dJX;
            int i2 = com.tencent.mm.i.a.gpS;
            d.b bVar = this.mem;
            com.tencent.mm.plugin.appbrand.b.a WH = n.buN().WH(str3);
            if (WH == null) {
                Log.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str3);
                f2 = false;
            } else {
                WH.appId = str2;
                if (!(bVar == null || buO2.laX == null || bVar == null || buO2.laX.contains(bVar))) {
                    buO2.laX.add(bVar);
                }
                WH.laU = true;
                g gVar = new g();
                gVar.taskName = "task_AppbrandCdnService_1";
                gVar.gqy = buO2.iZc;
                gVar.ehd = true;
                gVar.field_mediaId = WH.mediaId;
                gVar.field_fullpath = WH.laR;
                gVar.field_fileType = i2;
                gVar.field_talker = "weixin";
                gVar.field_priority = com.tencent.mm.i.a.gpM;
                if (i2 == com.tencent.mm.i.a.gpS) {
                    gVar.field_needStorage = true;
                } else {
                    gVar.field_needStorage = false;
                }
                gVar.field_isStreamMedia = false;
                gVar.field_appType = 0;
                gVar.field_bzScene = 0;
                gVar.field_force_aeskeycdn = true;
                gVar.field_trysafecdn = false;
                f2 = com.tencent.mm.an.f.baQ().f(gVar);
                Log.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(f2), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), str3);
            }
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", Boolean.valueOf(f2));
            if (!f2) {
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
                this.mej = 1;
                n.buO().a(this.mel);
                n.buO().a(this.mem);
                n.buO();
                b.WG(av.dJX);
                bDU();
                AppMethodBeat.o(46591);
                return;
            }
            if (this.meg) {
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
                this.mej = 2;
                bDU();
            }
            AppMethodBeat.o(46591);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(46592);
            if (this.mej == 0) {
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
                AppMethodBeat.o(46592);
                return;
            }
            if (this.mej == 1) {
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (this.lyv != null) {
                    this.lyv.run();
                    AppMethodBeat.o(46592);
                    return;
                }
            } else if (this.mej == 2) {
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
                Activity activity = this.mek;
                this.mek.getString(R.string.zb);
                this.gtM = h.a((Context) activity, this.mek.getString(R.string.a1s), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(46585);
                        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
                        dialogInterface.dismiss();
                        JsApiUploadEncryptedMediaFileTask.this.mei = 1;
                        JsApiUploadEncryptedMediaFileTask.this.mej = 1;
                        AppBrandMainProcessService.a(JsApiUploadEncryptedMediaFileTask.this);
                        AppMethodBeat.o(46585);
                    }
                });
                this.gtM.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass4 */

                    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        String string;
                        AppMethodBeat.i(46588);
                        if (i2 == 4 && keyEvent.getAction() == 1) {
                            if (TextUtils.isEmpty(JsApiUploadEncryptedMediaFileTask.this.mimeType) || !JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video")) {
                                string = JsApiUploadEncryptedMediaFileTask.this.mek.getString(R.string.a1n);
                            } else {
                                string = JsApiUploadEncryptedMediaFileTask.this.mek.getString(R.string.a1t);
                            }
                            h.a((Context) JsApiUploadEncryptedMediaFileTask.this.mek, true, JsApiUploadEncryptedMediaFileTask.this.mek.getString(R.string.a1o, new Object[]{string}), "", JsApiUploadEncryptedMediaFileTask.this.mek.getString(R.string.a1q), JsApiUploadEncryptedMediaFileTask.this.mek.getString(R.string.a1r), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(46586);
                                    Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                                    JsApiUploadEncryptedMediaFileTask.this.gtM.cancel();
                                    JsApiUploadEncryptedMediaFileTask.this.mei = 1;
                                    JsApiUploadEncryptedMediaFileTask.this.mej = 1;
                                    AppBrandMainProcessService.a(JsApiUploadEncryptedMediaFileTask.this);
                                    AppMethodBeat.o(46586);
                                }
                            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.AnonymousClass4.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(46587);
                                    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
                                    AppMethodBeat.o(46587);
                                }
                            });
                            AppMethodBeat.o(46588);
                            return true;
                        }
                        AppMethodBeat.o(46588);
                        return false;
                    }
                });
                AppMethodBeat.o(46592);
                return;
            } else if (this.mej == 3) {
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", this.dJX);
                hashMap.put("percent", Integer.valueOf(this.meh));
                new a((byte) 0).g(this.lAx).Zg(new JSONObject(hashMap).toString()).bEo();
            }
            AppMethodBeat.o(46592);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(46593);
            this.appId = parcel.readString();
            this.dJX = parcel.readString();
            this.fileId = parcel.readString();
            this.aesKey = parcel.readString();
            this.fileUrl = parcel.readString();
            this.kKK = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.meg = z;
            this.meh = parcel.readInt();
            this.mej = parcel.readInt();
            this.mei = parcel.readInt();
            this.mimeType = parcel.readString();
            AppMethodBeat.o(46593);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46594);
            parcel.writeString(this.appId);
            parcel.writeString(this.dJX);
            parcel.writeString(this.fileId);
            parcel.writeString(this.aesKey);
            parcel.writeString(this.fileUrl);
            parcel.writeInt(this.kKK);
            parcel.writeInt(this.meg ? 1 : 0);
            parcel.writeInt(this.meh);
            parcel.writeInt(this.mej);
            parcel.writeInt(this.mei);
            parcel.writeString(this.mimeType);
            AppMethodBeat.o(46594);
        }

        static {
            AppMethodBeat.i(46597);
            AppMethodBeat.o(46597);
        }
    }
}
