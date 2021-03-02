package com.tencent.mm.plugin.mv.ui.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.util.LruCache;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mv.ui.b.d;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.g;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.x;

public final class b implements g {
    private static final LruCache<String, Bitmap> Asq = new LruCache<>(200);
    public static final a Asr = new a((byte) 0);
    private final d Asl = new d(this.Asp.width, this.Asp.height);
    private final LinkedList<C1553b> Asm = new LinkedList<>();
    private com.tencent.mm.plugin.thumbplayer.e.b Asn;
    private boolean Aso;
    final c Asp;
    private final String TAG = ("MicroMsg.TPTrackThumbFetcher@" + hashCode());
    private final String cacheKey = this.Asp.AsA.url;
    private volatile boolean isRunning;
    private Bitmap wKi;

    static final class c extends q implements kotlin.g.a.b<C1553b, Boolean> {
        final /* synthetic */ b Ass;
        final /* synthetic */ long Asx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, long j2) {
            super(1);
            this.Ass = bVar;
            this.Asx = j2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(C1553b bVar) {
            boolean z;
            AppMethodBeat.i(257054);
            C1553b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            if (bVar2.Asv == this.Asx) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(257054);
            return valueOf;
        }
    }

    public static final class d extends q implements kotlin.g.a.b<C1553b, Boolean> {
        final /* synthetic */ b Ass;
        final /* synthetic */ long Asy;
        final /* synthetic */ z.e Asz;
        final /* synthetic */ Bitmap zZz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, long j2, z.e eVar, Bitmap bitmap) {
            super(1);
            this.Ass = bVar;
            this.Asy = j2;
            this.Asz = eVar;
            this.zZz = bitmap;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(C1553b bVar) {
            boolean z;
            AppMethodBeat.i(257055);
            C1553b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            if (bVar2.Asv == this.Asy) {
                this.Asz.SYF = bVar2.Asv;
                bVar2.gWp.invoke(Long.valueOf(bVar2.Asv), this.zZz);
                Log.i(this.Ass.TAG, "callback " + bVar2.Asv + ", " + this.zZz);
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(257055);
            return valueOf;
        }
    }

    public b(c cVar, final b.C1836b bVar) {
        boolean z;
        boolean z2;
        p.h(cVar, "trackInfo");
        p.h(bVar, "loader");
        AppMethodBeat.i(257062);
        this.Asp = cVar;
        if (s.YS(this.Asp.AsA.thumbPath)) {
            evI();
            Log.i(this.TAG, "init check first thumb exist");
        } else {
            if (this.Asp.AsA.thumbPath.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.Asp.AsA.thumbUrl.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    c.a aVar = new c.a();
                    aVar.OS(this.Asp.AsA.thumbPath);
                    aVar.bdp();
                    aVar.bdo();
                    com.tencent.mm.av.q.bcV().a(this.Asp.AsA.thumbUrl, aVar.bdv(), new com.tencent.mm.av.a.c.d(this) {
                        /* class com.tencent.mm.plugin.mv.ui.b.b.AnonymousClass1 */
                        final /* synthetic */ b Ass;

                        {
                            this.Ass = r1;
                        }

                        @Override // com.tencent.mm.av.a.c.d
                        public final void a(boolean z, Object[] objArr) {
                            AppMethodBeat.i(257043);
                            if (z) {
                                b.b(this.Ass);
                                Log.i(this.Ass.TAG, "init download first thumb succ");
                            }
                            AppMethodBeat.o(257043);
                        }
                    });
                }
            }
        }
        final Object obj = new Object();
        h.RTc.aV(new Runnable(this) {
            /* class com.tencent.mm.plugin.mv.ui.b.b.AnonymousClass2 */
            final /* synthetic */ b Ass;

            {
                this.Ass = r1;
            }

            public final void run() {
                AppMethodBeat.i(257048);
                Log.i(this.Ass.TAG, "create new TPTrackThumbFetcher, mediaInfo:" + this.Ass.Asp.AsA + ", loader.isAllComplete:" + bVar.GhM);
                b bVar = this.Ass;
                d.a aVar = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                bVar.Asn = d.a.hu(context);
                com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Ass.Asn;
                if (bVar2 != null) {
                    bVar2.fwW();
                }
                com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Ass.Asn;
                if (bVar3 != null) {
                    b.C1836b bVar4 = bVar;
                    com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Ass.Asp.AsA;
                    p.h(bVar4, "loader");
                    p.h(aVar2, "mediaInfo");
                    Log.i(bVar3.TAG, "setCdnResourceLoader, loader:" + bVar4.hashCode() + ", mediaId:" + bVar4.mediaId + ", isMoovReady:" + bVar4.uTW);
                    bVar3.GhA = bVar4;
                    bVar3.Ghy = aVar2;
                    bVar3.wdU = true;
                    bVar3.fwX();
                    bVar3.GhJ = true;
                }
                this.Ass.Aso = bVar.GhM;
                com.tencent.mm.plugin.thumbplayer.e.b bVar5 = this.Ass.Asn;
                if (bVar5 != null) {
                    bVar5.wcA = true;
                }
                com.tencent.mm.plugin.thumbplayer.e.b bVar6 = this.Ass.Asn;
                if (bVar6 != null) {
                    bVar6.GhI = true;
                }
                bVar.GhO = new m<String, Integer, x>(this) {
                    /* class com.tencent.mm.plugin.mv.ui.b.b.AnonymousClass2.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass2 Asu;

                    {
                        this.Asu = r2;
                    }

                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(String str, Integer num) {
                        AppMethodBeat.i(257044);
                        num.intValue();
                        b.d(this.Asu.Ass);
                        x xVar = x.SXb;
                        AppMethodBeat.o(257044);
                        return xVar;
                    }
                };
                d dVar = this.Ass.Asl;
                com.tencent.mm.plugin.thumbplayer.d.a aVar3 = this.Ass.Asp.AsA;
                p.h(aVar3, "mediaInfo");
                Log.i(dVar.TAG, "mediaInfo:".concat(String.valueOf(aVar3)));
                dVar.AsA = aVar3;
                d dVar2 = this.Ass.Asl;
                AnonymousClass2 r0 = new kotlin.g.a.b<Surface, x>(this) {
                    /* class com.tencent.mm.plugin.mv.ui.b.b.AnonymousClass2.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass2 Asu;

                    {
                        this.Asu = r2;
                    }

                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Surface surface) {
                        AppMethodBeat.i(257045);
                        Surface surface2 = surface;
                        p.h(surface2, LocaleUtil.ITALIAN);
                        Log.i(this.Asu.Ass.TAG, "thumbRenderer setup finished");
                        com.tencent.mm.plugin.thumbplayer.e.b bVar = this.Asu.Ass.Asn;
                        if (bVar != null) {
                            bVar.b(surface2, true);
                        }
                        com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Asu.Ass.Asn;
                        if (bVar2 != null) {
                            bVar2.fwU();
                        }
                        synchronized (obj) {
                            try {
                                obj.notifyAll();
                            } catch (Exception e2) {
                                Log.printErrStackTrace(this.Asu.Ass.TAG, e2, "notify init thumb fetcher error", new Object[0]);
                            }
                            try {
                                x xVar = x.SXb;
                            } catch (Throwable th) {
                                AppMethodBeat.o(257045);
                                throw th;
                            }
                        }
                        x xVar2 = x.SXb;
                        AppMethodBeat.o(257045);
                        return xVar2;
                    }
                };
                p.h(r0, "afterSurfaceCreated");
                Log.i(dVar2.TAG, "setup, output size:[" + dVar2.width + ',' + dVar2.height + ']');
                dVar2.AsE = r0;
                HandlerThread hz = com.tencent.f.c.d.hz("TPTrackThumbRenderer@" + dVar2.hashCode(), 0);
                hz.start();
                dVar2.AsD = new MMHandler(hz.getLooper());
                dVar2.AsC = hz;
                dVar2.k(new d.b(dVar2));
                dVar2.k(new d.c(dVar2));
                dVar2.k(new d.C1554d(dVar2));
                dVar2.k(new d.f(dVar2));
                d dVar3 = this.Ass.Asl;
                AnonymousClass3 r02 = new m<Bitmap, Long, x>(this.Ass) {
                    /* class com.tencent.mm.plugin.mv.ui.b.b.AnonymousClass2.AnonymousClass3 */

                    @Override // kotlin.g.b.e
                    public final kotlin.l.d Rs() {
                        AppMethodBeat.i(257047);
                        kotlin.l.b bp = aa.bp(b.class);
                        AppMethodBeat.o(257047);
                        return bp;
                    }

                    @Override // kotlin.l.a, kotlin.g.b.e
                    public final String getName() {
                        return "onFrameGenerated";
                    }

                    @Override // kotlin.g.b.e
                    public final String getSignature() {
                        return "onFrameGenerated(Landroid/graphics/Bitmap;J)V";
                    }

                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Bitmap bitmap, Long l) {
                        AppMethodBeat.i(257046);
                        Bitmap bitmap2 = bitmap;
                        long longValue = l.longValue();
                        p.h(bitmap2, "p1");
                        b.a((b) this.SYl, bitmap2, longValue);
                        x xVar = x.SXb;
                        AppMethodBeat.o(257046);
                        return xVar;
                    }
                };
                p.h(r02, "callback");
                dVar3.AsK = r02;
                AppMethodBeat.o(257048);
            }
        });
        synchronized (obj) {
            try {
                obj.wait();
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "wait init thumb fetcher error", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(257062);
                throw th;
            }
        }
        Log.i(this.TAG, "init thumb fetcher finished");
        AppMethodBeat.o(257062);
    }

    public static final /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(257064);
        bVar.evI();
        AppMethodBeat.o(257064);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257063);
        AppMethodBeat.o(257063);
    }

    /* renamed from: com.tencent.mm.plugin.mv.ui.b.b$b */
    public static final class C1553b {
        final long Asv;
        private final CMTime Asw;
        final m<Long, Bitmap, x> gWp;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
            if (kotlin.g.b.p.j(r5.Asw, r6.Asw) != false) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 257053(0x3ec1d, float:3.60208E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x002a
                boolean r0 = r6 instanceof com.tencent.mm.plugin.mv.ui.b.b.C1553b
                if (r0 == 0) goto L_0x002f
                com.tencent.mm.plugin.mv.ui.b.b$b r6 = (com.tencent.mm.plugin.mv.ui.b.b.C1553b) r6
                long r0 = r5.Asv
                long r2 = r6.Asv
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002f
                kotlin.g.a.m<java.lang.Long, android.graphics.Bitmap, kotlin.x> r0 = r5.gWp
                kotlin.g.a.m<java.lang.Long, android.graphics.Bitmap, kotlin.x> r1 = r6.gWp
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002f
                com.tencent.tav.coremedia.CMTime r0 = r5.Asw
                com.tencent.tav.coremedia.CMTime r1 = r6.Asw
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002f
            L_0x002a:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002e:
                return r0
            L_0x002f:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.b.b.C1553b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(257052);
            long j2 = this.Asv;
            int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            m<Long, Bitmap, x> mVar = this.gWp;
            int hashCode = ((mVar != null ? mVar.hashCode() : 0) + i3) * 31;
            CMTime cMTime = this.Asw;
            if (cMTime != null) {
                i2 = cMTime.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(257052);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(257051);
            String str = "Request(timeMs=" + this.Asv + ", callback=" + this.gWp + ", cmTime=" + this.Asw + ")";
            AppMethodBeat.o(257051);
            return str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ C1553b(long r4, kotlin.g.a.m r6) {
            /*
                r3 = this;
                r2 = 257050(0x3ec1a, float:3.60204E-40)
                com.tencent.tav.coremedia.CMTime r0 = com.tencent.tav.coremedia.CMTime.fromMs(r4)
                java.lang.String r1 = "CMTime.fromMs(timeMs)"
                kotlin.g.b.p.g(r0, r1)
                r3.<init>(r4, r6, r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.b.b.C1553b.<init>(long, kotlin.g.a.m):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.g.a.m<? super java.lang.Long, ? super android.graphics.Bitmap, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        private C1553b(long j2, m<? super Long, ? super Bitmap, x> mVar, CMTime cMTime) {
            p.h(mVar, "callback");
            p.h(cMTime, "cmTime");
            AppMethodBeat.i(257049);
            this.Asv = j2;
            this.gWp = mVar;
            this.Asw = cMTime;
            AppMethodBeat.o(257049);
        }
    }

    private final void evI() {
        AppMethodBeat.i(257056);
        Bitmap decodeFile = MMBitmapFactory.decodeFile(this.Asp.AsA.thumbPath);
        if (decodeFile != null) {
            this.wKi = Bitmap.createScaledBitmap(decodeFile, (int) (120.0f * (((float) decodeFile.getWidth()) / ((float) decodeFile.getHeight()))), 120, true);
            decodeFile.recycle();
        }
        AppMethodBeat.o(257056);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void cancel(long j2) {
        AppMethodBeat.i(257057);
        synchronized (this.Asm) {
            try {
                j.c((List) this.Asm, (kotlin.g.a.b) new c(this, j2));
            } finally {
                AppMethodBeat.o(257057);
            }
        }
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void destroy() {
        b.C1836b bVar;
        AppMethodBeat.i(257058);
        Log.i(this.TAG, "destroy");
        com.tencent.mm.plugin.thumbplayer.e.b bVar2 = this.Asn;
        if (!(bVar2 == null || (bVar = bVar2.GhA) == null)) {
            bVar.GhO = null;
        }
        com.tencent.mm.plugin.thumbplayer.e.b bVar3 = this.Asn;
        if (bVar3 != null) {
            bVar3.stopAsync();
            bVar3.recycle();
        }
        this.Asn = null;
        d dVar = this.Asl;
        dVar.k(new d.e(dVar));
        AppMethodBeat.o(257058);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void b(List<Long> list, m<? super Long, ? super Bitmap, x> mVar) {
        boolean z;
        AppMethodBeat.i(257059);
        p.h(list, "times");
        p.h(mVar, "callback");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            long longValue = t.longValue();
            Log.i(this.TAG, "requestFrames: ".concat(String.valueOf(longValue)));
            Bitmap bitmap = Asq.get(this.cacheKey + '-' + longValue);
            if (bitmap != null) {
                mVar.invoke(Long.valueOf(longValue), bitmap);
                z = false;
            } else {
                if (this.wKi != null && longValue == 0) {
                    mVar.invoke(Long.valueOf(longValue), this.wKi);
                }
                z = true;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        List<Number> t2 = j.t((Iterable) arrayList);
        ArrayList arrayList2 = new ArrayList(j.a(t2, 10));
        for (Number number : t2) {
            arrayList2.add(new C1553b(number.longValue(), mVar));
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            Log.i(this.TAG, "requestFrames: no new request");
            AppMethodBeat.o(257059);
            return;
        }
        synchronized (this.Asm) {
            try {
                this.Asm.addAll(arrayList3);
            } catch (Throwable th) {
                AppMethodBeat.o(257059);
                throw th;
            }
        }
        evJ();
        AppMethodBeat.o(257059);
    }

    private final void evJ() {
        boolean z;
        AppMethodBeat.i(257060);
        synchronized (this.Asm) {
            try {
                if (!this.isRunning) {
                    if (!this.Asm.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        C1553b bVar = this.Asm.get(0);
                        p.g(bVar, "requests[0]");
                        Ht(bVar.Asv);
                        this.isRunning = true;
                    } else {
                        Log.i(this.TAG, "finished request all frames");
                        destroy();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257060);
                }
            } finally {
                AppMethodBeat.o(257060);
            }
        }
    }

    private final void Ht(long j2) {
        com.tencent.mm.plugin.thumbplayer.e.b bVar;
        AppMethodBeat.i(257061);
        Log.v(this.TAG, "requestFrameAtTimeMs:" + j2 + ", enableSeek:" + this.Aso);
        this.Asl.AsL = j2;
        if (!this.Aso || (bVar = this.Asn) == null) {
            AppMethodBeat.o(257061);
            return;
        }
        bVar.YX((int) j2);
        AppMethodBeat.o(257061);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void setSize(int i2, int i3) {
        d dVar = this.Asl;
        if (!(dVar.width == i2 && dVar.height == i3)) {
            dVar.AsJ = true;
        }
        dVar.width = i2;
        dVar.height = i3;
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(257065);
        Log.i(bVar.TAG, "video download complete");
        bVar.Aso = true;
        if (bVar.isRunning) {
            C1553b bVar2 = bVar.Asm.get(0);
            p.g(bVar2, "requests[0]");
            bVar.Ht(bVar2.Asv);
            AppMethodBeat.o(257065);
            return;
        }
        bVar.evJ();
        AppMethodBeat.o(257065);
    }

    public static final /* synthetic */ void a(b bVar, Bitmap bitmap, long j2) {
        AppMethodBeat.i(257066);
        Log.i(bVar.TAG, "onFrameGenerated, " + bitmap + ", " + j2);
        z.e eVar = new z.e();
        eVar.SYF = -1;
        synchronized (bVar.Asm) {
            try {
                j.c((List) bVar.Asm, (kotlin.g.a.b) new d(bVar, j2, eVar, bitmap));
            } finally {
                AppMethodBeat.o(257066);
            }
        }
        Log.i(bVar.TAG, "get " + bVar.hashCode() + ": " + eVar.SYF + (char) 65292 + j2);
        bVar.isRunning = false;
        bVar.evJ();
        if (eVar.SYF >= 0) {
            Asq.put(bVar.cacheKey + '-' + eVar.SYF, bitmap);
        }
    }
}
