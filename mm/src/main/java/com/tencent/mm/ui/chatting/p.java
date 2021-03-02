package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public final class p {
    public long[] PgO = null;
    public a dom;

    public p(a aVar, long[] jArr) {
        AppMethodBeat.i(34486);
        this.dom = aVar;
        this.PgO = jArr;
        this.dom.Pwc.removeAllOptionMenu();
        this.dom.Pwc.addTextOptionMenu(2, this.dom.Pwc.getMMResources().getString(R.string.ahc), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.p.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34484);
                Intent intent = new Intent();
                Set<Long> gOs = ((k) p.this.dom.bh(k.class)).gOs();
                if (gOs != null) {
                    ArrayList<Long> arrayList = new ArrayList();
                    arrayList.addAll(gOs);
                    Collections.sort(arrayList);
                    long[] jArr = new long[arrayList.size()];
                    int i2 = 0;
                    for (Long l : arrayList) {
                        jArr[i2] = l.longValue();
                        i2++;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", jArr);
                    p.this.dom.Pwc.getContext().setResult(-1, intent);
                } else {
                    p.this.dom.Pwc.getContext().setResult(0, intent);
                }
                intent.putExtra("k_is_group_chat", p.this.dom.gRM());
                p.this.dom.Pwc.gNh();
                AppMethodBeat.o(34484);
                return false;
            }
        }, null, t.b.GREEN);
        final k kVar = (k) this.dom.bh(k.class);
        kVar.i(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.p.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(34485);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kVar.Nu(((Long) view.getTag()).longValue());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34485);
            }
        });
        AppMethodBeat.o(34486);
    }
}
