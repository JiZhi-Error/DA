package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    FrameLayout Jea;
    private boolean Jeb = false;
    private c Jec;
    boolean Jed = false;
    private boolean Jee = false;
    private int Jef = 0;
    a Jeg;
    b Jeh;
    private boolean Jei = false;
    private boolean Jej = false;
    private boolean Jek = false;
    private int Jel = -1;
    private Context context;
    WebView gxL;
    private int mTouchSlop;
    private boolean pOn = false;
    private int startY;
    private int waitTimes = 0;
    private int wcr;
    private int wqz;

    public interface a {
        void geq();
    }

    public interface b {
        void aa(int i2, boolean z);
    }

    public LogoWebViewWrapper(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(79590);
        this.context = context2;
        init();
        AppMethodBeat.o(79590);
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(79591);
        this.context = context2;
        init();
        AppMethodBeat.o(79591);
    }

    public void setReleaseTargetHeight(int i2) {
        this.Jef = i2;
    }

    private void init() {
        AppMethodBeat.i(79592);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
        AppMethodBeat.o(79592);
    }

    public void setFastScrollBack(boolean z) {
        this.Jee = z;
    }

    public FrameLayout getWebViewContainer() {
        AppMethodBeat.i(79593);
        if (this.Jea == null) {
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if ((childAt instanceof FrameLayout) && childAt.getId() == R.id.eso) {
                    this.Jea = (FrameLayout) childAt;
                    break;
                }
                i2++;
            }
        }
        FrameLayout frameLayout = this.Jea;
        AppMethodBeat.o(79593);
        return frameLayout;
    }

    public WebView getWebView() {
        return this.gxL;
    }

    public final void zh(boolean z) {
        this.Jed = z;
        if (this.Jed) {
            this.Jeb = false;
            this.waitTimes = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(79594);
        if (!this.Jed || this.Jei) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.Jeb = false;
                this.waitTimes = 0;
                this.Jej = false;
                AppMethodBeat.o(79594);
                return false;
            } else if (action != 2 || !this.Jeb) {
                switch (action) {
                    case 0:
                        if (this.gxL.isOverScrollStart()) {
                            this.wqz = (int) motionEvent.getY();
                            this.startY = (int) motionEvent.getY();
                            this.wcr = (int) motionEvent.getX();
                            this.Jeb = false;
                            this.waitTimes = 0;
                            this.Jei = true;
                            this.Jej = true;
                            break;
                        }
                        break;
                    case 2:
                        if (this.gxL.isOverScrollStart()) {
                            if (this.Jej) {
                                int y = (int) motionEvent.getY();
                                int x = (int) motionEvent.getX();
                                int i2 = y - this.wqz;
                                int i3 = x - this.wcr;
                                if (Math.abs(i2) > this.mTouchSlop && Math.abs(i2) > Math.abs(i3) && i2 > 0) {
                                    this.wqz = y;
                                    this.wcr = x;
                                    if (this.waitTimes != 1) {
                                        this.waitTimes++;
                                        break;
                                    } else {
                                        this.Jeb = true;
                                        this.Jej = false;
                                        Log.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                                        if (this.Jeg != null) {
                                            this.Jeg.geq();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.wqz = (int) motionEvent.getY();
                                this.startY = (int) motionEvent.getY();
                                this.wcr = (int) motionEvent.getX();
                                this.Jeb = false;
                                this.waitTimes = 0;
                                this.Jei = true;
                                this.Jej = true;
                                boolean z = this.Jeb;
                                AppMethodBeat.o(79594);
                                return z;
                            }
                        }
                        break;
                }
                boolean z2 = this.Jeb;
                AppMethodBeat.o(79594);
                return z2;
            } else {
                AppMethodBeat.o(79594);
                return true;
            }
        } else {
            AppMethodBeat.o(79594);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(79595);
        if (this.Jed && !this.Jei) {
            AppMethodBeat.o(79595);
            return false;
        } else if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Jei = true;
                    if (this.gxL.isOverScrollStart()) {
                        this.wqz = (int) motionEvent.getY();
                        this.startY = (int) motionEvent.getY();
                        this.wcr = (int) motionEvent.getX();
                        this.pOn = true;
                        AppMethodBeat.o(79595);
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    this.pOn = false;
                    if (this.Jeb || this.Jei) {
                        this.Jeb = false;
                        post(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(79586);
                                LogoWebViewWrapper.this.Jei = false;
                                AppMethodBeat.o(79586);
                            }
                        });
                        s(-this.Jef, getScrollBackDuration());
                        AppMethodBeat.o(79595);
                        return true;
                    }
                case 2:
                    if (this.Jeb) {
                        if (!this.pOn) {
                            this.wqz = (int) motionEvent.getY();
                            this.startY = (int) motionEvent.getY();
                            this.wcr = (int) motionEvent.getX();
                            this.pOn = true;
                            AppMethodBeat.o(79595);
                            return true;
                        }
                        this.wqz = (int) motionEvent.getY();
                        this.wcr = (int) motionEvent.getX();
                        int min = Math.min(this.startY - this.wqz, 0) >> 1;
                        int overScrollDistance = getOverScrollDistance();
                        int sqrt = ((int) Math.sqrt((double) ((getLogoHeight() >> 1) * Math.abs(min)))) << 1;
                        if (sqrt <= Math.abs(min)) {
                            min = -sqrt;
                        } else if (Math.abs(min) > overScrollDistance) {
                            min = -overScrollDistance;
                        }
                        agB(min);
                        if (this.Jeh != null) {
                            this.Jeh.aa(min, true);
                        }
                        AppMethodBeat.o(79595);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.o(79595);
            return false;
        } else {
            AppMethodBeat.o(79595);
            return false;
        }
    }

    private long getScrollBackDuration() {
        AppMethodBeat.i(79596);
        long abs = (long) Math.abs(getScrollY());
        long abs2 = Math.abs(abs - ((long) Math.abs(this.Jef)));
        if (abs2 >= abs) {
            AppMethodBeat.o(79596);
            return 300;
        }
        long j2 = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
        AppMethodBeat.o(79596);
        return j2;
    }

    private int getLogoHeight() {
        AppMethodBeat.i(79597);
        if (this.Jel < 0) {
            if (this.Jek) {
                this.Jel = getHeight();
            } else {
                this.Jel = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
            }
        }
        int i2 = this.Jel;
        AppMethodBeat.o(79597);
        return i2;
    }

    private int getOverScrollDistance() {
        AppMethodBeat.i(79599);
        int height = getHeight();
        AppMethodBeat.o(79599);
        return height;
    }

    public final void agB(int i2) {
        AppMethodBeat.i(79600);
        int overScrollDistance = getOverScrollDistance();
        scrollTo(0, Math.min(overScrollDistance, Math.max(-overScrollDistance, i2)));
        AppMethodBeat.o(79600);
    }

    public final void s(int i2, long j2) {
        AppMethodBeat.i(79601);
        if (this.Jec != null) {
            this.Jec.stop();
        }
        int scrollY = getScrollY();
        Log.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", Integer.valueOf(scrollY), Integer.valueOf(i2));
        if (scrollY != i2) {
            this.Jec = new c(scrollY, i2, j2);
            post(this.Jec);
        }
        AppMethodBeat.o(79601);
    }

    /* access modifiers changed from: package-private */
    public final class c implements Runnable {
        private final Interpolator Jen;
        private final int Jeo;
        private final int Jep;
        private boolean Jeq = true;
        private final long duration;
        private int pKQ = -1;
        private long startTime = -1;

        public c(int i2, int i3, long j2) {
            AppMethodBeat.i(79587);
            this.Jep = i2;
            this.Jeo = i3;
            this.Jen = LogoWebViewWrapper.this.Jee ? new AccelerateInterpolator() : new DecelerateInterpolator();
            this.duration = j2;
            AppMethodBeat.o(79587);
        }

        public final void run() {
            AppMethodBeat.i(79588);
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                long j2 = 500;
                if (this.duration > 0) {
                    j2 = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000L), 0L);
                }
                this.pKQ = this.Jep - Math.round(this.Jen.getInterpolation(((float) j2) / 1000.0f) * ((float) (this.Jep - this.Jeo)));
                LogoWebViewWrapper.this.agB(this.pKQ);
                if (LogoWebViewWrapper.this.Jeh != null) {
                    LogoWebViewWrapper.this.Jeh.aa(this.pKQ, false);
                }
            }
            if (this.Jeq && this.Jeo != this.pKQ) {
                u.b(LogoWebViewWrapper.this, this);
            }
            AppMethodBeat.o(79588);
        }

        public final void stop() {
            AppMethodBeat.i(79589);
            this.Jeq = false;
            LogoWebViewWrapper.this.removeCallbacks(this);
            AppMethodBeat.o(79589);
        }
    }

    public void setEasyMod(boolean z) {
        this.Jek = z;
    }

    public void setMMOverScrollListener(a aVar) {
        this.Jeg = aVar;
    }

    public void setMMOverScrollOffsetListener(b bVar) {
        this.Jeh = bVar;
    }
}
