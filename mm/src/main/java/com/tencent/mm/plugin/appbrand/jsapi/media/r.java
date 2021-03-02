package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.utils.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"})
public final class r {
    public static final r meF = new r();

    static {
        AppMethodBeat.i(228427);
        AppMethodBeat.o(228427);
    }

    private r() {
    }

    public static final String aah(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(228423);
        p.h(str, "srcPath");
        String k = s.k(b.aKV() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
        if (k == null) {
            p.hyc();
        }
        p.g(k, "VFSFileOp.exportExternal…illis() + \".jpg\", true)!!");
        try {
            bitmap = MMBitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e2) {
            Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom");
            try {
                bitmap = BitmapUtil.decodeFile(str, null);
            } catch (OutOfMemoryError e3) {
                Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, oom again");
                bitmap = null;
            } catch (Exception e4) {
                Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e4)));
                bitmap = null;
            }
        } catch (NullPointerException e5) {
            try {
                bitmap = BitmapUtil.decodeFile(str, null);
            } catch (Exception e6) {
                Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e6)));
                bitmap = null;
            }
        } catch (Exception e7) {
            Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp e ".concat(String.valueOf(e7)));
            bitmap = null;
        }
        if (bitmap == null) {
            Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
            AppMethodBeat.o(228423);
            return null;
        }
        bitmap.recycle();
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            boolean eN = d.eN(k, str);
            Log.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(eN), Long.valueOf(Util.nowMilliSecond() - nowMilliSecond), str, Long.valueOf(s.boW(str)), k, Long.valueOf(new o(k).length()));
            if (eN) {
                str = k;
            }
        } catch (OutOfMemoryError e8) {
            Log.e("MicroMsg.MediaUtils", "compressImage, oom");
        }
        AppMethodBeat.o(228423);
        return str;
    }

    public static final String aai(String str) {
        AppMethodBeat.i(228424);
        p.h(str, "srcPath");
        Exif fromFile = Exif.fromFile(str);
        p.g(fromFile, "exif");
        int orientationInDegree = fromFile.getOrientationInDegree();
        if (orientationInDegree != 0) {
            int i2 = orientationInDegree % v2helper.VOIP_ENC_HEIGHT_LV1;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                if (decodeFile == null) {
                    Log.e("MicroMsg.MediaUtils", "rotate image, get null bmp");
                    AppMethodBeat.o(228424);
                } else {
                    Bitmap rotate = BitmapUtil.rotate(decodeFile, (float) i2);
                    String str2 = b.aKH() + "microMsg.tmp." + System.currentTimeMillis() + (d.d(options) ? ".jpg" : ".png");
                    try {
                        BitmapUtil.saveBitmapToImage(rotate, 80, d.d(options) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, str2, true);
                        if (d.d(options)) {
                            com.tencent.mm.plugin.appbrand.l.b.dk(str, str2);
                        }
                        str = str2;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", e2);
                        s.deleteFile(str2);
                    }
                    AppMethodBeat.o(228424);
                }
            } catch (NullPointerException | OutOfMemoryError e3) {
            }
        } else {
            AppMethodBeat.o(228424);
        }
        return str;
    }

    public static final boolean bD(List<String> list) {
        AppMethodBeat.i(228425);
        p.h(list, "imageFiles");
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(228425);
            return false;
        }
        for (String str : list) {
            Exif fromFile = Exif.fromFile(str);
            p.g(fromFile, "Exif.fromFile(path)");
            if (fromFile.getOrientationInDegree() != 0) {
                AppMethodBeat.o(228425);
                return true;
            }
        }
        AppMethodBeat.o(228425);
        return false;
    }

    public static final boolean aam(String str) {
        AppMethodBeat.i(228426);
        p.h(str, "imageFile");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(228426);
            return false;
        }
        Exif fromFile = Exif.fromFile(str);
        p.g(fromFile, "Exif.fromFile(imageFile)");
        if (fromFile.getOrientationInDegree() != 0) {
            AppMethodBeat.o(228426);
            return true;
        }
        AppMethodBeat.o(228426);
        return false;
    }
}
