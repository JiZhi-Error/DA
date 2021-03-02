package com.tencent.mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.websearch.widget.view.footer.a;
import com.tencent.mm.ui.aa;

public class DirectionSwitchFooter extends LinearLayout implements a {
    private c IIu;
    private TextView IJc;
    private a.AbstractC1943a IJf;
    private View IJh;
    private View IJi;
    private View IJj;
    private View IJk;
    private Context context;
    private ImageView oeS;

    public DirectionSwitchFooter(Context context2) {
        super(context2);
        AppMethodBeat.i(116744);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116744);
    }

    public DirectionSwitchFooter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(116745);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116745);
    }

    private void init() {
        AppMethodBeat.i(116746);
        ViewGroup viewGroup = (ViewGroup) aa.jQ(this.context).inflate(R.layout.cck, this);
        this.IJc = (TextView) viewGroup.findViewById(R.id.d8x);
        this.oeS = (ImageView) viewGroup.findViewById(R.id.d8i);
        this.IJh = viewGroup.findViewById(R.id.ea5);
        this.IJi = viewGroup.findViewById(R.id.h6o);
        this.IJj = viewGroup.findViewById(R.id.ea6);
        this.IJk = viewGroup.findViewById(R.id.h6r);
        this.IJj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(116742);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (DirectionSwitchFooter.this.IJf != null) {
                    DirectionSwitchFooter.this.IJf.fZm();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116742);
            }
        });
        this.IJk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(116743);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (DirectionSwitchFooter.this.IJf != null) {
                    DirectionSwitchFooter.this.IJf.fZl();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DirectionSwitchFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116743);
            }
        });
        AppMethodBeat.o(116746);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setTitle(String str) {
        AppMethodBeat.i(116747);
        this.IJc.setText(str);
        AppMethodBeat.o(116747);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setIcon(String str) {
        AppMethodBeat.i(116748);
        if (TextUtils.isEmpty(str)) {
            this.oeS.setVisibility(8);
            AppMethodBeat.o(116748);
            return;
        }
        this.oeS.setVisibility(0);
        com.tencent.mm.av.a.a.bdb().a(str, this.oeS, this.IIu);
        AppMethodBeat.o(116748);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setCallback(a.AbstractC1943a aVar) {
        AppMethodBeat.i(116749);
        this.IJf = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() == 1) {
                this.IJj.setVisibility(8);
                this.IJk.setVisibility(8);
            }
            if (this.IJf != null) {
                if (!this.IJf.hasNext()) {
                    this.IJk.setEnabled(false);
                    this.IJi.setEnabled(false);
                } else {
                    this.IJi.setEnabled(true);
                    this.IJk.setEnabled(true);
                }
                if (!this.IJf.hasPrevious()) {
                    this.IJh.setEnabled(false);
                    this.IJj.setEnabled(false);
                    AppMethodBeat.o(116749);
                    return;
                }
                this.IJj.setEnabled(true);
                this.IJh.setEnabled(true);
            }
        }
        AppMethodBeat.o(116749);
    }
}
