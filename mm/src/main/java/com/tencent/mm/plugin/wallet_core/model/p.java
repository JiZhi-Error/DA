package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class p<K> {
    Map<String, Integer> HYe = new HashMap();
    List<K> HYf = new LinkedList();
    public Vector<p<K>.b> HYg = new Vector<>();
    List<String> HYh = new LinkedList();

    public abstract String a(Vector<p<K>.b> vector, int i2);

    public enum a {
        DISABLED,
        CHECKED,
        UNCHECKED;

        static {
            AppMethodBeat.i(70308);
            AppMethodBeat.o(70308);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(70307);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(70307);
            return aVar;
        }
    }

    public class b {
        public K HYn;
        public a HYo;

        public b() {
        }
    }

    public final void f(List<K> list, List<K> list2, List<String> list3) {
        this.HYh = list3;
        this.HYf = list2;
        this.HYg.clear();
        this.HYg = new Vector<>(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            p<K>.b bVar = new b();
            K k = list.get(i2);
            bVar.HYn = k;
            if (this.HYf.contains(k)) {
                bVar.HYo = a.CHECKED;
            } else {
                bVar.HYo = a.DISABLED;
            }
            this.HYg.add(bVar);
        }
        this.HYe.clear();
        for (int i3 = 0; i3 < list3.size(); i3++) {
            this.HYe.put(list3.get(i3), 0);
        }
        fQB();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.p$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] HYi = new int[a.values().length];

        static {
            AppMethodBeat.i(70305);
            try {
                HYi[a.UNCHECKED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                HYi[a.CHECKED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                HYi[a.DISABLED.ordinal()] = 3;
                AppMethodBeat.o(70305);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(70305);
            }
        }
    }

    public final void a(int i2, a aVar) {
        this.HYg.get(i2).HYo = aVar;
    }

    private void fQB() {
        boolean z;
        boolean z2;
        for (int i2 = 0; i2 < this.HYg.size(); i2++) {
            if (this.HYg.get(i2).HYo != a.CHECKED) {
                String a2 = a(this.HYg, i2);
                if (!this.HYe.containsKey(a2)) {
                    String[] aVK = d.aVK(a2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.HYh.size()) {
                            z = false;
                            break;
                        }
                        int i4 = 0;
                        while (true) {
                            if (i4 >= aVK.length) {
                                z2 = true;
                                break;
                            } else if (!this.HYh.get(i3).contains(aVK[i4])) {
                                z2 = false;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z) {
                        a(i2, a.DISABLED);
                    }
                }
                a(i2, a.UNCHECKED);
            }
        }
    }
}
