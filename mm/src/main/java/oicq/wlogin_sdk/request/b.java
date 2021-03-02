package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] Ucf;
    public i UbW = new i();
    private j UbX = new j(this.UbW);
    private f UbY = new f(this.UbW);
    private g UbZ = new g(this.UbW);
    private h Uca = new h(this.UbW);
    private e Ucb = new e(this.UbW);
    public d Ucc = null;
    private int Ucd = 66560;
    private int Uce = 1404;
    private Context mContext = null;

    private static /* synthetic */ int[] hPw() {
        AppMethodBeat.i(88053);
        int[] iArr = Ucf;
        if (iArr != null) {
            AppMethodBeat.o(88053);
        } else {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            Ucf = iArr;
            AppMethodBeat.o(88053);
        }
        return iArr;
    }

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1;

        public static a valueOf(String str) {
            AppMethodBeat.i(88046);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(88046);
            return aVar;
        }

        static {
            AppMethodBeat.i(88044);
            AppMethodBeat.o(88044);
        }
    }

    public b(Context context, int i2) {
        AppMethodBeat.i(88047);
        this.mContext = context;
        i iVar = this.UbW;
        iVar._context = context;
        iVar.UcK = i2;
        iVar.Ude = new c(context);
        byte[] bArr = new byte[16];
        iVar.UcB.nextBytes(bArr);
        System.arraycopy(bArr, 0, iVar.UcE, 0, 16);
        hPv();
        AppMethodBeat.o(88047);
    }

    public final byte[] a(long j2, a aVar, String str) {
        byte[] bArr;
        boolean z;
        byte[] a2;
        AppMethodBeat.i(88048);
        util.buY("wtlogin login with GetStWithPasswd:user:" + j2 + " appid:522017402 dwSigMap:8256 ...");
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        synchronized (this) {
            try {
                switch (hPw()[aVar.ordinal()]) {
                    case 1:
                        if (str != null && str.length() != 0) {
                            bArr = c.buW(str);
                            z = false;
                            break;
                        } else {
                            util.buY("USER_WITH_PWD userPasswd null");
                            AppMethodBeat.o(88048);
                            return null;
                        }
                        break;
                    case 2:
                        if (str == null || str.length() == 0) {
                            util.buY("USER_WITH_MD5 userPasswd null");
                            AppMethodBeat.o(88048);
                            return null;
                        }
                        try {
                            z = false;
                            bArr = (byte[]) str.getBytes(KindaConfigCacheStg.SAVE_CHARSET).clone();
                            break;
                        } catch (Exception e2) {
                            AppMethodBeat.o(88048);
                            return null;
                        }
                        break;
                    case 3:
                        WloginSigInfo Pu = this.UbW.Pu(j2);
                        if (Pu == null || Pu._en_A1 == null || Pu._en_A1.length <= 0) {
                            util.buY("userAccount:" + j2 + " appid:522017402 GetA1ByAccount return: null");
                            bArr = null;
                        } else {
                            util.buY("userAccount:" + j2 + " appid:522017402 GetA1ByAccount return: not null");
                            bArr = (byte[]) Pu._en_A1.clone();
                        }
                        if (bArr != null && bArr.length >= 16) {
                            z = true;
                            break;
                        } else {
                            util.buY("USER_WITH_A1 tmp_pwd null");
                            AppMethodBeat.o(88048);
                            return null;
                        }
                        break;
                    default:
                        return null;
                }
                this.UbW.UcO = util.lU(this.mContext);
                this.UbW.UcQ = util.lX(this.mContext).getBytes();
                this.UbW._uin = j2;
                this.UbW.UcH = 522017402;
                this.UbW.UcI = 8256;
                this.UbW.UcF = new f();
                this.Ucc = this.UbX;
                if (z) {
                    a2 = this.UbX.a(j2, this.UbW.Udc, bArr, this.Uce, this.Ucd, this.UbW.UcZ);
                } else {
                    byte[] bArr2 = new byte[4];
                    util.d(bArr2, 0, i.hPz());
                    a2 = this.UbX.a(j2, this.UbW.Udc, bArr2, bArr, this.Uce, this.Ucd, this.UbW.UcZ);
                }
                util.buY("wtlogin login with GetStWithPasswd:user:" + j2 + " appid:522017402 dwSigMap:8256 end");
                AppMethodBeat.o(88048);
                return a2;
            } finally {
                AppMethodBeat.o(88048);
            }
        }
    }

    public final byte[] f(long j2, byte[] bArr) {
        byte[] dn;
        AppMethodBeat.i(88049);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(88049);
            return null;
        }
        util.buY("user:" + j2 + " CheckPicture ...");
        synchronized (this) {
            try {
                this.Ucc = this.UbZ;
                dn = this.UbZ.dn(bArr);
            } catch (Throwable th) {
                AppMethodBeat.o(88049);
                throw th;
            }
        }
        util.buY("user:" + j2 + " CheckPicture end");
        AppMethodBeat.o(88049);
        return dn;
    }

    public final byte[] Pr(long j2) {
        byte[] bArr;
        AppMethodBeat.i(88050);
        synchronized (this) {
            try {
                g gVar = this.UbW.UcG;
                bArr = new byte[gVar.Udr];
                if (gVar.Udr > 0) {
                    System.arraycopy(gVar.Ucr, gVar.Udt, bArr, 0, gVar.Udr);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(88050);
                throw th;
            }
        }
        util.buY("user:" + j2 + " GetPicture data len:" + bArr.length);
        AppMethodBeat.o(88050);
        return bArr;
    }

    public final void Ps(long j2) {
        AppMethodBeat.i(88051);
        util.buY("user:" + j2 + " ClearUserSigInfo");
        this.UbW.q(Long.valueOf(j2));
        AppMethodBeat.o(88051);
    }

    private int hPv() {
        boolean z;
        int i2;
        AppMethodBeat.i(88052);
        synchronized (this) {
            try {
                byte[] lZ = util.lZ(this.mContext);
                if (lZ == null || lZ.length <= 0) {
                    lZ = util.lS(this.mContext);
                    if (lZ == null || lZ.length <= 0) {
                        lZ = new String("%4;7t>;28<fc.5*6").getBytes();
                        this.UbW.UcX = 0;
                    } else {
                        this.UbW.UcX = 1;
                    }
                    util.b(this.mContext, lZ);
                    this.UbW.UcW = 1;
                    this.UbW.UcY = 1;
                } else {
                    this.UbW.UcX = 1;
                    this.UbW.UcW = 0;
                    this.UbW.UcY = 0;
                }
                this.UbW.UcL = new byte[lZ.length];
                System.arraycopy(lZ, 0, this.UbW.UcL, 0, lZ.length);
                byte[] bArr = new byte[(lZ.length + 1)];
                bArr[0] = 35;
                System.arraycopy(lZ, 0, bArr, 1, lZ.length);
                this.UbW.UcC = util.dv(bArr);
                i.UcM = (byte[]) this.UbW.UcL.clone();
                this.UbW.UcN = util.lT(this.mContext);
                int lV = util.lV(this.mContext);
                this.UbW.UcO = util.lU(this.mContext);
                if (lV != this.UbW.UcO) {
                    util.lW(this.mContext);
                    util.aY(this.mContext, this.UbW.UcO);
                }
                this.UbW.UcQ = util.lX(this.mContext).getBytes();
                this.UbW.UcZ = util.lY(this.mContext);
                this.UbW.UcP = util.ma(this.mContext);
                this.UbW.UcS = util.df(this.mContext, new String(this.UbW.UcP));
                this.UbW.UcT = util.dg(this.mContext, new String(this.UbW.UcP));
                String str = Build.MODEL;
                if (str == null) {
                    this.UbW.UcU = new byte[0];
                } else {
                    this.UbW.UcU = str.getBytes();
                }
                if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                    z = true;
                } else {
                    z = false;
                }
                i iVar = this.UbW;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iVar.UcV = i2;
                String str2 = Build.VERSION.RELEASE;
                if (str2 == null) {
                    str2 = "";
                }
                util.buY("WtloginHelper init ok: android version:" + str2 + " release time:" + util.hPM());
            } finally {
                AppMethodBeat.o(88052);
            }
        }
        return 0;
    }
}
