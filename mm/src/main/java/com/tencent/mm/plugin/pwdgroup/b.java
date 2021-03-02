package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.pluginsdk.ui.j;

public final class b extends j implements e.a {
    /* synthetic */ b(String str, byte b2) {
        this(str);
    }

    @Override // com.tencent.mm.aj.e.a, com.tencent.mm.pluginsdk.ui.j
    public final void Mr(String str) {
        AppMethodBeat.i(27614);
        super.Mr(str);
        AppMethodBeat.o(27614);
    }

    public static class a {
        static j.a Boe;

        public static void c(ImageView imageView, String str) {
            b bVar;
            AppMethodBeat.i(27613);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str, (byte) 0);
            } else {
                bVar = (b) drawable;
            }
            bVar.setTag(str);
            imageView.setImageDrawable(bVar);
            AppMethodBeat.o(27613);
        }
    }

    private b(String str) {
        super(a.Boe, str);
    }
}
