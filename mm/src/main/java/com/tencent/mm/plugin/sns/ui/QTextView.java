package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;

public class QTextView extends View {
    private static HashMap<String, a> Evi = new HashMap<>();
    private int Evc;
    private String Evd;
    private String Eve;
    private boolean Evf;
    private int Evg;
    private boolean Evh;
    private a Evj;
    private a Evk;
    int Evl = 0;
    private TextPaint ayn;
    private Context context;
    private String mText = "";
    boolean pMC;
    private int pME;
    private int textSize = -1;

    static {
        AppMethodBeat.i(98222);
        AppMethodBeat.o(98222);
    }

    public QTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98213);
        this.context = context2;
        init();
        AppMethodBeat.o(98213);
    }

    public QTextView(Context context2) {
        super(context2);
        AppMethodBeat.i(98214);
        this.context = context2;
        init();
        AppMethodBeat.o(98214);
    }

    private void init() {
        AppMethodBeat.i(98215);
        this.pMC = false;
        this.Evf = true;
        this.Evh = false;
        this.pME = -1;
        this.Evd = "...";
        this.Eve = "";
        this.Evg = -16776961;
        this.Evj = new a();
        this.Evk = new a();
        this.ayn = new TextPaint();
        this.ayn.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0f);
            this.ayn.setTextSize((float) this.textSize);
        } else {
            this.ayn.setTextSize(13.0f);
        }
        this.ayn.setColor(WebView.NIGHT_MODE_COLOR);
        this.ayn.setTextAlign(Paint.Align.LEFT);
        AppMethodBeat.o(98215);
    }

    public void setText(String str) {
        AppMethodBeat.i(98216);
        if (Util.isNullOrNil(this.mText)) {
            this.mText = "";
        }
        this.mText = str;
        this.Evj.key = "";
        this.Evk.key = "";
        requestLayout();
        invalidate();
        AppMethodBeat.o(98216);
    }

    public String getText() {
        return this.mText;
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(98217);
        this.ayn.setTextSize((float) i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(98217);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(98218);
        this.ayn.setColor(i2);
        invalidate();
        AppMethodBeat.o(98218);
    }

    public void setEllipsis(String str) {
        this.Evd = str;
    }

    public void setEllipsisMore(String str) {
        this.Eve = str;
    }

    public void setMaxLines(int i2) {
        this.pME = i2;
    }

    public void setDrawEllipsizeMoreString(boolean z) {
        this.Evf = z;
    }

    public void setColorEllpsizeMore(int i2) {
        this.Evg = i2;
    }

    public void setRightAlignEllipsizeMoreString(boolean z) {
        this.Evh = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ArrayList<int[]> arrayList;
        a aVar;
        AppMethodBeat.i(98220);
        super.onDraw(canvas);
        if (this.pMC) {
            a aVar2 = this.Evj;
            arrayList = this.Evj.Evn;
            aVar = aVar2;
        } else {
            a aVar3 = this.Evk;
            arrayList = this.Evk.Evn;
            aVar = aVar3;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.Evc));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int[] iArr = arrayList.get(i2);
            canvas.drawText(this.mText, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, (Paint) this.ayn);
            if (i2 == arrayList.size() - 1 && aVar.Evm) {
                canvas.drawText(this.Evd, aVar.Evo + paddingLeft, paddingTop, this.ayn);
                if (this.Evf) {
                    int color = this.ayn.getColor();
                    this.ayn.setColor(this.Evg);
                    if (this.Evh) {
                        canvas.drawText(this.Eve, ((float) canvas.getWidth()) - ((aVar.Evq + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.ayn);
                    } else {
                        canvas.drawText(this.Eve, aVar.Evo + aVar.Evp + paddingLeft, paddingTop, this.ayn);
                    }
                    this.ayn.setColor(color);
                }
            }
            paddingTop += ((float) (-this.Evc)) + this.ayn.descent();
            if (paddingTop > ((float) canvas.getHeight())) {
                break;
            }
        }
        AppMethodBeat.o(98220);
    }

    public boolean getIsExpanded() {
        return this.pMC;
    }

    private int ZE(int i2) {
        AppMethodBeat.i(98221);
        if (this.pMC) {
            if (Util.isNullOrNil(this.Evj.key)) {
                this.Evl = this.Evj.a(this.mText, (i2 - getPaddingLeft()) - getPaddingRight(), this.ayn);
            }
        } else if (Util.isNullOrNil(this.Evk.key)) {
            this.Evl = this.Evk.a(this.mText, this.Evd, this.Eve, this.pME, (i2 - getPaddingLeft()) - getPaddingRight(), this.ayn);
        }
        int paddingLeft = this.Evl + getPaddingLeft() + getPaddingRight();
        AppMethodBeat.o(98221);
        return paddingLeft;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static HashMap<String, Integer> Evr = new HashMap<>();
        private int Evl = 0;
        boolean Evm = false;
        ArrayList<int[]> Evn = new ArrayList<>();
        float Evo;
        float Evp;
        float Evq;
        private String key = "";

        public a() {
            AppMethodBeat.i(98209);
            AppMethodBeat.o(98209);
        }

        public final int a(String str, int i2, TextPaint textPaint) {
            AppMethodBeat.i(98210);
            int a2 = a(str, null, null, -1, i2, textPaint);
            AppMethodBeat.o(98210);
            return a2;
        }

        static {
            AppMethodBeat.i(98212);
            AppMethodBeat.o(98212);
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[LOOP:1: B:39:0x0155->B:42:0x015f, LOOP_START, PHI: r1 
          PHI: (r1v37 int) = (r1v15 int), (r1v39 int) binds: [B:37:0x0142, B:42:0x015f] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.String r12, java.lang.String r13, java.lang.String r14, int r15, int r16, android.text.TextPaint r17) {
            /*
            // Method dump skipped, instructions count: 437
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.QTextView.a.a(java.lang.String, java.lang.String, java.lang.String, int, int, android.text.TextPaint):int");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size;
        int descent;
        AppMethodBeat.i(98219);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            ZE(size2);
        } else if (mode == Integer.MIN_VALUE) {
            size2 = Math.min(ZE(size2), size2);
        } else {
            ZE(size2);
            size2 = 0;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = View.MeasureSpec.getSize(i3);
        this.Evc = (int) this.ayn.ascent();
        if (mode2 == 1073741824) {
            descent = size3;
        } else {
            if (this.pMC) {
                size = this.Evj.Evn.size();
            } else {
                size = this.Evk.Evn.size();
            }
            descent = (size * ((int) (((float) (-this.Evc)) + this.ayn.descent()))) + getPaddingTop() + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                descent = Math.min(descent, size3);
            }
        }
        setMeasuredDimension(size2, descent);
        AppMethodBeat.o(98219);
    }
}
