package com.tencent.tavkit.composition.model;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class TAVVideoConfiguration implements Cloneable {
    public static CGRect DEFAULT_VIDEO_FRAME;
    public static final CGRect FIX_RENDER_SIZE = new CGRect();
    public static final CGRect SOURCE_SIZE;
    private TAVVideoConfigurationContentMode contentMode = TAVVideoConfigurationContentMode.aspectFit;
    private List<TAVVideoEffect> effects = new ArrayList();
    private CGRect frame = DEFAULT_VIDEO_FRAME;
    private int preferRotation = 0;
    private Matrix transform = new Matrix();

    static {
        AppMethodBeat.i(197579);
        CGRect cGRect = new CGRect();
        SOURCE_SIZE = cGRect;
        DEFAULT_VIDEO_FRAME = cGRect;
        AppMethodBeat.o(197579);
    }

    public TAVVideoConfiguration() {
        AppMethodBeat.i(197572);
        AppMethodBeat.o(197572);
    }

    public Matrix getTransform() {
        return this.transform;
    }

    public void setTransform(Matrix matrix) {
        this.transform = matrix;
    }

    public TAVVideoConfigurationContentMode getContentMode() {
        return this.contentMode;
    }

    public void setContentMode(TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        this.contentMode = tAVVideoConfigurationContentMode;
    }

    public CGRect getFrame() {
        return this.frame;
    }

    public void setFrame(CGRect cGRect) {
        this.frame = cGRect;
    }

    public boolean frameEnable() {
        AppMethodBeat.i(197573);
        if (this.frame == null || this.frame == FIX_RENDER_SIZE || this.frame == SOURCE_SIZE || !Utils.isRectValid(this.frame)) {
            AppMethodBeat.o(197573);
            return false;
        }
        AppMethodBeat.o(197573);
        return true;
    }

    public void setEffects(List<TAVVideoEffect> list) {
        this.effects = list;
    }

    public List<TAVVideoEffect> getEffects() {
        return this.effects;
    }

    public void addEffect(TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197574);
        if (this.effects == null) {
            this.effects = new ArrayList();
        }
        this.effects.add(tAVVideoEffect);
        AppMethodBeat.o(197574);
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public void setPreferRotation(int i2) {
        this.preferRotation = i2;
    }

    @Override // java.lang.Object
    public TAVVideoConfiguration clone() {
        AppMethodBeat.i(197575);
        TAVVideoConfiguration tAVVideoConfiguration = new TAVVideoConfiguration();
        tAVVideoConfiguration.contentMode = this.contentMode;
        tAVVideoConfiguration.frame = this.frame;
        tAVVideoConfiguration.transform = this.transform;
        tAVVideoConfiguration.effects = new ArrayList(this.effects);
        tAVVideoConfiguration.preferRotation = this.preferRotation;
        AppMethodBeat.o(197575);
        return tAVVideoConfiguration;
    }

    public void updateTimeRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(197576);
        if (this.effects == null) {
            AppMethodBeat.o(197576);
            return;
        }
        for (TAVVideoEffect tAVVideoEffect : this.effects) {
            if (tAVVideoEffect instanceof TAVAttachTimeRangeSourceEffect) {
                ((TAVAttachTimeRangeSourceEffect) tAVVideoEffect).attachTimeRange(cMTimeRange);
            }
        }
        AppMethodBeat.o(197576);
    }

    public enum TAVVideoConfigurationContentMode {
        aspectFit,
        aspectFill,
        scaleToFit;

        public static TAVVideoConfigurationContentMode valueOf(String str) {
            AppMethodBeat.i(197570);
            TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode = (TAVVideoConfigurationContentMode) Enum.valueOf(TAVVideoConfigurationContentMode.class, str);
            AppMethodBeat.o(197570);
            return tAVVideoConfigurationContentMode;
        }

        static {
            AppMethodBeat.i(197571);
            AppMethodBeat.o(197571);
        }
    }

    public String toString() {
        AppMethodBeat.i(197577);
        String str = "TAVVideoConfiguration{contentMode=" + this.contentMode + ", frame=" + this.frame + ", transform=" + this.transform + '}';
        AppMethodBeat.o(197577);
        return str;
    }
}
