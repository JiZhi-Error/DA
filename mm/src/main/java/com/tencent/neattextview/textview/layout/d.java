package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.LinkedList;

public final class d implements b {
    private static final TextPaint RBu = new TextPaint(1);
    private static Comparator<Integer> RBv = new Comparator<Integer>() {
        /* class com.tencent.neattextview.textview.layout.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Integer num, Integer num2) {
            AppMethodBeat.i(39745);
            int intValue = num.intValue() - num2.intValue();
            AppMethodBeat.o(39745);
            return intValue;
        }
    };
    public static boolean cWq = false;
    private int AoL;
    public int Pc;
    private float[] RAR;
    private boolean RBA;
    private float RBB = -1.0f;
    private float RBC = 0.0f;
    private float RBD = 0.0f;
    private RectF RBE = new RectF();
    private RectF RBF = new RectF();
    private LinkedList<Integer> RBG = null;
    private float RBH;
    private c RBw;
    private char[] RBx;
    private int RBy;
    private float RBz;
    public int avh;
    private float mHeight;
    private float mWidth;

    static {
        AppMethodBeat.i(39757);
        AppMethodBeat.o(39757);
    }

    public d(c cVar, char[] cArr, int i2, int i3, float f2, float[] fArr, float f3, float f4, float f5, TextPaint textPaint, boolean z, float f6, int i4, int i5, float f7) {
        AppMethodBeat.i(39746);
        this.RBw = cVar;
        this.RBx = cArr;
        this.avh = i2;
        this.Pc = i3;
        this.RBy = i4;
        this.RAR = fArr;
        this.RBz = f5;
        this.RBC = f6;
        this.RBA = z;
        this.mHeight = f4;
        this.mWidth = f3;
        this.RBD = f7;
        this.AoL = i5;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f8 = fontMetrics.leading - fontMetrics.top;
        float f9 = fontMetrics.bottom - fontMetrics.leading;
        this.RBH = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f2) - fontMetrics.top;
        this.RBE.set(0.0f, this.RBH - f8, 0.0f + f3, f9 + this.RBH);
        this.RBF.set(0.0f, this.RBH - f8, 0.0f + f7, this.RBE.top + this.mHeight);
        AppMethodBeat.o(39746);
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final void a(Canvas canvas, TextPaint textPaint, float f2) {
        float f3;
        AppMethodBeat.i(39747);
        float hiN = 0.0f + hiN();
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f4 = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f2) - fontMetrics.top;
        int i2 = this.avh;
        int i3 = this.Pc;
        int[] iArr = this.RBw.RBn.RBM;
        int[] iArr2 = this.RBw.RBn.RBN;
        E[] eArr = this.RBw.RBn.RBL;
        LinkedList<LineBackgroundSpan> linkedList = new LinkedList();
        for (int i4 = 0; i4 < this.RBw.RBn.RBK; i4++) {
            if (iArr[i4] < i3 && iArr2[i4] > i2) {
                linkedList.add(eArr[i4]);
            }
        }
        for (LineBackgroundSpan lineBackgroundSpan : linkedList) {
            lineBackgroundSpan.drawBackground(canvas, textPaint, (int) this.RBE.left, (int) this.RBE.right, (int) this.RBE.top, (int) f4, (int) this.RBE.bottom, this.RBw.getText(), this.avh, this.Pc, this.RBy);
        }
        StringBuilder append = cWq ? new StringBuilder("canvas w=").append(canvas.getWidth()).append(" canvas h=").append(canvas.getHeight()).append('\n') : null;
        int i5 = this.avh;
        boolean z = false;
        float f5 = f4;
        float f6 = hiN;
        for (int i6 = this.avh; i6 < this.Pc; i6++) {
            if (i6 + 1 < this.Pc) {
                if (this.RAR[i6 + 1] != 0.0f) {
                    if (!z) {
                        z = this.RBA && this.RAR[i6 + 1] == this.RBC;
                        if (z) {
                        }
                    }
                }
            }
            int i7 = i6 + 1;
            ImageSpan mp = this.RBw.RBg.mp(i5, i7);
            if (mp != null) {
                RBu.set(textPaint);
                mp.draw(canvas, "", i5, i7, f6, 0, (int) f5, (int) (this.mHeight + f2), RBu);
            } else {
                boolean z2 = false;
                RBu.set(textPaint);
                AbsoluteSizeSpan mp2 = this.RBw.RBi.mp(i5, i7);
                if (mp2 != null) {
                    z2 = true;
                    mp2.updateDrawState(RBu);
                }
                RelativeSizeSpan mp3 = this.RBw.RBj.mp(i5, i7);
                if (mp3 != null) {
                    z2 = true;
                    mp3.updateDrawState(RBu);
                }
                ForegroundColorSpan mp4 = this.RBw.RBl.mp(i5, i7);
                if (mp4 != null) {
                    mp4.updateDrawState(RBu);
                }
                ClickableSpan mp5 = this.RBw.RBm.mp(i5, i7);
                if (mp5 != null) {
                    mp5.updateDrawState(RBu);
                }
                if (z2) {
                    f3 = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f2) - fontMetrics.top;
                } else {
                    f3 = f5;
                }
                canvas.drawText(this.RBx, i5, i7 - i5, f6, f3, RBu);
                f5 = f3;
            }
            if (z) {
                f6 += this.RBC;
            }
            z = false;
            f6 += this.RAR[i5] + this.RBz;
            if (cWq) {
                append.append(f6).append(',');
            }
            i5 = i7;
        }
        AppMethodBeat.o(39747);
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float getHeight() {
        return this.mHeight;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float[] hiI() {
        return this.RAR;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final RectF hiK() {
        return this.RBF;
    }

    public final RectF mo(int i2, int i3) {
        AppMethodBeat.i(39748);
        RectF rectF = new RectF();
        if (i2 >= i3) {
            AppMethodBeat.o(39748);
        } else {
            float hiN = hiN();
            for (int i4 = this.avh; i4 < i2; i4++) {
                hiN += this.RAR[i4] + this.RBz;
            }
            float f2 = hiN;
            while (i2 < i3) {
                f2 += this.RAR[i2] + this.RBz;
                i2++;
            }
            rectF.set(hiN, this.RBE.top, f2, this.RBE.bottom);
            AppMethodBeat.o(39748);
        }
        return rectF;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final RectF hiJ() {
        return this.RBE;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final int getStart() {
        return this.avh;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final int getEnd() {
        return this.Pc;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float hiL() {
        return this.RBz;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final boolean hiM() {
        return this.RBA;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float hiN() {
        float f2;
        AppMethodBeat.i(39749);
        if (this.RBB != -1.0f) {
            float f3 = this.RBB;
            AppMethodBeat.o(39749);
            return f3;
        }
        if ((this.AoL & 7) == 1) {
            int i2 = this.avh;
            float f4 = 0.0f;
            for (int i3 = this.avh; i3 < this.Pc; i3++) {
                if (i3 + 1 >= this.Pc || this.RAR[i3 + 1] != 0.0f) {
                    f4 += this.RAR[i2] + this.RBz;
                    i2 = i3 + 1;
                }
            }
            f2 = (this.RBD - f4) / 2.0f;
        } else {
            f2 = 0.0f;
        }
        float max = Math.max(0.0f, f2);
        if (this.RBw.RBg.mp(this.avh, this.avh + 1) != null || !this.RBw.hiR().containsKey(Character.valueOf(this.RBx[this.avh]))) {
            this.RBB = max;
            float f5 = this.RBB;
            AppMethodBeat.o(39749);
            return f5;
        }
        float floatValue = max - this.RBw.hiR().get(Character.valueOf(this.RBx[this.avh])).floatValue();
        this.RBB = floatValue;
        AppMethodBeat.o(39749);
        return floatValue;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float hiO() {
        return this.RBH;
    }

    @Override // com.tencent.neattextview.textview.layout.b
    public final float getPrimaryHorizontal(int i2) {
        AppMethodBeat.i(39750);
        float hiN = this.RBE.left + hiN();
        int i3 = this.avh;
        int i4 = this.avh;
        boolean z = false;
        while (i4 < this.Pc && i4 < i2) {
            if (i4 + 1 < this.Pc) {
                if (this.RAR[i4 + 1] != 0.0f) {
                    if (!z) {
                        if (!this.RBA || this.RAR[i4 + 1] != this.RBC) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    }
                }
                i4++;
            }
            int i5 = i4 + 1;
            if (z) {
                hiN += this.RBC;
            }
            hiN += this.RAR[i3] + this.RBz;
            z = false;
            i3 = i5;
            i4++;
        }
        AppMethodBeat.o(39750);
        return hiN;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r1 != false) goto L_0x0042;
     */
    @Override // com.tencent.neattextview.textview.layout.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aqs(int r10) {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.neattextview.textview.layout.d.aqs(int):int");
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(39752);
        if (obj == null) {
            AppMethodBeat.o(39752);
            return false;
        } else if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.getStart() == this.avh && bVar.getEnd() == this.Pc && bVar.hiJ().equals(this.RBE) && bVar.hiM() == this.RBA && bVar.hiL() == this.RBz && bVar.hiN() == this.RBB) {
                for (int i2 = this.avh; i2 < this.Pc; i2++) {
                    if (this.RAR[i2] != bVar.hiI()[i2]) {
                        AppMethodBeat.o(39752);
                        return false;
                    }
                }
                AppMethodBeat.o(39752);
                return true;
            }
            AppMethodBeat.o(39752);
            return false;
        } else {
            AppMethodBeat.o(39752);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(39753);
        int hashCode = this.avh + this.Pc + ((int) this.mHeight) + ((int) this.mWidth) + ((int) this.RBB) + this.RBE.hashCode();
        AppMethodBeat.o(39753);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(39754);
        String str = "MeasuredLine{mStart=" + this.avh + ", mEnd=" + this.Pc + ", mLetter=" + this.RBz + ", isSmartLetter=" + this.RBA + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.RBB + ", mLineRect=" + this.RBE + ", mLineRect=" + this.RBF + '}';
        AppMethodBeat.o(39754);
        return str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        AppMethodBeat.i(39755);
        objectOutputStream.writeInt(this.avh);
        objectOutputStream.writeInt(this.Pc);
        objectOutputStream.writeObject(this.RAR);
        objectOutputStream.writeFloat(this.RBE.left);
        objectOutputStream.writeFloat(this.RBE.top);
        objectOutputStream.writeFloat(this.RBE.right);
        objectOutputStream.writeFloat(this.RBE.bottom);
        objectOutputStream.writeBoolean(this.RBA);
        objectOutputStream.writeFloat(this.RBz);
        objectOutputStream.writeFloat(hiN());
        AppMethodBeat.o(39755);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(39756);
        this.avh = objectInputStream.readInt();
        this.Pc = objectInputStream.readInt();
        this.RAR = (float[]) objectInputStream.readObject();
        this.RBE = new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat());
        this.RBA = objectInputStream.readBoolean();
        this.RBz = objectInputStream.readFloat();
        this.RBB = objectInputStream.readFloat();
        AppMethodBeat.o(39756);
    }
}
