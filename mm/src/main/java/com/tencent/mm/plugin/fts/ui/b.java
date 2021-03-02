package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {

    /* renamed from: com.tencent.mm.plugin.fts.ui.b$b  reason: collision with other inner class name */
    public static final class C1383b {
        public static final int wZQ = MMApplicationContext.getContext().getResources().getColor(R.color.Brand_90);
        public static final int wZR = Color.parseColor("#661AAD19");
        public static final int wZS = Color.parseColor("#801AAD19");

        static {
            AppMethodBeat.i(111811);
            AppMethodBeat.o(111811);
        }
    }

    public static final class c {
        public static final int wZT = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.l);
        public static final TextPaint wZU = new TextPaint();
        public static final int wZV = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.is);
        public static final TextPaint wZW = new TextPaint();
        public static final int wZX = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.hc);
        public static final TextPaint wZY = new TextPaint();
        public static final int wZZ = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.ka);
        public static final TextPaint xaa = new TextPaint();

        static {
            AppMethodBeat.i(111812);
            wZU.setTextSize((float) wZT);
            wZW.setTextSize((float) wZV);
            wZY.setTextSize((float) wZX);
            xaa.setTextSize((float) wZZ);
            AppMethodBeat.o(111812);
        }
    }

    public static class a {
        public static int wZP;

        static {
            AppMethodBeat.i(111810);
            wZP = 0;
            Context context = MMApplicationContext.getContext();
            wZP = ((com.tencent.mm.cb.a.jn(context) - (com.tencent.mm.cb.a.aG(context, R.dimen.jn) * 2)) - com.tencent.mm.cb.a.aG(context, R.dimen.ij)) - com.tencent.mm.cb.a.aG(context, R.dimen.jn);
            AppMethodBeat.o(111810);
        }
    }
}
