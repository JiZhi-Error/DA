package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class GetAppSimpleDetailResponse extends JceStruct {
    static ArrayList<AppSimpleDetail> cache_appSimpleDetailList;
    public ArrayList<AppSimpleDetail> appSimpleDetailList = null;
    public int ret = 0;

    public GetAppSimpleDetailResponse() {
    }

    public GetAppSimpleDetailResponse(int i2, ArrayList<AppSimpleDetail> arrayList) {
        this.ret = i2;
        this.appSimpleDetailList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102290);
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((Collection) this.appSimpleDetailList, 1);
        AppMethodBeat.o(102290);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102291);
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_appSimpleDetailList == null) {
            cache_appSimpleDetailList = new ArrayList<>();
            cache_appSimpleDetailList.add(new AppSimpleDetail());
        }
        this.appSimpleDetailList = (ArrayList) jceInputStream.read((Object) cache_appSimpleDetailList, 1, true);
        AppMethodBeat.o(102291);
    }
}
