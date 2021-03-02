package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayCashierDetailItemLayout extends LinearLayout {
    private static final int Ilg = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    private static final int Ilh = a.fromDPToPix(MMApplicationContext.getContext(), 11);
    private static final int qql = a.fromDPToPix(MMApplicationContext.getContext(), 288);
    public TextView Cqw;
    public CdnImageView Ili;
    public CdnImageView Ilj;
    public TextView qWU;

    static {
        AppMethodBeat.i(71333);
        AppMethodBeat.o(71333);
    }

    public WcPayCashierDetailItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(71327);
        init();
        AppMethodBeat.o(71327);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71328);
        init();
        AppMethodBeat.o(71328);
    }

    public WcPayCashierDetailItemLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71329);
        init();
        AppMethodBeat.o(71329);
    }

    private void init() {
        AppMethodBeat.i(71330);
        View.inflate(getContext(), R.layout.car, this);
        this.Cqw = (TextView) findViewById(R.id.jpt);
        this.Ili = (CdnImageView) findViewById(R.id.jpu);
        this.qWU = (TextView) findViewById(R.id.jpw);
        this.Ilj = (CdnImageView) findViewById(R.id.jpv);
        Drawable drawable = this.Ilj.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(getResources().getColor(R.color.BW_50), PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(71330);
    }

    public final void fTs() {
        AppMethodBeat.i(71331);
        if (this.qWU.getVisibility() != 8) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(71325);
                    int width = WcPayCashierDetailItemLayout.this.Cqw.getWidth();
                    if (WcPayCashierDetailItemLayout.this.Ili.getVisibility() != 8) {
                        width += WcPayCashierDetailItemLayout.Ilg;
                    }
                    if (WcPayCashierDetailItemLayout.this.Ilj.getVisibility() != 8) {
                        width += WcPayCashierDetailItemLayout.Ilh;
                    }
                    WcPayCashierDetailItemLayout.this.qWU.setMaxWidth(WcPayCashierDetailItemLayout.qql - width);
                    AppMethodBeat.o(71325);
                }
            });
        }
        AppMethodBeat.o(71331);
    }

    public final void U(CharSequence charSequence) {
        AppMethodBeat.i(71332);
        this.qWU.setText(charSequence);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(71326);
                Layout layout = WcPayCashierDetailItemLayout.this.qWU.getLayout();
                if (layout != null && layout.getLineCount() > 1) {
                    WcPayCashierDetailItemLayout.this.qWU.setMaxWidth((int) layout.getLineWidth(0));
                }
                AppMethodBeat.o(71326);
            }
        });
        AppMethodBeat.o(71332);
    }
}
