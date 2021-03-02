package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;

public final class a extends p {
    private AbstractC0509a jUr;

    /* renamed from: com.tencent.mm.plugin.aa.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC0509a {
        void bmr();
    }

    public a(AbstractC0509a aVar) {
        super(2, (u) null);
        this.jUr = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void onClick(View view) {
        AppMethodBeat.i(63470);
        if (this.jUr != null) {
            this.jUr.bmr();
        }
        AppMethodBeat.o(63470);
    }
}
