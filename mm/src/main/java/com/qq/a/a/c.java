package com.qq.a.a;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class c extends b {
    static HashMap<String, HashMap<String, byte[]>> cgl = null;
    protected RequestPacket cgk = new RequestPacket();

    public c() {
        AppMethodBeat.i(187109);
        this.cgk.iVersion = 2;
        AppMethodBeat.o(187109);
    }

    @Override // com.qq.a.a.b
    public final <T> void put(String str, T t) {
        AppMethodBeat.i(187110);
        if (str.startsWith(".")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("put name can not startwith . ");
            AppMethodBeat.o(187110);
            throw illegalArgumentException;
        }
        super.put(str, t);
        AppMethodBeat.o(187110);
    }

    @Override // com.qq.a.a.b
    public final byte[] IJ() {
        AppMethodBeat.i(187111);
        if (this.cgk.sServantName.equals("")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("servantName can not is null");
            AppMethodBeat.o(187111);
            throw illegalArgumentException;
        } else if (this.cgk.sFuncName.equals("")) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("funcName can not is null");
            AppMethodBeat.o(187111);
            throw illegalArgumentException2;
        } else {
            JceOutputStream jceOutputStream = new JceOutputStream(0);
            jceOutputStream.setServerEncoding(this.cgh);
            jceOutputStream.write((Map) this.cge, 0);
            this.cgk.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
            JceOutputStream jceOutputStream2 = new JceOutputStream(0);
            jceOutputStream2.setServerEncoding(this.cgh);
            writeTo(jceOutputStream2);
            byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream2.getByteBuffer());
            int length = jceBufArray.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 4);
            allocate.putInt(length + 4).put(jceBufArray).flip();
            byte[] array = allocate.array();
            AppMethodBeat.o(187111);
            return array;
        }
    }

    public final void cy(String str) {
        this.cgk.sServantName = str;
    }

    public final void cz(String str) {
        this.cgk.sFuncName = str;
    }

    public final void IK() {
        this.cgk.iRequestId = 1;
    }

    @Override // com.qq.a.a.b, com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(187112);
        this.cgk.writeTo(jceOutputStream);
        AppMethodBeat.o(187112);
    }

    @Override // com.qq.a.a.b, com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(187113);
        this.cgk.readFrom(jceInputStream);
        AppMethodBeat.o(187113);
    }

    @Override // com.qq.a.a.b, com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(187114);
        this.cgk.display(sb, i2);
        AppMethodBeat.o(187114);
    }
}
