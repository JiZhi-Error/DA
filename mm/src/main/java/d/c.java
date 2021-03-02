package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    public String KJM = "";
    public String SLd = "";
    public String SLe = "";
    public String SLf = "";
    public String fuD = "";
    public String qua = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214836);
        jceOutputStream.write(this.SLd, 0);
        jceOutputStream.write(this.SLf, 1);
        jceOutputStream.write(this.qua, 2);
        jceOutputStream.write(this.fuD, 3);
        jceOutputStream.write(this.KJM, 4);
        if (this.SLe != null) {
            jceOutputStream.write(this.SLe, 5);
        }
        AppMethodBeat.o(214836);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214837);
        this.SLd = jceInputStream.readString(0, true);
        this.SLf = jceInputStream.readString(1, true);
        this.qua = jceInputStream.readString(2, true);
        this.fuD = jceInputStream.readString(3, true);
        this.KJM = jceInputStream.readString(4, true);
        this.SLe = jceInputStream.readString(5, false);
        AppMethodBeat.o(214837);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
