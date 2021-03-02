package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;

public class TipSayingWidget extends LinearLayout {
    private Context context;
    private String gna;
    private TextView gyt;
    private ImageView yJS;
    private Chronometer yJT;
    private int yJU = 0;

    public TipSayingWidget(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(55954);
        this.context = context2;
        View inflate = View.inflate(this.context, R.layout.c3c, this);
        this.yJS = (ImageView) inflate.findViewById(R.id.h_p);
        this.gyt = (TextView) inflate.findViewById(R.id.h_r);
        this.yJT = (Chronometer) findViewById(R.id.b2u);
        AppMethodBeat.o(55954);
    }

    public void setCurSaying(String str) {
        AppMethodBeat.i(55955);
        if (Util.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.o(55955);
            return;
        }
        setVisibility(0);
        a.b.A(this.yJS, str);
        if (Util.isNullOrNil(this.gna)) {
            this.gna = z.aTY();
        }
        if (this.gna.equals(str)) {
            this.gyt.setText(this.context.getString(R.string.hrg, str));
            this.yJT.setVisibility(0);
            AppMethodBeat.o(55955);
            return;
        }
        this.gyt.setText(this.context.getString(R.string.hrg, str));
        this.yJT.setVisibility(8);
        AppMethodBeat.o(55955);
    }
}
