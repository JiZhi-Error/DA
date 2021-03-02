package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.widget.a.c;
import com.tencent.mm.plugin.sns.ad.widget.a.d;
import com.tencent.mm.plugin.sns.ad.widget.a.e;
import com.tencent.mm.plugin.sns.ad.widget.a.f;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class ba {
    SnsInfo DqO;
    protected SnsAdTouchProgressView.a EzA = new SnsAdTouchProgressView.a() {
        /* class com.tencent.mm.plugin.sns.ui.ba.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onStart() {
            AppMethodBeat.i(179192);
            ba.this.mStartTime = System.currentTimeMillis();
            ba.this.EzB = false;
            if (ba.this.Ezu == null) {
                Log.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
                AppMethodBeat.o(179192);
                return;
            }
            Log.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ba.this.Ezu.DXd);
            r.e(new long[]{20, 100});
            ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXd);
            ba baVar = ba.this;
            if (!(baVar.Ezu == null || baVar.Ezw == null || baVar.Ezw.getVisibility() == 0)) {
                Log.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + baVar.mScene);
                if (baVar.Ezt != null) {
                    if (baVar.Ezy != null && baVar.mScene == 1) {
                        ViewGroup.LayoutParams layoutParams = baVar.Ezw.getLayoutParams();
                        int height = (baVar.Ezy.getHeight() - baVar.Ezy.getPaddingTop()) - baVar.Ezy.getPaddingBottom();
                        if (layoutParams.height != height) {
                            Log.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + layoutParams.height + ", root.h=" + baVar.Ezy.getHeight() + ", root.padingTop=" + baVar.Ezy.getPaddingTop() + ", root.padingBottom=" + baVar.Ezy.getPaddingBottom());
                            layoutParams.height = height;
                            baVar.Ezw.setLayoutParams(layoutParams);
                        }
                    }
                    SnsAdSphereAnimView snsAdSphereAnimView = baVar.Ezw;
                    Bitmap bitmap = baVar.Ezt;
                    int i2 = baVar.Ezu.DXg;
                    int i3 = baVar.Ezu.DXe;
                    Log.i("SnsAdSphereAnimView", "setData, sceneType=" + i2 + ", duration=" + i3 + ", bmp=" + bitmap);
                    if (bitmap != null) {
                        snsAdSphereAnimView.Fex = i2;
                        int fromDPToPix = a.fromDPToPix(snsAdSphereAnimView.mContext, 30);
                        int fromDPToPix2 = a.fromDPToPix(snsAdSphereAnimView.mContext, 36);
                        if (snsAdSphereAnimView.Few != null) {
                            snsAdSphereAnimView.Few.clear();
                        }
                        snsAdSphereAnimView.DAC.postDelayed(new Runnable(bitmap, fromDPToPix, fromDPToPix2, i3) {
                            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.AnonymousClass1 */
                            final /* synthetic */ int Fey;
                            final /* synthetic */ int Fez;
                            final /* synthetic */ int moi;
                            final /* synthetic */ Bitmap val$bmp;

                            {
                                this.val$bmp = r2;
                                this.Fey = r3;
                                this.Fez = r4;
                                this.moi = r5;
                            }

                            public final void run() {
                                AppMethodBeat.i(179376);
                                int width = SnsAdSphereAnimView.this.getWidth();
                                int height = SnsAdSphereAnimView.this.getHeight();
                                Log.i("SnsAdSphereAnimView", "setData, w=" + width + ", h=" + height);
                                if (SnsAdSphereAnimView.this.Fex == SnsAdSphereAnimView.Fes) {
                                    SnsAdSphereAnimView.this.Few = new c(SnsAdSphereAnimView.this.mContext, SnsAdSphereAnimView.this, this.val$bmp, width, height, this.Fey, this.Fez, this.moi);
                                    AppMethodBeat.o(179376);
                                } else if (SnsAdSphereAnimView.this.Fex == SnsAdSphereAnimView.Fet) {
                                    SnsAdSphereAnimView.this.Few = new d(SnsAdSphereAnimView.this.mContext, SnsAdSphereAnimView.this, this.val$bmp, width, height, this.Fey, this.Fez, this.moi);
                                    AppMethodBeat.o(179376);
                                } else if (SnsAdSphereAnimView.this.Fex == SnsAdSphereAnimView.Feu) {
                                    SnsAdSphereAnimView.this.Few = new f(SnsAdSphereAnimView.this.mContext, SnsAdSphereAnimView.this, this.val$bmp, width, height, this.Fey, this.Fez, this.moi);
                                    AppMethodBeat.o(179376);
                                } else {
                                    if (SnsAdSphereAnimView.this.Fex == SnsAdSphereAnimView.Fev) {
                                        SnsAdSphereAnimView.this.Few = new e(SnsAdSphereAnimView.this.mContext, SnsAdSphereAnimView.this, this.val$bmp, width, height, this.Fey, this.Fez, this.moi);
                                    }
                                    AppMethodBeat.o(179376);
                                }
                            }
                        }, 100);
                    }
                    SnsAdSphereAnimView snsAdSphereAnimView2 = baVar.Ezw;
                    Log.i("SnsAdSphereAnimView", "start");
                    snsAdSphereAnimView2.invalidate();
                    baVar.Ezw.setVisibility(0);
                }
            }
            if (ba.this.EzC != null) {
                ba.this.EzC.onStart();
            }
            AppMethodBeat.o(179192);
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onCancel() {
            AppMethodBeat.i(179193);
            if (ba.this.EzB) {
                Log.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
                AppMethodBeat.o(179193);
            } else if (ba.this.Ezu == null) {
                Log.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
                AppMethodBeat.o(179193);
            } else {
                Log.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ba.this.Ezu.DXc);
                ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXc);
                ba.this.vq(true);
                if (ba.this.EzC != null) {
                    ba.this.EzC.onCancel();
                }
                ba.a(ba.this.DqO, 1, (int) (System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
                AppMethodBeat.o(179193);
            }
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onClick(View view) {
            AppMethodBeat.i(179194);
            Log.i("SnsAdPressGestureCtrl", "onClick");
            if (ba.this.EzC != null) {
                ba.this.EzC.onClick(view);
            }
            AppMethodBeat.o(179194);
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onFinish() {
            AppMethodBeat.i(179195);
            if (!ba.this.EzB) {
                ba.this.EzB = true;
                Log.i("SnsAdPressGestureCtrl", "onFinish");
                ba.this.vq(true);
                if (ba.this.EzC != null) {
                    ba.this.EzC.onFinish();
                }
                ba.a(ba.this.DqO, 2, (int) (System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
                AppMethodBeat.o(179195);
                return;
            }
            Log.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
            AppMethodBeat.o(179195);
        }
    };
    protected boolean EzB = false;
    public SnsAdTouchProgressView.a EzC;
    Bitmap Ezt;
    ADXml.p Ezu;
    SnsAdTouchProgressView Ezv;
    SnsAdSphereAnimView Ezw;
    at Ezx;
    View Ezy;
    private volatile boolean Ezz = false;
    private Context mContext;
    int mScene;
    protected long mStartTime;

    public ba(Context context, f.a aVar, View view) {
        AppMethodBeat.i(203477);
        this.mContext = context;
        this.Ezv = aVar.EYN;
        this.Ezw = aVar.EVt;
        this.Ezx = aVar.EUK;
        this.Ezy = view;
        this.mScene = 1;
        AppMethodBeat.o(203477);
    }

    public ba(Context context, SnsAdTouchProgressView snsAdTouchProgressView, SnsAdSphereAnimView snsAdSphereAnimView, at atVar, View view) {
        AppMethodBeat.i(203478);
        this.mContext = context;
        this.Ezv = snsAdTouchProgressView;
        this.Ezw = snsAdSphereAnimView;
        this.Ezx = atVar;
        this.Ezy = view;
        this.mScene = 2;
        AppMethodBeat.o(203478);
    }

    public final boolean a(SnsInfo snsInfo, ADXml.p pVar, Rect rect) {
        AppMethodBeat.i(203479);
        if (this.DqO == null || this.DqO.field_snsId != snsInfo.field_snsId) {
            this.Ezu = pVar;
            this.DqO = snsInfo;
            this.Ezt = null;
            this.Ezz = a(pVar, snsInfo);
            Log.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.Ezz + ", snsId=" + snsInfo.field_snsId);
            if (this.Ezz) {
                Log.i("SnsAdPressGestureCtrl", "initData, start=" + this.Ezu.DXc + ", end=" + this.Ezu.DXd + ", duration=" + this.Ezu.DXe + ", pressDuration=" + this.Ezu.DXe + ", touchRect=" + rect.toShortString());
                this.Ezv.setActionListener(this.EzA);
                this.Ezv.setDuration(pVar.DXe);
                this.Ezv.setTouchRange(rect);
                this.Ezx.Ewt.setTimerInterval(250);
                final String str = pVar.DXf;
                Log.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(str)));
                if (!TextUtils.isEmpty(str)) {
                    h.a(str, false, (f.a) new f.a() {
                        /* class com.tencent.mm.plugin.sns.ui.ba.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWN() {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWO() {
                            AppMethodBeat.i(203475);
                            Log.e("SnsAdPressGestureCtrl", "onDownloadError, snsId=" + (ba.this.DqO == null ? "" : Long.valueOf(ba.this.DqO.field_snsId)) + ", url=" + str);
                            AppMethodBeat.o(203475);
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void aNH(String str) {
                            AppMethodBeat.i(203476);
                            if (ba.this.Ezu != null) {
                                String str2 = ba.this.Ezu.DXf;
                                String kz = TextUtils.isEmpty(str2) ? "" : h.kz("adId", str2);
                                if (TextUtils.isEmpty(str) || !str.equals(kz)) {
                                    Log.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
                                } else {
                                    Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                                    if (decodeFile != null) {
                                        ba.this.Ezt = decodeFile;
                                        Log.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                                        AppMethodBeat.o(203476);
                                        return;
                                    }
                                    Log.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                                    AppMethodBeat.o(203476);
                                    return;
                                }
                            }
                            AppMethodBeat.o(203476);
                        }
                    });
                }
            } else {
                this.Ezv.setActionListener(null);
                vq(false);
                fhy();
                this.Ezx.Ewt.setTimerInterval(1000);
            }
        }
        boolean z = this.Ezz;
        AppMethodBeat.o(203479);
        return z;
    }

    private static boolean a(ADXml.p pVar, SnsInfo snsInfo) {
        AppMethodBeat.i(179202);
        if (pVar == null || snsInfo == null) {
            AppMethodBeat.o(179202);
            return false;
        }
        try {
            if (pVar.DXc <= 0 || pVar.DXd <= pVar.DXc) {
                AppMethodBeat.o(179202);
                return false;
            } else if (TextUtils.isEmpty(snsInfo.getAdXml().getGestureCanvasInfo())) {
                AppMethodBeat.o(179202);
                return false;
            } else {
                AppMethodBeat.o(179202);
                return true;
            }
        } catch (Exception e2) {
            Log.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + e2.toString());
            AppMethodBeat.o(179202);
            return false;
        }
    }

    public final void a(final k kVar, final long j2, final long j3) {
        AppMethodBeat.i(179203);
        if (!this.Ezz) {
            AppMethodBeat.o(179203);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.ba.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(179191);
                try {
                    boolean fgf = ba.this.Ezx.Ewt.fgf();
                    Log.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + ba.this.Ezu.DXc + ", end=" + ba.this.Ezu.DXd + ", duration=" + ba.this.Ezu.DXe + ", curPlayTime=" + j2 + ", isPlaying=" + fgf);
                    if (j2 < ((long) ba.this.Ezu.DXc) || !fgf) {
                        ba.this.fhy();
                        ba.this.vq(false);
                    } else {
                        ba baVar = ba.this;
                        if (!(baVar.Ezv == null || baVar.Ezv.getVisibility() == 0)) {
                            Log.i("SnsAdPressGestureCtrl", "enableLongPressGestureView, scene=" + baVar.mScene);
                            if (baVar.Ezy != null) {
                                ViewGroup.LayoutParams layoutParams = baVar.Ezv.getLayoutParams();
                                int height = (baVar.Ezy.getHeight() - baVar.Ezy.getPaddingTop()) - baVar.Ezy.getPaddingBottom();
                                if (layoutParams.height != height) {
                                    Log.d("SnsAdPressGestureCtrl", "ProgressView.h=" + layoutParams.height + ", root.h=" + baVar.Ezy.getHeight() + ", root.padingTop=" + baVar.Ezy.getPaddingTop() + ", root.padingBottom=" + baVar.Ezy.getPaddingBottom());
                                    layoutParams.height = height;
                                    baVar.Ezv.setLayoutParams(layoutParams);
                                }
                            }
                            baVar.Ezv.setVisibility(0);
                        }
                    }
                    if (j2 > ((long) (ba.this.Ezu.DXd - 250)) && !ba.this.Ezv.isAnimating()) {
                        Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
                        ba.this.Ezx.Ewt.seekTo(0);
                        if (kVar != null) {
                            Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + j3);
                            kVar.I(j3, false);
                        }
                    }
                    AppMethodBeat.o(179191);
                } catch (Exception e2) {
                    Log.e("SnsAdPressGestureCtrl", "checkLongPressGesture, exp=" + e2.toString());
                    AppMethodBeat.o(179191);
                }
            }
        });
        AppMethodBeat.o(179203);
    }

    public final boolean fhx() {
        boolean z;
        String Jb;
        AppMethodBeat.i(203480);
        if (this.Ezz) {
            if (this.Ezv != null) {
                z = this.Ezv.isAnimating();
            } else {
                z = false;
            }
            if (z) {
                if (this.DqO == null) {
                    Jb = "";
                } else {
                    Jb = r.Jb(this.DqO.field_snsId);
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.mStartTime);
                j.b(j.DDZ, Jb, this.mScene, currentTimeMillis, "");
                Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + Jb + ", pressDuration=" + currentTimeMillis);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.ba.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(203473);
                        ba.this.EzA.onFinish();
                        AppMethodBeat.o(203473);
                    }
                });
                AppMethodBeat.o(203480);
                return true;
            }
        }
        AppMethodBeat.o(203480);
        return false;
    }

    public final void fhy() {
        AppMethodBeat.i(179204);
        if (!(this.Ezv == null || this.Ezv.getVisibility() == 8)) {
            Log.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
            this.Ezv.clear();
            this.Ezv.setVisibility(8);
        }
        AppMethodBeat.o(179204);
    }

    public final void vq(boolean z) {
        AppMethodBeat.i(179205);
        if (!(this.Ezw == null || this.Ezw.getVisibility() == 8)) {
            Log.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
            if (!z) {
                this.Ezw.clear();
                this.Ezw.setVisibility(8);
                AppMethodBeat.o(179205);
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.sns.ui.ba.AnonymousClass4 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(203474);
                    ba.this.Ezw.setVisibility(8);
                    ba.this.Ezw.clear();
                    AppMethodBeat.o(203474);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.Ezw.startAnimation(alphaAnimation);
        }
        AppMethodBeat.o(179205);
    }

    public static void a(SnsInfo snsInfo, int i2, int i3, int i4) {
        AppMethodBeat.i(179206);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("snsid", new StringBuilder().append(snsInfo.field_snsId).toString());
            jSONObject.put("uxinfo", Util.nullAsNil(snsInfo.getAdInfo().uxInfo));
            jSONObject.put("scene", i4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", i2);
            jSONObject2.put("pressTotalTime", i3);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            String jSONObject3 = jSONObject.toString();
            com.tencent.mm.plugin.sns.data.k.jY("timeline_fullcard_longpress_action", jSONObject3);
            Log.i("SnsAdPressGestureCtrl", "reportAction, content=" + jSONObject3 + ", channel=timeline_fullcard_longpress_action");
            AppMethodBeat.o(179206);
        } catch (Exception e2) {
            Log.i("SnsAdPressGestureCtrl", "reportAction, exp=" + e2.toString());
            AppMethodBeat.o(179206);
        }
    }
}
