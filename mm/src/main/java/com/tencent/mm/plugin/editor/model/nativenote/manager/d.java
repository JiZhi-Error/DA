package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public final class d {
    public View mParentView;
    public PopupWindow qQv;
    public a qQw;

    public interface a {
        void cCL();

        void cCM();

        void cCN();

        void cCO();
    }

    public d(Context context, View view) {
        AppMethodBeat.i(181765);
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.layout.a0y, (ViewGroup) null);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.qQv = new PopupWindow(inflate, -2, -2, false);
        this.qQv.setClippingEnabled(false);
        inflate.findViewById(R.id.jn5).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(181761);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qQv.dismiss();
                d.this.mParentView.setVisibility(8);
                if (d.this.qQw != null) {
                    d.this.qQw.cCL();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181761);
            }
        });
        inflate.findViewById(R.id.jn2).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(181762);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qQv.dismiss();
                d.this.mParentView.setVisibility(8);
                if (d.this.qQw != null) {
                    d.this.qQw.cCM();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181762);
            }
        });
        inflate.findViewById(R.id.jn4).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.d.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(181763);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qQv.dismiss();
                d.this.mParentView.setVisibility(8);
                if (d.this.qQw != null) {
                    d.this.qQw.cCN();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181763);
            }
        });
        inflate.findViewById(R.id.jnc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.d.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(181764);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.this.qQv.dismiss();
                d.this.mParentView.setVisibility(8);
                if (d.this.qQw != null) {
                    d.this.qQw.cCO();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181764);
            }
        });
        AppMethodBeat.o(181765);
    }
}
