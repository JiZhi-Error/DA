package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
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
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SettingsSearchAuthUI extends MMActivity implements i {
    private byte[] CXN;
    private boolean Dcl;
    private com.tencent.mm.ui.search.a DdQ;
    private View DdR;
    private TextView DdS;
    private TextView DdT;
    private List<eom> DdU = new ArrayList();
    private a DdV;
    private ListView mListView;
    private ProgressDialog vIA;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSearchAuthUI() {
        AppMethodBeat.i(74392);
        AppMethodBeat.o(74392);
    }

    static /* synthetic */ void e(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(74402);
        settingsSearchAuthUI.eTg();
        AppMethodBeat.o(74402);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74393);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74393);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74394);
        this.DdQ = new com.tencent.mm.ui.search.a(this);
        this.mListView = (ListView) findViewById(R.id.w4);
        this.DdV = new a(this, (byte) 0);
        this.mListView.setAdapter((ListAdapter) this.DdV);
        this.DdR = findViewById(R.id.hey);
        this.DdS = (TextView) findViewById(R.id.hdc);
        this.DdT = (TextView) findViewById(R.id.hep);
        eTg();
        getSupportActionBar().setCustomView(this.DdQ);
        this.DdQ.setSearchViewListener(new a.b() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.search.a.b
            public final void onClickBackBtn(View view) {
                AppMethodBeat.i(74374);
                Log.i("MicroMsg.SettingsSearchAuthUI", "click search back");
                SettingsSearchAuthUI.this.finish();
                AppMethodBeat.o(74374);
            }
        });
        this.DdQ.getFtsEditText().gWY();
        this.DdQ.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.search.FTSEditTextView.a
            public final void dpw() {
            }

            @Override // com.tencent.mm.ui.search.FTSEditTextView.a
            public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
                AppMethodBeat.i(164137);
                Log.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", str);
                if (!Util.isNullOrNil(str)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
                    String string = SettingsSearchAuthUI.this.getString(R.string.yn);
                    m mVar = new m(string + " " + str.trim());
                    mVar.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(R.color.g7)), string.length(), mVar.length(), 33);
                    SettingsSearchAuthUI.this.DdS.setText(mVar);
                    AppMethodBeat.o(164137);
                    return;
                }
                SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
                AppMethodBeat.o(164137);
            }

            @Override // com.tencent.mm.ui.search.FTSEditTextView.a
            public final void eh(boolean z) {
                AppMethodBeat.i(74376);
                Log.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", Boolean.valueOf(z));
                if (z) {
                    SettingsSearchAuthUI.this.showVKB();
                    AppMethodBeat.o(74376);
                    return;
                }
                SettingsSearchAuthUI.this.hideVKB();
                AppMethodBeat.o(74376);
            }

            @Override // com.tencent.mm.ui.search.FTSEditTextView.a
            public final void onClickClearTextBtn(View view) {
                AppMethodBeat.i(74377);
                Log.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
                SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
                AppMethodBeat.o(74377);
            }

            @Override // com.tencent.mm.ui.search.FTSEditTextView.a
            public final boolean awE() {
                AppMethodBeat.i(74378);
                Log.i("MicroMsg.SettingsSearchAuthUI", "search key down");
                Editable text = SettingsSearchAuthUI.this.DdQ.getFtsEditText().getEditText().getText();
                SettingsSearchAuthUI.this.DdS.setVisibility(8);
                SettingsSearchAuthUI.this.DdQ.getFtsEditText().getEditText().clearFocus();
                SettingsSearchAuthUI.this.hideVKB();
                SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                if (!Util.isNullOrNil(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
                AppMethodBeat.o(74378);
                return true;
            }
        });
        this.DdS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(74379);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Editable text = SettingsSearchAuthUI.this.DdQ.getFtsEditText().getEditText().getText();
                if (!Util.isNullOrNil(text)) {
                    SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, text.toString().trim());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74379);
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                eom Xp;
                AppMethodBeat.i(74380);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (!SettingsSearchAuthUI.this.Dcl && (Xp = SettingsSearchAuthUI.this.DdV.Xp(i2)) != null) {
                    Intent intent = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
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
                    intent.putExtra("modify_scene", 2);
                    intent.putParcelableArrayListExtra("app_auth_items", new ArrayList<>(Arrays.asList(newArray)));
                    SettingsSearchAuthUI settingsSearchAuthUI = SettingsSearchAuthUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(settingsSearchAuthUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    settingsSearchAuthUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(settingsSearchAuthUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(74380);
            }
        });
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass5 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(74381);
                if (i2 + i3 == i4) {
                    Log.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                    if (SettingsSearchAuthUI.this.CXN != null) {
                        SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.CXN);
                        SettingsSearchAuthUI.this.CXN = null;
                    }
                }
                AppMethodBeat.o(74381);
            }
        });
        AppMethodBeat.o(74394);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(74395);
        super.onResume();
        g.azz().a(1169, this);
        g.azz().a(1127, this);
        AppMethodBeat.o(74395);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74396);
        super.onPause();
        g.azz().b(1169, this);
        g.azz().b(1127, this);
        AppMethodBeat.o(74396);
    }

    private void eTg() {
        AppMethodBeat.i(74397);
        removeAllOptionMenu();
        if (!this.DdU.isEmpty()) {
            if (this.Dcl) {
                addTextOptionMenu(700, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass6 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(74382);
                        if (menuItem.getItemId() == 700) {
                            SettingsSearchAuthUI.this.Dcl = false;
                            SettingsSearchAuthUI.this.DdV.notifyDataSetChanged();
                            SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                        }
                        AppMethodBeat.o(74382);
                        return true;
                    }
                });
                AppMethodBeat.o(74397);
                return;
            }
            addTextOptionMenu(700, getString(R.string.wg), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass7 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(74383);
                    if (menuItem.getItemId() == 700) {
                        SettingsSearchAuthUI.this.Dcl = true;
                        SettingsSearchAuthUI.this.DdV.notifyDataSetChanged();
                        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
                    }
                    AppMethodBeat.o(74383);
                    return true;
                }
            });
        }
        AppMethodBeat.o(74397);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(74398);
        super.finish();
        overridePendingTransition(R.anim.di, R.anim.s);
        AppMethodBeat.o(74398);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br7;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        byte[] bArr;
        boolean z;
        Collection<? extends eom> emptyList;
        AppMethodBeat.i(74399);
        Log.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.vIA != null) {
            this.vIA.dismiss();
        }
        if (i2 != 0 || i3 != 0) {
            h.cD(this, str);
        } else if (qVar.getType() == 1169) {
            l lVar = (l) qVar;
            if (lVar.CXQ == null || lVar.CXQ.McB != 1) {
                bArr = null;
            } else {
                bArr = lVar.CXQ.Mcz.toByteArray();
            }
            this.CXN = bArr;
            if (((l) qVar).CXN != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.DdU.clear();
            }
            List<eom> list = this.DdU;
            l lVar2 = (l) qVar;
            if (lVar2.CXQ != null) {
                emptyList = lVar2.CXQ.McA;
            } else {
                emptyList = Collections.emptyList();
            }
            list.addAll(emptyList);
            if (!this.DdU.isEmpty()) {
                this.DdV.Dcn = this.DdU;
                this.DdV.notifyDataSetChanged();
                this.DdR.setVisibility(8);
                this.mListView.setVisibility(0);
                eTg();
                AppMethodBeat.o(74399);
                return;
            }
            this.DdR.setVisibility(0);
            this.DdS.setVisibility(8);
            this.DdT.setVisibility(0);
            this.mListView.setVisibility(8);
            this.DdU.clear();
            eTg();
            AppMethodBeat.o(74399);
            return;
        } else if (qVar.getType() == 1127) {
            String str2 = ((d) qVar).appId;
            if (!Util.isNullOrNil(str2)) {
                if (!this.DdU.isEmpty()) {
                    Iterator<eom> it = this.DdU.iterator();
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
                this.DdV.notifyDataSetChanged();
            }
            AppMethodBeat.o(74399);
            return;
        }
        AppMethodBeat.o(74399);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        List<eom> Dcn;

        private a() {
        }

        /* synthetic */ a(SettingsSearchAuthUI settingsSearchAuthUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(74391);
            eom Xp = Xp(i2);
            AppMethodBeat.o(74391);
            return Xp;
        }

        public final int getCount() {
            AppMethodBeat.i(74388);
            if (this.Dcn == null || this.Dcn.isEmpty()) {
                AppMethodBeat.o(74388);
                return 0;
            }
            int size = this.Dcn.size();
            AppMethodBeat.o(74388);
            return size;
        }

        public final eom Xp(int i2) {
            AppMethodBeat.i(74389);
            if (i2 < 0 || i2 >= getCount()) {
                AppMethodBeat.o(74389);
                return null;
            }
            eom eom = this.Dcn.get(i2);
            AppMethodBeat.o(74389);
            return eom;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            C1688a aVar;
            AppMethodBeat.i(74390);
            if (view == null) {
                view = SettingsSearchAuthUI.this.getLayoutInflater().inflate(R.layout.bqr, (ViewGroup) null);
                C1688a aVar2 = new C1688a(this, (byte) 0);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1688a) view.getTag();
            }
            aVar.oeJ = (TextView) view.findViewById(R.id.hma);
            aVar.Dcr = (TextView) view.findViewById(R.id.hmb);
            aVar.Dcs = (TextView) view.findViewById(R.id.hm_);
            aVar.kjo = (Button) view.findViewById(R.id.hm9);
            aVar.kjo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74387);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.Xp(i2) != null) {
                        final d dVar = new d(a.this.Xp(i2).dNI, 2);
                        if (SettingsSearchAuthUI.this.vIA != null) {
                            SettingsSearchAuthUI.this.vIA.dismiss();
                        }
                        g.azz().a(dVar, 0);
                        SettingsSearchAuthUI.this.vIA = h.a((Context) SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74386);
                                g.azz().a(dVar);
                                AppMethodBeat.o(74386);
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74387);
                }
            });
            if (SettingsSearchAuthUI.this.Dcl) {
                aVar.kjo.setVisibility(0);
            } else {
                aVar.kjo.setVisibility(8);
            }
            if (Xp(i2) != null) {
                aVar.oeJ.setText(Xp(i2).ixZ);
                aVar.Dcr.setText(Xp(i2).Nmo);
                aVar.Dcs.setText(SettingsSearchAuthUI.gH(Xp(i2).Nmn));
            }
            AppMethodBeat.o(74390);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$a$a  reason: collision with other inner class name */
        class C1688a {
            TextView Dcr;
            TextView Dcs;
            Button kjo;
            TextView oeJ;

            private C1688a() {
            }

            /* synthetic */ C1688a(a aVar, byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(74400);
        settingsSearchAuthUI.DdR.setVisibility(0);
        settingsSearchAuthUI.DdS.setVisibility(0);
        settingsSearchAuthUI.DdT.setVisibility(8);
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.DdU.clear();
        settingsSearchAuthUI.eTg();
        AppMethodBeat.o(74400);
    }

    static /* synthetic */ void c(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.i(74401);
        settingsSearchAuthUI.DdR.setVisibility(8);
        settingsSearchAuthUI.DdS.setText("");
        settingsSearchAuthUI.DdU.clear();
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.eTg();
        AppMethodBeat.o(74401);
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, String str) {
        AppMethodBeat.i(74403);
        final l lVar = new l(str);
        g.azz().a(lVar, 0);
        settingsSearchAuthUI.vIA = h.a((Context) settingsSearchAuthUI, settingsSearchAuthUI.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74384);
                g.azz().a(lVar);
                AppMethodBeat.o(74384);
            }
        });
        AppMethodBeat.o(74403);
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, byte[] bArr) {
        AppMethodBeat.i(74404);
        final l lVar = new l(bArr);
        g.azz().a(lVar, 0);
        settingsSearchAuthUI.vIA = h.a((Context) settingsSearchAuthUI, settingsSearchAuthUI.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74385);
                g.azz().a(lVar);
                AppMethodBeat.o(74385);
            }
        });
        AppMethodBeat.o(74404);
    }

    static /* synthetic */ String gH(List list) {
        AppMethodBeat.i(74405);
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
        AppMethodBeat.o(74405);
        return sb2;
    }
}
