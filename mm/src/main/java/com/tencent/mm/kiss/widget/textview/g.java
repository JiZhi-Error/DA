package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class g {
    protected f huJ;
    public a huK;
    protected StaticLayout huL;
    protected boolean huM = false;
    int huN;
    int huO;
    private boolean huP = false;
    boolean huQ = false;
    boolean huR = false;
    private boolean huS = false;
    private View huT;
    private int huU = 0;
    private int huV = 0;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.huT = view;
        this.huK = aVar;
    }

    public final void init() {
        AppMethodBeat.i(141075);
        this.text = "";
        this.huT.setWillNotDraw(false);
        AppMethodBeat.o(141075);
    }

    public final void setSingleLine(boolean z) {
        int i2;
        AppMethodBeat.i(141076);
        if (z) {
            i2 = 1;
        } else {
            i2 = Integer.MAX_VALUE;
        }
        if (this.huK.maxLines != i2) {
            this.huK.maxLines = i2;
            this.huM = true;
            aBo();
            this.huT.requestLayout();
            this.huT.invalidate();
        }
        AppMethodBeat.o(141076);
    }

    public final void setLines(int i2) {
        AppMethodBeat.i(141077);
        if (!(this.huK.maxLines == i2 && this.huK.minLines == i2)) {
            this.huM = true;
            aBo();
            this.huK.maxLines = i2;
            this.huK.minLines = i2;
            this.huT.requestLayout();
            this.huT.invalidate();
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
        AppMethodBeat.o(141077);
    }

    public final void setTextSize(int i2, float f2) {
        Resources resources;
        AppMethodBeat.i(141078);
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        AppMethodBeat.o(141078);
    }

    private void setRawTextSize(float f2) {
        AppMethodBeat.i(141079);
        if (!(f2 == 0.0f || this.huK == null || f2 == this.huK.textSize)) {
            this.huK.textSize = f2;
            this.huM = true;
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
        AppMethodBeat.o(141079);
    }

    public final void setTextLayout(f fVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(141080);
        if (fVar == null || fVar.huH == null) {
            this.huJ = null;
            AppMethodBeat.o(141080);
            return;
        }
        if (this.huK == null) {
            b bVar = new b();
            bVar.huK = new a();
            bVar.huK.maxLines = fVar.maxLines;
            bVar.huK.maxLength = fVar.maxLength;
            bVar.huK.iW = fVar.iW;
            bVar.huK.huw = fVar.huw;
            bVar.huK.hux = fVar.hux;
            bVar.huK.gravity = fVar.gravity;
            bVar.huK.textSize = fVar.iW.getTextSize();
            bVar.huK.textColor = fVar.iW.getColor();
            bVar.huK.breakStrategy = fVar.breakStrategy;
            this.huK = bVar.huK;
        }
        aBo();
        this.huT.setWillNotDraw(false);
        this.huJ = fVar;
        this.huL = fVar.huH;
        this.text = fVar.text;
        this.huP = this.text instanceof Spannable;
        if (this.huP) {
            this.text = this.huJ.text;
            com.tencent.mm.kiss.widget.textview.b.b.aBv();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        if (this.text == null) {
            Object[] objArr = new Object[3];
            if (fVar.text == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            if (this.huJ.text == null) {
                z2 = true;
            }
            objArr[1] = Boolean.valueOf(z2);
            objArr[2] = Util.getStack();
            Log.e("MicroMsg.StaticTextViewHolder", "text is null, [%b, %b, %s]", objArr);
        }
        this.huT.requestLayout();
        this.huT.invalidate();
        AppMethodBeat.o(141080);
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(141081);
        if (!(this.huK == null || i2 == this.huK.textColor)) {
            this.huK.textColor = i2;
            this.huM = true;
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
        AppMethodBeat.o(141081);
    }

    public final void setGravity(int i2) {
        AppMethodBeat.i(141082);
        if (!(this.huK == null || i2 == this.huK.gravity)) {
            this.huK.gravity = i2;
            this.huM = true;
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
        AppMethodBeat.o(141082);
    }

    public final void setMaxLines(int i2) {
        AppMethodBeat.i(141083);
        if (!(this.huK == null || i2 == this.huK.maxLines)) {
            this.huK.maxLines = i2;
            this.huM = true;
            aBo();
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.huT.requestLayout();
            this.huT.invalidate();
        }
        AppMethodBeat.o(141083);
    }

    public final int getMaxLines() {
        if (this.huK != null) {
            return this.huK.maxLines;
        }
        return -1;
    }

    public final void setMinLines(int i2) {
        AppMethodBeat.i(141084);
        if (this.huK.minLines != i2) {
            this.huK.minLines = i2;
            aBo();
            this.huT.requestLayout();
            this.huT.invalidate();
        }
        AppMethodBeat.o(141084);
    }

    public final int getLineHeight() {
        AppMethodBeat.i(141085);
        TextPaint paint = this.huJ.huH.getPaint();
        if (paint == null) {
            paint = this.huK.iW;
        }
        int round = Math.round((((float) paint.getFontMetricsInt(null)) * this.huK.huB) + this.huK.huA);
        AppMethodBeat.o(141085);
        return round;
    }

    public final void setText(CharSequence charSequence, boolean z) {
        AppMethodBeat.i(141086);
        if (charSequence == null) {
            AppMethodBeat.o(141086);
            return;
        }
        if (this.text == null || !charSequence.equals(this.text) || z) {
            this.text = charSequence;
            this.huM = true;
            this.huT.requestLayout();
            this.huT.invalidate();
            if (h.DEBUG) {
                Log.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + ((Object) charSequence) + " hashcode " + hashCode() + " " + Util.getStack().toString());
            }
        }
        AppMethodBeat.o(141086);
    }

    /* access modifiers changed from: package-private */
    public final void aBo() {
        this.huV = 0;
        this.huU = 0;
        this.huN = 0;
        this.huO = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        AppMethodBeat.i(141087);
        if (this.huJ != null) {
            float textSize = this.huJ.iW.getTextSize();
            AppMethodBeat.o(141087);
            return textSize;
        } else if (this.huK != null) {
            float f2 = this.huK.textSize;
            AppMethodBeat.o(141087);
            return f2;
        } else {
            AppMethodBeat.o(141087);
            return 0.0f;
        }
    }

    public final int getTextColor() {
        AppMethodBeat.i(141088);
        if (this.huJ != null) {
            int color = this.huJ.iW.getColor();
            AppMethodBeat.o(141088);
            return color;
        } else if (this.huK != null) {
            int i2 = this.huK.textColor;
            AppMethodBeat.o(141088);
            return i2;
        } else {
            AppMethodBeat.o(141088);
            return 0;
        }
    }

    public final Layout getTvLayout() {
        return this.huL;
    }

    public final f getLayoutWrapper() {
        return this.huJ;
    }

    public final int getLineCount() {
        AppMethodBeat.i(141089);
        if (this.huL == null) {
            AppMethodBeat.o(141089);
            return 0;
        }
        int lineCount = this.huL.getLineCount();
        AppMethodBeat.o(141089);
        return lineCount;
    }

    public final int getSelectionStart() {
        AppMethodBeat.i(141090);
        if (this.text == null) {
            AppMethodBeat.o(141090);
            return -1;
        }
        int selectionStart = Selection.getSelectionStart(this.text);
        AppMethodBeat.o(141090);
        return selectionStart;
    }

    public final int getSelectionEnd() {
        AppMethodBeat.i(141091);
        if (this.text == null) {
            AppMethodBeat.o(141091);
            return -1;
        }
        int selectionEnd = Selection.getSelectionEnd(this.text);
        AppMethodBeat.o(141091);
        return selectionEnd;
    }

    public final boolean w(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(141092);
        boolean z3 = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (this.huT.isEnabled() && this.huP) {
            com.tencent.mm.kiss.widget.textview.b.b.aBv();
            boolean a2 = com.tencent.mm.kiss.widget.textview.b.b.a(this.huT, this.huL, (Spannable) this.text, motionEvent);
            this.huS = a2;
            if (this.huR && z3) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x < ((float) this.huN) || x > ((float) (this.huL.getWidth() + this.huN))) {
                    z = false;
                } else if (y < ((float) this.huO) || y > ((float) (this.huL.getHeight() + this.huO))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) this.text).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
                    if (clickableSpanArr.length > 0) {
                        Log.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                        clickableSpanArr[0].onClick(this.huT);
                        z2 = true;
                    }
                }
            }
            z2 = a2;
        }
        AppMethodBeat.o(141092);
        return z2;
    }

    public final boolean performClick() {
        if (this.huS || !this.huQ) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(141093);
        if (this.huL == null || this.huJ == null) {
            boolean qj = qj(this.huT.getMeasuredWidth());
            if (h.DEBUG) {
                Log.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.huL, this.huJ, Boolean.valueOf(qj));
            }
            if (qj) {
                this.huT.requestLayout();
                this.huT.invalidate();
            }
            AppMethodBeat.o(141093);
            return;
        }
        long j2 = 0;
        if (h.DEBUG) {
            j2 = System.nanoTime();
        }
        canvas.save();
        int paddingLeft = this.huT.getPaddingLeft();
        int paddingTop = this.huT.getPaddingTop();
        int right = (this.huT.getRight() - this.huT.getLeft()) - this.huT.getPaddingRight();
        int bottom = (this.huT.getBottom() - this.huT.getTop()) - this.huT.getPaddingBottom();
        canvas.clipRect(paddingLeft, paddingTop, right, bottom);
        if (this.huN == 0 || this.huO == 0) {
            int paddingLeft2 = this.huT.getPaddingLeft();
            int right2 = ((this.huT.getRight() - this.huT.getLeft()) - this.huT.getPaddingLeft()) - this.huT.getPaddingRight();
            int width = this.huL.getWidth();
            if (width > right2) {
                i3 = paddingLeft2;
            } else {
                switch (this.huJ.gravity & 8388615) {
                    case 1:
                    case 17:
                        i2 = (right2 / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        i2 = 0;
                        break;
                    case 5:
                    case 8388613:
                        i2 = right2 - width;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i3 = i2 + paddingLeft2;
            }
            this.huN = i3;
            int paddingTop2 = this.huT.getPaddingTop();
            int bottom2 = ((this.huT.getBottom() - this.huT.getTop()) - this.huT.getPaddingTop()) - this.huT.getPaddingBottom();
            int i5 = 0;
            int height = this.huL.getHeight();
            if (height > bottom2) {
                i4 = paddingTop2;
            } else {
                switch (this.huJ.gravity & 112) {
                    case 16:
                        i5 = (bottom2 / 2) - (height / 2);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        i5 = 0;
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        i5 = bottom2 - height;
                        break;
                }
                i4 = i5 + paddingTop2;
            }
            this.huO = i4;
        }
        canvas.translate((float) this.huN, (float) this.huO);
        this.huL.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            Log.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j2)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(right), Integer.valueOf(bottom));
        }
        AppMethodBeat.o(141093);
    }

    private boolean qj(int i2) {
        AppMethodBeat.i(141094);
        if (this.huM || this.huJ == null || this.huL == null) {
            if (this.huK == null) {
                AppMethodBeat.o(141094);
                return false;
            } else if (i2 > 0) {
                aBo();
                long j2 = 0;
                if (h.DEBUG) {
                    j2 = System.nanoTime();
                }
                this.huJ = d.a(this.text, i2, this.huK).aBl();
                this.huL = this.huJ.huH;
                this.huM = false;
                if (h.DEBUG) {
                    Log.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i2), Integer.valueOf(hashCode()), Double.valueOf(((double) (System.nanoTime() - j2)) / 1000000.0d), this.text);
                }
                AppMethodBeat.o(141094);
                return true;
            }
        }
        AppMethodBeat.o(141094);
        return false;
    }

    public final Point cV(int i2, int i3) {
        Point point;
        int i4;
        int i5;
        AppMethodBeat.i(141095);
        long j2 = 0;
        if (h.DEBUG) {
            j2 = System.nanoTime();
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        qj(size);
        if (this.huL != null) {
            if (mode != 1073741824) {
                int i6 = 0;
                if (this.huK.hux == null) {
                    StaticLayout staticLayout = this.huL;
                    if (this.huU != 0) {
                        i6 = this.huU;
                    } else {
                        int lineCount = staticLayout.getLineCount();
                        CharSequence text2 = staticLayout.getText();
                        float f2 = 0.0f;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= lineCount - 1) {
                                for (int i8 = 0; i8 < lineCount; i8++) {
                                    f2 = Math.max(f2, staticLayout.getLineWidth(i8));
                                }
                                this.huU = (int) Math.ceil((double) f2);
                                this.huU += this.huT.getPaddingLeft() + this.huT.getPaddingRight();
                                i6 = this.huU;
                            } else if (text2.charAt(staticLayout.getLineEnd(i7) - 1) != '\n') {
                                i6 = -1;
                                break;
                            } else {
                                i7++;
                            }
                        }
                    }
                }
                int ceil = (int) Math.ceil((double) Layout.getDesiredWidth(this.huL.getText(), this.huL.getPaint()));
                if (ceil > i6) {
                    i6 = ceil;
                }
                if (h.DEBUG) {
                    Log.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i6), Integer.valueOf(ceil));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i6);
                } else {
                    size = i6;
                }
            }
            if (mode2 == 1073741824) {
                i5 = size2;
            } else {
                StaticLayout staticLayout2 = this.huL;
                if (this.huV != 0) {
                    i5 = this.huV;
                } else {
                    int lineCount2 = staticLayout2.getLineCount();
                    if (this.huJ.maxLines > 0 && this.huJ.maxLines < lineCount2) {
                        lineCount2 = this.huJ.maxLines;
                    }
                    int paddingTop = this.huT.getPaddingTop() + this.huT.getPaddingBottom();
                    int lineTop = staticLayout2.getLineTop(lineCount2);
                    if (this.huK.minLines <= 0 || lineCount2 >= this.huK.minLines) {
                        i4 = lineTop;
                    } else {
                        i4 = ((this.huK.minLines - lineCount2) * getLineHeight()) + lineTop;
                    }
                    this.huV = i4 + paddingTop;
                    i5 = this.huV;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i5 = Math.min(i5, size2);
                }
            }
            point = new Point(size, i5);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j2)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            Log.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", objArr);
        }
        AppMethodBeat.o(141095);
        return point;
    }
}
