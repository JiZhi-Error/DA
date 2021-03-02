package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class aq extends a implements af {
    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35524);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(35524);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35525);
        final Intent intent = this.dom.Pwc.getContext().getIntent();
        if (intent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3) {
            AppMethodBeat.o(35525);
            return;
        }
        intent.setClass(this.dom.Pwc.getContext(), SendAppMessageWrapperUI.class);
        intent.putExtra("Select_Conv_User", this.dom.getTalkerUserName());
        this.dom.a(intent, 228, new c.a() {
            /* class com.tencent.mm.ui.chatting.d.aq.AnonymousClass1 */

            @Override // com.tencent.mm.br.c.a
            public final void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(35523);
                intent.removeExtra("SendAppMessageWrapper_Scene");
                if (i2 == 228) {
                    if (i3 != -1) {
                        ReportUtil.a(aq.this.dom.Pwc.getContext(), ReportUtil.d(intent.getExtras(), 0), true);
                        if (!aq.this.dom.Pwc.getContext().isFinishing()) {
                            aq.this.dom.Pwc.getContext().finish();
                        }
                    } else if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        ReportUtil.ab(false, 0);
                        AppMethodBeat.o(35523);
                        return;
                    } else if (!aq.this.dom.Pwc.getContext().isFinishing()) {
                        aq.this.dom.Pwc.getContext().finish();
                        AppMethodBeat.o(35523);
                        return;
                    }
                }
                AppMethodBeat.o(35523);
            }
        });
        AppMethodBeat.o(35525);
    }
}
