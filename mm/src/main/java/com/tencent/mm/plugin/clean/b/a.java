package com.tencent.mm.plugin.clean.b;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Runnable {
    private static final Long duN = 604800000L;
    private static final Long qps = 7776000000L;
    private long cacheSize;
    private boolean isStop;
    List<Runnable> pQl;
    private long qpt;
    private long qpu;
    private long qpv;
    private HashMap<String, Long> qpw;
    private HashSet<String> qpx;
    private AbstractC0924a qpy;
    LinkedList<String> qpz;

    /* renamed from: com.tencent.mm.plugin.clean.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0924a {
        void fn(int i2, int i3);

        void j(long j2, long j3, long j4);
    }

    static {
        AppMethodBeat.i(22768);
        AppMethodBeat.o(22768);
    }

    public a(AbstractC0924a aVar) {
        AppMethodBeat.i(231653);
        this.isStop = false;
        this.qpz = new LinkedList<>();
        this.pQl = new ArrayList();
        this.isStop = false;
        this.qpy = aVar;
        this.qpw = new HashMap<>();
        this.qpx = new HashSet<>();
        AppMethodBeat.o(231653);
    }

    public final void stop() {
        this.isStop = true;
        this.qpy = null;
    }

    private String bgQ() {
        AppMethodBeat.i(22762);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(22762);
        return sb;
    }

    public final void run() {
        int i2;
        int i3;
        long j2;
        AppMethodBeat.i(22763);
        long currentTicks = Util.currentTicks();
        if (this.isStop) {
            Log.i("MicroMsg.CleanCalcLogic", "%s start run but stop", bgQ());
            AppMethodBeat.o(22763);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        a(hashSet, hashSet2);
        String str = b.aKD() + "/Cache/";
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!this.isStop) {
                if (i4 >= size) {
                    break;
                } else if (!Util.isNullOrNil(next)) {
                    if (next.endsWith("/sns/") || next.endsWith("/music") || next.equals(str)) {
                        this.qpz.add(next);
                        j2 = J(new File(next));
                    } else {
                        j2 = I(new File(next));
                    }
                    this.qpw.put(next, Long.valueOf(j2));
                    Log.i("MicroMsg.CleanCalcLogic", "%s path[%s] size[%s]", bgQ(), next, Util.getSizeMB(j2));
                    this.qpt += j2;
                    if (hashSet2.contains(next)) {
                        this.qpv = j2 + this.qpv;
                    }
                    int i5 = i4 + 1;
                    if (this.qpy != null) {
                        this.qpy.fn(i5, size);
                    }
                    i4 = i5;
                }
            } else {
                Log.e("MicroMsg.CleanCalcLogic", "run stop.");
                break;
            }
        }
        this.qpu = com.tencent.mm.plugin.f.b.crW().crX().csg();
        long H = H(new File(b.aKA()));
        if (this.qpt <= 0) {
            this.qpt = 1;
            h.INSTANCE.idkeyStat(714, 60, 1, false);
        }
        g.aAi();
        long boW = s.boW(g.aAh().azO());
        Log.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%s] dataSize[%s] dbSize[%s], acc[%s] otherAcc[%s]", bgQ(), Long.valueOf(Util.ticksToNow(currentTicks)), Util.getSizeMB(this.qpt), Util.getSizeMB(H), Util.getSizeMB(boW), Util.getSizeMB(this.qpu), Util.getSizeMB(this.qpv));
        d.cyM();
        long cyN = d.cyN();
        d.cyM();
        long cyO = d.cyO();
        int i6 = (int) ((this.qpu * 100) / this.qpt);
        long j3 = (this.qpt - this.qpu) - this.qpv;
        int i7 = (int) ((100 * j3) / this.qpt);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
        long j4 = mmkv.getLong("CleanCalcMidImg", 0);
        long j5 = mmkv.getLong("CleanCalcHevcImg", 0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cacheSize).append(",");
        stringBuffer.append(this.qpt).append(",");
        stringBuffer.append((int) ((this.qpt * 100) / cyN)).append(",");
        stringBuffer.append(cyN - cyO).append(",");
        stringBuffer.append(cyO).append(",");
        stringBuffer.append(cyN).append(",");
        stringBuffer.append(boW).append(",");
        stringBuffer.append(this.qpu).append(",");
        stringBuffer.append(i6).append(",");
        stringBuffer.append(this.qpv).append(",");
        stringBuffer.append((int) ((this.qpv * 100) / this.qpt)).append(",");
        stringBuffer.append(j3).append(",");
        stringBuffer.append(i7).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(H).append(",");
        stringBuffer.append(j4).append(",");
        stringBuffer.append(j5);
        String stringBuffer2 = stringBuffer.toString();
        Log.i("MicroMsg.CleanCalcLogic", "rpt content %s", stringBuffer2);
        this.pQl.add(new Runnable() {
            /* class com.tencent.mm.plugin.clean.b.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(231652);
                ((f) g.af(f.class)).buk();
                AppMethodBeat.o(231652);
            }
        });
        h.INSTANCE.kvStat(14762, stringBuffer2);
        long j6 = this.qpt;
        long j7 = this.qpu;
        double d2 = ((double) j7) / ((double) j6);
        if (j6 > 17179869184L) {
            i2 = 7;
        } else if (j6 > 8589934592L) {
            i2 = 6;
        } else if (j6 > 2147483648L) {
            i2 = 5;
        } else if (j6 > TPAudioFrame.TP_CH_STEREO_LEFT) {
            i2 = 4;
        } else {
            i2 = 3;
        }
        if (d2 > 0.5d) {
            i3 = 11;
        } else if (d2 > 0.2d) {
            i3 = 10;
        } else if (d2 > 0.1d) {
            i3 = 9;
        } else {
            i3 = 8;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(new IDKey(1613, 0, (j6 / 1024) / 1024));
        arrayList.add(new IDKey(1613, 1, (j7 / 1024) / 1024));
        arrayList.add(new IDKey(1613, 2, 1));
        arrayList.add(new IDKey(1613, i2, 1));
        arrayList.add(new IDKey(1613, i3, 1));
        h.INSTANCE.b(arrayList, true);
        d.cyM().qpK = this.qpt;
        d.cyM().dataSize = H;
        d.cyM().qpu = this.qpu + boW;
        d.cyM().cacheSize = this.cacheSize;
        d.cyM().qpv = this.qpv;
        d.cyM().qpL = this.qpw;
        d.cyM().qpM = hashSet2;
        d.cyM().pQk = this.qpz;
        d.cyM().pQl = this.pQl;
        if (this.qpy != null) {
            this.qpy.j(this.qpt, this.qpu + boW, this.cacheSize);
        }
        stop();
        AppMethodBeat.o(22763);
    }

    private long H(File file) {
        AppMethodBeat.i(231654);
        long j2 = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String str = file2.getAbsolutePath() + File.separator;
                    if (!str.endsWith("/MicroMsg/")) {
                        long I = I(new File(str));
                        j2 += I;
                        Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), str, Util.getSizeMB(I));
                    } else if (file2.isDirectory()) {
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null) {
                            for (File file3 : listFiles2) {
                                if (file3.getName().length() < 32) {
                                    long I2 = I(file3);
                                    j2 += I2;
                                    Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), file3.getAbsolutePath(), Util.getSizeMB(I2));
                                } else if (file3.isDirectory()) {
                                    File[] listFiles3 = file3.listFiles();
                                    if (listFiles3 != null) {
                                        for (File file4 : listFiles3) {
                                            long I3 = I(file4);
                                            j2 += I3;
                                            Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), file4.getAbsolutePath(), Util.getSizeMB(I3));
                                        }
                                    }
                                } else {
                                    long I4 = I(new File(str));
                                    j2 += I4;
                                    Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), file3.getAbsolutePath(), Util.getSizeMB(I4));
                                }
                            }
                        }
                    } else {
                        long I5 = I(new File(str));
                        j2 += I5;
                        Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), str, Util.getSizeMB(I5));
                    }
                }
            }
        } else {
            j2 = I(file);
            Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", bgQ(), file.getAbsolutePath(), Util.getSizeMB(j2));
        }
        AppMethodBeat.o(231654);
        return j2;
    }

    private long I(File file) {
        File[] listFiles;
        AppMethodBeat.i(231655);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            long length = file.length();
            AppMethodBeat.o(231655);
            return length;
        }
        long j2 = 0;
        for (File file2 : listFiles) {
            long I = I(file2);
            if (I == -1) {
                AppMethodBeat.o(231655);
                return -1;
            }
            j2 += I;
        }
        AppMethodBeat.o(231655);
        return j2;
    }

    private int a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        int i2;
        File[] listFiles;
        AppMethodBeat.i(231656);
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        if (b.aKD().equals(b.aKE())) {
            hashSet3.add(b.aKJ());
            hashSet4.add(b.aKJ() + g.aAh().hqJ + File.separator);
            hashSet4.add(b.aKJ() + g.aAh().hqH + File.separator);
        } else {
            File file = new File(b.aKD() + File.separator);
            if (file.isDirectory()) {
                File[] listFiles2 = file.listFiles();
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        if (file2.isDirectory()) {
                            hashSet3.add(file2.getAbsolutePath() + File.separator);
                        } else {
                            hashSet3.add(file2.getAbsolutePath());
                        }
                    }
                } else {
                    hashSet3.add(b.aKD() + File.separator);
                }
            }
            hashSet3.add(b.aKI());
            hashSet4.add(b.aKJ() + g.aAh().hqJ + File.separator);
            hashSet4.add(b.aKJ() + g.aAh().hqH + File.separator);
            hashSet4.add(b.aKI() + g.aAh().hqJ + File.separator);
            hashSet4.add(b.aKI() + g.aAh().hqH + File.separator);
        }
        Log.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", bgQ(), b.aKD(), b.aKE(), g.aAh().hqJ, g.aAh().hqH);
        int i3 = 1;
        String str = b.aKD() + "/Cache/";
        hashSet.add(str);
        hashSet3.remove(str);
        Iterator it = hashSet3.iterator();
        while (it.hasNext()) {
            File file3 = new File((String) it.next());
            if (!file3.isDirectory() || (listFiles = file3.listFiles()) == null) {
                i2 = i3;
            } else {
                i2 = i3;
                for (File file4 : listFiles) {
                    Log.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", bgQ(), file4.getAbsolutePath());
                    if (file4.isDirectory()) {
                        String name = file4.getName();
                        String str2 = file4.getAbsolutePath() + File.separator;
                        if (name.length() < 32) {
                            hashSet.add(str2);
                            i2++;
                        } else if (hashSet4.contains(str2)) {
                            File[] listFiles3 = new File(str2).listFiles();
                            if (listFiles3 != null) {
                                for (File file5 : listFiles3) {
                                    if (file5.isDirectory()) {
                                        hashSet.add(file5.getAbsolutePath() + File.separator);
                                    } else {
                                        hashSet.add(file5.getAbsolutePath());
                                    }
                                }
                            }
                        } else {
                            hashSet2.add(str2);
                            hashSet.add(str2);
                            i2++;
                            this.qpx.add(name);
                        }
                    } else {
                        hashSet.add(file4.getAbsolutePath());
                        i2++;
                    }
                }
            }
            i3 = i2;
        }
        AppMethodBeat.o(231656);
        return i3;
    }

    private long J(File file) {
        AppMethodBeat.i(231657);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                long j2 = 0;
                for (File file2 : listFiles) {
                    j2 += J(file2);
                }
                AppMethodBeat.o(231657);
                return j2;
            }
            this.cacheSize += file.length();
            long length = file.length();
            AppMethodBeat.o(231657);
            return length;
        }
        this.cacheSize += file.length();
        long length2 = file.length();
        AppMethodBeat.o(231657);
        return length2;
    }
}
