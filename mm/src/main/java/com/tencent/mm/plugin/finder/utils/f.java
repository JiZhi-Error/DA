package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"})
public final class f {
    private static final String TAG = TAG;
    private static final a vVm;
    private static final List<a> vVn;
    public static final f vVo = new f();

    static {
        AppMethodBeat.i(253393);
        a aVar = new a("Finder_UploadBigFileConfig");
        vVm = aVar;
        vVn = j.listOf(aVar);
        AppMethodBeat.o(253393);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"})
    public static final class a {
        final long id = 1253;
        final long key = 37;
        final String vVp;

        public a(String str) {
            p.h(str, "mmkvKey");
            AppMethodBeat.i(253389);
            this.vVp = str;
            AppMethodBeat.o(253389);
        }

        public final void a(MultiProcessMMKV multiProcessMMKV) {
            AppMethodBeat.i(253388);
            p.h(multiProcessMMKV, "mmkv");
            multiProcessMMKV.putLong(this.vVp, 0);
            multiProcessMMKV.commit();
            f fVar = f.vVo;
            Log.i(f.TAG, "clean " + this.vVp);
            AppMethodBeat.o(253388);
        }
    }

    public static a dBB() {
        return vVm;
    }

    public static void a(a aVar) {
        AppMethodBeat.i(253390);
        p.h(aVar, "config");
        MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
        p.g(singleDefault, "mmkv");
        p.h(singleDefault, "mmkv");
        singleDefault.putLong(aVar.vVp, System.currentTimeMillis());
        singleDefault.commit();
        Log.i(TAG, "mark " + aVar.vVp);
        AppMethodBeat.o(253390);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(253391);
        p.h(aVar, "config");
        MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
        p.g(singleDefault, "mmkv");
        aVar.a(singleDefault);
        AppMethodBeat.o(253391);
    }

    public static void dBC() {
        AppMethodBeat.i(253392);
        MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
        for (T t : vVn) {
            p.g(singleDefault, "mmkv");
            p.h(singleDefault, "mmkv");
            if (singleDefault.getLong(t.vVp, 0) != 0) {
                t.a(singleDefault);
                h.INSTANCE.n(t.id, t.key, 1);
                Log.i(TAG, "check " + t.vVp + ", hit!");
            }
        }
        AppMethodBeat.o(253392);
    }
}
