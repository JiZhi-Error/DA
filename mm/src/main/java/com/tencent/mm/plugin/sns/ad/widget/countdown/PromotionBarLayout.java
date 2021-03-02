package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.m;

public class PromotionBarLayout extends RelativeLayout implements c {
    private d DAp;
    private a DAq;
    private View DAw;
    private TextView DAx;
    private TextView DAy;

    public PromotionBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PromotionBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(202401);
        super.onFinishInflate();
        try {
            this.DAq = new a(this);
            this.DAw = findViewById(R.id.g0);
            this.DAx = (TextView) findViewById(R.id.g1);
            this.DAy = (TextView) findViewById(R.id.hua);
            AppMethodBeat.o(202401);
        } catch (Throwable th) {
            AppMethodBeat.o(202401);
        }
    }

    public void setPromotionalPrice(String str) {
        AppMethodBeat.i(202402);
        if (this.DAx != null && !TextUtils.isEmpty(str)) {
            this.DAx.setText(str);
            m.u(this.DAx);
        }
        AppMethodBeat.o(202402);
    }

    public void setRightTitle(String str) {
        AppMethodBeat.i(202403);
        if (this.DAy != null) {
            this.DAy.setText(str);
        }
        AppMethodBeat.o(202403);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(202404);
        try {
            a aVar = this.DAq;
            if (!(aVar == null || aVar.DAr == null)) {
                d countDownVM = aVar.DAr.getCountDownVM();
                if (!(countDownVM == null || countDownVM == dVar)) {
                    a.a(countDownVM);
                }
                dVar.a(aVar.DAr);
                dVar.eYr();
            }
            this.DAp = dVar;
            AppMethodBeat.o(202404);
        } catch (Throwable th) {
            AppMethodBeat.o(202404);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(202405);
        super.onDetachedFromWindow();
        try {
            if (this.DAq != null) {
                a.a(this.DAp);
            }
            AppMethodBeat.o(202405);
        } catch (Throwable th) {
            AppMethodBeat.o(202405);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.c
    public d getCountDownVM() {
        return this.DAp;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.c
    public final void b(long j2, e.a aVar) {
        AppMethodBeat.i(202406);
        if (j2 <= 0) {
            try {
                setVisibility(8);
            } catch (Throwable th) {
                AppMethodBeat.o(202406);
                return;
            }
        }
        View view = this.DAw;
        if (view instanceof c) {
            ((c) view).b(j2, aVar);
        }
        AppMethodBeat.o(202406);
    }
}
