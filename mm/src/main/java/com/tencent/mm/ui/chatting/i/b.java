package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b implements c.b {
    private static WeakHashMap<Fragment, HashMap<Integer, c.a>> PDV = new WeakHashMap<>();
    private WeakReference<a> PDW;

    static {
        AppMethodBeat.i(36442);
        AppMethodBeat.o(36442);
    }

    public b(a aVar) {
        AppMethodBeat.i(36436);
        this.PDW = new WeakReference<>(aVar);
        AppMethodBeat.o(36436);
    }

    public static c.a d(Fragment fragment, int i2) {
        AppMethodBeat.i(36437);
        HashMap<Integer, c.a> hashMap = PDV.get(fragment);
        if (hashMap != null) {
            c.a remove = hashMap.remove(Integer.valueOf(i2));
            AppMethodBeat.o(36437);
            return remove;
        }
        AppMethodBeat.o(36437);
        return null;
    }

    private static void a(Fragment fragment, int i2, c.a aVar) {
        AppMethodBeat.i(36438);
        HashMap<Integer, c.a> hashMap = PDV.get(fragment);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            PDV.put(fragment, hashMap);
        }
        hashMap.put(Integer.valueOf(i2), aVar);
        AppMethodBeat.o(36438);
    }

    public final Fragment getFragment() {
        AppMethodBeat.i(36439);
        a aVar = this.PDW.get();
        if (aVar != null) {
            BaseChattingUIFragment baseChattingUIFragment = aVar.Pwc;
            AppMethodBeat.o(36439);
            return baseChattingUIFragment;
        }
        AppMethodBeat.o(36439);
        return null;
    }

    @Override // com.tencent.mm.br.c.b
    public final void a(Intent intent, int i2, c.a aVar) {
        AppMethodBeat.i(36440);
        Fragment fragment = getFragment();
        if (fragment == null) {
            AppMethodBeat.o(36440);
            return;
        }
        a(fragment, i2, aVar);
        fragment.startActivityForResult(intent, i2);
        AppMethodBeat.o(36440);
    }

    @Override // com.tencent.mm.br.c.b
    public final Context getContext() {
        AppMethodBeat.i(36441);
        FragmentActivity activity = getFragment().getActivity();
        AppMethodBeat.o(36441);
        return activity;
    }
}
