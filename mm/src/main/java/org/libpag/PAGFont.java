package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.extra.tools.b;
import org.xmlpull.v1.XmlPullParser;

public class PAGFont {
    private static final String DefaultLanguage = "zh-Hans";
    private static final Pattern FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    private static final String[] FallbackFontFileNames = {"/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf"};
    private static final String SystemFontConfigPath_JellyBean = "/system/etc/fallback_fonts.xml";
    private static final String SystemFontConfigPath_Lollipop = "/system/etc/fonts.xml";
    private static final String SystemFontPath = "/system/fonts/";
    private static boolean systemFontLoaded = false;
    public String fontFamily = "";
    public String fontStyle = "";

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i2, String str2, String str3);

    public static native PAGFont RegisterFont(String str, int i2, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i2, int i3, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void nativeInit();

    public static PAGFont RegisterFont(String str) {
        AppMethodBeat.i(236864);
        PAGFont RegisterFont = RegisterFont(str, 0);
        AppMethodBeat.o(236864);
        return RegisterFont;
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        AppMethodBeat.i(236865);
        PAGFont RegisterFont = RegisterFont(assetManager, str, 0);
        AppMethodBeat.o(236865);
        return RegisterFont;
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i2) {
        AppMethodBeat.i(236866);
        PAGFont RegisterFont = RegisterFont(assetManager, str, i2, "", "");
        AppMethodBeat.o(236866);
        return RegisterFont;
    }

    public static PAGFont RegisterFont(String str, int i2) {
        AppMethodBeat.i(236867);
        PAGFont RegisterFont = RegisterFont(str, i2, "", "");
        AppMethodBeat.o(236867);
        return RegisterFont;
    }

    private static PAGFont RegisterFontBytes(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(236868);
        PAGFont RegisterFontBytes = RegisterFontBytes(bArr, i2, i3, "", "");
        AppMethodBeat.o(236868);
        return RegisterFontBytes;
    }

    public PAGFont() {
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    static {
        AppMethodBeat.i(236880);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236880);
    }

    /* access modifiers changed from: package-private */
    public static class FontConfig {
        String fileName;
        String language;
        int ttcIndex;
        int weight;

        private FontConfig() {
            this.language = "";
            this.fileName = "";
            this.ttcIndex = 0;
            this.weight = 400;
        }
    }

    private static FontConfig[] parseLollipop() {
        AppMethodBeat.i(236869);
        FontConfig[] fontConfigArr = new FontConfig[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(SystemFontConfigPath_Lollipop);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                fontConfigArr = readFamilies(newPullParser);
            } finally {
                fileInputStream.close();
                AppMethodBeat.o(236869);
            }
        } catch (IOException e2) {
            AppMethodBeat.o(236869);
        }
        return fontConfigArr;
    }

    private static FontConfig[] readFamilies(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(236870);
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    readFamily(xmlPullParser, arrayList);
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        FontConfig[] fontConfigArr = new FontConfig[arrayList.size()];
        arrayList.toArray(fontConfigArr);
        AppMethodBeat.o(236870);
        return fontConfigArr;
    }

    private static void readFamily(XmlPullParser xmlPullParser, ArrayList<FontConfig> arrayList) {
        FontConfig fontConfig;
        AppMethodBeat.i(236871);
        xmlPullParser.getAttributeValue(null, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList2.add(readFont(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            AppMethodBeat.o(236871);
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                fontConfig = null;
                break;
            }
            fontConfig = (FontConfig) it.next();
            if (fontConfig.weight == 400) {
                break;
            }
        }
        if (fontConfig == null) {
            fontConfig = (FontConfig) arrayList2.get(0);
        }
        if (!fontConfig.fileName.isEmpty()) {
            if (attributeValue == null) {
                attributeValue = "";
            }
            fontConfig.language = attributeValue;
            arrayList.add(fontConfig);
        }
        AppMethodBeat.o(236871);
    }

    private static FontConfig readFont(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(236872);
        FontConfig fontConfig = new FontConfig();
        String attributeValue = xmlPullParser.getAttributeValue(null, FirebaseAnalytics.b.INDEX);
        fontConfig.ttcIndex = attributeValue == null ? 0 : Integer.parseInt(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        fontConfig.weight = attributeValue2 == null ? 400 : Integer.parseInt(attributeValue2);
        StringBuilder sb = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                skip(xmlPullParser);
            }
        }
        fontConfig.fileName = SystemFontPath + FILENAME_WHITESPACE_PATTERN.matcher(sb).replaceAll("");
        AppMethodBeat.o(236872);
        return fontConfig;
    }

    private static void skip(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(236873);
        int i2 = 1;
        while (i2 > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i2++;
                    break;
                case 3:
                    i2--;
                    break;
            }
        }
        AppMethodBeat.o(236873);
    }

    private static FontConfig[] parseJellyBean() {
        AppMethodBeat.i(236874);
        FontConfig[] fontConfigArr = new FontConfig[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(SystemFontConfigPath_JellyBean);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                newPullParser.nextTag();
                fontConfigArr = readFamiliesJellyBean(newPullParser);
            } finally {
                fileInputStream.close();
                AppMethodBeat.o(236874);
            }
        } catch (IOException e2) {
            AppMethodBeat.o(236874);
        }
        return fontConfigArr;
    }

    private static FontConfig[] readFamiliesJellyBean(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(236875);
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                readFileset(xmlPullParser, arrayList);
                            } else {
                                skip(xmlPullParser);
                            }
                        }
                    }
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        FontConfig[] fontConfigArr = new FontConfig[arrayList.size()];
        arrayList.toArray(fontConfigArr);
        AppMethodBeat.o(236875);
        return fontConfigArr;
    }

    private static void readFileset(XmlPullParser xmlPullParser, ArrayList<FontConfig> arrayList) {
        FontConfig fontConfig;
        AppMethodBeat.i(236876);
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("file")) {
                    arrayList2.add(readFont(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            AppMethodBeat.o(236876);
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                fontConfig = null;
                break;
            }
            fontConfig = (FontConfig) it.next();
            if (fontConfig.weight == 400) {
                break;
            }
        }
        if (fontConfig == null) {
            fontConfig = (FontConfig) arrayList2.get(0);
        }
        if (!fontConfig.fileName.isEmpty()) {
            arrayList.add(fontConfig);
        }
        AppMethodBeat.o(236876);
    }

    private static FontConfig getFontByLanguage(FontConfig[] fontConfigArr, String str) {
        AppMethodBeat.i(236877);
        String lowerCase = str.toLowerCase();
        for (FontConfig fontConfig : fontConfigArr) {
            if (fontConfig.language.toLowerCase().equals(lowerCase)) {
                AppMethodBeat.o(236877);
                return fontConfig;
            }
        }
        AppMethodBeat.o(236877);
        return null;
    }

    private static void addFont(FontConfig fontConfig, ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        AppMethodBeat.i(236878);
        if (arrayList.contains(fontConfig.fileName)) {
            AppMethodBeat.o(236878);
        } else if (!new File(fontConfig.fileName).exists()) {
            AppMethodBeat.o(236878);
        } else {
            arrayList.add(fontConfig.fileName);
            arrayList2.add(Integer.valueOf(fontConfig.ttcIndex));
            AppMethodBeat.o(236878);
        }
    }

    public static void RegisterFallbackFonts() {
        int i2 = 0;
        AppMethodBeat.i(236879);
        if (systemFontLoaded) {
            AppMethodBeat.o(236879);
            return;
        }
        systemFontLoaded = true;
        FontConfig[] fontConfigArr = new FontConfig[0];
        if (new File(SystemFontConfigPath_Lollipop).exists()) {
            try {
                fontConfigArr = parseLollipop();
            } catch (Exception e2) {
            }
        } else {
            try {
                fontConfigArr = parseJellyBean();
            } catch (Exception e3) {
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FontConfig fontByLanguage = getFontByLanguage(fontConfigArr, DefaultLanguage);
        if (fontByLanguage != null) {
            addFont(fontByLanguage, arrayList, arrayList2);
        }
        String[] strArr = FallbackFontFileNames;
        for (String str : strArr) {
            FontConfig fontConfig = new FontConfig();
            fontConfig.fileName = str;
            addFont(fontConfig, arrayList, arrayList2);
        }
        for (FontConfig fontConfig2 : fontConfigArr) {
            addFont(fontConfig2, arrayList, arrayList2);
        }
        if (!arrayList.isEmpty()) {
            String[] strArr2 = new String[arrayList.size()];
            arrayList.toArray(strArr2);
            int[] iArr = new int[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                iArr[i2] = ((Integer) it.next()).intValue();
                i2++;
            }
            SetFallbackFontPaths(strArr2, iArr);
        }
        AppMethodBeat.o(236879);
    }
}
