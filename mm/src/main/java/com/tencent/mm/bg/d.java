package com.tencent.mm.bg;

import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d implements i {
    public static int chatType = 0;
    private static final f<Integer, a> gAU = new h(5);
    private static d jlH;
    public boolean gYQ = false;
    private int jgF = 3;

    public static final class b {
        public int audioFormat = 0;
        public int jlA = 0;
        public String prefix = "";
        public int sampleRate = 0;
    }

    static {
        AppMethodBeat.i(148389);
        AppMethodBeat.o(148389);
    }

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int PP(String str) {
        int i2 = 5;
        AppMethodBeat.i(148383);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(148383);
        } else {
            if (str.startsWith(MStorageEventData.EventType.SINGLE)) {
            }
            if (str.startsWith("chatroom")) {
                i2 = 7;
            }
            if (str.startsWith("app")) {
                i2 = 8;
            }
            Log.d("upload", "type ".concat(String.valueOf(i2)));
            AppMethodBeat.o(148383);
        }
        return i2;
    }

    public static class a {
        public int fuA = 0;
        public String jlI = "BeiJing;GuangZhou;ShangHai;";
        public int jlJ = 0;
        public int jlK = 2;
        public int jlL = 2;
        public int jlM = 2;
        public int jlN = Task.EXTRAS_LIMIT_BYTES;
        public int jlO = 10240000;
        public int jlP = 100;
        public int jlQ = 100;
        public int jlR = 100;
        private Random jlS = new Random();
        public List<String> jlT = null;

        public a() {
            AppMethodBeat.i(148379);
            AppMethodBeat.o(148379);
        }

        public final boolean bfT() {
            String str;
            String[] split;
            AppMethodBeat.i(148380);
            as aUL = z.aUL();
            if ("  getRegionCode ".concat(String.valueOf(aUL)) != null) {
                str = aUL.fuO;
            } else {
                str = "";
            }
            Log.d("upload", str);
            String str2 = aUL.fuO;
            if (str2 != null && str2.length() > 0 && this.jlT != null && this.jlT.size() > 0 && (split = str2.split("_")) != null && split.length > 0) {
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2] != null && split[i2].length() > 0) {
                        for (String str3 : this.jlT) {
                            if (str3.trim().toLowerCase().equals(split[i2].trim().toLowerCase())) {
                                Log.d("upload", "isInRegion");
                                AppMethodBeat.o(148380);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            AppMethodBeat.o(148380);
            return false;
        }

        public final int getRate() {
            switch (d.chatType) {
                case 0:
                    return this.jlK;
                case 1:
                    return this.jlL;
                case 2:
                    return this.jlM;
                default:
                    return this.jlK;
            }
        }

        private int bfU() {
            switch (d.chatType) {
                case 0:
                    return this.jlP;
                case 1:
                    return this.jlQ;
                case 2:
                    return this.jlR;
                default:
                    return this.jlP;
            }
        }

        public final boolean bfV() {
            AppMethodBeat.i(148381);
            if (1 == g.B("EnableSpeexVoiceUpload", 0)) {
                AppMethodBeat.o(148381);
                return true;
            }
            Log.d("upload", "type " + d.chatType);
            int bfU = bfU();
            int rate = getRate();
            com.tencent.mm.kernel.g.aAi();
            Integer valueOf = Integer.valueOf(Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(16646145, (Object) null)));
            Log.d("upload", "daycount " + bfU() + "  count " + valueOf + " rate " + rate);
            if (valueOf.intValue() > bfU) {
                AppMethodBeat.o(148381);
                return false;
            } else if (rate == 0) {
                AppMethodBeat.o(148381);
                return false;
            } else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                AppMethodBeat.o(148381);
                return false;
            } else {
                com.tencent.mm.kernel.g.aAi();
                boolean z = this.fuA == 0 ? true : this.fuA == Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(12290, null), 0);
                Log.d("upload", "fitSex " + this.fuA + " " + z + " " + this.fuA);
                if (!z) {
                    AppMethodBeat.o(148381);
                    return false;
                } else if (!bfT()) {
                    AppMethodBeat.o(148381);
                    return false;
                } else {
                    int nextInt = this.jlS.nextInt(rate);
                    Log.d("upload", "luck ".concat(String.valueOf(nextInt)));
                    if (nextInt == rate / 2) {
                        AppMethodBeat.o(148381);
                        return true;
                    }
                    AppMethodBeat.o(148381);
                    return false;
                }
            }
        }

        public static a bfW() {
            String str;
            Object valueOf;
            Object valueOf2;
            AppMethodBeat.i(148382);
            Log.d("upload", "parseFromFile");
            String str2 = r.bes() + v.bev().dv(1, 9);
            int boW = (int) s.boW(str2);
            if (boW == -1) {
                Log.e("upload", "read file failed " + boW + str2);
                AppMethodBeat.o(148382);
                return null;
            }
            byte[] aW = s.aW(str2, 0, boW);
            if (aW == null) {
                Log.e("upload", "read file failed " + boW + str2);
                AppMethodBeat.o(148382);
                return null;
            }
            String str3 = new String(aW);
            if (Util.isNullOrNil(str3)) {
                AppMethodBeat.o(148382);
                return null;
            }
            int indexOf = str3.indexOf(60);
            if (indexOf > 0) {
                str = str3.substring(indexOf);
            } else {
                str = str3;
            }
            int hashCode = str.hashCode();
            a aVar = (a) d.gAU.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                AppMethodBeat.o(148382);
                return aVar;
            }
            Map<String, String> parseXml = XmlParser.parseXml(str, "Config", null);
            if (parseXml == null) {
                Log.e("upload", "parse msg failed");
                AppMethodBeat.o(148382);
                return null;
            }
            try {
                a aVar2 = new a();
                int i2 = 0;
                while (true) {
                    String str4 = parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".$key");
                    Log.d("upload", "key ".concat(String.valueOf(str4)));
                    if (str4 != null) {
                        if (str4.equals("region")) {
                            aVar2.jlI = parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                            if (aVar2.jlI != null && aVar2.jlI.length() > 0) {
                                String[] split = aVar2.jlI.split(";");
                                aVar2.jlT = new ArrayList();
                                if (split != null && split.length > 0) {
                                    for (int i3 = 0; i3 < split.length; i3++) {
                                        if (split[i3] != null && split[i3].length() > 0) {
                                            aVar2.jlT.add(split[i3]);
                                        }
                                    }
                                }
                            }
                        } else if (str4.equals("sex")) {
                            StringBuilder sb = new StringBuilder(".Config.Item");
                            if (i2 == 0) {
                                valueOf2 = "";
                            } else {
                                valueOf2 = Integer.valueOf(i2);
                            }
                            aVar2.fuA = Util.getInt(parseXml.get(sb.append(valueOf2).toString()), 0);
                        } else if (str4.equals("rate")) {
                            StringBuilder sb2 = new StringBuilder(".Config.Item");
                            if (i2 == 0) {
                                valueOf = "";
                            } else {
                                valueOf = Integer.valueOf(i2);
                            }
                            aVar2.jlJ = Util.getInt(parseXml.get(sb2.append(valueOf).toString()), 0);
                        } else if (str4.equals("minsize")) {
                            aVar2.jlN = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("maxsize")) {
                            aVar2.jlO = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("daycount_single")) {
                            aVar2.jlP = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("daycount_chatroom")) {
                            aVar2.jlQ = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("daycount_app")) {
                            aVar2.jlR = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("rate_single")) {
                            aVar2.jlK = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("rate_chatroom")) {
                            aVar2.jlL = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        } else if (str4.equals("rate_app")) {
                            aVar2.jlM = Util.getInt(parseXml.get(".Config.Item" + (i2 == 0 ? "" : Integer.valueOf(i2))), 0);
                        }
                        i2++;
                    } else {
                        Log.d("upload", "sex " + aVar2.fuA);
                        Log.d("upload", "rate_single " + aVar2.jlK);
                        Log.d("upload", "rate_chatroom " + aVar2.jlL);
                        Log.d("upload", "rate_app " + aVar2.jlM);
                        Log.d("upload", "rate " + aVar2.jlJ);
                        Log.d("upload", "minsize " + aVar2.jlN);
                        Log.d("upload", "maxsize " + aVar2.jlO);
                        Log.d("upload", "daycount_single " + aVar2.jlP);
                        Log.d("upload", "daycount_chatroom " + aVar2.jlQ);
                        Log.d("upload", "daycount_app " + aVar2.jlR);
                        Log.d("upload", "region " + aVar2.jlI);
                        d.gAU.x(Integer.valueOf(hashCode), aVar2);
                        AppMethodBeat.o(148382);
                        return aVar2;
                    }
                }
            } catch (Exception e2) {
                Log.e("upload", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(148382);
                return null;
            }
        }
    }

    public static d bfP() {
        AppMethodBeat.i(148384);
        if (jlH == null) {
            jlH = new d();
        }
        d dVar = jlH;
        AppMethodBeat.o(148384);
        return dVar;
    }

    public final void release() {
        AppMethodBeat.i(148385);
        this.gYQ = false;
        com.tencent.mm.kernel.g.azz().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        AppMethodBeat.o(148385);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(148386);
        if (!(qVar instanceof com.tencent.mm.ak.s) || ((com.tencent.mm.ak.s) qVar).aYR() != 9) {
            Log.d("upload", "another scene");
            AppMethodBeat.o(148386);
            return;
        }
        if (qVar.getType() == 159) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(81944, Long.valueOf(Util.nowSecond()));
            } else {
                int i4 = this.jgF - 1;
                this.jgF = i4;
                if (i4 < 0) {
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAh().azQ().set(81944, Long.valueOf(((Util.nowMilliSecond() - Util.MILLSECONDS_OF_DAY) + Util.MILLSECONDS_OF_HOUR) / 1000));
                    this.jgF = 3;
                }
            }
            release();
        }
        AppMethodBeat.o(148386);
    }

    public static void bfQ() {
        AppMethodBeat.i(148387);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(16646145, (Object) 0);
        AppMethodBeat.o(148387);
    }

    public static void bfR() {
        AppMethodBeat.i(148388);
        com.tencent.mm.kernel.g.aAi();
        Integer valueOf = Integer.valueOf(Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(16646145, (Object) null)));
        if (valueOf.intValue() < 0) {
            valueOf = 0;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.o(148388);
    }
}
