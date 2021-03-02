package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"})
public final class c implements h<String> {
    final BufferedReader bzE;

    public c(BufferedReader bufferedReader) {
        p.h(bufferedReader, "reader");
        AppMethodBeat.i(129277);
        this.bzE = bufferedReader;
        AppMethodBeat.o(129277);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"kotlin/io/LinesSequence$iterator$1", "", "", "done", "", "nextValue", "hasNext", "next", "kotlin-stdlib"})
    public static final class a implements Iterator<String>, kotlin.g.b.a.a {
        private String SYf;
        final /* synthetic */ c SYg;
        private boolean done;

        public final void remove() {
            AppMethodBeat.i(129266);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129266);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(c cVar) {
            this.SYg = cVar;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129264);
            if (this.SYf == null && !this.done) {
                this.SYf = this.SYg.bzE.readLine();
                if (this.SYf == null) {
                    this.done = true;
                }
            }
            if (this.SYf != null) {
                AppMethodBeat.o(129264);
                return true;
            }
            AppMethodBeat.o(129264);
            return false;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ String next() {
            AppMethodBeat.i(129265);
            if (!hasNext()) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129265);
                throw noSuchElementException;
            }
            String str = this.SYf;
            this.SYf = null;
            if (str == null) {
                p.hyc();
            }
            AppMethodBeat.o(129265);
            return str;
        }
    }

    @Override // kotlin.m.h
    public final Iterator<String> iterator() {
        AppMethodBeat.i(129276);
        a aVar = new a(this);
        AppMethodBeat.o(129276);
        return aVar;
    }
}
