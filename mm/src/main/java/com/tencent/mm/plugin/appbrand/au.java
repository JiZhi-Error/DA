package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

public final class au implements ao {
    public final ConcurrentSkipListSet<ao> kFx = new ConcurrentSkipListSet<>(new Comparator<ao>() {
        /* class com.tencent.mm.plugin.appbrand.au.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(ao aoVar, ao aoVar2) {
            AppMethodBeat.i(219272);
            ao aoVar3 = aoVar;
            ao aoVar4 = aoVar2;
            if (aoVar3 == aoVar4) {
                AppMethodBeat.o(219272);
                return 0;
            }
            int hashCode = aoVar3.hashCode() - aoVar4.hashCode();
            AppMethodBeat.o(219272);
            return hashCode;
        }
    });

    au() {
        AppMethodBeat.i(219275);
        AppMethodBeat.o(219275);
    }

    private void a(c<ao> cVar) {
        AppMethodBeat.i(219276);
        Iterator it = new LinkedList(this.kFx).iterator();
        while (it.hasNext()) {
            cVar.accept((ao) it.next());
        }
        AppMethodBeat.o(219276);
    }

    @Override // com.tencent.mm.plugin.appbrand.ao
    public final void b(final ak akVar) {
        AppMethodBeat.i(219277);
        a(new c<ao>() {
            /* class com.tencent.mm.plugin.appbrand.au.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(ao aoVar) {
                AppMethodBeat.i(219273);
                aoVar.b(akVar);
                AppMethodBeat.o(219273);
            }
        });
        AppMethodBeat.o(219277);
    }

    @Override // com.tencent.mm.plugin.appbrand.ao
    public final void btq() {
        AppMethodBeat.i(219278);
        a(new c<ao>() {
            /* class com.tencent.mm.plugin.appbrand.au.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(ao aoVar) {
                AppMethodBeat.i(219274);
                aoVar.btq();
                AppMethodBeat.o(219274);
            }
        });
        AppMethodBeat.o(219278);
    }
}
