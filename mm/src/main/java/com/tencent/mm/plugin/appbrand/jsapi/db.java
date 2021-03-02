package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"TAG", "", "parseFileName", "filePath", "fileExt", DownloadInfo.FILENAME, "plugin-appbrand-integration_release"})
public final class db {
    public static final String D(String str, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(228298);
        p.h(str, "filePath");
        String str4 = str3;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str5 = str2;
            str3 = new o(str).getName() + (!(str5 == null || str5.length() == 0) ? ".".concat(String.valueOf(str2)) : "");
        }
        Log.i("MicroMsg.AppBrand.SendVideoCommons", "parseFileName, fileName: ".concat(String.valueOf(str3)));
        AppMethodBeat.o(228298);
        return str3;
    }
}
