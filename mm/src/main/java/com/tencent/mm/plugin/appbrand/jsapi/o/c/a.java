package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.a.d;
import org.json.JSONObject;

public final class a implements h {
    com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.c.a$a  reason: collision with other inner class name */
    public static class C0693a extends bc {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.base.a aVar) {
        this.mgb = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179539);
        StringBuilder sb = new StringBuilder();
        i.bPC();
        String sb2 = sb.append(i.bPw()).toString();
        AppMethodBeat.o(179539);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "uploadTaskId";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(final f fVar, JSONObject jSONObject, final String str) {
        g adb;
        AppMethodBeat.i(179540);
        Log.d("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask");
        String appId = fVar.getAppId();
        String optString = jSONObject.optString("filePath");
        if (Util.isNullOrNil(optString)) {
            b(fVar, str, "filePath is null");
            AppMethodBeat.o(179540);
            return;
        }
        o VY = fVar.getFileSystem().VY(optString);
        if (VY == null || !VY.exists()) {
            Log.e("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", fVar.getAppId(), optString);
            b(fVar, str, "fail:file doesn't exist");
            AppMethodBeat.o(179540);
            return;
        }
        final String z = aa.z(VY.her());
        String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(optString);
        Log.i("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", fVar.getAppId(), optString, z);
        AnonymousClass1 r10 = new g.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.c.a.AnonymousClass1 */
            private JSONObject mgC;

            @Override // com.tencent.mm.plugin.appbrand.s.g.a
            public final void aat(String str) {
                AppMethodBeat.i(179535);
                Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", str, z, str, -1);
                if (a.j(fVar, str)) {
                    AppMethodBeat.o(179535);
                    return;
                }
                a.this.b(fVar, str, str);
                AppMethodBeat.o(179535);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.g.a
            public final void j(int i2, String str, int i3) {
                AppMethodBeat.i(179536);
                Log.i("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", str, z, str, Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str);
                    hashMap.put("statusCode", Integer.valueOf(i3));
                    hashMap.put("uploadTaskId", str);
                    hashMap.put("state", "success");
                    if (this.mgC != null) {
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.mgC);
                    }
                    new C0693a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                    a.this.mgb.remove(str);
                    AppMethodBeat.o(179536);
                } else if (a.j(fVar, str)) {
                    AppMethodBeat.o(179536);
                } else {
                    a.this.b(fVar, str, str);
                    AppMethodBeat.o(179536);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.s.g.a
            public final void i(int i2, long j2, long j3) {
                AppMethodBeat.i(179537);
                HashMap hashMap = new HashMap();
                hashMap.put("uploadTaskId", str);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i2));
                hashMap.put("totalBytesSent", Long.valueOf(j2));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j3));
                new C0693a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                AppMethodBeat.o(179537);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.g.a
            public final void J(JSONObject jSONObject) {
                AppMethodBeat.i(179538);
                if (jSONObject == null) {
                    AppMethodBeat.o(179538);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    this.mgC = jSONObject;
                    HashMap hashMap = new HashMap();
                    hashMap.put("uploadTaskId", str);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.mgC);
                    new C0693a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                    AppMethodBeat.o(179538);
                } else if (!((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp) {
                    AppMethodBeat.o(179538);
                } else {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    n nVar = new n();
                    nVar.dCn.dCo = "upload";
                    nVar.dCn.dCq = jSONObject;
                    nVar.dCn.dCp = str;
                    EventCenter.instance.publish(nVar);
                    AppMethodBeat.o(179538);
                }
            }
        };
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        Map<String, String> a2 = j.a(jSONObject, aVar);
        String optString2 = jSONObject.optString("url");
        if (Util.isNullOrNil(optString2)) {
            Log.i("MicroMsg.BaseCreateUploadTask", "url is null");
            b(fVar, str, "url is null or nil");
            AppMethodBeat.o(179540);
            return;
        }
        boolean z2 = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar.nhD;
        if (!z2 || j.c(aVar.cyV, optString2)) {
            if (aVar.cyL <= 0) {
                Log.i("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
            }
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = j.a(aVar, 2);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            if (i.bPC().adb(appId) == null) {
                adb = new g(fVar);
                i bPC = i.bPC();
                if (!bPC.nhY.containsKey(appId)) {
                    bPC.nhY.put(appId, adb);
                }
            } else {
                adb = i.bPC().adb(appId);
            }
            String name = d.getName(optString);
            if (adb != null) {
                Log.i("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", Boolean.valueOf(z2), Integer.valueOf(optInt));
                if (!z2) {
                    adb.a(optInt, mimeTypeByFilePath, z, jSONObject, a2, null, r10, str, b.NAME, name);
                    AppMethodBeat.o(179540);
                    return;
                }
                adb.a(optInt, mimeTypeByFilePath, z, jSONObject, a2, aVar.cyV, r10, str, b.NAME, name);
            }
            AppMethodBeat.o(179540);
            return;
        }
        Log.i("MicroMsg.BaseCreateUploadTask", "not in domain url %s", optString2);
        b(fVar, str, "url not in domain list");
        AppMethodBeat.o(179540);
    }

    /* access modifiers changed from: package-private */
    public final void b(f fVar, String str, String str2) {
        AppMethodBeat.i(179541);
        Log.w("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C0693a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(this.mgb.Zz(str));
        this.mgb.remove(str);
        AppMethodBeat.o(179541);
    }

    static /* synthetic */ boolean j(f fVar, String str) {
        AppMethodBeat.i(179542);
        g adb = i.bPC().adb(fVar.getAppId());
        if (adb == null || !adb.acT(str)) {
            AppMethodBeat.o(179542);
            return false;
        }
        Log.i("MicroMsg.BaseCreateUploadTask", "upload abort %s", str);
        AppMethodBeat.o(179542);
        return true;
    }
}
