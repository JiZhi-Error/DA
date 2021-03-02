package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private List<String> CuD;
    private List<String> Cxk;
    private int fromScene;
    private List<String> gzY;
    private String title;
    private View zjf;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68334);
        super.onCreate(bundle);
        AppMethodBeat.o(68334);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(68335);
        super.amZ();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        Log.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(stringExtra)));
        this.CuD = new ArrayList();
        if (!Util.isNullOrNil(stringExtra)) {
            this.CuD = Util.stringsToList(stringExtra.split(","));
        }
        if (bmE()) {
            this.title = getIntent().getStringExtra("key_title");
            String stringExtra2 = getIntent().getStringExtra("key_include_username_list");
            this.Cxk = new ArrayList();
            if (!Util.isNullOrNil(stringExtra2)) {
                this.Cxk = Util.stringsToList(stringExtra2.split(","));
            }
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(u.gVb());
        hashSet.addAll(u.gVc());
        String stringExtra3 = getIntent().getStringExtra("Select_block_List");
        if (!Util.isNullOrNil(stringExtra3)) {
            hashSet.addAll(Util.stringsToList(stringExtra3.split(",")));
        }
        this.gzY = new ArrayList();
        this.gzY.addAll(hashSet);
        AppMethodBeat.o(68335);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(68336);
        g gVar = new g(this, this.CuD, this.gzY, this.fromScene);
        AppMethodBeat.o(68336);
        return gVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(68337);
        s sVar = new s(this, this.gzY, false, this.scene);
        AppMethodBeat.o(68337);
        return sVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        if (this.fromScene == 1 || this.fromScene == 3) {
            return new int[]{131072, 131075};
        }
        return new int[]{131072};
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0173  */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(android.view.View r11, int r12) {
        /*
        // Method dump skipped, instructions count: 424
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.M(android.view.View, int):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68339);
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = " + intent.toString());
        } else {
            Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i2 + ", resultCode = " + i3 + ", data = null");
        }
        if (i2 == 1) {
            if (i3 == -1) {
                Log.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
                if (bmE()) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        aMp(stringExtra);
                    }
                    AppMethodBeat.o(68339);
                    return;
                }
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(68339);
            return;
        }
        Log.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(68339);
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
        AppMethodBeat.i(68340);
        if (this.fromScene == 1 || this.fromScene == 3) {
            String string = getString(R.string.isa);
            AppMethodBeat.o(68340);
            return string;
        }
        String string2 = getString(R.string.g4o);
        AppMethodBeat.o(68340);
        return string2;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(68341);
        super.a(listView, i2);
        if (this.zjf == null) {
            View inflate = View.inflate(this, R.layout.bph, null);
            this.zjf = inflate.findViewById(R.id.be9);
            TextView textView = (TextView) inflate.findViewById(R.id.ior);
            if (this.fromScene == 1 || this.fromScene == 3) {
                textView.setText(R.string.is4);
            } else {
                textView.setText(R.string.g3l);
            }
            listView.addHeaderView(inflate);
        }
        this.zjf.setVisibility(i2);
        AppMethodBeat.o(68341);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void egJ() {
        AppMethodBeat.i(68342);
        super.egJ();
        hideVKB();
        AppMethodBeat.o(68342);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68343);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.o(68343);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(68343);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68344);
        if (i2 == 4) {
            egJ();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(68344);
        return onKeyUp;
    }

    private boolean bmE() {
        return this.fromScene == 3;
    }

    private void aMp(String str) {
        AppMethodBeat.i(68345);
        Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
        if (!bmE()) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", str);
            setResult(-1, intent);
            finish();
            hideVKB();
            AppMethodBeat.o(68345);
        } else if (ab.Eq(str)) {
            List<String> SA = SA(str);
            if (!aS(SA)) {
                eOo();
                Log.e("MicroMsg.SelectRemittanceContactUI", "self no in chatroom(%s)", str);
                AppMethodBeat.o(68345);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : this.Cxk) {
                if (SA.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() == 0) {
                eOo();
                AppMethodBeat.o(68345);
            } else if (arrayList.size() == this.Cxk.size()) {
                b(str, arrayList, this.title);
                AppMethodBeat.o(68345);
            } else {
                a(str, arrayList, arrayList.size());
                AppMethodBeat.o(68345);
            }
        } else if (!this.Cxk.contains(str)) {
            eOo();
            AppMethodBeat.o(68345);
        } else if (this.Cxk.size() == 1) {
            String str3 = this.title;
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str);
            b(str, arrayList2, str3);
            AppMethodBeat.o(68345);
        } else {
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add(str);
            a(str, arrayList3, 1);
            AppMethodBeat.o(68345);
        }
    }

    private void a(final String str, final ArrayList<String> arrayList, int i2) {
        AppMethodBeat.i(68346);
        uZ(17);
        h.a((Context) this, getString(R.string.is7, new Object[]{Integer.valueOf(i2)}), "", getString(R.string.is6), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68330);
                Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ok");
                SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, str, arrayList);
                AppMethodBeat.o(68330);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68331);
                Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() cancel");
                AppMethodBeat.o(68331);
            }
        });
        AppMethodBeat.o(68346);
    }

    private void eOo() {
        AppMethodBeat.i(68347);
        uZ(16);
        h.a((Context) this, getString(R.string.is8), "", getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68332);
                Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick()");
                AppMethodBeat.o(68332);
            }
        });
        AppMethodBeat.o(68347);
    }

    private void b(final String str, final ArrayList<String> arrayList, String str2) {
        AppMethodBeat.i(68348);
        Log.i("MicroMsg.SelectRemittanceContactUI", "showLaunchComfirmDialog()");
        if (Util.isNullOrNil(str2)) {
            str2 = getString(R.string.ecy);
        }
        ((j) g.af(j.class)).a(getController(), str, getString(R.string.x) + str2, getString(R.string.w), new y.a() {
            /* class com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(68333);
                if (z) {
                    SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, str, arrayList);
                    SelectRemittanceContactUI.uZ(12);
                    AppMethodBeat.o(68333);
                    return;
                }
                SelectRemittanceContactUI.uZ(13);
                AppMethodBeat.o(68333);
            }
        });
        uZ(11);
        AppMethodBeat.o(68348);
    }

    private static List<String> SA(String str) {
        AppMethodBeat.i(68349);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.SelectRemittanceContactUI", "illegal chatroomName");
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(68349);
            return arrayList;
        } else if (!ab.Eq(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(z.aTY());
            arrayList2.add(str);
            AppMethodBeat.o(68349);
            return arrayList2;
        } else {
            try {
                List<String> Kh = ((c) g.af(c.class)).aSX().Kh(str);
                if (Kh == null) {
                    Kh = new ArrayList<>();
                }
                AppMethodBeat.o(68349);
                return Kh;
            } catch (Exception e2) {
                Log.e("MicroMsg.SelectRemittanceContactUI", "getChatroomMemberList error! %s", e2.getMessage());
                ArrayList arrayList3 = new ArrayList();
                AppMethodBeat.o(68349);
                return arrayList3;
            }
        }
    }

    private static boolean aS(List<String> list) {
        boolean z;
        AppMethodBeat.i(68350);
        if (list == null) {
            AppMethodBeat.o(68350);
            return false;
        }
        Iterator<String> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (Util.isEqual(it.next(), z.aTY())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        AppMethodBeat.o(68350);
        return z;
    }

    public static void uZ(int i2) {
        AppMethodBeat.i(68351);
        es esVar = new es();
        esVar.eEr = (long) i2;
        esVar.bfK();
        AppMethodBeat.o(68351);
    }

    static /* synthetic */ void a(SelectRemittanceContactUI selectRemittanceContactUI, String str, ArrayList arrayList) {
        AppMethodBeat.i(68352);
        lq lqVar = new lq();
        lqVar.dQX.context = selectRemittanceContactUI;
        lqVar.dQX.dQZ = arrayList;
        lqVar.dQX.dRa = str;
        EventCenter.instance.publish(lqVar);
        AppMethodBeat.o(68352);
    }
}
