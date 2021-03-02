package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Environment;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TAVGLUtils {
    private static final String TAG = "TAVGLUtils";
    private static final String TAV_DEBUG_IMAGE_DIR = (Environment.getExternalStorageDirectory().getPath() + "/TAV调试图片");

    static {
        AppMethodBeat.i(197335);
        AppMethodBeat.o(197335);
    }

    public static Bitmap saveBitmap(int i2, int i3, int i4) {
        AppMethodBeat.i(197325);
        Bitmap saveBitmap = saveBitmap(i2, 3553, i3, i4);
        AppMethodBeat.o(197325);
        return saveBitmap;
    }

    public static Bitmap saveBitmap(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(197326);
        Bitmap saveBitmap = saveBitmap(new TextureInfo(i2, i3, i4, i5, 0));
        AppMethodBeat.o(197326);
        return saveBitmap;
    }

    public static Bitmap saveBitmap(CIImage cIImage) {
        AppMethodBeat.i(197327);
        TextureInfo newTextureInfo = CIContext.newTextureInfo(cIImage.getSize().width, cIImage.getSize().height);
        CIImageFilter cIImageFilter = new CIImageFilter();
        cIImageFilter.setOutputTextureInfo(newTextureInfo);
        cIImage.draw(cIImageFilter);
        Bitmap saveBitmap = saveBitmap(newTextureInfo);
        AppMethodBeat.o(197327);
        return saveBitmap;
    }

    public static Bitmap saveBitmap(TextureInfo textureInfo) {
        AppMethodBeat.i(197328);
        TextureInfo checkTextureInfo = checkTextureInfo(textureInfo);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, checkTextureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(checkTextureInfo.width * checkTextureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, checkTextureInfo.width, checkTextureInfo.height, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(checkTextureInfo.width, checkTextureInfo.height, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        AppMethodBeat.o(197328);
        return createBitmap;
    }

    private static TextureInfo checkTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(197329);
        if (textureInfo.textureType == 3553) {
            AppMethodBeat.o(197329);
            return textureInfo;
        }
        TextureInfo textureInfo2 = new TextureInfo(RenderContext.createTexture(3553), 3553, textureInfo.width, textureInfo.height, null, 0);
        TextureFilter textureFilter = new TextureFilter();
        textureFilter.setOutputTextureInfo(textureInfo2);
        textureFilter.applyFilter(textureInfo, null, textureInfo.getTextureMatrix(), 1.0f, null);
        AppMethodBeat.o(197329);
        return textureInfo2;
    }

    public static void saveBitmapToFile(TextureInfo textureInfo) {
        AppMethodBeat.i(197330);
        saveBitmapToFile(textureInfo, newDebugImageFile(textureInfo.textureID, textureInfo.width, textureInfo.height));
        AppMethodBeat.o(197330);
    }

    public static File newDebugImageFile(int i2, int i3, int i4) {
        AppMethodBeat.i(197331);
        String str = Long.toHexString(System.currentTimeMillis()) + "_id=" + i2 + "_" + i3 + "_" + i4 + ".png";
        File file = new File(TAV_DEBUG_IMAGE_DIR);
        if (file.exists() || file.mkdir()) {
            File file2 = new File(TAV_DEBUG_IMAGE_DIR, str);
            AppMethodBeat.o(197331);
            return file2;
        }
        RuntimeException runtimeException = new RuntimeException("mkdir return false, path = " + file.getAbsolutePath());
        AppMethodBeat.o(197331);
        throw runtimeException;
    }

    public static void saveBitmapToFile(TextureInfo textureInfo, File file) {
        AppMethodBeat.i(197332);
        saveBitmapToFile(saveBitmap(textureInfo), file);
        AppMethodBeat.o(197332);
    }

    public static void saveBitmapToFile(Bitmap bitmap) {
        AppMethodBeat.i(197333);
        saveBitmapToFile(bitmap, newDebugImageFile(0, bitmap.getWidth(), bitmap.getHeight()));
        AppMethodBeat.o(197333);
    }

    public static void saveBitmapToFile(Bitmap bitmap, File file) {
        AppMethodBeat.i(197334);
        if (!file.createNewFile()) {
            RuntimeException runtimeException = new RuntimeException("createNewFile return false, path = " + file.getAbsolutePath());
            AppMethodBeat.o(197334);
            throw runtimeException;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArray);
        fileOutputStream.flush();
        fileOutputStream.close();
        AppMethodBeat.o(197334);
    }
}
