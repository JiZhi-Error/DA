package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzabw {
    private final ByteBuffer zzbwv;

    private zzabw(ByteBuffer byteBuffer) {
        AppMethodBeat.i(40243);
        this.zzbwv = byteBuffer;
        this.zzbwv.order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.o(40243);
    }

    private zzabw(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, i2, i3));
        AppMethodBeat.i(40242);
        AppMethodBeat.o(40242);
    }

    private static int zza(CharSequence charSequence) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(40254);
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 >= length) {
                i2 = i5;
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
                i4++;
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 < 2048) {
                        i3 += (127 - charAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i4) < 65536) {
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4).toString());
                                AppMethodBeat.o(40254);
                                throw illegalArgumentException;
                            }
                            i4++;
                        }
                    }
                    i4++;
                }
                i2 = i3 + i5;
            }
        }
        if (i2 < length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i2) + 4294967296L).toString());
            AppMethodBeat.o(40254);
            throw illegalArgumentException2;
        }
        AppMethodBeat.o(40254);
        return i2;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(40255);
        if (byteBuffer.isReadOnly()) {
            ReadOnlyBufferException readOnlyBufferException = new ReadOnlyBufferException();
            AppMethodBeat.o(40255);
            throw readOnlyBufferException;
        } else if (byteBuffer.hasArray()) {
            try {
                byte[] array = byteBuffer.array();
                int position = byteBuffer.position() + byteBuffer.arrayOffset();
                int remaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i5 = position + remaining;
                int i6 = 0;
                while (i6 < length && i6 + position < i5) {
                    char charAt = charSequence.charAt(i6);
                    if (charAt >= 128) {
                        break;
                    }
                    array[position + i6] = (byte) charAt;
                    i6++;
                }
                if (i6 == length) {
                    i2 = position + length;
                } else {
                    int i7 = position + i6;
                    while (i6 < length) {
                        char charAt2 = charSequence.charAt(i6);
                        if (charAt2 < 128 && i7 < i5) {
                            i3 = i7 + 1;
                            array[i7] = (byte) charAt2;
                        } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                            int i8 = i7 + 1;
                            array[i7] = (byte) ((charAt2 >>> 6) | 960);
                            i3 = i8 + 1;
                            array[i8] = (byte) ((charAt2 & '?') | 128);
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                            int i9 = i7 + 1;
                            array[i7] = (byte) ((charAt2 >>> '\f') | 480);
                            int i10 = i9 + 1;
                            array[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                            i3 = i10 + 1;
                            array[i10] = (byte) ((charAt2 & '?') | 128);
                        } else if (i7 <= i5 - 4) {
                            if (i6 + 1 != charSequence.length()) {
                                i6++;
                                char charAt3 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i11 = i7 + 1;
                                    array[i7] = (byte) ((codePoint >>> 18) | 240);
                                    int i12 = i11 + 1;
                                    array[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i13 = i12 + 1;
                                    array[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i3 = i13 + 1;
                                    array[i13] = (byte) ((codePoint & 63) | 128);
                                }
                            }
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i6 - 1).toString());
                            AppMethodBeat.o(40255);
                            throw illegalArgumentException;
                        } else {
                            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i7).toString());
                            AppMethodBeat.o(40255);
                            throw arrayIndexOutOfBoundsException;
                        }
                        i6++;
                        i7 = i3;
                    }
                    i2 = i7;
                }
                byteBuffer.position(i2 - byteBuffer.arrayOffset());
                AppMethodBeat.o(40255);
            } catch (ArrayIndexOutOfBoundsException e2) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e2);
                AppMethodBeat.o(40255);
                throw bufferOverflowException;
            }
        } else {
            int length2 = charSequence.length();
            while (i4 < length2) {
                char charAt4 = charSequence.charAt(i4);
                if (charAt4 < 128) {
                    byteBuffer.put((byte) charAt4);
                } else if (charAt4 < 2048) {
                    byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else if (charAt4 < 55296 || 57343 < charAt4) {
                    byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                    byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else {
                    if (i4 + 1 != charSequence.length()) {
                        i4++;
                        char charAt5 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt4, charAt5)) {
                            int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                            byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                        }
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
                    AppMethodBeat.o(40255);
                    throw illegalArgumentException2;
                }
                i4++;
            }
            AppMethodBeat.o(40255);
        }
    }

    private final void zzan(long j2) {
        AppMethodBeat.i(40269);
        while ((-128 & j2) != 0) {
            zzap((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            j2 >>>= 7;
        }
        zzap((int) j2);
        AppMethodBeat.o(40269);
    }

    public static int zzao(int i2) {
        AppMethodBeat.i(40261);
        if (i2 >= 0) {
            int zzas = zzas(i2);
            AppMethodBeat.o(40261);
            return zzas;
        }
        AppMethodBeat.o(40261);
        return 10;
    }

    public static int zzao(long j2) {
        if ((-128 & j2) == 0) {
            return 1;
        }
        if ((-16384 & j2) == 0) {
            return 2;
        }
        if ((-2097152 & j2) == 0) {
            return 3;
        }
        if ((-268435456 & j2) == 0) {
            return 4;
        }
        if ((-34359738368L & j2) == 0) {
            return 5;
        }
        if ((-4398046511104L & j2) == 0) {
            return 6;
        }
        if ((-562949953421312L & j2) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j2) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j2) == 0 ? 9 : 10;
    }

    private final void zzap(int i2) {
        AppMethodBeat.i(40264);
        byte b2 = (byte) i2;
        if (!this.zzbwv.hasRemaining()) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.o(40264);
            throw zzabx;
        }
        this.zzbwv.put(b2);
        AppMethodBeat.o(40264);
    }

    public static int zzaq(int i2) {
        AppMethodBeat.i(40267);
        int zzas = zzas(i2 << 3);
        AppMethodBeat.o(40267);
        return zzas;
    }

    public static int zzas(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (-268435456 & i2) == 0 ? 4 : 5;
    }

    public static int zzb(int i2, zzace zzace) {
        AppMethodBeat.i(40260);
        int zzaq = zzaq(i2);
        int zzvm = zzace.zzvm();
        int zzas = zzaq + zzvm + zzas(zzvm);
        AppMethodBeat.o(40260);
        return zzas;
    }

    public static zzabw zzb(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(40245);
        zzabw zzabw = new zzabw(bArr, 0, i3);
        AppMethodBeat.o(40245);
        return zzabw;
    }

    public static int zzc(int i2, long j2) {
        AppMethodBeat.i(40257);
        int zzaq = zzaq(i2) + zzao(j2);
        AppMethodBeat.o(40257);
        return zzaq;
    }

    public static int zzc(int i2, String str) {
        AppMethodBeat.i(40259);
        int zzaq = zzaq(i2) + zzfm(str);
        AppMethodBeat.o(40259);
        return zzaq;
    }

    public static int zzf(int i2, int i3) {
        AppMethodBeat.i(40258);
        int zzaq = zzaq(i2) + zzao(i3);
        AppMethodBeat.o(40258);
        return zzaq;
    }

    public static int zzfm(String str) {
        AppMethodBeat.i(40262);
        int zza = zza(str);
        int zzas = zza + zzas(zza);
        AppMethodBeat.o(40262);
        return zzas;
    }

    public static zzabw zzj(byte[] bArr) {
        AppMethodBeat.i(40244);
        zzabw zzb = zzb(bArr, 0, bArr.length);
        AppMethodBeat.o(40244);
        return zzb;
    }

    public final void zza(int i2, double d2) {
        AppMethodBeat.i(40246);
        zzg(i2, 1);
        long doubleToLongBits = Double.doubleToLongBits(d2);
        if (this.zzbwv.remaining() < 8) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.o(40246);
            throw zzabx;
        }
        this.zzbwv.putLong(doubleToLongBits);
        AppMethodBeat.o(40246);
    }

    public final void zza(int i2, float f2) {
        AppMethodBeat.i(40247);
        zzg(i2, 5);
        int floatToIntBits = Float.floatToIntBits(f2);
        if (this.zzbwv.remaining() < 4) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.o(40247);
            throw zzabx;
        }
        this.zzbwv.putInt(floatToIntBits);
        AppMethodBeat.o(40247);
    }

    public final void zza(int i2, long j2) {
        AppMethodBeat.i(40248);
        zzg(i2, 0);
        zzan(j2);
        AppMethodBeat.o(40248);
    }

    public final void zza(int i2, zzace zzace) {
        AppMethodBeat.i(40253);
        zzg(i2, 2);
        zzb(zzace);
        AppMethodBeat.o(40253);
    }

    public final void zza(int i2, boolean z) {
        int i3 = 0;
        AppMethodBeat.i(40251);
        zzg(i2, 0);
        if (z) {
            i3 = 1;
        }
        byte b2 = (byte) i3;
        if (!this.zzbwv.hasRemaining()) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            AppMethodBeat.o(40251);
            throw zzabx;
        }
        this.zzbwv.put(b2);
        AppMethodBeat.o(40251);
    }

    public final void zzar(int i2) {
        AppMethodBeat.i(40268);
        while ((i2 & -128) != 0) {
            zzap((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            i2 >>>= 7;
        }
        zzap(i2);
        AppMethodBeat.o(40268);
    }

    public final void zzb(int i2, long j2) {
        AppMethodBeat.i(40249);
        zzg(i2, 0);
        zzan(j2);
        AppMethodBeat.o(40249);
    }

    public final void zzb(int i2, String str) {
        AppMethodBeat.i(40252);
        zzg(i2, 2);
        try {
            int zzas = zzas(str.length());
            if (zzas == zzas(str.length() * 3)) {
                int position = this.zzbwv.position();
                if (this.zzbwv.remaining() < zzas) {
                    zzabx zzabx = new zzabx(zzas + position, this.zzbwv.limit());
                    AppMethodBeat.o(40252);
                    throw zzabx;
                }
                this.zzbwv.position(position + zzas);
                zza(str, this.zzbwv);
                int position2 = this.zzbwv.position();
                this.zzbwv.position(position);
                zzar((position2 - position) - zzas);
                this.zzbwv.position(position2);
                AppMethodBeat.o(40252);
                return;
            }
            zzar(zza(str));
            zza(str, this.zzbwv);
            AppMethodBeat.o(40252);
        } catch (BufferOverflowException e2) {
            zzabx zzabx2 = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            zzabx2.initCause(e2);
            AppMethodBeat.o(40252);
            throw zzabx2;
        }
    }

    public final void zzb(zzace zzace) {
        AppMethodBeat.i(40256);
        zzar(zzace.zzvl());
        zzace.zza(this);
        AppMethodBeat.o(40256);
    }

    public final void zze(int i2, int i3) {
        AppMethodBeat.i(40250);
        zzg(i2, 0);
        if (i3 >= 0) {
            zzar(i3);
            AppMethodBeat.o(40250);
            return;
        }
        zzan((long) i3);
        AppMethodBeat.o(40250);
    }

    public final void zzg(int i2, int i3) {
        AppMethodBeat.i(40266);
        zzar((i2 << 3) | i3);
        AppMethodBeat.o(40266);
    }

    public final void zzk(byte[] bArr) {
        AppMethodBeat.i(40265);
        int length = bArr.length;
        if (this.zzbwv.remaining() >= length) {
            this.zzbwv.put(bArr, 0, length);
            AppMethodBeat.o(40265);
            return;
        }
        zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
        AppMethodBeat.o(40265);
        throw zzabx;
    }

    public final void zzve() {
        AppMethodBeat.i(40263);
        if (this.zzbwv.remaining() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzbwv.remaining())));
            AppMethodBeat.o(40263);
            throw illegalStateException;
        }
        AppMethodBeat.o(40263);
    }
}
