package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class e {
    private static final HashMap<String, WeakReference<Bitmap>> JeH = new HashMap<>();

    public static void a(com.tencent.mm.plugin.webview.stub.e eVar, int i2, Object... objArr) {
        AppMethodBeat.i(79678);
        ArrayList arrayList = new ArrayList();
        if (objArr.length == 0) {
            AppMethodBeat.o(79678);
            return;
        }
        try {
            for (Object obj : objArr) {
                arrayList.add(String.valueOf(obj));
            }
            eVar.v(i2, arrayList);
            AppMethodBeat.o(79678);
        } catch (Exception e2) {
            Log.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e2.getMessage());
            AppMethodBeat.o(79678);
        }
    }

    static {
        AppMethodBeat.i(79687);
        AppMethodBeat.o(79687);
    }

    public static Bitmap baf(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(79680);
        WeakReference<Bitmap> weakReference = JeH.get(str);
        if (weakReference == null || weakReference.get() == null || weakReference.get().isRecycled()) {
            if (s.YS(str)) {
                bitmap = BitmapUtil.decodeFile(str, null);
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                JeH.put(str, new WeakReference<>(bitmap));
            } else {
                try {
                    bitmap = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
                    JeH.put(str, new WeakReference<>(bitmap));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(79680);
            return bitmap;
        }
        Bitmap bitmap2 = weakReference.get();
        AppMethodBeat.o(79680);
        return bitmap2;
    }

    public static long bag(String str) {
        AppMethodBeat.i(79681);
        long bA = bA(str, -1);
        AppMethodBeat.o(79681);
        return bA;
    }

    public static int gw(String str, int i2) {
        AppMethodBeat.i(79682);
        int bA = (int) bA(str, (long) i2);
        AppMethodBeat.o(79682);
        return bA;
    }

    private static long bA(String str, long j2) {
        AppMethodBeat.i(79683);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79683);
            return j2;
        }
        if (str.startsWith("#") && str.length() == 4) {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(2, str.charAt(1));
            sb.insert(4, str.charAt(2));
            sb.insert(6, str.charAt(3));
            str = sb.toString();
        }
        try {
            long parseColor = Util.MAX_32BIT_VALUE & ((long) Color.parseColor(str));
            AppMethodBeat.o(79683);
            return parseColor;
        } catch (Exception e2) {
            Log.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", str);
            AppMethodBeat.o(79683);
            return j2;
        }
    }

    public static Bitmap bah(String str) {
        Bitmap decodeByteArray;
        AppMethodBeat.i(79684);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79684);
            return null;
        }
        WeakReference<Bitmap> weakReference = JeH.get(str);
        if (weakReference == null || weakReference.get() == null || weakReference.get().isRecycled()) {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                AppMethodBeat.o(79684);
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int min = Math.min(options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            if (min > 96) {
                options.inSampleSize = Math.max((int) ((((float) min) * 1.0f) / 96.0f), 1);
                decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (decodeByteArray == null) {
                    AppMethodBeat.o(79684);
                    return null;
                }
                i2 = decodeByteArray.getWidth();
                i3 = decodeByteArray.getHeight();
                min = Math.min(i2, i3);
            } else {
                decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (decodeByteArray == null) {
                    AppMethodBeat.o(79684);
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, Math.max((i2 / 2) - (min / 2), 0), Math.max((i3 / 2) - (min / 2), 0), min, min);
            if (createBitmap != decodeByteArray) {
                decodeByteArray.recycle();
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 96, 96, false);
            if (createBitmap != createScaledBitmap) {
                Log.i("MicroMsg.WebView.RemoteUtil", "bitmap recycle %s", createBitmap.toString());
                createBitmap.recycle();
            }
            if (createScaledBitmap != null && !createScaledBitmap.isRecycled()) {
                JeH.put(str, new WeakReference<>(createScaledBitmap));
            }
            AppMethodBeat.o(79684);
            return createScaledBitmap;
        }
        Bitmap bitmap = weakReference.get();
        AppMethodBeat.o(79684);
        return bitmap;
    }

    public static int agC(int i2) {
        AppMethodBeat.i(79685);
        int agC = ao.agC(i2);
        AppMethodBeat.o(79685);
        return agC;
    }

    public static boolean a(Bundle bundle, String str, String str2, f fVar, Runnable runnable) {
        AppMethodBeat.i(79686);
        if (fVar == null) {
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(79686);
            return true;
        }
        Bundle bundle2 = new Bundle(3);
        bundle2.putBundle("open_ui_with_webview_ui_extras", bundle);
        bundle2.putString("open_ui_with_webview_ui_plugin_name", str);
        bundle2.putString("open_ui_with_webview_ui_plugin_entry", str2);
        try {
            fVar.j(101, bundle2);
            AppMethodBeat.o(79686);
            return true;
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e2, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.o(79686);
            return false;
        } catch (Exception e3) {
            if (runnable != null) {
                runnable.run();
            }
            Log.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e3, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.o(79686);
            return false;
        }
    }
}
