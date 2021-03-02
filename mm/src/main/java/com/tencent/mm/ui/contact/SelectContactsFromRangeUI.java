package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.pay.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.t;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI extends MMBaseSelectContactUI implements i {
    private int PSP;
    private String PSf;
    private a PZB;
    private b PZC;
    private String[] PZD;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        t.b bVar;
        AppMethodBeat.i(234082);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactsFromRangeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234069);
                SelectContactsFromRangeUI.this.finish();
                AppMethodBeat.o(234069);
                return false;
            }
        });
        String string = getString(R.string.x_);
        AnonymousClass2 r3 = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactsFromRangeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234070);
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", Util.listToString(SelectContactsFromRangeUI.this.PZB.PXY, ","));
                SelectContactsFromRangeUI.this.setResult(-1, intent);
                SelectContactsFromRangeUI.this.finish();
                AppMethodBeat.o(234070);
                return true;
            }
        };
        if (this.PSP == 16) {
            bVar = t.b.RED;
        } else {
            bVar = t.b.GREEN;
        }
        addTextOptionMenu(1, string, r3, null, bVar);
        enableOptionMenu(1, false);
        g.aAi();
        g.aAg().hqi.a(d.CTRL_INDEX, this);
        AppMethodBeat.o(234082);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(234083);
        super.amZ();
        this.PSP = getIntent().getIntExtra("list_type", 0);
        this.PSf = getIntent().getStringExtra("filter_type");
        this.PZD = getIntent().getStringArrayExtra("already_select_contact");
        this.PZB = new a(this, getIntent().getIntExtra("max_limit_num", 30));
        this.PZB.PWh = true;
        this.PZC = new b(this, this.PZB);
        AppMethodBeat.o(234083);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(234084);
        g.aAi();
        g.aAg().hqi.b(d.CTRL_INDEX, this);
        this.PZB.finish();
        super.onDestroy();
        AppMethodBeat.o(234084);
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
        AppMethodBeat.i(234085);
        String string = getString(R.string.g4);
        AppMethodBeat.o(234085);
        return string;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        return this.PZB;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        return this.PZC;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public Activity getActivity() {
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0108  */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(android.view.View r12, int r13) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.SelectContactsFromRangeUI.M(android.view.View, int):void");
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(234087);
        if (!(aVar instanceof e)) {
            AppMethodBeat.o(234087);
            return false;
        } else if (this.PSP == 16 || !aVar.contact.arD()) {
            AppMethodBeat.o(234087);
            return false;
        } else {
            AppMethodBeat.o(234087);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(234088);
        if (aVar instanceof e) {
            boolean contains = this.PZB.PXY.contains(((e) aVar).username);
            AppMethodBeat.o(234088);
            return contains;
        }
        AppMethodBeat.o(234088);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(234089);
        Log.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " " + qVar.getType());
        AppMethodBeat.o(234089);
    }

    class b extends o {
        private a PZG;

        public b(n nVar, a aVar) {
            super(nVar, false, 0);
            this.PZG = aVar;
        }

        @Override // com.tencent.mm.ui.contact.o
        public final void b(String str, int[] iArr) {
            AppMethodBeat.i(234078);
            this.PZG.ayM(str);
            if (this.PWf != null) {
                this.PWf.B(str, getCount(), true);
            }
            AppMethodBeat.o(234078);
        }

        @Override // com.tencent.mm.ui.contact.o
        public final void clearData() {
            AppMethodBeat.i(234079);
            this.PZG.ayM("");
            AppMethodBeat.o(234079);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.contact.p
        public final com.tencent.mm.ui.contact.a.a va(int i2) {
            AppMethodBeat.i(234080);
            com.tencent.mm.ui.contact.a.a va = this.PZG.va(i2);
            AppMethodBeat.o(234080);
            return va;
        }

        public final int getCount() {
            AppMethodBeat.i(234081);
            int count = this.PZG.getCount();
            AppMethodBeat.o(234081);
            return count;
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends q {
        private HashMap<String, Integer> PTD = new HashMap<>();
        private SparseArray<String> PTE = new SparseArray<>();
        List<String> PXY = new LinkedList();
        private Cursor jWh;
        private String query = "";
        int wnd;

        public a(n nVar, int i2) {
            super(nVar, null, true, false);
            AppMethodBeat.i(234071);
            this.wnd = i2;
            and();
            AppMethodBeat.o(234071);
        }

        public final void ayM(String str) {
            AppMethodBeat.i(234072);
            if (!this.query.equalsIgnoreCase(str)) {
                this.query = str;
            }
            and();
            AppMethodBeat.o(234072);
        }

        @Override // com.tencent.mm.ui.contact.q
        public final void and() {
            int i2 = 0;
            AppMethodBeat.i(234073);
            super.and();
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            this.PTD.clear();
            this.PTE.clear();
            if (("@all.contact.android".equals(SelectContactsFromRangeUI.this.PSf) || "@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.this.PSf)) && (SelectContactsFromRangeUI.this.PZD == null || SelectContactsFromRangeUI.this.PZD.length == 0)) {
                AppMethodBeat.o(234073);
                return;
            }
            g.aAi();
            this.jWh = ((l) g.af(l.class)).aSN().d(SelectContactsFromRangeUI.this.PZD, this.query, SelectContactsFromRangeUI.this.PSf, "", this.gzY);
            String[] a2 = ab.a(SelectContactsFromRangeUI.this.PZD, SelectContactsFromRangeUI.this.PSf, "", this.query, this.gzY);
            int[] a3 = ab.a(SelectContactsFromRangeUI.this.PZD, SelectContactsFromRangeUI.this.PSf, "", this.gzY, this.query);
            if (!(a2 == null || a3 == null)) {
                for (int i3 = 0; i3 < a2.length; i3++) {
                    if (i3 < a3.length) {
                        this.PTD.put(a2[i3], Integer.valueOf(a3[i3] + i2));
                        this.PTE.put(a3[i3] + i2, a2[i3]);
                        i2++;
                    } else {
                        i2 = i2;
                    }
                }
            }
            clearCache();
            notifyDataSetChanged();
            AppMethodBeat.o(234073);
        }

        @Override // com.tencent.mm.ui.contact.q
        public final int bnr(String str) {
            AppMethodBeat.i(234074);
            if (this.PTD == null) {
                AppMethodBeat.o(234074);
                return -1;
            } else if (this.PTD.containsKey(str)) {
                int intValue = this.PTD.get(str).intValue() + this.PWg.getContentLV().getHeaderViewsCount();
                AppMethodBeat.o(234074);
                return intValue;
            } else {
                AppMethodBeat.o(234074);
                return -1;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.contact.p
        public final com.tencent.mm.ui.contact.a.a va(int i2) {
            AppMethodBeat.i(234075);
            if (this.PTE.indexOfKey(i2) >= 0) {
                h hVar = new h(i2);
                hVar.header = this.PTE.get(i2);
                AppMethodBeat.o(234075);
                return hVar;
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 <= this.PTE.size()) {
                if (this.PTE.indexOfKey(i4) >= 0) {
                    i3++;
                }
                i4--;
                if (i4 < 0) {
                    break;
                }
            }
            int i5 = i2 - i3;
            if (this.jWh.moveToPosition(i5)) {
                Log.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
                as asVar = new as();
                asVar.convertFrom(this.jWh);
                e eVar = new e(i2);
                eVar.contact = asVar;
                if (ab.Eq(asVar.field_username)) {
                    eVar.PWh = false;
                    eVar.PWi = false;
                    eVar.Qaa = false;
                    eVar.Qap = true;
                } else {
                    eVar.PWh = eWh();
                    eVar.PWi = this.PWi;
                    eVar.Qap = false;
                }
                AppMethodBeat.o(234075);
                return eVar;
            }
            Log.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
            AppMethodBeat.o(234075);
            return null;
        }

        public final int getCount() {
            int i2 = 0;
            AppMethodBeat.i(234076);
            if (this.jWh == null) {
                AppMethodBeat.o(234076);
                return 0;
            }
            int count = this.jWh.getCount();
            if (this.PTE != null) {
                i2 = this.PTE.size();
            }
            int i3 = i2 + count;
            AppMethodBeat.o(234076);
            return i3;
        }

        @Override // com.tencent.mm.ui.contact.p
        public final void finish() {
            AppMethodBeat.i(234077);
            super.finish();
            Log.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
            if (this.jWh != null) {
                this.jWh.close();
                this.jWh = null;
            }
            AppMethodBeat.o(234077);
        }
    }
}
