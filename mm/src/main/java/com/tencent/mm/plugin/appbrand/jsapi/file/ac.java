package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac extends d {
    private static final int CTRL_INDEX = 778;
    private static final String NAME = "private_fileSystemConvert";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        String str2;
        boolean z;
        AppMethodBeat.i(174794);
        Log.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: %s %s", NAME, jSONObject.toString());
        String optString = jSONObject.optString("operationType", "");
        if (optString.equalsIgnoreCase("getAbsolutePath")) {
            String optString2 = jSONObject.optString(ch.COL_LOCALID);
            if (Util.isNullOrNil(optString2)) {
                fVar.i(i2, h(String.format("fail: parmas error %s", jSONObject.toString()), null));
                AppMethodBeat.o(174794);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("filePath", optString2);
                if (optString2.contains("wxfile://")) {
                    o VY = fVar.getFileSystem().VY(optString2);
                    if (VY == null) {
                        fVar.i(i2, h("fail:file doesn't exist", null));
                        fVar.i(i2, h(String.format("fail: %s not exists", optString2), null));
                        AppMethodBeat.o(174794);
                        return;
                    }
                    jSONObject2.put("filePath", aa.z(VY.her()));
                }
                fVar.i(i2, jSONObject2.toString());
                AppMethodBeat.o(174794);
            } catch (JSONException e2) {
                fVar.i(i2, h(String.format("fail: error %s", e2.getMessage()), null));
                AppMethodBeat.o(174794);
            }
        } else if (optString.equalsIgnoreCase("getWxFilePath")) {
            try {
                String optString3 = jSONObject.optString(DownloadInfo.FILENAME);
                if (Util.isNullOrNil(optString3)) {
                    str = "private_fileSystemConvert_" + System.currentTimeMillis();
                } else {
                    str = optString3;
                }
                String optString4 = jSONObject.optString("mimeType");
                boolean optBoolean = jSONObject.optBoolean("autoDeleteIfExists", true);
                if (Util.isNullOrNil(optString4)) {
                    fVar.i(i2, h(String.format("fail: parmas error %s", jSONObject.toString()), null));
                    AppMethodBeat.o(174794);
                    return;
                }
                String str3 = str + "." + optString4;
                if (fVar == null || Util.isNullOrNil(str3)) {
                    Object[] objArr = new Object[2];
                    if (fVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = str3;
                    Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: param error %b, %s", objArr);
                    str2 = null;
                } else {
                    at atVar = (at) fVar.getFileSystem();
                    if (atVar == null) {
                        Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: fs is null");
                        str2 = null;
                    } else {
                        String str4 = ((z) atVar.Wj("wxfile://clientdata")).kSr;
                        if (!str4.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                            str4 = str4 + FilePathGenerator.ANDROID_DIR_SEP;
                        }
                        o oVar = new o(str4 + FilePathGenerator.NO_MEDIA_FILENAME);
                        if (!oVar.exists()) {
                            Log.i("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: no nomedia file. trigger new");
                            try {
                                oVar.createNewFile();
                            } catch (IOException e3) {
                                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", e3, "hy: create no media file failed!", new Object[0]);
                            }
                        }
                        str2 = str4 + str3;
                    }
                }
                if (Util.isNullOrNil(str2)) {
                    fVar.i(i2, h("fail: getAbsoluteFile failed", null));
                    AppMethodBeat.o(174794);
                    return;
                }
                if (optBoolean && s.YS(str2)) {
                    s.deleteFile(str2);
                }
                String boZ = s.boZ(str2);
                s.boN(boZ);
                Log.w("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: getWxFilePath, fileName: %s, relativeFilePath: %s, relativeFileName: %s, parentAbsolutePath: %s!", str, str3, str2, boZ);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("filePath", str2);
                jSONObject3.put(ch.COL_LOCALID, "wxfile://clientdata/".concat(String.valueOf(str3)));
                fVar.i(i2, jSONObject3.toString());
                AppMethodBeat.o(174794);
            } catch (JSONException e4) {
                fVar.i(i2, h(String.format("fail: error %s", e4.getMessage()), null));
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiPrivateFileSystem", e4, "hy: json error!", new Object[0]);
                AppMethodBeat.o(174794);
            }
        } else {
            Log.e("MicroMsg.AppBrand.JsApiPrivateFileSystem", "hy: invalid operate type: %s", optString);
            fVar.i(i2, h(String.format("fail: not valid operate type: %s", optString), null));
            AppMethodBeat.o(174794);
        }
    }
}
