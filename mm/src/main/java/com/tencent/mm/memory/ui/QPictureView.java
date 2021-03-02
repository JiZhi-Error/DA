package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView extends QImageView {
    private boolean DEBUG = false;
    private i iuL = null;
    private boolean iuM = false;
    private Runnable iuN = new Runnable() {
        /* class com.tencent.mm.memory.ui.QPictureView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(156546);
            QPictureView.a(QPictureView.this);
            AppMethodBeat.o(156546);
        }
    };

    public QPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(156547);
        AppMethodBeat.o(156547);
    }

    public QPictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(156548);
        AppMethodBeat.o(156548);
    }

    private static String cd(Object obj) {
        AppMethodBeat.i(156549);
        if (obj == null) {
            AppMethodBeat.o(156549);
            return "NULL";
        } else if (obj instanceof a) {
            String str = obj + " hashcode " + obj.hashCode() + " " + ((a) obj).aSr() + " " + ((a) obj).aSr().hashCode();
            AppMethodBeat.o(156549);
            return str;
        } else {
            String valueOf = String.valueOf(obj);
            AppMethodBeat.o(156549);
            return valueOf;
        }
    }

    public void setReleasableBitmap(n nVar) {
        AppMethodBeat.i(156550);
        if (nVar == null || nVar.equals(this.iuL)) {
            AppMethodBeat.o(156550);
            return;
        }
        setImageBitmap(nVar.aSb());
        this.iuL = nVar;
        ce(this.iuL);
        AppMethodBeat.o(156550);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(156551);
        removeCallbacks(this.iuN);
        if (drawable == null || drawable.equals(this.iuL)) {
            AppMethodBeat.o(156551);
            return;
        }
        if (this.DEBUG) {
            Log.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + cd(this.iuL) + " new:" + cd(drawable) + " " + Util.getStack().toString());
        }
        cf(this.iuL);
        if (drawable instanceof i) {
            this.iuL = (i) drawable;
        } else {
            this.iuL = null;
        }
        ce(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(156551);
    }

    private static void ce(Object obj) {
        AppMethodBeat.i(156552);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).aRW();
        }
        AppMethodBeat.o(156552);
    }

    private static void cf(Object obj) {
        AppMethodBeat.i(156553);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).aRX();
        }
        AppMethodBeat.o(156553);
    }

    private void aSs() {
        AppMethodBeat.i(156554);
        if (this.DEBUG) {
            Log.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
        }
        removeCallbacks(this.iuN);
        if (this.iuM) {
            AppMethodBeat.o(156554);
            return;
        }
        this.iuM = true;
        AppMethodBeat.o(156554);
    }

    private void onDetach() {
        AppMethodBeat.i(156555);
        if (this.DEBUG) {
            Log.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
        }
        if (!this.iuM) {
            AppMethodBeat.o(156555);
            return;
        }
        this.iuM = false;
        removeCallbacks(this.iuN);
        postDelayed(this.iuN, 500);
        AppMethodBeat.o(156555);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(156556);
        super.onAttachedToWindow();
        aSs();
        AppMethodBeat.o(156556);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(156557);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.o(156557);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(156558);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.o(156558);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(156559);
        super.onFinishTemporaryDetach();
        aSs();
        AppMethodBeat.o(156559);
    }

    static /* synthetic */ void a(QPictureView qPictureView) {
        AppMethodBeat.i(156560);
        cf(qPictureView.iuL);
        qPictureView.iuL = null;
        super.setImageDrawable(null);
        AppMethodBeat.o(156560);
    }
}
