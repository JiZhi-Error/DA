package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class JsApiChooseMedia extends d {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    private static volatile boolean mcD = false;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2;
        AppMethodBeat.i(46489);
        if (mcD) {
            Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            fVar.i(i2, h("cancel", null));
            AppMethodBeat.o(46489);
            return;
        }
        Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia %s", jSONObject);
        Context context = fVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            fVar.i(i2, h("fail:page context is null", null));
            AppMethodBeat.o(46489);
        } else if (jSONObject == null) {
            Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(46489);
        } else {
            Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str5 = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("sourceType").toString();
            }
            if (Util.isNullOrNil(str5)) {
                str = "camera|album";
            } else {
                str = str5;
            }
            String str6 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str6 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (Util.isNullOrNil(str6)) {
                str2 = "video|image";
            } else {
                str2 = str6;
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 60);
            if (min < 3 || min > 60) {
                fVar.i(i2, h("fail:error maxDuration", null));
                AppMethodBeat.o(46489);
                return;
            }
            String optString = jSONObject.optString("camera");
            if (Util.isNullOrNil(optString)) {
                str3 = "back";
            } else {
                str3 = optString;
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            String str7 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str7 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (Util.isNullOrNil(str7)) {
                str4 = "original|compressed";
            } else {
                str4 = str7;
            }
            Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", str, str2, Integer.valueOf(min), str3, Integer.valueOf(min2), str4);
            r.b(fVar.getAppId(), new a.AbstractC0015a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.AnonymousClass3 */

                @Override // android.support.v4.app.a.AbstractC0015a
                public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(46430);
                    if (i2 != 120) {
                        Log.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                        AppMethodBeat.o(46430);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        Log.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                        fVar.i(i2, JsApiChooseMedia.this.h("fail:system permission denied", null));
                        AppMethodBeat.o(46430);
                    } else {
                        Log.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                        JsApiChooseMedia.this.a(fVar, jSONObject, i2);
                        AppMethodBeat.o(46430);
                    }
                }
            });
            Context context2 = fVar.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                fVar.i(i2, h("fail", null));
                z = false;
            } else {
                z = b.a((Activity) context2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    r.aeq(fVar.getAppId());
                }
            }
            if (!z) {
                Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
                AppMethodBeat.o(46489);
                return;
            }
            r.b(fVar.getAppId(), new a.AbstractC0015a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.AnonymousClass4 */

                @Override // android.support.v4.app.a.AbstractC0015a
                public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(46431);
                    if (i2 != 119) {
                        Log.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                        AppMethodBeat.o(46431);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        Log.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                        fVar.i(i2, JsApiChooseMedia.this.h("fail:system permission denied", null));
                        AppMethodBeat.o(46431);
                    } else {
                        Log.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                        JsApiChooseMedia.this.a(fVar, jSONObject, i2);
                        AppMethodBeat.o(46431);
                    }
                }
            });
            Context context3 = fVar.getContext();
            if (context3 == null || !(context3 instanceof Activity)) {
                Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                fVar.i(i2, h("fail", null));
                z2 = false;
            } else {
                z2 = b.a((Activity) context3, "android.permission.CAMERA", 119, "", "");
                if (z2) {
                    r.aeq(fVar.getAppId());
                }
            }
            if (!z2) {
                Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                AppMethodBeat.o(46489);
                return;
            }
            Log.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
            mcD = true;
            h.a(fVar.getAppId(), new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onResume() {
                    AppMethodBeat.i(46428);
                    Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                    boolean unused = JsApiChooseMedia.mcD = false;
                    h.b(fVar.getAppId(), this);
                    AppMethodBeat.o(46428);
                }
            });
            ChooseRequest chooseRequest = new ChooseRequest();
            chooseRequest.appId = fVar.getAppId();
            chooseRequest.mcF = str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
            chooseRequest.mcG = str.contains("camera");
            chooseRequest.mcH = str2.contains("image");
            chooseRequest.mcI = str2.contains("video");
            chooseRequest.mcJ = str2.contains("mix");
            if (str3.contains("back") || !str3.contains("front")) {
                chooseRequest.isFront = false;
            } else {
                chooseRequest.isFront = true;
            }
            chooseRequest.maxDuration = min;
            chooseRequest.count = min2;
            chooseRequest.mcj = str4.contains("compressed");
            chooseRequest.mck = str4.contains("original");
            com.tencent.mm.plugin.appbrand.ipc.a.a(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
                @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                public final /* synthetic */ void a(ChooseResult chooseResult) {
                    JSONArray jSONArray;
                    AppMethodBeat.i(46429);
                    ChooseResult chooseResult2 = chooseResult;
                    boolean unused = JsApiChooseMedia.mcD = false;
                    if (chooseResult2 == null) {
                        Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                        fVar.i(i2, JsApiChooseMedia.this.h("fail", null));
                        AppMethodBeat.o(46429);
                        return;
                    }
                    switch (chooseResult2.resultCode) {
                        case -1:
                            String str = chooseResult2.type;
                            try {
                                jSONArray = new JSONArray(chooseResult2.mcK);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.JsApiChooseMedia", "parse:%s err", null);
                                jSONArray = null;
                            }
                            if (jSONArray == null) {
                                Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                fVar.i(i2, JsApiChooseMedia.this.h("fail", null));
                                AppMethodBeat.o(46429);
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", str);
                            hashMap.put("tempFiles", jSONArray);
                            Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", str, jSONArray);
                            fVar.i(i2, JsApiChooseMedia.this.n("ok", hashMap));
                            AppMethodBeat.o(46429);
                            return;
                        case 0:
                            Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                            fVar.i(i2, JsApiChooseMedia.this.h("fail:cancel", null));
                            AppMethodBeat.o(46429);
                            return;
                        default:
                            Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                            fVar.i(i2, JsApiChooseMedia.this.h("fail", null));
                            AppMethodBeat.o(46429);
                            return;
                    }
                }
            });
            AppMethodBeat.o(46489);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private q gxX;
        private ChooseResult mcL = new ChooseResult();
        private ChooseRequest mcM;
        private String mcN;
        private String mcO;
        private l mcP;
        int mcq;
        private DialogInterface.OnCancelListener mcu;

        private a() {
            AppMethodBeat.i(46453);
            AppMethodBeat.o(46453);
        }

        static /* synthetic */ AppBrandLocalVideoObject a(a aVar, String str, boolean z) {
            AppMethodBeat.i(226889);
            AppBrandLocalVideoObject as = aVar.as(str, z);
            AppMethodBeat.o(226889);
            return as;
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46466);
            aVar.b(processResult);
            AppMethodBeat.o(46466);
        }

        static /* synthetic */ MMActivity b(a aVar) {
            AppMethodBeat.i(46467);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(46467);
            return bDF;
        }

        static /* synthetic */ String b(String str, String str2, int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(226896);
            String a2 = a(str, str2, i2, i3, i4, j2);
            AppMethodBeat.o(226896);
            return a2;
        }

        static /* synthetic */ void b(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46471);
            aVar.b(processResult);
            AppMethodBeat.o(46471);
        }

        static /* synthetic */ void b(JSONStringer jSONStringer, String str, String str2, int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(226892);
            a(jSONStringer, str, str2, i2, i3, i4, j2);
            AppMethodBeat.o(226892);
        }

        static /* synthetic */ void b(JSONStringer jSONStringer, ArrayList arrayList, ArrayList arrayList2) {
            AppMethodBeat.i(226893);
            a(jSONStringer, arrayList, arrayList2);
            AppMethodBeat.o(226893);
        }

        static /* synthetic */ MMActivity c(a aVar) {
            AppMethodBeat.i(46468);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(46468);
            return bDF;
        }

        static /* synthetic */ String c(ArrayList arrayList, ArrayList arrayList2) {
            AppMethodBeat.i(226898);
            String b2 = b(arrayList, arrayList2);
            AppMethodBeat.o(226898);
            return b2;
        }

        static /* synthetic */ void c(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46477);
            aVar.b(processResult);
            AppMethodBeat.o(46477);
        }

        static /* synthetic */ void d(a aVar) {
            AppMethodBeat.i(46469);
            aVar.bHr();
            AppMethodBeat.o(46469);
        }

        static /* synthetic */ void d(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226894);
            aVar.b(processResult);
            AppMethodBeat.o(226894);
        }

        static /* synthetic */ void e(a aVar) {
            AppMethodBeat.i(46470);
            aVar.bHs();
            AppMethodBeat.o(46470);
        }

        static /* synthetic */ void e(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226895);
            aVar.b(processResult);
            AppMethodBeat.o(226895);
        }

        static /* synthetic */ void f(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226897);
            aVar.b(processResult);
            AppMethodBeat.o(226897);
        }

        static /* synthetic */ void g(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46482);
            aVar.b(processResult);
            AppMethodBeat.o(46482);
        }

        static /* synthetic */ void h(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46483);
            aVar.b(processResult);
            AppMethodBeat.o(46483);
        }

        static /* synthetic */ void i(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46484);
            aVar.b(processResult);
            AppMethodBeat.o(46484);
        }

        static /* synthetic */ void j(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46486);
            aVar.b(processResult);
            AppMethodBeat.o(46486);
        }

        static /* synthetic */ void k(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46487);
            aVar.b(processResult);
            AppMethodBeat.o(46487);
        }

        static /* synthetic */ void l(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46488);
            aVar.b(processResult);
            AppMethodBeat.o(46488);
        }

        static /* synthetic */ void m(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226899);
            aVar.b(processResult);
            AppMethodBeat.o(226899);
        }

        static /* synthetic */ void n(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226900);
            aVar.b(processResult);
            AppMethodBeat.o(226900);
        }

        static /* synthetic */ void o(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226901);
            aVar.b(processResult);
            AppMethodBeat.o(226901);
        }

        static /* synthetic */ void p(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226902);
            aVar.b(processResult);
            AppMethodBeat.o(226902);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            boolean z;
            AppMethodBeat.i(46454);
            this.mcM = (ChooseRequest) processRequest;
            this.mcq = 16;
            if (Util.getAvailableMemoryMB(bDF()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Log.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
                u.makeText(bDF(), MMApplicationContext.getResources().getString(R.string.jh), 1).show();
            }
            Log.i("MicroMsg.JsApiChooseMedia", "goVideo");
            bDF().mmSetOnActivityResultCallback(this);
            if (this.mcM.mcF && this.mcM.mcG) {
                this.mcP = new l(bDF());
                this.mcP.a(new e.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(160599);
                        Log.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
                        a.this.mcL.resultCode = 0;
                        a.a(a.this, a.this.mcL);
                        AppMethodBeat.o(160599);
                    }
                });
                this.mcP.a(null, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass3 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(46443);
                        contextMenu.add(0, 1, 0, a.b(a.this).getString(R.string.um));
                        contextMenu.add(0, 2, 1, a.c(a.this).getString(R.string.uv));
                        AppMethodBeat.o(46443);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(46444);
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.d(a.this);
                                AppMethodBeat.o(46444);
                                return;
                            case 2:
                                a.e(a.this);
                                break;
                        }
                        AppMethodBeat.o(46444);
                    }
                }, new e.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(46445);
                        Log.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
                        a.this.mcL.resultCode = 0;
                        a.b(a.this, a.this.mcL);
                        AppMethodBeat.o(46445);
                    }
                });
                AppMethodBeat.o(46454);
            } else if (this.mcM.mcF) {
                bHs();
                AppMethodBeat.o(46454);
            } else if (this.mcM.mcG) {
                bHr();
                AppMethodBeat.o(46454);
            } else {
                this.mcL.resultCode = -2;
                Log.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
                b(this.mcL);
                AppMethodBeat.o(46454);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void bDM() {
            AppMethodBeat.i(46455);
            super.bDM();
            if (this.gxX != null) {
                this.gxX.dismiss();
                this.gxX = null;
            }
            if (this.mcP != null) {
                this.mcP.dismiss();
                this.mcP = null;
            }
            AppMethodBeat.o(46455);
        }

        private void bHr() {
            int i2 = 0;
            AppMethodBeat.i(46456);
            Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
            if (!this.mcM.mcI || !this.mcM.mcH) {
                if (this.mcM.mcI) {
                    i2 = 1;
                } else if (this.mcM.mcH) {
                    i2 = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KEY_SIGHT_PARAMS", xi(i2));
            s.a(bDF(), 7, intent, 3, i2);
            AppMethodBeat.o(46456);
        }

        private SightParams xi(int i2) {
            int i3 = 1;
            AppMethodBeat.i(46457);
            String str = "microMsg." + System.currentTimeMillis() + ".jpg";
            this.mcN = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + "microMsg." + str + ".mp4", false);
            this.mcO = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + "microMsg." + str + ".jpeg", true);
            int i4 = this.mcM.maxDuration;
            SightParams sightParams = new SightParams(3, 1);
            if (!this.mcM.isFront) {
                i3 = 2;
            }
            sightParams.zsH = i3;
            sightParams.mode = i2;
            if (sightParams.irT == null) {
                sightParams.irT = new VideoTransPara();
            }
            sightParams.irT.duration = i4;
            sightParams.zsO = false;
            sightParams.v(str, this.mcN, this.mcO, com.tencent.mm.loader.j.b.aKV());
            AppMethodBeat.o(46457);
            return sightParams;
        }

        private void bHs() {
            boolean z;
            int i2 = 3;
            boolean z2 = true;
            AppMethodBeat.i(46458);
            Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
            boolean z3 = this.mcM.mck;
            if (!this.mcM.mcJ && (!this.mcM.mcH || !this.mcM.mcI)) {
                if (this.mcM.mcH) {
                    i2 = 1;
                } else if (this.mcM.mcI) {
                    i2 = 2;
                    z3 = false;
                }
            }
            Intent intent = new Intent();
            if (!this.mcM.mcJ) {
                intent.putExtra("key_can_select_video_and_pic", true);
            }
            if (!this.mcM.mcj) {
                z = true;
            } else {
                z = false;
            }
            intent.putExtra("key_send_raw_image", z);
            intent.putExtra("key_force_show_raw_image_button", z3);
            if (!this.mcM.mck || this.mcM.mcj) {
                z2 = false;
            }
            intent.putExtra("key_is_raw_image_button_disable", z2);
            intent.putExtra("gallery_report_tag", 16);
            intent.putExtra("album_video_max_duration", LocalCache.TIME_DAY);
            intent.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
            s.a(bDF(), 8, this.mcM.count, this.mcq, i2, intent);
            AppMethodBeat.o(46458);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask, com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(46459);
            if (i3 == 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
                this.mcL.resultCode = 0;
                b(this.mcL);
                AppMethodBeat.o(46459);
            } else if (-1 != i3) {
                Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
                this.mcL.resultCode = -2;
                b(this.mcL);
                AppMethodBeat.o(46459);
            } else {
                switch (i2) {
                    case 8:
                        Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                        if (this.mcM.mcJ) {
                            final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                            final ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            final boolean z3 = stringArrayListExtra != null && stringArrayListExtra.size() > 0;
                            final boolean z4 = stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0;
                            final boolean z5 = false;
                            boolean z6 = false;
                            if (z3) {
                                z6 = true;
                            }
                            if (z3 || z4) {
                                if (z4) {
                                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                                    if (((!this.mcM.mck) && this.mcM.mcj) || ((this.mcM.mcj & this.mcM.mck) && booleanExtra)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.FALSE, Boolean.valueOf(this.mcM.mcj), Boolean.valueOf(this.mcM.mck), Boolean.valueOf(booleanExtra), Boolean.valueOf(z2));
                                    z5 = z2;
                                }
                                if (z5) {
                                    z = true;
                                } else {
                                    z = z6;
                                }
                                if (z) {
                                    xh(R.string.ji);
                                }
                                final boolean z7 = !z5 && stringArrayListExtra2 != null && r.bD(stringArrayListExtra2);
                                if (z7) {
                                    xh(R.string.jj);
                                }
                                com.tencent.mm.plugin.appbrand.utils.f.bZn().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass6 */

                                    public final void run() {
                                        boolean z;
                                        AppMethodBeat.i(46446);
                                        a.this.mcL.resultCode = -2;
                                        JSONStringer jSONStringer = new JSONStringer();
                                        try {
                                            jSONStringer.array();
                                            if (z3) {
                                                Iterator it = stringArrayListExtra.iterator();
                                                while (it.hasNext()) {
                                                    String str = (String) it.next();
                                                    if (new com.tencent.mm.vfs.o(str).exists()) {
                                                        Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", str);
                                                        a.this.mcL.resultCode = -1;
                                                        a.this.mcL.type = "mix";
                                                        AppBrandLocalVideoObject a2 = a.a(a.this, str, a.this.mcM.mcj);
                                                        if (a2 == null) {
                                                            Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", str);
                                                        } else {
                                                            a.a(a.this, str);
                                                            a.b(jSONStringer, a2.dJX, a.g(a.this), a2.duration, a2.height, a2.width, a2.size);
                                                        }
                                                    } else {
                                                        Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", str);
                                                    }
                                                }
                                            }
                                            if (z4) {
                                                ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                                ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                                for (String str2 : stringArrayListExtra2) {
                                                    if (z5) {
                                                        String aah = r.aah(str2);
                                                        if (aah != null && !aah.equals(str2)) {
                                                            z = true;
                                                            str2 = aah;
                                                        }
                                                        z = false;
                                                    } else {
                                                        if (z7) {
                                                            String aai = r.aai(str2);
                                                            if (!aai.equals(str2)) {
                                                                z = true;
                                                                str2 = aai;
                                                            }
                                                        }
                                                        z = false;
                                                    }
                                                    AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(a.this.mcM.appId, str2, z);
                                                    if (h2 != null) {
                                                        arrayList.add(Long.valueOf(h2.jPY));
                                                        arrayList2.add(h2.dJX);
                                                    } else {
                                                        Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", str2);
                                                    }
                                                }
                                                if (arrayList2.size() == 0) {
                                                    Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                                } else {
                                                    Log.i("MicroMsg.JsApiChooseMedia", "handle images success");
                                                    a.this.mcL.resultCode = -1;
                                                    a.this.mcL.type = "mix";
                                                    a.b(jSONStringer, arrayList2, arrayList);
                                                }
                                            }
                                            jSONStringer.endArray();
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                                        }
                                        a.this.mcL.mcK = jSONStringer.toString();
                                        a.c(a.this, a.this.mcL);
                                        AppMethodBeat.o(46446);
                                    }
                                });
                                AppMethodBeat.o(46459);
                                return;
                            }
                            Log.e("MicroMsg.JsApiChooseMedia", "none select any image or video");
                            this.mcL.resultCode = -2;
                            b(this.mcL);
                            AppMethodBeat.o(46459);
                            return;
                        }
                        final ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("key_select_video_list");
                        if (stringArrayListExtra3 == null || stringArrayListExtra3.size() <= 0) {
                            final ArrayList<String> stringArrayListExtra4 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (stringArrayListExtra4 == null || stringArrayListExtra4.size() == 0) {
                                Log.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                                this.mcL.resultCode = -2;
                                b(this.mcL);
                                AppMethodBeat.o(46459);
                                return;
                            }
                            boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            final boolean z8 = ((!this.mcM.mck) && this.mcM.mcj) || ((this.mcM.mcj & this.mcM.mck) && booleanExtra2);
                            Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.FALSE, Boolean.valueOf(this.mcM.mcj), Boolean.valueOf(this.mcM.mck), Boolean.valueOf(booleanExtra2), Boolean.valueOf(z8));
                            if (z8) {
                                xh(R.string.ji);
                            }
                            final boolean z9 = !z8 && r.bD(stringArrayListExtra4);
                            if (z9) {
                                xh(R.string.jj);
                            }
                            m.bZn().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass8 */

                                public final void run() {
                                    boolean z;
                                    AppMethodBeat.i(46450);
                                    final ArrayList arrayList = new ArrayList(stringArrayListExtra4.size());
                                    final ArrayList arrayList2 = new ArrayList(stringArrayListExtra4.size());
                                    for (String str : stringArrayListExtra4) {
                                        if (z8) {
                                            String aah = r.aah(str);
                                            if (aah != null && !aah.equals(str)) {
                                                z = true;
                                                str = aah;
                                            }
                                            z = false;
                                        } else {
                                            if (z9) {
                                                String aai = r.aai(str);
                                                if (!aai.equals(str)) {
                                                    z = true;
                                                    str = aai;
                                                }
                                            }
                                            z = false;
                                        }
                                        AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(a.this.mcM.appId, str, z);
                                        if (h2 != null) {
                                            arrayList.add(Long.valueOf(h2.jPY));
                                            arrayList2.add(h2.dJX);
                                        } else {
                                            Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", str);
                                        }
                                    }
                                    if (arrayList2.size() == 0) {
                                        Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                        a.this.mcL.resultCode = -2;
                                        a.i(a.this, a.this.mcL);
                                        AppMethodBeat.o(46450);
                                        return;
                                    }
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass8.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(46449);
                                            Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                            a.this.mcL.resultCode = -1;
                                            a.this.mcL.type = "image";
                                            ChooseResult chooseResult = a.this.mcL;
                                            ArrayList arrayList = arrayList2;
                                            ArrayList arrayList2 = arrayList;
                                            ChooseRequest unused = a.this.mcM;
                                            chooseResult.mcK = a.c(arrayList, arrayList2);
                                            a.j(a.this, a.this.mcL);
                                            AppMethodBeat.o(46449);
                                        }
                                    });
                                    AppMethodBeat.o(46450);
                                }
                            });
                            AppMethodBeat.o(46459);
                            return;
                        }
                        xh(R.string.ji);
                        com.tencent.mm.plugin.appbrand.utils.f.bZn().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(46448);
                                if (stringArrayListExtra3.size() == 1) {
                                    a.this.mcN = com.tencent.mm.vfs.s.k((String) stringArrayListExtra3.get(0), false);
                                    if (Util.isNullOrNil(a.this.mcN)) {
                                        Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                                        a.this.mcL.resultCode = -2;
                                        a.d(a.this, a.this.mcL);
                                        AppMethodBeat.o(46448);
                                    } else if (new com.tencent.mm.vfs.o(a.this.mcN).exists()) {
                                        Log.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                                        a.this.mcL.resultCode = -1;
                                        a.this.mcL.type = "video";
                                        AppBrandLocalVideoObject a2 = a.a(a.this, a.this.mcN, a.this.mcM.mcj);
                                        if (a2 == null) {
                                            Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", a.this.mcN);
                                            a.this.mcL.resultCode = -2;
                                            a.e(a.this, a.this.mcL);
                                            AppMethodBeat.o(46448);
                                            return;
                                        }
                                        a.a(a.this, a.this.mcN);
                                        String g2 = a.g(a.this);
                                        a.this.mcL.mcK = a.b(a2.dJX, g2, a2.duration, a2.height, a2.width, a2.size);
                                        a.f(a.this, a.this.mcL);
                                        AppMethodBeat.o(46448);
                                    } else {
                                        Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", a.this.mcN);
                                        a.this.mcL.resultCode = -2;
                                        a.g(a.this, a.this.mcL);
                                        AppMethodBeat.o(46448);
                                    }
                                } else {
                                    if (stringArrayListExtra3.size() > 1) {
                                        a.this.mcL.resultCode = -2;
                                        JSONStringer jSONStringer = new JSONStringer();
                                        try {
                                            jSONStringer.array();
                                            Iterator it = stringArrayListExtra3.iterator();
                                            while (it.hasNext()) {
                                                String str = (String) it.next();
                                                if (new com.tencent.mm.vfs.o(str).exists()) {
                                                    Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", str);
                                                    a.this.mcL.resultCode = -1;
                                                    a.this.mcL.type = "video";
                                                    AppBrandLocalVideoObject a3 = a.a(a.this, str, a.this.mcM.mcj);
                                                    if (a3 == null) {
                                                        Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", str);
                                                    } else {
                                                        a.a(a.this, str);
                                                        a.b(jSONStringer, a3.dJX, a.g(a.this), a3.duration, a3.height, a3.width, a3.size);
                                                    }
                                                } else {
                                                    Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", str);
                                                }
                                            }
                                            jSONStringer.endArray();
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                                        }
                                        a.this.mcL.mcK = jSONStringer.toString();
                                        a.h(a.this, a.this.mcL);
                                    }
                                    AppMethodBeat.o(46448);
                                }
                            }
                        });
                        AppMethodBeat.o(46459);
                        return;
                    case 7:
                        Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                        if (intent == null) {
                            Log.e("MicroMsg.JsApiChooseMedia", "data is null!");
                            break;
                        } else {
                            Log.i("MicroMsg.JsApiChooseMedia", "data is valid!");
                            SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                            if (sightCaptureResult == null) {
                                Log.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                                this.mcL.resultCode = -2;
                                b(this.mcL);
                                AppMethodBeat.o(46459);
                                return;
                            } else if (sightCaptureResult.zsy) {
                                final String k = com.tencent.mm.vfs.s.k(sightCaptureResult.zsG, false);
                                if (Util.isNullOrNil(k)) {
                                    Log.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", k);
                                    this.mcL.resultCode = -2;
                                    b(this.mcL);
                                    AppMethodBeat.o(46459);
                                    return;
                                }
                                boolean booleanExtra3 = intent.getBooleanExtra("CropImage_Compress_Img", false);
                                final boolean z10 = ((!this.mcM.mck) && this.mcM.mcj) || ((this.mcM.mcj & this.mcM.mck) && booleanExtra3);
                                Log.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.TRUE, Boolean.valueOf(this.mcM.mcj), Boolean.valueOf(this.mcM.mck), Boolean.valueOf(booleanExtra3), Boolean.valueOf(z10));
                                if (z10) {
                                    xh(R.string.ji);
                                }
                                final boolean z11 = !z10 && r.aam(k);
                                if (z11) {
                                    xh(R.string.jj);
                                }
                                m.bZn().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass9 */

                                    public final void run() {
                                        AppMethodBeat.i(46451);
                                        String str = k;
                                        if (z10) {
                                            String aah = r.aah(str);
                                            if (aah == null || aah.equals(str)) {
                                                aah = str;
                                            }
                                            str = aah;
                                        } else if (z11) {
                                            String aai = r.aai(str);
                                            if (!aai.equals(str)) {
                                                str = aai;
                                            }
                                        }
                                        final ArrayList arrayList = new ArrayList();
                                        final ArrayList arrayList2 = new ArrayList();
                                        AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(a.this.mcM.appId, str, true);
                                        if (h2 != null) {
                                            arrayList.add(Long.valueOf(h2.jPY));
                                            arrayList2.add(h2.dJX);
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass9.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(226881);
                                                    Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                                    a.this.mcL.resultCode = -1;
                                                    if (a.this.mcM.mcJ) {
                                                        a.this.mcL.type = "mix";
                                                    } else {
                                                        a.this.mcL.type = "image";
                                                    }
                                                    ChooseResult chooseResult = a.this.mcL;
                                                    ArrayList arrayList = arrayList2;
                                                    ArrayList arrayList2 = arrayList;
                                                    ChooseRequest unused = a.this.mcM;
                                                    chooseResult.mcK = a.c(arrayList, arrayList2);
                                                    a.k(a.this, a.this.mcL);
                                                    AppMethodBeat.o(226881);
                                                }
                                            });
                                            AppMethodBeat.o(46451);
                                            return;
                                        }
                                        Log.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", k);
                                        a.this.mcL.resultCode = -2;
                                        a.l(a.this, a.this.mcL);
                                        AppMethodBeat.o(46451);
                                    }
                                });
                                AppMethodBeat.o(46459);
                                return;
                            } else {
                                this.mcN = com.tencent.mm.vfs.s.k(sightCaptureResult.zsA, false);
                                if (Util.isNullOrNil(this.mcN)) {
                                    Log.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                                    break;
                                } else {
                                    Log.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", this.mcN);
                                    if (!aad(this.mcO) && aad(sightCaptureResult.zsB)) {
                                        this.mcO = com.tencent.mm.vfs.s.k(sightCaptureResult.zsB, true);
                                    }
                                    xh(R.string.ji);
                                    m.bZn().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass10 */

                                        public final void run() {
                                            AppMethodBeat.i(226882);
                                            if (new com.tencent.mm.vfs.o(a.this.mcN).exists()) {
                                                Log.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                                                a.this.mcL.resultCode = -1;
                                                if (a.this.mcM.mcJ) {
                                                    a.this.mcL.type = "mix";
                                                } else {
                                                    a.this.mcL.type = "video";
                                                }
                                                AppBrandLocalVideoObject a2 = a.a(a.this, a.this.mcN, a.this.mcM.mcj);
                                                if (a2 == null) {
                                                    Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", a.this.mcN);
                                                    a.this.mcL.resultCode = -2;
                                                    a.m(a.this, a.this.mcL);
                                                    AppMethodBeat.o(226882);
                                                    return;
                                                }
                                                a.a(a.this, a.this.mcN);
                                                String g2 = a.g(a.this);
                                                a.this.mcL.mcK = a.b(a2.dJX, g2, a2.duration, a2.height, a2.width, a2.size);
                                                a.n(a.this, a.this.mcL);
                                                AppMethodBeat.o(226882);
                                                return;
                                            }
                                            Log.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", a.this.mcN);
                                            a.this.mcL.resultCode = -2;
                                            a.o(a.this, a.this.mcL);
                                            AppMethodBeat.o(226882);
                                        }
                                    });
                                    AppMethodBeat.o(46459);
                                    return;
                                }
                            }
                        }
                        break;
                }
                this.mcL.resultCode = -2;
                b(this.mcL);
                AppMethodBeat.o(46459);
            }
        }

        private void xh(int i2) {
            AppMethodBeat.i(226883);
            this.mcu = new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(226880);
                    Log.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
                    a.this.mcL.resultCode = 0;
                    a.p(a.this, a.this.mcL);
                    AppMethodBeat.o(226880);
                }
            };
            MMActivity bDF = bDF();
            MMApplicationContext.getResources().getString(R.string.zb);
            this.gxX = com.tencent.mm.ui.base.h.a((Context) bDF, MMApplicationContext.getResources().getString(i2), true, this.mcu);
            AppMethodBeat.o(226883);
        }

        private AppBrandLocalVideoObject as(String str, boolean z) {
            com.tencent.mm.compatible.i.d dVar;
            int i2;
            int i3;
            AppMethodBeat.i(226884);
            if (z) {
                try {
                    str = t.aaf(str);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", Util.stackTraceToString(e2));
                }
            }
            try {
                com.tencent.mm.compatible.i.d dVar2 = new com.tencent.mm.compatible.i.d();
                dVar2.setDataSource(str);
                dVar = dVar2;
            } catch (Exception e3) {
                Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e3);
                dVar = null;
            }
            if (dVar == null) {
                Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
                AppMethodBeat.o(226884);
                return null;
            }
            int i4 = Util.getInt(dVar.extractMetadata(18), 0);
            int i5 = Util.getInt(dVar.extractMetadata(19), 0);
            int i6 = Util.getInt(dVar.extractMetadata(9), 0);
            int i7 = Util.getInt(dVar.extractMetadata(24), 0);
            Log.i("MicroMsg.JsApiChooseMedia", "outputWidth:%d, outputHeight:%d, rotation:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i7));
            if (i7 == 90 || i7 == 270) {
                i3 = i4;
                i2 = i5;
            } else {
                i3 = i5;
                i2 = i4;
            }
            dVar.release();
            AppBrandLocalVideoObject O = AppBrandLocalMediaObjectManager.O(this.mcM.appId, str);
            if (O == null) {
                Log.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
                AppMethodBeat.o(226884);
                return null;
            }
            O.duration = (i6 + 500) / 1000;
            O.width = i2;
            O.height = i3;
            O.size = com.tencent.mm.vfs.s.boW(str);
            Log.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", O);
            AppMethodBeat.o(226884);
            return O;
        }

        private static boolean aad(String str) {
            AppMethodBeat.i(46463);
            if (!TextUtils.isEmpty(str)) {
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
                Log.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", str);
                if (oVar.exists()) {
                    Log.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
                    AppMethodBeat.o(46463);
                    return true;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
                AppMethodBeat.o(46463);
                return false;
            }
            Log.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
            AppMethodBeat.o(46463);
            return false;
        }

        private static String b(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.i(226885);
            if (arrayList == null || arrayList.size() == 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
                AppMethodBeat.o(226885);
                return "";
            }
            Log.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                a(jSONStringer, arrayList, arrayList2);
                jSONStringer.endArray();
                String jSONStringer2 = jSONStringer.toString();
                AppMethodBeat.o(226885);
                return jSONStringer2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                AppMethodBeat.o(226885);
                return "";
            }
        }

        private static void a(JSONStringer jSONStringer, ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.i(226886);
            if (arrayList == null || arrayList.size() == 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson localIds is null");
                AppMethodBeat.o(226886);
                return;
            }
            Log.i("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson()");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    jSONStringer.object();
                    jSONStringer.key("tempFilePath");
                    jSONStringer.value(arrayList.get(i2));
                    jSONStringer.key("size");
                    jSONStringer.value(String.valueOf(arrayList2.get(i2).longValue()));
                    jSONStringer.key("fileType");
                    jSONStringer.value("image");
                    jSONStringer.endObject();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                    AppMethodBeat.o(226886);
                    return;
                }
            }
            AppMethodBeat.o(226886);
        }

        private static String a(String str, String str2, int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(226887);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
                AppMethodBeat.o(226887);
                return "";
            }
            Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                a(jSONStringer, str, str2, i2, i3, i4, j2);
                jSONStringer.endArray();
                String jSONStringer2 = jSONStringer.toString();
                AppMethodBeat.o(226887);
                return jSONStringer2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                AppMethodBeat.o(226887);
                return "";
            }
        }

        private static void a(JSONStringer jSONStringer, String str, String str2, int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(226888);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
                AppMethodBeat.o(226888);
                return;
            }
            Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
            try {
                jSONStringer.object();
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("thumbTempFilePath");
                jSONStringer.value(str2);
                jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                jSONStringer.value(String.valueOf(i2));
                jSONStringer.key("height");
                jSONStringer.value(String.valueOf(i3));
                jSONStringer.key("width");
                jSONStringer.value(String.valueOf(i4));
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(j2));
                jSONStringer.key("fileType");
                jSONStringer.value("video");
                jSONStringer.endObject();
                AppMethodBeat.o(226888);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", e2, "", new Object[0]);
                AppMethodBeat.o(226888);
            }
        }

        static /* synthetic */ void a(a aVar, String str) {
            com.tencent.mm.vfs.o oVar;
            String str2 = null;
            AppMethodBeat.i(226890);
            if (!TextUtils.isEmpty(aVar.mcO)) {
                oVar = new com.tencent.mm.vfs.o(aVar.mcO);
            } else {
                Log.e("MicroMsg.JsApiChooseMedia", "mThumbFilePath is empty!");
                oVar = null;
            }
            if (oVar == null || !oVar.exists()) {
                Log.e("MicroMsg.JsApiChooseMedia", "file == null or file not exist for path:%s!", aVar.mcO);
                String name = new com.tencent.mm.vfs.o(str).getName();
                if (!TextUtils.isEmpty(name) && name.contains(".")) {
                    str2 = name.substring(0, name.lastIndexOf("."));
                }
                if (TextUtils.isEmpty(str2)) {
                    aVar.mcO = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + ("microMsg_" + System.currentTimeMillis()) + ".jpeg", true);
                } else if (com.tencent.mm.loader.j.b.aKV() == null || !com.tencent.mm.loader.j.b.aKV().endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    aVar.mcO = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + FilePathGenerator.ANDROID_DIR_SEP + str2 + ".jpeg", true);
                } else {
                    aVar.mcO = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + str2 + ".jpeg", true);
                }
                if (!new com.tencent.mm.vfs.o(aVar.mcO).exists()) {
                    Log.i("MicroMsg.JsApiChooseMedia", "file not exist for path:%s!", aVar.mcO);
                    Log.i("MicroMsg.JsApiChooseMedia", "create new thumb path:%s!", aVar.mcO);
                    Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(str, 1);
                    if (createVideoThumbnail == null) {
                        Log.e("MicroMsg.JsApiChooseMedia", "createVideoThumbnail bitmap fail for path:%s!", aVar.mcO);
                        AppMethodBeat.o(226890);
                        return;
                    }
                    try {
                        BitmapUtil.saveBitmapToImage(createVideoThumbnail, 30, Bitmap.CompressFormat.JPEG, aVar.mcO, true);
                        AppMethodBeat.o(226890);
                    } catch (IOException e2) {
                        Log.e("MicroMsg.JsApiChooseMedia", "saveBitmapToImage exist IOException:" + e2.getMessage());
                        AppMethodBeat.o(226890);
                    }
                } else {
                    Log.i("MicroMsg.JsApiChooseMedia", "file is exist for path:%s!", aVar.mcO);
                    AppMethodBeat.o(226890);
                }
            } else {
                Log.i("MicroMsg.JsApiChooseMedia", "file is exist!, path:%s", aVar.mcO);
                AppMethodBeat.o(226890);
            }
        }

        static /* synthetic */ String g(a aVar) {
            AppMethodBeat.i(226891);
            if (!TextUtils.isEmpty(aVar.mcO)) {
                AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(aVar.mcM.appId, aVar.mcO, true);
                if (h2 == null || Util.isNullOrNil(h2.dJX)) {
                    Log.e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
                } else {
                    String str = h2.dJX;
                    AppMethodBeat.o(226891);
                    return str;
                }
            }
            AppMethodBeat.o(226891);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<ChooseRequest> CREATOR = new Parcelable.Creator<ChooseRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseRequest[] newArray(int i2) {
                return new ChooseRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46432);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(46432);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        boolean isFront;
        int maxDuration;
        boolean mcF;
        boolean mcG;
        boolean mcH;
        boolean mcI;
        boolean mcJ;
        boolean mcj;
        boolean mck;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final String bDO() {
            return "GalleryChooseMedia";
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7 = true;
            AppMethodBeat.i(46433);
            this.appId = parcel.readString();
            this.mcF = parcel.readByte() != 0;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mcG = z;
            if (parcel.readByte() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mcH = z2;
            if (parcel.readByte() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mcI = z3;
            if (parcel.readByte() != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mcJ = z4;
            if (parcel.readByte() != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.isFront = z5;
            this.maxDuration = parcel.readInt();
            this.count = parcel.readInt();
            if (parcel.readByte() != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.mcj = z6;
            if (parcel.readByte() == 0) {
                z7 = false;
            }
            this.mck = z7;
            AppMethodBeat.o(46433);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3;
            byte b4;
            byte b5;
            byte b6;
            byte b7;
            byte b8 = 1;
            AppMethodBeat.i(46434);
            parcel.writeString(this.appId);
            parcel.writeByte(this.mcF ? (byte) 1 : 0);
            if (this.mcG) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (this.mcH) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            parcel.writeByte(b3);
            if (this.mcI) {
                b4 = 1;
            } else {
                b4 = 0;
            }
            parcel.writeByte(b4);
            if (this.mcJ) {
                b5 = 1;
            } else {
                b5 = 0;
            }
            parcel.writeByte(b5);
            if (this.isFront) {
                b6 = 1;
            } else {
                b6 = 0;
            }
            parcel.writeByte(b6);
            parcel.writeInt(this.maxDuration);
            parcel.writeInt(this.count);
            if (this.mcj) {
                b7 = 1;
            } else {
                b7 = 0;
            }
            parcel.writeByte(b7);
            if (!this.mck) {
                b8 = 0;
            }
            parcel.writeByte(b8);
            AppMethodBeat.o(46434);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDN() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(46435);
            k(parcel);
            AppMethodBeat.o(46435);
        }

        static {
            AppMethodBeat.i(46436);
            AppMethodBeat.o(46436);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<ChooseResult> CREATOR = new Parcelable.Creator<ChooseResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseResult[] newArray(int i2) {
                return new ChooseResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46437);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(46437);
                return chooseResult;
            }
        };
        String mcK;
        int resultCode;
        String type;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(46438);
            this.resultCode = parcel.readInt();
            this.type = parcel.readString();
            this.mcK = parcel.readString();
            AppMethodBeat.o(46438);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46439);
            parcel.writeInt(this.resultCode);
            parcel.writeString(this.type);
            parcel.writeString(this.mcK);
            AppMethodBeat.o(46439);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.i(46440);
            k(parcel);
            AppMethodBeat.o(46440);
        }

        static {
            AppMethodBeat.i(46441);
            AppMethodBeat.o(46441);
        }
    }
}
