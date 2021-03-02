package com.tencent.mm.media.widget.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.Type;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/Camera2ImageSaver;", "Ljava/lang/Runnable;", "renderHelper", "Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "screenSize", "Landroid/graphics/Point;", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "", "image", "Landroid/media/Image;", "imageReadyCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;Landroid/graphics/Point;ZLandroid/media/Image;Lkotlin/jvm/functions/Function1;)V", "convertBitmapUseRenderScript", "srcHeight", "", "srcWidth", "convertBitmapUseRenderScriptUsePacketYUV", "convertBitmapUseYuvImage", "stream", "Ljava/io/ByteArrayOutputStream;", "getDataFromImage", "", "imageToByteBuffer", "Ljava/nio/ByteBuffer;", "run", "Companion", "plugin-mediaeditor_release"})
public final class a implements Runnable {
    private static final String TAG = TAG;
    public static final C0427a inb = new C0427a((byte) 0);
    private final d imN;
    private final Point imX;
    private final boolean imY;
    private final Image imZ;
    private final b<Bitmap, x> ina;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.g.a.b<? super android.graphics.Bitmap, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(d dVar, Point point, boolean z, Image image, b<? super Bitmap, x> bVar) {
        p.h(point, "screenSize");
        p.h(image, "image");
        p.h(bVar, "imageReadyCallback");
        AppMethodBeat.i(94071);
        this.imN = dVar;
        this.imX = point;
        this.imY = z;
        this.imZ = image;
        this.ina = bVar;
        AppMethodBeat.o(94071);
    }

    public final void run() {
        Bitmap a2;
        AppMethodBeat.i(94068);
        boolean aRH = com.tencent.mm.media.widget.d.b.aRH();
        try {
            int width = this.imZ.getWidth();
            int height = this.imZ.getHeight();
            if (aRH) {
                Image image = this.imZ;
                if (this.imN == null) {
                    Log.e(TAG, "a error happened when use rs and does not init rs helper");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    a2 = a(image, width, height, byteArrayOutputStream);
                    byteArrayOutputStream.close();
                } else {
                    long currentTicks = Util.currentTicks();
                    int width2 = image.getWidth();
                    float ceil = (float) Math.ceil((double) ((((float) image.getHeight()) - (((float) width2) * (((float) this.imX.x) / ((float) this.imX.y)))) / 2.0f));
                    Image.Plane[] planes = image.getPlanes();
                    byte[][] bArr = new byte[3][];
                    for (int i2 = 0; i2 < 3; i2++) {
                        Image.Plane plane = planes[i2];
                        p.g(plane, "planes[it]");
                        ByteBuffer buffer = plane.getBuffer();
                        byte[] bArr2 = new byte[buffer.capacity()];
                        buffer.get(bArr2);
                        bArr[i2] = bArr2;
                    }
                    byte[][] bArr3 = bArr;
                    long currentTicks2 = Util.currentTicks();
                    d dVar = this.imN;
                    Image.Plane[] planes2 = image.getPlanes();
                    p.g(planes2, "image.planes");
                    int i3 = (int) ceil;
                    p.h(planes2, "planes");
                    p.h(bArr3, "yuvBytes");
                    int rowStride = planes2[0].getRowStride();
                    int rowStride2 = planes2[1].getRowStride();
                    int pixelStride = planes2[1].getPixelStride();
                    Type.Builder builder = new Type.Builder(dVar.inZ, Element.U8(dVar.inZ));
                    builder.setX(rowStride).setY(bArr3[0].length / rowStride);
                    Allocation createTyped = Allocation.createTyped(dVar.inZ, builder.create());
                    createTyped.copyFrom(bArr3[0]);
                    c cVar = dVar.inY;
                    if (cVar != null) {
                        cVar.b(createTyped);
                    }
                    Type.Builder builder2 = new Type.Builder(dVar.inZ, Element.U8(dVar.inZ));
                    builder2.setX(bArr3[1].length);
                    Allocation createTyped2 = Allocation.createTyped(dVar.inZ, builder2.create());
                    createTyped2.copyFrom(bArr3[1]);
                    c cVar2 = dVar.inY;
                    if (cVar2 != null) {
                        cVar2.c(createTyped2);
                    }
                    Allocation createTyped3 = Allocation.createTyped(dVar.inZ, builder2.create());
                    createTyped3.copyFrom(bArr3[2]);
                    c cVar3 = dVar.inY;
                    if (cVar3 != null) {
                        cVar3.d(createTyped3);
                    }
                    c cVar4 = dVar.inY;
                    if (cVar4 != null) {
                        cVar4.Up();
                    }
                    c cVar5 = dVar.inY;
                    if (cVar5 != null) {
                        cVar5.bl((long) i3);
                    }
                    c cVar6 = dVar.inY;
                    if (cVar6 != null) {
                        cVar6.bn((long) rowStride2);
                    }
                    c cVar7 = dVar.inY;
                    if (cVar7 != null) {
                        cVar7.bm((long) pixelStride);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(width + 0, height - (i3 * 2), Bitmap.Config.ARGB_8888);
                    Allocation createFromBitmap = Allocation.createFromBitmap(dVar.inZ, createBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                    c cVar8 = dVar.inY;
                    if (cVar8 != null) {
                        cVar8.e(createFromBitmap);
                    }
                    createFromBitmap.copyTo(createBitmap);
                    createTyped.destroy();
                    createTyped2.destroy();
                    createTyped3.destroy();
                    createFromBitmap.destroy();
                    p.g(createBitmap, "bmp");
                    Log.i(TAG, "op1 cost " + Util.ticksToNow(currentTicks2));
                    if (this.imY) {
                        long currentTicks3 = Util.currentTicks();
                        Bitmap f2 = this.imN.f(createBitmap, 90);
                        Log.i(TAG, "op2 cost " + Util.ticksToNow(currentTicks3));
                        long currentTicks4 = Util.currentTicks();
                        d dVar2 = this.imN;
                        p.h(f2, "bitmap");
                        c cVar9 = dVar2.inY;
                        if (cVar9 != null) {
                            cVar9.iA(f2.getWidth());
                        }
                        c cVar10 = dVar2.inY;
                        if (cVar10 != null) {
                            cVar10.iB(f2.getHeight());
                        }
                        Allocation createFromBitmap2 = Allocation.createFromBitmap(dVar2.inZ, f2, Allocation.MipmapControl.MIPMAP_NONE, 1);
                        f2.recycle();
                        c cVar11 = dVar2.inY;
                        if (cVar11 != null) {
                            cVar11.a(createFromBitmap2);
                        }
                        a2 = Bitmap.createBitmap(f2.getWidth(), f2.getHeight(), f2.getConfig());
                        Allocation createFromBitmap3 = Allocation.createFromBitmap(dVar2.inZ, a2, Allocation.MipmapControl.MIPMAP_NONE, 1);
                        c cVar12 = dVar2.inY;
                        if (cVar12 != null) {
                            cVar12.c(createFromBitmap3, createFromBitmap3);
                        }
                        createFromBitmap3.copyTo(a2);
                        createFromBitmap3.destroy();
                        createFromBitmap2.destroy();
                        p.g(a2, "target");
                        Log.i(TAG, "op3 cost " + Util.ticksToNow(currentTicks4));
                        Log.i(TAG, "newFunc cost ".concat(String.valueOf(Util.ticksToNow(currentTicks))));
                    } else {
                        long currentTicks5 = Util.currentTicks();
                        a2 = this.imN.f(createBitmap, 270);
                        Log.i(TAG, "op4 cost " + Util.ticksToNow(currentTicks5));
                        Log.i(TAG, "newFunc cost ".concat(String.valueOf(Util.ticksToNow(currentTicks))));
                    }
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                a2 = a(this.imZ, width, height, byteArrayOutputStream2);
                byteArrayOutputStream2.close();
            }
            this.ina.invoke(a2);
        } catch (Exception e2) {
            Log.e(TAG, "take photo use image stream error", e2.getLocalizedMessage());
        } finally {
            this.imZ.close();
            AppMethodBeat.o(94068);
        }
    }

    private final Bitmap a(Image image, int i2, int i3, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(94069);
        byte[] e2 = d.e(a(image), i2, i3, 90);
        p.g(e2, "MMSightUtil.rotateNv21(y… srcHeight, srcWidth, 90)");
        if (this.imY) {
            SightVideoJNI.mirrorCameraData(e2, i3, i2, true);
        }
        float f2 = ((float) i2) * (((float) this.imX.x) / ((float) this.imX.y));
        float f3 = (((float) i3) - f2) / 2.0f;
        new YuvImage(e2, 17, i3, i2, null).compressToJpeg(new Rect((int) f3, 0, (int) (f2 + f3), i2), 100, byteArrayOutputStream);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        p.g(decodeByteArray, "BitmapFactory.decodeByte…rray(), 0, stream.size())");
        AppMethodBeat.o(94069);
        return decodeByteArray;
    }

    private static byte[] a(Image image) {
        int i2;
        AppMethodBeat.i(94070);
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(format) * (width * height)) / 8)];
        Image.Plane plane = planes[0];
        p.g(plane, "planes[0]");
        byte[] bArr2 = new byte[plane.getRowStride()];
        int i3 = 0;
        int i4 = 1;
        p.g(planes, "planes");
        int length = planes.length;
        int i5 = 0;
        while (i5 < length) {
            switch (i5) {
                case 0:
                    i3 = 0;
                    i4 = 1;
                    break;
                case 1:
                    i3 = (width * height) + 1;
                    i4 = 2;
                    break;
                case 2:
                    i3 = width * height;
                    i4 = 2;
                    break;
            }
            Image.Plane plane2 = planes[i5];
            p.g(plane2, "planes[i]");
            ByteBuffer buffer = plane2.getBuffer();
            Image.Plane plane3 = planes[i5];
            p.g(plane3, "planes[i]");
            int rowStride = plane3.getRowStride();
            Image.Plane plane4 = planes[i5];
            p.g(plane4, "planes[i]");
            int pixelStride = plane4.getPixelStride();
            int i6 = i5 == 0 ? 0 : 1;
            int i7 = width >> i6;
            int i8 = height >> i6;
            buffer.position(((cropRect.left >> i6) * pixelStride) + ((cropRect.top >> i6) * rowStride));
            int i9 = i3;
            for (int i10 = 0; i10 < i8; i10++) {
                if (pixelStride == 1 && i4 == 1) {
                    buffer.get(bArr, i9, i7);
                    i9 += i7;
                    i2 = i7;
                } else {
                    i2 = ((i7 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i11 = 0; i11 < i7; i11++) {
                        bArr[i9] = bArr2[i11 * pixelStride];
                        i9 += i4;
                    }
                }
                if (i10 < i8 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
            }
            i5++;
            i3 = i9;
        }
        AppMethodBeat.o(94070);
        return bArr;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/Camera2ImageSaver$Companion;", "", "()V", "TAG", "", "getOutputMediaFile", "Lcom/tencent/mm/vfs/VFSFile;", "type", "", FirebaseAnalytics.b.INDEX, "saveBitmapToSdCardStorage", "", "bmp", "Landroid/graphics/Bitmap;", "saveYuvToSdCardStorage", "imageData", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.b.a$a  reason: collision with other inner class name */
    public static final class C0427a {
        private C0427a() {
        }

        public /* synthetic */ C0427a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(94072);
        AppMethodBeat.o(94072);
    }
}
