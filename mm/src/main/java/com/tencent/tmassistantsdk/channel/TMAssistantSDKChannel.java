package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TMAssistantSDKChannel {
    public synchronized ArrayList<TMAssistantSDKChannelDataItem> getChannelDataItemList() {
        ArrayList<TMAssistantSDKChannelDataItem> queryAll;
        AppMethodBeat.i(101861);
        queryAll = new DBOption().queryAll();
        AppMethodBeat.o(101861);
        return queryAll;
    }

    public synchronized long AddDataItem(String str, int i2, String str2, int i3, String str3, long j2, long j3, int i4, byte[] bArr) {
        long insert;
        AppMethodBeat.i(101862);
        insert = new DBOption().insert(new TMAssistantSDKChannelDataItem(str, i2, str2, i3, str3, j2, j3, i4, bArr));
        AppMethodBeat.o(101862);
        return insert;
    }

    public synchronized boolean delDataItem(long j2) {
        boolean delete;
        AppMethodBeat.i(101863);
        if (j2 < 0) {
            delete = false;
            AppMethodBeat.o(101863);
        } else {
            delete = new DBOption().delete(j2);
            AppMethodBeat.o(101863);
        }
        return delete;
    }
}
