package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import java.util.HashMap;

public final class b extends FrameLayout {
    private View GQ = LayoutInflater.from(getContext()).inflate(R.layout.ars, (ViewGroup) this, false);
    private int gwE;
    private int xXT;
    private boolean xXU;
    e xYl;

    public b(Context context, int i2, boolean z) {
        super(context);
        AppMethodBeat.i(204317);
        this.gwE = i2;
        this.xXU = z;
        if (((f) g.af(f.class)).dSK().Oo(2) == 0 || !this.xXU) {
            addView(this.GQ);
            AppMethodBeat.o(204317);
            return;
        }
        this.xYl = new e(getContext(), this.gwE);
        this.xYl.setEmptyCallback(new c() {
            /* class com.tencent.mm.plugin.game.ui.message.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.ui.message.c
            public final void dWH() {
                AppMethodBeat.i(204316);
                b.this.refreshView();
                AppMethodBeat.o(204316);
            }
        });
        addView(this.xYl, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(204317);
    }

    public final void setNewMessageCount(int i2) {
        this.xXT = i2;
    }

    public final void resume() {
        AppMethodBeat.i(184807);
        HashMap hashMap = new HashMap();
        hashMap.put("tab", "2");
        hashMap.put("newnotice", String.valueOf(this.xXT));
        com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.gwE, com.tencent.mm.game.report.f.t(hashMap));
        this.xXT = 0;
        AppMethodBeat.o(184807);
    }

    public final void refreshView() {
        AppMethodBeat.i(204318);
        if (((f) g.af(f.class)).dSK().Oo(2) == 0) {
            if (this.xYl != null && indexOfChild(this.xYl) >= 0) {
                removeView(this.xYl);
            }
            if (this.GQ != null && indexOfChild(this.GQ) < 0) {
                addView(this.GQ);
            }
        }
        AppMethodBeat.o(204318);
    }
}
