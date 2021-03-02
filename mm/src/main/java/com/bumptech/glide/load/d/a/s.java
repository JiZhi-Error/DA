package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class s<T> implements j<T, Bitmap> {
    public static final h<Long> aLA = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new h.a<Long>() {
        /* class com.bumptech.glide.load.d.a.s.AnonymousClass1 */
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        {
            AppMethodBeat.i(77439);
            AppMethodBeat.o(77439);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // com.bumptech.glide.load.h.a
        public final /* synthetic */ void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            AppMethodBeat.i(77440);
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                try {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putLong(l2.longValue()).array());
                } finally {
                    AppMethodBeat.o(77440);
                }
            }
        }
    });
    public static final h<Integer> aLB = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new h.a<Integer>() {
        /* class com.bumptech.glide.load.d.a.s.AnonymousClass2 */
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        {
            AppMethodBeat.i(77441);
            AppMethodBeat.o(77441);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // com.bumptech.glide.load.h.a
        public final /* synthetic */ void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            AppMethodBeat.i(77442);
            Integer num2 = num;
            if (num2 != null) {
                messageDigest.update(bArr);
                synchronized (this.buffer) {
                    try {
                        this.buffer.position(0);
                        messageDigest.update(this.buffer.putInt(num2.intValue()).array());
                    } finally {
                        AppMethodBeat.o(77442);
                    }
                }
                return;
            }
            AppMethodBeat.o(77442);
        }
    });
    private static final b aLC = new b();
    private final e aCj;
    private final c<T> aLD;
    private final b aLE;

    interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static {
        AppMethodBeat.i(77449);
        AppMethodBeat.o(77449);
    }

    public static j<AssetFileDescriptor, Bitmap> a(e eVar) {
        AppMethodBeat.i(77445);
        s sVar = new s(eVar, new a((byte) 0));
        AppMethodBeat.o(77445);
        return sVar;
    }

    public static j<ParcelFileDescriptor, Bitmap> b(e eVar) {
        AppMethodBeat.i(77446);
        s sVar = new s(eVar, new d());
        AppMethodBeat.o(77446);
        return sVar;
    }

    private s(e eVar, c<T> cVar) {
        this(eVar, cVar, aLC);
    }

    private s(e eVar, c<T> cVar, b bVar) {
        this.aCj = eVar;
        this.aLD = cVar;
        this.aLE = bVar;
    }

    @Override // com.bumptech.glide.load.j
    public final boolean a(T t, i iVar) {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: com.bumptech.glide.load.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.j
    public final v<Bitmap> a(T t, int i2, int i3, i iVar) {
        Integer num;
        g gVar;
        AppMethodBeat.i(77447);
        long longValue = ((Long) iVar.a(aLA)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num2 = (Integer) iVar.a(aLB);
            if (num2 == null) {
                num = 2;
            } else {
                num = num2;
            }
            g gVar2 = (g) iVar.a(g.aKY);
            if (gVar2 == null) {
                gVar = g.aKX;
            } else {
                gVar = gVar2;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.aLD.a(mediaMetadataRetriever, t);
                int intValue = num.intValue();
                Bitmap bitmap = null;
                if (!(Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || gVar == g.aKW)) {
                    bitmap = a(mediaMetadataRetriever, longValue, intValue, i2, i3, gVar);
                }
                if (bitmap == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, intValue);
                }
                mediaMetadataRetriever.release();
                d a2 = d.a(bitmap, this.aCj);
                AppMethodBeat.o(77447);
                return a2;
            } catch (RuntimeException e2) {
                IOException iOException = new IOException(e2);
                AppMethodBeat.o(77447);
                throw iOException;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                AppMethodBeat.o(77447);
                throw th;
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(longValue)));
            AppMethodBeat.o(77447);
            throw illegalArgumentException;
        }
    }

    @TargetApi(27)
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, g gVar) {
        int i5;
        int i6;
        AppMethodBeat.i(77448);
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                i6 = parseInt;
                i5 = parseInt2;
            } else {
                i6 = parseInt2;
                i5 = parseInt;
            }
            float l = gVar.l(i5, i6, i3, i4);
            Bitmap scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) i5) * l), Math.round(((float) i6) * l));
            AppMethodBeat.o(77448);
            return scaledFrameAtTime;
        } catch (Throwable th) {
            Log.isLoggable("VideoDecoder", 3);
            AppMethodBeat.o(77448);
            return null;
        }
    }

    static class b {
        b() {
        }
    }

    static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.media.MediaMetadataRetriever, java.lang.Object] */
        @Override // com.bumptech.glide.load.d.a.s.c
        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AppMethodBeat.i(77443);
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
            AppMethodBeat.o(77443);
        }
    }

    static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.media.MediaMetadataRetriever, java.lang.Object] */
        @Override // com.bumptech.glide.load.d.a.s.c
        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            AppMethodBeat.i(77444);
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
            AppMethodBeat.o(77444);
        }
    }
}
