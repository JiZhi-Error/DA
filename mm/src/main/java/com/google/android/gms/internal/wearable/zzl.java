package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzl {
    private final ByteBuffer zzhb;

    private zzl(ByteBuffer byteBuffer) {
        AppMethodBeat.i(100707);
        this.zzhb = byteBuffer;
        this.zzhb.order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.o(100707);
    }

    private zzl(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, i2, i3));
        AppMethodBeat.i(100706);
        AppMethodBeat.o(100706);
    }

    private static int zza(CharSequence charSequence) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(100715);
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
                                AppMethodBeat.o(100715);
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
            AppMethodBeat.o(100715);
            throw illegalArgumentException2;
        }
        AppMethodBeat.o(100715);
        return i2;
    }

    private final void zza(long j2) {
        AppMethodBeat.i(100730);
        while ((-128 & j2) != 0) {
            zzj((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            j2 >>>= 7;
        }
        zzj((int) j2);
        AppMethodBeat.o(100730);
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(100716);
        if (byteBuffer.isReadOnly()) {
            ReadOnlyBufferException readOnlyBufferException = new ReadOnlyBufferException();
            AppMethodBeat.o(100716);
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
                            AppMethodBeat.o(100716);
                            throw illegalArgumentException;
                        } else {
                            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i7).toString());
                            AppMethodBeat.o(100716);
                            throw arrayIndexOutOfBoundsException;
                        }
                        i6++;
                        i7 = i3;
                    }
                    i2 = i7;
                }
                byteBuffer.position(i2 - byteBuffer.arrayOffset());
                AppMethodBeat.o(100716);
            } catch (ArrayIndexOutOfBoundsException e2) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e2);
                AppMethodBeat.o(100716);
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
                    AppMethodBeat.o(100716);
                    throw illegalArgumentException2;
                }
                i4++;
            }
            AppMethodBeat.o(100716);
        }
    }

    public static int zzb(int i2, long j2) {
        AppMethodBeat.i(100717);
        int zzk = ((-128 & j2) == 0 ? 1 : (-16384 & j2) == 0 ? 2 : (-2097152 & j2) == 0 ? 3 : (-268435456 & j2) == 0 ? 4 : (-34359738368L & j2) == 0 ? 5 : (-4398046511104L & j2) == 0 ? 6 : (-562949953421312L & j2) == 0 ? 7 : (-72057594037927936L & j2) == 0 ? 8 : (Long.MIN_VALUE & j2) == 0 ? 9 : 10) + zzk(i2);
        AppMethodBeat.o(100717);
        return zzk;
    }

    public static int zzb(int i2, zzt zzt) {
        AppMethodBeat.i(100720);
        int zzk = zzk(i2);
        int zzx = zzt.zzx();
        int zzm = zzk + zzx + zzm(zzx);
        AppMethodBeat.o(100720);
        return zzm;
    }

    public static int zzb(int i2, String str) {
        AppMethodBeat.i(100719);
        int zzk = zzk(i2) + zzg(str);
        AppMethodBeat.o(100719);
        return zzk;
    }

    public static zzl zzb(byte[] bArr) {
        AppMethodBeat.i(100708);
        zzl zzb = zzb(bArr, 0, bArr.length);
        AppMethodBeat.o(100708);
        return zzb;
    }

    public static zzl zzb(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(100709);
        zzl zzl = new zzl(bArr, 0, i3);
        AppMethodBeat.o(100709);
        return zzl;
    }

    public static int zze(int i2, int i3) {
        AppMethodBeat.i(100718);
        int zzk = zzk(i2) + zzi(i3);
        AppMethodBeat.o(100718);
        return zzk;
    }

    public static int zzg(String str) {
        AppMethodBeat.i(100722);
        int zza = zza(str);
        int zzm = zza + zzm(zza);
        AppMethodBeat.o(100722);
        return zzm;
    }

    public static int zzi(int i2) {
        AppMethodBeat.i(100721);
        if (i2 >= 0) {
            int zzm = zzm(i2);
            AppMethodBeat.o(100721);
            return zzm;
        }
        AppMethodBeat.o(100721);
        return 10;
    }

    private final void zzj(int i2) {
        AppMethodBeat.i(100725);
        byte b2 = (byte) i2;
        if (!this.zzhb.hasRemaining()) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.o(100725);
            throw zzm;
        }
        this.zzhb.put(b2);
        AppMethodBeat.o(100725);
    }

    public static int zzk(int i2) {
        AppMethodBeat.i(100728);
        int zzm = zzm(i2 << 3);
        AppMethodBeat.o(100728);
        return zzm;
    }

    public static int zzm(int i2) {
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

    public static int zzn(int i2) {
        return (i2 << 1) ^ (i2 >> 31);
    }

    public final void zza(byte b2) {
        AppMethodBeat.i(100724);
        if (!this.zzhb.hasRemaining()) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.o(100724);
            throw zzm;
        }
        this.zzhb.put(b2);
        AppMethodBeat.o(100724);
    }

    public final void zza(int i2, float f2) {
        AppMethodBeat.i(100710);
        zzf(i2, 5);
        int floatToIntBits = Float.floatToIntBits(f2);
        if (this.zzhb.remaining() < 4) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.o(100710);
            throw zzm;
        }
        this.zzhb.putInt(floatToIntBits);
        AppMethodBeat.o(100710);
    }

    public final void zza(int i2, long j2) {
        AppMethodBeat.i(100711);
        zzf(i2, 0);
        zza(j2);
        AppMethodBeat.o(100711);
    }

    public final void zza(int i2, zzt zzt) {
        AppMethodBeat.i(100714);
        zzf(i2, 2);
        if (zzt.zzhl < 0) {
            zzt.zzx();
        }
        zzl(zzt.zzhl);
        zzt.zza(this);
        AppMethodBeat.o(100714);
    }

    public final void zza(int i2, String str) {
        AppMethodBeat.i(100713);
        zzf(i2, 2);
        try {
            int zzm = zzm(str.length());
            if (zzm == zzm(str.length() * 3)) {
                int position = this.zzhb.position();
                if (this.zzhb.remaining() < zzm) {
                    zzm zzm2 = new zzm(zzm + position, this.zzhb.limit());
                    AppMethodBeat.o(100713);
                    throw zzm2;
                }
                this.zzhb.position(position + zzm);
                zza(str, this.zzhb);
                int position2 = this.zzhb.position();
                this.zzhb.position(position);
                zzl((position2 - position) - zzm);
                this.zzhb.position(position2);
                AppMethodBeat.o(100713);
                return;
            }
            zzl(zza(str));
            zza(str, this.zzhb);
            AppMethodBeat.o(100713);
        } catch (BufferOverflowException e2) {
            zzm zzm3 = new zzm(this.zzhb.position(), this.zzhb.limit());
            zzm3.initCause(e2);
            AppMethodBeat.o(100713);
            throw zzm3;
        }
    }

    public final void zzb(long j2) {
        AppMethodBeat.i(100731);
        if (this.zzhb.remaining() < 8) {
            zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
            AppMethodBeat.o(100731);
            throw zzm;
        }
        this.zzhb.putLong(j2);
        AppMethodBeat.o(100731);
    }

    public final void zzc(byte[] bArr) {
        AppMethodBeat.i(100726);
        int length = bArr.length;
        if (this.zzhb.remaining() >= length) {
            this.zzhb.put(bArr, 0, length);
            AppMethodBeat.o(100726);
            return;
        }
        zzm zzm = new zzm(this.zzhb.position(), this.zzhb.limit());
        AppMethodBeat.o(100726);
        throw zzm;
    }

    public final void zzd(int i2, int i3) {
        AppMethodBeat.i(100712);
        zzf(i2, 0);
        if (i3 >= 0) {
            zzl(i3);
            AppMethodBeat.o(100712);
            return;
        }
        zza((long) i3);
        AppMethodBeat.o(100712);
    }

    public final void zzf(int i2, int i3) {
        AppMethodBeat.i(100727);
        zzl((i2 << 3) | i3);
        AppMethodBeat.o(100727);
    }

    public final void zzl(int i2) {
        AppMethodBeat.i(100729);
        while ((i2 & -128) != 0) {
            zzj((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            i2 >>>= 7;
        }
        zzj(i2);
        AppMethodBeat.o(100729);
    }

    public final void zzr() {
        AppMethodBeat.i(100723);
        if (this.zzhb.remaining() != 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzhb.remaining())));
            AppMethodBeat.o(100723);
            throw illegalStateException;
        }
        AppMethodBeat.o(100723);
    }
}
