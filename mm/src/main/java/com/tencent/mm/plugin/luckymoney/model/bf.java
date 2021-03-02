package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.util.HashMap;
import org.json.JSONObject;

public final class bf extends av {
    public bf(String str, String str2, String str3) {
        AppMethodBeat.i(ShareElfFile.SectionHeader.SHN_HIPROC);
        HashMap hashMap = new HashMap();
        hashMap.put(ch.COL_USERNAME, str);
        hashMap.put("sendId", str2);
        hashMap.put("channelId", "1");
        hashMap.put("ver", str3);
        hashMap.put("sendUserName", z.aTY());
        setRequestData(hashMap);
        AppMethodBeat.o(ShareElfFile.SectionHeader.SHN_HIPROC);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1668;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/sharewxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
