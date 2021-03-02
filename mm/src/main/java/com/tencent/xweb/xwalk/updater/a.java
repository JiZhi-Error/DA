package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkInitializer;

public final class a {

    public static class b {
        public String SID;
        public String SIJ;
        public f[] SIK;
        public a.C2231a[] SIL;
        public String signature;
    }

    public static class c {
        public String SID;
        public boolean SIE;
        public int SIM;
        public String SIw;
        public boolean bUseCdn;
    }

    public static class d {
        public String SID = "";
        public String SIJ = "";
        public a.C2231a[] SIL;
        public e[] SIN = null;
        public String signature;
    }

    public static class g {
        public String SIS = "";
    }

    /* renamed from: com.tencent.xweb.xwalk.updater.a$a  reason: collision with other inner class name */
    public static class C2237a {
        public a.b SCE = new a.c();
        public String SIA;
        public c[] SIB;
        public int SIC;
        public String SID;
        public boolean SIE;
        public boolean SIF;
        public String SIG;
        public String SIH;
        public String SII;
        public int SIv;
        public String SIw;
        public float SIx = -1.0f;
        public float SIy = -1.0f;
        public String SIz;
        public boolean bUseCdn;
        public int version;

        public C2237a() {
            AppMethodBeat.i(207346);
            AppMethodBeat.o(207346);
        }
    }

    public static class e extends C2237a {
        public String SIO = "";

        public e() {
            AppMethodBeat.i(154534);
            AppMethodBeat.o(154534);
        }
    }

    public static class f extends C2237a {
        public g SIP = new g();
        public boolean SIQ;
        public String SIR;
        public boolean bTryUseSharedCore = true;

        public f() {
            AppMethodBeat.i(154535);
            AppMethodBeat.o(154535);
        }
    }

    public static b bsS(String str) {
        AppMethodBeat.i(154536);
        if (str == null) {
            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
            AppMethodBeat.o(154536);
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
            AppMethodBeat.o(154536);
            return null;
        }
        b k = k(file, a(file, (int) file.length(), "<Versions>"));
        AppMethodBeat.o(154536);
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b3 A[SYNTHETIC, Splitter:B:44:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cb A[SYNTHETIC, Splitter:B:52:0x00cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r10, int r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.a.a(java.io.File, int, java.lang.String):java.lang.String");
    }

    private static int a(Element element, String str) {
        int i2 = 0;
        AppMethodBeat.i(154538);
        if (element == null) {
            AppMethodBeat.o(154538);
        } else {
            String attribute = element.getAttribute(str);
            if (attribute == null || attribute.isEmpty()) {
                AppMethodBeat.o(154538);
            } else {
                try {
                    i2 = Integer.parseInt(attribute);
                    AppMethodBeat.o(154538);
                } catch (Exception e2) {
                    Log.e("ConfigParser", "safeGetInt failed : " + e2.getMessage());
                    AppMethodBeat.o(154538);
                }
            }
        }
        return i2;
    }

    private static int b(Element element, String str) {
        int i2 = 0;
        AppMethodBeat.i(207347);
        if (element == null) {
            AppMethodBeat.o(207347);
        } else {
            String attribute = element.getAttribute(str);
            if (attribute == null || attribute.isEmpty()) {
                AppMethodBeat.o(207347);
            } else {
                if (attribute.contains("0x")) {
                    attribute = attribute.trim().substring(2);
                }
                try {
                    i2 = Integer.parseInt(attribute, 16);
                    AppMethodBeat.o(207347);
                } catch (Exception e2) {
                    Log.e("ConfigParser", "safeGetIntFromHex failed" + e2.getMessage());
                    AppMethodBeat.o(207347);
                }
            }
        }
        return i2;
    }

    private static double c(Element element, String str) {
        double d2 = -1.0d;
        AppMethodBeat.i(154539);
        if (element == null) {
            AppMethodBeat.o(154539);
        } else {
            String attribute = element.getAttribute(str);
            if (attribute == null || attribute.isEmpty()) {
                AppMethodBeat.o(154539);
            } else {
                try {
                    d2 = Double.parseDouble(attribute);
                    AppMethodBeat.o(154539);
                } catch (Exception e2) {
                    Log.e("ConfigParser", "safeGetDouble failed : " + e2.getMessage());
                    AppMethodBeat.o(154539);
                }
            }
        }
        return d2;
    }

    private static float d(Element element, String str) {
        float f2 = -1.0f;
        AppMethodBeat.i(207348);
        if (element == null) {
            AppMethodBeat.o(207348);
        } else {
            String attribute = element.getAttribute(str);
            if (attribute == null || attribute.isEmpty()) {
                AppMethodBeat.o(207348);
            } else {
                try {
                    f2 = Float.parseFloat(attribute);
                    AppMethodBeat.o(207348);
                } catch (Exception e2) {
                    Log.e("ConfigParser", "safeGetFloat failed : " + e2.getMessage());
                    AppMethodBeat.o(207348);
                }
            }
        }
        return f2;
    }

    private static boolean e(Element element, String str) {
        AppMethodBeat.i(154540);
        if (element == null) {
            AppMethodBeat.o(154540);
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            AppMethodBeat.o(154540);
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(attribute);
        AppMethodBeat.o(154540);
        return parseBoolean;
    }

    private static c[] a(Element element) {
        AppMethodBeat.i(154541);
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            AppMethodBeat.o(154541);
            return null;
        }
        c[] cVarArr = new c[elementsByTagName.getLength()];
        for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
            c cVar = new c();
            Element element2 = (Element) elementsByTagName.item(i2);
            cVar.SIw = element2.getAttribute("url");
            cVar.SIM = a(element2, "targetVersion");
            cVar.SID = element2.getAttribute("md5");
            cVar.SIE = e(element2, "useCellular");
            cVar.bUseCdn = e(element2, "useCdn");
            cVarArr[i2] = cVar;
        }
        AppMethodBeat.o(154541);
        return cVarArr;
    }

    private static a.C2231a[] b(Element element) {
        AppMethodBeat.i(154542);
        if (element == null) {
            AppMethodBeat.o(154542);
            return null;
        }
        try {
            NodeList elementsByTagName = element.getElementsByTagName("command");
            if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                a.C2231a[] aVarArr = new a.C2231a[elementsByTagName.getLength()];
                for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                    a.C2231a aVar = new a.C2231a();
                    Element element2 = (Element) elementsByTagName.item(i2);
                    aVar.SCF = element2.getAttribute("optype");
                    aVar.SCG = element2.getAttribute("opvalue");
                    aVar.SCH = element2.getAttribute("module");
                    a(aVar.SCE, element2);
                    aVarArr[i2] = aVar;
                }
                AppMethodBeat.o(154542);
                return aVarArr;
            }
        } catch (Exception e2) {
            Log.e("ConfigParser", "parseCmds failed: " + e2.getMessage());
        }
        AppMethodBeat.o(154542);
        return null;
    }

    private static void a(a.b bVar, Element element) {
        AppMethodBeat.i(154543);
        bVar.SCK = a(element, "apkMin");
        bVar.SCL = a(element, "apkMax");
        bVar.SCM = a(element, "preDownApkMin");
        bVar.SCN = a(element, "preDownApkMax");
        bVar.SCI = a(element, "sdkMin");
        bVar.SCJ = a(element, "sdkMax");
        bVar.SCO = a(element, "apiMin");
        bVar.SCP = a(element, "apiMax");
        bVar.SCQ = a(element, "targetApiMin");
        bVar.SCR = a(element, "targetApiMax");
        bVar.SCS = element.getAttribute("forbidDeviceRegex");
        bVar.SCT = element.getAttribute("whiteDeviceRegex");
        bVar.SDd = element.getAttribute("forbidAppRegex");
        bVar.SDe = element.getAttribute("whiteAppRegex");
        bVar.SCU = a(element, "grayMin");
        bVar.SCV = a(element, "grayMax");
        bVar.SCW = a(element, "dayGrayMin");
        bVar.SCX = a(element, "dayGrayMax");
        bVar.SCY = a(element, "chromeMin");
        bVar.SCZ = a(element, "chromeMax");
        bVar.SDa = a(element, "usertype");
        bVar.SDf = a(element, "x5sdkmin");
        bVar.SDg = a(element, "x5sdkmax");
        bVar.SDh = a(element, "x5coremin");
        bVar.SDi = a(element, "x5coremax");
        bVar.SDb = c(element, "hoursStart");
        bVar.SDc = c(element, "hoursEnd");
        bVar.SDk = element.getAttribute("runtimeAbis");
        bVar.SDm = element.getAttribute("blackRuntimeAbis");
        bVar.SDj = element.getAttribute("deviceAbis");
        bVar.SDl = element.getAttribute("blackDeviceAbis");
        bVar.SDn = b(element, "appClientVerMin");
        bVar.SDo = b(element, "appClientVerMax");
        bVar.SDp = element.getAttribute("appInfoWhiteList");
        bVar.SDq = element.getAttribute("appInfoBlackList");
        AppMethodBeat.o(154543);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e1 A[SYNTHETIC, Splitter:B:64:0x01e1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01fb A[SYNTHETIC, Splitter:B:72:0x01fb] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0215 A[SYNTHETIC, Splitter:B:80:0x0215] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0228 A[SYNTHETIC, Splitter:B:87:0x0228] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.xweb.xwalk.updater.a.b k(java.io.File r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 590
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.a.k(java.io.File, java.lang.String):com.tencent.xweb.xwalk.updater.a$b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b A[SYNTHETIC, Splitter:B:52:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b5 A[SYNTHETIC, Splitter:B:60:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01cf A[SYNTHETIC, Splitter:B:68:0x01cf] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01e2 A[SYNTHETIC, Splitter:B:75:0x01e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.xweb.xwalk.updater.a.d l(java.io.File r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 520
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.a.l(java.io.File, java.lang.String):com.tencent.xweb.xwalk.updater.a$d");
    }
}
