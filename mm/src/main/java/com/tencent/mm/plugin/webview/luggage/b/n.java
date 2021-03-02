package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class n {
    protected List<o> IXa = new LinkedList();
    protected Map<Integer, a> xxy = new HashMap();

    public n() {
        AppMethodBeat.i(78709);
        dTx();
        dTy();
        AppMethodBeat.o(78709);
    }

    /* access modifiers changed from: protected */
    public void dTx() {
        AppMethodBeat.i(78710);
        a(new h());
        a(new l());
        a(new m());
        a(new i());
        a(new f());
        a(new d());
        a(new c());
        a(new e());
        a(new g());
        a(new j());
        a(new k());
        a(new b());
        AppMethodBeat.o(78710);
    }

    private void a(a aVar) {
        AppMethodBeat.i(78711);
        this.xxy.put(Integer.valueOf(aVar.id), aVar);
        AppMethodBeat.o(78711);
    }

    /* access modifiers changed from: protected */
    public void dTy() {
        AppMethodBeat.i(78712);
        this.IXa.clear();
        j(35, "menuItem:minimize", true);
        i(1, "menuItem:share:appMessage", false);
        i(2, "menuItem:share:timeline", false);
        FavUrlTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        AppBrandMainProcessService.b(favUrlTask);
        if (favUrlTask.ISM) {
            i(3, "menuItem:favorite", false);
            j(12, "menuItem:editTag", false);
            j(9, "menuItem:favorite", false);
        }
        j(31, "menuItem:search", true);
        j(6, "menuItem:copyUrl", false);
        i(7, "menuItem:openWithSafari", false);
        i(27, "menuItem:finish", true);
        j(28, "menuItem:refresh", true);
        j(29, "menuItem:addShortcut", false);
        AppMethodBeat.o(78712);
    }

    private void i(int i2, String str, boolean z) {
        AppMethodBeat.i(78713);
        this.IXa.add(new o(i2, str, z, false));
        AppMethodBeat.o(78713);
    }

    private void j(int i2, String str, boolean z) {
        AppMethodBeat.i(78714);
        this.IXa.add(new o(i2, str, z, true));
        AppMethodBeat.o(78714);
    }

    public final void b(Context context, g gVar, m mVar) {
        a aVar;
        AppMethodBeat.i(78715);
        for (o oVar : this.IXa) {
            if (!oVar.oBV && !oVar.IXc && (aVar = this.xxy.get(Integer.valueOf(oVar.id))) != null) {
                aVar.a(context, gVar, mVar);
            }
        }
        AppMethodBeat.o(78715);
    }

    public final void c(Context context, g gVar, m mVar) {
        a aVar;
        AppMethodBeat.i(78716);
        for (o oVar : this.IXa) {
            if (!oVar.oBV && oVar.IXc && (aVar = this.xxy.get(Integer.valueOf(oVar.id))) != null) {
                aVar.a(context, gVar, mVar);
            }
        }
        AppMethodBeat.o(78716);
    }

    public final void a(Context context, g gVar, MenuItem menuItem) {
        o oVar;
        AppMethodBeat.i(78717);
        if (menuItem == null) {
            AppMethodBeat.o(78717);
            return;
        }
        int itemId = menuItem.getItemId();
        Iterator<o> it = this.IXa.iterator();
        while (true) {
            if (!it.hasNext()) {
                oVar = null;
                break;
            }
            oVar = it.next();
            if (oVar != null && oVar.id == itemId) {
                break;
            }
        }
        a aVar = this.xxy.get(Integer.valueOf(oVar.id));
        if (aVar == null) {
            AppMethodBeat.o(78717);
            return;
        }
        aVar.a(context, gVar);
        AppMethodBeat.o(78717);
    }

    public final void gbX() {
        AppMethodBeat.i(78718);
        for (o oVar : this.IXa) {
            if (!oVar.IXb) {
                oVar.oBV = true;
            }
        }
        AppMethodBeat.o(78718);
    }

    public final void gbY() {
        AppMethodBeat.i(78719);
        for (o oVar : this.IXa) {
            if (!oVar.IXb) {
                oVar.oBV = false;
            }
        }
        AppMethodBeat.o(78719);
    }

    public final void aYA(String str) {
        AppMethodBeat.i(78720);
        Iterator<o> it = this.IXa.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            o next = it.next();
            if (next.name.equals(str)) {
                if (!next.IXb) {
                    next.oBV = true;
                    AppMethodBeat.o(78720);
                    return;
                }
            }
        }
        AppMethodBeat.o(78720);
    }

    public final void aYB(String str) {
        AppMethodBeat.i(78721);
        for (o oVar : this.IXa) {
            if (oVar.name.equals(str)) {
                oVar.oBV = false;
                AppMethodBeat.o(78721);
                return;
            }
        }
        AppMethodBeat.o(78721);
    }
}
