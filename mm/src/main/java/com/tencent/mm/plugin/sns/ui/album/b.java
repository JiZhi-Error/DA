package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.album.a;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b extends d<a.b> {
    private a ETv = null;
    private boolean dJM = false;
    private Map<String, List<SnsInfo>> map = new LinkedHashMap();
    private String sNG = "";
    private String userName = "";
    private boolean vUk = false;

    public interface a {
        void hg(List<a.b> list);
    }

    public b(a aVar, String str, boolean z) {
        AppMethodBeat.i(99866);
        this.ETv = aVar;
        this.userName = str;
        this.dJM = z;
        AppMethodBeat.o(99866);
    }

    public final void k(String str, boolean z, boolean z2) {
        AppMethodBeat.i(99867);
        Log.d("MicroMsg.SnsAlbumAdapterHelper", "limitSeq ".concat(String.valueOf(str)));
        this.sNG = str;
        this.vUk = z;
        pN(z2);
        AppMethodBeat.o(99867);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final void gZ(List<a.b> list) {
        AppMethodBeat.i(99868);
        if (this.ETv != null) {
            this.ETv.hg(list);
        }
        AppMethodBeat.o(99868);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final List<a.b> anm() {
        AppMethodBeat.i(99869);
        this.map.clear();
        ArrayList arrayList = new ArrayList();
        Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData isSelf=%s limitSeq=%s isPrivate=%s", Boolean.valueOf(this.dJM), this.sNG, Boolean.valueOf(this.vUk));
        List<SnsInfo> E = an.E(this.dJM, this.sNG);
        for (SnsInfo snsInfo : E) {
            if ((snsInfo.field_type == 1 || snsInfo.field_type == 15) && snsInfo.getTimeLine() != null && snsInfo.getTimeLine().ContentObj != null && !snsInfo.getTimeLine().ContentObj.LoV.isEmpty()) {
                long createTime = (long) snsInfo.getCreateTime();
                String charSequence = bm.JU(1000 * createTime).toString();
                Log.i("MicroMsg.SnsAlbumAdapterHelper", "key:%s createTime:%s info.id:%s", charSequence, Long.valueOf(createTime * 1000), Long.valueOf(snsInfo.field_snsId));
                List<SnsInfo> list = this.map.get(charSequence);
                if (list == null) {
                    list = new ArrayList<>();
                    this.map.put(charSequence, list);
                }
                list.add(snsInfo);
            }
        }
        for (Map.Entry<String, List<SnsInfo>> entry : this.map.entrySet()) {
            a.b bVar = new a.b();
            bVar.label = entry.getKey();
            bVar.ETm = entry.getValue();
            Log.i("MicroMsg.SnsAlbumAdapterHelper", "%s", bVar);
            arrayList.add(bVar);
        }
        Log.i("MicroMsg.SnsAlbumAdapterHelper", "loadData thread: %d count: %d  realCount:%s", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(E.size()), Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(99869);
        return arrayList;
    }
}
