package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al {
    private static final Set<String> IZe;

    static {
        String str;
        AppMethodBeat.i(78986);
        HashSet hashSet = new HashSet();
        IZe = hashSet;
        hashSet.add("file:///android_asset/");
        String aKC = b.aKC();
        if (!Util.isNullOrNil(aKC)) {
            str = b.aKC().replace("/data/user/0", "/data/data");
        } else {
            str = aKC;
        }
        o oVar = new o(ai.afw(0));
        IZe.add("file://" + aa.z(oVar.her()));
        IZe.add("file://" + ((j) g.af(j.class)).fXy());
        o oVar2 = new o(b.aKJ(), ai.afv(0));
        IZe.add("file://" + aa.z(oVar2.her()));
        IZe.add("file://" + aa.z(new o(str, "wenote/res").her()));
        IZe.add("file://" + aa.z(new o(b.aKJ(), "wenote/res").her()));
        Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", aa.z(oVar.her()), aa.z(oVar2.her()));
        o oVar3 = new o(str, "emoji/res");
        IZe.add("file://" + aa.z(oVar3.her()));
        o oVar4 = new o(b.aKJ(), "emoji/res");
        IZe.add("file://" + aa.z(oVar4.her()));
        Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", aa.z(oVar3.her()), aa.z(oVar4.her()));
        Iterator<String> it = IZe.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", it.next());
        }
        AppMethodBeat.o(78986);
    }

    public static boolean aYH(String str) {
        AppMethodBeat.i(78985);
        if (ac.jOz) {
            Log.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            AppMethodBeat.o(78985);
            return true;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(78985);
            return true;
        } else {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("about:blank")) {
                AppMethodBeat.o(78985);
                return false;
            } else if (!lowerCase.startsWith("file://")) {
                Uri parse = Uri.parse(lowerCase);
                if (Util.isNullOrNil(parse.getHost())) {
                    AppMethodBeat.o(78985);
                    return true;
                } else if (!parse.getHost().contains(h.Ph())) {
                    AppMethodBeat.o(78985);
                    return true;
                } else {
                    AppMethodBeat.o(78985);
                    return false;
                }
            } else {
                for (String str2 : IZe) {
                    if (lowerCase.startsWith(str2)) {
                        AppMethodBeat.o(78985);
                        return true;
                    }
                }
                AppMethodBeat.o(78985);
                return false;
            }
        }
    }
}
