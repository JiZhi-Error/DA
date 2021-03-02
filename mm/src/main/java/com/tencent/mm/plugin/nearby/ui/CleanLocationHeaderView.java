package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private TextView AzH;
    private ImageView gBZ;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(89806);
        bh(context);
        AppMethodBeat.o(89806);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(89807);
        bh(context);
        AppMethodBeat.o(89807);
    }

    private void bh(Context context) {
        AppMethodBeat.i(89808);
        View inflate = View.inflate(context, R.layout.bey, this);
        this.AzH = (TextView) inflate.findViewById(R.id.fug);
        this.AzH.setSingleLine(false);
        this.gBZ = (ImageView) inflate.findViewById(R.id.ftz);
        this.AzH.setText(R.string.b4v);
        this.gBZ.setImageResource(R.raw.peoplenearby_icon);
        AppMethodBeat.o(89808);
    }
}
