package com.tencent.mm.plugin.game.ui.message;

import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;

public final class f implements View.OnClickListener, View.OnLongClickListener {
    private int gwE;
    private b xYF;

    public interface b {
        void dWI();
    }

    public static class a {
        public boolean isNew;
        public int xHK;
        public o xYJ;
        public o.g xYK;

        public a(o oVar, o.g gVar, int i2) {
            AppMethodBeat.i(184812);
            this.xYJ = oVar;
            this.xYK = gVar;
            this.xHK = i2;
            this.isNew = !oVar.field_isRead;
            AppMethodBeat.o(184812);
        }
    }

    public f(int i2, b bVar) {
        this.gwE = i2;
        this.xYF = bVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(183902);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(183902);
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.xYJ == null || aVar.xYK == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(183902);
            return;
        }
        int a2 = p.a(view.getContext(), aVar.xYJ, aVar.xYK, aVar.xYJ.field_appId, this.gwE);
        HashMap hashMap = new HashMap();
        hashMap.put("tab", "2");
        hashMap.put("isnew", aVar.isNew ? "1" : "2");
        hashMap.put("fold", String.valueOf(aVar.xYJ.field_hasMergedCount));
        hashMap.put("ext_data", aVar.xYJ.xFX);
        com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 13, 1301, aVar.xHK, a2, 0, aVar.xYJ.field_appId, this.gwE, aVar.xYJ.xFV, aVar.xYJ.field_gameMsgId, aVar.xYJ.xFW, com.tencent.mm.game.report.f.t(hashMap));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183902);
    }

    public final boolean onLongClick(final View view) {
        AppMethodBeat.i(183903);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        if (!(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(183903);
            return false;
        }
        final a aVar = (a) view.getTag();
        if (aVar.xYJ == null) {
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(183903);
            return false;
        }
        com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(view.getContext(), view);
        aVar2.QSs = new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.game.ui.message.f.AnonymousClass1 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(183900);
                if (!Util.isNullOrNil(aVar.xYJ.xFQ.xGN)) {
                    if (c.aAN(aVar.xYJ.xFQ.xGN)) {
                        contextMenu.add(0, 13, 0, R.string.drr);
                    } else {
                        contextMenu.add(0, 12, 0, R.string.drt);
                    }
                }
                contextMenu.add(0, 11, 0, R.string.do2);
                AppMethodBeat.o(183900);
            }
        };
        aVar2.HLY = new o.g() {
            /* class com.tencent.mm.plugin.game.ui.message.f.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(183901);
                if (menuItem.getItemId() == 11) {
                    ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().delete(aVar.xYJ, new String[0]);
                    if (f.this.xYF != null) {
                        f.this.xYF.dWI();
                        AppMethodBeat.o(183901);
                        return;
                    }
                } else if (menuItem.getItemId() == 12) {
                    f.a aVar = new f.a(MMApplicationContext.getContext());
                    aVar.bow(MMApplicationContext.getResources().getString(R.string.drs)).apa(R.string.drt).Dq(true);
                    aVar.c(new f.c() {
                        /* class com.tencent.mm.plugin.game.ui.message.f.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(204323);
                            if (z) {
                                c.bJ(aVar.xYJ.xFQ.xGN, true);
                            }
                            AppMethodBeat.o(204323);
                        }
                    }).b(new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.game.ui.message.f.AnonymousClass2.AnonymousClass1 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                        }
                    }).show();
                    AppMethodBeat.o(183901);
                    return;
                } else if (menuItem.getItemId() == 13) {
                    c.bJ(aVar.xYJ.xFQ.xGN, false);
                    u.cG(view.getContext(), MMApplicationContext.getResources().getString(R.string.dsf));
                }
                AppMethodBeat.o(183901);
            }
        };
        aVar2.ez(0, 0);
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/game/ui/message/OnMsgClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(183903);
        return true;
    }
}
