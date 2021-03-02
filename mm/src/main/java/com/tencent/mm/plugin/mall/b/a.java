package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat qkZ = null;
    private static SimpleDateFormat qla = null;

    public static void ehv() {
        AppMethodBeat.i(66182);
        xk xkVar = new xk();
        xkVar.edE.edF = false;
        EventCenter.instance.publish(xkVar);
        AppMethodBeat.o(66182);
    }

    public static void t(ImageView imageView, String str) {
        AppMethodBeat.i(66183);
        d(imageView, str, 0);
        AppMethodBeat.o(66183);
    }

    public static void d(ImageView imageView, String str, int i2) {
        AppMethodBeat.i(66184);
        if (imageView == null) {
            AppMethodBeat.o(66184);
            return;
        }
        imageView.setImageBitmap(null);
        if (!Util.isNullOrNil(str)) {
            c.a aVar = new c.a();
            aVar.prefixPath = aDJ(str);
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.iaT = false;
            if (i2 != 0) {
                aVar.jbq = i2;
            }
            q.bcV().a(str, imageView, aVar.bdv());
            AppMethodBeat.o(66184);
            return;
        }
        if (i2 != 0) {
            imageView.setImageResource(i2);
        }
        AppMethodBeat.o(66184);
    }

    private static String aDJ(String str) {
        AppMethodBeat.i(66185);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(66185);
            return null;
        }
        String format = String.format("%s/%s", b.aKJ() + "wallet/mall", g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(66185);
        return format;
    }
}
