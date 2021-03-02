package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements p {
    k PaM;
    private TextView PbU;
    private String ppO = null;
    private int scene = 0;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(34032);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        gMi();
        String fC = ag.bal().fC(this.ppO);
        this.PaM = ag.bal().fB(fC);
        Object[] objArr = new Object[3];
        objArr[0] = this.ppO;
        objArr[1] = fC;
        if (this.PaM == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", objArr);
        if (Util.isNullOrNil(fC) || this.PaM == null || this.PaM.bay() || Util.isNullOrNil(this.PaM.field_addMemberUrl)) {
            ag.baq();
            h.a(this.ppO, this);
            Activity activity = getActivity();
            getString(R.string.zb);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) activity, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(34031);
                    BizChatSelectConversationUI.this.finish();
                    AppMethodBeat.o(34031);
                }
            });
        }
        AppMethodBeat.o(34032);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34033);
        super.onDestroy();
        AppMethodBeat.o(34033);
    }

    private void gMi() {
        AppMethodBeat.i(34034);
        if (Util.isNullOrNil(this.ppO)) {
            this.ppO = getIntent().getStringExtra("enterprise_biz_name");
            if (Util.isNullOrNil(this.ppO)) {
                Log.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
        AppMethodBeat.o(34034);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final com.tencent.mm.ui.contact.q bmC() {
        AppMethodBeat.i(34035);
        gMi();
        d dVar = new d(this, this.ppO);
        AppMethodBeat.o(34035);
        return dVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(34036);
        gMi();
        r rVar = new r(this, this.ppO);
        AppMethodBeat.o(34036);
        return rVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(34037);
        super.a(listView, i2);
        if (this.PbU == null) {
            AnonymousClass1 r0 = new View.OnClickListener() {
                /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(34026);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(34026);
                }
            };
            String string = getString(R.string.gi3);
            View inflate = aa.jQ(this).inflate(R.layout.ats, (ViewGroup) null);
            inflate.setOnClickListener(r0);
            TextView textView = (TextView) inflate.findViewById(R.id.bfe);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.PbU = textView;
        }
        this.PbU.setVisibility(i2);
        AppMethodBeat.o(34037);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(34038);
        super.egJ();
        AppMethodBeat.o(34038);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(232793);
        if (i2 < getContentLV().getHeaderViewsCount()) {
            Log.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i2));
            AppMethodBeat.o(232793);
        } else if (!(getContentLV().getAdapter().getItem(i2) instanceof a)) {
            Log.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
            AppMethodBeat.o(232793);
        } else {
            a aVar = (a) getContentLV().getAdapter().getItem(i2);
            if (aVar == null) {
                AppMethodBeat.o(232793);
                return;
            }
            String str = aVar.username;
            long j2 = aVar.ppv;
            if (str == null || j2 == -1) {
                Log.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j2));
                AppMethodBeat.o(232793);
                return;
            }
            a(str, j2, aVar.jVL);
            AppMethodBeat.o(232793);
        }
    }

    private void a(String str, long j2, CharSequence charSequence) {
        AppMethodBeat.i(34040);
        Log.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene != 2) {
            if (this.scene == 1) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
                String str2 = (String) hashMap.get("desc");
                a((String) hashMap.get("title"), str2, (String) hashMap.get("img_url"), str, j2);
            }
            AppMethodBeat.o(34040);
        } else if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
            r(str, String.valueOf(charSequence), j2);
            AppMethodBeat.o(34040);
        } else {
            s(str, String.valueOf(charSequence), j2);
            AppMethodBeat.o(34040);
        }
    }

    private void r(final String str, String str2, final long j2) {
        AppMethodBeat.i(34041);
        com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, j2, getString(R.string.g5i), str2, getString(R.string.yq), new y.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(34027);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j2);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(34027);
            }
        });
        AppMethodBeat.o(34041);
    }

    private void s(final String str, String str2, final long j2) {
        AppMethodBeat.i(34042);
        com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, j2, getString(R.string.g5i), str2, getString(R.string.yq), new y.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(34028);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str);
                    intent.putExtra("key_biz_chat_id", j2);
                    intent.putExtra("key_is_biz_chat", true);
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(34028);
            }
        });
        AppMethodBeat.o(34042);
    }

    private d a(String str, String str2, String str3, final String str4, final long j2) {
        AppMethodBeat.i(34043);
        d a2 = com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), str, str3, str2, true, getResources().getString(R.string.yq), (y.a) new y.a() {
            /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(34029);
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("enterprise_biz_name", str4);
                    intent.putExtra("key_biz_chat_id", j2);
                    intent.putExtra("key_is_biz_chat", true);
                    if (!Util.isNullOrNil(str)) {
                        intent.putExtra("enterprise_share_append_text", str);
                    }
                    BizChatSelectConversationUI.this.setResult(-1, intent);
                    BizChatSelectConversationUI.this.finish();
                }
                AppMethodBeat.o(34029);
            }
        });
        AppMethodBeat.o(34043);
        return a2;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(34044);
        String displayName = com.tencent.mm.model.aa.getDisplayName(this.ppO);
        AppMethodBeat.o(34044);
        return displayName;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(34045);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(34045);
            return;
        }
        switch (i2) {
            case 1:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    Log.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                    String string = bundleExtra.getString("enterprise_members");
                    bfs bfs = new bfs();
                    c cVar = new c();
                    cVar.field_addMemberUrl = this.PaM != null ? this.PaM.field_addMemberUrl : null;
                    cVar.field_brandUserName = this.ppO;
                    if (!e.a(cVar, string, null, bfs)) {
                        z = false;
                    } else if (cVar.field_bizChatLocalId != -1) {
                        a(this.ppO, cVar.field_bizChatLocalId, cVar.field_chatName);
                        z = true;
                    } else {
                        ag.baq();
                        final com.tencent.mm.al.a.o a2 = h.a(this.ppO, bfs, this);
                        getString(R.string.zb);
                        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dw), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.AnonymousClass5 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(34030);
                                bg.azz().a(a2);
                                AppMethodBeat.o(34030);
                            }
                        });
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    Toast.makeText(this, getString(R.string.g69), 0).show();
                    AppMethodBeat.o(34045);
                    return;
                }
                AppMethodBeat.o(34045);
                return;
            default:
                AppMethodBeat.o(34045);
                return;
        }
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(34046);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (qVar.getType() == 1355) {
            c NE = ag.baj().NE(((com.tencent.mm.al.a.o) qVar).baD().Lpw.LPp.KTl);
            if (NE == null) {
                Toast.makeText(MMApplicationContext.getContext(), getString(R.string.g69), 0).show();
                AppMethodBeat.o(34046);
                return;
            }
            a(this.ppO, NE.field_bizChatLocalId, NE.field_chatName);
        }
        AppMethodBeat.o(34046);
    }

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        AppMethodBeat.i(34047);
        bizChatSelectConversationUI.PaM = ag.bal().fB(ag.bal().fC(bizChatSelectConversationUI.ppO));
        if (bizChatSelectConversationUI.PaM == null || Util.isNullOrNil(bizChatSelectConversationUI.PaM.field_addMemberUrl)) {
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.PaM != null ? bizChatSelectConversationUI.PaM.field_addMemberUrl : null;
            Log.i("MicroMsg.BizChatSelectConversationUI", "field_addMemberUrl:%s", objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.string.ak0), 0).show();
            AppMethodBeat.o(34047);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.PaM.field_addMemberUrl);
        Log.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.PaM.field_addMemberUrl);
        intent.putExtra("useJs", true);
        com.tencent.mm.br.c.b(bizChatSelectConversationUI.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(34047);
    }
}
