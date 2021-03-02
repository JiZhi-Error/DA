package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public final class g {
    public a JIl;
    public View mParentView;
    public PopupWindow qQv;

    public interface a {
        void cCL();

        void cCM();

        void cCN();

        void cCO();
    }

    public g(Context context, View view) {
        AppMethodBeat.i(30472);
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.layout.cca, (ViewGroup) null);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.qQv = new PopupWindow(inflate, -2, -2, false);
        this.qQv.setClippingEnabled(false);
        inflate.findViewById(R.id.jn5).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.g.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30468);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.qQv.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.JIl != null) {
                    g.this.JIl.cCL();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30468);
            }
        });
        inflate.findViewById(R.id.jn2).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.g.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(30469);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.qQv.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.JIl != null) {
                    g.this.JIl.cCM();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30469);
            }
        });
        inflate.findViewById(R.id.jn4).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.g.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(30470);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.qQv.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.JIl != null) {
                    g.this.JIl.cCN();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30470);
            }
        });
        inflate.findViewById(R.id.jnc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.g.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(30471);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.qQv.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.JIl != null) {
                    g.this.JIl.cCO();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30471);
            }
        });
        AppMethodBeat.o(30472);
    }
}
