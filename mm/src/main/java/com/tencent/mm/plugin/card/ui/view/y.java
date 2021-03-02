package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class y extends i {
    private b pQV;
    private MMActivity pQZ;
    private View qkG;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113716);
        this.pQZ = this.qjX.cvt();
        AppMethodBeat.o(113716);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113717);
        this.pQV = this.qjX.cvq();
        if (this.qkG == null) {
            this.qkG = ((ViewStub) findViewById(R.id.ap8)).inflate();
        }
        if (this.pQV.csz()) {
            this.qkG.setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(R.color.hn)));
        }
        TextView textView = (TextView) this.qkG.findViewById(R.id.ap9);
        if (this.pQV.csR() == null) {
            Log.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            AppMethodBeat.o(113717);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.pQZ.getResources().getColor(R.color.tx));
        if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
            textView.setText(this.pQV.csQ().LeY);
            AppMethodBeat.o(113717);
            return;
        }
        n.h(textView, this.pQV.csR().status);
        AppMethodBeat.o(113717);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113718);
        if (this.qkG != null) {
            this.qkG.setVisibility(8);
        }
        AppMethodBeat.o(113718);
    }
}
