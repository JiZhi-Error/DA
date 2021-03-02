package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView extends LinearLayout {
    private int rmJ = 0;
    private MTimerHandler xOF = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.widget.AutoScrollTextView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(42570);
            AutoScrollTextView.a(AutoScrollTextView.this);
            AppMethodBeat.o(42570);
            return true;
        }
    }, true);
    private ArrayList<String> xPU = new ArrayList<>();
    private Animation xQb;
    private Animation xQc;
    private TextView xZy;
    private TextView xZz;

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42571);
        this.xZy = new TextView(context, attributeSet);
        this.xZy.setVisibility(8);
        this.xZz = new TextView(context, attributeSet);
        this.xZz.setVisibility(8);
        addView(this.xZy);
        addView(this.xZz);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.xQb = AnimationUtils.loadAnimation(context, R.anim.el);
        this.xQc = AnimationUtils.loadAnimation(context, R.anim.et);
        AppMethodBeat.o(42571);
    }

    public void setText(List<String> list) {
        AppMethodBeat.i(42572);
        this.xPU.clear();
        this.xOF.stopTimer();
        if (list == null || list.size() == 0) {
            this.xZy.setVisibility(8);
            this.xZz.setVisibility(8);
            AppMethodBeat.o(42572);
            return;
        }
        this.xPU.addAll(list);
        e(this.xZy, this.xPU.get(0));
        this.xZy.setVisibility(0);
        this.rmJ = 0;
        if (this.xPU.size() == 1) {
            AppMethodBeat.o(42572);
            return;
        }
        this.xOF.startTimer(5000);
        AppMethodBeat.o(42572);
    }

    private void e(TextView textView, String str) {
        AppMethodBeat.i(42573);
        textView.setText(new SpannableString(l.b(getContext(), str, textView.getTextSize())));
        AppMethodBeat.o(42573);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(42574);
        super.onDetachedFromWindow();
        this.xOF.stopTimer();
        AppMethodBeat.o(42574);
    }

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        String str;
        AppMethodBeat.i(42575);
        if (autoScrollTextView.xPU.size() >= 2) {
            if (autoScrollTextView.rmJ < autoScrollTextView.xPU.size() - 1) {
                autoScrollTextView.rmJ++;
                str = autoScrollTextView.xPU.get(autoScrollTextView.rmJ);
            } else {
                autoScrollTextView.rmJ = 0;
                str = autoScrollTextView.xPU.get(autoScrollTextView.rmJ);
            }
            autoScrollTextView.e(autoScrollTextView.xZz, str);
            autoScrollTextView.xZy.startAnimation(autoScrollTextView.xQc);
            autoScrollTextView.xZy.setVisibility(8);
            autoScrollTextView.xZz.startAnimation(autoScrollTextView.xQb);
            autoScrollTextView.xZz.setVisibility(0);
            TextView textView = autoScrollTextView.xZy;
            autoScrollTextView.xZy = autoScrollTextView.xZz;
            autoScrollTextView.xZz = textView;
        }
        AppMethodBeat.o(42575);
    }
}
