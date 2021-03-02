package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class d extends JceStruct implements Cloneable {
    static ArrayList<a> SLg;
    static ArrayList<b> SLh;
    static c SLi;
    static f SLj;
    static ArrayList<g> SLk;
    static h SLl;
    public String LhD = "";
    public String SLA = "";
    public f SLB = null;
    public ArrayList<g> SLC = null;
    public h SLD = null;
    public String SLm = "";
    public ArrayList<a> SLn = null;
    public String SLo = "";
    public String SLp = "";
    public String SLq = "";
    public ArrayList<b> SLr = null;
    public String SLs = "";
    public long SLt = 0;
    public String SLu = "";
    public c SLv = null;
    public long SLw = 0;
    public String SLx = "";
    public String SLy = "";
    public String SLz = "";
    public String dlj = "";
    public String processName = "";
    public String sessionId = "";
    public String threadName = "";
    public String type = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214838);
        jceOutputStream.write(this.SLz, 0);
        if (this.SLy != null) {
            jceOutputStream.write(this.SLy, 1);
        }
        if (this.dlj != null) {
            jceOutputStream.write(this.dlj, 2);
        }
        jceOutputStream.write(this.SLt, 3);
        jceOutputStream.write((Collection) this.SLr, 4);
        if (this.threadName != null) {
            jceOutputStream.write(this.threadName, 5);
        }
        if (this.SLs != null) {
            jceOutputStream.write(this.SLs, 6);
        }
        if (this.SLu != null) {
            jceOutputStream.write(this.SLu, 7);
        }
        if (this.SLB != null) {
            jceOutputStream.write((JceStruct) this.SLB, 8);
        }
        if (this.SLD != null) {
            jceOutputStream.write((JceStruct) this.SLD, 9);
        }
        if (this.SLv != null) {
            jceOutputStream.write((JceStruct) this.SLv, 10);
        }
        if (this.SLx != null) {
            jceOutputStream.write(this.SLx, 11);
        }
        if (this.SLn != null) {
            jceOutputStream.write((Collection) this.SLn, 12);
        }
        jceOutputStream.write(this.SLw, 13);
        if (this.LhD != null) {
            jceOutputStream.write(this.LhD, 14);
        }
        if (this.SLp != null) {
            jceOutputStream.write(this.SLp, 15);
        }
        if (this.processName != null) {
            jceOutputStream.write(this.processName, 16);
        }
        if (this.SLo != null) {
            jceOutputStream.write(this.SLo, 17);
        }
        if (this.type != null) {
            jceOutputStream.write(this.type, 18);
        }
        if (this.SLq != null) {
            jceOutputStream.write(this.SLq, 19);
        }
        if (this.SLm != null) {
            jceOutputStream.write(this.SLm, 20);
        }
        if (this.SLC != null) {
            jceOutputStream.write((Collection) this.SLC, 21);
        }
        if (this.SLA != null) {
            jceOutputStream.write(this.SLA, 22);
        }
        if (this.sessionId != null) {
            jceOutputStream.write(this.sessionId, 23);
        }
        AppMethodBeat.o(214838);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214839);
        this.SLz = jceInputStream.readString(0, true);
        this.SLy = jceInputStream.readString(1, false);
        this.dlj = jceInputStream.readString(2, false);
        this.SLt = jceInputStream.read(this.SLt, 3, true);
        if (SLh == null) {
            ArrayList<b> arrayList = new ArrayList<>();
            SLh = arrayList;
            arrayList.add(new b());
        }
        this.SLr = (ArrayList) jceInputStream.read((Object) SLh, 4, true);
        this.threadName = jceInputStream.readString(5, false);
        this.SLs = jceInputStream.readString(6, false);
        this.SLu = jceInputStream.readString(7, false);
        if (SLj == null) {
            SLj = new f();
        }
        this.SLB = (f) jceInputStream.read((JceStruct) SLj, 8, false);
        if (SLl == null) {
            SLl = new h();
        }
        this.SLD = (h) jceInputStream.read((JceStruct) SLl, 9, false);
        if (SLi == null) {
            SLi = new c();
        }
        this.SLv = (c) jceInputStream.read((JceStruct) SLi, 10, false);
        this.SLx = jceInputStream.readString(11, false);
        if (SLg == null) {
            ArrayList<a> arrayList2 = new ArrayList<>();
            SLg = arrayList2;
            arrayList2.add(new a());
        }
        this.SLn = (ArrayList) jceInputStream.read((Object) SLg, 12, false);
        this.SLw = jceInputStream.read(this.SLw, 13, false);
        this.LhD = jceInputStream.readString(14, false);
        this.SLp = jceInputStream.readString(15, false);
        this.processName = jceInputStream.readString(16, false);
        this.SLo = jceInputStream.readString(17, false);
        this.type = jceInputStream.readString(18, false);
        this.SLq = jceInputStream.readString(19, false);
        this.SLm = jceInputStream.readString(20, false);
        if (SLk == null) {
            ArrayList<g> arrayList3 = new ArrayList<>();
            SLk = arrayList3;
            arrayList3.add(new g());
        }
        this.SLC = (ArrayList) jceInputStream.read((Object) SLk, 21, false);
        this.SLA = jceInputStream.readString(22, false);
        this.sessionId = jceInputStream.readString(23, false);
        AppMethodBeat.o(214839);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
    }
}
