package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyExclusiveSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private List<String> gzY = new ArrayList();
    private List<String> jWf = new ArrayList();

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyExclusiveSelectContactUI() {
        AppMethodBeat.i(213404);
        AppMethodBeat.o(213404);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(213405);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        this.gzY.add(z.aTY());
        this.jWf = ((c) g.af(c.class)).aSX().Kh(this.chatroomName);
        this.jWf.remove(z.aTY());
        super.onCreate(bundle);
        AppMethodBeat.o(213405);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(213406);
        String string = getString(R.string.eq_);
        AppMethodBeat.o(213406);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        boolean z;
        AppMethodBeat.i(213407);
        Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "handleItemClick: %s", Integer.valueOf(i2));
        final com.tencent.mm.ui.contact.a.a anH = gUP().getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(213407);
        } else if (anH.contact == null) {
            AppMethodBeat.o(213407);
        } else {
            Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "ClickUser=%s", anH.contact.field_username);
            String str = anH.contact.field_username;
            String displayName = aa.getDisplayName(str, this.chatroomName);
            Iterator<String> it = this.jWf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!next.equals(str) && displayName.equals(aa.getDisplayName(next, this.chatroomName))) {
                    Log.i("MicroMsg.LuckyMoneyExclusiveSelectContactUI", "find same display name: %s", displayName);
                    z = true;
                    break;
                }
            }
            if (z) {
                h.a((Context) getContext(), getString(R.string.ep6), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213398);
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", anH.contact.field_username);
                        LuckyMoneyExclusiveSelectContactUI.this.setResult(-1, intent);
                        LuckyMoneyExclusiveSelectContactUI.this.finish();
                        AppMethodBeat.o(213398);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(213407);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", anH.contact.field_username);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(213407);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(213408);
        c.a aVar = new c.a();
        aVar.PTX = Util.listToString(this.jWf, ",");
        aVar.dFl = this.chatroomName;
        aVar.PTS = true;
        com.tencent.mm.ui.contact.c cVar = new com.tencent.mm.ui.contact.c(this, this.gzY, false, aVar, (byte) 0);
        AppMethodBeat.o(213408);
        return cVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(213409);
        a aVar = new a(this, this.gzY, this.chatroomName);
        AppMethodBeat.o(213409);
        return aVar;
    }

    public static class a extends s {
        private String chatroomName;
        private Cursor jWh;
        private String[] jWi;
        private String query;

        public a(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, String str) {
            super(mMBaseSelectContactUI, list, false, mMBaseSelectContactUI.scene);
            AppMethodBeat.i(213399);
            this.chatroomName = str;
            List<String> Kh = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(this.chatroomName);
            if (Kh != null) {
                Kh.remove(z.aTY());
                this.jWi = Util.listToStrings(Kh);
            }
            AppMethodBeat.o(213399);
        }

        @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.o
        public final void b(String str, int[] iArr) {
            AppMethodBeat.i(213400);
            Log.i("MicroMsg.SelectSearchContactItemByChatroom", "doSearch: %s", str);
            clearCache();
            this.query = str;
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(z.aTY());
            if (!Util.isNullOrNil(this.query) && this.jWi != null) {
                g.aAi();
                this.jWh = ((l) g.af(l.class)).aSN().a(this.jWi, "@all.chatroom", this.query, new LinkedList(), arrayList);
            }
            notifyDataSetChanged();
            ds(str, true);
            AppMethodBeat.o(213400);
        }

        @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
        public final com.tencent.mm.ui.contact.a.a va(int i2) {
            AppMethodBeat.i(213401);
            e eVar = null;
            if (this.jWh.moveToPosition(i2)) {
                as asVar = new as();
                asVar.convertFrom(this.jWh);
                eVar = new e(i2);
                eVar.contact = asVar;
                if (as.bjp(asVar.field_username)) {
                    eVar.Qab = true;
                }
            }
            AppMethodBeat.o(213401);
            return eVar;
        }

        @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
        public final void finish() {
            AppMethodBeat.i(213402);
            super.finish();
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            AppMethodBeat.o(213402);
        }

        @Override // com.tencent.mm.ui.contact.s
        public final int getCount() {
            AppMethodBeat.i(213403);
            if (this.jWh == null) {
                AppMethodBeat.o(213403);
                return 0;
            }
            int count = this.jWh.getCount();
            AppMethodBeat.o(213403);
            return count;
        }
    }
}
