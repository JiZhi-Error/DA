package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private List<String> gzY;
    private Button zov;
    private List<String> zow;
    private boolean zox;
    private MultiSelectContactView zoy;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MassSendSelectContactUI massSendSelectContactUI, int i2) {
        AppMethodBeat.i(26511);
        massSendSelectContactUI.Ql(i2);
        AppMethodBeat.o(26511);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(26501);
        super.amZ();
        this.gzY = new ArrayList();
        this.gzY.addAll(u.gVb());
        this.gzY.addAll(u.gVc());
        this.gzY.add(z.aTY());
        this.zow = new LinkedList();
        AppMethodBeat.o(26501);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26502);
        super.onCreate(bundle);
        Log.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.zoy = super.zoy;
        if (this.zoy == null) {
            finish();
            AppMethodBeat.o(26502);
            return;
        }
        this.zoy.setBackgroundDrawable(null);
        addTextOptionMenu(1, getString(R.string.eyd), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26498);
                Log.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
                ArrayList<String> stringsToList = Util.stringsToList((String[]) MassSendSelectContactUI.this.zow.toArray(new String[0]));
                if (stringsToList == null) {
                    Log.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                    AppMethodBeat.o(26498);
                    return false;
                }
                stringsToList.remove(z.aTY());
                String listToString = Util.listToString(stringsToList, ";");
                Intent intent = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
                intent.putExtra("mass_send_contact_list", listToString);
                MassSendSelectContactUI massSendSelectContactUI = MassSendSelectContactUI.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(massSendSelectContactUI, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                massSendSelectContactUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(massSendSelectContactUI, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(26498);
                return true;
            }
        }, null, t.b.GREEN);
        this.zov = (Button) findViewById(R.id.hh1);
        this.zov.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(26499);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
                p pVar = (p) ((HeaderViewListAdapter) MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
                if (!MassSendSelectContactUI.this.zox) {
                    MassSendSelectContactUI.this.zov.setText(R.string.ey3);
                    int count = pVar.getCount();
                    for (int i2 = 0; i2 < count; i2++) {
                        com.tencent.mm.ui.contact.a.a anH = pVar.getItem(i2);
                        if (!(anH == null || anH.contact == null)) {
                            MassSendSelectContactUI.this.zow.add(anH.contact.field_username);
                        }
                    }
                    MassSendSelectContactUI.this.zoy.it(MassSendSelectContactUI.this.zow);
                } else {
                    MassSendSelectContactUI.this.zov.setText(R.string.eye);
                    MassSendSelectContactUI.this.zoy.it(new LinkedList());
                    MassSendSelectContactUI.this.zow.clear();
                }
                MassSendSelectContactUI massSendSelectContactUI = MassSendSelectContactUI.this;
                massSendSelectContactUI.zox = !MassSendSelectContactUI.this.zox;
                MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.zow.size());
                pVar.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26499);
            }
        });
        this.zoy.setOnContactDeselectListener(new MultiSelectContactView.c() {
            /* class com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
            public final void T(int i2, String str) {
                AppMethodBeat.i(26500);
                if (i2 == 1 && str != null) {
                    MassSendSelectContactUI.this.zow.remove(str);
                    MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.this.zow.size());
                }
                AppMethodBeat.o(26500);
            }
        });
        Ql(this.zow.size());
        AppMethodBeat.o(26502);
    }

    private void Ql(int i2) {
        AppMethodBeat.i(26503);
        if (i2 > 0) {
            updateOptionMenuText(1, getString(R.string.eyd) + "(" + this.zow.size() + ")");
            enableOptionMenu(1, true);
            AppMethodBeat.o(26503);
            return;
        }
        updateOptionMenuText(1, getString(R.string.eyd));
        enableOptionMenu(1, false);
        AppMethodBeat.o(26503);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void aDT(String str) {
        AppMethodBeat.i(26504);
        h.INSTANCE.a(11225, 1, 0);
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", Util.listToString(new ArrayList(this.zow), ","));
        intent.putExtra("list_attr", u.Q(16384, 64));
        c.c(this, ".ui.contact.SelectLabelContactUI", intent, 0);
        AppMethodBeat.o(26504);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26505);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(26505);
            return;
        }
        switch (i2) {
            case 0:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!Util.isNullOrNil(stringExtra)) {
                    Log.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    for (String str : split) {
                        if (this.zow.add(str)) {
                            this.zoy.bev(str);
                        }
                    }
                    Ql(this.zow.size());
                    gUP().notifyDataSetChanged();
                    if (this.gzP != null) {
                        this.gzP.clearFocus();
                        this.gzP.gXP();
                        break;
                    }
                } else {
                    Log.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                    AppMethodBeat.o(26505);
                    return;
                }
                break;
        }
        AppMethodBeat.o(26505);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6p;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(231765);
        p gUP = gUP();
        com.tencent.mm.ui.contact.a.a anH = gUP.getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(231765);
        } else if (anH.contact == null) {
            AppMethodBeat.o(231765);
        } else {
            Log.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", anH.contact.field_username);
            String str = anH.contact.field_username;
            gUW();
            if (this.zow.contains(str)) {
                this.zow.remove(str);
                this.zoy.bev(str);
            } else {
                this.zow.add(str);
                this.zoy.bev(str);
            }
            Ql(this.zow.size());
            gUP.notifyDataSetChanged();
            gUW();
            gUX();
            AppMethodBeat.o(231765);
        }
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
        AppMethodBeat.i(26507);
        String string = getString(R.string.eyf);
        AppMethodBeat.o(26507);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(26508);
        c.a aVar = new c.a();
        aVar.PTM = true;
        aVar.PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        com.tencent.mm.ui.contact.c cVar = new com.tencent.mm.ui.contact.c(this, this.gzY, true, aVar, (byte) 0);
        AppMethodBeat.o(26508);
        return cVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(26509);
        s sVar = new s(this, this.gzY, true, this.scene);
        AppMethodBeat.o(26509);
        return sVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131072};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean eim() {
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(26510);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(26510);
            return false;
        }
        boolean contains = this.zow.contains(aVar.contact.field_username);
        AppMethodBeat.o(26510);
        return contains;
    }
}
