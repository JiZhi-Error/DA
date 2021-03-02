package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AudioMixInputParameters;
import java.util.List;

public class AudioMix<InputParameters extends AudioMixInputParameters> {
    protected List<InputParameters> inputParameters;

    public List<InputParameters> getInputParameters() {
        return this.inputParameters;
    }

    public AudioMix(List<InputParameters> list) {
        this.inputParameters = list;
    }

    public InputParameters getInputParametersWithTrackID(int i2) {
        AppMethodBeat.i(217850);
        for (InputParameters inputparameters : this.inputParameters) {
            if (inputparameters.getTrackID() == i2) {
                AppMethodBeat.o(217850);
                return inputparameters;
            }
        }
        AppMethodBeat.o(217850);
        return null;
    }

    public void release() {
        AppMethodBeat.i(217851);
        for (InputParameters inputparameters : this.inputParameters) {
            if (!(inputparameters == null || inputparameters.getAudioTapProcessor() == null)) {
                inputparameters.getAudioTapProcessor().release();
            }
        }
        AppMethodBeat.o(217851);
    }

    public String toString() {
        AppMethodBeat.i(217852);
        String str = "AudioMix{inputParameters=" + this.inputParameters + '}';
        AppMethodBeat.o(217852);
        return str;
    }
}
