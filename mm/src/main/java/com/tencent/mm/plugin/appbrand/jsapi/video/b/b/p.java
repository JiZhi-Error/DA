package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;

public final class p {
    static final Comparator<a> bHu = new Comparator<a>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.b.p.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    static final Comparator<a> bHv = new Comparator<a>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.b.p.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3.value < aVar4.value) {
                return -1;
            }
            return aVar4.value < aVar3.value ? 1 : 0;
        }
    };
    int bHA;
    int bHB;
    int bHC;
    final int bHw = 2000;
    final ArrayList<a> bHx = new ArrayList<>();
    int bHz = -1;
    final a[] myp = new a[5];

    static {
        AppMethodBeat.i(234771);
        AppMethodBeat.o(234771);
    }

    public p() {
        AppMethodBeat.i(234770);
        AppMethodBeat.o(234770);
    }

    static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
