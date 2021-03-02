package com.tencent.mm.sdcard_migrate.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class b {
    public static void a(Context context, Dialog dialog) {
        AppMethodBeat.i(204653);
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
            if ((context instanceof c) && (dialog instanceof c)) {
                ((c) dialog).iOnDialogDismissListener = (c) context;
            }
        }
        AppMethodBeat.o(204653);
    }

    public static c b(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(204654);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            c.a aVar = new c.a(context);
            aVar.bhS(null);
            aVar.bhT(str);
            aVar.gxl().a(onClickListener);
            aVar.AI(false);
            c gxm = aVar.gxm();
            gxm.show();
            a(context, gxm);
            AppMethodBeat.o(204654);
            return gxm;
        }
        AppMethodBeat.o(204654);
        return null;
    }

    public static c a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(204655);
        c b2 = b(context, str, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.o(204655);
        return b2;
    }

    private static c b(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(204656);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            c.a aVar = new c.a(context);
            aVar.bhS(null);
            aVar.bhT(str);
            aVar.bhU(str2).a(onClickListener);
            aVar.bhV(str3).b(onClickListener2);
            aVar.AI(false);
            c gxm = aVar.gxm();
            gxm.show();
            a(context, gxm);
            AppMethodBeat.o(204656);
            return gxm;
        }
        AppMethodBeat.o(204656);
        return null;
    }
}
