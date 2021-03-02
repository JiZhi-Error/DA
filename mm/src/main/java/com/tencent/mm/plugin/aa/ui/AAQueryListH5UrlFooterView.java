package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    private TextView jUR;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        AppMethodBeat.i(63499);
        init(context);
        AppMethodBeat.o(63499);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63500);
        init(context);
        AppMethodBeat.o(63500);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63501);
        init(context);
        AppMethodBeat.o(63501);
    }

    private void init(Context context) {
        AppMethodBeat.i(63502);
        this.jUR = (TextView) aa.jQ(context).inflate(R.layout.ac, (ViewGroup) this, true).findViewById(R.id.ak);
        ao.a(this.jUR.getPaint(), 0.8f);
        AppMethodBeat.o(63502);
    }

    public TextView getBottomLinkTv() {
        return this.jUR;
    }
}
