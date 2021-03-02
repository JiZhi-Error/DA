package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v {
    public static boolean a(Context context, a aVar, int i2, boolean z) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(43961);
        if (context == null || aVar == null) {
            Log.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            AppMethodBeat.o(43961);
            return false;
        } else if (aVar.cze == null) {
            Log.e("MicroMsg.AppBrandShortcutManager", "no such user");
            AppMethodBeat.o(43961);
            return false;
        } else {
            Bitmap m = m(aVar.cze);
            if (m == null) {
                Log.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
                AppMethodBeat.o(43961);
                return true;
            }
            Intent a2 = a(context, aVar, i2, a(context, m, i2), true);
            if (a2 == null) {
                Log.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
                AppMethodBeat.o(43961);
                return false;
            }
            if (((Intent) a2.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
                String str4 = aVar.appId;
                String eW = b.eW(str4 + String.valueOf(i2), q.dr(true));
                if (eW != null) {
                    str2 = b.toHexString(eW.getBytes());
                } else {
                    str2 = null;
                }
                String eW2 = b.eW(str4 + String.valueOf(i2), q.getAndroidId());
                if (eW != null) {
                    str3 = b.toHexString(eW2.getBytes());
                }
                Log.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", str4, str2);
                str = str3;
            } else {
                str = null;
                str2 = null;
            }
            try {
                b.a(context, a2, str, str2, z);
                Log.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", aVar.userName);
                AppMethodBeat.o(43961);
                return true;
            } catch (IllegalStateException e2) {
                Log.w("MicroMsg.AppBrandShortcutManager", e2.toString());
                AppMethodBeat.o(43961);
                return false;
            }
        }
    }

    public static Intent a(Context context, a aVar, int i2, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(43962);
        if (aVar == null || context == null || aVar.userName == null) {
            Log.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            AppMethodBeat.o(43962);
            return null;
        } else if (bitmap != null || !z) {
            String str = TextUtils.isEmpty(aVar.nickname) ? aVar.userName : aVar.nickname;
            Intent a2 = u.bth().a(context.getPackageName(), i2, aVar.userName, aVar.nickname, aVar.cze, aVar.appId, aVar.uin, 1);
            Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", str);
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            AppMethodBeat.o(43962);
            return intent;
        } else {
            Log.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            AppMethodBeat.o(43962);
            return null;
        }
    }

    public static Bitmap m(String[] strArr) {
        Bitmap bitmap;
        AppMethodBeat.i(43963);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                bitmap = null;
                break;
            }
            String str = strArr[i2];
            if (!Util.isNullOrNil(str) && (bitmap = com.tencent.mm.modelappbrand.a.b.aXY().a(str, (b.f) null)) != null && !bitmap.isRecycled()) {
                break;
            }
            i2++;
        }
        AppMethodBeat.o(43963);
        return bitmap;
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i2) {
        Bitmap bitmap2 = null;
        AppMethodBeat.i(43964);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(43964);
        } else {
            int density = (int) (com.tencent.mm.cb.a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Bitmap.Config.ARGB_8888, true);
                Log.i("MicroMsg.AppBrandShortcutManager", "bitmap recycle %s", createScaledBitmap);
                createScaledBitmap.recycle();
            }
            if (i2 == 2) {
                a(context, bitmap2, com.tencent.mm.cb.a.aI(context, R.string.ro));
            } else if (i2 == 1) {
                a(context, bitmap2, com.tencent.mm.cb.a.aI(context, R.string.rp));
            }
            AppMethodBeat.o(43964);
        }
        return bitmap2;
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        RectF rectF;
        AppMethodBeat.i(43965);
        if (context == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(43965);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43965);
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float density = com.tencent.mm.cb.a.getDensity(context);
            float f2 = 4.0f * density;
            float f3 = 2.0f * density;
            Paint paint = new Paint();
            paint.setTextSize(density * 6.0f);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            float measureText = paint.measureText(str);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f4 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            if (Build.VERSION.SDK_INT < 26) {
                rectF = new RectF((((float) width) - measureText) - (2.0f * f2), (((float) height) - f4) - (2.0f * f3), (float) width, (float) height);
            } else {
                rectF = new RectF(0.0f, (((float) height) - f4) - (2.0f * f3), measureText + (2.0f * f2), (float) height);
            }
            canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
            paint.setColor(-1);
            canvas.drawText(str, rectF.left + f2, (rectF.top + f3) - fontMetrics.ascent, paint);
            AppMethodBeat.o(43965);
        }
    }

    public static class a {
        public String appId;
        public String[] cze;
        public String nickname;
        public int uin;
        public String userName;

        public a(int i2, String[] strArr, String str, String str2, String str3) {
            this.uin = i2;
            this.cze = strArr;
            this.nickname = str;
            this.appId = str2;
            this.userName = str3;
        }
    }
}
