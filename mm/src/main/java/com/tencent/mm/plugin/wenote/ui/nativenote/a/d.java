package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    private TextView JJA = null;

    public d(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30854);
        this.JJA = (TextView) view.findViewById(R.id.g1_);
        this.JJA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30853);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteComplaintItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NoteEditorUI.gkh();
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteComplaintItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30853);
            }
        });
        AppMethodBeat.o(30854);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30855);
        Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lQ());
        AppMethodBeat.o(30855);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 30;
    }
}
