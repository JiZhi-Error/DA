package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;

public abstract class a implements b {
    private static final String wCc = wCc;
    private static final String wCd = wCd;
    private static final String wCe = wCe;
    private static final String wCf = wCf;
    private static final String wCg = wCg;
    private static final String wCh = wCh;
    static final String wCi = wCi;
    static String wCj = "";
    public static final C1355a wCk = new C1355a((byte) 0);
    public final Context context;
    Bundle dQL;
    azy vTz;
    cjk wCb;

    public a(Context context2) {
        p.h(context2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        this.context = context2;
    }

    /* renamed from: com.tencent.mm.plugin.finder.widget.post.a$a */
    public static final class C1355a {
        private C1355a() {
        }

        public /* synthetic */ C1355a(byte b2) {
            this();
        }
    }

    public final void ak(Bundle bundle) {
        LinkedList<FinderMedia> linkedList;
        LinkedList<cjl> linkedList2;
        p.h(bundle, "data");
        this.dQL = bundle;
        byte[] byteArray = bundle.getByteArray(wCe);
        byte[] byteArray2 = bundle.getByteArray(wCf);
        if (!(byteArray == null || byteArray2 == null)) {
            azy azy = new azy();
            try {
                azy.parseFrom(byteArray);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                azy = null;
            }
            this.vTz = azy;
            this.wCb = new cjk();
            FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
            try {
                finderObjectDesc.parseFrom(byteArray2);
            } catch (Exception e3) {
                Log.printDebugStack("safeParser", "", e3);
                finderObjectDesc = null;
            }
            FinderObjectDesc finderObjectDesc2 = finderObjectDesc;
            if (!(finderObjectDesc2 == null || (linkedList = finderObjectDesc2.media) == null)) {
                for (T t : linkedList) {
                    cjk cjk = this.wCb;
                    if (!(cjk == null || (linkedList2 = cjk.mediaList) == null)) {
                        c.a aVar = c.vGN;
                        p.g(t, "svrMedia");
                        linkedList2.add(c.a.b(t));
                    }
                }
            }
        }
    }

    public void refresh() {
        h.hkS();
        wCj = "";
    }

    public boolean cyn() {
        return true;
    }

    public void dIX() {
    }
}
