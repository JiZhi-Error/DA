package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class l {
    private static volatile l myE;
    public m myF = new m();
    private Set<String> myG = Collections.synchronizedSet(new HashSet());

    static /* synthetic */ boolean a(l lVar, String str, long j2, long j3, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(234799);
        boolean a2 = lVar.a(str, j2, j3, i2, z, z2);
        AppMethodBeat.o(234799);
        return a2;
    }

    private l() {
        AppMethodBeat.i(234791);
        AppMethodBeat.o(234791);
    }

    public static l bJT() {
        AppMethodBeat.i(234792);
        if (myE == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Video SDK has not been initialized! Call init() first!");
            AppMethodBeat.o(234792);
            throw illegalStateException;
        }
        l lVar = myE;
        AppMethodBeat.o(234792);
        return lVar;
    }

    public static void init() {
        AppMethodBeat.i(234793);
        if (myE == null) {
            synchronized (l.class) {
                try {
                    if (myE == null) {
                        myE = new l();
                    }
                } finally {
                    AppMethodBeat.o(234793);
                }
            }
            return;
        }
        AppMethodBeat.o(234793);
    }

    private boolean isCached(String str) {
        AppMethodBeat.i(234794);
        m mVar = this.myF;
        if (TextUtils.isEmpty(str) || mVar.mxs == null) {
            AppMethodBeat.o(234794);
            return false;
        }
        boolean isCached = mVar.mxs.isCached(h.abl(str));
        AppMethodBeat.o(234794);
        return isCached;
    }

    public final long aba(String str) {
        AppMethodBeat.i(234795);
        long aba = this.myF.aba(str);
        AppMethodBeat.o(234795);
        return aba;
    }

    public final boolean U(final String str, final long j2) {
        boolean z;
        AppMethodBeat.i(234796);
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            h.log(4, "VideoManager", "preload, not valid url, url=".concat(String.valueOf(str)));
            AppMethodBeat.o(234796);
            return false;
        } else if (!a.bJK().mxf) {
            h.log(4, "VideoManager", "preload, video proxy & cache disabled");
            AppMethodBeat.o(234796);
            return false;
        } else if (this.myG.contains(str)) {
            h.log(4, "VideoManager", "preload, same url in preloading, url=".concat(String.valueOf(str)));
            AppMethodBeat.o(234796);
            return false;
        } else if (h.aaW(str)) {
            h.log(4, "VideoManager", "preload, m3u8 is not supported, url=".concat(String.valueOf(str)));
            AppMethodBeat.o(234796);
            return false;
        } else if (isCached(str)) {
            h.log(4, "VideoManager", "preload, video already cached, url=".concat(String.valueOf(str)));
            AppMethodBeat.o(234796);
            return true;
        } else {
            if (j2 == -1 || aba(str) < j2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                h.log(4, "VideoManager", "preload, no need to preload, preloadSync skipped, url=".concat(String.valueOf(str)));
                AppMethodBeat.o(234796);
                return false;
            }
            try {
                m.a(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l.AnonymousClass1 */
                    final /* synthetic */ long myJ = 0;
                    final /* synthetic */ int myK = 0;
                    final /* synthetic */ boolean myL = true;
                    final /* synthetic */ boolean myM = false;
                    final /* synthetic */ b myN = null;

                    public final void run() {
                        AppMethodBeat.i(234789);
                        l.a(l.this, str, j2, this.myJ, this.myK, this.myL, this.myM);
                        AppMethodBeat.o(234789);
                    }
                }, "preloadAsync");
            } catch (Exception e2) {
                h.log(6, "VideoManager", "preload, preloadSync error, url=" + str + " msg=" + e2.getMessage());
            }
            AppMethodBeat.o(234796);
            return true;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x016a A[Catch:{ all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x031e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r21, long r22, long r24, int r26, boolean r27, boolean r28) {
        /*
        // Method dump skipped, instructions count: 1604
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l.a(java.lang.String, long, long, int, boolean, boolean):boolean");
    }

    public final void b(ArrayList<i> arrayList, final String str) {
        AppMethodBeat.i(234798);
        if (TextUtils.isEmpty(str)) {
            str = "preloadMediasAsync";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            final i next = it.next();
            boolean z = true;
            if (-1 == -1) {
                z = !isCached(next.myD);
            } else if (-1 > 0) {
                long aba = -1 - this.myF.mxs.aba(h.abl(next.myD));
                h.log(3, str, "preloadMediasAsync, remainingBytes2Cache " + aba + ", url=" + next.myD);
                z = aba > 0;
            }
            if (z) {
                arrayList2.add(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l.AnonymousClass2 */
                    final /* synthetic */ long myQ = -1;
                    final /* synthetic */ j myR = null;

                    public final void run() {
                        AppMethodBeat.i(234790);
                        l.a(next.proxyUrl, this.myQ, this.myR, str);
                        AppMethodBeat.o(234790);
                    }
                });
            } else {
                h.log(4, str, "preloadMediasAsync, url " + next.myD + " already cached, cacheMaxBytes=-1");
            }
        }
        if (arrayList2.size() > 0) {
            m.G(arrayList2);
        }
        AppMethodBeat.o(234798);
    }

    static /* synthetic */ void a(String str, long j2, j jVar, String str2) {
        AppMethodBeat.i(234800);
        j jVar2 = new j("com.tencent.mm.video");
        String concat = "VideoManager/sendUrlRequest/".concat(String.valueOf(str2));
        long j3 = -1;
        byte[] bArr = new byte[512];
        long j4 = 0;
        h.log(4, concat, "sendUrlRequest start url=".concat(String.valueOf(str)));
        try {
            jVar2.a(new g(Uri.parse(str), 0));
            j3 = jVar2.getTotalLength();
            while (true) {
                long read = (long) jVar2.read(bArr, 0, 512);
                if (read == -1) {
                    break;
                }
                j4 += read;
                if (j2 > 0 && j2 != -1 && j4 >= j2) {
                    break;
                }
            }
            h.log(4, concat, "sendUrlRequest finish, totalReadBytes=".concat(String.valueOf(j4)));
            try {
                jVar2.close();
            } catch (Exception e2) {
                h.log(4, concat, "sendUrlRequest closeException".concat(String.valueOf(e2)));
            }
            if (jVar != null) {
            }
        } catch (Exception e3) {
            h.log(4, concat, "sendUrlRequest fail with message" + e3.getMessage());
            try {
                jVar2.close();
            } catch (Exception e4) {
                h.log(4, concat, "sendUrlRequest closeException".concat(String.valueOf(e4)));
            }
            if (jVar != null) {
            }
        } catch (Throwable th) {
            try {
                jVar2.close();
            } catch (Exception e5) {
                h.log(4, concat, "sendUrlRequest closeException".concat(String.valueOf(e5)));
            }
            AppMethodBeat.o(234800);
            throw th;
        }
        h.log(4, concat, "sendUrlRequest totalLength=" + j3 + ", totalReadBytes=" + j4);
        AppMethodBeat.o(234800);
    }
}
