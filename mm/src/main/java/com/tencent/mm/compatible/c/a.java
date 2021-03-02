package com.tencent.mm.compatible.c;

import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodecList;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/compatible/camera/PluginCamera;", "", "()V", "CAMERA2_NUMBER_INFO_CACHE", "", "CAMERA2_SUPPORT_LEVELS_CACHE", "CAMERA_NUMBER_CACHE", "TAG", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "mCameraNumber", "mCameraNumberInApi2", "mCameraSupportLevels", "useMMKVCache", "", "getCamera2LevelListInfoFromDevice", "", "getCamera2NumberInfo", "getCamera2NumbersInfoFromDevice", "getCamera2SupportLevelLists", "getCameraNumbers", "initCameraNumbers", "initCodecCount", "libcompatible_release"})
public final class a {
    private static FutureTask<Integer> cCr;
    private static int gDo = -1;
    private static boolean gDp;
    private static int gDq = -1;
    private static String gDr;
    public static final a gDs = new a();

    static {
        AppMethodBeat.i(215472);
        AppMethodBeat.o(215472);
    }

    private a() {
    }

    public static final /* synthetic */ void anQ() {
        AppMethodBeat.i(215473);
        anM();
        AppMethodBeat.o(215473);
    }

    public static final /* synthetic */ void anR() {
        AppMethodBeat.i(215474);
        anN();
        AppMethodBeat.o(215474);
    }

    public static final /* synthetic */ FutureTask anU() {
        AppMethodBeat.i(215475);
        FutureTask<Integer> futureTask = cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        AppMethodBeat.o(215475);
        return futureTask;
    }

    public static void dp(boolean z) {
        AppMethodBeat.i(215465);
        gDp = z;
        Log.i("MicroMsg.PluginCamera", "initCameraNumbers start, useMMKVCache : ".concat(String.valueOf(z)));
        cCr = new FutureTask<>(CallableC0299a.gDt);
        h.RTc.aX(b.gDu);
        AppMethodBeat.o(215465);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b gDu = new b();

        static {
            AppMethodBeat.i(215464);
            AppMethodBeat.o(215464);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(215463);
            i iVar = h.RTc;
            a aVar = a.gDs;
            iVar.aX(a.anU());
            try {
                a aVar2 = a.gDs;
                a.anU().get(10, TimeUnit.SECONDS);
                AppMethodBeat.o(215463);
            } catch (TimeoutException e2) {
                Log.e("MicroMsg.PluginCamera", "futureTask TimeoutException cancel");
                a aVar3 = a.gDs;
                if (!a.anU().isCancelled()) {
                    a aVar4 = a.gDs;
                    if (!a.anU().isDone()) {
                        a aVar5 = a.gDs;
                        a.anU().cancel(true);
                        AppMethodBeat.o(215463);
                        return;
                    }
                }
                AppMethodBeat.o(215463);
            } catch (Exception e3) {
                Log.e("MicroMsg.PluginCamera", "futureTask Exception");
                AppMethodBeat.o(215463);
            }
        }
    }

    public static int anJ() {
        AppMethodBeat.i(215466);
        if (gDo == -1) {
            Log.i("MicroMsg.PluginCamera", "mCameraNumber == -1，slow initCameraNumbers, use MMKV cache");
            int i2 = MultiProcessMMKV.getDefault().getInt("cameraNumberCache", -1);
            Log.i("MicroMsg.PluginCamera", "get cameraNumberCache from MMKV cameraNumberCache is ".concat(String.valueOf(i2)));
            if (i2 == -1) {
                Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly");
                gDo = Camera.getNumberOfCameras();
                Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly DONE");
                MultiProcessMMKV.getDefault().putInt("cameraNumberCache", gDo);
                Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly save cache done");
            } else {
                Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV successful, return cameraNumberCache : ".concat(String.valueOf(i2)));
                if (gDp) {
                    if (i2 == 0) {
                        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV is 0, error, getNumberOfCameras freshly ");
                    } else {
                        gDo = i2;
                        AppMethodBeat.o(215466);
                        return i2;
                    }
                }
                int numberOfCameras = Camera.getNumberOfCameras();
                gDo = numberOfCameras;
                AppMethodBeat.o(215466);
                return numberOfCameras;
            }
        } else if (gDo == 0) {
            Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again");
            gDo = Camera.getNumberOfCameras();
            Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again DONE");
            MultiProcessMMKV.getDefault().putInt("cameraNumberCache", gDo);
        }
        Log.i("MicroMsg.PluginCamera", "mCameraNumber is " + gDo);
        int i3 = gDo;
        AppMethodBeat.o(215466);
        return i3;
    }

    public static int anK() {
        AppMethodBeat.i(215467);
        if (gDq == -1) {
            int i2 = MultiProcessMMKV.getDefault().getInt("camera2NumberInfoCache", -1);
            if (i2 == -1) {
                anM();
                MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", gDq);
            } else if (!gDp || i2 == 0) {
                anM();
                int i3 = gDq;
                AppMethodBeat.o(215467);
                return i3;
            } else {
                gDq = i2;
                AppMethodBeat.o(215467);
                return i2;
            }
        } else if (gDq == 0) {
            anM();
            MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", gDq);
        }
        int i4 = gDq;
        AppMethodBeat.o(215467);
        return i4;
    }

    public static String anL() {
        AppMethodBeat.i(215468);
        if (gDr == null) {
            String string = MultiProcessMMKV.getDefault().getString("camera2SupportLevelsCache", null);
            if (string == null) {
                anN();
                MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", gDr);
            } else if (gDp) {
                gDr = string;
                AppMethodBeat.o(215468);
                return string;
            } else {
                anN();
                String str = gDr;
                AppMethodBeat.o(215468);
                return str;
            }
        } else if (gDq == 0) {
            anN();
            MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", gDr);
        }
        String str2 = gDr;
        AppMethodBeat.o(215468);
        return str2;
    }

    private static void anM() {
        AppMethodBeat.i(215469);
        try {
            Object systemService = MMApplicationContext.getContext().getSystemService("camera");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                AppMethodBeat.o(215469);
                throw tVar;
            }
            gDq = ((CameraManager) systemService).getCameraIdList().length;
            AppMethodBeat.o(215469);
        } catch (Exception e2) {
            Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
            AppMethodBeat.o(215469);
        } catch (AssertionError e3) {
            Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
            AppMethodBeat.o(215469);
        }
    }

    private static void anN() {
        AppMethodBeat.i(215470);
        try {
            gDr = null;
            Object systemService = MMApplicationContext.getContext().getSystemService("camera");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                AppMethodBeat.o(215470);
                throw tVar;
            }
            CameraManager cameraManager = (CameraManager) systemService;
            String[] cameraIdList = cameraManager.getCameraIdList();
            p.g(cameraIdList, "manager.cameraIdList");
            for (String str : cameraIdList) {
                if (gDr == null) {
                    gDr = str + '-' + ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)) + '-' + ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)) + '+';
                } else {
                    gDr = p.I(gDr, str + '-' + ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)) + '-' + ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)) + '+');
                }
            }
            AppMethodBeat.o(215470);
        } catch (Exception e2) {
            Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
            AppMethodBeat.o(215470);
        } catch (AssertionError e3) {
            Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
            AppMethodBeat.o(215470);
        }
    }

    public static void anO() {
        AppMethodBeat.i(215471);
        try {
            Log.i("MicroMsg.PluginCamera", "initCodecCount start");
            long currentTimeMillis = System.currentTimeMillis();
            MediaCodecList.getCodecCount();
            Log.i("MicroMsg.PluginCamera", "initCodecCount end, duration : ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            AppMethodBeat.o(215471);
        } catch (Exception e2) {
            Log.e("MicroMsg.PluginCamera", "initCodecCount error");
            AppMethodBeat.o(215471);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "call"})
    /* renamed from: com.tencent.mm.compatible.c.a$a  reason: collision with other inner class name */
    static final class CallableC0299a<V> implements Callable<Integer> {
        public static final CallableC0299a gDt = new CallableC0299a();

        static {
            AppMethodBeat.i(215462);
            AppMethodBeat.o(215462);
        }

        CallableC0299a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() {
            AppMethodBeat.i(215461);
            Log.i("MicroMsg.PluginCamera", "initCameraNumbers getNumberOfCameras start");
            a aVar = a.gDs;
            a.gDo = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder("initCameraNumbers getNumberOfCameras Done mCameraNumber is ");
            a aVar2 = a.gDs;
            Log.i("MicroMsg.PluginCamera", sb.append(a.gDo).toString());
            a aVar3 = a.gDs;
            a.anQ();
            a aVar4 = a.gDs;
            a.anR();
            MultiProcessMMKV multiProcessMMKV = MultiProcessMMKV.getDefault();
            a aVar5 = a.gDs;
            multiProcessMMKV.putInt("cameraNumberCache", a.gDo);
            MultiProcessMMKV multiProcessMMKV2 = MultiProcessMMKV.getDefault();
            a aVar6 = a.gDs;
            multiProcessMMKV2.putInt("camera2NumberInfoCache", a.gDq);
            MultiProcessMMKV multiProcessMMKV3 = MultiProcessMMKV.getDefault();
            a aVar7 = a.gDs;
            multiProcessMMKV3.putString("camera2SupportLevelsCache", a.gDr);
            a aVar8 = a.gDs;
            Integer valueOf = Integer.valueOf(a.gDo);
            AppMethodBeat.o(215461);
            return valueOf;
        }
    }
}
