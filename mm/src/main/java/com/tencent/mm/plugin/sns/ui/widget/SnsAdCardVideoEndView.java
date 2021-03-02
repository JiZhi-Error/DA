package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public class SnsAdCardVideoEndView extends FrameLayout {
    private String Dsr = "";
    private aw FdW;
    private ImageView FdX;
    private View FdY;
    private TextView FdZ;
    private TextView Fea;
    private TextView Feb;
    private View Fec;
    private ImageView Fed;
    private TextView Fee;
    private TextView Fef;
    private ImageView Feg;
    private SnsInfo Feh = null;
    private boolean Fei = false;
    private long Fej = 0;
    private int mScene;

    public SnsAdCardVideoEndView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(176439);
        LayoutInflater.from(context).inflate(R.layout.bxk, this);
        this.FdX = (ImageView) findViewById(R.id.fa8);
        this.FdY = findViewById(R.id.ize);
        this.FdZ = (TextView) findViewById(R.id.izg);
        this.Fea = (TextView) findViewById(R.id.izd);
        this.Feb = (TextView) findViewById(R.id.izf);
        this.Fec = findViewById(R.id.dxk);
        this.Fed = (ImageView) findViewById(R.id.dxj);
        this.Fee = (TextView) findViewById(R.id.dxi);
        this.Fef = (TextView) findViewById(R.id.dxl);
        this.Feg = (ImageView) findViewById(R.id.bh6);
        this.FdX.setBackgroundColor(Color.parseColor("#7f000000"));
        AppMethodBeat.o(176439);
    }

    public final void a(aw awVar, int i2) {
        AppMethodBeat.i(176440);
        if (awVar == null) {
            eQ(false);
        }
        this.FdW = awVar;
        this.mScene = i2;
        AppMethodBeat.o(176440);
    }

    public final void bpn() {
        AppMethodBeat.i(176441);
        if (this.FdW == null) {
            AppMethodBeat.o(176441);
            return;
        }
        if (!TextUtils.isEmpty(this.FdW.title)) {
            this.FdZ.setText(this.FdW.title);
            this.Fea.setText(this.FdW.desc);
            this.Feb.setText(this.FdW.EwS);
            this.FdY.setVisibility(0);
            this.Fec.setVisibility(8);
        } else {
            this.Fee.setText(this.FdW.desc);
            this.Fef.setText(this.FdW.EwS);
            if (!TextUtils.isEmpty(this.FdW.EwR)) {
                x(this.Fed, this.FdW.EwR);
            }
            this.FdY.setVisibility(8);
            this.Fec.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.FdW.coverImgUrl)) {
            this.Feg.setVisibility(0);
            x(this.Feg, this.FdW.coverImgUrl);
            AppMethodBeat.o(176441);
            return;
        }
        this.Feg.setVisibility(8);
        AppMethodBeat.o(176441);
    }

    public final boolean ac(SnsInfo snsInfo) {
        AppMethodBeat.i(176442);
        String snsId = snsInfo.getSnsId();
        if (TextUtils.isEmpty(this.Dsr) || !this.Dsr.equals(snsId)) {
            Log.i("SnsAdCardVideoEndView", "checkSnsId changed, old=" + this.Dsr + ", new=" + snsId);
            this.Fej = 0;
            eQ(false);
            this.Dsr = snsId;
            this.Feh = snsInfo;
            this.Fei = false;
            setBackgroundDrawable(null);
            AppMethodBeat.o(176442);
            return true;
        }
        AppMethodBeat.o(176442);
        return false;
    }

    public void setBlurBkg(View view) {
        Bitmap bitmapFromView;
        AppMethodBeat.i(176443);
        try {
            if (this.Fei) {
                AppMethodBeat.o(176443);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (view instanceof MMTextureView) {
                bitmapFromView = ((MMTextureView) view).getBitmap();
            } else {
                bitmapFromView = BitmapUtil.getBitmapFromView(view);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            int width = bitmapFromView.getWidth() / 5;
            int height = bitmapFromView.getHeight() / 5;
            Bitmap fastblur = BitmapUtil.fastblur(Bitmap.createScaledBitmap(bitmapFromView, width, height, false), 20);
            long currentTimeMillis3 = System.currentTimeMillis();
            setBackgroundDrawable(new BitmapDrawable(fastblur));
            this.Fei = true;
            Log.i("SnsAdCardVideoEndView", "setBlurBkg, totalCost=" + (currentTimeMillis3 - currentTimeMillis) + ", captureCost=" + (currentTimeMillis2 - currentTimeMillis) + ", blurCost=" + (currentTimeMillis3 - currentTimeMillis2) + ", w=" + width + ", h=" + height);
            AppMethodBeat.o(176443);
        } catch (Throwable th) {
            Log.e("SnsAdCardVideoEndView", "setBlurBkg, exp=" + th.toString());
            this.Fei = false;
            AppMethodBeat.o(176443);
        }
    }

    public final void fkZ() {
        AppMethodBeat.i(176444);
        Log.i("SnsAdCardVideoEndView", "show, anim=true");
        this.Fej = System.currentTimeMillis();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(100);
        alphaAnimation.setDuration(300);
        setVisibility(0);
        startAnimation(alphaAnimation);
        AppMethodBeat.o(176444);
    }

    public final void eQ(boolean z) {
        AppMethodBeat.i(176445);
        Log.i("SnsAdCardVideoEndView", "hide, anim=".concat(String.valueOf(z)));
        if (getVisibility() == 0) {
            fla();
        }
        if (!z) {
            setVisibility(8);
            AppMethodBeat.o(176445);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(250);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView.AnonymousClass1 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(176438);
                SnsAdCardVideoEndView.this.setVisibility(8);
                AppMethodBeat.o(176438);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
        AppMethodBeat.o(176445);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(179373);
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            Log.i("SnsAdCardVideoEndView", "onAttachedToWindow");
        }
        AppMethodBeat.o(179373);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(179374);
        super.onDetachedFromWindow();
        if (getVisibility() == 0) {
            Log.i("SnsAdCardVideoEndView", "onDetachedFromWindow");
            fla();
        }
        AppMethodBeat.o(179374);
    }

    private void fla() {
        AppMethodBeat.i(179375);
        if (!(this.Feh == null || this.FdW == null || this.Fej <= 0)) {
            float currentTimeMillis = (float) (System.currentTimeMillis() - this.Fej);
            if (currentTimeMillis > ((float) this.FdW.duration)) {
                currentTimeMillis = (float) this.FdW.duration;
            }
            a(this.Feh, this.Fej, currentTimeMillis / 1000.0f);
            this.Fej = 0;
        }
        AppMethodBeat.o(179375);
    }

    private static void x(ImageView imageView, String str) {
        AppMethodBeat.i(176446);
        if (!TextUtils.equals((String) imageView.getTag(R.id.hu3), str)) {
            imageView.setImageDrawable(null);
            b.loadImage(str, imageView);
        }
        AppMethodBeat.o(176446);
    }

    private void a(SnsInfo snsInfo, long j2, float f2) {
        AppMethodBeat.i(176447);
        if (snsInfo == null) {
            Log.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse snsInfo==null");
            AppMethodBeat.o(176447);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("exposureDuration", (double) f2);
            jSONObject2.put("startTimestamp", j2);
            jSONObject2.put("type", 5);
            String nullAsNil = Util.nullAsNil(snsInfo.getUxinfo());
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            jSONObject.put("uxinfo", nullAsNil);
            jSONObject.put("snsid", snsInfo.field_snsId);
            jSONObject.put("scene", this.mScene);
            String jSONObject3 = jSONObject.toString();
            k.jY("17539", jSONObject3);
            Log.i("SnsAdCardVideoEndView", "reportVideoEndViewExpouse 17539, content=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(176447);
        } catch (Exception e2) {
            Log.e("SnsAdCardVideoEndView", "reportVideoEndViewExpouse exp:" + e2.toString());
            AppMethodBeat.o(176447);
        }
    }

    public static void i(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(176448);
        if (snsInfo == null) {
            Log.e("SnsAdCardVideoEndView", "reportVideoEndViewClick snsInfo==null, scene=".concat(String.valueOf(i2)));
            AppMethodBeat.o(176448);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("clickCount", 1);
            jSONObject2.put("type", 4);
            String nullAsNil = Util.nullAsNil(snsInfo.getUxinfo());
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            jSONObject.put("uxinfo", nullAsNil);
            jSONObject.put("snsid", snsInfo.field_snsId);
            jSONObject.put("scene", i2);
            String jSONObject3 = jSONObject.toString();
            k.jY("17539", jSONObject3);
            Log.i("SnsAdCardVideoEndView", "reportVideoEndViewClick 17539, content=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(176448);
        } catch (Exception e2) {
            Log.e("SnsAdCardVideoEndView", "reportVideoEndViewClick exp:" + e2.toString());
            AppMethodBeat.o(176448);
        }
    }
}
