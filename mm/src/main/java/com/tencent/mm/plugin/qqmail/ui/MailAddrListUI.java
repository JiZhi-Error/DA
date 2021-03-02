package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private m BrU = null;
    private q BvO = null;
    private ListView BvP;
    private a BvQ;
    private List<l> BvR;
    private m.a BvS = new m.a() {
        /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.qqmail.d.m.a
        public final void onComplete() {
            AppMethodBeat.i(123037);
            Log.i("MicroMsg.MailAddrListUI", "sync addr complete");
            if (MailAddrListUI.this.BvO != null) {
                MailAddrListUI.this.BvO.dismiss();
            }
            MailAddrListUI.this.BvR = MailAddrListUI.this.BrU.aKD(null);
            if (MailAddrListUI.this.BvR.size() == 0) {
                MailAddrListUI.this.khw.setText(R.string.gt9);
                MailAddrListUI.this.khw.setVisibility(0);
            }
            MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.string.fnf) + (MailAddrListUI.this.BvQ.eGR() > 0 ? "(" + MailAddrListUI.this.BvQ.eGR() + ")" : ""));
            String[] stringArrayExtra = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            if (stringArrayExtra != null) {
                HashSet hashSet = new HashSet();
                for (String str : stringArrayExtra) {
                    String[] split = str.split(" ");
                    if (split.length == 2) {
                        hashSet.add(split[1]);
                    }
                }
                for (l lVar : MailAddrListUI.this.BvR) {
                    if (hashSet.contains(lVar.yFq)) {
                        MailAddrListUI.this.BvQ.BvU.put(lVar.yFq, lVar);
                    }
                }
            }
            MailAddrListUI.this.BvQ.notifyDataSetChanged();
            AppMethodBeat.o(123037);
        }
    };
    private TextView khw = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailAddrListUI() {
        AppMethodBeat.i(123053);
        AppMethodBeat.o(123053);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bjy;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123054);
        super.onCreate(bundle);
        setMMTitle(R.string.fnf);
        this.BvR = new ArrayList();
        this.BrU = ((k) g.ah(k.class)).getNormalMailAppService().BrU;
        initView();
        this.BrU.a(this.BvS);
        this.BrU.eGn();
        AppMethodBeat.o(123054);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123055);
        this.BvP = (ListView) findViewById(R.id.gn_);
        this.khw = (TextView) findViewById(R.id.c39);
        this.BvQ = new a(this);
        s sVar = new s((byte) 0);
        sVar.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(123038);
                String nullAs = Util.nullAs(str, "");
                MailAddrListUI.this.BvR = MailAddrListUI.this.BrU.aKD(nullAs.toLowerCase().trim());
                if (MailAddrListUI.this.BvR.size() == 0) {
                    MailAddrListUI.this.khw.setText(R.string.fno);
                    MailAddrListUI.this.khw.setVisibility(0);
                    MailAddrListUI.this.enableOptionMenu(false);
                } else {
                    MailAddrListUI.this.khw.setVisibility(8);
                    MailAddrListUI.this.enableOptionMenu(true);
                }
                MailAddrListUI.this.BvQ.notifyDataSetChanged();
                AppMethodBeat.o(123038);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }
        };
        addSearchMenu(true, sVar);
        this.BvP.setAdapter((ListAdapter) this.BvQ);
        this.BvP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(123039);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a aVar = MailAddrListUI.this.BvQ;
                l Vi = aVar.Vi(i2 - MailAddrListUI.this.BvP.getHeaderViewsCount());
                String str = Vi.yFq;
                if (aVar.BvU.containsKey(str)) {
                    aVar.BvU.remove(str);
                } else {
                    aVar.BvU.put(str, Vi);
                }
                aVar.notifyDataSetChanged();
                MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.string.fnf) + (MailAddrListUI.this.BvQ.eGR() > 0 ? "(" + MailAddrListUI.this.BvQ.eGR() + ")" : ""));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(123039);
            }
        });
        this.BvP.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(123040);
                if (1 == i2) {
                    MailAddrListUI.this.hideVKB();
                }
                AppMethodBeat.o(123040);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.BvR = this.BrU.aKD(null);
        this.BvQ.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123041);
                MailAddrListUI.this.setResult(0);
                MailAddrListUI.this.finish();
                AppMethodBeat.o(123041);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(123042);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(MailAddrListUI.this.BvP);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123042);
            }
        });
        addTextOptionMenu(0, getString(R.string.fne), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123043);
                a aVar = MailAddrListUI.this.BvQ;
                ArrayList arrayList = new ArrayList();
                for (String str : aVar.BvU.keySet()) {
                    arrayList.add(aVar.BvU.get(str));
                }
                ComposeUI.fW(arrayList);
                MailAddrListUI.this.setResult(-1);
                MailAddrListUI.this.finish();
                AppMethodBeat.o(123043);
                return true;
            }
        });
        enableOptionMenu(!this.BvR.isEmpty());
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.BvO = h.a((Context) context, getString(R.string.fnd), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(123055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123056);
        super.onPause();
        AppMethodBeat.o(123056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123057);
        super.onResume();
        this.BvQ.notifyDataSetChanged();
        AppMethodBeat.o(123057);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123058);
        super.onDestroy();
        this.BrU.b(this.BvS);
        AppMethodBeat.o(123058);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        Map<String, l> BvU = new HashMap();
        private final Context context;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(123052);
            l Vi = Vi(i2);
            AppMethodBeat.o(123052);
            return Vi;
        }

        public a(Context context2) {
            AppMethodBeat.i(123044);
            this.context = context2;
            AppMethodBeat.o(123044);
        }

        public final int eGR() {
            AppMethodBeat.i(123046);
            int size = this.BvU.size();
            AppMethodBeat.o(123046);
            return size;
        }

        public final int getCount() {
            AppMethodBeat.i(123047);
            int size = MailAddrListUI.this.BvR.size();
            AppMethodBeat.o(123047);
            return size;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1613a aVar;
            l lVar;
            boolean z;
            AppMethodBeat.i(123049);
            if (view == null || view.getTag() == null) {
                C1613a aVar2 = new C1613a();
                view = View.inflate(this.context, R.layout.bjz, null);
                aVar2.BvV = (TextView) view.findViewById(R.id.gn6);
                aVar2.kgE = (TextView) view.findViewById(R.id.gn8);
                aVar2.BvW = (TextView) view.findViewById(R.id.gn5);
                aVar2.jVQ = (CheckBox) view.findViewById(R.id.gn9);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1613a) view.getTag();
            }
            l Vi = Vi(i2);
            if (i2 > 0) {
                lVar = Vi(i2 - 1);
            } else {
                lVar = null;
            }
            String a2 = a(Vi);
            String a3 = a(lVar);
            if (a2 == null) {
                aVar.BvV.setVisibility(8);
            } else if (!a2.equals(a3)) {
                aVar.BvV.setText(a2.toUpperCase());
                aVar.BvV.setVisibility(0);
            } else {
                aVar.BvV.setVisibility(8);
            }
            aVar.kgE.setText(Vi.name);
            aVar.BvW.setText(Vi.yFq);
            CheckBox checkBox = aVar.jVQ;
            if (this.BvU.get(Vi.yFq) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            AppMethodBeat.o(123049);
            return view;
        }

        private static String a(l lVar) {
            AppMethodBeat.i(123050);
            if (lVar == null) {
                AppMethodBeat.o(123050);
                return null;
            }
            String str = lVar.pinyin;
            char charAt = str.length() > 1 ? str.charAt(0) : '~';
            switch (charAt) {
                case '{':
                    char charAt2 = str.charAt(1);
                    if (Util.isNum(charAt2)) {
                        String valueOf = String.valueOf(charAt2);
                        AppMethodBeat.o(123050);
                        return valueOf;
                    }
                    AppMethodBeat.o(123050);
                    return "~";
                case '|':
                case '}':
                default:
                    if (Util.isAlpha(charAt)) {
                        String valueOf2 = String.valueOf(charAt);
                        AppMethodBeat.o(123050);
                        return valueOf2;
                    }
                    AppMethodBeat.o(123050);
                    return "~";
                case '~':
                    AppMethodBeat.o(123050);
                    return "~";
            }
        }

        public final l Vi(int i2) {
            AppMethodBeat.i(123051);
            l lVar = (l) MailAddrListUI.this.BvR.get(i2);
            AppMethodBeat.o(123051);
            return lVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrListUI$a$a  reason: collision with other inner class name */
        class C1613a {
            TextView BvV;
            TextView BvW;
            CheckBox jVQ;
            TextView kgE;

            C1613a() {
            }
        }
    }
}
