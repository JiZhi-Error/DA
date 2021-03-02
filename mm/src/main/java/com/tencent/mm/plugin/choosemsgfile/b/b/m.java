package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m extends RecyclerView.v {
    public final CheckBox gxr;
    public final ProgressBar kdb;
    public final ImageView puw;
    public final View qob;
    public final MMPinProgressBtn qoc;
    public final TextView qod;
    public final TextView qoe;
    public final View qof;
    public final TextView qog;
    public final ImageView qoh;
    public final View qoi;
    public ImageView qoj;

    private m(View view) {
        super(view);
        AppMethodBeat.i(123301);
        this.qob = view.findViewById(R.id.be8);
        this.puw = (ImageView) view.findViewById(R.id.bh7);
        this.qoc = (MMPinProgressBtn) view.findViewById(R.id.buu);
        this.kdb = (ProgressBar) view.findViewById(R.id.epo);
        this.qof = view.findViewById(R.id.j6d);
        this.qog = (TextView) view.findViewById(R.id.j6p);
        this.qod = (TextView) view.findViewById(R.id.cgm);
        this.qoe = (TextView) view.findViewById(R.id.cgn);
        this.qoh = (ImageView) view.findViewById(R.id.fa9);
        this.gxr = (CheckBox) view.findViewById(R.id.hhc);
        this.qoi = view.findViewById(R.id.hiu);
        this.qoj = (ImageView) view.findViewById(R.id.c4o);
        this.puw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.b.m.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(123299);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(123299);
                    return;
                }
                aVar.a(view, aVar);
                a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123299);
            }
        });
        this.qoi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.b.m.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(123300);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) view.getTag();
                if (aVar == null) {
                    a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(123300);
                    return;
                }
                boolean z = !m.this.gxr.isChecked();
                if (aVar.isEnable()) {
                    m.this.gxr.setChecked(z);
                    aVar.a(z, aVar, m.this);
                    if (!z) {
                        m.this.qoh.setVisibility(0);
                    } else {
                        m.this.qoh.setVisibility(8);
                    }
                }
                a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123300);
            }
        });
        AppMethodBeat.o(123301);
    }

    public static RecyclerView.v o(ViewGroup viewGroup) {
        AppMethodBeat.i(123302);
        m mVar = new m(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ud, viewGroup, false));
        AppMethodBeat.o(123302);
        return mVar;
    }
}
