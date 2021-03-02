package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.sns.ad.d.a.c;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AdLandingPagesProxy extends com.tencent.mm.remoteservice.a {
    private static AdLandingPagesProxy DGl;
    public static f DGn = new f();
    private Map<q, Long> DGm = new HashMap();
    private ConcurrentHashMap<Long, ArrayList<a>> DGo = new ConcurrentHashMap<>();
    private a.b DGp = new a.b() {
        /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void progress(long j2, int i2) {
            AppMethodBeat.i(202665);
            Log.v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i2));
            AdLandingPagesProxy.this.CLIENT_CALL("progress", Long.valueOf(j2), Integer.valueOf(i2));
            AppMethodBeat.o(202665);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void paused(long j2) {
            AppMethodBeat.i(202666);
            AdLandingPagesProxy.this.CLIENT_CALL("paused", Long.valueOf(j2));
            AppMethodBeat.o(202666);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void stopped(long j2) {
            AppMethodBeat.i(202667);
            AdLandingPagesProxy.this.CLIENT_CALL("stopped", Long.valueOf(j2));
            AppMethodBeat.o(202667);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void succeed(long j2) {
            AppMethodBeat.i(202668);
            AdLandingPagesProxy.this.CLIENT_CALL(StateEvent.ProcessResult.SUCCEED, Long.valueOf(j2));
            AppMethodBeat.o(202668);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void failed(long j2) {
            AppMethodBeat.i(202669);
            AdLandingPagesProxy.this.CLIENT_CALL(StateEvent.ProcessResult.FAILED, Long.valueOf(j2));
            AppMethodBeat.o(202669);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b
        public final void resumed(long j2) {
            AppMethodBeat.i(202670);
            AdLandingPagesProxy.this.CLIENT_CALL("resumed", Long.valueOf(j2));
            AppMethodBeat.o(202670);
        }
    };
    private Map<String, g> DGq = new HashMap();
    private Map<String, h.a> DGr = new HashMap();
    private com.tencent.mm.remoteservice.d Dxo;
    private Map<Long, e> callbacks = new HashMap();
    private i gNh = new i() {
        /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            int i4;
            String str2;
            byte[] bArr4;
            String str3;
            byte[] bArr5;
            String str4;
            AppMethodBeat.i(95209);
            Log.i("AdLandingPagesProxy", "onSceneEnd, funcId=" + (qVar == null ? 0 : qVar.getType()) + ", errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
            if (qVar instanceof j) {
                if (i2 == 0 && i3 == 0) {
                    String str5 = ((j) qVar).jsonString;
                    Log.i("AdLandingPagesProxy", "the dynamic string is " + str5 + ", sceneType is " + qVar.getType());
                    str4 = str5;
                } else {
                    Log.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i2 + " error msg is " + str + " sceneType is " + qVar.getType());
                    str4 = "";
                }
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    AdLandingPagesProxy.this.CLIENT_CALL("onDynamicUpdateEnd", Long.valueOf(((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue()), str4);
                    com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                }
                AppMethodBeat.o(95209);
                return;
            }
            if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    try {
                        long longValue = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        Log.i("AdLandingPagesProxy", "NetSceneAdChannelPkgInfo onSceneEnd, id %d", Long.valueOf(longValue));
                        xc xcVar = (xc) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && xcVar != null) {
                            bArr5 = xcVar.toByteArray();
                        } else {
                            bArr5 = null;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onAdChannelEnd", Long.valueOf(longValue), Integer.valueOf(i2), Integer.valueOf(i3), bArr5);
                        com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                        AppMethodBeat.o(95209);
                        return;
                    } catch (Exception e2) {
                        Log.e("AdLandingPagesProxy", Util.stackTraceToString(e2));
                        AppMethodBeat.o(95209);
                        return;
                    }
                }
            } else if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i) {
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    long longValue2 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                    AdLandingPagesProxy adLandingPagesProxy = AdLandingPagesProxy.this;
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(longValue2);
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i iVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i) qVar;
                    if (iVar.EiS != null) {
                        str3 = iVar.EiS;
                    } else {
                        str3 = "";
                    }
                    objArr[1] = str3;
                    objArr[2] = Integer.valueOf(i2);
                    objArr[3] = Integer.valueOf(i3);
                    adLandingPagesProxy.CLIENT_CALL("onFavOfficialItemEnd", objArr);
                    com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                    AppMethodBeat.o(95209);
                    return;
                }
            } else if (qVar instanceof com.tencent.mm.plugin.sns.ad.g.h) {
                Log.i("AdLandingPagesProxy", "real time report done.");
                com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                AppMethodBeat.o(95209);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e) {
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    try {
                        long longValue3 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        Log.i("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd, id %d", Long.valueOf(longValue3));
                        box box = (box) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && box != null) {
                            bArr4 = box.toByteArray();
                        } else {
                            bArr4 = null;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onGetSmartPhoneScene", Long.valueOf(longValue3), Integer.valueOf(i2), Integer.valueOf(i3), bArr4);
                        com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                        AppMethodBeat.o(95209);
                        return;
                    } catch (Exception e3) {
                        Log.e("AdLandingPagesProxy", "NetSceneAdGetSmartPhoneNumber onSceneEnd exp=" + e3.toString());
                        AppMethodBeat.o(95209);
                        return;
                    }
                }
            } else if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g) {
                try {
                    Log.i("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd, errType=" + i2 + ", errCode=" + i3);
                    com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                    AppMethodBeat.o(95209);
                    return;
                } catch (Exception e4) {
                    Log.e("AdLandingPagesProxy", "NetSceneAdLadingPageClick onSceneEnd exp=" + e4.toString());
                    AppMethodBeat.o(95209);
                    return;
                }
            } else if (qVar instanceof l) {
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    try {
                        long longValue4 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        Log.i("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd, id %d", Long.valueOf(longValue4));
                        emn emn = (emn) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && emn != null) {
                            str2 = emn.gTk;
                        } else {
                            str2 = "";
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onUpdateUxInfo", Long.valueOf(longValue4), Integer.valueOf(i2), Integer.valueOf(i3), str2);
                        com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                        AppMethodBeat.o(95209);
                        return;
                    } catch (Exception e5) {
                        Log.e("AdLandingPagesProxy", "NetSceneUpdateUxInfo onSceneEnd exp=" + e5.toString());
                        AppMethodBeat.o(95209);
                        return;
                    }
                }
            } else if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d) {
                if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                    long longValue5 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                    Log.i("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd, id %d", Long.valueOf(longValue5));
                    try {
                        dic dic = (dic) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && dic != null) {
                            i4 = dic.state;
                        } else {
                            i4 = -1;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onGetHbCoverStateScene", Long.valueOf(longValue5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                        AppMethodBeat.o(95209);
                        return;
                    } catch (Exception e6) {
                        Log.e("AdLandingPagesProxy", "NetSceneAdGetHbCoverState onSceneEnd exp=" + e6.toString());
                        AppMethodBeat.o(95209);
                        return;
                    }
                }
            } else if (qVar instanceof k) {
                try {
                    if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                        long longValue6 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        Log.i("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd, id %d", Long.valueOf(longValue6));
                        btl btl = (btl) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && btl != null) {
                            bArr3 = btl.toByteArray();
                        } else {
                            bArr3 = null;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onAdUpdateQrUrlEnd", Long.valueOf(longValue6), Integer.valueOf(i2), Integer.valueOf(i3), bArr3);
                        com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                    }
                    AppMethodBeat.o(95209);
                    return;
                } catch (Throwable th) {
                    Log.e("AdLandingPagesProxy", "NetSceneUpdateQrUrl onSceneEnd exp=" + th.toString());
                    AppMethodBeat.o(95209);
                    return;
                }
            } else if ((qVar instanceof com.tencent.mm.openim.b.b) || (qVar instanceof p)) {
                try {
                    if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                        Log.d("AdLandingPagesProxy", "onSceneEnd, errType = " + i2 + ", errCode = " + i3 + "," + str);
                        long longValue7 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        if (qVar.getType() != 30 && qVar.getType() != 667) {
                            Log.w("AdLandingPagesProxy", "not expected scene,  type = " + qVar.getType());
                            AppMethodBeat.o(95209);
                            return;
                        } else if (!(qVar instanceof p) || ((p) qVar).dKy == 1) {
                            String str6 = "";
                            JSONObject jSONObject = new JSONObject();
                            if (i2 == 0 && i3 == 0) {
                                if (qVar.getType() == 30) {
                                    str6 = ((p) qVar).gmD();
                                } else if (qVar.getType() == 667) {
                                    str6 = ((com.tencent.mm.openim.b.b) qVar).jGZ;
                                }
                            }
                            jSONObject.put("errMsg", str);
                            jSONObject.put("respUsername", str6);
                            AdLandingPagesProxy.this.CLIENT_CALL("onAddBrandSceneEnd", Long.valueOf(longValue7), Integer.valueOf(i2), Integer.valueOf(i3), jSONObject.toString());
                            b.e(AdLandingPagesProxy.this.gNh);
                        } else {
                            Log.e("AdLandingPagesProxy", "not opcode addcontact!");
                            AppMethodBeat.o(95209);
                            return;
                        }
                    }
                    AppMethodBeat.o(95209);
                    return;
                } catch (Throwable th2) {
                    Log.e("AdLandingPagesProxy", "NetSceneAddOpenIMContact or NetSceneVerifyUser onSceneEnd exp=" + th2.toString());
                    AppMethodBeat.o(95209);
                    return;
                }
            } else if (qVar instanceof com.tencent.mm.plugin.messenger.a.f) {
                try {
                    if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                        long longValue8 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        drt drt = (drt) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && drt != null) {
                            bArr2 = drt.toByteArray();
                        } else {
                            bArr2 = null;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", Long.valueOf(longValue8), Integer.valueOf(i2), Integer.valueOf(i3), bArr2);
                    }
                } catch (Throwable th3) {
                    Log.e("AdLandingPagesProxy", "NetSceneSearchContact, onSceneEnd exp=" + th3.toString());
                }
                com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                AppMethodBeat.o(95209);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a) {
                try {
                    if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                        long longValue9 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        bq bqVar = (bq) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        if (i2 == 0 && i3 == 0 && bqVar != null) {
                            bArr = bqVar.toByteArray();
                        } else {
                            bArr = null;
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onAdNativeAntiAbuse", Long.valueOf(longValue9), Integer.valueOf(i2), Integer.valueOf(i3), bArr);
                    }
                } catch (Throwable th4) {
                    Log.e("AdLandingPagesProxy", "NetSceneAdAntiAbuse, onSceneEnd exp = " + th4.toString());
                }
                com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
                AppMethodBeat.o(95209);
                return;
            } else if (qVar != null) {
                try {
                    if (AdLandingPagesProxy.this.DGm.containsKey(qVar)) {
                        long longValue10 = ((Long) AdLandingPagesProxy.this.DGm.remove(qVar)).longValue();
                        com.tencent.mm.bw.a aVar = ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                        byte[] bArr6 = null;
                        if (i2 == 0 && i3 == 0 && aVar != null) {
                            bArr6 = aVar.toByteArray();
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onRspCallbackCommon", Long.valueOf(longValue10), Integer.valueOf(i2), Integer.valueOf(i3), bArr6);
                    }
                } catch (Throwable th5) {
                    Log.e("AdLandingPagesProxy", "default, onSceneEnd exp=" + th5.toString());
                }
                com.tencent.mm.kernel.g.azz().b(qVar.getType(), AdLandingPagesProxy.this.gNh);
            }
            AppMethodBeat.o(95209);
        }
    };

    public interface a {
        void Yr(int i2);

        void eZP();

        void eZQ();

        void eZR();

        void eZS();

        void eZT();

        void start();
    }

    public interface e {
        void bn(Object obj);

        void h(int i2, int i3, Object obj);
    }

    public static class f {
        boolean DGx = false;
        long lastUpdateTime = 0;
    }

    public interface g {
        void eWO();

        void eZU();
    }

    static {
        AppMethodBeat.i(95375);
        AppMethodBeat.o(95375);
    }

    public com.tencent.mm.remoteservice.d getRemoteServiceProxy() {
        return this.Dxo;
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.i(95226);
        this.Dxo.connect(runnable);
        AppMethodBeat.o(95226);
    }

    public AdLandingPagesProxy(com.tencent.mm.remoteservice.d dVar) {
        super(dVar);
        AppMethodBeat.i(95227);
        this.Dxo = dVar;
        AppMethodBeat.o(95227);
    }

    public static AdLandingPagesProxy getInstance() {
        AppMethodBeat.i(95228);
        if (DGl == null) {
            DGl = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
        }
        AdLandingPagesProxy adLandingPagesProxy = DGl;
        AppMethodBeat.o(95228);
        return adLandingPagesProxy;
    }

    public boolean isConnected() {
        AppMethodBeat.i(95229);
        if (this.Dxo == null) {
            AppMethodBeat.o(95229);
            return false;
        }
        boolean isConnected = this.Dxo.isConnected();
        AppMethodBeat.o(95229);
        return isConnected;
    }

    public Object getCfg(int i2, Object obj) {
        AppMethodBeat.i(95230);
        Object REMOTE_CALL = REMOTE_CALL("getCfgMM", Integer.valueOf(i2), obj);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95230);
            return obj;
        }
        AppMethodBeat.o(95230);
        return REMOTE_CALL;
    }

    @com.tencent.mm.remoteservice.f
    public Object getCfgMM(int i2, Object obj) {
        AppMethodBeat.i(95231);
        com.tencent.mm.kernel.g.aAi();
        Object obj2 = com.tencent.mm.kernel.g.aAh().azQ().get(i2, obj);
        AppMethodBeat.o(95231);
        return obj2;
    }

    public int contactGetTypeTextFromUserName(String str) {
        AppMethodBeat.i(95232);
        Object REMOTE_CALL = REMOTE_CALL("contactGetTypeTextFromUserNameMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95232);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95232);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int contactGetTypeTextFromUserNameMM(String str) {
        AppMethodBeat.i(95233);
        int JG = ab.JG(str);
        AppMethodBeat.o(95233);
        return JG;
    }

    public String getSnsStatExtBySnsId(long j2) {
        AppMethodBeat.i(95234);
        String str = (String) REMOTE_CALL("getSnsStatExtBySnsIdMM", Long.valueOf(j2));
        AppMethodBeat.o(95234);
        return str;
    }

    public String getAccSnsPath() {
        AppMethodBeat.i(95236);
        String str = (String) REMOTE_CALL("getAccSnsPathMM", new Object[0]);
        AppMethodBeat.o(95236);
        return str;
    }

    @com.tencent.mm.remoteservice.f
    public String getAccSnsPathMM() {
        AppMethodBeat.i(95237);
        String accSnsPath = aj.getAccSnsPath();
        AppMethodBeat.o(95237);
        return accSnsPath;
    }

    public String getSnsAid(String str) {
        AppMethodBeat.i(95238);
        String str2 = (String) REMOTE_CALL("getSnsAidMM", str);
        AppMethodBeat.o(95238);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsAidMM(String str) {
        AppMethodBeat.i(95239);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String aid = aQl.getAid();
            AppMethodBeat.o(95239);
            return aid;
        }
        AppMethodBeat.o(95239);
        return "";
    }

    public int getSnsAdType(String str) {
        AppMethodBeat.i(95240);
        Object REMOTE_CALL = REMOTE_CALL("getSnsAdTypeMM", str);
        if (REMOTE_CALL instanceof Number) {
            int intValue = ((Number) REMOTE_CALL).intValue();
            AppMethodBeat.o(95240);
            return intValue;
        }
        AppMethodBeat.o(95240);
        return 0;
    }

    @com.tencent.mm.remoteservice.f
    public int getSnsAdTypeMM(String str) {
        AppMethodBeat.i(95241);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            int adType = aQl.getAdType();
            AppMethodBeat.o(95241);
            return adType;
        }
        AppMethodBeat.o(95241);
        return 0;
    }

    public void confirmDialPhoneNum(Activity activity, String str) {
        AppMethodBeat.i(95242);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(95242);
            return;
        }
        Intent intent = new Intent(MMApplicationContext.getContext(), SnsTransparentUI.class);
        intent.putExtra("phoneNum", str);
        intent.putExtra("op", 4);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "confirmDialPhoneNum", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(95242);
    }

    public String getSnsTraceid(String str) {
        AppMethodBeat.i(95243);
        String str2 = (String) REMOTE_CALL("getSnsTraceidMM", str);
        AppMethodBeat.o(95243);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsTraceidMM(String str) {
        AppMethodBeat.i(95244);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String traceid = aQl.getTraceid();
            AppMethodBeat.o(95244);
            return traceid;
        }
        AppMethodBeat.o(95244);
        return "";
    }

    public String getSnsUxInfo(String str) {
        AppMethodBeat.i(95245);
        String str2 = (String) REMOTE_CALL("getSnsUxInfoMM", str);
        AppMethodBeat.o(95245);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsUxInfoMM(String str) {
        AppMethodBeat.i(95246);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String uxinfo = aQl.getUxinfo();
            AppMethodBeat.o(95246);
            return uxinfo;
        }
        AppMethodBeat.o(95246);
        return "";
    }

    public boolean isRecExpAd(String str) {
        AppMethodBeat.i(95247);
        Object REMOTE_CALL = REMOTE_CALL("isRecExpAdMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95247);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95247);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isRecExpAdMM(String str) {
        AppMethodBeat.i(95248);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl == null) {
            AppMethodBeat.o(95248);
            return false;
        }
        boolean isRecExpAd = aQl.isRecExpAd();
        AppMethodBeat.o(95248);
        return isRecExpAd;
    }

    public SnsInfo getSnsInfo(String str) {
        Bundle bundle;
        AppMethodBeat.i(95249);
        try {
            bundle = (Bundle) REMOTE_CALL("getSnsInfoMM", str);
            if (bundle == null) {
                AppMethodBeat.o(95249);
                return null;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("AdLandingPagesProxy", e2, "", new Object[0]);
            bundle = null;
        }
        SnsInfo snsInfo = new SnsInfo();
        snsInfo.readFromBundle(bundle);
        AppMethodBeat.o(95249);
        return snsInfo;
    }

    @com.tencent.mm.remoteservice.f
    public Bundle getSnsInfoMM(String str) {
        AppMethodBeat.i(95250);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl == null) {
            AppMethodBeat.o(95250);
            return null;
        }
        Bundle writeToBundle = aQl.writeToBundle();
        AppMethodBeat.o(95250);
        return writeToBundle;
    }

    public String getUin() {
        AppMethodBeat.i(95251);
        Object REMOTE_CALL = REMOTE_CALL("getUinMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95251);
            return "";
        }
        String str = (String) REMOTE_CALL;
        AppMethodBeat.o(95251);
        return str;
    }

    @com.tencent.mm.remoteservice.f
    public String getUinMM() {
        AppMethodBeat.i(95252);
        com.tencent.mm.kernel.g.aAf();
        String ayV = com.tencent.mm.kernel.a.ayV();
        AppMethodBeat.o(95252);
        return ayV;
    }

    public boolean useOnlineStreamPlayer() {
        AppMethodBeat.i(95253);
        Object REMOTE_CALL = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95253);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95253);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean useOnlineStreamPlayerMM() {
        AppMethodBeat.i(95254);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100208");
        if (Fu.isValid()) {
            int i2 = Util.getInt(Fu.gzz().get("useOnlineVideoPlayer"), 0);
            Log.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=".concat(String.valueOf(i2)));
            if (i2 == 1) {
                AppMethodBeat.o(95254);
                return true;
            }
            AppMethodBeat.o(95254);
            return false;
        }
        AppMethodBeat.o(95254);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public int getExpValueByKeyMM(String str, int i2) {
        AppMethodBeat.i(95255);
        int gO = com.tencent.mm.model.c.d.aXv().gO(str, i2);
        AppMethodBeat.o(95255);
        return gO;
    }

    public int getExpValueByKey(String str, int i2) {
        AppMethodBeat.i(95256);
        Object REMOTE_CALL = REMOTE_CALL("getExpValueByKeyMM", str, Integer.valueOf(i2));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95256);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95256);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public String getExpIdByKeyMM(String str) {
        AppMethodBeat.i(95257);
        String expIdByKey = com.tencent.mm.model.c.d.aXv().getExpIdByKey(str);
        AppMethodBeat.o(95257);
        return expIdByKey;
    }

    public String getExpIdByKey(String str) {
        AppMethodBeat.i(95258);
        String str2 = (String) REMOTE_CALL("getExpIdByKeyMM", str);
        AppMethodBeat.o(95258);
        return str2;
    }

    public int isAutoAdDownload() {
        AppMethodBeat.i(95259);
        Object REMOTE_CALL = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95259);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95259);
        return intValue;
    }

    public void favEditTag() {
        AppMethodBeat.i(95260);
        REMOTE_CALL("favEditTagMM", new Object[0]);
        AppMethodBeat.o(95260);
    }

    @com.tencent.mm.remoteservice.f
    public void favEditTagMM() {
        AppMethodBeat.i(95261);
        hb hbVar = new hb();
        hbVar.dLm.type = 35;
        EventCenter.instance.publish(hbVar);
        AppMethodBeat.o(95261);
    }

    @com.tencent.mm.remoteservice.f
    public int isAutoAdDownloadMM() {
        AppMethodBeat.i(95262);
        int b2 = aj.faL().b((SnsInfo) null, (int[]) null);
        AppMethodBeat.o(95262);
        return b2;
    }

    public int doFavAdlanding(long j2, String str, int i2, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8) {
        AppMethodBeat.i(95263);
        Object REMOTE_CALL = REMOTE_CALL("doFavAdlandingMM", Long.valueOf(j2), str, Integer.valueOf(i2), str2, str3, str4, str5, str6, Integer.valueOf(i3), str7, str8);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95263);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95263);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int doFavAdlandingMM(long j2, String str, int i2, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8) {
        AppMethodBeat.i(95264);
        cz czVar = new cz();
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 9 || i2 == 10 || i2 == 11) {
            Util.isNullOrNil(str);
        }
        ((ad) com.tencent.mm.kernel.g.af(ad.class)).a(czVar, new StringBuilder().append(str6.hashCode()).toString(), z.aTY(), str4, str5, str6, str7, str2);
        czVar.dFZ.sessionId = com.tencent.mm.model.ad.JX(str3);
        czVar.dFZ.title = str4;
        czVar.dFZ.desc = str5;
        anb anb = czVar.dFZ.dGb;
        if (!(anb == null || anb.ppH == null || anb.ppH.size() <= 0 || anb.ppH.get(0) == null)) {
            anb.ppH.get(0).bgE(str6);
            anb.ppH.get(0).bgf(str4);
            anb.ppH.get(0).bgg(str5);
            anb.ppH.get(0).bgD(str8);
        }
        if (anb != null) {
            anb.bhd(str4);
            anb.bhe(str5);
        }
        czVar.dFZ.dGf = i3;
        EventCenter.instance.publish(czVar);
        int i4 = czVar.dFZ.dGe;
        AppMethodBeat.o(95264);
        return i4;
    }

    public int doFav(Intent intent, int i2) {
        AppMethodBeat.i(95265);
        Object REMOTE_CALL = REMOTE_CALL("doFavMM", intent, Integer.valueOf(i2));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95265);
            return 0;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95265);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int doFavMM(Intent intent, int i2) {
        AppMethodBeat.i(95266);
        cz czVar = new cz();
        ((ad) com.tencent.mm.kernel.g.af(ad.class)).a(czVar, intent);
        czVar.dFZ.dGf = i2;
        EventCenter.instance.publish(czVar);
        int i3 = czVar.dFZ.dGe;
        AppMethodBeat.o(95266);
        return i3;
    }

    public void doTransimt(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(202678);
        Intent intent = new Intent(MMApplicationContext.getContext(), SnsTransparentUI.class);
        intent.putExtra("adlandingXml", str);
        intent.putExtra("shareTitle", str2);
        intent.putExtra("shareThumbUrl", str3);
        intent.putExtra("shareDesc", str4);
        intent.putExtra("shareUrl", str5);
        intent.putExtra("statExtStr", str6);
        intent.putExtra("uxInfo", str7);
        intent.putExtra("canvasId", str8);
        intent.putExtra("op", 2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/model/AdLandingPagesProxy", "doTransimt", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(202678);
    }

    @com.tencent.mm.remoteservice.f
    public void doTransimtMM(String str, String str2, String str3, String str4, String str5) {
    }

    public void doDynamicUpdateScene(String str, String str2, String str3, e eVar) {
        AppMethodBeat.i(95268);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doDynamicUpdateSceneMM", Long.valueOf(currentTimeMillis), str, str2, str3);
        AppMethodBeat.o(95268);
    }

    @com.tencent.mm.remoteservice.f
    public void doDynamicUpdateSceneMM(long j2, String str, String str2, String str3) {
        AppMethodBeat.i(95269);
        j jVar = new j(str, str2, str3);
        this.DGm.put(jVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(jVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1337, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2721, this.gNh);
        AppMethodBeat.o(95269);
    }

    @com.tencent.mm.remoteservice.e
    public void onDynamicUpdateEnd(long j2, String str) {
        AppMethodBeat.i(95270);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null && !Util.isNullOrNil(str)) {
            remove.bn(str);
        }
        AppMethodBeat.o(95270);
    }

    public void doSearchDynamicUpdateScene(String str, e eVar) {
        AppMethodBeat.i(95271);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doSearchDynamicUpdateSceneMM", Long.valueOf(currentTimeMillis), str);
        AppMethodBeat.o(95271);
    }

    @com.tencent.mm.remoteservice.f
    public void doSearchDynamicUpdateSceneMM(long j2, String str) {
        AppMethodBeat.i(95272);
        j jVar = new j(str);
        this.DGm.put(jVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(jVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1337, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2721, this.gNh);
        AppMethodBeat.o(95272);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdChannelEnd(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(95273);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(95273);
    }

    public void doAdChannelScene(String str, String str2, e eVar, boolean z) {
        AppMethodBeat.i(95274);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doAdChannelSceneMM", Long.valueOf(currentTimeMillis), str, str2, Boolean.valueOf(z));
        AppMethodBeat.o(95274);
    }

    @com.tencent.mm.remoteservice.f
    public void doAdChannelSceneMM(long j2, String str, String str2, boolean z) {
        AppMethodBeat.i(95275);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(str, str2, z);
        this.DGm.put(bVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(bVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1210, this.gNh);
        AppMethodBeat.o(95275);
    }

    public void doAdUpdateQrUrlScene(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        AppMethodBeat.i(202679);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doAdUpdateQrUrlSceneMM", Long.valueOf(currentTimeMillis), str, str2, str3, str4, str5, str6);
        AppMethodBeat.o(202679);
    }

    @com.tencent.mm.remoteservice.f
    public void doAdUpdateQrUrlSceneMM(long j2, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(202680);
        k kVar = new k(str, str2, str3, str4, str5, str6);
        this.DGm.put(kVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.azz().a(1022, this.gNh);
        com.tencent.mm.kernel.g.azz().a(kVar, 0);
        AppMethodBeat.o(202680);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdUpdateQrUrlEnd(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(202681);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(202681);
    }

    public void doGetSmartPhoneScene(long j2, int i2, String str, String str2, int i3, e eVar) {
        AppMethodBeat.i(95276);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doGetSmartPhoneSceneMM", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        AppMethodBeat.o(95276);
    }

    @com.tencent.mm.remoteservice.f
    public void doGetSmartPhoneSceneMM(long j2, long j3, int i2, String str, String str2, int i3) {
        AppMethodBeat.i(95277);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e eVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e(j3, i2, str, str2, i3);
        this.DGm.put(eVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(eVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2605, this.gNh);
        AppMethodBeat.o(95277);
    }

    @com.tencent.mm.remoteservice.e
    public void onGetSmartPhoneScene(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(95278);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(95278);
    }

    public void getBtnPersonalWxUserName(String str, String str2, e eVar) {
        AppMethodBeat.i(202682);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("getBtnPersonalWxUserNameMM", Long.valueOf(currentTimeMillis), str, str2);
        AppMethodBeat.o(202682);
    }

    @com.tencent.mm.remoteservice.f
    public void getBtnPersonalWxUserNameMM(final long j2, String str, String str2) {
        AppMethodBeat.i(202683);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c cVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(str, str2);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(cVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(4353, new i() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass2 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(202664);
                Log.i("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
                if (i2 == 0 && i3 == 0) {
                    byb byb = (byb) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                    if (byb == null || TextUtils.isEmpty(byb.MdC)) {
                        Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, rsp==null");
                        AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), null);
                    } else {
                        AdLandingPagesProxy.this.CLIENT_CALL("onGetBtnPersonalWxUserName", Long.valueOf(j2), byb.username, byb.MdC);
                        AdLandingPagesProxy.this.doSearchContactMM(j2, byb.MdC);
                    }
                } else {
                    Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, failed");
                    AdLandingPagesProxy.this.CLIENT_CALL("onSearchContact", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), null);
                }
                com.tencent.mm.kernel.g.azz().b(qVar.getType(), this);
                AppMethodBeat.o(202664);
            }
        });
        AppMethodBeat.o(202683);
    }

    @com.tencent.mm.remoteservice.f
    public void doSearchContactMM(long j2, String str) {
        AppMethodBeat.i(202684);
        Log.i("AdLandingPagesProxy", "doSearchContactMM, userName=".concat(String.valueOf(str)));
        com.tencent.mm.plugin.messenger.a.f fVar = new com.tencent.mm.plugin.messenger.a.f(str, 1);
        this.DGm.put(fVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.azz().a(106, this.gNh);
        com.tencent.mm.kernel.g.azz().a(fVar, 0);
        AppMethodBeat.o(202684);
    }

    @com.tencent.mm.remoteservice.e
    public void onGetBtnPersonalWxUserName(long j2, String str, String str2) {
        AppMethodBeat.i(202685);
        e eVar = this.callbacks.get(Long.valueOf(j2));
        if (eVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ch.COL_USERNAME, str);
                jSONObject.put("aliasname", str2);
                eVar.bn(jSONObject.toString());
                AppMethodBeat.o(202685);
                return;
            } catch (Exception e2) {
                Log.e("AdLandingPagesProxy", "onGetBtnPersonalWxUserName, exp=" + e2.toString());
            }
        }
        AppMethodBeat.o(202685);
    }

    @com.tencent.mm.remoteservice.e
    public void onSearchContact(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(202686);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(202686);
    }

    public void doUpdateUxInfoScene(String str, e eVar) {
        AppMethodBeat.i(95279);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doUpdateUxInfoSceneMM", Long.valueOf(currentTimeMillis), str);
        AppMethodBeat.o(95279);
    }

    @com.tencent.mm.remoteservice.f
    public void doUpdateUxInfoSceneMM(long j2, String str) {
        AppMethodBeat.i(95280);
        l lVar = new l(str);
        this.DGm.put(lVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(lVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2883, this.gNh);
        AppMethodBeat.o(95280);
    }

    @com.tencent.mm.remoteservice.e
    public void onUpdateUxInfo(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(95281);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(95281);
    }

    public void doAdNativeAntiAbuseScene(String str, String str2, int i2, String str3, e eVar) {
        AppMethodBeat.i(202687);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doAdNativeAntiAbuseSceneMM", Long.valueOf(currentTimeMillis), str, str2, Integer.valueOf(i2), str3);
        AppMethodBeat.o(202687);
    }

    @com.tencent.mm.remoteservice.f
    public void doAdNativeAntiAbuseSceneMM(long j2, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(202688);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(str, str2, i2, str3);
        this.DGm.put(aVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.azz().a(4679, this.gNh);
        com.tencent.mm.kernel.g.azz().a(aVar, 0);
        AppMethodBeat.o(202688);
    }

    @com.tencent.mm.remoteservice.e
    public void onAdNativeAntiAbuse(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(202689);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(202689);
    }

    public void doGetHbCoverState(String str, e eVar) {
        AppMethodBeat.i(95282);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doGetHbCoverStateMM", Long.valueOf(currentTimeMillis), str);
        Log.i("AdLandingPagesProxy", "doGetHbCoverState, hbCoverId=".concat(String.valueOf(str)));
        AppMethodBeat.o(95282);
    }

    @com.tencent.mm.remoteservice.f
    public void doGetHbCoverStateMM(long j2, String str) {
        AppMethodBeat.i(95283);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d dVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(str);
        this.DGm.put(dVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(dVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2944, this.gNh);
        AppMethodBeat.o(95283);
    }

    @com.tencent.mm.remoteservice.e
    public void onGetHbCoverStateScene(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(95284);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(95284);
    }

    public void onAdLandingPageClick(String str, String str2) {
        AppMethodBeat.i(95285);
        System.currentTimeMillis();
        REMOTE_CALL("onAdLandingPageClickMM", str, str2);
        AppMethodBeat.o(95285);
    }

    @com.tencent.mm.remoteservice.f
    public void onAdLandingPageClickMM(String str, String str2) {
        AppMethodBeat.i(95286);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g gVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g(str, str2);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(gVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2538, this.gNh);
        AppMethodBeat.o(95286);
    }

    public void playTimelineClickAnimation(long j2) {
        AppMethodBeat.i(95287);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), null);
        REMOTE_CALL("playTimelineClickAnimationMM", Long.valueOf(currentTimeMillis), Long.valueOf(j2));
        AppMethodBeat.o(95287);
    }

    @com.tencent.mm.remoteservice.f
    public void playTimelineClickAnimationMM(long j2, long j3) {
        AppMethodBeat.i(95288);
        xw xwVar = new xw();
        xwVar.eeh.gY = j3;
        EventCenter.instance.publish(xwVar);
        AppMethodBeat.o(95288);
    }

    public void playTimelineBackAnimation(long j2) {
        AppMethodBeat.i(95289);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), null);
        REMOTE_CALL("playTimelineBackAnimationMM", Long.valueOf(currentTimeMillis), Long.valueOf(j2));
        AppMethodBeat.o(95289);
    }

    @com.tencent.mm.remoteservice.f
    public void playTimelineBackAnimationMM(long j2, long j3) {
        AppMethodBeat.i(95290);
        xv xvVar = new xv();
        xvVar.eeg.gY = j3;
        EventCenter.instance.publish(xvVar);
        AppMethodBeat.o(95290);
    }

    @Override // com.tencent.mm.remoteservice.a, com.tencent.mm.remoteservice.b
    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(95291);
        Log.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            Method[] methods = getClass().getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : com.tencent.mm.remoteservice.f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.o(95291);
                            return;
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(95291);
        } catch (Exception e2) {
            Log.e("AdLandingPagesProxy", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(95291);
        }
    }

    @com.tencent.mm.remoteservice.e
    public boolean isApkExist(String str) {
        AppMethodBeat.i(95292);
        Object REMOTE_CALL = REMOTE_CALL("isApkExistMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95292);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95292);
        return booleanValue;
    }

    public boolean isDownloading(String str) {
        AppMethodBeat.i(95295);
        Object REMOTE_CALL = REMOTE_CALL("isDownloadingMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95295);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95295);
        return booleanValue;
    }

    public boolean isPkgInstalled(String str) {
        AppMethodBeat.i(95297);
        Object REMOTE_CALL = REMOTE_CALL("isPkgInstalledMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95297);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95297);
        return booleanValue;
    }

    public boolean isPaused(String str) {
        AppMethodBeat.i(95299);
        Object REMOTE_CALL = REMOTE_CALL("isPausedMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95299);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95299);
        return booleanValue;
    }

    class b implements a.c {
        private String LG;
        private String appId;
        private boolean qKw;

        public b(String str, String str2, boolean z) {
            this.LG = str2;
            this.appId = str;
            this.qKw = z;
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c
        public final void aOJ(String str) {
            AppMethodBeat.i(95219);
            Log.i("AdLandingPagesProxy", "pkg %s installed", str);
            if (this.qKw) {
                a.e.DXp.reportDownloadInfo(4, this.appId);
            }
            a.e.DXp.reportDownloadInfo(5, this.appId);
            AppMethodBeat.o(95219);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c
        public final void aOK(String str) {
            AppMethodBeat.i(95220);
            Log.i("AdLandingPagesProxy", "pkg %s removed", str);
            if (!Util.isNullOrNil(str) && str.equals(this.LG)) {
                AdLandingPagesProxy.this.deleteDeferredDeepLinkMM(str);
            }
            AppMethodBeat.o(95220);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void start(long j2) {
        AppMethodBeat.i(95300);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.start();
            }
        }
        AppMethodBeat.o(95300);
    }

    @com.tencent.mm.remoteservice.e
    public void progress(long j2, int i2) {
        AppMethodBeat.i(95301);
        Log.v("AdLandingPagesProxy", "progress client id %d , progress %d", Long.valueOf(j2), Integer.valueOf(i2));
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.Yr(i2);
            }
        }
        AppMethodBeat.o(95301);
    }

    @com.tencent.mm.remoteservice.e
    public void paused(long j2) {
        AppMethodBeat.i(95302);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.eZP();
            }
        }
        AppMethodBeat.o(95302);
    }

    @com.tencent.mm.remoteservice.e
    public void stopped(long j2) {
        AppMethodBeat.i(95303);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.eZQ();
            }
        }
        this.DGo.remove(Long.valueOf(j2));
        AppMethodBeat.o(95303);
    }

    @com.tencent.mm.remoteservice.e
    public void succeed(long j2) {
        AppMethodBeat.i(95304);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.eZR();
            }
        }
        this.DGo.remove(Long.valueOf(j2));
        AppMethodBeat.o(95304);
    }

    @com.tencent.mm.remoteservice.e
    public void failed(long j2) {
        AppMethodBeat.i(95305);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.eZS();
            }
        }
        this.DGo.remove(Long.valueOf(j2));
        AppMethodBeat.o(95305);
    }

    @com.tencent.mm.remoteservice.e
    public void resumed(long j2) {
        AppMethodBeat.i(95306);
        Iterator<a> it = this.DGo.get(Long.valueOf(j2)).iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.eZT();
            }
        }
        AppMethodBeat.o(95306);
    }

    public long startDownload(String str, String str2, String str3, String str4, String str5, String str6, boolean z, a aVar, String str7, String str8, String str9, boolean z2) {
        AppMethodBeat.i(176245);
        Log.i("AdLandingPagesProxy", "startDownload, appId=" + str + ", pkg=" + str3 + ", aid=" + str7 + ", fileName=" + str6 + ", isGameApp=" + z2 + ", url=" + str5 + ", uxinfo=" + str9);
        Object REMOTE_CALL = REMOTE_CALL("startDownloadMM", str, str2, str3, str4, str5, str6, Boolean.valueOf(z), str7, str8, str9, Boolean.valueOf(z2));
        long longValue = REMOTE_CALL == null ? -1 : ((Long) REMOTE_CALL).longValue();
        ArrayList<a> arrayList = this.DGo.get(Long.valueOf(longValue));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            arrayList.add(aVar);
        } else if (!arrayList.contains(aVar)) {
            arrayList.add(aVar);
        }
        this.DGo.put(Long.valueOf(longValue), arrayList);
        AppMethodBeat.o(176245);
        return longValue;
    }

    public void stopTask(String str) {
        AppMethodBeat.i(95310);
        REMOTE_CALL("stopTaskMM", str);
        AppMethodBeat.o(95310);
    }

    public long queryIdByAppid(String str) {
        AppMethodBeat.i(95312);
        Object REMOTE_CALL = REMOTE_CALL("queryIdByAppidMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95312);
            return -1;
        }
        long longValue = ((Long) REMOTE_CALL).longValue();
        AppMethodBeat.o(95312);
        return longValue;
    }

    public boolean pauseTask(String str) {
        AppMethodBeat.i(95314);
        Object REMOTE_CALL = REMOTE_CALL("pauseTaskMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95314);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95314);
        return booleanValue;
    }

    public int getTaskProgress(String str) {
        AppMethodBeat.i(95316);
        Object REMOTE_CALL = REMOTE_CALL("getTaskProgressMM", str);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95316);
            return -1;
        }
        int intValue = ((Integer) REMOTE_CALL).intValue();
        AppMethodBeat.o(95316);
        return intValue;
    }

    public boolean resumeTask(String str, a aVar, String str2, String str3, String str4) {
        boolean z = false;
        AppMethodBeat.i(176247);
        Object REMOTE_CALL = REMOTE_CALL("resumeTaskMM", str, str2, str3, str4);
        if (REMOTE_CALL != null) {
            z = ((Boolean) REMOTE_CALL).booleanValue();
        }
        if (z) {
            long queryIdByAppid = queryIdByAppid(str);
            ArrayList<a> arrayList = this.DGo.get(Long.valueOf(queryIdByAppid));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayList.add(aVar);
            } else if (!arrayList.contains(aVar)) {
                arrayList.add(aVar);
            }
            this.DGo.put(Long.valueOf(queryIdByAppid), arrayList);
        }
        AppMethodBeat.o(176247);
        return z;
    }

    public boolean installApp(Context context, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(95320);
        Object REMOTE_CALL = REMOTE_CALL("installAppMM", str, str2, str3, str4);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95320);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95320);
        return booleanValue;
    }

    public void reportDownloadInfo(int i2, String str) {
        AppMethodBeat.i(95322);
        REMOTE_CALL("reportDownloadInfoMM", Integer.valueOf(i2), str);
        AppMethodBeat.o(95322);
    }

    public void addReportInfo(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(176249);
        REMOTE_CALL("addReportInfoMM", str, str2, str3, str4);
        AppMethodBeat.o(176249);
    }

    public void writeDeferredDeepLink(String str, String str2) {
        AppMethodBeat.i(95325);
        REMOTE_CALL("writeDeferredDeepLinkMM", str, str2);
        AppMethodBeat.o(95325);
    }

    @com.tencent.mm.remoteservice.f
    public void writeDeferredDeepLinkMM(String str, String str2) {
        AppMethodBeat.i(95326);
        akz().edit().putString(str, str2).commit();
        AppMethodBeat.o(95326);
    }

    public void deleteDeferredDeepLink(String str) {
        AppMethodBeat.i(95327);
        REMOTE_CALL("deleteDeferredDeepLinkMM", str);
        AppMethodBeat.o(95327);
    }

    @com.tencent.mm.remoteservice.f
    public void deleteDeferredDeepLinkMM(String str) {
        AppMethodBeat.i(95328);
        akz().edit().remove(str).commit();
        AppMethodBeat.o(95328);
    }

    private static SharedPreferences akz() {
        AppMethodBeat.i(95329);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0);
        AppMethodBeat.o(95329);
        return sharedPreferences;
    }

    @com.tencent.mm.remoteservice.e
    public void addCanvasCache(long j2, String str) {
        AppMethodBeat.i(95330);
        REMOTE_CALL("addCanvasCacheMM", Long.valueOf(j2), str);
        AppMethodBeat.o(95330);
    }

    @com.tencent.mm.remoteservice.f
    public void addCanvasCacheMM(long j2, String str) {
        AppMethodBeat.i(95331);
        m.feB().J(j2, str);
        AppMethodBeat.o(95331);
    }

    @com.tencent.mm.remoteservice.e
    public void asyncCacheXml(String str) {
        AppMethodBeat.i(95332);
        REMOTE_CALL("asyncCacheXmlMM", str);
        AppMethodBeat.o(95332);
    }

    @com.tencent.mm.remoteservice.f
    public void asyncCacheXmlMM(final String str) {
        AppMethodBeat.i(95333);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass4 */

            public final void run() {
                ADXml adXml;
                AppMethodBeat.i(95218);
                if (!com.tencent.mm.kernel.g.aAf().azp()) {
                    AppMethodBeat.o(95218);
                    return;
                }
                SnsInfo aQl = aj.faO().aQl(str);
                if (!(aQl == null || (adXml = aQl.getAdXml()) == null)) {
                    AdLandingPagesProxy.aOI(adXml.getLeftCanvasInfo());
                    AdLandingPagesProxy.aOI(adXml.getRightCanvasInfo());
                }
                AppMethodBeat.o(95218);
            }
        }, 5000);
        AppMethodBeat.o(95333);
    }

    public int getAdVoteIndex(String str, String str2, String str3) {
        AppMethodBeat.i(95334);
        int intValue = ((Integer) REMOTE_CALL("getAdVoteIndexMM", str, str2, str3)).intValue();
        AppMethodBeat.o(95334);
        return intValue;
    }

    @com.tencent.mm.remoteservice.f
    public int getAdVoteIndexMM(String str, String str2, String str3) {
        AppMethodBeat.i(95335);
        int aS = y.aS(str, str2, str3);
        AppMethodBeat.o(95335);
        return aS;
    }

    public String getAdVoteInfo(String str, String str2, String str3) {
        AppMethodBeat.i(95336);
        String str4 = (String) REMOTE_CALL("getAdVoteInfoMM", str, str2, str3);
        AppMethodBeat.o(95336);
        return str4;
    }

    @com.tencent.mm.remoteservice.f
    public String getAdVoteInfoMM(String str, String str2, String str3) {
        AppMethodBeat.i(95337);
        String aT = y.aT(str, str2, str3);
        AppMethodBeat.o(95337);
        return aT;
    }

    public void saveAdVoteInfo(String str, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(95338);
        REMOTE_CALL("saveAdVoteInfoMM", str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4);
        AppMethodBeat.o(95338);
    }

    @com.tencent.mm.remoteservice.f
    public void saveAdVoteInfoMM(String str, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(95339);
        y.b(str, str2, str3, i2, i3, str4);
        AppMethodBeat.o(95339);
    }

    public void doFavOfficialItemScene(String str, e eVar) {
        AppMethodBeat.i(95340);
        if (Util.isNullOrNil(str)) {
            Log.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
            AppMethodBeat.o(95340);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doFavOfficialItemSceneMM", Long.valueOf(currentTimeMillis), str);
        AppMethodBeat.o(95340);
    }

    @com.tencent.mm.remoteservice.f
    public void doFavOfficialItemSceneMM(long j2, String str) {
        AppMethodBeat.i(95341);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i(str);
        this.DGm.put(iVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(iVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(2874, this.gNh);
        AppMethodBeat.o(95341);
    }

    @com.tencent.mm.remoteservice.e
    public void onFavOfficialItemEnd(long j2, String str, int i2, int i3) {
        AppMethodBeat.i(95342);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (i2 == 0 && i3 == 0) {
            Log.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", str);
        } else {
            Log.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (remove != null) {
            remove.h(i2, i3, null);
        }
        AppMethodBeat.o(95342);
    }

    public String getSnsAdCanvasExtXml(String str) {
        AppMethodBeat.i(95343);
        String str2 = (String) REMOTE_CALL("getSnsAdCanvasExtXmlMM", str);
        AppMethodBeat.o(95343);
        return str2;
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsAdCanvasExtXmlMM(String str) {
        AppMethodBeat.i(95344);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String str2 = aQl.getAdInfo().adCanvasExtXml;
            AppMethodBeat.o(95344);
            return str2;
        }
        AppMethodBeat.o(95344);
        return "";
    }

    public void doCgiReportCanvasBrowseInfo(int i2, String str) {
        AppMethodBeat.i(95345);
        REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", Integer.valueOf(i2), str);
        AppMethodBeat.o(95345);
    }

    @com.tencent.mm.remoteservice.f
    public void doCgiReportCanvasBrowseInfoMM(int i2, String str) {
        AppMethodBeat.i(95346);
        cfy cfy = new cfy();
        cfy.MlF = i2;
        cfy.MlM = (int) (System.currentTimeMillis() / 1000);
        cfy.oTz = 1;
        cfy.MlG = new com.tencent.mm.bw.b(str.getBytes());
        ArrayList arrayList = new ArrayList();
        arrayList.add(cfy);
        com.tencent.mm.plugin.sns.ad.g.h hVar = new com.tencent.mm.plugin.sns.ad.g.h(arrayList);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(hVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1802, this.gNh);
        AppMethodBeat.o(95346);
    }

    public int getStreamVideoPlayerConfig() {
        AppMethodBeat.i(95347);
        try {
            int intValue = ((Integer) REMOTE_CALL("getStreamVideoPlayerConfigMM", new Object[0])).intValue();
            AppMethodBeat.o(95347);
            return intValue;
        } catch (Exception e2) {
            Log.e("AdLandingPagesProxy", "getStreamVideoPlayerConfig, exp=" + e2.toString());
            AppMethodBeat.o(95347);
            return 1;
        }
    }

    @com.tencent.mm.remoteservice.f
    public int getStreamVideoPlayerConfigMM() {
        AppMethodBeat.i(95348);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0);
        AppMethodBeat.o(95348);
        return a2;
    }

    @com.tencent.mm.remoteservice.f
    public void clearCallbackMM() {
        AppMethodBeat.i(95349);
        this.DGm.clear();
        this.DGp = null;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1337, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1210, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(2874, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(2721, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1802, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(2605, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(2883, this.gNh);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(4353, this.gNh);
        AppMethodBeat.o(95349);
    }

    @com.tencent.mm.remoteservice.e
    public void clearCallback() {
        AppMethodBeat.i(95350);
        REMOTE_CALL("clearCallbackMM", new Object[0]);
        this.DGq.clear();
        this.callbacks.clear();
        this.DGo.clear();
        AppMethodBeat.o(95350);
    }

    public void downloadLandingPagesCDNFile(String str, String str2, String str3, int i2, g gVar) {
        AppMethodBeat.i(202690);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            if (gVar != null) {
                gVar.eWO();
            }
            AppMethodBeat.o(202690);
            return;
        }
        if (gVar != null) {
            this.DGq.put(str2, gVar);
        }
        REMOTE_CALL("downloadLandingPagesCDNFileMM", str, str2, str3, Integer.valueOf(i2));
        AppMethodBeat.o(202690);
    }

    @com.tencent.mm.remoteservice.f
    public void downloadLandingPagesCDNFileMM(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(202691);
        if (i2 == 0) {
            downloadLandingPagesImageMMImpl(str, str2, str3);
            AppMethodBeat.o(202691);
            return;
        }
        if (i2 == 1) {
            downloadLandingPagesSightMMImpl(str, str2, str3);
        }
        AppMethodBeat.o(202691);
    }

    public void downloadLandingPagesImageMMImpl(final String str, final String str2, String str3) {
        AppMethodBeat.i(95353);
        Log.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl, mediaId=".concat(String.valueOf(str2)));
        final cnb a2 = n.a(str2, 2, str3, str3, 1, 1, "");
        final com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(a2);
        nVar.DEs = 3;
        nVar.dPI = a2.Id;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(202671);
                aj.faJ().a(new c(a2.Id));
                c faJ = aj.faJ();
                cnb cnb = a2;
                com.tencent.mm.plugin.sns.data.n nVar = nVar;
                bp gCU = bp.gCU();
                gCU.hXs = (int) (System.currentTimeMillis() / 1000);
                faJ.a(cnb, 8, nVar, gCU, str, str2);
                AppMethodBeat.o(202671);
            }
        });
        AppMethodBeat.o(95353);
    }

    public void downloadLandingPagesSightMMImpl(final String str, final String str2, String str3) {
        AppMethodBeat.i(202692);
        Log.i("AdLandingPagesProxy", "downloadLandingPagesSightMMImpl, mediaId=".concat(String.valueOf(str2)));
        final cnb a2 = n.a(str2, 6, str3, str3, 1, 1, "");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(202672);
                aj.faJ().a(new c(a2.Id));
                c faJ = aj.faJ();
                cnb cnb = a2;
                bp gCU = bp.gCU();
                gCU.hXs = (int) (System.currentTimeMillis() / 1000);
                faJ.a(cnb, 4, null, gCU, str, str2);
                AppMethodBeat.o(202672);
            }
        });
        AppMethodBeat.o(202692);
    }

    @com.tencent.mm.remoteservice.e
    public void onImgDownloadCallback(String str, boolean z) {
        AppMethodBeat.i(95354);
        Log.i("AdLandingPagesProxy", "onImgDownloadCallback, id=" + str + ", isOk=" + z);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95354);
            return;
        }
        g remove = this.DGq.remove(str);
        if (remove != null) {
            if (z) {
                remove.eZU();
                AppMethodBeat.o(95354);
                return;
            }
            remove.eWO();
        }
        AppMethodBeat.o(95354);
    }

    @com.tencent.mm.remoteservice.e
    public void onSightDownloadCallback(String str, boolean z) {
        AppMethodBeat.i(202693);
        Log.i("AdLandingPagesProxy", "onSightDownloadCallback, id=" + str + ", isOk=" + z);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(202693);
            return;
        }
        g remove = this.DGq.remove(str);
        if (remove != null) {
            if (z) {
                remove.eZU();
                AppMethodBeat.o(202693);
                return;
            }
            remove.eWO();
        }
        AppMethodBeat.o(202693);
    }

    class c implements c.b {
        private String mediaId;

        public c(String str) {
            this.mediaId = str;
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void aOG(String str) {
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void eZJ() {
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void cj(String str, boolean z) {
            AppMethodBeat.i(202676);
            Log.i("AdLandingPagesProxy", "onSightFinish, mediaId=" + str + ", isOk=" + z);
            if (!Util.isNullOrNil(str, this.mediaId) && str.equals(this.mediaId)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onSightDownloadCallback", str, Boolean.valueOf(z));
                aj.faJ().b(this);
            }
            AppMethodBeat.o(202676);
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void ci(String str, boolean z) {
            AppMethodBeat.i(95221);
            Log.i("AdLandingPagesProxy", "onImageFinish, mediaId=" + str + ", isOk=" + z);
            if (!Util.isNullOrNil(str, this.mediaId) && str.equals(this.mediaId)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onImgDownloadCallback", str, Boolean.valueOf(z));
                aj.faJ().b(this);
            }
            AppMethodBeat.o(95221);
        }
    }

    public void downloadLandingPageVideo(String str, String str2, String str3, h.a aVar) {
        AppMethodBeat.i(95355);
        if (Util.isNullOrNil(str, str2, str3)) {
            if (aVar != null) {
                aVar.a(str, -1, null);
            }
            AppMethodBeat.o(95355);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 20);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
        boolean z = sharedPreferences.getBoolean(str, false);
        if (s.YS(str3)) {
            Log.i("AdLandingPagesProxy", "is already download %s", Boolean.valueOf(z));
            if (z) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 21);
                aVar.a(str, 0, null);
                AppMethodBeat.o(95355);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 22);
        } else if (z) {
            Log.i("AdLandingPagesProxy", "last download file was deleted");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 23);
            sharedPreferences.edit().putBoolean(str, false).commit();
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 24);
        }
        if (this.DGr.containsKey(str)) {
            Log.i("%s is already in downloading", str2);
            AppMethodBeat.o(95355);
            return;
        }
        if (aVar != null) {
            this.DGr.put(str, aVar);
        }
        REMOTE_CALL("downloadLandingPageVideoMM", str, str2, str3);
        AppMethodBeat.o(95355);
    }

    public void stopDownloadLandingPageVideo(String str) {
        AppMethodBeat.i(95356);
        if (this.DGr.containsKey(str)) {
            this.DGr.remove(str);
            Log.i("AdLandingPagesProxy", "stop download video %s", str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 34);
            MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, false).commit();
        }
        REMOTE_CALL("stopDownloadLandingPageVideoMM", str);
        AppMethodBeat.o(95356);
    }

    @com.tencent.mm.remoteservice.f
    public void stopDownloadLandingPageVideoMM(String str) {
        AppMethodBeat.i(95357);
        aj.faJ().aOM(str);
        AppMethodBeat.o(95357);
    }

    public long[] queryVideoMoov(String str, String str2, String str3) {
        AppMethodBeat.i(95358);
        Log.i("AdLandingPagesProxy", "mediaId %s, path %s, url %s", str, str2, str3);
        if (Util.isNullOrNil(str, str2, str3)) {
            AppMethodBeat.o(95358);
            return null;
        }
        long[] jArr = (long[]) REMOTE_CALL("queryVideoMoovMM", str, str2, str3);
        AppMethodBeat.o(95358);
        return jArr;
    }

    @com.tencent.mm.remoteservice.f
    public long[] queryVideoMoovMM(String str, String str2, String str3) {
        AppMethodBeat.i(95359);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.fileType = 100;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.setSavePath(str2);
        long[] jArr = new long[2];
        if (CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr)) {
            AppMethodBeat.o(95359);
            return jArr;
        }
        AppMethodBeat.o(95359);
        return null;
    }

    class d implements h.a {
        private String mediaId;

        public d(String str) {
            this.mediaId = str;
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            AppMethodBeat.i(202677);
            if (str.equals(this.mediaId)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 26);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoMoovReady", str, Long.valueOf(j2), Long.valueOf(j3), str2);
            }
            AppMethodBeat.o(202677);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(95223);
            if (str.equals(this.mediaId)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 28);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoDataAvailable", str, Long.valueOf(j2), Long.valueOf(j3));
            }
            AppMethodBeat.o(95223);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(95224);
            if (str.equals(this.mediaId)) {
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoProgress", str, Long.valueOf(j2), Long.valueOf(j3));
            }
            AppMethodBeat.o(95224);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(95225);
            if (str.equals(this.mediaId)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 30);
                AdLandingPagesProxy.this.CLIENT_CALL("onCdnVideoFinish", str, Integer.valueOf(i2));
            }
            AppMethodBeat.o(95225);
        }
    }

    @com.tencent.mm.remoteservice.f
    public void downloadLandingPageVideoMM(String str, String str2, String str3) {
        AppMethodBeat.i(95360);
        Log.i("AdLandingPagesProxy", "add online video task [%s] url[%s] path[%s]", str, str2, str3);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 25);
        aj.faJ().a(str, str2, str3, new d(str));
        AppMethodBeat.o(95360);
    }

    public void requestVideoData(String str, int i2, int i3) {
        AppMethodBeat.i(95361);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 32);
        REMOTE_CALL("requestVideoDataMM", str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(95361);
    }

    @com.tencent.mm.remoteservice.f
    public void requestVideoDataMM(String str, int i2, int i3) {
        AppMethodBeat.i(95362);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.p.p.CTRL_INDEX, 33);
        o.bhk();
        com.tencent.mm.an.e.r(str, i2, i3);
        AppMethodBeat.o(95362);
    }

    public boolean isVideoDataAvailable(String str, int i2, int i3) {
        AppMethodBeat.i(95363);
        Object REMOTE_CALL = REMOTE_CALL("isVideoDataAvailableMM", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95363);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95363);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isVideoDataAvailableMM(String str, int i2, int i3) {
        AppMethodBeat.i(95364);
        boolean isVideoDataAvailable = o.bhk().isVideoDataAvailable(str, i2, i3);
        Log.i("AdLandingPagesProxy", "is video data avaiable %s %d %d %s", str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(isVideoDataAvailable));
        AppMethodBeat.o(95364);
        return isVideoDataAvailable;
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoMoovReady(String str, long j2, long j3, String str2) {
        AppMethodBeat.i(202694);
        Log.i("AdLandingPagesProxy", "cdn video moov ready %s %d %d", str, Long.valueOf(j2), Long.valueOf(j3));
        if (this.DGr.containsKey(str)) {
            this.DGr.get(str).a(str, j2, j3, str2);
        }
        AppMethodBeat.o(202694);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(95366);
        Log.i("AdLandingPagesProxy", "cdn video data available %s %d %d", str, Long.valueOf(j2), Long.valueOf(j3));
        if (this.DGr.containsKey(str)) {
            this.DGr.get(str).onDataAvailable(str, j2, j3);
        }
        AppMethodBeat.o(95366);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoProgress(String str, long j2, long j3) {
        AppMethodBeat.i(95367);
        Log.i("AdLandingPagesProxy", "cdn video progress %s %d %d", str, Long.valueOf(j2), Long.valueOf(j3));
        if (this.DGr.containsKey(str)) {
            this.DGr.get(str).i(str, j2, j3);
        }
        AppMethodBeat.o(95367);
    }

    @com.tencent.mm.remoteservice.e
    public void onCdnVideoFinish(String str, int i2) {
        AppMethodBeat.i(95368);
        Log.i("AdLandingPagesProxy", "cdn video finish %s, %d", str, Integer.valueOf(i2));
        if (i2 == 0) {
            MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, true).commit();
        }
        if (this.DGr.containsKey(str)) {
            this.DGr.remove(str).a(str, i2, null);
        }
        AppMethodBeat.o(95368);
    }

    public boolean isUseSnsDownloadImage() {
        AppMethodBeat.i(95369);
        Object REMOTE_CALL = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(95369);
            return false;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(95369);
        return booleanValue;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isUseSnsDownloadImageMM() {
        boolean z;
        AppMethodBeat.i(95370);
        f fVar = DGn;
        if (Util.currentTicks() - fVar.lastUpdateTime > 3600) {
            fVar.DGx = false;
            try {
                if (com.tencent.mm.kernel.g.aAc()) {
                    com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100348");
                    if (Fu.isValid()) {
                        if (Util.getInt(Fu.gzz().get("downloadMode"), 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar.DGx = z;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("AdLandingPagesProxy", e2, "get abtest failed!", new Object[0]);
            }
            fVar.lastUpdateTime = Util.currentTicks();
        }
        boolean z2 = DGn.DGx;
        AppMethodBeat.o(95370);
        return z2;
    }

    public void fetchQRCodeInfo(int i2, String str, e eVar) {
        AppMethodBeat.i(95371);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("fetchQRCodeInfoMM", Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str);
        AppMethodBeat.o(95371);
    }

    @com.tencent.mm.remoteservice.f
    public void fetchQRCodeInfoMM(final long j2, final int i2, final String str) {
        AppMethodBeat.i(95372);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(202674);
                new com.tencent.mm.plugin.scanner.d().bZ(i2, str).a(new d.b<bws>() {
                    /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass7.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.g.d.b
                    public final /* synthetic */ void bz(bws bws) {
                        AppMethodBeat.i(202673);
                        bws bws2 = bws;
                        byte[] bArr = null;
                        int i2 = -1;
                        try {
                            i2 = bws2.Ret;
                            bArr = bws2.toByteArray();
                            if (bws2 != null) {
                                Log.i("AdLandingPagesProxy", "fetchQRCodeInfoMM end, ret=" + bws2.Ret + ", urlType=" + bws2.Mcw + ", actionCode=" + bws2.KCD);
                            }
                        } catch (Exception e2) {
                            Log.e("AdLandingPagesProxy", "fetchQRCodeInfoMM, exp=" + e2.toString());
                        }
                        AdLandingPagesProxy.this.CLIENT_CALL("onFetchQRCodeInfo", Long.valueOf(j2), Integer.valueOf(i2), 0, bArr);
                        AppMethodBeat.o(202673);
                    }
                });
                AppMethodBeat.o(202674);
            }
        });
        AppMethodBeat.o(95372);
    }

    @com.tencent.mm.remoteservice.e
    public void onFetchQRCodeInfo(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(95373);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(95373);
    }

    public void geoLocation(String str, e eVar) {
        AppMethodBeat.i(202695);
        try {
            Log.d("AdLandingPagesProxy", "geoLocation is called!!");
            long currentTimeMillis = System.currentTimeMillis();
            this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
            REMOTE_CALL("geoLocationMM", Long.valueOf(currentTimeMillis), str);
            AppMethodBeat.o(202695);
        } catch (Throwable th) {
            Log.e("AdLandingPagesProxy", "geoLocation catch one exception");
            AppMethodBeat.o(202695);
        }
    }

    @com.tencent.mm.remoteservice.f
    public void geoLocationMM(long j2, String str) {
        AppMethodBeat.i(202696);
        try {
            Log.d("AdLandingPagesProxy", "geoLocationMM is called!!");
            com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b a2 = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c.a(this, "onGeoLocation", j2);
            if (a2 != null) {
                a2.request(str);
            }
            AppMethodBeat.o(202696);
        } catch (Throwable th) {
            Log.e("AdLandingPagesProxy", "geoLocationMM catch one exception");
            AppMethodBeat.o(202696);
        }
    }

    @com.tencent.mm.remoteservice.e
    public void onGeoLocation(long j2, Object obj) {
        AppMethodBeat.i(202697);
        try {
            Log.d("AdLandingPagesProxy", "onGeoLocation is called!!");
            e remove = this.callbacks.remove(Long.valueOf(j2));
            if (remove != null) {
                remove.bn(obj);
            }
            AppMethodBeat.o(202697);
        } catch (Throwable th) {
            Log.e("AdLandingPagesProxy", "onGeoLocation catch one exception");
            AppMethodBeat.o(202697);
        }
    }

    public void doAddBrandScene(String str, int i2, e eVar) {
        AppMethodBeat.i(202698);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("doAddBrandSceneSceneMM", Long.valueOf(currentTimeMillis), str, Integer.valueOf(i2));
        AppMethodBeat.o(202698);
    }

    @com.tencent.mm.remoteservice.f
    public void doAddBrandSceneSceneMM(long j2, String str, int i2) {
        AppMethodBeat.i(202699);
        q a2 = b.a(str, this.gNh, i2);
        if (a2 instanceof com.tencent.mm.openim.b.b) {
            com.tencent.mm.openim.b.b bVar = (com.tencent.mm.openim.b.b) a2;
            this.DGm.put(bVar, Long.valueOf(j2));
            com.tencent.mm.kernel.g.azz().a(bVar, 0);
            AppMethodBeat.o(202699);
            return;
        }
        if (a2 instanceof p) {
            p pVar = (p) a2;
            this.DGm.put(pVar, Long.valueOf(j2));
            com.tencent.mm.kernel.g.azz().a(pVar, 0);
        }
        AppMethodBeat.o(202699);
    }

    @com.tencent.mm.remoteservice.e
    public void onAddBrandSceneEnd(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(202700);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(202700);
    }

    public boolean isBrandAdded(String str) {
        AppMethodBeat.i(202701);
        Object REMOTE_CALL = REMOTE_CALL("selectBrandAdd", str);
        if (REMOTE_CALL instanceof Boolean) {
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.o(202701);
            return booleanValue;
        }
        AppMethodBeat.o(202701);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public boolean selectBrandAdd(String str) {
        AppMethodBeat.i(202702);
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
        if (aSN == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(202702);
            return false;
        }
        as Kn = aSN.Kn(str);
        if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
            AppMethodBeat.o(202702);
            return false;
        }
        AppMethodBeat.o(202702);
        return true;
    }

    public void updateContact(String str) {
        AppMethodBeat.i(202703);
        REMOTE_CALL("updateContactMM", str);
        AppMethodBeat.o(202703);
    }

    @com.tencent.mm.remoteservice.f
    public void updateContactMM(String str) {
        AppMethodBeat.i(202704);
        final bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
        if (aSN == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(202704);
            return;
        }
        final as Kn = aSN.Kn(str);
        Kn.aqQ();
        Kn.setUsername(str);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(202675);
                try {
                    if (((int) Kn.gMZ) == 0) {
                        aSN.aq(Kn);
                    }
                    if (((int) Kn.gMZ) <= 0) {
                        Log.e("AdLandingPagesProxy", "addContact : insert contact failed");
                        AppMethodBeat.o(202675);
                        return;
                    }
                    ab.B(Kn);
                    AppMethodBeat.o(202675);
                } catch (Throwable th) {
                    Log.e("AdLandingPagesProxy", th.toString());
                    AppMethodBeat.o(202675);
                }
            }
        });
        AppMethodBeat.o(202704);
    }

    public void prefetchH5Url(String str, String[] strArr) {
        AppMethodBeat.i(202705);
        try {
            REMOTE_CALL("prefetchH5UrlMM", str, strArr);
            AppMethodBeat.o(202705);
        } catch (Throwable th) {
            Log.e("AdLandingPagesProxy", "prefetchH5Url remote call has an exception!");
            AppMethodBeat.o(202705);
        }
    }

    @com.tencent.mm.remoteservice.f
    public void prefetchH5UrlMM(String str, String[] strArr) {
        c.b bVar;
        AppMethodBeat.i(202706);
        if (!TextUtils.isEmpty(str) && !com.tencent.mm.plugin.sns.ad.i.c.w(strArr)) {
            try {
                try {
                    com.tencent.mm.plugin.sns.ad.d.a.c cVar = com.tencent.mm.plugin.sns.ad.d.a.eWI().Dsw;
                    if (str == null || com.tencent.mm.plugin.sns.ad.i.c.w(strArr)) {
                        bVar = null;
                    } else {
                        bVar = cVar.b(new c.b(str, strArr));
                    }
                    cVar.c(bVar);
                    AppMethodBeat.o(202706);
                    return;
                } catch (Throwable th) {
                    AppMethodBeat.o(202706);
                    return;
                }
            } catch (Throwable th2) {
                Log.e("AdLandingPagesProxy", "prefetchH5UrlMM call has an exception!");
            }
        }
        AppMethodBeat.o(202706);
    }

    public void getTwistAdCard(String str, String str2, int i2, String str3, String str4, e eVar) {
        AppMethodBeat.i(202707);
        long currentTimeMillis = System.currentTimeMillis();
        this.callbacks.put(Long.valueOf(currentTimeMillis), eVar);
        REMOTE_CALL("getTwistAdCardMM", Long.valueOf(currentTimeMillis), str, str2, Integer.valueOf(i2), str3, str4);
        AppMethodBeat.o(202707);
    }

    @com.tencent.mm.remoteservice.f
    public void getTwistAdCardMM(long j2, String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(202708);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f fVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f(str, str2, i2, str3, str4);
        this.DGm.put(fVar, Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(fVar, 0);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(4729, this.gNh);
        AppMethodBeat.o(202708);
    }

    @com.tencent.mm.remoteservice.e
    public void onRspCallbackCommon(long j2, int i2, int i3, Object obj) {
        AppMethodBeat.i(202709);
        e remove = this.callbacks.remove(Long.valueOf(j2));
        if (remove != null) {
            remove.h(i2, i3, obj);
        }
        AppMethodBeat.o(202709);
    }

    public boolean isFreeSimCard() {
        AppMethodBeat.i(202710);
        Object REMOTE_CALL = REMOTE_CALL("isFreeSimCardMM", new Object[0]);
        if (REMOTE_CALL instanceof Boolean) {
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.o(202710);
            return booleanValue;
        }
        AppMethodBeat.o(202710);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isFreeSimCardMM() {
        boolean z;
        AppMethodBeat.i(202711);
        int eiV = ((com.tencent.mm.plugin.misc.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).eiV();
        switch (eiV) {
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        Log.i("AdLandingPagesProxy", "isFreeSimCard, simType=" + eiV + ", isFree=" + z);
        AppMethodBeat.o(202711);
        return z;
    }

    public void doJumpToFinderProfileUI(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(259436);
        REMOTE_CALL("doJumpToFinderProfileUIMM", str, str2, str3, Integer.valueOf(i2));
        AppMethodBeat.o(259436);
    }

    @com.tencent.mm.remoteservice.f
    public void doJumpToFinderProfileUIMM(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(259437);
        com.tencent.mm.plugin.sns.ad.e.h.a(MMApplicationContext.getContext(), str, str2, str3, i2);
        AppMethodBeat.o(259437);
    }

    @com.tencent.mm.remoteservice.f
    public String getSnsStatExtBySnsIdMM(long j2) {
        AppMethodBeat.i(95235);
        AdSnsInfo JE = aj.faR().JE(j2);
        if (JE != null) {
            String b2 = com.tencent.mm.plugin.sns.ad.g.j.b(JE.getTimeLine());
            AppMethodBeat.o(95235);
            return b2;
        }
        Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", Long.valueOf(j2));
        AppMethodBeat.o(95235);
        return "";
    }

    @com.tencent.mm.remoteservice.f
    public boolean isApkExistMM(String str) {
        AppMethodBeat.i(95293);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        boolean isApkExist = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(str);
        AppMethodBeat.o(95293);
        return isApkExist;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isDownloadingMM(String str) {
        AppMethodBeat.i(95294);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg == null || alg.status != 1) {
            AppMethodBeat.o(95294);
            return false;
        }
        AppMethodBeat.o(95294);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isPkgInstalledMM(String str) {
        AppMethodBeat.i(95296);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        boolean bz = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bz(MMApplicationContext.getContext(), str);
        AppMethodBeat.o(95296);
        return bz;
    }

    @com.tencent.mm.remoteservice.f
    public boolean isPausedMM(String str) {
        AppMethodBeat.i(95298);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg == null || alg.status != 2) {
            AppMethodBeat.o(95298);
            return false;
        }
        AppMethodBeat.o(95298);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public long startDownloadMM(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, boolean z2) {
        long a2;
        AppMethodBeat.i(176244);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        b bVar = new b(str, str3, z);
        a.b bVar2 = this.DGp;
        if (!z2) {
            g.a aVar2 = new g.a();
            aVar2.setAppId(str);
            aVar2.alm(str);
            aVar2.gm(str3);
            aVar2.setFileMD5(str4);
            aVar2.alj(str5);
            aVar2.all(str6);
            aVar2.kS(z);
            a2 = com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar2.qIY);
        } else {
            com.tencent.mm.plugin.downloader_app.a.a aVar3 = new com.tencent.mm.plugin.downloader_app.a.a();
            aVar3.downloadUrl = str5;
            aVar3.appId = str2;
            aVar3.qKu = str;
            aVar3.packageName = str3;
            aVar3.mYc = str4;
            aVar3.appName = str6;
            aVar3.dNv = 1;
            aVar3.qKw = z;
            aVar3.scene = TXLiteAVCode.WARNING_ROOM_DISCONNECT;
            a2 = ((com.tencent.mm.plugin.downloader_app.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(aVar3, new a.b() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.downloader_app.api.a.b
                public final void a(a.EnumC0947a aVar, long j2) {
                    AppMethodBeat.i(96292);
                    Log.d("MicroMsg.AdDownloadApkMgr", "downloadId=" + j2 + ", result=" + aVar);
                    AppMethodBeat.o(96292);
                }
            });
        }
        if (bVar2 != null) {
            aVar.DGp = bVar2;
        }
        if (z) {
            aVar.a(str3, bVar);
        }
        aVar.DXl.put(str, new a.d(str7, str8, str9));
        com.tencent.mm.plugin.downloader.model.f.cBv();
        com.tencent.mm.plugin.downloader.model.c.a(aVar.DXm);
        Log.i("AdLandingPagesProxy", "startDownloadMM, id %d", Long.valueOf(a2));
        AppMethodBeat.o(176244);
        return a2;
    }

    @com.tencent.mm.remoteservice.f
    public void stopTaskMM(String str) {
        AppMethodBeat.i(95309);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg != null) {
            com.tencent.mm.plugin.downloader.model.f.cBv().Cn(alg.id);
        }
        AppMethodBeat.o(95309);
    }

    @com.tencent.mm.remoteservice.f
    public long queryIdByAppidMM(String str) {
        AppMethodBeat.i(95311);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        long queryIdByAppid = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str);
        AppMethodBeat.o(95311);
        return queryIdByAppid;
    }

    @com.tencent.mm.remoteservice.f
    public boolean pauseTaskMM(String str) {
        AppMethodBeat.i(95313);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        boolean Cp = com.tencent.mm.plugin.downloader.model.f.cBv().Cp(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(str));
        AppMethodBeat.o(95313);
        return Cp;
    }

    @com.tencent.mm.remoteservice.f
    public int getTaskProgressMM(String str) {
        AppMethodBeat.i(95315);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg.oJj != 0) {
            int i2 = (int) ((alg.qJe * 100) / alg.oJj);
            AppMethodBeat.o(95315);
            return i2;
        }
        AppMethodBeat.o(95315);
        return 0;
    }

    @com.tencent.mm.remoteservice.f
    public boolean resumeTaskMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(176246);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        a.b bVar = this.DGp;
        com.tencent.mm.plugin.downloader.model.f.cBv();
        com.tencent.mm.plugin.downloader.model.c.a(aVar.DXm);
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg != null) {
            if (bVar != null) {
                aVar.DGp = bVar;
            }
            aVar.DXl.put(str, new a.d(str2, str3, str4));
            boolean Cq = com.tencent.mm.plugin.downloader.model.f.cBv().Cq(alg.id);
            AppMethodBeat.o(176246);
            return Cq;
        }
        AppMethodBeat.o(176246);
        return false;
    }

    @com.tencent.mm.remoteservice.f
    public boolean installAppMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(95319);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        Context context = MMApplicationContext.getContext();
        b bVar = new b(str, str2, false);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(95319);
            return false;
        }
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg == null || alg.status != 3 || TextUtils.isEmpty(alg.path)) {
            AppMethodBeat.o(95319);
            return false;
        }
        aVar.aH(4, alg.id);
        r.b(context, alg.path, null, false);
        aVar.a(str2, bVar);
        AppMethodBeat.o(95319);
        return true;
    }

    @com.tencent.mm.remoteservice.f
    public void reportDownloadInfoMM(int i2, String str) {
        AppMethodBeat.i(95321);
        a.e.DXp.reportDownloadInfo(i2, str);
        AppMethodBeat.o(95321);
    }

    @com.tencent.mm.remoteservice.f
    public void addReportInfoMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(176248);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(176248);
            return;
        }
        aVar.DXl.put(str, new a.d(str2, str3, str4));
        AppMethodBeat.o(176248);
    }

    static /* synthetic */ void aOI(String str) {
        long j2;
        int indexOf;
        AppMethodBeat.i(95374);
        int indexOf2 = str.indexOf("<canvasId>");
        if (indexOf2 < 0 || (indexOf = str.indexOf("</canvasId>")) <= indexOf2) {
            j2 = 0;
        } else {
            j2 = (long) Util.safeParseInt(str.substring(indexOf2 + 10, indexOf));
        }
        if (j2 > 0) {
            Log.i("AdLandingPagesProxy", "caching canvasId %d", Long.valueOf(j2));
            m.feB().J(j2, str);
        }
        AppMethodBeat.o(95374);
    }
}
