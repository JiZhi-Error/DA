package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i iuL = null;
    private boolean iuM = false;
    private Runnable iuN = new Runnable() {
        /* class com.tencent.mm.memory.ui.PictureView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(156530);
            PictureView.a(PictureView.this);
            AppMethodBeat.o(156530);
        }
    };

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(156531);
        AppMethodBeat.o(156531);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(156532);
        AppMethodBeat.o(156532);
    }

    private static String cd(Object obj) {
        AppMethodBeat.i(156533);
        if (obj == null) {
            AppMethodBeat.o(156533);
            return "NULL";
        } else if (obj instanceof a) {
            String str = obj + " hashcode " + obj.hashCode() + " " + ((a) obj).aSr() + " " + ((a) obj).aSr().hashCode();
            AppMethodBeat.o(156533);
            return str;
        } else {
            String valueOf = String.valueOf(obj);
            AppMethodBeat.o(156533);
            return valueOf;
        }
    }

    public void setReleasableBitmap(n nVar) {
        AppMethodBeat.i(156534);
        if (nVar == null || nVar.equals(this.iuL)) {
            AppMethodBeat.o(156534);
            return;
        }
        setImageBitmap(nVar.aSb());
        this.iuL = nVar;
        ce(this.iuL);
        AppMethodBeat.o(156534);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(156535);
        removeCallbacks(this.iuN);
        if (drawable == null || drawable.equals(this.iuL)) {
            AppMethodBeat.o(156535);
            return;
        }
        if (this.DEBUG) {
            Log.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + cd(this.iuL) + " new:" + cd(drawable) + " " + Util.getStack().toString());
        }
        cf(this.iuL);
        if (drawable instanceof i) {
            this.iuL = (i) drawable;
        } else {
            this.iuL = null;
        }
        ce(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(156535);
    }

    private static void ce(Object obj) {
        AppMethodBeat.i(156536);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).aRW();
        }
        AppMethodBeat.o(156536);
    }

    private static void cf(Object obj) {
        AppMethodBeat.i(156537);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).aRX();
        }
        AppMethodBeat.o(156537);
    }

    private void aSs() {
        AppMethodBeat.i(156538);
        removeCallbacks(this.iuN);
        if (this.DEBUG) {
            Log.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + Util.getStack().toString());
        }
        if (this.iuM) {
            AppMethodBeat.o(156538);
            return;
        }
        this.iuM = true;
        AppMethodBeat.o(156538);
    }

    private void onDetach() {
        AppMethodBeat.i(156539);
        if (this.DEBUG) {
            Log.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + Util.getStack().toString());
        }
        if (!this.iuM) {
            AppMethodBeat.o(156539);
            return;
        }
        this.iuM = false;
        removeCallbacks(this.iuN);
        postDelayed(this.iuN, 500);
        AppMethodBeat.o(156539);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(156540);
        super.onAttachedToWindow();
        aSs();
        AppMethodBeat.o(156540);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(156541);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.o(156541);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(156542);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.o(156542);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(156543);
        super.onFinishTemporaryDetach();
        aSs();
        AppMethodBeat.o(156543);
    }

    static /* synthetic */ void a(PictureView pictureView) {
        AppMethodBeat.i(156544);
        cf(pictureView.iuL);
        pictureView.iuL = null;
        super.setImageDrawable(null);
        AppMethodBeat.o(156544);
    }
}
