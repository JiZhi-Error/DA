package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class x extends i {
    MMActivity pQZ;
    private TextView qkA;
    private ImageView qkB;
    View qkC;
    private LinearLayout qkD;
    private View.OnClickListener qkE = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.view.x.AnonymousClass1 */

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(113711);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof r)) {
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
                return;
            }
            com.tencent.mm.plugin.card.base.b cvq = x.this.qjX.cvq();
            x.this.qjX.cvs();
            r rVar = (r) view.getTag();
            if (rVar == null) {
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
            } else if (rVar.pWo == null || rVar.pWo.isEmpty()) {
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
            } else if (rVar.pWm != null && rVar.pWm.equals(cvq.csW())) {
                x.this.qkC.setVisibility(8);
                x.this.qjX.cuE();
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
            } else if (!TextUtils.isEmpty(rVar.pWm) || !TextUtils.isEmpty(cvq.csW())) {
                ArrayList<r> ajt = com.tencent.mm.plugin.card.sharecard.a.b.ajt(rVar.pRX);
                if (ajt == null || ajt.size() <= 0) {
                    z = false;
                } else {
                    z = false;
                    for (int i2 = 0; i2 < ajt.size(); i2++) {
                        r rVar2 = ajt.get(i2);
                        if ((rVar2.pWm == null || !rVar2.pWm.equals(rVar.pWm)) && (!TextUtils.isEmpty(rVar2.pWm) || !TextUtils.isEmpty(rVar.pWm))) {
                            rVar2.pWp = false;
                            ajt.set(i2, rVar2);
                        } else {
                            rVar2.pWp = true;
                            if (!rVar2.pWq) {
                                rVar2.pWq = true;
                                z = true;
                            }
                            ajt.set(i2, rVar2);
                        }
                    }
                }
                ShareCardInfo ajA = am.ctY().ajA(rVar.pWo.get(0));
                if (ajA != null) {
                    x.this.qjX.b(ajA);
                }
                if (z && x.this.qjX.cvw() != null) {
                    x.this.qjX.cvw().cvj();
                }
                x.this.qkC.setVisibility(8);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
            } else {
                x.this.qkC.setVisibility(8);
                x.this.qjX.cuE();
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113711);
            }
        }
    };
    private boolean qkv = false;
    private View qkw;
    private View qkx;
    private ImageView qky;
    private TextView qkz;

    public x() {
        AppMethodBeat.i(113712);
        AppMethodBeat.o(113712);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113713);
        this.qkw = findViewById(R.id.hq7);
        this.qkx = findViewById(R.id.hq9);
        this.qky = (ImageView) findViewById(R.id.hq1);
        this.qkz = (TextView) findViewById(R.id.hq2);
        this.qkA = (TextView) findViewById(R.id.hq4);
        this.qkB = (ImageView) findViewById(R.id.hq3);
        this.qkw.setVisibility(8);
        this.qkC = findViewById(R.id.hq5);
        this.qkD = (LinearLayout) findViewById(R.id.hq6);
        this.qkC.setVisibility(8);
        this.pQZ = this.qjX.cvt();
        AppMethodBeat.o(113713);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113715);
        this.qkw.setVisibility(8);
        AppMethodBeat.o(113715);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a8  */
    @Override // com.tencent.mm.plugin.card.ui.view.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update() {
        /*
        // Method dump skipped, instructions count: 725
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.view.x.update():void");
    }
}
