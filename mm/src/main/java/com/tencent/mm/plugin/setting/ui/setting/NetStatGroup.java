package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NetStatGroup extends LinearLayout {
    LinearLayout CZd;
    final TextView CZe;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(73893);
        View.inflate(context, R.layout.bfm, this);
        this.CZd = (LinearLayout) findViewById(R.id.dl9);
        this.CZe = (TextView) findViewById(R.id.bki);
        this.CZe.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.hc));
        AppMethodBeat.o(73893);
    }
}
