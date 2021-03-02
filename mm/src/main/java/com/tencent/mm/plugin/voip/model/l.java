package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.Proxy;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.appbrand.jsapi.share.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.plugin.voip.model.a.k;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.wxmm.v2helper;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public final class l {
    public int GVA = 0;
    public long GVB = 0;
    public long GVC = 0;
    public int GVD = 0;
    public int GVE = 0;
    public boolean GVF = false;
    public boolean GVG = false;
    public boolean GVH = false;
    public int GVI = 10;
    private int GVJ = -1;
    private int GVK = -1;
    private int GVL = -1;
    private int GVM = -1;
    private int GVN = -1;
    public boolean GVO = false;
    private boolean GVP = false;
    private int GVQ = 1;
    private boolean GVR = false;
    private int GVS = 1;
    private int GVT = -1;
    private int GVU = -1;
    public v2protocal GVV = new v2protocal(this.mHandler);
    public x GVW = x.GZW;
    public n GVX = new n(this);
    public w GVY;
    public byte[] GVZ = null;
    public boolean GVr = false;
    public boolean GVs = false;
    public boolean GVt = false;
    public boolean GVu = false;
    public boolean GVv = false;
    public boolean GVw = false;
    public boolean GVx = false;
    public boolean GVy = false;
    public eca GVz = new eca();
    public ett GWa = null;
    public boolean GWb = false;
    public boolean GWc = false;
    public int GWd = 0;
    public int GWe = 0;
    public int GWf = 0;
    public int GWg = 0;
    public boolean GWh = false;
    public boolean GWi = true;
    public VoipScoreState GWj;
    public int GWk = 0;
    public MTimerHandler GWl = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(114886);
            Log.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
            l.this.GVY.a(null, false, 7);
            AppMethodBeat.o(114886);
            return true;
        }
    }, true);
    Timer GWm = null;
    int GWn = 0;
    private MTimerHandler GWo = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(177018);
            if (l.this.mStatus == 4) {
                e.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
                l.this.GVV.Hcw.GXc = 105;
                l.this.K(1, -9000, "");
            }
            AppMethodBeat.o(177018);
            return false;
        }
    }, false);
    private a GWp = null;
    public boolean dWM = false;
    MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass8 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(114891);
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 1) {
                if (l.this.GVV.roomId == 0) {
                    e.Loge("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                    AppMethodBeat.o(114891);
                    return;
                }
                e.Logi("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
                w wVar = l.this.GVY;
                int i2 = message.arg2;
                euk euk = new euk();
                euk.oUv = 1;
                SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                sKBuiltinBuffer_t.setBuffer((byte[]) message.obj);
                euk.KMS = sKBuiltinBuffer_t;
                SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                try {
                    sKBuiltinBuffer_t2.setBuffer(euk.toByteArray());
                    etm etm = new etm();
                    etm.Lms = i2;
                    etm.Lmt = sKBuiltinBuffer_t2;
                    etm.xNH = z.aTY();
                    etn etn = new etn();
                    etn.oTz = 1;
                    etn.oTA.add(etm);
                    wVar.a(etn, true, 2);
                    AppMethodBeat.o(114891);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                    AppMethodBeat.o(114891);
                }
            } else if (message.arg1 == 4) {
                if (l.this.GVV.roomId == 0) {
                    e.Loge("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                    AppMethodBeat.o(114891);
                    return;
                }
                e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
                l.this.GVV.Hcw.GXc = 107;
                l.this.K(1, -9004, "");
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 6) {
                e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
                if (l.this.GVV.roomId == 0) {
                    e.Logi("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                    AppMethodBeat.o(114891);
                    return;
                }
                l.this.GVt = true;
                l.this.GVV.Hcw.GXs = 1;
                if (l.this.dWM || l.this.GVu) {
                    l.this.GVV.Hbk = 0;
                } else {
                    l.this.GVV.Hbk = 1;
                }
                l.this.GVV.setInactive();
                e.Logi("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
                l.this.fGy();
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 3) {
                l.this.mStatus = 5;
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 5) {
                e.Logi("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
                if (l.this.mStatus >= 5) {
                    l.this.GVV.Hcw.GXc = 108;
                } else {
                    l.this.GVV.Hcw.GXc = 106;
                }
                if (message.arg2 == 5) {
                    l.this.GVV.Hcw.GXu = 1;
                    e.Logi("MicroMsg.Voip.VoipContext", "channel broken...");
                } else if (message.arg2 == 8) {
                    if (l.this.GVx) {
                        e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                        l.this.GVw = true;
                        AppMethodBeat.o(114891);
                        return;
                    }
                    e.Logi("MicroMsg.Voip.VoipContext", "channel connect fail...");
                    l.this.GVt = false;
                    l.this.GVV.Hcw.GXu = 5;
                }
                l.this.K(1, -9000, "");
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 100) {
                e.outputJniLog((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 101) {
                e.outputJniLog((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 7) {
                e.Logi("MicroMsg.Voip.VoipContext", "NOTIFY_FROM_JNI_SPEEDTESTRESULT handle");
                byte[] bArr = (byte[]) message.obj;
                int i3 = message.arg2;
                String str = null;
                try {
                    str = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
                } catch (Exception e3) {
                    e.Logi("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
                }
                String str2 = null;
                try {
                    str2 = ((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getSimOperatorName();
                } catch (Exception e4) {
                    e.Logi("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
                }
                new j(l.this.GVC, l.this.GVB, l.this.GVD, str2, str, l.this.GVE, i3, bArr).fII();
                AppMethodBeat.o(114891);
            } else if (message.arg1 == 8) {
                byte[] bArr2 = (byte[]) message.obj;
                l lVar = l.this;
                try {
                    epd epd = (epd) new epd().parseFrom(bArr2);
                    if (!lVar.GWh || epd.NmY != 1) {
                        e.Logi("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + epd.NmY);
                    }
                    switch (epd.NmY) {
                        case 1:
                            if (!lVar.GWh) {
                                e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
                                lVar.j(8, false, true);
                                lVar.c(4, false, true, true);
                                if (epd.NmZ != null) {
                                    ByteBuffer wrap = ByteBuffer.wrap(epd.NmZ.zy, 0, 4);
                                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                                    int min = Math.min(wrap.getInt(), 6);
                                    ByteBuffer allocate = ByteBuffer.allocate(4);
                                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                                    allocate.putInt(min);
                                    e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: ".concat(String.valueOf(min)));
                                    lVar.GVV.setAppCmd(30, allocate.array(), 4);
                                } else {
                                    e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
                                }
                            }
                            lVar.GWh = true;
                            AppMethodBeat.o(114891);
                            return;
                        case 2:
                            e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
                            lVar.GVX.GWL = true;
                            AppMethodBeat.o(114891);
                            return;
                        case 3:
                            if (epd.NmZ != null) {
                                byte[] bArr3 = epd.NmZ.zy;
                                e.Logi("MicroMsg.Voip.VoipContext", "steve: remote new network type:".concat(String.valueOf(bArr3)));
                                int appCmd = lVar.GVV.setAppCmd(302, bArr3, 4);
                                if (appCmd < 0) {
                                    e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr3 + "fail:" + appCmd + ", [roomid=" + lVar.GVV.ypO + ", roomkey=" + lVar.GVV.ypH + "]");
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 4:
                            if (epd.NmZ != null) {
                                esu esu = (esu) new esu().parseFrom(epd.NmZ.zy);
                                e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + esu.Nqs);
                                byte[] bArr4 = new byte[4];
                                bArr4[0] = (byte) esu.Nqs;
                                lVar.GVV.setJNIAppCmd(2, bArr4, 4);
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 5:
                            if (epd.NmZ != null) {
                                byte[] bArr5 = epd.NmZ.zy;
                                if (lVar.GVV != null) {
                                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr5);
                                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                                    int i4 = wrap2.getInt();
                                    ByteBuffer allocate2 = ByteBuffer.allocate(6);
                                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                                    allocate2.putShort(3);
                                    allocate2.putShort((short) i4);
                                    allocate2.putShort(0);
                                    lVar.GVV.setAppCmd(35, allocate2.array(), 6);
                                    e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec:  ".concat(String.valueOf(i4)));
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_DisableCodec empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 6:
                            if (epd.NmZ != null) {
                                byte[] bArr6 = epd.NmZ.zy;
                                if (lVar.GVV != null) {
                                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr6);
                                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                                    int i5 = wrap3.getInt();
                                    ByteBuffer allocate3 = ByteBuffer.allocate(6);
                                    allocate3.order(ByteOrder.LITTLE_ENDIAN);
                                    allocate3.putShort(3);
                                    allocate3.putShort((short) i5);
                                    allocate3.putShort(0);
                                    lVar.GVV.setAppCmd(39, allocate3.array(), 6);
                                    e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i5)));
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 7:
                            if (epd.NmZ != null) {
                                byte[] bArr7 = epd.NmZ.zy;
                                if (lVar.GVV != null) {
                                    ByteBuffer wrap4 = ByteBuffer.wrap(bArr7);
                                    wrap4.order(ByteOrder.LITTLE_ENDIAN);
                                    int i6 = wrap4.getInt();
                                    if (i6 == 20) {
                                        ByteBuffer allocate4 = ByteBuffer.allocate(6);
                                        allocate4.order(ByteOrder.LITTLE_ENDIAN);
                                        allocate4.putShort(2);
                                        allocate4.putShort(16);
                                        allocate4.putShort(0);
                                        lVar.GVV.setAppCmd(39, allocate4.array(), 6);
                                        ByteBuffer allocate5 = ByteBuffer.allocate(6);
                                        allocate5.order(ByteOrder.LITTLE_ENDIAN);
                                        allocate5.putShort(2);
                                        allocate5.putShort(4);
                                        allocate5.putShort(0);
                                        lVar.GVV.setAppCmd(39, allocate5.array(), 6);
                                    } else {
                                        ByteBuffer allocate6 = ByteBuffer.allocate(6);
                                        allocate6.order(ByteOrder.LITTLE_ENDIAN);
                                        allocate6.putShort(2);
                                        allocate6.putShort((short) i6);
                                        allocate6.putShort(0);
                                        lVar.GVV.setAppCmd(39, allocate6.array(), 6);
                                    }
                                    e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder:  ".concat(String.valueOf(i6)));
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "jcchen CMD_VOIP_CloseEncoder empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 8:
                            if (epd.NmZ != null) {
                                byte[] bArr8 = epd.NmZ.zy;
                                e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote wx ver: ".concat(String.valueOf(bArr8)));
                                int appCmd2 = lVar.GVV.setAppCmd(506, bArr8, 4);
                                if (appCmd2 < 0) {
                                    e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] remote wx ver: " + bArr8 + "ret: " + appCmd2 + ", [roomid=" + lVar.GVV.ypO + ", roomkey=" + lVar.GVV.ypH + "]");
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteClientVersion] empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                        case 9:
                            if (epd.NmZ == null) {
                                e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] empty buffer");
                                break;
                            } else {
                                byte[] bArr9 = epd.NmZ.zy;
                                int length = epd.NmZ.zy.length;
                                e.Logi("MicroMsg.Voip.VoipContext", "anlin: remote device model: ".concat(String.valueOf(bArr9)));
                                int appCmd3 = lVar.GVV.setAppCmd(508, bArr9, length);
                                if (appCmd3 < 0) {
                                    e.Logi("MicroMsg.Voip.VoipContext", "anlin:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteDeviceModel] remote device model: " + bArr9 + "ret: " + appCmd3 + ", [roomid=" + lVar.GVV.ypO + ", roomkey=" + lVar.GVV.ypH + "]");
                                }
                                AppMethodBeat.o(114891);
                                return;
                            }
                        case 10:
                            if (epd.NmZ != null) {
                                ByteBuffer allocate7 = ByteBuffer.allocate(4);
                                allocate7.order(ByteOrder.LITTLE_ENDIAN);
                                allocate7.putInt(1);
                                lVar.GVV.setAppCmd(48, allocate7.array(), 4);
                                e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq:  1");
                                AppMethodBeat.o(114891);
                                return;
                            }
                            e.Logi("MicroMsg.Voip.VoipContext", "ashlynli CMD_VOIP_EnableAq empty buffer");
                            AppMethodBeat.o(114891);
                            return;
                    }
                    AppMethodBeat.o(114891);
                } catch (Exception e5) {
                    e.Logi("MicroMsg.Voip.VoipContext", "rudp cmd processing Error");
                    AppMethodBeat.o(114891);
                }
            } else {
                if (message.arg1 == 9) {
                    o oVar = l.this.GVV.Hcw;
                    if (0 == oVar.GXG) {
                        oVar.GXG = System.currentTimeMillis();
                        e.Logi("MicroMsg.VoipDailReport", "first pkt received timestamp:" + oVar.GXG);
                    }
                    e.Logi("MicroMsg.Voip.VoipContext", "get first pkt for voip");
                    if (1 == l.this.GVV.HbV) {
                        euv euv = new euv();
                        euv.oTW = 1;
                        l.this.GVY.a(euv, 2);
                        AppMethodBeat.o(114891);
                        return;
                    }
                } else if (message.arg1 == 11) {
                    l.this.GWk = 2;
                    AppMethodBeat.o(114891);
                    return;
                } else if (message.arg1 == 12) {
                    l.this.GWk = 1;
                    AppMethodBeat.o(114891);
                    return;
                } else if (message.arg1 == 13) {
                    int i7 = message.arg2;
                    new h(l.this.GVV.roomId, l.this.GVV.ypH, l.this.GVV.ypO, 1, i7, (int[]) message.obj, null).fII();
                    AppMethodBeat.o(114891);
                    return;
                } else if (message.arg1 == 14) {
                    int i8 = message.arg2;
                    new h(l.this.GVV.roomId, l.this.GVV.ypH, l.this.GVV.ypO, 2, i8, (int[]) message.obj, null).fII();
                    AppMethodBeat.o(114891);
                    return;
                } else if (message.arg1 == 15) {
                    l.this.aE(message.arg2, false);
                }
                AppMethodBeat.o(114891);
            }
        }
    };
    public int mStatus = 1;
    public Context owO = null;
    public Network zIU = null;
    public ConnectivityManager.NetworkCallback zIV = null;
    public LinkedList<Integer> zIW = new LinkedList<>();

    public interface a {
        void K(int i2, int i3, String str);
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void aC(int i2, int i3, int i4);
    }

    /* access modifiers changed from: package-private */
    public interface d {
        void fGL();
    }

    protected l() {
        AppMethodBeat.i(114899);
        this.GVX.GWQ = this.GVV.ypH;
        this.GVY = new w(this);
        this.GWg = 0;
        this.GWj = new VoipScoreState();
        AppMethodBeat.o(114899);
    }

    public final void reset() {
        AppMethodBeat.i(114900);
        Log.i("MicroMsg.Voip.VoipContext", "reset");
        this.GVX.fGO();
        if (this.GVV.fIZ()) {
            this.GVV.xh(false);
        }
        this.GVV.reset();
        this.GVJ = -1;
        this.GVK = -1;
        this.GVL = -1;
        this.GVM = -1;
        this.GVN = -1;
        this.GVV.HaQ = 0;
        this.GWo.stopTimer();
        this.GVY.fIE();
        this.GWl.stopTimer();
        this.GVr = false;
        this.GVt = false;
        this.GVs = false;
        this.GVu = false;
        this.dWM = false;
        this.GVv = false;
        this.GVZ = null;
        this.GWa = null;
        this.GVF = false;
        this.GVG = false;
        this.GVH = false;
        this.GVO = false;
        this.GVP = false;
        this.GVR = false;
        this.GVQ = 1;
        this.GVS = 1;
        this.GWb = false;
        this.GVT = -1;
        this.GVU = -1;
        this.GVw = false;
        this.GVx = false;
        this.GVv = false;
        this.GVr = false;
        this.GVy = false;
        this.GVI = 10;
        this.mStatus = 1;
        this.GWg = 0;
        this.GWk = 0;
        this.GWh = false;
        this.GWf = 0;
        this.zIU = null;
        this.zIW.clear();
        AppMethodBeat.o(114900);
    }

    public final void fGn() {
        int i2 = 0;
        AppMethodBeat.i(114901);
        if (this.GVr && this.GVA == 0) {
            this.GVA = 1;
            if (this.GVV.field_speedTestInfoLength < 8) {
                e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.GVV.field_speedTestInfoLength);
                AppMethodBeat.o(114901);
                return;
            }
            int i3 = this.GVV.Hcu[1];
            if (i3 + 2 > this.GVV.field_speedTestInfoLength) {
                e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i3 + ", bufsize=" + this.GVV.field_speedTestInfoLength);
                AppMethodBeat.o(114901);
                return;
            }
            int i4 = this.GVV.Hcu[i3 + 2 + 1];
            if (i3 + 6 + i4 != this.GVV.field_speedTestInfoLength) {
                e.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i3 + ", C2SRttCnt=" + i4 + ", bufsize=" + this.GVV.field_speedTestInfoLength);
                AppMethodBeat.o(114901);
                return;
            }
            this.GVB = this.GVV.ypH;
            this.GVD = this.GVV.netType;
            this.GVE = this.GVV.roomId;
            this.GVz.LsZ = this.GVV.roomId;
            this.GVz.NbR = this.GVV.HaK;
            this.GVz.Llx = this.GVV.netType;
            this.GVz.NbS = this.GVr ? 1 : 0;
            eca eca = this.GVz;
            eca.NbT = this.GVt ? 1 : 0;
            this.GVz.NbU = this.GVV.Hcu[0];
            int i5 = 2;
            this.GVz.NbV = this.GVV.Hcu[1];
            for (int i6 = 0; i6 < this.GVz.NbV; i6++) {
                i5++;
                this.GVz.NbW.add(Integer.valueOf(this.GVV.Hcu[i5]));
            }
            int i7 = i5 + 1;
            this.GVz.NbX = this.GVV.Hcu[i5];
            int i8 = i7 + 1;
            this.GVz.NbY = this.GVV.Hcu[i7];
            while (i2 < this.GVz.NbY) {
                this.GVz.NbZ.add(Integer.valueOf(this.GVV.Hcu[i8]));
                i2++;
                i8++;
            }
            this.GVz.Nca = this.GVV.Hcu[i8];
            this.GVz.Ncb = this.GVV.Hcu[i8 + 1];
            new k(this.GVz).fII();
            AppMethodBeat.o(114901);
            return;
        }
        e.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.GVr + " ,mSpeedTestStatus=" + this.GVA);
        AppMethodBeat.o(114901);
    }

    public final void fGo() {
        AppMethodBeat.i(114902);
        if (this.GVA == 0) {
            AppMethodBeat.o(114902);
        } else if (this.GVA == 1) {
            this.GVA = 0;
            this.GVV.Hce = 0;
            AppMethodBeat.o(114902);
        } else {
            this.GVA = 0;
            v2protocal v2protocal = this.GVV;
            e.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            v2protocal.StopSpeedTest();
            v2protocal.Hce = 0;
            AppMethodBeat.o(114902);
        }
    }

    public final void ada(int i2) {
        AppMethodBeat.i(114903);
        this.GVV.zNX = Math.abs(i2);
        AppMethodBeat.o(114903);
    }

    public final void adb(int i2) {
        AppMethodBeat.i(114904);
        this.GVV.HaL = Math.abs(i2);
        if (i2 != 0) {
            this.GVW.enR();
        }
        AppMethodBeat.o(114904);
    }

    public final void fGp() {
        AppMethodBeat.i(114905);
        this.GVV.HaM = this.GVX.fGN();
        this.GVV.HaN = this.GVX.fFs();
        AppMethodBeat.o(114905);
    }

    public final void adc(int i2) {
        this.GVV.HaO = i2;
    }

    public final void shutdown() {
        AppMethodBeat.i(114906);
        fGK();
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(114889);
                if (l.this.GVW != null) {
                    l.this.GVW.wW(false);
                }
                AppMethodBeat.o(114889);
            }
        });
        AppMethodBeat.o(114906);
    }

    public final boolean a(ett ett) {
        this.GWa = ett;
        this.GVV.haD = this.GWa.NqS;
        this.GVV.roomId = this.GWa.LsZ;
        this.GVV.ypH = this.GWa.Lta;
        this.GVV.ypO = 1;
        this.GVV.Hav = 0;
        this.mStatus = 3;
        return true;
    }

    public final void setStatus(int i2) {
        AppMethodBeat.i(114907);
        if (i2 == this.mStatus) {
            AppMethodBeat.o(114907);
            return;
        }
        if (i2 == 4) {
            this.GWo.startTimer(Util.MILLSECONDS_OF_MINUTE);
        }
        this.mStatus = i2;
        AppMethodBeat.o(114907);
    }

    public final int fGq() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        return this.mStatus != 4 ? 3 : 2;
    }

    public final boolean fGr() {
        if (this.mStatus == 2 || this.mStatus == 4) {
            return true;
        }
        return false;
    }

    public final boolean fGs() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean fGt() {
        AppMethodBeat.i(114908);
        Log.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", Integer.valueOf(this.mStatus));
        if (this.mStatus == 1) {
            AppMethodBeat.o(114908);
            return false;
        }
        AppMethodBeat.o(114908);
        return true;
    }

    public final void ade(int i2) {
        AppMethodBeat.i(114910);
        if (8 == i2 || 9 == i2) {
            this.GVN = i2;
        } else {
            this.GVL = i2;
            this.GVJ = i2;
        }
        if (1 == i2 || 3 == i2) {
            adf(2);
        }
        com.tencent.mm.plugin.voip.c.fFg().GYS.GZt = false;
        com.tencent.mm.plugin.voip.c.fFg().fIg();
        this.GVW.acQ(i2);
        AppMethodBeat.o(114910);
    }

    public final void adf(int i2) {
        AppMethodBeat.i(114911);
        if (8 == i2 || 9 == i2) {
            this.GVM = i2;
        } else {
            this.GVJ = i2;
            this.GVK = i2;
        }
        this.GVY.adv(i2);
        AppMethodBeat.o(114911);
    }

    public final long fGu() {
        return (long) this.GVV.HaK;
    }

    public final boolean fGv() {
        if (this.GVH) {
            return false;
        }
        switch (this.GVJ) {
            case -1:
                return true;
            case 0:
                if (4 != this.GVK) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.GVK || -1 == this.GVK)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.GVK || 6 == this.GVK || 7 == this.GVK) {
                    return false;
                }
        }
        return true;
    }

    public final boolean fGw() {
        if (this.GVH) {
            return false;
        }
        switch (this.GVJ) {
            case -1:
                return true;
            case 0:
                if (4 != this.GVK) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.GVL || this.GVL == 0 || -1 == this.GVL)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.GVL || 6 == this.GVL || 7 == this.GVL) {
                    return false;
                }
        }
        return true;
    }

    private void fGx() {
        int i2;
        AppMethodBeat.i(114914);
        e.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ae.gKu.gEo);
        if (ae.gKu.gDM == 1) {
            this.GVV.setAppCmd(410);
        }
        byte[] bArr = new byte[2];
        if (ae.gKu.gEo >= 0) {
            bArr[0] = (byte) ae.gKu.gEo;
            this.GVV.setAppCmd(406, bArr, 1);
        } else if (ae.gKu.gEo == -2) {
            this.GVV.setAppCmd(407);
        }
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100447");
        if (Fu.isValid() && 1 == (i2 = Util.getInt(Fu.gzz().get("SetVoipRnnNsOn"), 0))) {
            this.GVV.setAppCmd(v2helper.EMethodSetSendToNetworkOn, new byte[]{(byte) i2}, 1);
        }
        int i3 = ae.gKu.gEp;
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNew %d", Integer.valueOf(i3));
        if (ae.gKu.gEp >= 0) {
            if (i3 > 0) {
                int floor = ((int) Math.floor(((double) i3) / 1000.0d)) % 100;
                Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", Integer.valueOf(floor));
                if (floor > 0) {
                    this.GVV.setAppCmd(408, new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)}, 4);
                }
            } else if (i3 == 0) {
                this.GVV.setAppCmd(409);
            }
        } else if (ae.gKu.gEp == -2) {
            this.GVV.setAppCmd(409);
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_play_fadeinfadeout_switch, -1);
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_switch = %d", Integer.valueOf(a2));
        byte[] bArr2 = {0};
        if (a2 > 0) {
            bArr2[0] = (byte) a2;
        }
        this.GVV.setAppCmd(451, bArr2, 1);
        int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_fullbandflag, -1);
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, fullbandmode = %d", Integer.valueOf(a3));
        int i4 = ae.gKu.gEr;
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", Integer.valueOf(i4));
        if (a3 > 0 && i4 > 0) {
            this.GVV.setAppCmd(456, new byte[]{(byte) (a3 & 255), (byte) ((a3 >> 8) & 255), (byte) ((a3 >> 16) & 255), (byte) ((a3 >> 24) & 255)}, 4);
        }
        int a4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_play_fadeinfadeout_thresh, -1);
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, play_fadeinfadeout_thresh = %d", Integer.valueOf(a4));
        bArr2[0] = 0;
        if (a4 > 0) {
            bArr2[0] = (byte) a4;
        }
        this.GVV.setAppCmd(452, bArr2, 1);
        int a5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_rcnnvadctr, -1);
        Log.i("MicroMsg.Voip.VoipContext", "kerrizhang, voip rcnnvad_switch = %d", Integer.valueOf(a5));
        if (a5 > 0) {
            this.GVV.setAppCmd(v.CTRL_INDEX, new byte[]{(byte) a5}, 1);
        }
        int a6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_aec_value, 0);
        Log.i("MicroMsg.Voip.VoipContext", "dennyliang, voip aec_value = %d", Integer.valueOf(a6));
        if (a6 > 0) {
            this.GVV.setAppCmd(460, new byte[]{(byte) (a6 & 255), (byte) ((a6 >> 8) & 255), (byte) ((a6 >> 16) & 255), (byte) ((a6 >> 24) & 255)}, 4);
        }
        int a7 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_agc_params, -1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agc_paras: %d", Integer.valueOf(a7));
        if (a7 > 0) {
            byte b2 = (byte) (a7 & 1);
            Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc_switch: %d", Byte.valueOf(b2));
            if (b2 > 0) {
                byte[] bArr3 = {(byte) ((a7 >> 1) & 31), (byte) ((a7 >> 6) & 31), (byte) ((a7 >> 11) & 3), (byte) ((a7 >> 13) & 3), (byte) ((a7 >> 15) & 1), (byte) ((a7 >> 16) & 7), (byte) ((a7 >> 19) & 15)};
                Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", Byte.valueOf(bArr3[0]), Byte.valueOf(bArr3[1]), Byte.valueOf(bArr3[2]), Byte.valueOf(bArr3[3]), Byte.valueOf(bArr3[4]), Byte.valueOf(bArr3[5]), Byte.valueOf(bArr3[6]));
                this.GVV.setAppCmd(404, bArr3, 7);
            } else {
                this.GVV.setAppCmd(405);
            }
        }
        if (ae.gKu.gEt >= 0) {
            byte[] bArr4 = new byte[7];
            if (ae.gKu.gEu >= 0 && ae.gKu.gEv >= 0) {
                bArr4[0] = (byte) ae.gKu.gEu;
                bArr4[1] = (byte) ae.gKu.gEv;
                if (ae.gKu.gEw >= 0) {
                    bArr4[2] = (byte) ae.gKu.gEw;
                    bArr4[3] = (byte) ae.gKu.gEt;
                    bArr4[4] = (byte) ae.gKu.gEx;
                    bArr4[5] = (byte) ae.gKu.gEy;
                    bArr4[6] = (byte) ae.gKu.gEz;
                    this.GVV.setAppCmd(404, bArr4, 7);
                } else {
                    this.GVV.setAppCmd(404, bArr4, 2);
                }
            }
        } else if (ae.gKu.gEt == -2) {
            this.GVV.setAppCmd(405);
        }
        int a8 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_frz_sta_peroid, -1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, frz_sta_p_x = %d", Integer.valueOf(a8));
        if (a8 > 0) {
            this.GVV.setAppCmd(u.CTRL_INDEX, new byte[]{(byte) (a8 & 255), (byte) ((a8 >> 8) & 255), (byte) ((a8 >> 16) & 255), (byte) ((a8 >> 24) & 255)}, 4);
        }
        int a9 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_neteq_flag, -1);
        int a10 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_neteq_min_cache, -1);
        int a11 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_neteq_max_cache, -1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x-exp, neteq flag:%d, min cache:%d, max cache:%d", Integer.valueOf(a9), Integer.valueOf(a10), Integer.valueOf(a11));
        if (a9 == 1 && a10 > 0 && a11 > 0) {
            this.GVV.setAppCmd(bg.CTRL_INDEX, new byte[]{(byte) (a9 & 255), (byte) ((a9 >> 8) & 255), (byte) ((a9 >> 16) & 255), (byte) ((a9 >> 24) & 255), (byte) (a10 & 255), (byte) ((a10 >> 8) & 255), (byte) ((a10 >> 16) & 255), (byte) ((a10 >> 24) & 255), (byte) (a11 & 255), (byte) ((a11 >> 8) & 255), (byte) ((a11 >> 16) & 255), (byte) ((a11 >> 24) & 255)}, 3);
        } else if (a9 == 0) {
            this.GVV.setAppCmd(bg.CTRL_INDEX, new byte[]{(byte) (a9 & 255), (byte) ((a9 >> 8) & 255), (byte) ((a9 >> 16) & 255), (byte) ((a9 >> 24) & 255)}, 1);
        }
        int a12 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_engine_get_data_config, -1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, tryUpdateAudioAdaption, switch_flag_x = %d", Integer.valueOf(a12));
        byte[] bArr5 = {0};
        if (a12 > 0) {
            bArr5[0] = 1;
        }
        this.GVV.setAppCmd(450, bArr5, 1);
        if (ae.gKu.gDN >= 0 || ae.gKu.gDP >= 0) {
            bArr[0] = -1;
            bArr[1] = -1;
            if (ae.gKu.gDN >= 0) {
                bArr[0] = (byte) ae.gKu.gDN;
            }
            if (ae.gKu.gDP >= 0) {
                bArr[1] = (byte) ae.gKu.gDP;
            }
            this.GVV.setAppCmd(414, bArr, 2);
        }
        if (ae.gKu.gDO >= 0 || ae.gKu.gDQ >= 0) {
            bArr[0] = -1;
            bArr[1] = -1;
            if (ae.gKu.gDO >= 0) {
                bArr[0] = (byte) ae.gKu.gDO;
            }
            if (ae.gKu.gDQ >= 0) {
                bArr[1] = (byte) ae.gKu.gDQ;
            }
            this.GVV.setAppCmd(415, bArr, 2);
        }
        if (ae.gKu.gDR >= 0 || ae.gKu.gDS >= 0) {
            bArr[0] = -1;
            bArr[1] = -1;
            if (ae.gKu.gDR >= 0) {
                bArr[0] = (byte) ae.gKu.gDR;
            }
            if (ae.gKu.gDS >= 0) {
                bArr[1] = (byte) ae.gKu.gDS;
            }
            this.GVV.setAppCmd(v2helper.EMethodOutputVolumeGainEnable, bArr, 2);
        }
        if (ae.gKu.gDX >= 0) {
            bArr[0] = (byte) ae.gKu.gDX;
            this.GVV.setAppCmd(416, bArr, 1);
        }
        if (ae.gKu.gEb >= 0) {
            bArr[0] = (byte) ae.gKu.gEb;
            this.GVV.setAppCmd(431, bArr, 4);
        }
        if (ae.gKu.gDY >= 0 && !(this.GVV.Hbt == 0 && ae.gKu.gDY == 5)) {
            bArr[0] = (byte) ae.gKu.gDY;
            this.GVV.setAppCmd(417, bArr, 1);
        }
        if (ae.gKu.gDZ >= 0 && !(this.GVV.Hbt == 0 && ae.gKu.gDZ == 5)) {
            bArr[0] = (byte) ae.gKu.gDZ;
            this.GVV.setAppCmd(418, bArr, 1);
        }
        if (ae.gKu.gEa >= 0) {
            bArr[0] = (byte) ae.gKu.gEa;
            this.GVV.setAppCmd(419, bArr, 1);
        }
        if (this.GVV.Hbt == 1 && (ae.gKu.gDY == 5 || ae.gKu.gDZ == 5)) {
            this.GVV.HaX = 5;
        }
        if (1 == ae.gKu.gEN) {
            byte[] bArr6 = new byte[30];
            for (int i5 = 0; i5 < 15; i5++) {
                bArr6[i5 * 2] = (byte) (ae.gKu.gEO[i5] & 255);
                bArr6[(i5 * 2) + 1] = (byte) ((ae.gKu.gEO[i5] >> 8) & 255);
            }
            this.GVV.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr6, 30);
        }
        if (ae.gKu.gEN == 0) {
            this.GVV.setAppCmd(v2helper.EMethodSetPlayerPreCorrectCofOff);
        }
        if (ae.gKu.gEP[0] > 0 || ae.gKu.gEP[1] > 0) {
            bArr[0] = 0;
            bArr[1] = 0;
            if (ae.gKu.gEP[0] > 0 && ae.gKu.gEP[0] < 10000) {
                bArr[0] = (byte) ae.gKu.gEP[0];
            }
            if (ae.gKu.gEP[1] > 0 && ae.gKu.gEP[1] < 10000) {
                bArr[1] = (byte) ae.gKu.gEP[1];
            }
            this.GVV.setAppCmd(v2helper.EMethodSetNgStrength, bArr, 2);
        }
        if (ae.gKu.gER > 0) {
            bArr[0] = (byte) ae.gKu.gER;
            this.GVV.setAppCmd(v2helper.EMethodSetSpkEnhance, bArr, 1);
        }
        int a13 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_agcrx_params, -1);
        Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, x_agcrx_para: %d", Integer.valueOf(a13));
        if (a13 > 0) {
            byte b3 = (byte) (a13 & 1);
            Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx_switch: %d", Byte.valueOf(b3));
            if (b3 > 0) {
                byte[] bArr7 = {(byte) ((a13 >> 1) & 3), (byte) ((a13 >> 3) & 31), (byte) ((a13 >> 8) & 31), (byte) ((a13 >> 13) & 1)};
                Log.i("MicroMsg.Voip.VoipContext", "qipengfeng, agcrx paras: %d, %d, %d, %d", Byte.valueOf(bArr7[0]), Byte.valueOf(bArr7[1]), Byte.valueOf(bArr7[2]), Byte.valueOf(bArr7[3]));
                this.GVV.setAppCmd(v2helper.EMethodSetAgcRxOn, bArr7, 4);
            }
        }
        if (ae.gKu.gEZ >= 0) {
            this.GVV.setAppCmd(v2helper.EMethodSetAgcRxOn, new byte[]{(byte) ae.gKu.gEZ, (byte) ae.gKu.gFa, (byte) ae.gKu.gFb, (byte) ae.gKu.gFc}, 4);
        }
        AppMethodBeat.o(114914);
    }

    public final void elV() {
        AppMethodBeat.i(114915);
        e.Logi("MicroMsg.Voip.VoipContext", "In networkRequestViaCellular");
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(0);
            builder.addCapability(12);
            NetworkRequest build = builder.build();
            e.Logi("MicroMsg.Voip.VoipContext", "NetworkRequest toString: " + build.toString() + " hashCode: " + build.hashCode());
            try {
                connectivityManager.requestNetwork(build, new ConnectivityManager.NetworkCallback() {
                    /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass7 */

                    public final void onAvailable(Network network) {
                        AppMethodBeat.i(114890);
                        super.onAvailable(network);
                        l.this.GVV.Hbe++;
                        Parcel obtain = Parcel.obtain();
                        network.writeToParcel(obtain, 0);
                        e.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + obtain.readInt() + " toString: " + network.toString());
                        if (com.tencent.mm.compatible.util.d.oD(28)) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                            try {
                                int multipathPreference = connectivityManager.getMultipathPreference(network);
                                e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(multipathPreference)));
                                if (multipathPreference == 0) {
                                    l.this.GVV.Hbd = 3;
                                }
                            } catch (Exception e2) {
                                e.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
                                l.this.GVV.Hbd = 2;
                                try {
                                    connectivityManager.unregisterNetworkCallback(this);
                                    AppMethodBeat.o(114890);
                                    return;
                                } catch (Exception e3) {
                                    e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
                                    AppMethodBeat.o(114890);
                                    return;
                                }
                            }
                        }
                        if (l.this.zIU != null) {
                            l.this.zIU = network;
                            if (l.this.zIW != null) {
                                for (int i2 = 0; i2 < l.this.zIW.size(); i2++) {
                                    l.this.aE(l.this.zIW.get(i2).intValue(), true);
                                }
                            }
                        } else {
                            l.this.zIU = network;
                        }
                        l.this.zIV = this;
                        e.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + l.this.zIV.hashCode());
                        l.this.GVV.Hbd = 1;
                        AppMethodBeat.o(114890);
                    }
                });
                AppMethodBeat.o(114915);
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "missing the appropriate permissions");
                this.GVV.Hbd = 2;
                AppMethodBeat.o(114915);
            }
        } else {
            AppMethodBeat.o(114915);
        }
    }

    public final void elW() {
        AppMethodBeat.i(114916);
        e.Logi("MicroMsg.Voip.VoipContext", "try to UnregisterCellularNetwork");
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
            if (this.zIV != null) {
                e.Logi("MicroMsg.Voip.VoipContext", "unregister networkcallback hashCode: " + this.zIV.hashCode());
                try {
                    connectivityManager.unregisterNetworkCallback(this.zIV);
                } catch (Exception e2) {
                    e.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
                }
                this.zIV = null;
                this.zIU = null;
            }
        }
        AppMethodBeat.o(114916);
    }

    public final void fGy() {
        int i2;
        AppMethodBeat.i(114917);
        e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.GVv && this.GVt) {
            e.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.GVV.setActive();
            if (this.GVy) {
                e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.GVy);
                AppMethodBeat.o(114917);
                return;
            }
            this.GVV.setSvrConfig(205, 0, 0, this.GVV.HbM, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(207, 0, 0, this.GVV.HaF, 0, 0, 0, 0, null);
            e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.GVV.HbM + " SwitchFlag = " + this.GVV.HaF);
            this.GVV.HaI[0] = (byte) ae.gKE.gGV;
            this.GVV.HaI[1] = (byte) ae.gKE.gGW;
            this.GVV.HaI[2] = (byte) ae.gKE.gGX;
            this.GVV.HaI[3] = (byte) ae.gKE.gGY;
            this.GVV.HaI[4] = (byte) ae.gKE.gGZ;
            this.GVV.HaI[5] = (byte) ae.gKE.gHa;
            this.GVV.HaI[6] = (byte) ae.gKE.gHb;
            this.GVV.HaI[7] = (byte) ae.gKE.gHc;
            this.GVV.HaI[8] = (byte) ae.gKE.gHd;
            this.GVV.HaI[9] = (byte) ae.gKE.gHe;
            this.GVV.setSvrConfig(209, 0, 0, 0, 0, 0, 0, this.GVV.HaI.length, this.GVV.HaI);
            if (this.GVV.startEngine() == 0) {
                this.GVV.Hcw.GXC = 0;
            } else {
                this.GVy = false;
                this.GVV.Hcw.GXC = 1;
            }
            if (this.GVV.HaH == null) {
                e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
            } else if (this.GVV.HaH.length < 1024) {
                this.GVV.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.GVV.HaH.length, this.GVV.HaH);
            } else {
                e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.GVV.HaH.length);
            }
            fGx();
            if (!fGv() && !fGw()) {
                fGB();
            } else if (this.GWm != null) {
                fGB();
            } else {
                this.GWm = new Timer();
                this.GWn = 0;
                this.GWm.schedule(new TimerTask() {
                    /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass10 */

                    public final void run() {
                        AppMethodBeat.i(114893);
                        l.this.GWn++;
                        if (l.this.GVV.Hck != 0 || l.this.GWn > 10) {
                            l.this.fGB();
                            if (l.this.GWm != null) {
                                l.this.GWm.cancel();
                                l.this.GWm = null;
                            }
                            AppMethodBeat.o(114893);
                            return;
                        }
                        AppMethodBeat.o(114893);
                    }
                }, 200, 200);
            }
            this.GVW.fFT();
            n nVar = this.GVX;
            if (nVar.qrL == 2) {
                e.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                e.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                nVar.qrL = 2;
                nVar.GWL = false;
                nVar.GWM = 0;
                if (nVar.GWP != null) {
                    Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is not null");
                    if (!nVar.GWP.isQuit()) {
                        Log.i("MicroMsg.Voip.VoipDeviceHandler", "mDevHandlerThread is alive");
                    }
                }
                nVar.GWP.removeCallbacksAndMessages(null);
                if (nVar.GWU != null) {
                    e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    nVar.GWU.GWY = true;
                    nVar.GWU.cancel();
                    nVar.GWU = null;
                }
                nVar.GWU = new n.a();
                ThreadPool.post(nVar.GWU, "VoipDeviceHandler_decode");
                e.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                ae.gKu.dump();
                synchronized (nVar.GWJ) {
                    try {
                        if (nVar.qrL == n.qrK) {
                            Log.e("MicroMsg.Voip.VoipDeviceHandler", "current is not allowed to start dev");
                        } else {
                            nVar.GWB = new c();
                            nVar.GWB.GTm = String.valueOf(nVar.GWQ);
                            a aVar = new a();
                            e.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + aVar.Bry + ", framelen: " + aVar.GSV + ", ret:" + nVar.GSZ.GVV.a(aVar));
                            nVar.GWB.N(aVar.Bry, aVar.channels, aVar.GSV, 0);
                            nVar.qrM = nVar.GWB.F(nVar.GSZ.owO, true);
                            nVar.GSZ.GVV.HaZ = nVar.GWB.jvb;
                            byte[] bArr = new byte[1];
                            bArr[0] = (byte) (nVar.GWB.GSY ? 1 : 0);
                            nVar.GSZ.GVV.setAppCmd(502, bArr, 1);
                            if (nVar.qrM <= 10) {
                                if (nVar.qrM <= 0) {
                                    nVar.qrP = 1;
                                }
                                nVar.qrM = 92;
                            }
                            if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
                                com.tencent.mm.plugin.voip.c.fFg().ry(true);
                            } else {
                                com.tencent.mm.plugin.voip.c.fFg().ry(false);
                            }
                            nVar.GWB.GTi = new b() {
                                /* class com.tencent.mm.plugin.voip.model.n.AnonymousClass3 */

                                @Override // com.tencent.mm.plugin.voip.model.b
                                public final int Q(byte[] bArr, int i2) {
                                    AppMethodBeat.i(114943);
                                    if (n.this.qrL != 2) {
                                        AppMethodBeat.o(114943);
                                        return -1;
                                    }
                                    if (1 == n.this.GWN) {
                                        n.this.GWN = 0;
                                        n.this.GWO = System.currentTimeMillis();
                                        e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first play");
                                    } else {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        long j2 = currentTimeMillis - n.this.GWO;
                                        if (j2 > 1000) {
                                            e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,play deltaTime:".concat(String.valueOf(j2)));
                                        }
                                        n.this.GWO = currentTimeMillis;
                                    }
                                    if (n.this.GSZ.GVV.iCs) {
                                        int playCallback = n.this.GSZ.GVV.playCallback(bArr, i2);
                                        if (playCallback < 0) {
                                            e.Loge("MicroMsg.Voip.VoipDeviceHandler", f.apq() + "protocal.playcallback ret:" + playCallback);
                                            AppMethodBeat.o(114943);
                                            return -1;
                                        }
                                        n.GWS++;
                                    }
                                    AppMethodBeat.o(114943);
                                    return 0;
                                }
                            };
                            if (nVar.GWB.fFp() <= 0) {
                                nVar.qrP = 1;
                            }
                        }
                    } finally {
                        AppMethodBeat.o(114917);
                    }
                }
                synchronized (nVar.GWJ) {
                    try {
                        nVar.GWP.post(new Runnable() {
                            /* class com.tencent.mm.plugin.voip.model.n.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(114942);
                                try {
                                    n.o(n.this);
                                    AppMethodBeat.o(114942);
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", e2.getMessage());
                                    n.this.qrP = 1;
                                    n.this.GSZ.adb(n.this.qrP);
                                    AppMethodBeat.o(114942);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            o oVar = this.GVV.Hcw;
            if (oVar.beginTime == 0) {
                oVar.GXv = 0;
            } else {
                oVar.GXv = (int) (System.currentTimeMillis() - oVar.beginTime);
            }
            e.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + oVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            e.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + oVar.GXv);
            this.GVW.onConnected();
            this.mStatus = 5;
            o oVar2 = this.GVV.Hcw;
            oVar2.GXD = System.currentTimeMillis();
            e.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + oVar2.GXD);
            this.GVV.setSvrConfig(202, this.GVV.Hbl, this.GVV.Hbm, 0, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(203, 0, 0, this.GVV.Hbq, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(206, 0, 0, this.GVV.Hbu, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(103, this.GVV.Hbn, this.GVV.Hbo, this.GVV.Hbp, this.GVV.Hbs, 0, 0, 0, null);
            this.GVV.setSvrConfig(205, 0, 0, this.GVV.HbM, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(207, 0, 0, this.GVV.HaF, 0, 0, 0, 0, null);
            e.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.GVV.HbM + " SwitchFlag = " + this.GVV.HaF);
            int i3 = (this.GVV.Hbz >> 2) & 3;
            int i4 = this.GVV.Hbz & 3;
            if (this.GVV.ypO == 0) {
                i2 = (i3 << 2) + i4;
            } else {
                i2 = (i4 << 2) + i3;
            }
            this.GVV.setSvrConfig(502, 0, 0, i2, 0, 0, 0, 0, null);
            this.GVV.setSvrConfig(503, 0, 0, this.GVV.HbA, this.GVV.HbB, this.GVV.HbC, this.GVV.HbD, 0, null);
            if (!(this.GVV.HbR == null || this.GVV.HbS == null)) {
                this.GVV.setSvrConfig(504, 0, 0, this.GVV.HbQ, 0, 0, 0, 0, null);
                this.GVV.setSvrConfig(505, 0, 0, this.GVV.HbR[0], this.GVV.HbR[1], this.GVV.HbR[2], this.GVV.HbR[3], 0, null);
                this.GVV.setSvrConfig(506, 0, 0, this.GVV.HbS[0], this.GVV.HbS[1], 0, 0, 0, null);
                e.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.GVV.HbQ + ",FECKeyPara1 = " + ((int) this.GVV.HbR[0]) + "," + ((int) this.GVV.HbR[1]) + "," + ((int) this.GVV.HbR[2]) + "," + ((int) this.GVV.HbR[3]) + ",FECKeyPara2 = " + ((int) this.GVV.HbS[0]) + "," + ((int) this.GVV.HbS[1]));
            }
            this.GVV.setSvrConfig(507, 0, 0, (this.GVV.HbE & 4) >> 2, (this.GVV.HbE & 2) >> 1, this.GVV.HbE & 1, 0, 0, null);
            this.GVV.setjbmbitraterssvrparam();
            e.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.GVV.Hbl + ",audioTsdEdge = " + this.GVV.Hbm + ",passthroughQosAlgorithm = " + this.GVV.Hbn + ",fastPlayRepair = " + this.GVV.Hbo + ", audioDTX = " + this.GVV.Hbq + ", mARQFlag = " + i2 + ", mQosStrategy = " + this.GVV.HbE + ", mSvrCfgListV = " + this.GVV.Hbp + ", maxBRForRelay = " + this.GVV.Hbs);
            byte[] bArr2 = {(byte) ae.gKt.gGb, -1};
            e.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            e.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + ((int) bArr2[0]));
            this.GVV.setAppCmd(15, bArr2, 1);
            e.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.KyO);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.KyO);
            byte[] array = allocate.array();
            this.GVV.setAppCmd(505, array, 4);
            try {
                if (this.GVV != null) {
                    epd epd = new epd();
                    epd.NmY = 8;
                    epd.NmZ = new com.tencent.mm.bw.b(array);
                    e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version: ".concat(String.valueOf(array)));
                    this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                }
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "anlin send local client version Error!");
            }
            String str = Build.MODEL;
            int length = str.length();
            byte[] bytes = str.getBytes();
            e.Logi("MicroMsg.Voip.VoipContext", "anlin DeviceModel: ".concat(String.valueOf(bytes)));
            this.GVV.setAppCmd(507, bytes, length);
            try {
                if (this.GVV != null) {
                    epd epd2 = new epd();
                    epd2.NmY = 9;
                    epd2.NmZ = new com.tencent.mm.bw.b(bytes);
                    e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model: ".concat(String.valueOf(bytes)));
                    this.GVV.SendRUDP(epd2.toByteArray(), epd2.toByteArray().length);
                }
            } catch (Exception e3) {
                e.Logi("MicroMsg.Voip.VoipContext", "anlin send local device model Error!");
            }
            boolean z = ((this.GVV.HaF >> 17) & 1) != 0;
            boolean z2 = ((this.GVV.HaF >> 18) & 1) != 0;
            xb(z);
            e.Logi("MicroMsg.Voip.VoipContext", "EnableBlur: SetBlurFlag =47, aqBlur=" + z2);
            if (z2) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                allocate2.putInt(1);
                this.GVV.setAppCmd(47, allocate2.array(), 4);
            }
            if ((this.GVV.HaF & 2) == 0) {
                j(16, true, true);
                j(4, true, true);
            }
            int i5 = (this.GVV.HaF >> 12) & 1;
            ByteBuffer allocate3 = ByteBuffer.allocate(4);
            allocate3.order(ByteOrder.LITTLE_ENDIAN);
            allocate3.putInt(i5);
            e.Logi("MicroMsg.Voip.VoipContext", "weiranli set MixVcodec1 from svr = ".concat(String.valueOf(i5)));
            this.GVV.setAppCmd(46, allocate3.array(), 4);
            if ((this.GVV.HaF & 512) == 0) {
                ByteBuffer allocate4 = ByteBuffer.allocate(4);
                allocate4.order(ByteOrder.LITTLE_ENDIAN);
                allocate4.putInt(8);
                e.Logi("MicroMsg.Voip.VoipContext", "jcchen Disable 720p from svr: mSwitchFlag = " + this.GVV.HaF);
                this.GVV.setAppCmd(32, allocate4.array(), 4);
                this.GVV.setAppCmd(30, allocate4.array(), 4);
            }
            if ((this.GVV.HaF & 1048576) == 1) {
                e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable enble, mSwitchFlag: " + this.GVV.HaF);
                this.GVV.setAppCmd(52);
            } else {
                e.Logi("MicroMsg.Voip.VoipContext", "setAppCmd: EMethodSetP2SSendThreadEnable disable, mSwitchFlag: " + this.GVV.HaF);
            }
            if (ac.jPq != 0) {
                ByteBuffer allocate5 = ByteBuffer.allocate(4);
                allocate5.order(ByteOrder.LITTLE_ENDIAN);
                allocate5.putInt(ac.jPq);
                this.GVV.setAppCmd(36, allocate5.array(), 4);
            } else if (ac.jPr != 0) {
                if ((ac.jPr & 2) != 0) {
                    j(2, true, false);
                }
                if ((ac.jPr & 32) != 0) {
                    j(32, true, false);
                }
                if ((ac.jPr & 16) != 0) {
                    j(16, true, false);
                }
                if ((ac.jPr & 4) != 0) {
                    j(4, true, false);
                }
                if ((ac.jPr & 8) != 0) {
                    j(8, true, false);
                }
            }
            byte[] bArr3 = new byte[4];
            this.GVV.setAppCmd(26, bArr3, 4);
            ByteBuffer wrap = ByteBuffer.wrap(bArr3);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i6 = wrap.getInt();
            e.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(i6)));
            if (!((this.GVV.Hbp & 4) != 0 || ae.gKt.gGd > 0) && this.GVV.qtK) {
                e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
                boolean z3 = (i6 & 4) != 0;
                boolean z4 = (i6 & 8) != 0;
                if (z3 || z4) {
                    this.GVX.GWL = true;
                    aF(false, false);
                }
                this.GVV.qtK = false;
            }
            if (this.GVV.qtK) {
                v2protocal v2protocal = this.GVV;
                int i7 = ae.gKt.gGd;
                boolean z5 = false;
                boolean z6 = (i6 & 4) != 0;
                boolean z7 = (i6 & 8) != 0;
                if (z6 || z7) {
                    String str2 = z6 ? TPDecoderType.TP_CODEC_MIMETYPE_HEVC : "video/avc";
                    v2protocal.Hcz = new e(v2protocal.width, v2protocal.height, v2protocal.HcB, v2protocal.bitrate, i7, str2);
                    e.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(str2)));
                    if (v2protocal.HcC != null) {
                        v2protocal.HcA = new d(v2protocal.HcC);
                        e.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
                    }
                    z5 = true;
                }
                if (v2protocal.Hcz == null || v2protocal.HcA == null) {
                    v2protocal.qtK = false;
                    z5 = false;
                }
                e.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + z5 + ", iHW:" + i6);
                if (!this.GVV.qtK) {
                    e.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
                    this.GVX.GWL = true;
                    aF(false, false);
                    c(8, true, false, true);
                    c(8, true, false, false);
                }
            }
            if (this.GVV.Hcz != null) {
                this.GVV.Hcz.GSZ = this;
            }
            if (v2protocal.HcA != null) {
                v2protocal.HcA.a(this);
            }
            this.GVy = true;
            this.GWh = false;
            VoipScoreState voipScoreState = this.GWj;
            voipScoreState.yrb = bp.aVP();
            Log.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", Long.valueOf(voipScoreState.yrb));
            fGz();
            fGA();
            AppMethodBeat.o(114917);
            return;
        }
        e.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.GVv + ", isChannelConnectedSuccess " + this.GVt);
        AppMethodBeat.o(114917);
    }

    public final void aF(boolean z, boolean z2) {
        AppMethodBeat.i(235607);
        if (!z) {
            if (this.GVV != null) {
                if (this.GWi) {
                    e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
                    j(8, false, true);
                } else {
                    e.Logi("MicroMsg.Voip.VoipContext", "closecodec: remote i264 enc!");
                    c(8, false, true, true);
                }
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(6);
                e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
                this.GVV.setAppCmd(30, allocate.array(), 4);
                AppMethodBeat.o(235607);
                return;
            }
        } else if (this.GWi) {
            e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr old!!");
            adg(2);
            AppMethodBeat.o(235607);
            return;
        } else {
            e.Logi("MicroMsg.Voip.VoipContext", "closeRemoteHWEnc: DecErr new!!");
            if (z2) {
                c(4, true, false, false);
                AppMethodBeat.o(235607);
                return;
            }
            c(8, true, false, false);
        }
        AppMethodBeat.o(235607);
    }

    public final int j(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(114919);
        if (i2 < 0) {
            AppMethodBeat.o(114919);
            return -1;
        }
        e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + i2 + ", local=" + z + ", remote =" + z2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i2);
        if (z) {
            try {
                if (this.GVV != null) {
                    epd epd = new epd();
                    epd.NmY = 5;
                    epd.NmZ = new com.tencent.mm.bw.b(allocate.array());
                    e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(i2)));
                    this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                }
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
            }
        }
        if (z2) {
            e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(i2)));
            ByteBuffer allocate2 = ByteBuffer.allocate(6);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            allocate2.putShort(3);
            allocate2.putShort((short) i2);
            allocate2.putShort(0);
            this.GVV.setAppCmd(35, allocate2.array(), 6);
        }
        AppMethodBeat.o(114919);
        return 1;
    }

    public final int c(int i2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(184049);
        if (i2 < 0) {
            AppMethodBeat.o(184049);
            return -1;
        }
        e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec: targetCodec =" + i2 + ", local=" + z + ", remote =" + z2 + "encTag=" + z3);
        if (z && z3) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i2);
            try {
                if (this.GVV != null) {
                    epd epd = new epd();
                    epd.NmY = 6;
                    epd.NmZ = new com.tencent.mm.bw.b(allocate.array());
                    e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i2)));
                    this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                }
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(6);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            allocate2.putShort(2);
            allocate2.putShort((short) i2);
            allocate2.putShort(0);
            this.GVV.setAppCmd(39, allocate2.array(), 6);
        } else if (z && !z3) {
            ByteBuffer allocate3 = ByteBuffer.allocate(6);
            allocate3.order(ByteOrder.LITTLE_ENDIAN);
            allocate3.putShort(0);
            allocate3.putShort((short) i2);
            allocate3.putShort(0);
            this.GVV.setAppCmd(39, allocate3.array(), 6);
            ByteBuffer allocate4 = ByteBuffer.allocate(4);
            allocate4.order(ByteOrder.LITTLE_ENDIAN);
            allocate4.putInt(i2);
            try {
                if (this.GVV != null) {
                    epd epd2 = new epd();
                    epd2.NmY = 7;
                    epd2.NmZ = new com.tencent.mm.bw.b(allocate4.array());
                    e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i2)));
                    this.GVV.SendRUDP(epd2.toByteArray(), epd2.toByteArray().length);
                }
            } catch (Exception e3) {
                e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
            }
        } else if (z2 && z3) {
            e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:disable remote target codec: ".concat(String.valueOf(i2)));
            ByteBuffer allocate5 = ByteBuffer.allocate(6);
            allocate5.order(ByteOrder.LITTLE_ENDIAN);
            allocate5.putShort(3);
            allocate5.putShort((short) i2);
            allocate5.putShort(0);
            this.GVV.setAppCmd(39, allocate5.array(), 6);
            ByteBuffer allocate6 = ByteBuffer.allocate(4);
            allocate6.order(ByteOrder.LITTLE_ENDIAN);
            allocate6.putInt(i2);
            try {
                if (this.GVV != null) {
                    epd epd3 = new epd();
                    epd3.NmY = 7;
                    epd3.NmZ = new com.tencent.mm.bw.b(allocate6.array());
                    e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec:close local target codec: ".concat(String.valueOf(i2)));
                    this.GVV.SendRUDP(epd3.toByteArray(), epd3.toByteArray().length);
                }
            } catch (Exception e4) {
                e.Logi("MicroMsg.Voip.VoipContext", "CloseCodec Error");
            }
        }
        AppMethodBeat.o(184049);
        return 1;
    }

    private int xb(boolean z) {
        AppMethodBeat.i(235608);
        e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + z);
        if (z) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(1);
            try {
                if (this.GVV != null) {
                    epd epd = new epd();
                    epd.NmY = 10;
                    epd.NmZ = new com.tencent.mm.bw.b(allocate.array());
                    e.Logi("MicroMsg.Voip.VoipContext", "EnableAq: SetAqFlag =44, aqBlur=" + z);
                    this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                }
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "EnableAq Error");
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            allocate2.putInt(1);
            this.GVV.setAppCmd(44, allocate2.array(), 4);
        }
        AppMethodBeat.o(235608);
        return 1;
    }

    public final void aE(int i2, boolean z) {
        AppMethodBeat.i(114921);
        e.Logi("MicroMsg.Voip.VoipContext", "start bindSocket " + i2 + " ToNetwork " + this.zIU + " rebind " + z);
        if (this.zIU != null && com.tencent.mm.compatible.util.d.oD(23)) {
            FileDescriptor fileDescriptor = new FileDescriptor();
            try {
                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.setInt(fileDescriptor, i2);
                this.zIU.bindSocket(fileDescriptor);
                if (!z) {
                    this.zIW.add(Integer.valueOf(i2));
                }
                e.Logd("MicroMsg.Voip.VoipContext", "bindSocketToNetwork success: network" + this.zIU + "+socketfd" + i2);
                AppMethodBeat.o(114921);
                return;
            } catch (Exception e2) {
                e.Logi("MicroMsg.Voip.VoipContext", "bindSocketToNetwork Error");
            }
        }
        AppMethodBeat.o(114921);
    }

    public final boolean fGz() {
        int appCmd;
        AppMethodBeat.i(114922);
        boolean fGv = fGv();
        int i2 = 0;
        if (fGv) {
            i2 = 1;
        }
        e.Logd("MicroMsg.Voip.VoipContext", "needVideoOut ret: " + fGv + "videoStatus: " + i2 + ", sendVideoStatus: " + this.GVT);
        if (this.GVT == -1 || this.GVT != i2) {
            if (fGv) {
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                appCmd = this.GVV.setAppCmd(203);
            } else {
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                appCmd = this.GVV.setAppCmd(202);
            }
            if (appCmd == 0) {
                this.GVT = i2;
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + appCmd + "sendVideoStatus: " + this.GVT);
            }
        }
        AppMethodBeat.o(114922);
        return fGv;
    }

    public final boolean fGA() {
        int appCmd;
        AppMethodBeat.i(114923);
        boolean fGw = fGw();
        int i2 = 0;
        if (fGw) {
            i2 = 1;
        }
        e.Logd("MicroMsg.Voip.VoipContext", "needVideoIn ret: " + fGw + "videoStatus: " + i2 + ", recvVideoStatus: " + this.GVU);
        if (this.GVU == -1 || this.GVU != i2) {
            if (fGw) {
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                appCmd = this.GVV.setAppCmd(201);
            } else {
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                appCmd = this.GVV.setAppCmd(200);
            }
            if (appCmd == 0) {
                this.GVU = i2;
                e.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: succeed, ret: " + appCmd + "recvVideoStatus: " + this.GVU);
            }
        }
        AppMethodBeat.o(114923);
        return fGw;
    }

    private static boolean fGC() {
        AppMethodBeat.i(235609);
        int aon = m.aon();
        boolean z = (aon & 1024) != 0;
        int i2 = (aon >> 12) & 15;
        int i3 = aon & 255;
        int i4 = Build.VERSION.SDK_INT;
        long totalMemory = (com.tencent.matrix.g.a.getTotalMemory(MMApplicationContext.getContext()) / 1024) / 1024;
        boolean z2 = i2 >= ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_beauty_cpu_core_num_threshold, 4);
        boolean z3 = i3 >= ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_beauty_cpu_freq_threshold, 45);
        boolean z4 = i4 >= ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_beauty_sdkint_threadshold, 23);
        boolean z5 = totalMemory >= ((long) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_beauty_totalmem_threshold, 4096));
        double TL = com.tencent.matrix.g.a.TL();
        Debug.MemoryInfo bo = com.tencent.matrix.g.a.bo(MMApplicationContext.getContext());
        Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s, cpuRate:%s, dalvikPss:%s, nativePss:%s", Integer.valueOf(aon), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(totalMemory), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Double.valueOf(TL), Integer.valueOf(bo.dalvikPss), Integer.valueOf(bo.nativePss));
        if (!z || !z2 || !z3 || !z4 || !z5) {
            AppMethodBeat.o(235609);
            return false;
        }
        AppMethodBeat.o(235609);
        return true;
    }

    private static int fGD() {
        AppMethodBeat.i(184050);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_beauty_manufacture, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                i iVar = new i(a2);
                String str = Build.MANUFACTURER;
                int optInt = iVar.optInt(str, -1);
                Log.i("MicroMsg.Voip.VoipContext", "checkVoipBeautyManufactureConfig, config:%s, manufacture:%s, beautyCmd:%s", a2, str, Integer.valueOf(optInt));
                if (optInt >= 0) {
                    AppMethodBeat.o(184050);
                    return optInt;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Voip.VoipContext", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(184050);
        return 0;
    }

    public final void fGF() {
        int i2;
        AppMethodBeat.i(235610);
        boolean fGC = fGC();
        int i3 = ae.gKt.gGj;
        int i4 = (this.GVV.HaF >> 15) & 1;
        if (i3 > 0) {
            i2 = 1;
        } else if (!fGC || i4 <= 0) {
            i2 = 0;
        } else {
            i2 = i4;
        }
        if (this.GVW != null) {
            this.GVW.setSpatiotemporalDenosing(i2);
        }
        Log.i("MicroMsg.Voip.VoipContext", "hseasun: stfitler  voipSTFilterSvrCfg: %d, voipSTFilterWhiteList:%d voipSTFilterFlag:%d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
        this.GVV.HbY = i2;
        AppMethodBeat.o(235610);
    }

    public final void adg(int i2) {
        AppMethodBeat.i(114925);
        try {
            epd epd = new epd();
            epd.NmY = i2;
            if (1 == i2) {
                e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(6);
                epd.NmZ = new com.tencent.mm.bw.b(allocate.array());
                this.GVV.setAppCmd(32, allocate.array(), 4);
            } else {
                epd.NmZ = null;
            }
            this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
            e.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(i2)));
            AppMethodBeat.o(114925);
        } catch (Exception e2) {
            e.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
            AppMethodBeat.o(114925);
        }
    }

    public final void adh(int i2) {
        AppMethodBeat.i(114926);
        e.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i2 + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i2;
            this.GVV.setJNIAppCmd(2, bArr, 4);
            esu esu = new esu();
            esu.Nqs = i2;
            esu.Nqt = 1;
            epd epd = new epd();
            epd.NmY = 4;
            epd.NmZ = new com.tencent.mm.bw.b(esu.toByteArray(), 0, 1);
            this.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
            AppMethodBeat.o(114926);
        } catch (Exception e2) {
            e.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
            AppMethodBeat.o(114926);
        }
    }

    private void a(final d dVar) {
        AppMethodBeat.i(177020);
        if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4) {
            e.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
            AppMethodBeat.o(177020);
        } else if (this.GVr) {
            e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
            AppMethodBeat.o(177020);
        } else {
            c cVar = new c(this, (byte) 0);
            cVar.GWy = new b() {
                /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass11 */

                @Override // com.tencent.mm.plugin.voip.model.l.b
                public final void aC(final int i2, final int i3, final int i4) {
                    AppMethodBeat.i(114895);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass11.AnonymousClass1 */

                        public final void run() {
                            int length;
                            int length2;
                            AppMethodBeat.i(114894);
                            e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
                            int i2 = (((l.this.GVV.Hbz >> 2) & 3) >> 1) & 1 & ((l.this.GVV.Hbz & 3) >> 1) & 1;
                            v2protocal v2protocal = l.this.GVV;
                            int i3 = l.this.GVV.Hav;
                            long j2 = (long) l.this.GVV.roomId;
                            int i4 = l.this.GVV.ypO;
                            long j3 = l.this.GVV.ypH;
                            byte[] bArr = l.this.GVV.Hax;
                            int i5 = l.this.GVV.channelStrategy;
                            int i6 = l.this.GVV.HaC;
                            int i7 = l.this.GVV.HaD;
                            int i8 = l.this.GVV.HaA;
                            if (l.this.GVV.HaB == null) {
                                length = 0;
                            } else {
                                length = l.this.GVV.HaB.length;
                            }
                            byte[] bArr2 = l.this.GVV.HaB;
                            int i9 = l.this.GVV.HaE;
                            int i10 = l.this.GVV.Hau;
                            int i11 = l.this.GVV.HbJ;
                            byte[] bArr3 = l.this.GVV.HbK;
                            int i12 = l.this.GVV.HbL;
                            int i13 = l.this.GVV.HaF;
                            if (l.this.GVV.HaG == null) {
                                length2 = 0;
                            } else {
                                length2 = l.this.GVV.HaG.length;
                            }
                            int configInfo = v2protocal.setConfigInfo(i3, j2, i4, j3, bArr, i5, i6, i7, i8, length, bArr2, i9, i2, i10, i11, bArr3, i12, i13, length2, l.this.GVV.HaG, l.this.GVV.HbM, i2, i4, i3, "", "", v2protocal.fJa());
                            if (configInfo < 0) {
                                e.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(configInfo)));
                                l.this.GVV.Hcw.GXc = 14;
                                l.this.K(1, -9002, "");
                                dVar.fGL();
                                AppMethodBeat.o(114894);
                            } else if (l.this.GVV.HbZ == null) {
                                e.Loge("MicroMsg.Voip.VoipContext", "relay conns buf null");
                                l.this.K(1, -9002, "");
                                dVar.fGL();
                                AppMethodBeat.o(114894);
                            } else {
                                int AddNewRelayConns = l.this.GVV.AddNewRelayConns(l.this.GVV.HbZ, l.this.GVV.HbZ.length, 0);
                                if (AddNewRelayConns < 0) {
                                    e.Loge("MicroMsg.Voip.VoipContext", "add relayconns err:".concat(String.valueOf(AddNewRelayConns)));
                                    l.this.K(1, -9002, "");
                                    dVar.fGL();
                                    AppMethodBeat.o(114894);
                                    return;
                                }
                                l.this.GVr = true;
                                l.this.GVV.Hcw.GXj = 1;
                                l.this.GVV.Hcw.GXr = 1;
                                dVar.fGL();
                                AppMethodBeat.o(114894);
                            }
                        }
                    });
                    AppMethodBeat.o(114895);
                }
            };
            com.tencent.f.h.RTc.aX(cVar);
            AppMethodBeat.o(177020);
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        int GWw;
        int GWx;
        b GWy;
        int oXT;

        private c() {
            this.GWw = 0;
            this.GWx = 0;
        }

        /* synthetic */ c(l lVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(114898);
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null && defaultHost.length() > 0 && defaultPort > 0) {
                this.oXT = 1;
                this.GWw = defaultPort;
                try {
                    this.GWx = e.aCD(InetAddress.getByName(defaultHost).getHostAddress());
                } catch (UnknownHostException e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipContext", e2, "", new Object[0]);
                }
            }
            this.GWy.aC(this.oXT, this.GWw, this.GWx);
            AppMethodBeat.o(114898);
        }
    }

    public final void fGG() {
        AppMethodBeat.i(177021);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(114896);
                if (l.this.mStatus != 4 && l.this.mStatus != 5 && l.this.mStatus != 6) {
                    e.Logi("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + l.this.mStatus);
                    AppMethodBeat.o(114896);
                } else if (l.this.GVs) {
                    e.Logi("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
                    AppMethodBeat.o(114896);
                } else {
                    l.this.GVs = true;
                    e.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
                    if (l.this.GVV.Hca == null) {
                        e.Loge("MicroMsg.Voip.VoipContext", "direct conns buf null");
                        AppMethodBeat.o(114896);
                        return;
                    }
                    int AddNewDirectConns = l.this.GVV.AddNewDirectConns(l.this.GVV.Hca, l.this.GVV.Hca.length, 0);
                    if (AddNewDirectConns < 0) {
                        e.Loge("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:".concat(String.valueOf(AddNewDirectConns)));
                        AppMethodBeat.o(114896);
                        return;
                    }
                    l.this.fGJ();
                    AppMethodBeat.o(114896);
                }
            }
        });
        AppMethodBeat.o(177021);
    }

    public final void fGH() {
        AppMethodBeat.i(177022);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(114897);
                e.Logi("MicroMsg.Voip.VoipContext", "v2protocal QueryNicWanIp");
                if (!(l.this.zIU == null || l.this.GVV.Hcb == null)) {
                    int QueryNicWanIp = l.this.GVV.QueryNicWanIp(l.this.GVV.Hcb, l.this.GVV.Hcb.length);
                    if (QueryNicWanIp != 0) {
                        e.Loge("MicroMsg.Voip.VoipContext", "query nic wan ip fail ret:".concat(String.valueOf(QueryNicWanIp)));
                    } else {
                        AppMethodBeat.o(114897);
                        return;
                    }
                }
                l.this.elW();
                AppMethodBeat.o(114897);
            }
        });
        AppMethodBeat.o(177022);
    }

    public final void fGI() {
        AppMethodBeat.i(114928);
        boolean z = !Util.isNullOrNil(this.GVV.Hax);
        e.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + z + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.GVx + ",isRemoteAccepted:" + this.GVu + ",isLocalAccept:" + this.dWM);
        this.GVV.Hcw.GXo = 7;
        if (z && (this.mStatus == 4 || this.mStatus == 5 || this.mStatus == 6 || ((this.mStatus == 2 && this.GVx) || (this.mStatus == 3 && this.GVx)))) {
            if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
                e.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
                AppMethodBeat.o(114928);
                return;
            } else if (this.GVu || this.dWM) {
                if (!this.GVr) {
                    a(new d() {
                        /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.voip.model.l.d
                        public final void fGL() {
                            AppMethodBeat.i(177017);
                            Log.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
                            l.this.fGG();
                            l.this.fGH();
                            AppMethodBeat.o(177017);
                        }
                    });
                    AppMethodBeat.o(114928);
                    return;
                }
                fGG();
                fGH();
            } else if (this.GVx && !this.GVr) {
                a(new d() {
                    /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.voip.model.l.d
                    public final void fGL() {
                        AppMethodBeat.i(177016);
                        Log.i("MicroMsg.Voip.VoipContext", "onStartConnectRelay ok");
                        AppMethodBeat.o(177016);
                    }
                });
                AppMethodBeat.o(114928);
                return;
            }
        }
        AppMethodBeat.o(114928);
    }

    public final void fGJ() {
        AppMethodBeat.i(114929);
        if (this.GVs && !Util.isNullOrNil(this.GVV.Haz)) {
            int handleCommand = this.GVV.handleCommand(1, this.GVV.Haz, this.GVV.Haz.length);
            if (handleCommand < 0) {
                e.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(handleCommand)));
            }
            this.GVV.Haz = null;
        }
        AppMethodBeat.o(114929);
    }

    public final void ci(byte[] bArr) {
        AppMethodBeat.i(114930);
        Log.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.GVV.Hcw.GXh = 1;
        this.GVV.Hcw.GXg = 1;
        this.GVV.Hax = bArr;
        AppMethodBeat.o(114930);
    }

    public final void c(int i2, byte[] bArr, byte[] bArr2) {
        this.GVV.HbQ = i2;
        this.GVV.HbR = bArr;
        this.GVV.HbS = bArr2;
    }

    public final void a(byte[] bArr, int i2, int i3, byte[] bArr2) {
        this.GVV.HaA = i2;
        this.GVV.HaB = bArr;
        this.GVV.HbJ = i3;
        this.GVV.HbK = bArr2;
    }

    public final void adi(int i2) {
        this.GVV.HbL = i2;
    }

    public final void k(int i2, int i3, int i4, int i5, int i6) {
        this.GVV.Hbz = i2;
        this.GVV.HbA = i3;
        this.GVV.HbB = i4;
        this.GVV.HbC = i5;
        this.GVV.HbD = i6;
    }

    public final void adj(int i2) {
        this.GVV.HbE = i2;
    }

    public final void cj(byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(114932);
        Log.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", Byte.valueOf(this.GVV.Hcw.GXl));
        if (this.GVV.Hcw.GXl == 1 || bArr == null) {
            AppMethodBeat.o(114932);
            return;
        }
        this.GVV.Hcw.GXl = 1;
        this.GVV.Hay = bArr;
        if (this.GVV.Hay != null) {
            int exchangeCabInfo = this.GVV.exchangeCabInfo(this.GVV.Hay, this.GVV.Hay.length);
            if (this.GVV.Hay == null || this.GVV.Hay.length < 36) {
                z = true;
            }
            this.GWi = z;
            if (exchangeCabInfo < 0) {
                e.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(exchangeCabInfo)));
                this.GVV.Hcw.GXc = 15;
                K(1, -9003, "");
            }
        }
        AppMethodBeat.o(114932);
    }

    public final void adk(int i2) {
        this.GVV.Hcw.GXi = 1;
        this.GVV.channelStrategy = i2;
    }

    public final void adl(int i2) {
        this.GVV.HaE = i2;
    }

    public final void ck(byte[] bArr) {
        AppMethodBeat.i(114933);
        this.GVV.Haz = bArr;
        fGJ();
        AppMethodBeat.o(114933);
    }

    public final void fGK() {
        AppMethodBeat.i(114934);
        Log.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.GWl.stopTimer();
        AppMethodBeat.o(114934);
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        AppMethodBeat.i(114935);
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            AppMethodBeat.o(114935);
            return booleanValue;
        } catch (Exception e2) {
            AppMethodBeat.o(114935);
            return false;
        }
    }

    public final int bu(LinkedList<csu> linkedList) {
        AppMethodBeat.i(114936);
        LinkedList<csu> linkedList2 = new LinkedList<>();
        int bv = this.GVV.bv(linkedList2);
        if (bv == 0) {
            if (linkedList2.size() == 0 || linkedList2.size() > 2) {
                AppMethodBeat.o(114936);
                return 0;
            } else if (linkedList2.get(0).MxQ == 1 && linkedList2.get(0).Loh == 5) {
                linkedList.add(linkedList2.get(0));
                this.GVV.Hbc = 1;
                AppMethodBeat.o(114936);
                return 0;
            } else {
                linkedList.add(linkedList2.get(0));
                this.GVV.Hbb = 1;
                if (!a((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity"))) {
                    Log.i("MicroMsg.Voip.VoipContext", "mobile network not connectedorconnecting");
                    AppMethodBeat.o(114936);
                    return 0;
                }
                String simOperator = ((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
                if (simOperator == null || simOperator.length() < 3) {
                    Log.i("MicroMsg.Voip.VoipContext", "nic_op NULL");
                    AppMethodBeat.o(114936);
                    return 0;
                }
                csu csu = new csu();
                csu.LYu = "android-cellular";
                csu.MxQ = 0;
                csu.Loh = 5;
                csu.MxR = simOperator.substring(0, 3) + ":" + simOperator.substring(3, simOperator.length());
                linkedList.add(csu);
                this.GVV.Hbc = 1;
            }
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            Log.d("MicroMsg.Voip.VoipContext", "nic_name:" + linkedList.get(i2).LYu + " nic_role:" + linkedList.get(i2).MxQ + " net_type:" + linkedList.get(i2).Loh + " nic_isp_info:" + linkedList.get(i2).MxR);
        }
        AppMethodBeat.o(114936);
        return bv;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.GWp = aVar;
        }
    }

    public final void K(int i2, int i3, String str) {
        AppMethodBeat.i(114937);
        fGK();
        if (this.GWp != null) {
            this.GWp.K(i2, i3, str);
        }
        AppMethodBeat.o(114937);
    }

    /* access modifiers changed from: package-private */
    public final void fGB() {
        AppMethodBeat.i(114924);
        if (this.mStatus == 5) {
            setStatus(6);
            this.GVV.Hcw.fGR();
            e.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.l.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(114892);
                    l.this.GVW.fFS();
                    AppMethodBeat.o(114892);
                }
            });
        }
        AppMethodBeat.o(114924);
    }

    public final void fGE() {
        int i2;
        boolean z;
        AppMethodBeat.i(184051);
        boolean fGC = fGC();
        int i3 = ae.gKt.gGh;
        int i4 = ae.gKt.gGi;
        int i5 = (((this.GVV.HaF >> 11) & 1) << 3) | ((this.GVV.HaF >> 4) & 7);
        if (fGC) {
            i2 = fGD();
        } else {
            i2 = 0;
        }
        if (i4 < 0 && i3 < 0) {
            if (fGC && i5 > 0) {
                z = false;
                i2 = i5;
            }
            z = false;
        } else if (i3 >= 0) {
            z = true;
            i2 = i3;
        } else {
            if (i5 == 0) {
                z = true;
                i2 = i4;
            }
            z = false;
        }
        Log.printInfoStack("MicroMsg.Voip.VoipContext", "setVoipBeautyConfig local:%s, server:%s , blacklist:%s, whitelist:%s, voipBeautyFlag:%s, uiCallback:%s and isHitBlackListOrWhitList:%s", Boolean.valueOf(fGC), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), this.GVW, Boolean.valueOf(z));
        if (!z && i2 == 0 && com.tencent.mm.plugin.voip.b.g.fKl()) {
            i2 = com.tencent.mm.plugin.voip.b.g.fKk();
            i5 = com.tencent.mm.plugin.voip.b.g.fKk();
        }
        if (this.GVW != null) {
            this.GVW.setVoipBeauty(i2);
        }
        this.GVV.HbW = i2;
        this.GVV.HbX = i5;
        AppMethodBeat.o(184051);
    }
}
