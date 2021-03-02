package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public final Map<String, Map<String, List<Pair<String, String>>>> sAp;
    public final List<Pair<String, String>> sCM;
    public f sCN;
    public b sJf;
    public final Map<String, List<Pair<String, String>>> sJg;
    public final com.tencent.mm.hellhoundlib.a.c sJh = new com.tencent.mm.hellhoundlib.a.c() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.g.c.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(184393);
            if (!"onScrollStateChanged".equals(str2) || !"(Landroid/widget/AbsListView;I)V".equals(str3)) {
                if (!"onScroll".equals(str2) || !"(Landroid/widget/AbsListView;III)V".equals(str3)) {
                    if ("resetStoryHeader".equals(str2) && "()V".equals(str3) && c.this.sJf != null) {
                        c.this.sJf.cQT();
                    }
                } else if (objArr.length >= 4 && c.this.sCN != null) {
                    int intValue = ((Integer) objArr[1]).intValue();
                    int intValue2 = ((Integer) objArr[2]).intValue();
                    ((Integer) objArr[3]).intValue();
                    c.this.sCN.a((ViewGroup) objArr[0], intValue, intValue2, 0);
                    AppMethodBeat.o(184393);
                    return;
                }
            } else if (objArr.length >= 2 && c.this.sCN != null) {
                c.this.sCN.k((ViewGroup) objArr[0], ((Integer) objArr[1]).intValue());
                AppMethodBeat.o(184393);
                return;
            }
            AppMethodBeat.o(184393);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    };
    public b sJi = new b() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.g.c.AnonymousClass2 */

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            AppMethodBeat.i(220600);
            if (str.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI")) {
                if (c.this.sJf == null) {
                    AppMethodBeat.o(220600);
                    return;
                } else if (str4.equals("smoothScrollToPosition")) {
                    if (objArr != null && objArr.length > 0) {
                        c.this.sJf.smoothScrollToPosition(((Integer) objArr[0]).intValue());
                        AppMethodBeat.o(220600);
                        return;
                    }
                } else if (str4.equals("smoothScrollToPositionFromTop")) {
                    if (objArr != null && objArr.length >= 2) {
                        b bVar = c.this.sJf;
                        int intValue = ((Integer) objArr[0]).intValue();
                        ((Integer) objArr[1]).intValue();
                        bVar.Hr(intValue);
                        AppMethodBeat.o(220600);
                        return;
                    }
                } else if (str4.equals("scrollToTop") && objArr != null && objArr.length > 0) {
                    c.this.sJf.cQS();
                }
            }
            AppMethodBeat.o(220600);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
        }
    };
    public final Map<String, List<Pair<String, String>>> sxm;

    c() {
        AppMethodBeat.i(177410);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onScrollStateChanged", "(Landroid/widget/AbsListView;I)V"));
        arrayList.add(Pair.create("onScroll", "(Landroid/widget/AbsListView;III)V"));
        HashMap hashMap = new HashMap();
        hashMap.put("android/widget/AbsListView$OnScrollListener", arrayList);
        this.sAp = new HashMap();
        this.sAp.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", hashMap);
        this.sJg = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Pair.create("resetStoryHeader", "()V"));
        this.sJg.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", arrayList2);
        this.sCM = new ArrayList();
        this.sCM.add(Pair.create("smoothScrollToPosition", "(I)V"));
        this.sCM.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
        this.sxm = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
        this.sxm.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", arrayList3);
        AppMethodBeat.o(177410);
    }
}
