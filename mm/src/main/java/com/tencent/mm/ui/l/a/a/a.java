package com.tencent.mm.ui.l.a.a;

import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public abstract class a extends v {
    e QlN;

    /* access modifiers changed from: protected */
    public abstract q gWJ();

    public a(e eVar) {
        super(new LinkedList());
        this.QlN = eVar;
        o oVar = new o(b.aKJ(), "luggage/" + eVar.mAppId);
        LinkedList<q> linkedList = this.kTe;
        String z = aa.z(oVar.her());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new z(aa.z(new o(z, "files/").her()), "wxfile://"));
        linkedList2.add(new com.tencent.mm.plugin.appbrand.appstorage.o(aa.z(new o(z, "objects/").her()), "default_obfuscation_key", "wxfile://"));
        linkedList.addAll(linkedList2);
        this.kTe.add(gWJ());
        Log.i("MicroMsg.MagicEmojiFileSystem", "hy: file system established");
    }
}
