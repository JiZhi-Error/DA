package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ak;
import com.tencent.mm.plugin.qqmail.d.am;
import com.tencent.mm.plugin.qqmail.d.au;
import com.tencent.mm.plugin.qqmail.d.ay;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class h implements i, b<IPCString, Bundle> {
    private String BqZ;
    private d<Bundle> hny;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCString iPCString, d<Bundle> dVar) {
        AppMethodBeat.i(198587);
        IPCString iPCString2 = iPCString;
        Log.i("MicroMsg.ReadMailTask", "read mail  %s", iPCString2.value);
        this.hny = dVar;
        this.BqZ = iPCString2.value;
        g.azz().a(new c(iPCString2.value), 0);
        g.azz().a(11312, this);
        AppMethodBeat.o(198587);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(198586);
        Log.i("MicroMsg.ReadMailTask", "read mail, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!((c) qVar).BqZ.equals(this.BqZ)) {
            Log.w("MicroMsg.ReadMailTask", "not my scene, ignore");
            AppMethodBeat.o(198586);
            return;
        }
        g.azz().b(11312, this);
        if (this.hny != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("err_type", i2);
            bundle.putInt("err_code", i3);
            bundle.putString("err_msg", str);
            bundle.putString("mail_id", this.BqZ);
            if (i2 == 0 && i3 == 0) {
                am amVar = ((au) ((c) qVar).iUB.iLL.iLR).Bth;
                if (amVar != null) {
                    bundle.putString("mail_content", amVar.content);
                    if (!amVar.BsS.isEmpty()) {
                        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                        Iterator<ak> it = amVar.BsS.iterator();
                        while (it.hasNext()) {
                            ak next = it.next();
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("attach_fileId", next.fileid);
                            bundle2.putString("attach_key", next.key);
                            bundle2.putString("attach_name", next.name);
                            bundle2.putString("attach_type", next.type);
                            bundle2.putInt("attach_size", next.size);
                            bundle2.putString("attach_download_url", next.BsJ);
                            arrayList.add(bundle2);
                        }
                        bundle.putParcelableArrayList("mail_normal_attach", arrayList);
                    }
                    if (!amVar.BsT.isEmpty()) {
                        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                        Iterator<ak> it2 = amVar.BsT.iterator();
                        while (it2.hasNext()) {
                            ak next2 = it2.next();
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("attach_fileId", next2.fileid);
                            bundle3.putString("attach_key", next2.key);
                            bundle3.putString("attach_name", next2.name);
                            bundle3.putString("attach_type", next2.type);
                            bundle3.putInt("attach_size", next2.size);
                            bundle3.putString("attach_download_url", next2.BsJ);
                            arrayList2.add(bundle3);
                        }
                        bundle.putParcelableArrayList("mail_big_attach", arrayList2);
                    }
                }
                ay ayVar = ((au) ((c) qVar).iUB.iLL.iLR).Bti;
                if (ayVar != null) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("cookie_xmail_uin", ayVar.Btl);
                    bundle4.putString("cookie_xmail_skey", ayVar.Btn);
                    bundle4.putString("cookie_xmail_sid", ayVar.Btm);
                    bundle.putParcelable("mail_cookie", bundle4);
                }
            }
            this.hny.bn(bundle);
        }
        AppMethodBeat.o(198586);
    }
}
