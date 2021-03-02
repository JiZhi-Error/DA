package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class f extends JceStruct {
    static ArrayList<c> Ssq = new ArrayList<>();
    static ArrayList<i> Ssr = new ArrayList<>();
    static ArrayList<h> Sss = new ArrayList<>();
    static e Sst = new e();
    public int RND = 0;
    public long Ssm = 0;
    public ArrayList<i> Ssn = null;
    public ArrayList<h> Sso = null;
    public e Ssp = null;
    public ArrayList<c> kgc = null;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214760);
        jceOutputStream.write(this.Ssm, 0);
        if (this.kgc != null) {
            jceOutputStream.write((Collection) this.kgc, 1);
        }
        jceOutputStream.write(this.RND, 2);
        if (this.Ssn != null) {
            jceOutputStream.write((Collection) this.Ssn, 3);
        }
        if (this.Sso != null) {
            jceOutputStream.write((Collection) this.Sso, 4);
        }
        if (this.Ssp != null) {
            jceOutputStream.write((JceStruct) this.Ssp, 5);
        }
        AppMethodBeat.o(214760);
    }

    static {
        AppMethodBeat.i(214762);
        Ssq.add(new c());
        Ssr.add(new i());
        Sss.add(new h());
        AppMethodBeat.o(214762);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214761);
        this.Ssm = jceInputStream.read(this.Ssm, 0, true);
        this.kgc = (ArrayList) jceInputStream.read((Object) Ssq, 1, false);
        this.RND = jceInputStream.read(this.RND, 2, false);
        this.Ssn = (ArrayList) jceInputStream.read((Object) Ssr, 3, false);
        this.Sso = (ArrayList) jceInputStream.read((Object) Sss, 4, false);
        this.Ssp = (e) jceInputStream.read((JceStruct) Sst, 5, false);
        AppMethodBeat.o(214761);
    }
}
