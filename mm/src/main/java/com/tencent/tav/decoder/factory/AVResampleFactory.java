package com.tencent.tav.decoder.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.resample.TAVResample;

public class AVResampleFactory {
    private static final String TAG = "AVResampleFactory";
    private static AVResampleFactory instance = null;
    private boolean tavResampleEnable = false;

    public static synchronized void setInstance(AVResampleFactory aVResampleFactory) {
        synchronized (AVResampleFactory.class) {
            instance = aVResampleFactory;
        }
    }

    public static synchronized AVResampleFactory getInstance() {
        AVResampleFactory aVResampleFactory;
        synchronized (AVResampleFactory.class) {
            AppMethodBeat.i(218449);
            if (instance == null) {
                instance = new AVResampleFactory();
            }
            aVResampleFactory = instance;
            AppMethodBeat.o(218449);
        }
        return aVResampleFactory;
    }

    public AVResampleFactory() {
        boolean z = false;
        AppMethodBeat.i(218450);
        try {
            this.tavResampleEnable = Class.forName("com.tencent.tavkit.resample.TAVResample") != null ? true : z;
            AppMethodBeat.o(218450);
        } catch (ClassNotFoundException e2) {
            Logger.w(TAG, "newAVResample: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(218450);
        }
    }

    public boolean isResampleEnable() {
        return this.tavResampleEnable;
    }

    public IAVResample newAVResample(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(218451);
        if (this.tavResampleEnable) {
            TAVResample tAVResample = new TAVResample(i2, i3, i4, i5);
            AppMethodBeat.o(218451);
            return tAVResample;
        }
        AppMethodBeat.o(218451);
        return null;
    }
}
