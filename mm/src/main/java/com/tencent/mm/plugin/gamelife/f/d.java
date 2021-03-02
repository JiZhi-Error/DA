package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d implements j.a, j.b {
    final List<WeakReference<j>> uIe = new ArrayList();
    private final j.a uIf;

    public d(j.a aVar) {
        AppMethodBeat.i(241563);
        this.uIf = aVar;
        AppMethodBeat.o(241563);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap a(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(241564);
        Pair<String, Boolean> aBb = aBb(str);
        final String str2 = (String) aBb.first;
        if (((Boolean) aBb.second).booleanValue()) {
            a aAR = ((b) g.af(b.class)).aAR(str2);
            if (aAR != null) {
                String nullAsNil = Util.nullAsNil(aAR.cXH());
                e eVar = e.ycg;
                Bitmap aJx = e.getLoader().bQ(new a(nullAsNil)).aJx();
                if (aJx != null && !aJx.isRecycled()) {
                    AppMethodBeat.o(241564);
                    return aJx;
                }
            }
            ((b) g.af(b.class)).a(str2, new b.c() {
                /* class com.tencent.mm.plugin.gamelife.f.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.gamelife.a.b.c
                public final void aj(Map<String, a> map) {
                    AppMethodBeat.i(241561);
                    a aVar = map.get(str2);
                    if (aVar == null) {
                        Log.w("GameLife.AvatarDrawableLoader", "get contact failed");
                        AppMethodBeat.o(241561);
                        return;
                    }
                    String cXH = aVar.cXH();
                    e eVar = e.ycg;
                    com.tencent.mm.loader.a.b<a, Bitmap> bQ = e.getLoader().bQ(new a(cXH));
                    bQ.a(new e<a, Bitmap>() {
                        /* class com.tencent.mm.plugin.gamelife.f.d.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
                        @Override // com.tencent.mm.loader.f.e
                        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<a> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
                            AppMethodBeat.i(241560);
                            synchronized (d.this.uIe) {
                                try {
                                    Iterator<WeakReference<j>> it = d.this.uIe.iterator();
                                    while (it.hasNext()) {
                                        j jVar = it.next().get();
                                        if (jVar == null) {
                                            it.remove();
                                        } else if (((b) g.af(b.class)).aAR((String) d.aBb(jVar.getTag()).first).cXH().equals(aVar.value().url)) {
                                            jVar.Mr(jVar.getTag());
                                        }
                                    }
                                } finally {
                                    AppMethodBeat.o(241560);
                                }
                            }
                        }
                    });
                    bQ.aJw();
                    AppMethodBeat.o(241561);
                }
            });
            AppMethodBeat.o(241564);
            return null;
        }
        Bitmap a2 = this.uIf.a(str2, i2, i3, i4);
        AppMethodBeat.o(241564);
        return a2;
    }

    static Pair<String, Boolean> aBb(String str) {
        AppMethodBeat.i(241565);
        if (as.bjv(str)) {
            Pair<String, Boolean> pair = new Pair<>(str, Boolean.TRUE);
            AppMethodBeat.o(241565);
            return pair;
        }
        String avi = ((f) g.af(f.class)).avi(str);
        Pair<String, Boolean> pair2 = new Pair<>(avi, Boolean.valueOf(as.bjv(avi)));
        AppMethodBeat.o(241565);
        return pair2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap fZ(String str) {
        AppMethodBeat.i(241566);
        Pair<String, Boolean> aBb = aBb(str);
        if (((Boolean) aBb.second).booleanValue()) {
            Bitmap a2 = a(str, 0, 0, 0);
            AppMethodBeat.o(241566);
            return a2;
        }
        Bitmap fZ = this.uIf.fZ((String) aBb.first);
        AppMethodBeat.o(241566);
        return fZ;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap ga(String str) {
        AppMethodBeat.i(241567);
        Pair<String, Boolean> aBb = aBb(str);
        if (((Boolean) aBb.second).booleanValue()) {
            Bitmap a2 = a(str, 0, 0, 0);
            AppMethodBeat.o(241567);
            return a2;
        }
        Bitmap ga = this.uIf.ga((String) aBb.first);
        AppMethodBeat.o(241567);
        return ga;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap Wg() {
        AppMethodBeat.i(241568);
        Bitmap Wg = this.uIf.Wg();
        AppMethodBeat.o(241568);
        return Wg;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final void a(final j jVar) {
        AppMethodBeat.i(241569);
        if (jVar instanceof e.a) {
            Pair<String, Boolean> aBb = aBb(jVar.getTag());
            boolean booleanValue = ((Boolean) aBb.second).booleanValue();
            final String str = (String) aBb.first;
            if (booleanValue) {
                this.uIe.add(new WeakReference<>(jVar));
                AppMethodBeat.o(241569);
                return;
            }
            jVar.Kcl = new j.c() {
                /* class com.tencent.mm.plugin.gamelife.f.d.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.j.c
                public final boolean auc(String str) {
                    AppMethodBeat.i(241562);
                    if (str.equals(str)) {
                        jVar.goH();
                        jVar.Kcl = null;
                    }
                    AppMethodBeat.o(241562);
                    return true;
                }
            };
            this.uIf.a(jVar);
        }
        AppMethodBeat.o(241569);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.b
    public final boolean aub(String str) {
        AppMethodBeat.i(241570);
        if (!as.bjv(((f) g.af(f.class)).avi(str))) {
            AppMethodBeat.o(241570);
            return true;
        }
        AppMethodBeat.o(241570);
        return false;
    }
}
