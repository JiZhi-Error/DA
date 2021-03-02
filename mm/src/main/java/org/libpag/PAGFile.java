package org.libpag;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGFile extends PAGComposition {
    private static native PAGFile LoadFromAssets(AssetManager assetManager, String str);

    private static native PAGFile LoadFromBytes(byte[] bArr, int i2);

    private static native PAGFile LoadFromPath(String str);

    public static native int MaxSupportedTagLevel();

    private static final native void nativeInit();

    public native PAGFile copyOriginal();

    public native PAGLayer[] getLayersByEditableIndex(int i2, int i3);

    public native PAGText getTextData(int i2);

    public native void nativeReplaceImage(int i2, long j2);

    public native int numImages();

    public native int numTexts();

    public native int numVideos();

    public native String path();

    public native void replaceText(int i2, PAGText pAGText);

    public native void setDuration(long j2);

    public native void setTimeStretchMode(int i2);

    public native int tagLevel();

    public native int timeStretchMode();

    public static PAGFile Load(String str) {
        AppMethodBeat.i(236858);
        PAGFile LoadFromPath = LoadFromPath(str);
        AppMethodBeat.o(236858);
        return LoadFromPath;
    }

    public static PAGFile Load(byte[] bArr) {
        AppMethodBeat.i(236859);
        PAGFile LoadFromBytes = LoadFromBytes(bArr, bArr.length);
        AppMethodBeat.o(236859);
        return LoadFromBytes;
    }

    public static PAGFile Load(AssetManager assetManager, String str) {
        AppMethodBeat.i(236860);
        PAGFile LoadFromAssets = LoadFromAssets(assetManager, str);
        AppMethodBeat.o(236860);
        return LoadFromAssets;
    }

    private PAGFile(long j2) {
        super(j2);
    }

    public void replaceImage(int i2, PAGImage pAGImage) {
        AppMethodBeat.i(236861);
        if (pAGImage == null) {
            nativeReplaceImage(i2, 0);
            AppMethodBeat.o(236861);
            return;
        }
        nativeReplaceImage(i2, pAGImage.nativeContext);
        AppMethodBeat.o(236861);
    }

    static {
        AppMethodBeat.i(236862);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236862);
    }
}
