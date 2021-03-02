package com.tencent.mm.plugin.finder.conv;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001cB\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "Companion", "plugin-finder_release"})
public final class h implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, d.b, o.g {
    public static final a tyM = new a((byte) 0);
    private c tyK;
    private kotlin.g.a.a<x> tyL;

    static {
        AppMethodBeat.i(242747);
        AppMethodBeat.o(242747);
    }

    public h(kotlin.g.a.a<x> aVar) {
        p.h(aVar, "callBack");
        AppMethodBeat.i(242746);
        this.tyL = aVar;
        AppMethodBeat.o(242746);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        String str;
        String str2 = null;
        AppMethodBeat.i(242743);
        p.h(contextMenu, "menu");
        p.h(view, "v");
        p.h(contextMenuInfo, "menuInfo");
        c cVar = this.tyK;
        if (cVar != null) {
            str = cVar.field_sessionId;
        } else {
            str = null;
        }
        if (!p.j(str, "findersayhisessionholder")) {
            c cVar2 = this.tyK;
            if (cVar2 != null) {
                str2 = cVar2.field_sessionId;
            }
            if (!p.j(str2, "finder_system_message")) {
                contextMenu.add(0, 2, 0, R.string.euz);
            }
        }
        AppMethodBeat.o(242743);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(242744);
        p.h(menuItem, "menuItem");
        c cVar = this.tyK;
        if (cVar != null) {
            switch (menuItem.getItemId()) {
                case 0:
                    e conversationStorage = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
                    String str = cVar.field_sessionId;
                    p.g(str, "focused.field_sessionId");
                    if (conversationStorage.avs(str)) {
                        kotlin.g.a.a<x> aVar = this.tyL;
                        if (aVar != null) {
                            aVar.invoke();
                            AppMethodBeat.o(242744);
                            return;
                        }
                        AppMethodBeat.o(242744);
                        return;
                    }
                    Log.e("Finder.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + cVar.field_sessionId);
                    AppMethodBeat.o(242744);
                    return;
                case 1:
                    e conversationStorage2 = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
                    String str2 = cVar.field_sessionId;
                    p.g(str2, "focused.field_sessionId");
                    if (conversationStorage2.bt(str2, true)) {
                        kotlin.g.a.a<x> aVar2 = this.tyL;
                        if (aVar2 != null) {
                            aVar2.invoke();
                            AppMethodBeat.o(242744);
                            return;
                        }
                        AppMethodBeat.o(242744);
                        return;
                    }
                    Log.e("Finder.ConversationOnLongClickListener", "setTopPlace failed. sessionId=" + cVar.field_sessionId);
                    AppMethodBeat.o(242744);
                    return;
                case 2:
                    ContextMenu.ContextMenuInfo menuInfo = menuItem.getMenuInfo();
                    if (menuInfo != null) {
                        bp.a(cVar.field_sessionId, new b(cVar, (AdapterView.AdapterContextMenuInfo) menuInfo, this, menuItem));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
                        AppMethodBeat.o(242744);
                        throw tVar;
                    }
                case 3:
                    e conversationStorage3 = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
                    String str3 = cVar.field_sessionId;
                    p.g(str3, "focused.field_sessionId");
                    if (conversationStorage3.bt(str3, false)) {
                        kotlin.g.a.a<x> aVar3 = this.tyL;
                        if (aVar3 != null) {
                            aVar3.invoke();
                            AppMethodBeat.o(242744);
                            return;
                        }
                        AppMethodBeat.o(242744);
                        return;
                    }
                    Log.e("Finder.ConversationOnLongClickListener", "setUnTopPlace failed. sessionId=" + cVar.field_sessionId);
                    AppMethodBeat.o(242744);
                    return;
            }
            AppMethodBeat.o(242744);
            return;
        }
        AppMethodBeat.o(242744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
    public static final class b implements bp.a {
        final /* synthetic */ c tyN;
        final /* synthetic */ AdapterView.AdapterContextMenuInfo tyO;
        final /* synthetic */ h tyP;
        final /* synthetic */ MenuItem tyQ;

        b(c cVar, AdapterView.AdapterContextMenuInfo adapterContextMenuInfo, h hVar, MenuItem menuItem) {
            this.tyN = cVar;
            this.tyO = adapterContextMenuInfo;
            this.tyP = hVar;
            this.tyQ = menuItem;
        }

        @Override // com.tencent.mm.model.bp.a
        public final boolean amG() {
            return false;
        }

        @Override // com.tencent.mm.model.bp.a
        public final void amH() {
            AppMethodBeat.i(242742);
            Log.i("Finder.ConversationOnLongClickListener", "longclick delete msg finish");
            boolean deleteNotify = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().deleteNotify(this.tyN.systemRowid, false);
            if (deleteNotify) {
                ag sessionInfoStorage = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage();
                String str = this.tyN.field_sessionId;
                p.g(str, "focused.field_sessionId");
                p.h(str, "sessionId");
                k avz = sessionInfoStorage.avz(str);
                sessionInfoStorage.vFb.remove(str);
                sessionInfoStorage.vFa.remove(avz.field_talker);
                sessionInfoStorage.delete(avz, false, "sessionId");
                ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().doNotify(this.tyN.field_sessionId, 6, this.tyN);
                kotlin.g.a.a aVar = this.tyP.tyL;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            Log.i("Finder.ConversationOnLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + deleteNotify + " position=" + this.tyO.position);
            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnF().viS++;
            AppMethodBeat.o(242742);
        }
    }

    @Override // com.tencent.mm.plugin.finder.conv.d.b
    public final void a(View view, int i2, c cVar) {
        AppMethodBeat.i(242745);
        p.h(view, "view");
        p.h(cVar, "conv");
        this.tyK = cVar;
        com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(view.getContext());
        aVar.setOnDismissListener(this);
        TouchableLayout.a aVar2 = TouchableLayout.Rni;
        int i3 = TouchableLayout.kuv;
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        aVar.a(view, i2, 0, this, this, i3, TouchableLayout.kuw);
        aVar.gTx();
        AppMethodBeat.o(242745);
    }

    public final void onDismiss() {
        this.tyK = null;
    }
}
