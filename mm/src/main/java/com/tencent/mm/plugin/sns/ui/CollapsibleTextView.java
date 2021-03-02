package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private int Eoo = 0;
    protected SnsPostDescPreloadTextView Epk;
    protected SnsTextView Epl;
    protected TextView Epm;
    private String Epn;
    private String Epo;
    private HashMap<String, Integer> Epp;
    protected bl Epq;
    private Runnable Epr = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.CollapsibleTextView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(97836);
            if (CollapsibleTextView.this.Epk != null && (CollapsibleTextView.this.Epk.getTag() instanceof bg) && ((bg) CollapsibleTextView.this.Epk.getTag()).dRS.equals(CollapsibleTextView.this.dRS)) {
                CollapsibleTextView.this.Epk.setMaxLines(6);
                CollapsibleTextView.this.Epm.setVisibility(0);
                CollapsibleTextView.this.Epm.setText(CollapsibleTextView.this.Epn);
            }
            AppMethodBeat.o(97836);
        }
    };
    private Context context;
    private String dJX;
    private String dRS;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean isAd = false;
    protected a mAdTagClickCallback;
    protected int position;
    private CharSequence text;

    public CollapsibleTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(97837);
        this.context = context2;
        this.Epn = this.context.getString(R.string.h5o);
        this.Epo = this.context.getString(R.string.h5n);
        View inflate = aa.jQ(this.context).inflate(R.layout.uu, this);
        inflate.setPadding(0, -3, 0, 0);
        this.Epk = (SnsPostDescPreloadTextView) inflate.findViewById(R.id.bn6);
        this.Epm = (TextView) inflate.findViewById(R.id.bn4);
        this.Epl = (SnsTextView) inflate.findViewById(R.id.bn7);
        AppMethodBeat.o(97837);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(int i2, CharSequence charSequence, TextView.BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, bk bkVar, String str3, boolean z) {
        AppMethodBeat.i(97838);
        this.context = bkVar.gte;
        this.Epp = hashMap;
        this.text = charSequence;
        this.isAd = z;
        this.dJX = str;
        this.dRS = str2;
        this.Eoo = i2;
        this.Epk.setCollapseibleMap(hashMap);
        this.Epk.setIsAd(z);
        this.Epn = this.context.getString(R.string.h5o);
        this.Epo = this.context.getString(R.string.h5n);
        this.Epl.setOriginText(str3);
        bg bgVar = new bg(this.dRS, this.dJX, false, false, 1);
        bgVar.userName = this.Epq.mRa;
        if (i2 == 0) {
            this.Epk.setText(charSequence);
            this.Epl.setVisibility(8);
            this.Epm.setVisibility(0);
            this.Epk.setVisibility(0);
            o oVar = new o(this.context);
            oVar.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
            oVar.mAdTagClickScene = 30;
            this.Epk.setOnTouchListener(oVar);
            this.Epk.setTag(bgVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.Epm.setVisibility(8);
                this.Epk.setMaxLines(8);
                AppMethodBeat.o(97838);
                return;
            }
            this.hasCheck = true;
            switch (hashMap.get(str).intValue()) {
                case 0:
                    this.Epm.setVisibility(8);
                    AppMethodBeat.o(97838);
                    return;
                case 1:
                    this.Epk.setMaxLines(6);
                    this.Epm.setVisibility(0);
                    this.Epm.setText(this.Epn);
                    AppMethodBeat.o(97838);
                    return;
                case 2:
                    this.Epk.setMaxLines(Integer.MAX_VALUE);
                    this.Epm.setVisibility(0);
                    this.Epm.setText(this.Epo);
                    break;
            }
            AppMethodBeat.o(97838);
            return;
        }
        this.Epl.setText(charSequence, bufferType);
        this.Epl.setTag(bgVar);
        this.Epl.setVisibility(0);
        this.Epm.setVisibility(8);
        this.Epk.setVisibility(8);
        this.Epl.setOnClickListener(bkVar.DQs.FaO);
        AppMethodBeat.o(97838);
    }

    public int getSpreadHeight() {
        AppMethodBeat.i(97839);
        Log.i("MicroMsg.CollapsibleTextView", "count:" + this.Epk.getLineCount() + "  height:" + this.Epk.getLineHeight());
        int lineCount = (this.Epk.getLineCount() - 7) * this.Epk.getLineHeight();
        AppMethodBeat.o(97839);
        return lineCount;
    }

    public void setOpClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(97840);
        if (this.Epm != null) {
            this.Epm.setOnClickListener(onClickListener);
        }
        setOnClickListener(onClickListener);
        AppMethodBeat.o(97840);
    }

    public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b bVar) {
        AppMethodBeat.i(203233);
        if (this.Epk != null) {
            this.Epk.setShrinkOrSpreadListener(bVar);
        }
        AppMethodBeat.o(203233);
    }

    public void setLongClickable(boolean z) {
        AppMethodBeat.i(97841);
        this.Epm.setLongClickable(z);
        this.Epl.setLongClickable(z);
        this.Epk.setLongClickable(z);
        super.setLongClickable(z);
        AppMethodBeat.o(97841);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(97842);
        this.Epm.setClickable(z);
        this.Epl.setClickable(z);
        this.Epk.setClickable(z);
        super.setClickable(z);
        AppMethodBeat.o(97842);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97843);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.Eoo == 0 && !this.isAd) {
            if (this.hasCheck) {
                AppMethodBeat.o(97843);
                return;
            }
            this.hasCheck = true;
            if (this.Epk.getLineCount() <= 7) {
                this.Epp.put(this.dJX, 0);
                AppMethodBeat.o(97843);
                return;
            }
            this.Epp.put(this.dJX, 1);
            this.handler.post(this.Epr);
        }
        AppMethodBeat.o(97843);
    }

    public void setAdTagClickCallback(a aVar, int i2) {
        this.mAdTagClickCallback = aVar;
        this.position = i2;
    }
}
