package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class GetAppSimpleDetailRequest extends JceStruct {
    static ArrayList<AppDetailParam> cache_appReqList;
    public ArrayList<AppDetailParam> appReqList = null;

    public GetAppSimpleDetailRequest() {
    }

    public GetAppSimpleDetailRequest(ArrayList<AppDetailParam> arrayList) {
        this.appReqList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102288);
        if (this.appReqList != null) {
            jceOutputStream.write((Collection) this.appReqList, 0);
        }
        AppMethodBeat.o(102288);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102289);
        if (cache_appReqList == null) {
            cache_appReqList = new ArrayList<>();
            cache_appReqList.add(new AppDetailParam());
        }
        this.appReqList = (ArrayList) jceInputStream.read((Object) cache_appReqList, 0, false);
        AppMethodBeat.o(102289);
    }
}
