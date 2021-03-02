package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends o {
    private int funcId;
    public b iLK;
    public c iLL;
    private boolean iLM;
    private boolean longPolling;
    private int longPollingTimeout;
    private int newExtFlag;
    public int option;
    private int timeout;
    byte[] transferHeader;
    private String uri;

    /* synthetic */ d(com.tencent.mm.bw.a aVar, com.tencent.mm.bw.a aVar2, String str, int i2, int i3, int i4, boolean z, int i5, int i6, boolean z2, int i7, boolean z3, byte b2) {
        this(aVar, aVar2, str, i2, i3, i4, z, i5, i6, z2, i7, z3);
    }

    private d(com.tencent.mm.bw.a aVar, com.tencent.mm.bw.a aVar2, String str, int i2, int i3, int i4, boolean z, int i5, int i6, boolean z2, int i7, boolean z3) {
        AppMethodBeat.i(197060);
        this.iLK = null;
        this.iLL = null;
        this.option = 0;
        this.iLK = new b(aVar, i2, i3, z && (aVar instanceof dop), i6);
        this.iLL = new c(aVar2, i4, z);
        this.uri = str;
        this.funcId = i2;
        this.timeout = i5;
        this.longPolling = z2;
        this.longPollingTimeout = i7;
        this.newExtFlag = 0;
        this.transferHeader = null;
        this.iLM = z3;
        AppMethodBeat.o(197060);
    }

    public static class a {
        public int funcId;
        private boolean iLM;
        public com.tencent.mm.bw.a iLN;
        public com.tencent.mm.bw.a iLO;
        public int iLP = 0;
        public boolean iLQ = true;
        private boolean longPolling = false;
        private int longPollingTimeout = 0;
        public int newExtFlag = 0;
        public int respCmdId = 0;
        public int routeInfo = 0;
        public int timeout = 0;
        public byte[] transferHeader = null;
        public String uri;

        public final void c(com.tencent.mm.bw.a aVar) {
            this.iLN = aVar;
        }

        public final void d(com.tencent.mm.bw.a aVar) {
            this.iLO = aVar;
        }

        public final void MB(String str) {
            this.uri = str;
        }

        public final void sG(int i2) {
            this.funcId = i2;
        }

        public final void sH(int i2) {
            this.timeout = i2;
        }

        public final void sI(int i2) {
            this.iLP = i2;
        }

        public final void sJ(int i2) {
            this.respCmdId = i2;
        }

        public final void aYL() {
            this.longPolling = true;
        }

        public final void setKeepAlive(boolean z) {
            this.iLM = z;
        }

        public final void aYM() {
            this.longPollingTimeout = 25000;
        }

        public final d aXF() {
            boolean z = true;
            AppMethodBeat.i(132301);
            if (this.iLN == null || this.iLO == null || Util.isNullOrNil(this.uri) || this.funcId <= 0 || this.iLP == Integer.MIN_VALUE || this.respCmdId == Integer.MIN_VALUE) {
                Object[] objArr = new Object[6];
                objArr[0] = Boolean.valueOf(this.iLN == null);
                objArr[1] = Boolean.valueOf(this.iLO == null);
                objArr[2] = Boolean.valueOf(Util.isNullOrNil(this.uri));
                objArr[3] = Boolean.valueOf(this.funcId <= 0);
                objArr[4] = Boolean.valueOf(this.iLP == Integer.MIN_VALUE);
                if (this.respCmdId != Integer.MIN_VALUE) {
                    z = false;
                }
                objArr[5] = Boolean.valueOf(z);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%s %s %s %s %s %s", objArr));
                AppMethodBeat.o(132301);
                throw illegalArgumentException;
            }
            d dVar = new d(this.iLN, this.iLO, this.uri, this.funcId, this.iLP, this.respCmdId, this.iLQ, this.timeout, this.routeInfo, this.longPolling, this.longPollingTimeout, this.iLM, (byte) 0);
            if (this.newExtFlag != 0) {
                dVar.addNewExtFlag(this.newExtFlag);
                dVar.transferHeader = this.transferHeader;
            }
            AppMethodBeat.o(132301);
            return dVar;
        }
    }

    public final int getReqCmdId() {
        return this.iLK.cmdId;
    }

    public final com.tencent.mm.bw.a aYJ() {
        return this.iLK.iLR;
    }

    public final com.tencent.mm.bw.a aYK() {
        return this.iLL.iLR;
    }

    public final void addNewExtFlag(int i2) {
        this.newExtFlag |= i2;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getTimeOut() {
        return this.timeout;
    }

    @Override // com.tencent.mm.network.s
    public final int getType() {
        return this.funcId;
    }

    @Override // com.tencent.mm.network.s
    public final String getUri() {
        return this.uri;
    }

    public final void setRsaInfo(ac acVar) {
        AppMethodBeat.i(132306);
        this.iLK.setRsaInfo(acVar);
        AppMethodBeat.o(132306);
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getOptions() {
        return this.option;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final boolean getIsLongPolling() {
        return this.longPolling;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final boolean keepAlive() {
        return this.iLM;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getLongPollingTimeout() {
        return this.longPollingTimeout;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final int getNewExtFlags() {
        return this.newExtFlag;
    }

    @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
    public final byte[] getTransHeader() {
        return this.transferHeader;
    }

    public static final class b extends l.d implements l.b {
        public int cmdId;
        private int funcId;
        public com.tencent.mm.bw.a iLR;
        private boolean needHeader;

        public b(com.tencent.mm.bw.a aVar, int i2, int i3, boolean z, int i4) {
            AppMethodBeat.i(132302);
            this.iLR = aVar;
            this.funcId = i2;
            this.cmdId = i3;
            this.needHeader = z;
            setRouteInfo(i4);
            AppMethodBeat.o(132302);
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
            AppMethodBeat.i(132303);
            if (this.iLR instanceof dop) {
                ((dop) this.iLR).setBaseRequest(l.a(this));
            }
            byte[] byteArray = this.iLR.toByteArray();
            AppMethodBeat.o(132303);
            return byteArray;
        }
    }

    public static final class c extends l.e implements l.c {
        public int cmdId;
        public com.tencent.mm.bw.a iLR = null;
        private boolean needHeader;

        public c(com.tencent.mm.bw.a aVar, int i2, boolean z) {
            this.iLR = aVar;
            this.cmdId = i2;
            this.needHeader = z;
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(132304);
            this.iLR = this.iLR.parseFrom(bArr);
            if (!(this.iLR instanceof dyp)) {
                l.a(this, ((dpc) this.iLR).getBaseResponse());
                int i2 = ((dpc) this.iLR).getBaseResponse().Ret;
                AppMethodBeat.o(132304);
                return i2;
            }
            int ret = ((dyp) this.iLR).getRet();
            AppMethodBeat.o(132304);
            return ret;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return this.cmdId;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ak.o
    public final /* bridge */ /* synthetic */ l.d getReqObjImp() {
        return this.iLK;
    }

    @Override // com.tencent.mm.network.s
    public final /* bridge */ /* synthetic */ l.e getRespObj() {
        return this.iLL;
    }
}
