package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.plugin.gamelife.ui.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001eB\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "Companion", "plugin-gamelife_release"})
public final class c implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, o.g {
    public static final a ycO = new a((byte) 0);
    private kotlin.g.a.a<x> tyL;
    private com.tencent.mm.plugin.gamelife.e.a ycL;
    private int ycM;
    private int ycN;

    static {
        AppMethodBeat.i(241462);
        AppMethodBeat.o(241462);
    }

    public c(kotlin.g.a.a<x> aVar) {
        p.h(aVar, "callBack");
        AppMethodBeat.i(241461);
        this.tyL = aVar;
        AppMethodBeat.o(241461);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_MARK_UNREAD", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        com.tencent.mm.plugin.gamelife.e.a aVar;
        AppMethodBeat.i(241458);
        p.h(contextMenu, "menu");
        p.h(view, "v");
        p.h(contextMenuInfo, "menuInfo");
        com.tencent.mm.plugin.gamelife.e.a aVar2 = this.ycL;
        if ((aVar2 != null ? Boolean.valueOf(aVar2.dXj()) : null) == null || (aVar = this.ycL) == null || !aVar.dXj()) {
            com.tencent.mm.plugin.gamelife.e.a aVar3 = this.ycL;
            if (aVar3 == null || aVar3.field_unReadCount != 0) {
                contextMenu.add(0, 0, 0, R.string.bj0);
            } else {
                contextMenu.add(0, 1, 0, R.string.bj1);
            }
            contextMenu.add(0, 3, 0, R.string.biz);
            AppMethodBeat.o(241458);
            return;
        }
        contextMenu.add(0, 3, 0, R.string.biz);
        AppMethodBeat.o(241458);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        boolean update;
        AppMethodBeat.i(241459);
        p.h(menuItem, "menuItem");
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(menuItem.getItemId());
        com.tencent.mm.plugin.gamelife.e.a aVar = this.ycL;
        objArr[1] = aVar != null ? aVar.field_sessionId : null;
        Log.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", objArr);
        com.tencent.mm.plugin.gamelife.e.a aVar2 = this.ycL;
        if (aVar2 != null) {
            switch (menuItem.getItemId()) {
                case 0:
                    e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
                    String str = aVar2.field_sessionId;
                    p.g(str, "focused.field_sessionId");
                    if (conversationStorage.avs(str)) {
                        kotlin.g.a.a<x> aVar3 = this.tyL;
                        if (aVar3 != null) {
                            aVar3.invoke();
                            AppMethodBeat.o(241459);
                            return;
                        }
                        AppMethodBeat.o(241459);
                        return;
                    }
                    Log.e("GameLife.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + aVar2.field_sessionId);
                    AppMethodBeat.o(241459);
                    return;
                case 1:
                    e conversationStorage2 = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
                    String str2 = aVar2.field_sessionId;
                    p.g(str2, "focused.field_sessionId");
                    p.h(str2, "sessionId");
                    b.a aVar4 = com.tencent.mm.plugin.gamelife.b.xZZ;
                    if (!b.a.aAQ(str2)) {
                        update = false;
                    } else {
                        com.tencent.mm.plugin.gamelife.e.a aBa = conversationStorage2.aBa(str2);
                        aBa.field_unReadCount = 1;
                        update = conversationStorage2.update(aBa.systemRowid, aBa, false);
                        conversationStorage2.doNotify(MStorageEventData.EventType.SINGLE, 5, aBa);
                        Log.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + update + " sessionId=" + str2);
                    }
                    if (update) {
                        kotlin.g.a.a<x> aVar5 = this.tyL;
                        if (aVar5 != null) {
                            aVar5.invoke();
                            AppMethodBeat.o(241459);
                            return;
                        }
                        AppMethodBeat.o(241459);
                        return;
                    }
                    Log.e("GameLife.ConversationOnLongClickListener", "markUnread failed. sessionId=" + aVar2.field_sessionId);
                    AppMethodBeat.o(241459);
                    return;
                case 3:
                    if (!aVar2.dXj()) {
                        com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(aVar2.field_selfUserName);
                        if (aAR != null) {
                            c.a aVar6 = com.tencent.mm.game.report.c.hhl;
                            int i3 = (this.ycM - 2) + 1;
                            int i4 = this.ycN;
                            String str3 = aVar2.field_sessionId;
                            p.g(str3, "focused.field_sessionId");
                            long dWY = (long) aAR.dWY();
                            String str4 = aVar2.field_selfUserName;
                            p.g(str4, "focused.field_selfUserName");
                            com.tencent.mm.plugin.gamelife.d.a aVar7 = aVar2.ybV;
                            if (aVar7 == null) {
                                p.hyc();
                            }
                            long j2 = (long) aVar7.field_accountType;
                            String str5 = aVar2.field_talker;
                            p.g(str5, "focused.field_talker");
                            long dXi = aVar2.dXi();
                            com.tencent.mm.plugin.gamelife.i.a aVar8 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                            c.a.a(i3, 92, i4, str3, dWY, str4, j2, str5, dXi, com.tencent.mm.plugin.gamelife.i.a.dXm());
                        }
                    } else {
                        c.a aVar9 = com.tencent.mm.game.report.c.hhl;
                        int i5 = (this.ycM - 2) + 1;
                        int i6 = this.ycN;
                        String str6 = aVar2.field_sessionId;
                        p.g(str6, "focused.field_sessionId");
                        long dXi2 = aVar2.dXi();
                        com.tencent.mm.plugin.gamelife.i.a aVar10 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                        c.a.a(i5, 1, i6, str6, 0, "", 0, "", dXi2, com.tencent.mm.plugin.gamelife.i.a.dXm());
                    }
                    ContextMenu.ContextMenuInfo menuInfo = menuItem.getMenuInfo();
                    if (menuInfo != null) {
                        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
                        boolean aAT = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).aAT(aVar2.field_sessionId);
                        if (!aAT) {
                            Log.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
                            break;
                        } else if (!aVar2.dXj()) {
                            com.tencent.mm.co.g.hio().i(new b(aVar2, aAT, adapterContextMenuInfo)).hdy();
                            AppMethodBeat.o(241459);
                            return;
                        } else {
                            com.tencent.mm.co.g.hio().i(C1425c.ycS).hdy();
                            AppMethodBeat.o(241459);
                            return;
                        }
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
                        AppMethodBeat.o(241459);
                        throw tVar;
                    }
            }
            AppMethodBeat.o(241459);
            return;
        }
        AppMethodBeat.o(241459);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.b.d
    public final void a(View view, int i2, com.tencent.mm.plugin.gamelife.e.a aVar, int i3) {
        AppMethodBeat.i(241460);
        p.h(view, "view");
        p.h(aVar, "conv");
        this.ycL = aVar;
        this.ycM = i2;
        this.ycN = i3;
        com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(view.getContext());
        aVar2.setOnDismissListener(this);
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        int i4 = TouchableLayout.kuv;
        TouchableLayout.a aVar4 = TouchableLayout.Rni;
        aVar2.a(view, i2, 0, this, this, i4, TouchableLayout.kuw);
        aVar2.gTx();
        AppMethodBeat.o(241460);
    }

    public final void onDismiss() {
        this.ycL = null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ AdapterView.AdapterContextMenuInfo tyO;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycP;
        final /* synthetic */ boolean ycQ;

        b(com.tencent.mm.plugin.gamelife.e.a aVar, boolean z, AdapterView.AdapterContextMenuInfo adapterContextMenuInfo) {
            this.ycP = aVar;
            this.ycQ = z;
            this.tyO = adapterContextMenuInfo;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241455);
            bp.a(this.ycP.field_sessionId, new bp.a(this) {
                /* class com.tencent.mm.plugin.gamelife.ui.c.b.AnonymousClass1 */
                final /* synthetic */ b ycR;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.ycR = r1;
                }

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    return false;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(241454);
                    Log.i("GameLife.ConversationOnLongClickListener", "longclick delete msg finish [CONTEXT_MENU_LONG_CLICK_DELETE] ret=" + this.ycR.ycQ + " position=" + this.ycR.tyO.position);
                    AppMethodBeat.o(241454);
                }
            });
            AppMethodBeat.o(241455);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.gamelife.ui.c$c  reason: collision with other inner class name */
    static final class C1425c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        public static final C1425c ycS = new C1425c();

        static {
            AppMethodBeat.i(241457);
            AppMethodBeat.o(241457);
        }

        C1425c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241456);
            ((com.tencent.mm.plugin.game.api.c) g.af(com.tencent.mm.plugin.game.api.c.class)).dSH();
            AppMethodBeat.o(241456);
            return null;
        }
    }
}
