package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;

public final class i implements k.a {
    View jBN;
    MMActivity pQZ;
    boolean pXX = false;
    View qdd;
    TextView qde;
    ImageView qdf;
    View qdg;
    TextView qdh;
    ImageView qdi;

    public i(MMActivity mMActivity, View view) {
        this.pQZ = mMActivity;
        this.jBN = view;
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void a(g gVar) {
        AppMethodBeat.i(113517);
        cwf();
        AppMethodBeat.o(113517);
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void onChange() {
    }

    /* access modifiers changed from: package-private */
    public final void cwf() {
        AppMethodBeat.i(113518);
        int i2 = am.ctU().pRQ;
        if (i2 <= 0 || !this.pXX) {
            this.qdd.setVisibility(8);
            if (this.qdg != null) {
                this.qdg.setVisibility(8);
            }
            AppMethodBeat.o(113518);
            return;
        }
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, "");
        String str2 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, "");
        int dimensionPixelOffset = this.pQZ.getResources().getDimensionPixelOffset(R.dimen.v9);
        if (!TextUtils.isEmpty(str2)) {
            n.a(this.qdf, str2, dimensionPixelOffset, (int) R.drawable.c24, true);
        } else {
            this.qdf.setImageResource(R.drawable.c24);
        }
        if (!TextUtils.isEmpty(str)) {
            this.qde.setText(str);
        } else {
            this.qde.setText(this.pQZ.getString(R.string.aqa, new Object[]{Integer.valueOf(i2)}));
        }
        this.qdd.setVisibility(0);
        if (this.qdg != null) {
            if (!TextUtils.isEmpty(str2)) {
                n.a(this.qdi, str2, dimensionPixelOffset, (int) R.drawable.c24, true);
            } else {
                this.qdi.setImageResource(R.drawable.c24);
            }
            if (!TextUtils.isEmpty(str)) {
                this.qdh.setText(str);
            } else {
                this.qdh.setText(this.pQZ.getString(R.string.aqa, new Object[]{Integer.valueOf(i2)}));
            }
            this.qdg.setVisibility(0);
        }
        AppMethodBeat.o(113518);
    }
}
