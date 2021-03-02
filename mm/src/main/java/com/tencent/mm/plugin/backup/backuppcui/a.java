package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean oOP = false;
    HashSet<Integer> oMG = new HashSet<>();
    BackupPcChooseUI oOO;

    public a(BackupPcChooseUI backupPcChooseUI) {
        AppMethodBeat.i(21627);
        this.oOO = backupPcChooseUI;
        oOP = false;
        AppMethodBeat.o(21627);
    }

    public final int getCount() {
        AppMethodBeat.i(21628);
        LinkedList<f.b> cfr = b.cga().cge().cfr();
        if (cfr != null) {
            int size = cfr.size();
            AppMethodBeat.o(21628);
            return size;
        }
        AppMethodBeat.o(21628);
        return 0;
    }

    private static String getItem(int i2) {
        AppMethodBeat.i(21629);
        LinkedList<f.b> cfr = b.cga().cge().cfr();
        if (cfr.get(i2) == null) {
            AppMethodBeat.o(21629);
            return null;
        }
        String str = cfr.get(i2).oJq;
        AppMethodBeat.o(21629);
        return str;
    }

    public final long getItemId(int i2) {
        return -1;
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        C0834a aVar;
        AppMethodBeat.i(21630);
        if (view == null) {
            view = this.oOO.getLayoutInflater().inflate(R.layout.hp, viewGroup, false);
            C0834a aVar2 = new C0834a();
            aVar2.gvv = (ImageView) view.findViewById(R.id.x1);
            aVar2.jVO = (TextView) view.findViewById(R.id.ir3);
            aVar2.jVQ = (CheckBox) view.findViewById(R.id.hhc);
            aVar2.oMI = (RelativeLayout) view.findViewById(R.id.hhd);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (C0834a) view.getTag();
        }
        aVar.oMI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.backuppcui.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(21626);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.oMG.contains(Integer.valueOf(i2))) {
                    a.this.oMG.remove(Integer.valueOf(i2));
                } else {
                    a.this.oMG.add(Integer.valueOf(i2));
                }
                a.this.notifyDataSetChanged();
                a.this.oOO.a(a.this.oMG);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21626);
            }
        });
        String item = getItem(i2);
        a.b.c(aVar.gvv, item);
        if (ab.Eq(item)) {
            aVar.jVO.setText(l.b(this.oOO, aa.getDisplayName(item, item), aVar.jVO.getTextSize()));
        } else {
            aVar.jVO.setText(l.b(this.oOO, aa.getDisplayName(item), aVar.jVO.getTextSize()));
        }
        if (this.oMG.contains(Integer.valueOf(i2))) {
            aVar.jVQ.setChecked(true);
        } else {
            aVar.jVQ.setChecked(false);
        }
        AppMethodBeat.o(21630);
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.a$a  reason: collision with other inner class name */
    class C0834a {
        ImageView gvv;
        TextView jVO;
        CheckBox jVQ;
        RelativeLayout oMI;

        C0834a() {
        }
    }
}
