package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class DoubleTabView extends RelativeLayout {
    private MMTabView OAq;
    MMTabView OAr;
    private MMTabView OAs;
    private String OAt;
    private String OAu;
    private String OAv;
    private a OAw;
    private Matrix mMatrix = new Matrix();
    private int rmI;
    private int rmJ = 0;
    private Bitmap rmK;
    private LinearLayout rmL;
    private ImageView rmM;
    protected View.OnClickListener rmQ = new View.OnClickListener() {
        /* class com.tencent.mm.ui.DoubleTabView.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(141284);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            if (DoubleTabView.this.OAw != null) {
                DoubleTabView.this.OAw.onTabClick(intValue);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(141284);
        }
    };

    public interface a {
        void onTabClick(int i2);
    }

    public DoubleTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141285);
        init();
        AppMethodBeat.o(141285);
    }

    public DoubleTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141286);
        init();
        AppMethodBeat.o(141286);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141287);
        super.onLayout(z, i2, i3, i4, i5);
        this.rmI = (i4 - i2) / 2;
        int i6 = this.rmI;
        if (this.rmK == null || this.rmK.getWidth() != i6) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.rmK == null ? -1 : this.rmK.getWidth());
            objArr[1] = Integer.valueOf(i6);
            Log.w("MicroMsg.DoubleTabView", "sharp width changed, from %d to %d", objArr);
            this.rmK = Bitmap.createBitmap(i6, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
            new Canvas(this.rmK).drawColor(getResources().getColor(R.color.afp));
            p(this.rmJ, 0.0f);
            this.rmM.setImageBitmap(this.rmK);
        }
        setTo(this.rmJ);
        AppMethodBeat.o(141287);
    }

    private void init() {
        AppMethodBeat.i(141288);
        cIm();
        cIn();
        gHn();
        gHo();
        AppMethodBeat.o(141288);
    }

    private void cIm() {
        AppMethodBeat.i(141289);
        this.rmL = new LinearLayout(getContext());
        this.rmL.setBackgroundResource(R.color.afz);
        this.rmL.setId(R.id.bt9);
        this.rmL.setOrientation(0);
        addView(this.rmL, new RelativeLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(141289);
    }

    private void cIn() {
        AppMethodBeat.i(141290);
        this.rmM = new ImageView(getContext());
        this.rmM.setImageMatrix(this.mMatrix);
        this.rmM.setScaleType(ImageView.ScaleType.MATRIX);
        this.rmM.setId(R.id.bt_);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.id.bt9);
        addView(this.rmM, layoutParams);
        AppMethodBeat.o(141290);
    }

    public void setFirstTabString(String str) {
        AppMethodBeat.i(141291);
        this.OAt = str;
        this.OAq.setText(str);
        requestLayout();
        AppMethodBeat.o(141291);
    }

    public void setSecondTabString(String str) {
        AppMethodBeat.i(141292);
        this.OAu = str;
        this.OAr.setText(str);
        requestLayout();
        AppMethodBeat.o(141292);
    }

    public void setThirdTabString(String str) {
        AppMethodBeat.i(205108);
        this.OAv = str;
        this.OAs.setText(str);
        requestLayout();
        AppMethodBeat.o(205108);
    }

    private void gHn() {
        AppMethodBeat.i(141293);
        this.OAq = Gd(0);
        this.OAq.setText(this.OAt);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        this.rmL.addView(this.OAq, layoutParams);
        AppMethodBeat.o(141293);
    }

    private void gHo() {
        AppMethodBeat.i(141294);
        this.OAr = Gd(1);
        this.OAr.setText(this.OAu);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.amu));
        layoutParams.weight = 1.0f;
        this.rmL.addView(this.OAr, layoutParams);
        AppMethodBeat.o(141294);
    }

    private MMTabView Gd(int i2) {
        AppMethodBeat.i(141295);
        MMTabView mMTabView = new MMTabView(getContext(), i2);
        mMTabView.setTag(Integer.valueOf(i2));
        mMTabView.setOnClickListener(this.rmQ);
        AppMethodBeat.o(141295);
        return mMTabView;
    }

    public void setOnTabClickListener(a aVar) {
        this.OAw = aVar;
    }

    public int getCurentIndex() {
        return this.rmJ;
    }

    public final void p(int i2, float f2) {
        AppMethodBeat.i(141296);
        this.mMatrix.setTranslate(((float) this.rmI) * (((float) i2) + f2), 0.0f);
        this.rmM.setImageMatrix(this.mMatrix);
        AppMethodBeat.o(141296);
    }

    public void setTo(int i2) {
        AppMethodBeat.i(141297);
        this.rmJ = i2;
        this.OAq.setTextColor(this.rmJ == 0 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        this.OAr.setTextColor(this.rmJ == 1 ? getResources().getColor(R.color.afp) : getContext().getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(141297);
    }

    public void setFirstTabUnReadCount(String str) {
        AppMethodBeat.i(141298);
        if (this.OAq != null) {
            this.OAq.setUnread(str);
        }
        AppMethodBeat.o(141298);
    }

    public void setSecondTabUnReadCount(String str) {
        AppMethodBeat.i(141299);
        if (this.OAr != null) {
            this.OAr.setUnread(str);
        }
        AppMethodBeat.o(141299);
    }
}
