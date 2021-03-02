package com.google.a;

import android.support.constraint.ConstraintLayout;
import com.google.a.w;
import com.google.a.y;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

final class bb<T> implements br<T> {
    private static final Unsafe UNSAFE = ch.HU();
    private static final int[] bYn = new int[0];
    private final aw bXE;
    private final al bYA;
    private final cb<?, ?> bYB;
    private final s<?> bYC;
    private final ap bYD;
    private final int[] bYo;
    private final Object[] bYp;
    private final int bYq;
    private final int bYr;
    private final boolean bYs;
    private final boolean bYt;
    private final boolean bYu;
    private final boolean bYv;
    private final int[] bYw;
    private final int bYx;
    private final int bYy;
    private final be bYz;

    private bb(int[] iArr, Object[] objArr, int i2, int i3, aw awVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, be beVar, al alVar, cb<?, ?> cbVar, s<?> sVar, ap apVar) {
        this.bYo = iArr;
        this.bYp = objArr;
        this.bYq = i2;
        this.bYr = i3;
        this.bYt = awVar instanceof ab;
        this.bYu = z;
        this.bYs = sVar != null && sVar.f(awVar);
        this.bYv = z2;
        this.bYw = iArr2;
        this.bYx = i4;
        this.bYy = i5;
        this.bYz = beVar;
        this.bYA = alVar;
        this.bYB = cbVar;
        this.bYC = sVar;
        this.bXE = awVar;
        this.bYD = apVar;
    }

    static <T> bb<T> a(au auVar, be beVar, al alVar, cb<?, ?> cbVar, s<?> sVar, ap apVar) {
        boolean z;
        int i2;
        int i3;
        int[] iArr;
        int[] iArr2;
        int a2;
        int i4;
        int a3;
        int i5;
        boolean z2;
        int i6;
        Class<?> cls;
        boolean z3;
        char c2;
        int i7;
        int i8;
        int i9;
        char c3;
        char c4;
        char c5;
        int i10;
        char c6;
        int[] iArr3;
        int i11;
        int i12;
        int i13;
        char charAt;
        char charAt2;
        char charAt3;
        char charAt4;
        char charAt5;
        char charAt6;
        char charAt7;
        char charAt8;
        int i14;
        int i15;
        char c7;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        char c8;
        int i23;
        Field c9;
        char charAt9;
        char c10;
        int i24;
        Field c11;
        Field c12;
        int i25;
        char charAt10;
        char charAt11;
        char charAt12;
        int i26;
        char charAt13;
        char charAt14;
        if (auVar instanceof bp) {
            bp bpVar = (bp) auVar;
            if (bpVar.He() == bl.PROTO3) {
                z3 = true;
            } else {
                z3 = false;
            }
            String str = bpVar.info;
            int length = str.length();
            int i27 = 1;
            char charAt15 = str.charAt(0);
            if (charAt15 >= 55296) {
                int i28 = charAt15 & 8191;
                int i29 = 13;
                while (true) {
                    i7 = i27 + 1;
                    charAt14 = str.charAt(i27);
                    if (charAt14 < 55296) {
                        break;
                    }
                    i28 |= (charAt14 & 8191) << i29;
                    i29 += 13;
                    i27 = i7;
                }
                c2 = (charAt14 << i29) | i28;
            } else {
                c2 = charAt15;
                i7 = 1;
            }
            int i30 = i7 + 1;
            int charAt16 = str.charAt(i7);
            if (charAt16 >= 55296) {
                int i31 = charAt16 & 8191;
                int i32 = 13;
                while (true) {
                    i26 = i30 + 1;
                    charAt13 = str.charAt(i30);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i31 |= (charAt13 & 8191) << i32;
                    i32 += 13;
                    i30 = i26;
                }
                charAt16 = (charAt13 << i32) | i31;
                i8 = i26;
            } else {
                i8 = i30;
            }
            if (charAt16 == 0) {
                i12 = 0;
                c3 = 0;
                c4 = 0;
                c5 = 0;
                c6 = 0;
                iArr3 = bYn;
                i11 = 0;
                i13 = 0;
            } else {
                int i33 = i8 + 1;
                int charAt17 = str.charAt(i8);
                if (charAt17 >= 55296) {
                    int i34 = charAt17 & 8191;
                    int i35 = 13;
                    while (true) {
                        i9 = i33 + 1;
                        charAt8 = str.charAt(i33);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i34 |= (charAt8 & 8191) << i35;
                        i35 += 13;
                        i33 = i9;
                    }
                    charAt17 = (charAt8 << i35) | i34;
                } else {
                    i9 = i33;
                }
                int i36 = i9 + 1;
                int charAt18 = str.charAt(i9);
                if (charAt18 >= 55296) {
                    int i37 = charAt18 & 8191;
                    int i38 = 13;
                    while (true) {
                        i36++;
                        charAt7 = str.charAt(i36);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i37 |= (charAt7 & 8191) << i38;
                        i38 += 13;
                    }
                    charAt18 = (charAt7 << i38) | i37;
                }
                int i39 = i36 + 1;
                int charAt19 = str.charAt(i36);
                if (charAt19 >= 55296) {
                    int i40 = charAt19 & 8191;
                    int i41 = 13;
                    while (true) {
                        i39++;
                        charAt6 = str.charAt(i39);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i40 |= (charAt6 & 8191) << i41;
                        i41 += 13;
                    }
                    charAt19 = (charAt6 << i41) | i40;
                }
                int i42 = i39 + 1;
                char charAt20 = str.charAt(i39);
                if (charAt20 >= 55296) {
                    int i43 = charAt20 & 8191;
                    int i44 = 13;
                    while (true) {
                        i42++;
                        charAt5 = str.charAt(i42);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i43 |= (charAt5 & 8191) << i44;
                        i44 += 13;
                    }
                    c3 = (charAt5 << i44) | i43;
                } else {
                    c3 = charAt20;
                }
                int i45 = i42 + 1;
                char charAt21 = str.charAt(i42);
                if (charAt21 >= 55296) {
                    int i46 = charAt21 & 8191;
                    int i47 = 13;
                    while (true) {
                        i45++;
                        charAt4 = str.charAt(i45);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i46 |= (charAt4 & 8191) << i47;
                        i47 += 13;
                    }
                    c4 = (charAt4 << i47) | i46;
                } else {
                    c4 = charAt21;
                }
                int i48 = i45 + 1;
                char charAt22 = str.charAt(i45);
                if (charAt22 >= 55296) {
                    int i49 = charAt22 & 8191;
                    int i50 = 13;
                    while (true) {
                        i48++;
                        charAt3 = str.charAt(i48);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i49 |= (charAt3 & 8191) << i50;
                        i50 += 13;
                    }
                    c5 = (charAt3 << i50) | i49;
                } else {
                    c5 = charAt22;
                }
                int i51 = i48 + 1;
                int charAt23 = str.charAt(i48);
                if (charAt23 >= 55296) {
                    int i52 = charAt23 & 8191;
                    int i53 = 13;
                    while (true) {
                        i10 = i51 + 1;
                        charAt2 = str.charAt(i51);
                        if (charAt2 < 55296) {
                            break;
                        }
                        i52 |= (charAt2 & 8191) << i53;
                        i53 += 13;
                        i51 = i10;
                    }
                    charAt23 = (charAt2 << i53) | i52;
                } else {
                    i10 = i51;
                }
                i8 = i10 + 1;
                char charAt24 = str.charAt(i10);
                if (charAt24 >= 55296) {
                    int i54 = charAt24 & 8191;
                    int i55 = 13;
                    while (true) {
                        i8++;
                        charAt = str.charAt(i8);
                        if (charAt < 55296) {
                            break;
                        }
                        i54 |= (charAt & 8191) << i55;
                        i55 += 13;
                    }
                    c6 = (charAt << i55) | i54;
                } else {
                    c6 = charAt24;
                }
                iArr3 = new int[(charAt23 + c6 + c5)];
                i11 = charAt18 + (charAt17 * 2);
                i12 = charAt19;
                i13 = charAt17;
            }
            Unsafe unsafe = UNSAFE;
            Object[] objArr = bpVar.bYp;
            int i56 = 0;
            Class<?> cls2 = bpVar.bXE.getClass();
            int[] iArr4 = new int[(c4 * 3)];
            Object[] objArr2 = new Object[(c4 * 2)];
            int i57 = c6 + c5;
            int i58 = 0;
            int i59 = c6;
            int i60 = i11;
            int i61 = i8;
            while (i61 < length) {
                int i62 = i61 + 1;
                char charAt25 = str.charAt(i61);
                if (charAt25 >= 55296) {
                    int i63 = charAt25 & 8191;
                    int i64 = 13;
                    while (true) {
                        i15 = i62 + 1;
                        charAt12 = str.charAt(i62);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i63 |= (charAt12 & 8191) << i64;
                        i64 += 13;
                        i62 = i15;
                    }
                    i14 = i63 | (charAt12 << i64);
                } else {
                    i14 = charAt25;
                    i15 = i62;
                }
                int i65 = i15 + 1;
                char charAt26 = str.charAt(i15);
                if (charAt26 >= 55296) {
                    int i66 = charAt26 & 8191;
                    int i67 = 13;
                    while (true) {
                        i65++;
                        charAt11 = str.charAt(i65);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i66 |= (charAt11 & 8191) << i67;
                        i67 += 13;
                    }
                    c7 = i66 | (charAt11 << i67);
                    i61 = i65;
                } else {
                    c7 = charAt26;
                    i61 = i65;
                }
                int i68 = c7 & 255;
                if ((c7 & 1024) != 0) {
                    iArr3[i56] = i58;
                    i16 = i56 + 1;
                } else {
                    i16 = i56;
                }
                if (i68 >= 51) {
                    int i69 = i61 + 1;
                    char charAt27 = str.charAt(i61);
                    if (charAt27 >= 55296) {
                        int i70 = charAt27 & 8191;
                        int i71 = 13;
                        while (true) {
                            i25 = i69 + 1;
                            charAt10 = str.charAt(i69);
                            if (charAt10 < 55296) {
                                break;
                            }
                            i70 |= (charAt10 & 8191) << i71;
                            i71 += 13;
                            i69 = i25;
                        }
                        c10 = (charAt10 << i71) | i70;
                        i61 = i25;
                    } else {
                        c10 = charAt27;
                        i61 = i69;
                    }
                    int i72 = i68 - 51;
                    if (i72 == 9 || i72 == 17) {
                        objArr2[((i58 / 3) * 2) + 1] = objArr[i60];
                        i24 = i60 + 1;
                    } else if (i72 == 12 && (c2 & 1) == 1) {
                        objArr2[((i58 / 3) * 2) + 1] = objArr[i60];
                        i24 = i60 + 1;
                    } else {
                        i24 = i60;
                    }
                    int i73 = c10 * 2;
                    Object obj = objArr[i73];
                    if (obj instanceof Field) {
                        c11 = (Field) obj;
                    } else {
                        c11 = c(cls2, (String) obj);
                        objArr[i73] = c11;
                    }
                    i22 = (int) unsafe.objectFieldOffset(c11);
                    int i74 = i73 + 1;
                    Object obj2 = objArr[i74];
                    if (obj2 instanceof Field) {
                        c12 = (Field) obj2;
                    } else {
                        c12 = c(cls2, (String) obj2);
                        objArr[i74] = c12;
                    }
                    i20 = 0;
                    i21 = i57;
                    i17 = i24;
                    i19 = (int) unsafe.objectFieldOffset(c12);
                } else {
                    i17 = i60 + 1;
                    Field c13 = c(cls2, (String) objArr[i60]);
                    if (i68 == 9 || i68 == 17) {
                        objArr2[((i58 / 3) * 2) + 1] = c13.getType();
                        i18 = i59;
                    } else if (i68 == 27 || i68 == 49) {
                        objArr2[((i58 / 3) * 2) + 1] = objArr[i17];
                        i18 = i59;
                        i17++;
                    } else {
                        if (i68 == 12 || i68 == 30 || i68 == 44) {
                            if ((c2 & 1) == 1) {
                                objArr2[((i58 / 3) * 2) + 1] = objArr[i17];
                                i18 = i59;
                                i17++;
                            }
                        } else if (i68 == 50) {
                            int i75 = i59 + 1;
                            iArr3[i59] = i58;
                            int i76 = i17 + 1;
                            objArr2[(i58 / 3) * 2] = objArr[i17];
                            if ((c7 & 2048) != 0) {
                                i17 = i76 + 1;
                                objArr2[((i58 / 3) * 2) + 1] = objArr[i76];
                                i18 = i75;
                            } else {
                                i18 = i75;
                                i17 = i76;
                            }
                        }
                        i18 = i59;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(c13);
                    if ((c2 & 1) != 1 || i68 > 17) {
                        i19 = 0;
                        i20 = 0;
                    } else {
                        int i77 = i61 + 1;
                        char charAt28 = str.charAt(i61);
                        if (charAt28 >= 55296) {
                            int i78 = charAt28 & 8191;
                            int i79 = 13;
                            while (true) {
                                i23 = i77 + 1;
                                charAt9 = str.charAt(i77);
                                if (charAt9 < 55296) {
                                    break;
                                }
                                i78 |= (charAt9 & 8191) << i79;
                                i79 += 13;
                                i77 = i23;
                            }
                            c8 = i78 | (charAt9 << i79);
                        } else {
                            c8 = charAt28;
                            i23 = i77;
                        }
                        int i80 = (c8 / ' ') + (i13 * 2);
                        Object obj3 = objArr[i80];
                        if (obj3 instanceof Field) {
                            c9 = (Field) obj3;
                        } else {
                            c9 = c(cls2, (String) obj3);
                            objArr[i80] = c9;
                        }
                        i19 = (int) unsafe.objectFieldOffset(c9);
                        i20 = c8 % ' ';
                        i61 = i23;
                    }
                    if (i68 < 18 || i68 > 49) {
                        i21 = i57;
                        i59 = i18;
                        i22 = objectFieldOffset;
                    } else {
                        i21 = i57 + 1;
                        iArr3[i57] = objectFieldOffset;
                        i59 = i18;
                        i22 = objectFieldOffset;
                    }
                }
                int i81 = i58 + 1;
                iArr4[i58] = i14;
                int i82 = i81 + 1;
                iArr4[i81] = ((c7 & 256) != 0 ? 268435456 : 0) | ((c7 & 512) != 0 ? 536870912 : 0) | (i68 << 20) | i22;
                iArr4[i82] = (i20 << 20) | i19;
                i58 = i82 + 1;
                i57 = i21;
                i56 = i16;
                i60 = i17;
            }
            return new bb<>(iArr4, objArr2, i12, c3, bpVar.bXE, z3, false, iArr3, c6, c6 + c5, beVar, alVar, cbVar, sVar, apVar);
        }
        bw bwVar = (bw) auVar;
        if (bwVar.bZn == bl.PROTO3) {
            z = true;
        } else {
            z = false;
        }
        w[] wVarArr = bwVar.bZp;
        if (wVarArr.length == 0) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = wVarArr[0].bUr;
            i3 = wVarArr[wVarArr.length - 1].bUr;
        }
        int length2 = wVarArr.length;
        int[] iArr5 = new int[(length2 * 3)];
        Object[] objArr3 = new Object[(length2 * 2)];
        int i83 = 0;
        int i84 = 0;
        for (w wVar : wVarArr) {
            if (wVar.bUp == y.MAP) {
                i83++;
            } else if (wVar.bUp.id >= 18 && wVar.bUp.id <= 49) {
                i84++;
            }
        }
        int[] iArr6 = i83 > 0 ? new int[i83] : null;
        int[] iArr7 = i84 > 0 ? new int[i84] : null;
        int i85 = 0;
        int i86 = 0;
        int[] iArr8 = bwVar.bZo;
        if (iArr8 == null) {
            iArr = bYn;
        } else {
            iArr = iArr8;
        }
        int i87 = 0;
        int i88 = 0;
        int i89 = 0;
        while (i88 < wVarArr.length) {
            w wVar2 = wVarArr[i88];
            int i90 = wVar2.bUr;
            bi biVar = wVar2.bUv;
            if (biVar != null) {
                i4 = wVar2.bUp.id + 51;
                a2 = (int) ch.a(biVar.bYI);
                a3 = (int) ch.a(biVar.bYH);
                i5 = 0;
            } else {
                y yVar = wVar2.bUp;
                a2 = (int) ch.a(wVar2.bUo);
                i4 = yVar.id;
                if (!z && !yVar.bVH.bVS) {
                    if (yVar.bVH == y.a.MAP) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        a3 = (int) ch.a(wVar2.bUs);
                        i5 = Integer.numberOfTrailingZeros(wVar2.bUt);
                    }
                }
                if (wVar2.bUw == null) {
                    a3 = 0;
                    i5 = 0;
                } else {
                    a3 = (int) ch.a(wVar2.bUw);
                    i5 = 0;
                }
            }
            iArr5[i89] = wVar2.bUr;
            int i91 = i89 + 1;
            if (wVar2.bUu) {
                i6 = 536870912;
            } else {
                i6 = 0;
            }
            iArr5[i91] = (i4 << 20) | i6 | (wVar2.required ? 268435456 : 0) | a2;
            iArr5[i89 + 2] = a3 | (i5 << 20);
            switch (w.AnonymousClass1.bUA[wVar2.bUp.ordinal()]) {
                case 1:
                case 2:
                    if (wVar2.bUo != null) {
                        cls = wVar2.bUo.getType();
                        break;
                    } else {
                        cls = wVar2.bUx;
                        break;
                    }
                case 3:
                case 4:
                    cls = wVar2.bUq;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (wVar2.bUy != null) {
                objArr3[(i89 / 3) * 2] = wVar2.bUy;
                if (cls != null) {
                    objArr3[((i89 / 3) * 2) + 1] = cls;
                } else if (wVar2.bUz != null) {
                    objArr3[((i89 / 3) * 2) + 1] = wVar2.bUz;
                }
            } else if (cls != null) {
                objArr3[((i89 / 3) * 2) + 1] = cls;
            } else if (wVar2.bUz != null) {
                objArr3[((i89 / 3) * 2) + 1] = wVar2.bUz;
            }
            if (i87 < iArr.length && iArr[i87] == i90) {
                iArr[i87] = i89;
                i87++;
            }
            if (wVar2.bUp == y.MAP) {
                iArr6[i85] = i89;
                i85++;
            } else if (wVar2.bUp.id >= 18 && wVar2.bUp.id <= 49) {
                iArr7[i86] = (int) ch.a(wVar2.bUo);
                i86++;
            }
            i88++;
            i89 += 3;
        }
        if (iArr6 == null) {
            iArr2 = bYn;
        } else {
            iArr2 = iArr6;
        }
        if (iArr7 == null) {
            iArr7 = bYn;
        }
        int[] iArr9 = new int[(iArr.length + iArr2.length + iArr7.length)];
        System.arraycopy(iArr, 0, iArr9, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr9, iArr.length, iArr2.length);
        System.arraycopy(iArr7, 0, iArr9, iArr.length + iArr2.length, iArr7.length);
        return new bb<>(iArr5, objArr3, i2, i3, bwVar.bXE, z, true, iArr9, iArr.length, iArr.length + iArr2.length, beVar, alVar, cbVar, sVar, apVar);
    }

    private static Field c(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e2) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.a.br
    public final boolean equals(T t, T t2) {
        boolean z;
        int length = this.bYo.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int gJ = gJ(i2);
            long j2 = (long) (gJ & 1048575);
            switch ((gJ & 267386880) >>> 20) {
                case 0:
                    if (!c(t, t2, i2) || Double.doubleToLongBits(ch.j(t, j2)) != Double.doubleToLongBits(ch.j(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 1:
                    if (!c(t, t2, i2) || Float.floatToIntBits(ch.i(t, j2)) != Float.floatToIntBits(ch.i(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 2:
                    if (!c(t, t2, i2) || ch.g(t, j2) != ch.g(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 3:
                    if (!c(t, t2, i2) || ch.g(t, j2) != ch.g(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 4:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 5:
                    if (!c(t, t2, i2) || ch.g(t, j2) != ch.g(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 6:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 7:
                    if (!c(t, t2, i2) || ch.h(t, j2) != ch.h(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 8:
                    if (!c(t, t2, i2) || !bt.o(ch.k(t, j2), ch.k(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 9:
                    if (!c(t, t2, i2) || !bt.o(ch.k(t, j2), ch.k(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 10:
                    if (!c(t, t2, i2) || !bt.o(ch.k(t, j2), ch.k(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 11:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 12:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 13:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 14:
                    if (!c(t, t2, i2) || ch.g(t, j2) != ch.g(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 15:
                    if (!c(t, t2, i2) || ch.f(t, j2) != ch.f(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 16:
                    if (!c(t, t2, i2) || ch.g(t, j2) != ch.g(t2, j2)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 17:
                    if (!c(t, t2, i2) || !bt.o(ch.k(t, j2), ch.k(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 49:
                    z = bt.o(ch.k(t, j2), ch.k(t2, j2));
                    break;
                case 50:
                    z = bt.o(ch.k(t, j2), ch.k(t2, j2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                case 58:
                case bv.CTRL_INDEX /*{ENCODED_INT: 59}*/:
                case 60:
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    int gK = gK(i2);
                    if (!(ch.f(t, (long) (gK & 1048575)) == ch.f(t2, (long) (gK & 1048575))) || !bt.o(ch.k(t, j2), ch.k(t2, j2))) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                return false;
            }
        }
        if (!this.bYB.aw(t).equals(this.bYB.aw(t2))) {
            return false;
        }
        if (this.bYs) {
            return this.bYC.an(t).equals(this.bYC.an(t2));
        }
        return true;
    }

    @Override // com.google.a.br
    public final int hashCode(T t) {
        int hashCode;
        int i2;
        int i3;
        int length = this.bYo.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int gJ = gJ(i4);
            int i6 = this.bYo[i4];
            long j2 = (long) (1048575 & gJ);
            switch ((gJ & 267386880) >>> 20) {
                case 0:
                    hashCode = (i5 * 53) + ae.aF(Double.doubleToLongBits(ch.j(t, j2)));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 1:
                    hashCode = (i5 * 53) + Float.floatToIntBits(ch.i(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 2:
                    hashCode = (i5 * 53) + ae.aF(ch.g(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 3:
                    hashCode = (i5 * 53) + ae.aF(ch.g(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 4:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 5:
                    hashCode = (i5 * 53) + ae.aF(ch.g(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 6:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 7:
                    hashCode = (i5 * 53) + ae.bF(ch.h(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 8:
                    hashCode = ((String) ch.k(t, j2)).hashCode() + (i5 * 53);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 9:
                    Object k = ch.k(t, j2);
                    if (k != null) {
                        i3 = k.hashCode();
                    } else {
                        i3 = 37;
                    }
                    hashCode = i3 + (i5 * 53);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 10:
                    hashCode = (i5 * 53) + ch.k(t, j2).hashCode();
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 11:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 12:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 13:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 14:
                    hashCode = (i5 * 53) + ae.aF(ch.g(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 15:
                    hashCode = (i5 * 53) + ch.f(t, j2);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 16:
                    hashCode = (i5 * 53) + ae.aF(ch.g(t, j2));
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 17:
                    Object k2 = ch.k(t, j2);
                    if (k2 != null) {
                        i2 = k2.hashCode();
                    } else {
                        i2 = 37;
                    }
                    hashCode = i2 + (i5 * 53);
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 49:
                    hashCode = (i5 * 53) + ch.k(t, j2).hashCode();
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 50:
                    hashCode = (i5 * 53) + ch.k(t, j2).hashCode();
                    continue;
                    i4 += 3;
                    i5 = hashCode;
                case 51:
                    if (a(t, i6, i4)) {
                        hashCode = ae.aF(Double.doubleToLongBits(((Double) ch.k(t, j2)).doubleValue())) + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 52:
                    if (a(t, i6, i4)) {
                        hashCode = Float.floatToIntBits(((Float) ch.k(t, j2)).floatValue()) + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 53:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ae.aF(e(t, j2));
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 54:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ae.aF(e(t, j2));
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 55:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 56:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ae.aF(e(t, j2));
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 58:
                    if (a(t, i6, i4)) {
                        hashCode = ae.bF(((Boolean) ch.k(t, j2)).booleanValue()) + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case bv.CTRL_INDEX /*{ENCODED_INT: 59}*/:
                    if (a(t, i6, i4)) {
                        hashCode = ((String) ch.k(t, j2)).hashCode() + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 60:
                    if (a(t, i6, i4)) {
                        hashCode = ch.k(t, j2).hashCode() + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ch.k(t, j2).hashCode();
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 62:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 63:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 64:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 65:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ae.aF(e(t, j2));
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 66:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + d(t, j2);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 67:
                    if (a(t, i6, i4)) {
                        hashCode = (i5 * 53) + ae.aF(e(t, j2));
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
                case 68:
                    if (a(t, i6, i4)) {
                        hashCode = ch.k(t, j2).hashCode() + (i5 * 53);
                        continue;
                        i4 += 3;
                        i5 = hashCode;
                    }
                    break;
            }
            hashCode = i5;
            i4 += 3;
            i5 = hashCode;
        }
        int hashCode2 = (i5 * 53) + this.bYB.aw(t).hashCode();
        if (this.bYs) {
            return (hashCode2 * 53) + this.bYC.an(t).hashCode();
        }
        return hashCode2;
    }

    @Override // com.google.a.br
    public final void n(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i2 = 0; i2 < this.bYo.length; i2 += 3) {
            int gJ = gJ(i2);
            long j2 = (long) (1048575 & gJ);
            int i3 = this.bYo[i2];
            switch ((gJ & 267386880) >>> 20) {
                case 0:
                    if (e((Object) t2, i2)) {
                        ch.a(t, j2, ch.j(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.i(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.g(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.g(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.g(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (e((Object) t2, i2)) {
                        ch.a(t, j2, ch.h(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (e((Object) t2, i2)) {
                        ch.a(t, j2, ch.k(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i2);
                    break;
                case 10:
                    if (e((Object) t2, i2)) {
                        ch.a(t, j2, ch.k(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.g(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.f(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (e((Object) t2, i2)) {
                        ch.a((Object) t, j2, ch.g(t2, j2));
                        f(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    a(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 49:
                    this.bYA.a(t, t2, j2);
                    break;
                case 50:
                    bt.a(this.bYD, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                case 58:
                case bv.CTRL_INDEX /*{ENCODED_INT: 59}*/:
                    if (a(t2, i3, i2)) {
                        ch.a(t, j2, ch.k(t2, j2));
                        b(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    b(t, t2, i2);
                    break;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (a(t2, i3, i2)) {
                        ch.a(t, j2, ch.k(t2, j2));
                        b(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i2);
                    break;
            }
        }
        if (!this.bYu) {
            bt.a(this.bYB, t, t2);
            if (this.bYs) {
                bt.a(this.bYC, t, t2);
            }
        }
    }

    private void a(T t, T t2, int i2) {
        long gJ = (long) (gJ(i2) & 1048575);
        if (e((Object) t2, i2)) {
            Object k = ch.k(t, gJ);
            Object k2 = ch.k(t2, gJ);
            if (k != null && k2 != null) {
                ch.a(t, gJ, ae.l(k, k2));
                f(t, i2);
            } else if (k2 != null) {
                ch.a(t, gJ, k2);
                f(t, i2);
            }
        }
    }

    private void b(T t, T t2, int i2) {
        int gJ = gJ(i2);
        int i3 = this.bYo[i2];
        long j2 = (long) (gJ & 1048575);
        if (a(t2, i3, i2)) {
            Object k = ch.k(t, j2);
            Object k2 = ch.k(t2, j2);
            if (k != null && k2 != null) {
                ch.a(t, j2, ae.l(k, k2));
                b(t, i3, i2);
            } else if (k2 != null) {
                ch.a(t, j2, k2);
                b(t, i3, i2);
            }
        }
    }

    @Override // com.google.a.br
    public final void ap(T t) {
        for (int i2 = this.bYx; i2 < this.bYy; i2++) {
            long gJ = (long) (gJ(this.bYw[i2]) & 1048575);
            Object k = ch.k(t, gJ);
            if (k != null) {
                ch.a(t, gJ, this.bYD.au(k));
            }
        }
        int length = this.bYw.length;
        for (int i3 = this.bYy; i3 < length; i3++) {
            this.bYA.a(t, (long) this.bYw[i3]);
        }
        this.bYB.ap(t);
        if (this.bYs) {
            this.bYC.ap(t);
        }
    }

    private int gJ(int i2) {
        return this.bYo[i2 + 1];
    }

    private int gK(int i2) {
        return this.bYo[i2 + 2];
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) ch.k(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) ch.k(t, j2)).longValue();
    }

    private boolean c(T t, T t2, int i2) {
        return e(t, i2) == e(t2, i2);
    }

    private boolean e(T t, int i2) {
        if (this.bYu) {
            int gJ = gJ(i2);
            long j2 = (long) (gJ & 1048575);
            switch ((gJ & 267386880) >>> 20) {
                case 0:
                    return ch.j(t, j2) != 0.0d;
                case 1:
                    return ch.i(t, j2) != 0.0f;
                case 2:
                    return ch.g(t, j2) != 0;
                case 3:
                    return ch.g(t, j2) != 0;
                case 4:
                    return ch.f(t, j2) != 0;
                case 5:
                    return ch.g(t, j2) != 0;
                case 6:
                    return ch.f(t, j2) != 0;
                case 7:
                    return ch.h(t, j2);
                case 8:
                    Object k = ch.k(t, j2);
                    if (k instanceof String) {
                        return !((String) k).isEmpty();
                    }
                    if (k instanceof g) {
                        return !g.bNg.equals(k);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return ch.k(t, j2) != null;
                case 10:
                    return !g.bNg.equals(ch.k(t, j2));
                case 11:
                    return ch.f(t, j2) != 0;
                case 12:
                    return ch.f(t, j2) != 0;
                case 13:
                    return ch.f(t, j2) != 0;
                case 14:
                    return ch.g(t, j2) != 0;
                case 15:
                    return ch.f(t, j2) != 0;
                case 16:
                    return ch.g(t, j2) != 0;
                case 17:
                    return ch.k(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int gK = gK(i2);
            return (ch.f(t, (long) (gK & 1048575)) & (1 << (gK >>> 20))) != 0;
        }
    }

    private void f(T t, int i2) {
        if (!this.bYu) {
            int gK = gK(i2);
            long j2 = (long) (gK & 1048575);
            ch.a((Object) t, j2, ch.f(t, j2) | (1 << (gK >>> 20)));
        }
    }

    private boolean a(T t, int i2, int i3) {
        return ch.f(t, (long) (gK(i3) & 1048575)) == i2;
    }

    private void b(T t, int i2, int i3) {
        ch.a((Object) t, (long) (gK(i3) & 1048575), i2);
    }
}
