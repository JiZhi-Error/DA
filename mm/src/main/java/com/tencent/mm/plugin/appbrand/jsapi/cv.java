package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.b.g;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import kotlin.o;
import org.json.JSONObject;

public final class cv extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "uploadToCommonCDN";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45706);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiUploadToCommonCDN", "data is null");
            AppMethodBeat.o(45706);
            return;
        }
        Log.i("MicroMsg.JsApiUploadToCommonCDN", "JsApiUploadToCommonCDN data=".concat(String.valueOf(jSONObject)));
        int optInt = jSONObject.optInt("appType");
        int optInt2 = jSONObject.optInt("fileType");
        String optString = jSONObject.optString("fileKey");
        String optString2 = jSONObject.optString("filePath");
        ByteBuffer cD = cD(jSONObject.opt("fileData"));
        String optString3 = jSONObject.optString("thumbFilePath");
        ByteBuffer cD2 = cD(jSONObject.opt("thumbFileData"));
        boolean optBoolean = jSONObject.optBoolean("isStorageMode");
        int optInt3 = jSONObject.optInt("snsUploadVersion");
        if (!TextUtils.isEmpty(optString2) || cD != null) {
            if (!TextUtils.isEmpty(optString2)) {
                optString2 = c(sVar2, optString2);
                if (optString2.length() == 0) {
                    Log.w("MicroMsg.JsApiUploadToCommonCDN", "get full file path fail: ".concat(String.valueOf(optString2)));
                    sVar2.i(i2, h("fail:get full file path fail", null));
                    AppMethodBeat.o(45706);
                    return;
                }
            }
            if (!TextUtils.isEmpty(optString3)) {
                optString3 = c(sVar2, optString3);
                if (optString3.length() == 0) {
                    Log.w("MicroMsg.JsApiUploadToCommonCDN", "get full thumb file path fail: ".concat(String.valueOf(optString2)));
                    sVar2.i(i2, h("fail:get full thumb file path fail", null));
                    AppMethodBeat.o(45706);
                    return;
                }
            }
            if (TextUtils.isEmpty(optString)) {
                optString = g.getMessageDigest(String.format(Locale.ENGLISH, "%s%d", optString2, Long.valueOf(System.currentTimeMillis())).getBytes());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("appType", optInt);
            bundle.putInt("fileType", optInt2);
            bundle.putString("fileKey", optString);
            bundle.putString("filePath", optString2);
            if (cD != null) {
                byte[] bArr = new byte[cD.remaining()];
                cD.get(bArr);
                com.tencent.mm.plugin.appbrand.ipc.a.a aVar = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
                o<Boolean, String> aH = com.tencent.mm.plugin.appbrand.ipc.a.a.aH(bArr);
                if (aH.first.booleanValue()) {
                    bundle.putString("fileDataKey", aH.second);
                } else {
                    bundle.putByteArray("fileData", bArr);
                }
            }
            bundle.putString("thumbFilePath", optString3);
            if (cD2 != null) {
                byte[] bArr2 = new byte[cD2.remaining()];
                cD2.get(bArr2);
                com.tencent.mm.plugin.appbrand.ipc.a.a aVar2 = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
                o<Boolean, String> aH2 = com.tencent.mm.plugin.appbrand.ipc.a.a.aH(bArr2);
                if (aH2.first.booleanValue()) {
                    bundle.putString("thumbFileDataKey", aH2.second);
                } else {
                    bundle.putByteArray("thumbFileData", bArr2);
                }
            }
            bundle.putBoolean("isStorageMode", optBoolean);
            bundle.putInt("snsUploadVersion", optInt3);
            h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.cv.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(45702);
                    Bundle bundle2 = bundle;
                    int i2 = bundle2.getInt("ret", 1);
                    if (i2 == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("fileUrl", bundle2.getString("fileUrl", ""));
                        hashMap.put("thumbUrl", bundle2.getString("thumbUrl", ""));
                        sVar2.i(i2, cv.this.n("ok", hashMap));
                        AppMethodBeat.o(45702);
                    } else if (i2 == 1 || i2 != 2) {
                        sVar2.i(i2, cv.this.h("fail:cdn com upload error", null));
                        AppMethodBeat.o(45702);
                    } else {
                        sVar2.i(i2, cv.this.h("fail:cdn com call error", null));
                        AppMethodBeat.o(45702);
                    }
                }
            });
            AppMethodBeat.o(45706);
            return;
        }
        Log.w("MicroMsg.JsApiUploadToCommonCDN", "filePath and fileData invalid");
        sVar2.i(i2, h("fail:filePath and fileData invalid", null));
        AppMethodBeat.o(45706);
    }

    private static ByteBuffer cD(Object obj) {
        ByteBuffer byteBuffer;
        AppMethodBeat.i(226684);
        if (obj instanceof String) {
            byteBuffer = ByteBuffer.wrap(((String) obj).getBytes());
        } else {
            byteBuffer = obj instanceof ByteBuffer ? (ByteBuffer) obj : null;
        }
        AppMethodBeat.o(226684);
        return byteBuffer;
    }

    private static String c(s sVar, String str) {
        AppMethodBeat.i(45705);
        com.tencent.mm.vfs.o VY = sVar.getRuntime().getFileSystem().VY(str);
        if (VY == null) {
            AppMethodBeat.o(45705);
            return "";
        }
        String z = aa.z(VY.her());
        AppMethodBeat.o(45705);
        return z;
    }

    static final class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            byte[] Za;
            byte[] Za2;
            AppMethodBeat.i(45704);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("appType", 0);
            int i3 = bundle2.getInt("fileType", 0);
            String string = bundle2.getString("fileKey", "");
            String string2 = bundle2.getString("filePath", "");
            if (TextUtils.isEmpty(bundle2.getString("fileDataKey", ""))) {
                Za = bundle2.getByteArray("fileData");
            } else {
                com.tencent.mm.plugin.appbrand.ipc.a.a aVar = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
                Za = com.tencent.mm.plugin.appbrand.ipc.a.a.Za(bundle2.getString("fileDataKey"));
            }
            String string3 = bundle2.getString("thumbFilePath", "");
            if (TextUtils.isEmpty(bundle2.getString("thumbFileDataKey", ""))) {
                Za2 = bundle2.getByteArray("thumbFileData");
            } else {
                com.tencent.mm.plugin.appbrand.ipc.a.a aVar2 = com.tencent.mm.plugin.appbrand.ipc.a.a.lxe;
                Za2 = com.tencent.mm.plugin.appbrand.ipc.a.a.Za(bundle2.getString("thumbFileDataKey"));
            }
            boolean z = bundle2.getBoolean("isStorageMode", true);
            int i4 = bundle2.getInt("snsUploadVersion", 1);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_JsApiUploadToCommonCDN";
            gVar.field_fileType = i3;
            gVar.field_bzScene = 2;
            gVar.field_appType = i2;
            gVar.field_mediaId = string;
            gVar.field_fullpath = string2;
            gVar.field_thumbpath = string3;
            gVar.field_needStorage = z;
            gVar.snsVersion = i4;
            if (Za != null) {
                gVar.fileBuffer = Za;
            }
            if (Za2 != null) {
                gVar.thumbnailBuffer = Za2;
            }
            gVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.cv.a.AnonymousClass1 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    AppMethodBeat.i(45703);
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            Log.e("MicroMsg.JsApiUploadToCommonCDN", "cdn upload failed, retCode:%d sceneResult[%s]", Integer.valueOf(dVar.field_retCode), dVar);
                            Bundle bundle = new Bundle();
                            bundle.putInt("ret", 1);
                            dVar.bn(bundle);
                        } else {
                            Log.i("MicroMsg.JsApiUploadToCommonCDN", "cdn upload success, media id : %s  file url=%s   thumb url=%s", str, dVar.field_fileUrl, dVar.field_thumbUrl);
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("ret", 0);
                            bundle2.putString("fileUrl", dVar.field_fileUrl);
                            bundle2.putString("thumbUrl", dVar.field_thumbUrl);
                            dVar.bn(bundle2);
                        }
                    }
                    if (i2 != 0) {
                        Log.i("MicroMsg.JsApiUploadToCommonCDN", "cdn upload failed, startRet : %d", Integer.valueOf(i2));
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("ret", 1);
                        dVar.bn(bundle3);
                    }
                    AppMethodBeat.o(45703);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!f.baQ().f(gVar)) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("ret", 2);
                dVar.bn(bundle3);
            }
            AppMethodBeat.o(45704);
        }
    }
}
