package com.tencent.mm.plugin.gallery.model;

import android.support.v4.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J6\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/model/LinearPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"})
public final class l implements j {
    public static final a xjg = new a((byte) 0);

    static {
        AppMethodBeat.i(111789);
        AppMethodBeat.o(111789);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gallery/model/LinearPreload$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gallery.model.j
    public final Set<Integer> a(p.c cVar, p.c cVar2, int i2, int i3, int i4) {
        int i5 = 0;
        AppMethodBeat.i(111788);
        kotlin.g.b.p.h(cVar, "state");
        kotlin.g.b.p.h(cVar2, "lastState");
        b bVar = new b();
        if (i2 != -1 && i3 != -1 && i2 < i3 && p.c.IDLE == cVar) {
            Log.d("MicroMsg.LinearPreload", "start LinearPreload!!!");
            switch (m.$EnumSwitchMapping$0[cVar2.ordinal()]) {
                case 1:
                    int i6 = (i2 - 1) + 0;
                    while (i5 > -32 && i6 >= 0) {
                        bVar.add(Integer.valueOf(i6));
                        i5--;
                        i6 = (i2 - 1) + i5;
                    }
                    break;
                case 2:
                case 3:
                    int i7 = i3 + 1 + 0;
                    while (i5 < 32 && i7 < i4) {
                        bVar.add(Integer.valueOf(i7));
                        i5++;
                        i7 = i3 + 1 + i5;
                    }
                    break;
            }
        }
        b bVar2 = bVar;
        AppMethodBeat.o(111788);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.gallery.model.j
    public final boolean dRm() {
        return true;
    }
}
