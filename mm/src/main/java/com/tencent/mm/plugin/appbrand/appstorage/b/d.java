package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/LegacyFolder;", "", SharePatchInfo.OAT_DIR, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDir", "()Ljava/lang/String;", "imagecache", "wxafiles", "wxanewfiles", "plugin-appbrand-integration_release"})
public enum d {
    imagecache("wxacache"),
    wxafiles("wxafiles"),
    wxanewfiles("wxanewfiles");
    
    public final String dir;

    public static d valueOf(String str) {
        AppMethodBeat.i(175126);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(175126);
        return dVar;
    }

    private d(String str) {
        this.dir = str;
    }

    static {
        AppMethodBeat.i(175124);
        AppMethodBeat.o(175124);
    }
}
