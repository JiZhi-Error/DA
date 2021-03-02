package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends d<k> {
    public static final int CTRL_INDEX = 532;
    public static final String NAME = "chooseMessageFile";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46492);
        final k kVar2 = kVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiChooseMessageFile", "data is null");
            kVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46492);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.JsApiChooseMessageFile", "context is null, invoke with appId:%s, callbackId:%d", kVar2.getAppId(), Integer.valueOf(i2));
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46492);
            return;
        }
        Log.i("MicroMsg.JsApiChooseMessageFile", "chooseMsgFile data:%s, appId:%s, callbackId:%d", jSONObject, kVar2.getAppId(), Integer.valueOf(i2));
        String optString = jSONObject.optString("type", "all");
        String optString2 = jSONObject.optString(ShareConstants.MEDIA_EXTENSION, "");
        ((a) g.af(a.class)).a(castActivityOrNull, optString, jSONObject.optInt("count", 9), optString2, new a.AbstractC0293a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.f.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.choosemsgfile.compat.a.AbstractC0293a
            public final void a(int i2, String str, final ArrayList<MsgFile> arrayList) {
                AppMethodBeat.i(46491);
                Log.i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", Integer.valueOf(i2), arrayList);
                switch (i2) {
                    case -1:
                        m.bZn().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.media.f.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                int exifOrientation;
                                Bitmap.CompressFormat compressFormat;
                                AppMethodBeat.i(46490);
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    MsgFile msgFile = (MsgFile) it.next();
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        if (Util.isNullOrNil(msgFile.filePath) || !s.YS(msgFile.filePath)) {
                                            Log.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", msgFile.filePath);
                                        } else {
                                            if ("image".equals(msgFile.type) && (exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(msgFile.filePath)) != 0) {
                                                o Wa = kVar2.getFileSystem().Wa(msgFile.fileName);
                                                boolean equals = "png".equals(msgFile.gCr);
                                                String str = msgFile.filePath;
                                                if (equals) {
                                                    compressFormat = Bitmap.CompressFormat.PNG;
                                                } else {
                                                    compressFormat = Bitmap.CompressFormat.JPEG;
                                                }
                                                boolean rotate = BitmapUtil.rotate(str, exifOrientation, compressFormat, 100, aa.z(Wa.her()));
                                                if (rotate) {
                                                    msgFile.filePath = aa.z(Wa.her());
                                                    msgFile.fileSize = (int) Wa.length();
                                                }
                                                Log.i("MicroMsg.JsApiChooseMessageFile", "isOk:%b degree:%d msgFile:%s", Boolean.valueOf(rotate), Integer.valueOf(exifOrientation), msgFile);
                                            }
                                            o oVar = new o(msgFile.filePath);
                                            i<String> iVar = new i<>();
                                            com.tencent.mm.plugin.appbrand.appstorage.m a2 = kVar2.getFileSystem().a(oVar, msgFile.gCr, false, iVar);
                                            if (a2 == com.tencent.mm.plugin.appbrand.appstorage.m.OK) {
                                                jSONObject.put("path", iVar.value);
                                                jSONObject.put("name", msgFile.fileName);
                                                jSONObject.put("size", msgFile.fileSize);
                                                jSONObject.put("type", msgFile.type);
                                                jSONObject.put("time", msgFile.timeStamp);
                                                jSONArray.put(jSONObject);
                                            } else {
                                                Log.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", msgFile, a2);
                                            }
                                        }
                                    } catch (JSONException e2) {
                                        Log.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e2, "", new Object[0]);
                                    }
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("errMsg", f.this.getName() + ":ok");
                                    jSONObject2.put("tempFiles", jSONArray);
                                } catch (JSONException e3) {
                                    Log.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e3, "", new Object[0]);
                                }
                                Log.i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", jSONObject2.toString());
                                kVar2.i(i2, jSONObject2.toString());
                                AppMethodBeat.o(46490);
                            }
                        });
                        AppMethodBeat.o(46491);
                        return;
                    case 0:
                        kVar2.i(i2, f.this.h("fail:cancel", null));
                        break;
                    case 1:
                        if (Util.isNullOrNil(str)) {
                            kVar2.i(i2, f.this.h("fail", null));
                            AppMethodBeat.o(46491);
                            return;
                        }
                        kVar2.i(i2, f.this.h("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(46491);
                        return;
                }
                AppMethodBeat.o(46491);
            }
        });
        AppMethodBeat.o(46492);
    }
}
