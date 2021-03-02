package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private List<String> PVI = null;
    private boolean PVJ = false;
    private boolean PVK = true;
    private boolean PVL;
    private boolean PVM;
    private boolean PVN;
    private ArrayList<String> PVO;
    private int PVP;
    private int PVQ;
    private ListView PVR;
    private m PVS;
    private HashMap<String, Long> PVT;
    private TextView emptyTipTv;
    private List<as> gxh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(GroupCardSelectUI groupCardSelectUI) {
        AppMethodBeat.i(234005);
        groupCardSelectUI.ani();
        AppMethodBeat.o(234005);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37854);
        super.onCreate(bundle);
        this.PVK = getIntent().getBooleanExtra("group_select_type", true);
        this.PVL = getIntent().getBooleanExtra("group_select_need_result", false);
        this.PVM = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
        this.PVO = getIntent().getStringArrayListExtra("group_select_block_chatroom");
        this.PVN = getIntent().getBooleanExtra("group_select_show_create_new_group", false);
        this.PVP = getIntent().getIntExtra("group_select_chatroom_max_num", Integer.MAX_VALUE);
        if (!this.PVM || this.PVN) {
            setMMTitle(getString(R.string.fu));
        } else {
            setMMTitle(getString(R.string.fv));
        }
        this.PVJ = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.PVJ) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (Util.isNullOrNil(stringExtra)) {
                this.PVI = new LinkedList();
            } else {
                this.PVI = af.k(stringExtra.split(","));
            }
            this.PVQ = getIntent().getIntExtra("max_limit_num", 0);
        }
        gUM();
        initView();
        if (this.PVJ) {
            addTextOptionMenu(1, getString(R.string.x_), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.contact.GroupCardSelectUI.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(37853);
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", Util.listToString(GroupCardSelectUI.this.PVI, ","));
                    GroupCardSelectUI.this.setResult(-1, intent);
                    GroupCardSelectUI.this.finish();
                    AppMethodBeat.o(37853);
                    return true;
                }
            }, null, t.b.GREEN);
            enableOptionMenu(1, true);
            ani();
        }
        AppMethodBeat.o(37854);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37855);
        super.onDestroy();
        AppMethodBeat.o(37855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(37856);
        super.onResume();
        AppMethodBeat.o(37856);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(37857);
        super.onPause();
        AppMethodBeat.o(37857);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(37858);
        this.PVR = (ListView) findViewById(R.id.dld);
        this.PVS = new m(this, this.gxh, this.PVI, this.PVJ);
        this.PVR.setAdapter((ListAdapter) this.PVS);
        this.PVR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.contact.GroupCardSelectUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(37851);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (GroupCardSelectUI.this.PVN) {
                    int headerViewsCount = i2 - GroupCardSelectUI.this.PVR.getHeaderViewsCount();
                    if (i2 == 0) {
                        GroupCardSelectUI.c(GroupCardSelectUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(37851);
                        return;
                    }
                    i2 = headerViewsCount;
                }
                as asVar = (as) GroupCardSelectUI.this.PVS.getItem(i2);
                if (asVar == null) {
                    Log.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(37851);
                    return;
                }
                GroupCardSelectUI.a(GroupCardSelectUI.this, asVar);
                GroupCardSelectUI.e(GroupCardSelectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37851);
            }
        });
        this.emptyTipTv = (TextView) findViewById(R.id.dl_);
        if (this.PVS.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.GroupCardSelectUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37852);
                GroupCardSelectUI.this.finish();
                AppMethodBeat.o(37852);
                return true;
            }
        });
        if (this.PVN) {
            ListView listView = this.PVR;
            View inflate = aa.jQ(this).inflate(R.layout.atw, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.bfe)).setText(R.string.aut);
            TextView textView = (TextView) inflate.findViewById(R.id.h0b);
            if (this.PVS.getCount() <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            listView.addHeaderView(inflate);
        }
        AppMethodBeat.o(37858);
    }

    private void gUM() {
        AppMethodBeat.i(37859);
        bg.aVF();
        this.PVT = c.aST().gCt();
        this.gxh = new LinkedList();
        List<as> aUV = ab.aUV();
        if (aUV.size() == 0) {
            AppMethodBeat.o(37859);
            return;
        }
        int i2 = 0;
        for (as asVar : aUV) {
            if (!ab.Iz(asVar.field_username) && (this.PVO == null || !this.PVO.contains(asVar.field_username))) {
                if (this.PVT.containsKey(asVar.field_username)) {
                    if (this.PVM) {
                        ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
                        if (Kd == null) {
                            Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", Util.nullAs(asVar.field_username, ""));
                        } else if (!Kd.JO(z.aTY())) {
                        }
                    }
                    if (c(asVar)) {
                        a(i2, asVar, this.PVT.get(asVar.field_username).longValue());
                        i2++;
                    }
                } else if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
                    if (this.PVM) {
                        ah Kd2 = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
                        if (Kd2 == null) {
                            Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", Util.nullAs(asVar.field_username, ""));
                        } else if (Kd2.JO(z.aTY()) && c(asVar)) {
                            this.gxh.add(asVar);
                        }
                    } else if (c(asVar)) {
                        this.gxh.add(asVar);
                    }
                }
                i2 = i2;
            }
        }
        aUV.clear();
        AppMethodBeat.o(37859);
    }

    private boolean c(as asVar) {
        AppMethodBeat.i(234003);
        if (this.PVP == Integer.MAX_VALUE) {
            AppMethodBeat.o(234003);
            return true;
        } else if (asVar == null) {
            AppMethodBeat.o(234003);
            return false;
        } else {
            ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(asVar.field_username);
            if (Kd == null) {
                Log.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", asVar.field_username);
                AppMethodBeat.o(234003);
                return false;
            } else if (Kd.field_memberCount < this.PVP) {
                AppMethodBeat.o(234003);
                return true;
            } else {
                AppMethodBeat.o(234003);
                return false;
            }
        }
    }

    private void a(int i2, as asVar, long j2) {
        AppMethodBeat.i(37860);
        int i3 = 0;
        while (i3 < i2 && j2 <= this.PVT.get(this.gxh.get(i3).field_username).longValue()) {
            i3++;
        }
        this.gxh.add(i3, asVar);
        AppMethodBeat.o(37860);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.att;
    }

    static class a {
        CheckBox BaJ;
        TextView PVW;
        ImageView keC;
        TextView yDA;

        a() {
        }
    }

    private void ani() {
        String str;
        AppMethodBeat.i(37861);
        if (this.PVJ) {
            StringBuilder append = new StringBuilder().append(getString(R.string.x_));
            if (this.PVI.size() > 0) {
                str = String.format("(%s)", Integer.valueOf(this.PVI.size()));
            } else {
                str = "";
            }
            updateOptionMenuText(1, append.append(str).toString());
        }
        AppMethodBeat.o(37861);
    }

    static /* synthetic */ void c(GroupCardSelectUI groupCardSelectUI) {
        AppMethodBeat.i(37863);
        Intent intent = new Intent();
        intent.putExtra("list_type", 12);
        intent.putExtra("titile", groupCardSelectUI.getString(R.string.g4));
        intent.putExtra("block_contact", z.aTY());
        intent.putExtra("KBlockOpenImFav", true);
        intent.putExtra("without_openim", true);
        intent.putExtra("list_attr", u.Q(16384, 64, 1, 2, 4, 4194304));
        groupCardSelectUI.setMMOnFragmentActivityResult(new MMFragmentActivity.b() {
            /* class com.tencent.mm.ui.contact.GroupCardSelectUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(234002);
                if (i2 == 10001 && i3 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    Log.i("MicroMsg.GroupCardSelectUI", "CreateNewGroup select contact return");
                    if (Util.isNullOrNil(stringExtra)) {
                        Log.i("MicroMsg.GroupCardSelectUI", "CreateNewGroup select contact return");
                    }
                    ((com.tencent.mm.plugin.messenger.foundation.a.c) g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(GroupCardSelectUI.this.getContext(), (c.b) GroupCardSelectUI.this.getIntent().getSerializableExtra("key_bind_param"), stringExtra, new c.AbstractC1475c() {
                        /* class com.tencent.mm.ui.contact.GroupCardSelectUI.AnonymousClass5.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.messenger.foundation.a.c.AbstractC1475c
                        public final void f(boolean z, String str) {
                            AppMethodBeat.i(234001);
                            if (z) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_User", str);
                                intent.putExtra("key_has_create_new_group", 1);
                                GroupCardSelectUI.this.setResult(-1, intent);
                                GroupCardSelectUI.this.finish();
                            }
                            AppMethodBeat.o(234001);
                        }
                    });
                }
                AppMethodBeat.o(234002);
            }
        });
        com.tencent.mm.br.c.c(groupCardSelectUI, ".ui.contact.SelectContactUI", intent, 10001);
        AppMethodBeat.o(37863);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.contact.GroupCardSelectUI r11, com.tencent.mm.storage.as r12) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.GroupCardSelectUI.a(com.tencent.mm.ui.contact.GroupCardSelectUI, com.tencent.mm.storage.as):void");
    }
}
