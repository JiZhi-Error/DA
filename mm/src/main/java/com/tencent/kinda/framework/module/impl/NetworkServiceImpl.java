package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.kinda.gen.KNetworkService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class NetworkServiceImpl implements KNetworkService {
    private static final String TAG = "MicroMsg.WXPNetworkServiceImpl";

    @Override // com.tencent.kinda.gen.KNetworkService
    public byte[] getBaseRequest(int i2) {
        AppMethodBeat.i(18672);
        jr jrVar = new jr();
        byte[] baseRequestOnError = getBaseRequestOnError(i2);
        t tVar = g.aAg().hqi;
        if (tVar == null) {
            Log.printErrStackTrace(TAG, new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
            AppMethodBeat.o(18672);
            return baseRequestOnError;
        }
        com.tencent.mm.network.g gVar = tVar.iMw;
        if (gVar == null) {
            Log.printErrStackTrace(TAG, new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
            AppMethodBeat.o(18672);
            return baseRequestOnError;
        }
        e aZh = gVar.aZh();
        if (aZh == null) {
            Log.printErrStackTrace(TAG, new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
            AppMethodBeat.o(18672);
            return baseRequestOnError;
        }
        jrVar.KOj = d.KyO;
        jrVar.Scene = i2;
        jrVar.rBx = aZh.getUin();
        g.aAf();
        Log.v(TAG, "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", Integer.valueOf(a.getUin()), Integer.valueOf(aZh.getUin()), aZh.getUsername(), aZh.aZd(), Boolean.valueOf(aZh.aZb()));
        jrVar.KOi = b.cD(q.aoG().getBytes());
        if (jrVar.KOi.zy.length >= 16) {
            jrVar.KOi = jrVar.KOi.aiU(16);
        }
        jrVar.KOk = b.cD(d.ics.getBytes());
        if (jrVar.KOk.zy.length >= 132) {
            jrVar.KOk = jrVar.KOk.aiU(132);
        }
        jrVar.KOh = b.cD(aZh.qe(1));
        if (jrVar.KOh.zy.length >= 36) {
            jrVar.KOh = jrVar.KOh.aiU(36);
        }
        try {
            byte[] byteArray = jrVar.toByteArray();
            Log.v(TAG, "result.size: %d", Integer.valueOf(byteArray.length));
            AppMethodBeat.o(18672);
            return byteArray;
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.v(TAG, "exception: %s", e2.getMessage());
            AppMethodBeat.o(18672);
            return baseRequestOnError;
        }
    }

    @Override // com.tencent.kinda.gen.KNetworkService
    public void invoke(KCgi kCgi, KNetworkMockManager kNetworkMockManager) {
        AppMethodBeat.i(18673);
        Log.d(TAG, "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()));
        g.aAg().hqi.a(new WXPNetSceneBase(kCgi.getCgiId(), kCgi.getCgiId(), kCgi.getCgiUrl(), kCgi.getChannelType(), kCgi.getTimeout(), kCgi.getRetryCount(), kCgi.getRequestData(), kCgi, kNetworkMockManager), 0);
        Log.d(TAG, "do scene for: %s", kCgi.getCgiUrl());
        AppMethodBeat.o(18673);
    }

    private byte[] getBaseRequestOnError(int i2) {
        AppMethodBeat.i(18674);
        try {
            byte[] bArr = {0, 1};
            jr jrVar = new jr();
            jrVar.KOj = 0;
            jrVar.KOi = new b(bArr);
            jrVar.KOk = new b(bArr);
            jrVar.Scene = i2;
            jrVar.KOh = new b(bArr);
            g.aAf();
            jrVar.rBx = a.getUin();
            byte[] byteArray = jrVar.toByteArray();
            AppMethodBeat.o(18674);
            return byteArray;
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(18674);
            return bArr2;
        }
    }
}
