package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.samsung.android.smartclip.SmartClipMetaUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookSmartClip {
    private static final String TAG = "SmartClip";
    private DataExtractionListener mDataExtractionListener = null;
    private Slook mSlook = new Slook();
    private View mView = null;

    public interface DataExtractionListener {
        public static final int EXTRACTION_DEFAULT = 1;
        public static final int EXTRACTION_DISCARD = 0;

        int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea);
    }

    public SlookSmartClip(View view) {
        AppMethodBeat.i(76256);
        this.mView = view;
        AppMethodBeat.o(76256);
    }

    public final void addMetaTag(SlookSmartClipMetaTag slookSmartClipMetaTag) {
        AppMethodBeat.i(76257);
        if (!isSupport(1)) {
            AppMethodBeat.o(76257);
            return;
        }
        SmartClipMetaUtils.addMetaTag(this.mView, slookSmartClipMetaTag);
        AppMethodBeat.o(76257);
    }

    public final void removeMetaTag(String str) {
        AppMethodBeat.i(76258);
        if (!isSupport(1)) {
            AppMethodBeat.o(76258);
            return;
        }
        SmartClipMetaUtils.removeMetaTag(this.mView, str);
        AppMethodBeat.o(76258);
    }

    public final void clearAllMetaTag() {
        AppMethodBeat.i(76259);
        if (!isSupport(1)) {
            AppMethodBeat.o(76259);
            return;
        }
        SmartClipMetaUtils.clearAllMetaTag(this.mView);
        AppMethodBeat.o(76259);
    }

    public final void setDataExtractionListener(DataExtractionListener dataExtractionListener) {
        AppMethodBeat.i(76260);
        if (!isSupport(1)) {
            AppMethodBeat.o(76260);
            return;
        }
        this.mDataExtractionListener = dataExtractionListener;
        SmartClipMetaUtils.setDataExtractionListener(this.mView, new SmartClipDataExtractionListener() {
            /* class com.samsung.android.sdk.look.smartclip.SlookSmartClip.AnonymousClass1 */

            public int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
                AppMethodBeat.i(76255);
                int onExtractSmartClipData = SlookSmartClip.this.mDataExtractionListener.onExtractSmartClipData(view, slookSmartClipDataElement, slookSmartClipCroppedArea);
                AppMethodBeat.o(76255);
                return onExtractSmartClipData;
            }
        });
        AppMethodBeat.o(76260);
    }

    public final int extractDefaultSmartClipData(SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
        AppMethodBeat.i(76261);
        if (!isSupport(1)) {
            AppMethodBeat.o(76261);
            return 0;
        }
        int extractDefaultSmartClipData = SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, slookSmartClipDataElement, slookSmartClipCroppedArea);
        AppMethodBeat.o(76261);
        return extractDefaultSmartClipData;
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76262);
        if (this.mSlook.isFeatureEnabled(2)) {
            AppMethodBeat.o(76262);
            return true;
        }
        AppMethodBeat.o(76262);
        return false;
    }
}
