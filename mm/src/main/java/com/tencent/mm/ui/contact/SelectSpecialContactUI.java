package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int PYo;
    private String title;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(38040);
        super.amZ();
        this.title = getIntent().getStringExtra("titile");
        this.PYo = getIntent().getIntExtra("list_attr", 0);
        AppMethodBeat.o(38040);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234091);
        a anH = gUP().getItem(i2);
        if (anH == null) {
            AppMethodBeat.o(234091);
        } else if (anH.contact == null) {
            AppMethodBeat.o(234091);
        } else {
            String str = anH.contact.field_username;
            Log.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (u.hasAttr(this.PYo, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(234091);
            } else if (u.hasAttr(this.PYo, 32768)) {
                intent.putExtra("Contact_User", str);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
                c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 1);
                AppMethodBeat.o(234091);
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                AppMethodBeat.o(234091);
            }
        }
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
        return this.title;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(38042);
        ae aeVar = new ae(this, getIntent().getStringExtra("filter_type"));
        AppMethodBeat.o(38042);
        return aeVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(234092);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                gUQ().and();
                AppMethodBeat.o(234092);
                return;
            default:
                AppMethodBeat.o(234092);
                return;
        }
    }
}
