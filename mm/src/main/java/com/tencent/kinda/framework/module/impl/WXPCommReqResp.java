package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class WXPCommReqResp extends o {
    private int funcId;
    public WeakReference<KNetworkMockManager> m_mockMgr;
    private int newExtFlag;
    private int option = 0;
    private Req req = null;
    private WXPRequestWrapper requestWrapper;
    private Resp resp = null;
    private WXPResponseWrapper responseWrapper;
    private byte[] transferHeader;
    private String uri;

    public WXPCommReqResp(byte[] bArr, String str, int i2, int i3, int i4, boolean z, int i5, int i6, String str2, KNetworkMockManager kNetworkMockManager) {
        AppMethodBeat.i(18685);
        this.requestWrapper = new WXPRequestWrapper(bArr);
        this.responseWrapper = new WXPResponseWrapper();
        this.req = new Req(this.requestWrapper, i2, i3, z, i5, i6, str2);
        this.resp = new Resp(this.responseWrapper, i4, z);
        this.uri = str;
        this.funcId = i2;
        this.m_mockMgr = new WeakReference<>(kNetworkMockManager);
        this.newExtFlag = 0;
        this.transferHeader = null;
        AppMethodBeat.o(18685);
    }

    public final int getReqCmdId() {
        AppMethodBeat.i(18686);
        int i2 = this.req.cmdId;
        AppMethodBeat.o(18686);
        return i2;
    }

    public final int getRespCmdId() {
        AppMethodBeat.i(18687);
        int i2 = this.resp.cmdId;
        AppMethodBeat.o(18687);
        return i2;
    }

    public final WXPRequestWrapper getRequestProtoBuf() {
        AppMethodBeat.i(18688);
        WXPRequestWrapper wXPRequestWrapper = this.req.rImpl;
        AppMethodBeat.o(18688);
        return wXPRequestWrapper;
    }

    public final WXPResponseWrapper getResponseProtoBuf() {
        AppMethodBeat.i(18689);
        WXPResponseWrapper wXPResponseWrapper = this.resp.rImpl;
        AppMethodBeat.o(18689);
        return wXPResponseWrapper;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return this.funcId;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return this.uri;
    }

    @Override // com.tencent.mm.network.s
    public final Resp getRespObj() {
        return this.resp;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ak.o
    public final Req getReqObjImp() {
        return this.req;
    }

    public void setRsaInfo(ac acVar) {
        AppMethodBeat.i(18690);
        this.req.setRsaInfo(acVar);
        AppMethodBeat.o(18690);
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public int getOptions() {
        return this.option;
    }

    public void setOptions(int i2) {
        this.option = i2;
    }

    public byte[] getWXPReqData() {
        AppMethodBeat.i(18691);
        byte[] data = this.requestWrapper.getData();
        AppMethodBeat.o(18691);
        return data;
    }

    public void setWXPReqData(byte[] bArr) {
        AppMethodBeat.i(18692);
        this.requestWrapper.setData(bArr);
        AppMethodBeat.o(18692);
    }

    public byte[] getWXPRespData() {
        AppMethodBeat.i(18693);
        byte[] data = this.responseWrapper.getData();
        AppMethodBeat.o(18693);
        return data;
    }

    public void setWXPRespData(byte[] bArr) {
        AppMethodBeat.i(18694);
        this.responseWrapper.setData(bArr);
        AppMethodBeat.o(18694);
    }

    public String getWXPRespNewData() {
        AppMethodBeat.i(18695);
        String newData = this.responseWrapper.getNewData();
        AppMethodBeat.o(18695);
        return newData;
    }

    public void setWXPRespNewData(String str) {
        AppMethodBeat.i(18696);
        this.responseWrapper.setNewData(str);
        if (!(this.m_mockMgr == null || this.m_mockMgr.get() == null)) {
            setWXPRespData(this.m_mockMgr.get().jsonToResponseData(str));
        }
        AppMethodBeat.o(18696);
    }

    public String resp2Json(byte[] bArr) {
        AppMethodBeat.i(18697);
        String str = null;
        if (!(this.m_mockMgr == null || this.m_mockMgr.get() == null)) {
            str = this.m_mockMgr.get().responseDataToJson(bArr);
        }
        AppMethodBeat.o(18697);
        return str;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public int getNewExtFlags() {
        return this.newExtFlag;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public byte[] getTransHeader() {
        return this.transferHeader;
    }

    public void addNewExtFlag(int i2) {
        this.newExtFlag |= i2;
    }

    public void clearNewExtFlag() {
        this.newExtFlag = 0;
    }

    public void setTransferHeader(byte[] bArr) {
        this.transferHeader = bArr;
    }

    public static final class Req extends l.d implements l.b {
        private int cmdId;
        private int funcId;
        private boolean needHeader;
        private WXPRequestWrapper rImpl;

        public Req(WXPRequestWrapper wXPRequestWrapper, int i2, int i3, boolean z) {
            this.rImpl = wXPRequestWrapper;
            this.funcId = i2;
            this.cmdId = i3;
            this.needHeader = z;
        }

        public Req(WXPRequestWrapper wXPRequestWrapper, int i2, int i3, boolean z, int i4, int i5, String str) {
            AppMethodBeat.i(18682);
            this.rImpl = wXPRequestWrapper;
            this.funcId = i2;
            this.cmdId = i3;
            this.needHeader = z;
            setRouteInfo(Util.getInt(str, 0));
            AppMethodBeat.o(18682);
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return this.cmdId;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return this.funcId;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(18683);
            byte[] data = this.rImpl.getData();
            AppMethodBeat.o(18683);
            return data;
        }

        public final WXPRequestWrapper getImpl() {
            return this.rImpl;
        }
    }

    public static final class Resp extends l.e implements l.c {
        private int cmdId;
        private boolean needHeader;
        private WXPResponseWrapper rImpl = null;

        public Resp(WXPResponseWrapper wXPResponseWrapper, int i2, boolean z) {
            this.rImpl = wXPResponseWrapper;
            this.cmdId = i2;
            this.needHeader = z;
        }

        public final WXPResponseWrapper getResponseWrapper() {
            return this.rImpl;
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(18684);
            this.rImpl.setData(bArr);
            AppMethodBeat.o(18684);
            return 0;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return this.cmdId;
        }
    }

    public static final class WXPRequestWrapper {
        private byte[] data;

        public WXPRequestWrapper() {
        }

        public WXPRequestWrapper(byte[] bArr) {
            this.data = bArr;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final void setData(byte[] bArr) {
            this.data = bArr;
        }
    }

    public class WXPResponseWrapper {
        private byte[] data;
        private String newData = null;

        public WXPResponseWrapper() {
        }

        public byte[] getData() {
            return this.data;
        }

        public void setData(byte[] bArr) {
            this.data = bArr;
        }

        public String getNewData() {
            return this.newData;
        }

        public void setNewData(String str) {
            this.newData = str;
        }
    }
}
