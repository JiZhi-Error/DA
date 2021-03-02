package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends m {
    boolean Ecz;
    ImageView dKU;
    ProgressBar progressBar;

    public h(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private h(Context context, ViewGroup viewGroup, byte b2) {
        super(context, null, viewGroup);
        this.Ecz = true;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96452);
        View view = this.contentView;
        this.dKU = (ImageView) view.findViewById(R.id.hw1);
        this.progressBar = (ProgressBar) view.findViewById(R.id.glr);
        AppMethodBeat.o(96452);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buh;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96453);
        if (this.contentView == null || this.dKU == null || this.progressBar == null) {
            AppMethodBeat.o(96453);
        } else if (((t) this.EcX) == null) {
            AppMethodBeat.o(96453);
        } else {
            float f2 = ((t) this.EcX).paddingTop;
            float f3 = ((t) this.EcX).paddingBottom;
            float f4 = ((t) this.EcX).paddingLeft;
            float f5 = ((t) this.EcX).paddingRight;
            String str = ((t) this.EcX).DYK;
            float f6 = ((t) this.EcX).height;
            float f7 = ((t) this.EcX).width;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dKU.getLayoutParams();
            layoutParams.width = (int) f7;
            layoutParams.height = (int) f6;
            this.dKU.setLayoutParams(layoutParams);
            this.Ecz = false;
            startLoading();
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((t) this.EcX).DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                    AppMethodBeat.i(96449);
                    h.this.startLoading();
                    AppMethodBeat.o(96449);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(96450);
                    h.this.stopLoading();
                    AppMethodBeat.o(96450);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(96451);
                    try {
                        h.this.stopLoading();
                        Bitmap decodeFile = BitmapUtil.decodeFile(str);
                        h hVar = h.this;
                        if (decodeFile == null) {
                            Log.e("AdLandingImageComp", "when set image the bmp is null!");
                            AppMethodBeat.o(96451);
                        } else if (hVar.dKU == null) {
                            Log.e("AdLandingImageComp", "when set image the imageView is null!");
                            AppMethodBeat.o(96451);
                        } else if (decodeFile.getWidth() == 0) {
                            Log.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                            AppMethodBeat.o(96451);
                        } else {
                            hVar.dKU.setImageBitmap(decodeFile);
                            hVar.progressBar.setVisibility(8);
                            AppMethodBeat.o(96451);
                        }
                    } catch (Exception e2) {
                        Log.e("AdLandingImageComp", "%s" + Util.stackTraceToString(e2));
                        AppMethodBeat.o(96451);
                    }
                }
            });
            this.contentView.setPadding((int) f4, (int) f2, (int) f5, (int) f3);
            AppMethodBeat.o(96453);
        }
    }

    public final void startLoading() {
        AppMethodBeat.i(96454);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(96454);
    }

    public final void stopLoading() {
        AppMethodBeat.i(96455);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(96455);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96456);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96456);
            return false;
        }
        try {
            if (!this.Ecz) {
                String mD5String = MD5Util.getMD5String(((t) this.EcX).DYK);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            AppMethodBeat.o(96456);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("AdLandingImageComp", e2, "", new Object[0]);
            AppMethodBeat.o(96456);
            return false;
        }
    }
}
