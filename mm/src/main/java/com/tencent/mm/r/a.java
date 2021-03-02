package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.h;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bs;

public final class a implements s {
    @Override // com.tencent.mm.api.s
    public final void a(String str, i iVar, de deVar) {
        long j2;
        boolean z = false;
        AppMethodBeat.i(114096);
        if (iVar == null || deVar == null) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(iVar == null);
            if (deVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(deVar.xKb);
            Log.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", objArr);
            AppMethodBeat.o(114096);
            return;
        }
        b(deVar);
        try {
            g.b bVar = new g.b();
            bVar.iLT = iVar.field_businessInfo;
            bVar.iLU = iVar.field_functionmsgid;
            if (iVar.field_actionTime == 0) {
                j2 = cl.aWy() / 1000;
            } else {
                j2 = iVar.field_actionTime;
            }
            deVar.CreateTime = (int) j2;
            iVar.field_status = 100;
            iVar.a(deVar);
            bs bsVar = bs.OqA;
            bs.a(str, iVar);
            Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", iVar, Integer.valueOf(deVar.CreateTime));
            h.d.ck(Integer.valueOf(deVar.xKb)).b(new h.a(deVar, bVar));
            AppMethodBeat.o(114096);
        } catch (Exception e2) {
            Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(114096);
        }
    }

    @Override // com.tencent.mm.api.s
    public final void b(String str, i iVar, de deVar) {
        AppMethodBeat.i(114097);
        Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", iVar);
        try {
            b(deVar);
            deVar.CreateTime = (int) iVar.field_actionTime;
            iVar.a(deVar);
            iVar.field_status = 100;
            bs bsVar = bs.OqA;
            bs.a(str, iVar);
            h.d.ck(Integer.valueOf(deVar.xKb)).b(new h.c(deVar, str, iVar));
            AppMethodBeat.o(114097);
        } catch (Exception e2) {
            Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(114097);
        }
    }

    @Override // com.tencent.mm.api.s
    public final void b(rx rxVar) {
        AppMethodBeat.i(114098);
        try {
            new g.b();
            g.a.cj(Long.valueOf(rxVar.KZn));
            AppMethodBeat.o(114098);
        } catch (Exception e2) {
            Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(114098);
        }
    }

    private static de b(de deVar) {
        boolean z = true;
        AppMethodBeat.i(114095);
        if (deVar == null) {
            AppMethodBeat.o(114095);
            return null;
        }
        Object[] objArr = new Object[3];
        objArr[0] = deVar.KHl;
        objArr[1] = Integer.valueOf(deVar.xKb);
        if (deVar.KHn != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", objArr);
        String nullAsNil = Util.nullAsNil(z.a(deVar.KHl));
        if ("readerapp".equals(nullAsNil)) {
            deVar.KHl = z.Su("newsapp");
            deVar.xKb = 12399999;
        }
        if ("blogapp".equals(nullAsNil) || "newsapp".equals(nullAsNil)) {
            deVar.xKb = 12399999;
        }
        AppMethodBeat.o(114095);
        return deVar;
    }
}
