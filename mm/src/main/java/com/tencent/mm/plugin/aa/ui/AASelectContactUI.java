package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private ArrayList<String> jVS;
    private ArrayList<String> jVT;
    private HashSet<String> jVU;
    private HashSet<String> jVV;
    private long jVW;
    private int jVX;
    private CheckBox jVY;
    private View jVZ;
    private List<String> jWa;
    private List<String> jWb;
    private int scene;
    private String title;

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean c(AASelectContactUI aASelectContactUI) {
        AppMethodBeat.i(63546);
        boolean bmE = aASelectContactUI.bmE();
        AppMethodBeat.o(63546);
        return bmE;
    }

    static /* synthetic */ void h(AASelectContactUI aASelectContactUI) {
        AppMethodBeat.i(213012);
        aASelectContactUI.ani();
        AppMethodBeat.o(213012);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        int size;
        AppMethodBeat.i(63536);
        super.amZ();
        this.scene = getIntent().getIntExtra("enter_scene", 1);
        this.jVT = getIntent().getStringArrayListExtra("third_party_usernamelist");
        this.title = getIntent().getStringExtra("titile");
        this.jVW = getIntent().getLongExtra("max_select_num", 20);
        this.jVX = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!ab.Eq(this.chatroomName)) {
            Log.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.jVV = new HashSet<>();
        this.jVU = new HashSet<>();
        this.jVS = new ArrayList<>();
        this.jWb = new ArrayList();
        this.jWa = new ArrayList();
        if (ab.Iz(this.chatroomName)) {
            aR(i.SA(this.chatroomName));
        }
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.jVU.addAll(Arrays.asList(stringExtra.split(",")));
        }
        String stringExtra2 = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(stringExtra2)) {
            this.jVV.addAll(Util.stringsToList(stringExtra2.split(",")));
            ani();
        }
        this.jVS.addAll(this.jVV);
        this.jVY = (CheckBox) findViewById(R.id.irw);
        this.jVZ = findViewById(R.id.irx);
        this.jVZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass1 */

            public final void onClick(View view) {
                final List<String> list;
                AppMethodBeat.i(63530);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AASelectContactUI.this.jVY.isChecked()) {
                    if (AASelectContactUI.this.jVV != null) {
                        AASelectContactUI.this.jVV.clear();
                    } else {
                        AASelectContactUI.this.jVV = new HashSet();
                    }
                    AASelectContactUI.this.jVY.setChecked(false);
                    AASelectContactUI.this.gUP().notifyDataSetChanged();
                } else {
                    if (AASelectContactUI.c(AASelectContactUI.this)) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = AASelectContactUI.this.jVT.iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        list = arrayList;
                    } else if (!ab.Iz(AASelectContactUI.this.chatroomName)) {
                        list = i.SA(AASelectContactUI.this.chatroomName);
                    } else {
                        list = AASelectContactUI.this.jWa;
                    }
                    if (((long) list.size()) > AASelectContactUI.this.jVW) {
                        h.a(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(R.string.b3, new Object[]{Long.valueOf(AASelectContactUI.this.jVW)}), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(63529);
                                AASelectContactUI.a(AASelectContactUI.this, list);
                                AppMethodBeat.o(63529);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass1.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    } else {
                        AASelectContactUI.a(AASelectContactUI.this, (List) list);
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 6);
                a.a(this, "com/tencent/mm/plugin/aa/ui/AASelectContactUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63530);
            }
        });
        if (bmE()) {
            size = this.jVT.size();
        } else if (!ab.Iz(this.chatroomName)) {
            size = i.SA(this.chatroomName).size();
        } else {
            size = this.jWa.size();
        }
        if (this.jVV.size() == size) {
            this.jVY.setChecked(true);
        } else {
            this.jVY.setChecked(false);
        }
        this.jVY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(63531);
                AASelectContactUI.h(AASelectContactUI.this);
                AppMethodBeat.o(63531);
            }
        });
        AppMethodBeat.o(63536);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(63537);
        super.initView();
        addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63532);
                if (((long) AASelectContactUI.this.jVV.size()) > AASelectContactUI.this.jVW) {
                    h.c(AASelectContactUI.this.getContext(), AASelectContactUI.this.getString(R.string.ecq, new Object[]{Long.valueOf(AASelectContactUI.this.jVW)}), "", true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 8);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13722, 3);
                    AppMethodBeat.o(63532);
                } else if (AASelectContactUI.this.jVV.size() <= 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 9);
                    AppMethodBeat.o(63532);
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(AASelectContactUI.this.jVV);
                    AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", Util.listToString(linkedList, ",")));
                    AASelectContactUI.this.finish();
                    AASelectContactUI.this.hideVKB();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 8);
                    AppMethodBeat.o(63532);
                }
                return true;
            }
        }, null, t.b.GREEN);
        ani();
        this.zoy.setOnContactDeselectListener(this);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00e7  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(android.view.MenuItem r12) {
                /*
                // Method dump skipped, instructions count: 245
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.ui.AASelectContactUI.AnonymousClass4.onMenuItemClick(android.view.MenuItem):boolean");
            }
        });
        if (ab.Iz(this.chatroomName)) {
            View inflate = aa.jQ(getContext()).inflate(R.layout.ag, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.au);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 44);
            linearLayout.setPadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 15), 0, com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 8));
            linearLayout.setLayoutParams(layoutParams);
            inflate.findViewById(R.id.av).setVisibility(0);
            getContentLV().addHeaderView(inflate, null, false);
        }
        AppMethodBeat.o(63537);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63538);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.jVU.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        AppMethodBeat.o(63538);
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
        return this.title;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(63539);
        if (bmE()) {
            d dVar = new d(this, this.jVT);
            AppMethodBeat.o(63539);
            return dVar;
        }
        e eVar = new e(this, this.chatroomName);
        AppMethodBeat.o(63539);
        return eVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(63540);
        if (bmE()) {
            f fVar = new f(this, this.jVT);
            AppMethodBeat.o(63540);
            return fVar;
        }
        g gVar = new g(this, this.chatroomName);
        AppMethodBeat.o(63540);
        return gVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        int size;
        AppMethodBeat.i(213009);
        p gUP = gUP();
        com.tencent.mm.ui.contact.a.a anH = gUP.getItem(i2 - getContentLV().getHeaderViewsCount());
        if (anH == null) {
            AppMethodBeat.o(213009);
        } else if (anH.contact == null) {
            AppMethodBeat.o(213009);
        } else {
            Log.i("MicroMsg.AASelectContactUI", "ClickUser=%s", anH.contact.field_username);
            String str = anH.contact.field_username;
            if (as.bjp(str)) {
                AppMethodBeat.o(213009);
                return;
            }
            if (str.equals(z.aTY())) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 4);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 2, 5);
            }
            gUW();
            if (this.jVV.contains(str)) {
                this.jVV.remove(str);
            } else {
                this.jVV.add(str);
            }
            if (bmE()) {
                size = this.jVT.size();
            } else if (!ab.Iz(this.chatroomName)) {
                size = i.SA(this.chatroomName).size();
            } else {
                size = this.jWa.size();
            }
            if (this.jVV.size() == size) {
                this.jVY.setChecked(true);
            } else {
                this.jVY.setChecked(false);
            }
            gUP.notifyDataSetChanged();
            ani();
            AppMethodBeat.o(213009);
        }
    }

    private boolean bmE() {
        return this.scene == 6;
    }

    private void ani() {
        AppMethodBeat.i(63544);
        if (this.jVV.size() > 0) {
            enableOptionMenu(1, true);
            updateOptionMenuText(1, getString(R.string.v, new Object[]{Integer.valueOf(this.jVV.size())}));
        } else {
            enableOptionMenu(1, false);
            updateOptionMenuText(1, getString(R.string.x_));
        }
        if (this.jVV.size() == 1 && this.jVV.contains(z.aTY())) {
            enableOptionMenu(1, false);
            AppMethodBeat.o(63544);
        } else if (this.jVV.size() == 0) {
            enableOptionMenu(1, false);
            AppMethodBeat.o(63544);
        } else {
            enableOptionMenu(1, true);
            AppMethodBeat.o(63544);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(63545);
        if (i2 == 1) {
            this.jVV.remove(str);
            gUP().notifyDataSetChanged();
        }
        AppMethodBeat.o(63545);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.af;
    }

    private void aR(List<String> list) {
        AppMethodBeat.i(213010);
        if (list != null && list.size() > 0) {
            for (String str : list) {
                if (as.bjp(str)) {
                    this.jWb.add(str);
                } else {
                    this.jWa.add(str);
                }
            }
        }
        AppMethodBeat.o(213010);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(63542);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(63542);
            return false;
        }
        boolean contains = this.jVV.contains(aVar.contact.field_username);
        AppMethodBeat.o(63542);
        return contains;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(63543);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(63543);
            return false;
        }
        boolean contains = this.jVU.contains(aVar.contact.field_username);
        AppMethodBeat.o(63543);
        return contains;
    }

    static /* synthetic */ void a(AASelectContactUI aASelectContactUI, List list) {
        AppMethodBeat.i(213011);
        if (aASelectContactUI.jVV != null) {
            aASelectContactUI.jVV.clear();
        } else {
            aASelectContactUI.jVV = new HashSet<>();
        }
        aASelectContactUI.jVV.addAll(list);
        aASelectContactUI.jVY.setChecked(true);
        aASelectContactUI.gUP().notifyDataSetChanged();
        AppMethodBeat.o(213011);
    }
}
