package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b implements j.a, j.b {
    final List<WeakReference<e.a>> uIe = new ArrayList();
    private final j.a uIf;

    public b(j.a aVar) {
        AppMethodBeat.i(241790);
        this.uIf = aVar;
        AppMethodBeat.o(241790);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap a(final String str, int i2, int i3, int i4) {
        ah avb;
        d<o> dkb;
        AppMethodBeat.i(241791);
        Pair<String, Boolean> aua = aua(str);
        String str2 = (String) aua.first;
        if (((Boolean) aua.second).booleanValue()) {
            if (as.bjt(str2)) {
                avb = ((m) g.af(m.class)).ava(str2);
            } else {
                avb = ((m) g.af(m.class)).avb(str2);
            }
            if (avb != null) {
                String cXH = avb.cXH();
                boolean bjt = as.bjt(str2);
                m mVar = m.uJa;
                com.tencent.mm.loader.c.e a2 = m.a(bjt ? m.a.AVATAR : m.a.WX_AVATAR);
                if (bjt) {
                    m mVar2 = m.uJa;
                    dkb = m.dka();
                } else {
                    m mVar3 = m.uJa;
                    dkb = m.dkb();
                }
                com.tencent.mm.loader.a.b<o, Bitmap> bQ = dkb.bQ(new a(cXH));
                bQ.a(a2);
                Bitmap aJx = bQ.aJx();
                if (aJx == null || aJx.isRecycled()) {
                    bQ.a(new com.tencent.mm.loader.f.e<o, Bitmap>() {
                        /* class com.tencent.mm.plugin.finder.loader.b.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
                        @Override // com.tencent.mm.loader.f.e
                        public final /* synthetic */ void a(a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
                            AppMethodBeat.i(241788);
                            synchronized (b.this.uIe) {
                                try {
                                    Iterator<WeakReference<e.a>> it = b.this.uIe.iterator();
                                    while (it.hasNext()) {
                                        e.a aVar2 = it.next().get();
                                        if (aVar2 != null) {
                                            aVar2.Mr(str);
                                        } else {
                                            it.remove();
                                        }
                                    }
                                } finally {
                                    AppMethodBeat.o(241788);
                                }
                            }
                        }
                    });
                    bQ.aJw();
                } else {
                    AppMethodBeat.o(241791);
                    return aJx;
                }
            }
            AppMethodBeat.o(241791);
            return null;
        }
        Bitmap a3 = this.uIf.a(str2, i2, i3, i4);
        AppMethodBeat.o(241791);
        return a3;
    }

    private static Pair<String, Boolean> aua(String str) {
        AppMethodBeat.i(241792);
        if (as.bjt(str)) {
            Pair<String, Boolean> pair = new Pair<>(str, Boolean.TRUE);
            AppMethodBeat.o(241792);
            return pair;
        } else if (as.bjs(str)) {
            Pair<String, Boolean> pair2 = new Pair<>(str, Boolean.TRUE);
            AppMethodBeat.o(241792);
            return pair2;
        } else {
            String avi = ((aa) g.af(aa.class)).avi(str);
            Pair<String, Boolean> pair3 = new Pair<>(avi, Boolean.valueOf(as.bjt(avi) || as.bjs(avi)));
            AppMethodBeat.o(241792);
            return pair3;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap fZ(String str) {
        AppMethodBeat.i(241793);
        Pair<String, Boolean> aua = aua(str);
        if (((Boolean) aua.second).booleanValue()) {
            Bitmap a2 = a(str, 0, 0, 0);
            AppMethodBeat.o(241793);
            return a2;
        }
        Bitmap fZ = this.uIf.fZ((String) aua.first);
        AppMethodBeat.o(241793);
        return fZ;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap ga(String str) {
        AppMethodBeat.i(241794);
        Pair<String, Boolean> aua = aua(str);
        if (((Boolean) aua.second).booleanValue()) {
            Bitmap a2 = a(str, 0, 0, 0);
            AppMethodBeat.o(241794);
            return a2;
        }
        Bitmap ga = this.uIf.ga((String) aua.first);
        AppMethodBeat.o(241794);
        return ga;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap Wg() {
        AppMethodBeat.i(241795);
        Bitmap Wg = this.uIf.Wg();
        AppMethodBeat.o(241795);
        return Wg;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final void a(final j jVar) {
        AppMethodBeat.i(241796);
        if (jVar instanceof e.a) {
            Pair<String, Boolean> aua = aua(jVar.getTag());
            boolean booleanValue = ((Boolean) aua.second).booleanValue();
            final String str = (String) aua.first;
            if (booleanValue) {
                this.uIe.add(new WeakReference<>((e.a) jVar));
                AppMethodBeat.o(241796);
                return;
            }
            jVar.Kcl = new j.c() {
                /* class com.tencent.mm.plugin.finder.loader.b.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.j.c
                public final boolean auc(String str) {
                    AppMethodBeat.i(241789);
                    if (str.equals(str)) {
                        jVar.goH();
                        jVar.Kcl = null;
                    }
                    AppMethodBeat.o(241789);
                    return true;
                }
            };
            this.uIf.a(jVar);
        }
        AppMethodBeat.o(241796);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.b
    public final boolean aub(String str) {
        AppMethodBeat.i(241797);
        if (!as.bjt(((aa) g.af(aa.class)).avi(str))) {
            AppMethodBeat.o(241797);
            return true;
        }
        AppMethodBeat.o(241797);
        return false;
    }
}
