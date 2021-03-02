package com.tencent.mm.live.c;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q extends a {
    final b hOp;
    final EditText vy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207990);
        this.hOp = bVar;
        this.vy = (EditText) viewGroup.findViewById(R.id.h82);
        EditText editText = this.vy;
        x xVar = x.hJf;
        civ aGr = x.aGr();
        editText.setText(String.valueOf((aGr != null ? Long.valueOf(aGr.hyH) : null).longValue()));
        ((Button) viewGroup.findViewById(R.id.egw)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.q.AnonymousClass1 */
            final /* synthetic */ q hPU;

            {
                this.hPU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207989);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EditText editText = this.hPU.vy;
                p.g(editText, "editText");
                Editable text = editText.getText();
                if (!Util.isNullOrNil(text)) {
                    x xVar = x.hJf;
                    civ aGr = x.aGr();
                    if (aGr != null) {
                        aGr.hyH = Long.parseLong(text.toString());
                    }
                }
                viewGroup.setVisibility(8);
                b.C0376b.a(this.hPU.hOp, b.c.hLX);
                a.a(this, "com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207989);
            }
        });
        AppMethodBeat.o(207990);
    }
}
