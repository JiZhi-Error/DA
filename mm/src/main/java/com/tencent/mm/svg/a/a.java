package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.svg.WeChatSVG;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.c;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

public final class a {
    private static String Our = ".svg.code.drawable";
    protected static int Ous = 3;
    private static String Out = "";
    private static Map<Integer, c> Ouu = new ConcurrentHashMap();
    private static Map<Integer, Picture> Ouv = new ConcurrentHashMap();
    private static Map<String, Picture> Ouw = new ConcurrentHashMap();
    private static Float Oux;
    private TypedValue Oup = new TypedValue();
    private byte[] Ouq = new byte[0];

    public a() {
        AppMethodBeat.i(148701);
        AppMethodBeat.o(148701);
    }

    static {
        AppMethodBeat.i(148716);
        AppMethodBeat.o(148716);
    }

    public static void gm(String str) {
        Out = str;
    }

    public static Drawable h(Resources resources, int i2) {
        AppMethodBeat.i(148702);
        Drawable a2 = a(resources, i2, 0.0f);
        AppMethodBeat.o(148702);
        return a2;
    }

    private static String gFN() {
        AppMethodBeat.i(148703);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            AppMethodBeat.o(148703);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 3; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains("com.tencent.mm") && !stackTrace[i2].getClassName().contains("sdk.platformtools.Log")) {
                sb.append("[");
                sb.append(stackTrace[i2].getClassName().substring(15));
                sb.append(":");
                sb.append(stackTrace[i2].getMethodName());
                sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(148703);
        return sb2;
    }

    public static Drawable a(Resources resources, int i2, float f2) {
        AppMethodBeat.i(148704);
        if (i2 == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", Integer.valueOf(i2));
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "The stack : %s", gFN());
            c cVar = new c(new Picture(), i2);
            AppMethodBeat.o(148704);
            return cVar;
        } else if (b.gFX()) {
            Drawable c2 = c(resources, i2, f2);
            AppMethodBeat.o(148704);
            return c2;
        } else {
            Drawable a2 = a(resources, i2, Out + Our, f2);
            AppMethodBeat.o(148704);
            return a2;
        }
    }

    public static Bitmap i(Resources resources, int i2) {
        AppMethodBeat.i(148705);
        Bitmap b2 = b(resources, i2, 0.0f);
        AppMethodBeat.o(148705);
        return b2;
    }

    public static Bitmap b(Resources resources, int i2, float f2) {
        AppMethodBeat.i(148706);
        Drawable a2 = a(resources, i2, f2);
        if (a2 == null) {
            AppMethodBeat.o(148706);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        a2.draw(new Canvas(createBitmap));
        AppMethodBeat.o(148706);
        return createBitmap;
    }

    public final boolean j(Resources resources, int i2) {
        String charSequence;
        AppMethodBeat.i(148707);
        try {
            if (resources.getResourceTypeName(i2).equals(ShareConstants.DEXMODE_RAW)) {
                synchronized (this.Ouq) {
                    try {
                        TypedValue typedValue = this.Oup;
                        if (typedValue == null) {
                            typedValue = new TypedValue();
                            this.Oup = typedValue;
                        }
                        resources.getValue(i2, typedValue, true);
                        charSequence = typedValue.string.toString();
                    } catch (Throwable th) {
                        AppMethodBeat.o(148707);
                        throw th;
                    }
                }
                if (charSequence.endsWith(".svg")) {
                    AppMethodBeat.o(148707);
                    return true;
                }
            }
            AppMethodBeat.o(148707);
            return false;
        } catch (Resources.NotFoundException e2) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGCompat", e2, "resource not found", new Object[0]);
            AppMethodBeat.o(148707);
            return false;
        }
    }

    public static Map<Integer, c> gFO() {
        return Ouu;
    }

    protected static boolean b(View view, Paint paint) {
        AppMethodBeat.i(148708);
        if (Build.VERSION.SDK_INT > 10) {
            boolean c2 = c(view, paint);
            AppMethodBeat.o(148708);
            return c2;
        }
        AppMethodBeat.o(148708);
        return false;
    }

    @TargetApi(11)
    private static boolean c(View view, Paint paint) {
        AppMethodBeat.i(148709);
        if (view != null) {
            try {
                if (view.getLayerType() != 1) {
                    view.setLayerType(1, paint);
                }
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            }
            if (view.willNotCacheDrawing()) {
                view.setWillNotCacheDrawing(false);
                if (view.getWindowToken() != null) {
                    view.buildLayer();
                }
            }
            AppMethodBeat.o(148709);
            return true;
        }
        AppMethodBeat.o(148709);
        return false;
    }

    protected static View C(Drawable drawable) {
        AppMethodBeat.i(148710);
        while (true) {
            Drawable.Callback callback = drawable.getCallback();
            if (callback != null) {
                if (!(callback instanceof View)) {
                    if (!(callback instanceof Drawable)) {
                        break;
                    }
                    drawable = (Drawable) callback;
                } else {
                    View view = (View) callback;
                    AppMethodBeat.o(148710);
                    return view;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(148710);
        return null;
    }

    private static Drawable c(Resources resources, int i2, float f2) {
        AppMethodBeat.i(148711);
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGCompat", "Using wechat svg library.", new Object[0]);
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
                }
            }
            long parse = WeChatSVG.parse(EncodingUtils.getString(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET).toString());
            if (parse == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
                AppMethodBeat.o(148711);
                return null;
            }
            float[] viewPort = WeChatSVG.getViewPort(parse);
            float f3 = resources.getDisplayMetrics().density;
            float f4 = (f2 > 0.0f ? f2 : 1.0f) * (viewPort[0] / ((float) Ous)) * f3;
            float f5 = (viewPort[1] / ((float) Ous)) * f3;
            if (f2 <= 0.0f) {
                f2 = 1.0f;
            }
            float f6 = f5 * f2;
            Picture picture = new Picture();
            int renderViewPort = WeChatSVG.renderViewPort(parse, picture.beginRecording((int) f4, (int) f6), (float) ((int) f4), (float) ((int) f6));
            picture.endRecording();
            WeChatSVG.release(parse);
            c cVar = new c(picture, i2);
            if (renderViewPort < 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", Integer.valueOf(renderViewPort));
                AppMethodBeat.o(148711);
                return null;
            }
            AppMethodBeat.o(148711);
            return cVar;
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.SVGCompat", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(148711);
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.SVGCompat", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(148711);
            throw th;
        }
    }

    private static float cm(float f2) {
        AppMethodBeat.i(148712);
        if (Oux == null) {
            Oux = Float.valueOf(f2 / ((float) Ous));
        }
        float floatValue = Oux.floatValue();
        AppMethodBeat.o(148712);
        return floatValue;
    }

    private static Drawable a(Resources resources, int i2, String str, float f2) {
        float f3;
        c cVar;
        AppMethodBeat.i(148713);
        float f4 = resources.getDisplayMetrics().density;
        if (f2 > 0.0f) {
            f3 = f2;
        } else {
            f3 = 1.0f;
        }
        if (f2 > 0.0f) {
            String str2 = i2 + "_scale_" + f2;
            Picture picture = Ouw.get(str2);
            if (picture == null) {
                picture = a(f4, a(resources, i2, str), f3);
                Ouw.put(str2, picture);
            }
            cVar = new c(picture, i2);
        } else {
            Picture picture2 = Ouv.get(Integer.valueOf(i2));
            if (picture2 == null) {
                picture2 = a(f4, a(resources, i2, str), f3);
                Ouv.put(Integer.valueOf(i2), picture2);
            }
            cVar = new c(picture2, i2);
        }
        AppMethodBeat.o(148713);
        return cVar;
    }

    private static c a(Resources resources, int i2, String str) {
        String str2;
        c cVar;
        AppMethodBeat.i(148714);
        try {
            if (Ouu.containsKey(Integer.valueOf(i2))) {
                cVar = Ouu.get(Integer.valueOf(i2));
            } else {
                String resourceName = resources.getResourceName(i2);
                if (resourceName == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
                    AppMethodBeat.o(148714);
                    return null;
                }
                int indexOf = resourceName.indexOf(FilePathGenerator.ANDROID_DIR_SEP);
                if (indexOf > 0) {
                    str2 = str + "." + resourceName.substring(indexOf + 1);
                } else {
                    str2 = str + "." + resourceName;
                }
                cVar = (c) Class.forName(str2).newInstance();
                Ouu.put(Integer.valueOf(i2), cVar);
            }
            AppMethodBeat.o(148714);
            return cVar;
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", "");
            AppMethodBeat.o(148714);
            return null;
        } catch (InstantiationException e3) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", "");
            Log.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
            AppMethodBeat.o(148714);
            return null;
        } catch (IllegalAccessException e4) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", "");
            Log.printErrStackTrace("MicroMsg.SVGCompat", e4, "", new Object[0]);
            AppMethodBeat.o(148714);
            return null;
        }
    }

    private static Picture a(float f2, c cVar, float f3) {
        AppMethodBeat.i(148715);
        Picture picture = new Picture();
        if (cVar == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
            AppMethodBeat.o(148715);
        } else {
            float cm = cm(f2) * f3;
            Canvas beginRecording = picture.beginRecording((int) (((float) c.getWidth(cVar)) * cm), (int) (((float) c.getHeight(cVar)) * cm));
            beginRecording.save();
            beginRecording.scale(cm, cm);
            c.render(cVar, beginRecording, Looper.myLooper());
            beginRecording.restore();
            picture.endRecording();
            AppMethodBeat.o(148715);
        }
        return picture;
    }
}
