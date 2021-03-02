package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.a.g;

public final class k extends g {
    private Button gxv = ((Button) this.lJI.findViewById(R.id.fz0));
    private TextView kuu = ((TextView) this.lJI.findViewById(R.id.ip7));
    private TextView titleTv = ((TextView) this.lJI.findViewById(R.id.ipd));

    public k(Context context) {
        super(context);
        AppMethodBeat.i(205229);
        apf(R.layout.au1);
        AppMethodBeat.o(205229);
    }

    public final k bmc(String str) {
        AppMethodBeat.i(205230);
        this.titleTv.setText(str);
        AppMethodBeat.o(205230);
        return this;
    }

    public final k bmd(String str) {
        AppMethodBeat.i(205231);
        this.kuu.setText(str);
        AppMethodBeat.o(205231);
        return this;
    }

    public final k g(View.OnClickListener onClickListener) {
        AppMethodBeat.i(205232);
        this.gxv.setOnClickListener(onClickListener);
        AppMethodBeat.o(205232);
        return this;
    }
}
