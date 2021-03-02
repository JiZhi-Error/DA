package com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.rtmp.TXLiveConstants;

public class BubbleView extends RelativeLayout implements Runnable {
    protected int backgroundColor;
    private TextView gtJ;
    protected Context mContext;
    protected a zYk;
    protected float zYl;
    protected RelativeLayout zYm;
    protected ImageView zYn;
    protected int zYo;
    protected int zYp;
    float zYq = 0.0f;
    float zYr = 0.0f;
    float zYs = 0.0f;
    int zYt = -1;

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(239496);
        c(context, attributeSet);
        AppMethodBeat.o(239496);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(239497);
        c(context, attributeSet);
        AppMethodBeat.o(239497);
    }

    private void c(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(239498);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1485a.BubbleTextView);
        float dimension = obtainStyledAttributes.getDimension(5, 0.0f);
        this.backgroundColor = obtainStyledAttributes.getColor(4, 0);
        this.zYq = obtainStyledAttributes.getDimension(2, 0.0f);
        this.zYr = obtainStyledAttributes.getDimension(0, 0.0f);
        int color = obtainStyledAttributes.getColor(7, 0);
        float dimension2 = obtainStyledAttributes.getDimension(8, 0.0f);
        String string = obtainStyledAttributes.getString(6);
        this.zYt = obtainStyledAttributes.getResourceId(1, -1);
        setCurDirection(obtainStyledAttributes.getInt(3, 3));
        setRelativePosition(obtainStyledAttributes.getFraction(12, 1, 1, 0.3f));
        setCurThemeStyle(color);
        this.zYs = obtainStyledAttributes.getDimension(10, 0.0f);
        obtainStyledAttributes.recycle();
        a(dimension, this.backgroundColor, color, dimension2, string);
        AppMethodBeat.o(239498);
    }

    public void setCurThemeStyle(int i2) {
        this.zYp = 3;
    }

    private void setRelativePosition(float f2) {
        if (f2 < 0.2f) {
            this.zYl = 0.2f;
        } else if (f2 > 0.8f) {
            this.zYl = 0.8f;
        } else {
            this.zYl = f2;
        }
    }

    private void setCurDirection(int i2) {
        switch (i2) {
            case 1:
                this.zYk = a.LEFT;
                return;
            case 2:
                this.zYk = a.TOP;
                return;
            case 3:
                this.zYk = a.RIGHT;
                return;
            case 4:
                this.zYk = a.BOTTOM;
                return;
            default:
                return;
        }
    }

    private void a(float f2, int i2, int i3, float f3, String str) {
        int i4;
        AppMethodBeat.i(239499);
        this.zYm = new RelativeLayout(this.mContext);
        this.zYm.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) this.zYs);
        this.zYm.setBackground(new a(i2, f2));
        a(i3, f3, str);
        this.zYn = new ImageView(this.mContext);
        this.zYn.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) this.zYq, (int) this.zYr);
        switch (this.zYk) {
            case LEFT:
                i4 = 90;
                layoutParams.addRule(17, this.zYn.getId());
                break;
            case TOP:
                i4 = TXLiveConstants.RENDER_ROTATION_180;
                layoutParams.addRule(3, this.zYn.getId());
                break;
            case BOTTOM:
                i4 = 0;
                layoutParams2.addRule(3, this.zYm.getId());
                break;
            default:
                i4 = 270;
                layoutParams2.addRule(17, this.zYm.getId());
                break;
        }
        this.zYn.setImageDrawable(new BitmapDrawable(BitmapUtil.rotate(b(ar.m(this.mContext, this.zYt, this.mContext.getResources().getColor(R.color.am)), this.zYq, this.zYr), (float) i4)));
        addView(this.zYn, layoutParams2);
        addView(this.zYm, layoutParams);
        this.zYm.post(this);
        setClickable(true);
        AppMethodBeat.o(239499);
    }

    private static Bitmap b(Drawable drawable, float f2, float f3) {
        AppMethodBeat.i(239500);
        Bitmap createBitmap = Bitmap.createBitmap((int) f2, (int) f3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, (int) f2, (int) f3);
        drawable.draw(canvas);
        AppMethodBeat.o(239500);
        return createBitmap;
    }

    private void a(int i2, float f2, String str) {
        AppMethodBeat.i(239501);
        b(i2, f2, str);
        this.zYm.addView(this.gtJ);
        AppMethodBeat.o(239501);
    }

    private void b(int i2, float f2, String str) {
        AppMethodBeat.i(239502);
        this.gtJ = new TextView(this.mContext);
        this.gtJ.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(17);
        layoutParams.setMarginStart(f.zSe);
        layoutParams.setMarginEnd(f.zSe);
        layoutParams.topMargin = f.zSe;
        layoutParams.bottomMargin = f.zSe;
        this.gtJ.setLayoutParams(layoutParams);
        this.gtJ.setTextColor(i2);
        this.gtJ.setTextSize((float) at.E(this.mContext, (int) f2));
        this.gtJ.setText(str);
        AppMethodBeat.o(239502);
    }

    public void run() {
        AppMethodBeat.i(239503);
        int width = this.zYm.getWidth();
        int height = this.zYm.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zYn.getLayoutParams();
        switch (this.zYk) {
            case TOP:
            case BOTTOM:
                this.zYo = (int) ((((float) width) * this.zYl) - ((float) (this.zYn.getWidth() / 2)));
                layoutParams.setMargins(this.zYo, 0, 0, 0);
                break;
            default:
                this.zYo = (int) ((((float) height) * this.zYl) - ((float) (this.zYn.getHeight() / 2)));
                layoutParams.setMargins(0, this.zYo, 0, 0);
                break;
        }
        this.zYn.setLayoutParams(layoutParams);
        AppMethodBeat.o(239503);
    }

    public float getRelative() {
        return this.zYl;
    }

    public enum a {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;

        public static a valueOf(String str) {
            AppMethodBeat.i(239494);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(239494);
            return aVar;
        }

        static {
            AppMethodBeat.i(239495);
            AppMethodBeat.o(239495);
        }
    }
}
