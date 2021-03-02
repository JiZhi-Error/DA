package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

public final class aj extends m {
    protected boolean COc = true;
    protected SphereImageView EgD;
    protected View EgE;
    protected ImageView EgF;
    protected a EgG;
    int EgH;
    protected boolean EgI = false;
    protected SphereImageView.b EgJ = new SphereImageView.b() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdK() {
            AppMethodBeat.i(96745);
            if (!aj.this.EgI) {
                aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
                aj.this.EgI = true;
                Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onAngleChange");
            }
            aj.this.czp.removeMessages(1);
            aj.this.czp.sendEmptyMessageDelayed(1, 3000);
            AppMethodBeat.o(96745);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdL() {
            AppMethodBeat.i(96746);
            Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onTouchBegin, isRoating=" + aj.this.EgI);
            if (!aj.this.EgI) {
                aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
                aj.this.EgI = true;
            }
            aj.this.czp.removeMessages(1);
            AppMethodBeat.o(96746);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdM() {
            AppMethodBeat.i(96747);
            Log.d("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", e.C0599e.NAME);
            aj.this.czp.removeMessages(1);
            aj.this.czp.sendEmptyMessageDelayed(1, 3000);
            aj.this.EgH++;
            AppMethodBeat.o(96747);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void aQa(String str) {
            final long j2 = 800;
            AppMethodBeat.i(96748);
            Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "onUpdateImage, isFirstShow=" + aj.this.COc);
            aj.this.stopLoading();
            if (aj.this.EgF.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(96741);
                        aj.this.EgF.setVisibility(8);
                        aj.this.EgF.setImageDrawable(null);
                        aj.this.EgE.setVisibility(0);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aj.this.EgE, "alpha", 0.0f, 1.0f);
                        ofFloat.setDuration(400L);
                        ofFloat.start();
                        AppMethodBeat.o(96741);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                aj.this.EgF.startAnimation(alphaAnimation);
            }
            if (aj.this.COc) {
                aj.this.COc = false;
                aj.this.czp.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(96743);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(300);
                        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(96742);
                                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "hide rollTipView");
                                aj.this.EgE.setVisibility(8);
                                aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
                                aj.this.EgI = false;
                                AppMethodBeat.o(96742);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        aj.this.EgE.startAnimation(alphaAnimation);
                        AppMethodBeat.o(96743);
                    }
                }, 2500);
                long j3 = (long) aj.this.fdH().DWK;
                if (j3 >= 800) {
                    j2 = j3;
                }
                aj.this.czp.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass3.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(96744);
                        aj.this.EgD.feu();
                        aj.this.EgD.Ejd.requestRender();
                        String str = aj.this.fdH().DWL;
                        if (!a.kx(str, "scene_ad_landing")) {
                            Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
                            a.a(aj.this.EgD, str, "scene_ad_landing");
                        }
                        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
                        aj.this.EgD.setSensorEnabled(true);
                        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + j2);
                        aj.this.EgD.setTouchEnabled(true);
                        AppMethodBeat.o(96744);
                    }
                }, j2);
                AppMethodBeat.o(96748);
                return;
            }
            Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor, isFirstShow=false");
            aj.this.EgD.setSensorEnabled(true);
            AppMethodBeat.o(96748);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void onDetachedFromWindow() {
        }
    };
    protected boolean EgK = true;
    protected MMHandler czp = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(96740);
            aj.this.aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
            aj.this.EgI = false;
            AppMethodBeat.o(96740);
        }
    };
    protected ProgressBar krF;
    protected Context mContext;
    protected boolean onr = false;

    public aj(Context context, u uVar, ViewGroup viewGroup) {
        super(context, uVar, viewGroup);
        AppMethodBeat.i(96749);
        this.mContext = context;
        AppMethodBeat.o(96749);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bup;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96750);
        this.EgD = (SphereImageView) this.contentView.findViewById(R.id.i3l);
        this.krF = (ProgressBar) this.contentView.findViewById(R.id.glr);
        this.EgE = this.contentView.findViewById(R.id.iok);
        this.EgF = (ImageView) this.contentView.findViewById(R.id.fa8);
        this.EgD.setEventListener(this.EgJ);
        this.EgD.an(2.0f, -4.0f);
        this.EgD.setTouchSensitivity(0.35f);
        this.EgD.setSensorEnabled(false);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "createView, hash=" + this.EgD.hashCode());
        this.EgD.setTouchEnabled(false);
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "disable touch init");
        this.EgG = new a();
        this.EgG.a(new a.d() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
            public final void onStart(String str) {
                AppMethodBeat.i(96738);
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onStart");
                Bitmap kw = a.kw(str, "scene_ad_landing");
                if (kw != null) {
                    aj.this.EgF.setImageBitmap(kw);
                    aj.this.EgF.setVisibility(0);
                    AppMethodBeat.o(96738);
                    return;
                }
                aj.this.startLoading();
                AppMethodBeat.o(96738);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
            public final void a(boolean z, String str, Bitmap bitmap, String str2) {
                AppMethodBeat.i(96739);
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "ImageLoader onFinish, isSucc=" + z + ", errInfo=" + str);
                aj.this.EgD.g(bitmap, str2);
                if (!z) {
                    aj.this.stopLoading();
                }
                AppMethodBeat.o(96739);
            }
        });
        AppMethodBeat.o(96750);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96751);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins((int) ((u) this.EcX).paddingLeft, (int) ((u) this.EcX).paddingTop, (int) ((u) this.EcX).paddingRight, (int) ((u) this.EcX).paddingBottom);
            this.contentView.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(96751);
    }

    public final u fdH() {
        return (u) this.EcX;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96752);
        try {
            if (this.contentView == null || this.EgD == null || this.krF == null) {
                Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem, view==null");
                AppMethodBeat.o(96752);
            } else if (((u) this.EcX) == null) {
                Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem, getInfo==null");
                AppMethodBeat.o(96752);
            } else {
                String str = ((u) this.EcX).DWL;
                String str2 = ((u) this.EcX).DWN;
                float f2 = ((u) this.EcX).height;
                float f3 = ((u) this.EcX).width;
                boolean z = ((u) this.EcX).DYJ;
                this.onr = false;
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem， server.w=" + f3 + ", h=" + f2 + ", screen.w=" + this.mEX + ", h=" + this.mEY);
                ViewGroup.LayoutParams layoutParams = this.EgD.getLayoutParams();
                if (f2 == 0.0f || f3 == 0.0f || z) {
                    layoutParams.width = this.mEX;
                    layoutParams.height = this.mEY;
                    this.onr = true;
                } else {
                    int i2 = (this.mEX - ((int) ((u) this.EcX).paddingLeft)) - ((int) ((u) this.EcX).paddingRight);
                    if (f3 >= ((float) i2)) {
                        f3 = (float) i2;
                    }
                    layoutParams.width = (int) f3;
                    layoutParams.height = (int) ((f3 * ((u) this.EcX).height) / ((u) this.EcX).width);
                    if (layoutParams.width >= this.mEX && layoutParams.height >= this.mEY) {
                        this.onr = true;
                    }
                }
                this.EgD.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.EgF.getLayoutParams();
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.EgF.setLayoutParams(layoutParams2);
                if (str2 != null && str2.length() > 0) {
                    try {
                        this.contentView.setBackgroundColor(Color.parseColor(str2));
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "parseColor exp:" + e2.toString());
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem, imageUrl is empty");
                    AppMethodBeat.o(96752);
                    return;
                }
                Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem, loadImage isFullScreen=" + this.onr);
                this.EgG.l(str, layoutParams.width, layoutParams.height, "scene_ad_landing");
                AppMethodBeat.o(96752);
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "fillItem exp=" + e3.toString());
            AppMethodBeat.o(96752);
        }
    }

    public final void startLoading() {
        AppMethodBeat.i(96753);
        this.krF.setVisibility(0);
        AppMethodBeat.o(96753);
    }

    public final void stopLoading() {
        AppMethodBeat.i(96754);
        this.krF.setVisibility(8);
        AppMethodBeat.o(96754);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96755);
        super.eWZ();
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillAppear, isFirstApper=" + this.EgK);
        if (!this.EgK) {
            this.EgD.setSensorEnabled(true);
            if (!this.EgI) {
                aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
                this.EgI = true;
            }
            this.czp.removeMessages(1);
            this.czp.sendEmptyMessageDelayed(1, 3000);
            AppMethodBeat.o(96755);
            return;
        }
        this.EgK = false;
        AppMethodBeat.o(96755);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96756);
        super.eXa();
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDisappear, disable sensor");
        this.EgD.setSensorEnabled(false);
        AppMethodBeat.o(96756);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96757);
        super.eXd();
        Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "viewWillDestroy, disable sensor");
        this.EgD.setSensorEnabled(false);
        AppMethodBeat.o(96757);
    }

    public final Bitmap fdI() {
        int i2 = 0;
        AppMethodBeat.i(96758);
        try {
            Bitmap bitmap = this.EgD.getBitmap();
            StringBuilder append = new StringBuilder("getCurFrameBitmap, w=").append(bitmap == null ? 0 : bitmap.getWidth()).append(", h=");
            if (bitmap != null) {
                i2 = bitmap.getHeight();
            }
            Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", append.append(i2).toString());
            AppMethodBeat.o(96758);
            return bitmap;
        } catch (Throwable th) {
            Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "getCurFrameBitmap exp:" + th.toString());
            AppMethodBeat.o(96758);
            return null;
        }
    }

    public final void fdJ() {
        AppMethodBeat.i(96759);
        if (this.EgE.getVisibility() == 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.EgE, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(250L);
            ofFloat.start();
        }
        aPZ("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        AppMethodBeat.o(96759);
    }

    /* access modifiers changed from: protected */
    public final void aPZ(String str) {
        AppMethodBeat.i(96760);
        ap.h(str, this.mContext);
        AppMethodBeat.o(96760);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96761);
        if (!super.bp(jSONObject)) {
            Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData super failed");
            AppMethodBeat.o(96761);
            return false;
        }
        try {
            jSONObject.put("panCount", this.EgH);
            Log.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData json=" + jSONObject.toString());
            AppMethodBeat.o(96761);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "setComponentKVReportData exp=" + e2.toString());
            AppMethodBeat.o(96761);
            return false;
        }
    }
}
