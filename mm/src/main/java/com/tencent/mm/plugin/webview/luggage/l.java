package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public final class l extends k {
    public View IUe;
    public View IUf;
    private TextView IUg = ((TextView) this.IUf.findViewById(R.id.js2));

    public l(Context context, View view) {
        super(context);
        AppMethodBeat.i(78371);
        this.IUe = view;
        this.IUf = LayoutInflater.from(context).inflate(R.layout.cbt, (ViewGroup) this, false);
        this.IUf.setVisibility(0);
        this.IUf.setBackgroundResource(R.color.afj);
        l(this.IUf, view);
        AppMethodBeat.o(78371);
    }

    public final void setCurrentUrl(String str) {
        AppMethodBeat.i(78372);
        if (!Util.isNullOrNil(str)) {
            String host = Uri.parse(str).getHost();
            if (!Util.isNullOrNil(host)) {
                String string = getContext().getString(R.string.izp, host);
                this.IUg.setVisibility(0);
                this.IUg.setText(string);
                AppMethodBeat.o(78372);
                return;
            }
        }
        this.IUg.setVisibility(8);
        AppMethodBeat.o(78372);
    }

    public final void setX5LogoViewVisibility(int i2) {
        AppMethodBeat.i(78373);
        this.IUf.setVisibility(i2);
        AppMethodBeat.o(78373);
    }

    public final void setBgColor(int i2) {
        AppMethodBeat.i(78374);
        ((ViewGroup) this.IUf.getParent()).setBackgroundColor(i2);
        AppMethodBeat.o(78374);
    }
}
