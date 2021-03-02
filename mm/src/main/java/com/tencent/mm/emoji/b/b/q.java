package com.tencent.mm.emoji.b.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0014R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"})
public final class q {
    private static final SparseArray<p> gYI = new SparseArray<>();
    private static final HashMap<String, o> gYJ = new HashMap<>();
    public static final q gYK = new q();

    static {
        AppMethodBeat.i(199922);
        AppMethodBeat.o(199922);
    }

    private q() {
    }

    public static void a(p pVar) {
        AppMethodBeat.i(199917);
        p.h(pVar, "externalPanelViewProvider");
        gYI.put(pVar.lU(), pVar);
        AppMethodBeat.o(199917);
    }

    public static void pj(int i2) {
        AppMethodBeat.i(199918);
        gYI.remove(i2);
        AppMethodBeat.o(199918);
    }

    public static p pk(int i2) {
        AppMethodBeat.i(199919);
        p pVar = gYI.get(i2);
        AppMethodBeat.o(199919);
        return pVar;
    }

    public static void a(o oVar) {
        AppMethodBeat.i(199920);
        p.h(oVar, "panelGroup");
        gYJ.put(oVar.avy(), oVar);
        AppMethodBeat.o(199920);
    }

    public static o ES(String str) {
        AppMethodBeat.i(199921);
        p.h(str, "groupId");
        o oVar = gYJ.get(str);
        AppMethodBeat.o(199921);
        return oVar;
    }
}
