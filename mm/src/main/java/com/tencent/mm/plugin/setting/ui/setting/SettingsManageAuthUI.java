package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI extends MMActivity implements i {
    private byte[] CXN;
    private a Dcj;
    private List<eom> Dck = new ArrayList();
    private boolean Dcl;
    private ListView mListView;
    private ProgressDialog vIA;
    private View wMd;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsManageAuthUI() {
        AppMethodBeat.i(74195);
        AppMethodBeat.o(74195);
    }

    static /* synthetic */ void cc(byte[] bArr) {
        AppMethodBeat.i(74203);
        cb(bArr);
        AppMethodBeat.o(74203);
    }

    static /* synthetic */ void e(SettingsManageAuthUI settingsManageAuthUI) {
        AppMethodBeat.i(74204);
        settingsManageAuthUI.eTg();
        AppMethodBeat.o(74204);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74196);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74196);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74197);
        this.mListView = (ListView) findViewById(R.id.w4);
        this.wMd = findViewById(R.id.w3);
        this.Dcj = new a(this, (byte) 0);
        this.mListView.setAdapter((ListAdapter) this.Dcj);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(74183);
                if (i2 + i3 == i4) {
                    Log.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
                    if (SettingsManageAuthUI.this.CXN != null) {
                        SettingsManageAuthUI.cc(SettingsManageAuthUI.this.CXN);
                        SettingsManageAuthUI.this.CXN = null;
                    }
                }
                AppMethodBeat.o(74183);
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                eom Xp;
                AppMethodBeat.i(74184);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (!SettingsManageAuthUI.this.Dcl && (Xp = SettingsManageAuthUI.this.Dcj.Xp(i2)) != null) {
                    Intent intent = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
                    UserAuthItemParcelable[] newArray = UserAuthItemParcelable.CREATOR.newArray(Xp.Nmn.size());
                    for (int i3 = 0; i3 < Xp.Nmn.size(); i3++) {
                        eon eon = Xp.Nmn.get(i3);
                        UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                        userAuthItemParcelable.scope = eon.scope;
                        userAuthItemParcelable.CYp = eon.CYp;
                        userAuthItemParcelable.state = eon.state;
                        userAuthItemParcelable.CYq = eon.CYq;
                        newArray[i3] = userAuthItemParcelable;
                    }
                    intent.putExtra("app_id", Xp.dNI);
                    intent.putExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Xp.ixZ);
                    intent.putExtra("modify_scene", 1);
                    intent.putParcelableArrayListExtra("app_auth_items", new ArrayList<>(Arrays.asList(newArray)));
                    SettingsManageAuthUI settingsManageAuthUI = SettingsManageAuthUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(settingsManageAuthUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    settingsManageAuthUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(settingsManageAuthUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(74184);
            }
        });
        eTg();
        setMMTitle(R.string.gnf);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74185);
                SettingsManageAuthUI.this.finish();
                AppMethodBeat.o(74185);
                return true;
            }
        });
        AppMethodBeat.o(74197);
    }

    private void eTg() {
        AppMethodBeat.i(74198);
        removeAllOptionMenu();
        addIconOptionMenu(800, R.raw.actionbar_search_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74186);
                Intent intent = new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class);
                SettingsManageAuthUI settingsManageAuthUI = SettingsManageAuthUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsManageAuthUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsManageAuthUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsManageAuthUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.kb(SettingsManageAuthUI.this);
                AppMethodBeat.o(74186);
                return true;
            }
        });
        if (this.Dck.isEmpty()) {
            this.wMd.setVisibility(0);
            AppMethodBeat.o(74198);
            return;
        }
        this.wMd.setVisibility(8);
        if (this.Dcl) {
            addTextOptionMenu(700, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass5 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(74187);
                    if (menuItem.getItemId() == 700) {
                        SettingsManageAuthUI.this.Dcl = false;
                        SettingsManageAuthUI.this.Dcj.notifyDataSetChanged();
                        SettingsManageAuthUI.e(SettingsManageAuthUI.this);
                    }
                    AppMethodBeat.o(74187);
                    return true;
                }
            });
            AppMethodBeat.o(74198);
            return;
        }
        addTextOptionMenu(700, getString(R.string.wg), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74188);
                if (menuItem.getItemId() == 700) {
                    SettingsManageAuthUI.this.Dcl = true;
                    SettingsManageAuthUI.this.Dcj.notifyDataSetChanged();
                    SettingsManageAuthUI.e(SettingsManageAuthUI.this);
                }
                AppMethodBeat.o(74188);
                return true;
            }
        });
        AppMethodBeat.o(74198);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(74199);
        super.onResume();
        g.azz().a(1146, this);
        g.azz().a(1127, this);
        cb(null);
        AppMethodBeat.o(74199);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74200);
        super.onPause();
        g.azz().b(1146, this);
        g.azz().b(1127, this);
        AppMethodBeat.o(74200);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqy;
    }

    private static void cb(byte[] bArr) {
        AppMethodBeat.i(74201);
        g.azz().a(new com.tencent.mm.plugin.setting.model.i(bArr), 0);
        AppMethodBeat.o(74201);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        byte[] bArr;
        boolean z;
        Collection<? extends eom> emptyList;
        AppMethodBeat.i(74202);
        Log.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.vIA != null) {
            this.vIA.dismiss();
        }
        if (i2 != 0 || i3 != 0) {
            h.cD(this, str);
        } else if (qVar.getType() == 1146) {
            com.tencent.mm.plugin.setting.model.i iVar = (com.tencent.mm.plugin.setting.model.i) qVar;
            if (iVar.CXM == null || iVar.CXM.McB != 1) {
                bArr = null;
            } else {
                bArr = iVar.CXM.Mcz.toByteArray();
            }
            this.CXN = bArr;
            if (((com.tencent.mm.plugin.setting.model.i) qVar).CXN != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.Dck.clear();
            }
            List<eom> list = this.Dck;
            com.tencent.mm.plugin.setting.model.i iVar2 = (com.tencent.mm.plugin.setting.model.i) qVar;
            if (iVar2.CXM != null) {
                emptyList = iVar2.CXM.McA;
            } else {
                emptyList = Collections.emptyList();
            }
            list.addAll(emptyList);
            this.Dcj.Dcn = this.Dck;
            this.Dcj.notifyDataSetChanged();
            eTg();
            AppMethodBeat.o(74202);
            return;
        } else if (qVar.getType() == 1127) {
            String str2 = ((d) qVar).appId;
            if (!Util.isNullOrNil(str2)) {
                if (!this.Dck.isEmpty()) {
                    Iterator<eom> it = this.Dck.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().dNI.equals(str2)) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                this.Dcj.notifyDataSetChanged();
            }
            AppMethodBeat.o(74202);
            return;
        }
        AppMethodBeat.o(74202);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        List<eom> Dcn;

        private a() {
        }

        /* synthetic */ a(SettingsManageAuthUI settingsManageAuthUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(74194);
            eom Xp = Xp(i2);
            AppMethodBeat.o(74194);
            return Xp;
        }

        public final int getCount() {
            AppMethodBeat.i(74191);
            if (this.Dcn == null || this.Dcn.isEmpty()) {
                AppMethodBeat.o(74191);
                return 0;
            }
            int size = this.Dcn.size();
            AppMethodBeat.o(74191);
            return size;
        }

        public final eom Xp(int i2) {
            AppMethodBeat.i(74192);
            if (i2 < 0 || i2 >= getCount()) {
                AppMethodBeat.o(74192);
                return null;
            }
            eom eom = this.Dcn.get(i2);
            AppMethodBeat.o(74192);
            return eom;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            C1687a aVar;
            AppMethodBeat.i(74193);
            if (view == null) {
                view = SettingsManageAuthUI.this.getLayoutInflater().inflate(R.layout.bqr, (ViewGroup) null);
                C1687a aVar2 = new C1687a(this, (byte) 0);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1687a) view.getTag();
            }
            aVar.oeJ = (TextView) view.findViewById(R.id.hma);
            aVar.Dcr = (TextView) view.findViewById(R.id.hmb);
            aVar.Dcs = (TextView) view.findViewById(R.id.hm_);
            aVar.kjo = (Button) view.findViewById(R.id.hm9);
            aVar.kjo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74190);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.Xp(i2) != null) {
                        final d dVar = new d(a.this.Xp(i2).dNI, 1);
                        if (SettingsManageAuthUI.this.vIA != null) {
                            SettingsManageAuthUI.this.vIA.dismiss();
                        }
                        g.azz().a(dVar, 0);
                        SettingsManageAuthUI.this.vIA = h.a((Context) SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74189);
                                g.azz().a(dVar);
                                AppMethodBeat.o(74189);
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74190);
                }
            });
            if (SettingsManageAuthUI.this.Dcl) {
                aVar.kjo.setVisibility(0);
            } else {
                aVar.kjo.setVisibility(8);
            }
            if (Xp(i2) != null) {
                aVar.oeJ.setText(Xp(i2).ixZ);
                aVar.Dcr.setText(Xp(i2).Nmo);
                aVar.Dcs.setText(SettingsManageAuthUI.gG(Xp(i2).Nmn));
            }
            AppMethodBeat.o(74193);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$a$a  reason: collision with other inner class name */
        class C1687a {
            TextView Dcr;
            TextView Dcs;
            Button kjo;
            TextView oeJ;

            private C1687a() {
            }

            /* synthetic */ C1687a(a aVar, byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ String gG(List list) {
        AppMethodBeat.i(74205);
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((eon) it.next()).CYp);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(74205);
        return sb2;
    }
}
