package com.tencent.mm.modelsimple;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.ba.i;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.cr;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.recovery.wx.util.WXUtil;
import java.util.Iterator;
import java.util.LinkedList;

public final class v extends q implements m {
    i callback;
    public s iMO;
    private int iMt = 2;
    private final String jki;
    private final String jkj;
    private final String jkk;
    private final String jkl;
    private final String jkm;
    private final String jkn;
    private final int jko;
    private final int jkp;
    private boolean jkq = true;
    public boolean jkr = false;

    public v(String str, String str2, String str3, int i2, String str4, String str5, String str6, int i3) {
        AppMethodBeat.i(134188);
        Log.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        Log.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i2 + "bindEmail = " + str4 + " bindMobile = " + str5);
        Log.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i3 + " ticket: " + str6);
        this.jkp = i3;
        this.iMO = new bj();
        x.a aVar = (x.a) this.iMO.getReqObj();
        aVar.setUin(0);
        aVar.KAi.UserName = str;
        aVar.KAi.KQi = Util.getCutPasswordMD5(str2);
        if (i3 == 4) {
            aVar.KAi.KQi = str6;
            Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.KAi.KQi);
        }
        aVar.KAi.oUJ = str3;
        aVar.KAi.KDZ = i2;
        aVar.KAi.KEa = str4;
        aVar.KAi.KEb = str5;
        aVar.KAi.Bri = str6;
        aVar.KAi.LtW = i3;
        aVar.KAi.rBH = Util.getTimeZoneOffset();
        aVar.KAi.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        aVar.KAi.rBI = LocaleUtil.getApplicationLanguage();
        aVar.KAi.KLM = 0;
        aVar.KAi.MyA = 0;
        aVar.KAi.MyB = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
        aVar.KAi.LuU = com.tencent.mm.compatible.deviceinfo.q.aoD();
        aVar.KAi.MyC = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
        aVar.KAi.MyD = d.INSTANCE.TK(2);
        aVar.KAi.MyE = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aps()).getString("getgoogleaid", "");
        aVar.KAi.KFu = MMApplicationContext.getApplicationId();
        this.jki = str;
        this.jkj = str2;
        this.jkk = str3;
        this.jkl = str4;
        this.jkm = str5;
        this.jko = i2;
        this.jkn = "";
        this.jkq = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        aVar.KAi.KLN = a.azt();
        AppMethodBeat.o(134188);
    }

    public v(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, String str11, boolean z, boolean z2) {
        AppMethodBeat.i(134189);
        Log.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, Util.secPrint(str2), str3, Integer.valueOf(i2), str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.jkp = i3;
        this.iMO = new bj();
        x.a aVar = (x.a) this.iMO.getReqObj();
        aVar.setUin(0);
        aVar.KAi.UserName = str;
        aVar.KAi.KQi = Util.getCutPasswordMD5(str2);
        if (i3 == 4) {
            aVar.KAi.KQi = str8;
            Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.KAi.KQi);
        }
        aVar.KAi.oUJ = str3;
        aVar.KAi.KDZ = i2;
        aVar.KAi.KEa = str4;
        aVar.KAi.KEb = str5;
        aVar.KAi.Bri = str8;
        aVar.KAi.LtW = i3;
        aVar.KAi.rBH = Util.getTimeZoneOffset();
        aVar.KAi.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        aVar.KAi.rBI = LocaleUtil.getApplicationLanguage();
        aVar.KAi.KLM = 0;
        aVar.KAi.ked = str9;
        aVar.KAi.MbK = str11;
        aVar.KAi.MbJ = str10;
        aVar.KAi.KPT = z ? 1 : 0;
        aVar.KAi.LtX = z2 ? 1 : 0;
        aVar.KAi.KLN = a.azt();
        aVar.KAi.MyB = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
        aVar.KAi.LuU = com.tencent.mm.compatible.deviceinfo.q.aoD();
        aVar.KAi.MyC = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
        aVar.KAi.MyD = d.INSTANCE.TK(2);
        aVar.KAi.MyE = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aps()).getString("getgoogleaid", "");
        aVar.KAi.KFu = MMApplicationContext.getApplicationId();
        this.jki = str;
        this.jkj = str2;
        this.jkk = str3;
        this.jkl = str4;
        this.jkm = str5;
        this.jko = i2;
        this.jkn = str9;
        this.jkq = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        AppMethodBeat.o(134189);
    }

    public final void tL(int i2) {
        AppMethodBeat.i(134190);
        ((x.a) this.iMO.getReqObj()).KAi.KPZ = i2;
        AppMethodBeat.o(134190);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(134191);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(134191);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    public final void PB(String str) {
        AppMethodBeat.i(134192);
        if (!Util.isNullOrNil(str)) {
            ((x.a) this.iMO.getReqObj()).KAi.KQa = str;
            Log.i("MicroMsg.NetSceneReg", "setRegSessionId %s", str);
        }
        AppMethodBeat.o(134192);
    }

    public final void PC(String str) {
        AppMethodBeat.i(134193);
        if (!Util.isNullOrNil(str)) {
            ((x.a) this.iMO.getReqObj()).KAi.MyI = str;
            Log.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", str);
        }
        AppMethodBeat.o(134193);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 126;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134194);
        final x.b bVar = (x.b) sVar.getRespObj();
        if (bVar.KAj != null) {
            int i5 = bVar.KAj.KLo;
            Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", Integer.valueOf(i5));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(i5));
            com.tencent.mm.network.g gVar = com.tencent.mm.kernel.g.aAg().hqi.iMw;
            if (gVar != null) {
                gVar.fB((i5 & 1) == 0);
            }
        } else {
            Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", Integer.valueOf(bVar.getRetCode()));
        }
        if (i3 == 4 && i4 == -301) {
            bh.a(true, bVar.KAj.KQk, bVar.KAj.KQl, bVar.KAj.KQj);
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134194);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134194);
        } else if (i3 == 4 && i4 == -240) {
            Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.iMt));
            this.iMt--;
            if (this.iMt <= 0) {
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(134194);
                return;
            }
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134194);
        } else if (i3 == 4 && i4 == -102) {
            final int i6 = sVar.getReqObj().getRsaInfo().ver;
            Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i6));
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.modelsimple.v.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(134186);
                    new m().doScene(v.this.dispatcher(), new i() {
                        /* class com.tencent.mm.modelsimple.v.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(134185);
                            Log.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                v.this.doScene(v.this.dispatcher(), v.this.callback);
                                AppMethodBeat.o(134185);
                                return;
                            }
                            v.this.callback.onSceneEnd(i2, i3, "", v.this);
                            AppMethodBeat.o(134185);
                        }
                    });
                    AppMethodBeat.o(134186);
                }
            });
            AppMethodBeat.o(134194);
        } else if (i3 == 4 && (i4 == -305 || i4 == -306)) {
            Log.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", Integer.valueOf(i4), Integer.valueOf(f.Kze));
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(134194);
        } else if (i3 == 0 && i4 == 0) {
            x.a aVar = (x.a) sVar.getReqObj();
            Log.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.KAj.rBz + " regtype:" + bVar.KAj.KEd + " mode:" + aVar.KAi.LtW);
            if (bVar.KAj.rBx != 0 && !this.jkq) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.qg(bVar.KAj.rBx);
                com.tencent.mm.kernel.g.aAh().azQ().set(2, aVar.KAi.UserName);
                com.tencent.mm.kernel.g.aAh().azQ().set(16, (Object) 1);
                com.tencent.mm.kernel.g.aAh().azQ().set(52, Integer.valueOf(bVar.KAj.KEd));
                com.tencent.mm.kernel.g.aAh().azQ().set(340240, Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.kernel.g.aAh().azQ().set(340241, Boolean.TRUE);
                cr.sk(bVar.KAj.KEl);
                cr.a(bVar.KAj.KEm);
                cr.a(bVar.KAj.KEn);
                if (!(this.jki == null || this.jki.length() <= 0 || this.jkp == 1)) {
                    bVar.KAj.UserName = this.jki;
                }
                bVar.KAj.KEa = this.jkl;
                bVar.KAj.oTW = 0;
                if (!com.tencent.mm.kernel.g.aAc() || com.tencent.mm.kernel.g.aAh().azQ() == null) {
                    com.tencent.mm.kernel.g.aAf();
                    Log.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", Boolean.valueOf(com.tencent.mm.kernel.g.aAc()), p.getString(a.getUin()), com.tencent.mm.kernel.g.aAh().azQ());
                } else {
                    String str2 = this.jkn;
                    int i7 = this.jko;
                    String str3 = this.jkk;
                    String str4 = this.jkm;
                    String str5 = bVar.KAj.UserName;
                    String str6 = bVar.KAj.KEa;
                    int i8 = bVar.KAj.oTW;
                    String str7 = bVar.KAj.KEg;
                    String str8 = bVar.KAj.KEh;
                    int i9 = bVar.KAj.KEi;
                    int i10 = bVar.KAj.MyL;
                    String str9 = bVar.KAj.KCy;
                    String str10 = bVar.KAj.KEj;
                    String str11 = bVar.KAj.KLg;
                    Log.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", str5, str2, p.getString(i7), str3, str6, str4, Integer.valueOf(i8), str7, str8, Integer.valueOf(i9), Integer.valueOf(i10), Util.secPrint(str9), str10, 0, Util.secPrint(str11), Util.secPrint(null), Util.secPrint(null), Util.secPrint(null), -1, bVar.KAj.MyK, 0);
                    ao azQ = com.tencent.mm.kernel.g.aAh().azQ();
                    bf.iDu.aO(WXUtil.LAST_LOGIN_WEXIN_USERNAME, str5);
                    bf.iDu.aO("last_login_nick_name", str3);
                    bf.iDu.k(str4, i7, str6);
                    azQ.set(2, str5);
                    azQ.set(42, str2);
                    azQ.set(9, Integer.valueOf(i7));
                    azQ.set(4, str3);
                    azQ.set(5, str6);
                    azQ.set(6, str4);
                    azQ.set(7, Integer.valueOf(i8));
                    azQ.set(21, str7);
                    azQ.set(22, str8);
                    azQ.set(57, (Object) 0);
                    azQ.set(17, Integer.valueOf(i9));
                    azQ.set(25, Integer.valueOf(i10));
                    azQ.set(1, str9);
                    azQ.set(29, str10);
                    azQ.set(34, (Object) 0);
                    azQ.set(256, Boolean.FALSE);
                    Log.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    azQ.set(-1535680990, str11);
                    azQ.set(46, (Object) null);
                    azQ.set(72, (Object) null);
                    azQ.set(64, (Object) -1);
                    azQ.gBI();
                    ((PluginAuth) com.tencent.mm.kernel.g.ah(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.jkn, this.jko, this.jkk, this.jkm, 0);
                }
                bh.a(false, bVar.KAj.KQk, bVar.KAj.KQl, bVar.KAj.KQj);
                com.tencent.mm.kernel.g.aAh().azQ().gBI();
                com.tencent.mm.kernel.g.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.modelsimple.v.AnonymousClass2 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                        AppMethodBeat.i(134187);
                        if (gVar == null) {
                            AppMethodBeat.o(134187);
                            return;
                        }
                        gVar.aZh().a(bVar.aiZ(1), bVar.aiZ(2), bVar.aiZ(3), bVar.KAj.rBx);
                        AppMethodBeat.o(134187);
                    }
                }), 0);
                Log.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.KAj.MyN);
                this.jkr = (bVar.KAj.MyN & 1) != 0;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
            ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(linkedList));
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(134194);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(134194);
        }
    }

    public final byte[] bfm() {
        AppMethodBeat.i(134195);
        byte[] a2 = z.a(((x.b) this.iMO.getRespObj()).KAj.MbL, new byte[0]);
        AppMethodBeat.o(134195);
        return a2;
    }

    public final String bfl() {
        AppMethodBeat.i(134196);
        String str = ((x.b) this.iMO.getRespObj()).KAj.MbJ;
        AppMethodBeat.o(134196);
        return str;
    }

    public final String bfv() {
        AppMethodBeat.i(134197);
        String str = ((x.b) this.iMO.getRespObj()).KAj.MyR;
        AppMethodBeat.o(134197);
        return str;
    }

    public final int bfw() {
        int i2;
        AppMethodBeat.i(134198);
        dyh dyh = ((x.b) this.iMO.getRespObj()).KAj.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 1) {
                    i2 = Util.getInt(next.NeO, 0);
                    break;
                }
            }
        }
        i2 = 0;
        AppMethodBeat.o(134198);
        return i2;
    }

    public final String bfx() {
        String str;
        AppMethodBeat.i(134199);
        dyh dyh = ((x.b) this.iMO.getRespObj()).KAj.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 2) {
                    str = next.NeO;
                    break;
                }
            }
        }
        str = "";
        AppMethodBeat.o(134199);
        return str;
    }

    public final int bfy() {
        int i2;
        AppMethodBeat.i(134200);
        dyh dyh = ((x.b) this.iMO.getRespObj()).KAj.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 3) {
                    i2 = Util.getInt(next.NeO, 2);
                    break;
                }
            }
        }
        i2 = 2;
        AppMethodBeat.o(134200);
        return i2;
    }

    public final String bfz() {
        String str;
        AppMethodBeat.i(134201);
        dyh dyh = ((x.b) this.iMO.getRespObj()).KAj.KLj;
        if (dyh != null && dyh.MXV != null && dyh.MXV.size() > 0) {
            Iterator<eer> it = dyh.MXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eer next = it.next();
                if (next.Cya == 17) {
                    str = next.NeO;
                    break;
                }
            }
        }
        str = null;
        AppMethodBeat.o(134201);
        return str;
    }
}
