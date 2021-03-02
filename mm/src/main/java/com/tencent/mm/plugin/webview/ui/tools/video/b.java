package com.tencent.mm.plugin.webview.ui.tools.video;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private int JxP;
    public boolean JxQ = false;
    public Context mContext;
    private int nEA;
    private WindowManager.LayoutParams nEB;
    private View nEb;
    private int nEd;
    private ViewGroup.LayoutParams nEe;
    private ViewGroup nEf;
    private final Set<c> nEg = Collections.newSetFromMap(new ConcurrentHashMap());
    private int nEz;

    public b(Context context) {
        AppMethodBeat.i(212052);
        this.mContext = context;
        AppMethodBeat.o(212052);
    }

    public final void release() {
        AppMethodBeat.i(212053);
        this.nEg.clear();
        AppMethodBeat.o(212053);
    }

    public final boolean zr(boolean z) {
        AppMethodBeat.i(212055);
        if (this.nEb == null) {
            AppMethodBeat.o(212055);
            return false;
        }
        Activity activity = (Activity) this.mContext;
        if (z || (activity != null && !activity.isFinishing() && !activity.isDestroyed())) {
            ((ViewGroup) activity.getWindow().getDecorView()).setSystemUiVisibility(this.nEz);
            activity.getWindow().clearFlags(1024);
            if (this.nEB != null) {
                activity.getWindow().setAttributes(this.nEB);
            }
            activity.setRequestedOrientation(this.nEA);
            Log.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", Integer.valueOf(this.nEA));
            if (this.nEf != null) {
                if (this.nEb.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.nEb.getParent()).removeView(this.nEb);
                }
                this.nEf.addView(this.nEb, this.nEd, this.nEe);
                this.nEb.setBackgroundColor(this.JxP);
            }
            this.nEb = null;
            f.e(false, true, true);
            for (c cVar : this.nEg) {
                cVar.Na();
            }
            AppMethodBeat.o(212055);
            return true;
        }
        Log.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", activity);
        AppMethodBeat.o(212055);
        return false;
    }

    public final boolean bJb() {
        return this.nEb != null;
    }

    public final void c(c cVar) {
        AppMethodBeat.i(212056);
        if (!this.nEg.contains(cVar)) {
            this.nEg.add(cVar);
        }
        AppMethodBeat.o(212056);
    }

    public final void d(c cVar) {
        AppMethodBeat.i(212057);
        this.nEg.remove(cVar);
        AppMethodBeat.o(212057);
    }

    private void bTL() {
        AppMethodBeat.i(212058);
        for (c cVar : this.nEg) {
            cVar.bDq();
        }
        AppMethodBeat.o(212058);
    }

    public final void N(View view, int i2) {
        AppMethodBeat.i(212054);
        Activity activity = (Activity) this.mContext;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            Log.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", activity);
            AppMethodBeat.o(212054);
            return;
        }
        View view2 = this.nEb;
        this.nEb = view;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (view2 == null) {
            if (view.getParent() instanceof ViewGroup) {
                this.nEf = (ViewGroup) view.getParent();
                this.nEd = this.nEf.indexOfChild(view);
                this.nEe = view.getLayoutParams();
                this.nEf.removeView(view);
                this.JxP = this.nEb.getDrawingCacheBackgroundColor();
                this.nEb.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            } else {
                this.nEd = 0;
                this.nEf = null;
                this.nEe = null;
            }
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            viewGroup.bringChildToFront(view);
            view.setX(0.0f);
            view.setY(0.0f);
        }
        if (view2 == null) {
            this.nEz = viewGroup.getSystemUiVisibility();
        }
        viewGroup.setSystemUiVisibility(5894);
        if (view2 == null) {
            this.nEB = new WindowManager.LayoutParams();
            this.nEB.copyFrom(activity.getWindow().getAttributes());
        }
        activity.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        if (view2 == null) {
            this.nEA = activity.getRequestedOrientation();
            Log.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", Integer.valueOf(this.nEA));
        }
        switch (i2) {
            case -90:
                activity.setRequestedOrientation(8);
                break;
            case 0:
                activity.setRequestedOrientation(1);
                break;
            case 90:
                activity.setRequestedOrientation(0);
                break;
            default:
                activity.setRequestedOrientation(9);
                break;
        }
        f.e(true, true, true);
        bTL();
        AppMethodBeat.o(212054);
    }
}
