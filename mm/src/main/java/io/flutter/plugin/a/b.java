package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import java.nio.ByteBuffer;

public final class b<T> {
    final i<T> SRZ;
    final String name;
    private final c wJt;

    /* renamed from: io.flutter.plugin.a.b$b  reason: collision with other inner class name */
    public interface AbstractC2252b<T> {
        void a(T t, c<T> cVar);
    }

    public interface c<T> {
        void eO(T t);
    }

    public b(c cVar, String str, i<T> iVar) {
        this.wJt = cVar;
        this.name = str;
        this.SRZ = iVar;
    }

    public final void eN(T t) {
        AppMethodBeat.i(9842);
        this.wJt.a(this.name, this.SRZ.eP(t), null);
        AppMethodBeat.o(9842);
    }

    public final void a(AbstractC2252b<T> bVar) {
        AppMethodBeat.i(214888);
        this.wJt.a(this.name, bVar == null ? null : new a(this, bVar, (byte) 0));
        AppMethodBeat.o(214888);
    }

    final class a implements c.a {
        private final AbstractC2252b<T> SSa;

        /* synthetic */ a(b bVar, AbstractC2252b bVar2, byte b2) {
            this(bVar2);
        }

        private a(AbstractC2252b<T> bVar) {
            this.SSa = bVar;
        }

        @Override // io.flutter.plugin.a.c.a
        public final void a(ByteBuffer byteBuffer, final c.b bVar) {
            AppMethodBeat.i(9830);
            try {
                this.SSa.a(b.this.SRZ.J(byteBuffer), new c<T>() {
                    /* class io.flutter.plugin.a.b.a.AnonymousClass1 */

                    @Override // io.flutter.plugin.a.b.c
                    public final void eO(T t) {
                        AppMethodBeat.i(214887);
                        bVar.I(b.this.SRZ.eP(t));
                        AppMethodBeat.o(214887);
                    }
                });
                AppMethodBeat.o(9830);
            } catch (RuntimeException e2) {
                new StringBuilder("BasicMessageChannel#").append(b.this.name);
                bVar.I(null);
                AppMethodBeat.o(9830);
            }
        }
    }
}
