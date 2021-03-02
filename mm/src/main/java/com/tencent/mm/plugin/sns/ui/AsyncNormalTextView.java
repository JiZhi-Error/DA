package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public class AsyncNormalTextView extends CollapsibleTextView {
    private bk DQX;
    private BaseTimeLineItem.BaseViewHolder Eon;
    private int Eoo = 0;
    private String content;
    private Context context;

    public AsyncNormalTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public final void a(String str, bk bkVar, int i2, bl blVar) {
        AppMethodBeat.i(97761);
        this.Eoo = i2;
        this.content = str;
        this.DQX = bkVar;
        this.Epq = blVar;
        if (Util.isNullOrNil(str)) {
            setVisibility(8);
        }
        AppMethodBeat.o(97761);
    }

    public void setShow(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(97762);
        this.Eon = baseViewHolder;
        ffl();
        AppMethodBeat.o(97762);
    }

    public final void ffl() {
        AppMethodBeat.i(97763);
        if (!Util.isNullOrNil(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.Eoo == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.Eoo, new SpannableStringBuilder(l.b(this.context, this.content, this.Epk.getTextSize())), TextView.BufferType.NORMAL, this.DQX.Epp, this.Epq.Eql, this.Epq.Dsr, this.DQX, this.content, this.Epq.Eoq);
            } else {
                CharSequence charSequence = null;
                if (this.Epq != null) {
                    charSequence = this.Epq.ENn;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(l.b(this.context, this.content, this.Epk.getTextSize()));
                }
                if (this.Epq != null) {
                    a(this.Eoo, charSequence, TextView.BufferType.SPANNABLE, this.DQX.Epp, this.Epq.Eql, this.Epq.Dsr, this.DQX, this.content, this.Epq.Eoq);
                }
            }
            bg bgVar = new bg(this.Epq.Dsr, this.Epq.Eql, false, false, 1);
            bgVar.userName = this.Epq.mRa;
            this.Epk.setTag(bgVar);
            if (this.Epl != null) {
                this.Epl.setTag(bgVar);
            }
            this.Epm.setTag(this.Eon);
            setTag(this.Eon);
        }
        AppMethodBeat.o(97763);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.CollapsibleTextView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97764);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(97764);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(97765);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(97765);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(97766);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
        AppMethodBeat.o(97766);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(97767);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
        AppMethodBeat.o(97767);
    }

    public String getContent() {
        return this.content;
    }

    public void setContentWidth(int i2) {
        AppMethodBeat.i(97768);
        if (this.Epl != null) {
            this.Epk.setSpecialWidth(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
            this.Epl.setLayoutParams(layoutParams);
            this.Epk.setLayoutParams(layoutParams);
            this.Epm.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(97768);
    }

    @Override // com.tencent.mm.plugin.sns.ui.CollapsibleTextView
    public final void setAdTagClickCallback(a aVar, int i2) {
        AppMethodBeat.i(203228);
        super.setAdTagClickCallback(aVar, i2);
        AppMethodBeat.o(203228);
    }
}
