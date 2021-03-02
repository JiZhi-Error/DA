package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private List<String> gzY;
    private HashSet<String> jVV;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(SnsAddressUI snsAddressUI) {
        AppMethodBeat.i(38061);
        snsAddressUI.ani();
        AppMethodBeat.o(38061);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(38050);
        super.amZ();
        this.gzY = new ArrayList();
        ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(getIntent().getStringExtra("Block_list"), "").split(","));
        HashSet<String> gVb = u.gVb();
        gVb.addAll(stringsToList);
        this.gzY.addAll(gVb);
        this.gzY.addAll(u.gVc());
        this.jVV = new HashSet<>();
        String nullAs = Util.nullAs(getIntent().getStringExtra("Select_Contact"), "");
        if (!Util.isNullOrNil(nullAs)) {
            this.jVV.addAll(Util.stringsToList(nullAs.split(",")));
        }
        AppMethodBeat.o(38050);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38051);
        super.onCreate(bundle);
        Log.i("MicroMsg.SnsAddressUI", "Create!");
        addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SnsAddressUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38047);
                Intent intent = new Intent();
                ArrayList<String> stringsToList = Util.stringsToList((String[]) SnsAddressUI.this.jVV.toArray(new String[0]));
                if (stringsToList == null || stringsToList.size() == 0) {
                    intent.putExtra("Select_Contact", "");
                } else {
                    intent.putExtra("Select_Contact", Util.listToString(stringsToList, ","));
                }
                SnsAddressUI.this.setResult(-1, intent);
                SnsAddressUI.this.finish();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.contact.SnsAddressUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(38046);
                        if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                            SnsAddressUI.this.moveTaskToBack(true);
                        }
                        AppMethodBeat.o(38046);
                    }
                }, 100);
                SnsAddressUI.this.hideVKB();
                AppMethodBeat.o(38047);
                return true;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SnsAddressUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38048);
                SnsAddressUI.this.finish();
                if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    SnsAddressUI.this.moveTaskToBack(true);
                }
                AppMethodBeat.o(38048);
                return true;
            }
        });
        Iterator<String> it = this.jVV.iterator();
        while (it.hasNext()) {
            this.zoy.bev(it.next());
        }
        this.zoy.setOnContactDeselectListener(new MultiSelectContactView.c() {
            /* class com.tencent.mm.ui.contact.SnsAddressUI.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
            public final void T(int i2, String str) {
                AppMethodBeat.i(38049);
                if (i2 == 1 && str != null) {
                    SnsAddressUI.this.jVV.remove(str);
                    SnsAddressUI.b(SnsAddressUI.this);
                }
                AppMethodBeat.o(38049);
            }
        });
        ani();
        AppMethodBeat.o(38051);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234093);
        p gUP = gUP();
        a anH = gUP.getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(234093);
        } else if (anH.contact == null) {
            AppMethodBeat.o(234093);
        } else {
            Log.i("MicroMsg.SnsAddressUI", "ClickUser=%s", anH.contact.field_username);
            String str = anH.contact.field_username;
            gUW();
            if (this.jVV.contains(str)) {
                this.jVV.remove(str);
                this.zoy.bev(str);
            } else if (this.jVV.size() < aq.NSd) {
                this.jVV.add(str);
                this.zoy.bev(str);
            } else {
                Toast.makeText(this, (int) R.string.h8p, 0).show();
                Log.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", Integer.valueOf(aq.NSd));
            }
            ani();
            gUP.notifyDataSetChanged();
            AppMethodBeat.o(234093);
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
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(38053);
        String nullAs = Util.nullAs(getIntent().getStringExtra("Add_address_titile"), "");
        AppMethodBeat.o(38053);
        return nullAs;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(38054);
        c.a aVar = new c.a();
        aVar.PTM = true;
        aVar.PTV = true;
        aVar.customHeader = getString(R.string.fm);
        aVar.PTW = Util.nullAs(getIntent().getStringExtra("Add_get_from_sns"), "");
        aVar.PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        c cVar = new c(this, this.gzY, true, aVar, (byte) 0);
        AppMethodBeat.o(38054);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(38055);
        s sVar = new s(this, this.gzY, true, this.scene);
        AppMethodBeat.o(38055);
        return sVar;
    }

    private void ani() {
        String format;
        boolean z;
        AppMethodBeat.i(38056);
        if (this.jVV.size() == 0) {
            format = String.format("%s", getString(R.string.x_));
        } else {
            format = String.format("%s(%d/%d)", getString(R.string.x_), Integer.valueOf(this.jVV.size()), Integer.valueOf(aq.NSd));
        }
        updateOptionMenuText(1, format);
        if (this.jVV.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
        AppMethodBeat.o(38056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(38057);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(38057);
            return;
        }
        switch (i2) {
            case 3:
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!Util.isNullOrNil(stringExtra)) {
                    Log.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    for (String str : split) {
                        if (this.jVV.add(str)) {
                            this.zoy.bev(str);
                        }
                    }
                    ani();
                    gUP().notifyDataSetChanged();
                    break;
                } else {
                    Log.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                    AppMethodBeat.o(38057);
                    return;
                }
        }
        AppMethodBeat.o(38057);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean eim() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void aDT(String str) {
        AppMethodBeat.i(38058);
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.jVV);
        intent.putExtra("always_select_contact", Util.listToString(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", u.Q(16384, 64));
        startActivityForResult(intent, 3);
        AppMethodBeat.o(38058);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131072};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(38060);
        if (i2 == 1) {
            this.jVV.remove(str);
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(38060);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(a aVar) {
        AppMethodBeat.i(38059);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(38059);
            return false;
        }
        boolean contains = this.jVV.contains(aVar.contact.field_username);
        AppMethodBeat.o(38059);
        return contains;
    }
}
