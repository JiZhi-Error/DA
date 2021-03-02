package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView ImZ;
    private TextView Ina;
    ImageView Inb;
    private int Inc;

    public SwitchPhoneItemView(Context context) {
        this(context, 0);
    }

    public SwitchPhoneItemView(Context context, int i2) {
        super(context);
        AppMethodBeat.i(71489);
        this.Inc = 0;
        this.Inc = i2;
        bh(context);
        AppMethodBeat.o(71489);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71490);
        this.Inc = 0;
        bh(context);
        AppMethodBeat.o(71490);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71491);
        this.Inc = 0;
        bh(context);
        AppMethodBeat.o(71491);
    }

    private void bh(Context context) {
        View inflate;
        AppMethodBeat.i(71492);
        if (this.Inc > 0) {
            inflate = inflate(context, this.Inc, this);
        } else {
            inflate = inflate(context, R.layout.ca7, this);
        }
        this.ImZ = (TextView) inflate.findViewById(R.id.gay);
        this.Ina = (TextView) inflate.findViewById(R.id.ga_);
        this.Inb = (ImageView) inflate.findViewById(R.id.ga9);
        AppMethodBeat.o(71492);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(71493);
        if (!Util.isNullOrNil(charSequence)) {
            this.ImZ.setText(charSequence);
        } else {
            this.ImZ.setVisibility(8);
        }
        if (!Util.isNullOrNil(charSequence2)) {
            this.Ina.setMaxLines(2);
            this.Ina.setSelected(true);
            this.Ina.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.Ina.setText(charSequence2);
            this.Ina.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(71493);
            return;
        }
        this.Ina.setVisibility(8);
        AppMethodBeat.o(71493);
    }
}
