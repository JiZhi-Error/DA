package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class d extends a {
    public View EVJ;
    public View EVK;
    private TextView EVL;
    private TextView EVM;
    private TextView EVN;
    private TextView EVO;
    private View EVP;
    MMPinProgressBtn EVQ;
    ADXml.i EVR;
    String EVS = null;
    protected a.d EVT = new a.d() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
        public final void onStart(String str) {
            AppMethodBeat.i(100025);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onStart");
            AppMethodBeat.o(100025);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
        public final void a(boolean z, String str, Bitmap bitmap, String str2) {
            AppMethodBeat.i(100026);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "ImageLoader onFinish, isSucc=" + z + ", errInfo=" + str);
            d.this.EgD.g(bitmap, str2);
            AppMethodBeat.o(100026);
        }
    };
    public SphereImageView EgD;
    ImageView EgF;
    private a EgG;
    int EgH = 0;
    protected SphereImageView.b Ekr = new SphereImageView.b() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdK() {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdL() {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void fdM() {
            d.this.EgH++;
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void aQa(final String str) {
            AppMethodBeat.i(100029);
            if (d.this.EgF.getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(350);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(100027);
                        d.this.EgF.setVisibility(8);
                        d.this.EgF.setImageDrawable(new ColorDrawable(d.this.EgF.getResources().getColor(R.color.f3046d)));
                        AppMethodBeat.o(100027);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
                d.this.EgF.startAnimation(alphaAnimation);
            }
            if (d.this.EVR == null || a.kx(d.this.EVR.DWL, "scene_timeline")) {
                d.this.EgD.setSensorEnabled(true);
                d.this.EgD.setTouchEnabled(true);
            } else {
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
                d.this.EgD.setTouchEnabled(false);
                d.this.EgD.feu();
                d.this.EgD.Ejd.requestRender();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(100028);
                        String str = d.this.EVR != null ? d.this.EVR.DWL : "";
                        if (str == null || !str.equals(str)) {
                            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + str + ", info.url=" + str);
                        } else {
                            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
                            a.a(d.this.EgD, str, "scene_timeline");
                        }
                        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
                        d.this.EgD.setSensorEnabled(true);
                        d.this.EgD.setTouchEnabled(true);
                        AppMethodBeat.o(100028);
                    }
                }, 800);
            }
            if (d.this.EVQ.getVisibility() == 0) {
                d.this.EVQ.setVisibility(8);
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
            }
            AppMethodBeat.o(100029);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b
        public final void onDetachedFromWindow() {
            AppMethodBeat.i(100030);
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + d.this.EgD.hashCode());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("panCount", d.this.EgH);
                jSONObject.put("type", 1);
                String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String aid = d.this.DsC.getAid();
                if (aid == null) {
                    aid = "";
                }
                h.INSTANCE.a(17539, d.this.DsC.getTimeLine().Id, aid, d.this.DsC.getAdInfo().uxInfo, 2, encode);
                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(encode)));
            } catch (Exception e2) {
                Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + e2.toString());
            }
            d.this.EgH = 0;
            d.this.EVS = null;
            AppMethodBeat.o(100030);
        }
    };
    public View ExX;
    private Context mContext;

    public d(TimeLineObject timeLineObject, SnsInfo snsInfo, c cVar) {
        AppMethodBeat.i(100031);
        this.timeLineObject = timeLineObject;
        this.DsC = snsInfo;
        this.Dyw = cVar;
        AppMethodBeat.o(100031);
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void n(View view, View view2) {
        AppMethodBeat.i(100032);
        this.contentView = view;
        this.EAV = view2;
        this.mContext = view.getContext();
        this.ExX = view.findViewById(R.id.i3j);
        this.EVJ = view.findViewById(R.id.isy);
        this.EVK = view.findViewById(R.id.aan);
        this.EVL = (TextView) view.findViewById(R.id.it0);
        this.EVM = (TextView) view.findViewById(R.id.isz);
        this.EVN = (TextView) view.findViewById(R.id.aap);
        this.EVO = (TextView) view.findViewById(R.id.aao);
        this.EVP = view.findViewById(R.id.aaw);
        this.EgF = (ImageView) view.findViewById(R.id.fa8);
        this.EgD = (SphereImageView) view.findViewById(R.id.i3k);
        this.EVQ = (MMPinProgressBtn) view.findViewById(R.id.gl7);
        this.EVQ.setMax(50);
        this.EgD.an(1.8f, -2.0f);
        this.EgD.setTouchSensitivity(0.45f);
        this.EgD.setEventListener(this.Ekr);
        this.EgD.setTouchEnabled(true);
        this.EgD.setSensorEnabled(false);
        this.EgD.feu();
        this.EgG = new a();
        this.EgG.a(this.EVT);
        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "initView, hash=" + this.EgD.hashCode());
        AppMethodBeat.o(100032);
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void refreshView() {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(100033);
        try {
            Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "refreshView, hash=" + this.EgD.hashCode());
            this.DsC = f.aQl(this.DsC.getSnsId());
            this.EVR = null;
            if (!(this.DsC == null || this.DsC.getAdXml() == null)) {
                this.EVR = this.DsC.getAdXml().adSphereCardInfo;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
            this.EVJ.setVisibility(8);
            this.EVL.setVisibility(8);
            this.EVM.setVisibility(8);
            this.EVK.setVisibility(8);
            this.EVN.setVisibility(8);
            this.EVO.setVisibility(8);
            this.EVP.setVisibility(8);
            if (this.EVR != null) {
                int aG = (((min - com.tencent.mm.cb.a.aG(this.mContext, R.dimen.ajw)) - com.tencent.mm.cb.a.aG(this.mContext, R.dimen.bt)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.ir);
                if (this.EVR.DWw == 0) {
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    layoutParams2.width = aG;
                    layoutParams2.height = (int) (((float) layoutParams2.width) * 0.75f);
                    layoutParams = layoutParams2;
                } else if (this.EVR.DWw == 1) {
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    layoutParams3.width = aG;
                    layoutParams3.height = layoutParams3.width;
                    layoutParams = layoutParams3;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    ViewGroup.LayoutParams layoutParams4 = this.contentView.getLayoutParams();
                    layoutParams4.width = layoutParams.width;
                    layoutParams4.height = layoutParams.height;
                    this.contentView.setLayoutParams(layoutParams4);
                    ((RoundedCornerFrameLayout) this.contentView).setRadius((float) com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8));
                    ViewGroup.LayoutParams layoutParams5 = this.EgD.getLayoutParams();
                    layoutParams5.width = layoutParams.width;
                    layoutParams5.height = layoutParams.height;
                    this.EgD.setLayoutParams(layoutParams5);
                    ViewGroup.LayoutParams layoutParams6 = this.EgF.getLayoutParams();
                    layoutParams6.width = layoutParams5.width;
                    layoutParams6.height = layoutParams5.height;
                    this.EgF.setLayoutParams(layoutParams6);
                }
                if (this.EVR.DWy == 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) this.EVR.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable.setGradientType(0);
                    this.EVJ.setBackground(gradientDrawable);
                    if (!Util.isNullOrNil(this.EVR.title) || !Util.isNullOrNil(this.EVR.description)) {
                        this.EVJ.setVisibility(0);
                    }
                    this.EVK.setVisibility(8);
                    if (!Util.isNullOrNil(this.EVR.title)) {
                        this.EVL.setVisibility(0);
                        this.EVL.setText(g.gxZ().a(this.EVL.getContext(), this.EVR.title, this.EVL.getTextSize()));
                    }
                    if (!Util.isNullOrNil(this.EVR.description)) {
                        this.EVM.setVisibility(0);
                        this.EVM.setText(g.gxZ().a(this.EVM.getContext(), this.EVR.description, this.EVM.getTextSize()));
                    }
                } else if (this.EVR.DWy == 1) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.EVR.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable2.setGradientType(0);
                    this.EVJ.setVisibility(8);
                    this.EVK.setBackground(gradientDrawable2);
                    if (!Util.isNullOrNil(this.EVR.title) || !Util.isNullOrNil(this.EVR.description)) {
                        this.EVK.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.EVP.getLayoutParams();
                        layoutParams7.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
                        this.EVP.setLayoutParams(layoutParams7);
                    }
                    if (!Util.isNullOrNil(this.EVR.title)) {
                        this.EVN.setVisibility(0);
                        this.EVN.setText(g.gxZ().a(this.EVN.getContext(), this.EVR.title, this.EVN.getTextSize()));
                    }
                    if (!Util.isNullOrNil(this.EVR.description)) {
                        this.EVO.setVisibility(0);
                        this.EVO.setText(g.gxZ().a(this.EVO.getContext(), this.EVR.description, this.EVO.getTextSize()));
                    }
                }
                if (this.DsC != null && this.DsC.getAdInfo().isWeapp()) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.EVR.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                    gradientDrawable3.setGradientType(0);
                    this.EVK.setVisibility(0);
                    this.EVK.setBackground(gradientDrawable3);
                    this.EVP.setVisibility(0);
                }
                this.EgD.setVisibility(0);
                this.EgD.setTag(this);
                this.EgD.setOnClickListener(this.Dyw.Fbd);
                if (this.EVS == null || !this.EVS.equals(this.EVR.DWL)) {
                    Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "loadImage");
                    try {
                        this.EgF.setVisibility(0);
                        final String str = this.EVR.DWL;
                        final String str2 = this.EVR.DWM;
                        new a.c(str, str2, "scene_timeline", new a.d() {
                            /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
                            public final void onStart(String str) {
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.d
                            public final void a(boolean z, String str, Bitmap bitmap, String str2) {
                                AppMethodBeat.i(100024);
                                if (str2 == null || !str2.equals(str)) {
                                    AppMethodBeat.o(100024);
                                } else if (bitmap != null) {
                                    d.this.EgF.setImageBitmap(bitmap);
                                    AppMethodBeat.o(100024);
                                } else {
                                    Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "show progressView");
                                    d.this.EVQ.setVisibility(0);
                                    d.this.EVQ.gYN();
                                    if (!TextUtils.isEmpty(str2)) {
                                        Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "have no shot and thumb cache, start download thumb image");
                                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str2, 133, new f.a() {
                                            /* class com.tencent.mm.plugin.sns.ui.c.a.d.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                            public final void eWN() {
                                            }

                                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                            public final void eWO() {
                                                AppMethodBeat.i(100022);
                                                Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloadError thumb");
                                                AppMethodBeat.o(100022);
                                            }

                                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                            public final void aNH(String str) {
                                                AppMethodBeat.i(100023);
                                                Log.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloaded thumb, path=".concat(String.valueOf(str)));
                                                if (d.this.EgF.getVisibility() == 0) {
                                                    try {
                                                        d.this.EgF.setImageBitmap(MMBitmapFactory.decodeFile(str));
                                                        AppMethodBeat.o(100023);
                                                        return;
                                                    } catch (Throwable th) {
                                                        Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDownloaded thumb exp:" + th.toString());
                                                    }
                                                }
                                                AppMethodBeat.o(100023);
                                            }
                                        });
                                        AppMethodBeat.o(100024);
                                        return;
                                    }
                                    Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "thumbUrl is empty");
                                    AppMethodBeat.o(100024);
                                }
                            }
                        }).execute(new Void[0]);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "showMaskView exp=" + th.toString());
                    }
                    this.EgG.l(this.EVR.DWL, this.EgD.getLayoutParams().width, this.EgD.getLayoutParams().height, "scene_timeline");
                    this.EVS = this.EVR.DWL;
                    AppMethodBeat.o(100033);
                    return;
                }
                Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "invalid refreshView");
                AppMethodBeat.o(100033);
                return;
            }
            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "invalid spherecardinfo");
            AppMethodBeat.o(100033);
        } catch (Throwable th2) {
            Log.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "refreshView, exp=" + th2.toString());
            AppMethodBeat.o(100033);
        }
    }
}
