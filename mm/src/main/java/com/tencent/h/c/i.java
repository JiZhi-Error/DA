package com.tencent.h.c;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.wxmm.v2encoder;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static byte[] SpZ = {68, 70, 71, 35, 36, 37, 94, 35, 37, 36, 82, 71, 72, 82, 40, 38, 42, 77, 60, 62, 60};
    private static byte[] Sqa = {77, JceStruct.ZERO_TAG, 61, -119, 116, -43, 122, -45, 103, -63, -105, v2encoder.enumCODEC_vcodec2, 70, 121, -88, 42};
    private static byte[] Sqb = {-27, -63, 58, 27, 82, JceStruct.STRUCT_END, -15, -54, -59, -75, 1, 61, 125, 119, 90, -8};

    public interface a {
        byte[] cV(byte[] bArr);

        byte[] q(byte[] bArr, byte[] bArr2);

        byte[] readFile(String str);
    }

    static final class b extends JceStruct {
        static Map<String, String> Sqd;
        public Map<String, String> Sqc = null;

        public b() {
            AppMethodBeat.i(214646);
            Sqd = new HashMap();
            Sqd.put("", "");
            AppMethodBeat.o(214646);
        }

        @Override // com.qq.taf.jce.JceStruct
        public final void writeTo(JceOutputStream jceOutputStream) {
            AppMethodBeat.i(214647);
            jceOutputStream.write((Map) this.Sqc, 0);
            AppMethodBeat.o(214647);
        }

        @Override // com.qq.taf.jce.JceStruct
        public final void readFrom(JceInputStream jceInputStream) {
            AppMethodBeat.i(214648);
            this.Sqc = (Map) jceInputStream.read((Object) Sqd, 0, true);
            AppMethodBeat.o(214648);
        }
    }

    public static Map<String, String> a(a aVar) {
        AppMethodBeat.i(214649);
        ArrayList<String> arrayList = new ArrayList();
        String hpW = hpW();
        String b2 = b(aVar);
        String c2 = c(aVar);
        arrayList.add(hpW + b2 + c2);
        arrayList.add(hpW + c2);
        b bVar = new b();
        for (String str : arrayList) {
            try {
                bVar.readFrom(new JceInputStream(aVar.cV(aVar.q(aVar.readFile(str), SpZ))));
                if (bVar.Sqc.size() != 0) {
                    break;
                }
            } catch (Throwable th) {
            }
        }
        Map<String, String> map = bVar.Sqc;
        AppMethodBeat.o(214649);
        return map;
    }

    private static String hpV() {
        AppMethodBeat.i(214650);
        try {
            Class<?> cls = Class.forName("android.os.Environment$UserEnvironment");
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(Process.myUid() / 100000));
            Method method = cls.getMethod("getExternalStorageDirectory", new Class[0]);
            method.setAccessible(true);
            String absolutePath = ((File) method.invoke(newInstance, new Object[0])).getAbsolutePath();
            AppMethodBeat.o(214650);
            return absolutePath;
        } catch (Throwable th) {
            AppMethodBeat.o(214650);
            return "";
        }
    }

    private static String hpW() {
        AppMethodBeat.i(214651);
        String hpV = hpV();
        if (TextUtils.isEmpty(hpV)) {
            try {
                hpV = Environment.getExternalStorageDirectory().getAbsolutePath();
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(214651);
        return hpV;
    }

    private static String b(a aVar) {
        String str;
        AppMethodBeat.i(214652);
        try {
            str = new String(aVar.q(Sqa, SpZ), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Throwable th) {
            str = "";
        }
        AppMethodBeat.o(214652);
        return str;
    }

    private static String c(a aVar) {
        String str;
        AppMethodBeat.i(214653);
        try {
            str = new String(aVar.q(Sqb, SpZ), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Throwable th) {
            str = "";
        }
        AppMethodBeat.o(214653);
        return str;
    }
}
