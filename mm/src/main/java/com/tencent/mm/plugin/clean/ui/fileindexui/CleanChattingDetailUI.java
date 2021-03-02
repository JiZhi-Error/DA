package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.ui.fileindexui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements b {
    private ProgressDialog gtM;
    private Button kjo;
    private int pos;
    private long qpE;
    CheckBox qqA;
    MMAutoAdjustTextView qqB;
    private com.tencent.mm.plugin.clean.b.b qqC;
    private GridHeadersGridView qqx;
    private b qqy;
    private View qqz;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22882);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("key_username");
        this.pos = getIntent().getIntExtra("key_pos", 0);
        if (Util.isNullOrNil(this.username)) {
            Log.w("MicroMsg.CleanChattingDetailUI", "username is null");
            finish();
            AppMethodBeat.o(22882);
            return;
        }
        this.qqz = (View) $(R.id.lz);
        this.qqA = (CheckBox) $(R.id.ly);
        this.qqB = (MMAutoAdjustTextView) $(R.id.bmg);
        this.kjo = (Button) $(R.id.blh);
        ER(0);
        if (ab.Eq(this.username)) {
            setMMTitle(aa.getDisplayName(this.username, this.username));
        } else {
            setMMTitle(aa.getDisplayName(this.username));
        }
        this.qqx = (GridHeadersGridView) findViewById(R.id.b38);
        this.qqx.setNumColumns(3);
        this.qqy = new b(this, this.username);
        this.qqx.setOnHeaderClickListener(this.qqy.qqm);
        this.qqx.setOnItemClickListener(this.qqy.ppw);
        this.qqx.setOnScrollListener(this.qqy.qqo);
        this.qqx.setAdapter((ListAdapter) this.qqy);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22876);
                CleanChattingDetailUI.this.finish();
                AppMethodBeat.o(22876);
                return false;
            }
        });
        this.qqz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(22877);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = CleanChattingDetailUI.this.qqy;
                if (bVar2.oMG.size() == bVar2.kgc.size()) {
                    bVar2.oMG.clear();
                } else {
                    for (int i2 = 0; i2 < bVar2.kgc.size(); i2++) {
                        bVar2.oMG.add(Integer.valueOf(i2));
                    }
                }
                bVar2.cyT();
                CleanChattingDetailUI.this.qqy.notifyDataSetChanged();
                a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22877);
            }
        });
        this.kjo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(22879);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.string.b93), "", CleanChattingDetailUI.this.getString(R.string.bla), CleanChattingDetailUI.this.getString(R.string.amn), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(22878);
                        CleanChattingDetailUI.b(CleanChattingDetailUI.this);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(714, 31, 1, false);
                        AppMethodBeat.o(22878);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass3.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22879);
            }
        });
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.b4o), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.gtM.dismiss();
        if (this.qqy != null) {
            ThreadPool.post(new b.RunnableC0926b(this.qqy, (byte) 0), "load_clean_detail");
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(714, 30, 1, false);
        AppMethodBeat.o(22882);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.uo;
    }

    public final void ER(int i2) {
        AppMethodBeat.i(22883);
        this.kjo.setEnabled(i2 > 0);
        AppMethodBeat.o(22883);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22884);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        if (this.qqy != null) {
            this.qqy.isStop = true;
        }
        super.onDestroy();
        AppMethodBeat.o(22884);
    }

    @Override // com.tencent.mm.plugin.clean.c.b
    public final void fo(final int i2, final int i3) {
        AppMethodBeat.i(22885);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(22880);
                CleanChattingDetailUI.this.gtM.setMessage(CleanChattingDetailUI.this.getString(R.string.b58, new Object[]{((i2 * 100) / i3) + "%"}));
                AppMethodBeat.o(22880);
            }
        });
        AppMethodBeat.o(22885);
    }

    @Override // com.tencent.mm.plugin.clean.c.b
    public final void Ce(final long j2) {
        AppMethodBeat.i(22886);
        Log.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new StringBuilder().append(hashCode()).toString(), Long.valueOf(j2));
        d.cyM().qpu -= j2;
        d.cyM().qpK -= j2;
        this.qpE += j2;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(22881);
                CleanChattingDetailUI.this.gtM.dismiss();
                Intent intent = new Intent();
                intent.putExtra("key_pos", CleanChattingDetailUI.this.pos);
                intent.putExtra("key_delete_size", CleanChattingDetailUI.this.qpE);
                CleanChattingDetailUI.this.setResult(1000, intent);
                h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.string.b4p, new Object[]{Util.getSizeKB(j2)}), "", true);
                AppMethodBeat.o(22881);
            }
        });
        AppMethodBeat.o(22886);
    }

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        AppMethodBeat.i(22887);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cleanChattingDetailUI.qqy.oMG);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c EP = cleanChattingDetailUI.qqy.EP(intValue);
            if (EP != null) {
                arrayList2.add(EP);
                cleanChattingDetailUI.qqy.kgc.remove(intValue);
            }
        }
        cleanChattingDetailUI.qqy.cyS();
        cleanChattingDetailUI.qqy.notifyDataSetChanged();
        cleanChattingDetailUI.qqC = new com.tencent.mm.plugin.clean.b.b(null, arrayList2, cleanChattingDetailUI);
        ThreadPool.post(cleanChattingDetailUI.qqC, "delete-clean");
        cleanChattingDetailUI.gtM.show();
        cleanChattingDetailUI.gtM.setMessage(cleanChattingDetailUI.getString(R.string.b58, new Object[]{"0%"}));
        AppMethodBeat.o(22887);
    }
}
