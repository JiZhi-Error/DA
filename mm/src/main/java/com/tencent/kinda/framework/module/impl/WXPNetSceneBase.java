package com.tencent.kinda.framework.module.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.kinda.framework.module.impl.WXPCommReqResp;
import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public class WXPNetSceneBase extends q implements m {
    private static final String TAG = "MicroMsg.KindaLibWXPNetSceneBase";
    private KCgi cgi;
    private int cgiId;
    private String cgiUri;
    private i onSceneEndCallback;
    private int respCmdId = 0;
    private WXPCommReqResp wxpCommReqResp;

    static /* synthetic */ void access$100(WXPNetSceneBase wXPNetSceneBase) {
        AppMethodBeat.i(214455);
        wXPNetSceneBase.clearField();
        AppMethodBeat.o(214455);
    }

    public WXPNetSceneBase(int i2, int i3, String str, int i4, int i5, int i6, byte[] bArr, KCgi kCgi, KNetworkMockManager kNetworkMockManager) {
        AppMethodBeat.i(18701);
        this.cgiId = i3;
        this.cgiUri = str;
        this.cgi = kCgi;
        this.wxpCommReqResp = new WXPCommReqResp(bArr, str, i3, i2, this.respCmdId, true, i6, i5, kCgi.getRouteInfo(), kNetworkMockManager);
        setIsKinda(true);
        Log.i(TAG, "init scene: cgiId:%d, cgiUri:%s ", Integer.valueOf(i3), str);
        AppMethodBeat.o(18701);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return this.cgiId;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(18702);
        this.onSceneEndCallback = iVar;
        c.eBv().sC(true);
        int dispatch = dispatch(gVar, this.wxpCommReqResp, this);
        AppMethodBeat.o(18702);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public int dispatch(g gVar, s sVar, m mVar) {
        AppMethodBeat.i(18703);
        int dispatch = super.dispatch(gVar, sVar, mVar);
        AppMethodBeat.o(18703);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, final int i3, final int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(18704);
        Log.i(TAG, "onGYNetEnd: %s, , uri: %s errType %d errCode %d errMsg %s", Integer.valueOf(this.cgiId), this.cgiUri, Integer.valueOf(i3), Integer.valueOf(i4), str);
        final WXPCommReqResp.Resp resp = (WXPCommReqResp.Resp) sVar.getRespObj();
        if (this.cgi == null) {
            AppMethodBeat.o(18704);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.kinda.framework.module.impl.WXPNetSceneBase.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18700);
                if (WXPNetSceneBase.this.cgi == null) {
                    AppMethodBeat.o(18700);
                    return;
                }
                if (i3 == 0) {
                    WXPNetSceneBase.this.cgi.onResp(0, resp.getResponseWrapper().getData());
                } else if (i3 == 4 && i4 == -102) {
                    WXPNetSceneBase.this.cgi.onResp(351, null);
                } else {
                    WXPNetSceneBase.this.cgi.onResp(1, null);
                }
                WXPNetSceneBase.access$100(WXPNetSceneBase.this);
                AppMethodBeat.o(18700);
            }
        });
        this.onSceneEndCallback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(18704);
    }

    @Override // com.tencent.mm.ak.q
    public void cancel() {
        AppMethodBeat.i(18705);
        Log.e(TAG, "cancel: thread when doScene: %s, thread id: %d, cgiUri: %s", Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()), this.cgiUri);
        super.cancel();
        if (this.cgi == null) {
            AppMethodBeat.o(18705);
            return;
        }
        this.cgi.onResp(1, null);
        clearField();
        AppMethodBeat.o(18705);
    }

    private void clearField() {
        this.cgi = null;
        if (this.wxpCommReqResp != null) {
            this.wxpCommReqResp = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(214454);
        super.finalize();
        AppMethodBeat.o(214454);
    }
}
