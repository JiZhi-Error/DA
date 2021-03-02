package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public static final int bqj = x.bJ("ID3");
    private final AbstractC0113a buw;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a  reason: collision with other inner class name */
    public interface AbstractC0113a {
        boolean g(int i2, int i3, int i4, int i5, int i6);
    }

    static {
        AppMethodBeat.i(92443);
        AppMethodBeat.o(92443);
    }

    public a() {
        this(null);
    }

    public a(AbstractC0113a aVar) {
        this.buw = aVar;
    }

    @Override // com.google.android.exoplayer2.metadata.a
    public final Metadata a(d dVar) {
        AppMethodBeat.i(92432);
        ByteBuffer byteBuffer = dVar.aKP;
        Metadata d2 = d(byteBuffer.array(), byteBuffer.limit());
        AppMethodBeat.o(92432);
        return d2;
    }

    public final Metadata d(byte[] bArr, int i2) {
        int i3;
        boolean z;
        AppMethodBeat.i(92433);
        ArrayList arrayList = new ArrayList();
        m mVar = new m(bArr, i2);
        b x = x(mVar);
        if (x == null) {
            AppMethodBeat.o(92433);
            return null;
        }
        int i4 = mVar.position;
        if (x.bux == 2) {
            i3 = 6;
        } else {
            i3 = 10;
        }
        int i5 = x.buz;
        if (x.buy) {
            i5 = f(mVar, x.buz);
        }
        mVar.eY(i5 + i4);
        if (a(mVar, x.bux, i3, false)) {
            z = false;
        } else if (x.bux != 4 || !a(mVar, 4, i3, true)) {
            new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(x.bux);
            AppMethodBeat.o(92433);
            return null;
        } else {
            z = true;
        }
        while (mVar.xd() >= i3) {
            Id3Frame a2 = a(x.bux, mVar, z, i3, this.buw);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Metadata metadata = new Metadata(arrayList);
        AppMethodBeat.o(92433);
        return metadata;
    }

    private static b x(m mVar) {
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(92434);
        if (mVar.xd() < 10) {
            AppMethodBeat.o(92434);
            return null;
        } else if (mVar.xf() != bqj) {
            AppMethodBeat.o(92434);
            return null;
        } else {
            int readUnsignedByte = mVar.readUnsignedByte();
            mVar.eZ(1);
            int readUnsignedByte2 = mVar.readUnsignedByte();
            int xj = mVar.xj();
            if (readUnsignedByte == 2) {
                if ((readUnsignedByte2 & 64) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    AppMethodBeat.o(92434);
                    return null;
                }
                i2 = xj;
            } else if (readUnsignedByte == 3) {
                if ((readUnsignedByte2 & 64) != 0) {
                    int readInt = mVar.readInt();
                    mVar.eZ(readInt);
                    xj -= readInt + 4;
                }
                i2 = xj;
            } else if (readUnsignedByte == 4) {
                if ((readUnsignedByte2 & 64) != 0) {
                    int xj2 = mVar.xj();
                    mVar.eZ(xj2 - 4);
                    xj -= xj2;
                }
                if ((readUnsignedByte2 & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    xj -= 10;
                }
                i2 = xj;
            } else {
                AppMethodBeat.o(92434);
                return null;
            }
            if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            b bVar = new b(readUnsignedByte, z2, i2);
            AppMethodBeat.o(92434);
            return bVar;
        }
    }

    private static Id3Frame a(int i2, m mVar, boolean z, int i3, AbstractC0113a aVar) {
        int xf;
        int i4;
        int i5;
        Id3Frame binaryFrame;
        String str;
        int e2;
        String bH;
        String str2;
        String str3;
        boolean z2;
        AppMethodBeat.i(92436);
        int readUnsignedByte = mVar.readUnsignedByte();
        int readUnsignedByte2 = mVar.readUnsignedByte();
        int readUnsignedByte3 = mVar.readUnsignedByte();
        int readUnsignedByte4 = i2 >= 3 ? mVar.readUnsignedByte() : 0;
        if (i2 == 4) {
            xf = mVar.xk();
            if (!z) {
                xf = (xf & 255) | (((xf >> 8) & 255) << 7) | (((xf >> 16) & 255) << 14) | (((xf >> 24) & 255) << 21);
            }
        } else if (i2 == 3) {
            xf = mVar.xk();
        } else {
            xf = mVar.xf();
        }
        if (i2 >= 3) {
            i4 = mVar.readUnsignedShort();
        } else {
            i4 = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && xf == 0 && i4 == 0) {
            mVar.setPosition(mVar.limit);
            AppMethodBeat.o(92436);
            return null;
        }
        int i6 = mVar.position + xf;
        if (i6 > mVar.limit) {
            mVar.setPosition(mVar.limit);
            AppMethodBeat.o(92436);
            return null;
        } else if (aVar == null || aVar.g(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            if (i2 == 3) {
                boolean z8 = (i4 & 128) != 0;
                z4 = (i4 & 64) != 0;
                if ((i4 & 32) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z6 = z8;
                z7 = z2;
                z3 = z8;
            } else if (i2 == 4) {
                boolean z9 = (i4 & 64) != 0;
                z3 = (i4 & 8) != 0;
                z4 = (i4 & 4) != 0;
                z5 = (i4 & 2) != 0;
                if ((i4 & 1) != 0) {
                    z6 = true;
                    z7 = z9;
                } else {
                    z6 = false;
                    z7 = z9;
                }
            }
            if (z3 || z4) {
                mVar.setPosition(i6);
                AppMethodBeat.o(92436);
                return null;
            }
            if (z7) {
                i5 = xf - 1;
                mVar.eZ(1);
            } else {
                i5 = xf;
            }
            if (z6) {
                i5 -= 4;
                mVar.eZ(4);
            }
            if (z5) {
                i5 = f(mVar, i5);
            }
            if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i2 == 2 || readUnsignedByte4 == 88)) {
                if (i5 <= 0) {
                    binaryFrame = null;
                } else {
                    int readUnsignedByte5 = mVar.readUnsignedByte();
                    String et = et(readUnsignedByte5);
                    byte[] bArr = new byte[(i5 - 1)];
                    mVar.readBytes(bArr, 0, i5 - 1);
                    int h2 = h(bArr, 0, readUnsignedByte5);
                    String str4 = new String(bArr, 0, h2, et);
                    int eu = h2 + eu(readUnsignedByte5);
                    if (eu < bArr.length) {
                        str3 = new String(bArr, eu, h(bArr, eu, readUnsignedByte5) - eu, et);
                    } else {
                        str3 = "";
                    }
                    binaryFrame = new TextInformationFrame("TXXX", str4, str3);
                }
            } else if (readUnsignedByte == 84) {
                String h3 = h(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                if (i5 <= 0) {
                    binaryFrame = null;
                } else {
                    int readUnsignedByte6 = mVar.readUnsignedByte();
                    String et2 = et(readUnsignedByte6);
                    byte[] bArr2 = new byte[(i5 - 1)];
                    mVar.readBytes(bArr2, 0, i5 - 1);
                    binaryFrame = new TextInformationFrame(h3, null, new String(bArr2, 0, h(bArr2, 0, readUnsignedByte6), et2));
                }
            } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i2 == 2 || readUnsignedByte4 == 88)) {
                if (i5 <= 0) {
                    binaryFrame = null;
                } else {
                    int readUnsignedByte7 = mVar.readUnsignedByte();
                    String et3 = et(readUnsignedByte7);
                    byte[] bArr3 = new byte[(i5 - 1)];
                    mVar.readBytes(bArr3, 0, i5 - 1);
                    int h4 = h(bArr3, 0, readUnsignedByte7);
                    String str5 = new String(bArr3, 0, h4, et3);
                    int eu2 = h4 + eu(readUnsignedByte7);
                    if (eu2 < bArr3.length) {
                        str2 = new String(bArr3, eu2, e(bArr3, eu2) - eu2, KindaConfigCacheStg.SAVE_CHARSET);
                    } else {
                        str2 = "";
                    }
                    binaryFrame = new UrlLinkFrame("WXXX", str5, str2);
                }
            } else if (readUnsignedByte == 87) {
                String h5 = h(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                byte[] bArr4 = new byte[i5];
                mVar.readBytes(bArr4, 0, i5);
                binaryFrame = new UrlLinkFrame(h5, null, new String(bArr4, 0, e(bArr4, 0), KindaConfigCacheStg.SAVE_CHARSET));
            } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                byte[] bArr5 = new byte[i5];
                mVar.readBytes(bArr5, 0, i5);
                int e3 = e(bArr5, 0);
                binaryFrame = new PrivFrame(new String(bArr5, 0, e3, KindaConfigCacheStg.SAVE_CHARSET), i(bArr5, e3 + 1, bArr5.length));
            } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i2 == 2)) {
                int readUnsignedByte8 = mVar.readUnsignedByte();
                String et4 = et(readUnsignedByte8);
                byte[] bArr6 = new byte[(i5 - 1)];
                mVar.readBytes(bArr6, 0, i5 - 1);
                int e4 = e(bArr6, 0);
                String str6 = new String(bArr6, 0, e4, KindaConfigCacheStg.SAVE_CHARSET);
                int i7 = e4 + 1;
                int h6 = h(bArr6, i7, readUnsignedByte8);
                String str7 = new String(bArr6, i7, h6 - i7, et4);
                int eu3 = eu(readUnsignedByte8) + h6;
                int h7 = h(bArr6, eu3, readUnsignedByte8);
                binaryFrame = new GeobFrame(str6, str7, new String(bArr6, eu3, h7 - eu3, et4), i(bArr6, eu(readUnsignedByte8) + h7, bArr6.length));
            } else if (i2 != 2 ? readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67 : readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                int readUnsignedByte9 = mVar.readUnsignedByte();
                String et5 = et(readUnsignedByte9);
                byte[] bArr7 = new byte[(i5 - 1)];
                mVar.readBytes(bArr7, 0, i5 - 1);
                if (i2 == 2) {
                    e2 = 2;
                    bH = "image/" + x.bH(new String(bArr7, 0, 3, KindaConfigCacheStg.SAVE_CHARSET));
                    if (bH.equals("image/jpg")) {
                        bH = "image/jpeg";
                    }
                } else {
                    e2 = e(bArr7, 0);
                    bH = x.bH(new String(bArr7, 0, e2, KindaConfigCacheStg.SAVE_CHARSET));
                    if (bH.indexOf(47) == -1) {
                        bH = "image/".concat(String.valueOf(bH));
                    }
                }
                int i8 = e2 + 2;
                int h8 = h(bArr7, i8, readUnsignedByte9);
                binaryFrame = new ApicFrame(bH, new String(bArr7, i8, h8 - i8, et5), bArr7[e2 + 1] & 255, i(bArr7, eu(readUnsignedByte9) + h8, bArr7.length));
            } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i2 == 2)) {
                if (i5 < 4) {
                    binaryFrame = null;
                } else {
                    int readUnsignedByte10 = mVar.readUnsignedByte();
                    String et6 = et(readUnsignedByte10);
                    byte[] bArr8 = new byte[3];
                    mVar.readBytes(bArr8, 0, 3);
                    String str8 = new String(bArr8, 0, 3);
                    byte[] bArr9 = new byte[(i5 - 4)];
                    mVar.readBytes(bArr9, 0, i5 - 4);
                    int h9 = h(bArr9, 0, readUnsignedByte10);
                    String str9 = new String(bArr9, 0, h9, et6);
                    int eu4 = h9 + eu(readUnsignedByte10);
                    if (eu4 < bArr9.length) {
                        str = new String(bArr9, eu4, h(bArr9, eu4, readUnsignedByte10) - eu4, et6);
                    } else {
                        str = "";
                    }
                    binaryFrame = new CommentFrame(str8, str9, str);
                }
            } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                binaryFrame = a(mVar, i5, i2, z, i3, aVar);
            } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                binaryFrame = b(mVar, i5, i2, z, i3, aVar);
            } else {
                String h10 = h(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                byte[] bArr10 = new byte[i5];
                mVar.readBytes(bArr10, 0, i5);
                binaryFrame = new BinaryFrame(h10, bArr10);
            }
            if (binaryFrame == null) {
                try {
                    new StringBuilder("Failed to decode frame: id=").append(h(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)).append(", frameSize=").append(i5);
                } catch (UnsupportedEncodingException e5) {
                    mVar.setPosition(i6);
                    AppMethodBeat.o(92436);
                    return null;
                } catch (Throwable th) {
                    mVar.setPosition(i6);
                    AppMethodBeat.o(92436);
                    throw th;
                }
            }
            mVar.setPosition(i6);
            AppMethodBeat.o(92436);
            return binaryFrame;
        } else {
            mVar.setPosition(i6);
            AppMethodBeat.o(92436);
            return null;
        }
    }

    private static int f(m mVar, int i2) {
        AppMethodBeat.i(92439);
        byte[] bArr = mVar.data;
        int i3 = i2;
        for (int i4 = mVar.position; i4 + 1 < i3; i4++) {
            if ((bArr[i4] & 255) == 255 && bArr[i4 + 1] == 0) {
                System.arraycopy(bArr, i4 + 2, bArr, i4 + 1, (i3 - i4) - 2);
                i3--;
            }
        }
        AppMethodBeat.o(92439);
        return i3;
    }

    private static String et(int i2) {
        switch (i2) {
            case 0:
                return KindaConfigCacheStg.SAVE_CHARSET;
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return MimeTypeUtil.ContentType.DEFAULT_CHARSET;
            default:
                return KindaConfigCacheStg.SAVE_CHARSET;
        }
    }

    private static String h(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(92440);
        if (i2 == 2) {
            String format = String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            AppMethodBeat.o(92440);
            return format;
        }
        String format2 = String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        AppMethodBeat.o(92440);
        return format2;
    }

    private static int h(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92441);
        int e2 = e(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            AppMethodBeat.o(92441);
            return e2;
        }
        while (e2 < bArr.length - 1) {
            if (e2 % 2 == 0 && bArr[e2 + 1] == 0) {
                AppMethodBeat.o(92441);
                return e2;
            }
            e2 = e(bArr, e2 + 1);
        }
        int length = bArr.length;
        AppMethodBeat.o(92441);
        return length;
    }

    private static int e(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static int eu(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static byte[] i(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92442);
        if (i3 <= i2) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(92442);
            return bArr2;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        AppMethodBeat.o(92442);
        return copyOfRange;
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        final int bux;
        final boolean buy;
        final int buz;

        public b(int i2, boolean z, int i3) {
            this.bux = i2;
            this.buy = z;
            this.buz = i3;
        }
    }

    private static boolean a(m mVar, int i2, int i3, boolean z) {
        int xf;
        long xf2;
        int i4;
        long j2;
        boolean z2;
        AppMethodBeat.i(92435);
        int i5 = mVar.position;
        while (mVar.xd() >= i3) {
            try {
                if (i2 >= 3) {
                    xf = mVar.readInt();
                    xf2 = mVar.dE();
                    i4 = mVar.readUnsignedShort();
                } else {
                    xf = mVar.xf();
                    xf2 = (long) mVar.xf();
                    i4 = 0;
                }
                if (xf == 0 && xf2 == 0 && i4 == 0) {
                    mVar.setPosition(i5);
                    AppMethodBeat.o(92435);
                    return true;
                }
                if (i2 != 4 || z) {
                    j2 = xf2;
                } else if ((8421504 & xf2) != 0) {
                    mVar.setPosition(i5);
                    AppMethodBeat.o(92435);
                    return false;
                } else {
                    j2 = (((xf2 >> 24) & 255) << 21) | (255 & xf2) | (((xf2 >> 8) & 255) << 7) | (((xf2 >> 16) & 255) << 14);
                }
                boolean z3 = false;
                if (i2 == 4) {
                    z3 = (i4 & 64) != 0;
                    z2 = (i4 & 1) != 0;
                } else if (i2 == 3) {
                    z3 = (i4 & 32) != 0;
                    z2 = (i4 & 128) != 0;
                } else {
                    z2 = false;
                }
                int i6 = 0;
                if (z3) {
                    i6 = 1;
                }
                if (z2) {
                    i6 += 4;
                }
                if (j2 < ((long) i6)) {
                    mVar.setPosition(i5);
                    AppMethodBeat.o(92435);
                    return false;
                } else if (((long) mVar.xd()) < j2) {
                    mVar.setPosition(i5);
                    AppMethodBeat.o(92435);
                    return false;
                } else {
                    mVar.eZ((int) j2);
                }
            } catch (Throwable th) {
                mVar.setPosition(i5);
                AppMethodBeat.o(92435);
                throw th;
            }
        }
        mVar.setPosition(i5);
        AppMethodBeat.o(92435);
        return true;
    }

    private static ChapterFrame a(m mVar, int i2, int i3, boolean z, int i4, AbstractC0113a aVar) {
        AppMethodBeat.i(92437);
        int i5 = mVar.position;
        int e2 = e(mVar.data, i5);
        String str = new String(mVar.data, i5, e2 - i5, KindaConfigCacheStg.SAVE_CHARSET);
        mVar.setPosition(e2 + 1);
        int readInt = mVar.readInt();
        int readInt2 = mVar.readInt();
        long dE = mVar.dE();
        if (dE == Util.MAX_32BIT_VALUE) {
            dE = -1;
        }
        long dE2 = mVar.dE();
        if (dE2 == Util.MAX_32BIT_VALUE) {
            dE2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = i5 + i2;
        while (mVar.position < i6) {
            Id3Frame a2 = a(i3, mVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterFrame chapterFrame = new ChapterFrame(str, readInt, readInt2, dE, dE2, id3FrameArr);
        AppMethodBeat.o(92437);
        return chapterFrame;
    }

    private static ChapterTocFrame b(m mVar, int i2, int i3, boolean z, int i4, AbstractC0113a aVar) {
        AppMethodBeat.i(92438);
        int i5 = mVar.position;
        int e2 = e(mVar.data, i5);
        String str = new String(mVar.data, i5, e2 - i5, KindaConfigCacheStg.SAVE_CHARSET);
        mVar.setPosition(e2 + 1);
        int readUnsignedByte = mVar.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = mVar.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
            int i7 = mVar.position;
            int e3 = e(mVar.data, i7);
            strArr[i6] = new String(mVar.data, i7, e3 - i7, KindaConfigCacheStg.SAVE_CHARSET);
            mVar.setPosition(e3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i8 = i5 + i2;
        while (mVar.position < i8) {
            Id3Frame a2 = a(i3, mVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterTocFrame chapterTocFrame = new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
        AppMethodBeat.o(92438);
        return chapterTocFrame;
    }
}
