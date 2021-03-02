package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.io.File;

public final class b {
    private static final String[] icA = {null};
    private static final String[] icv = {null};
    private static final String[] icw = {null};
    private static final String[] icx = {null};
    private static final String[] icy = {null};
    private static final String[] icz = {null};

    public static synchronized String aKz() {
        String str;
        synchronized (b.class) {
            if (icv[0] == null) {
                icv[0] = "/tencent/MicroMsg/";
            }
            str = icv[0];
        }
        return str;
    }

    public static synchronized String aKA() {
        String str;
        synchronized (b.class) {
            if (icx[0] == null) {
                Context context = MMApplicationContext.getContext();
                if (context == null) {
                    throw new RuntimeException("MMApplicationContext not initialized.");
                }
                icx[0] = context.getFilesDir().getParentFile().getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP;
            }
            str = icx[0];
        }
        return str;
    }

    public static synchronized String aKB() {
        String str;
        synchronized (b.class) {
            str = aKA() + "MicroMsg/";
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Throwable th) {
            }
        }
        return str;
    }

    public static synchronized String aKC() {
        String str;
        synchronized (b.class) {
            str = aKA() + "files/public/";
        }
        return str;
    }

    public static synchronized String aKD() {
        String str;
        synchronized (b.class) {
            if (icy[0] == null) {
                icy[0] = aKE();
            }
            str = icy[0];
        }
        return str;
    }

    public static synchronized String aKE() {
        String str;
        String absolutePath;
        synchronized (b.class) {
            if (icz[0] == null) {
                String[] strArr = icz;
                if (MMApplicationContext.isToolsIsolatedProcess()) {
                    absolutePath = "/sdcard";
                } else {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                }
                strArr[0] = absolutePath;
            }
            str = icz[0];
        }
        return str;
    }

    public static synchronized String aKF() {
        String str;
        synchronized (b.class) {
            if (icA[0] == null) {
                icA[0] = new File(aKG()).getParentFile().getAbsolutePath();
            }
            str = icA[0];
        }
        return str;
    }

    private static synchronized String aKG() {
        String absolutePath;
        File file;
        File file2 = null;
        synchronized (b.class) {
            Context context = MMApplicationContext.getContext();
            if (context == null) {
                throw new RuntimeException("MMApplicationContext not initialized.");
            }
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null || externalCacheDir.exists() || externalCacheDir.mkdirs()) {
                    file2 = externalCacheDir;
                }
            } catch (Throwable th) {
            }
            if (file2 == null) {
                if (MMApplicationContext.isToolsIsolatedProcess()) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory == null) {
                        file = new File("/sdcard/");
                    } else {
                        file = externalStorageDirectory;
                    }
                } else {
                    file = new File("/sdcard/");
                }
                file2 = new File(file, "Android/data/" + MMApplicationContext.getApplicationId() + "/cache");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            try {
                absolutePath = file2.getCanonicalPath();
            } catch (Throwable th2) {
                absolutePath = file2.getAbsolutePath();
            }
        }
        return absolutePath;
    }

    public static synchronized String aKH() {
        String str;
        synchronized (b.class) {
            str = aKG() + "/image/";
        }
        return str;
    }

    public static synchronized String aKI() {
        String str;
        synchronized (b.class) {
            str = aKE() + "/tencent/MicroMsg/";
        }
        return str;
    }

    public static synchronized String aKJ() {
        String str;
        synchronized (b.class) {
            str = aKD() + aKz();
        }
        return str;
    }

    public static synchronized String aKK() {
        String str;
        synchronized (b.class) {
            str = aKF() + "/MicroMsg/";
        }
        return str;
    }

    public static synchronized String aKL() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "crash/";
        }
        return str;
    }

    public static synchronized String aKM() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "Download/";
        }
        return str;
    }

    public static synchronized String aKN() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "vusericon/";
        }
        return str;
    }

    public static synchronized String aKO() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "Game/";
        }
        return str;
    }

    public static synchronized String aKP() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "CDNTemp/";
        }
        return str;
    }

    public static synchronized String aKQ() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "xlog";
        }
        return str;
    }

    public static synchronized String aKR() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "avatar/";
        }
        return str;
    }

    public static synchronized String aKS() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "Cache/";
        }
        return str;
    }

    public static synchronized String aKT() {
        String str;
        synchronized (b.class) {
            str = aKE() + "/tencent/MicroMsg/" + aKW();
        }
        return str;
    }

    public static synchronized String aKU() {
        File file;
        String str;
        synchronized (b.class) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (externalStoragePublicDirectory != null) {
                file = new File(externalStoragePublicDirectory, aKW());
            } else {
                file = new File(aKF(), "Pictures/" + aKW());
                if (!file.exists() && !file.mkdirs()) {
                    file = new File(aKT());
                }
            }
            try {
                str = file.getCanonicalPath() + FilePathGenerator.ANDROID_DIR_SEP;
            } catch (Throwable th) {
                str = file.getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP;
            }
        }
        return str;
    }

    public static synchronized String aKV() {
        String aKT;
        synchronized (b.class) {
            if (aKD().equals(aKF())) {
                aKT = aKU();
            } else {
                aKT = aKT();
            }
        }
        return aKT;
    }

    private static synchronized String aKW() {
        String str;
        synchronized (b.class) {
            if (WeChatBrands.AppInfo.current().isUS()) {
                str = "WeChat/";
            } else {
                String str2 = aKE() + "/tencent/MicroMsg/WeiXin/";
                if (new File(aKE() + "/tencent/MicroMsg/WeChat/").exists()) {
                    str = "WeChat/";
                } else if (new File(str2).exists()) {
                    str = "WeiXin/";
                } else {
                    str = LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) ? "WeiXin/" : "WeChat/";
                }
            }
        }
        return str;
    }

    public static synchronized String aKX() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "appbrand/";
        }
        return str;
    }

    public static synchronized String aKY() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "watchdog/";
        }
        return str;
    }

    public static synchronized String aKZ() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "exdevice/";
        }
        return str;
    }

    public static synchronized String aLa() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "newyear/";
        }
        return str;
    }

    public static synchronized String aLb() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "WebviewCache/";
        }
        return str;
    }

    public static synchronized String aLc() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "browser/";
        }
        return str;
    }

    public static synchronized String aLd() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "card/";
        }
        return str;
    }

    public static synchronized String aLe() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "CheckResUpdate/";
        }
        return str;
    }

    public static synchronized String aLf() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "crash/";
        }
        return str;
    }

    public static synchronized String aLg() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "diskcache/";
        }
        return str;
    }

    public static synchronized String aLh() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "FailMsgFileCache/";
        }
        return str;
    }

    public static synchronized String aLi() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "fts/";
        }
        return str;
    }

    public static synchronized String aLj() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "Handler/";
        }
        return str;
    }

    public static synchronized String aLk() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "MixAudio/";
        }
        return str;
    }

    public static synchronized String aLl() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "preloadedRes/";
        }
        return str;
    }

    public static synchronized String aLm() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "recovery/";
        }
        return str;
    }

    public static synchronized String aLn() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "share/";
        }
        return str;
    }

    public static synchronized String aLo() {
        String str;
        synchronized (b.class) {
            str = aLn() + "upload_cache/";
        }
        return str;
    }

    public static synchronized String aLp() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "sns_ad_landingpages/";
        }
        return str;
    }

    public static synchronized String aLq() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "SQLTrace/";
        }
        return str;
    }

    public static synchronized String aLr() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "tracedog/";
        }
        return str;
    }

    public static synchronized String aLs() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "vproxy/";
        }
        return str;
    }

    public static synchronized String aLt() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wagamefiles/";
        }
        return str;
    }

    public static synchronized String aLu() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wallet/";
        }
        return str;
    }

    public static synchronized String aLv() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wepkg/";
        }
        return str;
    }

    public static synchronized String aLw() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxacache/";
        }
        return str;
    }

    public static synchronized String aLx() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxafiles/";
        }
        return str;
    }

    public static synchronized String aLy() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxajscahce/";
        }
        return str;
    }

    public static synchronized String aLz() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxanewfiles/";
        }
        return str;
    }

    public static synchronized String aLA() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "temp_video_cache";
        }
        return str;
    }

    public static synchronized String aLB() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "egg_spring/";
        }
        return str;
    }

    public static synchronized String aLC() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxvideocache/";
        }
        return str;
    }

    public static synchronized String aLD() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "wxvideotmp/";
        }
        return str;
    }

    public static synchronized String aLE() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "favoffline/";
        }
        return str;
    }

    public static synchronized String aLF() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "image_crop/";
        }
        return str;
    }

    public static synchronized String aLG() {
        String str;
        synchronized (b.class) {
            str = aKJ() + "mail/";
        }
        return str;
    }

    public static synchronized String aLH() {
        File file;
        String absolutePath;
        synchronized (b.class) {
            try {
                file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.CConstants", th, "[-] Fail to get public download path from system.", new Object[0]);
                file = null;
            }
            if (file == null) {
                file = new File(aKE(), Environment.DIRECTORY_DOWNLOADS);
            }
            File file2 = new File(file, aKW());
            try {
                absolutePath = file2.getCanonicalPath();
            } catch (Throwable th2) {
                absolutePath = file2.getAbsolutePath();
            }
        }
        return absolutePath;
    }

    public static synchronized void A(String str, boolean z) {
        synchronized (b.class) {
            Log.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + aKD() + ", DEFAULT_SDCARD_ROOT: " + aKE());
            if (z) {
                icy[0] = str;
                icv[0] = "/MicroMsg/";
            } else {
                if (!aKD().equals(aKF())) {
                    icy[0] = str;
                }
                icz[0] = str;
            }
            Log.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + aKD() + ", DEFAULT_SDCARD_ROOT: " + aKE());
        }
    }

    public static synchronized void aLI() {
        synchronized (b.class) {
            icA[0] = null;
        }
    }
}
