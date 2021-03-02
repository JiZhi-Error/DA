package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends JceStruct {
    public String SLM = "";
    public String SLN = "";
    public String SLO = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214844);
        jceOutputStream.write(this.SLM, 0);
        jceOutputStream.write(this.SLO, 1);
        if (this.SLN != null) {
            jceOutputStream.write(this.SLN, 2);
        }
        AppMethodBeat.o(214844);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214845);
        this.SLM = jceInputStream.readString(0, true);
        this.SLO = jceInputStream.readString(1, true);
        this.SLN = jceInputStream.readString(2, false);
        AppMethodBeat.o(214845);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
