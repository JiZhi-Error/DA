package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsSelectChatRoomUI extends MMBaseSelectContactUI {
    private HashSet<String> jVV = new HashSet<>();

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSelectChatRoomUI() {
        AppMethodBeat.i(98988);
        AppMethodBeat.o(98988);
    }

    static /* synthetic */ ArrayList a(SnsSelectChatRoomUI snsSelectChatRoomUI) {
        AppMethodBeat.i(99000);
        ArrayList<String> fiB = snsSelectChatRoomUI.fiB();
        AppMethodBeat.o(99000);
        return fiB;
    }

    private void ani() {
        AppMethodBeat.i(98989);
        if (this.jVV.size() > 0) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(98989);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(98989);
    }

    private ArrayList<String> fiB() {
        AppMethodBeat.i(98990);
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.jVV.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(98990);
        return arrayList;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98991);
        super.onCreate(bundle);
        addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98985);
                SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, (List) SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this));
                AppMethodBeat.o(98985);
                return true;
            }
        }, null, t.b.GREEN);
        ani();
        this.zoy.it(new ArrayList(this.jVV));
        AppMethodBeat.o(98991);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(98992);
        super.amZ();
        String stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            List<String> stringToList = Util.stringToList(stringExtra, ",");
            if (!Util.isNullOrNil(stringToList)) {
                this.jVV.addAll(stringToList);
            }
        }
        AppMethodBeat.o(98992);
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
        AppMethodBeat.i(98993);
        String string = getContext().getString(R.string.h7g);
        AppMethodBeat.o(98993);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(98994);
        a aVar = new a(this);
        aVar.ESo = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(98986);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() != null && (view.getTag() instanceof as)) {
                    SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, (as) view.getTag());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98986);
            }
        };
        AppMethodBeat.o(98994);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(98995);
        com.tencent.mm.plugin.sns.ui.a.b bVar = new com.tencent.mm.plugin.sns.ui.a.b(this);
        bVar.ESo = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(98987);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() != null && (view.getTag() instanceof as)) {
                    SnsSelectChatRoomUI.a(SnsSelectChatRoomUI.this, (as) view.getTag());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectChatRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98987);
            }
        };
        AppMethodBeat.o(98995);
        return bVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131075};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(98996);
        super.a(listView, i2);
        AppMethodBeat.o(98996);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(98997);
        if (i2 == 1) {
            this.jVV.remove(str);
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(98997);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(203628);
        int headerViewsCount = i2 - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            Log.i("MicroMsg.SnsSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i2));
            AppMethodBeat.o(203628);
            return;
        }
        com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
        if (anH == null) {
            AppMethodBeat.o(203628);
        } else if (anH.contact == null) {
            AppMethodBeat.o(203628);
        } else if (anH.contact.field_deleteFlag == 1) {
            AppMethodBeat.o(203628);
        } else {
            String str = anH.contact.field_username;
            gUW();
            this.zoy.bev(str);
            if (this.jVV.contains(str)) {
                this.jVV.remove(str);
            } else {
                this.jVV.add(str);
            }
            gUQ().notifyDataSetChanged();
            ani();
            AppMethodBeat.o(203628);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(98999);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(98999);
            return false;
        }
        boolean contains = this.jVV.contains(aVar.contact.field_username);
        AppMethodBeat.o(98999);
        return contains;
    }

    static /* synthetic */ void a(SnsSelectChatRoomUI snsSelectChatRoomUI, List list) {
        AppMethodBeat.i(99001);
        Log.i("MicroMsg.SnsSelectChatRoomUI", "sns post who can see scene,users=%s", list.toString());
        ArrayList<String> fiB = snsSelectChatRoomUI.fiB();
        fiB.remove(z.aTY());
        String listToString = Util.listToString(fiB, ",");
        Intent intent = new Intent();
        intent.putExtra("select_chatrooms", listToString);
        snsSelectChatRoomUI.setResult(-1, intent);
        snsSelectChatRoomUI.finish();
        snsSelectChatRoomUI.ani();
        snsSelectChatRoomUI.gUP().notifyDataSetChanged();
        AppMethodBeat.o(99001);
    }

    static /* synthetic */ void a(SnsSelectChatRoomUI snsSelectChatRoomUI, as asVar) {
        AppMethodBeat.i(99002);
        String str = asVar.field_username;
        int i2 = 0;
        Intent intent = new Intent(snsSelectChatRoomUI, SnsChatRoomMemberUI.class);
        List<String> Ic = v.Ic(str);
        if (Ic != null) {
            i2 = Ic.size();
        }
        intent.putExtra("RoomInfo_Id", str);
        intent.putExtra("room_member_count", i2);
        intent.putExtra("Add_address_titile", snsSelectChatRoomUI.getString(R.string.h7f));
        intent.putExtra("room_name", asVar.field_username);
        snsSelectChatRoomUI.startActivityForResult(intent, 1);
        e eVar = e.DUQ;
        Integer num = eVar.DVb.get(str);
        if (num == null) {
            eVar.DVb.put(str, 1);
            AppMethodBeat.o(99002);
            return;
        }
        eVar.DVb.put(str, Integer.valueOf(num.intValue() + 1));
        AppMethodBeat.o(99002);
    }
}
