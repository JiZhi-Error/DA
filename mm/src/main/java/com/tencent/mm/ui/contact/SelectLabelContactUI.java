package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> PYm;
    private int PYo;
    private HashSet<String> jVV;
    private String label;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SelectLabelContactUI selectLabelContactUI, String str) {
        AppMethodBeat.i(38039);
        selectLabelContactUI.bnC(str);
        AppMethodBeat.o(38039);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(38031);
        super.amZ();
        this.label = getIntent().getStringExtra("label");
        this.PYo = getIntent().getIntExtra("list_attr", 0);
        this.jVV = new HashSet<>();
        this.PYm = new HashSet<>();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.PYm.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        String stringExtra2 = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(stringExtra2)) {
            this.jVV.addAll(Util.stringsToList(stringExtra2.split(",")));
        }
        AppMethodBeat.o(38031);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38032);
        super.onCreate(bundle);
        if (u.hasAttr(this.PYo, 64)) {
            addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.contact.SelectLabelContactUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(38030);
                    ArrayList arrayList = new ArrayList(SelectLabelContactUI.this.jVV);
                    Log.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", arrayList.toString());
                    SelectLabelContactUI.a(SelectLabelContactUI.this, Util.listToString(arrayList, ","));
                    AppMethodBeat.o(38030);
                    return true;
                }
            }, null, t.b.GREEN);
        }
        ani();
        AppMethodBeat.o(38032);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234090);
        p gUP = gUP();
        a anH = gUP.getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(234090);
        } else if (anH.contact == null) {
            AppMethodBeat.o(234090);
        } else {
            String str = anH.contact.field_username;
            Log.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", str);
            if (!u.hasAttr(this.PYo, 64)) {
                bnC(str);
                AppMethodBeat.o(234090);
            } else if (this.PYm.contains(str) || this.jVV.contains(str) || !u.hasAttr(this.PYo, 131072) || this.PYm.size() + this.jVV.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                if (!this.PYm.contains(str)) {
                    if (this.jVV.contains(str)) {
                        this.jVV.remove(str);
                    } else {
                        this.jVV.add(str);
                    }
                }
                ani();
                gUP.notifyDataSetChanged();
                AppMethodBeat.o(234090);
            } else {
                h.d(getContext(), getString(R.string.ghv, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE))}), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectLabelContactUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(234090);
            }
        }
    }

    private void ani() {
        AppMethodBeat.i(38034);
        if (!u.hasAttr(this.PYo, 64) || this.jVV.size() <= 0) {
            updateOptionMenuText(1, getString(R.string.x_));
            enableOptionMenu(1, false);
            AppMethodBeat.o(38034);
            return;
        }
        updateOptionMenuText(1, getString(R.string.x_) + "(" + this.jVV.size() + ")");
        enableOptionMenu(1, true);
        AppMethodBeat.o(38034);
    }

    private void bnC(String str) {
        AppMethodBeat.i(38035);
        if (u.hasAttr(this.PYo, 16384)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(38035);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(this, ChattingUI.class);
        intent2.putExtra("Chat_User", str);
        intent2.putExtra("finish_direct", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(38035);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        return this.label;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(38036);
        i iVar = new i(this, u.hasAttr(this.PYo, 64), com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(this.label)));
        AppMethodBeat.o(38036);
        return iVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(a aVar) {
        AppMethodBeat.i(38037);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(38037);
            return false;
        }
        boolean contains = this.jVV.contains(aVar.contact.field_username);
        AppMethodBeat.o(38037);
        return contains;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(a aVar) {
        AppMethodBeat.i(38038);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(38038);
            return false;
        }
        boolean contains = this.PYm.contains(aVar.contact.field_username);
        AppMethodBeat.o(38038);
        return contains;
    }
}
