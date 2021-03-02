package com.tencent.mm.pluginsdk.ui.span;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.ui.ao;

public class q extends p {
    private a KrB;
    private Object tag;

    public interface a {
        void b(View view, Object obj);
    }

    public q() {
    }

    public q(Object obj, a aVar) {
        super(2, (u) null);
        this.KrB = aVar;
        this.tag = obj;
    }

    public q(Object obj, a aVar, int i2) {
        super(2, (u) null);
        AppMethodBeat.i(100607);
        this.KrB = aVar;
        this.tag = obj;
        setColorConfig(i2);
        AppMethodBeat.o(100607);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public void onClick(View view) {
        AppMethodBeat.i(100608);
        if (this.KrB != null) {
            this.KrB.b(view, this.tag);
        }
        AppMethodBeat.o(100608);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(100609);
        super.updateDrawState(textPaint);
        ao.a(textPaint, 0.8f);
        AppMethodBeat.o(100609);
    }
}
