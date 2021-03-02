package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h extends JceStruct {
    static Map<String, String> SLF;
    public Map<String, String> SLL = null;
    public float SLP = 0.0f;
    public float SLQ = 0.0f;
    public long SLR = 0;
    public long SLS = 0;
    public long SLT = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214846);
        jceOutputStream.write(this.SLP, 0);
        jceOutputStream.write(this.SLQ, 1);
        jceOutputStream.write(this.SLR, 2);
        jceOutputStream.write(this.SLT, 3);
        jceOutputStream.write(this.SLS, 4);
        if (this.SLL != null) {
            jceOutputStream.write((Map) this.SLL, 5);
        }
        AppMethodBeat.o(214846);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214847);
        this.SLP = jceInputStream.read(this.SLP, 0, true);
        this.SLQ = jceInputStream.read(this.SLQ, 1, true);
        this.SLR = jceInputStream.read(this.SLR, 2, true);
        this.SLT = jceInputStream.read(this.SLT, 3, true);
        this.SLS = jceInputStream.read(this.SLS, 4, true);
        if (SLF == null) {
            HashMap hashMap = new HashMap();
            SLF = hashMap;
            hashMap.put("", "");
        }
        this.SLL = (Map) jceInputStream.read((Object) SLF, 5, false);
        AppMethodBeat.o(214847);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
