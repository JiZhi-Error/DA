package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends JceStruct {
    static Map<Integer, ArrayList<f>> RNE;
    public long RNB = 0;
    public Map<Integer, ArrayList<f>> RNC = null;
    public int RND = 0;
    public int RNi = 0;
    public int RNj = 0;
    public int RNk = 0;
    public int RNl = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138427);
        jceOutputStream.write(this.RNB, 0);
        jceOutputStream.write((Map) this.RNC, 1);
        jceOutputStream.write(this.RNi, 2);
        jceOutputStream.write(this.RNj, 3);
        jceOutputStream.write(this.RNk, 4);
        jceOutputStream.write(this.RNl, 5);
        if (this.RND != 0) {
            jceOutputStream.write(this.RND, 6);
        }
        AppMethodBeat.o(138427);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138428);
        this.RNB = jceInputStream.read(this.RNB, 0, true);
        if (RNE == null) {
            RNE = new HashMap();
            ArrayList<f> arrayList = new ArrayList<>();
            arrayList.add(new f());
            RNE.put(0, arrayList);
        }
        this.RNC = (Map) jceInputStream.read((Object) RNE, 1, true);
        this.RNi = jceInputStream.read(this.RNi, 2, false);
        this.RNj = jceInputStream.read(this.RNj, 3, false);
        this.RNk = jceInputStream.read(this.RNk, 4, false);
        this.RNl = jceInputStream.read(this.RNl, 5, false);
        this.RND = jceInputStream.read(this.RND, 6, false);
        AppMethodBeat.o(138428);
    }
}
