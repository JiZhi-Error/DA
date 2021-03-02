package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WebViewBag extends FrameLayout {
    private static final int JkI = (((com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - b.oYI) - b.Jkx) - b.Jky);
    private Point HpF = new Point();
    private Point HpG = new Point();
    private Point HpH = new Point();
    private Point HpI;
    private a JkF;
    private WebViewBagBgView JkG;
    private boolean JkH;
    private Runnable aco = new Runnable() {
        /* class com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(80416);
            float currentTimeMillis = (((float) (System.currentTimeMillis() - WebViewBag.this.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                WebViewBag.this.czp.postDelayed(WebViewBag.this.aco, 5);
                WebViewBag.a(WebViewBag.this, WebViewBag.this.HpG.x + ((int) (((((float) WebViewBag.this.HpH.x) * 1.0f) - ((float) WebViewBag.this.HpG.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) WebViewBag.this.HpH.y) * 1.0f) - ((float) WebViewBag.this.HpG.y)))) + WebViewBag.this.HpG.y);
                AppMethodBeat.o(80416);
                return;
            }
            WebViewBag.a(WebViewBag.this, WebViewBag.this.HpH.x, WebViewBag.this.HpH.y);
            WebViewBag.e(WebViewBag.this);
            AppMethodBeat.o(80416);
        }
    };
    protected MMHandler czp;
    private View kHq;
    private ImageView lIM;
    private View.OnClickListener mOnClickListener;
    private long mStartTime;
    private WindowManager mWindowManager;
    private PointF okA = new PointF();

    public interface a {
        void kp(int i2, int i3);

        void onTouchEvent(MotionEvent motionEvent);
    }

    static /* synthetic */ void a(WebViewBag webViewBag, int i2, int i3) {
        AppMethodBeat.i(80424);
        webViewBag.ko(i2, i3);
        AppMethodBeat.o(80424);
    }

    static /* synthetic */ void e(WebViewBag webViewBag) {
        AppMethodBeat.i(80425);
        webViewBag.onAnimationEnd();
        AppMethodBeat.o(80425);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(80417);
        Log.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", Integer.valueOf(configuration.orientation));
        this.HpI.x = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
        this.HpI.y = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
        AppMethodBeat.o(80417);
    }

    public WebViewBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(80418);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.czp = new MMHandler();
        this.HpI = new Point(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()), com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
        LayoutInflater.from(context).inflate(R.layout.cbl, this);
        this.lIM = (ImageView) findViewById(R.id.dt5);
        this.JkG = (WebViewBagBgView) findViewById(R.id.a2x);
        this.kHq = findViewById(R.id.h8v);
        this.JkG.setStartColor(context.getResources().getColor(R.color.afh));
        this.JkG.setAngryColor(context.getResources().getColor(R.color.afg));
        AppMethodBeat.o(80418);
    }

    public void setIcon(String str) {
        AppMethodBeat.i(80419);
        c.a aVar = new c.a();
        aVar.iaT = true;
        aVar.jbf = true;
        aVar.prefixPath = d.aSY();
        aVar.jbq = R.raw.webview_bag_default_icon;
        q.bcV().a(str, this.lIM, aVar.bdv());
        AppMethodBeat.o(80419);
    }

    public final void p(int i2, int i3, long j2) {
        AppMethodBeat.i(80420);
        WebViewBagBgView webViewBagBgView = this.JkG;
        webViewBagBgView.JkR = false;
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", Long.valueOf(j2), Long.valueOf(currentTimeMillis));
        webViewBagBgView.atU = i2;
        webViewBagBgView.FNL = i3;
        webViewBagBgView.mStartTime = j2;
        webViewBagBgView.Mg(currentTimeMillis);
        if (j2 > currentTimeMillis) {
            webViewBagBgView.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(80428);
                    WebViewBagBgView.this.JkR = true;
                    WebViewBagBgView.this.invalidate();
                    AppMethodBeat.o(80428);
                }
            }, j2 - currentTimeMillis);
        } else {
            webViewBagBgView.JkR = true;
        }
        webViewBagBgView.invalidate();
        AppMethodBeat.o(80420);
    }

    public void setListener(a aVar) {
        this.JkF = aVar;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.i(80421);
        Log.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", Boolean.valueOf(z));
        this.JkH = z;
        AppMethodBeat.o(80421);
    }

    /* access modifiers changed from: protected */
    public Point getLastTouchDownViewPos() {
        return this.HpF;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(80422);
        if (!this.JkH) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(80422);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.okA.x = motionEvent.getRawX();
                this.okA.y = motionEvent.getRawY();
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                this.HpF.x = layoutParams.x;
                this.HpF.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.okA.x) < ((float) BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.okA.y) < ((float) BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0f))) {
                    if (this.mOnClickListener != null) {
                        this.mOnClickListener.onClick(this);
                        break;
                    }
                } else {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.HpG.x = (int) Math.max(Math.min((rawX + ((float) this.HpF.x)) - this.okA.x, (float) this.HpI.x), 0.0f);
                    this.HpG.y = (int) Math.max(Math.min((rawY + ((float) this.HpF.y)) - this.okA.y, (float) this.HpI.y), 0.0f);
                    if (this.HpG.x + (getWidth() / 2) <= this.HpI.x / 2) {
                        this.HpH.x = b.Jky;
                    } else {
                        this.HpH.x = (this.HpI.x - getWidth()) - b.Jky;
                    }
                    this.HpH.y = this.HpG.y;
                    if (this.HpH.y == 0) {
                        this.HpH.y = b.Jky;
                    } else if (this.HpH.y > JkI) {
                        this.HpH.y = JkI;
                    }
                    this.mStartTime = System.currentTimeMillis();
                    this.czp.postDelayed(this.aco, 5);
                    if (this.JkF != null) {
                        this.JkF.kp(this.HpH.x, this.HpH.y);
                        break;
                    }
                }
                break;
            case 2:
                ko((int) Math.max(Math.min((((float) this.HpF.x) + motionEvent.getRawX()) - this.okA.x, (float) this.HpI.x), 0.0f), (int) Math.max(Math.min((((float) this.HpF.y) + motionEvent.getRawY()) - this.okA.y, (float) this.HpI.y), 0.0f));
                break;
        }
        if (this.JkF != null) {
            this.JkF.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(80422);
        return true;
    }

    static {
        AppMethodBeat.i(80426);
        AppMethodBeat.o(80426);
    }

    private void ko(int i2, int i3) {
        AppMethodBeat.i(80423);
        if (this.mWindowManager != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            try {
                this.mWindowManager.updateViewLayout(this, layoutParams);
                AppMethodBeat.o(80423);
                return;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.WebViewBag", th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(80423);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
