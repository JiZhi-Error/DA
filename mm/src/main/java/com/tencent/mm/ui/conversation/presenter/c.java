package com.tencent.mm.ui.conversation.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l;

public final class c implements i, d {
    private final a Qjm = new a();
    private String iNV;
    boolean isDeleteCancel = false;
    q tipDialog;
    BaseConversationUI ui;

    public c(BaseConversationUI baseConversationUI, String str) {
        AppMethodBeat.i(234323);
        this.ui = baseConversationUI;
        this.iNV = str;
        AppMethodBeat.o(234323);
    }

    @Override // com.tencent.mm.ui.conversation.presenter.d
    public final void a(l.a aVar) {
        AppMethodBeat.i(234324);
        az azVar = aVar.conversation;
        if (azVar == null) {
            AppMethodBeat.o(234324);
        } else if (g.DQ(azVar.field_username)) {
            Intent intent = new Intent(this.ui, BizChatConversationUI.class);
            intent.putExtra("Contact_User", azVar.field_username);
            intent.putExtra("biz_chat_from_scene", 7);
            intent.addFlags(67108864);
            BaseConversationUI baseConversationUI = this.ui;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(baseConversationUI, bl.axQ(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseConversationUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseConversationUI, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(234324);
        } else if (g.Nh(azVar.field_username)) {
            com.tencent.mm.api.c fJ = g.fJ(azVar.field_username);
            String UJ = fJ == null ? null : fJ.UJ();
            if (UJ == null) {
                UJ = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", UJ);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", azVar.field_username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.putExtra("geta8key_scene", 51);
            intent2.addFlags(67108864);
            com.tencent.mm.br.c.b(this.ui, "webview", ".ui.tools.WebViewUI", intent2);
            a(fJ, 2, azVar.field_unReadCount);
            AppMethodBeat.o(234324);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_biz_chat", false);
            this.ui.startChatting(azVar.field_username, bundle, true);
            a(g.fJ(azVar.field_username), 1, azVar.field_unReadCount);
            AppMethodBeat.o(234324);
        }
    }

    @Override // com.tencent.mm.ui.conversation.presenter.d
    public final boolean a(View view, Point point, int i2, long j2, l.a aVar) {
        AppMethodBeat.i(234325);
        a.a(this.Qjm);
        a.a(this.Qjm, view, point.x, point.y, i2, j2, aVar.conversation);
        AppMethodBeat.o(234325);
        return true;
    }

    private void a(com.tencent.mm.api.c cVar, int i2, int i3) {
        AppMethodBeat.i(234326);
        d MO = ag.bar().MO(this.iNV);
        long j2 = MO != null ? MO.field_wwCorpId : 0;
        long j3 = MO != null ? MO.field_wwUserVid : 0;
        int i4 = i3 > 0 ? 1 : 2;
        long UK = cVar == null ? 0 : cVar.UK();
        h.INSTANCE.a(14507, Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 1, Integer.valueOf(i4), Integer.valueOf(i2));
        Log.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 1, Integer.valueOf(i4), Integer.valueOf(i2));
        AppMethodBeat.o(234326);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(234327);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 1394) {
                efm eDZ = ((com.tencent.mm.plugin.profile.b.d) qVar).eDZ();
                efn eDY = ((com.tencent.mm.plugin.profile.b.d) qVar).eDY();
                if (eDY == null || eDY.KTz == null || eDY.KTz.ret != 0) {
                    if (eDY == null || eDY.KTz == null) {
                        Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(qVar.getType()));
                        AppMethodBeat.o(234327);
                        return;
                    }
                    Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(eDY.KTz.ret));
                    AppMethodBeat.o(234327);
                    return;
                } else if (!eDZ.neT) {
                    AppMethodBeat.o(234327);
                    return;
                } else {
                    com.tencent.mm.api.c fJ = g.fJ(eDZ.KTt);
                    fJ.field_brandFlag |= 1;
                    cpe cpe = new cpe();
                    cpe.kem = fJ.field_brandFlag;
                    cpe.UserName = eDZ.KTt;
                    bg.aVF();
                    com.tencent.mm.model.c.aSM().d(new k.a(47, cpe));
                    ag.bah().update(fJ, new String[0]);
                    bg.aVF();
                    com.tencent.mm.model.c.aST().bjW(fJ.field_username);
                    bg.aVF();
                    if (com.tencent.mm.model.c.aST().bkk(fJ.field_enterpriseFather) <= 0) {
                        bg.aVF();
                        com.tencent.mm.model.c.aST().bjW(fJ.field_enterpriseFather);
                        AppMethodBeat.o(234327);
                        return;
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.aSS().biO(fJ.field_enterpriseFather);
                }
            }
            AppMethodBeat.o(234327);
            return;
        }
        AppMethodBeat.o(234327);
    }

    public final void delConversationAndMsg(String str) {
        AppMethodBeat.i(234328);
        if (Util.isNullOrNil(str)) {
            Log.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
            AppMethodBeat.o(234328);
            return;
        }
        asyncDelMsg(str);
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(str);
        com.tencent.mm.api.c MT = ag.bah().MT(str);
        bg.aVF();
        com.tencent.mm.model.c.aSS().biO(MT.field_enterpriseFather);
        AppMethodBeat.o(234328);
    }

    private void asyncDelMsg(String str) {
        AppMethodBeat.i(234329);
        bg.aVF();
        ca aEw = com.tencent.mm.model.c.aSQ().aEw(str);
        afk afk = new afk();
        afk.Lqk = new dqi().bhy(Util.nullAsNil(str));
        afk.Brn = aEw.field_msgSvrId;
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new k.a(8, afk));
        this.isDeleteCancel = false;
        BaseConversationUI baseConversationUI = this.ui;
        getString(R.string.zb);
        final q a2 = com.tencent.mm.ui.base.h.a((Context) baseConversationUI, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.conversation.presenter.c.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                c.this.isDeleteCancel = true;
            }
        });
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.ui.conversation.presenter.c.AnonymousClass3 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                return c.this.isDeleteCancel;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(234318);
                if (a2 != null) {
                    a2.dismiss();
                }
                AppMethodBeat.o(234318);
            }
        });
        AppMethodBeat.o(234329);
    }

    class a implements View.OnCreateContextMenuListener {
        private com.tencent.mm.ui.widget.b.a Qjp;
        private String ppl = "";
        private o.g pso;

        a() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(234320);
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(this.ppl);
            if (Kn == null) {
                Log.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.ppl);
                AppMethodBeat.o(234320);
                return;
            }
            String arJ = Kn.arJ();
            if (arJ.toLowerCase().endsWith("@chatroom") && Util.isNullOrNil(Kn.field_nickname)) {
                arJ = c.this.getString(R.string.b25);
            }
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(c.this.ui, arJ));
            if (Kn.arE()) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.euv);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.bxt);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.string.bxm);
            contextMenu.add(adapterContextMenuInfo.position, 1, 2, R.string.euz);
            AppMethodBeat.o(234320);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(234321);
            aVar.Qjp = new com.tencent.mm.ui.widget.b.a(c.this.ui);
            aVar.pso = new o.g() {
                /* class com.tencent.mm.ui.conversation.presenter.c.a.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(234319);
                    switch (menuItem.getItemId()) {
                        case 0:
                            bg.aVF();
                            com.tencent.mm.model.c.aST().bjW(a.this.ppl);
                            AppMethodBeat.o(234319);
                            return;
                        case 1:
                            c.this.delConversationAndMsg(a.this.ppl);
                            AppMethodBeat.o(234319);
                            return;
                        case 2:
                            c cVar = c.this;
                            String str = a.this.ppl;
                            BaseConversationUI baseConversationUI = cVar.ui;
                            com.tencent.mm.ui.base.h.c(baseConversationUI, baseConversationUI.getString(R.string.bxd), "", baseConversationUI.getString(R.string.bxc), baseConversationUI.getString(R.string.sz), new DialogInterface.OnClickListener(str, baseConversationUI) {
                                /* class com.tencent.mm.ui.conversation.presenter.c.AnonymousClass1 */
                                final /* synthetic */ String gMw;
                                final /* synthetic */ Context val$context;

                                {
                                    this.gMw = r2;
                                    this.val$context = r3;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(234317);
                                    final com.tencent.mm.plugin.profile.b.d dVar = new com.tencent.mm.plugin.profile.b.d(this.gMw, true);
                                    bg.azz().a(1394, c.this);
                                    bg.azz().a(dVar, 0);
                                    c cVar = c.this;
                                    Context context = this.val$context;
                                    this.val$context.getString(R.string.zb);
                                    cVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.val$context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.ui.conversation.presenter.c.AnonymousClass1.AnonymousClass1 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(234316);
                                            bg.azz().a(dVar);
                                            bg.azz().b(1394, c.this);
                                            AppMethodBeat.o(234316);
                                        }
                                    });
                                    AppMethodBeat.o(234317);
                                }
                            }, null);
                            AppMethodBeat.o(234319);
                            return;
                        case 3:
                            String str2 = a.this.ppl;
                            bg.aVF();
                            if (com.tencent.mm.model.c.aSN().Kn(str2) != null) {
                                bg.aVF();
                                if (!com.tencent.mm.model.c.aST().bkg(str2)) {
                                    j.HO(str2);
                                    break;
                                } else {
                                    ab.F(str2, true);
                                    AppMethodBeat.o(234319);
                                    return;
                                }
                            } else {
                                Log.e("EnterpriseConversationPresenter", "changed biz stick status failed, contact is null, talker = ".concat(String.valueOf(str2)));
                                AppMethodBeat.o(234319);
                                return;
                            }
                    }
                    AppMethodBeat.o(234319);
                }
            };
            AppMethodBeat.o(234321);
        }

        static /* synthetic */ void a(a aVar, View view, int i2, int i3, int i4, long j2, az azVar) {
            AppMethodBeat.i(234322);
            if (azVar == null) {
                AppMethodBeat.o(234322);
                return;
            }
            aVar.ppl = azVar.field_username;
            aVar.Qjp.a(view, i4, j2, aVar, aVar.pso, i2, i3);
            AppMethodBeat.o(234322);
        }
    }

    /* access modifiers changed from: package-private */
    public final String getString(int i2) {
        AppMethodBeat.i(234330);
        String string = this.ui.getString(i2);
        AppMethodBeat.o(234330);
        return string;
    }
}
