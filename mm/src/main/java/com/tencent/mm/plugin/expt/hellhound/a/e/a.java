package com.tencent.mm.plugin.expt.hellhound.a.e;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor;", "", "()V", "Companion", "PermissionListener", "plugin-expt_release"})
public final class a {
    private static int sIj = -1;
    private static boolean sIk;
    private static boolean sIl;
    private static final b sIm = new b();
    public static final C1018a sIn = new C1018a((byte) 0);

    public static final int cPH() {
        return sIj;
    }

    public static final void cPI() {
        sIj = -1;
    }

    public static final boolean cPJ() {
        return sIk;
    }

    public static final boolean cPK() {
        return sIl;
    }

    public static final void cPL() {
        sIl = false;
    }

    public static final void mj(boolean z) {
        sIk = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\u000b\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$Companion;", "", "()V", "TAG", "", "isOnPauseEvent", "", "isOnPauseEvent$annotations", "()Z", "setOnPauseEvent", "(Z)V", "isRequestPermission", "isRequestPermission$annotations", "setRequestPermission", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "permissionRequestCode", "", "permissionRequestCode$annotations", "getPermissionRequestCode", "()I", "setPermissionRequestCode", "(I)V", "monitor", "", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.e.a$a  reason: collision with other inner class name */
    public static final class C1018a {
        private C1018a() {
        }

        public /* synthetic */ C1018a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(184283);
        AppMethodBeat.o(184283);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJN\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/permission/PermissionMonitor$PermissionListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "()V", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.hellhoundlib.a.b {
        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            AppMethodBeat.i(221120);
            if (obj != null && (((obj instanceof Activity) || (obj instanceof Fragment) || (obj instanceof android.app.Fragment)) && objArr != null && objArr.length >= 2)) {
                C1018a aVar = a.sIn;
                Object obj2 = objArr[1];
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(221120);
                    throw tVar;
                }
                a.sIj = ((Integer) obj2).intValue();
                C1018a aVar2 = a.sIn;
                Log.i("HABBYGE-MALI.PermissionMonitor", "PermissionListener, args: %d", Integer.valueOf(a.sIj));
                C1018a aVar3 = a.sIn;
                a.sIl = true;
            }
            AppMethodBeat.o(221120);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
        }
    }

    public static final void cMH() {
        AppMethodBeat.i(184284);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("requestPermissions", "([Ljava/lang/String;I)V"));
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(arrayList, sIm);
        AppMethodBeat.o(184284);
    }
}
