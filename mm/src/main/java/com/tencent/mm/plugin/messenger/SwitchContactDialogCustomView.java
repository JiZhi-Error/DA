package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;

public class SwitchContactDialogCustomView extends LinearLayout {
    private TextView Xy;
    private TextView zpj;
    private ImageView zpk;
    private TextView zpl;
    private TextView zpm;

    public SwitchContactDialogCustomView(Context context) {
        this(context, null);
    }

    public SwitchContactDialogCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(90742);
        LayoutInflater.from(context).inflate(R.layout.cn, this);
        this.Xy = (TextView) findViewById(R.id.ipm);
        this.zpj = (TextView) findViewById(R.id.be9);
        this.zpk = (ImageView) findViewById(R.id.gb4);
        this.zpl = (TextView) findViewById(R.id.bmr);
        this.zpm = (TextView) findViewById(R.id.icz);
        AppMethodBeat.o(90742);
    }

    public void setTilte(String str) {
        AppMethodBeat.i(90743);
        this.Xy.setText(str);
        AppMethodBeat.o(90743);
    }

    public void setContent(String str) {
        AppMethodBeat.i(90744);
        this.zpj.setText(str);
        AppMethodBeat.o(90744);
    }

    public void setDesc(String str) {
        AppMethodBeat.i(90745);
        this.zpl.setText(str);
        AppMethodBeat.o(90745);
    }

    public void setSubDesc(String str) {
        AppMethodBeat.i(90746);
        this.zpm.setText(str);
        AppMethodBeat.o(90746);
    }

    public void setPhoto(String str) {
        AppMethodBeat.i(90747);
        a.b.c(this.zpk, str);
        AppMethodBeat.o(90747);
    }

    public void setOnPhotoOnClick(View.OnClickListener onClickListener) {
        AppMethodBeat.i(90748);
        if (this.zpk != null) {
            this.zpk.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(90748);
    }
}
