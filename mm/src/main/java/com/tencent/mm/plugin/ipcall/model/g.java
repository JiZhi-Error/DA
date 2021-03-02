package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.k;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g.c;
import com.tencent.mm.plugin.ipcall.model.g.d;
import com.tencent.mm.plugin.ipcall.model.g.e;
import com.tencent.mm.plugin.ipcall.model.g.f;
import com.tencent.mm.plugin.ipcall.model.g.h;
import com.tencent.mm.plugin.ipcall.model.g.i;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class g implements a.AbstractC1441a, b.a {
    public boolean dWM = false;
    public int yoI = 0;
    public int yoJ = 0;
    public int yoK = 0;
    public boolean yoL = false;
    public boolean yoM = false;
    public a yoN;
    public d yoO = new d();
    i yoP = new i();
    com.tencent.mm.plugin.ipcall.model.g.a yoQ = new com.tencent.mm.plugin.ipcall.model.g.a();
    h yoR = new h();
    c yoS = new c();
    public e yoT = new e();
    com.tencent.mm.plugin.ipcall.model.g.g yoU = new com.tencent.mm.plugin.ipcall.model.g.g();
    f yoV = new f();
    public com.tencent.mm.plugin.ipcall.model.b.c yoW;
    public boolean yoX = false;
    public boolean yoY = false;
    p yoZ = new p.a() {
        /* class com.tencent.mm.plugin.ipcall.model.g.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            boolean z = false;
            AppMethodBeat.i(25363);
            Log.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", Integer.valueOf(i2));
            if (i.eat().yqI) {
                f eaw = i.eaw();
                if (eaw.mAT == 4 || eaw.mAT == 5) {
                    z = true;
                }
                if (z && i2 == 4 && g.this.yoV != null) {
                    g.this.yoV.a(g.this.yoW);
                }
            }
            AppMethodBeat.o(25363);
        }
    };

    public interface a {
        void X(String str, String str2, int i2);

        void Y(String str, String str2, int i2);

        void Z(String str, String str2, int i2);

        void aa(String str, String str2, int i2);

        void dZI();

        void dZJ();

        void dZK();

        void dZL();

        void dZM();

        void dZN();

        void ep(String str, int i2);

        void eq(String str, int i2);

        void er(String str, int i2);
    }

    public g() {
        AppMethodBeat.i(25364);
        AppMethodBeat.o(25364);
    }

    public final void eap() {
        AppMethodBeat.i(25365);
        if (this.yoW.yqk) {
            Log.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.yoL = true;
        Log.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(this.yoW.ypJ));
        this.yoS.stop();
        this.yoP.stop();
        this.yoQ.a(this.yoW);
        this.yoU.a(this.yoW);
        AppMethodBeat.o(25365);
    }

    public final void Pb(int i2) {
        AppMethodBeat.i(25366);
        if (!this.yoW.yqk) {
            Log.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        Log.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(this.yoW.ypJ));
        this.yoM = true;
        this.yoS.stop();
        this.yoP.stop();
        this.yoR.ysA = false;
        this.yoR.ysz = i2;
        this.yoR.a(this.yoW);
        this.yoU.a(this.yoW);
        AppMethodBeat.o(25366);
    }

    private void qp(boolean z) {
        AppMethodBeat.i(25367);
        Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(z), Boolean.valueOf(this.yoL), Boolean.valueOf(this.yoM));
        if (this.yoL || this.yoM) {
            Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
            AppMethodBeat.o(25367);
        } else if (z) {
            if (this.yoN != null) {
                if (!this.yoW.ypV) {
                    this.yoN.dZN();
                } else {
                    this.yoN.dZI();
                }
            }
            Log.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.yoP.a(this.yoW);
            AppMethodBeat.o(25367);
        } else {
            if (this.yoN != null) {
                if (this.yoW.ypS) {
                    this.yoN.Y(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                    AppMethodBeat.o(25367);
                    return;
                } else if (this.yoW.ypT) {
                    this.yoN.Z(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                    AppMethodBeat.o(25367);
                    return;
                } else if (this.yoW.ypU) {
                    this.yoN.aa(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                    AppMethodBeat.o(25367);
                    return;
                } else if (!this.yoW.ypV) {
                    this.yoN.dZN();
                    AppMethodBeat.o(25367);
                    return;
                } else {
                    this.yoN.X(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                }
            }
            AppMethodBeat.o(25367);
        }
    }

    private void qq(boolean z) {
        AppMethodBeat.i(25368);
        Log.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", Boolean.valueOf(z));
        if (!z) {
            this.yoI++;
            if (this.yoI >= 2) {
                Log.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
                this.yoS.stop();
                if (i.eaw().eao() && this.yoN != null) {
                    this.yoN.dZM();
                    AppMethodBeat.o(25368);
                    return;
                }
            }
        } else {
            this.yoI = 0;
        }
        AppMethodBeat.o(25368);
    }

    private void L(boolean z, int i2) {
        AppMethodBeat.i(25369);
        Log.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", Boolean.valueOf(z));
        if (z || i2 >= 0 || this.yoK > 0) {
            AppMethodBeat.o(25369);
            return;
        }
        this.yoK++;
        Log.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", Integer.valueOf(this.yoK));
        this.yoQ.a(this.yoW);
        AppMethodBeat.o(25369);
    }

    private void M(boolean z, int i2) {
        AppMethodBeat.i(25370);
        Log.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", Boolean.valueOf(z), Boolean.valueOf(this.yoR.ysA));
        if (z || i2 >= 0 || this.yoJ > 0) {
            AppMethodBeat.o(25370);
            return;
        }
        this.yoJ++;
        Log.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", Integer.valueOf(this.yoJ), Boolean.valueOf(this.yoR.ysA));
        this.yoR.a(this.yoW);
        AppMethodBeat.o(25370);
    }

    private void qr(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(25371);
        Log.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", Boolean.valueOf(z));
        if (z && i.eat().yqI) {
            i.eat().Pd(this.yoW.yqb);
        }
        if (!z) {
            Log.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.yoP.stop();
            if (i.eaw().mAT != 3) {
                z2 = false;
            }
            if (z2 && this.yoN != null) {
                this.yoN.er(this.yoW.rBM, this.yoW.ypM);
            }
            AppMethodBeat.o(25371);
            return;
        }
        if (this.yoW != null && z) {
            Pc(this.yoW.eaJ());
        }
        AppMethodBeat.o(25371);
    }

    private void qs(boolean z) {
        AppMethodBeat.i(25372);
        Log.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", Boolean.valueOf(z));
        if (z && i.eat().yqI) {
            i.eat().Pd(this.yoW.yqb);
        }
        if (this.yoW != null && z) {
            int eaJ = this.yoW.eaJ();
            if (eaJ == 2 || eaJ == 1) {
                if (!this.yoY) {
                    bg.azz().a(new o(this.yoW.roomId, this.yoW.ypH, this.yoW.eaI(), this.yoW.ypI, false), 0);
                } else {
                    Log.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    AppMethodBeat.o(25372);
                    return;
                }
            }
            Pc(this.yoW.eaJ());
        }
        AppMethodBeat.o(25372);
    }

    public final boolean Pc(int i2) {
        AppMethodBeat.i(25373);
        switch (i2) {
            case 1:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (!this.yoX) {
                    this.yoX = true;
                    if (this.yoN != null) {
                        this.yoN.dZJ();
                    }
                }
                AppMethodBeat.o(25373);
                return true;
            case 2:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(this.yoL), Boolean.valueOf(this.yoM));
                if (this.yoL || this.yoM) {
                    AppMethodBeat.o(25373);
                    return true;
                }
                this.yoP.stop();
                if (!this.dWM) {
                    this.dWM = true;
                    if (this.yoW != null) {
                        this.yoW.yqk = true;
                    }
                    if (this.yoN != null) {
                        this.yoN.dZK();
                    }
                    this.yoS.a(this.yoW);
                }
                AppMethodBeat.o(25373);
                return true;
            case 3:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.yoP.stop();
                this.yoS.stop();
                if (this.yoN != null) {
                    this.yoN.eq(this.yoW.rBM, this.yoW.ypM);
                }
                AppMethodBeat.o(25373);
                return true;
            case 4:
            case 7:
            case 8:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.yoW.ypU) {
                    if (this.yoN != null) {
                        this.yoN.aa(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                    }
                } else if (this.yoN != null) {
                    this.yoN.ep(this.yoW.rBM, this.yoW.ypM);
                }
                AppMethodBeat.o(25373);
                return true;
            case 5:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.yoN != null) {
                    this.yoN.dZL();
                }
                AppMethodBeat.o(25373);
                return true;
            case 6:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.yoW.ypS = true;
                if (this.yoN != null) {
                    this.yoN.Y(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
                }
                AppMethodBeat.o(25373);
                return true;
            default:
                Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", Integer.valueOf(i2));
                AppMethodBeat.o(25373);
                return false;
        }
    }

    private void qt(boolean z) {
        int AddNewRelayConns;
        AppMethodBeat.i(25374);
        Log.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", Boolean.valueOf(z));
        if (z) {
            com.tencent.mm.plugin.ipcall.model.d.a eat = i.eat();
            com.tencent.mm.plugin.ipcall.model.b.c cVar = this.yoW;
            Log.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (!(cVar == null || cVar.oMr == null || cVar.oMr.size() <= 0)) {
                com.tencent.mm.plugin.ipcall.a.c.bc(cVar.oMr);
            }
            if (!(cVar == null || cVar.yqe == null || cVar.yqe.size() <= 0)) {
                com.tencent.mm.plugin.ipcall.a.c.bc(cVar.yqe);
            }
            dmm dmm = new dmm();
            dml dml = new dml();
            dml.LqX = 0;
            dml.LqY = "";
            dml.LqZ = "";
            dml.Lra = 4;
            dml.Lrb = 4;
            dml.Lrc = 2;
            dml.MPX = new esr();
            dml.MPY = new esr();
            if (!(cVar == null || cVar.oMr == null || cVar.oMr.size() <= 0)) {
                dml.MPX = com.tencent.mm.plugin.ipcall.a.c.bc(cVar.oMr);
            }
            if (!(cVar == null || cVar.yqe == null || cVar.yqe.size() <= 0)) {
                dml.MPY = com.tencent.mm.plugin.ipcall.a.c.bc(cVar.yqe);
            }
            dmm.MQa.add(dml);
            dmm.MPZ = 1;
            byte[] bArr = null;
            try {
                bArr = dmm.toByteArray();
            } catch (Exception e2) {
                Log.e("MicroMsg.IPCallEngineManager", "conn info to byte array fail..");
            }
            if (!(bArr == null || (AddNewRelayConns = eat.yqF.AddNewRelayConns(bArr, bArr.length, 1)) == 0)) {
                com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(AddNewRelayConns)));
            }
        }
        AppMethodBeat.o(25374);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.ipcall.model.b.a.AbstractC1441a
    public final void a(int i2, Object obj, int i3, int i4) {
        AppMethodBeat.i(25375);
        if (c(i2, obj, i3, i4)) {
            Log.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            AppMethodBeat.o(25375);
            return;
        }
        switch (i2) {
            case 1:
                qp(true);
                AppMethodBeat.o(25375);
                return;
            case 3:
                L(true, i4);
                AppMethodBeat.o(25375);
                return;
            case 4:
                M(true, i4);
                AppMethodBeat.o(25375);
                return;
            case 6:
                qt(true);
                break;
            case 8:
                qs(true);
                AppMethodBeat.o(25375);
                return;
        }
        AppMethodBeat.o(25375);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.ipcall.model.b.a.AbstractC1441a
    public final void b(int i2, Object obj, int i3, int i4) {
        AppMethodBeat.i(25376);
        if (c(i2, obj, i3, i4)) {
            Log.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            AppMethodBeat.o(25376);
            return;
        }
        switch (i2) {
            case 1:
                qp(false);
                AppMethodBeat.o(25376);
                return;
            case 3:
                L(false, i4);
                AppMethodBeat.o(25376);
                return;
            case 4:
                M(false, i4);
                AppMethodBeat.o(25376);
                return;
            case 6:
                qt(false);
                break;
            case 8:
                qs(false);
                AppMethodBeat.o(25376);
                return;
        }
        AppMethodBeat.o(25376);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.ipcall.model.b.b.a
    public final void a(int i2, q qVar, int i3, int i4) {
        AppMethodBeat.i(25377);
        if (c(i2, qVar, i3, i4)) {
            Log.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            AppMethodBeat.o(25377);
            return;
        }
        switch (i2) {
            case 2:
                qr(true);
                AppMethodBeat.o(25377);
                return;
            case 5:
                qq(true);
                break;
        }
        AppMethodBeat.o(25377);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.ipcall.model.b.b.a
    public final void b(int i2, q qVar, int i3, int i4) {
        AppMethodBeat.i(25378);
        if (c(i2, qVar, i3, i4)) {
            Log.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            AppMethodBeat.o(25378);
            return;
        }
        switch (i2) {
            case 2:
                qr(false);
                AppMethodBeat.o(25378);
                return;
            case 5:
                qq(false);
                break;
        }
        AppMethodBeat.o(25378);
    }

    private boolean c(int i2, Object obj, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(25379);
        if (this.yoW == null || obj == null) {
            Log.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            AppMethodBeat.o(25379);
            return true;
        }
        switch (i2) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.model.e.i) {
                    com.tencent.mm.plugin.ipcall.model.e.i iVar = (com.tencent.mm.plugin.ipcall.model.e.i) obj;
                    dfm dfm = iVar.yrF;
                    if (this.yoW.ypJ == iVar.yrE.MKg) {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", Integer.valueOf(this.yoW.ypJ));
                        i.eau().gQ(this.yoW.ypJ, i4);
                        if (i3 == 0 && i4 == 0) {
                            if (this.yoW != null) {
                                this.yoW.roomId = dfm.LsZ;
                                this.yoW.ypH = dfm.Lta;
                                this.yoW.ypI = dfm.MKi;
                                this.yoW.ypO = dfm.MKr;
                                this.yoW.ypQ = dfm.MKs * 1000;
                                this.yoW.ypX = dfm.ypX;
                                this.yoW.ypY = dfm.ypY;
                                this.yoW.oMr = dfm.KMD;
                                this.yoW.yqe = dfm.MKt;
                                this.yoW.yqj = dfm.MKu;
                                if (dfm.yqf > 0) {
                                    this.yoW.yqf = dfm.yqf;
                                }
                                this.yoW.ypZ = dfm.ypZ;
                                this.yoW.yqa = dfm.yqa;
                                this.yoW.ypW = dfm.MKw;
                                if (dfm.yqc > 0) {
                                    this.yoW.yqc = dfm.yqc - 1;
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.yoW.yqc + "] from Invite resp");
                                } else {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.yoW.yqc = 2;
                                }
                                this.yoW.yqd = dfm.MKv;
                                Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", Integer.valueOf(dfm.ypR));
                                if (dfm.ypR > 0) {
                                    this.yoW.ypV = false;
                                    this.yoW.ypR = dfm.ypR;
                                } else {
                                    this.yoW.ypV = true;
                                    this.yoW.ypR = 0;
                                }
                                this.yoW.ypN = dfm.ypN;
                                this.yoW.ypM = dfm.ypM;
                                this.yoW.rBL = i4;
                                this.yoW.rBM = Util.nullAsNil(z.a(dfm.BaseResponse.ErrMsg));
                                break;
                            }
                        } else {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                            if (dfm.BaseResponse == null) {
                                this.yoW.ypN = "";
                                this.yoW.ypM = 2;
                                this.yoW.rBM = MMApplicationContext.getContext().getString(R.string.aml);
                                this.yoW.rBL = i4;
                                break;
                            } else {
                                if (i4 == 433) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                                    this.yoW.ypS = true;
                                } else if (i4 == 434) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                                    this.yoW.ypT = true;
                                } else if (i4 == 435) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                                    this.yoW.ypU = true;
                                }
                                if (dfm.ypR > 0) {
                                    this.yoW.ypV = false;
                                    this.yoW.ypR = dfm.ypR;
                                } else {
                                    this.yoW.ypV = true;
                                    this.yoW.ypR = 0;
                                }
                                this.yoW.ypN = dfm.ypN;
                                this.yoW.ypM = dfm.ypM;
                                this.yoW.rBL = i4;
                                if (dfm.getBaseResponse() != null) {
                                    this.yoW.rBM = Util.nullAsNil(z.a(dfm.BaseResponse.ErrMsg));
                                    Log.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", Integer.valueOf(dfm.ypM), Integer.valueOf(i4), this.yoW.rBM);
                                    break;
                                }
                            }
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.yoW.ypJ), Integer.valueOf(iVar.yrE.MKg));
                        AppMethodBeat.o(25379);
                        return true;
                    }
                } else {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
                break;
            case 2:
                if (obj instanceof o) {
                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                    o oVar = (o) obj;
                    dfv dfv = oVar.yrR;
                    if (this.yoW.roomId == oVar.yrQ.LsZ) {
                        if (i3 == 0 && i4 == 0) {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", Integer.valueOf(dfv.LsZ), Integer.valueOf(dfv.MKF), Integer.valueOf(dfv.MKG), Integer.valueOf(dfv.MKD));
                            if (dfv.LsZ == this.yoW.roomId && dfv.Lta == this.yoW.ypH) {
                                if (dfv.MKG == this.yoW.ypO) {
                                    Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (dfv.MKD > this.yoW.ypP) {
                                        this.yoW.ypP = dfv.MKD;
                                        if (dfv.MKF != 0) {
                                            this.yoW.lPy = dfv.MKF;
                                        }
                                    }
                                } else {
                                    Log.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    boolean z2 = false;
                                    Iterator<com.tencent.mm.plugin.ipcall.model.b.d> it = this.yoW.yqg.iterator();
                                    while (it.hasNext()) {
                                        com.tencent.mm.plugin.ipcall.model.b.d next = it.next();
                                        if (next.qrD == dfv.MKG) {
                                            if (dfv.MKD > next.ypP) {
                                                next.ypP = dfv.MKD;
                                                if (dfv.MKF != 0) {
                                                    next.hpS = dfv.MKF;
                                                }
                                            }
                                            z2 = true;
                                        } else {
                                            z2 = z2;
                                        }
                                    }
                                    if (!z2) {
                                        com.tencent.mm.plugin.ipcall.model.b.d dVar = new com.tencent.mm.plugin.ipcall.model.b.d();
                                        dVar.qrD = dfv.MKG;
                                        dVar.hpS = dfv.MKF;
                                        dVar.ypP = dfv.MKD;
                                        this.yoW.yqg.add(dVar);
                                    }
                                }
                                if (dfv.rBL == 404 || dfv.rBL == 484) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.yoW.ypU = true;
                                }
                                this.yoW.rBM = dfv.rBM;
                                this.yoW.rBL = dfv.rBL;
                                this.yoW.ypM = dfv.ypM;
                                this.yoW.ypN = dfv.ypN;
                                this.yoW.yqb = dfv.yqb;
                                break;
                            }
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(oVar.yrQ.LsZ));
                        AppMethodBeat.o(25379);
                        return true;
                    }
                } else {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
            case 3:
                if (!(obj instanceof com.tencent.mm.plugin.ipcall.model.e.a)) {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                com.tencent.mm.plugin.ipcall.model.e.a aVar = (com.tencent.mm.plugin.ipcall.model.e.a) obj;
                if (this.yoW.ypJ != aVar.yrn.MKg) {
                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.yoW.ypJ), Integer.valueOf(aVar.yrn.MKg));
                    AppMethodBeat.o(25379);
                    return true;
                }
                break;
            case 4:
                if (obj instanceof n) {
                    n nVar = (n) obj;
                    if (this.yoW.roomId == nVar.yrO.LsZ) {
                        if (i3 != 0 || i4 != 0) {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        } else {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                            this.yoW.lPy = 5;
                            break;
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(nVar.yrO.LsZ));
                        AppMethodBeat.o(25379);
                        return true;
                    }
                } else {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
            case 5:
                if (!(obj instanceof com.tencent.mm.plugin.ipcall.model.e.h)) {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                com.tencent.mm.plugin.ipcall.model.e.h hVar = (com.tencent.mm.plugin.ipcall.model.e.h) obj;
                if (this.yoW.roomId != hVar.yrC.LsZ) {
                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(hVar.yrC.LsZ));
                    AppMethodBeat.o(25379);
                    return true;
                }
                break;
            case 6:
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    dfp dfp = kVar.yrJ;
                    if (this.yoW.roomId == kVar.yrI.LsZ) {
                        if (i3 != 0 || i4 != 0) {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        } else {
                            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                            this.yoW.oMr = dfp.KMD;
                            this.yoW.yqe = dfp.MKt;
                            break;
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(kVar.yrI.LsZ));
                        AppMethodBeat.o(25379);
                        return true;
                    }
                } else {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
            case 8:
                if (obj instanceof dfn) {
                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    dfn dfn = (dfn) obj;
                    if (this.yoW.roomId == dfn.LsZ) {
                        if (i3 == 0 && i4 == 0) {
                            this.yoW.yqb = dfn.yqb;
                            Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", Integer.valueOf(dfn.MKx.size()));
                            Iterator<dfw> it2 = dfn.MKx.iterator();
                            while (it2.hasNext()) {
                                dfw next2 = it2.next();
                                if (this.yoW.ypO == next2.MKG) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(this.yoW.ypO), Integer.valueOf(next2.MKH), Integer.valueOf(next2.MKI));
                                    if (next2.MKI > this.yoW.ypP) {
                                        this.yoW.ypP = next2.MKI;
                                        if (next2.MKH != 0) {
                                            this.yoW.lPy = next2.MKH;
                                        }
                                    }
                                } else {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(next2.MKG), Integer.valueOf(next2.MKH), Integer.valueOf(next2.MKI));
                                    boolean z3 = false;
                                    Iterator<com.tencent.mm.plugin.ipcall.model.b.d> it3 = this.yoW.yqg.iterator();
                                    while (it3.hasNext()) {
                                        com.tencent.mm.plugin.ipcall.model.b.d next3 = it3.next();
                                        if (next3.qrD == next2.MKG) {
                                            if (next2.MKI > next3.ypP) {
                                                next3.ypP = next2.MKI;
                                                if (next2.MKH != 0) {
                                                    next3.hpS = next2.MKH;
                                                }
                                            }
                                            z = true;
                                        } else {
                                            z = z3;
                                        }
                                        z3 = z;
                                    }
                                    if (!z3) {
                                        com.tencent.mm.plugin.ipcall.model.b.d dVar2 = new com.tencent.mm.plugin.ipcall.model.b.d();
                                        dVar2.qrD = next2.MKG;
                                        dVar2.hpS = next2.MKH;
                                        dVar2.ypP = next2.MKI;
                                        this.yoW.yqg.add(dVar2);
                                    }
                                }
                                if (next2.rBL == 404 || next2.rBL == 484) {
                                    Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.yoW.ypU = true;
                                }
                                this.yoW.rBM = next2.rBM;
                                this.yoW.rBL = next2.rBL;
                                this.yoW.ypM = next2.ypM;
                                this.yoW.ypN = next2.ypN;
                            }
                            break;
                        }
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.yoW.roomId), Integer.valueOf(dfn.LsZ));
                        AppMethodBeat.o(25379);
                        return true;
                    }
                } else {
                    Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                    AppMethodBeat.o(25379);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(25379);
        return false;
    }
}
