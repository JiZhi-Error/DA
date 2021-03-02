package com.tencent.mm.modelsimple;

import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.l;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.g;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.msgquote.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;

public final class w extends q implements m {
    private static final MMHandler jkv = new MMHandler("deleteRevokeMessageThread");
    private i callback;
    private final d iUB;
    private final String jkw;
    private final long msgId;

    static {
        AppMethodBeat.i(20646);
        AppMethodBeat.o(20646);
    }

    public w(ca caVar, String str) {
        int i2;
        String str2;
        AppMethodBeat.i(20642);
        bg.aVF();
        Object obj = c.azQ().get(290818, (Object) 0);
        if (obj != null) {
            i2 = Util.getInt(obj.toString(), 0);
        } else {
            i2 = 0;
        }
        this.msgId = caVar.field_msgId;
        this.jkw = str;
        String str3 = null;
        int i3 = 0;
        int i4 = (int) (caVar.field_createTime / 1000);
        long j2 = caVar.field_msgSvrId;
        String aTY = z.aTY();
        String str4 = caVar.field_talker;
        if (caVar.fQV != 1) {
            switch (caVar.getType()) {
                case 1:
                case 42:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 66:
                    int hashCode = x.x(z.aTY(), caVar.field_createTime).hashCode();
                    Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", Integer.valueOf(hashCode));
                    i3 = hashCode;
                    break;
                case 3:
                    g H = com.tencent.mm.av.q.bcR().H(caVar.field_talker, caVar.field_msgId);
                    String str5 = caVar.fQY;
                    Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", caVar.field_talker, Integer.valueOf(H.iXx), Long.valueOf(H.localId), str5);
                    str3 = str5;
                    break;
                case 34:
                    r Rr = o.bib().Rr(caVar.field_imgPath);
                    if (Rr != null) {
                        String str6 = Rr.clientId;
                        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", str6);
                        str3 = str6;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    String str7 = caVar.field_imgPath;
                    Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", str7);
                    str3 = str7;
                    break;
                case 47:
                    String valueOf = String.valueOf(be.bkr(caVar.field_content).time);
                    Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", valueOf);
                    str3 = valueOf;
                    break;
                case 49:
                case 1048625:
                case 268435505:
                case 553648177:
                case 587202609:
                    com.tencent.mm.pluginsdk.model.app.c Mp = ao.cgO().Mp(caVar.field_msgId);
                    if (Mp != null) {
                        str2 = Mp.field_clientAppDataId;
                    } else {
                        str2 = caVar.field_talker + caVar.field_msgId + "T" + caVar.field_createTime;
                    }
                    Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", str2);
                    str3 = str2;
                    break;
            }
        }
        d.a aVar = new d.a();
        aVar.iLN = new dpk();
        aVar.iLO = new dpl();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.funcId = 594;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        dpk dpk = (dpk) this.iUB.iLK.iLR;
        dpk.KIz = str3;
        dpk.MSH = i3;
        dpk.MSI = 0;
        dpk.MSK = j2;
        dpk.CreateTime = i4;
        dpk.xNH = aTY;
        dpk.xNG = str4;
        dpk.MSJ = i2;
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", dpk.KIz, Integer.valueOf(dpk.MSH), Integer.valueOf(dpk.MSI), Integer.valueOf(dpk.CreateTime), dpk.xNH, dpk.xNG, Integer.valueOf(dpk.MSJ));
        AppMethodBeat.o(20642);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 594;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(20643);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(20643);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20644);
        if (i3 == 0 && i4 == 0) {
            bg.aVF();
            final ca Hb = c.aSQ().Hb(this.msgId);
            if (Hb.field_msgId == this.msgId) {
                ca aZ = ca.aZ(Hb);
                Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s， type:%s", Long.valueOf(Hb.field_msgId), Long.valueOf(Hb.field_msgSvrId), bfA().MSL, Integer.valueOf(Hb.getType()));
                int type = Hb.getType();
                a(this.jkw, "  " + MMApplicationContext.getContext().getString(R.string.e5r), Hb, Hb.field_content);
                Hb.nv(0);
                Hb.nc(Hb.fqJ | 4);
                sx sxVar = new sx();
                sxVar.dZt.msgId = this.msgId;
                EventCenter.instance.publish(sxVar);
                bg.aVF();
                c.aSQ().a(Hb.field_msgId, Hb);
                ((a) com.tencent.mm.kernel.g.ah(a.class)).handleRevokeMsgBySelf(Hb.field_msgId);
                int i5 = 0;
                bg.aVF();
                Object obj = c.azQ().get(290818, (Object) 0);
                if (obj != null) {
                    i5 = Util.getInt(obj.toString(), 0);
                }
                bg.aVF();
                c.azQ().set(290818, Integer.valueOf(i5 + 1));
                Hb.setType(type);
                if (Hb.dOQ()) {
                    b bVar = b.jmd;
                    int t = l.t(Hb);
                    if (bVar.bfZ()) {
                        bVar.a(Hb, b.EnumC0457b.revoke, t);
                    }
                } else {
                    b bVar2 = b.jmd;
                    if (bVar2.bfZ()) {
                        bVar2.a(Hb, b.EnumC0457b.revoke, 0);
                    }
                }
                jkv.postDelayed(new Runnable() {
                    /* class com.tencent.mm.modelsimple.w.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(20641);
                        Log.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", Long.valueOf(Hb.field_msgId));
                        Hb.setType(10002);
                        w.a(w.this.jkw, "", Hb, "");
                        bg.aVF();
                        c.aSQ().a(Hb.field_msgId, Hb);
                        AppMethodBeat.o(20641);
                    }
                }, 300000);
                if (aa.i(aZ)) {
                    nv nvVar = new nv();
                    nvVar.dTW.dTX = aZ;
                    EventCenter.instance.publish(nvVar);
                }
            } else {
                Log.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", Long.valueOf(this.msgId));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20644);
    }

    private static boolean aa(ca caVar) {
        AppMethodBeat.i(231569);
        if (caVar == null) {
            AppMethodBeat.o(231569);
            return false;
        } else if (caVar.getType() == 1 || caVar.getType() == 16777265 || caVar.getType() == 822083633) {
            AppMethodBeat.o(231569);
            return true;
        } else {
            AppMethodBeat.o(231569);
            return false;
        }
    }

    private static String PD(String str) {
        AppMethodBeat.i(231570);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(231570);
            return "";
        }
        try {
            String encodeToString = Base64.encodeToString(str.getBytes(), 0);
            AppMethodBeat.o(231570);
            return encodeToString;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.NetSceneRevokeMsg", th, "safeBase64Encode err:%s", str);
            AppMethodBeat.o(231570);
            return "";
        }
    }

    public static void a(String str, String str2, ca caVar, String str3) {
        AppMethodBeat.i(20645);
        if (aa(caVar)) {
            if (caVar.getType() == 822083633) {
                str3 = PD(str3);
            }
            String PD = PD(caVar.fqK);
            int type = caVar.getType();
            caVar.setType(10002);
            caVar.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent><type><![CDATA[%s]]></type><msgSource><![CDATA[%s]]></msgSource></invokeMessage></sysmsg>", str, Long.valueOf(cl.aWy()), str2, str3, Integer.valueOf(type), PD));
            AppMethodBeat.o(20645);
            return;
        }
        caVar.setType(10000);
        caVar.setContent(str);
        AppMethodBeat.o(20645);
    }

    public final dpl bfA() {
        return (dpl) this.iUB.iLL.iLR;
    }
}
