package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;

public final class r {
    public static final Comparator<a> bHu = new Comparator<a>() {
        /* class com.google.android.exoplayer2.i.r.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    public static final Comparator<a> bHv = new Comparator<a>() {
        /* class com.google.android.exoplayer2.i.r.AnonymousClass2 */

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
    public int bHA;
    public int bHB;
    public int bHC;
    public final int bHw = 2000;
    public final ArrayList<a> bHx = new ArrayList<>();
    public final a[] bHy = new a[5];
    public int bHz = -1;

    static {
        AppMethodBeat.i(93197);
        AppMethodBeat.o(93197);
    }

    public r(int i2) {
        AppMethodBeat.i(196069);
        AppMethodBeat.o(196069);
    }

    public static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
