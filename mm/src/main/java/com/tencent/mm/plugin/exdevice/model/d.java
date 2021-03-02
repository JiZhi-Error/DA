package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.i.a;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d {
    private static int ryd = 0;
    c rxY;
    private w rxZ;
    HashMap<Long, MTimerHandler> rya;
    HashMap<Long, MTimerHandler> ryb;
    HashMap<Long, Integer> ryc;
    private j rye = null;
    private Object ryf = new Object();

    public d() {
        AppMethodBeat.i(23219);
        u.cLy().rxU = new c.a() {
            /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.exdevice.model.c.a
            public final void cKs() {
                AppMethodBeat.i(23205);
                if (d.this.rxY == null) {
                    d.this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
                    d.this.rxY.rDx = null;
                }
                d.this.rxY.fc(MMApplicationContext.getContext());
                AppMethodBeat.o(23205);
            }
        };
        if (this.rxZ == null) {
            this.rxZ = new w() {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.exdevice.service.k, com.tencent.mm.plugin.exdevice.service.w
                public final void a(long j2, int i2, int i3, int i4, long j3) {
                    AppMethodBeat.i(23216);
                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", b.Dj(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    if (MMApplicationContext.getContext() == null) {
                        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
                        AppMethodBeat.o(23216);
                        return;
                    }
                    if (4 == i3) {
                        u.cLx().Db(j2);
                        long[] anH = a.anH("shut_down_device");
                        if (!(anH == null || anH.length == 0)) {
                            for (long j4 : anH) {
                                if (j4 == j2) {
                                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", Long.valueOf(j4));
                                    d.CM(j4);
                                    if (!a.ae("shut_down_device", j4)) {
                                        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                                    }
                                }
                            }
                        }
                        if (d.this.ryc.get(Long.valueOf(j2)) != null) {
                            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", d.this.ryc.get(Long.valueOf(j2)));
                            dt dtVar = new dt();
                            EventCenter.instance.publish(dtVar);
                            if (!dtVar.dGM.dor || (((Integer) d.this.ryc.get(Long.valueOf(j2))).intValue() & 1) != 1) {
                                d.CM(j2);
                            }
                        } else {
                            d.CM(j2);
                        }
                    }
                    if (i2 != i3) {
                        com.tencent.mm.plugin.exdevice.i.b anI = ad.cKL().anI(String.valueOf(j2));
                        if (anI == null || Util.isNullOrNil(anI.field_brandName)) {
                            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", Long.valueOf(j2));
                            AppMethodBeat.o(23216);
                            return;
                        }
                        f.a CY = u.cLx().CY(j2);
                        if (CY != null) {
                            CY.dHO = i3;
                        } else {
                            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", Long.valueOf(j2));
                        }
                        if (i3 == 2) {
                            Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                            AppMethodBeat.o(23216);
                            return;
                        }
                        ad.cKW();
                        e.d(anI.field_brandName, anI.field_url, i3, anI.field_deviceID);
                    }
                    AppMethodBeat.o(23216);
                }
            };
        }
        this.rya = new HashMap<>();
        this.ryb = new HashMap<>();
        this.ryc = new HashMap<>();
        AppMethodBeat.o(23219);
    }

    public static int cKt() {
        return ryd;
    }

    public final synchronized void Gw(int i2) {
        AppMethodBeat.i(23220);
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", Integer.valueOf(i2));
        ryd = i2;
        AppMethodBeat.o(23220);
    }

    public final synchronized void a(Long l, int i2) {
        AppMethodBeat.i(23221);
        this.ryc.put(l, Integer.valueOf(i2));
        AppMethodBeat.o(23221);
    }

    public final void b(String str, long j2, int i2) {
        AppMethodBeat.i(23222);
        a(str, j2, i2, false);
        AppMethodBeat.o(23222);
    }

    public final void a(final String str, final long j2, int i2, final boolean z) {
        AppMethodBeat.i(23223);
        a.ae("shut_down_device", j2);
        if (this.rxY == null) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
            this.rxY.rDx = new c.a(i2) {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.exdevice.service.c.a
                public final void onServiceConnected() {
                    AppMethodBeat.i(23212);
                    d.this.rxY.rDx = null;
                    d.this.b(str, j2, this.dIe, z);
                    AppMethodBeat.o(23212);
                }
            };
            this.rxY.fc(MMApplicationContext.getContext());
            AppMethodBeat.o(23223);
        } else if (this.rxY == null || this.rxY.rDy) {
            b(str, j2, i2, z);
            AppMethodBeat.o(23223);
        } else {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            this.rxY.rDx = new c.a(i2) {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.exdevice.service.c.a
                public final void onServiceConnected() {
                    AppMethodBeat.i(23213);
                    d.this.rxY.rDx = null;
                    d.this.b(str, j2, this.dIe, z);
                    AppMethodBeat.o(23213);
                }
            };
            this.rxY.fc(MMApplicationContext.getContext());
            AppMethodBeat.o(23223);
        }
    }

    public final void b(String str, long j2, int i2, boolean z) {
        boolean d2;
        AppMethodBeat.i(23224);
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            d2 = c(str, j2, i2);
        } else {
            d2 = d(str, j2, i2);
        }
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", Boolean.valueOf(d2));
        AppMethodBeat.o(23224);
    }

    public static void CM(long j2) {
        AppMethodBeat.i(23225);
        if (u.cLy().rxT != null) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", Long.valueOf(j2), Boolean.valueOf(u.cLy().rxT.De(j2)));
        }
        AppMethodBeat.o(23225);
    }

    public final void cKu() {
        AppMethodBeat.i(23226);
        if (this.rxY != null && this.rxY.rDy) {
            try {
                com.tencent.mm.br.c.a(this.rxY, "exdevice");
                AppMethodBeat.o(23226);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(23226);
    }

    private synchronized boolean c(final String str, final long j2, final int i2) {
        boolean z;
        AppMethodBeat.i(23227);
        int aYS = bg.azz().aYS();
        if (aYS != 4 && aYS != 6) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.o(23227);
            z = false;
        } else if (this.ryb.containsKey(Long.valueOf(j2))) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", str, Long.valueOf(j2));
            AppMethodBeat.o(23227);
            z = false;
        } else {
            MTimerHandler mTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass8 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(23214);
                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(u.cLx().CX(j2)));
                    d.CM(j2);
                    d.this.ryb.remove(Long.valueOf(j2));
                    AppMethodBeat.o(23214);
                    return false;
                }
            }, false);
            long cMj = b.cMj();
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", Long.valueOf(cMj));
            mTimerHandler.startTimer(cMj);
            this.ryb.put(Long.valueOf(j2), mTimerHandler);
            if (u.cLy().rxT != null) {
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", str, Long.valueOf(j2));
                z = u.cLy().rxT.a(j2, i2, this.rxZ);
                AppMethodBeat.o(23227);
            } else {
                Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                AppMethodBeat.o(23227);
                z = false;
            }
        }
        return z;
    }

    private boolean d(final String str, final long j2, final int i2) {
        AppMethodBeat.i(23228);
        if (bg.azz().aYS() != 4) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            AppMethodBeat.o(23228);
            return false;
        }
        if (this.rya.containsKey(Long.valueOf(j2))) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j2), Integer.valueOf(i2));
            MTimerHandler mTimerHandler = this.rya.get(Long.valueOf(j2));
            mTimerHandler.stopTimer();
            mTimerHandler.startTimer(30000);
        } else {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j2), Integer.valueOf(i2));
            MTimerHandler mTimerHandler2 = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(23215);
                    int CX = u.cLx().CX(j2);
                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(CX));
                    if (CX != 2) {
                        ad.cKW();
                        e.dh(str, 2);
                    }
                    d.this.rya.remove(Long.valueOf(j2));
                    AppMethodBeat.o(23215);
                    return false;
                }
            }, false);
            mTimerHandler2.startTimer(30000);
            this.rya.put(Long.valueOf(j2), mTimerHandler2);
        }
        if (u.cLy().rxT == null) {
            Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", str, Long.valueOf(j2), Integer.valueOf(i2));
            AppMethodBeat.o(23228);
            return false;
        }
        f.a CY = u.cLx().CY(j2);
        if (CY == null) {
            Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", Long.valueOf(j2));
            AppMethodBeat.o(23228);
            return false;
        }
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", Integer.valueOf(CY.dHO));
        if (!(CY.dHO == 2 || CY.dHO == 1)) {
            u.cLy().rxT.a(j2, i2, this.rxZ);
        }
        AppMethodBeat.o(23228);
        return true;
    }

    public static boolean lO(boolean z) {
        AppMethodBeat.i(23229);
        if (u.cLy().rxT != null) {
            long[] cLa = u.cLy().rxT.cLa();
            if (cLa == null || cLa.length <= 0) {
                Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                AppMethodBeat.o(23229);
                return false;
            }
            for (long j2 : cLa) {
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", Long.valueOf(j2));
                com.tencent.mm.plugin.exdevice.i.b Di = ad.cKL().Di(j2);
                if (Di == null) {
                    Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", Long.valueOf(j2));
                } else if (!z || (Di.field_closeStrategy & 1) != 0) {
                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", Long.valueOf(j2));
                    u.cLy().rxT.De(j2);
                } else {
                    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", Long.valueOf(j2));
                }
            }
            AppMethodBeat.o(23229);
            return true;
        }
        Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        AppMethodBeat.o(23229);
        return false;
    }

    public final void a(final int i2, j jVar) {
        AppMethodBeat.i(23230);
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", Integer.valueOf(i2));
        if (jVar == null) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            AppMethodBeat.o(23230);
            return;
        }
        this.rye = jVar;
        if (this.rxY == null) {
            this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
            this.rxY.rDx = new c.a(i2) {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.exdevice.service.c.a
                public final void onServiceConnected() {
                    AppMethodBeat.i(23218);
                    if (!u.cLy().rxT.b(i2, d.this.rye)) {
                        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                    AppMethodBeat.o(23218);
                }
            };
            this.rxY.fc(MMApplicationContext.getContext());
            AppMethodBeat.o(23230);
            return;
        }
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.cLy().rxT == null) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.o(23230);
            return;
        }
        if (!u.cLy().rxT.b(i2, this.rye)) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
        AppMethodBeat.o(23230);
    }

    public final void Gx(int i2) {
        AppMethodBeat.i(23231);
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", Integer.valueOf(i2));
        if (this.rxY == null) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            AppMethodBeat.o(23231);
        } else if (u.cLy().rxT == null) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            AppMethodBeat.o(23231);
        } else {
            if (!u.cLy().rxT.c(i2, this.rye)) {
                Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            AppMethodBeat.o(23231);
        }
    }

    public final void am(final Runnable runnable) {
        AppMethodBeat.i(23232);
        Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
        if (this.rxY == null) {
            this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
            this.rxY.rDx = new c.a() {
                /* class com.tencent.mm.plugin.exdevice.model.d.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.exdevice.service.c.a
                public final void onServiceConnected() {
                    AppMethodBeat.i(23208);
                    runnable.run();
                    AppMethodBeat.o(23208);
                }
            };
            this.rxY.fc(MMApplicationContext.getContext());
            AppMethodBeat.o(23232);
            return;
        }
        this.rxY.an(runnable);
        AppMethodBeat.o(23232);
    }
}
