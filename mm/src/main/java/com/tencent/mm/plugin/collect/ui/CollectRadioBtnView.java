package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;

public class CollectRadioBtnView extends LinearLayout {
    private TextView mPa;
    private ImageView qCg;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64192);
        init(context);
        AppMethodBeat.o(64192);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(64193);
        init(context);
        AppMethodBeat.o(64193);
    }

    private void init(Context context) {
        AppMethodBeat.i(64194);
        View inflate = aa.jQ(context).inflate(R.layout.v3, this);
        this.qCg = (ImageView) inflate.findViewById(R.id.gqy);
        this.mPa = (TextView) inflate.findViewById(R.id.ir3);
        AppMethodBeat.o(64194);
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(64195);
        this.mPa.setText(str);
        AppMethodBeat.o(64195);
    }

    public void setRadioSrc(int i2) {
        AppMethodBeat.i(64196);
        this.qCg.setImageResource(i2);
        AppMethodBeat.o(64196);
    }
}
