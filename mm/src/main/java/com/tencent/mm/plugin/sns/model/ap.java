package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ap<K, O> {
    Map<K, ap<K, O>.b> DMl = null;
    private a DMm = null;
    private int maxSize;

    public interface a {
        boolean dQ(Object obj);
    }

    public class b<OO> {
        public Long DMo;
        public OO obj;

        public b(OO oo) {
            AppMethodBeat.i(95890);
            this.obj = oo;
            fbu();
            AppMethodBeat.o(95890);
        }

        public final void fbu() {
            AppMethodBeat.i(95891);
            this.DMo = Long.valueOf(System.currentTimeMillis());
            AppMethodBeat.o(95891);
        }
    }

    public ap(int i2, a aVar) {
        AppMethodBeat.i(95892);
        this.maxSize = i2;
        this.DMl = new HashMap();
        this.DMm = aVar;
        AppMethodBeat.o(95892);
    }

    public final void fbt() {
        AppMethodBeat.i(95893);
        if (this.DMl.size() > this.maxSize) {
            ArrayList arrayList = new ArrayList(this.DMl.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<K, ap<K, O>.b>>() {
                /* class com.tencent.mm.plugin.sns.model.ap.AnonymousClass1 */

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(95889);
                    int compareTo = ((b) ((Map.Entry) obj).getValue()).DMo.compareTo(((b) ((Map.Entry) obj2).getValue()).DMo);
                    AppMethodBeat.o(95889);
                    return compareTo;
                }
            });
            int size = this.DMl.size() - this.maxSize;
            if (size <= 0) {
                AppMethodBeat.o(95893);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.DMm.dQ(entry.getKey())) {
                    Log.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                    size--;
                } else {
                    size = size;
                }
                if (size <= 0) {
                    break;
                }
            }
        }
        AppMethodBeat.o(95893);
    }
}
