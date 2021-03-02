package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class h extends b {
    public WepkgVersion JNh;
    public g JNr;
    private Map<String, WepkgPreloadFile> JNs;
    private String charset = MimeTypeUtil.ContentType.DEFAULT_CHARSET;

    public h(int i2, boolean z, String str) {
        super(i2, z, str);
    }

    public h(WepkgVersion wepkgVersion, g gVar, Map<String, WepkgPreloadFile> map) {
        super(0, true, wepkgVersion.version);
        AppMethodBeat.i(110705);
        this.JNh = wepkgVersion;
        this.JNr = gVar;
        this.JNs = map;
        if (wepkgVersion != null && !Util.isNullOrNil(wepkgVersion.charset)) {
            this.charset = wepkgVersion.charset;
        }
        AppMethodBeat.o(110705);
    }

    public final boolean bcE(String str) {
        AppMethodBeat.i(110706);
        WebResourceResponse bcB = bcB(d.bcQ(str));
        if (bcB != null) {
            InputStream inputStream = bcB.mInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(110706);
            return true;
        }
        AppMethodBeat.o(110706);
        return false;
    }

    public final WebResourceResponse bcB(String str) {
        AppMethodBeat.i(110707);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110707);
            return null;
        }
        if (!(this.JNs == null || this.JNs.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = this.JNs.get(str);
            if (!Util.isNullOrNil(wepkgPreloadFile.filePath)) {
                o oVar = new o(wepkgPreloadFile.filePath);
                if (oVar.exists() && oVar.isFile() && oVar.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        Log.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", str, wepkgPreloadFile.filePath);
                        WebResourceResponse webResourceResponse = new WebResourceResponse(wepkgPreloadFile.mimeType, this.charset, s.ao(oVar));
                        AppMethodBeat.o(110707);
                        return webResourceResponse;
                    } catch (FileNotFoundException e2) {
                    }
                }
            }
        }
        if (this.JNr != null) {
            WebResourceResponse mt = this.JNr.mt(str, this.charset);
            AppMethodBeat.o(110707);
            return mt;
        }
        AppMethodBeat.o(110707);
        return null;
    }

    public final String anz(String str) {
        AppMethodBeat.i(110708);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110708);
            return null;
        }
        if (!(this.JNs == null || this.JNs.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = this.JNs.get(str);
            if (!Util.isNullOrNil(wepkgPreloadFile.filePath)) {
                o oVar = new o(wepkgPreloadFile.filePath);
                if (oVar.exists() && oVar.isFile() && oVar.length() == ((long) wepkgPreloadFile.size)) {
                    String str2 = wepkgPreloadFile.filePath;
                    AppMethodBeat.o(110708);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(110708);
        return null;
    }
}
