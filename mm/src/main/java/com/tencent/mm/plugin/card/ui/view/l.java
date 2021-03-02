package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agz;
import java.util.LinkedList;

public final class l extends i {
    View qjZ;
    LinearLayout qka;
    boolean qkb = false;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113682);
        if (this.qjZ == null) {
            this.qjZ = ((ViewStub) findViewById(R.id.am2)).inflate();
        }
        final agz agz = this.qjX.cvq().csR().LcB;
        ((TextView) this.qjZ.findViewById(R.id.bok)).setText(agz.title);
        if (agz.LqE != null && agz.LqE.size() > 0) {
            this.qka = (LinearLayout) this.qjZ.findViewById(R.id.boj);
            this.qka.removeAllViews();
            final LinkedList<abz> linkedList = agz.LqE;
            final LayoutInflater layoutInflater = (LayoutInflater) this.qjX.cvt().getSystemService("layout_inflater");
            if (agz.LqD >= linkedList.size() || this.qkb) {
                this.qjZ.findViewById(R.id.boi).setVisibility(8);
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    TextView textView = (TextView) layoutInflater.inflate(R.layout.p3, (ViewGroup) null, false);
                    textView.setText(linkedList.get(i2).title);
                    this.qka.addView(textView);
                }
                this.qka.invalidate();
                AppMethodBeat.o(113682);
                return;
            }
            for (int i3 = 0; i3 < agz.LqD; i3++) {
                TextView textView2 = (TextView) layoutInflater.inflate(R.layout.p3, (ViewGroup) null, false);
                textView2.setText(linkedList.get(i3).title);
                this.qka.addView(textView2);
            }
            this.qka.invalidate();
            this.qjZ.findViewById(R.id.boi).setVisibility(0);
            this.qjZ.findViewById(R.id.boi).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.view.l.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113681);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    l.this.qkb = true;
                    l.this.qjZ.findViewById(R.id.boi).setVisibility(8);
                    for (int i2 = agz.LqD; i2 < linkedList.size(); i2++) {
                        TextView textView = (TextView) layoutInflater.inflate(R.layout.p3, (ViewGroup) null, false);
                        textView.setText(((abz) linkedList.get(i2)).title);
                        l.this.qka.addView(textView);
                    }
                    l.this.qka.invalidate();
                    a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113681);
                }
            });
        }
        AppMethodBeat.o(113682);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113683);
        if (this.qjZ != null) {
            this.qjZ.setVisibility(8);
        }
        AppMethodBeat.o(113683);
    }
}
