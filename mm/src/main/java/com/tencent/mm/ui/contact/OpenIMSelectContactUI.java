package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.t;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI extends MMBaseSelectContactUI {
    private int PSP;
    private HashSet<String> PYm;
    private HashSet<String> PYn;
    private int PYo;
    private boolean PYp = true;
    private SelectContactUI.a PYq = new SelectContactUI.a();
    private String dNI;
    private List<String> gzY;
    private HashSet<String> jVV;
    private String title;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OpenIMSelectContactUI() {
        AppMethodBeat.i(37946);
        AppMethodBeat.o(37946);
    }

    static /* synthetic */ boolean a(OpenIMSelectContactUI openIMSelectContactUI, List list, List list2) {
        AppMethodBeat.i(37960);
        boolean D = openIMSelectContactUI.D(list, list2);
        AppMethodBeat.o(37960);
        return D;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37947);
        super.onCreate(bundle);
        if (u.hasAttr(this.PYo, 64)) {
            addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.contact.OpenIMSelectContactUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(37945);
                    ArrayList a2 = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.this.PYo, 8192));
                    a2.remove(z.aTY());
                    ArrayList arrayList = new ArrayList(OpenIMSelectContactUI.this.PYn);
                    arrayList.removeAll(a2);
                    boolean a3 = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, a2, arrayList);
                    AppMethodBeat.o(37945);
                    return a3;
                }
            }, null, t.b.GREEN);
        }
        ani();
        Iterator<String> it = this.jVV.iterator();
        while (it.hasNext()) {
            bev(it.next());
        }
        AppMethodBeat.o(37947);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(37948);
        super.amZ();
        this.dNI = getIntent().getStringExtra("openim_appid");
        this.title = getIntent().getStringExtra("titile");
        this.PSP = getIntent().getIntExtra("list_type", -1);
        this.PYo = getIntent().getIntExtra("list_attr", u.PWR);
        this.gzY = new ArrayList();
        this.jVV = new HashSet<>();
        this.PYn = new HashSet<>();
        this.PYm = new HashSet<>();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.PYm.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        String stringExtra2 = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(stringExtra2)) {
            this.jVV.addAll(Util.stringsToList(stringExtra2.split(",")));
            this.PYn.addAll(this.jVV);
        }
        HashSet hashSet = new HashSet();
        String stringExtra3 = getIntent().getStringExtra("block_contact");
        if (!Util.isNullOrNil(stringExtra3)) {
            hashSet.addAll(Util.stringsToList(stringExtra3.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(u.gVb());
        hashSet2.addAll(u.gVc());
        this.gzY.addAll(hashSet2);
        AppMethodBeat.o(37948);
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
        AppMethodBeat.i(37949);
        if (Util.isNullOrNil(this.title)) {
            this.title = ((a) g.af(a.class)).a(this.dNI, "openim_acct_type_title", a.EnumC0497a.TYPE_WORDING);
        }
        String str = this.title;
        AppMethodBeat.o(37949);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(37950);
        aa aaVar = new aa(this.dNI, this, this.gzY, u.hasAttr(this.PYo, 64));
        AppMethodBeat.o(37950);
        return aaVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(37951);
        s sVar = new s(this, this.gzY, u.hasAttr(this.PYo, 64), this.scene);
        AppMethodBeat.o(37951);
        return sVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        int i3 = 0;
        AppMethodBeat.i(234016);
        int headerViewsCount = i2 - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            Log.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i2));
            AppMethodBeat.o(234016);
            return;
        }
        com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
        if (anH == null) {
            AppMethodBeat.o(234016);
        } else if (anH.contact == null) {
            AppMethodBeat.o(234016);
        } else if (anH.contact.field_deleteFlag == 1) {
            AppMethodBeat.o(234016);
        } else {
            String str = anH.contact.field_username;
            Log.i("OpenIMSelectContactUI", "ClickUser=%s", str);
            if (u.hasAttr(this.PYo, 64)) {
                if (!u.hasAttr(this.PYo, 131072) || this.jVV.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    if (!this.PYm.contains(str)) {
                        gUW();
                        bev(str);
                        if (this.jVV.contains(str)) {
                            this.jVV.remove(str);
                        } else {
                            this.jVV.add(str);
                        }
                    }
                } else if (!this.PYm.contains(str)) {
                    gUW();
                    if (this.jVV.contains(str)) {
                        bev(str);
                        this.jVV.remove(str);
                    } else {
                        String stringExtra = getIntent().getStringExtra("too_many_member_tip_string");
                        if (Util.isNullOrNil(stringExtra)) {
                            stringExtra = getString(R.string.ghv, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        h.d(getContext(), stringExtra, "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.contact.OpenIMSelectContactUI.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                }
                ani();
                if (this.PYp && (this.PSP == 1 || this.PSP == 0)) {
                    int size = this.PYm != null ? this.PYm.size() : 0;
                    if (this.jVV != null) {
                        i3 = this.jVV.size();
                    }
                    this.PYq.e(this, size + i3, Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomInviteStartCount")));
                }
                gUQ().notifyDataSetChanged();
                AppMethodBeat.o(234016);
                return;
            }
            D(Util.stringsToList(new String[]{str}), new ArrayList(0));
            AppMethodBeat.o(234016);
        }
    }

    private void ani() {
        AppMethodBeat.i(37953);
        if (!u.hasAttr(this.PYo, 64) || this.jVV.size() <= 0) {
            updateOptionMenuText(1, getString(R.string.t1));
            enableOptionMenu(1, false);
            AppMethodBeat.o(37953);
            return;
        }
        updateOptionMenuText(1, getString(R.string.t1) + "(" + this.jVV.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!u.hasAttr(this.PYo, TPMediaCodecProfileLevel.HEVCMainTierLevel52) || this.jVV.size() >= intExtra) {
            enableOptionMenu(1, true);
            AppMethodBeat.o(37953);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.o(37953);
    }

    private void bev(String str) {
        AppMethodBeat.i(37954);
        if (this.zoy == null) {
            AppMethodBeat.o(37954);
            return;
        }
        this.zoy.bev(str);
        AppMethodBeat.o(37954);
    }

    private boolean D(List<String> list, List<String> list2) {
        AppMethodBeat.i(37955);
        Log.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", list, list2);
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", Util.listToString(list, ","));
        intent.putExtra("Cancel_Select_Contact", Util.listToString(list2, ","));
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(37955);
        return true;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(37956);
        if (i2 == 1) {
            this.jVV.remove(str);
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(37956);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean gUY() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(37957);
        if (aVar.PWh && aVar.contact != null) {
            boolean contains = this.jVV.contains(aVar.contact.field_username);
            AppMethodBeat.o(37957);
            return contains;
        } else if (aVar.PWi && aVar.contact != null) {
            boolean contains2 = this.jVV.contains(aVar.contact.field_username);
            AppMethodBeat.o(37957);
            return contains2;
        } else if (aVar instanceof k) {
            boolean isEmpty = this.jVV.isEmpty();
            AppMethodBeat.o(37957);
            return isEmpty;
        } else {
            AppMethodBeat.o(37957);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(37958);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(37958);
            return false;
        }
        boolean contains = this.PYm.contains(aVar.contact.field_username);
        AppMethodBeat.o(37958);
        return contains;
    }

    static /* synthetic */ ArrayList a(OpenIMSelectContactUI openIMSelectContactUI, boolean z) {
        AppMethodBeat.i(37959);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<String> it = openIMSelectContactUI.jVV.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (z || !ab.IQ(next)) {
                hashSet.add(next);
            } else {
                List<String> Id = v.Id(next);
                if (Id != null) {
                    for (String str : Id) {
                        hashSet.add(str);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(37959);
        return arrayList;
    }
}
