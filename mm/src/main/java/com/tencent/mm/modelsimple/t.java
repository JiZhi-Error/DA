package com.tencent.mm.modelsimple;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.z;
import com.tencent.mm.network.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public final class t extends q implements m {
    public String account;
    i callback;
    private int errCode;
    private int errType;
    public final s iMO;
    private int iMt;
    private String jjT;
    private String jjU;
    private boolean jjV;
    private boolean jjW;
    private int jjX;
    private int jjY;
    public String jjZ;
    private boolean jka;

    public t(int i2, String str, String str2, String str3) {
        this("", "", i2, str, str2, str3, 0, "", false, false);
    }

    public t(String str, String str2, String str3, int i2) {
        this(str, str2, 0, "", "", "", i2, str3, false, false);
    }

    public t(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.jjZ = str;
    }

    public t(String str, String str2, int i2, String str3, String str4, String str5, int i3, String str6, boolean z, boolean z2) {
        AppMethodBeat.i(134165);
        this.jjT = "";
        this.jjU = "";
        this.account = "";
        this.jjV = false;
        this.jjW = false;
        this.errType = 0;
        this.errCode = 0;
        this.iMt = 3;
        this.jjX = 0;
        this.jjY = 0;
        this.jka = false;
        Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i2 + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i3 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + Util.getStack());
        if (z && Util.isNullOrNil(str2)) {
            Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", str2);
        }
        this.account = str;
        this.iMO = new bh(f.KyZ ? 252 : 701);
        j.f fVar = (j.f) this.iMO.getReqObj();
        int i4 = bh.aVK().getInt("key_auth_update_version", 0);
        Log.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i4), Integer.valueOf(d.KyO));
        if (i4 == 0) {
            fVar.setSceneStatus(1);
            e.INSTANCE.idkeyStat(148, 0, 1, false);
            fVar.Kzz = true;
        } else if (i4 < d.KyO) {
            fVar.setSceneStatus(16);
            e.INSTANCE.idkeyStat(148, 1, 1, false);
        } else {
            fVar.setSceneStatus(1);
        }
        fVar.setUin(0);
        cmg cmg = new cmg();
        cme cme = new cme();
        fVar.Kzy.MrA = cmg;
        fVar.Kzy.MrB = cme;
        cme.KLS = new dfx();
        String bjr = b.bjq().bjr();
        if (!TextUtils.isEmpty(bjr)) {
            cme.KLS.LrO = b.bjq().jDB.LrO;
            cme.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
            Log.i("MicroMsg.NetSceneManualAuth", "manual auth add public key , length " + bjr.length());
        } else {
            cme.KLS.LrO = 0;
            cme.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            Log.e("MicroMsg.NetSceneManualAuth", "get sign key failed");
        }
        cme.Mrz = i3;
        jk jkVar = new jk();
        cme.KLK = jkVar;
        jkVar.KLk = str6;
        jkVar.KOa = 0;
        jkVar.KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        jkVar.KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ewr ewr = new ewr();
        jkVar.KNY = ewr;
        ewr.KQx = "";
        ewr.KQw = "";
        ewr.Num = "";
        fca fca = new fca();
        jkVar.KNZ = fca;
        fca.MbK = "";
        fca.MbJ = "";
        if (i2 == 1) {
            ewr.KQx = str3;
            ewr.KQw = str4;
            ewr.Num = str5;
            fca.MbK = "";
            fca.MbJ = "";
        } else if (i2 == 3) {
            ewr.KQx = "";
            ewr.KQw = "";
            ewr.Num = "";
            fca.MbK = str3;
            fca.MbJ = str4;
        }
        if (Util.isNullOrNil(str) && g.aAc()) {
            e.INSTANCE.idkeyStat(148, 2, 1, false);
            this.jjT = (String) g.aAh().azQ().get(3, (Object) null);
            this.jjU = (String) g.aAh().azQ().get(19, (Object) null);
            j.g gVar = (j.g) this.iMO.getRespObj();
            str = Util.nullAsNil((String) g.aAh().azQ().get(2, (Object) null));
            if (Util.isNullOrNil(str)) {
                str = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0)).toString();
            } else {
                gVar.dMW = str;
            }
        } else if (z || z2) {
            this.jjT = str2;
            this.jjU = str2;
        } else {
            this.jjT = Util.getCutPasswordMD5(Util.nullAsNil(str2));
            this.jjU = Util.getFullPasswordMD5(Util.nullAsNil(str2));
        }
        cmg.UserName = str;
        byte[] bArr = null;
        if (!(i2 == 1 || i2 == 3)) {
            if (i2 == 2) {
                bArr = g.aAf().azh().e(Util.getLong(str, 0), str3);
            } else if (Util.isValidQQNum(str)) {
                bArr = g.aAf().azh().a(Util.getLong(str, 0), this.jjU, true);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = Util.secPrint(Util.dumpHex(bArr));
        Log.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", objArr);
        jkVar.KNX = new SKBuiltinBuffer_t().setBuffer(Util.isNullOrNil(bArr) ? new byte[0] : bArr);
        cmg.KQi = this.jjU;
        cmg.KQv = this.jjT;
        b.a aVar = new b.a();
        aVar.jDD = b.bjq().bjr();
        aVar.jDC = b.bjq().jDC;
        fVar.setCGiVerifyKey(aVar);
        e.INSTANCE.idkeyStat(148, f.KyZ ? 104 : 105, 1, false);
        e.INSTANCE.idkeyStat(148, f.Kza ? 106 : 107, 1, false);
        AppMethodBeat.o(134165);
    }

    public final void PA(String str) {
        AppMethodBeat.i(134166);
        j.f fVar = (j.f) this.iMO.getReqObj();
        fVar.Kzy.MrA.KQi = str;
        fVar.Kzy.MrA.KQv = str;
        fVar.Kzy.MrB.KLK.KNX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.jjT = str;
        this.jjU = str;
        AppMethodBeat.o(134166);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.KyZ ? 252 : 701;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 5;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(134167);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(134167);
        return dispatch;
    }

    public final t bfj() {
        this.jka = true;
        return this;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134168);
        j.f fVar = (j.f) sVar.getReqObj();
        final j.g gVar = (j.g) sVar.getRespObj();
        if (gVar.Kzw == null || gVar.Kzw.Nky == null) {
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", Integer.valueOf(gVar.getRetCode()));
        } else {
            int i5 = gVar.Kzw.Nky.KLo;
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", Integer.valueOf(i5));
            g.aAi();
            g.aAh().hqB.set(47, Integer.valueOf(i5));
            com.tencent.mm.network.g gVar2 = g.aAg().hqi.iMw;
            if (gVar2 != null) {
                gVar2.fB((i5 & 1) == 0);
            }
        }
        this.errType = i3;
        this.errCode = i4;
        ell ell = gVar.Kzw;
        if (ell == null) {
            Log.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.callback.onSceneEnd(4, -1, "", this);
            e.INSTANCE.idkeyStat(148, 3, 1, false);
            AppMethodBeat.o(134168);
            return;
        }
        int i6 = ell.Nkx;
        Object[] objArr = new Object[11];
        objArr[0] = this.account;
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i4);
        objArr[3] = str;
        objArr[4] = ell;
        objArr[5] = Integer.valueOf(i6);
        objArr[6] = ell.Nky;
        objArr[7] = ell.Nkz;
        objArr[8] = ell.NkA;
        objArr[9] = ell.Nky == null ? -1 : ell.Nky.KLq;
        objArr[10] = ell.Nky == null ? -1 : ell.Nky.KLr;
        Log.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", objArr);
        if (i3 == 0 && i4 == 0) {
            if ((i6 & 2) != 0) {
                ba baVar = ell.Nkz;
                if (baVar == null || Util.isNullOrNil(baVar.UserName)) {
                    Log.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.callback.onSceneEnd(4, -1, "", this);
                    AppMethodBeat.o(134168);
                } else if (bh.a(sVar) == 2) {
                    e.INSTANCE.idkeyStat(148, 7, 1, false);
                    Log.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.jjY));
                    this.jjY++;
                    if (this.jjY > 1) {
                        this.callback.onSceneEnd(4, -1, "", this);
                        AppMethodBeat.o(134168);
                        return;
                    }
                    ((j.f) getReqResp().getReqObj()).Kzy.MrB.KLK.KOa = 1;
                    doScene(dispatcher(), this.callback);
                    AppMethodBeat.o(134168);
                } else {
                    g.aAk().setHighPriority();
                    Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    aj.a(gVar.Kzw, false);
                    ((PluginAuth) g.ah(PluginAuth.class)).getHandleAuthResponseCallbacks().a(fVar, gVar, false);
                    if (!Util.isNullOrNil(this.account)) {
                        g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, this.account);
                        bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, this.account);
                    }
                    g.aAg().hqi.a(new bu(new bu.a() {
                        /* class com.tencent.mm.modelsimple.t.AnonymousClass2 */

                        @Override // com.tencent.mm.model.bu.a
                        public final void a(com.tencent.mm.network.g gVar) {
                            AppMethodBeat.i(134163);
                            if (gVar == null || gVar.aZh() == null || gVar.aiZ(1) == null || gVar.aiZ(2) == null || gVar.aiZ(3) == null || gVar.Kzw == null || gVar.Kzw.Nky == null) {
                                e.INSTANCE.idkeyStat(148, 8, 1, false);
                                Log.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                AppMethodBeat.o(134163);
                                return;
                            }
                            Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", Util.secPrint(Util.dumpHex(gVar.aiZ(1))), Util.secPrint(Util.dumpHex(gVar.aiZ(2))), Util.secPrint(Util.dumpHex(gVar.aiZ(3))), Integer.valueOf(gVar.Kzw.Nky.rBx));
                            gVar.aZh().a(gVar.aiZ(1), gVar.aiZ(2), gVar.aiZ(3), gVar.Kzw.Nky.rBx);
                            AppMethodBeat.o(134163);
                        }
                    }), 0);
                    if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
                        ((com.tencent.mm.plugin.zero.b.b) g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().tE(10);
                    }
                    int i7 = ell.Nky.KLn;
                    if ((i7 & 8) == 0) {
                        String aTY = z.aTY();
                        if (!TextUtils.isEmpty(aTY)) {
                            g.aAg().hqi.a(new p(aTY), 0);
                        }
                    } else {
                        Log.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(i7));
                        e.INSTANCE.idkeyStat(148, 9, 1, false);
                    }
                    int i8 = 4;
                    if (fVar.Kzy.MrB.KLK.KNX != null && fVar.Kzy.MrB.KLK.KNX.getILen() > 0) {
                        i8 = 1;
                    } else if (fVar.Kzy.MrB.Mrz == 1) {
                        i8 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.E(1, i8, fVar.Kzy.MrA.UserName);
                    if (i3 == 0 && i4 == 0) {
                        Log.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        mi miVar = new mi();
                        miVar.dRI.result = true;
                        EventCenter.instance.publish(miVar);
                    }
                    g.aAk().setLowPriority();
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(134168);
                }
            } else {
                Log.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
                this.callback.onSceneEnd(4, -1, "", this);
                AppMethodBeat.o(134168);
            }
        } else if (i3 == 4 && i4 == -301) {
            Log.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            e.INSTANCE.idkeyStat(148, 4, 1, false);
            if (ell == null || ell.NkA == null) {
                Log.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                bh.a(true, ell.NkA.KQk, ell.NkA.KQl, ell.NkA.KQj);
            }
            this.iMt--;
            if (this.iMt <= 0) {
                Log.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getResources().getString(R.string.a4l) + "(" + i3 + ", " + i4 + ")", 0).show();
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134168);
                return;
            }
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.iMt));
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134168);
        } else if (!this.jka && i3 == 4 && i4 == -102) {
            e.INSTANCE.idkeyStat(148, 5, 1, false);
            final int i9 = sVar.getReqObj().getRsaInfo().ver;
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i9));
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.modelsimple.t.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(134161);
                    new m().doScene(t.this.dispatcher(), new i() {
                        /* class com.tencent.mm.modelsimple.t.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(134160);
                            Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                t.this.doScene(t.this.dispatcher(), t.this.callback);
                                AppMethodBeat.o(134160);
                                return;
                            }
                            t.this.callback.onSceneEnd(i2, i3, "", t.this);
                            AppMethodBeat.o(134160);
                        }
                    });
                    AppMethodBeat.o(134161);
                }

                public final String toString() {
                    AppMethodBeat.i(134162);
                    String str = super.toString() + "|onGYNetEnd1";
                    AppMethodBeat.o(134162);
                    return str;
                }
            });
            AppMethodBeat.o(134168);
        } else if (i3 == 4 && (i4 == -305 || i4 == -306)) {
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i4), Integer.valueOf(f.Kze));
            e.INSTANCE.idkeyStat(148, i4 == -305 ? 108 : 109, 1, true);
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134168);
        } else if (i3 == 4 && i4 == -217) {
            this.callback.onSceneEnd(i3, i4, str, this);
            e.INSTANCE.idkeyStat(148, 47, 1, false);
            AppMethodBeat.o(134168);
        } else if (i3 == 4 && i4 == -218) {
            this.callback.onSceneEnd(i3, i4, str, this);
            e.INSTANCE.idkeyStat(148, 53, 1, false);
            AppMethodBeat.o(134168);
        } else if (i3 == 4 && i4 == -240) {
            Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.iMt));
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134168);
                return;
            }
            e.INSTANCE.idkeyStat(148, 57, 1, false);
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134168);
        } else {
            Log.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i4), Integer.valueOf(i3), str);
            this.callback.onSceneEnd(i3, i4, str, this);
            e.INSTANCE.idkeyStat(148, 6, 1, false);
            if (f.KyZ && i4 != -106) {
                e.INSTANCE.idkeyStat(148, 110, 1, false);
            }
            AppMethodBeat.o(134168);
        }
    }

    public final String ajx() {
        AppMethodBeat.i(222850);
        ell ell = ((j.g) this.iMO.getRespObj()).Kzw;
        if (ell != null) {
            String str = ell.Nkz.ked;
            AppMethodBeat.o(222850);
            return str;
        }
        AppMethodBeat.o(222850);
        return null;
    }

    public static class a {
        public String dHx;
        public String dQx;
        public String jke;
        public Bundle jkf;
        public int type;
        public String username;

        public final String toString() {
            AppMethodBeat.i(134164);
            String format = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, Util.secPrint(this.dHx), this.jke, this.dQx, this.jkf);
            AppMethodBeat.o(134164);
            return format;
        }
    }

    public final String bfk() {
        AppMethodBeat.i(134169);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134169);
            return "";
        }
        String str = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLi;
        AppMethodBeat.o(134169);
        return str;
    }

    public final String bfl() {
        AppMethodBeat.i(134170);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134170);
            return "";
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((j.g) this.iMO.getRespObj()).Kzw.Nky.KLd != null) {
                String nullAsNil = Util.nullAsNil(((j.g) this.iMO.getRespObj()).Kzw.Nky.KLd.MbJ);
                AppMethodBeat.o(134170);
                return nullAsNil;
            }
        } else if (secCodeType == 1 && ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc != null) {
            String nullAsNil2 = Util.nullAsNil(((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc.KQw);
            AppMethodBeat.o(134170);
            return nullAsNil2;
        }
        AppMethodBeat.o(134170);
        return "";
    }

    public final byte[] bfm() {
        AppMethodBeat.i(134171);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(134171);
            return bArr;
        }
        int secCodeType = getSecCodeType();
        if (secCodeType == 3) {
            if (((j.g) this.iMO.getRespObj()).Kzw.Nky.KLd != null) {
                byte[] a2 = com.tencent.mm.platformtools.z.a(((j.g) this.iMO.getRespObj()).Kzw.Nky.KLd.MbL, new byte[0]);
                AppMethodBeat.o(134171);
                return a2;
            }
        } else if (secCodeType == 1) {
            if (((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc != null) {
                byte[] a3 = com.tencent.mm.platformtools.z.a(((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc.KHp, new byte[0]);
                AppMethodBeat.o(134171);
                return a3;
            }
        } else if (secCodeType == 2 && ((j.f) this.iMO.getReqObj()).Kzy.MrA != null) {
            g.aAf().azh().a(Util.getLong(((j.f) this.iMO.getReqObj()).Kzy.MrA.UserName, 0), com.tencent.mm.platformtools.z.a(((j.g) this.iMO.getRespObj()).Kzw.Nky.KLb));
            byte[] Ai = g.aAf().azh().Ai(Util.getLong(((j.f) this.iMO.getReqObj()).Kzy.MrA.UserName, 0));
            AppMethodBeat.o(134171);
            return Ai;
        }
        byte[] bArr2 = new byte[0];
        AppMethodBeat.o(134171);
        return bArr2;
    }

    public final int getSecCodeType() {
        AppMethodBeat.i(134172);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            Log.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            AppMethodBeat.o(134172);
            return 0;
        } else if (this.errType != 4) {
            Log.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            AppMethodBeat.o(134172);
            return 0;
        } else if (this.errCode == -311) {
            AppMethodBeat.o(134172);
            return 2;
        } else if (this.errCode == -6) {
            AppMethodBeat.o(134172);
            return 1;
        } else if (this.errCode == -310) {
            AppMethodBeat.o(134172);
            return 3;
        } else {
            AppMethodBeat.o(134172);
            return 0;
        }
    }

    public final String bfn() {
        AppMethodBeat.i(134173);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134173);
            return "";
        } else if (getSecCodeType() != 1 || ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc == null) {
            AppMethodBeat.o(134173);
            return "";
        } else if (((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc.Num != null) {
            String str = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLc.Num;
            AppMethodBeat.o(134173);
            return str;
        } else {
            AppMethodBeat.o(134173);
            return null;
        }
    }

    public final String bbH() {
        AppMethodBeat.i(134174);
        String str = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLk;
        AppMethodBeat.o(134174);
        return str;
    }

    public final boolean bfo() {
        AppMethodBeat.i(134175);
        if ((((j.g) this.iMO.getRespObj()).Kzw.Nky.KLn & 16) != 0) {
            AppMethodBeat.o(134175);
            return true;
        }
        AppMethodBeat.o(134175);
        return false;
    }

    public final String bfp() {
        AppMethodBeat.i(134176);
        String str = ((j.g) this.iMO.getRespObj()).Kzw.Nkz.KEb;
        AppMethodBeat.o(134176);
        return str;
    }

    public final int bfq() {
        int i2;
        AppMethodBeat.i(134177);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134177);
            return 0;
        }
        dyh dyh = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 11) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
            AppMethodBeat.o(134177);
            return i2;
        }
        i2 = 0;
        AppMethodBeat.o(134177);
        return i2;
    }

    public final BindWordingContent bfr() {
        String str;
        BindWordingContent bindWordingContent;
        AppMethodBeat.i(134178);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134178);
            return null;
        }
        dyh dyh = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 12) {
                    str = next.NeO;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            new a();
            try {
                bindWordingContent = a.Py(str);
            } catch (XmlPullParserException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
                bindWordingContent = null;
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneManualAuth", e3, "", new Object[0]);
            }
            AppMethodBeat.o(134178);
            return bindWordingContent;
        }
        bindWordingContent = null;
        AppMethodBeat.o(134178);
        return bindWordingContent;
    }

    public final String bfs() {
        AppMethodBeat.i(134179);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134179);
            return "";
        }
        dyh dyh = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLj;
        if (!(dyh == null || dyh.MXV == null || dyh.MXV.size() <= 0)) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (it.hasNext()) {
                eer next = it.next();
                if (next.Cya == 16) {
                    String str = next.NeO;
                    AppMethodBeat.o(134179);
                    return str;
                }
            }
        }
        AppMethodBeat.o(134179);
        return "";
    }

    public final int bft() {
        int i2;
        AppMethodBeat.i(134180);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134180);
            return 0;
        }
        dyh dyh = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 13) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
            AppMethodBeat.o(134180);
            return i2;
        }
        i2 = 0;
        AppMethodBeat.o(134180);
        return i2;
    }

    public final boolean bfu() {
        AppMethodBeat.i(134181);
        if (((j.g) this.iMO.getRespObj()).Kzw.Nky == null) {
            AppMethodBeat.o(134181);
            return true;
        }
        dyh dyh = ((j.g) this.iMO.getRespObj()).Kzw.Nky.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 18) {
                    if (Util.getInt(next.NeO, 0) == 1) {
                        AppMethodBeat.o(134181);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(134181);
        return true;
    }
}
