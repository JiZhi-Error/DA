package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KFileService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class KindaFileServiceImpl implements KFileService {
    @Override // com.tencent.kinda.gen.KFileService
    public byte[] getData(String str) {
        AppMethodBeat.i(18425);
        byte[] bArr = new byte[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(MMApplicationContext.getContext().getAssets().open("kinda-strings/".concat(String.valueOf(str))), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            bArr = sb2.getBytes();
            Log.d("kinda KindaFileServiceImpl", "读取kinda的字符串资源文件结果是：".concat(String.valueOf(sb2)));
        } catch (IOException e2) {
            Log.e("kinda KindaFileServiceImpl", "kinda打开json资源文件时出错，错误信息是：" + e2.getMessage());
        }
        AppMethodBeat.o(18425);
        return bArr;
    }
}
