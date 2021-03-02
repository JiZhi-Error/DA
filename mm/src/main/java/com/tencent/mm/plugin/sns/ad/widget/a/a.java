package com.tencent.mm.plugin.sns.ad.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a {
    protected int DAQ;
    protected int DAR;
    protected int DAS;
    protected int DAT;
    protected FrameLayout DAU;
    protected BitmapDrawable DAV;
    protected ArrayList<Rect> DAW = new ArrayList<>();
    protected int atU;
    protected Bitmap mBmp;
    protected Context mContext;
    protected int mMaxSize;

    /* access modifiers changed from: protected */
    public abstract void c(View view, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract Rect eYz();

    public a(Context context, FrameLayout frameLayout, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6) {
        this.mBmp = bitmap;
        this.mContext = context;
        this.DAQ = i4;
        this.mMaxSize = i5;
        this.DAU = frameLayout;
        this.DAR = i2;
        this.DAS = i3;
        this.atU = i6;
        this.DAV = new BitmapDrawable(context.getResources(), this.mBmp);
        eYA();
    }

    private void eYA() {
        int i2 = 16;
        try {
            clear();
            int i3 = (int) (((((1.3f * ((float) this.DAR)) * ((float) this.DAS)) / ((float) this.mMaxSize)) / ((float) this.DAQ)) / 12.0f);
            if (i3 >= 16) {
                i2 = i3;
            }
            this.DAT = i2;
            Log.i("BaseAnimScene", "spireNum=" + this.DAT);
            for (int i4 = 0; i4 < this.DAT; i4++) {
                this.DAW.add(eYz());
            }
            Iterator<Rect> it = this.DAW.iterator();
            while (it.hasNext()) {
                Rect next = it.next();
                View view = new View(this.mContext);
                int abs = Math.abs(next.right - next.left);
                int abs2 = Math.abs(next.top - next.bottom);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(abs, abs2);
                layoutParams.leftMargin = next.left;
                layoutParams.topMargin = next.top;
                view.setBackgroundDrawable(this.DAV);
                this.DAU.addView(view, layoutParams);
                c(view, (abs / 2) + next.left, next.top + (abs2 / 2), abs2);
            }
        } catch (Throwable th) {
            Log.e("BaseAnimScene", "buildSprites exp=" + android.util.Log.getStackTraceString(th));
        }
    }

    public final void clear() {
        this.DAU.removeAllViews();
        this.DAW.clear();
    }

    protected static Rect a(Rect rect, int i2, int i3, int i4) {
        int i5 = i4 / 2;
        rect.left = i2 - i5;
        rect.right = i2 + i5;
        rect.top = i3 - i5;
        rect.bottom = i5 + i3;
        return rect;
    }
}
