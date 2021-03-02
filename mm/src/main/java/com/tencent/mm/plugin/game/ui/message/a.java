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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.a.g;
import java.util.HashMap;

public final class a extends FrameLayout {
    private View GQ = LayoutInflater.from(getContext()).inflate(R.layout.ars, (ViewGroup) this, false);
    private int gwE;
    d xXS;
    private int xXT;
    private boolean xXU;

    public a(Context context, int i2, boolean z) {
        super(context);
        AppMethodBeat.i(204307);
        this.gwE = i2;
        this.xXU = z;
        if (((f) g.af(f.class)).dSK().Oo(1) == 0 || !this.xXU) {
            addView(this.GQ);
            AppMethodBeat.o(204307);
            return;
        }
        this.xXS = new d(getContext(), this.gwE);
        this.xXS.setEmptyCallback(new c() {
            /* class com.tencent.mm.plugin.game.ui.message.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.ui.message.c
            public final void dWH() {
                AppMethodBeat.i(204305);
                a.this.refreshView();
                AppMethodBeat.o(204305);
            }
        });
        addView(this.xXS, new FrameLayout.LayoutParams(-1, -1));
        int nullAsNil = Util.nullAsNil((Integer) g.aAh().azQ().get(ar.a.USERINFO_GAME_NOT_DISTURB_GUIDANCE_COUNT_INT, (Object) 0));
        if (nullAsNil <= 0) {
            g.aAh().azQ().set(ar.a.USERINFO_GAME_NOT_DISTURB_GUIDANCE_COUNT_INT, Integer.valueOf(nullAsNil + 1));
            final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 0, true);
            gVar.T(getResources().getString(R.string.dph));
            gVar.ape(1);
            gVar.QOT = new g.a() {
                /* class com.tencent.mm.plugin.game.ui.message.a.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(204306);
                    gVar.bMo();
                    AppMethodBeat.o(204306);
                }
            };
            gVar.setCustomView(LayoutInflater.from(getContext()).inflate(R.layout.art, (ViewGroup) null));
            gVar.dGm();
        }
        AppMethodBeat.o(204307);
    }

    public final void setNewMessageCount(int i2) {
        this.xXT = i2;
    }

    public final void resume() {
        AppMethodBeat.i(184806);
        HashMap hashMap = new HashMap();
        hashMap.put("tab", "1");
        hashMap.put("newmsg", String.valueOf(this.xXT));
        com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, this.gwE, com.tencent.mm.game.report.f.t(hashMap));
        this.xXT = 0;
        AppMethodBeat.o(184806);
    }

    public final void refreshView() {
        AppMethodBeat.i(204308);
        if (((f) com.tencent.mm.kernel.g.af(f.class)).dSK().Oo(1) == 0) {
            if (this.xXS != null && indexOfChild(this.xXS) >= 0) {
                removeView(this.xXS);
            }
            if (this.GQ != null && indexOfChild(this.GQ) < 0) {
                addView(this.GQ);
            }
        }
        AppMethodBeat.o(204308);
    }
}
