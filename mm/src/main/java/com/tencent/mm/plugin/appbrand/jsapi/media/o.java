package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class o extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final boolean aaa(String str) {
        AppMethodBeat.i(139885);
        boolean contains = Util.nullAsNil(str).toLowerCase().contains("video");
        AppMethodBeat.o(139885);
        return contains;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final String aab(String str) {
        AppMethodBeat.i(139886);
        if (TextUtils.isEmpty(str)) {
            str = "mp4";
        }
        String exportImagePath = AndroidMediaUtil.getExportImagePath(str);
        AppMethodBeat.o(139886);
        return exportImagePath;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.media.a
    public final void aac(final String str) {
        AppMethodBeat.i(139887);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139884);
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(str)), 1).show();
                AppMethodBeat.o(139884);
            }
        });
        AppMethodBeat.o(139887);
    }
}
