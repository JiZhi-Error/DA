package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> gzY;
    private View zjf;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(65973);
        super.amZ();
        HashSet hashSet = new HashSet();
        hashSet.addAll(u.gVb());
        hashSet.addAll(u.gVc());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!Util.isNullOrNil(stringExtra)) {
            hashSet.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        this.gzY = new ArrayList();
        this.gzY.addAll(hashSet);
        AppMethodBeat.o(65973);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(213536);
        if (i2 < getContentLV().getHeaderViewsCount()) {
            Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i2));
            Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int Q = u.Q(16, 1, 2, 4, 16384, 64, 65536, 131072);
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", Q);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(R.string.ers, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(R.string.j20));
            c.c(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(R.anim.dq, R.anim.bs);
            AppMethodBeat.o(213536);
            return;
        }
        a aVar = (a) getContentLV().getAdapter().getItem(i2);
        if (aVar == null) {
            AppMethodBeat.o(213536);
            return;
        }
        as asVar = aVar.contact;
        if (asVar == null) {
            AppMethodBeat.o(213536);
            return;
        }
        String str = asVar.field_username;
        Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
        final Intent intent2 = new Intent();
        intent2.putExtra("Select_Conv_User", str);
        String str2 = null;
        if (ab.Eq(str)) {
            str2 = getString(R.string.is3, new Object[]{Integer.valueOf(v.Ie(str))});
        }
        ((j) g.af(j.class)).a(this.mController, str, getString(R.string.g5i), str, str2, getString(R.string.yq), new y.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(65972);
                if (z) {
                    SelectLuckyMoneyContactUI.this.setResult(-1, intent2);
                    SelectLuckyMoneyContactUI.this.finish();
                }
                AppMethodBeat.o(65972);
            }
        });
        AppMethodBeat.o(213536);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(65975);
        String string = getString(R.string.ert);
        AppMethodBeat.o(65975);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(65976);
        com.tencent.mm.ui.contact.ab abVar = new com.tencent.mm.ui.contact.ab(this, this.gzY);
        AppMethodBeat.o(65976);
        return abVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(65977);
        s sVar = new s(this, this.gzY, false, this.scene);
        AppMethodBeat.o(65977);
        return sVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131072};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(65978);
        super.a(listView, i2);
        if (this.zjf == null) {
            View inflate = View.inflate(this, R.layout.bph, null);
            this.zjf = inflate.findViewById(R.id.be9);
            ((TextView) inflate.findViewById(R.id.ior)).setText(R.string.epp);
            listView.addHeaderView(inflate);
        }
        this.zjf.setVisibility(i2);
        AppMethodBeat.o(65978);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(65979);
        super.egJ();
        hideVKB();
        AppMethodBeat.o(65979);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(65980);
        if (i2 == 4) {
            egJ();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(65980);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(65981);
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = " + intent.toString());
        } else {
            Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = null");
        }
        if (i2 == 1) {
            if (i3 == -1) {
                Log.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(65981);
            return;
        }
        Log.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(65981);
    }
}
