package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;

public final class n {
    private static final int ujn = d.e(MMApplicationContext.getContext(), 18.0f);
    private static final int ujo = d.e(MMApplicationContext.getContext(), 12.0f);
    private static final float ujp;
    private static final float ujq = ujq;
    public static final a ujr = new a((byte) 0);
    int bgColor;
    int kcc;
    final float radius;
    CharSequence text;
    final int textColor;
    final int textSize;
    final float ujl;
    final float ujm;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ n(CharSequence charSequence, float f2, float f3, int i2, int i3, int i4, int i5) {
        this(charSequence, f2, f3, i2, i3, i4, i5, ujq);
        AppMethodBeat.i(246183);
        AppMethodBeat.o(246183);
    }

    private n(CharSequence charSequence, float f2, float f3, int i2, int i3, int i4, int i5, float f4) {
        p.h(charSequence, "text");
        AppMethodBeat.i(246182);
        this.text = charSequence;
        this.ujl = f2;
        this.ujm = f3;
        this.bgColor = i2;
        this.kcc = i3;
        this.textColor = i4;
        this.textSize = i5;
        this.radius = f4;
        AppMethodBeat.o(246182);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(260473);
        p.h(charSequence, "<set-?>");
        this.text = charSequence;
        AppMethodBeat.o(260473);
    }

    static {
        AppMethodBeat.i(246184);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        ujp = context.getResources().getDimension(R.dimen.bt);
        AppMethodBeat.o(246184);
    }
}
