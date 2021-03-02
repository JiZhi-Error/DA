package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s {
    private final View.OnTouchListener KfV = new View.OnTouchListener() {
        /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    boolean Kfn;
    r Kfo;
    a Kfu;
    int Kga;
    b Kgb;
    private int background = -1;
    boolean gue;
    int index;
    View.OnClickListener ko = new View.OnClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.applet.s.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(152230);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListRow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListRow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(152230);
        }
    };
    View lJI;
    int row;

    public interface a {
        void m(ViewGroup viewGroup, int i2);
    }

    public interface b {
        boolean oi(int i2);
    }

    public s() {
        AppMethodBeat.i(152233);
        AppMethodBeat.o(152233);
    }
}
