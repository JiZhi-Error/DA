package com.tencent.mm.plugin.sns.ad.landingpage.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.q;

public final class a extends q {
    private a(Context context) {
        super(context, R.style.a66, 0);
        AppMethodBeat.i(202001);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8);
            window.getDecorView().setSystemUiVisibility(4102);
        }
        AppMethodBeat.o(202001);
    }

    public static q ap(Context context, int i2) {
        AppMethodBeat.i(202002);
        if (context instanceof Activity) {
            String str = "";
            if (i2 > 0) {
                str = context.getString(i2);
            }
            a aVar = new a(context);
            if (!TextUtils.isEmpty(str)) {
                aVar.setMessage(str);
            }
            aVar.setCancelable(true);
            aVar.setOnCancelListener(null);
            aVar.setCanceledOnTouchOutside(false);
            AppMethodBeat.o(202002);
            return aVar;
        }
        AppMethodBeat.o(202002);
        return null;
    }
}
