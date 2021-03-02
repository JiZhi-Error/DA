package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class c {
    static List<String> z(File file) {
        AppMethodBeat.i(87624);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                AppMethodBeat.o(87624);
                return arrayList;
            }
        }
    }

    static File eV(String str) {
        AppMethodBeat.i(87625);
        File file = new File(str);
        if (file.exists()) {
            AppMethodBeat.o(87625);
        } else {
            if (!file.getParentFile().exists()) {
                eV(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
            AppMethodBeat.o(87625);
        }
        return file;
    }
}
