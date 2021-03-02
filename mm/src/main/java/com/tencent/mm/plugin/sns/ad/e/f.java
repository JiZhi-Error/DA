package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class f {
    static void b(Context context, q qVar, Button button) {
        AppMethodBeat.i(201920);
        String kz = h.kz("adId", qVar.DYH);
        if (Util.isNullOrNil(kz) || !s.YS(kz)) {
            c(context, qVar, button);
            AppMethodBeat.o(201920);
            return;
        }
        Log.i("BtnIconUpdateHelper", "icon exists, url = " + qVar.DYH);
        a(context, qVar, button, kz);
        AppMethodBeat.o(201920);
    }

    static void a(Context context, q qVar, Button button, String str) {
        AppMethodBeat.i(201921);
        Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
        if (decodeFile == null) {
            Log.e("BtnIconUpdateHelper", "onDownloaded, bitmap == null");
            AppMethodBeat.o(201921);
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeFile);
        int fromDPToPix = a.fromDPToPix(context, 20);
        int fromDPToPix2 = a.fromDPToPix(context, 20);
        int fromDPToPix3 = a.fromDPToPix(context, 4);
        float measureText = button.getPaint().measureText(button.getText().toString()) + ((float) (fromDPToPix + fromDPToPix3));
        float width = (float) button.getWidth();
        Log.i("BtnIconUpdateHelper", "btn width = ".concat(String.valueOf(width)));
        int i2 = ((int) (width - measureText)) / 2;
        if (i2 < 0) {
            Log.d("BtnIconUpdateHelper", "updateBtnIcon but horizontalPadding < 0");
            AppMethodBeat.o(201921);
            return;
        }
        Log.i("BtnIconUpdateHelper", "horizontalPadding = ".concat(String.valueOf(i2)));
        button.setPadding(i2, 0, i2, 0);
        button.setIncludeFontPadding(false);
        android.support.v4.graphics.drawable.a.a(bitmapDrawable, Color.parseColor(qVar.DYt));
        bitmapDrawable.setBounds(0, 0, fromDPToPix, fromDPToPix2);
        button.setCompoundDrawables(bitmapDrawable, null, null, null);
        button.setCompoundDrawablePadding(fromDPToPix3);
        AppMethodBeat.o(201921);
    }

    private static void c(final Context context, final q qVar, final Button button) {
        AppMethodBeat.i(201922);
        final String str = qVar.DYH;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(201922);
            return;
        }
        Log.d("BtnIconUpdateHelper", "loadImage, hash = " + button.hashCode() + ", btnIconUrl = " + str);
        button.setTag(R.id.hu3, str);
        h.a(str, false, (f.a) new f.a() {
            /* class com.tencent.mm.plugin.sns.ad.e.f.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(201917);
                button.setTag(R.id.hu3, "");
                Log.e("BtnIconUpdateHelper", "onDownloadError, hash = " + button.hashCode() + ", url = " + str);
                AppMethodBeat.o(201917);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(201918);
                try {
                    String str2 = (String) button.getTag(R.id.hu3);
                    String kz = Util.isNullOrNil(str2) ? "" : h.kz("adId", str2);
                    if (Util.isNullOrNil(str) || !str.equals(kz)) {
                        Log.d("BtnIconUpdateHelper", "onDownloaded, url changed");
                        AppMethodBeat.o(201918);
                        return;
                    }
                    f.a(context, qVar, button, str);
                    Log.d("BtnIconUpdateHelper", "onDownloaded succ, hash = " + button.hashCode());
                    AppMethodBeat.o(201918);
                } catch (Throwable th) {
                    Log.e("BtnIconUpdateHelper", "onDownloaded, exp=" + th.toString());
                    AppMethodBeat.o(201918);
                }
            }
        });
        AppMethodBeat.o(201922);
    }

    public static void a(final Context context, final q qVar, final Button button) {
        boolean z = false;
        AppMethodBeat.i(201919);
        if (context == null || qVar == null || button == null) {
            try {
                Log.e("BtnIconUpdateHelper", "context or btnInfo or btn is null ");
            } catch (Throwable th) {
                Log.e("BtnIconUpdateHelper", th.toString());
                AppMethodBeat.o(201919);
                return;
            }
        } else if (!Util.isNullOrNil(qVar.DYH)) {
            if (Util.isNullOrNil(button.getText())) {
                Log.e("BtnIconUpdateHelper", "btnText is null ");
            } else {
                z = true;
            }
        }
        if (!z) {
            AppMethodBeat.o(201919);
        } else if (button.getWidth() > 0) {
            Log.i("BtnIconUpdateHelper", "already onLayoutChange, then updateBtnIconLogic");
            b(context, qVar, button);
            AppMethodBeat.o(201919);
        } else {
            button.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class com.tencent.mm.plugin.sns.ad.e.f.AnonymousClass1 */

                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AppMethodBeat.i(201916);
                    try {
                        Log.i("BtnIconUpdateHelper", "after onLayoutChange, then updateBtnIconLogic");
                        f.b(context, qVar, button);
                        button.removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(201916);
                    } catch (Throwable th) {
                        Log.e("BtnIconUpdateHelper", th.toString());
                        AppMethodBeat.o(201916);
                    }
                }
            });
            AppMethodBeat.o(201919);
        }
    }
}
