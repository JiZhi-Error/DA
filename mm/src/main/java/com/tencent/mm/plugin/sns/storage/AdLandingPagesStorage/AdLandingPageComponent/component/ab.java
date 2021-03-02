package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends m implements SensorEventListener {
    int Efs;
    final float Eft = 10.0f;
    final int Efu = 1;
    HorizontalScrollView Efv;
    float[] Efw;
    float[] Efx;
    private int Efy = 0;
    boolean Efz = true;
    Sensor cle;
    Sensor clg;
    ImageView dKU;
    private SensorManager mSensorManager;
    ProgressBar progressBar;

    public ab(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bu8;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96668);
        View view = this.contentView;
        this.mSensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
        this.cle = this.mSensorManager.getDefaultSensor(1);
        this.clg = this.mSensorManager.getDefaultSensor(2);
        this.Efv = (HorizontalScrollView) view.findViewById(R.id.er);
        this.dKU = (ImageView) view.findViewById(R.id.es);
        this.progressBar = (ProgressBar) view.findViewById(R.id.glr);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(96668);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96669);
        if (!com.tencent.mm.vfs.s.YS(h.kz("adId", ((s) this.EcX).DYK))) {
            this.Efz = false;
        }
        String str = ((s) this.EcX).DYK;
        Bitmap kD = h.kD("adId", str);
        if (kD != null) {
            Log.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
            setImage(kD);
            AppMethodBeat.o(96669);
            return;
        }
        startLoading();
        h.a(str, ((s) this.EcX).DZj, new f.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
                AppMethodBeat.i(96664);
                ab.this.startLoading();
                AppMethodBeat.o(96664);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(96665);
                ab.this.progressBar.setVisibility(8);
                AppMethodBeat.o(96665);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(96666);
                try {
                    ab.this.setImage(BitmapUtil.decodeFile(str));
                    AppMethodBeat.o(96666);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + Util.stackTraceToString(e2));
                    AppMethodBeat.o(96666);
                }
            }
        });
        AppMethodBeat.o(96669);
    }

    public final void startLoading() {
        AppMethodBeat.i(96670);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(96670);
    }

    public final void setImage(Bitmap bitmap) {
        int i2;
        AppMethodBeat.i(96671);
        if (bitmap == null) {
            Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
            AppMethodBeat.o(96671);
        } else if (this.dKU == null) {
            Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
            AppMethodBeat.o(96671);
        } else if (bitmap.getHeight() == 0) {
            Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
            AppMethodBeat.o(96671);
        } else {
            this.progressBar.setVisibility(8);
            this.dKU.setImageBitmap(bitmap);
            this.dKU.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(96667);
                    int measuredWidth = ab.this.dKU.getMeasuredWidth();
                    if (measuredWidth > ab.this.mEX) {
                        ab abVar = ab.this;
                        abVar.Efs = (measuredWidth - abVar.mEX) / 2;
                        ab.this.Efv.scrollBy(ab.this.Efs, 0);
                    }
                    AppMethodBeat.o(96667);
                }
            });
            if (bitmap.getHeight() != 0) {
                int i3 = this.mEY;
                if (((s) this.EcX).DZl != 2.14748365E9f) {
                    i2 = (int) ((s) this.EcX).DZl;
                } else {
                    i2 = i3;
                }
                this.dKU.setLayoutParams(new RelativeLayout.LayoutParams((bitmap.getWidth() * i2) / bitmap.getHeight(), i2));
            }
            AppMethodBeat.o(96671);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = -10.0f;
        AppMethodBeat.i(96672);
        if (sensorEvent.sensor.getType() == 1) {
            this.Efw = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.Efx = sensorEvent.values;
        }
        if (!(this.Efw == null || this.Efx == null)) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.Efw, this.Efx)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f3 = fArr2[2];
                if (this.Efs != 0) {
                    if (f3 > 10.0f) {
                        f3 = 10.0f;
                    }
                    if (f3 >= -10.0f) {
                        f2 = f3;
                    }
                    this.Efv.scrollBy((int) ((f2 * ((float) this.Efs)) / 10.0f), 0);
                }
            }
        }
        AppMethodBeat.o(96672);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean fdm() {
        AppMethodBeat.i(96673);
        if (fdl() >= ((int) (((float) getView().getHeight()) * 0.1f))) {
            AppMethodBeat.o(96673);
            return true;
        }
        AppMethodBeat.o(96673);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96674);
        super.eWZ();
        this.mSensorManager.registerListener(this, this.cle, 1);
        this.mSensorManager.registerListener(this, this.clg, 1);
        AppMethodBeat.o(96674);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96675);
        super.eXa();
        this.mSensorManager.unregisterListener(this);
        AppMethodBeat.o(96675);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96676);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96676);
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.Efy);
            if (!this.Efz) {
                String mD5String = MD5Util.getMD5String(((s) this.EcX).DYK);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            AppMethodBeat.o(96676);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e2, "", new Object[0]);
            AppMethodBeat.o(96676);
            return false;
        }
    }
}
