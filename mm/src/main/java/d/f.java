package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f extends JceStruct {
    static Map<String, String> SLF;
    public String Gyj = "";
    public String SLG = "";
    public long SLH = 0;
    public long SLI = 0;
    public String SLJ = "";
    public String SLK = "";
    public Map<String, String> SLL = null;
    public String SLe = "";
    public String brand = "";
    public String dGL = "";
    public String guid = "";
    public String model = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214842);
        jceOutputStream.write(this.SLK, 0);
        if (this.SLe != null) {
            jceOutputStream.write(this.SLe, 1);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 2);
        }
        if (this.dGL != null) {
            jceOutputStream.write(this.dGL, 3);
        }
        if (this.brand != null) {
            jceOutputStream.write(this.brand, 4);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 5);
        }
        if (this.SLJ != null) {
            jceOutputStream.write(this.SLJ, 6);
        }
        jceOutputStream.write(this.SLH, 7);
        jceOutputStream.write(this.SLI, 8);
        if (this.SLG != null) {
            jceOutputStream.write(this.SLG, 9);
        }
        if (this.Gyj != null) {
            jceOutputStream.write(this.Gyj, 10);
        }
        if (this.SLL != null) {
            jceOutputStream.write((Map) this.SLL, 11);
        }
        AppMethodBeat.o(214842);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214843);
        this.SLK = jceInputStream.readString(0, true);
        this.SLe = jceInputStream.readString(1, false);
        this.guid = jceInputStream.readString(2, false);
        this.dGL = jceInputStream.readString(3, false);
        this.brand = jceInputStream.readString(4, false);
        this.model = jceInputStream.readString(5, false);
        this.SLJ = jceInputStream.readString(6, false);
        this.SLH = jceInputStream.read(this.SLH, 7, false);
        this.SLI = jceInputStream.read(this.SLI, 8, false);
        this.SLG = jceInputStream.readString(9, false);
        this.Gyj = jceInputStream.readString(10, false);
        if (SLF == null) {
            HashMap hashMap = new HashMap();
            SLF = hashMap;
            hashMap.put("", "");
        }
        this.SLL = (Map) jceInputStream.read((Object) SLF, 11, false);
        AppMethodBeat.o(214843);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
