package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.abz;

public final class c extends a {
    protected TextView qlB;
    protected TextView qlC;

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxM() {
        AppMethodBeat.i(113902);
        this.qlC = (TextView) cxL().findViewById(R.id.akb);
        this.qlB = (TextView) cxL().findViewById(R.id.ap_);
        AppMethodBeat.o(113902);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxN() {
        AppMethodBeat.i(113903);
        if (this.pQV.csQ().LeC != null && this.pQV.csQ().LeC.size() > 0) {
            abz abz = this.pQV.csQ().LeC.get(0);
            if (this.oeJ != null) {
                this.oeJ.setText(abz.title);
            }
            if (this.qlB != null) {
                if (!TextUtils.isEmpty(abz.pRY)) {
                    this.qlB.setText(abz.pRY);
                } else {
                    this.qlB.setVisibility(8);
                }
            }
            if (this.qlC != null) {
                if (!TextUtils.isEmpty(abz.pRZ)) {
                    this.qlC.setText(abz.pRZ);
                    AppMethodBeat.o(113903);
                    return;
                }
                this.qlC.setVisibility(8);
            }
        }
        AppMethodBeat.o(113903);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void H(boolean z, boolean z2) {
    }
}
