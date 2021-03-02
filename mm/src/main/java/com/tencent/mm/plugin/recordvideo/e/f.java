package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\rH\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class f implements t {
    public static final a Civ = new a((byte) 0);
    private final HashMap<String, Long> Ciu = new HashMap<>();

    static {
        AppMethodBeat.i(237995);
        AppMethodBeat.o(237995);
    }

    public f() {
        AppMethodBeat.i(237994);
        AppMethodBeat.o(237994);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237996);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237996);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin$Companion;", "", "()V", "TAG", "", "TIME_START", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final long aLR(String str) {
        AppMethodBeat.i(237991);
        p.h(str, "tag");
        long currentTimeMillis = System.currentTimeMillis();
        this.Ciu.put(str, Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(237991);
        return currentTimeMillis;
    }

    public final long jH(String str, String str2) {
        AppMethodBeat.i(237992);
        p.h(str, "tag");
        if (this.Ciu.get(str) == null) {
            Log.e("MicroMsg.RecordTimeCalculatePlugin", str + " miss start mark!!!");
            AppMethodBeat.o(237992);
            return -1;
        }
        Long l = this.Ciu.get(str);
        if (l != null) {
            long currentTimeMillis = System.currentTimeMillis();
            p.g(l, "this");
            long longValue = currentTimeMillis - l.longValue();
            Log.i("MicroMsg.RecordTimeCalculatePlugin", str2 + " cost time:" + longValue);
            AppMethodBeat.o(237992);
            return longValue;
        }
        AppMethodBeat.o(237992);
        return -1;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(237993);
        this.Ciu.clear();
        AppMethodBeat.o(237993);
    }
}
