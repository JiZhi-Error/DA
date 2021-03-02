package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;

/* access modifiers changed from: package-private */
public final class av implements aw {
    final ConcurrentSkipListSet<aw> kFA = new ConcurrentSkipListSet<>(new Comparator<aw>() {
        /* class com.tencent.mm.plugin.appbrand.av.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(aw awVar, aw awVar2) {
            AppMethodBeat.i(219279);
            aw awVar3 = awVar;
            aw awVar4 = awVar2;
            if (awVar3 == awVar4) {
                AppMethodBeat.o(219279);
                return 0;
            }
            int hashCode = awVar3.hashCode() - awVar4.hashCode();
            AppMethodBeat.o(219279);
            return hashCode;
        }
    });
    final AtomicBoolean kFB = new AtomicBoolean(false);

    av() {
        AppMethodBeat.i(219284);
        AppMethodBeat.o(219284);
    }

    private void s(b<aw, Void> bVar) {
        AppMethodBeat.i(219285);
        Iterator it = new LinkedList(this.kFA).iterator();
        while (it.hasNext()) {
            bVar.invoke((aw) it.next());
        }
        AppMethodBeat.o(219285);
    }

    @Override // com.tencent.mm.plugin.appbrand.aw
    public final void btt() {
        AppMethodBeat.i(219286);
        s(new b<aw, Void>() {
            /* class com.tencent.mm.plugin.appbrand.av.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Void invoke(aw awVar) {
                AppMethodBeat.i(219280);
                awVar.btt();
                AppMethodBeat.o(219280);
                return null;
            }
        });
        AppMethodBeat.o(219286);
    }

    @Override // com.tencent.mm.plugin.appbrand.aw
    public final void btu() {
        AppMethodBeat.i(219287);
        s(new b<aw, Void>() {
            /* class com.tencent.mm.plugin.appbrand.av.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Void invoke(aw awVar) {
                AppMethodBeat.i(219281);
                awVar.btu();
                AppMethodBeat.o(219281);
                return null;
            }
        });
        this.kFB.set(true);
        this.kFA.clear();
        AppMethodBeat.o(219287);
    }

    @Override // com.tencent.mm.plugin.appbrand.aw
    public final void Uu(final String str) {
        AppMethodBeat.i(219288);
        s(new b<aw, Void>() {
            /* class com.tencent.mm.plugin.appbrand.av.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Void invoke(aw awVar) {
                AppMethodBeat.i(219282);
                awVar.Uu(str);
                AppMethodBeat.o(219282);
                return null;
            }
        });
        AppMethodBeat.o(219288);
    }

    @Override // com.tencent.mm.plugin.appbrand.aw
    public final void bru() {
        AppMethodBeat.i(219289);
        s(new b<aw, Void>() {
            /* class com.tencent.mm.plugin.appbrand.av.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Void invoke(aw awVar) {
                AppMethodBeat.i(219283);
                awVar.bru();
                AppMethodBeat.o(219283);
                return null;
            }
        });
        AppMethodBeat.o(219289);
    }
}
