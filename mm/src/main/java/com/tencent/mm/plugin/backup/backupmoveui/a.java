package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    BackupMoveChooseUI oMF;
    HashSet<Integer> oMG = new HashSet<>();

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        AppMethodBeat.i(21377);
        this.oMF = backupMoveChooseUI;
        AppMethodBeat.o(21377);
    }

    public final int getCount() {
        AppMethodBeat.i(21378);
        LinkedList<f.b> cfr = b.cfv().cfz().cfr();
        if (cfr != null) {
            int size = cfr.size();
            AppMethodBeat.o(21378);
            return size;
        }
        AppMethodBeat.o(21378);
        return 0;
    }

    public final long getItemId(int i2) {
        return -1;
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        C0833a aVar;
        AppMethodBeat.i(21380);
        if (view == null) {
            view = this.oMF.getLayoutInflater().inflate(R.layout.hu, viewGroup, false);
            aVar = new C0833a();
            aVar.gvv = (ImageView) view.findViewById(R.id.x1);
            aVar.jVO = (TextView) view.findViewById(R.id.ir3);
            aVar.jVQ = (CheckBox) view.findViewById(R.id.hhc);
            aVar.oMI = (RelativeLayout) view.findViewById(R.id.hhd);
            view.setTag(aVar);
        } else {
            aVar = (C0833a) view.getTag();
        }
        if (i2 >= getCount()) {
            Log.e("MicroMsg.BackupMoveChooseAdapter", "getView error, position:%d, count:%d", Integer.valueOf(i2), Integer.valueOf(getCount()));
            AppMethodBeat.o(21380);
        } else {
            f.b bVar = b.cfv().cfz().cfr().get(i2);
            aVar.oMI.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.backup.backupmoveui.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(21376);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.oMG.contains(Integer.valueOf(i2))) {
                        a.this.oMG.remove(Integer.valueOf(i2));
                    } else {
                        a.this.oMG.add(Integer.valueOf(i2));
                    }
                    a.this.notifyDataSetChanged();
                    a.this.oMF.a(a.this.oMG);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21376);
                }
            });
            a.b.c(aVar.gvv, bVar.oJq);
            if (ab.Eq(bVar.oJq)) {
                aVar.jVO.setText(l.b(this.oMF, aa.getDisplayName(bVar.oJq, bVar.oJq), aVar.jVO.getTextSize()));
            } else {
                aVar.jVO.setText(l.b(this.oMF, aa.getDisplayName(bVar.oJq), aVar.jVO.getTextSize()));
            }
            if (this.oMG.contains(Integer.valueOf(i2))) {
                aVar.jVQ.setChecked(true);
            } else {
                aVar.jVQ.setChecked(false);
            }
            AppMethodBeat.o(21380);
        }
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.a$a  reason: collision with other inner class name */
    class C0833a {
        ImageView gvv;
        TextView jVO;
        CheckBox jVQ;
        RelativeLayout oMI;

        C0833a() {
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(21381);
        f.b bVar = b.cfv().cfz().cfr().get(i2);
        AppMethodBeat.o(21381);
        return bVar;
    }
}
