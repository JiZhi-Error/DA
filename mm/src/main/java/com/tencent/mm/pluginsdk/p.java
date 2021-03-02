package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mm.kernel.c.a;

public interface p extends a {
    boolean a(Context context, String str, DialogInterface.OnDismissListener onDismissListener);

    boolean gw(String str);

    String v(Context context, String str);
}
