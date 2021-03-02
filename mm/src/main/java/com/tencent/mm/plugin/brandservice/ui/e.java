package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.m;

public final class e {
    final Activity dKq;
    String poQ;
    m ppB;

    public e(Activity activity, String str) {
        this.dKq = activity;
        this.poQ = str;
    }

    public final MenuItem.OnMenuItemClickListener cmc() {
        AppMethodBeat.i(194877);
        AnonymousClass1 r0 = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.e.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(194876);
                if (e.this.ppB != null) {
                    e.this.ppB.dismiss();
                    e.this.ppB = null;
                }
                e.this.ppB = new m(e.this.dKq);
                e.this.ppB.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.brandservice.ui.e.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        AppMethodBeat.i(194874);
                        ((n) g.af(n.class)).fI(e.this.poQ);
                        if (!((n) g.af(n.class)).fF(e.this.poQ)) {
                            String fG = ((n) g.af(n.class)).fG(e.this.poQ);
                            if (Util.isNullOrNil(fG)) {
                                mVar.aS(2, R.string.ajy, R.raw.ofm_add_icon);
                            } else {
                                mVar.b(2, fG, R.raw.ofm_add_icon);
                            }
                        }
                        mVar.aS(3, R.string.bxg, R.raw.actionbar_goto_disabled_biz_icon);
                        mVar.aS(4, R.string.d0, R.raw.actionbar_setting_white_icon);
                        AppMethodBeat.o(194874);
                    }
                };
                e.this.ppB.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.brandservice.ui.e.AnonymousClass1.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(194875);
                        switch (menuItem.getItemId()) {
                            case 2:
                                String fH = ((n) g.af(n.class)).fH(e.this.poQ);
                                if (!Util.isNullOrNil(fH)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", fH);
                                    Log.i("EnterpriseBizEntranceListHelper", "KRawUrl :%s", fH);
                                    intent.putExtra("useJs", true);
                                    intent.addFlags(67108864);
                                    c.b(e.this.dKq, "webview", ".ui.tools.WebViewUI", intent, 0);
                                    AppMethodBeat.o(194875);
                                    return;
                                }
                                ((n) g.af(n.class)).fI(e.this.poQ);
                                ((n) g.af(n.class)).b(e.this.dKq, e.this.poQ);
                                AppMethodBeat.o(194875);
                                return;
                            case 3:
                                Intent intent2 = new Intent(e.this.dKq, EnterpriseBizContactPlainListUI.class);
                                intent2.putExtra("enterprise_biz_name", e.this.poQ);
                                intent2.putExtra("enterprise_scene", 2);
                                Activity activity = e.this.dKq;
                                a bl = new a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListHelper$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(194875);
                                return;
                            case 4:
                                Intent intent3 = new Intent();
                                intent3.putExtra("Contact_User", e.this.poQ);
                                b.jRt.c(intent3, e.this.dKq);
                                break;
                        }
                        AppMethodBeat.o(194875);
                    }
                };
                e.this.ppB.iv();
                AppMethodBeat.o(194876);
                return false;
            }
        };
        AppMethodBeat.o(194877);
        return r0;
    }

    public final boolean e(int i2, int i3, Intent intent) {
        AppMethodBeat.i(194878);
        switch (i2) {
            case 1:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.eir().s(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.r(this.dKq, this.dKq.getString(R.string.dzo));
                }
                AppMethodBeat.o(194878);
                return true;
            default:
                AppMethodBeat.o(194878);
                return false;
        }
    }
}
