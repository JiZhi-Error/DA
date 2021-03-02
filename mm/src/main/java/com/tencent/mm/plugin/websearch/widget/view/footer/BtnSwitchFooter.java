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

public class BtnSwitchFooter extends LinearLayout implements a {
    private c IIu;
    private TextView IJc;
    private View IJd;
    private View IJe;
    private a.AbstractC1943a IJf;
    private Context context;
    private ImageView oeS;

    public BtnSwitchFooter(Context context2) {
        super(context2);
        AppMethodBeat.i(116733);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116733);
    }

    public BtnSwitchFooter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(116734);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        this.IIu = aVar.bdv();
        this.context = context2;
        init();
        AppMethodBeat.o(116734);
    }

    private void init() {
        AppMethodBeat.i(116735);
        ViewGroup viewGroup = (ViewGroup) aa.jQ(this.context).inflate(R.layout.ccj, this);
        this.IJe = viewGroup.findViewById(R.id.d8g);
        this.IJd = viewGroup.findViewById(R.id.d8t);
        this.IJc = (TextView) viewGroup.findViewById(R.id.d8x);
        this.oeS = (ImageView) viewGroup.findViewById(R.id.d8i);
        this.IJe.setVisibility(8);
        this.IJd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(116732);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BtnSwitchFooter.this.IJf != null) {
                    BtnSwitchFooter.this.IJf.fZk();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/widget/view/footer/BtnSwitchFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(116732);
            }
        });
        AppMethodBeat.o(116735);
    }

    public void setSwitchClickLsn(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116736);
        this.IJd.setOnClickListener(onClickListener);
        AppMethodBeat.o(116736);
    }

    public void setSwitchVisible(int i2) {
        AppMethodBeat.i(116737);
        this.IJd.setVisibility(i2);
        AppMethodBeat.o(116737);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setTitle(String str) {
        AppMethodBeat.i(116738);
        this.IJc.setText(str);
        AppMethodBeat.o(116738);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setIcon(String str) {
        AppMethodBeat.i(116739);
        if (TextUtils.isEmpty(str)) {
            this.oeS.setVisibility(8);
            AppMethodBeat.o(116739);
            return;
        }
        this.oeS.setVisibility(0);
        com.tencent.mm.av.a.a.bdb().a(str, this.oeS, this.IIu);
        AppMethodBeat.o(116739);
    }

    @Override // com.tencent.mm.plugin.websearch.widget.view.footer.a
    public void setCallback(a.AbstractC1943a aVar) {
        AppMethodBeat.i(116740);
        this.IJf = aVar;
        if (aVar != null) {
            if (aVar.getItemCount() > 1) {
                this.IJd.setVisibility(0);
                AppMethodBeat.o(116740);
                return;
            }
            this.IJd.setVisibility(8);
        }
        AppMethodBeat.o(116740);
    }
}
