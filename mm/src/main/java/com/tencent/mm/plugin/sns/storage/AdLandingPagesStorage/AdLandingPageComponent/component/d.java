package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d extends m {
    protected ad EbN;
    protected ImageView EbO;
    protected TextView EbP;
    protected TextView EbQ;
    protected FrameLayout EbR;
    protected RoundedCornerFrameLayout EbS;
    protected ViewGroup EbT;
    protected p EbU;
    protected boolean EbV = false;
    int clickCount = 0;
    protected View mContentView;
    protected Context mContext;
    protected Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.AnonymousClass4 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(96424);
            if (message.what == 1) {
                d.this.V(((Boolean) message.obj).booleanValue());
                AppMethodBeat.o(96424);
                return;
            }
            if (message.what == 2) {
                d.this.W(((Boolean) message.obj).booleanValue());
            }
            AppMethodBeat.o(96424);
        }
    };

    public d(Context context, ad adVar, ViewGroup viewGroup) {
        super(context, adVar, viewGroup);
        AppMethodBeat.i(96425);
        this.mContext = context;
        this.EbT = viewGroup;
        this.EbN = adVar;
        eXe();
        eWT();
        Log.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + adVar.DZi + ", hash=" + hashCode());
        AppMethodBeat.o(96425);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96426);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bue, this.EbT, false);
        this.mContentView = inflate;
        this.EbO = (ImageView) inflate.findViewById(R.id.d6c);
        this.EbP = (TextView) inflate.findViewById(R.id.d6d);
        this.EbQ = (TextView) inflate.findViewById(R.id.d6b);
        this.EbR = (FrameLayout) inflate.findViewById(R.id.d6a);
        ((RoundedCornerFrameLayout) inflate.findViewById(R.id.d68)).setRadius((float) a.fromDPToPix(this.mContext, 8));
        this.EbS = (RoundedCornerFrameLayout) inflate.findViewById(R.id.d69);
        this.EbS.setRadius((float) a.fromDPToPix(this.mContext, 4));
        this.EbT.addView(this.mContentView);
        this.mContentView.setVisibility(8);
        AppMethodBeat.o(96426);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96427);
        if (!TextUtils.isEmpty(this.EbN.iconUrl)) {
            final String str = this.EbN.iconUrl;
            h.a(str, this.EbN.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(96419);
                    Log.e("AdLandingFloatBarCompWrapper", "refreshView icon onDownloadError, url=" + str);
                    AppMethodBeat.o(96419);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(96420);
                    Log.i("AdLandingFloatBarCompWrapper", "refreshView icon onDownloaded, path=".concat(String.valueOf(str)));
                    try {
                        d.this.EbO.setImageBitmap(BitmapUtil.decodeFile(str, null));
                        d.this.EbS.setVisibility(0);
                        AppMethodBeat.o(96420);
                    } catch (Throwable th) {
                        Log.e("AdLandingFloatBarCompWrapper", "refreshView icon download exp=" + th.toString());
                        AppMethodBeat.o(96420);
                    }
                }
            });
        } else {
            this.EbS.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.EbN.title)) {
            this.EbP.setText(this.EbN.title);
            this.EbP.setVisibility(0);
        } else {
            this.EbP.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.EbN.desc)) {
            this.EbQ.setText(this.EbN.desc);
            this.EbQ.setVisibility(0);
        } else {
            this.EbQ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.EbN.lco)) {
            try {
                this.mContentView.setBackgroundColor(Color.parseColor(this.EbN.lco));
            } catch (Exception e2) {
                Log.e("AdLandingFloatBarCompWrapper", "refreshView backgroundColor, exp=" + e2.toString() + ", color=" + this.EbN.lco);
            }
        } else if (!TextUtils.isEmpty(this.EbN.DZB)) {
            h.a(this.EbN.DZB, this.EbN.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(96421);
                    Log.e("AdLandingFloatBarCompWrapper", "refreshView bkg onDownloadError");
                    AppMethodBeat.o(96421);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(96422);
                    Log.i("AdLandingFloatBarCompWrapper", "refreshView bkg onDownloaded, path=".concat(String.valueOf(str)));
                    try {
                        Drawable a2 = b.a(d.this.mContext.getResources(), str);
                        if (a2 != null) {
                            d.this.mContentView.setBackgroundDrawable(a2);
                        }
                        AppMethodBeat.o(96422);
                    } catch (Throwable th) {
                        Log.e("AdLandingFloatBarCompWrapper", "refreshView bkg download exp=" + th.toString());
                        AppMethodBeat.o(96422);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.EbN.iyd)) {
            try {
                this.EbP.setTextColor(Color.parseColor(this.EbN.iyd));
            } catch (Exception e3) {
                Log.e("AdLandingFloatBarCompWrapper", "refreshView titleColor, exp=" + e3.toString() + ", color=" + this.EbN.iyd);
            }
        }
        if (!TextUtils.isEmpty(this.EbN.DZC)) {
            try {
                this.EbQ.setTextColor(Color.parseColor(this.EbN.DZC));
            } catch (Exception e4) {
                Log.e("AdLandingFloatBarCompWrapper", "refreshView descColor, exp=" + e4.toString() + ", color=" + this.EbN.DZC);
            }
        }
        this.EbR.removeAllViews();
        m a2 = ay.a(this.mContext, this.EbN.DZH, this.EbR, 0);
        if (a2 instanceof p) {
            this.EbU = (p) a2;
        } else {
            Log.e("AdLandingFloatBarCompWrapper", "btnComp=".concat(String.valueOf(a2)));
        }
        if (this.EbU != null) {
            this.EbR.addView(this.EbU.getView());
        }
        this.EbV = this.EbN.DZD;
        this.mContentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.AnonymousClass3 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(96423);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFloatBarCompWrapper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!d.this.EbV) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFloatBarCompWrapper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96423);
                    return;
                }
                d.this.clickCount++;
                if (d.this.EbU != null) {
                    Button button = null;
                    try {
                        if (d.this.EbU instanceof q) {
                            button = ((q) d.this.EbU).Edp;
                        } else if (d.this.EbU instanceof s) {
                            button = ((s) d.this.EbU).EdB;
                        }
                        if (button != null) {
                            button.performClick();
                        } else {
                            Log.e("AdLandingFloatBarCompWrapper", "onClick noBtn found, comp=" + d.this.EbU);
                        }
                        i2 = d.this.EbU.clickCount;
                    } catch (Exception e2) {
                        Log.e("AdLandingFloatBarCompWrapper", "onClick exp=" + e2.toString());
                    }
                    Log.i("AdLandingFloatBarCompWrapper", "onClick, clickCount=" + d.this.clickCount + ", btnClickCount=" + i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFloatBarCompWrapper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96423);
                }
                i2 = 0;
                Log.i("AdLandingFloatBarCompWrapper", "onClick, clickCount=" + d.this.clickCount + ", btnClickCount=" + i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFloatBarCompWrapper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96423);
            }
        });
        AppMethodBeat.o(96427);
    }

    public final void JA(long j2) {
        AppMethodBeat.i(96428);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, Boolean.TRUE), j2);
        AppMethodBeat.o(96428);
    }

    /* access modifiers changed from: protected */
    public final void V(boolean z) {
        AppMethodBeat.i(96429);
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
        AppMethodBeat.o(96429);
    }

    public final void j(boolean z, long j2) {
        AppMethodBeat.i(96430);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, Boolean.valueOf(z)), j2);
        AppMethodBeat.o(96430);
    }

    /* access modifiers changed from: protected */
    public final void W(boolean z) {
        AppMethodBeat.i(96431);
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
        AppMethodBeat.o(96431);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(96432);
        if (this.mContentView.getVisibility() == 0) {
            AppMethodBeat.o(96432);
            return true;
        }
        AppMethodBeat.o(96432);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96433);
        super.eWZ();
        if (this.EbU != null) {
            this.EbU.eWZ();
        }
        Log.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
        if ((this.EbU instanceof u) && !((u) this.EbU).Edp.isEnabled()) {
            this.EbV = false;
        }
        AppMethodBeat.o(96433);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96434);
        super.eXa();
        if (this.EbU != null) {
            this.EbU.eXa();
        }
        Log.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + this.Dzo + ", stayTime=" + fdo());
        AppMethodBeat.o(96434);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96435);
        super.eXd();
        if (this.EbU != null) {
            this.EbU.eXd();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(96435);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(96436);
        if (this.EbN == null) {
            StringBuilder sb = new StringBuilder("kvReport, mFloatBarInfo==null?");
            if (this.EbN != null) {
                z = false;
            }
            Log.e("AdLandingFloatBarCompWrapper", sb.append(z).toString());
            AppMethodBeat.o(96436);
            return false;
        } else if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96436);
            return false;
        } else {
            try {
                jSONObject.put("clickCount", this.clickCount);
                Log.i("AdLandingFloatBarCompWrapper", "kv=" + jSONObject.toString());
                AppMethodBeat.o(96436);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("AdLandingFloatBarCompWrapper", e2, "", new Object[0]);
                AppMethodBeat.o(96436);
                return false;
            }
        }
    }

    public final void fcW() {
        AppMethodBeat.i(96437);
        if (this.EbU != null) {
            this.EbU.clickCount -= this.clickCount;
            Log.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.EbU.clickCount + ", stayTime=" + this.EbU.fdo());
        }
        AppMethodBeat.o(96437);
    }

    public final p fcX() {
        return this.EbU;
    }
}
