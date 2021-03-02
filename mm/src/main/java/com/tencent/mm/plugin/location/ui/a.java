package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends j {
    private int yHh = 8;
    private ArrayList<String> yHi = new ArrayList<>();

    public a() {
        AppMethodBeat.i(55794);
        AppMethodBeat.o(55794);
    }

    public final void setData(ArrayList<String> arrayList) {
        boolean z;
        AppMethodBeat.i(55795);
        this.yHi.clear();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.yHi.add(it.next());
        }
        Object[] objArr = new Object[1];
        if (this.OQN == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", objArr);
        if (this.OQN == null) {
            AppMethodBeat.o(55795);
            return;
        }
        this.OQN.cmy();
        AppMethodBeat.o(55795);
    }

    @Override // com.tencent.mm.ui.base.j
    public final int getCount() {
        AppMethodBeat.i(55796);
        int size = this.yHi.size();
        AppMethodBeat.o(55796);
        return size;
    }

    @Override // com.tencent.mm.ui.base.j
    public final View e(int i2, View view) {
        AppMethodBeat.i(55797);
        C1462a aVar = new C1462a();
        if (view == null) {
            view = View.inflate(MMApplicationContext.getContext(), R.layout.hi, null);
            aVar.keC = (ImageView) view.findViewById(R.id.wz);
            aVar.yHj = (TextView) view.findViewById(R.id.j1t);
            view.setTag(aVar);
        } else {
            aVar = (C1462a) view.getTag();
        }
        String str = this.yHi.get(i2);
        a.b.c(aVar.keC, str);
        String displayName = aa.getDisplayName(str);
        if (displayName.length() > this.yHh) {
            displayName = ((Object) displayName.subSequence(0, this.yHh + 1)) + "...";
        }
        aVar.yHj.setText(displayName);
        AppMethodBeat.o(55797);
        return view;
    }

    @Override // com.tencent.mm.ui.base.j
    public final Object getItem(int i2) {
        AppMethodBeat.i(55798);
        String str = this.yHi.get(i2);
        AppMethodBeat.o(55798);
        return str;
    }

    @Override // com.tencent.mm.ui.base.j
    public final long getItemId(int i2) {
        return (long) i2;
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.a$a  reason: collision with other inner class name */
    class C1462a {
        ImageView keC;
        TextView yHj;

        C1462a() {
        }
    }
}
