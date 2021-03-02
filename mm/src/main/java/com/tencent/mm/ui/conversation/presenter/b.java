package com.tencent.mm.ui.conversation.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.al.p;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b implements MenuItem.OnMenuItemClickListener, p, MMActivity.a {
    private k PaM;
    private d PaO;
    private final MMFragmentActivity Qjh;
    private com.tencent.mm.al.c.b Qji = new com.tencent.mm.al.c.b();
    private String iNV;
    private m ppB;
    private String ppO;
    private q tipDialog;

    static /* synthetic */ boolean b(b bVar) {
        AppMethodBeat.i(234313);
        boolean gWn = bVar.gWn();
        AppMethodBeat.o(234313);
        return gWn;
    }

    public b(MMFragmentActivity mMFragmentActivity, String str) {
        AppMethodBeat.i(234306);
        this.Qjh = mMFragmentActivity;
        this.iNV = str;
        this.PaO = ag.bar().MO(str);
        if (this.PaO == null) {
            Log.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", str);
        }
        ag.bah();
        this.ppO = f.MX(str);
        AppMethodBeat.o(234306);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(234307);
        final String fH = g.fH(this.iNV);
        final boolean z = !Util.isNullOrNil(fH);
        if (!z) {
            this.Qji.fI(this.iNV);
        }
        if (this.ppB != null) {
            this.ppB.dismiss();
            this.ppB = null;
        }
        this.ppB = new m(this.Qjh);
        this.ppB.HLX = new o.f() {
            /* class com.tencent.mm.ui.conversation.presenter.b.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                boolean z = false;
                AppMethodBeat.i(234302);
                if (!(b.this.PaO != null && b.this.PaO.field_hide_create_chat) && b.b(b.this)) {
                    z = true;
                }
                if (z) {
                    mVar.aS(1, R.string.ajz, R.raw.actionbar_create_biz_chat_icon);
                }
                if (!g.fF(b.this.iNV)) {
                    String fG = g.fG(b.this.iNV);
                    if (Util.isNullOrNil(fG)) {
                        mVar.aS(2, R.string.ajy, R.raw.ofm_add_icon);
                    } else {
                        mVar.b(2, fG, R.raw.ofm_add_icon);
                    }
                }
                if (z) {
                    mVar.a(4, b.d(b.this).getString(R.string.ajx), ar.m(b.this.Qjh, R.raw.actionbar_facefriend_icon, -1));
                }
                mVar.a(3, b.d(b.this).getString(R.string.d0), ar.m(b.this.Qjh, R.raw.actionbar_setting_white_icon, -1));
                AppMethodBeat.o(234302);
            }
        };
        this.ppB.HLY = new o.g() {
            /* class com.tencent.mm.ui.conversation.presenter.b.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(234303);
                switch (menuItem.getItemId()) {
                    case 1:
                        b.f(b.this);
                        AppMethodBeat.o(234303);
                        return;
                    case 2:
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", fH);
                            Log.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", fH);
                            intent.putExtra("useJs", true);
                            intent.addFlags(67108864);
                            c.b(b.this.Qjh, "webview", ".ui.tools.WebViewUI", intent, 0);
                            AppMethodBeat.o(234303);
                            return;
                        }
                        b.this.Qji.fI(b.this.iNV);
                        b.this.Qji.z(b.this.Qjh);
                        AppMethodBeat.o(234303);
                        return;
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", b.this.iNV);
                        c.b(b.this.Qjh, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        break;
                    case 4:
                        if (!Util.isNullOrNil(b.this.ppO)) {
                            Intent intent3 = new Intent(b.this.Qjh, BizChatFavUI.class);
                            intent3.putExtra("Contact_User", b.this.ppO);
                            intent3.addFlags(67108864);
                            MMFragmentActivity mMFragmentActivity = b.this.Qjh;
                            a bl = new a().bl(intent3);
                            com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mMFragmentActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(234303);
                            return;
                        }
                        Log.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
                        AppMethodBeat.o(234303);
                        return;
                }
                AppMethodBeat.o(234303);
            }
        };
        this.ppB.iv();
        AppMethodBeat.o(234307);
        return false;
    }

    private boolean gWn() {
        AppMethodBeat.i(234309);
        this.PaM = ag.bal().fB(ag.bal().fC(this.ppO));
        if (this.PaM == null || Util.isNullOrNil(this.PaM.field_addMemberUrl)) {
            AppMethodBeat.o(234309);
            return false;
        }
        AppMethodBeat.o(234309);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(234310);
        if (i3 != -1 || intent == null) {
            AppMethodBeat.o(234310);
            return;
        }
        switch (i2) {
            case 1:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    Log.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    bfs bfs = new bfs();
                    com.tencent.mm.al.a.c cVar = new com.tencent.mm.al.a.c();
                    cVar.field_addMemberUrl = this.PaM != null ? this.PaM.field_addMemberUrl : null;
                    cVar.field_brandUserName = this.ppO;
                    if (!e.a(cVar, string, null, bfs)) {
                        z = false;
                    } else if (cVar.field_bizChatLocalId != -1) {
                        Nq(cVar.field_bizChatLocalId);
                        z = true;
                    } else {
                        ag.baq();
                        final com.tencent.mm.al.a.o a2 = h.a(this.ppO, bfs, this);
                        MMFragmentActivity mMFragmentActivity = this.Qjh;
                        getString(R.string.zb);
                        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMFragmentActivity, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.conversation.presenter.b.AnonymousClass4 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(234305);
                                ag.baq();
                                h.d(a2);
                                AppMethodBeat.o(234305);
                            }
                        });
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    Toast.makeText(this.Qjh, getString(R.string.g6j), 0).show();
                    AppMethodBeat.o(234310);
                    return;
                }
                AppMethodBeat.o(234310);
                return;
            default:
                AppMethodBeat.o(234310);
                return;
        }
    }

    private void Nq(long j2) {
        AppMethodBeat.i(234311);
        if (this.Qjh instanceof BaseBizConversationUI) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j2);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            ((BaseBizConversationUI) this.Qjh).startChatting(this.ppO, bundle, true);
        }
        AppMethodBeat.o(234311);
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(234312);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (qVar.getType() == 1355) {
            com.tencent.mm.al.a.c NE = ag.baj().NE(((com.tencent.mm.al.a.o) qVar).baD().Lpw.LPp.KTl);
            if (NE == null) {
                Toast.makeText(MMApplicationContext.getContext(), getString(R.string.g6j), 0).show();
                AppMethodBeat.o(234312);
                return;
            }
            Nq(NE.field_bizChatLocalId);
        }
        AppMethodBeat.o(234312);
    }

    private String getString(int i2) {
        AppMethodBeat.i(234308);
        String string = this.Qjh.getString(i2);
        AppMethodBeat.o(234308);
        return string;
    }

    static /* synthetic */ Resources d(b bVar) {
        AppMethodBeat.i(234314);
        Resources resources = bVar.Qjh.getResources();
        AppMethodBeat.o(234314);
        return resources;
    }

    static /* synthetic */ void f(b bVar) {
        boolean z = false;
        AppMethodBeat.i(234315);
        if (!bVar.gWn()) {
            Toast.makeText(bVar.Qjh, bVar.getString(R.string.ak0), 0).show();
            String fC = ag.bal().fC(bVar.ppO);
            bVar.PaM = ag.bal().fB(fC);
            Object[] objArr = new Object[3];
            objArr[0] = bVar.ppO;
            objArr[1] = fC;
            if (bVar.PaM == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("EnterpriseConversationDropMenuPresenter", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", objArr);
            if (Util.isNullOrNil(fC) || bVar.PaM == null || bVar.PaM.bay() || Util.isNullOrNil(bVar.PaM.field_addMemberUrl)) {
                ag.baq();
                h.a(bVar.ppO, bVar);
                MMFragmentActivity mMFragmentActivity = bVar.Qjh;
                bVar.getString(R.string.zb);
                bVar.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMFragmentActivity, bVar.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.conversation.presenter.b.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(234304);
                        b.this.Qjh.finish();
                        AppMethodBeat.o(234304);
                    }
                });
            }
            AppMethodBeat.o(234315);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bVar.PaM.field_addMemberUrl);
        Log.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", bVar.PaM.field_addMemberUrl);
        intent.putExtra("useJs", true);
        intent.addFlags(67108864);
        if (bVar.Qjh instanceof MMActivity) {
            ((MMActivity) bVar.Qjh).mmSetOnActivityResultCallback(bVar);
        } else if (bVar.Qjh instanceof BaseBizConversationUI) {
            ((BaseBizConversationUI) bVar.Qjh).onActResult = bVar;
        }
        c.b(bVar.Qjh, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(234315);
    }
}
