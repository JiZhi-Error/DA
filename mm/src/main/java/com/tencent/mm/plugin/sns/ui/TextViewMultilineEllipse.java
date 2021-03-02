package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class TextViewMultilineEllipse extends View {
    private a EQO;
    private a EQP;
    private int Evc;
    private String Evd;
    private String Eve;
    private boolean Evf;
    private int Evg;
    private boolean Evh;
    private TextPaint ayn;
    private Context context;
    private String mText;
    private boolean pMC;
    private int pME;
    private int textSize = -1;

    public TextViewMultilineEllipse(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(99707);
        this.context = context2;
        this.pMC = false;
        this.Evf = true;
        this.Evh = false;
        this.pME = -1;
        this.Evd = "...";
        this.Eve = "";
        this.Evg = -16776961;
        this.EQO = new a();
        this.EQP = new a();
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
        AppMethodBeat.o(99707);
    }

    public void setText(String str) {
        AppMethodBeat.i(99708);
        this.mText = str;
        requestLayout();
        invalidate();
        AppMethodBeat.o(99708);
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(99709);
        this.ayn.setTextSize((float) i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(99709);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(99710);
        this.ayn.setColor(i2);
        invalidate();
        AppMethodBeat.o(99710);
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
        AppMethodBeat.i(99712);
        super.onDraw(canvas);
        if (this.pMC) {
            a aVar2 = this.EQO;
            arrayList = this.EQO.Evn;
            aVar = aVar2;
        } else {
            a aVar3 = this.EQP;
            arrayList = this.EQP.Evn;
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
        AppMethodBeat.o(99712);
    }

    public boolean getIsExpanded() {
        return this.pMC;
    }

    private int ZE(int i2) {
        int a2;
        AppMethodBeat.i(99713);
        if (this.pMC) {
            a2 = this.EQO.a(this.mText, (i2 - getPaddingLeft()) - getPaddingRight(), this.ayn);
        } else {
            a2 = this.EQP.a(this.mText, this.Evd, this.Eve, this.pME, (i2 - getPaddingLeft()) - getPaddingRight(), this.ayn);
        }
        int paddingLeft = a2 + getPaddingLeft() + getPaddingRight();
        AppMethodBeat.o(99713);
        return paddingLeft;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        boolean Evm = false;
        ArrayList<int[]> Evn = new ArrayList<>();
        float Evo;
        float Evp;
        float Evq;

        public a() {
            AppMethodBeat.i(99704);
            AppMethodBeat.o(99704);
        }

        public final int a(String str, int i2, TextPaint textPaint) {
            AppMethodBeat.i(99705);
            int a2 = a(str, null, null, -1, i2, textPaint);
            AppMethodBeat.o(99705);
            return a2;
        }

        public final int a(String str, String str2, String str3, int i2, int i3, TextPaint textPaint) {
            AppMethodBeat.i(99706);
            this.Evn.clear();
            this.Evm = false;
            this.Evo = 0.0f;
            this.Evp = 0.0f;
            this.Evq = 0.0f;
            if (i3 == -1) {
                this.Evn.add(new int[]{0, str.length()});
                int measureText = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.o(99706);
                return measureText;
            }
            if (str2 != null) {
                this.Evp = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.Evq = textPaint.measureText(str3);
            }
            int i4 = -1;
            float f2 = 0.0f;
            boolean z = true;
            int i5 = 0;
            while (true) {
                if (i5 >= str.length()) {
                    break;
                }
                if (i4 == -1) {
                    i4 = i5;
                }
                if (this.Evn.size() == i2) {
                    this.Evm = true;
                    break;
                }
                float measureText2 = textPaint.measureText(new StringBuilder().append(str.charAt(i5)).toString());
                boolean z2 = false;
                if (str.charAt(i5) == '\n') {
                    z2 = true;
                    this.Evn.add(new int[]{i4, i5 - 1});
                } else if (f2 + measureText2 >= ((float) i3)) {
                    z2 = true;
                    if (str.charAt(i5) == ' ' || !z) {
                        i5--;
                        this.Evn.add(new int[]{i4, i5});
                    } else {
                        while (str.charAt(i5) != ' ') {
                            i5--;
                        }
                        this.Evn.add(new int[]{i4, i5});
                    }
                }
                if (z2) {
                    i4 = -1;
                    f2 = 0.0f;
                    if (this.Evn.size() == i2 - 1) {
                        i3 = (int) (((float) i3) - (this.Evp + this.Evq));
                        z = false;
                    }
                } else {
                    f2 += measureText2;
                    if (i5 == str.length() - 1) {
                        this.Evn.add(new int[]{i4, i5});
                    }
                }
                i5++;
            }
            if (this.Evm) {
                int[] iArr = this.Evn.get(this.Evn.size() - 1);
                this.Evo = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.Evn.size() == 0) {
                AppMethodBeat.o(99706);
                return 0;
            } else if (this.Evn.size() == 1) {
                int measureText3 = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.o(99706);
                return measureText3;
            } else {
                AppMethodBeat.o(99706);
                return i3;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size;
        int descent;
        AppMethodBeat.i(99711);
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
                size = this.EQO.Evn.size();
            } else {
                size = this.EQP.Evn.size();
            }
            descent = (size * ((int) (((float) (-this.Evc)) + this.ayn.descent()))) + getPaddingTop() + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                descent = Math.min(descent, size3);
            }
        }
        setMeasuredDimension(size2, descent);
        AppMethodBeat.o(99711);
    }
}
