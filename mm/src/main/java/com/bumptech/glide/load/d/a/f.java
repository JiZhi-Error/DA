package com.bumptech.glide.load.d.a;

import android.util.Log;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class f implements ImageHeaderParser {
    static final byte[] aKN = "Exif\u0000\u0000".getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
    private static final int[] aKO = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* access modifiers changed from: package-private */
    public interface c {
        int pA();

        int py();

        short pz();

        int read(byte[] bArr, int i2);

        long skip(long j2);
    }

    static {
        AppMethodBeat.i(77383);
        AppMethodBeat.o(77383);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType c(InputStream inputStream) {
        AppMethodBeat.i(77377);
        ImageHeaderParser.ImageType a2 = a(new d((InputStream) j.checkNotNull(inputStream, "Argument must not be null")));
        AppMethodBeat.o(77377);
        return a2;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        AppMethodBeat.i(77378);
        ImageHeaderParser.ImageType a2 = a(new a((ByteBuffer) j.checkNotNull(byteBuffer, "Argument must not be null")));
        AppMethodBeat.o(77378);
        return a2;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int a(InputStream inputStream, com.bumptech.glide.load.b.a.b bVar) {
        AppMethodBeat.i(77379);
        int a2 = a(new d((InputStream) j.checkNotNull(inputStream, "Argument must not be null")), (com.bumptech.glide.load.b.a.b) j.checkNotNull(bVar, "Argument must not be null"));
        AppMethodBeat.o(77379);
        return a2;
    }

    private static ImageHeaderParser.ImageType a(c cVar) {
        AppMethodBeat.i(77380);
        int py = cVar.py();
        if (py == 65496) {
            ImageHeaderParser.ImageType imageType = ImageHeaderParser.ImageType.JPEG;
            AppMethodBeat.o(77380);
            return imageType;
        }
        int py2 = ((py << 16) & -65536) | (cVar.py() & 65535);
        if (py2 == -1991225785) {
            cVar.skip(21);
            if (cVar.pA() >= 3) {
                ImageHeaderParser.ImageType imageType2 = ImageHeaderParser.ImageType.PNG_A;
                AppMethodBeat.o(77380);
                return imageType2;
            }
            ImageHeaderParser.ImageType imageType3 = ImageHeaderParser.ImageType.PNG;
            AppMethodBeat.o(77380);
            return imageType3;
        } else if ((py2 >> 8) == 4671814) {
            ImageHeaderParser.ImageType imageType4 = ImageHeaderParser.ImageType.GIF;
            AppMethodBeat.o(77380);
            return imageType4;
        } else if (py2 != 1380533830) {
            ImageHeaderParser.ImageType imageType5 = ImageHeaderParser.ImageType.UNKNOWN;
            AppMethodBeat.o(77380);
            return imageType5;
        } else {
            cVar.skip(4);
            if ((((cVar.py() << 16) & -65536) | (cVar.py() & 65535)) != 1464156752) {
                ImageHeaderParser.ImageType imageType6 = ImageHeaderParser.ImageType.UNKNOWN;
                AppMethodBeat.o(77380);
                return imageType6;
            }
            int py3 = ((cVar.py() << 16) & -65536) | (cVar.py() & 65535);
            if ((py3 & -256) != 1448097792) {
                ImageHeaderParser.ImageType imageType7 = ImageHeaderParser.ImageType.UNKNOWN;
                AppMethodBeat.o(77380);
                return imageType7;
            } else if ((py3 & 255) == 88) {
                cVar.skip(4);
                if ((cVar.pA() & 16) != 0) {
                    ImageHeaderParser.ImageType imageType8 = ImageHeaderParser.ImageType.WEBP_A;
                    AppMethodBeat.o(77380);
                    return imageType8;
                }
                ImageHeaderParser.ImageType imageType9 = ImageHeaderParser.ImageType.WEBP;
                AppMethodBeat.o(77380);
                return imageType9;
            } else if ((py3 & 255) == 76) {
                cVar.skip(4);
                if ((cVar.pA() & 8) != 0) {
                    ImageHeaderParser.ImageType imageType10 = ImageHeaderParser.ImageType.WEBP_A;
                    AppMethodBeat.o(77380);
                    return imageType10;
                }
                ImageHeaderParser.ImageType imageType11 = ImageHeaderParser.ImageType.WEBP;
                AppMethodBeat.o(77380);
                return imageType11;
            } else {
                ImageHeaderParser.ImageType imageType12 = ImageHeaderParser.ImageType.WEBP;
                AppMethodBeat.o(77380);
                return imageType12;
            }
        }
    }

    private static int a(c cVar, com.bumptech.glide.load.b.a.b bVar) {
        boolean z;
        int i2;
        int i3 = -1;
        AppMethodBeat.i(77381);
        int py = cVar.py();
        if ((py & 65496) == 65496 || py == 19789 || py == 18761) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            AppMethodBeat.o(77381);
        } else {
            while (true) {
                if (cVar.pz() == 255) {
                    short pz = cVar.pz();
                    if (pz != 218) {
                        if (pz != 217) {
                            int py2 = cVar.py() - 2;
                            if (pz == 225) {
                                i2 = py2;
                                break;
                            }
                            long skip = cVar.skip((long) py2);
                            if (skip != ((long) py2)) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    new StringBuilder("Unable to skip enough data, type: ").append((int) pz).append(", wanted to skip: ").append(py2).append(", but actually skipped: ").append(skip);
                                }
                                i2 = -1;
                            }
                        } else {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            i2 = -1;
                            break;
                        }
                    } else {
                        i2 = -1;
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    i2 = -1;
                    break;
                }
            }
            if (i2 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                AppMethodBeat.o(77381);
            } else {
                byte[] bArr = (byte[]) bVar.a(i2, byte[].class);
                try {
                    int read = cVar.read(bArr, i2);
                    if (read != i2) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Unable to read exif segment data, length: ").append(i2).append(", actually read: ").append(read);
                        }
                    } else if (c(bArr, i2)) {
                        i3 = a(new b(bArr, i2));
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    }
                } finally {
                    bVar.put(bArr);
                    AppMethodBeat.o(77381);
                }
            }
        }
        return i3;
    }

    private static boolean c(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > aKN.length;
        if (z) {
            for (int i3 = 0; i3 < aKN.length; i3++) {
                if (bArr[i3] != aKN[i3]) {
                    return false;
                }
            }
        }
        return z;
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        AppMethodBeat.i(77382);
        switch (bVar.dm(6)) {
            case 18761:
                byteOrder = ByteOrder.LITTLE_ENDIAN;
                break;
            case 19789:
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
            default:
                Log.isLoggable("DfltImageHeaderParser", 3);
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
        }
        bVar.aKP.order(byteOrder);
        int dl = bVar.dl(10) + 6;
        short dm = bVar.dm(dl);
        for (int i2 = 0; i2 < dm; i2++) {
            int i3 = dl + 2 + (i2 * 12);
            short dm2 = bVar.dm(i3);
            if (dm2 == 274) {
                short dm3 = bVar.dm(i3 + 2);
                if (dm3 > 0 && dm3 <= 12) {
                    int dl2 = bVar.dl(i3 + 4);
                    if (dl2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Got tagIndex=").append(i2).append(" tagType=").append((int) dm2).append(" formatCode=").append((int) dm3).append(" componentCount=").append(dl2);
                        }
                        int i4 = aKO[dm3] + dl2;
                        if (i4 <= 4) {
                            int i5 = i3 + 8;
                            if (i5 < 0 || i5 > bVar.aKP.remaining()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    new StringBuilder("Illegal tagValueOffset=").append(i5).append(" tagType=").append((int) dm2);
                                }
                            } else if (i4 >= 0 && i5 + i4 <= bVar.aKP.remaining()) {
                                short dm4 = bVar.dm(i5);
                                AppMethodBeat.o(77382);
                                return dm4;
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                }
            }
        }
        AppMethodBeat.o(77382);
        return -1;
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        final ByteBuffer aKP;

        b(byte[] bArr, int i2) {
            AppMethodBeat.i(77368);
            this.aKP = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
            AppMethodBeat.o(77368);
        }

        /* access modifiers changed from: package-private */
        public final int dl(int i2) {
            AppMethodBeat.i(77369);
            if (aP(i2, 4)) {
                int i3 = this.aKP.getInt(i2);
                AppMethodBeat.o(77369);
                return i3;
            }
            AppMethodBeat.o(77369);
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final short dm(int i2) {
            AppMethodBeat.i(77370);
            if (aP(i2, 2)) {
                short s = this.aKP.getShort(i2);
                AppMethodBeat.o(77370);
                return s;
            }
            AppMethodBeat.o(77370);
            return -1;
        }

        private boolean aP(int i2, int i3) {
            AppMethodBeat.i(77371);
            if (this.aKP.remaining() - i2 >= i3) {
                AppMethodBeat.o(77371);
                return true;
            }
            AppMethodBeat.o(77371);
            return false;
        }
    }

    static final class a implements c {
        private final ByteBuffer byteBuffer;

        a(ByteBuffer byteBuffer2) {
            AppMethodBeat.i(77362);
            this.byteBuffer = byteBuffer2;
            byteBuffer2.order(ByteOrder.BIG_ENDIAN);
            AppMethodBeat.o(77362);
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int py() {
            AppMethodBeat.i(77363);
            int pA = ((pA() << 8) & 65280) | (pA() & 255);
            AppMethodBeat.o(77363);
            return pA;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final short pz() {
            AppMethodBeat.i(77364);
            short pA = (short) (pA() & 255);
            AppMethodBeat.o(77364);
            return pA;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final long skip(long j2) {
            AppMethodBeat.i(77365);
            int min = (int) Math.min((long) this.byteBuffer.remaining(), j2);
            this.byteBuffer.position(this.byteBuffer.position() + min);
            long j3 = (long) min;
            AppMethodBeat.o(77365);
            return j3;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int read(byte[] bArr, int i2) {
            AppMethodBeat.i(77366);
            int min = Math.min(i2, this.byteBuffer.remaining());
            if (min == 0) {
                AppMethodBeat.o(77366);
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            AppMethodBeat.o(77366);
            return min;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int pA() {
            AppMethodBeat.i(77367);
            if (this.byteBuffer.remaining() <= 0) {
                AppMethodBeat.o(77367);
                return -1;
            }
            byte b2 = this.byteBuffer.get();
            AppMethodBeat.o(77367);
            return b2;
        }
    }

    static final class d implements c {
        private final InputStream aKQ;

        d(InputStream inputStream) {
            this.aKQ = inputStream;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int py() {
            AppMethodBeat.i(77372);
            int read = ((this.aKQ.read() << 8) & 65280) | (this.aKQ.read() & 255);
            AppMethodBeat.o(77372);
            return read;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final short pz() {
            AppMethodBeat.i(77373);
            short read = (short) (this.aKQ.read() & 255);
            AppMethodBeat.o(77373);
            return read;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final long skip(long j2) {
            AppMethodBeat.i(77374);
            if (j2 < 0) {
                AppMethodBeat.o(77374);
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.aKQ.skip(j3);
                if (skip <= 0) {
                    if (this.aKQ.read() == -1) {
                        break;
                    }
                    j3--;
                } else {
                    j3 -= skip;
                }
            }
            long j4 = j2 - j3;
            AppMethodBeat.o(77374);
            return j4;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int read(byte[] bArr, int i2) {
            AppMethodBeat.i(77375);
            int i3 = i2;
            while (i3 > 0) {
                int read = this.aKQ.read(bArr, i2 - i3, i3);
                if (read == -1) {
                    break;
                }
                i3 -= read;
            }
            int i4 = i2 - i3;
            AppMethodBeat.o(77375);
            return i4;
        }

        @Override // com.bumptech.glide.load.d.a.f.c
        public final int pA() {
            AppMethodBeat.i(77376);
            int read = this.aKQ.read();
            AppMethodBeat.o(77376);
            return read;
        }
    }
}
