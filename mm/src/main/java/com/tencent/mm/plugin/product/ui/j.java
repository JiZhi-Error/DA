package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;

public final class j extends BaseAdapter {
    m BbG;
    String BbH;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(67035);
        h Uw = Uw(i2);
        AppMethodBeat.o(67035);
        return Uw;
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(67031);
        if (this.BbG.Bag != null) {
            int size = this.BbG.Bag.size();
            AppMethodBeat.o(67031);
            return size;
        }
        AppMethodBeat.o(67031);
        return 0;
    }

    private h Uw(int i2) {
        AppMethodBeat.i(67032);
        h hVar = this.BbG.Bag.get(i2);
        AppMethodBeat.o(67032);
        return hVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final boolean isEnabled(int i2) {
        AppMethodBeat.i(67033);
        boolean z = Uw(i2).iJ;
        AppMethodBeat.o(67033);
        return z;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        AppMethodBeat.i(67034);
        h Uw = Uw(i2);
        if (view == null || view.getTag() == null) {
            view2 = View.inflate(this.mContext, R.layout.bj7, null);
        } else {
            view2 = view;
        }
        CheckBox checkBox = (CheckBox) view2;
        checkBox.setText(Uw.name);
        checkBox.setEnabled(Uw.iJ);
        checkBox.setChecked(Uw.id.equals(this.BbH));
        if (!Uw.iJ) {
            view2.setBackgroundResource(R.drawable.ckk);
        } else if (Uw.id.equals(this.BbH)) {
            view2.setBackgroundResource(R.drawable.ckm);
        } else {
            view2.setBackgroundResource(R.drawable.ckl);
        }
        view2.setTag(new Pair(this.BbG.Bae, Uw.id));
        AppMethodBeat.o(67034);
        return view2;
    }
}
