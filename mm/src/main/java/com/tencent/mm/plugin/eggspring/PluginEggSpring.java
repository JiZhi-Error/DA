package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.eggspring.c.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.n.n;

public class PluginEggSpring extends f implements c, a {
    private static final String qUE = b.aLB();
    public static final String qUF;
    public static final String qUG = (qUF + "innerLuckyBag.wxam");
    private final Set<String> qUH = new HashSet();

    public PluginEggSpring() {
        AppMethodBeat.i(194690);
        AppMethodBeat.o(194690);
    }

    static /* synthetic */ void access$100(PluginEggSpring pluginEggSpring) {
        AppMethodBeat.i(162215);
        pluginEggSpring.initDir();
        AppMethodBeat.o(162215);
    }

    static {
        AppMethodBeat.i(108141);
        StringBuilder sb = new StringBuilder();
        b.a aVar = com.tencent.mm.plugin.eggspring.c.b.qVd;
        StringBuilder sb2 = new StringBuilder();
        String aKC = com.tencent.mm.loader.j.b.aKC();
        p.g(aKC, "CConstants.DATAROOT_PUBLIC_PATH()");
        qUF = sb.append(sb2.append(n.j(aKC, "/data/user/0", "/data/data", false)).append("/emoji/").toString()).append("egg_spring/").toString();
        AppMethodBeat.o(108141);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(108135);
        Log.i("MicroMsg.PluginEggSpring", "onAccountInitialized");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.eggspring.PluginEggSpring.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(108134);
                if (1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_delete_egg_spring_media, 0)) {
                    Log.i("MicroMsg.PluginEggSpring", "clear useless media.");
                    s.dy(PluginEggSpring.qUE, true);
                    s.dy(PluginEggSpring.qUF, true);
                    AppMethodBeat.o(108134);
                    return;
                }
                PluginEggSpring.access$100(PluginEggSpring.this);
                AppMethodBeat.o(108134);
            }
        }, "init_egg_spring_dir");
        AppMethodBeat.o(108135);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(108136);
        Log.i("MicroMsg.PluginEggSpring", "onAccountRelease");
        AppMethodBeat.o(108136);
    }

    private void initDir() {
        AppMethodBeat.i(108137);
        copyAsset("innerLuckyBag.wxam", qUG);
        AppMethodBeat.o(108137);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(160271);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b3, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b4, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b5, code lost:
        if (r5 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b7, code lost:
        if (r3 != null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bc, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(160271);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c2, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c8, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cb, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00cf, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c7 A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copyAsset(java.lang.String r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.PluginEggSpring.copyAsset(java.lang.String, java.lang.String):void");
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(108138);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(108138);
                return;
            }
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(108139);
        Log.i("MicroMsg.PluginEggSpring", "execute");
        AppMethodBeat.o(108139);
    }

    @Override // com.tencent.mm.plugin.eggspring.a.a
    public void prefetch(String str) {
        AppMethodBeat.i(194691);
        this.qUH.add(str);
        if (h.azD(str) != null) {
            Log.i("MicroMsg.PluginEggSpring", "has prefetch %s", str);
            AppMethodBeat.o(194691);
            return;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_egg_preload_url, 0);
        Log.i("MicroMsg.PluginEggSpring", "prefetch %s: config %s", str, Integer.valueOf(a2));
        if (a2 == 1) {
            h.a(i.class, str, new h.a() {
                /* class com.tencent.mm.plugin.eggspring.PluginEggSpring.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.game.luggage.h.a
                public final void callback() {
                    AppMethodBeat.i(194689);
                    Log.i("MicroMsg.PluginEggSpring", "prefetch callback");
                    AppMethodBeat.o(194689);
                }
            });
        }
        AppMethodBeat.o(194691);
    }

    @Override // com.tencent.mm.plugin.eggspring.a.a
    public void cleanPrefetch() {
        AppMethodBeat.i(194692);
        Log.i("MicroMsg.PluginEggSpring", "cleanPrefetch: ");
        for (String str : this.qUH) {
            h.remove(str);
        }
        this.qUH.clear();
        AppMethodBeat.o(194692);
    }
}
