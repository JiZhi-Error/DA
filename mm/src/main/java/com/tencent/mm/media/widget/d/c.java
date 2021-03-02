package com.tencent.mm.media.widget.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/media/widget/util/CameraReportHelper;", "", "()V", "TAG", "", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "checkAndReportCamera2Info", "", "CameraInfo", "plugin-mediaeditor_release"})
public final class c {
    private static FutureTask<Integer> cCr;
    public static final c itl = new c();

    static {
        AppMethodBeat.i(218950);
        AppMethodBeat.o(218950);
    }

    private c() {
    }

    public static final /* synthetic */ FutureTask aRO() {
        AppMethodBeat.i(218951);
        FutureTask<Integer> futureTask = cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        AppMethodBeat.o(218951);
        return futureTask;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/media/widget/util/CameraReportHelper$CameraInfo;", "", "id", "", "lens", "", "supportLevel", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getLens", "()Ljava/lang/String;", "setLens", "(Ljava/lang/String;)V", "getSupportLevel", "setSupportLevel", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-mediaeditor_release"})
    public static final class a {
        private int id;
        private String itm;
        private String itn;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (kotlin.g.b.p.j(r3.itn, r4.itn) != false) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 218944(0x35740, float:3.06806E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.media.widget.d.c.a
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.media.widget.d.c$a r4 = (com.tencent.mm.media.widget.d.c.a) r4
                int r0 = r3.id
                int r1 = r4.id
                if (r0 != r1) goto L_0x002d
                java.lang.String r0 = r3.itm
                java.lang.String r1 = r4.itm
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.itn
                java.lang.String r1 = r4.itn
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.d.c.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(218943);
            int i3 = this.id * 31;
            String str = this.itm;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            String str2 = this.itn;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(218943);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(218942);
            String str = "CameraInfo(id=" + this.id + ", lens=" + this.itm + ", supportLevel=" + this.itn + ")";
            AppMethodBeat.o(218942);
            return str;
        }

        public a(int i2, String str, String str2) {
            p.h(str, "lens");
            p.h(str2, "supportLevel");
            AppMethodBeat.i(218941);
            this.id = i2;
            this.itm = str;
            this.itn = str2;
            AppMethodBeat.o(218941);
        }
    }

    public static void aRN() {
        AppMethodBeat.i(218949);
        cCr = new FutureTask<>(b.ito);
        h.RTc.aX(RunnableC0440c.itp);
        AppMethodBeat.o(218949);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.widget.d.c$c  reason: collision with other inner class name */
    static final class RunnableC0440c implements Runnable {
        public static final RunnableC0440c itp = new RunnableC0440c();

        static {
            AppMethodBeat.i(218948);
            AppMethodBeat.o(218948);
        }

        RunnableC0440c() {
        }

        public final void run() {
            AppMethodBeat.i(218947);
            i iVar = h.RTc;
            c cVar = c.itl;
            iVar.aX(c.aRO());
            try {
                c cVar2 = c.itl;
                c.aRO().get(10, TimeUnit.SECONDS);
                AppMethodBeat.o(218947);
            } catch (TimeoutException e2) {
                Log.e("MicroMsg.CameraReportHelper", "futureTask TimeoutException cancel");
                c cVar3 = c.itl;
                if (!c.aRO().isCancelled()) {
                    c cVar4 = c.itl;
                    if (!c.aRO().isDone()) {
                        c cVar5 = c.itl;
                        c.aRO().cancel(true);
                        AppMethodBeat.o(218947);
                        return;
                    }
                }
                AppMethodBeat.o(218947);
            } catch (Exception e3) {
                Log.e("MicroMsg.CameraReportHelper", "futureTask Exception");
                AppMethodBeat.o(218947);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "call"})
    static final class b<V> implements Callable<Integer> {
        public static final b ito = new b();

        static {
            AppMethodBeat.i(218946);
            AppMethodBeat.o(218946);
        }

        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() {
            int i2;
            String str;
            String str2;
            int i3;
            int i4;
            int i5;
            String str3;
            int i6;
            String str4;
            AppMethodBeat.i(218945);
            HashSet hashSet = new HashSet();
            int i7 = 0;
            String str5 = null;
            String str6 = null;
            int i8 = 0;
            int i9 = 0;
            com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
            String anL = com.tencent.mm.compatible.c.a.anL();
            if (anL != null) {
                String str7 = null;
                for (String str8 : n.b(anL, new String[]{"+"})) {
                    List b2 = n.b(str8, new String[]{"-"});
                    List list = b2.size() >= 3 ? b2 : null;
                    if (list != null) {
                        String str9 = (String) list.get(0);
                        String str10 = (String) list.get(1);
                        String str11 = (String) list.get(2);
                        Integer buA = n.buA(str10);
                        if (buA != null) {
                            switch (buA.intValue()) {
                                case 0:
                                    a aVar2 = a.itg;
                                    a.aRq();
                                    break;
                                case 1:
                                    a aVar3 = a.itg;
                                    a.aRr();
                                    break;
                                case 2:
                                    a aVar4 = a.itg;
                                    a.aRs();
                                    break;
                                case 3:
                                    a aVar5 = a.itg;
                                    a.aRt();
                                    break;
                                case 4:
                                    a aVar6 = a.itg;
                                    a.aRu();
                                    break;
                            }
                        }
                        Integer buA2 = n.buA(str11);
                        if (buA2 != null) {
                            switch (buA2.intValue()) {
                                case 0:
                                    if (str5 == null) {
                                        str4 = str10;
                                    } else {
                                        str4 = str5;
                                    }
                                    i8++;
                                    str5 = str4;
                                    break;
                                case 1:
                                    if (str6 == null) {
                                        str3 = str10;
                                    } else {
                                        str3 = str6;
                                    }
                                    i6 = i9 + 1;
                                    i9 = i6;
                                    str6 = str3;
                                    break;
                                default:
                                    i6 = i9;
                                    str3 = str6;
                                    i9 = i6;
                                    str6 = str3;
                                    break;
                            }
                        }
                        if (!(!p.j(str7, str10)) || str7 == null) {
                            i5 = i7;
                        } else {
                            a aVar7 = a.itg;
                            a.aRz();
                            i5 = 1;
                        }
                        Integer buA3 = n.buA(str9);
                        if (buA3 != null) {
                            hashSet.add(new a(buA3.intValue(), str11, str10));
                        }
                        str7 = str10;
                        i7 = i5;
                    }
                }
                i2 = i8;
                str = str6;
                str2 = str5;
                i3 = i7;
            } else {
                i2 = 0;
                str = null;
                str2 = null;
                i3 = 0;
                anL = null;
            }
            com.tencent.mm.compatible.c.a aVar8 = com.tencent.mm.compatible.c.a.gDs;
            Integer valueOf = Integer.valueOf(com.tencent.mm.compatible.c.a.anK());
            Integer num = valueOf.intValue() != -1 ? valueOf : null;
            if (num != null) {
                i4 = num.intValue();
                switch (i4) {
                    case 0:
                        a aVar9 = a.itg;
                        a.aRv();
                        break;
                    case 1:
                        a aVar10 = a.itg;
                        a.aRw();
                        break;
                    case 2:
                        a aVar11 = a.itg;
                        a.aRx();
                        break;
                    default:
                        a aVar12 = a.itg;
                        a.aRy();
                        break;
                }
            } else {
                i4 = -1;
            }
            if (!(i4 == -1 || anL == null || str2 == null || str == null)) {
                a aVar13 = a.itg;
                if (anL == null) {
                    p.hyc();
                }
                if (str2 == null) {
                    p.hyc();
                }
                if (str == null) {
                    p.hyc();
                }
                a.a(i4, anL, i3, str2, str, i2, i9);
            }
            AppMethodBeat.o(218945);
            return 1;
        }
    }
}
