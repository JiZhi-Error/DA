package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l {
    public HashMap<String, WeakReference<a>> bGH = new HashMap<>();
    private boolean dirty = true;
    public ann taG = new ann();
    private HashSet<Integer> taH = new HashSet<>();
    private List<anl> taI = new LinkedList();

    public interface a {
        void cUG();

        void cUH();
    }

    public l() {
        AppMethodBeat.i(103413);
        try {
            this.taG.parseFrom(Util.decodeHexString((String) g.aAh().azQ().get(225283, "")));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FavTagSetMgr", e2, "", new Object[0]);
            Log.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", e2.getMessage());
            this.taG = new ann();
        }
        Log.i("MicroMsg.FavTagSetMgr", "tag:\n%s", this.taG.xuO);
        AppMethodBeat.o(103413);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(103414);
        if (aVar == null) {
            AppMethodBeat.o(103414);
            return;
        }
        this.bGH.put(aVar.toString(), new WeakReference<>(aVar));
        AppMethodBeat.o(103414);
    }

    private void mw(boolean z) {
        AppMethodBeat.i(103415);
        for (WeakReference<a> weakReference : this.bGH.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    weakReference.get().cUG();
                } else {
                    weakReference.get().cUH();
                }
            }
        }
        AppMethodBeat.o(103415);
    }

    private void save() {
        final byte[] bArr;
        AppMethodBeat.i(103416);
        try {
            bArr = this.taG.toByteArray();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FavTagSetMgr", e2, "", new Object[0]);
            Log.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", e2.getMessage());
            bArr = null;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.a.l.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(103409);
                g.aAh().azQ().set(225283, Util.encodeHexString(bArr));
                AppMethodBeat.o(103409);
            }

            public final String toString() {
                AppMethodBeat.i(103410);
                String str = super.toString() + "|save";
                AppMethodBeat.o(103410);
                return str;
            }
        });
        this.dirty = true;
        AppMethodBeat.o(103416);
    }

    public final List<anl> HW(int i2) {
        AppMethodBeat.i(103417);
        if (i2 < 0 || i2 > 1) {
            AppMethodBeat.o(103417);
            return null;
        }
        if (this.dirty) {
            Log.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.taI.clear();
            Iterator<anm> it = this.taG.xuO.iterator();
            while (it.hasNext()) {
                this.taI.addAll(it.next().Lym);
            }
            this.dirty = false;
        }
        Log.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", Integer.valueOf(this.taI.size()));
        List<anl> list = this.taI;
        AppMethodBeat.o(103417);
        return list;
    }

    public final int cUF() {
        AppMethodBeat.i(103418);
        int i2 = 0;
        Iterator<anm> it = this.taG.xuO.iterator();
        while (it.hasNext()) {
            i2 = it.next().Lym.size() + i2;
        }
        AppMethodBeat.o(103418);
        return i2;
    }

    public final void arV(final String str) {
        AppMethodBeat.i(103419);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103419);
        } else if (this.taH.contains(Integer.valueOf(str.hashCode()))) {
            Log.d("MicroMsg.FavTagSetMgr", "has add tag %s", str);
            AppMethodBeat.o(103419);
        } else {
            this.taH.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Log.d("MicroMsg.FavTagSetMgr", "add tag %s, post", str);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.a.l.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(103411);
                        l.this.arW(str);
                        AppMethodBeat.o(103411);
                    }
                });
                AppMethodBeat.o(103419);
                return;
            }
            Log.d("MicroMsg.FavTagSetMgr", "add tag %s", str);
            arW(str);
            AppMethodBeat.o(103419);
        }
    }

    /* access modifiers changed from: package-private */
    public final void arW(String str) {
        char c2;
        anm anm;
        anm anm2;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(103420);
        String Sh = f.Sh(str.toLowerCase());
        if (Sh == null || Sh.length() <= 0) {
            c2 = '#';
        } else {
            c2 = Sh.charAt(0);
        }
        Iterator<anm> it = this.taG.xuO.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                anm = null;
                break;
            }
            anm = it.next();
            if (anm.Lyl == c2) {
                break;
            } else if (anm.Lyl > c2) {
                anm = new anm();
                anm.Lyl = c2;
                this.taG.xuO.add(i4, anm);
                break;
            } else {
                i4++;
            }
        }
        if (anm == null) {
            anm anm3 = new anm();
            anm3.Lyl = c2;
            this.taG.xuO.add(anm3);
            anm2 = anm3;
        } else {
            anm2 = anm;
        }
        Iterator<anl> it2 = anm2.Lym.iterator();
        while (it2.hasNext()) {
            anl next = it2.next();
            int compareTo = next.Lyk.compareTo(Sh);
            if (compareTo == 0) {
                i2 = next.FeZ.compareTo(str);
            } else {
                i2 = compareTo;
            }
            if (i2 == 0) {
                AppMethodBeat.o(103420);
                return;
            } else if (i2 > 0) {
                anl anl = new anl();
                anl.FeZ = str;
                anl.Lyk = Sh;
                anm2.Lym.add(i3, anl);
                save();
                mw(true);
                AppMethodBeat.o(103420);
                return;
            } else {
                i3++;
            }
        }
        anl anl2 = new anl();
        anl2.FeZ = str;
        anl2.Lyk = Sh;
        anm2.Lym.add(anl2);
        mw(true);
        save();
        AppMethodBeat.o(103420);
    }

    public final void w(g gVar) {
        AppMethodBeat.i(103421);
        if (gVar == null) {
            AppMethodBeat.o(103421);
            return;
        }
        for (String str : gVar.field_tagProto.Lyo) {
            removeTag(str);
        }
        AppMethodBeat.o(103421);
    }

    public final void j(Set<String> set) {
        AppMethodBeat.i(103422);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(103422);
            return;
        }
        Log.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", set);
        for (String str : set) {
            removeTag(str);
        }
        AppMethodBeat.o(103422);
    }

    private void removeTag(final String str) {
        AppMethodBeat.i(103423);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103423);
            return;
        }
        this.taH.remove(Integer.valueOf(str.hashCode()));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", str);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.fav.a.l.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(103412);
                    l.this.arX(str);
                    AppMethodBeat.o(103412);
                }
            });
            AppMethodBeat.o(103423);
            return;
        }
        Log.d("MicroMsg.FavTagSetMgr", "remove tag %s", str);
        arX(str);
        AppMethodBeat.o(103423);
    }

    /* access modifiers changed from: package-private */
    public final void arX(String str) {
        char c2;
        anm anm;
        AppMethodBeat.i(103424);
        String Sh = f.Sh(str.toLowerCase());
        if (Sh == null || Sh.length() <= 0) {
            c2 = '#';
        } else {
            c2 = Sh.charAt(0);
        }
        Iterator<anm> it = this.taG.xuO.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                anm = null;
                break;
            }
            anm next = it.next();
            if (next.Lyl == c2) {
                anm = next;
                break;
            } else if (next.Lyl > c2) {
                AppMethodBeat.o(103424);
                return;
            } else {
                i2++;
            }
        }
        if (anm == null) {
            AppMethodBeat.o(103424);
            return;
        }
        Iterator<anl> it2 = anm.Lym.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            anl next2 = it2.next();
            int compareTo = next2.Lyk.compareTo(Sh);
            if (compareTo == 0) {
                compareTo = next2.FeZ.compareTo(str);
            }
            if (compareTo == 0) {
                if (!((af) g.ah(af.class)).getFavSearchStorage().asc(next2.FeZ)) {
                    anm.Lym.remove(i3);
                    if (anm.Lym.isEmpty()) {
                        this.taG.xuO.remove(i2);
                    }
                    mw(false);
                    save();
                }
                AppMethodBeat.o(103424);
                return;
            } else if (compareTo > 0) {
                AppMethodBeat.o(103424);
                return;
            } else {
                i3++;
            }
        }
        AppMethodBeat.o(103424);
    }
}
