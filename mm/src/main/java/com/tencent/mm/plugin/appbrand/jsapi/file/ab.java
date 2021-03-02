package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.List;
import org.json.JSONObject;

public final class ab extends d {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long lVm = -1;
    private a lVn = new a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.file.ab.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.multitask.c.a
        public final void bC(List<MultiTaskInfo> list) {
            AppMethodBeat.i(226770);
            for (MultiTaskInfo multiTaskInfo : list) {
                if (!(multiTaskInfo == null || multiTaskInfo.field_type != 4 || multiTaskInfo.field_data == null)) {
                    aoe aoe = new aoe();
                    try {
                        aoe.parseFrom(multiTaskInfo.field_data);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AppBrand.JsApiOpenDocument", "handleMultiTaskInfoClicked", th);
                    }
                    if (Util.nullAsNil(aoe.appId).equals(ab.this.mAppID) && ab.this.lwE != null) {
                        ab.this.lwE.acQ(MMApplicationContext.getProcessName());
                    }
                }
            }
            AppMethodBeat.o(226770);
        }
    };
    private a lVo = new a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.file.ab.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.multitask.c.a
        public final void bC(List<MultiTaskInfo> list) {
            AppMethodBeat.i(226771);
            for (MultiTaskInfo multiTaskInfo : list) {
                if (!(multiTaskInfo == null || multiTaskInfo.field_type != 4 || multiTaskInfo.field_data == null)) {
                    aoe aoe = new aoe();
                    try {
                        aoe.parseFrom(multiTaskInfo.field_data);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AppBrand.JsApiOpenDocument", "handleMultiTaskInfoClicked", th);
                    }
                    if (Util.nullAsNil(aoe.processName).equals(MMApplicationContext.getProcessName()) && ab.this.lwE != null) {
                        ab.this.lwE.acQ("");
                    }
                }
            }
            AppMethodBeat.o(226771);
        }
    };
    private com.tencent.mm.plugin.appbrand.q.a lwE;
    private String mAppID;

    public ab() {
        AppMethodBeat.i(174793);
        AppMethodBeat.o(174793);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46349);
        long nowMilliSecond = Util.nowMilliSecond();
        if (nowMilliSecond - lVm < 1000) {
            fVar.i(i2, h("fail:document viewer already starting", null));
            AppMethodBeat.o(46349);
            return;
        }
        lVm = nowMilliSecond;
        final Context context = fVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46349);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("showMenu");
        String optString = jSONObject.optString("filePath");
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46349);
            return;
        }
        o VY = fVar.getFileSystem().VY(optString);
        if (VY == null) {
            fVar.i(i2, h("fail:file doesn't exist", null));
            AppMethodBeat.o(46349);
            return;
        }
        this.mAppID = fVar.getAppId();
        OpenFileRequest openFileRequest = new OpenFileRequest();
        openFileRequest.filePath = aa.z(VY.her());
        openFileRequest.gCr = org.apache.commons.a.d.getExtension(optString);
        openFileRequest.appId = this.mAppID;
        openFileRequest.lwF = optBoolean;
        String optString2 = jSONObject.optString("fileType");
        if (!Util.isNullOrNil(optString2)) {
            openFileRequest.gCr = optString2;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.b(context, openFileRequest, new AppBrandProxyUIProcessTask.b<OpenFileRequest.OpenResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.ab.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
            public final /* synthetic */ void a(OpenFileRequest.OpenResult openResult) {
                String str;
                AppMethodBeat.i(46313);
                OpenFileRequest.OpenResult openResult2 = openResult;
                if (fVar.isRunning()) {
                    if (openResult2 != null && openResult2.ret != 2147483645) {
                        switch (openResult2.ret) {
                            case 0:
                                ab.this.lwE = new com.tencent.mm.plugin.appbrand.q.a(new b((Activity) context));
                                str = "ok";
                                break;
                            case 2147483646:
                                str = "fail no third apps supported";
                                break;
                            case Integer.MAX_VALUE:
                                str = "fail user cancel";
                                break;
                            default:
                                str = "fail file type not supported " + openResult2.ret;
                                break;
                        }
                    } else {
                        str = "fail env error";
                    }
                    fVar.i(i2, ab.this.h(str, null));
                }
                AppMethodBeat.o(46313);
            }
        });
        h.a(fVar.getAppId(), new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.ab.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(174788);
                if (ab.this.lwE != null) {
                    com.tencent.mm.plugin.appbrand.q.a unused = ab.this.lwE;
                    ab.this.lwE = null;
                }
                h.b(fVar.getAppId(), this);
                AppMethodBeat.o(174788);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(174789);
                if (ab.this.lwE != null) {
                    com.tencent.mm.plugin.appbrand.q.a unused = ab.this.lwE;
                    com.tencent.mm.plugin.appbrand.q.a.a(ab.this.lVo);
                }
                AppMethodBeat.o(174789);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(174790);
                if (ab.this.lwE != null) {
                    com.tencent.mm.plugin.appbrand.q.a unused = ab.this.lwE;
                    com.tencent.mm.plugin.appbrand.q.a.a(ab.this.lVn);
                }
                AppMethodBeat.o(174790);
            }
        });
        AppMethodBeat.o(46349);
    }
}
