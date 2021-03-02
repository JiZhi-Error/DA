package com.tencent.mm.plugin.sns.device.appstore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* access modifiers changed from: package-private */
public final class c {
    String DEW;
    String DEX;
    List<String> DEY;
    List<String> DEZ;
    String DFa;
    int mPriority;

    c() {
    }

    /* access modifiers changed from: package-private */
    public final Collection<b> eZC() {
        AppMethodBeat.i(202645);
        ArrayList arrayList = new ArrayList();
        List<String> list = this.DEY;
        List<String> list2 = this.DEZ;
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(202645);
            return arrayList;
        }
        if (list2 == null || list2.isEmpty()) {
            for (String str : list) {
                arrayList.add(b.B(str, "", this.DEW, this.DEX));
            }
        } else {
            for (String str2 : list2) {
                for (String str3 : list) {
                    arrayList.add(b.B(str3, str2, this.DEW, this.DEX));
                }
            }
        }
        AppMethodBeat.o(202645);
        return arrayList;
    }

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(c cVar, c cVar2) {
            AppMethodBeat.i(202644);
            int a2 = a(cVar, cVar2);
            AppMethodBeat.o(202644);
            return a2;
        }

        private static int a(c cVar, c cVar2) {
            AppMethodBeat.i(202643);
            try {
                int compare = Integer.compare(cVar.mPriority, cVar2.mPriority);
                AppMethodBeat.o(202643);
                return compare;
            } catch (Throwable th) {
                AppMethodBeat.o(202643);
                return 0;
            }
        }
    }
}
