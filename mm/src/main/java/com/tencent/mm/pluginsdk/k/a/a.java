package com.tencent.mm.pluginsdk.k.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] KaA = {"LDPI", "HDPI", "MDPI"};
    public boolean Kau;
    public boolean Kav;
    public int Kaw;
    public Rect Kax;
    public Rect Kay;
    public Map<String, String> Kaz;
    public String desc;
    public String device;
    public String endTime;
    public String iGx;
    public String id;
    public String platform;
    public String title;
    public String url;
    public int wnT;

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.device = str3;
        this.Kau = z;
        this.Kav = z2;
    }

    private boolean goe() {
        AppMethodBeat.i(31153);
        long nowMilliSecond = Util.nowMilliSecond();
        long j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        long j3 = 0;
        try {
            if (this.endTime != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.endTime).getTime();
            }
            if (this.iGx != null) {
                j3 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.iGx).getTime();
            }
            Log.d("MicroMsg.PushMessage", "CHECKTIME : [" + j3 + "," + j2 + "]");
            if (j2 <= nowMilliSecond) {
                AppMethodBeat.o(31153);
                return false;
            } else if (j3 > nowMilliSecond) {
                AppMethodBeat.o(31153);
                return false;
            } else {
                AppMethodBeat.o(31153);
                return true;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(31153);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(31154);
        String str = "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.device + (this.Kau ? ", closable" : "") + (this.Kav ? ", trans-closable" : "");
        AppMethodBeat.o(31154);
        return str;
    }

    public static String bek(String str) {
        String str2;
        AppMethodBeat.i(31155);
        EnumC2020a bel = bel(str);
        if (bel == EnumC2020a.ASSET) {
            AppMethodBeat.o(31155);
            return str;
        } else if (bel == EnumC2020a.DOWNLOAD) {
            if (str == null) {
                str2 = null;
            } else {
                int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
                    str2 = null;
                } else {
                    str2 = str.substring(lastIndexOf + 1);
                }
            }
            if (str2 == null) {
                AppMethodBeat.o(31155);
                return null;
            }
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            String sb2 = sb.append(c.aSY()).append(str2).toString();
            AppMethodBeat.o(31155);
            return sb2;
        } else {
            AppMethodBeat.o(31155);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.k.a.a$a  reason: collision with other inner class name */
    public enum EnumC2020a {
        ASSET,
        DOWNLOAD,
        ERROR;

        public static EnumC2020a valueOf(String str) {
            AppMethodBeat.i(31151);
            EnumC2020a aVar = (EnumC2020a) Enum.valueOf(EnumC2020a.class, str);
            AppMethodBeat.o(31151);
            return aVar;
        }

        static {
            AppMethodBeat.i(31152);
            AppMethodBeat.o(31152);
        }
    }

    public static EnumC2020a bel(String str) {
        AppMethodBeat.i(31156);
        if (str.indexOf("tips/") == 0) {
            EnumC2020a aVar = EnumC2020a.ASSET;
            AppMethodBeat.o(31156);
            return aVar;
        } else if (str.indexOf("weixin://") == 0) {
            EnumC2020a aVar2 = EnumC2020a.DOWNLOAD;
            AppMethodBeat.o(31156);
            return aVar2;
        } else {
            EnumC2020a aVar3 = EnumC2020a.ERROR;
            AppMethodBeat.o(31156);
            return aVar3;
        }
    }

    public static ArrayList<a> cm(Context context, String str) {
        HashSet hashSet;
        String str2;
        AppMethodBeat.i(31157);
        if (str == null || str.length() < 0) {
            AppMethodBeat.o(31157);
            return null;
        }
        String displaySizeType = BackwardSupportUtil.BitmapFactory.getDisplaySizeType(context);
        if (displaySizeType == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(displaySizeType);
            String displayDensityType = BackwardSupportUtil.BitmapFactory.getDisplayDensityType(context);
            Log.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(displayDensityType)));
            if (displayDensityType != null) {
                String[] split = displayDensityType.split("_");
                if (split == null || split.length < 2) {
                    str2 = null;
                } else {
                    str2 = split[0];
                }
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            AppMethodBeat.o(31157);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "tips", null);
        if (parseXml == null) {
            AppMethodBeat.o(31157);
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            String str3 = ".tips.tip" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (parseXml.get(str3) == null) {
                break;
            }
            String str4 = parseXml.get(str3 + ".$id");
            Log.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(str4)));
            String str5 = parseXml.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, parseXml.get(str3 + ".$device"), Util.nullAsTrue(Boolean.valueOf(parseXml.get(str3 + ".$enableclose"))), Util.nullAsTrue(Boolean.valueOf(parseXml.get(str3 + ".$transparentclose"))));
                int i3 = Util.getInt(parseXml.get(str3 + ".title.$x"), 0);
                int i4 = Util.getInt(parseXml.get(str3 + ".title.$y"), 0);
                int i5 = Util.getInt(parseXml.get(str3 + ".title.$width"), 0);
                int i6 = Util.getInt(parseXml.get(str3 + ".title.$font"), 0);
                int hex = Util.getHex(parseXml.get(str3 + ".title.$color"), 0);
                aVar.title = parseXml.get(str3 + ".title");
                aVar.Kaw = hex;
                aVar.Kax = new Rect(i3, i4, i5 + i3, i6 + i4);
                int i7 = Util.getInt(parseXml.get(str3 + ".description.$x"), 0);
                int i8 = Util.getInt(parseXml.get(str3 + ".description.$y"), 0);
                int i9 = Util.getInt(parseXml.get(str3 + ".description.$width"), 0);
                int i10 = Util.getInt(parseXml.get(str3 + ".description.$font"), 0);
                int hex2 = Util.getHex(parseXml.get(str3 + ".description.$color"), 0);
                aVar.desc = parseXml.get(str3 + ".description");
                aVar.wnT = hex2;
                aVar.Kay = new Rect(i7, i8, i9 + i7, i10 + i8);
                aVar.url = parseXml.get(str3 + ".url");
                aVar.iGx = parseXml.get(str3 + ".time.start");
                aVar.endTime = parseXml.get(str3 + ".time.end");
                Log.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.iGx + " end:" + aVar.endTime);
                HashMap hashMap = new HashMap();
                int i11 = 0;
                while (true) {
                    String str6 = str3 + ".images.image" + (i11 > 0 ? Integer.valueOf(i11) : "");
                    String str7 = parseXml.get(str6);
                    Log.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(str7)));
                    if (str7 == null) {
                        break;
                    }
                    String str8 = parseXml.get(str6 + ".$type");
                    if (hashSet.contains(str8)) {
                        hashMap.put(str8, str7);
                    }
                    i11++;
                }
                if (hashMap.size() > 0) {
                    aVar.Kaz = hashMap;
                }
                Log.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i2++;
        }
        Log.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            AppMethodBeat.o(31157);
            return arrayList;
        }
        AppMethodBeat.o(31157);
        return null;
    }

    public static void gof() {
        AppMethodBeat.i(31158);
        bg.aVF();
        c.azQ().set(8193, "");
        bg.aVF();
        c.azQ().set(8449, (Object) 0L);
        AppMethodBeat.o(31158);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r0.goe() != false) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.pluginsdk.k.a.a ix(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.k.a.a.ix(android.content.Context):com.tencent.mm.pluginsdk.k.a.a");
    }
}
