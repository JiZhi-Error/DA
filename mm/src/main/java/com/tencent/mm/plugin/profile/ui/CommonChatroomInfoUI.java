package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.ui.a;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;

public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private a Bdr;
    private b Bds;
    private as contact;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(26944);
        super.amZ();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        bg.aVF();
        this.contact = c.aSN().Kn(stringExtra);
        AppMethodBeat.o(26944);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26945);
        super.initView();
        a aVar = this.Bdr;
        j jVar = new j();
        jVar.query = aVar.contact.field_username;
        jVar.wWZ = aVar;
        jVar.handler = aVar.handler;
        jVar.kXb = 6;
        jVar.wWY = new a.C1583a((byte) 0);
        ((n) g.ah(n.class)).search(2, jVar);
        AppMethodBeat.o(26945);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(26946);
        if (this.contact.fuA == 1) {
            String string = getString(R.string.ba7);
            AppMethodBeat.o(26946);
            return string;
        } else if (this.contact.fuA == 2) {
            String string2 = getString(R.string.ba6);
            AppMethodBeat.o(26946);
            return string2;
        } else {
            String string3 = getString(R.string.baa);
            AppMethodBeat.o(26946);
            return string3;
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(26947);
        if (this.Bdr == null) {
            this.Bdr = new a(this, this.scene, this.contact);
        }
        a aVar = this.Bdr;
        AppMethodBeat.o(26947);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(26948);
        if (this.Bds == null) {
            this.Bds = new b(this, this.scene, this.contact);
        }
        b bVar = this.Bds;
        AppMethodBeat.o(26948);
        return bVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(231829);
        f fVar = (f) getContentLV().getAdapter().getItem(i2);
        if (fVar != null) {
            if ((as.bjp(fVar.contact.field_username) || as.bjq(fVar.contact.field_username)) && !WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(view.getContext())) {
                AppMethodBeat.o(231829);
                return;
            }
            com.tencent.mm.br.c.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", fVar.contact.field_username).putExtra("finish_direct", true));
        }
        AppMethodBeat.o(231829);
    }
}
