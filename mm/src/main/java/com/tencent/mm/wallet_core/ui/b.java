package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public final class b {
    public static d a(Context context, int i2, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(72941);
        d a2 = h.a(context, str, str2, ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null), onClickListener);
        AppMethodBeat.o(72941);
        return a2;
    }
}
