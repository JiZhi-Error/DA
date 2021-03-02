package com.tencent.mm.plugin.sns.ad.h;

import android.text.TextUtils;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<Request extends dop, Response extends dpc> extends q implements m {
    protected d Dxf;
    protected i Dxg;

    /* access modifiers changed from: protected */
    public abstract void a(Request request, Object... objArr);

    public final q a(Request request, Response response, String str, int i2, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            a(request, objArr);
            d.a aVar = new d.a();
            aVar.iLN = request;
            aVar.iLO = response;
            aVar.uri = str;
            aVar.funcId = i2;
            this.Dxf = aVar.aXF();
            if (request != this.Dxf.iLK.iLR) {
                return this;
            }
            Log.i("SnsAd.AbsNetScene", "the request is same as mRequestAndResponse.getRequestProtoBuf()");
            return this;
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (this.Dxf != null) {
            return this.Dxf.getType();
        }
        Log.w("SnsAd.AbsNetScene", "the scene is not initialized, please call initialize method");
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        try {
            this.Dxg = iVar;
            return dispatch(gVar, this.Dxf, this);
        } catch (Throwable th) {
            return 99999999;
        }
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        try {
            if (this.Dxg != null) {
                this.Dxg.onSceneEnd(i3, i4, str, this);
            }
        } catch (Throwable th) {
        }
    }

    public final Response eXx() {
        s reqResp = getReqResp();
        if (reqResp instanceof d) {
            try {
                return (Response) ((dpc) ((d) reqResp).iLL.iLR);
            } catch (Throwable th) {
                Log.w("SnsAd.AbsNetScene", "the response result is not the required!!!!");
            }
        }
        return null;
    }
}
