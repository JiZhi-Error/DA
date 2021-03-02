package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class n extends BaseTimeLineItem {
    protected ADXml.i EVR;
    protected a EZd;
    protected boolean EZe = true;
    protected boolean EZf = true;
    protected String EZg = null;
    protected a.d EZh = new a.d() {
        /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
        public final void onStart(String str) {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
        public final void a(boolean z, String str, Bitmap bitmap, String str2) {
            AppMethodBeat.i(100095);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ImageLoader onFinish, isSucc=" + z + ", errInfo=" + str);
            if (n.this.EZd == null) {
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, mViewHolder==null");
                AppMethodBeat.o(100095);
                return;
            }
            String str3 = n.this.EVR != null ? n.this.EVR.DWL : "";
            if (str2 == null || !str2.equals(str3)) {
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onFinish, url != nowUrl");
                AppMethodBeat.o(100095);
                return;
            }
            n.this.EZd.EZp.g(bitmap, str2);
            AppMethodBeat.o(100095);
        }
    };
    boolean EZi = false;
    protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a EgG;
    private int EgH = 0;
    protected SphereImageView.b Ekr = new SphereImageView.b() {
        /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdK() {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdL() {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdM() {
            AppMethodBeat.i(100098);
            n.a(n.this);
            AppMethodBeat.o(100098);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void aQa(final String str) {
            AppMethodBeat.i(100099);
            String str2 = n.this.EVR != null ? n.this.EVR.DWL : "";
            if (str == null || str.equals(str2)) {
                final a aVar = n.this.EZd;
                if (aVar == null) {
                    Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
                    AppMethodBeat.o(100099);
                    return;
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + n.this.EZe + ", visiable=" + aVar.EZq.getVisibility());
                if (n.this.EZe) {
                    if (aVar.EZq.getVisibility() == 0) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(350);
                        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass3.AnonymousClass1 */

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(100096);
                                aVar.EZq.setVisibility(8);
                                aVar.EZq.setImageDrawable(new ColorDrawable(aVar.EZq.getContext().getResources().getColor(R.color.f3046d)));
                                AppMethodBeat.o(100096);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
                        aVar.EZq.startAnimation(alphaAnimation);
                    }
                    if (n.this.EVR == null || com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kx(n.this.EVR.DWL, "scene_timeline")) {
                        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + n.this.EZi);
                        if (!n.this.EZi) {
                            aVar.EZp.setSensorEnabled(true);
                        }
                        n.this.EZe = false;
                    } else {
                        Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
                        aVar.EZp.setTouchEnabled(false);
                        aVar.EZp.feu();
                        aVar.EZp.Ejd.requestRender();
                        n.this.czp.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass3.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(100097);
                                String str = n.this.EVR != null ? n.this.EVR.DWL : "";
                                if (str == null || !str.equals(str)) {
                                    Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + str + ", info.url=" + str);
                                } else {
                                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
                                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(aVar.EZp, str, "scene_timeline");
                                    n.this.EZe = false;
                                }
                                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + n.this.EZi);
                                if (!n.this.EZi) {
                                    aVar.EZp.setSensorEnabled(true);
                                }
                                aVar.EZp.setTouchEnabled(true);
                                AppMethodBeat.o(100097);
                            }
                        }, 800);
                    }
                }
                if (aVar.EZr.getVisibility() == 0) {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
                    aVar.EZr.setVisibility(8);
                }
                AppMethodBeat.o(100099);
                return;
            }
            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + str + ", info.url=" + str2);
            AppMethodBeat.o(100099);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void onDetachedFromWindow() {
            int i2 = 0;
            AppMethodBeat.i(100100);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
            n.this.EZe = true;
            n.this.EZf = true;
            n.this.EZg = null;
            n.this.czp.removeCallbacksAndMessages(null);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("panCount", n.this.EgH);
                jSONObject.put("type", 1);
                String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                SnsInfo Zv = n.this.DQX.Zv(n.this.EZd.position);
                String aid = Zv.getAid();
                if (aid == null) {
                    aid = "";
                }
                h.INSTANCE.a(17539, Zv.getTimeLine().Id, aid, Zv.getAdInfo().uxInfo, 1, encode);
                StringBuilder append = new StringBuilder("KVReport, id=17539, touchCount=").append(encode).append(", snsInfo.hash=");
                if (Zv != null) {
                    i2 = Zv.hashCode();
                }
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", append.append(i2).toString());
            } catch (Exception e2) {
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + e2.toString());
            }
            n.this.EgH = 0;
            AppMethodBeat.o(100100);
        }
    };
    protected MMHandler czp = new MMHandler(Looper.getMainLooper());

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        public View EVh;
        public TextView EVi;
        public TextView EVj;
        public TextView EVk;
        public View EVl;
        public SphereImageView EZp;
        public ImageView EZq;
        public MMPinProgressBtn EZr;
        public View ExX;
        public TextView uXS;
        public View wnX;
    }

    public n() {
        AppMethodBeat.i(100105);
        AppMethodBeat.o(100105);
    }

    static /* synthetic */ int a(n nVar) {
        int i2 = nVar.EgH;
        nVar.EgH = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100106);
        try {
            final a aVar = (a) baseViewHolder;
            this.EZd = aVar;
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, holder=" + baseViewHolder.hashCode());
            if (baseViewHolder.EWD != null) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bxm);
                if (!baseViewHolder.EWE) {
                    aVar.ExX = baseViewHolder.EWD.inflate();
                    baseViewHolder.EWE = true;
                }
            } else if (!baseViewHolder.EWE) {
                aVar.ExX = baseViewHolder.convertView.findViewById(R.id.i3j);
                baseViewHolder.EWE = true;
            }
            aVar.wnX = aVar.convertView.findViewById(R.id.isy);
            aVar.EVh = aVar.convertView.findViewById(R.id.aan);
            aVar.uXS = (TextView) aVar.convertView.findViewById(R.id.it0);
            aVar.EVi = (TextView) aVar.convertView.findViewById(R.id.isz);
            aVar.EVj = (TextView) aVar.convertView.findViewById(R.id.aap);
            aVar.EVk = (TextView) aVar.convertView.findViewById(R.id.aao);
            aVar.EZp = (SphereImageView) aVar.convertView.findViewById(R.id.i3k);
            aVar.EVl = aVar.convertView.findViewById(R.id.aaw);
            aVar.EZq = (ImageView) aVar.convertView.findViewById(R.id.fa8);
            aVar.EZr = (MMPinProgressBtn) aVar.convertView.findViewById(R.id.gl7);
            aVar.EZr.setMax(50);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent, disable touch and sensor");
            aVar.EZp.setTouchEnabled(false);
            aVar.EZp.setSensorEnabled(false);
            aVar.EZp.an(1.8f, -2.0f);
            aVar.EZp.setTouchSensitivity(0.45f);
            aVar.EZp.setEventListener(this.Ekr);
            aVar.EZp.setOnlyHorizontalScroll(true);
            this.EgG = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a();
            this.EgG.a(this.EZh);
            final int i2 = this.EVR == null ? 0 : this.EVR.DWK;
            this.czp.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(100094);
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + i2);
                    aVar.EZp.setTouchEnabled(true);
                    AppMethodBeat.o(100094);
                }
            }, (long) i2);
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "viewHash=" + aVar.EZp.hashCode() + ", touchDelay=" + i2);
            AppMethodBeat.o(100106);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "buildContent exp=" + th.toString());
            AppMethodBeat.o(100106);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        ADXml.i iVar;
        AppMethodBeat.i(100107);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (baseViewHolder.hho) {
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, holder is busy");
                AppMethodBeat.o(100107);
                return;
            }
            final a aVar = (a) baseViewHolder;
            SnsInfo snsInfo = blVar.DqO;
            if (snsInfo == null || snsInfo.getAdXml() == null) {
                iVar = null;
            } else {
                iVar = snsInfo.getAdXml().adSphereCardInfo;
            }
            this.EVR = iVar;
            if (Build.VERSION.SDK_INT < 24 && iVar != null && (this.EZg == null || !this.EZg.equals(iVar.DWL))) {
                this.EZe = true;
                this.EZf = true;
                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, reset, sdk_int=" + Build.VERSION.SDK_INT);
            }
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "ad fillItem, sphereCard, pos=" + i2 + ", snsId=" + (timeLineObject == null ? "" : timeLineObject.Id) + ", hash=" + aVar.EZp.hashCode() + ", isFirst=" + this.EZf + ", snsInfo.hash=" + (snsInfo != null ? snsInfo.hashCode() : 0));
            ViewGroup.LayoutParams layoutParams = null;
            aVar.wnX.setVisibility(8);
            aVar.uXS.setVisibility(8);
            aVar.EVi.setVisibility(8);
            aVar.EVh.setVisibility(8);
            aVar.EVj.setVisibility(8);
            aVar.EVk.setVisibility(8);
            aVar.EVl.setVisibility(8);
            if (iVar != null) {
                WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
                int min = ((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 56)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.i2)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir);
                if (iVar.DWw == 0) {
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    layoutParams2.width = min;
                    layoutParams2.height = (int) (((float) layoutParams2.width) * 0.75f);
                    layoutParams = layoutParams2;
                } else if (iVar.DWw == 1) {
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    layoutParams3.width = min;
                    layoutParams3.height = layoutParams3.width;
                    layoutParams = layoutParams3;
                }
                if (layoutParams != null) {
                    ViewGroup.LayoutParams layoutParams4 = aVar.ExX.getLayoutParams();
                    layoutParams4.width = layoutParams.width;
                    layoutParams4.height = layoutParams.height;
                    aVar.ExX.setLayoutParams(layoutParams4);
                    ((RoundedCornerFrameLayout) aVar.ExX).setRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 8));
                    ViewGroup.LayoutParams layoutParams5 = aVar.EZp.getLayoutParams();
                    layoutParams5.width = layoutParams.width;
                    layoutParams5.height = layoutParams.height;
                    aVar.EZp.setLayoutParams(layoutParams5);
                    ViewGroup.LayoutParams layoutParams6 = aVar.EZq.getLayoutParams();
                    layoutParams6.width = layoutParams5.width;
                    layoutParams6.height = layoutParams5.height;
                    aVar.EZq.setLayoutParams(layoutParams6);
                }
                if (iVar.DWy == 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) iVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable.setGradientType(0);
                    aVar.wnX.setBackground(gradientDrawable);
                    if (!Util.isNullOrNil(iVar.title) || !Util.isNullOrNil(iVar.description)) {
                        aVar.wnX.setVisibility(0);
                    }
                    if (!Util.isNullOrNil(iVar.title)) {
                        aVar.uXS.setVisibility(0);
                        aVar.uXS.setText(g.gxZ().a(aVar.uXS.getContext(), iVar.title, aVar.uXS.getTextSize()));
                    }
                    if (!Util.isNullOrNil(iVar.description)) {
                        aVar.EVi.setVisibility(0);
                        aVar.EVi.setText(g.gxZ().a(aVar.EVi.getContext(), iVar.description, aVar.EVi.getTextSize()));
                    }
                } else if (iVar.DWy == 1) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) iVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable2.setGradientType(0);
                    aVar.EVh.setBackground(gradientDrawable2);
                    if (!Util.isNullOrNil(iVar.title) || !Util.isNullOrNil(iVar.description)) {
                        aVar.EVh.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) aVar.EVl.getLayoutParams();
                        layoutParams7.topMargin = com.tencent.mm.cb.a.fromDPToPix(aVar.ExX.getContext(), 4);
                        aVar.EVl.setLayoutParams(layoutParams7);
                    }
                    if (!Util.isNullOrNil(iVar.title)) {
                        aVar.EVj.setVisibility(0);
                        aVar.EVj.setText(g.gxZ().a(aVar.EVj.getContext(), iVar.title, aVar.EVj.getTextSize()));
                    }
                    if (!Util.isNullOrNil(iVar.description)) {
                        aVar.EVk.setVisibility(0);
                        aVar.EVk.setText(g.gxZ().a(aVar.EVk.getContext(), iVar.description, aVar.EVk.getTextSize()));
                    }
                }
                if (snsInfo != null && snsInfo.getAdInfo().isWeapp()) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) iVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable3.setGradientType(0);
                    aVar.EVh.setVisibility(0);
                    aVar.EVh.setBackground(gradientDrawable3);
                    aVar.EVl.setVisibility(0);
                }
                if (this.EZf) {
                    aVar.EZq.setVisibility(0);
                    final String str = iVar.DWL;
                    final String str2 = iVar.DWM;
                    new a.c(str, str2, "scene_timeline", new a.d() {
                        /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
                        public final void onStart(String str) {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
                        public final void a(boolean z, String str, Bitmap bitmap, String str2) {
                            AppMethodBeat.i(100104);
                            if (str2 == null || !str2.equals(str)) {
                                AppMethodBeat.o(100104);
                            } else if (bitmap != null) {
                                aVar.EZq.setImageBitmap(bitmap);
                                AppMethodBeat.o(100104);
                            } else {
                                Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "show progressView");
                                aVar.EZr.setVisibility(0);
                                aVar.EZr.gYN();
                                if (!TextUtils.isEmpty(str2)) {
                                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "no shot and thumb cache, start download thumb image");
                                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str2, 133, new f.a() {
                                        /* class com.tencent.mm.plugin.sns.ui.item.n.AnonymousClass4.AnonymousClass1 */
                                        String EZn = str2;

                                        {
                                            AppMethodBeat.i(100101);
                                            AppMethodBeat.o(100101);
                                        }

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void eWN() {
                                        }

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void eWO() {
                                            AppMethodBeat.i(100102);
                                            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloadError thumb");
                                            AppMethodBeat.o(100102);
                                        }

                                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                        public final void aNH(String str) {
                                            AppMethodBeat.i(100103);
                                            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb, path=".concat(String.valueOf(str)));
                                            String str2 = n.this.EVR != null ? n.this.EVR.DWM : "";
                                            if (this.EZn == null || !this.EZn.equals(str2)) {
                                                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded, url != nowUrl");
                                            } else if (aVar.EZq.getVisibility() == 0) {
                                                try {
                                                    aVar.EZq.setImageBitmap(MMBitmapFactory.decodeFile(str));
                                                    AppMethodBeat.o(100103);
                                                    return;
                                                } catch (Throwable th) {
                                                    Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDownloaded thumb exp:" + th.toString());
                                                    AppMethodBeat.o(100103);
                                                    return;
                                                }
                                            }
                                            AppMethodBeat.o(100103);
                                        }
                                    });
                                    AppMethodBeat.o(100104);
                                    return;
                                }
                                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "thumbUrl is empty");
                                AppMethodBeat.o(100104);
                            }
                        }
                    }).execute(new Void[0]);
                }
                aVar.EZp.setVisibility(0);
                aVar.EZp.setOnClickListener(bkVar.DQs.Fbd);
                aVar.EZp.setTag(baseViewHolder);
                if (!this.EZe && !this.EZi) {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem !first, enable sensor");
                    aVar.EZp.setSensorEnabled(true);
                }
                if (this.EZg == null || !this.EZg.equals(iVar.DWL)) {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem, loadImage, hash=" + aVar.EZp.hashCode());
                    ViewGroup.LayoutParams layoutParams8 = aVar.EZp.getLayoutParams();
                    this.EgG.l(iVar.DWL, layoutParams8.width, layoutParams8.height, "scene_timeline");
                    this.EZg = iVar.DWL;
                }
                this.EZf = false;
            } else {
                Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "sphereCardInfo==null, invalid sphereCard");
            }
            Log.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem total timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(100107);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "fillItem exp=" + th.toString());
            AppMethodBeat.o(100107);
        }
    }

    public final void a(SphereImageView sphereImageView, boolean z) {
        AppMethodBeat.i(100108);
        Log.d("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "setIsInLowPriority, isInLowPriority=" + z + ", hash=" + sphereImageView.hashCode());
        this.EZi = z;
        if (z) {
            sphereImageView.setSensorEnabled(false);
            AppMethodBeat.o(100108);
            return;
        }
        if (!this.EZe) {
            sphereImageView.setSensorEnabled(true);
        }
        AppMethodBeat.o(100108);
    }
}
