package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {
    public static final a ctX = new a() {
        /* class com.tencent.luggage.d.a.a.AnonymousClass1 */

        @Override // com.tencent.luggage.d.a.a
        public final void a(c cVar) {
            AppMethodBeat.i(140459);
            cVar.a(b.PASS);
            AppMethodBeat.o(140459);
        }

        @Override // com.tencent.luggage.d.a.a
        public final void a(String str, c cVar) {
            AppMethodBeat.i(140460);
            cVar.a(b.PASS);
            AppMethodBeat.o(140460);
        }
    };
    public static final a ctY = new a() {
        /* class com.tencent.luggage.d.a.a.AnonymousClass2 */

        @Override // com.tencent.luggage.d.a.a
        public final void a(c cVar) {
            AppMethodBeat.i(140461);
            cVar.a(b.REJECT);
            AppMethodBeat.o(140461);
        }

        @Override // com.tencent.luggage.d.a.a
        public final void a(String str, c cVar) {
            AppMethodBeat.i(140462);
            cVar.a(b.REJECT);
            AppMethodBeat.o(140462);
        }
    };

    void a(c cVar);

    void a(String str, c cVar);
}
