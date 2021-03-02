package com.tencent.mm.media.widget.camerarecordview.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "black", "", "", "blackModelList", "kotlin.jvm.PlatformType", "enable", "", "ramConfig", "", "totalMemory", "getTotalMemory", "()I", "enableDaemonRecord", "enableDaemonRecordByConfig", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final C0431a iqa = new C0431a((byte) 0);
    public final boolean enable = ((b) g.af(b.class)).a(b.a.clicfg_multi_record, true);
    private final int ipW;
    public final int ipX = ((b) g.af(b.class)).a(b.a.clicfg_multi_record_ram_enable, 5000);
    public final String ipY = ((b) g.af(b.class)).a(b.a.clicfg_multi_record_model_black, "");
    private final List<String> ipZ;

    static {
        AppMethodBeat.i(161621);
        AppMethodBeat.o(161621);
    }

    public a(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(161620);
        this.ipW = d.gy(context) / 1024;
        String str = this.ipY;
        p.g(str, "blackModelList");
        this.ipZ = n.b(str, new char[]{';'});
        AppMethodBeat.o(161620);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.a.a$a  reason: collision with other inner class name */
    public static final class C0431a {
        private C0431a() {
        }

        public /* synthetic */ C0431a(byte b2) {
            this();
        }
    }

    public final boolean aQl() {
        AppMethodBeat.i(161619);
        Iterator<T> it = this.ipZ.iterator();
        while (it.hasNext()) {
            if (p.j(it.next(), Build.MODEL)) {
                Log.i("MicroMsg.DaemonChecker", "disable by blackModelList Build.MODEL:" + Build.MODEL);
                AppMethodBeat.o(161619);
                return false;
            }
        }
        if (this.ipW < this.ipX) {
            Log.i("MicroMsg.DaemonChecker", "disable by lower ram:" + this.ipW + "  config:" + this.ipX);
            AppMethodBeat.o(161619);
            return false;
        }
        AppMethodBeat.o(161619);
        return true;
    }
}
