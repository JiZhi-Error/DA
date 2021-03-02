package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.JSONObject;

public final class a {
    public static int iUo = 1;
    private static String iUp = "";

    private static String bbt() {
        AppMethodBeat.i(104501);
        if (Util.isNullOrNil(iUp)) {
            iUp = b.aKC().replace("/data/user/0", "/data/data");
        }
        String str = iUp;
        AppMethodBeat.o(104501);
        return str;
    }

    public static String bbu() {
        AppMethodBeat.i(104502);
        o oVar = new o(bbt(), "emoji/res");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        String z = aa.z(oVar.her());
        AppMethodBeat.o(104502);
        return z;
    }

    public static String bbv() {
        AppMethodBeat.i(104503);
        String str = bbt() + "emoji/newemoji/";
        AppMethodBeat.o(104503);
        return str;
    }

    public static int bbw() {
        AppMethodBeat.i(104504);
        InputStream inputStream = null;
        try {
            inputStream = s.ao(new o(bbu(), "config.conf"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = str + readLine;
                } else {
                    int i2 = new JSONObject(str).getInt("version");
                    Log.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i2));
                    return i2;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, e2.getMessage(), new Object[0]);
            return 1;
        } finally {
            Util.qualityClose(inputStream);
            AppMethodBeat.o(104504);
        }
    }

    private static int bbx() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(104505);
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("emoji_config.conf");
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                bufferedReader = null;
                inputStreamReader = null;
                try {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, e2.getMessage(), new Object[0]);
                    Util.qualityClose(inputStream);
                    Util.qualityClose(inputStreamReader);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(104505);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    Util.qualityClose(inputStreamReader);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(104505);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStreamReader = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(104505);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                String str = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            int i2 = new JSONObject(str).getInt("version");
                            Log.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i2));
                            Util.qualityClose(inputStream);
                            Util.qualityClose(inputStreamReader);
                            Util.qualityClose(bufferedReader);
                            AppMethodBeat.o(104505);
                            return i2;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, e2.getMessage(), new Object[0]);
                        Util.qualityClose(inputStream);
                        Util.qualityClose(inputStreamReader);
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(104505);
                        return 1;
                    }
                }
            } catch (Exception e5) {
                e2 = e5;
                bufferedReader = null;
                Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, e2.getMessage(), new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(104505);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(104505);
                throw th;
            }
        } catch (Exception e6) {
            e2 = e6;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(inputStream);
            Util.qualityClose(inputStreamReader);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(104505);
            return 1;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            Util.qualityClose(inputStream);
            Util.qualityClose(inputStreamReader);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(104505);
            throw th;
        }
    }

    private static boolean Oi(String str) {
        InputStream inputStream;
        OutputStream outputStream;
        AppMethodBeat.i(104506);
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("emoji_template.zip");
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
            inputStream = null;
        }
        if (inputStream == null) {
            Log.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            AppMethodBeat.o(104506);
            return false;
        }
        o oVar = new o(str);
        if (oVar.exists()) {
            oVar.delete();
        }
        oVar.heq().mkdirs();
        try {
            outputStream = s.ap(oVar);
        } catch (FileNotFoundException e3) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
            outputStream = null;
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        Util.qualityClose(inputStream);
                        Util.qualityClose(outputStream);
                        AppMethodBeat.o(104506);
                        return true;
                    }
                }
            } catch (IOException e4) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e4, "", new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(104506);
                return false;
            } catch (Throwable th) {
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                AppMethodBeat.o(104506);
                throw th;
            }
        } else {
            Util.qualityClose(inputStream);
            AppMethodBeat.o(104506);
            return false;
        }
    }

    public static void fF(boolean z) {
        AppMethodBeat.i(104507);
        o oVar = new o(bbu());
        Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", oVar.hes());
        if (d.KyR) {
            Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            s.dy(aa.z(oVar.mUri), true);
            j(oVar);
        } else {
            iUo = bbw();
            if (z) {
                int bbx = bbx();
                Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(bbx), Integer.valueOf(iUo));
                if (iUo < bbx) {
                    s.dy(aa.z(oVar.mUri), true);
                    j(oVar);
                }
            } else if (iUo == 1) {
                Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(iUo));
                s.dy(aa.z(oVar.mUri), true);
                j(oVar);
            }
        }
        s.dy(b.aKJ() + "emoji", true);
        AppMethodBeat.o(104507);
    }

    private static void j(o oVar) {
        AppMethodBeat.i(104508);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        o oVar2 = new o(oVar, FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar2.exists()) {
            try {
                oVar2.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "create nomedia file error", new Object[0]);
            }
        }
        o oVar3 = new o(oVar, "emoji_template.zip");
        if (Oi(aa.z(oVar3.her()))) {
            int fW = s.fW(aa.z(oVar3.her()), oVar3.getParent());
            if (fW < 0) {
                Log.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + fW + ", zipFilePath = " + aa.z(oVar3.her()) + ", unzipPath = " + oVar3.getParent());
                AppMethodBeat.o(104508);
                return;
            }
            iUo = bbw();
            Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", oVar3.getParent(), Integer.valueOf(iUo));
            AppMethodBeat.o(104508);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", aa.z(oVar3.her()));
        AppMethodBeat.o(104508);
    }

    public static void k(o oVar) {
        AppMethodBeat.i(104509);
        o oVar2 = new o(bbu());
        s.dy(aa.z(oVar2.mUri), true);
        oVar2.mkdirs();
        o oVar3 = new o(oVar2, FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar3.exists()) {
            try {
                oVar3.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "create nomedia file error", new Object[0]);
            }
        }
        o oVar4 = new o(oVar2, "emoji_template.zip");
        s.nw(aa.z(oVar.mUri), aa.z(oVar4.mUri));
        int UnZipFolder = Util.UnZipFolder(aa.z(oVar4.mUri), oVar4.getParent());
        if (UnZipFolder < 0) {
            Log.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + UnZipFolder + ", zipFilePath = " + aa.z(oVar4.her()) + ", unzipPath = " + oVar4.getParent());
            AppMethodBeat.o(104509);
            return;
        }
        iUo = bbw();
        Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", oVar4.getParent(), Integer.valueOf(iUo));
        AppMethodBeat.o(104509);
    }
}
