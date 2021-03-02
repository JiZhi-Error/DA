package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TimeLogger {
    private boolean mDisabled;
    private String mLabel;
    ArrayList<String> mSplitLabels;
    ArrayList<Long> mSplits;
    private String mTag;

    public TimeLogger(String str, String str2) {
        AppMethodBeat.i(157843);
        reset(str, str2);
        AppMethodBeat.o(157843);
    }

    public void reset(String str, String str2) {
        AppMethodBeat.i(230400);
        this.mTag = str;
        this.mLabel = str2;
        reset();
        AppMethodBeat.o(230400);
    }

    public void reset() {
        AppMethodBeat.i(230401);
        this.mDisabled = false;
        if (this.mDisabled) {
            AppMethodBeat.o(230401);
            return;
        }
        if (this.mSplits == null) {
            this.mSplits = new ArrayList<>();
            this.mSplitLabels = new ArrayList<>();
        } else {
            this.mSplits.clear();
            this.mSplitLabels.clear();
        }
        addSplit(null);
        AppMethodBeat.o(230401);
    }

    public void addSplit(String str) {
        AppMethodBeat.i(157844);
        if (this.mDisabled) {
            AppMethodBeat.o(157844);
            return;
        }
        this.mSplits.add(Long.valueOf(SystemClock.elapsedRealtime()));
        this.mSplitLabels.add(str);
        AppMethodBeat.o(157844);
    }

    public void dumpToLog() {
        AppMethodBeat.i(157845);
        if (this.mDisabled) {
            AppMethodBeat.o(157845);
            return;
        }
        Log.d(this.mTag, this.mLabel + ": begin");
        long longValue = this.mSplits.get(0).longValue();
        long j2 = longValue;
        for (int i2 = 1; i2 < this.mSplits.size(); i2++) {
            j2 = this.mSplits.get(i2).longValue();
            long longValue2 = this.mSplits.get(i2 - 1).longValue();
            Log.d(this.mTag, this.mLabel + ":      " + (j2 - longValue2) + " ms, " + this.mSplitLabels.get(i2));
        }
        Log.d(this.mTag, this.mLabel + ": end, " + (j2 - longValue) + " ms");
        AppMethodBeat.o(157845);
    }
}
