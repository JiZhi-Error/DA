package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class FrameAnimatorImageView extends ImageView {
    private Runnable wEt = null;
    private DrawFilter wEu = new PaintFlagsDrawFilter(0, 3);

    public interface a {
        void onStop();
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64218);
        AppMethodBeat.o(64218);
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(64219);
        AppMethodBeat.o(64219);
    }

    public final void a(int i2, final a aVar) {
        int i3 = 0;
        AppMethodBeat.i(64220);
        Drawable drawable = MMApplicationContext.getContext().getResources().getDrawable(i2);
        setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.start();
            if (animationDrawable.isOneShot()) {
                for (int i4 = 0; i4 < animationDrawable.getNumberOfFrames(); i4++) {
                    i3 = animationDrawable.getDuration(i4) + i3;
                }
                if (aVar != null) {
                    this.wEt = new Runnable() {
                        /* class com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(64217);
                            aVar.onStop();
                            AppMethodBeat.o(64217);
                        }
                    };
                    MMHandlerThread.postToMainThreadDelayed(this.wEt, (long) i3);
                }
            }
        }
        AppMethodBeat.o(64220);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(64221);
        MMHandlerThread.removeRunnable(this.wEt);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(64221);
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(64222);
        MMHandlerThread.removeRunnable(this.wEt);
        super.setImageResource(i2);
        AppMethodBeat.o(64222);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(64223);
        MMHandlerThread.removeRunnable(this.wEt);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(64223);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(64224);
        canvas.setDrawFilter(this.wEu);
        super.onDraw(canvas);
        AppMethodBeat.o(64224);
    }
}
