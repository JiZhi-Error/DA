package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c implements a {
    public static final char[] RAN = {8230};
    private static final String RAO = new String(RAN);
    private int AoL;
    protected String RAP;
    protected char[] RAQ;
    protected float[] RAR;
    protected float[] RAS;
    protected float[] RAT = new float[a.RAJ.length];
    protected float[] RAU = new float[a.RAK.length];
    protected HashMap<Character, Float> RAV = new HashMap<>(a.RAJ.length);
    public ArrayList<b> RAX = new ArrayList<>();
    private LinkedList<b> RAY = new LinkedList<>();
    private float RAZ;
    private float RBa;
    private float RBb;
    private float RBc;
    private float RBd;
    private TextPaint RBe = new TextPaint();
    private float[] RBf;
    e<ImageSpan> RBg = new e<>(ImageSpan.class);
    private e<LineHeightSpan> RBh = new e<>(LineHeightSpan.class);
    e<AbsoluteSizeSpan> RBi = new e<>(AbsoluteSizeSpan.class);
    e<RelativeSizeSpan> RBj = new e<>(RelativeSizeSpan.class);
    private e<BackgroundColorSpan> RBk = new e<>(BackgroundColorSpan.class);
    e<ForegroundColorSpan> RBl = new e<>(ForegroundColorSpan.class);
    e<ClickableSpan> RBm = new e<>(ClickableSpan.class);
    e<LineBackgroundSpan> RBn = new e<>(LineBackgroundSpan.class);
    private float RBo = 0.0f;
    private LinkedList<com.tencent.neattextview.textview.b.c> RBp;
    protected boolean[] RBq;
    private int RBr = 0;
    private int RBs = 0;
    private int RBt = 0;
    protected TextPaint ayn;
    private int bJw = 0;
    private TextUtils.TruncateAt hux;
    protected CharSequence mText;
    private float qTi;

    /* access modifiers changed from: protected */
    public abstract void a(TextPaint textPaint, float[] fArr, float f2, int i2, boolean z);

    public c(CharSequence charSequence, float[] fArr) {
        this.mText = charSequence;
        this.RAP = charSequence.toString();
        this.RAQ = this.RAP.toCharArray();
        if (fArr != null) {
            this.RAR = new float[fArr.length];
            System.arraycopy(fArr, 0, this.RAR, 0, fArr.length);
        }
    }

    public final String hiP() {
        return this.RAP;
    }

    public final void a(TextPaint textPaint, float f2, float f3, float f4, float f5, float f6, int i2, TextUtils.TruncateAt truncateAt, float f7, boolean z, int i3) {
        this.ayn = new TextPaint(textPaint);
        this.RBd = f7;
        this.RAZ = f3;
        this.qTi = f2;
        this.RBa = f4;
        this.RBb = f5;
        this.bJw = i2;
        this.hux = truncateAt;
        this.RBc = f6;
        this.RBf = null;
        this.AoL = i3;
        int length = this.mText.length();
        if (this.RAR == null) {
            this.RAR = new float[length];
            textPaint.getTextWidths(this.RAP, this.RAR);
        }
        this.RBq = new boolean[length];
        a(this.mText, textPaint, this.RBq);
        c(textPaint);
        a(textPaint, new float[0], f2, i2, z);
        a(truncateAt, f7, textPaint);
    }

    public final void a(TextPaint textPaint, float[] fArr, float f2, float f3, float f4, float f5, float f6, int i2, TextUtils.TruncateAt truncateAt, float f7, boolean z, int i3) {
        this.ayn = new TextPaint(textPaint);
        this.RBd = f7;
        this.RAZ = f3;
        this.qTi = f2;
        this.RBa = f4;
        this.RBb = f5;
        this.bJw = i2;
        this.hux = truncateAt;
        this.RBc = f6;
        this.RBf = null;
        this.AoL = i3;
        int length = this.mText.length();
        if (this.RAR == null) {
            this.RAR = new float[length];
            textPaint.getTextWidths(this.RAP, this.RAR);
        }
        this.RBq = new boolean[length];
        a(this.mText, textPaint, this.RBq);
        c(textPaint);
        float[] fArr2 = new float[fArr.length];
        for (int i4 = 0; i4 < fArr.length; i4++) {
            fArr2[i4] = f2 - fArr[i4];
        }
        a(textPaint, fArr2, f2, i2, z);
        a(truncateAt, f7, textPaint);
    }

    public final void a(Canvas canvas, float f2, float f3) {
        canvas.save();
        canvas.translate(f2, f3);
        float f4 = 0.0f;
        Iterator<b> it = this.RAY.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, this.ayn, this.RAX);
        }
        Iterator<b> it2 = this.RAX.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            next.a(canvas, this.ayn, f4);
            f4 = next.getHeight() + f4;
        }
        canvas.restore();
    }

    public final float[] hiI() {
        return this.RAR;
    }

    public final CharSequence getText() {
        return this.mText;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public int hiG() {
        return this.RAX.size();
    }

    private void a(CharSequence charSequence, TextPaint textPaint, boolean[] zArr) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            int length = charSequence.length();
            this.RBg.a(spanned, length);
            this.RBh.a(spanned, length);
            this.RBi.a(spanned, length);
            this.RBj.a(spanned, length);
            this.RBl.a(spanned, length);
            this.RBk.a(spanned, length);
            this.RBm.a(spanned, length);
            this.RBn.a(spanned, length);
        }
        this.RBe.set(textPaint);
        for (int i2 = 0; i2 < this.RBi.RBK; i2++) {
            this.RBi.RBL[i2].updateMeasureState(this.RBe);
            int i3 = this.RBi.RBM[i2];
            int i4 = this.RBi.RBN[i2];
            int i5 = i4 - i3;
            float[] fArr = new float[i5];
            this.RBe.getTextWidths(charSequence, i3, i4, fArr);
            System.arraycopy(fArr, 0, this.RAR, i3, i5);
            if (this.RAS == null) {
                this.RAS = new float[charSequence.length()];
            }
            float[] fArr2 = this.RAS;
            fArr2[i3] = Math.max(fArr2[i3], this.RBe.getTextSize());
        }
        for (int i6 = 0; i6 < this.RBj.RBK; i6++) {
            this.RBj.RBL[i6].updateMeasureState(this.RBe);
            int i7 = this.RBj.RBM[i6];
            int i8 = this.RBj.RBN[i6];
            int i9 = i8 - i7;
            float[] fArr3 = new float[i9];
            this.RBe.getTextWidths(charSequence, i7, i8, fArr3);
            System.arraycopy(fArr3, 0, this.RAR, i7, i9);
            if (this.RAS == null) {
                this.RAS = new float[charSequence.length()];
            }
            float[] fArr4 = this.RAS;
            fArr4[i7] = Math.max(fArr4[i7], this.RBe.getTextSize());
        }
        for (int i10 = 0; i10 < this.RBh.RBK; i10++) {
            E e2 = this.RBh.RBL[i10];
            int i11 = this.RBh.RBM[i10];
            int i12 = this.RBh.RBN[i10];
            if (this.RAS == null) {
                this.RAS = new float[charSequence.length()];
            }
            Paint.FontMetricsInt fontMetricsInt = this.ayn.getFontMetricsInt();
            e2.chooseHeight(charSequence, i11, i12, 0, 0, fontMetricsInt);
            float[] fArr5 = this.RAS;
            fArr5[i11] = Math.max(fArr5[i11], (float) (fontMetricsInt.descent - fontMetricsInt.ascent));
        }
        for (int i13 = 0; i13 < this.RBg.RBK; i13++) {
            E e3 = this.RBg.RBL[i13];
            int i14 = this.RBg.RBM[i13];
            int i15 = this.RBg.RBN[i13] - i14;
            Drawable drawable = e3.getDrawable();
            Rect rect = new Rect();
            if (drawable != null) {
                rect.set(drawable.getBounds());
            }
            this.RAR[i14] = (float) rect.width();
            zArr[i14] = true;
            int i16 = i14 + 1;
            while (i16 < i14 + i15 && i16 < this.RAR.length) {
                this.RAR[i16] = 0.0f;
                zArr[i16] = true;
                i16++;
            }
            if (this.RAS == null) {
                this.RAS = new float[charSequence.length()];
            }
            Paint.FontMetrics fontMetrics = this.ayn.getFontMetrics();
            float f2 = fontMetrics.bottom - fontMetrics.top;
            float[] fArr6 = this.RAS;
            fArr6[i14] = Math.max(fArr6[i14], Math.max(f2, (float) rect.height()));
        }
        for (int i17 = 0; i17 < this.RBk.RBK; i17++) {
            this.RAY.add(new com.tencent.neattextview.textview.b.a(this.RBk.RBM[i17], this.RBk.RBN[i17], this.RBk.RBL[i17]));
        }
        for (int i18 = 0; i18 < this.RBm.RBK; i18++) {
            this.RAY.add(new com.tencent.neattextview.textview.b.c(this.RBm.RBM[i18], this.RBm.RBN[i18], this.RBm.RBL[i18]));
        }
    }

    public final float[] hiQ() {
        float f2 = 0.0f;
        if (this.RBf == null) {
            Iterator<b> it = this.RAX.iterator();
            float f3 = 0.0f;
            while (it.hasNext()) {
                b next = it.next();
                if (f3 < next.getWidth()) {
                    f3 = next.getWidth();
                }
                f2 = next.getHeight() + f2;
            }
            this.RBf = new float[]{f3, f2};
        }
        return this.RBf;
    }

    public final TextPaint getTextPaint() {
        return this.ayn;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int mn(int i2, int i3) {
        int i4 = (int) (((float) i2) - this.RBa);
        int i5 = (int) (((float) i3) - this.RBb);
        Iterator<b> it = this.RAX.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.hiK().contains((float) i4, (float) i5)) {
                return next.aqs(i4);
            }
        }
        return this.RAQ.length;
    }

    private void c(Paint paint) {
        this.RAV.clear();
        Rect rect = new Rect();
        char[] cArr = a.RAJ;
        int i2 = 0;
        for (char c2 : cArr) {
            float measureText = paint.measureText(String.valueOf(c2));
            paint.getTextBounds(String.valueOf(c2), 0, 1, rect);
            this.RAT[i2] = measureText - ((float) rect.right);
            i2++;
        }
        int i3 = 0;
        for (char c3 : a.RAK) {
            paint.getTextBounds(String.valueOf(c3), 0, 1, rect);
            float max = (float) Math.max(rect.left, 0);
            this.RAU[i3] = max;
            this.RAV.put(Character.valueOf(a.RAK[i3]), Float.valueOf(max));
            i3++;
        }
    }

    public final HashMap<Character, Float> hiR() {
        return this.RAV;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final List<com.tencent.neattextview.textview.b.c> hiH() {
        if (this.RBp == null) {
            this.RBp = new LinkedList<>();
            Iterator<b> it = this.RAY.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.getClass() == com.tencent.neattextview.textview.b.c.class) {
                    this.RBp.add((com.tencent.neattextview.textview.b.c) next);
                }
            }
        }
        return this.RBp;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getEllipsisCount(int i2) {
        if (this.RBt == i2) {
            return this.RBs;
        }
        return 0;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getEllipsisStart(int i2) {
        if (this.RBt == i2) {
            return this.RBr;
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.text.TextUtils.TruncateAt r11, float r12, android.text.TextPaint r13) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.neattextview.textview.layout.c.a(android.text.TextUtils$TruncateAt, float, android.text.TextPaint):void");
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineBaseline(int i2) {
        b bVar;
        int size = this.RAX.size();
        if (size > i2) {
            bVar = this.RAX.get(i2);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = this.RAX.get(size - 1);
        }
        return (int) bVar.hiO();
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineTop(int i2) {
        b bVar;
        int size = this.RAX.size();
        if (size > i2) {
            bVar = this.RAX.get(i2);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = this.RAX.get(size - 1);
        }
        return (int) bVar.hiJ().top;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineBottom(int i2) {
        b bVar;
        int size = this.RAX.size();
        if (size > i2) {
            bVar = this.RAX.get(i2);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = this.RAX.get(size - 1);
        }
        return (int) bVar.hiJ().bottom;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineForOffset(int i2) {
        int i3 = 0;
        Iterator<b> it = this.RAX.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.getStart() <= i2 && i2 < next.getEnd()) {
                return i3;
            }
            i3++;
        }
        return i3 - 1;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final float getPrimaryHorizontal(int i2) {
        int lineForOffset = getLineForOffset(i2);
        if (lineForOffset < 0) {
            return 0.0f;
        }
        return this.RAX.get(lineForOffset).getPrimaryHorizontal(i2);
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getOffsetForHorizontal(int i2, float f2) {
        float f3 = f2 - this.RBa;
        if (this.RAX.size() > i2) {
            return this.RAX.get(i2).aqs((int) f3);
        }
        return 0;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final float getLineWidth(int i2) {
        if (this.RAX.size() > i2) {
            return this.RAX.get(i2).hiJ().width();
        }
        return 0.0f;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineStart(int i2) {
        if (this.RAX.size() > i2) {
            return this.RAX.get(i2).getStart();
        }
        return this.RAQ.length;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final int getLineForVertical(int i2) {
        int i3 = (int) (((float) i2) - this.RBb);
        Iterator<b> it = this.RAX.iterator();
        float f2 = 0.0f;
        int i4 = 0;
        while (it.hasNext()) {
            b next = it.next();
            if (f2 == 0.0f) {
                f2 = next.hiK().top;
            }
            RectF hiK = next.hiK();
            if (hiK.contains(hiK.centerX(), (float) i3)) {
                return i4;
            }
            i4++;
        }
        if (((float) i3) <= f2) {
            return 0;
        }
        return i4 - 1;
    }

    @Override // com.tencent.neattextview.textview.layout.a
    public final float getLineRight(int i2) {
        if (this.RAX.size() > i2) {
            return this.RAX.get(i2).hiJ().right;
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public final void a(char[] cArr, int i2, int i3, float f2, float[] fArr, int i4, float f3, boolean z, float f4, float f5) {
        Paint.FontMetrics fontMetrics = this.ayn.getFontMetrics();
        float f6 = fontMetrics.bottom - fontMetrics.top;
        if (this.RAS != null) {
            int i5 = i2;
            while (i5 < i3) {
                float f7 = this.RAS[i5];
                if (f7 <= 0.0f) {
                    f7 = f6;
                }
                i5++;
                f6 = f7;
            }
        }
        float f8 = f6 + this.RBc;
        d dVar = new d(this, cArr, i2, i3, this.RBo, fArr, f2, f8, f3, this.ayn, z, f4, i4, this.AoL, f5);
        this.RBo += f8;
        this.RAX.add(dVar);
    }

    public final void aG(CharSequence charSequence) {
        a(charSequence, this.ayn, this.RBq);
    }
}
