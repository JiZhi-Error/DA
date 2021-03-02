package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.a;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ImgUtil;
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
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage extends d {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";
    private static Boolean mcb = null;

    static /* synthetic */ boolean bHp() {
        AppMethodBeat.i(226879);
        boolean bHo = bHo();
        AppMethodBeat.o(226879);
        return bHo;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        String str;
        boolean z;
        AppMethodBeat.i(46425);
        if (fVar.getAppId() == null) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46425);
        } else if (p.Um(fVar.getAppId()).kCV) {
            fVar.i(i2, h("cancel", null));
            AppMethodBeat.o(46425);
        } else {
            final Context context = fVar.getContext();
            if (context == null || !(context instanceof Activity)) {
                fVar.i(i2, h("fail", null));
                AppMethodBeat.o(46425);
                return;
            }
            final ChooseRequest chooseRequest = new ChooseRequest();
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            String optString = jSONObject.optString("sizeType");
            String optString2 = jSONObject.optString("count");
            Log.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", optJSONArray, optString, optString2);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                chooseRequest.mch = true;
                chooseRequest.mci = true;
            } else {
                chooseRequest.mch = optJSONArray.toString().contains("camera");
                chooseRequest.mci = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
            }
            if (chooseRequest.mch) {
                r.b(fVar.getAppId(), new a.AbstractC0015a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass4 */

                    @Override // android.support.v4.app.a.AbstractC0015a
                    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                        AppMethodBeat.i(226861);
                        if (i2 != 113) {
                            AppMethodBeat.o(226861);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            fVar.i(i2, JsApiChooseImage.this.h("fail:system permission denied", null));
                            AppMethodBeat.o(226861);
                        } else {
                            JsApiChooseImage.this.a(fVar, jSONObject, i2);
                            AppMethodBeat.o(226861);
                        }
                    }
                });
                Context context2 = fVar.getContext();
                if (context2 == null || !(context2 instanceof Activity)) {
                    fVar.i(i2, h("fail", null));
                    z = false;
                } else {
                    z = b.a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                    if (z) {
                        r.aeq(fVar.getAppId());
                    }
                }
                if (!z) {
                    AppMethodBeat.o(46425);
                    return;
                }
            }
            p.Un(fVar.getAppId()).kCV = true;
            h.a(fVar.getAppId(), new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onDestroy() {
                    AppMethodBeat.i(180217);
                    if (fVar.getAppId() != null) {
                        p.Un(fVar.getAppId()).kCV = false;
                    }
                    h.b(fVar.getAppId(), this);
                    AppMethodBeat.o(180217);
                }
            });
            if (Util.isNullOrNil(optString)) {
                str = "compressed";
            } else {
                str = optString;
            }
            chooseRequest.mcj = str.contains("compressed");
            chooseRequest.mck = str.contains("original");
            chooseRequest.count = Util.getInt(optString2, 9);
            chooseRequest.appId = fVar.getAppId();
            final AnonymousClass2 r5 = new AppBrandProxyUIProcessTask.b<ChooseResult>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
                @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                public final /* synthetic */ void a(ChooseResult chooseResult) {
                    AppMethodBeat.i(46397);
                    ChooseResult chooseResult2 = chooseResult;
                    if (fVar.getAppId() != null) {
                        p.Un(fVar.getAppId()).kCV = false;
                    }
                    if (chooseResult2 != null) {
                        switch (chooseResult2.resultCode) {
                            case 0:
                                fVar.i(i2, JsApiChooseImage.this.h("cancel", null));
                                AppMethodBeat.o(46397);
                                return;
                            case -1:
                                ArrayList<AppBrandLocalMediaObject> arrayList = chooseResult2.mcm;
                                if (Util.isNullOrNil(arrayList)) {
                                    Log.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                    break;
                                } else {
                                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                                    ArrayList arrayList3 = new ArrayList(arrayList.size());
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    Iterator<AppBrandLocalMediaObject> it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        AppBrandLocalMediaObject next = it.next();
                                        if (next != null && !Util.isNullOrNil(next.dJX)) {
                                            arrayList2.add(next.dJX);
                                            arrayList3.add(Long.valueOf(next.jPY));
                                            arrayList4.add(next.iGf);
                                        }
                                    }
                                    Log.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", JsApiChooseImage.D(arrayList2));
                                    HashMap hashMap = new HashMap(1);
                                    hashMap.put("tempFilePaths", JsApiChooseImage.E(arrayList2));
                                    hashMap.put("tempFileSizes", JsApiChooseImage.E(arrayList3));
                                    if (CrashReportFactory.hasDebuger()) {
                                        hashMap.put("__realPaths", JsApiChooseImage.E(arrayList4));
                                    }
                                    fVar.i(i2, JsApiChooseImage.this.n("ok", hashMap));
                                    AppMethodBeat.o(46397);
                                    return;
                                }
                        }
                    }
                    fVar.i(i2, JsApiChooseImage.this.h("fail", null));
                    AppMethodBeat.o(46397);
                }
            };
            if (!chooseRequest.mch || !chooseRequest.mci || !bHo()) {
                Log.i("MicroMsg.JsApiChooseImage", "start select");
                com.tencent.mm.plugin.appbrand.ipc.a.b(context, chooseRequest, r5);
                AppMethodBeat.o(46425);
                return;
            }
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(226860);
                    JsApiChooseImage.a(JsApiChooseImage.this, fVar.getContext(), new o.g() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(226858);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    chooseRequest.mci = false;
                                    break;
                                case 2:
                                    chooseRequest.mch = false;
                                    break;
                            }
                            Log.i("MicroMsg.JsApiChooseImage", "start select after source choose");
                            com.tencent.mm.plugin.appbrand.ipc.a.b(context, chooseRequest, r5);
                            AppMethodBeat.o(226858);
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass3.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(226859);
                            Log.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
                            p.Un(fVar.getAppId()).kCV = false;
                            fVar.i(i2, JsApiChooseImage.this.h("cancel", null));
                            AppMethodBeat.o(226859);
                        }
                    });
                    AppMethodBeat.o(226860);
                }
            });
            AppMethodBeat.o(46425);
        }
    }

    private static boolean bHo() {
        AppMethodBeat.i(226877);
        if (mcb == null) {
            Log.i("MicroMsg.JsApiChooseImage", "inti wx style field");
            mcb = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_chooseimage_new, false));
        }
        if (mcb == null) {
            Log.e("MicroMsg.JsApiChooseImage", "get shoot style fail, use default style");
            AppMethodBeat.o(226877);
            return false;
        }
        Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot, flag: %b", mcb);
        boolean booleanValue = mcb.booleanValue();
        AppMethodBeat.o(226877);
        return booleanValue;
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private q gxX;
        double latitude;
        double longitude;
        ChooseRequest mcn;
        ChooseResult mco = new ChooseResult();
        final int mcp = (hashCode() % 10000);
        int mcq;
        boolean mcr;
        boolean mcs;
        boolean mct;
        private DialogInterface.OnCancelListener mcu;

        private a() {
            AppMethodBeat.i(46412);
            AppMethodBeat.o(46412);
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226873);
            aVar.b(processResult);
            AppMethodBeat.o(226873);
        }

        static /* synthetic */ MMActivity b(a aVar) {
            AppMethodBeat.i(46422);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(46422);
            return bDF;
        }

        static /* synthetic */ void b(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226875);
            aVar.b(processResult);
            AppMethodBeat.o(226875);
        }

        static /* synthetic */ MMActivity c(a aVar) {
            AppMethodBeat.i(226874);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226874);
            return bDF;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(46413);
            this.mcn = (ChooseRequest) processRequest;
            this.mcn.mcl = true;
            this.mcn.count = Math.max(1, Math.min(9, this.mcn.count));
            this.mcq = 16;
            if (Util.getAvailableMemoryMB(bDF()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                u.makeText(bDF(), MMApplicationContext.getResources().getString(R.string.jh), 1).show();
            }
            this.mct = JsApiChooseImage.bHp();
            Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", Boolean.valueOf(this.mct));
            bDF().mmSetOnActivityResultCallback(this);
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", !this.mcn.mcj);
            intent.putExtra("key_force_show_raw_image_button", this.mcn.mck);
            if (!this.mcn.mck || this.mcn.mcj) {
                z2 = false;
            } else {
                z2 = true;
            }
            intent.putExtra("key_is_raw_image_button_disable", z2);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
            intent.putExtra("gallery_report_tag", 16);
            if (!this.mcn.mch || !this.mcn.mci) {
                if (this.mcn.mci) {
                    intent.putExtra("show_header_view", false);
                    s.a(bDF(), 1, this.mcn.count, this.mcq, intent);
                    AppMethodBeat.o(46413);
                } else if (!this.mcn.mch) {
                    Log.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                    this.mco.resultCode = -2;
                    b(this.mco);
                    AppMethodBeat.o(46413);
                } else if (this.mct) {
                    aML();
                    AppMethodBeat.o(46413);
                } else {
                    s.d(bDF(), com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    AppMethodBeat.o(46413);
                }
            } else if (this.mct) {
                Log.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
                this.mco.resultCode = -2;
                b(this.mco);
                AppMethodBeat.o(46413);
            } else {
                s.a(bDF(), 1, this.mcn.count, this.mcq, intent);
                AppMethodBeat.o(46413);
            }
        }

        private boolean bHq() {
            AppMethodBeat.i(180229);
            MMActivity bDF = bDF();
            if (bDF == null) {
                Log.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
                AppMethodBeat.o(180229);
                return false;
            } else if (i.n(bDF, "android.permission.ACCESS_FINE_LOCATION")) {
                this.mcs = true;
                AppMethodBeat.o(180229);
                return true;
            } else if (this.mcr) {
                AppMethodBeat.o(180229);
                return false;
            } else {
                if (this.mcn != null) {
                    this.mcn.mcl = false;
                }
                boolean a2 = i.a(bDF, "android.permission.ACCESS_FINE_LOCATION", this.mcp, null, null);
                AppMethodBeat.o(180229);
                return a2;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void u(int[] iArr) {
            AppMethodBeat.i(180230);
            if (iArr.length <= 0 || iArr[0] != 0) {
                Log.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
                this.mcr = true;
            } else {
                Log.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
                this.mcs = true;
            }
            aML();
            AppMethodBeat.o(180230);
        }

        private void aML() {
            AppMethodBeat.i(180231);
            if (bHq() || this.mcr) {
                m.bZn().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(46410);
                        if (a.this.mcs) {
                            a.a(a.this);
                        }
                        GetSightParamsIPCTask.a aVar = GetSightParamsIPCTask.mbY;
                        SightParams p = GetSightParamsIPCTask.a.p(2, 0, false);
                        p.zsP = false;
                        Intent intent = new Intent();
                        intent.setClassName(a.b(a.this), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
                        intent.putExtra("KEY_SIGHT_PARAMS", p);
                        a.a(a.this, intent);
                        AppMethodBeat.o(46410);
                    }
                });
                AppMethodBeat.o(180231);
                return;
            }
            Log.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
            AppMethodBeat.o(180231);
        }

        private void xh(int i2) {
            AppMethodBeat.i(46414);
            this.mcu = new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(226866);
                    a.this.mco.resultCode = 0;
                    a.a(a.this, a.this.mco);
                    AppMethodBeat.o(226866);
                }
            };
            MMActivity bDF = bDF();
            MMApplicationContext.getResources().getString(R.string.zb);
            this.gxX = com.tencent.mm.ui.base.h.a((Context) bDF, MMApplicationContext.getResources().getString(i2), true, this.mcu);
            AppMethodBeat.o(46414);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void bDM() {
            AppMethodBeat.i(46417);
            super.bDM();
            if (this.gxX != null) {
                this.gxX.dismiss();
                this.gxX = null;
            }
            AppMethodBeat.o(46417);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask, com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            final String h2;
            final boolean z;
            final boolean z2;
            AppMethodBeat.i(46418);
            if (i3 == 0) {
                this.mco.resultCode = 0;
                b(this.mco);
                AppMethodBeat.o(46418);
                return;
            }
            switch (i2) {
                case 1:
                case 3:
                    if (intent == null) {
                        this.mco.resultCode = 0;
                        b(this.mco);
                        AppMethodBeat.o(46418);
                        return;
                    }
                    final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                    final boolean z3 = ((!this.mcn.mck) && this.mcn.mcj) || ((this.mcn.mcj & this.mcn.mck) && booleanExtra);
                    if (intent.getBooleanExtra("isTakePhoto", false) || intent.getBooleanExtra("isPreviewPhoto", false)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.valueOf(z), Boolean.valueOf(this.mcn.mcj), Boolean.valueOf(this.mcn.mck), Boolean.valueOf(booleanExtra), Boolean.valueOf(z3));
                    if (z3) {
                        xh(R.string.ji);
                    }
                    if (z3 || !r.bD(stringArrayListExtra)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        xh(R.string.mq);
                    }
                    m.bZn().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(226868);
                            final ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                            for (String str : stringArrayListExtra) {
                                boolean isGif = ImgUtil.isGif(str);
                                boolean z = z;
                                if (isGif) {
                                    Log.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", str);
                                } else if (z3) {
                                    String aah = r.aah(str);
                                    if (aah != null && !aah.equals(str)) {
                                        z = true;
                                        str = aah;
                                    }
                                } else if (z2) {
                                    String aai = r.aai(str);
                                    if (!aai.equals(str)) {
                                        z = true;
                                        str = aai;
                                    }
                                }
                                AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(a.this.mcn.appId, str, z);
                                if (h2 != null) {
                                    if (z) {
                                        try {
                                            a.c(a.this).getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{str});
                                        } catch (Exception e2) {
                                        }
                                    }
                                    arrayList.add(h2);
                                } else {
                                    Log.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", str);
                                }
                            }
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(226867);
                                    a.this.mco.resultCode = -1;
                                    a.this.mco.mcm = arrayList;
                                    a.b(a.this, a.this.mco);
                                    AppMethodBeat.o(226867);
                                }
                            });
                            AppMethodBeat.o(226868);
                        }
                    });
                    AppMethodBeat.o(46418);
                    return;
                case 2:
                    if (!this.mct) {
                        h2 = s.h(bDF().getApplicationContext(), intent, com.tencent.mm.loader.j.b.aKV());
                    } else if (intent == null) {
                        this.mco.resultCode = 0;
                        b(this.mco);
                        AppMethodBeat.o(46418);
                        return;
                    } else {
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult == null) {
                            this.mco.resultCode = 0;
                            b(this.mco);
                            AppMethodBeat.o(46418);
                            return;
                        }
                        h2 = sightCaptureResult.zsG;
                    }
                    if (Util.isNullOrNil(h2)) {
                        Log.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
                        this.mco.resultCode = -2;
                        b(this.mco);
                        AppMethodBeat.o(46418);
                        return;
                    }
                    if (!(bDF() == null || bDF().getWindow() == null)) {
                        bDF().getWindow().getDecorView().setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    }
                    m.bZn().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(226870);
                            try {
                                com.tencent.mm.plugin.appbrand.l.b.a(h2, a.this.latitude, a.this.longitude, System.currentTimeMillis());
                            } catch (Exception e2) {
                                Log.w("MicroMsg.JsApiChooseImage", "set extra exif info error", e2);
                            }
                            Log.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", h2);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    boolean z = false;
                                    AppMethodBeat.i(226869);
                                    Intent intent = new Intent();
                                    intent.putExtra("key_send_raw_image", !a.this.mcn.mcj);
                                    intent.putExtra("key_force_show_raw_image_button", a.this.mcn.mck);
                                    if (a.this.mcn.mck && !a.this.mcn.mcj) {
                                        z = true;
                                    }
                                    intent.putExtra("key_is_raw_image_button_disable", z);
                                    intent.putExtra("max_select_count", a.this.mcn.count);
                                    intent.putExtra("query_source_type", a.this.mcq);
                                    intent.putExtra("isPreviewPhoto", true);
                                    intent.putExtra("max_select_count", 1);
                                    ArrayList<String> arrayList = new ArrayList<>(1);
                                    arrayList.add(h2);
                                    intent.putStringArrayListExtra("preview_image_list", arrayList);
                                    intent.putExtra("preview_image", true);
                                    intent.putExtra("key_force_hide_edit_image_button", true);
                                    intent.addFlags(67108864);
                                    a.a(a.this, "gallery", ".ui.GalleryEntryUI", intent);
                                    AppMethodBeat.o(226869);
                                }
                            });
                            AppMethodBeat.o(226870);
                        }
                    });
                    AppMethodBeat.o(46418);
                    return;
                default:
                    this.mco.resultCode = -2;
                    b(this.mco);
                    AppMethodBeat.o(46418);
                    return;
            }
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(226871);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enableIndoor", true);
            if (e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class) == null) {
                Log.e("MicroMsg.JsApiChooseImage", "skip getLocation, LocationManager is null");
                AppMethodBeat.o(226871);
                return;
            }
            ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).a("wgs84", new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
                public final void a(int i2, String str, a.C0814a aVar) {
                    AppMethodBeat.i(226865);
                    Log.i("MicroMsg.JsApiChooseImage", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i2), str, aVar);
                    if (i2 == 0) {
                        a.this.latitude = aVar.latitude;
                        a.this.longitude = aVar.longitude;
                    }
                    AppMethodBeat.o(226865);
                }
            }, bundle);
            AppMethodBeat.o(226871);
        }

        static /* synthetic */ void a(a aVar, Intent intent) {
            AppMethodBeat.i(226872);
            aVar.bDF().mmSetOnActivityResultCallback(aVar);
            aVar.bDF().startActivityForResult(intent, 2);
            AppMethodBeat.o(226872);
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            AppMethodBeat.i(226876);
            aVar.bDF().mmSetOnActivityResultCallback(aVar);
            c.b(aVar.bDF(), str, str2, intent, 3);
            AppMethodBeat.o(226876);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<ChooseRequest> CREATOR = new Parcelable.Creator<ChooseRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseRequest[] newArray(int i2) {
                return new ChooseRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46399);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(46399);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        boolean mch;
        boolean mci;
        boolean mcj;
        boolean mck;
        boolean mcl = true;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            AppMethodBeat.i(46400);
            this.appId = parcel.readString();
            this.count = parcel.readInt();
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
            if (parcel.readByte() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mcj = z3;
            if (parcel.readByte() == 0) {
                z4 = false;
            }
            this.mck = z4;
            AppMethodBeat.o(46400);
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
            byte b5 = 1;
            AppMethodBeat.i(46401);
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
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
            if (this.mcj) {
                b4 = 1;
            } else {
                b4 = 0;
            }
            parcel.writeByte(b4);
            if (!this.mck) {
                b5 = 0;
            }
            parcel.writeByte(b5);
            AppMethodBeat.o(46401);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final String bDO() {
            return "GalleryChooseImage";
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDN() {
            if (this.mcl) {
                return true;
            }
            this.mcl = true;
            return false;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(46402);
            k(parcel);
            AppMethodBeat.o(46402);
        }

        static {
            AppMethodBeat.i(46403);
            AppMethodBeat.o(46403);
        }
    }

    static final class ChooseResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<ChooseResult> CREATOR = new Parcelable.Creator<ChooseResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseResult[] newArray(int i2) {
                return new ChooseResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46404);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(46404);
                return chooseResult;
            }
        };
        ArrayList<AppBrandLocalMediaObject> mcm;
        int resultCode;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(46405);
            this.resultCode = parcel.readInt();
            this.mcm = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
            AppMethodBeat.o(46405);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46406);
            parcel.writeInt(this.resultCode);
            parcel.writeTypedList(this.mcm);
            AppMethodBeat.o(46406);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(46407);
            AppMethodBeat.o(46407);
        }
    }

    static /* synthetic */ String D(ArrayList arrayList) {
        AppMethodBeat.i(46426);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.o(46426);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(46426);
        return jSONArray2;
    }

    static /* synthetic */ JSONArray E(ArrayList arrayList) {
        AppMethodBeat.i(46427);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.JsApiChooseImage", "data is null");
            AppMethodBeat.o(46427);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        AppMethodBeat.o(46427);
        return jSONArray;
    }

    static /* synthetic */ void a(JsApiChooseImage jsApiChooseImage, final Context context, o.g gVar, final DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(226878);
        l lVar = new l(context);
        lVar.a(new e.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.a.e.a
            public final void onClick() {
                AppMethodBeat.i(226862);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                }
                AppMethodBeat.o(226862);
            }
        });
        lVar.a(null, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass6 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(226863);
                contextMenu.add(0, 1, 0, context.getString(R.string.um));
                contextMenu.add(0, 2, 1, context.getString(R.string.uv));
                AppMethodBeat.o(226863);
            }
        }, gVar, new e.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(226864);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                }
                AppMethodBeat.o(226864);
            }
        });
        AppMethodBeat.o(226878);
    }
}
