package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.c.a;

public final class b {
    public static final String UeV = ".";
    public static final String UeW = "$";
    private static final Map UeX;
    private static final Map UeY = new HashMap();
    private static final Map UeZ = new HashMap();
    private static final Map Ufa = new HashMap();
    static Class Ufb;
    static Class Ufc;
    static Class Ufd;
    static Class Ufe;
    static Class Uff;
    static Class Ufg;
    static Class Ufh;
    static Class Ufi;

    static {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        AppMethodBeat.i(40703);
        HashMap hashMap = new HashMap();
        UeX = hashMap;
        Class cls9 = Boolean.TYPE;
        if (Ufb == null) {
            cls = bvc("java.lang.Boolean");
            Ufb = cls;
        } else {
            cls = Ufb;
        }
        hashMap.put(cls9, cls);
        Map map = UeX;
        Class cls10 = Byte.TYPE;
        if (Ufc == null) {
            cls2 = bvc("java.lang.Byte");
            Ufc = cls2;
        } else {
            cls2 = Ufc;
        }
        map.put(cls10, cls2);
        Map map2 = UeX;
        Class cls11 = Character.TYPE;
        if (Ufd == null) {
            cls3 = bvc("java.lang.Character");
            Ufd = cls3;
        } else {
            cls3 = Ufd;
        }
        map2.put(cls11, cls3);
        Map map3 = UeX;
        Class cls12 = Short.TYPE;
        if (Ufe == null) {
            cls4 = bvc("java.lang.Short");
            Ufe = cls4;
        } else {
            cls4 = Ufe;
        }
        map3.put(cls12, cls4);
        Map map4 = UeX;
        Class cls13 = Integer.TYPE;
        if (Uff == null) {
            cls5 = bvc("java.lang.Integer");
            Uff = cls5;
        } else {
            cls5 = Uff;
        }
        map4.put(cls13, cls5);
        Map map5 = UeX;
        Class cls14 = Long.TYPE;
        if (Ufg == null) {
            cls6 = bvc("java.lang.Long");
            Ufg = cls6;
        } else {
            cls6 = Ufg;
        }
        map5.put(cls14, cls6);
        Map map6 = UeX;
        Class cls15 = Double.TYPE;
        if (Ufh == null) {
            cls7 = bvc("java.lang.Double");
            Ufh = cls7;
        } else {
            cls7 = Ufh;
        }
        map6.put(cls15, cls7);
        Map map7 = UeX;
        Class cls16 = Float.TYPE;
        if (Ufi == null) {
            cls8 = bvc("java.lang.Float");
            Ufi = cls8;
        } else {
            cls8 = Ufi;
        }
        map7.put(cls16, cls8);
        Map map8 = UeX;
        Class cls17 = Void.TYPE;
        map8.put(cls17, cls17);
        for (Class cls18 : UeX.keySet()) {
            Class cls19 = (Class) UeX.get(cls18);
            if (!cls18.equals(cls19)) {
                UeY.put(cls19, cls18);
            }
        }
        oI("int", "I");
        oI(DownloadSetting.TYPE_BOOLEAN, "Z");
        oI("float", "F");
        oI("long", "J");
        oI("short", "S");
        oI("byte", "B");
        oI("double", QLog.TAG_REPORTLEVEL_DEVELOPER);
        oI("char", "C");
        AppMethodBeat.o(40703);
    }

    private static Class bvc(String str) {
        AppMethodBeat.i(40702);
        try {
            Class<?> cls = Class.forName(str);
            AppMethodBeat.o(40702);
            return cls;
        } catch (ClassNotFoundException e2) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e2.getMessage());
            AppMethodBeat.o(40702);
            throw noClassDefFoundError;
        }
    }

    private static void oI(String str, String str2) {
        AppMethodBeat.i(40700);
        UeZ.put(str, str2);
        Ufa.put(str2, str);
        AppMethodBeat.o(40700);
    }

    public static String bE(Class cls) {
        int i2 = 0;
        AppMethodBeat.i(40701);
        if (cls == null) {
            AppMethodBeat.o(40701);
            return "";
        }
        String name = cls.getName();
        if (name == null) {
            AppMethodBeat.o(40701);
            return "";
        } else if (name.length() == 0) {
            AppMethodBeat.o(40701);
            return "";
        } else {
            a aVar = new a();
            if (name.startsWith("[")) {
                while (name.charAt(0) == '[') {
                    name = name.substring(1);
                    aVar.bvo("[]");
                }
                if (name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                    name = name.substring(1, name.length() - 1);
                }
            }
            if (Ufa.containsKey(name)) {
                name = (String) Ufa.get(name);
            }
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf != -1) {
                i2 = lastIndexOf + 1;
            }
            int indexOf = name.indexOf(36, i2);
            String substring = name.substring(lastIndexOf + 1);
            if (indexOf != -1) {
                substring = substring.replace('$', '.');
            }
            String stringBuffer = new StringBuffer().append(substring).append(aVar).toString();
            AppMethodBeat.o(40701);
            return stringBuffer;
        }
    }
}
