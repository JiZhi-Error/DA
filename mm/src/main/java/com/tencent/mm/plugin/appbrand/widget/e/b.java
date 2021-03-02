package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends LinearLayout {
    public static final int oyv = Color.parseColor("#000000");
    public static final int oyw = Color.parseColor("#000000");
    private TextView hbb;

    static {
        AppMethodBeat.i(146580);
        AppMethodBeat.o(146580);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(146572);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        this.hbb = new TextView(context);
        this.hbb.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.hbb);
        AppMethodBeat.o(146572);
    }

    public final void setText(String str) {
        AppMethodBeat.i(146573);
        this.hbb.setText(str);
        AppMethodBeat.o(146573);
    }

    public final void setTextSize(int i2) {
        AppMethodBeat.i(146574);
        this.hbb.setTextSize((float) i2);
        AppMethodBeat.o(146574);
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(146575);
        this.hbb.setTextColor(i2);
        AppMethodBeat.o(146575);
    }

    public final void setTitlePadding(int i2) {
        AppMethodBeat.i(146576);
        this.hbb.setPadding(i2, i2, i2, i2);
        AppMethodBeat.o(146576);
    }

    public final void setGravity(String str) {
        AppMethodBeat.i(146577);
        if (str.equals("left")) {
            this.hbb.setGravity(3);
            AppMethodBeat.o(146577);
        } else if (str.equals("right")) {
            this.hbb.setGravity(5);
            AppMethodBeat.o(146577);
        } else {
            str.equals("center");
            this.hbb.setGravity(17);
            AppMethodBeat.o(146577);
        }
    }

    public final void A(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(146578);
        Aq(i3);
        a aVar = new a();
        aVar.borderRadius = (float) i2;
        aVar.setColor(i5);
        aVar.setStroke(i3, i4);
        setBackgroundDrawable(aVar);
        AppMethodBeat.o(146578);
    }

    private void Aq(int i2) {
        AppMethodBeat.i(146579);
        setPadding(i2, i2, i2, i2);
        AppMethodBeat.o(146579);
    }
}
