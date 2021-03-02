package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class p extends b {
    private boolean QiI = false;
    private WeImageView hex;
    private View oQL;
    private View oQM;
    private TextView titleTv;

    public p(Context context) {
        super(context);
        AppMethodBeat.i(38853);
        if (!this.QiI && this.view != null) {
            this.oQL = this.view.findViewById(R.id.a24);
            this.oQM = this.view.findViewById(R.id.a29);
            this.hex = (WeImageView) this.view.findViewById(R.id.a26);
            this.hex.setIconColor(((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50));
            this.titleTv = (TextView) this.view.findViewById(R.id.a2_);
            this.QiI = true;
        }
        AppMethodBeat.o(38853);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.bh7;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(38854);
        if (this.oQL != null) {
            this.oQL.setVisibility(i2);
        }
        AppMethodBeat.o(38854);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    private static boolean q(Object obj, int i2) {
        AppMethodBeat.i(38856);
        if (obj == null) {
            AppMethodBeat.o(38856);
            return true;
        } else if (((Integer) obj).intValue() != i2) {
            AppMethodBeat.o(38856);
            return true;
        } else {
            AppMethodBeat.o(38856);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f5  */
    @Override // com.tencent.mm.pluginsdk.ui.b.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bYa() {
        /*
        // Method dump skipped, instructions count: 767
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.a.p.bYa():boolean");
    }
}
