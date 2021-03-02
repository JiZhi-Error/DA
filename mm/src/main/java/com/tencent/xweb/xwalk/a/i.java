package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;

public final class i {

    public static class a {
        public String originalFileName;
        public String patchFileName;
        public int type;

        public final String toString() {
            AppMethodBeat.i(157196);
            String str = "PluginPatchConfig type:" + this.type + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName;
            AppMethodBeat.o(157196);
            return str;
        }
    }

    public static List<a> ao(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        String substring;
        int i2;
        AppMethodBeat.i(157197);
        ArrayList arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        c.tryClose(bufferedReader);
                        AppMethodBeat.o(157197);
                        return arrayList;
                    } else if (!readLine.isEmpty()) {
                        if (readLine.startsWith("ADD:")) {
                            substring = readLine.substring(4);
                            i2 = 1;
                        } else if (readLine.startsWith("MOD:")) {
                            i2 = 2;
                            substring = readLine.substring(4);
                        } else if (readLine.startsWith("DEL:")) {
                            substring = readLine.substring(4);
                            i2 = 3;
                        } else {
                            Log.e("XWalkPluginPatchConfigP", "getPluginPatchConfigList unknown flag".concat(String.valueOf(readLine)));
                            c.tryClose(bufferedReader);
                            AppMethodBeat.o(157197);
                            return null;
                        }
                        String[] split = substring.split(",");
                        for (String str : split) {
                            if (str != null && !str.isEmpty()) {
                                a aVar = new a();
                                aVar.originalFileName = str;
                                aVar.type = i2;
                                if (i2 == 2) {
                                    aVar.patchFileName = aVar.originalFileName + ".patch";
                                }
                                Log.i("XWalkPluginPatchConfigP", "getPluginPatchConfigList config:" + aVar.toString());
                                arrayList.add(aVar);
                            }
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        Log.e("XWalkPluginPatchConfigP", "getPluginPatchConfigList error:" + e2.getMessage());
                        c.tryClose(bufferedReader);
                        AppMethodBeat.o(157197);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        c.tryClose(bufferedReader);
                        AppMethodBeat.o(157197);
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            bufferedReader = null;
            Log.e("XWalkPluginPatchConfigP", "getPluginPatchConfigList error:" + e2.getMessage());
            c.tryClose(bufferedReader);
            AppMethodBeat.o(157197);
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            c.tryClose(bufferedReader);
            AppMethodBeat.o(157197);
            throw th;
        }
    }
}
