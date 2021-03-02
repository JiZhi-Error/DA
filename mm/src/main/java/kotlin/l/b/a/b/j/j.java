package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.o.i;
import kotlin.x;

public final class j {
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.Collection<? extends H> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> b(Collection<? extends H> collection, kotlin.g.a.b<? super H, ? extends kotlin.l.b.a.b.b.a> bVar) {
        AppMethodBeat.i(60009);
        p.h(collection, "$this$selectMostSpecificInEachOverridableGroup");
        p.h(bVar, "descriptorByHandle");
        if (collection.size() <= 1) {
            AppMethodBeat.o(60009);
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        i.b bVar2 = i.TSf;
        i hLZ = i.b.hLZ();
        while (true) {
            if (!linkedList.isEmpty()) {
                Object ks = kotlin.a.j.ks(linkedList);
                i.b bVar3 = i.TSf;
                i hLZ2 = i.b.hLZ();
                Collection<? super H> a2 = i.a(ks, linkedList, bVar, new b(hLZ2));
                p.g(a2, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
                if (a2.size() != 1 || !hLZ2.isEmpty()) {
                    Object obj = (Object) i.a(a2, bVar);
                    p.g(obj, "OverridingUtil.selectMos…roup, descriptorByHandle)");
                    kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) bVar.invoke(obj);
                    for (Object obj2 : a2) {
                        p.g(obj2, LocaleUtil.ITALIAN);
                        if (!i.e(aVar, (kotlin.l.b.a.b.b.a) bVar.invoke(obj2))) {
                            hLZ2.add(obj2);
                        }
                    }
                    if (!hLZ2.isEmpty()) {
                        hLZ.addAll(hLZ2);
                    }
                    hLZ.add(obj);
                } else {
                    Object i2 = kotlin.a.j.i(a2);
                    p.g(i2, "overridableGroup.single()");
                    hLZ.add(i2);
                }
            } else {
                i iVar = hLZ;
                AppMethodBeat.o(60009);
                return iVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.b<H, x> {
        final /* synthetic */ i TIj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(1);
            this.TIj = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(60008);
            i iVar = this.TIj;
            p.g(obj, LocaleUtil.ITALIAN);
            iVar.add(obj);
            x xVar = x.SXb;
            AppMethodBeat.o(60008);
            return xVar;
        }
    }

    public static final class a extends q implements kotlin.g.a.b<D, D> {
        public static final a TIi = new a();

        static {
            AppMethodBeat.i(60007);
            AppMethodBeat.o(60007);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(60006);
            kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) obj;
            p.h(aVar, "$receiver");
            AppMethodBeat.o(60006);
            return aVar;
        }
    }
}
