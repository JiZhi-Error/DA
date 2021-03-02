package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {

    /* access modifiers changed from: package-private */
    public enum a {
        GLOBAL(new String[0]),
        AWI(new String[0]),
        BACKGROUND(new String[0]),
        VOIP("VideoActivity", "VoipCSMainUI", "MultiTalkMainUI", "VoipScoreDialog"),
        SNS("Sns.*UI", "SnsOnlineVideoActivity"),
        FINDER("Finder.*UI"),
        ALBUM_GALLERY("AlbumPreviewUI", "ImagePreviewUI", "ImageGalleryUI"),
        STORY("Story.*UI"),
        RECORD("MMRecordUI");
        
        static final int AWQ = (Integer.MIN_VALUE >> values().length);
        List<String> AWR;
        int AWS = 0;
        int AWT = 0;
        int AWU = 0;
        int AWV = 0;
        int AWW = 0;
        boolean AWX = false;
        int type;

        /* renamed from: com.tencent.mm.plugin.performance.watchdogs.b$a$a  reason: collision with other inner class name */
        static class C1575a {
            static int AWZ = 0;
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(201131);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(201131);
            return aVar;
        }

        static {
            AppMethodBeat.i(201134);
            AppMethodBeat.o(201134);
        }

        private a(String... strArr) {
            AppMethodBeat.i(201132);
            int i2 = C1575a.AWZ;
            C1575a.AWZ = i2 + 1;
            this.type = Integer.MIN_VALUE >>> i2;
            this.AWR = Arrays.asList(strArr);
            AppMethodBeat.o(201132);
        }

        static a aKa(String str) {
            AppMethodBeat.i(201133);
            a[] values = values();
            for (a aVar : values) {
                for (String str2 : aVar.AWR) {
                    if (!aVar.AWX && str.matches(str2)) {
                        Log.d("MicroMsg.MemoryWatchDog.Reporter", "%s matches %s(%s)", str, str2, aVar.name());
                        AppMethodBeat.o(201133);
                        return aVar;
                    }
                }
            }
            AppMethodBeat.o(201133);
            return null;
        }

        static boolean Ur(int i2) {
            return ((AWQ ^ -1) & i2) != 0;
        }
    }

    private static int Uq(int i2) {
        if (i2 >= 102400) {
            return i2 < 204800 ? BuildInfo.IS_ARM64 ? 43 : 3 : i2 < 307200 ? BuildInfo.IS_ARM64 ? 44 : 4 : i2 < 409600 ? BuildInfo.IS_ARM64 ? 45 : 5 : i2 < 512000 ? BuildInfo.IS_ARM64 ? 46 : 6 : i2 < 614400 ? BuildInfo.IS_ARM64 ? 47 : 7 : i2 < 716800 ? BuildInfo.IS_ARM64 ? 48 : 8 : i2 < 819200 ? BuildInfo.IS_ARM64 ? 49 : 9 : i2 < 921600 ? BuildInfo.IS_ARM64 ? 50 : 10 : i2 < 1024000 ? BuildInfo.IS_ARM64 ? 51 : 11 : i2 < 1126400 ? BuildInfo.IS_ARM64 ? 52 : 12 : i2 < 1228800 ? BuildInfo.IS_ARM64 ? 53 : 13 : i2 < 1331200 ? BuildInfo.IS_ARM64 ? 54 : 14 : i2 < 1433600 ? BuildInfo.IS_ARM64 ? 55 : 15 : BuildInfo.IS_ARM64 ? 56 : 16;
        }
        if (BuildInfo.IS_ARM64) {
            return 42;
        }
        return 2;
    }

    private static ArrayList<IDKey> b(c.a aVar) {
        int i2;
        AppMethodBeat.i(201136);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(1308);
        iDKey.SetValue(1);
        iDKey.SetKey(BuildInfo.IS_ARM64 ? 1 : 0);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(1308);
        iDKey2.SetValue(1);
        iDKey2.SetKey(Uq(aVar.AXG));
        arrayList.add(iDKey2);
        h(aVar);
        String packageName = WeChatBrands.AppInfo.current().getPackageName();
        HashMap hashMap = new HashMap();
        hashMap.put(String.valueOf(packageName), 1595);
        hashMap.put(packageName + ":appbrand0", 1596);
        hashMap.put(packageName + ":appbrand1", 1596);
        hashMap.put(packageName + ":appbrand2", 1596);
        hashMap.put(packageName + ":appbrand3", 1596);
        hashMap.put(packageName + ":appbrand4", 1596);
        hashMap.put(packageName + ":tools", 1607);
        hashMap.put(packageName + ":toolsmp", 1598);
        hashMap.put(packageName + ":push", 1599);
        hashMap.put(packageName + ":hotpot..", 1600);
        hashMap.put(packageName + ":sandbox", 1601);
        hashMap.put(packageName + ":exdevice", 1610);
        c.a[] aVarArr = aVar.AXH;
        for (c.a aVar2 : aVarArr) {
            Integer num = (Integer) hashMap.remove(aVar2.processName);
            int intValue = num != null ? num.intValue() : 1602;
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "id = %s, process = %s", Integer.valueOf(intValue), aVar2.processName);
            arrayList.add(new IDKey(intValue, BuildInfo.IS_ARM64 ? 1 : 0, 1));
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(intValue);
            iDKey3.SetValue(1);
            iDKey3.SetKey(Uq(aVar2.AXF));
            arrayList.add(iDKey3);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "stub : id = %s, process = %s", entry.getValue(), entry.getKey());
            arrayList.add(new IDKey(((Integer) entry.getValue()).intValue(), BuildInfo.IS_ARM64 ? 1 : 0, 1));
            arrayList.add(new IDKey(((Integer) entry.getValue()).intValue(), BuildInfo.IS_ARM64 ? 57 : 17, 1));
        }
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(1308);
        iDKey4.SetValue(1);
        long j2 = aVar.AXE.availMem;
        if (j2 < DownloadHelper.SAVE_LENGTH) {
            if (BuildInfo.IS_ARM64) {
                i2 = 113;
            } else {
                i2 = 82;
            }
            iDKey4.SetKey(i2);
        } else if (j2 < 209715200) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 114 : 83);
        } else if (j2 < 314572800) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 115 : 84);
        } else if (j2 < 419430400) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 116 : 85);
        } else if (j2 < 524288000) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 117 : 86);
        } else if (j2 < 629145600) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 118 : 87);
        } else if (j2 < 734003200) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 119 : 88);
        } else if (j2 < 838860800) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 120 : 89);
        } else if (j2 < 943718400) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 121 : 90);
        } else if (j2 < 1048576000) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 122 : 91);
        } else if (j2 < 1572864000) {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 123 : 92);
        } else {
            iDKey4.SetKey(BuildInfo.IS_ARM64 ? 124 : 93);
        }
        arrayList.add(iDKey4);
        AppMethodBeat.o(201136);
        return arrayList;
    }

    private static boolean d(c.a aVar) {
        AppMethodBeat.i(201138);
        if (aVar.AXx - aVar.AXy > 262144000) {
            a.GLOBAL.AWS++;
            if (!aVar.AXs ? aVar.cPB : aVar.AXg) {
                a.AWI.AWS++;
            } else {
                a.BACKGROUND.AWS++;
            }
            a aKa = a.aKa(aVar.activity);
            if (aKa != null) {
                aKa.AWS++;
            }
            AppMethodBeat.o(201138);
            return true;
        }
        AppMethodBeat.o(201138);
        return false;
    }

    private static boolean e(c.a aVar) {
        AppMethodBeat.i(201139);
        if (aVar.AXv > 524288000) {
            a.GLOBAL.AWT++;
            if (!aVar.AXs ? aVar.cPB : aVar.AXg) {
                a.AWI.AWT++;
            } else {
                a.BACKGROUND.AWT++;
            }
            a aKa = a.aKa(aVar.activity);
            if (aKa != null) {
                aKa.AWT++;
            }
            AppMethodBeat.o(201139);
            return true;
        }
        AppMethodBeat.o(201139);
        return false;
    }

    private static boolean f(c.a aVar) {
        AppMethodBeat.i(201140);
        if (BuildInfo.IS_ARM64 || ((double) aVar.AXq) <= 3879731.2d) {
            AppMethodBeat.o(201140);
            return false;
        }
        a.GLOBAL.AWU++;
        if (!aVar.AXs ? aVar.cPB : aVar.AXg) {
            a.AWI.AWU++;
        } else {
            a.BACKGROUND.AWU++;
        }
        a aKa = a.aKa(aVar.activity);
        if (aKa != null) {
            aKa.AWU++;
        }
        AppMethodBeat.o(201140);
        return true;
    }

    private static boolean g(c.a aVar) {
        AppMethodBeat.i(201141);
        if (aVar.AXF > 1024000) {
            a.GLOBAL.AWV++;
            if (!aVar.AXs ? aVar.cPB : aVar.AXg) {
                a.AWI.AWV++;
            } else {
                a.BACKGROUND.AWV++;
            }
            a aKa = a.aKa(aVar.activity);
            if (aKa != null) {
                aKa.AWV++;
            }
            AppMethodBeat.o(201141);
            return true;
        }
        AppMethodBeat.o(201141);
        return false;
    }

    private static boolean h(c.a aVar) {
        AppMethodBeat.i(201142);
        if (aVar.AXG > 2097152) {
            a.GLOBAL.AWW++;
            if (!aVar.AXs ? aVar.cPB : aVar.AXg) {
                a.AWI.AWW++;
            } else {
                a.BACKGROUND.AWW++;
            }
            a aKa = a.aKa(aVar.activity);
            if (aKa != null) {
                aKa.AWW++;
            }
            AppMethodBeat.o(201142);
            return true;
        }
        AppMethodBeat.o(201142);
        return false;
    }

    public static void a(int i2, long j2, long j3, long j4, long j5, long j6, String str, int i3, long j7, long j8, long j9, long j10) {
        AppMethodBeat.i(201143);
        e eVar = e.INSTANCE;
        Object[] objArr = new Object[14];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = MMApplicationContext.getProcessName();
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(j3);
        objArr[4] = Long.valueOf(j4);
        objArr[5] = Long.valueOf(j5);
        objArr[6] = Long.valueOf(j6);
        objArr[7] = str;
        objArr[8] = Integer.valueOf(i3);
        objArr[9] = Long.valueOf(j7);
        objArr[10] = Long.valueOf(j8);
        objArr[11] = Integer.valueOf(BuildInfo.IS_ARM64 ? 1 : 2);
        objArr[12] = Long.valueOf(j9);
        objArr[13] = Long.valueOf(j10);
        eVar.a(20731, objArr);
        AppMethodBeat.o(201143);
    }

    public static void a(c.a aVar, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(201135);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(959);
        iDKey.SetValue(1);
        if (aVar.AXx - aVar.AXy < DownloadHelper.SAVE_LENGTH) {
            iDKey.SetKey(120);
        } else if (aVar.AXx - aVar.AXy < 209715200) {
            iDKey.SetKey(121);
        } else if (aVar.AXx - aVar.AXy < 314572800) {
            iDKey.SetKey(122);
        } else if (aVar.AXx - aVar.AXy < 419430400) {
            iDKey.SetKey(123);
        } else if (aVar.AXx - aVar.AXy < 524288000) {
            iDKey.SetKey(124);
        } else if (aVar.AXx - aVar.AXy < 629145600) {
            iDKey.SetKey(125);
        } else if (aVar.AXx - aVar.AXy < 734003200) {
            iDKey.SetKey(126);
        } else if (aVar.AXx - aVar.AXy < 838860800) {
            iDKey.SetKey(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        } else {
            iDKey.SetKey(128);
        }
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(959);
        iDKey2.SetValue(1);
        if (aVar.AXv < DownloadHelper.SAVE_LENGTH) {
            iDKey2.SetKey(TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
        } else if (aVar.AXv < 209715200) {
            iDKey2.SetKey(132);
        } else if (aVar.AXv < 314572800) {
            iDKey2.SetKey(133);
        } else if (aVar.AXv < 419430400) {
            iDKey2.SetKey(g.CTRL_INDEX);
        } else if (aVar.AXv < 524288000) {
            iDKey2.SetKey(com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX);
        } else if (aVar.AXv < 629145600) {
            iDKey2.SetKey(r.CTRL_INDEX);
        } else if (aVar.AXv < 734003200) {
            iDKey2.SetKey(137);
        } else if (aVar.AXv < 838860800) {
            iDKey2.SetKey(138);
        } else {
            iDKey2.SetKey(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
        }
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(959);
        iDKey3.SetValue(1);
        if (aVar.AXq < 2097152) {
            iDKey3.SetKey(TbsListener.ErrorCode.NEEDDOWNLOAD_3);
        } else if (((float) aVar.AXq) < 2516582.5f) {
            iDKey3.SetKey(TbsListener.ErrorCode.NEEDDOWNLOAD_4);
        } else if (((float) aVar.AXq) < 2936012.8f) {
            iDKey3.SetKey(144);
        } else if (((float) aVar.AXq) < 3145728.0f) {
            iDKey3.SetKey(145);
        } else if (((float) aVar.AXq) < 3565158.5f) {
            iDKey3.SetKey(146);
        } else if (((float) aVar.AXq) < 3984588.8f) {
            iDKey3.SetKey(TbsListener.ErrorCode.NEEDDOWNLOAD_8);
        } else {
            iDKey3.SetKey(148);
        }
        if (((float) aVar.AXq) >= 3858759.8f) {
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(959);
            iDKey4.SetValue(1);
            iDKey4.SetKey(149);
            arrayList.add(iDKey4);
        }
        arrayList.add(iDKey3);
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(959);
        iDKey5.SetValue(1);
        iDKey5.SetKey(151);
        arrayList.add(iDKey5);
        e.INSTANCE.b(arrayList, false);
        c(aVar);
        ArrayList<IDKey> arrayList2 = new ArrayList<>();
        if (MMApplicationContext.isMainProcess()) {
            i2 = 10;
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            i2 = 20;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 30;
        } else {
            i2 = 0;
        }
        IDKey iDKey6 = new IDKey();
        iDKey6.SetID(1031);
        iDKey6.SetKey(i2);
        iDKey6.SetValue(((aVar.AXx - aVar.AXy) / 1024) / 1024);
        arrayList2.add(iDKey6);
        IDKey iDKey7 = new IDKey();
        iDKey7.SetID(1031);
        iDKey7.SetKey(i2 + 1);
        iDKey7.SetValue((aVar.AXv / 1024) / 1024);
        arrayList2.add(iDKey7);
        IDKey iDKey8 = new IDKey();
        iDKey8.SetID(1031);
        iDKey8.SetKey(i2 + 2);
        iDKey8.SetValue(1);
        arrayList2.add(iDKey8);
        e.INSTANCE.b(arrayList2, false);
        if (MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "reportPreloadProcessMemory: hasActivity = %s", Boolean.valueOf(z));
            if (MMApplicationContext.isAppBrandProcess()) {
                i3 = 1462;
            } else if (MMApplicationContext.isToolsProcess()) {
                i3 = 1463;
            } else if (MMApplicationContext.isToolsMpProcess()) {
                i3 = 1464;
            } else {
                i3 = -1;
            }
            if (i3 > 0) {
                ArrayList<IDKey> arrayList3 = new ArrayList<>();
                arrayList3.add(new IDKey(i3, 0, 1));
                arrayList3.add(new IDKey(i3, z ? 1 : 2, 1));
                long j2 = aVar.AXx - aVar.AXy;
                IDKey iDKey9 = new IDKey();
                iDKey9.SetID(i3);
                iDKey9.SetValue(1);
                if (j2 < 52428800) {
                    if (z) {
                        i7 = 3;
                    } else {
                        i7 = 16;
                    }
                    iDKey9.SetKey(i7);
                } else if (j2 < DownloadHelper.SAVE_LENGTH) {
                    iDKey9.SetKey(z ? 4 : 17);
                } else if (j2 < 209715200) {
                    iDKey9.SetKey(z ? 5 : 18);
                } else if (j2 < 314572800) {
                    iDKey9.SetKey(z ? 6 : 19);
                } else if (j2 < 419430400) {
                    iDKey9.SetKey(z ? 7 : 20);
                } else if (j2 < 524288000) {
                    iDKey9.SetKey(z ? 8 : 21);
                } else if (j2 < 629145600) {
                    iDKey9.SetKey(z ? 9 : 22);
                } else if (j2 < 734003200) {
                    iDKey9.SetKey(z ? 10 : 23);
                } else if (j2 < 838860800) {
                    iDKey9.SetKey(z ? 11 : 24);
                } else if (j2 < 943718400) {
                    iDKey9.SetKey(z ? 12 : 25);
                } else if (j2 < 1048576000) {
                    iDKey9.SetKey(z ? 13 : 26);
                } else {
                    iDKey9.SetKey(z ? 14 : 27);
                }
                arrayList3.add(iDKey9);
                long j3 = aVar.AXv;
                IDKey iDKey10 = new IDKey();
                iDKey10.SetID(i3);
                iDKey10.SetValue(1);
                if (j3 < DownloadHelper.SAVE_LENGTH) {
                    if (z) {
                        i6 = 55;
                    } else {
                        i6 = 69;
                    }
                    iDKey10.SetKey(i6);
                } else if (j3 < 209715200) {
                    iDKey10.SetKey(z ? 56 : 70);
                } else if (j3 < 314572800) {
                    iDKey10.SetKey(z ? 57 : 71);
                } else if (j3 < 419430400) {
                    iDKey10.SetKey(z ? 58 : 72);
                } else if (j3 < 524288000) {
                    iDKey10.SetKey(z ? 59 : 73);
                } else if (j3 < 629145600) {
                    iDKey10.SetKey(z ? 60 : 74);
                } else if (j3 < 734003200) {
                    iDKey10.SetKey(z ? 61 : 75);
                } else if (j3 < 838860800) {
                    iDKey10.SetKey(z ? 62 : 76);
                } else if (j3 < 943718400) {
                    iDKey10.SetKey(z ? 63 : 77);
                } else if (j3 < 1048576000) {
                    iDKey10.SetKey(z ? 64 : 78);
                } else {
                    iDKey10.SetKey(z ? 65 : 79);
                }
                arrayList3.add(iDKey10);
                if (!BuildInfo.IS_ARM64) {
                    IDKey iDKey11 = new IDKey();
                    iDKey11.SetID(i3);
                    iDKey11.SetValue(1);
                    long j4 = (long) aVar.AXq;
                    if (((double) j4) < 1572864.0d) {
                        if (z) {
                            i5 = 111;
                        } else {
                            i5 = 118;
                        }
                        iDKey11.SetKey(i5);
                    } else if (j4 < 2097152) {
                        iDKey11.SetKey(z ? 112 : 119);
                    } else if (((double) j4) < 2621440.0d) {
                        iDKey11.SetKey(z ? 113 : 120);
                    } else if (j4 < 3145728) {
                        iDKey11.SetKey(z ? 114 : 121);
                    } else if (((double) j4) < 3670016.0d) {
                        iDKey11.SetKey(z ? 115 : 122);
                    } else {
                        iDKey11.SetKey(z ? 116 : 123);
                    }
                    arrayList3.add(iDKey11);
                }
                IDKey iDKey12 = new IDKey();
                iDKey12.SetID(i3);
                iDKey12.SetValue(1);
                int i8 = aVar.AXF;
                if (i8 < 102400) {
                    if (z) {
                        i4 = com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX;
                    } else {
                        i4 = 153;
                    }
                    iDKey12.SetKey(i4);
                } else if (i8 < 204800) {
                    iDKey12.SetKey(z ? 140 : 154);
                } else if (i8 < 307200) {
                    iDKey12.SetKey(z ? 141 : 155);
                } else if (i8 < 409600) {
                    iDKey12.SetKey(z ? TbsListener.ErrorCode.NEEDDOWNLOAD_3 : 156);
                } else if (i8 < 512000) {
                    iDKey12.SetKey(z ? TbsListener.ErrorCode.NEEDDOWNLOAD_4 : 157);
                } else if (i8 < 614400) {
                    iDKey12.SetKey(z ? 144 : 158);
                } else if (i8 < 716800) {
                    iDKey12.SetKey(z ? 145 : JsApiGetBackgroundAudioState.CTRL_INDEX);
                } else if (i8 < 819200) {
                    iDKey12.SetKey(z ? 146 : 160);
                } else if (i8 < 921600) {
                    iDKey12.SetKey(z ? TbsListener.ErrorCode.NEEDDOWNLOAD_8 : 161);
                } else if (i8 < 1024000) {
                    iDKey12.SetKey(z ? 148 : TbsListener.ErrorCode.STARTDOWNLOAD_3);
                } else {
                    iDKey12.SetKey(z ? 149 : TbsListener.ErrorCode.STARTDOWNLOAD_4);
                }
                arrayList3.add(iDKey12);
                e.INSTANCE.b(arrayList3, false);
            }
        }
        AppMethodBeat.o(201135);
    }

    private static void c(c.a aVar) {
        int i2;
        int i3;
        AppMethodBeat.i(201137);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 1161;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 1162;
        } else if (MMApplicationContext.isToolsProcess()) {
            i2 = 1163;
        } else if (MMApplicationContext.isPushProcess()) {
            i2 = 1164;
        } else if (MMApplicationContext.isToolsMpProcess()) {
            i2 = 1165;
        } else {
            i2 = -1;
        }
        if (i2 <= 0) {
            AppMethodBeat.o(201137);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(i2);
        iDKey.SetValue(1);
        iDKey.SetKey(0);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetValue(1);
        iDKey2.SetKey(BuildInfo.IS_ARM64 ? 254 : 255);
        arrayList.add(iDKey2);
        long j2 = aVar.AXx - aVar.AXy;
        d(aVar);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(i2);
        iDKey3.SetValue(1);
        if (j2 < DownloadHelper.SAVE_LENGTH) {
            iDKey3.SetKey(1);
        } else if (j2 < 209715200) {
            iDKey3.SetKey(2);
        } else if (j2 < 314572800) {
            iDKey3.SetKey(3);
        } else if (j2 < 419430400) {
            iDKey3.SetKey(4);
        } else if (j2 < 524288000) {
            iDKey3.SetKey(5);
        } else if (j2 < 629145600) {
            iDKey3.SetKey(6);
        } else if (j2 < 734003200) {
            iDKey3.SetKey(7);
        } else if (j2 < 838860800) {
            iDKey3.SetKey(8);
        } else if (j2 < 943718400) {
            iDKey3.SetKey(9);
        } else if (j2 < 1048576000) {
            iDKey3.SetKey(10);
        } else {
            iDKey3.SetKey(11);
        }
        arrayList.add(iDKey3);
        long j3 = aVar.AXv;
        e(aVar);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(i2);
        iDKey4.SetValue(1);
        if (j3 < DownloadHelper.SAVE_LENGTH) {
            iDKey4.SetKey(33);
        } else if (j3 < 209715200) {
            iDKey4.SetKey(34);
        } else if (j3 < 314572800) {
            iDKey4.SetKey(35);
        } else if (j3 < 419430400) {
            iDKey4.SetKey(36);
        } else if (j3 < 524288000) {
            iDKey4.SetKey(37);
        } else if (j3 < 629145600) {
            iDKey4.SetKey(38);
        } else if (j3 < 734003200) {
            iDKey4.SetKey(39);
        } else if (j3 < 838860800) {
            iDKey4.SetKey(40);
        } else if (j3 < 943718400) {
            iDKey4.SetKey(41);
        } else if (j3 < 1048576000) {
            iDKey4.SetKey(42);
        } else {
            iDKey4.SetKey(43);
        }
        arrayList.add(iDKey4);
        long j4 = (long) aVar.AXq;
        f(aVar);
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(i2);
        iDKey5.SetValue(1);
        if (((double) j4) < 1572864.0d) {
            iDKey5.SetKey(65);
        } else if (j4 < 2097152) {
            iDKey5.SetKey(66);
        } else if (((double) j4) < 2621440.0d) {
            iDKey5.SetKey(67);
        } else if (j4 < 3145728) {
            iDKey5.SetKey(68);
        } else if (((double) j4) < 3670016.0d) {
            iDKey5.SetKey(69);
        } else if (j4 < 4194304) {
            iDKey5.SetKey(70);
        } else if (((double) j4) < 4718592.0d) {
            iDKey5.SetKey(71);
        } else if (j4 < 5242880) {
            iDKey5.SetKey(72);
        } else if (((double) j4) < 5767168.0d) {
            iDKey5.SetKey(73);
        } else if (((double) j4) < 6291456.0d) {
            iDKey5.SetKey(74);
        } else if (((double) j4) < 6815744.0d) {
            iDKey5.SetKey(75);
        } else if (((double) j4) < 7340032.0d) {
            iDKey5.SetKey(76);
        } else if (((double) j4) < 7864320.0d) {
            iDKey5.SetKey(77);
        } else if (((double) j4) < 8388608.0d) {
            iDKey5.SetKey(78);
        } else if (((double) j4) < 8912896.0d) {
            iDKey5.SetKey(79);
        } else if (((double) j4) < 9437184.0d) {
            iDKey5.SetKey(80);
        } else if (((double) j4) < 9961472.0d) {
            iDKey5.SetKey(81);
        } else if (j4 < 10485760) {
            iDKey5.SetKey(82);
        } else {
            iDKey5.SetKey(83);
        }
        arrayList.add(iDKey5);
        int i4 = aVar.AXF;
        g(aVar);
        IDKey iDKey6 = new IDKey();
        iDKey6.SetID(i2);
        iDKey6.SetValue(1);
        if (i4 < 102400) {
            if (BuildInfo.IS_ARM64) {
                i3 = 154;
            } else {
                i3 = 122;
            }
            iDKey6.SetKey(i3);
        } else if (i4 < 204800) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 155 : 123);
        } else if (i4 < 307200) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 156 : 124);
        } else if (i4 < 409600) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 157 : 125);
        } else if (i4 < 512000) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 158 : 126);
        } else if (i4 < 614400) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? JsApiGetBackgroundAudioState.CTRL_INDEX : TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        } else if (i4 < 716800) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 160 : 128);
        } else if (i4 < 819200) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? 161 : 129);
        } else if (i4 < 921600) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? TbsListener.ErrorCode.STARTDOWNLOAD_3 : 130);
        } else if (i4 < 1024000) {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? TbsListener.ErrorCode.STARTDOWNLOAD_4 : TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
        } else {
            iDKey6.SetKey(BuildInfo.IS_ARM64 ? TbsListener.ErrorCode.STARTDOWNLOAD_5 : 132);
        }
        arrayList.add(iDKey6);
        if (MMApplicationContext.isMainProcess()) {
            arrayList.addAll(b(aVar));
        }
        e.INSTANCE.b(arrayList, false);
        long j5 = -1;
        long j6 = -1;
        if (aVar.map != null) {
            j5 = Util.getLong(aVar.map.get("summary.system"), -1);
            j6 = Util.getLong(aVar.map.get("summary.graphics"), -1);
        }
        Log.i("MicroMsg.MemoryWatchDog.Reporter", "systemPss = %d, graphics = %d", Long.valueOf(j5), Long.valueOf(j6));
        int i5 = 0;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        a[] values = a.values();
        for (a aVar2 : values) {
            if (aVar2.AWS >= 3) {
                aVar2.type |= 1;
            }
            if (aVar2.AWT >= 3) {
                aVar2.type |= 2;
            }
            if (aVar2.AWU >= 3) {
                aVar2.type |= 4;
            }
            if (aVar2.AWV >= 3) {
                aVar2.type |= 8;
            }
            if (aVar2.AWW >= 3) {
                aVar2.type |= 16;
            }
            int i6 = aVar2.type;
            if (a.Ur(i6) && !aVar2.AWX) {
                if ((i6 & 16) == 16 && !z) {
                    sb.append("allProcess:");
                    c.a[] aVarArr = aVar.AXH;
                    for (c.a aVar3 : aVarArr) {
                        sb.append(aVar3.pid).append("-").append(aVar3.processName).append("-pss:").append(aVar3.AXF).append(";");
                    }
                    z = true;
                }
                i5 |= (aVar.AXr.isEmpty() ? 0 : 256) | i6 | (d(aVar) ? 1 : 0) | (e(aVar) ? 2 : 0) | (f(aVar) ? 4 : 0) | (g(aVar) ? 8 : 0) | (h(aVar) ? 16 : 0);
                aVar2.AWX = true;
            }
        }
        if (a.Ur(i5)) {
            a(i5, j2, j3, j4, (long) i4, (long) aVar.AXG, sb.toString(), -1, j5, j6, aVar.AXD, aVar.AXE.totalMem);
        }
        AppMethodBeat.o(201137);
    }
}
