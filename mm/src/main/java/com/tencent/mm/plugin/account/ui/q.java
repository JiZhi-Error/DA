package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.p;

public final class q {
    public static p a(Context context, View view, String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(128472);
        View inflate = View.inflate(context, R.layout.bih, null);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(R.id.ie6);
        b bVar = new b(context, strArr);
        horizontalListView.setAdapter((ListAdapter) bVar);
        horizontalListView.setOnItemClickListener(onItemClickListener);
        horizontalListView.setBackgroundResource(R.drawable.bnu);
        p pVar = new p(inflate);
        pVar.setHeight(a.fromDPToPix(context, 120));
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.getCount(); i3++) {
            View view2 = bVar.getView(i3, null, horizontalListView);
            view2.measure(0, 0);
            i2 += view2.getMeasuredWidth();
        }
        pVar.setWidth(a.fromDPToPix(context, 20) + i2);
        pVar.showAsDropDown(view, (view.getWidth() - (a.fromDPToPix(context, 20) + i2)) / 2, 0);
        AppMethodBeat.o(128472);
        return pVar;
    }
}
