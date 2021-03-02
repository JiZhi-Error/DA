package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI extends MMActivity implements b {
    private List<c> dataList = new ArrayList();
    private ProgressDialog gtM;
    private Button kjo;
    private TextView oML;
    private CheckBox qqA;
    private a qqG;
    private ListView qqH;
    private TextView qqI;
    private TextView qqJ;
    private boolean qqK = false;
    private View qqz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CleanChattingUI() {
        AppMethodBeat.i(22898);
        AppMethodBeat.o(22898);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22899);
        super.onCreate(bundle);
        Log.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.string.b51);
        this.qqH = (ListView) findViewById(R.id.b39);
        this.qqG = new a(this, this.dataList);
        this.qqH.setAdapter((ListAdapter) this.qqG);
        this.qqH.setEmptyView(findViewById(R.id.c3e));
        this.qqJ = (TextView) $(R.id.c35);
        this.qqz = findViewById(R.id.lz);
        this.qqI = (TextView) findViewById(R.id.bmg);
        this.qqA = (CheckBox) findViewById(R.id.ly);
        this.oML = (TextView) findViewById(R.id.lx);
        if (!LocaleUtil.isChineseAppLang()) {
            this.qqI.setTextSize(1, 14.0f);
            this.oML.setTextSize(1, 14.0f);
        }
        this.kjo = (Button) findViewById(R.id.blh);
        this.kjo.setEnabled(false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22888);
                CleanChattingUI.this.finish();
                AppMethodBeat.o(22888);
                return false;
            }
        });
        this.qqH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(22889);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                c EO = CleanChattingUI.this.qqG.EO(i2);
                if (EO != null) {
                    Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                    intent.putExtra("key_username", EO.username);
                    intent.putExtra("key_pos", i2);
                    CleanChattingUI.this.startActivityForResult(intent, 0);
                    h.INSTANCE.idkeyStat(714, 21, 1, false);
                }
                a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(22889);
            }
        });
        this.kjo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(22891);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.base.h.a(CleanChattingUI.this, CleanChattingUI.this.getString(R.string.b92), "", CleanChattingUI.this.getString(R.string.bla), CleanChattingUI.this.getString(R.string.amn), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(22890);
                        CleanChattingUI.b(CleanChattingUI.this);
                        h.INSTANCE.idkeyStat(714, 22, 1, false);
                        AppMethodBeat.o(22890);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass3.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }, (int) R.color.cd);
                a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22891);
            }
        });
        this.qqz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(22892);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = CleanChattingUI.this.qqG;
                if (aVar.oMG.size() == aVar.getCount()) {
                    aVar.oMG.clear();
                } else {
                    for (int i2 = 0; i2 < aVar.getCount(); i2++) {
                        aVar.oMG.add(Integer.valueOf(i2));
                    }
                }
                aVar.notifyDataSetChanged();
                aVar.qqi.a(aVar.oMG);
                a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22892);
            }
        });
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.b4o), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.gtM.dismiss();
        h.INSTANCE.idkeyStat(714, 20, 1, false);
        AppMethodBeat.o(22899);
    }

    public final void a(HashSet<Integer> hashSet) {
        AppMethodBeat.i(22900);
        if (this.qqG == null) {
            Log.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            AppMethodBeat.o(22900);
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator<Integer> it = hashSet.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            c EO = this.qqG.EO(intValue);
            if (EO != null) {
                j2 = EO.size + j2;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j2 > 0) {
            this.qqI.setText(getString(R.string.bli, new Object[]{Util.getSizeKB(j2)}));
            this.kjo.setEnabled(true);
            if (hashSet.size() == this.qqG.getCount()) {
                this.qqA.setChecked(true);
                AppMethodBeat.o(22900);
                return;
            }
            this.qqA.setChecked(false);
            AppMethodBeat.o(22900);
            return;
        }
        this.qqI.setText("");
        this.kjo.setEnabled(false);
        this.qqA.setChecked(false);
        AppMethodBeat.o(22900);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22901);
        if (this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(22901);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(22902);
        super.onResume();
        if (this.qqG != null && this.dataList.isEmpty()) {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(22895);
                    if (!CleanChattingUI.this.qqK) {
                        Log.i("MicroMsg.CleanChattingUI", "load contact cursor now");
                        CleanChattingUI.this.qqK = true;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(22893);
                                CleanChattingUI.this.qqJ.setText(CleanChattingUI.this.getString(R.string.h2, new Object[]{" "}));
                                AppMethodBeat.o(22893);
                            }
                        });
                        try {
                            Cursor csh = com.tencent.mm.plugin.f.b.crW().crX().csh();
                            if (csh != null) {
                                while (csh.moveToNext()) {
                                    c cVar = new c();
                                    cVar.username = csh.getString(0);
                                    cVar.size = csh.getLong(1);
                                    CleanChattingUI.this.dataList.add(cVar);
                                }
                            }
                        } catch (NullPointerException e2) {
                            Log.printErrStackTrace("MicroMsg.CleanChattingUI", e2, "", new Object[0]);
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass6.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(22894);
                                CleanChattingUI.this.qqG.notifyDataSetChanged();
                                CleanChattingUI.this.qqJ.setText(R.string.b4n);
                                AppMethodBeat.o(22894);
                            }
                        });
                    }
                    AppMethodBeat.o(22895);
                }
            });
        }
        AppMethodBeat.o(22902);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.uq;
    }

    @Override // com.tencent.mm.plugin.clean.c.b
    public final void fo(final int i2, final int i3) {
        AppMethodBeat.i(22903);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(22896);
                CleanChattingUI.this.gtM.setMessage(CleanChattingUI.this.getString(R.string.b58, new Object[]{((i2 * 100) / i3) + "%"}));
                AppMethodBeat.o(22896);
            }
        });
        AppMethodBeat.o(22903);
    }

    @Override // com.tencent.mm.plugin.clean.c.b
    public final void Ce(final long j2) {
        AppMethodBeat.i(22904);
        Log.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new StringBuilder().append(hashCode()).toString(), Long.valueOf(j2));
        d.cyM().qpu -= j2;
        d.cyM().qpK -= j2;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(22897);
                CleanChattingUI.this.gtM.dismiss();
                com.tencent.mm.ui.base.h.c(CleanChattingUI.this, CleanChattingUI.this.getString(R.string.b4p, new Object[]{Util.getSizeKB(j2)}), "", true);
                CleanChattingUI.this.qqJ.setText(CleanChattingUI.this.getString(R.string.h2, new Object[]{" "}));
                AppMethodBeat.o(22897);
            }
        });
        AppMethodBeat.o(22904);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        c cVar;
        AppMethodBeat.i(22905);
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra >= 0 && intExtra < this.dataList.size() && (cVar = this.dataList.get(intExtra)) != null) {
                if (cVar.size == longExtra) {
                    this.dataList.remove(intExtra);
                    this.qqG.cyS();
                } else {
                    cVar.size -= longExtra;
                }
            }
        }
        this.qqG.notifyDataSetChanged();
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(22905);
    }

    static /* synthetic */ void b(CleanChattingUI cleanChattingUI) {
        AppMethodBeat.i(22906);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.qqG.oMG);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c EO = cleanChattingUI.qqG.EO(intValue);
            if (EO != null) {
                arrayList2.add(EO.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.qqG.cyS();
        cleanChattingUI.qqG.notifyDataSetChanged();
        ThreadPool.post(new com.tencent.mm.plugin.clean.b.b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.gtM.setMessage(cleanChattingUI.getString(R.string.b58, new Object[]{"0%"}));
        cleanChattingUI.gtM.show();
        AppMethodBeat.o(22906);
    }
}
