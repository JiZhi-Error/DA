package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView BCj;
    private a BCk;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ReaderAppSubscribeUI readerAppSubscribeUI, int i2) {
        AppMethodBeat.i(102716);
        readerAppSubscribeUI.Vm(i2);
        AppMethodBeat.o(102716);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bl1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(102711);
        super.onCreate(bundle);
        g.aAh().azQ().set(868518890, LocaleUtil.INDONESIAN_NEWNAME);
        setMMTitle(R.string.bef);
        initView();
        AppMethodBeat.o(102711);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(102712);
        this.BCk = new a(this, Util.nullAsNil((Integer) g.aAh().azQ().get(868518889, (Object) null)));
        this.BCj = (ListView) findViewById(R.id.gt2);
        this.BCj.setAdapter((ListAdapter) this.BCk);
        this.BCj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean z;
                AppMethodBeat.i(102706);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a aVar = ReaderAppSubscribeUI.this.BCk;
                if ((aVar.BCn & aVar.BCm[i2]) != 0) {
                    aVar.BCn &= aVar.BCm[i2] ^ -1;
                    aVar.BCp--;
                    if (aVar.BCp < 0) {
                        aVar.BCp = 0;
                    }
                    aVar.notifyDataSetChanged();
                    z = true;
                } else if (aVar.BCp < 3) {
                    aVar.BCn |= aVar.BCm[i2];
                    aVar.BCp++;
                    if (aVar.BCp > aVar.BCm.length) {
                        aVar.BCp = aVar.BCm.length;
                    }
                    aVar.notifyDataSetChanged();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    h.n(ReaderAppSubscribeUI.this, R.string.beg, R.string.zb);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(102706);
            }
        });
        this.BCk.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(102707);
                ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.this.BCk.BCn);
                AppMethodBeat.o(102707);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(102708);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(ReaderAppSubscribeUI.this.BCj);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(102708);
            }
        });
        AppMethodBeat.o(102712);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(102713);
        if (i2 == 4) {
            if (this.BCk != null) {
                Vm(this.BCk.BCn);
            }
            AppMethodBeat.o(102713);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(102713);
        return onKeyDown;
    }

    private void Vm(int i2) {
        AppMethodBeat.i(102714);
        g.aAh().azQ().set(868518889, Integer.valueOf(i2));
        cqi cqi = new cqi();
        cqi.MvW = i2;
        ((l) g.af(l.class)).aSM().d(new k.a(43, cqi));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.b.a.jRt.c(intent, this);
        finish();
        AppMethodBeat.o(102714);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(102715);
        super.onResume();
        this.BCk.notifyDataSetChanged();
        AppMethodBeat.o(102715);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        final int[] BCm = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int BCn;
        private String[] BCo = null;
        int BCp = 0;
        private final Context context;

        public a(Context context2, int i2) {
            AppMethodBeat.i(102709);
            this.context = context2;
            this.BCn = i2;
            this.BCo = context2.getString(R.string.fu3).split(";");
            this.BCp = Vn(i2);
            AppMethodBeat.o(102709);
        }

        public final int getCount() {
            return this.BCo.length;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1625a aVar;
            AppMethodBeat.i(102710);
            if (view == null) {
                C1625a aVar2 = new C1625a();
                view = View.inflate(this.context, R.layout.bl0, null);
                aVar2.jVO = (TextView) view.findViewById(R.id.gt1);
                aVar2.jVQ = (CheckBox) view.findViewById(R.id.gt0);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1625a) view.getTag();
            }
            aVar.jVO.setText(this.BCo[i2]);
            aVar.jVQ.setChecked((this.BCn & this.BCm[i2]) != 0);
            AppMethodBeat.o(102710);
            return view;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI$a$a  reason: collision with other inner class name */
        static class C1625a {
            TextView jVO;
            CheckBox jVQ;

            C1625a() {
            }
        }

        private int Vn(int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.BCm.length; i4++) {
                if ((this.BCm[i4] & i2) != 0) {
                    i3++;
                } else {
                    i3 = i3;
                }
            }
            return i3;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i2) {
            return this.BCo[i2];
        }
    }
}
