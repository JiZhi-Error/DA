package com.tencent.mm.plugin.hardcoder;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.co;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.e;
import com.tencent.mm.hardcoder.h;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.hardcoder.j;
import com.tencent.mm.hardcoder.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class a implements e.a, h.a {
    private static String yiZ = null;
    private static Long yja = null;
    public static boolean yjb = false;
    private static a yjc;
    private IListener wUc = new IListener<co>() {
        /* class com.tencent.mm.plugin.hardcoder.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161749);
            this.__eventId = co.class.getName().hashCode();
            AppMethodBeat.o(161749);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(co coVar) {
            AppMethodBeat.i(130755);
            if (coVar instanceof co) {
                dead();
                if (!a.this.yjd.isEmpty()) {
                    a.this.yjd.clear();
                    Iterator it = ((ArrayList) a.this.yjd.clone()).iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(((Integer) pair.first).intValue(), (Object[]) pair.second);
                    }
                }
                if (!a.this.yje.isEmpty()) {
                    a.this.yje.clear();
                    Iterator it2 = ((ArrayList) a.this.yje.clone()).iterator();
                    while (it2.hasNext()) {
                        Object[] objArr = (Object[]) it2.next();
                        if (objArr.length >= 4) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                        }
                    }
                }
            }
            AppMethodBeat.o(130755);
            return false;
        }
    };
    private ArrayList<Pair<Integer, Object[]>> yjd = new ArrayList<>();
    private ArrayList<Object[]> yje = new ArrayList<>();

    public a() {
        AppMethodBeat.i(130756);
        AppMethodBeat.o(130756);
    }

    public static a dYI() {
        AppMethodBeat.i(130757);
        if (yjc == null) {
            yjc = new a();
        }
        a aVar = yjc;
        AppMethodBeat.o(130757);
        return aVar;
    }

    @Override // com.tencent.mm.hardcoder.e.a
    public final void a(int[] iArr, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int[] iArr3, int[] iArr4) {
        AppMethodBeat.i(130758);
        if (Log.getLogLevel() <= 1 || WXHardCoderJNI.hcKVPerReport) {
            int i11 = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            if (yja == null) {
                if (MMApplicationContext.isMMProcess()) {
                    g.aAi();
                    yja = (Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_FLAG_LONG, (Object) 0L);
                } else {
                    yja = 0L;
                }
            }
            if (TextUtils.isEmpty(yiZ)) {
                yiZ = q.dr(false);
            }
            String str = yiZ;
            int longValue = (int) yja.longValue();
            StringBuilder sb = new StringBuilder();
            if (iArr2 != null) {
                int length = iArr2.length;
                for (int i12 = 0; i12 < length; i12++) {
                    sb.append(iArr2[i12] + "#");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (iArr3 != null) {
                for (int i13 : iArr3) {
                    StringBuilder sb3 = new StringBuilder();
                    if (i13 < 0) {
                        i13 = 0;
                    }
                    sb2.append(sb3.append(i13).append("#").toString());
                }
            }
            StringBuilder sb4 = new StringBuilder();
            if (iArr4 != null) {
                for (int i14 : iArr4) {
                    StringBuilder sb5 = new StringBuilder();
                    if (i14 < 0) {
                        i14 = 0;
                    }
                    sb4.append(sb5.append(i14).append("#").toString());
                }
            }
            String format = String.format("[oneliang]performance report, imei:%s, threadId:%s, enable:%s, heavy:%s, speedUp:%s, engineStatus:%s, cancelInDelay:%s, scene:%s, action:%s, cpuLevel:%s, ioLevel:%s, bindCoreIds:%s, executeTime:%s,runtime:%s, phoneHZ:%s, cpuLevelTimeArray:%s, ioLevelTimeArray:%s", str, Arrays.toString(iArr), Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i11), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(i6), Integer.valueOf(i7), sb.toString(), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), sb2.toString(), sb4.toString());
            String format2 = String.format("time:%s,imei:%s,threadId:%s,enable:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,sMidascene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s, phoneHZ:%s, cpuLevelTimeArray:%s, ioLevelTimeArray:%s", Long.valueOf(System.currentTimeMillis()), str, Arrays.toString(iArr), Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i11), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(i6), Integer.valueOf(i7), sb.toString(), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), sb2.toString(), sb4.toString());
            if (WXHardCoderJNI.getDebug()) {
                Log.i("MicroMsg.HardCoderReporterImpl", format);
            }
            Object[] objArr = new Object[21];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(longValue);
            objArr[2] = Integer.valueOf(i11);
            objArr[3] = Integer.valueOf(i4);
            objArr[4] = Integer.valueOf(i5);
            objArr[5] = Long.valueOf(j2);
            objArr[6] = Integer.valueOf(i6);
            objArr[7] = Integer.valueOf(i7);
            objArr[8] = sb.toString();
            if (i8 < 0) {
                i8 = 0;
            }
            objArr[9] = Integer.valueOf(i8);
            objArr[10] = Integer.valueOf(i9);
            objArr[11] = 0;
            objArr[12] = 0;
            objArr[13] = Integer.valueOf(i10);
            objArr[14] = 0;
            objArr[15] = sb2.toString();
            objArr[16] = sb4.toString();
            objArr[17] = "";
            objArr[18] = 0;
            objArr[19] = Integer.valueOf(i3);
            objArr[20] = Integer.valueOf(i2);
            a(14607, objArr);
            if (yjb) {
                StringBuilder sb6 = new StringBuilder();
                g.aAi();
                String sb7 = sb6.append(g.aAh().hqF).append("/hcstat").toString();
                com.tencent.mm.b.e.f(sb7);
                o oVar = new o(sb7, "data.txt");
                if (!oVar.exists()) {
                    try {
                        oVar.createNewFile();
                    } catch (Exception e2) {
                        Log.i("MicroMsg.HardCoderReporterImpl", "create new file exception:" + e2.getMessage());
                    }
                }
                OutputStream outputStream = null;
                try {
                    outputStream = s.d(oVar, true);
                    outputStream.write((format2 + "\n").getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    outputStream.flush();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            AppMethodBeat.o(130758);
                            return;
                        } catch (Exception e3) {
                            Log.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e3.getMessage());
                            AppMethodBeat.o(130758);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    Log.i("MicroMsg.HardCoderReporterImpl", "exception:" + e4.getMessage());
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            AppMethodBeat.o(130758);
                            return;
                        } catch (Exception e5) {
                            Log.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e5.getMessage());
                            AppMethodBeat.o(130758);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                            Log.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e6.getMessage());
                        }
                    }
                    AppMethodBeat.o(130758);
                    throw th;
                }
            }
            AppMethodBeat.o(130758);
            return;
        }
        AppMethodBeat.o(130758);
    }

    @Override // com.tencent.mm.hardcoder.h.a
    public final void reportInfo(h hVar) {
        long j2;
        AppMethodBeat.i(130759);
        if (hVar instanceof j) {
            j jVar = (j) hVar;
            Log.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", Boolean.valueOf(jVar.hlC), Integer.valueOf(jVar.key), Integer.valueOf(jVar.value), Boolean.valueOf(jVar.ebV));
            if (jVar.hlC) {
                j2 = 678;
            } else {
                j2 = 679;
            }
            long j3 = (long) jVar.key;
            long j4 = (long) jVar.value;
            boolean z = jVar.ebV;
            if (!MMApplicationContext.isMMProcess() || g.aAf().hpY) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(j2, j3, j4, z);
                AppMethodBeat.o(130759);
                return;
            }
            Log.w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
            this.wUc.alive();
            this.yje.add(new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)});
            AppMethodBeat.o(130759);
        } else if (hVar instanceof i) {
            i iVar = (i) hVar;
            if (yja == null) {
                g.aAi();
                yja = (Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_FLAG_LONG, (Object) 0L);
            }
            if (TextUtils.isEmpty(yiZ)) {
                yiZ = q.dr(false);
            }
            String str = yiZ;
            int longValue = (int) yja.longValue();
            int i2 = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            int isRunning = WXHardCoderJNI.isRunning();
            int i3 = WXHardCoderJNI.getEnable() ? 1 : 0;
            if (iVar.type == 1) {
                long j5 = (iVar.hlB * 100) / iVar.interval;
                a(15187, str, Integer.valueOf(longValue), Integer.valueOf(i2), Integer.valueOf(isRunning), Integer.valueOf(iVar.scene), Long.valueOf(iVar.hlf), Integer.valueOf(iVar.type), Long.valueOf(iVar.hlB), Long.valueOf(iVar.interval), Long.valueOf(j5), Integer.valueOf(i3));
                Log.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", str, Integer.valueOf(i3), Integer.valueOf(longValue), Integer.valueOf(i2), Integer.valueOf(isRunning), Integer.valueOf(iVar.scene), Long.valueOf(iVar.hlf), Integer.valueOf(iVar.type), Long.valueOf(iVar.hlB), Long.valueOf(iVar.interval), Long.valueOf(j5)));
            }
            AppMethodBeat.o(130759);
        } else {
            if (hVar instanceof k) {
                a(16509, new Object[0]);
            }
            AppMethodBeat.o(130759);
        }
    }

    private void a(int i2, Object... objArr) {
        AppMethodBeat.i(130760);
        if (!MMApplicationContext.isMMProcess() || g.aAf().hpY) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(i2, objArr);
            AppMethodBeat.o(130760);
            return;
        }
        Log.w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
        this.wUc.alive();
        this.yjd.add(new Pair<>(Integer.valueOf(i2), objArr));
        AppMethodBeat.o(130760);
    }
}
