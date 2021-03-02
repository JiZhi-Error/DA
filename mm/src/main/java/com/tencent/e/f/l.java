package com.tencent.e.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class l {
    static HashMap<String, byte[]> ROg = null;
    protected HashMap<String, byte[]> ROf = new HashMap<>();
    private HashMap<String, Object> cgg = new HashMap<>();
    protected String cgh = MimeTypeUtil.ContentType.DEFAULT_CHARSET;
    protected RequestPacket cgk = new RequestPacket();

    public l() {
        AppMethodBeat.i(138485);
        this.cgk.iVersion = 3;
        AppMethodBeat.o(138485);
    }

    public final void bqf(String str) {
        this.cgh = str;
    }

    public final void cy(String str) {
        this.cgk.sServantName = str;
    }

    public final void cz(String str) {
        this.cgk.sFuncName = str;
    }

    public final void IK() {
        this.cgk.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        AppMethodBeat.i(138486);
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wup put err");
            AppMethodBeat.o(138486);
            throw illegalArgumentException;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.cgh);
        jceOutputStream.write((Object) t, 0);
        this.ROf.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
        AppMethodBeat.o(138486);
    }

    public final byte[] IJ() {
        AppMethodBeat.i(138487);
        if (this.cgk.sServantName == null) {
            this.cgk.sServantName = "";
        }
        if (this.cgk.sFuncName == null) {
            this.cgk.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.cgh);
        jceOutputStream.write((Map) this.ROf, 0);
        this.cgk.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        JceOutputStream jceOutputStream2 = new JceOutputStream(0);
        jceOutputStream2.setServerEncoding(this.cgh);
        this.cgk.writeTo(jceOutputStream2);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        byte[] array = allocate.array();
        AppMethodBeat.o(138487);
        return array;
    }
}
