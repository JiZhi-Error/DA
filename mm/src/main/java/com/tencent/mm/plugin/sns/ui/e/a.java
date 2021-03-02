package com.tencent.mm.plugin.sns.ui.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {
    private static SparseArray<HashMap> FcR = new SparseArray<>();
    private static m FcS = new m() {
        /* class com.tencent.mm.plugin.sns.ui.e.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.story.api.m
        public final void cr(final String str, final boolean z) {
            AppMethodBeat.i(100378);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.e.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(100377);
                    for (int i2 = 0; i2 < a.FcR.size(); i2++) {
                        Set<WeakReference> set = (Set) ((HashMap) a.FcR.valueAt(i2)).get(str);
                        if (set == null || set.size() == 0) {
                            AppMethodBeat.o(100377);
                            return;
                        }
                        for (WeakReference weakReference : set) {
                            m mVar = (m) weakReference.get();
                            if (mVar != null) {
                                mVar.cr(str, z);
                            }
                        }
                    }
                    AppMethodBeat.o(100377);
                }
            });
            AppMethodBeat.o(100378);
        }
    };

    static {
        AppMethodBeat.i(100382);
        ((e) g.ah(e.class)).addStoryStatusNotifyListener(FcS);
        AppMethodBeat.o(100382);
    }

    public static void a(int i2, String str, m mVar) {
        HashMap hashMap;
        AppMethodBeat.i(100379);
        if (TextUtils.isEmpty(str) || mVar == null) {
            AppMethodBeat.o(100379);
            return;
        }
        HashMap hashMap2 = FcR.get(i2);
        if (hashMap2 == null) {
            hashMap = new HashMap();
        } else {
            hashMap = hashMap2;
        }
        Set set = (Set) hashMap.get(str);
        if (set == null) {
            set = new HashSet();
        }
        set.add(new WeakReference(mVar));
        hashMap.put(str, set);
        FcR.put(i2, hashMap);
        AppMethodBeat.o(100379);
    }

    public static void b(int i2, String str, m mVar) {
        AppMethodBeat.i(100380);
        if (TextUtils.isEmpty(str) || mVar == null) {
            AppMethodBeat.o(100380);
            return;
        }
        HashMap hashMap = FcR.get(i2);
        if (hashMap == null) {
            AppMethodBeat.o(100380);
            return;
        }
        Set set = (Set) hashMap.get(str);
        if (set == null) {
            AppMethodBeat.o(100380);
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            m mVar2 = (m) ((WeakReference) it.next()).get();
            if (mVar2 == null || mVar2.equals(mVar)) {
                it.remove();
            }
        }
        AppMethodBeat.o(100380);
    }

    public static void fkK() {
        AppMethodBeat.i(100381);
        FcR.remove(4);
        AppMethodBeat.o(100381);
    }
}
