package com.tencent.mm.plugin.multitask.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/multitask/utils/MinusScreenUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEWPAGER_SCROLL_MARGING", "", "getVIEWPAGER_SCROLL_MARGING", "()I", "doLoadFromImage", "Landroid/graphics/Bitmap;", "srcPath", "contentView", "Landroid/widget/ImageView;", "supportMultiTaskType", "", "multiTaskType", "plugin-multitask_release"})
public final class a {
    private static final int AgI = at.fromDPToPix(MMApplicationContext.getContext(), 16);
    public static final a AgJ = new a();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(200783);
        AppMethodBeat.o(200783);
    }

    private a() {
    }

    public static int esC() {
        return AgI;
    }

    public static Bitmap aGR(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(200782);
        try {
            bitmap = MMBitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "doCompressImage, decode bmp oom");
            try {
                bitmap = BitmapUtil.decodeFile(str, null);
            } catch (OutOfMemoryError e3) {
                Log.e(TAG, "doCompressImage, decode bmp oom retry, oom again");
                bitmap = null;
            } catch (Exception e4) {
                Log.e(TAG, "doCompressImage, decode bmp oom retry, e $e");
                bitmap = null;
            }
        } catch (NullPointerException e5) {
            try {
                bitmap = BitmapUtil.decodeFile(str, null);
            } catch (Exception e6) {
                Log.e(TAG, "doCompressImage, decode bmp npe retry, e $e");
                bitmap = null;
            }
        } catch (Exception e7) {
            Log.e(TAG, "doCompressImage, decode bmp e $e");
            bitmap = null;
        }
        if (bitmap == null) {
            Log.e(TAG, "doCompressImage, decode bmp return null");
            AppMethodBeat.o(200782);
            return null;
        }
        AppMethodBeat.o(200782);
        return bitmap;
    }

    public static boolean Js(int i2) {
        return i2 == 2 || i2 == 22 || i2 == 4 || i2 == 1 || i2 == 5 || i2 == 3 || i2 == 8;
    }
}
