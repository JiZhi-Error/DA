package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class n extends a {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final boolean aaa(String str) {
        AppMethodBeat.i(139881);
        boolean contains = Util.nullAsNil(str).toLowerCase().contains("image");
        AppMethodBeat.o(139881);
        return contains;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final String aab(String str) {
        AppMethodBeat.i(139882);
        String exportImagePath = AndroidMediaUtil.getExportImagePath(str);
        AppMethodBeat.o(139882);
        return exportImagePath;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final void aac(String str) {
        AppMethodBeat.i(139883);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.n.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139880);
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.bjr, AndroidMediaUtil.getToastSysCameraPath()), 1).show();
                AppMethodBeat.o(139880);
            }
        });
        AppMethodBeat.o(139883);
    }
}
