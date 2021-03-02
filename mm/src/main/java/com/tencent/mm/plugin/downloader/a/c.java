package com.tencent.mm.plugin.downloader.a;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static final String[] qFB = {"dlied4.myapp.com", "dlied5.myapp.com"};
    private static final Map<String, String> qFC = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(123485);
        AppMethodBeat.o(123485);
    }

    public static synchronized void h(String str, String... strArr) {
        synchronized (c.class) {
            AppMethodBeat.i(123480);
            if (!Util.isNullOrNil(str)) {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (!Util.isNullOrNil(strArr[i2])) {
                        qFC.put(strArr[i2], str);
                    }
                }
            }
            AppMethodBeat.o(123480);
        }
    }

    public static synchronized void w(String... strArr) {
        synchronized (c.class) {
            AppMethodBeat.i(123481);
            for (int i2 = 0; i2 < 2; i2++) {
                if (!Util.isNullOrNil(strArr[i2])) {
                    qFC.remove(strArr[i2]);
                }
            }
            AppMethodBeat.o(123481);
        }
    }

    public static void clearCache() {
        AppMethodBeat.i(123482);
        qFC.clear();
        AppMethodBeat.o(123482);
    }

    private static String fG(String str, String str2) {
        String str3;
        AppMethodBeat.i(123484);
        try {
            URI uri = new URI(str);
            String query = uri.getQuery();
            if (query == null) {
                str3 = str2;
            } else {
                str3 = query + "&" + str2;
            }
            str = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString();
            AppMethodBeat.o(123484);
        } catch (URISyntaxException e2) {
            AppMethodBeat.o(123484);
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class a implements k<IPCString, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            String bdK;
            AppMethodBeat.i(123479);
            IPCString iPCString2 = iPCString;
            if (iPCString2 == null) {
                AppMethodBeat.o(123479);
                return null;
            }
            String str = iPCString2.value;
            String str2 = (String) c.qFC.get(str);
            if (Util.isNullOrNil(str2)) {
                jg jgVar = new jg();
                jgVar.dNY.url = str;
                EventCenter.instance.publish(jgVar);
                str2 = jgVar.dNZ.dNI;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Log.i("MicroMsg.GameDownloadExtension", "getOpenId invoke in main thread");
                g o = h.o(str2, false, false);
                bdK = (o == null || Util.isNullOrNil(o.field_openId)) ? null : o.field_openId;
            } else {
                Log.i("MicroMsg.GameDownloadExtension", "getOpenId invoke in worker thread");
                com.tencent.mm.plugin.r.a.eAU();
                bdK = n.bdK(str2);
            }
            IPCString iPCString3 = new IPCString(bdK);
            AppMethodBeat.o(123479);
            return iPCString3;
        }
    }

    public static String akX(String str) {
        String host;
        String str2;
        AppMethodBeat.i(123483);
        if (Util.isNullOrNil(str)) {
            host = "";
        } else {
            host = Uri.parse(str).getHost();
        }
        if (Util.isNullOrNil(host) || !Arrays.asList(qFB).contains(host)) {
            Log.i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
            AppMethodBeat.o(123483);
            return str;
        }
        IPCString iPCString = (IPCString) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), a.class);
        if (iPCString != null) {
            str2 = iPCString.value;
        } else {
            str2 = "";
        }
        String fG = fG(fG(str, String.format("openid=%s", str2)), "p=wechat");
        Log.i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", fG);
        AppMethodBeat.o(123483);
        return fG;
    }
}
