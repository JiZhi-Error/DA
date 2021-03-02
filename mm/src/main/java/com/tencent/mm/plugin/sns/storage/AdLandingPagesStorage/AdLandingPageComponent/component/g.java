package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.c.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class g extends m {
    protected TextView EbQ;
    protected FrameLayout EbR;
    protected ViewGroup EbT;
    protected p EbU;
    protected boolean EbV = false;
    protected aj Ecv;
    protected RoundedCornerFrameLayout Ecw;
    int clickCount = 0;
    protected View mContentView;
    protected Context mContext;
    protected Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g.AnonymousClass2 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(202863);
            if (message.what == 1) {
                g.this.V(((Boolean) message.obj).booleanValue());
                AppMethodBeat.o(202863);
                return;
            }
            if (message.what == 2) {
                g.this.W(((Boolean) message.obj).booleanValue());
            }
            AppMethodBeat.o(202863);
        }
    };

    public g(Context context, aj ajVar, ViewGroup viewGroup) {
        super(context, ajVar, viewGroup);
        AppMethodBeat.i(202865);
        this.mContext = context;
        this.EbT = viewGroup;
        this.Ecv = ajVar;
        eXe();
        eWT();
        Log.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + ajVar.DZi + ", hash=" + hashCode());
        AppMethodBeat.o(202865);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(202866);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bug, this.EbT, false);
        this.mContentView = inflate;
        this.EbQ = (TextView) inflate.findViewById(R.id.d6b);
        this.EbR = (FrameLayout) inflate.findViewById(R.id.d6a);
        this.Ecw = (RoundedCornerFrameLayout) inflate.findViewById(R.id.d68);
        this.Ecw.setRadius(0.0f);
        this.EbT.addView(this.mContentView);
        this.mContentView.setVisibility(8);
        AppMethodBeat.o(202866);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(202867);
        if (!TextUtils.isEmpty(this.Ecv.desc)) {
            this.EbQ.setText(this.Ecv.desc);
            this.EbQ.setVisibility(0);
        } else {
            this.EbQ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.Ecv.DZC)) {
            try {
                this.EbQ.setTextColor(Color.parseColor(this.Ecv.DZC));
            } catch (Exception e2) {
                Log.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + e2.toString() + ", color=" + this.Ecv.DZC);
            }
        }
        this.EbR.removeAllViews();
        m a2 = ay.a(this.mContext, this.Ecv.DZH, this.EbR, 0);
        if (a2 instanceof p) {
            this.EbU = (p) a2;
            this.EbU.a(this.Ecv.DZH, fcZ());
        } else {
            Log.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(a2)));
        }
        if (this.EbU != null) {
            this.EbR.addView(this.EbU.getView());
        }
        this.EbV = this.Ecv.DZD;
        this.mContentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g.AnonymousClass1 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(202862);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!g.this.EbV) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(202862);
                    return;
                }
                g.this.clickCount++;
                if (g.this.EbU != null) {
                    Button button = null;
                    try {
                        if (g.this.EbU instanceof q) {
                            button = ((q) g.this.EbU).Edp;
                        } else if (g.this.EbU instanceof s) {
                            button = ((s) g.this.EbU).EdB;
                        }
                        if (button != null) {
                            button.performClick();
                        } else {
                            Log.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.EbU);
                        }
                        i2 = g.this.EbU.clickCount;
                    } catch (Exception e2) {
                        Log.e("AdLandingFullScreenFloatBarComp", "onClick exp=" + e2.toString());
                    }
                    Log.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(202862);
                }
                i2 = 0;
                Log.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202862);
            }
        });
        AppMethodBeat.o(202867);
    }

    public final void fcY() {
        AppMethodBeat.i(202868);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, Boolean.TRUE), 0);
        AppMethodBeat.o(202868);
    }

    /* access modifiers changed from: protected */
    public final void V(boolean z) {
        AppMethodBeat.i(202869);
        if (this.mContentView.getVisibility() != 0) {
            this.mContentView.setVisibility(0);
            eWZ();
            this.mContentView.clearAnimation();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.5f, 1, 0.0f);
                translateAnimation.setInterpolator(new OvershootInterpolator(1.0f));
                translateAnimation.setDuration(700);
                this.mContentView.startAnimation(translateAnimation);
            }
        }
        AppMethodBeat.o(202869);
    }

    public final void vf(boolean z) {
        AppMethodBeat.i(202870);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, Boolean.valueOf(z)), 0);
        AppMethodBeat.o(202870);
    }

    /* access modifiers changed from: protected */
    public final void W(boolean z) {
        AppMethodBeat.i(202871);
        if (this.mContentView.getVisibility() == 0) {
            this.mContentView.setVisibility(8);
            eXa();
            this.mContentView.clearAnimation();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.5f);
                translateAnimation.setDuration(400);
                this.mContentView.startAnimation(translateAnimation);
            }
        }
        AppMethodBeat.o(202871);
    }

    private static ah fcZ() {
        AppMethodBeat.i(202872);
        if (ae.DJT != null) {
            ah ahVar = ae.DJT;
            AppMethodBeat.o(202872);
            return ahVar;
        }
        ah ahVar2 = new ah();
        AppMethodBeat.o(202872);
        return ahVar2;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(202873);
        super.eWZ();
        if (this.EbU != null) {
            this.EbU.eWZ();
        }
        Log.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
        AppMethodBeat.o(202873);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(202874);
        super.eXa();
        if (this.EbU != null) {
            this.EbU.eXa();
            Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.EbU.Dzo + ", mBtnComponent stayTime = " + this.EbU.fdo() + ", mBtnComponent cid = " + this.EbU.fdn());
        }
        Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + this.Dzo + ", stayTime = " + fdo());
        AppMethodBeat.o(202874);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(202875);
        super.eXd();
        if (this.EbU != null) {
            this.EbU.eXd();
            Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.EbU.Dzo + ", mBtnComponent stayTime = " + this.EbU.fdo() + ", mBtnComponent cid = " + this.EbU.fdn());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
        AppMethodBeat.o(202875);
    }

    public final void fda() {
        AppMethodBeat.i(202876);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 44);
        if (this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            layoutParams.leftMargin = fromDPToPix;
            layoutParams.rightMargin = fromDPToPix;
        }
        if (this.EbR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) this.EbR.getLayoutParams()).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 24);
        }
        AppMethodBeat.o(202876);
    }

    public final void fdb() {
        AppMethodBeat.i(202877);
        if (this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
        AppMethodBeat.o(202877);
    }

    public static class a {
        i Ecy = new i();

        public a(int i2, long j2, int i3, String str, int i4, long j3, int i5) {
            AppMethodBeat.i(202864);
            try {
                i iVar = new i();
                iVar.h("cid", str);
                iVar.U(f.COL_EXPOSURECOUNT, i4);
                iVar.v("stayTime", j3);
                iVar.U("clickCount", i5);
                this.Ecy.U(f.COL_EXPOSURECOUNT, i2);
                this.Ecy.v("stayTime", j2);
                this.Ecy.U("clickCount", i3);
                this.Ecy.h("btnInfo", iVar);
                AppMethodBeat.o(202864);
            } catch (Throwable th) {
                Log.e("AdLandingFullScreenFloatBarComp", th.toString());
                AppMethodBeat.o(202864);
            }
        }
    }

    public final String fdc() {
        AppMethodBeat.i(202878);
        try {
            p pVar = this.EbU;
            if (pVar != null) {
                if (this.EbU != null) {
                    this.EbU.clickCount -= this.clickCount;
                    Log.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.EbU.clickCount + ", stayTime=" + this.EbU.fdo());
                }
                String iVar = new a(this.Dzo, fdo(), this.clickCount, pVar.fdn(), pVar.Dzo, pVar.fdo(), pVar.clickCount).Ecy.toString();
                AppMethodBeat.o(202878);
                return iVar;
            }
        } catch (Throwable th) {
            Log.e("AdLandingFullScreenFloatBarComp", th.toString());
        }
        AppMethodBeat.o(202878);
        return "";
    }
}
