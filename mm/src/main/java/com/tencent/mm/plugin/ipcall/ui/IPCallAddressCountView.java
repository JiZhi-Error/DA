package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View jxm;
    private TextView yul;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25660);
        init();
        AppMethodBeat.o(25660);
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        AppMethodBeat.i(25661);
        init();
        AppMethodBeat.o(25661);
    }

    public IPCallAddressCountView(Context context, int i2) {
        this(context);
        AppMethodBeat.i(25662);
        setAddressCount(i2);
        AppMethodBeat.o(25662);
    }

    private void init() {
        AppMethodBeat.i(25663);
        inflate(getContext(), R.layout.awf, this);
        this.jxm = findViewById(R.id.ba6);
        this.yul = (TextView) findViewById(R.id.ba5);
        AppMethodBeat.o(25663);
    }

    public void setAddressCount(int i2) {
        AppMethodBeat.i(25664);
        this.yul.setText(getContext().getResources().getQuantityString(R.plurals.f3135b, i2, Integer.valueOf(i2)));
        AppMethodBeat.o(25664);
    }
}
