package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    j aDc;
    private SupportRequestManagerFragment aMI;
    Fragment aMJ;
    final a aMs;
    final m aMt;
    private final Set<SupportRequestManagerFragment> aMu;

    public SupportRequestManagerFragment() {
        this(new a());
        AppMethodBeat.i(77581);
        AppMethodBeat.o(77581);
    }

    @SuppressLint({"ValidFragment"})
    private SupportRequestManagerFragment(a aVar) {
        AppMethodBeat.i(77582);
        this.aMt = new a();
        this.aMu = new HashSet();
        this.aMs = aVar;
        AppMethodBeat.o(77582);
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        AppMethodBeat.i(204486);
        this.aMu.remove(supportRequestManagerFragment);
        AppMethodBeat.o(204486);
    }

    private void pT() {
        AppMethodBeat.i(77583);
        if (this.aMI != null) {
            this.aMI.a(this);
            this.aMI = null;
        }
        AppMethodBeat.o(77583);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        AppMethodBeat.i(77584);
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            pT();
            this.aMI = c.af(activity).aCp.a(activity.getSupportFragmentManager(), l.l(activity));
            if (!equals(this.aMI)) {
                this.aMI.aMu.add(this);
            }
            AppMethodBeat.o(77584);
        } catch (IllegalStateException e2) {
            Log.isLoggable("SupportRMFragment", 5);
            AppMethodBeat.o(77584);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        AppMethodBeat.i(77585);
        super.onDetach();
        this.aMJ = null;
        pT();
        AppMethodBeat.o(77585);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        AppMethodBeat.i(77586);
        super.onStart();
        this.aMs.onStart();
        AppMethodBeat.o(77586);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        AppMethodBeat.i(77587);
        super.onStop();
        this.aMs.onStop();
        AppMethodBeat.o(77587);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(77588);
        super.onDestroy();
        this.aMs.onDestroy();
        pT();
        AppMethodBeat.o(77588);
    }

    @Override // android.support.v4.app.Fragment
    public String toString() {
        AppMethodBeat.i(77589);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.aMJ;
        }
        String sb = append.append(parentFragment).append("}").toString();
        AppMethodBeat.o(77589);
        return sb;
    }

    class a implements m {
        a() {
        }

        public final String toString() {
            AppMethodBeat.i(77580);
            String str = super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
            AppMethodBeat.o(77580);
            return str;
        }
    }
}
