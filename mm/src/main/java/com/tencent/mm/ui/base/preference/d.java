package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import java.util.HashMap;
import junit.framework.Assert;

/* access modifiers changed from: package-private */
public final class d extends BaseAdapter {
    protected int BaH = -1;
    protected CharSequence[] OXw;
    protected CharSequence[] OXx;
    private final Context context;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap<>();

    public d(Context context2) {
        AppMethodBeat.i(142528);
        this.context = context2;
        this.style = 1;
        AppMethodBeat.o(142528);
    }

    /* access modifiers changed from: protected */
    public final void gLC() {
        AppMethodBeat.i(142529);
        if (this.OXw == null) {
            this.OXw = new CharSequence[0];
        }
        if (this.OXx == null) {
            this.OXx = new CharSequence[0];
        }
        Assert.assertTrue("entries count different", this.OXw.length == this.OXx.length);
        this.values.clear();
        for (int i2 = 0; i2 < this.OXx.length; i2++) {
            this.values.put(this.OXx[i2], new c(this.OXw[i2], 1048576 + i2));
        }
        AppMethodBeat.o(142529);
    }

    public final int getCount() {
        return this.OXx.length;
    }

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142530);
        if (view == null) {
            view = aa.jQ(this.context).inflate(R.layout.b9x, (ViewGroup) null);
            a aVar = new a();
            aVar.BaI = (TextView) view.findViewById(R.id.ijq);
            aVar.BaJ = (CheckBox) view.findViewById(R.id.azg);
            aVar.BaK = (RadioButton) view.findViewById(R.id.gqn);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.BaI.setText(this.OXw[i2]);
        switch (this.style) {
            case 1:
                aVar2.BaJ.setVisibility(8);
                aVar2.BaK.setVisibility(0);
                aVar2.BaK.setChecked(this.OXx[i2].equals(this.value));
                break;
            case 2:
                aVar2.BaJ.setVisibility(0);
                aVar2.BaK.setVisibility(8);
                aVar2.BaJ.setChecked(this.OXx[i2].equals(this.value));
                break;
            default:
                aVar2.BaJ.setVisibility(8);
                aVar2.BaK.setVisibility(8);
                break;
        }
        AppMethodBeat.o(142530);
        return view;
    }

    static class a {
        TextView BaI;
        CheckBox BaJ;
        RadioButton BaK;

        a() {
        }
    }
}
