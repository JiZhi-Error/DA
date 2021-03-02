package com.tencent.mm.ui.conversation.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.j;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l;
import com.tencent.mm.ui.g;

public final class a implements d {
    public b QiY;
    public long QiZ;
    private final View$OnCreateContextMenuListenerC2114a Qja = new View$OnCreateContextMenuListenerC2114a(this, (byte) 0);
    BaseConversationUI ui;

    public interface b {
        void NW(long j2);
    }

    public a(BaseConversationUI baseConversationUI, b bVar) {
        AppMethodBeat.i(234298);
        this.ui = baseConversationUI;
        this.QiY = bVar;
        AppMethodBeat.o(234298);
    }

    @Override // com.tencent.mm.ui.conversation.presenter.d
    public final void a(l.a aVar) {
        AppMethodBeat.i(234299);
        com.tencent.mm.al.a.a aVar2 = aVar.Qgk;
        if (aVar2 == null) {
            AppMethodBeat.o(234299);
            return;
        }
        String str = aVar2.field_brandUserName;
        long j2 = aVar2.field_bizChatId;
        if (str == null) {
            AppMethodBeat.o(234299);
            return;
        }
        this.QiZ = j2;
        Bundle bundle = new Bundle();
        bundle.putLong("key_biz_chat_id", j2);
        bundle.putBoolean("key_need_send_video", false);
        bundle.putBoolean("key_is_biz_chat", true);
        this.ui.startChatting(str, bundle, true);
        AppMethodBeat.o(234299);
    }

    @Override // com.tencent.mm.ui.conversation.presenter.d
    public final boolean a(View view, Point point, int i2, long j2, l.a aVar) {
        AppMethodBeat.i(234300);
        if (aVar.Qgk == null) {
            AppMethodBeat.o(234300);
            return false;
        }
        View$OnCreateContextMenuListenerC2114a aVar2 = this.Qja;
        int i3 = point.x;
        int i4 = point.y;
        com.tencent.mm.al.a.a aVar3 = aVar.Qgk;
        if (aVar2.pqr == null) {
            aVar2.plk = new o.g() {
                /* class com.tencent.mm.ui.conversation.presenter.a.View$OnCreateContextMenuListenerC2114a.AnonymousClass2 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(234291);
                    switch (menuItem.getItemId()) {
                        case 0:
                            View$OnCreateContextMenuListenerC2114a.a(View$OnCreateContextMenuListenerC2114a.this, View$OnCreateContextMenuListenerC2114a.this.Qjd);
                            AppMethodBeat.o(234291);
                            return;
                        case 1:
                            com.tencent.mm.al.a.a Al = ag.bak().Al(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                            Al.field_unReadCount = 1;
                            Al.field_atCount = 0;
                            Al.field_atAll = 0;
                            ag.bak().b(Al);
                            com.tencent.mm.modelstat.b.jmd.V(Al.field_brandUserName, true);
                            AppMethodBeat.o(234291);
                            return;
                        case 2:
                            ag.bak().An(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                            com.tencent.mm.modelstat.b.jmd.V(ag.bak().Al(View$OnCreateContextMenuListenerC2114a.this.Qjd).field_brandUserName, false);
                            AppMethodBeat.o(234291);
                            return;
                        case 3:
                            com.tencent.mm.al.a.a Al2 = ag.bak().Al(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                            if (!ag.bak().Ao(View$OnCreateContextMenuListenerC2114a.this.Qjd)) {
                                View$OnCreateContextMenuListenerC2114a.a(View$OnCreateContextMenuListenerC2114a.this, true);
                                ag.bak().Ap(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                                com.tencent.mm.modelstat.b.jmd.c(true, Al2.field_brandUserName, true);
                                break;
                            } else {
                                View$OnCreateContextMenuListenerC2114a.a(View$OnCreateContextMenuListenerC2114a.this, false);
                                ag.bak().Aq(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                                com.tencent.mm.modelstat.b.jmd.c(true, Al2.field_brandUserName, false);
                                AppMethodBeat.o(234291);
                                return;
                            }
                        case 4:
                            g.c(a.this.ui, new Runnable() {
                                /* class com.tencent.mm.ui.conversation.presenter.a.View$OnCreateContextMenuListenerC2114a.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(234290);
                                    ag.bak().Am(View$OnCreateContextMenuListenerC2114a.this.Qjd);
                                    if (ag.bak().Nz(View$OnCreateContextMenuListenerC2114a.this.Qjc) <= 0) {
                                        bg.aVF();
                                        c.aST().bjW(View$OnCreateContextMenuListenerC2114a.this.Qjc);
                                    }
                                    AppMethodBeat.o(234290);
                                }
                            });
                            AppMethodBeat.o(234291);
                            return;
                    }
                    AppMethodBeat.o(234291);
                }
            };
            aVar2.pqr = new com.tencent.mm.ui.widget.b.a(a.this.ui);
        }
        aVar2.Qjb = aVar3;
        aVar2.Qjc = aVar3.field_brandUserName;
        aVar2.Qjd = aVar3.field_bizChatId;
        aVar2.pqr.a(view, i2, j2, aVar2, aVar2.plk, i3, i4);
        AppMethodBeat.o(234300);
        return true;
    }

    /* renamed from: com.tencent.mm.ui.conversation.presenter.a$a  reason: collision with other inner class name */
    class View$OnCreateContextMenuListenerC2114a implements View.OnCreateContextMenuListener {
        com.tencent.mm.al.a.a Qjb;
        String Qjc;
        long Qjd;
        private boolean isDeleteCancel;
        o.g plk;
        com.tencent.mm.ui.widget.b.a pqr;
        private q tipDialog;

        private View$OnCreateContextMenuListenerC2114a() {
            this.isDeleteCancel = false;
        }

        /* synthetic */ View$OnCreateContextMenuListenerC2114a(a aVar, byte b2) {
            this();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(234295);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            if (this.Qjb.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 1, R.string.euu);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.string.eus);
            }
            ag.bak();
            if (com.tencent.mm.al.a.b.c(this.Qjb)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 2, R.string.euv);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 2, R.string.eut);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 3, R.string.euz);
            AppMethodBeat.o(234295);
        }

        static /* synthetic */ void a(View$OnCreateContextMenuListenerC2114a aVar, final long j2) {
            AppMethodBeat.i(234296);
            Log.i("BizChatConversationPresenter", "deleteChatroom");
            ag.baj().bs(j2);
            aVar.isDeleteCancel = false;
            BaseConversationUI baseConversationUI = a.this.ui;
            a.a(a.this, R.string.zb);
            aVar.tipDialog = h.a((Context) baseConversationUI, a.a(a.this, R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.presenter.a.View$OnCreateContextMenuListenerC2114a.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(234292);
                    View$OnCreateContextMenuListenerC2114a.this.isDeleteCancel = true;
                    AppMethodBeat.o(234292);
                }
            });
            j.a(aVar.Qjc, j2, new bp.a() {
                /* class com.tencent.mm.ui.conversation.presenter.a.View$OnCreateContextMenuListenerC2114a.AnonymousClass4 */

                @Override // com.tencent.mm.model.bp.a
                public final boolean amG() {
                    AppMethodBeat.i(234293);
                    boolean z = View$OnCreateContextMenuListenerC2114a.this.isDeleteCancel;
                    AppMethodBeat.o(234293);
                    return z;
                }

                @Override // com.tencent.mm.model.bp.a
                public final void amH() {
                    AppMethodBeat.i(234294);
                    if (View$OnCreateContextMenuListenerC2114a.this.tipDialog != null) {
                        ag.baj().Am(j2);
                        ag.bak().Am(j2);
                        if (ag.bak().Nz(View$OnCreateContextMenuListenerC2114a.this.Qjc) <= 0) {
                            bg.aVF();
                            c.aST().bjW(View$OnCreateContextMenuListenerC2114a.this.Qjc);
                        }
                        View$OnCreateContextMenuListenerC2114a.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.o(234294);
                }
            });
            AppMethodBeat.o(234296);
        }

        static /* synthetic */ void a(View$OnCreateContextMenuListenerC2114a aVar, boolean z) {
            AppMethodBeat.i(234297);
            com.tencent.mm.al.a.c bs = ag.baj().bs(aVar.Qjd);
            if (e.NG(bs.field_bizChatServId)) {
                if (z) {
                    bs.field_bitFlag |= 16;
                } else {
                    bs.field_bitFlag &= -17;
                }
                Log.i("BizChatConversationPresenter", "dealSetMute:bitFlag %s", Integer.valueOf(bs.field_bitFlag));
                ag.baj().b(bs);
            } else {
                k fB = ag.bal().fB(bs.field_bizChatServId);
                if (fB == null) {
                    AppMethodBeat.o(234297);
                    return;
                }
                if (z) {
                    fB.field_bitFlag |= 16;
                } else {
                    fB.field_bitFlag &= -17;
                }
                ag.bal().b(fB);
                bs.field_bitFlag = fB.field_bitFlag;
                ag.baj().b(bs);
            }
            nt ntVar = new nt();
            ntVar.KTl = bs.field_bizChatServId;
            ntVar.KTn = bs.field_bitFlag;
            ag.baq();
            com.tencent.mm.al.a.h.a(bs.field_brandUserName, ntVar, new p() {
                /* class com.tencent.mm.ui.conversation.presenter.a.View$OnCreateContextMenuListenerC2114a.AnonymousClass1 */

                @Override // com.tencent.mm.al.p
                public final void a(int i2, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(234289);
                    Log.i("BizChatConversationPresenter", "dealSetBitSet %s onBizChatSceneEnd ret: %d ", View$OnCreateContextMenuListenerC2114a.this.Qjc, Integer.valueOf(i2));
                    AppMethodBeat.o(234289);
                }
            });
            AppMethodBeat.o(234297);
        }
    }

    static /* synthetic */ String a(a aVar, int i2) {
        AppMethodBeat.i(234301);
        String string = aVar.ui.getString(i2);
        AppMethodBeat.o(234301);
        return string;
    }
}
