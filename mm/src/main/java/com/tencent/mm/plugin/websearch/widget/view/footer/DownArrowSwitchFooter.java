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

public class DownArrowSwitchFooter extends LinearLayout implements a {
    private c IIu;
    private TextView IJc;
    private View IJd;
    private a.AbstractC1943a IJf;
    private Context context;
    private ImageView oeS;

    public DownArrowSwitchFooter(Context context2) {
        super(context2);
        AppMethodBeat.i(116752);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116752);
    }

    public DownArrowSwitchFooter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(116753);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116753);
    }

    private void init() {
        AppMethodBeat.i(116754);
        ViewGroup viewGroup = (ViewGroup) aa.jQ(this.context).inflate(R.layout.ccl, this);
        this.IJd = viewGroup.findViewById(R.id.btc);
        this.IJc = (TextView) viewGroup.findViewById(R.id.d8x);
        this.oeS = (ImageView) viewGroup.findViewById(R.id.d8i);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(116751);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/DownArrowSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (DownArrowSwitchFooter.this.IJf != null) {
                    DownArrowSwitchFooter.this.IJf.fZk();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/DownArrowSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116751);
            }
        });
        AppMethodBeat.o(116754);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setTitle(String str) {
        AppMethodBeat.i(116755);
        this.IJc.setText(str);
        AppMethodBeat.o(116755);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setIcon(String str) {
        AppMethodBeat.i(116756);
        if (TextUtils.isEmpty(str)) {
            this.oeS.setVisibility(8);
            AppMethodBeat.o(116756);
            return;
        }
        this.oeS.setVisibility(0);
        com.tencent.mm.av.a.a.bdb().a(str, this.oeS, this.IIu);
        AppMethodBeat.o(116756);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setCallback(a.AbstractC1943a aVar) {
        AppMethodBeat.i(116757);
        this.IJf = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() > 1) {
                this.IJd.setVisibility(0);
                AppMethodBeat.o(116757);
                return;
            }
            this.IJd.setVisibility(8);
        }
        AppMethodBeat.o(116757);
    }
}
