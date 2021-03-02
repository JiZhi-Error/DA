package com.qq.taf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class RequestPacket extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled;
    static Map<String, String> cache_context = null;
    static byte[] cache_sBuffer = null;
    public byte cPacketType = 0;
    public Map<String, String> context;
    public int iMessageType = 0;
    public int iRequestId = 0;
    public int iTimeout = 0;
    public short iVersion = 0;
    public byte[] sBuffer;
    public String sFuncName = null;
    public String sServantName = null;
    public Map<String, String> status;

    static {
        boolean z;
        AppMethodBeat.i(109590);
        if (!RequestPacket.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
        AppMethodBeat.o(109590);
    }

    public RequestPacket() {
    }

    public RequestPacket(short s, byte b2, int i2, int i3, String str, String str2, byte[] bArr, int i4, Map<String, String> map, Map<String, String> map2) {
        this.iVersion = s;
        this.cPacketType = b2;
        this.iMessageType = i2;
        this.iRequestId = i3;
        this.sServantName = str;
        this.sFuncName = str2;
        this.sBuffer = bArr;
        this.iTimeout = i4;
        this.context = map;
        this.status = map2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(109591);
        RequestPacket requestPacket = (RequestPacket) obj;
        if (!JceUtil.equals(1, (int) requestPacket.iVersion) || !JceUtil.equals(1, (int) requestPacket.cPacketType) || !JceUtil.equals(1, requestPacket.iMessageType) || !JceUtil.equals(1, requestPacket.iRequestId) || !JceUtil.equals((Object) 1, (Object) requestPacket.sServantName) || !JceUtil.equals((Object) 1, (Object) requestPacket.sFuncName) || !JceUtil.equals((Object) 1, (Object) requestPacket.sBuffer) || !JceUtil.equals(1, requestPacket.iTimeout) || !JceUtil.equals((Object) 1, (Object) requestPacket.context) || !JceUtil.equals((Object) 1, (Object) requestPacket.status)) {
            AppMethodBeat.o(109591);
            return false;
        }
        AppMethodBeat.o(109591);
        return true;
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(109592);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(109592);
                throw assertionError;
            }
        }
        AppMethodBeat.o(109592);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(109593);
        jceOutputStream.write(this.iVersion, 1);
        jceOutputStream.write(this.cPacketType, 2);
        jceOutputStream.write(this.iMessageType, 3);
        jceOutputStream.write(this.iRequestId, 4);
        jceOutputStream.write(this.sServantName, 5);
        jceOutputStream.write(this.sFuncName, 6);
        jceOutputStream.write(this.sBuffer, 7);
        jceOutputStream.write(this.iTimeout, 8);
        jceOutputStream.write((Map) this.context, 9);
        jceOutputStream.write((Map) this.status, 10);
        AppMethodBeat.o(109593);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(109594);
        try {
            this.iVersion = jceInputStream.read(this.iVersion, 1, true);
            this.cPacketType = jceInputStream.read(this.cPacketType, 2, true);
            this.iMessageType = jceInputStream.read(this.iMessageType, 3, true);
            this.iRequestId = jceInputStream.read(this.iRequestId, 4, true);
            this.sServantName = jceInputStream.readString(5, true);
            this.sFuncName = jceInputStream.readString(6, true);
            if (cache_sBuffer == null) {
                cache_sBuffer = new byte[1];
            }
            this.sBuffer = jceInputStream.read(cache_sBuffer, 7, true);
            this.iTimeout = jceInputStream.read(this.iTimeout, 8, true);
            if (cache_context == null) {
                HashMap hashMap = new HashMap();
                cache_context = hashMap;
                hashMap.put("", "");
            }
            this.context = (Map) jceInputStream.read((Object) cache_context, 9, true);
            if (cache_context == null) {
                HashMap hashMap2 = new HashMap();
                cache_context = hashMap2;
                hashMap2.put("", "");
            }
            this.status = (Map) jceInputStream.read((Object) cache_context, 10, true);
            AppMethodBeat.o(109594);
        } catch (Exception e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(109594);
            throw runtimeException;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(109595);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.iVersion, "iVersion");
        jceDisplayer.display(this.cPacketType, "cPacketType");
        jceDisplayer.display(this.iMessageType, "iMessageType");
        jceDisplayer.display(this.iRequestId, "iRequestId");
        jceDisplayer.display(this.sServantName, "sServantName");
        jceDisplayer.display(this.sFuncName, "sFuncName");
        jceDisplayer.display(this.sBuffer, "sBuffer");
        jceDisplayer.display(this.iTimeout, "iTimeout");
        jceDisplayer.display((Map) this.context, "context");
        jceDisplayer.display((Map) this.status, "status");
        AppMethodBeat.o(109595);
    }
}
