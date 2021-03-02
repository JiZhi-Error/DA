package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView ayz;
    Context mContext;
    private TextView qlo;
    public int qlp = 0;
    boolean qlq = true;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113886);
        setLayoutResource(R.layout.b8j);
        this.mContext = context;
        AppMethodBeat.o(113886);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(113887);
        super.onBindView(view);
        this.qlo = (TextView) view.findViewById(16908304);
        this.ayz = (TextView) view.findViewById(16908310);
        cxJ();
        kC(this.qlq);
        AppMethodBeat.o(113887);
    }

    public final void cxJ() {
        AppMethodBeat.i(113888);
        if (!(this.qlo == null || this.qlp == 0)) {
            this.qlo.setTextColor(this.qlp);
        }
        AppMethodBeat.o(113888);
    }

    public final void cxK() {
        AppMethodBeat.i(113889);
        kC(false);
        this.qlq = false;
        AppMethodBeat.o(113889);
    }

    private void kC(boolean z) {
        AppMethodBeat.i(113890);
        if (this.ayz != null) {
            Rect dD = dD(this.ayz);
            this.ayz.setSingleLine(z);
            if (!z) {
                dD.top = this.mContext.getResources().getDimensionPixelOffset(R.dimen.hs);
                dD.bottom = this.mContext.getResources().getDimensionPixelOffset(R.dimen.hs);
                e(this.ayz, dD);
            }
        }
        AppMethodBeat.o(113890);
    }

    private static Rect dD(View view) {
        AppMethodBeat.i(113891);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(113891);
        return rect;
    }

    private static void e(View view, Rect rect) {
        AppMethodBeat.i(113892);
        if (view == null || rect == null) {
            AppMethodBeat.o(113892);
            return;
        }
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(113892);
    }
}
