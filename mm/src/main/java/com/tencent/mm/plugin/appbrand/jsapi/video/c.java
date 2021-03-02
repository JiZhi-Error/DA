package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.a.d;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.h;
import com.google.android.exoplayer2.h.a.k;
import com.google.android.exoplayer2.h.a.l;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.io.File;
import java.io.IOException;

public class c implements b, g {
    private static c mwM;
    private a bFT;
    e mwL;

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(234624);
        Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
        AppMethodBeat.o(234624);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(234625);
        Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
        AppMethodBeat.o(234625);
    }

    public static c bJr() {
        AppMethodBeat.i(234626);
        if (mwM == null) {
            synchronized (c.class) {
                try {
                    if (mwM == null) {
                        mwM = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(234626);
                    throw th;
                }
            }
        }
        c cVar = mwM;
        AppMethodBeat.o(234626);
        return cVar;
    }

    private c() {
        int indexOf;
        AppMethodBeat.i(234627);
        String processName = MMApplicationContext.getProcessName();
        String str = "main";
        if (!Util.isNullOrNil(processName) && (indexOf = processName.indexOf(":")) >= 0 && processName.length() >= indexOf + 1) {
            str = processName.substring(indexOf + 1);
        }
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        try {
            s.dy((!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? aKJ + FilePathGenerator.ANDROID_DIR_SEP : aKJ) + "wxavideocache/", true);
        } catch (Throwable th) {
            Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", th);
        }
        String aKJ2 = com.tencent.mm.loader.j.b.aKJ();
        String str2 = (!aKJ2.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? aKJ2 + FilePathGenerator.ANDROID_DIR_SEP : aKJ2) + "videocache/" + str + FilePathGenerator.ANDROID_DIR_SEP;
        try {
            if (!s.boN(str2)) {
                Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
                if (!new o(str2).isDirectory()) {
                    Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
                    s.deleteFile(str2);
                    if (!s.boN(str2)) {
                        Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
                        AppMethodBeat.o(234627);
                        return;
                    }
                }
            }
            o oVar = new o(str2);
            this.bFT = new l(new File(s.k(aa.z(oVar.her()), true)), new k(TPAudioFrame.TP_CH_STEREO_LEFT));
            Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", aa.z(oVar.her()));
            this.mwL = new e(this.bFT, g.dY(MMApplicationContext.getContext()), new r(), new com.google.android.exoplayer2.h.a.c(this.bFT, 10485760), 2, new d.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.c.AnonymousClass1 */

                @Override // com.google.android.exoplayer2.h.a.d.a
                public final void k(long j2, long j3) {
                    AppMethodBeat.i(234619);
                    Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", Long.valueOf(j2), Long.valueOf(j3));
                    AppMethodBeat.o(234619);
                }
            });
            Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", this.bFT);
            AppMethodBeat.o(234627);
        } catch (Throwable th2) {
            Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", th2);
            AppMethodBeat.o(234627);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final String getProxyUrl(String str) {
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final void o(final String str, final long j2, final long j3) {
        AppMethodBeat.i(234628);
        if (this.bFT == null) {
            Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, cache is null");
            AppMethodBeat.o(234628);
            return;
        }
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(234623);
                Uri parse = Uri.parse(str);
                String aaV = j.bJE().aaV(str);
                j jVar = new j(parse, j2, j3, aaV);
                h.a aVar = new h.a();
                c.this.bFT.a(aaV, new a.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.video.c.AnonymousClass2.AnonymousClass1 */

                    @Override // com.google.android.exoplayer2.h.a.a.b
                    public final void a(a aVar, com.google.android.exoplayer2.h.a.g gVar) {
                        AppMethodBeat.i(234620);
                        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", Boolean.valueOf(gVar.bGq), Long.valueOf(gVar.position), Long.valueOf(gVar.length));
                        AppMethodBeat.o(234620);
                    }

                    @Override // com.google.android.exoplayer2.h.a.a.b
                    public final void c(com.google.android.exoplayer2.h.a.g gVar) {
                        AppMethodBeat.i(234621);
                        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", Boolean.valueOf(gVar.bGq), Long.valueOf(gVar.position), Long.valueOf(gVar.length));
                        AppMethodBeat.o(234621);
                    }

                    @Override // com.google.android.exoplayer2.h.a.a.b
                    public final void a(a aVar, com.google.android.exoplayer2.h.a.g gVar, com.google.android.exoplayer2.h.a.g gVar2) {
                        AppMethodBeat.i(234622);
                        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", Boolean.valueOf(gVar.bGq), Long.valueOf(gVar.position), Long.valueOf(gVar.length));
                        AppMethodBeat.o(234622);
                    }
                });
                try {
                    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, position:%s, length:%s, url:%s", Long.valueOf(j2), Long.valueOf(j3), str);
                    a aVar2 = c.this.bFT;
                    d wR = c.this.mwL.wR();
                    byte[] bArr = new byte[131072];
                    com.google.android.exoplayer2.i.a.checkNotNull(wR);
                    com.google.android.exoplayer2.i.a.checkNotNull(bArr);
                    String c2 = h.c(jVar);
                    long j2 = jVar.bEP;
                    long bp = jVar.length != -1 ? jVar.length : aVar2.bp(c2);
                    aVar.contentLength = bp;
                    aVar.bGs = 0;
                    aVar.bGt = 0;
                    while (bp != 0) {
                        long f2 = aVar2.f(c2, j2, bp != -1 ? bp : MAlarmHandler.NEXT_FIRE_INTERVAL);
                        if (f2 <= 0) {
                            f2 = -f2;
                            if (f2 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                                break;
                            }
                        } else {
                            aVar.bGs += f2;
                        }
                        long j3 = j2 + f2;
                        bp -= bp == -1 ? 0 : f2;
                        j2 = j3;
                    }
                    String c3 = h.c(jVar);
                    long j4 = jVar.bEP;
                    long bp2 = jVar.length != -1 ? jVar.length : aVar2.bp(c3);
                    while (bp2 != 0) {
                        long f3 = aVar2.f(c3, j4, bp2 != -1 ? bp2 : MAlarmHandler.NEXT_FIRE_INTERVAL);
                        if (f3 <= 0) {
                            long j5 = -f3;
                            if (h.a(jVar, j4, j5, wR, bArr, aVar) < j5) {
                                break;
                            }
                            f3 = j5;
                        }
                        long j6 = j4 + f3;
                        bp2 -= bp2 == -1 ? 0 : f3;
                        j4 = j6;
                    }
                    AppMethodBeat.o(234623);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", e2, "cache IOException", new Object[0]);
                    AppMethodBeat.o(234623);
                } catch (IllegalArgumentException e3) {
                    Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", e3, "cache IllegalArgumentException", new Object[0]);
                    AppMethodBeat.o(234623);
                } catch (InterruptedException e4) {
                    Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", e4, "cache InterruptedException", new Object[0]);
                    AppMethodBeat.o(234623);
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", e5, "cache Exception", new Object[0]);
                    AppMethodBeat.o(234623);
                }
            }
        });
        AppMethodBeat.o(234628);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final long f(String str, long j2, long j3) {
        AppMethodBeat.i(234629);
        if (this.bFT == null) {
            Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
            AppMethodBeat.o(234629);
            return 0;
        }
        Uri.parse(str);
        long f2 = this.bFT.f(j.bJE().aaV(str), j2, j3);
        Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", Long.valueOf(f2), Long.valueOf(j2), Long.valueOf(j3), str);
        AppMethodBeat.o(234629);
        return f2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.g
    public final g.a bJs() {
        return this.mwL;
    }
}
