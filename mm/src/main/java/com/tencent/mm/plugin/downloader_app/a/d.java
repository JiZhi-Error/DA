package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static LinkedList<a> qKH = new LinkedList<>();
    private static LinkedList<b> qKI = new LinkedList<>();
    private static LinkedList<c> qKJ = new LinkedList<>();
    private static LinkedList<f> qKK = new LinkedList<>();
    private static LinkedList<e> qKL = new LinkedList<>();
    private static LinkedList<AbstractC0946d> qKM = new LinkedList<>();
    private static LinkedList<g> qKN = new LinkedList<>();
    private static a.b qKO;

    public interface a {
        void kZ(boolean z);
    }

    public interface b {
        void onClick();
    }

    public interface c {
        void la(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.a.d$d  reason: collision with other inner class name */
    public interface AbstractC0946d {
        void O(int i2, long j2);
    }

    public interface e {
        void alw(String str);
    }

    public interface f {
        void alx(String str);
    }

    public interface g {
        void aly(String str);
    }

    static {
        AppMethodBeat.i(8895);
        AppMethodBeat.o(8895);
    }

    public static void cBn() {
        AppMethodBeat.i(8871);
        if (qKO == null) {
            qKO = new a.b() {
                /* class com.tencent.mm.plugin.downloader_app.a.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.downloader.b.a.b
                public final void O(int i2, long j2) {
                    AppMethodBeat.i(8870);
                    d.P(i2, j2);
                    AppMethodBeat.o(8870);
                }
            };
        }
        com.tencent.mm.plugin.downloader.b.a.a(qKO);
        AppMethodBeat.o(8871);
    }

    public static void cBo() {
        AppMethodBeat.i(8872);
        com.tencent.mm.plugin.downloader.b.a.b(qKO);
        qKO = null;
        qKH.clear();
        qKI.clear();
        qKJ.clear();
        qKK.clear();
        qKL.clear();
        qKM.clear();
        AppMethodBeat.o(8872);
    }

    public static void CI(long j2) {
        AppMethodBeat.i(8873);
        Iterator<AbstractC0946d> it = qKM.iterator();
        while (it.hasNext()) {
            it.next().O(5, j2);
        }
        AppMethodBeat.o(8873);
    }

    public static void a(AbstractC0946d dVar) {
        AppMethodBeat.i(8874);
        if (!qKM.contains(dVar)) {
            qKM.add(dVar);
        }
        AppMethodBeat.o(8874);
    }

    public static void b(AbstractC0946d dVar) {
        AppMethodBeat.i(8875);
        qKM.remove(dVar);
        AppMethodBeat.o(8875);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(8876);
        qKH.add(aVar);
        AppMethodBeat.o(8876);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(8877);
        qKH.remove(aVar);
        AppMethodBeat.o(8877);
    }

    public static void kX(boolean z) {
        AppMethodBeat.i(8878);
        Iterator<a> it = qKH.iterator();
        while (it.hasNext()) {
            it.next().kZ(z);
        }
        AppMethodBeat.o(8878);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(8879);
        qKI.add(bVar);
        AppMethodBeat.o(8879);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(8880);
        qKI.remove(bVar);
        AppMethodBeat.o(8880);
    }

    public static void cBW() {
        AppMethodBeat.i(8881);
        Iterator<b> it = qKI.iterator();
        while (it.hasNext()) {
            it.next().onClick();
        }
        AppMethodBeat.o(8881);
    }

    public static void a(c cVar) {
        AppMethodBeat.i(8882);
        qKJ.add(cVar);
        AppMethodBeat.o(8882);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(8883);
        qKJ.remove(cVar);
        AppMethodBeat.o(8883);
    }

    public static void kY(boolean z) {
        AppMethodBeat.i(8884);
        Iterator<c> it = qKJ.iterator();
        while (it.hasNext()) {
            it.next().la(z);
        }
        AppMethodBeat.o(8884);
    }

    public static void a(f fVar) {
        AppMethodBeat.i(8885);
        qKK.add(fVar);
        AppMethodBeat.o(8885);
    }

    public static void b(f fVar) {
        AppMethodBeat.i(8886);
        qKK.remove(fVar);
        AppMethodBeat.o(8886);
    }

    public static void alt(String str) {
        AppMethodBeat.i(8887);
        Iterator<f> it = qKK.iterator();
        while (it.hasNext()) {
            it.next().alx(str);
        }
        AppMethodBeat.o(8887);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(8888);
        if (!qKL.contains(eVar)) {
            qKL.add(eVar);
        }
        AppMethodBeat.o(8888);
    }

    public static void b(e eVar) {
        AppMethodBeat.i(8889);
        qKL.remove(eVar);
        AppMethodBeat.o(8889);
    }

    public static void alu(String str) {
        AppMethodBeat.i(8890);
        Iterator<e> it = qKL.iterator();
        while (it.hasNext()) {
            it.next().alw(str);
        }
        AppMethodBeat.o(8890);
    }

    public static void a(g gVar) {
        AppMethodBeat.i(8891);
        if (!qKN.contains(gVar)) {
            qKN.add(gVar);
        }
        AppMethodBeat.o(8891);
    }

    public static void b(g gVar) {
        AppMethodBeat.i(8892);
        qKN.remove(gVar);
        AppMethodBeat.o(8892);
    }

    public static void alv(String str) {
        AppMethodBeat.i(8893);
        Iterator<g> it = qKN.iterator();
        while (it.hasNext()) {
            it.next().aly(str);
        }
        AppMethodBeat.o(8893);
    }

    static /* synthetic */ void P(int i2, long j2) {
        AppMethodBeat.i(8894);
        com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
        if (!(Cw == null || !Cw.field_fromDownloadApp || i2 == 9)) {
            b.l(Cw);
        }
        Iterator<AbstractC0946d> it = qKM.iterator();
        while (it.hasNext()) {
            it.next().O(i2, j2);
        }
        AppMethodBeat.o(8894);
    }
}
