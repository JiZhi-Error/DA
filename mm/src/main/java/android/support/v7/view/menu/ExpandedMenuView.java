package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements h.b, p, AdapterView.OnItemClickListener {
    private static final int[] afR = {16842964, 16843049};
    private h aaQ;
    private int afS;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        az a2 = az.a(context, attributeSet, afR, i2, 0);
        if (a2.hasValue(0)) {
            setBackgroundDrawable(a2.getDrawable(0));
        }
        if (a2.hasValue(1)) {
            setDivider(a2.getDrawable(1));
        }
        a2.ayy.recycle();
    }

    @Override // android.support.v7.view.menu.p
    public final void a(h hVar) {
        this.aaQ = hVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.support.v7.view.menu.h.b
    public final boolean f(j jVar) {
        return this.aaQ.a(jVar, (o) null, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        f((j) getAdapter().getItem(i2));
    }

    public final int getWindowAnimations() {
        return this.afS;
    }
}
