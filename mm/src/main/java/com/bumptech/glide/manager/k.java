package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class k extends Fragment {
    j aDc;
    final a aMs;
    final m aMt;
    private final Set<k> aMu;
    private k aMv;
    Fragment aMw;

    public k() {
        this(new a());
        AppMethodBeat.i(77554);
        AppMethodBeat.o(77554);
    }

    @SuppressLint({"ValidFragment"})
    private k(a aVar) {
        AppMethodBeat.i(77555);
        this.aMt = new a();
        this.aMu = new HashSet();
        this.aMs = aVar;
        AppMethodBeat.o(77555);
    }

    private void a(k kVar) {
        AppMethodBeat.i(204485);
        this.aMu.remove(kVar);
        AppMethodBeat.o(204485);
    }

    private void pT() {
        AppMethodBeat.i(77556);
        if (this.aMv != null) {
            this.aMv.a(this);
            this.aMv = null;
        }
        AppMethodBeat.o(77556);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        AppMethodBeat.i(77557);
        super.onAttach(activity);
        try {
            pT();
            this.aMv = c.af(activity).aCp.a(activity.getFragmentManager(), l.l(activity));
            if (!equals(this.aMv)) {
                this.aMv.aMu.add(this);
            }
            AppMethodBeat.o(77557);
        } catch (IllegalStateException e2) {
            Log.isLoggable("RMFragment", 5);
            AppMethodBeat.o(77557);
        }
    }

    public final void onDetach() {
        AppMethodBeat.i(77558);
        super.onDetach();
        pT();
        AppMethodBeat.o(77558);
    }

    public final void onStart() {
        AppMethodBeat.i(77559);
        super.onStart();
        this.aMs.onStart();
        AppMethodBeat.o(77559);
    }

    public final void onStop() {
        AppMethodBeat.i(77560);
        super.onStop();
        this.aMs.onStop();
        AppMethodBeat.o(77560);
    }

    public final void onDestroy() {
        AppMethodBeat.i(77561);
        super.onDestroy();
        this.aMs.onDestroy();
        pT();
        AppMethodBeat.o(77561);
    }

    public final String toString() {
        Fragment fragment;
        AppMethodBeat.i(77562);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        if (Build.VERSION.SDK_INT >= 17) {
            fragment = getParentFragment();
        } else {
            fragment = null;
        }
        if (fragment == null) {
            fragment = this.aMw;
        }
        String sb = append.append(fragment).append("}").toString();
        AppMethodBeat.o(77562);
        return sb;
    }

    class a implements m {
        a() {
        }

        public final String toString() {
            AppMethodBeat.i(77553);
            String str = super.toString() + "{fragment=" + k.this + "}";
            AppMethodBeat.o(77553);
            return str;
        }
    }
}
