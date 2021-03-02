package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class ApkDownUrl extends JceStruct {
    static ArrayList<String> cache_urlList;
    public byte type = 0;
    public ArrayList<String> urlList = null;

    public ApkDownUrl() {
    }

    public ApkDownUrl(byte b2, ArrayList<String> arrayList) {
        this.type = b2;
        this.urlList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102274);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((Collection) this.urlList, 1);
        AppMethodBeat.o(102274);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102275);
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_urlList == null) {
            cache_urlList = new ArrayList<>();
            cache_urlList.add("");
        }
        this.urlList = (ArrayList) jceInputStream.read((Object) cache_urlList, 1, true);
        AppMethodBeat.o(102275);
    }
}
