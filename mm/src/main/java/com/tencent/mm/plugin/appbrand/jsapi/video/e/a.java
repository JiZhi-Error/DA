package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a implements d {
    protected int mAT = 0;
    private volatile boolean mAU;
    protected c.f mAV;
    protected c.e mAW;
    protected c.g mAX;
    protected c.b mAY;
    protected c.h mAZ;
    protected c.a mBa;
    protected c.i mBb;
    protected c.d mBc;
    private final Set<c.g> mBd = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Set<c.h> mBe = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Set<c.b> mBf = Collections.newSetFromMap(new ConcurrentHashMap());

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getState() {
        return this.mAT;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public void release() {
        this.mAU = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public void a(String str, String str2, c.AbstractC0716c cVar) {
        dU(str, str2);
        if (cVar != null) {
            cVar.bKA();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r1 = r2.mBd.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r1.hasNext() == false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r1.next().a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r2.mAX == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r2.mAX.a(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bKx() {
        /*
            r2 = this;
            java.lang.String r0 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r1 = "notifyOnPrepared"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            monitor-enter(r2)
            boolean r0 = r2.mAU     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
        L_0x000f:
            return
        L_0x0010:
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$g r0 = r2.mAX
            if (r0 == 0) goto L_0x001a
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$g r0 = r2.mAX
            r0.a(r2)
        L_0x001a:
            java.util.Set<com.tencent.mm.plugin.appbrand.jsapi.video.e.c$g> r0 = r2.mBd
            java.util.Iterator r1 = r0.iterator()
        L_0x0020:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$g r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g) r0
            r0.a(r2)
            goto L_0x0020
        L_0x0030:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.bKx():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r1 = r2.mBf.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r1.hasNext() == false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r1.next().QA();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r2.mAY == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r2.mAY.QA();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bKy() {
        /*
            r2 = this;
            java.lang.String r0 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r1 = "notifyOnCompletion"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            monitor-enter(r2)
            boolean r0 = r2.mAU     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
        L_0x000f:
            return
        L_0x0010:
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$b r0 = r2.mAY
            if (r0 == 0) goto L_0x001a
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$b r0 = r2.mAY
            r0.QA()
        L_0x001a:
            java.util.Set<com.tencent.mm.plugin.appbrand.jsapi.video.e.c$b> r0 = r2.mBf
            java.util.Iterator r1 = r0.iterator()
        L_0x0020:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$b r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b) r0
            r0.QA()
            goto L_0x0020
        L_0x0030:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.bKy():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r1.mBa == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        r1.mBa.id(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void xF(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mAU     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
        L_0x0006:
            return
        L_0x0007:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$a r0 = r1.mBa
            if (r0 == 0) goto L_0x0006
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$a r0 = r1.mBa
            r0.id(r2)
            goto L_0x0006
        L_0x0012:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.xF(int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r1 = r2.mBe.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r1.hasNext() == false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r1.next().b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r2.mAZ == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r2.mAZ.b(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bKz() {
        /*
            r2 = this;
            java.lang.String r0 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r1 = "notifyOnSeekComplete"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            monitor-enter(r2)
            boolean r0 = r2.mAU     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
        L_0x000f:
            return
        L_0x0010:
            monitor-exit(r2)     // Catch:{ all -> 0x0030 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$h r0 = r2.mAZ
            if (r0 == 0) goto L_0x001a
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$h r0 = r2.mAZ
            r0.b(r2)
        L_0x001a:
            java.util.Set<com.tencent.mm.plugin.appbrand.jsapi.video.e.c$h> r0 = r2.mBe
            java.util.Iterator r1 = r0.iterator()
        L_0x0020:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$h r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h) r0
            r0.b(r2)
            goto L_0x0020
        L_0x0030:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.bKz():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r5.mBb == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r5.mBb.a(r5, r6, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ei(int r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r1 = "notifyOnVideoSizeChanged, width:%d, height:%d"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r2[r3] = r4
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r2[r3] = r4
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
            monitor-enter(r5)
            boolean r0 = r5.mAU     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0021
            monitor-exit(r5)     // Catch:{ all -> 0x002c }
        L_0x0020:
            return
        L_0x0021:
            monitor-exit(r5)     // Catch:{ all -> 0x002c }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$i r0 = r5.mBb
            if (r0 == 0) goto L_0x0020
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$i r0 = r5.mBb
            r0.a(r5, r6, r7)
            goto L_0x0020
        L_0x002c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.ei(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6.mAW.cc(r7, r8) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r6.mAW == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ej(int r7, int r8) {
        /*
            r6 = this;
            r1 = 1
            r0 = 0
            java.lang.String r2 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r3 = "notifyOnError, what:%d, extra:%d"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4[r0] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r4[r1] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r4)
            monitor-enter(r6)
            boolean r2 = r6.mAU     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0021
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
        L_0x0020:
            return r0
        L_0x0021:
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$e r2 = r6.mAW
            if (r2 == 0) goto L_0x0020
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$e r2 = r6.mAW
            boolean r2 = r2.cc(r7, r8)
            if (r2 == 0) goto L_0x0020
            r0 = r1
            goto L_0x0020
        L_0x0030:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.ej(int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6.mAV.cb(r7, r8) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r6.mAV == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ek(int r7, int r8) {
        /*
            r6 = this;
            r1 = 1
            r0 = 0
            java.lang.String r2 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r3 = "notifyOnInfo, what:%d, extra:%d"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4[r0] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r4[r1] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r4)
            monitor-enter(r6)
            boolean r2 = r6.mAU     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0021
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
        L_0x0020:
            return r0
        L_0x0021:
            monitor-exit(r6)     // Catch:{ all -> 0x0030 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$f r2 = r6.mAV
            if (r2 == 0) goto L_0x0020
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$f r2 = r6.mAV
            boolean r2 = r2.cb(r7, r8)
            if (r2 == 0) goto L_0x0020
            r0 = r1
            goto L_0x0020
        L_0x0030:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.ek(int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r4.mBc == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r4.mBc.abu(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void abt(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "MicroMsg.SameLayer.BaseMediaPlayer"
            java.lang.String r1 = "notifyOnDownStreamChanged, selectIndex:%s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
            monitor-enter(r4)
            boolean r0 = r4.mAU     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0016
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
        L_0x0015:
            return
        L_0x0016:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$d r0 = r4.mBc
            if (r0 == 0) goto L_0x0015
            com.tencent.mm.plugin.appbrand.jsapi.video.e.c$d r0 = r4.mBc
            r0.abu(r5)
            goto L_0x0015
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.abt(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.f fVar) {
        this.mAV = fVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.e eVar) {
        this.mAW = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.g gVar) {
        this.mAX = gVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.b bVar) {
        this.mAY = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.h hVar) {
        this.mAZ = hVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.a aVar) {
        this.mBa = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.i iVar) {
        this.mBb = iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void a(c.d dVar) {
        this.mBc = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
    public final void b(c.g gVar) {
        this.mBd.add(gVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
    public final void b(c.h hVar) {
        this.mBe.add(hVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.d
    public final void b(c.b bVar) {
        this.mBf.add(bVar);
    }
}
