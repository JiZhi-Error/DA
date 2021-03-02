package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.sns.ui.bg;
import java.util.Map;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private b FfA = null;
    private int FfB = ViewConfiguration.getLongPressTimeout();
    private Map<String, Integer> FfC;
    private a FfD = new a();
    private boolean Ffy = true;
    private int Ffz = 0;
    private boolean isAd = false;
    private boolean ooU = false;
    private boolean pJi = false;

    public interface b {
        void fiW();
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(204003);
        AppMethodBeat.o(204003);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(204004);
        AppMethodBeat.o(204004);
    }

    public void setSpecialWidth(int i2) {
        this.Ffz = i2;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public final com.tencent.mm.kiss.widget.textview.a.a aBn() {
        AppMethodBeat.i(100547);
        this.Ffy = true;
        com.tencent.mm.kiss.widget.textview.a.a textViewConfig = f.fll().getTextViewConfig();
        AppMethodBeat.o(100547);
        return textViewConfig;
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public void setMaxLines(int i2) {
        int postDescWidth;
        boolean z = true;
        AppMethodBeat.i(100548);
        if (getText() == null) {
            super.setMaxLines(i2);
        }
        if (i2 < 7) {
            if (this.Ffy) {
                setConfig(f.fll().flm());
                this.Ffy = false;
            }
            z = false;
        } else {
            if (!this.Ffy) {
                setConfig(f.fll().getTextViewConfig());
                this.Ffy = true;
            }
            z = false;
        }
        if (z) {
            f a2 = c.hue.a(getConfig(), getText());
            if (a2 == null && (postDescWidth = getPostDescWidth()) > 0) {
                a2 = d.a(getText(), postDescWidth, getConfig()).aBl();
            }
            if (a2 != null) {
                setTextLayout(a2);
            }
        }
        AppMethodBeat.o(100548);
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void B(CharSequence charSequence) {
        AppMethodBeat.i(100549);
        super.B(charSequence);
        hitCount++;
        AppMethodBeat.o(100549);
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void A(CharSequence charSequence) {
        AppMethodBeat.i(100550);
        if (charSequence != null) {
            setText(charSequence, true);
        }
        missCount++;
        AppMethodBeat.o(100550);
    }

    private int getPostDescWidth() {
        AppMethodBeat.i(100551);
        if (this.Ffz > 0) {
            int i2 = this.Ffz;
            AppMethodBeat.o(100551);
            return i2;
        }
        int viewWidth = f.fll().getViewWidth();
        AppMethodBeat.o(100551);
        return viewWidth;
    }

    public void setCollapseibleMap(Map<String, Integer> map) {
        this.FfC = map;
    }

    public void setShrinkOrSpreadListener(b bVar) {
        this.FfA = bVar;
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView, com.tencent.mm.kiss.widget.textview.PLTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(100552);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(100552);
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        bg bgVar;
        AppMethodBeat.i(204005);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.pJi = true;
                postDelayed(this.FfD, (long) this.FfB);
                break;
            case 1:
                if (!this.ooU && this.pJi && !this.isAd && (getTag() instanceof bg) && (bgVar = (bg) getTag()) != null && this.FfC != null && (!this.FfC.containsKey(bgVar.dJX) || !this.FfC.get(bgVar.dJX).equals(0))) {
                    if (!this.FfC.containsKey(bgVar.dJX) || !this.FfC.get(bgVar.dJX).equals(1)) {
                        this.FfC.put(bgVar.dJX, 1);
                        if (this.FfA != null) {
                            this.FfA.fiW();
                        }
                    } else {
                        this.FfC.put(bgVar.dJX, 2);
                        if (this.FfA != null) {
                            this.FfA.fiW();
                        }
                    }
                }
                this.ooU = false;
                this.pJi = false;
                removeCallbacks(this.FfD);
                break;
            case 3:
                this.ooU = false;
                this.pJi = false;
                removeCallbacks(this.FfD);
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(204005);
        return onTouchEvent;
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(204002);
            SnsPostDescPreloadTextView.this.ooU = true;
            AppMethodBeat.o(204002);
        }
    }
}
