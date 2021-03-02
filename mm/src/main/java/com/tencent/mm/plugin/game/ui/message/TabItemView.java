package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;

public class TabItemView extends LinearLayout {
    private int dDG;
    private TextView trw;
    private TextView xYM;
    private View xYN;

    public TabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(183906);
        b(context, attributeSet);
        AppMethodBeat.o(183906);
    }

    public TabItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(183907);
        b(context, attributeSet);
        AppMethodBeat.o(183907);
    }

    public void setShowType(int i2) {
        this.dDG = i2;
    }

    public void setUnreadCount(int i2) {
        AppMethodBeat.i(183908);
        if (i2 > 0) {
            this.xYM.setVisibility(0);
            if (i2 < 100) {
                this.xYM.setText(String.valueOf(i2));
                AppMethodBeat.o(183908);
                return;
            }
            this.xYM.setText(R.string.drn);
            AppMethodBeat.o(183908);
            return;
        }
        this.xYM.setVisibility(8);
        AppMethodBeat.o(183908);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(183909);
        if (z) {
            this.trw.setTextColor(getResources().getColor(R.color.a2x));
            this.xYN.setVisibility(0);
            this.xYM.setVisibility(8);
            ((f) g.af(f.class)).dSK().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.dDG)));
            ((e) g.af(e.class)).dSJ();
            int i2 = this.dDG;
            o dVs = r.dVs();
            if (dVs != null && dVs.field_showType == i2) {
                r.dVt();
            }
            AppMethodBeat.o(183909);
            return;
        }
        this.trw.setTextColor(getResources().getColor(R.color.l4));
        this.xYN.setVisibility(8);
        AppMethodBeat.o(183909);
    }

    private void b(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(183910);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.TabItemView);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.arr, (ViewGroup) this, true);
        this.trw = (TextView) findViewById(R.id.iga);
        this.xYM = (TextView) findViewById(R.id.ig_);
        this.xYN = findViewById(R.id.ig8);
        this.trw.setText(string);
        if (a.jk(getContext())) {
            this.trw.setTextSize(0, ((float) a.aH(getContext(), R.dimen.ft)) * a.ji(getContext()));
            this.xYM.setTextSize(0, ((float) a.aH(getContext(), R.dimen.go)) * a.ji(getContext()));
        }
        AppMethodBeat.o(183910);
    }
}
