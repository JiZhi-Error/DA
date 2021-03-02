package com.tencent.mm.plugin.appbrand.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.j;

public final class l {
    public static ProgressDialog b(Context context, CharSequence charSequence) {
        AppMethodBeat.i(147713);
        j b2 = j.b(context, charSequence, true);
        AppMethodBeat.o(147713);
        return b2;
    }

    public static d b(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(147715);
        d hbn = new d.a(context).bon(str).bou(str2).c(onClickListener).hbn();
        hbn.show();
        AppMethodBeat.o(147715);
        return hbn;
    }

    public static d a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(147716);
        d hbn = new d.a(context).bon(str2).boo(str).bou(str3).c(onClickListener).bov(str4).d(onClickListener2).hbn();
        hbn.show();
        AppMethodBeat.o(147716);
        return hbn;
    }

    public static d c(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(147717);
        d hbn = new d.a(context).bon(str2).boo(str).aoV(R.string.ets).c(onClickListener).Dk(false).hbn();
        hbn.show();
        AppMethodBeat.o(147717);
        return hbn;
    }
}
