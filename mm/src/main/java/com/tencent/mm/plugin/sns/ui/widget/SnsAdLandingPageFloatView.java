package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView extends FrameLayout {
    boolean ESr;
    private Map<String, String> Eaa = new HashMap();
    private List<m> ExZ;
    public x Fel;
    public g Fem;
    private m Fen;
    private View Feo;
    private AnimatorSet Fep = new AnimatorSet();
    public boolean Feq = true;
    public String adCanvasExtXml;
    public String dVe;
    private boolean isResume;
    ValueAnimator tMD = ValueAnimator.ofFloat(1.0f, 0.4f).setDuration(100L);

    public SnsAdLandingPageFloatView(Context context) {
        super(context, null);
        AppMethodBeat.i(100462);
        AppMethodBeat.o(100462);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        AppMethodBeat.i(100463);
        AppMethodBeat.o(100463);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, -1);
        AppMethodBeat.i(100464);
        AppMethodBeat.o(100464);
    }

    public final void initView() {
        AppMethodBeat.i(203985);
        if (this.Fem != null) {
            initPage();
            flc();
            ValueAnimator duration = ValueAnimator.ofFloat(0.4f, 0.96f).setDuration(200 * getAnimationTimeFactor());
            duration.setInterpolator(new OvershootInterpolator());
            ValueAnimator duration2 = ValueAnimator.ofFloat(0.96f, 1.0f).setDuration(100 * getAnimationTimeFactor());
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(100453);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SnsAdLandingPageFloatView.this.Feo.setScaleX(floatValue);
                    SnsAdLandingPageFloatView.this.Feo.setScaleY(floatValue);
                    AppMethodBeat.o(100453);
                }
            });
            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(100454);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SnsAdLandingPageFloatView.this.Feo.setScaleX(floatValue);
                    SnsAdLandingPageFloatView.this.Feo.setScaleY(floatValue);
                    AppMethodBeat.o(100454);
                }
            });
            this.Fep.playSequentially(duration, duration2);
            this.Fep.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass3 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(100455);
                    SnsAdLandingPageFloatView.this.ESr = true;
                    uz uzVar = new uz();
                    uzVar.ebq.ebr = SnsAdLandingPageFloatView.this.dVe;
                    uzVar.ebq.state = 120;
                    EventCenter.instance.publish(uzVar);
                    AppMethodBeat.o(100455);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(100456);
                    SnsAdLandingPageFloatView.this.ESr = false;
                    SnsAdLandingPageFloatView.this.onResume();
                    uz uzVar = new uz();
                    uzVar.ebq.ebr = SnsAdLandingPageFloatView.this.dVe;
                    uzVar.ebq.state = 121;
                    EventCenter.instance.publish(uzVar);
                    AppMethodBeat.o(100456);
                }
            });
            this.tMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass4 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(100457);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SnsAdLandingPageFloatView.this.Feo.setScaleX(floatValue);
                    SnsAdLandingPageFloatView.this.Feo.setScaleY(floatValue);
                    AppMethodBeat.o(100457);
                }
            });
            this.tMD.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass5 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(100458);
                    SnsAdLandingPageFloatView.this.ESr = true;
                    SnsAdLandingPageFloatView.this.isResume = false;
                    SnsAdLandingPageFloatView.this.onPause();
                    uz uzVar = new uz();
                    uzVar.ebq.ebr = SnsAdLandingPageFloatView.this.dVe;
                    uzVar.ebq.state = 122;
                    EventCenter.instance.publish(uzVar);
                    AppMethodBeat.o(100458);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(100459);
                    SnsAdLandingPageFloatView.this.Feo.setVisibility(8);
                    SnsAdLandingPageFloatView.this.ESr = false;
                    uz uzVar = new uz();
                    uzVar.ebq.ebr = SnsAdLandingPageFloatView.this.dVe;
                    uzVar.ebq.state = 123;
                    EventCenter.instance.publish(uzVar);
                    AppMethodBeat.o(100459);
                }
            });
        }
        AppMethodBeat.o(203985);
    }

    private void initPage() {
        AppMethodBeat.i(203986);
        if (this.Fel != null) {
            if (this.Fel.DZg > 0) {
                setBackground(null);
            }
            int i2 = 0;
            try {
                i2 = Color.parseColor(this.Fem.lco);
            } catch (Exception e2) {
                Log.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + e2.toString() + ", colorStr=" + this.Fem.lco);
            }
            this.Fen = ay.a(getContext(), this.Fel, this, i2);
            this.Fen.setBackgroundColor(i2);
            this.Feo = this.Fen.getView();
            addView(this.Feo);
            this.Fen.fdp();
            if (this.Fel.DZf <= 0) {
                setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass6 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(100460);
                        Rect rect = new Rect(SnsAdLandingPageFloatView.this.Fen.getView().getLeft(), SnsAdLandingPageFloatView.this.Fen.getView().getTop(), SnsAdLandingPageFloatView.this.Fen.getView().getRight(), SnsAdLandingPageFloatView.this.Fen.getView().getBottom());
                        Log.i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", rect, Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            if (motionEvent.getActionMasked() == 1) {
                                SnsAdLandingPageFloatView snsAdLandingPageFloatView = SnsAdLandingPageFloatView.this;
                                if (!snsAdLandingPageFloatView.ESr) {
                                    snsAdLandingPageFloatView.tMD.start();
                                    snsAdLandingPageFloatView.ESr = true;
                                }
                            }
                            AppMethodBeat.o(100460);
                            return true;
                        }
                        AppMethodBeat.o(100460);
                        return false;
                    }
                });
            }
        }
        AppMethodBeat.o(203986);
    }

    public final void onResume() {
        AppMethodBeat.i(100465);
        this.isResume = true;
        if (this.Fem != null) {
            this.Fen.eWZ();
            post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(100461);
                    SnsAdLandingPageFloatView.this.Fen.eXb();
                    AppMethodBeat.o(100461);
                }
            });
        }
        AppMethodBeat.o(100465);
    }

    public final void onPause() {
        AppMethodBeat.i(100466);
        this.isResume = false;
        if (this.Fem != null) {
            this.Fen.eXa();
        }
        AppMethodBeat.o(100466);
    }

    public final void flb() {
        AppMethodBeat.i(203987);
        if (!this.ESr) {
            this.Fep.start();
            this.ESr = true;
        }
        AppMethodBeat.o(203987);
    }

    private void flc() {
        String str;
        AppMethodBeat.i(100467);
        if (this.Fem != null && !Util.isNullOrNil(this.adCanvasExtXml)) {
            Map<String, String> parseXml = XmlParser.parseXml(this.adCanvasExtXml, "adCardItemList", null);
            int i2 = 0;
            while (true) {
                if (i2 > 0) {
                    str = ".adCardItemList.cardItem" + i2;
                } else {
                    str = ".adCardItemList.cardItem";
                }
                if (!parseXml.containsKey(str + ".cardTpId")) {
                    break;
                }
                String nullAs = Util.nullAs(parseXml.get(str + ".cardTpId"), "");
                String nullAs2 = Util.nullAs(parseXml.get(str + ".cardExt"), "");
                if (!Util.isNullOrNil(nullAs) && !Util.isNullOrNil(nullAs2)) {
                    this.Eaa.put(nullAs, nullAs2);
                }
                i2++;
            }
        }
        AppMethodBeat.o(100467);
    }

    public List<m> getAllComp() {
        AppMethodBeat.i(100468);
        if (this.ExZ != null) {
            List<m> list = this.ExZ;
            AppMethodBeat.o(100468);
            return list;
        }
        this.ExZ = new ArrayList();
        this.ExZ.add(this.Fen);
        i.gU(this.ExZ);
        List<m> list2 = this.ExZ;
        AppMethodBeat.o(100468);
        return list2;
    }

    /* access modifiers changed from: package-private */
    public long getAnimationTimeFactor() {
        return this.Feq ? 1 : 0;
    }
}
