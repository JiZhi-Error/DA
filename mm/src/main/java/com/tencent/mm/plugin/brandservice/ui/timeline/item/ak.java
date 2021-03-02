package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class ak extends aj {
    public LinearLayout pwA;
    public LinearLayout pwz;
    public LinearLayout pxI;
    public LinearLayout pxJ;
    public TextView pxK;
    public List<ah> pxL = new ArrayList();
    public ar pxM = new ar();
    public at pxN = new at();
    public ap pxO = new ap();
    public aq pxP = new aq();
    public au pxQ = new au();
    public ao pxR = new ao();
    public as pxS = new as();
    private View.OnClickListener pxT = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ak.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(6028);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            z zVar = (z) view.getTag();
            zVar.field_isExpand = true;
            zVar.field_status = 4;
            zVar.field_isRead = 1;
            zVar.field_hasShow = 1;
            ag.ban().C(zVar);
            com.tencent.mm.plugin.brandservice.ui.timeline.b.cB(ak.this.pxE.nZr);
            ak.this.pxE.pqZ.f(zVar, 0);
            a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(6028);
        }
    };

    public ak() {
        AppMethodBeat.i(6030);
        AppMethodBeat.o(6030);
    }

    private void a(View view, ai aiVar, boolean z) {
        AppMethodBeat.i(6031);
        if (z) {
            if (aiVar.puO == null) {
                aiVar.a(view, this.pxE);
            }
            if (aiVar.puO != null) {
                aiVar.puO.setVisibility(0);
                AppMethodBeat.o(6031);
                return;
            }
        } else if (aiVar.puO != null) {
            aiVar.puO.setVisibility(8);
        }
        AppMethodBeat.o(6031);
    }

    private void a(ak akVar, int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        AppMethodBeat.i(6032);
        boolean z8 = i2 == 5;
        a(akVar.pxI, akVar.pxN, z8);
        if (z8) {
            z = true;
        } else {
            z = false;
        }
        if (i2 == 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        a(akVar.pxI, akVar.pxP, z2);
        if (z2) {
            z = true;
        }
        if (i2 == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(akVar.pxI, akVar.pxQ, z3);
        if (z3) {
            z = true;
        }
        if (i2 == 6) {
            z4 = true;
        } else {
            z4 = false;
        }
        a(akVar.pxI, akVar.pxR, z4);
        if (z4) {
            z = true;
        }
        if (i2 == 10) {
            z5 = true;
        } else {
            z5 = false;
        }
        a(akVar.pxI, akVar.pxS, z5);
        if (z5) {
            z6 = true;
        } else {
            z6 = z;
        }
        LinearLayout linearLayout = akVar.pxI;
        ar arVar = akVar.pxM;
        if (z6 || i3 <= 0 || i2 == -1) {
            z7 = false;
        }
        a(linearLayout, arVar, z7);
        AppMethodBeat.o(6032);
    }

    private static void c(v vVar) {
        if (vVar.type == 6) {
            vVar.type = 7;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0341 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01b0 A[LOOP:2: B:29:0x01a6->B:31:0x01b0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0335  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(final com.tencent.mm.storage.z r31, int r32, android.view.View r33) {
        /*
        // Method dump skipped, instructions count: 1500
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.ak.a(com.tencent.mm.storage.z, int, android.view.View):android.view.View");
    }

    private static void s(View view, int i2, int i3) {
        AppMethodBeat.i(6033);
        view.setPadding(0, i2 - com.tencent.mm.plugin.brandservice.ui.timeline.b.prB, 0, i3 - com.tencent.mm.plugin.brandservice.ui.timeline.b.prB);
        AppMethodBeat.o(6033);
    }

    private static void X(View view, int i2) {
        AppMethodBeat.i(6034);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(6034);
    }
}
