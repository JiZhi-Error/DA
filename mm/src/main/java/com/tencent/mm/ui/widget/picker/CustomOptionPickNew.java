package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.picker.d.c;
import com.tencent.mm.ui.widget.picker.d.d;
import com.tencent.mm.ui.widget.picker.d.e;
import com.tencent.mm.ui.widget.picker.g.a;
import com.tencent.mm.ui.widget.picker.g.b;
import java.util.Arrays;
import java.util.List;

public class CustomOptionPickNew extends FrameLayout {
    private a<String> QSN;
    private Context context;
    private String[] ozA;
    private int ozE;
    private int ozF;

    public CustomOptionPickNew(Context context2) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y));
        AppMethodBeat.i(198401);
        this.context = context2;
        this.QSN = new a<>(context2);
        init();
        AppMethodBeat.o(198401);
    }

    public CustomOptionPickNew(Context context2, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context2, (int) R.style.a4y), attributeSet);
        AppMethodBeat.i(198402);
        this.context = context2;
        this.QSN = new a<>(context2);
        init();
        AppMethodBeat.o(198402);
    }

    public CustomOptionPickNew(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(198403);
        this.context = context2;
        this.QSN = new a<>(context2);
        init();
        AppMethodBeat.o(198403);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(198404);
        this.ozA = strArr;
        a<String> aVar = this.QSN;
        List<T> asList = Arrays.asList(strArr);
        b bVar = aVar.QUF;
        bVar.jLN = asList;
        bVar.QUH.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(bVar.jLN));
        bVar.QUH.setCurrentItem(0);
        bVar.QUH.setIsOptions(true);
        b.AnonymousClass1 r3 = new c() {
            /* class com.tencent.mm.ui.widget.picker.g.b.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.picker.d.c
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(198531);
                if (b.this.QUC != null) {
                    b.this.QUC.uO(b.this.QUH.getCurrentItem());
                }
                AppMethodBeat.o(198531);
            }
        };
        if (asList != null && bVar.jLO) {
            bVar.QUH.setOnItemSelectedListener(r3);
        }
        aVar.hcw();
        AppMethodBeat.o(198404);
    }

    public void setValue(int i2) {
        this.ozF = i2;
    }

    public final void apo(int i2) {
        AppMethodBeat.i(198405);
        this.QSN.hcx().setCurrentItem(i2);
        AppMethodBeat.o(198405);
    }

    private void init() {
        AppMethodBeat.i(198406);
        new com.tencent.mm.ui.widget.picker.b.a(this.context, new e() {
            /* class com.tencent.mm.ui.widget.picker.CustomOptionPickNew.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.picker.d.e
            public final void uP(int i2) {
                AppMethodBeat.i(198400);
                CustomOptionPickNew.this.ozE = i2;
                AppMethodBeat.o(198400);
            }
        }).apu(this.ozF).apt(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1)).a(this.QSN);
        setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        setItemHeight(this.context.getResources().getDimensionPixelSize(R.dimen.ce));
        setDividerColor(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1));
        this.QSN.QUF.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        this.QSN.QUF.QUH.aps(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).apr(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
        AppMethodBeat.o(198406);
    }

    public void setDividerColor(int i2) {
        AppMethodBeat.i(198407);
        this.QSN.QUF.setDividerColor(i2);
        AppMethodBeat.o(198407);
    }

    public int getValue() {
        AppMethodBeat.i(198408);
        this.QSN.blg();
        int i2 = this.ozE;
        AppMethodBeat.o(198408);
        return i2;
    }

    public void setOnValueChangedListener(d dVar) {
        AppMethodBeat.i(198409);
        this.QSN.setOnValueChangedListener(dVar);
        AppMethodBeat.o(198409);
    }

    public void setDividerHeight(float f2) {
        AppMethodBeat.i(198410);
        this.QSN.QUF.QUH.setDividerHeight(f2);
        AppMethodBeat.o(198410);
    }

    public void setItemHeight(int i2) {
    }

    public final String currentValue() {
        AppMethodBeat.i(198411);
        this.QSN.blg();
        String str = this.ozA[this.ozE];
        AppMethodBeat.o(198411);
        return str;
    }

    public WheelView getView() {
        AppMethodBeat.i(198412);
        WheelView hcx = this.QSN.hcx();
        AppMethodBeat.o(198412);
        return hcx;
    }
}
