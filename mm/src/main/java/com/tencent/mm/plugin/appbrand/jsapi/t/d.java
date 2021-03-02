package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.view.u;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    MTimerHandler klF;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        final boolean z = true;
        AppMethodBeat.i(138273);
        final s sVar2 = sVar;
        final ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView == null) {
            Log.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(138273);
            return;
        }
        Log.i("MicroMsg.JsApiShowToast", "showToast:%s, callbackId:%d", jSONObject, Integer.valueOf(i2));
        final int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1500);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("icon", "success");
        final String optString3 = jSONObject.optString("image");
        final boolean optBoolean = jSONObject.optBoolean("mask");
        if (!Util.isNullOrNil(optString2) || !Util.isNullOrNil(optString3)) {
            z = false;
        }
        h.a(sVar2.getAppId(), new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.t.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(138264);
                if (d.this.klF != null) {
                    d.this.klF.stopTimer();
                    d.this.klF = null;
                }
                AppMethodBeat.o(138264);
            }
        });
        currentPageView.P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.t.d.AnonymousClass2 */

            public final void run() {
                final View inflate;
                Drawable drawable;
                AppMethodBeat.i(138272);
                if (d.this.klF != null) {
                    d.this.klF.stopTimer();
                }
                if (!sVar2.isRunning()) {
                    Log.w("MicroMsg.JsApiShowToast", "service is not running");
                    AppMethodBeat.o(138272);
                    return;
                }
                if (z) {
                    inflate = LayoutInflater.from(currentPageView.getContext()).inflate(R.layout.fn, (ViewGroup) currentPageView.getContentView(), false);
                } else {
                    inflate = LayoutInflater.from(currentPageView.getContext()).inflate(R.layout.fo, (ViewGroup) currentPageView.getContentView(), false);
                }
                if (optBoolean) {
                    new a(inflate);
                }
                TextView textView = (TextView) inflate.findViewById(R.id.ipm);
                final int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 18);
                if (!Util.isNullOrNil(optString)) {
                    textView.setLineSpacing(0.0f, 1.0f);
                    textView.setSpannableFactory(new Spannable.Factory() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.d.AnonymousClass2.AnonymousClass2 */

                        public final Spannable newSpannable(CharSequence charSequence) {
                            AppMethodBeat.i(138271);
                            Spannable newSpannable = super.newSpannable(charSequence);
                            if (!TextUtils.isEmpty(newSpannable)) {
                                newSpannable.setSpan(new com.tencent.mm.plugin.appbrand.widget.h.a((float) fromDPToPix, 17), 0, newSpannable.length(), 18);
                            }
                            AppMethodBeat.o(138271);
                            return newSpannable;
                        }
                    });
                    textView.setText(optString, TextView.BufferType.SPANNABLE);
                    textView.setVisibility(0);
                    if (!z) {
                        inflate.findViewById(R.id.hr_).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 27), 0, 0);
                    }
                } else {
                    textView.setVisibility(4);
                }
                if (!z) {
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.e4p);
                    ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.gl7);
                    if (optString2.equals("loading")) {
                        imageView.setVisibility(8);
                        progressBar.setVisibility(0);
                    } else {
                        imageView.setVisibility(0);
                        progressBar.setVisibility(8);
                        if (!Util.isNullOrNil(optString3)) {
                            Bitmap k = z.k(sVar2.getRuntime(), optString3);
                            drawable = (k == null || k.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), k);
                        } else if (optString2.equals("error")) {
                            drawable = sVar2.getContext().getResources().getDrawable(R.raw.app_brand_show_toast_error);
                            drawable.mutate().setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
                        } else {
                            drawable = sVar2.getContext().getResources().getDrawable(R.drawable.by4);
                        }
                        if (drawable != null) {
                            imageView.setImageDrawable(drawable);
                            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        }
                    }
                }
                currentPageView.nqT.ccK();
                currentPageView.nqT.dk(inflate);
                d.this.klF = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.t.d.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(138265);
                        View view = inflate;
                        if (view != null) {
                            view.setVisibility(8);
                            if (ViewGroup.class.isInstance(view.getParent())) {
                                ((ViewGroup) view.getParent()).removeView(view);
                            }
                        }
                        Log.i("MicroMsg.JsApiShowToast", "on timer expired!");
                        AppMethodBeat.o(138265);
                        return true;
                    }
                }, false);
                d.this.klF.startTimer((long) optInt);
                sVar2.i(i2, d.this.h("ok", null));
                AppMethodBeat.o(138272);
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.d$2$a */
            class a implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener {
                View bJW;
                TouchDelegate moo;
                View mop;

                a(View view) {
                    AppMethodBeat.i(138266);
                    view.addOnAttachStateChangeListener(this);
                    view.setOnTouchListener(new View.OnTouchListener(AnonymousClass2.this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.d.AnonymousClass2.a.AnonymousClass1 */

                        @SuppressLint({"ClickableViewAccessibility"})
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    this.mop = view;
                    AppMethodBeat.o(138266);
                }

                public final void onViewAttachedToWindow(View view) {
                    AppMethodBeat.i(138267);
                    this.bJW = (View) view.getParent();
                    bIv();
                    this.bJW.addOnLayoutChangeListener(this);
                    AppMethodBeat.o(138267);
                }

                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AppMethodBeat.i(138269);
                    bIv();
                    AppMethodBeat.o(138269);
                }

                private void bIv() {
                    AppMethodBeat.i(138270);
                    if (this.bJW != null && u.aD(this.mop)) {
                        Rect rect = new Rect(0, 0, this.bJW.getWidth(), this.bJW.getHeight());
                        View view = this.bJW;
                        TouchDelegate touchDelegate = new TouchDelegate(rect, this.mop);
                        this.moo = touchDelegate;
                        view.setTouchDelegate(touchDelegate);
                    }
                    AppMethodBeat.o(138270);
                }

                public final void onViewDetachedFromWindow(View view) {
                    AppMethodBeat.i(138268);
                    if (this.bJW != null && this.bJW.getTouchDelegate() == this.moo) {
                        this.bJW.setTouchDelegate(null);
                    }
                    if (this.bJW != null) {
                        this.bJW.removeOnLayoutChangeListener(this);
                    }
                    AppMethodBeat.o(138268);
                }
            }
        });
        AppMethodBeat.o(138273);
    }
}
