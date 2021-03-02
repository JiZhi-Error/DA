package com.tencent.mm.plugin.shake.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i2, boolean z) {
        AppMethodBeat.i(28577);
        if (imageView == null) {
            AppMethodBeat.o(28577);
            return;
        }
        imageView.setImageBitmap(null);
        if (!Util.isNullOrNil(str)) {
            c.a aVar = new c.a();
            aVar.fullPath = m.ON(str);
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.iaT = z;
            if (i2 != 0) {
                aVar.jbt = i2;
            }
            q.bcV().a(str, imageView, aVar.bdv());
        }
        AppMethodBeat.o(28577);
    }

    public static String eVk() {
        AppMethodBeat.i(28578);
        List<f> eUe = m.eUn().eUe();
        StringBuilder sb = new StringBuilder();
        for (f fVar : eUe) {
            sb.append(fVar.field_reserved1);
            sb.append("|");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(28578);
        return sb2;
    }
}
