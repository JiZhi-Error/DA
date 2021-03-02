package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastJsonResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zzwv = {'u', 'l', 'l'};
    private static final char[] zzww = {'r', 'u', 'e'};
    private static final char[] zzwx = {'r', 'u', 'e', '\"'};
    private static final char[] zzwy = {'a', 'l', 's', 'e'};
    private static final char[] zzwz = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zzxa = {'\n'};
    private static final zza<Integer> zzxc = new zza();
    private static final zza<Long> zzxd = new zzb();
    private static final zza<Float> zzxe = new zzc();
    private static final zza<Double> zzxf = new zzd();
    private static final zza<Boolean> zzxg = new zze();
    private static final zza<String> zzxh = new zzf();
    private static final zza<BigInteger> zzxi = new zzg();
    private static final zza<BigDecimal> zzxj = new zzh();
    private final char[] zzwq = new char[1];
    private final char[] zzwr = new char[32];
    private final char[] zzws = new char[1024];
    private final StringBuilder zzwt = new StringBuilder(32);
    private final StringBuilder zzwu = new StringBuilder(1024);
    private final Stack<Integer> zzxb = new Stack<>();

    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* access modifiers changed from: package-private */
    public interface zza<O> {
        O zzh(FastParser fastParser, BufferedReader bufferedReader);
    }

    static {
        AppMethodBeat.i(12044);
        AppMethodBeat.o(12044);
    }

    public FastParser() {
        AppMethodBeat.i(12014);
        AppMethodBeat.o(12014);
    }

    static /* synthetic */ int zza(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12036);
        int zzd = fastParser.zzd(bufferedReader);
        AppMethodBeat.o(12036);
        return zzd;
    }

    private final int zza(BufferedReader bufferedReader, char[] cArr) {
        int i2;
        AppMethodBeat.i(12033);
        char zzj = zzj(bufferedReader);
        if (zzj == 0) {
            ParseException parseException = new ParseException("Unexpected EOF");
            AppMethodBeat.o(12033);
            throw parseException;
        } else if (zzj == ',') {
            ParseException parseException2 = new ParseException("Missing value");
            AppMethodBeat.o(12033);
            throw parseException2;
        } else if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            AppMethodBeat.o(12033);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zzj == '\"') {
                i2 = 0;
                boolean z = false;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c2 = cArr[i2];
                    if (Character.isISOControl(c2)) {
                        ParseException parseException3 = new ParseException("Unexpected control character while reading string");
                        AppMethodBeat.o(12033);
                        throw parseException3;
                    } else if (c2 != '\"' || z) {
                        z = c2 == '\\' ? !z : false;
                        i2++;
                    } else {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 + 1));
                        AppMethodBeat.o(12033);
                        return i2;
                    }
                }
            } else {
                cArr[0] = zzj;
                i2 = 1;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    if (cArr[i2] == '}' || cArr[i2] == ',' || Character.isWhitespace(cArr[i2]) || cArr[i2] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 - 1));
                        cArr[i2] = 0;
                        AppMethodBeat.o(12033);
                        return i2;
                    }
                    i2++;
                }
            }
            if (i2 == cArr.length) {
                ParseException parseException4 = new ParseException("Absurdly long value");
                AppMethodBeat.o(12033);
                throw parseException4;
            }
            ParseException parseException5 = new ParseException("Unexpected EOF");
            AppMethodBeat.o(12033);
            throw parseException5;
        }
    }

    private final String zza(BufferedReader bufferedReader) {
        String str = null;
        AppMethodBeat.i(12018);
        this.zzxb.push(2);
        char zzj = zzj(bufferedReader);
        switch (zzj) {
            case '\"':
                this.zzxb.push(3);
                str = zzb(bufferedReader, this.zzwr, this.zzwt, null);
                zzk(3);
                if (zzj(bufferedReader) == ':') {
                    AppMethodBeat.o(12018);
                    break;
                } else {
                    ParseException parseException = new ParseException("Expected key/value separator");
                    AppMethodBeat.o(12018);
                    throw parseException;
                }
            case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                zzk(2);
                zzk(1);
                zzk(5);
                AppMethodBeat.o(12018);
                break;
            case '}':
                zzk(2);
                AppMethodBeat.o(12018);
                break;
            default:
                ParseException parseException2 = new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
                AppMethodBeat.o(12018);
                throw parseException2;
        }
        return str;
    }

    private final String zza(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        AppMethodBeat.i(12022);
        switch (zzj(bufferedReader)) {
            case '\"':
                String zzb = zzb(bufferedReader, cArr, sb, cArr2);
                AppMethodBeat.o(12022);
                return zzb;
            case 'n':
                zzb(bufferedReader, zzwv);
                AppMethodBeat.o(12022);
                return null;
            default:
                ParseException parseException = new ParseException("Expected string");
                AppMethodBeat.o(12022);
                throw parseException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.server.response.FastJsonResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) {
        AppMethodBeat.i(12031);
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char zzj = zzj(bufferedReader);
        switch (zzj) {
            case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                zzk(5);
                AppMethodBeat.o(12031);
                return arrayList;
            case 'n':
                zzb(bufferedReader, zzwv);
                zzk(5);
                AppMethodBeat.o(12031);
                return null;
            case '{':
                this.zzxb.push(1);
                while (true) {
                    try {
                        FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                        if (zza(bufferedReader, newConcreteTypeInstance)) {
                            arrayList.add(newConcreteTypeInstance);
                            char zzj2 = zzj(bufferedReader);
                            switch (zzj2) {
                                case ',':
                                    if (zzj(bufferedReader) != '{') {
                                        ParseException parseException = new ParseException("Expected start of next object in array");
                                        AppMethodBeat.o(12031);
                                        throw parseException;
                                    }
                                    this.zzxb.push(1);
                                case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                                    zzk(5);
                                    AppMethodBeat.o(12031);
                                    return arrayList;
                                default:
                                    ParseException parseException2 = new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj2).toString());
                                    AppMethodBeat.o(12031);
                                    throw parseException2;
                            }
                        } else {
                            AppMethodBeat.o(12031);
                            return arrayList;
                        }
                    } catch (InstantiationException e2) {
                        ParseException parseException3 = new ParseException("Error instantiating inner object", e2);
                        AppMethodBeat.o(12031);
                        throw parseException3;
                    } catch (IllegalAccessException e3) {
                        ParseException parseException4 = new ParseException("Error instantiating inner object", e3);
                        AppMethodBeat.o(12031);
                        throw parseException4;
                    }
                }
            default:
                ParseException parseException5 = new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
                AppMethodBeat.o(12031);
                throw parseException5;
        }
    }

    private final <O> ArrayList<O> zza(BufferedReader bufferedReader, zza<O> zza2) {
        AppMethodBeat.i(12021);
        char zzj = zzj(bufferedReader);
        if (zzj != 'n') {
            if (zzj == '[') {
                this.zzxb.push(5);
                ArrayList<O> arrayList = new ArrayList<>();
                while (true) {
                    bufferedReader.mark(1024);
                    switch (zzj(bufferedReader)) {
                        case 0:
                            ParseException parseException = new ParseException("Unexpected EOF");
                            AppMethodBeat.o(12021);
                            throw parseException;
                        case ',':
                            break;
                        case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                            zzk(5);
                            AppMethodBeat.o(12021);
                            return arrayList;
                        default:
                            bufferedReader.reset();
                            arrayList.add(zza2.zzh(this, bufferedReader));
                            break;
                    }
                }
            } else {
                ParseException parseException2 = new ParseException("Expected start of array");
                AppMethodBeat.o(12021);
                throw parseException2;
            }
        } else {
            zzb(bufferedReader, zzwv);
            AppMethodBeat.o(12021);
            return null;
        }
    }

    static /* synthetic */ boolean zza(FastParser fastParser, BufferedReader bufferedReader, boolean z) {
        AppMethodBeat.i(12040);
        boolean zza2 = fastParser.zza(bufferedReader, false);
        AppMethodBeat.o(12040);
        return zza2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 231
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private final boolean zza(java.io.BufferedReader r12, com.google.android.gms.common.server.response.FastJsonResponse r13) {
        /*
        // Method dump skipped, instructions count: 826
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean");
    }

    private final boolean zza(BufferedReader bufferedReader, boolean z) {
        AppMethodBeat.i(12027);
        while (true) {
            char zzj = zzj(bufferedReader);
            switch (zzj) {
                case '\"':
                    if (z) {
                        ParseException parseException = new ParseException("No boolean value found in string");
                        AppMethodBeat.o(12027);
                        throw parseException;
                    }
                    z = true;
                case 'f':
                    zzb(bufferedReader, z ? zzwz : zzwy);
                    AppMethodBeat.o(12027);
                    return false;
                case 'n':
                    zzb(bufferedReader, zzwv);
                    AppMethodBeat.o(12027);
                    return false;
                case 't':
                    zzb(bufferedReader, z ? zzwx : zzww);
                    AppMethodBeat.o(12027);
                    return true;
                default:
                    ParseException parseException2 = new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
                    AppMethodBeat.o(12027);
                    throw parseException2;
            }
        }
    }

    static /* synthetic */ long zzb(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12037);
        long zze = fastParser.zze(bufferedReader);
        AppMethodBeat.o(12037);
        return zze;
    }

    private final String zzb(BufferedReader bufferedReader) {
        AppMethodBeat.i(12019);
        bufferedReader.mark(1024);
        switch (zzj(bufferedReader)) {
            case '\"':
                if (bufferedReader.read(this.zzwq) != -1) {
                    char c2 = this.zzwq[0];
                    boolean z = false;
                    while (true) {
                        if (c2 == '\"' && !z) {
                            break;
                        } else {
                            boolean z2 = c2 == '\\' ? !z : false;
                            if (bufferedReader.read(this.zzwq) == -1) {
                                ParseException parseException = new ParseException("Unexpected EOF while parsing string");
                                AppMethodBeat.o(12019);
                                throw parseException;
                            }
                            c2 = this.zzwq[0];
                            if (Character.isISOControl(c2)) {
                                ParseException parseException2 = new ParseException("Unexpected control character while reading string");
                                AppMethodBeat.o(12019);
                                throw parseException2;
                            }
                            z = z2;
                        }
                    }
                } else {
                    ParseException parseException3 = new ParseException("Unexpected EOF while parsing string");
                    AppMethodBeat.o(12019);
                    throw parseException3;
                }
            case ',':
                ParseException parseException4 = new ParseException("Missing value");
                AppMethodBeat.o(12019);
                throw parseException4;
            case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                this.zzxb.push(5);
                bufferedReader.mark(32);
                if (zzj(bufferedReader) != ']') {
                    bufferedReader.reset();
                    int i2 = 1;
                    boolean z3 = false;
                    boolean z4 = false;
                    while (i2 > 0) {
                        char zzj = zzj(bufferedReader);
                        if (zzj == 0) {
                            ParseException parseException5 = new ParseException("Unexpected EOF while parsing array");
                            AppMethodBeat.o(12019);
                            throw parseException5;
                        } else if (Character.isISOControl(zzj)) {
                            ParseException parseException6 = new ParseException("Unexpected control character while reading array");
                            AppMethodBeat.o(12019);
                            throw parseException6;
                        } else {
                            if (zzj == '\"' && !z4) {
                                z3 = !z3;
                            }
                            int i3 = (zzj != '[' || z3) ? i2 : i2 + 1;
                            i2 = (zzj != ']' || z3) ? i3 : i3 - 1;
                            if (zzj != '\\' || !z3) {
                                z4 = false;
                            } else {
                                z4 = !z4;
                            }
                        }
                    }
                    zzk(5);
                    break;
                } else {
                    zzk(5);
                    break;
                }
            case '{':
                this.zzxb.push(1);
                bufferedReader.mark(32);
                char zzj2 = zzj(bufferedReader);
                if (zzj2 == '}') {
                    zzk(1);
                    break;
                } else if (zzj2 == '\"') {
                    bufferedReader.reset();
                    zza(bufferedReader);
                    do {
                    } while (zzb(bufferedReader) != null);
                    zzk(1);
                    break;
                } else {
                    ParseException parseException7 = new ParseException(new StringBuilder(18).append("Unexpected token ").append(zzj2).toString());
                    AppMethodBeat.o(12019);
                    throw parseException7;
                }
            default:
                bufferedReader.reset();
                zza(bufferedReader, this.zzws);
                break;
        }
        char zzj3 = zzj(bufferedReader);
        switch (zzj3) {
            case ',':
                zzk(2);
                String zza2 = zza(bufferedReader);
                AppMethodBeat.o(12019);
                return zza2;
            case '}':
                zzk(2);
                AppMethodBeat.o(12019);
                return null;
            default:
                ParseException parseException8 = new ParseException(new StringBuilder(18).append("Unexpected token ").append(zzj3).toString());
                AppMethodBeat.o(12019);
                throw parseException8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x002f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzb(java.io.BufferedReader r10, char[] r11, java.lang.StringBuilder r12, char[] r13) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zzb(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final void zzb(BufferedReader bufferedReader, char[] cArr) {
        AppMethodBeat.i(12034);
        int i2 = 0;
        while (i2 < cArr.length) {
            int read = bufferedReader.read(this.zzwr, 0, cArr.length - i2);
            if (read == -1) {
                ParseException parseException = new ParseException("Unexpected EOF");
                AppMethodBeat.o(12034);
                throw parseException;
            }
            for (int i3 = 0; i3 < read; i3++) {
                if (cArr[i3 + i2] != this.zzwr[i3]) {
                    ParseException parseException2 = new ParseException("Unexpected character");
                    AppMethodBeat.o(12034);
                    throw parseException2;
                }
            }
            i2 += read;
        }
        AppMethodBeat.o(12034);
    }

    static /* synthetic */ float zzc(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12038);
        float zzg = fastParser.zzg(bufferedReader);
        AppMethodBeat.o(12038);
        return zzg;
    }

    private final String zzc(BufferedReader bufferedReader) {
        AppMethodBeat.i(12020);
        String zza2 = zza(bufferedReader, this.zzwr, this.zzwt, null);
        AppMethodBeat.o(12020);
        return zza2;
    }

    static /* synthetic */ double zzd(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12039);
        double zzh = fastParser.zzh(bufferedReader);
        AppMethodBeat.o(12039);
        return zzh;
    }

    private final int zzd(BufferedReader bufferedReader) {
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5 = 0;
        AppMethodBeat.i(12024);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12024);
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            if (cArr[0] == '-') {
                i2 = Integer.MIN_VALUE;
                i3 = 1;
                z = true;
            } else {
                i2 = -2147483647;
                i3 = 0;
                z = false;
            }
            if (i3 < zza2) {
                i4 = i3 + 1;
                int digit = Character.digit(cArr[i3], 10);
                if (digit < 0) {
                    ParseException parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(12024);
                    throw parseException;
                }
                i5 = -digit;
            } else {
                i4 = i3;
            }
            while (i4 < zza2) {
                int i6 = i4 + 1;
                int digit2 = Character.digit(cArr[i4], 10);
                if (digit2 < 0) {
                    ParseException parseException2 = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(12024);
                    throw parseException2;
                } else if (i5 < -214748364) {
                    ParseException parseException3 = new ParseException("Number too large");
                    AppMethodBeat.o(12024);
                    throw parseException3;
                } else {
                    int i7 = i5 * 10;
                    if (i7 < i2 + digit2) {
                        ParseException parseException4 = new ParseException("Number too large");
                        AppMethodBeat.o(12024);
                        throw parseException4;
                    }
                    i5 = i7 - digit2;
                    i4 = i6;
                }
            }
            if (!z) {
                int i8 = -i5;
                AppMethodBeat.o(12024);
                return i8;
            } else if (i4 > 1) {
                AppMethodBeat.o(12024);
                return i5;
            } else {
                ParseException parseException5 = new ParseException("No digits to parse");
                AppMethodBeat.o(12024);
                throw parseException5;
            }
        } else {
            ParseException parseException6 = new ParseException("No number to parse");
            AppMethodBeat.o(12024);
            throw parseException6;
        }
    }

    private final long zze(BufferedReader bufferedReader) {
        long j2;
        int i2;
        boolean z;
        int i3;
        long j3 = 0;
        AppMethodBeat.i(12025);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12025);
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            if (cArr[0] == '-') {
                j2 = Long.MIN_VALUE;
                i2 = 1;
                z = true;
            } else {
                j2 = -9223372036854775807L;
                i2 = 0;
                z = false;
            }
            if (i2 < zza2) {
                i3 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    ParseException parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(12025);
                    throw parseException;
                }
                j3 = (long) (-digit);
            } else {
                i3 = i2;
            }
            while (i3 < zza2) {
                int i4 = i3 + 1;
                int digit2 = Character.digit(cArr[i3], 10);
                if (digit2 < 0) {
                    ParseException parseException2 = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(12025);
                    throw parseException2;
                } else if (j3 < -922337203685477580L) {
                    ParseException parseException3 = new ParseException("Number too large");
                    AppMethodBeat.o(12025);
                    throw parseException3;
                } else {
                    long j4 = j3 * 10;
                    if (j4 < ((long) digit2) + j2) {
                        ParseException parseException4 = new ParseException("Number too large");
                        AppMethodBeat.o(12025);
                        throw parseException4;
                    }
                    j3 = j4 - ((long) digit2);
                    i3 = i4;
                }
            }
            if (!z) {
                long j5 = -j3;
                AppMethodBeat.o(12025);
                return j5;
            } else if (i3 > 1) {
                AppMethodBeat.o(12025);
                return j3;
            } else {
                ParseException parseException5 = new ParseException("No digits to parse");
                AppMethodBeat.o(12025);
                throw parseException5;
            }
        } else {
            ParseException parseException6 = new ParseException("No number to parse");
            AppMethodBeat.o(12025);
            throw parseException6;
        }
    }

    static /* synthetic */ String zze(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12041);
        String zzc = fastParser.zzc(bufferedReader);
        AppMethodBeat.o(12041);
        return zzc;
    }

    static /* synthetic */ BigInteger zzf(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12042);
        BigInteger zzf = fastParser.zzf(bufferedReader);
        AppMethodBeat.o(12042);
        return zzf;
    }

    private final BigInteger zzf(BufferedReader bufferedReader) {
        AppMethodBeat.i(12026);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12026);
            return null;
        }
        BigInteger bigInteger = new BigInteger(new String(this.zzws, 0, zza2));
        AppMethodBeat.o(12026);
        return bigInteger;
    }

    private final float zzg(BufferedReader bufferedReader) {
        AppMethodBeat.i(12028);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12028);
            return 0.0f;
        }
        float parseFloat = Float.parseFloat(new String(this.zzws, 0, zza2));
        AppMethodBeat.o(12028);
        return parseFloat;
    }

    static /* synthetic */ BigDecimal zzg(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12043);
        BigDecimal zzi = fastParser.zzi(bufferedReader);
        AppMethodBeat.o(12043);
        return zzi;
    }

    private final double zzh(BufferedReader bufferedReader) {
        AppMethodBeat.i(12029);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12029);
            return 0.0d;
        }
        double parseDouble = Double.parseDouble(new String(this.zzws, 0, zza2));
        AppMethodBeat.o(12029);
        return parseDouble;
    }

    private final BigDecimal zzi(BufferedReader bufferedReader) {
        AppMethodBeat.i(12030);
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            AppMethodBeat.o(12030);
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(new String(this.zzws, 0, zza2));
        AppMethodBeat.o(12030);
        return bigDecimal;
    }

    private final char zzj(BufferedReader bufferedReader) {
        AppMethodBeat.i(12032);
        if (bufferedReader.read(this.zzwq) == -1) {
            AppMethodBeat.o(12032);
            return 0;
        }
        while (Character.isWhitespace(this.zzwq[0])) {
            if (bufferedReader.read(this.zzwq) == -1) {
                AppMethodBeat.o(12032);
                return 0;
            }
        }
        char c2 = this.zzwq[0];
        AppMethodBeat.o(12032);
        return c2;
    }

    private final void zzk(int i2) {
        AppMethodBeat.i(12035);
        if (this.zzxb.isEmpty()) {
            ParseException parseException = new ParseException(new StringBuilder(46).append("Expected state ").append(i2).append(" but had empty stack").toString());
            AppMethodBeat.o(12035);
            throw parseException;
        }
        int intValue = this.zzxb.pop().intValue();
        if (intValue != i2) {
            ParseException parseException2 = new ParseException(new StringBuilder(46).append("Expected state ").append(i2).append(" but had ").append(intValue).toString());
            AppMethodBeat.o(12035);
            throw parseException2;
        }
        AppMethodBeat.o(12035);
    }

    public void parse(InputStream inputStream, T t) {
        AppMethodBeat.i(12015);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zzxb.push(0);
            char zzj = zzj(bufferedReader);
            switch (zzj) {
                case 0:
                    ParseException parseException = new ParseException("No data to parse");
                    AppMethodBeat.o(12015);
                    throw parseException;
                case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                    this.zzxb.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(value, value.getOutputFieldName(), zza(bufferedReader, value));
                        break;
                    } else {
                        ParseException parseException2 = new ParseException("Object array response class must have a single Field");
                        AppMethodBeat.o(12015);
                        throw parseException2;
                    }
                case '{':
                    this.zzxb.push(1);
                    zza(bufferedReader, t);
                    break;
                default:
                    ParseException parseException3 = new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
                    AppMethodBeat.o(12015);
                    throw parseException3;
            }
            zzk(0);
            try {
                bufferedReader.close();
                AppMethodBeat.o(12015);
            } catch (IOException e2) {
                AppMethodBeat.o(12015);
            }
        } catch (IOException e3) {
            ParseException parseException4 = new ParseException(e3);
            AppMethodBeat.o(12015);
            throw parseException4;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.o(12015);
            throw th;
        }
    }

    public void parse(String str, T t) {
        AppMethodBeat.i(12016);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            parse(byteArrayInputStream, t);
            try {
            } catch (IOException e2) {
                AppMethodBeat.o(12016);
            }
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e3) {
            }
            AppMethodBeat.o(12016);
        }
    }
}
