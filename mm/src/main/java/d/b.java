package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends JceStruct {
    static byte[] SLc;
    public byte[] data = null;
    public String fileName = "";
    public byte type = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214834);
        jceOutputStream.write(this.type, 0);
        if (this.fileName != null) {
            jceOutputStream.write(this.fileName, 1);
        }
        jceOutputStream.write(this.data, 2);
        AppMethodBeat.o(214834);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214835);
        this.type = jceInputStream.read(this.type, 0, true);
        this.fileName = jceInputStream.readString(1, false);
        if (SLc == null) {
            byte[] bArr = new byte[1];
            SLc = bArr;
            bArr[0] = 0;
        }
        this.data = jceInputStream.read(SLc, 2, true);
        AppMethodBeat.o(214835);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
