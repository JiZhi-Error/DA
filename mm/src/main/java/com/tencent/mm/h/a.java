package com.tencent.mm.h;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a {
    public String Title;
    public int dDG;
    public String desc;
    public c gpb;
    public String url;

    public static a Dk(String str) {
        AppMethodBeat.i(149961);
        c Dm = c.Dm(str);
        if (Dm != null) {
            a aVar = new a();
            aVar.gpb = Dm;
            aVar.url = Dm.url;
            aVar.desc = Dm.desc;
            aVar.dDG = Dm.dDG;
            aVar.Title = Dm.Title;
            AppMethodBeat.o(149961);
            return aVar;
        }
        AppMethodBeat.o(149961);
        return null;
    }

    public final boolean a(Context context, DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(149963);
        h.a(context, this.desc, this.Title, onDismissListener);
        AppMethodBeat.o(149963);
        return true;
    }

    public final boolean a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i2 = R.string.x_;
        AppMethodBeat.i(149962);
        if (this.dDG == 3 || this.dDG == 4) {
            String str = this.gpb.gpn;
            String str2 = this.gpb.gpo;
            if (Util.isNullOrNil(str) && Util.isNullOrNil(str2)) {
                if (this.dDG == 3) {
                    i2 = R.string.a0_;
                }
                str = context.getString(i2);
                str2 = context.getString(this.dDG == 3 ? R.string.x6 : R.string.sz);
            }
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                String str3 = this.desc;
                String str4 = this.Title;
                if (!Util.isNullOrNil(str)) {
                    str2 = str;
                }
                if (!Util.isNullOrNil(str)) {
                    onClickListener2 = onClickListener;
                }
                h.a(context, str3, str4, str2, onClickListener2);
            } else {
                h.c(context, this.desc, this.Title, str, str2, onClickListener, onClickListener2);
            }
            AppMethodBeat.o(149962);
            return true;
        } else if (this.dDG == 1) {
            h.a(context, this.desc, this.Title, context.getString(R.string.x_), true, onClickListener);
            AppMethodBeat.o(149962);
            return true;
        } else if (this.dDG == 5) {
            h.c(context, this.desc, this.Title, true);
            AppMethodBeat.o(149962);
            return true;
        } else {
            AppMethodBeat.o(149962);
            return false;
        }
    }
}
