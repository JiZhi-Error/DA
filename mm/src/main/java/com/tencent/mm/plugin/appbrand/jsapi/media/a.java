package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public abstract class a extends d<f> {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.a$a  reason: collision with other inner class name */
    public interface AbstractC0675a extends b {
        void a(Context context, Runnable runnable, Runnable runnable2);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean aaa(String str);

    /* access modifiers changed from: package-private */
    public abstract String aab(String str);

    /* access modifiers changed from: package-private */
    public abstract void aac(String str);

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        final String optString = jSONObject.optString("filePath", "");
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, h("fail filePath invalid", null));
            return;
        }
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.a.AnonymousClass1 */

            public final void run() {
                String str;
                AppMethodBeat.i(139864);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(139864);
                    return;
                }
                InputStream Wc = fVar.getFileSystem().Wc(optString);
                if (Wc == null) {
                    try {
                        fVar.i(i2, a.this.h("fail file not exists", null));
                    } catch (Throwable th) {
                        Util.qualityClose(Wc);
                        AppMethodBeat.o(139864);
                        throw th;
                    }
                } else {
                    String extension = org.apache.commons.a.d.getExtension(optString);
                    if (!a.this.aaa(MimeTypeUtil.getMimeTypeByFileExt(extension))) {
                        fVar.i(i2, a.this.h("fail invalid file type", null));
                        Util.qualityClose(Wc);
                        AppMethodBeat.o(139864);
                        return;
                    }
                    String aab = a.this.aab(extension);
                    boolean c2 = a.c(aab, Wc);
                    if (c2) {
                        a.this.aac(aab);
                        AndroidMediaUtil.refreshMediaScanner(aab, fVar.getContext());
                    }
                    f fVar = fVar;
                    int i2 = i2;
                    a aVar = a.this;
                    if (c2) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    fVar.i(i2, aVar.h(str, null));
                }
                Util.qualityClose(Wc);
                AppMethodBeat.o(139864);
            }
        };
        AbstractC0675a aVar = (AbstractC0675a) fVar.M(AbstractC0675a.class);
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "NULL permissionInterface with appId:%s, run directly", fVar.getAppId());
            r1.run();
            return;
        }
        aVar.a(fVar.getContext(), r1, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(193677);
                fVar.i(i2, a.this.h("fail:system permission denied", null));
                AppMethodBeat.o(193677);
            }
        });
    }

    static boolean c(String str, InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            o oVar = new o(str);
            oVar.heq().mkdirs();
            outputStream = s.ap(oVar);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e2);
            return false;
        } finally {
            Util.qualityClose(outputStream);
            Util.qualityClose(inputStream);
        }
    }
}
