package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import org.json.JSONObject;

public final class ao {
    private static String iUp = "";
    public static Set<String> tbJ;
    public static int tbK = 1;

    private static String my(boolean z) {
        AppMethodBeat.i(127420);
        if (z) {
            String str = g.aAh().hqG;
            AppMethodBeat.o(127420);
            return str;
        }
        if (Util.isNullOrNil(iUp)) {
            iUp = b.aKC().replace("/data/user/0", "/data/data");
        }
        String str2 = iUp;
        AppMethodBeat.o(127420);
        return str2;
    }

    public static String cVg() {
        File file;
        AppMethodBeat.i(127421);
        if (SdcardUtil.getAvailableInternalMemorySize() > 1048576) {
            file = new File(my(false), "wenote/res");
        } else {
            file = new File(b.aKJ(), "wenote/res");
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(127421);
        return absolutePath;
    }

    public static String cVh() {
        AppMethodBeat.i(127422);
        File file = new File(my(false), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            String absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(127422);
            return absolutePath;
        }
        File file2 = new File(b.aKJ(), "wenote/res");
        if (new File(file2, "WNNote.zip").exists()) {
            String absolutePath2 = file2.getAbsolutePath();
            AppMethodBeat.o(127422);
            return absolutePath2;
        }
        AppMethodBeat.o(127422);
        return "";
    }

    public static String cVi() {
        AppMethodBeat.i(127423);
        File file = new File(my(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(127423);
        return absolutePath;
    }

    public static String cVj() {
        AppMethodBeat.i(127424);
        StringBuilder sb = new StringBuilder();
        File file = new File(my(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        String sb2 = sb.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
        AppMethodBeat.o(127424);
        return sb2;
    }

    public static String cVk() {
        AppMethodBeat.i(127425);
        File file = new File(my(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(127425);
        return absolutePath;
    }

    public static String cVl() {
        AppMethodBeat.i(127426);
        File file = new File(my(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(127426);
        return absolutePath;
    }

    public static int bbw() {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(127427);
        try {
            fileInputStream = new FileInputStream(new File(cVh(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        int i2 = new JSONObject(str).getInt("version");
                        Log.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i2));
                        Util.qualityClose(fileInputStream);
                        AppMethodBeat.o(127427);
                        return i2;
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
                    Util.qualityClose(fileInputStream);
                    AppMethodBeat.o(127427);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(fileInputStream);
                    AppMethodBeat.o(127427);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            fileInputStream = null;
            Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(fileInputStream);
            AppMethodBeat.o(127427);
            return 1;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            Util.qualityClose(fileInputStream);
            AppMethodBeat.o(127427);
            throw th;
        }
    }

    public static int bbx() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(127428);
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                bufferedReader = null;
                inputStreamReader = null;
                try {
                    Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
                    Util.qualityClose(inputStream);
                    Util.qualityClose(inputStreamReader);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(127428);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    Util.qualityClose(inputStreamReader);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(127428);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStreamReader = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(127428);
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
                            Log.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str, Integer.valueOf(i2));
                            Util.qualityClose(inputStream);
                            Util.qualityClose(inputStreamReader);
                            Util.qualityClose(bufferedReader);
                            AppMethodBeat.o(127428);
                            return i2;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
                        Util.qualityClose(inputStream);
                        Util.qualityClose(inputStreamReader);
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(127428);
                        return 1;
                    }
                }
            } catch (Exception e5) {
                e2 = e5;
                bufferedReader = null;
                Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(127428);
                return 1;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                Util.qualityClose(inputStream);
                Util.qualityClose(inputStreamReader);
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(127428);
                throw th;
            }
        } catch (Exception e6) {
            e2 = e6;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(inputStream);
            Util.qualityClose(inputStreamReader);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(127428);
            return 1;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            Util.qualityClose(inputStream);
            Util.qualityClose(inputStreamReader);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(127428);
            throw th;
        }
    }
}
