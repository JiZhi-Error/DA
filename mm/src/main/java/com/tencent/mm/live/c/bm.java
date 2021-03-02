package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/plugin/ShareRoomsLoader;", "", "()V", "load", "", "UIcallback", "Lkotlin/Function1;", "", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "plugin-logic_release"})
public final class bm {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ b hTG;

        a(b bVar) {
            this.hTG = bVar;
        }

        public final void run() {
            AppMethodBeat.i(208286);
            Cursor b2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().b(ab.iCM, null, com.tencent.mm.o.a.gNj, true, "");
            final ArrayList arrayList = new ArrayList();
            while (b2.moveToNext()) {
                String string = b2.getString(b2.getColumnIndex(ch.COL_USERNAME));
                int Ie = v.Ie(string);
                p.g(string, "name");
                arrayList.add(new h(string, Ie));
            }
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.c.bm.a.AnonymousClass1 */
                final /* synthetic */ a hTH;

                {
                    this.hTH = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* bridge */ /* synthetic */ x invoke() {
                    AppMethodBeat.i(208285);
                    this.hTH.hTG.invoke(arrayList);
                    x xVar = x.SXb;
                    AppMethodBeat.o(208285);
                    return xVar;
                }
            });
            AppMethodBeat.o(208286);
        }
    }
}
