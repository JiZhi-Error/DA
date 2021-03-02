package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n extends RecyclerView.v {
    public final ImageView gBZ;
    public final CheckBox gxr;
    public final TextView gxs;
    public final ImageView gyr;
    public final TextView hPW;
    public final View jWr;
    public final ProgressBar kdb;
    public final LinearLayout qnZ;
    public final MMPinProgressBtn qoc;
    public final ImageView qoj;
    public final View qol;
    public final TextView timeTv;
    public final TextView titleTv;

    private n(View view) {
        super(view);
        AppMethodBeat.i(123305);
        this.qnZ = (LinearLayout) view.findViewById(R.id.be8);
        this.gyr = (ImageView) view.findViewById(R.id.x1);
        this.gxs = (TextView) view.findViewById(R.id.fti);
        this.timeTv = (TextView) view.findViewById(R.id.in3);
        this.gxr = (CheckBox) view.findViewById(R.id.hhc);
        this.qol = view.findViewById(R.id.hhu);
        this.qoj = (ImageView) view.findViewById(R.id.c4o);
        this.gBZ = (ImageView) view.findViewById(R.id.dtx);
        this.titleTv = (TextView) view.findViewById(R.id.ir3);
        this.hPW = (TextView) view.findViewById(R.id.bop);
        this.qoc = (MMPinProgressBtn) view.findViewById(R.id.buu);
        this.kdb = (ProgressBar) view.findViewById(R.id.epo);
        this.jWr = view.findViewById(R.id.brt);
        this.qnZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.b.n.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(123303);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(123303);
                    return;
                }
                aVar.a(view, aVar);
                a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123303);
            }
        });
        this.qol.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.b.n.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(123304);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(123304);
                    return;
                }
                boolean z = !n.this.gxr.isChecked();
                if (aVar.isEnable()) {
                    n.this.gxr.setChecked(z);
                    aVar.a(z, aVar, n.this);
                }
                a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123304);
            }
        });
        AppMethodBeat.o(123305);
    }

    public static RecyclerView.v o(ViewGroup viewGroup) {
        AppMethodBeat.i(123306);
        n nVar = new n(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ue, viewGroup, false));
        AppMethodBeat.o(123306);
        return nVar;
    }
}
