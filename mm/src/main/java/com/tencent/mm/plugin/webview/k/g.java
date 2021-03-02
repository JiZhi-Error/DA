package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

public final class g {
    public HashMap<String, a> JBy = new HashMap<>();

    public static class a {
        public int JBz;
        public int permission;
        public String title;
    }

    public g() {
        AppMethodBeat.i(82381);
        AppMethodBeat.o(82381);
    }

    public static void a(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(82382);
        d.a aVar = new d.a(context);
        aVar.Dk(false);
        aVar.aoR(3);
        aVar.bon(context.getString(R.string.izw));
        if (!Util.isNullOrNil(str)) {
            aVar.Di(true);
            aVar.aB(str);
        }
        aVar.Dj(true);
        aVar.bos(context.getString(R.string.izv));
        aVar.bou(context.getString(R.string.x_));
        aVar.aoX(context.getResources().getColor(R.color.x0));
        aVar.c(onClickListener);
        aVar.bov(context.getString(R.string.sz));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("key_webview_menu_haokan");
        if (mmkv.decodeBool("show_first_tips", true)) {
            mmkv.encode("show_first_tips", false);
            mmkv.apply();
            aVar.aA(context.getString(R.string.izu));
        }
        aVar.hbn().show();
        AppMethodBeat.o(82382);
    }

    public final a bbo(String str) {
        AppMethodBeat.i(82383);
        a aVar = this.JBy.get(str);
        AppMethodBeat.o(82383);
        return aVar;
    }
}
