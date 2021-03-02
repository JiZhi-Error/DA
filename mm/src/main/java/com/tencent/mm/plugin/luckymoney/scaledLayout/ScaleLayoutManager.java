package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager extends ViewPagerLayoutManager {
    public float aXu;
    private int hbd;
    private float yYh;
    private float yYi;
    private float yYj;

    public ScaleLayoutManager(Context context) {
        this(new a(context, 0));
        AppMethodBeat.i(65335);
        AppMethodBeat.o(65335);
    }

    private ScaleLayoutManager(a aVar) {
        this(aVar.context, aVar.hbd, aVar.aXu, aVar.yYi, aVar.yYj, aVar.orientation, aVar.yYh, aVar.yYm, aVar.yYn, aVar.atu);
        AppMethodBeat.i(65336);
        AppMethodBeat.o(65336);
    }

    private ScaleLayoutManager(Context context, int i2, float f2, float f3, float f4, int i3, float f5, int i4, int i5, boolean z) {
        super(i3, z);
        AppMethodBeat.i(213334);
        assertNotInLayoutOrScroll(null);
        if (this.yYC != i5) {
            this.yYC = i5;
            removeAllViews();
        }
        assertNotInLayoutOrScroll(null);
        if (this.yYA != i4) {
            this.yYA = i4;
            removeAllViews();
        }
        this.hbd = i2;
        this.aXu = f2;
        this.yYh = f5;
        this.yYi = f3;
        this.yYj = f4;
        AppMethodBeat.o(213334);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
    public final float efn() {
        return (float) (this.hbd + this.yYp);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
    public final void v(View view, float f2) {
        AppMethodBeat.i(65338);
        float abs = Math.abs((((float) this.yYr) + f2) - ((float) this.yYr));
        if (abs - ((float) this.yYp) > 0.0f) {
            abs = (float) this.yYp;
        }
        float f3 = 1.0f - ((abs / ((float) this.yYp)) * (1.0f - this.aXu));
        view.setScaleX(f3);
        view.setScaleY(f3);
        float abs2 = Math.abs(f2);
        float f4 = (((this.yYj - this.yYi) / this.yYw) * abs2) + this.yYi;
        if (abs2 >= this.yYw) {
            f4 = this.yYj;
        }
        view.setAlpha(f4);
        AppMethodBeat.o(65338);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
    public final float efo() {
        if (this.yYh == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / this.yYh;
    }

    public static class a {
        private static float yYk = 1.0f;
        private static float yYl = 1.0f;
        private float aXu;
        private boolean atu;
        private Context context;
        private int hbd = 0;
        private int orientation;
        private float yYh;
        private float yYi;
        private float yYj;
        private int yYm;
        private int yYn;

        public a(Context context2, int i2) {
            this.context = context2;
            this.orientation = 0;
            this.aXu = 0.8f;
            this.yYh = 1.0f;
            this.yYi = yYl;
            this.yYj = yYk;
            this.atu = false;
            this.yYn = Integer.MAX_VALUE;
            this.yYm = -1;
        }
    }
}
