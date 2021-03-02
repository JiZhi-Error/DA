package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends d {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        final String str;
        AppMethodBeat.i(128875);
        final String optString = jSONObject.optString("filePath", "");
        if (!"sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "md5";
        } else {
            str = "sha1";
        }
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(128875);
            return;
        }
        e.lUJ.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.r.AnonymousClass1 */

            public final void run() {
                String x;
                AppMethodBeat.i(128874);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(128874);
                    return;
                }
                o VY = fVar.getFileSystem().VY(optString);
                if (VY == null) {
                    fVar.i(i2, r.this.h("fail:file doesn't exist", null));
                    AppMethodBeat.o(128874);
                    return;
                }
                o oVar = new o(aa.z(VY.her()));
                String str = str;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 107902:
                        if (str.equals("md5")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3528965:
                        if (str.equals("sha1")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        x = g.getMD5(aa.z(oVar.her()));
                        break;
                    case 1:
                        x = r.x(new o(aa.z(oVar.her())));
                        break;
                    default:
                        x = "";
                        break;
                }
                HashMap hashMap = new HashMap(2);
                hashMap.put("size", Long.valueOf(oVar.length()));
                hashMap.put("digest", x);
                fVar.i(i2, r.this.n("ok", hashMap));
                AppMethodBeat.o(128874);
            }
        });
        AppMethodBeat.o(128875);
    }

    static String x(o oVar) {
        String stringBuffer;
        AppMethodBeat.i(170098);
        try {
            MessageDigest instance = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
            try {
                InputStream ao = s.ao(oVar);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = ao.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e2) {
                        try {
                            ao.close();
                        } catch (IOException e3) {
                            Log.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e3);
                        }
                        AppMethodBeat.o(170098);
                        return "";
                    } catch (Throwable th) {
                        try {
                            ao.close();
                        } catch (IOException e4) {
                            Log.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e4);
                        }
                        AppMethodBeat.o(170098);
                        throw th;
                    }
                }
                byte[] digest = instance.digest();
                if (digest == null) {
                    stringBuffer = null;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer(digest.length);
                    for (byte b2 : digest) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() < 2) {
                            stringBuffer2.append(0);
                        }
                        stringBuffer2.append(hexString.toLowerCase());
                    }
                    stringBuffer = stringBuffer2.toString();
                }
                try {
                    ao.close();
                } catch (IOException e5) {
                    Log.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e5);
                }
                AppMethodBeat.o(170098);
                return stringBuffer;
            } catch (FileNotFoundException e6) {
                Log.e("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", e6);
                AppMethodBeat.o(170098);
                return "";
            }
        } catch (NoSuchAlgorithmException e7) {
            Log.e("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", e7);
            AppMethodBeat.o(170098);
            return "";
        }
    }
}
