package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.at;

public class AsyncTextView extends TextView implements Runnable {
    private String Eop;
    private boolean Eoq;
    private String Eor;
    private q.a Eos;
    private boolean Eot;
    private c Eou = null;
    private int Eov = 0;
    private Context context;
    private int qcr;
    private String userName;

    public AsyncTextView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(97769);
        init(context2);
        AppMethodBeat.o(97769);
    }

    public AsyncTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(97770);
        init(context2);
        AppMethodBeat.o(97770);
    }

    private void init(Context context2) {
        AppMethodBeat.i(97771);
        this.context = context2;
        this.Eov = at.fromDPToPix(context2, 14);
        AppMethodBeat.o(97771);
    }

    public void setContactInfo(c cVar) {
        this.Eou = cVar;
    }

    public final void a(String str, String str2, q.a aVar, boolean z, String str3, int i2, boolean z2) {
        AppMethodBeat.i(97772);
        this.userName = str;
        this.Eop = str2;
        this.qcr = i2;
        this.Eoq = z;
        this.Eor = str3;
        this.Eos = aVar;
        this.Eot = z2;
        run();
        AppMethodBeat.o(97772);
    }

    public void run() {
        int i2;
        int i3;
        AppMethodBeat.i(97773);
        if (getTag() instanceof String) {
            String str = (String) getTag();
            if (!Util.isNullOrNil(str, this.userName) && !this.Eoq && str.equals(this.userName)) {
                AppMethodBeat.o(97773);
                return;
            }
        }
        if (this.Eou == null || !as.bjp(this.Eou.field_username) || !"3552365301".equals(this.Eou.field_openImAppid)) {
            i2 = 0;
            i3 = 0;
        } else {
            i3 = this.Eop.length();
            String str2 = " @" + ((a) g.af(a.class)).bN(this.Eou.field_openImAppid, this.Eou.field_descWordingId);
            this.Eop += str2;
            i2 = str2.length() + i3;
        }
        int i4 = this.qcr == 10 ? 3 : 2;
        q qVar = new q(new b(this.Eoq, this.userName, this.Eor, 1), this.Eos, i4);
        Context context2 = getContext();
        String str3 = this.Eop;
        getTextSize();
        m mVar = new m(l.f(context2, str3, i4));
        mVar.a(qVar, this.Eop, 0);
        if (this.Eou != null && i3 != i2 && i2 > i3 && i3 >= 0) {
            mVar.setSpan(((a) g.af(a.class)).f(this.context, this.Eou.field_openImAppid, this.Eov), i3, i2, 33);
        }
        setText(mVar, TextView.BufferType.SPANNABLE);
        ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(this, this.userName, a.b.SNS_FEED, a.c.OUTLINED);
        setTag(this.userName);
        AppMethodBeat.o(97773);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(97774);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(97774);
        } catch (Throwable th) {
            AppMethodBeat.o(97774);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(97775);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(97775);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AsyncTextView", th, "", new Object[0]);
            AppMethodBeat.o(97775);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(97776);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(97776);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(97776);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(97777);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(97777);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(97777);
            return true;
        }
    }
}
