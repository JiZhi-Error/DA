package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah {
    private static ah PjW;
    Object PjV;

    public interface b {
        boolean g(View view, MotionEvent motionEvent);
    }

    public static synchronized ah gOj() {
        ah ahVar;
        synchronized (ah.class) {
            AppMethodBeat.i(34839);
            if (PjW == null) {
                PjW = new ah();
            }
            ahVar = PjW;
            AppMethodBeat.o(34839);
        }
        return ahVar;
    }

    @TargetApi(14)
    public static class a implements View.OnHoverListener {
        private b PjX;

        public a(b bVar) {
            this.PjX = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(34838);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, bVar.axR());
            if (this.PjX != null) {
                boolean g2 = this.PjX.g(view, motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(g2, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(34838);
                return g2;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(34838);
            return false;
        }
    }
}
