package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class e extends JceStruct implements Cloneable {
    static ArrayList<d> SLE;
    public ArrayList<d> dtS = null;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214840);
        jceOutputStream.write((Collection) this.dtS, 0);
        AppMethodBeat.o(214840);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214841);
        if (SLE == null) {
            ArrayList<d> arrayList = new ArrayList<>();
            SLE = arrayList;
            arrayList.add(new d());
        }
        this.dtS = (ArrayList) jceInputStream.read((Object) SLE, 0, true);
        AppMethodBeat.o(214841);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
