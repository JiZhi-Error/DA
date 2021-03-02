package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;

public class HoneyPayCardLayout extends LinearLayout {
    private ImageView qyu;
    private String yjY;
    private TextView ykq;
    private TextView ykr;
    private WalletTextView yks;
    private TextView ykt;
    private CdnImageView yku;

    public HoneyPayCardLayout(Context context) {
        super(context);
        AppMethodBeat.i(64678);
        init();
        AppMethodBeat.o(64678);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64679);
        init();
        AppMethodBeat.o(64679);
    }

    public HoneyPayCardLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(64680);
        init();
        AppMethodBeat.o(64680);
    }

    private void init() {
        AppMethodBeat.i(64681);
        View inflate = inflate(getContext(), R.layout.auf, this);
        this.qyu = (ImageView) inflate.findViewById(R.id.dqv);
        this.yks = (WalletTextView) inflate.findViewById(R.id.dqz);
        this.ykq = (TextView) inflate.findViewById(R.id.dr1);
        this.ykr = (TextView) inflate.findViewById(R.id.dr0);
        this.ykt = (TextView) inflate.findViewById(R.id.dqx);
        this.yku = (CdnImageView) inflate.findViewById(R.id.dqw);
        this.yks.setPrefix(ah.hhz());
        AppMethodBeat.o(64681);
    }

    public void setCardRecord(cbv cbv) {
        long j2 = 0;
        AppMethodBeat.i(64682);
        this.yjY = cbv.LWD;
        this.ykt.setText(cbv.pTn);
        if (!Util.isNullOrNil(cbv.icon)) {
            this.yku.gI(cbv.icon, c.OM(cbv.nHh));
        }
        a.b.a(this.qyu, cbv.LjD, 0.06f, false);
        f.i(this.ykq, cbv.LjD);
        this.yks.setText(c.GO(cbv.LpD));
        if (cbv.MhI == 0) {
            this.ykr.setTextColor(getResources().getColor(R.color.Orange));
            this.ykr.setText(R.string.e1a);
            AppMethodBeat.o(64682);
        } else if (cbv.MhI != 1) {
            Log.w("MicroMsg.HoneyPayCardLayout", "unknown rcvd: %s", Integer.valueOf(cbv.MhI));
            AppMethodBeat.o(64682);
        } else if (cbv.MhK == 0) {
            long j3 = cbv.MhJ;
            if (j3 < 0) {
                Log.w("MicroMsg.HoneyPayCardLayout", "unused quota wrong: %s", Long.valueOf(j3));
            } else {
                j2 = j3;
            }
            this.ykr.setText(getContext().getString(R.string.e1_, ah.hhz() + c.GO(j2)));
            AppMethodBeat.o(64682);
        } else {
            Log.i("MicroMsg.HoneyPayCardLayout", "show check detail");
            this.ykr.setText("");
            AppMethodBeat.o(64682);
        }
    }
}
