package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.aa;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class ae implements ad {
    public static final b zPk = new b((byte) 0);
    private volatile boolean kyn = true;
    ArrayList<g> zPa;
    private volatile int zPb;
    private String zPc = "";
    private final a zPd = new a("", (byte) 0);
    private final ConcurrentHashMap<String, a> zPe = new ConcurrentHashMap<>();
    private aa zPf;
    private j zPg;
    private boolean zPh = true;
    private int zPi;
    private String zPj = "";

    static {
        AppMethodBeat.i(239703);
        AppMethodBeat.o(239703);
    }

    public static final class e extends q implements kotlin.g.a.q<ByteBuffer, Integer, Integer, x> {
        final /* synthetic */ String tBp;
        final /* synthetic */ ae zPq;
        final /* synthetic */ int zPr;
        final /* synthetic */ int zPu;
        final /* synthetic */ int zPv = 0;
        final /* synthetic */ g zPw;
        final /* synthetic */ byte[] zPx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar, ae aeVar, int i2, String str, byte[] bArr, int i3) {
            super(3);
            this.zPw = gVar;
            this.zPq = aeVar;
            this.zPr = i2;
            this.tBp = str;
            this.zPx = bArr;
            this.zPu = i3;
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(ByteBuffer byteBuffer, Integer num, Integer num2) {
            AppMethodBeat.i(239684);
            final ByteBuffer byteBuffer2 = byteBuffer;
            final int intValue = num.intValue();
            final int intValue2 = num2.intValue();
            p.h(byteBuffer2, "byteBuffer");
            Boolean valueOf = Boolean.valueOf(ae.a(this.zPq, this.zPq.zPj));
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.booleanValue();
                final f Rc = this.zPw.Rc(this.zPq.zPi);
                if (Rc != null) {
                    a aVar = this.zPq.zPd;
                    ae.a(aVar, byteBuffer2, intValue, intValue2);
                    aVar.mirror = this.zPv;
                    aVar.angle = this.zPq.zPi;
                    final Bitmap bitmap = aVar.zPl;
                    if (bitmap != null) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>() {
                            /* class com.tencent.mm.plugin.multitalk.model.ae.e.AnonymousClass1 */

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(239683);
                                if (this.zPq.kyn) {
                                    g gVar = this.zPw;
                                    if (gVar != null) {
                                        gVar.emc();
                                    }
                                    long currentTicks = Util.currentTicks();
                                    Rc.a(this.tBp, bitmap, 90, this.zPv);
                                    com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
                                    com.tencent.mm.plugin.multitalk.d.d.append(4, Util.ticksToNow(currentTicks));
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(239683);
                                return xVar;
                            }
                        });
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239684);
            return xVar;
        }
    }

    public ae() {
        AppMethodBeat.i(239702);
        AppMethodBeat.o(239702);
    }

    public static final /* synthetic */ boolean a(ae aeVar, String str) {
        AppMethodBeat.i(239704);
        boolean aGo = aeVar.aGo(str);
        AppMethodBeat.o(239704);
        return aGo;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(ae aeVar) {
        AppMethodBeat.i(239688);
        aeVar.bJ(0, "");
        AppMethodBeat.o(239688);
    }

    public final void bJ(int i2, String str) {
        AppMethodBeat.i(239687);
        p.h(str, "largeHostName");
        Log.printInfoStack("VideoDisplayDataMuxer", "setLargeTargetState ".concat(String.valueOf(i2)), new Object[0]);
        this.zPb = i2;
        this.zPc = str;
        AppMethodBeat.o(239687);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(239689);
        p.h(gVar, "targetContainer");
        ArrayList<g> arrayList = this.zPa;
        if (arrayList == null || !arrayList.contains(gVar)) {
            if (this.zPa == null) {
                this.zPa = new ArrayList<>();
            }
            ArrayList<g> arrayList2 = this.zPa;
            if (arrayList2 != null) {
                arrayList2.add(gVar);
                AppMethodBeat.o(239689);
                return;
            }
            AppMethodBeat.o(239689);
            return;
        }
        AppMethodBeat.o(239689);
    }

    public final void b(g gVar) {
        AppMethodBeat.i(239690);
        p.h(gVar, "targetContainer");
        ArrayList<g> arrayList = new ArrayList<>();
        ArrayList<g> arrayList2 = this.zPa;
        if (arrayList2 != null) {
            Iterator<g> it = arrayList2.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (!p.j(next, gVar)) {
                    arrayList.add(next);
                }
            }
        }
        this.zPa = arrayList;
        AppMethodBeat.o(239690);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.ad
    public final void eor() {
        this.kyn = true;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.ad
    public final void a(String str, int[] iArr, int i2, int i3, int i4, int i5) {
        Bitmap bitmap;
        AppMethodBeat.i(239691);
        p.h(str, "userName");
        p.h(iArr, "pBuffer");
        ArrayList<f> aGp = aGp(str);
        ArrayList<f> arrayList = !aGp.isEmpty() ? aGp : null;
        if (arrayList != null) {
            a b2 = b((f) j.ks(arrayList));
            if (b2 != null) {
                a(b2, iArr, i2, i3);
                b2.mirror = i4;
                b2.angle = i5;
                if (!(b2 == null || (bitmap = b2.zPl) == null)) {
                    com.tencent.mm.ac.d.h(new g(bitmap, arrayList, this, iArr, i2, i3, i4, i5, str));
                    AppMethodBeat.o(239691);
                    return;
                }
            }
            AppMethodBeat.o(239691);
            return;
        }
        AppMethodBeat.o(239691);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.ad
    public final void a(String str, int[] iArr, int i2, int i3, int i4) {
        AppMethodBeat.i(239692);
        p.h(str, "userName");
        p.h(iArr, "pBuffer");
        this.zPh = true;
        Boolean valueOf = Boolean.valueOf(aGo(str));
        if (!(valueOf.booleanValue() && i2 > 0 && i3 > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            ArrayList<g> arrayList = this.zPa;
            if (arrayList != null) {
                for (T t : arrayList) {
                    f Rc = t.Rc(i4);
                    if (Rc != null) {
                        this.zPi = i4;
                        a aVar = this.zPd;
                        a(aVar, iArr, i2, i3);
                        aVar.mirror = 0;
                        aVar.angle = i4;
                        Bitmap bitmap = aVar.zPl;
                        if (bitmap != null) {
                            com.tencent.mm.ac.d.h(new d(bitmap, Rc, t, this, i4, iArr, i2, i3, str));
                        }
                    }
                }
                AppMethodBeat.o(239692);
                return;
            }
            AppMethodBeat.o(239692);
            return;
        }
        AppMethodBeat.o(239692);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.ad
    public final void a(String str, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(239693);
        p.h(str, "userName");
        p.h(bArr, "pBuffer");
        Boolean valueOf = Boolean.valueOf(aGo(str));
        if (!valueOf.booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            ArrayList<g> arrayList = this.zPa;
            if (arrayList != null) {
                for (T t : arrayList) {
                    if (t.Rc(0) != null) {
                        this.zPi = i3;
                        this.zPj = str;
                        if (this.zPg == null || this.zPf == null) {
                            aa aaVar = new aa();
                            aaVar.eog();
                            aaVar.c(new e(t, this, i3, str, bArr, i2));
                            aaVar.U(new f(aaVar, t, this, i3, str, bArr, i2));
                            this.zPf = aaVar;
                            this.zPh = false;
                        }
                        long currentTicks = Util.currentTicks();
                        j jVar = this.zPg;
                        if (jVar != null) {
                            jVar.f(bArr, i2, this.zPh);
                        }
                        com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
                        com.tencent.mm.plugin.multitalk.d.d.append(2, Util.ticksToNow(currentTicks));
                    }
                }
                AppMethodBeat.o(239693);
                return;
            }
            AppMethodBeat.o(239693);
            return;
        }
        AppMethodBeat.o(239693);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.ad
    public final void eos() {
        AppMethodBeat.i(239694);
        j jVar = this.zPg;
        if (jVar != null) {
            jVar.emB();
            aa aaVar = this.zPf;
            if (aaVar != null) {
                aaVar.U(new aa.b(aaVar));
                HandlerThread handlerThread = aaVar.handlerThread;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
            }
            this.zPf = null;
        }
        this.zPg = null;
        AppMethodBeat.o(239694);
    }

    public static void a(f fVar) {
        AppMethodBeat.i(239696);
        p.h(fVar, "target");
        ImageView avatarIv = fVar.getAvatarIv();
        if (avatarIv != null) {
            h.RTc.aV(new c(avatarIv, fVar));
            AppMethodBeat.o(239696);
            return;
        }
        AppMethodBeat.o(239696);
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ ImageView zPm;
        final /* synthetic */ f zPn;

        c(ImageView imageView, f fVar) {
            this.zPm = imageView;
            this.zPn = fVar;
        }

        public final void run() {
            AppMethodBeat.i(239681);
            a.b.y(this.zPm, this.zPn.getUsername());
            this.zPn.emz();
            AppMethodBeat.o(239681);
        }
    }

    public final void aa(boolean z) {
        AppMethodBeat.i(239697);
        ArrayList<g> arrayList = this.zPa;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.zPa = null;
        a(this);
        if (!z) {
            this.zPe.clear();
        }
        this.zPd.zPl = null;
        eos();
        AppMethodBeat.o(239697);
    }

    private final boolean aGn(String str) {
        AppMethodBeat.i(239698);
        if (this.zPb != 1 || !p.j(str, this.zPc)) {
            AppMethodBeat.o(239698);
            return false;
        }
        AppMethodBeat.o(239698);
        return true;
    }

    private final boolean aGo(String str) {
        AppMethodBeat.i(239699);
        if (this.zPb != 2 || !p.j(str, this.zPc)) {
            AppMethodBeat.o(239699);
            return false;
        }
        AppMethodBeat.o(239699);
        return true;
    }

    private final a b(f fVar) {
        AppMethodBeat.i(239700);
        if (aGn(fVar.getUsername())) {
            a aVar = this.zPd;
            AppMethodBeat.o(239700);
            return aVar;
        } else if (this.zPe.get(fVar.getUsername()) == null) {
            a aVar2 = new a(fVar.getUsername(), (byte) 0);
            this.zPe.put(fVar.getUsername(), aVar2);
            AppMethodBeat.o(239700);
            return aVar2;
        } else {
            a aVar3 = this.zPe.get(fVar.getUsername());
            AppMethodBeat.o(239700);
            return aVar3;
        }
    }

    private final ArrayList<f> aGp(String str) {
        AppMethodBeat.i(239701);
        ArrayList<f> arrayList = new ArrayList<>();
        ArrayList<g> arrayList2 = this.zPa;
        if (arrayList2 != null) {
            for (T t : arrayList2) {
                if (aGn(str)) {
                    f Rc = t.Rc(0);
                    if (Rc != null) {
                        arrayList.add(Rc);
                    }
                } else {
                    f aFB = t.aFB(str);
                    if (aFB != null) {
                        arrayList.add(aFB);
                    }
                }
            }
        }
        AppMethodBeat.o(239701);
        return arrayList;
    }

    public static final class a {
        int angle;
        int mirror;
        private String userName;
        Bitmap zPl;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (kotlin.g.b.p.j(r3.zPl, r4.zPl) != false) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 239680(0x3a840, float:3.35863E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.multitalk.model.ae.a
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.plugin.multitalk.model.ae$a r4 = (com.tencent.mm.plugin.multitalk.model.ae.a) r4
                java.lang.String r0 = r3.userName
                java.lang.String r1 = r4.userName
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                int r0 = r3.angle
                int r1 = r4.angle
                if (r0 != r1) goto L_0x0033
                int r0 = r3.mirror
                int r1 = r4.mirror
                if (r0 != r1) goto L_0x0033
                android.graphics.Bitmap r0 = r3.zPl
                android.graphics.Bitmap r1 = r4.zPl
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.ae.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(239679);
            String str = this.userName;
            int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.angle) * 31) + this.mirror) * 31;
            Bitmap bitmap = this.zPl;
            if (bitmap != null) {
                i2 = bitmap.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(239679);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(239678);
            String str = "BitmapHolder(userName=" + this.userName + ", angle=" + this.angle + ", mirror=" + this.mirror + ", dataBitmap=" + this.zPl + ")";
            AppMethodBeat.o(239678);
            return str;
        }

        private a(String str) {
            p.h(str, "userName");
            AppMethodBeat.i(239677);
            this.userName = str;
            this.angle = 0;
            this.mirror = 0;
            this.zPl = null;
            AppMethodBeat.o(239677);
        }

        public /* synthetic */ a(String str, byte b2) {
            this(str);
        }
    }

    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ String tBp;
        final /* synthetic */ ArrayList zPC;
        final /* synthetic */ ae zPq;
        final /* synthetic */ int zPr;
        final /* synthetic */ int[] zPs;
        final /* synthetic */ int zPt;
        final /* synthetic */ int zPu;
        final /* synthetic */ int zPv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Bitmap bitmap, ArrayList arrayList, ae aeVar, int[] iArr, int i2, int i3, int i4, int i5, String str) {
            super(0);
            this.cKG = bitmap;
            this.zPC = arrayList;
            this.zPq = aeVar;
            this.zPs = iArr;
            this.zPt = i2;
            this.zPu = i3;
            this.zPv = i4;
            this.zPr = i5;
            this.tBp = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239686);
            if (this.zPq.kyn) {
                for (f fVar : this.zPC) {
                    long currentTicks = Util.currentTicks();
                    fVar.a(this.tBp, this.cKG, this.zPr, this.zPv);
                    com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
                    com.tencent.mm.plugin.multitalk.d.d.append(3, Util.ticksToNow(currentTicks));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239686);
            return xVar;
        }
    }

    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ String tBp;
        final /* synthetic */ f zPo;
        final /* synthetic */ g zPp;
        final /* synthetic */ ae zPq;
        final /* synthetic */ int zPr;
        final /* synthetic */ int[] zPs;
        final /* synthetic */ int zPt;
        final /* synthetic */ int zPu;
        final /* synthetic */ int zPv = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Bitmap bitmap, f fVar, g gVar, ae aeVar, int i2, int[] iArr, int i3, int i4, String str) {
            super(0);
            this.cKG = bitmap;
            this.zPo = fVar;
            this.zPp = gVar;
            this.zPq = aeVar;
            this.zPr = i2;
            this.zPs = iArr;
            this.zPt = i3;
            this.zPu = i4;
            this.tBp = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239682);
            if (this.zPq.kyn) {
                this.zPp.emc();
                long currentTicks = Util.currentTicks();
                this.zPo.a(this.tBp, this.cKG, 90, this.zPv);
                com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
                com.tencent.mm.plugin.multitalk.d.d.append(4, Util.ticksToNow(currentTicks));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239682);
            return xVar;
        }
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String tBp;
        final /* synthetic */ aa zPA;
        final /* synthetic */ ae zPq;
        final /* synthetic */ int zPr;
        final /* synthetic */ int zPu;
        final /* synthetic */ int zPv = 0;
        final /* synthetic */ g zPw;
        final /* synthetic */ byte[] zPx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(aa aaVar, g gVar, ae aeVar, int i2, String str, byte[] bArr, int i3) {
            super(0);
            this.zPA = aaVar;
            this.zPw = gVar;
            this.zPq = aeVar;
            this.zPr = i2;
            this.tBp = str;
            this.zPx = bArr;
            this.zPu = i3;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239685);
            ae aeVar = this.zPq;
            j jVar = new j(this.zPA.zOH);
            jVar.a(new j.a(this) {
                /* class com.tencent.mm.plugin.multitalk.model.ae.f.AnonymousClass1 */
                final /* synthetic */ f zPB;

                {
                    this.zPB = r1;
                }

                @Override // com.tencent.mm.plugin.multitalk.model.j.a
                public final void onSizeChanged(int i2, int i3) {
                    aa aaVar = this.zPB.zPA;
                    aaVar.width = i2;
                    aaVar.height = i3;
                }
            });
            aeVar.zPg = jVar;
            x xVar = x.SXb;
            AppMethodBeat.o(239685);
            return xVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r0.getHeight() != r12) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void a(com.tencent.mm.plugin.multitalk.model.ae.a r9, int[] r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.ae.a(com.tencent.mm.plugin.multitalk.model.ae$a, int[], int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r0.getHeight() != r5) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.multitalk.model.ae.a r2, java.nio.ByteBuffer r3, int r4, int r5) {
        /*
            r1 = 239705(0x3a859, float:3.35898E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            java.lang.System.currentTimeMillis()
            android.graphics.Bitmap r0 = r2.zPl
            if (r0 == 0) goto L_0x0027
            android.graphics.Bitmap r0 = r2.zPl
            if (r0 != 0) goto L_0x0014
            kotlin.g.b.p.hyc()
        L_0x0014:
            int r0 = r0.getWidth()
            if (r0 != r4) goto L_0x0027
            android.graphics.Bitmap r0 = r2.zPl
            if (r0 != 0) goto L_0x0021
            kotlin.g.b.p.hyc()
        L_0x0021:
            int r0 = r0.getHeight()
            if (r0 == r5) goto L_0x002f
        L_0x0027:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r0)
            r2.zPl = r0
        L_0x002f:
            android.graphics.Bitmap r0 = r2.zPl
            if (r0 == 0) goto L_0x0038
            java.nio.Buffer r3 = (java.nio.Buffer) r3
            r0.copyPixelsFromBuffer(r3)
        L_0x0038:
            java.lang.System.currentTimeMillis()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.ae.a(com.tencent.mm.plugin.multitalk.model.ae$a, java.nio.ByteBuffer, int, int):void");
    }
}
