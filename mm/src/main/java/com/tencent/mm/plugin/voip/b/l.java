package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private Map<Integer, Map<Integer, Integer>> Hhr;
    public int mState;

    public l(int i2) {
        this.mState = i2;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void aD(int i2, int i3, int i4) {
        Map<Integer, Integer> map;
        AppMethodBeat.i(115527);
        if (this.Hhr == null) {
            this.Hhr = new HashMap();
        }
        if (!this.Hhr.containsKey(Integer.valueOf(i2))) {
            map = new HashMap<>();
            this.Hhr.put(Integer.valueOf(i2), map);
        } else {
            map = this.Hhr.get(Integer.valueOf(i2));
        }
        map.put(Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(115527);
    }

    public final boolean adT(int i2) {
        AppMethodBeat.i(115528);
        if (this.Hhr == null || !this.Hhr.containsKey(Integer.valueOf(this.mState))) {
            Log.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", k.adM(this.mState));
            AppMethodBeat.o(115528);
            return false;
        } else if (!this.Hhr.get(Integer.valueOf(this.mState)).containsKey(Integer.valueOf(i2))) {
            Log.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", k.adM(this.mState), k.adM(i2));
            AppMethodBeat.o(115528);
            return false;
        } else {
            AppMethodBeat.o(115528);
            return true;
        }
    }

    public final void adU(int i2) {
        AppMethodBeat.i(115529);
        if (!adT(i2)) {
            Log.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
            AppMethodBeat.o(115529);
            return;
        }
        int intValue = this.Hhr.get(Integer.valueOf(this.mState)).get(Integer.valueOf(i2)).intValue();
        Log.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", k.adM(this.mState), k.adM(intValue), k.adM(i2));
        this.mState = intValue;
        AppMethodBeat.o(115529);
    }

    public final int getState() {
        return this.mState;
    }
}
