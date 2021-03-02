package com.tencent.mm.plugin.hardwareopt.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a implements com.tencent.mm.vending.c.a<cbc, Context> {
    private Context mContext = null;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ cbc call(Context context) {
        AppMethodBeat.i(55560);
        cbc gm = gm(context);
        AppMethodBeat.o(55560);
        return gm;
    }

    private cbc gm(Context context) {
        boolean z;
        AppMethodBeat.i(55557);
        this.mContext = context;
        long nanoTime = System.nanoTime();
        try {
            jm jmVar = new jm();
            jmVar.imei = q.dr(false);
            jmVar.KOb = Build.MANUFACTURER;
            jmVar.kxx = Build.MODEL;
            jmVar.KOc = Build.VERSION.INCREMENTAL;
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgs = jmVar;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", jmVar.imei, jmVar.KOb, jmVar.kxx, jmVar.KOc);
            tg tgVar = new tg();
            tgVar.abi = Build.CPU_ABI;
            Map<String, String> aoq = n.aoq();
            tgVar.LbP = Util.nullAs(aoq.get("Processor"), "");
            tgVar.kxx = aoq.get("model name");
            tgVar.LbR = aoq.get("Hardware");
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = s.dB("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", false);
                tgVar.LbQ = Util.getInt(randomAccessFile.readLine(), -1) / 1000;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                    }
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e3, "hy: error when reading cpu frequency", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                        Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e4, "hy: error when close read cpu files", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                        Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e5, "hy: error when close read cpu files", new Object[0]);
                    }
                }
                AppMethodBeat.o(55557);
                throw th;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgt = tgVar;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", tgVar.abi, tgVar.LbP, Integer.valueOf(tgVar.LbQ), tgVar.kxx, tgVar.LbR);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
            cop cop = new cop();
            cop.MuL = (int) ((memoryInfo.totalMem / 1024) / 1024);
            cop.MuM = (int) ((memoryInfo.threshold / 1024) / 1024);
            cop.MuN = ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
            cop.AXb = ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgu = cop;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(cop.MuL), Integer.valueOf(cop.MuM), Integer.valueOf(cop.MuN), Integer.valueOf(cop.AXb));
            StatFs statFs = new StatFs(b.aKD());
            ecz ecz = new ecz();
            if (Build.VERSION.SDK_INT >= 18) {
                ecz.Ndq = (int) ((statFs.getTotalBytes() / 1024) / 1024);
            } else {
                ecz.Ndq = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
            }
            ecz.Ndr = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgv = ecz;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(ecz.Ndq), Boolean.valueOf(ecz.Ndr));
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getDeviceConfigurationInfo();
            bgc bgc = new bgc();
            bgc.LPO = deviceConfigurationInfo.reqGlEsVersion >= 131072;
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                z = true;
            } else {
                z = false;
            }
            bgc.LPP = z;
            try {
                g.af(p.class);
                bgc.LPQ = false;
            } catch (Throwable th2) {
                Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", th2, "hy: error when retrieve vulkan support!", new Object[0]);
                bgc.LPQ = false;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgz = bgc;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(bgc.LPO), Boolean.valueOf(bgc.LPP), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(bgc.LPQ));
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i2 = point.x;
            int i3 = point.y;
            drg drg = new drg();
            drg.resolution = String.valueOf(i2) + "x" + i3;
            drg.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgw = drg;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", drg.resolution, Integer.valueOf(drg.density));
            abp abp = new abp();
            abp.Lmu = aBD("video/avc");
            abp.Lmv = aBD(TPDecoderType.TP_CODEC_MIMETYPE_HEVC);
            abp.Lmw = dYL();
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgx = abp;
            Object[] objArr = new Object[3];
            objArr[0] = abp.Lmu;
            objArr[1] = abp.Lmv;
            objArr[2] = Integer.valueOf(abp.Lmw != null ? abp.Lmw.size() : 0);
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d", objArr);
            ant ant = new ant();
            ant.Lzc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (Build.VERSION.SDK_INT >= 18) {
                ant.Lzd = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } else {
                ant.Lzd = false;
            }
            ant.Lze = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            ant.Lzf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            ant.Lzg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            ant.Lzh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            ant.Lzi = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (Build.VERSION.SDK_INT >= 19) {
                ant.Lzt = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            } else {
                ant.Lzt = false;
            }
            ant.Lzj = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (Build.VERSION.SDK_INT >= 23) {
                ant.Lzk = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            } else if (ae.gKx.gIE == 1) {
                ant.Lzk = true;
            } else {
                ant.Lzk = false;
            }
            ant.Lzl = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            ant.Lzm = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            ant.Lzn = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            ant.Lzo = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (Build.VERSION.SDK_INT >= 19) {
                ant.Lzp = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            } else {
                ant.Lzp = false;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                ant.Lzq = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            } else {
                ant.Lzq = false;
            }
            ant.Lzr = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            ant.Lzs = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK().Mgy = ant;
            Log.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(ant.Lzc), Boolean.valueOf(ant.Lzd), Boolean.valueOf(ant.Lze), Boolean.valueOf(ant.Lzf), Boolean.valueOf(ant.Lzg), Boolean.valueOf(ant.Lzh), Boolean.valueOf(ant.Lzi), Boolean.valueOf(ant.Lzt), Boolean.valueOf(ant.Lzj), Boolean.valueOf(ant.Lzk), Boolean.valueOf(ant.Lzl), Boolean.valueOf(ant.Lzm), Boolean.valueOf(ant.Lzn), Boolean.valueOf(ant.Lzo), Boolean.valueOf(ant.Lzp), Boolean.valueOf(ant.Lzq), Boolean.valueOf(ant.Lzr), Boolean.valueOf(ant.Lzs));
            Log.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
            try {
                cbc dYK = com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK();
                if (dYK != null) {
                    if (dYK.Mgt != null) {
                        g.aAh().azQ().set(ar.a.USERINFO_HARDWARE_CPU_FREQUENCY_MHZ_INT_SYNC, Integer.valueOf(dYK.Mgt.LbQ));
                    }
                    if (dYK.Mgu != null) {
                        g.aAh().azQ().set(ar.a.USERINFO_HARDWARE_MEMORY_IN_MB_INT_SYNC, Integer.valueOf(dYK.Mgu.MuL));
                    }
                }
            } catch (Exception e6) {
                Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e6, "alvinluo save hardware info to config storage exception", new Object[0]);
            }
            cbc dYK2 = com.tencent.mm.plugin.hardwareopt.b.a.dYJ().dYK();
            AppMethodBeat.o(55557);
            return dYK2;
        } catch (Exception e7) {
            Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e7, "hy: exception when find hardware info", new Object[0]);
            com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
            if (hdH != null) {
                hdH.ej(null);
            }
            AppMethodBeat.o(55557);
            return null;
        }
    }

    private static String aBD(String str) {
        AppMethodBeat.i(55558);
        z zVar = null;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z q = z.q(str, true);
                String name = q.getName();
                try {
                    q.release();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "codec release exception", new Object[0]);
                }
                AppMethodBeat.o(55558);
                return name;
            }
            AppMethodBeat.o(55558);
            return "too low version";
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e3, "hy: error in handle media codec", new Object[0]);
            if (0 != 0) {
                try {
                    zVar.release();
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e4, "codec release exception", new Object[0]);
                }
            }
            AppMethodBeat.o(55558);
            return "undefined";
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    zVar.release();
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e5, "codec release exception", new Object[0]);
                }
            }
            AppMethodBeat.o(55558);
            throw th;
        }
    }

    private static LinkedList<cow> dYL() {
        AppMethodBeat.i(55559);
        int codecCount = MediaCodecList.getCodecCount();
        LinkedList<cow> linkedList = new LinkedList<>();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String str : supportedTypes) {
                    Set set = (Set) hashMap.get(str.toLowerCase());
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(codecInfoAt.getName());
                    hashMap.put(str.toLowerCase(), set);
                }
            }
        }
        Log.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            cow cow = new cow();
            cow.mime = (String) entry.getKey();
            LinkedList<String> linkedList2 = new LinkedList<>();
            if (entry.getValue() != null) {
                linkedList2.addAll((Collection) entry.getValue());
            }
            cow.Mva = linkedList2;
            linkedList.add(cow);
        }
        AppMethodBeat.o(55559);
        return linkedList;
    }
}
