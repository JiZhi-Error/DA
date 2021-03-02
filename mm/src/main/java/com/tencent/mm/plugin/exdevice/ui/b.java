package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private Context mContext;
    private String mRa = z.aTY();
    List<d> rJD;
    Map<String, String> rJE;
    String rJF;
    c rJG;
    private String rJH;
    private boolean rJI = false;
    private d.a rJJ = new d.a();
    private View.OnClickListener rJK = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.exdevice.ui.b.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(24166);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            b.this.rJG.anW(b.this.GI(((Integer) view.getTag()).intValue()).rMD.field_username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24166);
        }
    };
    private View.OnClickListener rJL = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.exdevice.ui.b.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(24167);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.this.rJG.anW(b.this.mRa);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24167);
        }
    };
    private View.OnClickListener rJM = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.exdevice.ui.b.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(231714);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.this.rJG.cMa();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231714);
        }
    };

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(24179);
        d GI = GI(i2);
        AppMethodBeat.o(24179);
        return GI;
    }

    public b(Context context, String str) {
        AppMethodBeat.i(24168);
        this.mContext = context;
        this.rJH = str;
        AppMethodBeat.o(24168);
    }

    private static void e(LinkedList<c> linkedList, String str) {
        AppMethodBeat.i(24169);
        Iterator<c> it = linkedList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.field_username.equalsIgnoreCase(str)) {
                Log.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", next.toString());
                it.remove();
            }
        }
        AppMethodBeat.o(24169);
    }

    private static boolean f(LinkedList<c> linkedList, String str) {
        AppMethodBeat.i(24170);
        try {
            Iterator<c> it = linkedList.iterator();
            while (it.hasNext()) {
                if (it.next().field_username.equalsIgnoreCase(str)) {
                    AppMethodBeat.o(24170);
                    return true;
                }
            }
            AppMethodBeat.o(24170);
            return false;
        } catch (Exception e2) {
            Log.d("MicroMsg.ExdeviceRankAdapter", e2.toString());
            AppMethodBeat.o(24170);
            return false;
        }
    }

    private List<d> a(ArrayList<c> arrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> arrayList2, boolean z) {
        AppMethodBeat.i(24171);
        LinkedList linkedList = new LinkedList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        com.tencent.mm.plugin.exdevice.g.b.a.d h2 = h(this.mRa, arrayList2);
        if (h2 != null) {
            d.a aVar = this.rJJ;
            aVar.rMD = h2;
            aVar.rME = 3;
            if (h2.field_score == 0) {
                ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).l((Activity) this.mContext, this.mRa);
            }
        } else {
            d.a aVar2 = this.rJJ;
            aVar2.rMD = null;
            aVar2.rJH = this.rJH;
            aVar2.username = this.mRa;
            aVar2.rME = 7;
        }
        if (z) {
            this.rJJ.azh = 2;
        } else {
            this.rJJ.azh = 1;
        }
        arrayList3.add(this.rJJ.cMh());
        d.a aVar3 = this.rJJ;
        aVar3.azh = 0;
        arrayList3.add(aVar3.cMh());
        e(linkedList, this.mRa);
        ArrayList arrayList4 = new ArrayList();
        Log.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        Iterator<com.tencent.mm.plugin.exdevice.g.b.a.d> it = arrayList2.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.g.b.a.d next = it.next();
            d.a aVar4 = this.rJJ;
            aVar4.rMD = next;
            aVar4.azh = 1;
            aVar4.rME = 4;
            arrayList4.add(aVar4.cMh());
            if (linkedList.size() > 0 && f(linkedList, next.field_username)) {
                d.a aVar5 = this.rJJ;
                aVar5.rMD = next;
                aVar5.azh = 1;
                aVar5.rME = 2;
                arrayList3.add(aVar5.cMh());
                e(linkedList, next.field_username);
            }
        }
        if (linkedList.size() > 0) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                d.a aVar6 = this.rJJ;
                aVar6.username = ((c) it2.next()).field_username;
                aVar6.rJH = this.rJH;
                aVar6.rMD = null;
                aVar6.azh = 1;
                aVar6.rME = 6;
                arrayList3.add(aVar6.cMh());
            }
        }
        if (arrayList3.size() > 2) {
            ((d) arrayList3.get(arrayList3.size() - 1)).rME = ((d) arrayList3.get(arrayList3.size() - 1)).rME | 2 | 1;
            d.a aVar7 = this.rJJ;
            aVar7.azh = 0;
            aVar7.rMD = null;
            arrayList3.add(aVar7.cMh());
        }
        if (arrayList4.size() > 1) {
            ((d) arrayList4.get(arrayList4.size() - 1)).rME = 5;
        }
        arrayList3.addAll(arrayList4);
        Log.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", Integer.valueOf(arrayList2.size()), arrayList2.toString());
        Log.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", Integer.valueOf(arrayList3.size()), arrayList3.toString());
        AppMethodBeat.o(24171);
        return arrayList3;
    }

    public final List<d> b(ArrayList<c> arrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> arrayList2, boolean z) {
        AppMethodBeat.i(24172);
        if (arrayList == null) {
            try {
                arrayList = new ArrayList<>();
            } catch (Exception e2) {
                Log.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                ArrayList arrayList3 = new ArrayList();
                AppMethodBeat.o(24172);
                return arrayList3;
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        List<d> a2 = a(arrayList, arrayList2, z);
        AppMethodBeat.o(24172);
        return a2;
    }

    public static com.tencent.mm.plugin.exdevice.g.b.a.d h(String str, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> arrayList) {
        AppMethodBeat.i(24173);
        if (arrayList == null) {
            AppMethodBeat.o(24173);
            return null;
        }
        Iterator<com.tencent.mm.plugin.exdevice.g.b.a.d> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.g.b.a.d next = it.next();
            if (str.equalsIgnoreCase(next.field_username)) {
                AppMethodBeat.o(24173);
                return next;
            }
        }
        AppMethodBeat.o(24173);
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i2) {
        return false;
    }

    public final int getCount() {
        AppMethodBeat.i(24174);
        if (this.rJD == null) {
            AppMethodBeat.o(24174);
            return 0;
        }
        int size = this.rJD.size();
        AppMethodBeat.o(24174);
        return size;
    }

    public final d GI(int i2) {
        AppMethodBeat.i(24175);
        d dVar = this.rJD.get(i2);
        AppMethodBeat.o(24175);
        return dVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(24176);
        int i3 = GI(i2).azh;
        AppMethodBeat.o(24176);
        return i3;
    }

    public static void finish() {
        AppMethodBeat.i(24177);
        ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).fmi();
        AppMethodBeat.o(24177);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0397  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
        // Method dump skipped, instructions count: 944
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.b$b  reason: collision with other inner class name */
    static final class C1005b {
        public View jxm;
        public View pxo;
        public TextView rAP;
        public ImageView rJS;
        public NoMeasuredTextView rJT;
        public TextView rJU;
        public ExdeviceLikeView rJV;
        public View rJW;
        public View rJX;
        public View rJY;
        public TextView rJZ;
        public View rKa;
        public ImageView rKb;
        public TextView rKc;
        public TextView rKd;
        public TextView rKe;
        public TextView rKf;

        C1005b() {
        }
    }

    static final class a {
        public View jWr;

        a() {
        }
    }
}
