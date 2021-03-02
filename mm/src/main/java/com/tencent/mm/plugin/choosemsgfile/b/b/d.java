package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;

public abstract class d extends a<m> {
    public d(g gVar, ca caVar) {
        super(gVar, caVar);
    }

    /* access modifiers changed from: protected */
    public String aWd() {
        return "";
    }

    public void a(m mVar, int i2, a aVar) {
        mVar.puw.setTag(this);
        mVar.qoi.setTag(this);
        q.bcV().a(aWd(), mVar.puw, c.eT(getContext()));
        mVar.qof.setVisibility(8);
        mVar.qog.setVisibility(8);
        mVar.qod.setVisibility(8);
        mVar.qoe.setVisibility(8);
        mVar.qoi.setVisibility(0);
        mVar.gxr.setVisibility(0);
        V(mVar);
        if (cys().BY(this.qnv.field_msgId)) {
            mVar.qoh.setVisibility(8);
            mVar.gxr.setChecked(true);
        } else {
            mVar.qoh.setVisibility(0);
            mVar.gxr.setChecked(false);
        }
        if (isEnable()) {
            mVar.qob.setAlpha(1.0f);
        } else {
            mVar.qob.setAlpha(0.6f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void V(final m mVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(mVar);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.choosemsgfile.b.b.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(123266);
                    d.this.b(mVar);
                    AppMethodBeat.o(123266);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(m mVar) {
        switch (this.qnF) {
            case 0:
                mVar.kdb.setVisibility(8);
                mVar.qoc.setVisibility(8);
                mVar.gxr.setVisibility(0);
                mVar.qoi.setVisibility(0);
                mVar.gxr.setChecked(false);
                mVar.qoj.setVisibility(8);
                return;
            case 1:
                mVar.kdb.setVisibility(0);
                mVar.qoc.setVisibility(8);
                mVar.gxr.setVisibility(8);
                mVar.qoi.setVisibility(8);
                mVar.qoj.setVisibility(8);
                return;
            case 2:
                mVar.kdb.setVisibility(0);
                mVar.qoc.setVisibility(0);
                mVar.gxr.setVisibility(8);
                mVar.qoi.setVisibility(8);
                mVar.qoj.setVisibility(8);
                if (this.aqi > 0) {
                    int i2 = (int) ((((float) this.fs) / ((float) this.aqi)) * 100.0f);
                    if (i2 == -1 || i2 >= 100) {
                        mVar.qoc.setProgress(100);
                        return;
                    } else {
                        mVar.qoc.setProgress(i2);
                        return;
                    }
                } else {
                    return;
                }
            case 3:
                mVar.kdb.setVisibility(8);
                mVar.qoc.setVisibility(8);
                mVar.gxr.setVisibility(0);
                mVar.qoi.setVisibility(0);
                mVar.qoj.setVisibility(8);
                return;
            case 4:
                mVar.kdb.setVisibility(8);
                mVar.qoc.setVisibility(8);
                mVar.gxr.setVisibility(8);
                mVar.qoi.setVisibility(8);
                mVar.qoj.setVisibility(0);
                return;
            case 5:
                mVar.kdb.setVisibility(8);
                mVar.qoc.setVisibility(8);
                mVar.gxr.setVisibility(8);
                mVar.qoi.setVisibility(8);
                mVar.qoj.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
