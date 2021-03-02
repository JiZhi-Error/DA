package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderUtils;

public class ExtractorUtils {
    public static final String MIME_AUDIO = "audio/";
    public static final String MIME_VIDEO = "video/";

    public static CGSize getVideoSize(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218505);
        try {
            MediaFormat firstFormat = DecoderUtils.getFirstFormat(assetExtractor, "video/");
            CGSize cGSize = new CGSize();
            if (firstFormat != null) {
                if (firstFormat.containsKey("display-width")) {
                    cGSize.width = (float) firstFormat.getInteger("display-width");
                } else {
                    cGSize.width = (float) firstFormat.getInteger("width");
                }
                if (firstFormat.containsKey("display-height")) {
                    cGSize.height = (float) firstFormat.getInteger("display-height");
                } else {
                    cGSize.height = (float) firstFormat.getInteger("height");
                }
            }
            AppMethodBeat.o(218505);
            return cGSize;
        } catch (Error | Exception e2) {
            CGSize cGSize2 = new CGSize();
            AppMethodBeat.o(218505);
            return cGSize2;
        }
    }

    public static int getPreferRotation(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218506);
        try {
            MediaFormat firstFormat = DecoderUtils.getFirstFormat(assetExtractor, "video/");
            if (firstFormat != null && firstFormat.containsKey("rotation-degrees")) {
                int integer = firstFormat.getInteger("rotation-degrees") / 90;
                AppMethodBeat.o(218506);
                return integer;
            }
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(218506);
        return 0;
    }

    public static void applyMirror(Matrix matrix, int i2, int i3, int i4) {
        AppMethodBeat.i(218507);
        if (matrix == null) {
            AppMethodBeat.o(218507);
            return;
        }
        Matrix matrix2 = new Matrix();
        switch (i2) {
            case 1:
                matrix2.postScale(-1.0f, 1.0f);
                matrix2.postTranslate((float) i3, 0.0f);
                break;
            case 2:
                matrix2.postScale(1.0f, -1.0f);
                matrix2.postTranslate(0.0f, (float) i4);
                break;
            case 3:
                matrix2.postScale(-1.0f, -1.0f);
                matrix2.postTranslate((float) i3, (float) i4);
                break;
        }
        matrix.postConcat(matrix2);
        AppMethodBeat.o(218507);
    }

    public static int getFrameRate(MediaFormat mediaFormat) {
        AppMethodBeat.i(218508);
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey("frame-rate")) {
                    int integer = mediaFormat.getInteger("frame-rate");
                    AppMethodBeat.o(218508);
                    return integer;
                }
            } catch (Error | Exception e2) {
            }
        }
        AppMethodBeat.o(218508);
        return 0;
    }

    public static boolean isSameExtractor(DecoderAssetTrack decoderAssetTrack, DecoderAssetTrack decoderAssetTrack2) {
        boolean z;
        AppMethodBeat.i(218509);
        if (decoderAssetTrack == null || decoderAssetTrack2 == null) {
            z = false;
        } else {
            z = true;
        }
        if (!z || decoderAssetTrack.assetPath == null || !decoderAssetTrack.assetPath.equals(decoderAssetTrack2.assetPath)) {
            AppMethodBeat.o(218509);
            return false;
        }
        AppMethodBeat.o(218509);
        return true;
    }
}
