package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.PointF;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    static final int Jkp;
    boolean AbM;
    C1976a Jkq;
    final b Jkr;
    boolean Jks;
    PointF Jkt = new PointF();
    boolean Jku;
    boolean mIsShowing;
    int mScreenHeight;
    int mScreenWidth;

    public interface b {
        void ggn();
    }

    static {
        int i2 = b.JkC;
        Jkp = i2 * i2;
    }

    public a(b bVar) {
        AppMethodBeat.i(80412);
        this.Jkr = bVar;
        WindowManager windowManager = (WindowManager) MMApplicationContext.getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (d.oD(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 85;
        layoutParams.width = b.JkD;
        layoutParams.height = b.JkD;
        layoutParams.x = 0;
        layoutParams.y = 0;
        this.Jkq = new C1976a(MMApplicationContext.getContext());
        try {
            this.Jkq.setVisibility(8);
            windowManager.addView(this.Jkq, layoutParams);
            AppMethodBeat.o(80412);
        } catch (Exception e2) {
            Log.e("MicroMsg.BagCancelController", "showCanceller add failed %s", e2);
            AppMethodBeat.o(80412);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.a$a  reason: collision with other inner class name */
    public static final class C1976a extends FrameLayout {
        View mContentView;
        Vibrator ooM;
        ImageView rIY = ((ImageView) findViewById(R.id.a2x));

        public C1976a(Context context) {
            super(context);
            AppMethodBeat.i(80409);
            this.ooM = (Vibrator) context.getSystemService("vibrator");
            LayoutInflater.from(context).inflate(R.layout.cbm, this);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rIY.getLayoutParams();
            layoutParams.height = b.JkC;
            layoutParams.width = b.JkC;
            this.rIY.setLayoutParams(layoutParams);
            this.mContentView = findViewById(R.id.be9);
            AppMethodBeat.o(80409);
        }

        /* access modifiers changed from: package-private */
        public final void aq(float f2, float f3) {
            AppMethodBeat.i(80410);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 1.0f, 1, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(50);
            this.rIY.startAnimation(scaleAnimation);
            AppMethodBeat.o(80410);
        }
    }
}
