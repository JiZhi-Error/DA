package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.a.a;
import kotlin.l.b.a.b.k.a.q;
import kotlin.l.b.a.b.l.j;

public final class b extends q implements kotlin.l.b.a.b.a.b {
    public static final a TLS = new a((byte) 0);
    private final boolean TLR;

    static {
        AppMethodBeat.i(60389);
        AppMethodBeat.o(60389);
    }

    public /* synthetic */ b(kotlin.l.b.a.b.f.b bVar, j jVar, y yVar, a.l lVar, kotlin.l.b.a.b.e.a.a aVar) {
        this(bVar, jVar, yVar, lVar, aVar, false);
        AppMethodBeat.i(60388);
        AppMethodBeat.o(60388);
    }

    private b(kotlin.l.b.a.b.f.b bVar, j jVar, y yVar, a.l lVar, kotlin.l.b.a.b.e.a.a aVar, boolean z) {
        super(bVar, jVar, yVar, lVar, aVar);
        AppMethodBeat.i(186260);
        this.TLR = false;
        AppMethodBeat.o(186260);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(kotlin.l.b.a.b.f.b bVar, j jVar, y yVar, InputStream inputStream) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(60387);
            p.h(bVar, "fqName");
            p.h(jVar, "storageManager");
            p.h(yVar, "module");
            p.h(inputStream, "inputStream");
            InputStream inputStream2 = inputStream;
            try {
                InputStream inputStream3 = inputStream2;
                a.C2300a aVar = kotlin.l.b.a.b.e.a.a.TAB;
                p.h(inputStream3, "stream");
                DataInputStream dataInputStream = new DataInputStream(inputStream3);
                f fVar = new f(1, dataInputStream.readInt());
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(fVar, 10));
                Iterator it = fVar.iterator();
                while (it.hasNext()) {
                    ((ab) it).nextInt();
                    arrayList.add(Integer.valueOf(dataInputStream.readInt()));
                }
                int[] u = kotlin.a.j.u((Collection<Integer>) arrayList);
                kotlin.l.b.a.b.e.a.a aVar2 = new kotlin.l.b.a.b.e.a.a(Arrays.copyOf(u, u.length));
                if (!aVar2.hIi()) {
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + kotlin.l.b.a.b.e.a.a.TAz + ", actual " + aVar2 + ". Please update Kotlin");
                    AppMethodBeat.o(60387);
                    throw unsupportedOperationException;
                }
                a.l d2 = a.l.d(inputStream3, a.TLQ.TDN);
                kotlin.f.b.a(inputStream2, null);
                p.g(d2, "proto");
                b bVar2 = new b(bVar, jVar, yVar, d2, aVar2);
                AppMethodBeat.o(60387);
                return bVar2;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(inputStream2, th2);
                AppMethodBeat.o(60387);
                throw th;
            }
        }
    }
}
