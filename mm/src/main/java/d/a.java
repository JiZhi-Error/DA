package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends JceStruct {
    public String SKY = "";
    public String SKZ = "";
    public String SLa = "";
    public String SLb = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214832);
        if (this.SLa != null) {
            jceOutputStream.write(this.SLa, 0);
        }
        if (this.SKY != null) {
            jceOutputStream.write(this.SKY, 1);
        }
        if (this.SLb != null) {
            jceOutputStream.write(this.SLb, 2);
        }
        if (this.SKZ != null) {
            jceOutputStream.write(this.SKZ, 3);
        }
        AppMethodBeat.o(214832);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214833);
        this.SLa = jceInputStream.readString(0, false);
        this.SKY = jceInputStream.readString(1, false);
        this.SLb = jceInputStream.readString(2, false);
        this.SKZ = jceInputStream.readString(3, false);
        AppMethodBeat.o(214833);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
