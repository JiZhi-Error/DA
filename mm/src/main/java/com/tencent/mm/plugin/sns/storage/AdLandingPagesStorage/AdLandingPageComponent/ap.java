package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class ap {
    public String DWN;
    public String Eap;
    public float Eaq;
    public float tt;

    public static ap a(Map<String, String> map, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(202832);
        ap apVar = new ap();
        apVar.Eap = Util.nullAsNil(map.get(str + ".borderColor"));
        apVar.Eaq = i.a(Util.safeParseDouble(map.get(str + ".borderSize")), i2, i3, i4);
        apVar.tt = i.a(Util.safeParseDouble(map.get(str + ".cornerRadius")), i2, i3, i4);
        apVar.DWN = Util.nullAsNil(map.get(str + ".bgColor"));
        AppMethodBeat.o(202832);
        return apVar;
    }

    public static void a(View view, ap apVar) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(202833);
        try {
            String str = apVar.Eap;
            String str2 = apVar.DWN;
            float f2 = apVar.Eaq;
            float f3 = apVar.tt;
            GradientDrawable gradientDrawable = null;
            if (!Util.isNullOrNil(str) && f2 > 0.0f) {
                try {
                    i2 = Color.parseColor(str);
                } catch (Exception e2) {
                    Log.e("BorderCornerBgInfo", Util.stackTraceToString(e2));
                    i2 = 0;
                }
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke((int) f2, i2);
            }
            if (!Util.isNullOrNil(str2)) {
                try {
                    i3 = Color.parseColor(str2);
                } catch (Exception e3) {
                    Log.e("BorderCornerBgInfo", Util.stackTraceToString(e3));
                }
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                }
                gradientDrawable.setColor(i3);
            }
            if (gradientDrawable != null && f3 > 0.0f) {
                gradientDrawable.setCornerRadius(f3);
            }
            if (gradientDrawable != null) {
                view.setClipToOutline(true);
                view.setBackgroundDrawable(gradientDrawable);
            }
            AppMethodBeat.o(202833);
        } catch (Throwable th) {
            Log.e("BorderCornerBgInfo", "");
            AppMethodBeat.o(202833);
        }
    }
}
