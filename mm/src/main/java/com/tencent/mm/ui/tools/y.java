package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y {
    List<b> Qxm;
    WeakReference<EditText> Qxn;
    ArrayList<String> Qxo;
    boolean Qxp;
    String mText;

    public y(EditText editText) {
        AppMethodBeat.i(143290);
        this.Qxn = new WeakReference<>(editText);
        AppMethodBeat.o(143290);
    }

    /* access modifiers changed from: package-private */
    public final b aoo(int i2) {
        AppMethodBeat.i(143291);
        if (this.Qxm != null) {
            for (b bVar : this.Qxm) {
                if (i2 <= bVar.start + bVar.length && i2 > bVar.start) {
                    AppMethodBeat.o(143291);
                    return bVar;
                }
            }
        }
        AppMethodBeat.o(143291);
        return null;
    }

    static boolean a(EditText editText, ArrayList<String> arrayList) {
        AppMethodBeat.i(143292);
        String obj = editText.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<b> o = o(obj, arrayList);
        if (o == null || o.size() <= 0) {
            AppMethodBeat.o(143292);
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        TextPaint paint = editText.getPaint();
        for (b bVar : o) {
            int i2 = bVar.start;
            int i3 = bVar.length;
            if (i2 < 0 || i3 <= 0 || i2 + i3 > obj.length()) {
                Log.i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i2), Integer.valueOf(i3));
            } else if (bVar.Qxs) {
                spannableStringBuilder.append((CharSequence) a(context, obj.substring(i2, i2 + i3), paint));
            } else {
                spannableStringBuilder.append((CharSequence) obj.substring(i2, i2 + i3));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            editText.setText(spannableStringBuilder);
            editText.setTextKeepState(spannableStringBuilder);
            if (selectionStart == selectionEnd && selectionStart >= 0) {
                editText.setSelection(selectionStart);
            }
        }
        AppMethodBeat.o(143292);
        return true;
    }

    private static SpannableString a(Context context, String str, Paint paint) {
        AppMethodBeat.i(143293);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ImageSpan(new a(context, str, paint), 0), 0, str.length(), 33);
        AppMethodBeat.o(143293);
        return spannableString;
    }

    static List<b> o(String str, ArrayList<String> arrayList) {
        int i2;
        AppMethodBeat.i(143294);
        if (Util.isNullOrNil(str) || arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(143294);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 > length) {
                break;
            }
            Iterator<String> it = arrayList.iterator();
            int i4 = 0;
            int i5 = length;
            while (it.hasNext()) {
                String next = it.next();
                if (!Util.isNullOrNil(next)) {
                    int indexOf = str.indexOf(next, i3);
                    if (indexOf < 0 || (indexOf >= i5 && (indexOf != i5 || next.length() <= i4))) {
                        i2 = i4;
                    } else {
                        i2 = next.length();
                        i5 = indexOf;
                    }
                    i4 = i2;
                }
            }
            if (i5 < length) {
                if (i5 > i3) {
                    arrayList2.add(new b(i3, i5 - i3, false));
                }
                arrayList2.add(new b(i5, i4, true));
                i3 = i5 + i4;
            } else if (i5 > i3) {
                arrayList2.add(new b(i3, i5 - i3, false));
            }
        }
        AppMethodBeat.o(143294);
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        boolean Qxs;
        int length;
        int start;

        b(int i2, int i3, boolean z) {
            this.start = i2;
            this.length = i3;
            this.Qxs = z;
        }
    }

    public static class a extends Drawable {
        private static int QoX;
        private RectF JkS;
        private float QoY;
        private float QoZ;
        private float Qxq;
        private float Qxr;
        private Paint hob = new Paint(1);
        private String mText;
        private Paint zbt;

        public a(Context context, String str, Paint paint) {
            AppMethodBeat.i(143284);
            this.hob.setColor(-7829368);
            this.zbt = paint;
            QoX = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 2.0f);
            this.Qxq = (float) QoX;
            this.Qxr = (float) QoX;
            this.mText = str;
            this.QoY = this.zbt.measureText(this.mText);
            Paint.FontMetrics fontMetrics = this.zbt.getFontMetrics();
            this.QoZ = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) (this.QoY + ((float) (QoX * 2)) + ((float) (QoX * 2))), (int) this.QoZ);
            Log.i("MicroMsg.TextDrawable", "setText(%s).", str);
            AppMethodBeat.o(143284);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(143285);
            canvas.drawRoundRect(this.JkS, this.Qxq, this.Qxr, this.hob);
            Rect bounds = getBounds();
            Paint.FontMetricsInt fontMetricsInt = this.zbt.getFontMetricsInt();
            canvas.drawText(this.mText, (float) ((int) (((((float) (bounds.right - bounds.left)) - (this.JkS.right - this.JkS.left)) + ((float) (QoX * 2))) / 2.0f)), (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.zbt);
            AppMethodBeat.o(143285);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(143286);
            if (i2 != this.hob.getAlpha()) {
                this.hob.setAlpha(i2);
                invalidateSelf();
            }
            AppMethodBeat.o(143286);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(143287);
            this.hob.setColorFilter(colorFilter);
            invalidateSelf();
            AppMethodBeat.o(143287);
        }

        public final int getOpacity() {
            AppMethodBeat.i(143288);
            if (this.hob.getAlpha() < 255) {
                AppMethodBeat.o(143288);
                return -3;
            }
            AppMethodBeat.o(143288);
            return -1;
        }

        public final void setBounds(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(143289);
            super.setBounds(i2, i3, i4, i5);
            Paint.FontMetrics fontMetrics = this.zbt.getFontMetrics();
            this.JkS = new RectF((float) (QoX + i2), (fontMetrics.ascent - fontMetrics.top) + ((float) i3), (float) (i4 - QoX), (float) i5);
            invalidateSelf();
            AppMethodBeat.o(143289);
        }
    }
}
