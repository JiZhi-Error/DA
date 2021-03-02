package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;

public class DecoderUtils {
    public static final String MIME_AUDIO = "audio/";
    public static final String MIME_VIDEO = "video/";
    public static final int TIMEOUT_US = 1000;

    public static int getFirstTrackIndex(AssetExtractor assetExtractor, String str) {
        AppMethodBeat.i(218150);
        try {
            int trackCount = assetExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                if (assetExtractor.getTrackFormat(i2).getString("mime").startsWith(str)) {
                    AppMethodBeat.o(218150);
                    return i2;
                }
            }
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(218150);
        return -1;
    }

    public static MediaFormat getFirstFormat(AssetExtractor assetExtractor, String str) {
        AppMethodBeat.i(218151);
        try {
            int trackCount = assetExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = assetExtractor.getTrackFormat(i2);
                if (trackFormat.getString("mime").startsWith(str)) {
                    AppMethodBeat.o(218151);
                    return trackFormat;
                }
            }
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(218151);
        return null;
    }

    public static long getDuration(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218152);
        try {
            int trackCount = assetExtractor.getTrackCount();
            long j2 = 0;
            long j3 = 0;
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = assetExtractor.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith("video/")) {
                    if (trackFormat.containsKey("durationUs")) {
                        j3 = trackFormat.getLong("durationUs");
                    }
                } else if (string.startsWith("audio/") && trackFormat.containsKey("durationUs")) {
                    j2 = trackFormat.getLong("durationUs");
                }
            }
            if (j3 > 0) {
                AppMethodBeat.o(218152);
                return j3;
            }
            AppMethodBeat.o(218152);
            return j2;
        } catch (Error | Exception e2) {
            AppMethodBeat.o(218152);
            return 0;
        }
    }

    public static long getAudioDuration(AssetExtractor assetExtractor) {
        AppMethodBeat.i(218153);
        try {
            int trackCount = assetExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = assetExtractor.getTrackFormat(i2);
                if (trackFormat.getString("mime").startsWith("audio/") && trackFormat.containsKey("durationUs")) {
                    long j2 = trackFormat.getLong("durationUs");
                    AppMethodBeat.o(218153);
                    return j2;
                }
            }
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(218153);
        return 0;
    }

    public static long getDuration(String str) {
        AppMethodBeat.i(218154);
        try {
            AssetExtractor assetExtractor = new AssetExtractor();
            assetExtractor.setDataSource(str);
            long duration = getDuration(assetExtractor);
            try {
                assetExtractor.release();
            } catch (Error | Exception e2) {
            }
            AppMethodBeat.o(218154);
            return duration;
        } catch (Error | Exception e3) {
            AppMethodBeat.o(218154);
            return 0;
        }
    }

    public static Rectangle getMatrixAndCropRect(CGSize cGSize, int i2, float f2, float f3, Point point, Matrix matrix) {
        Rectangle rectangle;
        AppMethodBeat.i(218155);
        while (i2 < 0) {
            i2 += 4;
        }
        int i3 = i2 % 4;
        getRotationMatrix(matrix, i3, cGSize.width, cGSize.height);
        CGSize transformedSize = getTransformedSize(cGSize, i3, f3);
        if (f3 > 0.0f || f2 > 1.0f) {
            CGSize cGSize2 = new CGSize();
            if (i3 % 2 == 1) {
                cGSize2.width = cGSize.height;
                cGSize2.height = cGSize.width;
            } else {
                cGSize2.width = cGSize.width;
                cGSize2.height = cGSize.height;
            }
            float f4 = 0.0f;
            float f5 = 0.0f;
            if (transformedSize.width != cGSize2.width) {
                f4 = (cGSize2.width - transformedSize.width) * 0.5f;
            } else if (transformedSize.height != cGSize2.height) {
                f5 = (cGSize2.height - transformedSize.height) * 0.5f;
            }
            Matrix matrix2 = new Matrix();
            matrix2.setTranslate(-f4, -f5);
            float f6 = transformedSize.width;
            float f7 = (f2 - 1.0f) / f2;
            float f8 = (((-transformedSize.width) * 0.5f) * f7) - ((float) point.x);
            float f9 = (((-transformedSize.height) * 0.5f) * f7) - ((float) point.y);
            Matrix matrix3 = new Matrix();
            matrix3.setTranslate(f8, f9);
            float f10 = f4 - f8;
            float f11 = f5 - f9;
            matrix2.postConcat(matrix3);
            matrix2.postScale(f2, f2);
            Matrix matrix4 = new Matrix();
            matrix.invert(matrix4);
            RectF rectF = new RectF(f10, f11, (f6 / f2) + f10, (transformedSize.height / f2) + f11);
            matrix4.mapRect(rectF);
            rectangle = new Rectangle(rectF.left, rectF.top, rectF.width(), rectF.height());
            if (rectangle.x < 0.0f) {
                rectangle.width += rectangle.x;
                rectangle.x = 0.0f;
            }
            if (rectangle.y < 0.0f) {
                rectangle.height += rectangle.y;
                rectangle.y = 0.0f;
            }
            if (rectangle.x + rectangle.width > cGSize.width) {
                rectangle.width = cGSize2.width - rectangle.x;
            }
            if (rectangle.y + rectangle.height > cGSize.height) {
                rectangle.height = cGSize2.height - rectangle.y;
            }
            matrix.postConcat(matrix2);
        } else {
            rectangle = null;
        }
        AppMethodBeat.o(218155);
        return rectangle;
    }

    public static CGSize getTransformedSize(CGSize cGSize, int i2, float f2) {
        AppMethodBeat.i(218156);
        CGSize clone = cGSize.clone();
        if (Math.abs(i2) % 2 == 1) {
            float f3 = clone.width;
            clone.width = clone.height;
            clone.height = f3;
        }
        if (f2 > 0.0f) {
            if ((clone.width * 1.0f) / clone.height > f2) {
                clone.width = (float) ((int) Math.ceil((double) (clone.height * f2)));
            } else {
                clone.height = (float) ((int) Math.ceil((double) ((clone.width * 1.0f) / f2)));
            }
        }
        AppMethodBeat.o(218156);
        return clone;
    }

    public static void getRotationMatrix(Matrix matrix, int i2, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        AppMethodBeat.i(218157);
        int i3 = i2 % 4;
        if (i3 < 0) {
            i3 += 4;
        }
        switch (i3) {
            case 1:
                f4 = 0.0f;
                f5 = f3;
                f6 = 0.0f;
                f7 = -1.0f;
                f8 = 1.0f;
                f9 = 0.0f;
                break;
            case 2:
                f4 = f3;
                f5 = f2;
                f6 = -1.0f;
                f7 = 0.0f;
                f8 = 0.0f;
                f9 = -1.0f;
                break;
            case 3:
                f4 = f2;
                f5 = 0.0f;
                f6 = 0.0f;
                f7 = 1.0f;
                f8 = -1.0f;
                f9 = 0.0f;
                break;
            default:
                f4 = 0.0f;
                f5 = 0.0f;
                f6 = 1.0f;
                f7 = 0.0f;
                f8 = 0.0f;
                f9 = 1.0f;
                break;
        }
        matrix.setValues(new float[]{f9, f7, f5, f8, f6, f4, 0.0f, 0.0f, 1.0f});
        AppMethodBeat.o(218157);
    }

    private static void swap(float[] fArr, int i2, int i3) {
        float f2 = fArr[i2];
        fArr[i2] = fArr[i3];
        fArr[i3] = f2;
    }

    public static float[] toOpenGL2DMatrix(Matrix matrix) {
        AppMethodBeat.i(218158);
        float[] fArr = new float[9];
        if (matrix == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                fArr[i2] = i2 % 4 == 0 ? 1.0f : 0.0f;
            }
        } else {
            matrix.getValues(fArr);
            swap(fArr, 1, 3);
            swap(fArr, 2, 6);
            swap(fArr, 5, 7);
        }
        AppMethodBeat.o(218158);
        return fArr;
    }

    public static long getAudioDuration(long j2, int i2, int i3) {
        return (TimeUtil.SECOND_TO_US * j2) / ((long) ((i2 * 2) * i3));
    }

    public static ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(218159);
        if (Build.VERSION.SDK_INT < 21) {
            ByteBuffer byteBuffer = mediaCodec.getOutputBuffers()[i2];
            AppMethodBeat.o(218159);
            return byteBuffer;
        }
        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i2);
        AppMethodBeat.o(218159);
        return outputBuffer;
    }

    public static ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(218160);
        if (Build.VERSION.SDK_INT < 21) {
            ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[i2];
            AppMethodBeat.o(218160);
            return byteBuffer;
        }
        ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i2);
        AppMethodBeat.o(218160);
        return inputBuffer;
    }

    public static Matrix getPreferMatrix(CGSize cGSize, CGSize cGSize2, int i2) {
        AppMethodBeat.i(218161);
        Matrix matrix = new Matrix();
        getMatrixAndCropRect(cGSize2, i2, 1.0f, 0.0f, new Point(0, 0), matrix);
        Matrix matrix2 = new Matrix();
        CGSize transformedSize = getTransformedSize(cGSize2, i2, 0.0f);
        if ((transformedSize.width * 1.0f) / cGSize.width > (1.0f * transformedSize.height) / cGSize.height) {
            float f2 = cGSize.width / transformedSize.width;
            matrix2.setScale(f2, f2);
            matrix2.postTranslate(0.0f, (float) Math.round((cGSize.height - (transformedSize.height * f2)) * 0.5f));
        } else {
            float f3 = cGSize.height / transformedSize.height;
            matrix2.setScale(f3, f3);
            matrix2.postTranslate((float) Math.round((cGSize.width - (transformedSize.width * f3)) * 0.5f), 0.0f);
        }
        matrix.postConcat(matrix2);
        AppMethodBeat.o(218161);
        return matrix;
    }
}
