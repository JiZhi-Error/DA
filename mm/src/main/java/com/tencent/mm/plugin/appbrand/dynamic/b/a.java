package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.j.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;

public final class a {
    private static final b.l lmM = new b.d();

    static {
        AppMethodBeat.i(121250);
        AppMethodBeat.o(121250);
    }

    public static Bitmap db(String str, String str2) {
        AppMethodBeat.i(121249);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(121249);
            return null;
        }
        String Wf = LaunchParcel.Wf(str2);
        if (Util.isNullOrNil(Wf)) {
            AppMethodBeat.o(121249);
            return null;
        }
        String str3 = str + '#' + Wf;
        Bitmap EP = lmM.EP(str3);
        if (EP == null || EP.isRecycled()) {
            WebResourceResponse dh = c.dh(str, Wf);
            if (dh != null) {
                try {
                    if (dh.mInputStream != null && dh.mInputStream.available() > 0) {
                        Bitmap decodeStream = BitmapUtil.decodeStream(dh.mInputStream);
                        if (decodeStream == null || decodeStream.isRecycled()) {
                            if (dh != null) {
                                Util.qualityClose(dh.mInputStream);
                            }
                            AppMethodBeat.o(121249);
                            return null;
                        }
                        lmM.put(str3, decodeStream);
                        if (dh != null) {
                            Util.qualityClose(dh.mInputStream);
                        }
                        AppMethodBeat.o(121249);
                        return decodeStream;
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", e2);
                    if (dh != null) {
                        Util.qualityClose(dh.mInputStream);
                    }
                } catch (Throwable th) {
                    if (dh != null) {
                        Util.qualityClose(dh.mInputStream);
                    }
                    AppMethodBeat.o(121249);
                    throw th;
                }
            }
            if (dh != null) {
                Util.qualityClose(dh.mInputStream);
            }
            AppMethodBeat.o(121249);
            return null;
        }
        AppMethodBeat.o(121249);
        return EP;
    }
}
