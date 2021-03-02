package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView extends LinearLayout {
    private TextView jVn;
    private TextView qpf;
    private WalletTextView qzt;
    private TextView qzu;

    public CollectBillHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(64034);
        init(context);
        AppMethodBeat.o(64034);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64035);
        init(context);
        AppMethodBeat.o(64035);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(64036);
        init(context);
        AppMethodBeat.o(64036);
    }

    private void init(Context context) {
        AppMethodBeat.i(64037);
        View inflate = aa.jQ(context).inflate(R.layout.ux, this);
        this.qpf = (TextView) inflate.findViewById(R.id.b65);
        this.qzu = (TextView) inflate.findViewById(R.id.b64);
        this.qzt = (WalletTextView) inflate.findViewById(R.id.b67);
        this.jVn = (TextView) inflate.findViewById(R.id.b66);
        AppMethodBeat.o(64037);
    }

    public final void b(int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(64038);
        this.qpf.setText(e.a(getContext(), j2, i4));
        this.qzt.setText(e.Fb(i3));
        this.jVn.setText(getContext().getString(R.string.b6g, Integer.valueOf(i2)));
        AppMethodBeat.o(64038);
    }
}
